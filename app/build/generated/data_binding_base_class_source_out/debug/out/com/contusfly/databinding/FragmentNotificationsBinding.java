// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentNotificationsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imageNotificationAlert;

  @NonNull
  public final ImageView imageNotificationPermission;

  @NonNull
  public final ImageView imageNotificationTone;

  @NonNull
  public final RelativeLayout layoutNotificationAlert;

  @NonNull
  public final RelativeLayout layoutNotificationPermission;

  @NonNull
  public final RelativeLayout layoutNotificationTone;

  @NonNull
  public final CustomTextView notificationPermissionLabel;

  @NonNull
  public final CustomTextView notificationToneLabel;

  @NonNull
  public final CustomTextView textNotificationAlert;

  @NonNull
  public final CustomTextView textNotificationPermission;

  @NonNull
  public final CustomTextView textNotificationTone;

  private FragmentNotificationsBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView imageNotificationAlert, @NonNull ImageView imageNotificationPermission,
      @NonNull ImageView imageNotificationTone, @NonNull RelativeLayout layoutNotificationAlert,
      @NonNull RelativeLayout layoutNotificationPermission,
      @NonNull RelativeLayout layoutNotificationTone,
      @NonNull CustomTextView notificationPermissionLabel,
      @NonNull CustomTextView notificationToneLabel, @NonNull CustomTextView textNotificationAlert,
      @NonNull CustomTextView textNotificationPermission,
      @NonNull CustomTextView textNotificationTone) {
    this.rootView = rootView;
    this.imageNotificationAlert = imageNotificationAlert;
    this.imageNotificationPermission = imageNotificationPermission;
    this.imageNotificationTone = imageNotificationTone;
    this.layoutNotificationAlert = layoutNotificationAlert;
    this.layoutNotificationPermission = layoutNotificationPermission;
    this.layoutNotificationTone = layoutNotificationTone;
    this.notificationPermissionLabel = notificationPermissionLabel;
    this.notificationToneLabel = notificationToneLabel;
    this.textNotificationAlert = textNotificationAlert;
    this.textNotificationPermission = textNotificationPermission;
    this.textNotificationTone = textNotificationTone;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentNotificationsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentNotificationsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_notifications, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentNotificationsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image_notification_alert;
      ImageView imageNotificationAlert = ViewBindings.findChildViewById(rootView, id);
      if (imageNotificationAlert == null) {
        break missingId;
      }

      id = R.id.image_notification_permission;
      ImageView imageNotificationPermission = ViewBindings.findChildViewById(rootView, id);
      if (imageNotificationPermission == null) {
        break missingId;
      }

      id = R.id.image_notification_tone;
      ImageView imageNotificationTone = ViewBindings.findChildViewById(rootView, id);
      if (imageNotificationTone == null) {
        break missingId;
      }

      id = R.id.layout_notification_alert;
      RelativeLayout layoutNotificationAlert = ViewBindings.findChildViewById(rootView, id);
      if (layoutNotificationAlert == null) {
        break missingId;
      }

      id = R.id.layout_notification_permission;
      RelativeLayout layoutNotificationPermission = ViewBindings.findChildViewById(rootView, id);
      if (layoutNotificationPermission == null) {
        break missingId;
      }

      id = R.id.layout_notification_tone;
      RelativeLayout layoutNotificationTone = ViewBindings.findChildViewById(rootView, id);
      if (layoutNotificationTone == null) {
        break missingId;
      }

      id = R.id.notification_permission_label;
      CustomTextView notificationPermissionLabel = ViewBindings.findChildViewById(rootView, id);
      if (notificationPermissionLabel == null) {
        break missingId;
      }

      id = R.id.notification_tone_label;
      CustomTextView notificationToneLabel = ViewBindings.findChildViewById(rootView, id);
      if (notificationToneLabel == null) {
        break missingId;
      }

      id = R.id.text_notification_alert;
      CustomTextView textNotificationAlert = ViewBindings.findChildViewById(rootView, id);
      if (textNotificationAlert == null) {
        break missingId;
      }

      id = R.id.text_notification_permission;
      CustomTextView textNotificationPermission = ViewBindings.findChildViewById(rootView, id);
      if (textNotificationPermission == null) {
        break missingId;
      }

      id = R.id.text_notification_tone;
      CustomTextView textNotificationTone = ViewBindings.findChildViewById(rootView, id);
      if (textNotificationTone == null) {
        break missingId;
      }

      return new FragmentNotificationsBinding((LinearLayout) rootView, imageNotificationAlert,
          imageNotificationPermission, imageNotificationTone, layoutNotificationAlert,
          layoutNotificationPermission, layoutNotificationTone, notificationPermissionLabel,
          notificationToneLabel, textNotificationAlert, textNotificationPermission,
          textNotificationTone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}