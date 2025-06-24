package com.example.todoapplication.data.repo

import com.example.todoapplication.data.datasource.ToDoApplicationDataSource
import com.example.todoapplication.data.entity.ToDo

class ToDoRepository(var toDoDataSource : ToDoApplicationDataSource) {

    suspend fun save(name:String) = toDoDataSource.save(name)

    suspend fun update(id:Int,name: String) = toDoDataSource.update(id,name)

    suspend fun delete(id:Int) = toDoDataSource.delete(id)

    suspend fun loadToDos() : List<ToDo> = toDoDataSource.loadToDos()

    suspend fun search(searchText: String): List<ToDo> = toDoDataSource.search(searchText)
}