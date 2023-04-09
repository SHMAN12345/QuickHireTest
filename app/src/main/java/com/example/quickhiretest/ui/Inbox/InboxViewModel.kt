package com.example.quickhiretest.ui.Inbox

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InboxViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        //value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}