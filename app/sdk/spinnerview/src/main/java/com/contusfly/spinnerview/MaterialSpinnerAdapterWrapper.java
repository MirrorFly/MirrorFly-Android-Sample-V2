package com.contusfly.spinnerview;

import android.content.Context;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.List;

final class MaterialSpinnerAdapterWrapper extends MaterialSpinnerBaseAdapter {

    private final ListAdapter listAdapter;

    public MaterialSpinnerAdapterWrapper(Context context, ListAdapter toWrap) {
        super(context);
        listAdapter = toWrap;
    }

    @Override public int getCount() {
        int size = listAdapter.getCount();
        if (size == 1 || isHintEnabled()) return size;
        return size - 1;
    }

    @Override public Object getItem(int position) {
        if (isHintEnabled()) {
            return listAdapter.getItem(position);
        } else if (position >= getSelectedIndex() && listAdapter.getCount() != 1) {
            return listAdapter.getItem(position + 1);
        } else {
            return listAdapter.getItem(position);
        }
    }

    @Override public Object get(int position) {
        return listAdapter.getItem(position);
    }

    @Override public List<Object> getItems() {
        List<Object> items = new ArrayList<>();
        for (int i = 0; i < listAdapter.getCount(); i++) {
            items.add(listAdapter.getItem(i));
        }
        return items;
    }
}
