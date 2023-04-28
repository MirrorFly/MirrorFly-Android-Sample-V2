package com.contusfly.database.dao

import androidx.room.*
import com.contusfly.database.model.ContactModel

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(vararg contactModel: ContactModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContacts(users: List<ContactModel>)

    @Query("SELECT * FROM ContactModel WHERE isBlockedMe")
    fun getBlockedMeContacts(): List<ContactModel>?

    @Query("SELECT * FROM ContactModel WHERE jid LIKE (:jid)")
    fun getContact(jid: String): ContactModel?

    @Query("delete from ContactModel ")
    fun deleteAllContacts()
}