package com.example.quickhiretest.ui.addData

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.quickhiretest.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var imageURL=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)


//        val bundle = this.arguments
//        if (bundle != null) {
//            val i = bundle.getInt(key, defaulValue)
//        }

        val bundle = arguments
        if (bundle != null) {
            binding.detailDesc.text = bundle.getString("Description")
            binding.detailTitle.text = bundle.getString("Title")
            binding.detailPriority.text = bundle.getString("Priority")
            imageURL = bundle.getString("Image")!!
            Glide.with(this).load(bundle.getString("Image"))
                .into(binding.detailImage)
        }


//        val bundle = intent.extras
//        if (bundle != null) {
//            binding.detailDesc.text = bundle.getString("Description")
//            binding.detailTitle.text = bundle.getString("Title")
//            binding.detailPriority.text = bundle.getString("Priority")
//            imageURL = bundle.getString("Image")!!
//            Glide.with(this).load(bundle.getString("Image"))
//                .into(binding.detailImage)
//        }


        return binding.root
    }

}