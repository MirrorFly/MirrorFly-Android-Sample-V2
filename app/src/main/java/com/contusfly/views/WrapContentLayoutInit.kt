package com.contusfly.views

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Crop the image of the taken photo to set on the profile image
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
open class WrapContentLayoutInit(context: Context) : LinearLayoutManager(context) {
    /**
     * Child size boolean variable
     */
    @JvmField
    var isChildSize = false

    /**
     * Initialise the child dimensions.
     *
     * @param width    Width of layout
     * @param height   Height of layout
     * @param vertical True if vertical
     */
    fun initChildDimensions(width: Int, height: Int, vertical: Boolean) {
        if (getChildDimensionsValue(CHILD_WIDTH) != 0 || getChildDimensionsValue(CHILD_HEIGHT) !=
                0) {
            return
        }

        // Getting default child size
        val childSize = DEFAULT_CHILD_SIZE
        if (vertical) {
            setChildDimensionsValue(CHILD_WIDTH, width)
            setChildDimensionsValue(CHILD_HEIGHT, childSize)
        } else {
            setChildDimensionsValue(CHILD_WIDTH, childSize)
            setChildDimensionsValue(CHILD_HEIGHT, height)
        }
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
    fun measureCheckChild(isChildSize: Boolean, i: Int, stateItemCount: Int, widthSpec: Int,
                          unspecified: Int, recycler: RecyclerView.Recycler) {
        if (!isChildSize && i < stateItemCount) {
            measureChild(recycler, i, widthSpec, unspecified, childDimensions)
        }
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
    fun measureChild(recycler: RecyclerView.Recycler, position: Int, widthSpec: Int, heightSpec: Int, dimensions: IntArray) {
        val child = recycler.getViewForPosition(position)
        val p = child.layoutParams as RecyclerView.LayoutParams
        val hPadding = paddingLeft + paddingRight
        val vPadding = paddingTop + paddingBottom
        val hMargin = p.leftMargin + p.rightMargin
        val vMargin = p.topMargin + p.bottomMargin
        val hDecoration = getRightDecorationWidth(child) + getLeftDecorationWidth(child)
        val vDecoration = getTopDecorationHeight(child) + getBottomDecorationHeight(child)
        val childWidthSpec = getChildMeasureSpec(widthSpec, View.MeasureSpec.AT_MOST,
                hPadding + hMargin +
                        hDecoration, p.width,
                canScrollHorizontally())
        val childHeightSpec = getChildMeasureSpec(heightSpec, View.MeasureSpec.AT_MOST,
                vPadding + vMargin +
                        vDecoration, p.height,
                canScrollVertically())
        child.measure(childWidthSpec, childHeightSpec)
        dimensions[CHILD_WIDTH] = getDecoratedMeasuredWidth(child) + p.leftMargin + p.rightMargin
        dimensions[CHILD_HEIGHT] = getDecoratedMeasuredHeight(child) + p.bottomMargin + p.topMargin
        recycler.recycleView(child)
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
    fun setMeasureData(vertical: Boolean, height: Int, heightSize: Int, widthSize: Int,
                       exactWidth: Boolean, exactHeight: Boolean, width: Int): Int {
        return if (vertical && height < heightSize || !vertical && width < widthSize) {

            // Its really should wrap the contents of the view, let's do it
            setMeasure(exactWidth, widthSize, exactHeight, heightSize, width, height)
            0
        } else {
            1
        }
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
    private fun setMeasure(exactWidth: Boolean, widthSize: Int, exactHeight: Boolean, heightSize: Int, width: Int, height: Int) {
        var measureWidth = width
        var meaureHeight = height
        if (exactWidth) {
            measureWidth = widthSize
        } else {
            measureWidth += paddingLeft + paddingRight
        }
        if (exactHeight) {
            meaureHeight = heightSize
        } else {
            meaureHeight += paddingTop + paddingBottom
        }
        setMeasuredDimension(measureWidth, meaureHeight)
    }

    companion object {
        /**
         * Width of the child layout
         */
        const val CHILD_WIDTH = 0

        /**
         * Height of the child layout
         */
        const val CHILD_HEIGHT = 1

        /**
         * Default child layout size
         */
        private const val DEFAULT_CHILD_SIZE = 100
        /**
         * Get {@see childDimensions}
         *
         * @return [.childDimensions]
         */
        /**
         * List of child dimensions
         */
        @JvmStatic
        val childDimensions = IntArray(2)

        /**
         * Make unspecified spec.
         *
         * @return int The measure spec
         */
        @JvmStatic
        fun makeUnspecifiedSpec(): Int {
            return View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        }

        /**
         * Returns the value of the child dimension based on the index
         *
         * @param index index of the child dimension
         * @return int Value based on the index of the childDimensions
         */
        @JvmStatic
        fun getChildDimensionsValue(index: Int): Int {
            return childDimensions[index]
        }

        /**
         * Sets the values for the childDimensions based on index
         *
         * @param index index of the childDimensions
         * @param value value for the index of childDimensions
         */
        @JvmStatic
        fun setChildDimensionsValue(index: Int, value: Int) {
            childDimensions[index] = value
        }
    }
}