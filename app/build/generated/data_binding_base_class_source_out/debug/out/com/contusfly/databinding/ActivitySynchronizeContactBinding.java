// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySynchronizeContactBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline guidelineBottom;

  @NonNull
  public final Guideline guidelineMiddle;

  @NonNull
  public final Guideline guidelineTop;

  @NonNull
  public final ImageView imageContactSync;

  @NonNull
  public final ProgressBar imageContactSyncLoader;

  @NonNull
  public final CustomTextView textContactSync;

  @NonNull
  public final CustomTextView welcomeMessageTextView;

  private ActivitySynchronizeContactBinding(@NonNull ConstraintLayout rootView,
      @NonNull Guideline guidelineBottom, @NonNull Guideline guidelineMiddle,
      @NonNull Guideline guidelineTop, @NonNull ImageView imageContactSync,
      @NonNull ProgressBar imageContactSyncLoader, @NonNull CustomTextView textContactSync,
      @NonNull CustomTextView welcomeMessageTextView) {
    this.rootView = rootView;
    this.guidelineBottom = guidelineBottom;
    this.guidelineMiddle = guidelineMiddle;
    this.guidelineTop = guidelineTop;
    this.imageContactSync = imageContactSync;
    this.imageContactSyncLoader = imageContactSyncLoader;
    this.textContactSync = textContactSync;
    this.welcomeMessageTextView = welcomeMessageTextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySynchronizeContactBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySynchronizeContactBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_synchronize_contact, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySynchronizeContactBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.guideline_bottom;
      Guideline guidelineBottom = ViewBindings.findChildViewById(rootView, id);
      if (guidelineBottom == null) {
        break missingId;
      }

      id = R.id.guideline_middle;
      Guideline guidelineMiddle = ViewBindings.findChildViewById(rootView, id);
      if (guidelineMiddle == null) {
        break missingId;
      }

      id = R.id.guideline_top;
      Guideline guidelineTop = ViewBindings.findChildViewById(rootView, id);
      if (guidelineTop == null) {
        break missingId;
      }

      id = R.id.image_contact_sync;
      ImageView imageContactSync = ViewBindings.findChildViewById(rootView, id);
      if (imageContactSync == null) {
        break missingId;
      }

      id = R.id.image_contact_sync_loader;
      ProgressBar imageContactSyncLoader = ViewBindings.findChildViewById(rootView, id);
      if (imageContactSyncLoader == null) {
        break missingId;
      }

      id = R.id.text_contact_sync;
      CustomTextView textContactSync = ViewBindings.findChildViewById(rootView, id);
      if (textContactSync == null) {
        break missingId;
      }

      id = R.id.welcome_message_text_view;
      CustomTextView welcomeMessageTextView = ViewBindings.findChildViewById(rootView, id);
      if (welcomeMessageTextView == null) {
        break missingId;
      }

      return new ActivitySynchronizeContactBinding((ConstraintLayout) rootView, guidelineBottom,
          guidelineMiddle, guidelineTop, imageContactSync, imageContactSyncLoader, textContactSync,
          welcomeMessageTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}