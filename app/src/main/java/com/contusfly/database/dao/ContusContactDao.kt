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

    @Query("delete from ContusContact where jid in (:jidList)")
    suspend fun deleteContusContacts(jidList: List<String>)

    @Query("delete from ContusContact ")
    fun deleteAllContusContacts()

    @Query("SELECT * FROM ContusContact WHERE jid LIKE (:jid)")
    fun getContusContact(jid: String): ContusContact?

    @Query("SELECT * FROM ContusContact")
    suspend fun getAllContusContact(): List<ContusContact>?

    @Query("SELECT * FROM ContusContact WHERE isBlocked")
    fun getBlockedContusContactS(): List<ContusContact>?

    @Query("SELECT * FROM ContusContact WHERE isBlockedMe")
    fun getBlockedMeContusContactS(): List<ContusContact>?

    @Query("SELECT * FROM ContusContact WHERE isAdminBlocked")
    fun getAdminBlockedContusContactS(): List<ContusContact>?

    @Update
    suspend fun updateContusContact(contusContact: ContusContact)

    @Update
    suspend fun updateContusContacts(list: List<ContusContact?>?)

    @Query("SELECT count(*) FROM ContusContact WHERE jid LIKE (:jid)")
    fun isContusContact(jid: String): Int
}
