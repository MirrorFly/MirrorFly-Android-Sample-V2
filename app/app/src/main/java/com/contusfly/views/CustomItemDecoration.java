package com.contusfly.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.contusfly.R;

public class CustomItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    public CustomItemDecoration(Context context) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.line_divider);
    }
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getAdapter().getItemCount();
        for (int i = 0; i < childCount; i++) {
            if (i == (childCount - 1)) {
                continue;
            }
            View child = parent.getChildAt(i);
            if (child != null && child.getLayoutParams() != null) {
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }
}
