// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CircularImageView;
import io.github.rockerhieu.emojicon.EmojiconTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListGroupUserTagItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CircularImageView imageChatPicture;

  @NonNull
  public final EmojiconTextView userChatName;

  private ListGroupUserTagItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull CircularImageView imageChatPicture, @NonNull EmojiconTextView userChatName) {
    this.rootView = rootView;
    this.imageChatPicture = imageChatPicture;
    this.userChatName = userChatName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListGroupUserTagItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListGroupUserTagItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_group_user_tag_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListGroupUserTagItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image_chat_picture;
      CircularImageView imageChatPicture = ViewBindings.findChildViewById(rootView, id);
      if (imageChatPicture == null) {
        break missingId;
      }

      id = R.id.user_chat_name;
      EmojiconTextView userChatName = ViewBindings.findChildViewById(rootView, id);
      if (userChatName == null) {
        break missingId;
      }

      return new ListGroupUserTagItemBinding((ConstraintLayout) rootView, imageChatPicture,
          userChatName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
