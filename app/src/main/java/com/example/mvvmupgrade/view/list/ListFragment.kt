package com.example.mvvmupgrade.view.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmupgrade.R
import com.example.mvvmupgrade.model.NumberTrivia
import com.example.mvvmupgrade.viewmodel.NumberTriviaViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlin.collections.List


class ListFragment : Fragment(), View.OnClickListener{
    private lateinit var numberTriviaViewModel: NumberTriviaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView = view.recyclerview


        numberTriviaViewModel = ViewModelProvider(this).get(NumberTriviaViewModel::class.java)
        numberTriviaViewModel.setDatabaseRepository(requireContext())

        val adapter = ListAdapter(numberTriviaViewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        numberTriviaViewModel.listOfTrivia.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })



        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.add2)
        }
        return view
    }

    override fun onClick(view: View?) {

    }


}