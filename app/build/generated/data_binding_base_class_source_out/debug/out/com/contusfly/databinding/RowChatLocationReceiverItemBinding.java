// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.RoundRectCornerImageView;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RowChatLocationReceiverItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RowStarredMessageHeaderReceiverBinding headerStarredMessageSender;

  @NonNull
  public final ShapeableImageView icBalloon;

  @NonNull
  public final ImageView icStarRv;

  @NonNull
  public final RoundRectCornerImageView imageLocRev;

  @NonNull
  public final RelativeLayout rlHeaderReceiver;

  @NonNull
  public final RelativeLayout rowChatLocation;

  @NonNull
  public final ImageView sendImgForward;

  @NonNull
  public final AppCompatTextView textChatDate;

  @NonNull
  public final AppCompatTextView textLocRevTime;

  @NonNull
  public final LinearLayout viewChatRevLoc;

  @NonNull
  public final View viewDivider;

  @NonNull
  public final ViewStub viewMessageDate;

  @NonNull
  public final ViewStub viewSenderName;

  private RowChatLocationReceiverItemBinding(@NonNull LinearLayout rootView,
      @NonNull RowStarredMessageHeaderReceiverBinding headerStarredMessageSender,
      @NonNull ShapeableImageView icBalloon, @NonNull ImageView icStarRv,
      @NonNull RoundRectCornerImageView imageLocRev, @NonNull RelativeLayout rlHeaderReceiver,
      @NonNull RelativeLayout rowChatLocation, @NonNull ImageView sendImgForward,
      @NonNull AppCompatTextView textChatDate, @NonNull AppCompatTextView textLocRevTime,
      @NonNull LinearLayout viewChatRevLoc, @NonNull View viewDivider,
      @NonNull ViewStub viewMessageDate, @NonNull ViewStub viewSenderName) {
    this.rootView = rootView;
    this.headerStarredMessageSender = headerStarredMessageSender;
    this.icBalloon = icBalloon;
    this.icStarRv = icStarRv;
    this.imageLocRev = imageLocRev;
    this.rlHeaderReceiver = rlHeaderReceiver;
    this.rowChatLocation = rowChatLocation;
    this.sendImgForward = sendImgForward;
    this.textChatDate = textChatDate;
    this.textLocRevTime = textLocRevTime;
    this.viewChatRevLoc = viewChatRevLoc;
    this.viewDivider = viewDivider;
    this.viewMessageDate = viewMessageDate;
    this.viewSenderName = viewSenderName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RowChatLocationReceiverItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RowChatLocationReceiverItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.row_chat_location_receiver_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RowChatLocationReceiverItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.header_starred_message_sender;
      View headerStarredMessageSender = ViewBindings.findChildViewById(rootView, id);
      if (headerStarredMessageSender == null) {
        break missingId;
      }
      RowStarredMessageHeaderReceiverBinding binding_headerStarredMessageSender = RowStarredMessageHeaderReceiverBinding.bind(headerStarredMessageSender);

      id = R.id.ic_balloon;
      ShapeableImageView icBalloon = ViewBindings.findChildViewById(rootView, id);
      if (icBalloon == null) {
        break missingId;
      }

      id = R.id.ic_star_rv;
      ImageView icStarRv = ViewBindings.findChildViewById(rootView, id);
      if (icStarRv == null) {
        break missingId;
      }

      id = R.id.image_loc_rev;
      RoundRectCornerImageView imageLocRev = ViewBindings.findChildViewById(rootView, id);
      if (imageLocRev == null) {
        break missingId;
      }

      id = R.id.rl_header_receiver;
      RelativeLayout rlHeaderReceiver = ViewBindings.findChildViewById(rootView, id);
      if (rlHeaderReceiver == null) {
        break missingId;
      }

      id = R.id.row_chat_location;
      RelativeLayout rowChatLocation = ViewBindings.findChildViewById(rootView, id);
      if (rowChatLocation == null) {
        break missingId;
      }

      id = R.id.send_img_forward;
      ImageView sendImgForward = ViewBindings.findChildViewById(rootView, id);
      if (sendImgForward == null) {
        break missingId;
      }

      id = R.id.text_chat_date;
      AppCompatTextView textChatDate = ViewBindings.findChildViewById(rootView, id);
      if (textChatDate == null) {
        break missingId;
      }

      id = R.id.text_loc_rev_time;
      AppCompatTextView textLocRevTime = ViewBindings.findChildViewById(rootView, id);
      if (textLocRevTime == null) {
        break missingId;
      }

      id = R.id.view_chat_rev_loc;
      LinearLayout viewChatRevLoc = ViewBindings.findChildViewById(rootView, id);
      if (viewChatRevLoc == null) {
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

      id = R.id.view_sender_name;
      ViewStub viewSenderName = ViewBindings.findChildViewById(rootView, id);
      if (viewSenderName == null) {
        break missingId;
      }

      return new RowChatLocationReceiverItemBinding((LinearLayout) rootView,
          binding_headerStarredMessageSender, icBalloon, icStarRv, imageLocRev, rlHeaderReceiver,
          rowChatLocation, sendImgForward, textChatDate, textLocRevTime, viewChatRevLoc,
          viewDivider, viewMessageDate, viewSenderName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}