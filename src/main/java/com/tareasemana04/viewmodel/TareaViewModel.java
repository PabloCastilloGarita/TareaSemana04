package com.tareasemana04.viewmodel;

import android.app.Application
import androidx.lifecycle.*
import com.tareasemana04.data.TareaDatabase
import com.tareasemana04.model.Tarea
import com.tareasemana04.repository.TareaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TareaViewModel(application: Application)
    : AndroidViewModel(application) {

            val getAllData : LiveData<List<Tarea>>
private val repository: TareaRepository

        init {
        val tareaDao = TareaDatabase.getDatabase(application).tareaDao()
        repository = TareaRepository(lugarDao)
        getAllData = repository.getAllData
        }

        fun addTarea(tarea: Tarea) {
        viewModelScope.launch (Dispatchers.IO) {repository.addTarea(tarea)}
        }

        fun updateTarea(tarea: Tarea) {
        viewModelScope.launch (Dispatchers.IO) {repository.updateTarea(tarea)}
        }

        fun deleteTarea(tarea: Tarea) {
        viewModelScope.launch (Dispatchers.IO) {repository.deleteTarea(tarea)}
        }
        }
