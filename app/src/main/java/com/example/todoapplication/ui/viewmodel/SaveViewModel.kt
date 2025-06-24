package com.example.todoapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveViewModel @Inject constructor(var toDosRepository : ToDoRepository) : ViewModel() {

    fun save(name: String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.save(name)
        }
    }
}