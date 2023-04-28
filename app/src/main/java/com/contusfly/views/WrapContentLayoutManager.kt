package com.contusfly.views

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Crop the image of the taken photo to set on the profile image
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
class WrapContentLayoutManager(context: Context) : WrapContentLayoutInit(context) {
    /**
     * Set the measurement
     *
     * @param recycler   recycler view to measure
     * @param state      state of the recycler view
     * @param widthSpec  width
     * @param heightSpec height
     */
    override fun onMeasure(recycler: RecyclerView.Recycler, state: RecyclerView.State, widthSpec: Int, heightSpec: Int) {
        val widthMode = View.MeasureSpec.getMode(widthSpec)
        val heightMode = View.MeasureSpec.getMode(heightSpec)
        val widthSize = View.MeasureSpec.getSize(widthSpec)
        val heightSize = View.MeasureSpec.getSize(heightSpec)
        val exactWidth = widthMode == View.MeasureSpec.EXACTLY
        val exactHeight = heightMode == View.MeasureSpec.EXACTLY
        makeUnspecifiedSpec()
        if (exactWidth && exactHeight) {
            // in case of exact calculations for both dimensions let's use
            // default "onMeasure" implementation
            super.onMeasure(recycler, state, widthSpec, heightSpec)
            return
        }
        val vertical = orientation == VERTICAL
        initChildDimensions(widthSize, heightSize, vertical)
        recycler.clear()
        val resultValue = setMeasureAdapter(state, recycler, widthSpec, heightSpec)
        if (resultValue == 1) {
            super.onMeasure(recycler, state, widthSpec, heightSpec)
        }
    }

    /**
     * Set the measurement on the adapter
     *
     * @param state      state of the recycler view
     * @param recycler   recycler view to measure
     * @param widthSpec  width
     * @param heightSpec height
     * @return int 1 if Measured or 0 if not
     */
    private fun setMeasureAdapter(state: RecyclerView.State, recycler: RecyclerView.Recycler, widthSpec: Int, heightSpec: Int): Int {
        val vertical = orientation == VERTICAL
        val stateItemCount = state.itemCount
        val adapterItemCount = itemCount
        val unspecified = makeUnspecifiedSpec()
        val widthSize = View.MeasureSpec.getSize(widthSpec)
        val heightSize = View.MeasureSpec.getSize(heightSpec)
        val widthMode = View.MeasureSpec.getMode(widthSpec)
        val heightMode = View.MeasureSpec.getMode(heightSpec)
        val exactWidth = widthMode == View.MeasureSpec.EXACTLY
        val exactHeight = heightMode == View.MeasureSpec.EXACTLY
        var width = 0
        var height = 0
        for (i in 0 until adapterItemCount) {
            if (vertical) {
                measureCheckChild(isChildSize, i, stateItemCount, widthSpec,
                        unspecified, recycler)
                height += getChildDimensionsValue(CHILD_HEIGHT)
                if (i == 0) {
                    width = getChildDimensionsValue(CHILD_WIDTH)
                }
            }
            if (!isChildSize && i < stateItemCount) {
                measureChild(recycler, i, unspecified, heightSpec, childDimensions)
            }
            width += getChildDimensionsValue(CHILD_WIDTH)
            if (i == 0) {
                height = getChildDimensionsValue(CHILD_HEIGHT)
            }
            if (width >= widthSize || height >= heightSize) {
                break
            }
        }
        return setMeasureData(vertical, height, heightSize, widthSize,
                exactWidth, exactHeight, width)
    }

    /**
     * Measure the orientation
     *
     * @param orientation vertical/horizontal
     */
    override fun setOrientation(orientation: Int) {
        /**
         * Might be called before the constructor of this class is called noinspection
         * ConstantConditions
         */
        if (getOrientation() != orientation) {
            setChildDimensionsValue(CHILD_WIDTH, 0)
            setChildDimensionsValue(CHILD_HEIGHT, 0)
        }
        super.setOrientation(orientation)
    }
}