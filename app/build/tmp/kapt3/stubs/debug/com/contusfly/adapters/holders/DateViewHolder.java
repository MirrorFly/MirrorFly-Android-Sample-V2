package com.contusfly.adapters.holders;

import java.lang.System;

/**
 * Date view holder contains the fields of the Date view in the chat view
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/contusfly/adapters/holders/DateViewHolder;", "Lcom/contusfly/adapters/holders/ReplyMessageViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "dateView", "Landroidx/appcompat/widget/AppCompatTextView;", "dateViewStub", "Landroid/view/ViewStub;", "checkTwoDigitsForDate", "", "date", "", "getMonthForInt", "num", "hideDateView", "", "renderDateView", "showDateView", "item", "Lcom/mirrorflysdk/api/models/ChatMessage;", "text", "app_debug"})
public class DateViewHolder extends com.contusfly.adapters.holders.ReplyMessageViewHolder {
    
    /**
     * Date view between the chats
     */
    private androidx.appcompat.widget.AppCompatTextView dateView;
    
    /**
     * View stub to avoid unwanted rendering of views. Its used to render view whenever it is
     * necessary
     */
    private final android.view.ViewStub dateViewStub = null;
    
    public DateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.View itemView) {
        super(null);
    }
    
    /**
     * Hides date view header if it is already rendered
     */
    public final void hideDateView() {
    }
    
    /**
     * Shows the date view and shows text based on item position
     *
     * @param item Position of the view
     */
    public final void showDateView(@org.jetbrains.annotations.NotNull()
    com.mirrorflysdk.api.models.ChatMessage item) {
    }
    
    /**
     * Shows date view and sets text
     *
     * @param text Text to show
     */
    private final void showDateView(java.lang.String text) {
    }
    
    /**
     * Renders the view from ViewStub
     */
    private final void renderDateView() {
    }
    
    private final java.lang.String getMonthForInt(int num) {
        return null;
    }
    
    private final java.lang.String checkTwoDigitsForDate(int date) {
        return null;
    }
}