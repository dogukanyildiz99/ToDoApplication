package com.example.todoapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.entity.ToDo
import com.example.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var toDosRepository : ToDoRepository) : ViewModel() {
    var toDosList = MutableLiveData<List<ToDo>>()

    init {
        loadToDos()
    }

    fun delete(id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.delete(id)
            loadToDos()
        }
    }

    fun loadToDos(){
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepository.loadToDos()//Tetikleme veya veri aktaramı
        }
    }

    fun search(searchText: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepository.search(searchText)//Tetikleme veya veri aktaramı
        }
    }
}