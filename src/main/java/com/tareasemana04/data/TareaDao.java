package com.tareasemana04.data;

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lugares.model.Lugar

@Dao
interface TareaDao {
    //funcion para obtener la lista de lugares
    @Query("select * from Tarea")
    fun getAllData() : LiveData<List<Tarea>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHuesped(lugar: Lugar)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateHuesped(lugar: Lugar)

    @Delete
    suspend fun deleteHuesped(lugar: Lugar)
}