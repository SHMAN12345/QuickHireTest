package com.example.quickhiretest.ui.Insurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickhiretest.R
import com.example.quickhiretest.databinding.FragmentInsuranceBinding

class InsuranceFragment : Fragment() {
    private var _binding: FragmentInsuranceBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentInsuranceBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCalculate.setOnClickListener{
            var basic:Int=0
            var extra=0
            var total=0

            //Get age group
            val age=binding.spinnerAge.selectedItemPosition

            //Get the gender
            val gender=binding.radioGroupGender.checkedRadioButtonId


            //Get the smoker status
            val smoker=binding.checkBoxSmoker.isChecked

            if(age==0)//less than 17
            {
                basic=60

            }
            else if(age==1)
            {
                basic=70
                if (gender==binding.radioButtonMale.id)
                {
                    //Calculate the extra premium for male
                    extra+=50

                }

                if(smoker)
                {
                    //Calculate the extra premium for a smoker
                    extra+=100
                }


            }
            else if(age==2)
            {
                basic=90
                if (gender==binding.radioButtonMale.id)
                {
                    //Calculate the extra premium for male
                    extra+=100

                }

                if(smoker)
                {
                    //Calculate the extra premium for a smoker
                    extra+=150
                }
            }

            else if(age==3)
            {
                basic=120
                if (gender==binding.radioButtonMale.id)
                {
                    //Calculate the extra premium for male
                    extra+=150

                }

                if(smoker)
                {
                    //Calculate the extra premium for a smoker
                    extra+=200
                }
            }

            else if(age==4)
            {
                basic=150
                if (gender==binding.radioButtonMale.id)
                {
                    //Calculate the extra premium for male
                    extra+=200

                }

                if(smoker)
                {
                    //Calculate the extra premium for a smoker
                    extra+=250
                }
            }

            else if(age==5)
            {
                basic=150
                if (gender==binding.radioButtonMale.id)
                {
                    //Calculate the extra premium for male
                    extra+=200

                }

                if(smoker)
                {
                    //Calculate the extra premium for a smoker
                    extra+=300
                }
            }

            total=basic+extra
            //binding.myPremium=Premium(basic,extra,total)
        }

        binding.buttonReset.setOnClickListener{
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.toggle()
            //binding.myPremium=Premium()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }



}