package com.contusfly.adapters;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/adapters/ViewPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/fragment/app/FragmentActivity;", "fragmentsArray", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "titles", "", "", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/ArrayList;[Ljava/lang/String;)V", "getFragmentsArray", "()Ljava/util/ArrayList;", "getTitles", "()[Ljava/lang/String;", "[Ljava/lang/String;", "createFragment", "position", "", "getItemCount", "getTabTitle", "", "app_debug"})
public final class ViewPagerAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<androidx.fragment.app.Fragment> fragmentsArray = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] titles = null;
    
    public ViewPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<androidx.fragment.app.Fragment> fragmentsArray, @org.jetbrains.annotations.NotNull()
    java.lang.String[] titles) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<androidx.fragment.app.Fragment> getFragmentsArray() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getTitles() {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.fragment.app.Fragment createFragment(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.CharSequence getTabTitle(int position) {
        return null;
    }
}