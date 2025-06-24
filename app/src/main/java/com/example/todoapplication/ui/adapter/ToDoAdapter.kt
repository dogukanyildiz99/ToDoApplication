package com.example.todoapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.data.entity.ToDo
import com.example.todoapplication.databinding.CardDesignBinding
import com.example.todoapplication.ui.screens.MainScreenDirections
import com.example.todoapplication.ui.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext: Context,
                   var toDosList: List<ToDo>,
                   var viewModel: MainViewModel
)
    : RecyclerView.Adapter<ToDoAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {//0,1,2
        val toDo = toDosList.get(position)
        val design = holder.binding

        design.textViewName.text = toDo.name

        design.cardViewToDo.setOnClickListener {
            val toUptadeScreen = MainScreenDirections.toUpdateScreen(toDo = toDo)
            it.findNavController().navigate(toUptadeScreen)
        }

        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Do you want to delete ${toDo.name} ?", Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                    viewModel.delete(toDo.id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return toDosList.size
    }
}