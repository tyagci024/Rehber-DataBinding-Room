package com.example.rehber.Service

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rehber.Contact

@Dao

interface ContactDao {


    @Insert
    suspend fun addCon(contact : Contact)

    @Delete
    suspend fun deleteCon(contact : Contact)

    @Update
    suspend fun updateCon(contact : Contact)


    @Query("SELECT * from contact_table order by id ASC")
    fun getAllContact(): LiveData<List<Contact>>


    @Query("DELETE FROM contact_table WHERE id = :contactId")
    suspend fun deleteContactById(contactId: Int)

    @Query("DELETE FROM contact_table")
    suspend fun deleteAll()






}