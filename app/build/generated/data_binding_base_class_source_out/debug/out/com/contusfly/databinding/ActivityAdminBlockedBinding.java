// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAdminBlockedBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatTextView adminMailAddress;

  @NonNull
  public final AppCompatImageView mirrorflyLogo;

  @NonNull
  public final AppCompatImageView userBlockedIcon;

  @NonNull
  public final AppCompatTextView userBlockedMessage;

  @NonNull
  public final AppCompatTextView userBlockedMessageLabel;

  @NonNull
  public final AppCompatTextView userOk;

  private ActivityAdminBlockedBinding(@NonNull LinearLayout rootView,
      @NonNull AppCompatTextView adminMailAddress, @NonNull AppCompatImageView mirrorflyLogo,
      @NonNull AppCompatImageView userBlockedIcon, @NonNull AppCompatTextView userBlockedMessage,
      @NonNull AppCompatTextView userBlockedMessageLabel, @NonNull AppCompatTextView userOk) {
    this.rootView = rootView;
    this.adminMailAddress = adminMailAddress;
    this.mirrorflyLogo = mirrorflyLogo;
    this.userBlockedIcon = userBlockedIcon;
    this.userBlockedMessage = userBlockedMessage;
    this.userBlockedMessageLabel = userBlockedMessageLabel;
    this.userOk = userOk;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdminBlockedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdminBlockedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_admin_blocked, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdminBlockedBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.admin_mail_address;
      AppCompatTextView adminMailAddress = ViewBindings.findChildViewById(rootView, id);
      if (adminMailAddress == null) {
        break missingId;
      }

      id = R.id.mirrorfly_logo;
      AppCompatImageView mirrorflyLogo = ViewBindings.findChildViewById(rootView, id);
      if (mirrorflyLogo == null) {
        break missingId;
      }

      id = R.id.user_blocked_icon;
      AppCompatImageView userBlockedIcon = ViewBindings.findChildViewById(rootView, id);
      if (userBlockedIcon == null) {
        break missingId;
      }

      id = R.id.user_blocked_message;
      AppCompatTextView userBlockedMessage = ViewBindings.findChildViewById(rootView, id);
      if (userBlockedMessage == null) {
        break missingId;
      }

      id = R.id.user_blocked_message_label;
      AppCompatTextView userBlockedMessageLabel = ViewBindings.findChildViewById(rootView, id);
      if (userBlockedMessageLabel == null) {
        break missingId;
      }

      id = R.id.user_ok;
      AppCompatTextView userOk = ViewBindings.findChildViewById(rootView, id);
      if (userOk == null) {
        break missingId;
      }

      return new ActivityAdminBlockedBinding((LinearLayout) rootView, adminMailAddress,
          mirrorflyLogo, userBlockedIcon, userBlockedMessage, userBlockedMessageLabel, userOk);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
