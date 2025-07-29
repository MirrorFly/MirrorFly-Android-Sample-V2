package com.contusfly.groupmention;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputType;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.contusfly.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import io.github.rockerhieu.emojicon.EmojiconEditText;

public class MentionEditGroupText extends EmojiconEditText {

    private static final  int FLAGNOSPELLINGSUGGESTION = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;

    @NonNull
    private final AtomicBoolean isDelKeyEventAlreadyHandled = new AtomicBoolean(false);

    @Nullable
    private UserMentionConfig mentionConfig;

    @Nullable
    private TextUIConfig mentionUIConfig;

    @Nullable
    private MentionWatcher mentionWatcher;

    private int originalInputType;

    public MentionEditGroupText(@NonNull Context context) {
        this(context, null);
    }

    public MentionEditGroupText(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, com.google.android.material.R.attr.editTextStyle);
    }

    public MentionEditGroupText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.originalInputType = getInputType();
    }


    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (this.mentionConfig != null) {
            post(() -> {
                updateInputType(selStart, selEnd);
                updateSpan(selStart, selEnd);
                lookupMention();
            });
        }
    }

    private boolean hasNoSuggestionFlag() {
        return (getInputType() & FLAGNOSPELLINGSUGGESTION) == FLAGNOSPELLINGSUGGESTION;
    }

    private void lookupMention() {
        final Editable text = getText();
        if (this.mentionWatcher != null && text != null) {
            this.mentionWatcher.findMention(text);
        }
    }

    private void updateInputType(int selStart, int selEnd) {
        if (selStart == selEnd) {
            final Editable text = getText();
            int inputType = getInputType();
            final Typeface typeFace = getTypeface();

            int offset = selStart;
            if (text != null) {
                offset = text.toString().lastIndexOf(" ", selStart - 1);
                if (offset < 0) {
                    offset = selStart;
                } else {
                    offset = Math.min(offset + 1, text.length());
                }
            }
            final MentionSpan startMentionSpan = getMentionSpanAtOffset(offset);
            if (startMentionSpan != null) {
                if (!hasNoSuggestionFlag()) {
                    originalInputType = inputType;
                    setInputType(inputType | FLAGNOSPELLINGSUGGESTION);
                    setTypeface(typeFace);
                }
            } else {
                if (hasNoSuggestionFlag()) {
                    setInputType(originalInputType);
                    setTypeface(typeFace);
                }
            }
        }
    }

    private void updateSpan(int selStart, int selEnd) {

        final Editable text = getText();
        if (text == null) return;

        boolean selChanged = false;
        int start = selStart;
        int end = selEnd;

        final MentionSpan startMentionSpan = getMentionSpanAtOffset(selStart);
        final int startMentionStartPosition = text.getSpanStart(startMentionSpan);
        final int startMentionEndPosition = text.getSpanEnd(startMentionSpan);
        if (startMentionStartPosition < selStart && selStart < startMentionEndPosition) {
            start = startMentionStartPosition;
            selChanged = true;
        }

        boolean isAlreadySelected = selStart != selEnd;
        if (isAlreadySelected) {
            final MentionSpan endMentionSpan = getMentionSpanAtOffset(selEnd);
            final int endMentionStartPosition = text.getSpanStart(endMentionSpan);
            final int endMentionEndPosition = text.getSpanEnd(endMentionSpan);
            if (endMentionStartPosition < selEnd && selEnd < endMentionEndPosition) {
                end = endMentionEndPosition;
                selChanged = true;
            }
        }
        if (selChanged) {
            setSelection(start, end);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        if (!isDelKeyEventAlreadyHandled.getAndSet(false) && event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
            Log.d("__ onKeyDkeycode = %s", String.valueOf(event.getKeyCode()));
            boolean handled = onBackspacePressed();
            if (handled) {
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    @Nullable
    @Override
    public InputConnection onCreateInputConnection(@NonNull EditorInfo outAttrs) {
        final InputConnection connection = super.onCreateInputConnection(outAttrs);
        if (connection == null) return null;
        return new InputConnectionWrapper(connection, true) {
            @Override
            public boolean sendKeyEvent(KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                    Log.d("__ keycode del = %s", String.valueOf(event.getKeyCode()));
                    isDelKeyEventAlreadyHandled.set(true);
                    boolean handled = onBackspacePressed();
                    if (handled) {
                        return true;
                    }
                }
                return super.sendKeyEvent(event);
            }

            @Override
            public boolean deleteSurroundingText(int beforeLength, int afterLength) {
                Log.d("__ deleteS%s, afterL=%s", String.valueOf(beforeLength+afterLength));
                if (beforeLength == 1 && afterLength == 0) {
                    return sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
                            && sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
                }

                return super.deleteSurroundingText(beforeLength, afterLength);
            }
        };
    }

    /**
     * Return the MentionSpan to which the character at index belongs
     *
     * @param index Offset of mention span to get
     * @return Then markup object with mention information
     * @since 3.0.0
     */
    @Nullable
    public MentionSpan getMentionSpanAtOffset(int index) {
        final Editable text = getText();
        if (text == null) return null;

        final MentionSpan[] spans = text.getSpans(index, index, MentionSpan.class);
        return (spans != null && spans.length > 0) ? spans[0] : null;
    }

    private boolean onBackspacePressed() {
        int cursorStart = getSelectionStart();
        final int cursorEnd = getSelectionEnd();
        Log.e("cursorStart",String.valueOf(cursorStart));
        Log.e("cursorEnd",String.valueOf(cursorEnd));
        if (cursorStart == cursorEnd) {
            final Editable buffer = getText();
            if (buffer != null && buffer.length() > 0) {
                if(cursorEnd==0){
                    return false;
                }
                MentionSpan[] span = buffer.getSpans(cursorStart-1, cursorEnd, MentionSpan.class);
                if (span.length > 0) {
                    int start = buffer.getSpanStart(span[span.length-1]);
                    int end = buffer.getSpanEnd(span[span.length-1]);
                    buffer.replace(start, end, "");
                    buffer.removeSpan(span[span.length-1]);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Binds the configuration for mention and the callback for mention to this EditText.
     *
     * @param config The configuration for mention to be applied for this class
     * @param handler The callback that will run when a mentioned text is detected
     * @since 3.0.0
     */
    public void bindUserMention(@NonNull UserMentionConfig config, @NonNull TextUIConfig mentionUIConfig, @NonNull OnMentionEventListener handler, LinearLayout groupTagLayout, RecyclerView groupRecyclerView, boolean fromChat) {

        this.mentionConfig = config;
        this.mentionUIConfig = mentionUIConfig;
        this.mentionWatcher = new MentionWatcher(this, config, (isDetected, detectedKeyword) -> {
            if(fromChat) {
                if (!isDetected) {
                    if (groupTagLayout.getVisibility() == View.VISIBLE) {
                        groupTagLayout.setVisibility(View.GONE);
                    }
                } else {
                    if(groupTagLayout.getVisibility() != View.VISIBLE)
                     groupTagLayout.setVisibility(View.VISIBLE);
                }
            } else {
                if (!isDetected) {
                    if (groupRecyclerView.getVisibility() == View.VISIBLE) {
                        groupRecyclerView.setVisibility(View.GONE);
                    }

                } else {
                    groupRecyclerView.setVisibility(View.VISIBLE);
                }
            }
            handler.onMentionedTextDetected(detectedKeyword);
        });

    }


    public void replaceText(String name,MentionUser userId) {
        final int startCursorPosition = getSelectionStart();
        final int endCursorPosition = getSelectionEnd();
        final Editable text = getText();
        final String token = mentionConfig.getTrigger();
        if (text == null) return;
        int index = MentionWatcher.findTriggerIndex(this, mentionConfig.getTrigger(), mentionConfig.getDelimiter(), startCursorPosition);
        if (index >= 0) {
            MentionSpan mentionSpan = new MentionSpan(getContext(), token, name, userId, mentionUIConfig,null);
            final SpannableString mentionText = new SpannableString(mentionSpan.getDisplayText());
             mentionText.setSpan(mentionSpan, 0, mentionText.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
            text.replace(index, endCursorPosition, TextUtils.concat(mentionText, mentionConfig.getDelimiter()));
            setSelection(index + mentionSpan.getLength() + 1);
        }

    }

    public SpannableString unSentedMessageAddMentionSpan(String name,MentionUser userId) {
        final String token = mentionConfig.getTrigger();
        MentionSpan mentionSpan = new MentionSpan(getContext(), token, name, userId, mentionUIConfig,null);
        final SpannableString mentionText = new SpannableString(mentionSpan.getDisplayText());
        mentionText.setSpan(mentionSpan, 0, mentionText.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        return mentionText;
    }

    /**
     * Returns the mentioned-template text on this EditText.
     *
     * @return The text indicating that mentions are included
     * @since 3.0.0
     */
    @NonNull
    public CharSequence getMentionedTemplate() {
        CharSequence result = "";
        final Editable mentionedTemplateText = Editable.Factory.getInstance().newEditable(getText());
        final MentionSpan[] spans = mentionedTemplateText.getSpans(0, mentionedTemplateText.length(), MentionSpan.class);
        if (spans.length > 0) {
            for (MentionSpan span : spans) {
                int start = mentionedTemplateText.getSpanStart(span);
                int end = mentionedTemplateText.getSpanEnd(span);
                mentionedTemplateText.replace(start, end, span.getTemplateText());
            }
            result = mentionedTemplateText;
        }
        return result;
    }

    /**
     * Returns the list of mentioned-users on this EditText.
     *
     * @return The list of mentioned users
     * @since 3.0.0
     */
    @NonNull
    public List<MentionUser> getMentionedUsers() {
        if (getText() == null) return Collections.emptyList();
        final MentionSpan[] spans = getText().getSpans(0, getText().length(), MentionSpan.class);
        final List<MentionUser> mentionedUsers = new ArrayList<>();
        for (MentionSpan span : spans) {
            mentionedUsers.add(span.getMentionedUser());
        }
        return mentionedUsers;
    }

    public void applyTextUIConfig(@NonNull TextUIConfig textUIConfig) {
        if (textUIConfig.getTextColor() != TextUIConfig.UNDEFINED_RESOURCE_ID) {
            getPaint().setColor(textUIConfig.getTextColor());
        }
        if (textUIConfig.getTextStyle() != TextUIConfig.UNDEFINED_RESOURCE_ID) {
            getPaint().setTypeface(textUIConfig.generateTypeface());
        }
        if (textUIConfig.getTextSize() != TextUIConfig.UNDEFINED_RESOURCE_ID) {
            getPaint().setTextSize(textUIConfig.getTextSize());
        }
        if (textUIConfig.getTextBackgroundColor() != TextUIConfig.UNDEFINED_RESOURCE_ID) {
            getPaint().bgColor = textUIConfig.getTextBackgroundColor();
        }


    }



}

