package com.contusfly.call.groupcall.listeners

interface ActivityOnClickListener {

    /**
     * Callback Method to answer the call
     */
    fun answer()

    /**
     * Callback Method to request camera permission when un mute video
     */
    fun requestCameraPermission()

    /**
     * Callback Method to cancel call again
     */
    fun cancelCallAgain()

    /**
     * Callback Method to initiate call again
     */
    fun makeCallAgain()

    /**
     * Callback Method to hang video call
     */
    fun hangVideoCall()

    /**
     * Callback Method to add users to the call
     */
    fun addUsersInCall()

    /**
     * Callback Method to handle call confirmation dialog
     */
    fun onCallSwitchConfirmationDialog()

    /**
     * Callback Method to handle requesting video call dialog
     */
    fun onRequestingVideoCallDialog()

    /**
     * Callback Method to handle call switch dialog
     * @param isAccepted to determine whether call switch accepted or declined
     */
    fun onCallSwitchDialog(isAccepted: Boolean)

    /**
     * Callback Method to add local user to adapter
     */
    fun addLocalUserToAdapter()

    /**
     * Callback Method to switch tile view to grid view
     */
    fun switchToGridView()

    /**
     * Callback Method to switch grid view to tile view
     */
    fun switchToTileView()

    /**
     * Callback Method to reset view updated flag
     */
    fun resetViewsUpdatedFlag()
}