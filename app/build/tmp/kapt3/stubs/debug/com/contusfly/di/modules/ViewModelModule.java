package com.contusfly.di.modules;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!\u00a2\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH!\u00a2\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH!\u00a2\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H!\u00a2\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H!\u00a2\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH!\u00a2\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u001dH!\u00a2\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H!\u00a2\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%H!\u00a2\u0006\u0002\b&J\u0015\u0010\'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)H!\u00a2\u0006\u0002\b*\u00a8\u0006+"}, d2 = {"Lcom/contusfly/di/modules/ViewModelModule;", "", "()V", "bindCallLogViewModel", "Landroidx/lifecycle/ViewModel;", "callLogViewModel", "Lcom/contusfly/call/calllog/CallLogViewModel;", "bindCallLogViewModel$app_debug", "bindCallViewModel", "callViewModel", "Lcom/contusfly/call/groupcall/CallViewModel;", "bindCallViewModel$app_debug", "bindChatParentViewModel", "chatParentViewModel", "Lcom/contusfly/viewmodels/ChatParentViewModel;", "bindChatParentViewModel$app_debug", "bindChatViewModel", "chatViewModel", "Lcom/contusfly/viewmodels/ChatViewModel;", "bindChatViewModel$app_debug", "bindContactViewModel", "contactViewModel", "Lcom/contusfly/viewmodels/ContactViewModel;", "bindContactViewModel$app_debug", "bindDashboardViewModel", "dashboardViewModel", "Lcom/contusfly/viewmodels/DashboardViewModel;", "bindDashboardViewModel$app_debug", "bindForwardMessageViewModel", "Lcom/contusfly/viewmodels/ForwardMessageViewModel;", "bindForwardMessageViewModel$app_debug", "bindMediaPreviewViewModel", "mediaPreviewViewModel", "Lcom/contusfly/viewmodels/MediaPreviewViewModel;", "bindMediaPreviewViewModel$app_debug", "bindMentionsViewModel", "mentionsViewModel", "Lcom/contusfly/viewmodels/MentionsViewModel;", "bindMentionsViewModel$app_debug", "bindUserListViewModel", "userListViewModel", "Lcom/contusfly/viewmodels/UserListViewModel;", "bindUserListViewModel$app_debug", "app_debug"})
@dagger.Module
public abstract class ViewModelModule {
    
    public ViewModelModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.viewmodels.DashboardViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindDashboardViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.viewmodels.DashboardViewModel dashboardViewModel);
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.viewmodels.ChatParentViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindChatParentViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.viewmodels.ChatParentViewModel chatParentViewModel);
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.viewmodels.ContactViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindContactViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.viewmodels.ContactViewModel contactViewModel);
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.viewmodels.ChatViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindChatViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.viewmodels.ChatViewModel chatViewModel);
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.viewmodels.ForwardMessageViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindForwardMessageViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.viewmodels.ForwardMessageViewModel chatViewModel);
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.call.calllog.CallLogViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindCallLogViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.call.calllog.CallLogViewModel callLogViewModel);
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.call.groupcall.CallViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindCallViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.call.groupcall.CallViewModel callViewModel);
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.viewmodels.MediaPreviewViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindMediaPreviewViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.viewmodels.MediaPreviewViewModel mediaPreviewViewModel);
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.viewmodels.UserListViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindUserListViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.viewmodels.UserListViewModel userListViewModel);
    
    @org.jetbrains.annotations.NotNull
    @com.contusfly.di.ViewModelKey(value = com.contusfly.viewmodels.MentionsViewModel.class)
    @dagger.multibindings.IntoMap
    @dagger.Binds
    public abstract androidx.lifecycle.ViewModel bindMentionsViewModel$app_debug(@org.jetbrains.annotations.NotNull
    com.contusfly.viewmodels.MentionsViewModel mentionsViewModel);
}