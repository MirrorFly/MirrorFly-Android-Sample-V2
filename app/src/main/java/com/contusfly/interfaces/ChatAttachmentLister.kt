package com.contusfly.interfaces

interface ChatAttachmentLister {

    fun onAttachDocument()

    fun onAttachCamera()

    fun onAttachGallery()

    fun onAttachAudio()

    fun onAttachContact()

    fun onAttachLocation()
}