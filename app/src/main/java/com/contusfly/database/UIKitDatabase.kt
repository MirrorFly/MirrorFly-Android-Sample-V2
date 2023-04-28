package com.contusfly.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.contusfly.database.dao.ContactDao
import com.contusfly.database.model.ContactModel
import com.contusfly.utils.AppConstants

@Database(entities = [ContactModel::class], version = 1, exportSchema = false)
abstract class UIKitDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {

        /**
         * This is just for singleton pattern
         */
        private var INSTANCE: UIKitDatabase? = null

        fun initDatabase(context: Context): UIKitDatabase {
            if (INSTANCE == null) {
                synchronized(UIKitDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Get PhraseRoomDatabase database instance
                        INSTANCE = Room.databaseBuilder(context.applicationContext, UIKitDatabase::class.java, AppConstants.DB_NAME)
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }

        fun getInstance(): UIKitDatabase {
            return INSTANCE!!
        }
    }

}