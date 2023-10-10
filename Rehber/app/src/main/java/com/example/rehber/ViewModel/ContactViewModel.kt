package com.example.rehber.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.rehber.Contact
import com.example.rehber.Service.ContactDatabase
import com.example.rehber.Service.ContactRepo
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    val repoSitory : ContactRepo
    val readAllData : LiveData<List<Contact>>


    init{
        val contDao = ContactDatabase.getDatabase(application).contactDao()
        repoSitory= ContactRepo(contDao)
        readAllData = contDao.getAllContact()
    }



    fun addContact(contact: Contact){
        viewModelScope.launch {
            repoSitory.addContact(contact)
        }
    }
    fun updateCon(contact: Contact){
viewModelScope.launch {
    repoSitory.update(contact)
}
    }
    fun deleteContact(contactId: Int){
        viewModelScope.launch {
            repoSitory.deleteContact(contactId)
        }
    }



}