package com.example.beberagua

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beberagua.adapter.UserAdapter
import com.example.beberagua.databinding.FragmentResumoBinding
import com.example.beberagua.mvvm.MainViewModel

class ResumoFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentResumoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResumoBinding.inflate(
            layoutInflater, container, false)

        mainViewModel = MainViewModel(context)

        val adapter = UserAdapter()

        mainViewModel.lerTodosOsDados.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }


        binding.recyclerUser.layoutManager = LinearLayoutManager(context)
        binding.recyclerUser.adapter = adapter
        binding.recyclerUser.setHasFixedSize(true)


        return binding.root

    }

}