package com.tareasemana04.repository;

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.tareasemana04.data.TareaDao
import com.tareasemana04.model.Tarea

class TareaRepository(private val lugarDao: TareaDao) {
    val getAllData : LiveData<List<Tarea>> = tareaDao.getAllData()

    suspend fun addHuesped(tarea: Tarea) {
        lugarDao.addHuesped(tarea)
    }

    suspend fun updateHuesped(tarea: Tarea) {
        lugarDao.updateHuesped(tarea)
    }

    suspend fun deleteHuesped(tarea: Tarea) {
        lugarDao.deleteHuesped(tarea)
    }
}
