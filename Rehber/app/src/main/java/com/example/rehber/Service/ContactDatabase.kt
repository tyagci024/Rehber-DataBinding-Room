package com.example.rehber.Service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rehber.Contact

@Database(entities = [Contact::class],version = 1,exportSchema = false)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao():ContactDao

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            var tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this)
            {
                val instance =
                    Room.databaseBuilder(context, ContactDatabase::class.java, "contacts").build()
                tempInstance = instance
                return instance
            }
        }

    }
}