package com.tareasemana04.model;

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tarea")
data class Tarea(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        @ColumnInfo(name = "nombre")
        val nombre: String,
        @ColumnInfo(name = "apellido")
        val apellido: String?,
        @ColumnInfo(name = "correo")
        val correo: String?,
        @ColumnInfo(name = "numero_cuarto")
        val numero_cuarto: String?,
        ) : Parcelable