// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ChatTagListItemLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CustomTextView addView;

  @NonNull
  public final CustomTextView chatTagInformationTv;

  @NonNull
  public final CustomTextView chatTagNameTv;

  @NonNull
  public final LinearLayout parentView;

  @NonNull
  public final ImageView rightArrowIcon;

  private ChatTagListItemLayoutBinding(@NonNull LinearLayout rootView,
      @NonNull CustomTextView addView, @NonNull CustomTextView chatTagInformationTv,
      @NonNull CustomTextView chatTagNameTv, @NonNull LinearLayout parentView,
      @NonNull ImageView rightArrowIcon) {
    this.rootView = rootView;
    this.addView = addView;
    this.chatTagInformationTv = chatTagInformationTv;
    this.chatTagNameTv = chatTagNameTv;
    this.parentView = parentView;
    this.rightArrowIcon = rightArrowIcon;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ChatTagListItemLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ChatTagListItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.chat_tag_list_item_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ChatTagListItemLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_view;
      CustomTextView addView = ViewBindings.findChildViewById(rootView, id);
      if (addView == null) {
        break missingId;
      }

      id = R.id.chat_tag_information_tv;
      CustomTextView chatTagInformationTv = ViewBindings.findChildViewById(rootView, id);
      if (chatTagInformationTv == null) {
        break missingId;
      }

      id = R.id.chat_tag_name_tv;
      CustomTextView chatTagNameTv = ViewBindings.findChildViewById(rootView, id);
      if (chatTagNameTv == null) {
        break missingId;
      }

      LinearLayout parentView = (LinearLayout) rootView;

      id = R.id.right_arrow_icon;
      ImageView rightArrowIcon = ViewBindings.findChildViewById(rootView, id);
      if (rightArrowIcon == null) {
        break missingId;
      }

      return new ChatTagListItemLayoutBinding((LinearLayout) rootView, addView,
          chatTagInformationTv, chatTagNameTv, parentView, rightArrowIcon);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
