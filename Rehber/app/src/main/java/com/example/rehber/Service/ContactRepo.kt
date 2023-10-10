package com.example.rehber.Service

import androidx.lifecycle.LiveData
import com.example.rehber.Contact

class ContactRepo(val contactDao : ContactDao) {


    suspend fun addContact(contact: Contact){
        contactDao.addCon(contact)
    }
    suspend fun deleteContact(id : Int){
        contactDao.deleteContactById(id)
    }
    suspend fun update(contact: Contact){
        contactDao.updateCon(contact)
    }
}