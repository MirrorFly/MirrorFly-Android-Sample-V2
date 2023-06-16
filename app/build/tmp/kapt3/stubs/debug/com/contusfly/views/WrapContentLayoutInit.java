package com.contusfly.views;

import java.lang.System;

/**
 * Crop the image of the taken photo to set on the profile image
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006J:\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u00060\u0013R\u00020\u0014J2\u0010\u0015\u001a\u00020\b2\n\u0010\u0012\u001a\u00060\u0013R\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J8\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J>\u0010\u001f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/contusfly/views/WrapContentLayoutInit;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isChildSize", "", "initChildDimensions", "", "width", "", "height", "vertical", "measureCheckChild", "i", "stateItemCount", "widthSpec", "unspecified", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "measureChild", "position", "heightSpec", "dimensions", "", "setMeasure", "exactWidth", "widthSize", "exactHeight", "heightSize", "setMeasureData", "Companion", "app_debug"})
public class WrapContentLayoutInit extends androidx.recyclerview.widget.LinearLayoutManager {
    
    /**
     * Child size boolean variable
     */
    @kotlin.jvm.JvmField()
    public boolean isChildSize = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.views.WrapContentLayoutInit.Companion Companion = null;
    
    /**
     * Width of the child layout
     */
    public static final int CHILD_WIDTH = 0;
    
    /**
     * Height of the child layout
     */
    public static final int CHILD_HEIGHT = 1;
    
    /**
     * Default child layout size
     */
    private static final int DEFAULT_CHILD_SIZE = 100;
    
    /**
     * List of child dimensions
     */
    @org.jetbrains.annotations.NotNull()
    private static final int[] childDimensions = null;
    
    public WrapContentLayoutInit(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    /**
     * Initialise the child dimensions.
     *
     * @param width    Width of layout
     * @param height   Height of layout
     * @param vertical True if vertical
     */
    public final void initChildDimensions(int width, int height, boolean vertical) {
    }
    
    /**
     * measure the child and and measure to the view
     *
     * @param isChildSize    boolean
     * @param i              integer
     * @param stateItemCount integer
     * @param widthSpec      integer
     * @param unspecified    integer
     * @param recycler       RecyclerView.Recycler
     */
    public final void measureCheckChild(boolean isChildSize, int i, int stateItemCount, int widthSpec, int unspecified, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.Recycler recycler) {
    }
    
    /**
     * Measures the child size of the recycler view based on the height and width
     *
     * @param recycler   Instance of RecyclerView.Recycler
     * @param position   The position of list
     * @param widthSpec  The width spec of list view
     * @param heightSpec The height spec of list view
     * @param dimensions The dimensions of list view
     */
    public final void measureChild(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.Recycler recycler, int position, int widthSpec, int heightSpec, @org.jetbrains.annotations.NotNull()
    int[] dimensions) {
    }
    
    /**
     * Set up the measure data
     *
     * @param vertical    Boolean is vertical
     * @param height      Height of the view
     * @param heightSize  Height size of the view
     * @param widthSize   Height size of the view
     * @param exactWidth  Exact Width of view
     * @param exactHeight Exact height of the view
     * @param width       Width of the view
     * @return int Measured size
     */
    public final int setMeasureData(boolean vertical, int height, int heightSize, int widthSize, boolean exactWidth, boolean exactHeight, int width) {
        return 0;
    }
    
    /**
     * Measure the height and width of the layout manager
     *
     * @param exactWidth  Indicates width mode is exact or not
     * @param widthSize   Size of the width
     * @param exactHeight Indicates height mode is exact or not
     * @param heightSize  Size of the height
     * @param width       Child width
     * @param height      Child height
     */
    private final void setMeasure(boolean exactWidth, int widthSize, boolean exactHeight, int heightSize, int width, int height) {
    }
    
    /**
     * List of child dimensions
     */
    @org.jetbrains.annotations.NotNull()
    public static final int[] getChildDimensions() {
        return null;
    }
    
    /**
     * Make unspecified spec.
     *
     * @return int The measure spec
     */
    @kotlin.jvm.JvmStatic()
    public static final int makeUnspecifiedSpec() {
        return 0;
    }
    
    /**
     * Returns the value of the child dimension based on the index
     *
     * @param index index of the child dimension
     * @return int Value based on the index of the childDimensions
     */
    @kotlin.jvm.JvmStatic()
    public static final int getChildDimensionsValue(int index) {
        return 0;
    }
    
    /**
     * Sets the values for the childDimensions based on index
     *
     * @param index index of the childDimensions
     * @param value value for the index of childDimensions
     */
    @kotlin.jvm.JvmStatic()
    public static final void setChildDimensionsValue(int index, int value) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/views/WrapContentLayoutInit$Companion;", "", "()V", "CHILD_HEIGHT", "", "CHILD_WIDTH", "DEFAULT_CHILD_SIZE", "childDimensions", "", "getChildDimensions$annotations", "getChildDimensions", "()[I", "getChildDimensionsValue", "index", "makeUnspecifiedSpec", "setChildDimensionsValue", "", "value", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final int[] getChildDimensions() {
            return null;
        }
        
        /**
         * List of child dimensions
         */
        @kotlin.jvm.JvmStatic()
        @java.lang.Deprecated()
        public static void getChildDimensions$annotations() {
        }
        
        /**
         * Make unspecified spec.
         *
         * @return int The measure spec
         */
        @kotlin.jvm.JvmStatic()
        public final int makeUnspecifiedSpec() {
            return 0;
        }
        
        /**
         * Returns the value of the child dimension based on the index
         *
         * @param index index of the child dimension
         * @return int Value based on the index of the childDimensions
         */
        @kotlin.jvm.JvmStatic()
        public final int getChildDimensionsValue(int index) {
            return 0;
        }
        
        /**
         * Sets the values for the childDimensions based on index
         *
         * @param index index of the childDimensions
         * @param value value for the index of childDimensions
         */
        @kotlin.jvm.JvmStatic()
        public final void setChildDimensionsValue(int index, int value) {
        }
    }
}