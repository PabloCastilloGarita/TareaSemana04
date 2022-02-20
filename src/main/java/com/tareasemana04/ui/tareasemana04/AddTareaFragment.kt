package com.tareasemana04.ui.tareasemana04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tareasemana04.R
import com.tareasemana04.databinding.AddTareaFragmentBinding
import com.tareasemana04.model.Tarea
import com.tareasemana04.viewmodel.TareaViewModel

class AddTareaFragment {
    private lateinit var lugarViewModel: TareaViewModel
    private var _binding: AddTareaFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel = ViewModelProvider(this).get(TareaViewModel::class.java)

        _binding = AddTareaFragmentBinding.inflate(inflater, container, false)

        binding.btAddTarea.setOnClickListener() {
            agregarTarea()
        }

        return binding.root
    }

    private fun agregarTarea() {
        val nombre = binding.etNombre.text.toString()
        if (nombre.isNotEmpty()) {
            val apellido = binding.etApellido.text.toString()
            val  correo = binding.etCorreo.text.toString()
            val numeroHabitacion = binding.etNumeroHabitacion.text.toString()
            val tarea = Tarea(0, nombre,apellido, correo, numeroHabitacion)
            lugarViewModel.addTarea(tarea)
            Toast.makeText(requireContext(),
                getString(R.string.msg_tarea_add),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_addTaraeFragment_to_nav_tarea)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}