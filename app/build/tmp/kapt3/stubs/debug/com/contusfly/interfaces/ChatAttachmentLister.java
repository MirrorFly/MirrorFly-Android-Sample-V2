package com.contusfly.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/contusfly/interfaces/ChatAttachmentLister;", "", "onAttachAudio", "", "onAttachCamera", "onAttachContact", "onAttachDocument", "onAttachGallery", "onAttachLocation", "app_debug"})
public abstract interface ChatAttachmentLister {
    
    public abstract void onAttachDocument();
    
    public abstract void onAttachCamera();
    
    public abstract void onAttachGallery();
    
    public abstract void onAttachAudio();
    
    public abstract void onAttachContact();
    
    public abstract void onAttachLocation();
}