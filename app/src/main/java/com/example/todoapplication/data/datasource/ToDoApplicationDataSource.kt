package com.example.todoapplication.data.datasource

import com.example.todoapplication.data.entity.ToDo
import com.example.todoapplication.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoApplicationDataSource(var toDosDao: ToDoDao) {
    suspend fun save(name:String){
        val newToDo = ToDo(0,name)
        toDosDao.save(newToDo)
    }

    suspend fun update(id:Int,name: String){
        val updatedToDo = ToDo(id,name)
        toDosDao.update(id, name)
    }

    suspend fun delete(id:Int){
        val deletedToDo = ToDo(id,"")
        toDosDao.delete(deletedToDo)
    }

    suspend fun loadToDos() : List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext toDosDao.loadToDos()
    }

    suspend fun search(searchText: String): List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext toDosDao.search(searchText)
    }
}