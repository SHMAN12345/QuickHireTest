package com.example.quickhiretest.ui.addData


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickhiretest.R
import com.example.quickhiretest.databinding.FragmentAddDataBinding
import com.example.quickhiretest.databinding.FragmentInboxDetailBinding
import com.example.quickhiretest.ui.Inbox.InboxViewModel
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList

class AddDataFragment : Fragment() {

    private var _binding: FragmentAddDataBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var dataList:ArrayList<DataClass>
    private lateinit var adapter: MyAdapter
    var databaseReference:DatabaseReference?=null
    var eventListener:ValueEventListener?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddDataBinding.inflate(inflater, container, false)

        val gridLayoutManager=GridLayoutManager(requireContext(),1)
        binding.recycleViewData.layoutManager=gridLayoutManager


        val builder = AlertDialog.Builder(requireContext())
        builder.setCancelable(false)
        builder.setView(R.layout.progress_layout)
        val dialog = builder.create()
        dialog.show()

        dataList = ArrayList()
        adapter = MyAdapter(requireContext(), dataList)
        binding.recycleViewData.adapter = adapter
        databaseReference = FirebaseDatabase.getInstance().getReference("Todo List")
        dialog.show()

        eventListener = databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (itemSnapshot in snapshot.children) {
                    val dataClass = itemSnapshot.getValue(DataClass::class.java)
                    if (dataClass != null) {
                        dataList.add(dataClass)
                    }
                }
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            override fun onCancelled(error: DatabaseError) {
                dialog.dismiss()
            }
        })


        binding.fab.setOnClickListener{
//            val intent= Intent(activity,UploadFragment::class.java)
//            startActivity(intent)

            activity?.let{
                val intent = Intent (it, UploadFragment::class.java)
                it.startActivity(intent)
            }

//            val fragment = UploadFragment() // replace NewFragment with the name of your new fragment class
//            val transaction = requireActivity().supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.nav_uploadData, fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()

        }

        binding.search.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                searchList(newText)
                return true
            }
        })

        return binding.root
    }

    fun searchList(text: String) {
        val searchList = java.util.ArrayList<DataClass>()
        for (dataClass in dataList) {
            if (dataClass.dataTitle?.lowercase()
                    ?.contains(text.lowercase(Locale.getDefault())) == true
            ) {
                searchList.add(dataClass)
            }
        }
        adapter.searchDataList(searchList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}