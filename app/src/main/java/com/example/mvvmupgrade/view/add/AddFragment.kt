package com.example.mvvmupgrade.view.add

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.mvvmupgrade.R
import com.example.mvvmupgrade.model.NumberTrivia
import com.example.mvvmupgrade.viewmodel.NumberTriviaViewModel
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {
    private lateinit var numberTriviaViewModel: NumberTriviaViewModel
    lateinit var currentNumberTrivia: NumberTrivia

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        numberTriviaViewModel = ViewModelProvider(this).get(NumberTriviaViewModel::class.java)
        numberTriviaViewModel.setDatabaseRepository(requireContext())
        view.buttonStoreTrivia.setOnClickListener {
            numberTriviaViewModel.insertTrivia(currentNumberTrivia)
        }

        view.buttonRandomTrivia.setOnClickListener {
            numberTriviaViewModel.getRandomTrivia()?.observe(viewLifecycleOwner, Observer {
                val data = it.text
                val obj = it
                currentNumberTrivia = obj
                view.textViewTrivia.text = data
            })
        }

        view.editTextNumber.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                numberTriviaViewModel.getTrivia(p0.toString()+"?json")!!.observe(viewLifecycleOwner,
                    Observer {
                        val data = it.text
                        view.textViewTrivia.text = data
                        val obj = it
                        currentNumberTrivia = obj
                    })
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })
        return view
    }

}