package com.tareasemana04.ui.tareasemana04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tareasemana04.databinding.FragmentHomeBinding
import com.tareasemana04.databinding.FragmentTareasemana04Binding

class tareasemana04Fragment : Fragment() {
    private lateinit var tareasemana04ViewModel: tareasemana04ViewModel
    private var _binding: FragmentTareasemana04Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tareasemana04ViewModel =
            ViewModelProvider(this).get(tareasemana04ViewModel::class.java)

        _binding = FragmentTareasemana04Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        tareasemana04ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}