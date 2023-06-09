package com.example.quickhiretest.ui.Inbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.quickhiretest.R
import com.example.quickhiretest.databinding.FragmentEditProfileBinding
import com.example.quickhiretest.databinding.FragmentInboxBinding
import com.example.quickhiretest.databinding.FragmentInboxDetailBinding


class InboxDetailFragment : Fragment() {
    private var _binding: FragmentInboxDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(InboxViewModel::class.java)

        _binding = FragmentInboxDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}