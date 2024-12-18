// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.MirrorFlySeekBar;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListStarredAudioSentItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RelativeLayout audioCarbonRetryLayout;

  @NonNull
  public final RelativeLayout audioRetryLayout;

  @NonNull
  public final ConstraintLayout audioSentView;

  @NonNull
  public final RelativeLayout downloadProgressLayout;

  @NonNull
  public final RowStarredMessageHeaderSenderBinding headerStarredMessageReceiver;

  @NonNull
  public final ImageView imageAudioAction;

  @NonNull
  public final ImageView imageAudioCancel;

  @NonNull
  public final ImageView imageAudioFavorite;

  @NonNull
  public final ImageView imageAudioStatus;

  @NonNull
  public final AppCompatImageView imageAudioType;

  @NonNull
  public final ProgressBar progressAudioUpload;

  @NonNull
  public final ProgressBar progressBuffer;

  @NonNull
  public final RelativeLayout rlHeaderSender;

  @NonNull
  public final RelativeLayout rowChatAudio;

  @NonNull
  public final MirrorFlySeekBar seekAudioProgress;

  @NonNull
  public final AppCompatTextView textAudioDuration;

  @NonNull
  public final AppCompatTextView textAudioTime;

  @NonNull
  public final AppCompatTextView textChatDate;

  @NonNull
  public final ImageView viewCarbonRetry;

  @NonNull
  public final View viewDivider;

  @NonNull
  public final ImageView viewRetry;

  @NonNull
  public final ListChatReplySentItemBinding viewTextSentReply;

  @NonNull
  public final ConstraintLayout viewTextSentReplyLayout;

  private ListStarredAudioSentItemBinding(@NonNull LinearLayout rootView,
      @NonNull RelativeLayout audioCarbonRetryLayout, @NonNull RelativeLayout audioRetryLayout,
      @NonNull ConstraintLayout audioSentView, @NonNull RelativeLayout downloadProgressLayout,
      @NonNull RowStarredMessageHeaderSenderBinding headerStarredMessageReceiver,
      @NonNull ImageView imageAudioAction, @NonNull ImageView imageAudioCancel,
      @NonNull ImageView imageAudioFavorite, @NonNull ImageView imageAudioStatus,
      @NonNull AppCompatImageView imageAudioType, @NonNull ProgressBar progressAudioUpload,
      @NonNull ProgressBar progressBuffer, @NonNull RelativeLayout rlHeaderSender,
      @NonNull RelativeLayout rowChatAudio, @NonNull MirrorFlySeekBar seekAudioProgress,
      @NonNull AppCompatTextView textAudioDuration, @NonNull AppCompatTextView textAudioTime,
      @NonNull AppCompatTextView textChatDate, @NonNull ImageView viewCarbonRetry,
      @NonNull View viewDivider, @NonNull ImageView viewRetry,
      @NonNull ListChatReplySentItemBinding viewTextSentReply,
      @NonNull ConstraintLayout viewTextSentReplyLayout) {
    this.rootView = rootView;
    this.audioCarbonRetryLayout = audioCarbonRetryLayout;
    this.audioRetryLayout = audioRetryLayout;
    this.audioSentView = audioSentView;
    this.downloadProgressLayout = downloadProgressLayout;
    this.headerStarredMessageReceiver = headerStarredMessageReceiver;
    this.imageAudioAction = imageAudioAction;
    this.imageAudioCancel = imageAudioCancel;
    this.imageAudioFavorite = imageAudioFavorite;
    this.imageAudioStatus = imageAudioStatus;
    this.imageAudioType = imageAudioType;
    this.progressAudioUpload = progressAudioUpload;
    this.progressBuffer = progressBuffer;
    this.rlHeaderSender = rlHeaderSender;
    this.rowChatAudio = rowChatAudio;
    this.seekAudioProgress = seekAudioProgress;
    this.textAudioDuration = textAudioDuration;
    this.textAudioTime = textAudioTime;
    this.textChatDate = textChatDate;
    this.viewCarbonRetry = viewCarbonRetry;
    this.viewDivider = viewDivider;
    this.viewRetry = viewRetry;
    this.viewTextSentReply = viewTextSentReply;
    this.viewTextSentReplyLayout = viewTextSentReplyLayout;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListStarredAudioSentItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListStarredAudioSentItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_starred_audio_sent_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListStarredAudioSentItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.audio_carbon_retry_layout;
      RelativeLayout audioCarbonRetryLayout = ViewBindings.findChildViewById(rootView, id);
      if (audioCarbonRetryLayout == null) {
        break missingId;
      }

      id = R.id.audio_retry_layout;
      RelativeLayout audioRetryLayout = ViewBindings.findChildViewById(rootView, id);
      if (audioRetryLayout == null) {
        break missingId;
      }

      id = R.id.audio_sent_view;
      ConstraintLayout audioSentView = ViewBindings.findChildViewById(rootView, id);
      if (audioSentView == null) {
        break missingId;
      }

      id = R.id.download_progress_layout;
      RelativeLayout downloadProgressLayout = ViewBindings.findChildViewById(rootView, id);
      if (downloadProgressLayout == null) {
        break missingId;
      }

      id = R.id.header_starred_message_receiver;
      View headerStarredMessageReceiver = ViewBindings.findChildViewById(rootView, id);
      if (headerStarredMessageReceiver == null) {
        break missingId;
      }
      RowStarredMessageHeaderSenderBinding binding_headerStarredMessageReceiver = RowStarredMessageHeaderSenderBinding.bind(headerStarredMessageReceiver);

      id = R.id.image_audio_action;
      ImageView imageAudioAction = ViewBindings.findChildViewById(rootView, id);
      if (imageAudioAction == null) {
        break missingId;
      }

      id = R.id.image_audio_cancel;
      ImageView imageAudioCancel = ViewBindings.findChildViewById(rootView, id);
      if (imageAudioCancel == null) {
        break missingId;
      }

      id = R.id.image_audio_favorite;
      ImageView imageAudioFavorite = ViewBindings.findChildViewById(rootView, id);
      if (imageAudioFavorite == null) {
        break missingId;
      }

      id = R.id.image_audio_status;
      ImageView imageAudioStatus = ViewBindings.findChildViewById(rootView, id);
      if (imageAudioStatus == null) {
        break missingId;
      }

      id = R.id.image_audio_type;
      AppCompatImageView imageAudioType = ViewBindings.findChildViewById(rootView, id);
      if (imageAudioType == null) {
        break missingId;
      }

      id = R.id.progress_audio_upload;
      ProgressBar progressAudioUpload = ViewBindings.findChildViewById(rootView, id);
      if (progressAudioUpload == null) {
        break missingId;
      }

      id = R.id.progress_buffer;
      ProgressBar progressBuffer = ViewBindings.findChildViewById(rootView, id);
      if (progressBuffer == null) {
        break missingId;
      }

      id = R.id.rl_header_sender;
      RelativeLayout rlHeaderSender = ViewBindings.findChildViewById(rootView, id);
      if (rlHeaderSender == null) {
        break missingId;
      }

      id = R.id.row_chat_audio;
      RelativeLayout rowChatAudio = ViewBindings.findChildViewById(rootView, id);
      if (rowChatAudio == null) {
        break missingId;
      }

      id = R.id.seek_audio_progress;
      MirrorFlySeekBar seekAudioProgress = ViewBindings.findChildViewById(rootView, id);
      if (seekAudioProgress == null) {
        break missingId;
      }

      id = R.id.text_audio_duration;
      AppCompatTextView textAudioDuration = ViewBindings.findChildViewById(rootView, id);
      if (textAudioDuration == null) {
        break missingId;
      }

      id = R.id.text_audio_time;
      AppCompatTextView textAudioTime = ViewBindings.findChildViewById(rootView, id);
      if (textAudioTime == null) {
        break missingId;
      }

      id = R.id.text_chat_date;
      AppCompatTextView textChatDate = ViewBindings.findChildViewById(rootView, id);
      if (textChatDate == null) {
        break missingId;
      }

      id = R.id.view_carbon_retry;
      ImageView viewCarbonRetry = ViewBindings.findChildViewById(rootView, id);
      if (viewCarbonRetry == null) {
        break missingId;
      }

      id = R.id.view_divider;
      View viewDivider = ViewBindings.findChildViewById(rootView, id);
      if (viewDivider == null) {
        break missingId;
      }

      id = R.id.view_retry;
      ImageView viewRetry = ViewBindings.findChildViewById(rootView, id);
      if (viewRetry == null) {
        break missingId;
      }

      id = R.id.view_text_sent_reply;
      View viewTextSentReply = ViewBindings.findChildViewById(rootView, id);
      if (viewTextSentReply == null) {
        break missingId;
      }
      ListChatReplySentItemBinding binding_viewTextSentReply = ListChatReplySentItemBinding.bind(viewTextSentReply);

      id = R.id.view_text_sent_reply_layout;
      ConstraintLayout viewTextSentReplyLayout = ViewBindings.findChildViewById(rootView, id);
      if (viewTextSentReplyLayout == null) {
        break missingId;
      }

      return new ListStarredAudioSentItemBinding((LinearLayout) rootView, audioCarbonRetryLayout,
          audioRetryLayout, audioSentView, downloadProgressLayout,
          binding_headerStarredMessageReceiver, imageAudioAction, imageAudioCancel,
          imageAudioFavorite, imageAudioStatus, imageAudioType, progressAudioUpload, progressBuffer,
          rlHeaderSender, rowChatAudio, seekAudioProgress, textAudioDuration, textAudioTime,
          textChatDate, viewCarbonRetry, viewDivider, viewRetry, binding_viewTextSentReply,
          viewTextSentReplyLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
