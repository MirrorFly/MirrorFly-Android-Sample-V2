package com.contusfly.database.dao


import androidx.room.*
import com.contusfly.database.model.ContusContact

@Dao
interface ContusContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContusContact(vararg contusContact: ContusContact)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContusContactAsSingle(vararg contusContact: ContusContact)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContusContacts(users: List<ContusContact>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: ContusContact)

    @Query("DELETE FROM ContusContact WHERE jid = :jid")
    suspend fun deleteContusContact(jid: String)

    @Query("DELETE FROM ContusContact WHERE jid IN (:jidList)")
    suspend fun deleteContusContacts(jidList: List<String>)

    @Query("DELETE FROM ContusContact")
    fun deleteAllContusContacts()

    @Query("SELECT * FROM ContusContact WHERE jid LIKE (:jid)")
    fun getContusContact(jid: String): ContusContact?

    @Query("SELECT * FROM ContusContact")
    suspend fun getAllContusContact(): List<ContusContact>

    @Query("SELECT * FROM ContusContact WHERE isBlocked = 1")
    fun getBlockedContusContactS(): List<ContusContact>

    @Query("SELECT * FROM ContusContact WHERE isBlockedMe = 1")
    fun getBlockedMeContusContactS(): List<ContusContact>

    @Query("SELECT * FROM ContusContact WHERE isAdminBlocked = 1")
    fun getAdminBlockedContusContactS(): List<ContusContact>

    @Update
    suspend fun updateContusContact(contusContact: ContusContact)

    @Update
    suspend fun updateContusContacts(list: List<ContusContact>)

    @Query("SELECT count(*) FROM ContusContact WHERE jid LIKE (:jid)")
    fun isContusContact(jid: String): Int
}
