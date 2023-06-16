package com.contusfly.views;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.Arrays;

public class EmojiExcludeEditText extends EditText {

    private EmojiExcludeFilter emojiExcludeFilter;

    public EmojiExcludeEditText(Context context) {
        super(context);
        init();
    }

    public EmojiExcludeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EmojiExcludeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (emojiExcludeFilter == null) {
            emojiExcludeFilter = new EmojiExcludeFilter();
        }
        setFilters(new InputFilter[]{emojiExcludeFilter});
    }

    @Override
    public void setFilters(InputFilter[] filters) {
        if (filters.length != 0) { //if length == 0 it will here return when init() is called
            boolean add = true;
            for (InputFilter inputFilter : filters) {
                if (inputFilter == emojiExcludeFilter) {
                    add = false;
                    break;
                }
            }
            if (add) {
                filters = Arrays.copyOf(filters, filters.length + 1);
                filters[filters.length - 1] = emojiExcludeFilter;
            }
        }
        super.setFilters(filters);
    }

    private class EmojiExcludeFilter implements InputFilter {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            for (int i = start; i < end; i++) {
                int type = Character.getType(source.charAt(i));
                if (type == Character.SURROGATE || type == Character.OTHER_SYMBOL) {
                    return "";
                }
            }
            return null;
        }
    }
}
