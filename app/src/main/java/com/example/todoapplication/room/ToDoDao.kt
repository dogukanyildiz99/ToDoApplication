package com.example.todoapplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapplication.data.entity.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDo")
    suspend fun loadToDos() : List<ToDo>

    @Insert
    suspend fun save(toDo: ToDo)

    @Query("UPDATE toDo SET name = :name WHERE id = :id")
    suspend fun update(id: Int, name: String)

    @Delete
    suspend fun delete(toDo: ToDo)

    @Query("SELECT * FROM toDo WHERE name LIKE '%' ||:searchText|| '%' ")
    suspend fun search(searchText: String) : List<ToDo>
}