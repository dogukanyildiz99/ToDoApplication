package com.example.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.example.todoapplication.data.datasource.ToDoApplicationDataSource
import com.example.todoapplication.data.repo.ToDoRepository
import com.example.todoapplication.room.MyDatabase
import com.example.todoapplication.room.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDosRepository(toDosDataSource: ToDoApplicationDataSource) : ToDoRepository {
        return ToDoRepository(toDosDataSource)
    }

    @Provides
    @Singleton
    fun provideToDosDataSource(toDosDao: ToDoDao) : ToDoApplicationDataSource {
        return ToDoApplicationDataSource(toDosDao)
    }

    @Provides
    @Singleton
    fun provideToDosDao(@ApplicationContext context: Context) : ToDoDao {
        val db = Room.databaseBuilder(context, MyDatabase::class.java, "todo_app.sqlite")
            .createFromAsset("todo_app.sqlite")
            .build()
        return db.getToDoDao()
    }
}