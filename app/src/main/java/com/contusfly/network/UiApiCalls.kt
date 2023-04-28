package com.contusfly.network

import com.contusfly.models.ContactSyncData
import com.contusfly.models.RegisterData
import com.contusfly.utils.Constants
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
interface UiApiCalls {

    @POST(Constants.REGISTER_END_POINT)
    suspend fun registerAsync(@Body params: HashMap<String, String>): RegisterData

    @POST(Constants.REGISTER_END_POINT)
    fun getRegisterData(@Body body: HashMap<String, String>): Call<RegisterData>

    @POST(Constants.CONTACT_SYNC_END_POINT)
    suspend fun contactSyncAsync(@Body params: HashMap<String, String>): ContactSyncData

    @POST(Constants.CONTACT_SYNC_END_POINT)
    fun getContactSync(@Body params: HashMap<String, String>): Call<JSONObject>
}