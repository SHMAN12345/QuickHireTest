package com.example.quickhiretest.ui.BMI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.quickhiretest.R
import com.example.quickhiretest.databinding.FragmentBmiBinding
import kotlin.math.pow

class BmiFragment : Fragment() {

    private var _binding:FragmentBmiBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentBmiBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Linking UI to code
        val imageViewBMI =binding.imageViewBMI

        val textViewBMI=binding.textViewBMI
        val textViewStatus=binding.textViewStatus

        val editTextWeight=binding.editTextWeight
        val editTextHeight=binding.editTextHeight

        val buttonCalculate=binding.buttonCalculate
        val buttonReset=binding.buttonReset

        buttonCalculate.setOnClickListener {
            if(editTextWeight.text.isEmpty())
            {
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener //terminate the program

            }

            if(editTextHeight.text.isEmpty())
            {
                editTextHeight.setError(getString(R.string.value_required))
                return@setOnClickListener //terminate the program

            }

            var weight = editTextWeight.text.toString().toFloat()
            var height = editTextHeight.text.toString().toFloat()

            var bmi = weight/(height/100).pow(2)

            if(bmi<18.5) //Underweight
            {
                imageViewBMI.setImageResource(R.drawable.under)
                //Body Mass Index : 18.24
                textViewBMI.text=String.format("%s : %.2f",getString(R.string.bmi),bmi)
                textViewStatus.text=String.format("%s : %s",getString(R.string.status),getString(R.string.under))
            }

            else if(bmi>=18.5 && bmi<25) //Underweight
            {
                imageViewBMI.setImageResource(R.drawable.normal)
                //Body Mass Index : 18.24
                textViewBMI.text=String.format("%s : %.2f",getString(R.string.bmi),bmi)
                textViewStatus.text=String.format("%s : %s",getString(R.string.status),getString(R.string.normal))
            }

            else if(bmi>=25) //Underweight
            {
                imageViewBMI.setImageResource(R.drawable.over)
                //Body Mass Index : 18.24
                textViewBMI.text=String.format("%s : %.2f",getString(R.string.bmi),bmi)
                textViewStatus.text=String.format("%s : %s",getString(R.string.status),getString(R.string.over))
            }

        }




        binding.buttonReset.setOnClickListener {
            binding.editTextHeight.text.clear()
            binding.editTextHeight.text.clear()
            binding.imageViewBMI.setImageResource(R.drawable.empty)
            binding. textViewBMI.text=String.format("%s",getString(R.string.bmi))
            binding.textViewStatus.text=String.format("%s",getString(R.string.status))
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}