package com.contusfly.models
import com.google.gson.annotations.SerializedName

/**
 * This class will show the list of created, updated, deleted contus contact
 */
class ContusContactList {

    /**
     * variable holds created contus contact list.
     */
    @SerializedName("created")
    var created: List<ContusContacts>? = null

    /**
     * variable holds updated contus contact list.
     */
    @SerializedName("updated")
    var updated: List<ContusContacts>? = null

    /**
     * variable holds contus contact list to be delete.
     */
    @SerializedName("deleted")
    var deleted: List<ContusContacts>? = null
}
