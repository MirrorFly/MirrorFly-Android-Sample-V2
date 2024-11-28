package com.contusfly.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0002J\u0012\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u00152\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010%2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u000200H\u0016J\u001a\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020%2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u00103\u001a\u00020\u0015H\u0002J \u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u001dH\u0002J\u0018\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001dH\u0002J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/contusfly/fragments/ScheduleBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "binding", "Lcom/contusfly/databinding/FragmentScheduleBottomSheetBinding;", "datePickerDialog", "Landroid/app/DatePickerDialog;", "meetLink", "oldTimeStamp", "", "parentViewModel", "Lcom/contusfly/viewmodels/ChatParentViewModel;", "scheduleTimeStamp", "timePickerDialog", "Landroid/app/TimePickerDialog;", "combinedTimeStamp", "", "defaultTimeStamp", "selectedDateTimeStamp", "dateTimePicker", "defaultDate", "defaultTime", "generateMeetLink", "getTheme", "", "goToOngoingCallPreviewActivity", "context", "Landroid/content/Context;", "callLink", "initView", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "setClickListeners", "updateDateText", "year", "month", "day", "updateTimeText", "hour", "minute", "viewVisibility", "isChecked", "", "app_debug"})
public final class ScheduleBottomSheetFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment implements android.view.View.OnClickListener {
    private final android.app.Activity activity = null;
    private com.contusfly.databinding.FragmentScheduleBottomSheetBinding binding;
    private java.lang.String meetLink = "";
    private long scheduleTimeStamp = 0L;
    private long oldTimeStamp = 0L;
    private final java.lang.String TAG = "#schedulemeet";
    private com.contusfly.viewmodels.ChatParentViewModel parentViewModel;
    private android.app.DatePickerDialog datePickerDialog;
    private android.app.TimePickerDialog timePickerDialog;
    private java.util.HashMap _$_findViewCache;
    
    public ScheduleBottomSheetFragment(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
        super();
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onDismiss(@org.jetbrains.annotations.NotNull
    android.content.DialogInterface dialog) {
    }
    
    @java.lang.Override
    public int getTheme() {
        return 0;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void generateMeetLink() {
    }
    
    private final java.lang.String defaultDate() {
        return null;
    }
    
    private final java.lang.String defaultTime() {
        return null;
    }
    
    private final void viewVisibility(boolean isChecked) {
    }
    
    private final void setClickListeners() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.Nullable
    android.view.View v) {
    }
    
    private final void goToOngoingCallPreviewActivity(android.content.Context context, java.lang.String callLink) {
    }
    
    private final void dateTimePicker() {
    }
    
    private final void updateDateText(int year, int month, int day) {
    }
    
    private final void updateTimeText(int hour, int minute) {
    }
    
    private final void combinedTimeStamp(long defaultTimeStamp, long selectedDateTimeStamp) {
    }
}