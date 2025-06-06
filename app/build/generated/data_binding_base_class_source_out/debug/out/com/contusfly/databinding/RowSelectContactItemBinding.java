// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CircularImageView;
import com.contusfly.views.CustomTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RowSelectContactItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CheckBox checkSelection;

  @NonNull
  public final LinearLayout contactItem;

  @NonNull
  public final LinearLayout contactView;

  @NonNull
  public final CircularImageView emailContactIcon;

  @NonNull
  public final LinearLayout header;

  @NonNull
  public final CustomTextView headertext;

  @NonNull
  public final CircularImageView imageChatPicture;

  @NonNull
  public final ImageView imageTick;

  @NonNull
  public final CustomTextView textChatName;

  @NonNull
  public final CustomTextView textInvite;

  @NonNull
  public final CustomTextView textUserStatus;

  private RowSelectContactItemBinding(@NonNull LinearLayout rootView,
      @NonNull CheckBox checkSelection, @NonNull LinearLayout contactItem,
      @NonNull LinearLayout contactView, @NonNull CircularImageView emailContactIcon,
      @NonNull LinearLayout header, @NonNull CustomTextView headertext,
      @NonNull CircularImageView imageChatPicture, @NonNull ImageView imageTick,
      @NonNull CustomTextView textChatName, @NonNull CustomTextView textInvite,
      @NonNull CustomTextView textUserStatus) {
    this.rootView = rootView;
    this.checkSelection = checkSelection;
    this.contactItem = contactItem;
    this.contactView = contactView;
    this.emailContactIcon = emailContactIcon;
    this.header = header;
    this.headertext = headertext;
    this.imageChatPicture = imageChatPicture;
    this.imageTick = imageTick;
    this.textChatName = textChatName;
    this.textInvite = textInvite;
    this.textUserStatus = textUserStatus;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RowSelectContactItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RowSelectContactItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.row_select_contact_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RowSelectContactItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.check_selection;
      CheckBox checkSelection = ViewBindings.findChildViewById(rootView, id);
      if (checkSelection == null) {
        break missingId;
      }

      LinearLayout contactItem = (LinearLayout) rootView;

      id = R.id.contact_view;
      LinearLayout contactView = ViewBindings.findChildViewById(rootView, id);
      if (contactView == null) {
        break missingId;
      }

      id = R.id.email_contact_icon;
      CircularImageView emailContactIcon = ViewBindings.findChildViewById(rootView, id);
      if (emailContactIcon == null) {
        break missingId;
      }

      id = R.id.header;
      LinearLayout header = ViewBindings.findChildViewById(rootView, id);
      if (header == null) {
        break missingId;
      }

      id = R.id.headertext;
      CustomTextView headertext = ViewBindings.findChildViewById(rootView, id);
      if (headertext == null) {
        break missingId;
      }

      id = R.id.image_chat_picture;
      CircularImageView imageChatPicture = ViewBindings.findChildViewById(rootView, id);
      if (imageChatPicture == null) {
        break missingId;
      }

      id = R.id.image_tick;
      ImageView imageTick = ViewBindings.findChildViewById(rootView, id);
      if (imageTick == null) {
        break missingId;
      }

      id = R.id.text_chat_name;
      CustomTextView textChatName = ViewBindings.findChildViewById(rootView, id);
      if (textChatName == null) {
        break missingId;
      }

      id = R.id.text_invite;
      CustomTextView textInvite = ViewBindings.findChildViewById(rootView, id);
      if (textInvite == null) {
        break missingId;
      }

      id = R.id.text_user_status;
      CustomTextView textUserStatus = ViewBindings.findChildViewById(rootView, id);
      if (textUserStatus == null) {
        break missingId;
      }

      return new RowSelectContactItemBinding((LinearLayout) rootView, checkSelection, contactItem,
          contactView, emailContactIcon, header, headertext, imageChatPicture, imageTick,
          textChatName, textInvite, textUserStatus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
