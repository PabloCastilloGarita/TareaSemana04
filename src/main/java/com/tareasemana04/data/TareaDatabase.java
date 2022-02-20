package com.tareasemana04.data;

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tareasemana04.model.*

import kotlin.jvm.Volatile;

@Database(entities = [Tarea::class], version = 1, exportSchema = false)
abstract class TareaDatabase : RoomDatabase() {
abstract fun tareaDao() : TareaDao

        companion object {
@Volatile
private var INSTANCE: TareaDatabase? = null

        fun getDatabase(context: android.content.Context) : TareaDatabase {
        var instance = INSTANCE
        if(instance != null) {
        return instance
        }
synchronized(this) {
        //se crea el esquema de la base de datos
        val basedatos = Room.databaseBuilder(
        context.applicationContext,
        TareaDatabase::class.java,
        "tarea_database"
        ).build()
        INSTANCE = basedatos
        return basedatos
        }
        }
    }
}