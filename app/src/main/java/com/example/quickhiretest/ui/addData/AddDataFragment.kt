package com.example.quickhiretest.ui.addData


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.quickhiretest.R
import com.example.quickhiretest.databinding.FragmentAddDataBinding
import com.example.quickhiretest.databinding.FragmentInboxDetailBinding
import com.example.quickhiretest.ui.Inbox.InboxViewModel

class AddDataFragment : Fragment() {

    private var _binding: FragmentAddDataBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddDataBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener{
            val intent= Intent(activity,UploadFragment::class.java)
            startActivity(intent)

//            activity?.let{
//                val intent = Intent (it, UploadFragment::class.java)
//                it.startActivity(intent)
//            }

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}