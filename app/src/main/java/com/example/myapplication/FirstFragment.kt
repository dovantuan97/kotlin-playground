package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private fun increment(view : View){
        val counterEl = view.findViewById<TextView>(R.id.textview_first)
        var counter = counterEl.text.toString().toInt()
        counter++
        counterEl.text = counter.toString()
    }

    private fun decrement(view : View){
        val counterEl = view.findViewById<TextView>(R.id.textview_first)
        var counter = counterEl.text.toString().toInt()
        counter--
        counterEl.text = counter.toString()
    }

    private fun handleInput(view: View): String {
        return view.findViewById<TextView>(R.id.input).text.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rng.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.pop.setOnClickListener {
            Toast.makeText(context, handleInput(view), Toast.LENGTH_SHORT).show()
        }

        binding.increment.setOnClickListener {
            increment(view)
        }

        binding.decrement.setOnClickListener {
            decrement(view)
        }

        binding.submit.setOnClickListener {
            Toast.makeText(context, handleInput(view), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}