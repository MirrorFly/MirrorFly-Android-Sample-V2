package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J<\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/utils/CustomLengthFilter;", "Landroid/text/InputFilter;", "max", "", "(I)V", "mMax", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dStart", "dEnd", "app_debug"})
public final class CustomLengthFilter implements android.text.InputFilter {
    private int mMax = 0;
    
    public CustomLengthFilter(int max) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.CharSequence filter(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence source, int start, int end, @org.jetbrains.annotations.Nullable()
    android.text.Spanned dest, int dStart, int dEnd) {
        return null;
    }
}