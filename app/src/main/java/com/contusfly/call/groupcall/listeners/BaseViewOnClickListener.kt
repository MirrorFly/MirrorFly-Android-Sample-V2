package com.contusfly.call.groupcall.listeners

interface BaseViewOnClickListener {


    /**
     * Callback Method for swap video button click
     */
    fun onSwapVideo()

    /**
     * Callback Method to show/hide option arrow
     */
    fun checkOptionArrowVisibility(visibility: Int)

    /**
     * Callback Method to update local view position
     */
    fun onCallOptionsVisible()

    /**
     * Callback Method to update local view position
     */
    fun onCallOptionsHidden()

    /**
     * Callback Method to animate call detail while call is in hold/reconnecting
     */
    fun animateCallOptionsView()

    /**
     * Callback Method to enable call option animation
     */
    fun enableCallOptionAnimation()

    /**
     * Callback Method to animates the call options layout with given animation
     *
     * @param animation             animation id
     * @param callOptionsVisibility visibility to be changed for callOptions view
     * @param arrowVisibility       visibility to be changed for arrow view
     */
    fun animateCallOptions(animation: Int, callOptionsVisibility: Int, arrowVisibility: Int)

    /**
     * Callback Method to  update local video mute status
     */
    fun ownVideoMuteStatusUpdated()

    /**
     * Callback Method to update local audio mute status
     */
    fun ownAudioMuteStatusUpdated()


    /**
     * Callback Method to animate list view
     */
    fun animateListViewWithCallOptions()

    /**
     * Callback Method to remove pinned user
     */
    fun pinnedUserRemoved()
}