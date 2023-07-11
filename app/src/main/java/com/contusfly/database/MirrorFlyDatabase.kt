package com.contusfly.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.contusfly.database.dao.ContusContactDao
import com.contusfly.database.model.ContusContact
import com.contusfly.utils.AppConstants

@Database(entities = [ContusContact::class], version = 2, exportSchema = false)
abstract class MirrorFlyDatabase : RoomDatabase()  {

    abstract fun contusContactDao(): ContusContactDao

    companion object {

        /**
         * This is just for singleton pattern
         */
        private var INSTANCE: MirrorFlyDatabase? = null

        fun initDatabase(context: Context): MirrorFlyDatabase {
            if (INSTANCE == null) {
                synchronized(MirrorFlyDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Get PhraseRoomDatabase database instance
                        INSTANCE = Room.databaseBuilder(context.applicationContext, MirrorFlyDatabase::class.java, AppConstants.DB_NAME_MIRROR_FLY)
                            .allowMainThreadQueries()
                            .addMigrations(MIGRATION_1_2)
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }

        fun getInstance(): MirrorFlyDatabase {
            return INSTANCE!!
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE ContusContact ADD COLUMN isAdminBlocked INTEGER DEFAULT NULL")
            }
        }
    }
}