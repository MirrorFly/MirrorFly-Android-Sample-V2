// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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

public final class ListChatAudioReceivedItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout audioReceiveView;

  @NonNull
  public final RelativeLayout audioRetryLayout;

  @NonNull
  public final RelativeLayout downloadProgressLayout;

  @NonNull
  public final RowStarredMessageHeaderReceiverBinding headerStarredMessageSender;

  @NonNull
  public final ImageView imageAudioAction;

  @NonNull
  public final ImageView imageAudioCancel;

  @NonNull
  public final ImageView imageAudioFavorite;

  @NonNull
  public final AppCompatImageView imageAudioType;

  @NonNull
  public final ProgressBar progressAudioUpload;

  @NonNull
  public final ProgressBar progressBuffer;

  @NonNull
  public final RelativeLayout rlHeaderReceiver;

  @NonNull
  public final RelativeLayout rowChatAudio;

  @NonNull
  public final MirrorFlySeekBar seekAudioProgress;

  @NonNull
  public final ImageView sendImgForward;

  @NonNull
  public final ViewChatSpaceBinding spaceView;

  @NonNull
  public final AppCompatTextView textAudioDuration;

  @NonNull
  public final AppCompatTextView textAudioTime;

  @NonNull
  public final AppCompatTextView textChatDate;

  @NonNull
  public final LinearLayout viewChatSendAudio;

  @NonNull
  public final View viewDivider;

  @NonNull
  public final ViewStub viewMessageDate;

  @NonNull
  public final ImageView viewRetry;

  @NonNull
  public final ViewStub viewSenderName;

  @NonNull
  public final ListChatReplyReceivedItemBinding viewTextSentReply;

  private ListChatAudioReceivedItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout audioReceiveView, @NonNull RelativeLayout audioRetryLayout,
      @NonNull RelativeLayout downloadProgressLayout,
      @NonNull RowStarredMessageHeaderReceiverBinding headerStarredMessageSender,
      @NonNull ImageView imageAudioAction, @NonNull ImageView imageAudioCancel,
      @NonNull ImageView imageAudioFavorite, @NonNull AppCompatImageView imageAudioType,
      @NonNull ProgressBar progressAudioUpload, @NonNull ProgressBar progressBuffer,
      @NonNull RelativeLayout rlHeaderReceiver, @NonNull RelativeLayout rowChatAudio,
      @NonNull MirrorFlySeekBar seekAudioProgress, @NonNull ImageView sendImgForward,
      @NonNull ViewChatSpaceBinding spaceView, @NonNull AppCompatTextView textAudioDuration,
      @NonNull AppCompatTextView textAudioTime, @NonNull AppCompatTextView textChatDate,
      @NonNull LinearLayout viewChatSendAudio, @NonNull View viewDivider,
      @NonNull ViewStub viewMessageDate, @NonNull ImageView viewRetry,
      @NonNull ViewStub viewSenderName,
      @NonNull ListChatReplyReceivedItemBinding viewTextSentReply) {
    this.rootView = rootView;
    this.audioReceiveView = audioReceiveView;
    this.audioRetryLayout = audioRetryLayout;
    this.downloadProgressLayout = downloadProgressLayout;
    this.headerStarredMessageSender = headerStarredMessageSender;
    this.imageAudioAction = imageAudioAction;
    this.imageAudioCancel = imageAudioCancel;
    this.imageAudioFavorite = imageAudioFavorite;
    this.imageAudioType = imageAudioType;
    this.progressAudioUpload = progressAudioUpload;
    this.progressBuffer = progressBuffer;
    this.rlHeaderReceiver = rlHeaderReceiver;
    this.rowChatAudio = rowChatAudio;
    this.seekAudioProgress = seekAudioProgress;
    this.sendImgForward = sendImgForward;
    this.spaceView = spaceView;
    this.textAudioDuration = textAudioDuration;
    this.textAudioTime = textAudioTime;
    this.textChatDate = textChatDate;
    this.viewChatSendAudio = viewChatSendAudio;
    this.viewDivider = viewDivider;
    this.viewMessageDate = viewMessageDate;
    this.viewRetry = viewRetry;
    this.viewSenderName = viewSenderName;
    this.viewTextSentReply = viewTextSentReply;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListChatAudioReceivedItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListChatAudioReceivedItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_chat_audio_received_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListChatAudioReceivedItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.audio_receive_view;
      ConstraintLayout audioReceiveView = ViewBindings.findChildViewById(rootView, id);
      if (audioReceiveView == null) {
        break missingId;
      }

      id = R.id.audio_retry_layout;
      RelativeLayout audioRetryLayout = ViewBindings.findChildViewById(rootView, id);
      if (audioRetryLayout == null) {
        break missingId;
      }

      id = R.id.download_progress_layout;
      RelativeLayout downloadProgressLayout = ViewBindings.findChildViewById(rootView, id);
      if (downloadProgressLayout == null) {
        break missingId;
      }

      id = R.id.header_starred_message_sender;
      View headerStarredMessageSender = ViewBindings.findChildViewById(rootView, id);
      if (headerStarredMessageSender == null) {
        break missingId;
      }
      RowStarredMessageHeaderReceiverBinding binding_headerStarredMessageSender = RowStarredMessageHeaderReceiverBinding.bind(headerStarredMessageSender);

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

      id = R.id.rl_header_receiver;
      RelativeLayout rlHeaderReceiver = ViewBindings.findChildViewById(rootView, id);
      if (rlHeaderReceiver == null) {
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

      id = R.id.send_img_forward;
      ImageView sendImgForward = ViewBindings.findChildViewById(rootView, id);
      if (sendImgForward == null) {
        break missingId;
      }

      id = R.id.space_view;
      View spaceView = ViewBindings.findChildViewById(rootView, id);
      if (spaceView == null) {
        break missingId;
      }
      ViewChatSpaceBinding binding_spaceView = ViewChatSpaceBinding.bind(spaceView);

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

      id = R.id.view_chat_send_audio;
      LinearLayout viewChatSendAudio = ViewBindings.findChildViewById(rootView, id);
      if (viewChatSendAudio == null) {
        break missingId;
      }

      id = R.id.view_divider;
      View viewDivider = ViewBindings.findChildViewById(rootView, id);
      if (viewDivider == null) {
        break missingId;
      }

      id = R.id.view_message_date;
      ViewStub viewMessageDate = ViewBindings.findChildViewById(rootView, id);
      if (viewMessageDate == null) {
        break missingId;
      }

      id = R.id.view_retry;
      ImageView viewRetry = ViewBindings.findChildViewById(rootView, id);
      if (viewRetry == null) {
        break missingId;
      }

      id = R.id.view_sender_name;
      ViewStub viewSenderName = ViewBindings.findChildViewById(rootView, id);
      if (viewSenderName == null) {
        break missingId;
      }

      id = R.id.view_text_sent_reply;
      View viewTextSentReply = ViewBindings.findChildViewById(rootView, id);
      if (viewTextSentReply == null) {
        break missingId;
      }
      ListChatReplyReceivedItemBinding binding_viewTextSentReply = ListChatReplyReceivedItemBinding.bind(viewTextSentReply);

      return new ListChatAudioReceivedItemBinding((ConstraintLayout) rootView, audioReceiveView,
          audioRetryLayout, downloadProgressLayout, binding_headerStarredMessageSender,
          imageAudioAction, imageAudioCancel, imageAudioFavorite, imageAudioType,
          progressAudioUpload, progressBuffer, rlHeaderReceiver, rowChatAudio, seekAudioProgress,
          sendImgForward, binding_spaceView, textAudioDuration, textAudioTime, textChatDate,
          viewChatSendAudio, viewDivider, viewMessageDate, viewRetry, viewSenderName,
          binding_viewTextSentReply);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}