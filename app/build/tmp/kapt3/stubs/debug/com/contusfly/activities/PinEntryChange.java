package com.contusfly.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0006\u0010\u001d\u001a\u00020\u0012J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/contusfly/activities/PinEntryChange;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/contusfly/databinding/ActivityPinEntryChangeBinding;", "confirmPinValue", "", "errorMessage", "myPin", "oldPinValue", "pinType", "setPinValue", "title", "calculateNextExpiryDate", "Ljava/util/Date;", "noOfDays", "", "hideKeyboard", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "pinSaveChangeValidation", "privateChatSavePin", "savePin", "setSaveBtnOnClickListener", "setToolbar", "showKeyboard", "updateSafeChat", "validateOldAndNewPin", "", "validatePin", "Companion", "app_debug"})
public final class PinEntryChange extends androidx.appcompat.app.AppCompatActivity {
    
    /**
     * to store the title and set it to the action bar layout
     */
    private java.lang.String title;
    
    /**
     * to store the new pin value
     */
    private java.lang.String setPinValue;
    
    /**
     * to store the confirm pin value
     */
    private java.lang.String confirmPinValue;
    
    /**
     * to store the old pin value
     */
    private java.lang.String oldPinValue;
    
    /**
     * to store the error message value that shown on the toast message
     */
    private java.lang.String errorMessage;
    
    /**
     * to get type of pin
     */
    private java.lang.String pinType;
    private com.contusfly.databinding.ActivityPinEntryChangeBinding binding;
    
    /**
     * to store the pin
     */
    private java.lang.String myPin;
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.activities.PinEntryChange.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public PinEntryChange() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * to set the tool bar and get Intent values and validate
     */
    public final void setToolbar() {
    }
    
    /**
     * to validate the pin
     */
    private final boolean validatePin() {
        return false;
    }
    
    /**
     * click listener for save vutton
     */
    private final void setSaveBtnOnClickListener() {
    }
    
    private final void pinSaveChangeValidation() {
    }
    
    /**
     * to save the pin
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    private final void savePin() throws java.text.ParseException {
    }
    
    /**
     * to save the pin
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    private final void privateChatSavePin() throws java.text.ParseException {
    }
    
    private final void updateSafeChat() {
    }
    
    /**
     * to calculate the expiry date
     *
     * @param noOfDays - number of days for expiring.
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.Date calculateNextExpiryDate(int noOfDays) {
        return null;
    }
    
    /**
     * to validate the otp
     */
    private final boolean validateOldAndNewPin() {
        return false;
    }
    
    /**
     * to show key board to the user
     */
    private final void showKeyboard() {
    }
    
    /**
     * to hide key board to the user
     */
    private final void hideKeyboard() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/activities/PinEntryChange$Companion;", "", "()V", "callAppListener", "", "isShow", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * to indicate applifecyclelistencer class
         *
         * @param isShow bool value to show pin screen
         */
        private final void callAppListener(boolean isShow) {
        }
    }
}