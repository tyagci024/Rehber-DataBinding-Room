package com.example.rehber

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "contact_table")


data class Contact (    @PrimaryKey(autoGenerate = true)
                        val id: Int, val name : String , val number: String) : Serializable