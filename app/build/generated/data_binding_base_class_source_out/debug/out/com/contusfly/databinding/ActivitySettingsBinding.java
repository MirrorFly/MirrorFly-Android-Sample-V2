// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySettingsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CustomTextView textDone;

  @NonNull
  public final CustomTextView textTitle;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final FrameLayout viewContainer;

  private ActivitySettingsBinding(@NonNull LinearLayout rootView, @NonNull CustomTextView textDone,
      @NonNull CustomTextView textTitle, @NonNull Toolbar toolbar,
      @NonNull FrameLayout viewContainer) {
    this.rootView = rootView;
    this.textDone = textDone;
    this.textTitle = textTitle;
    this.toolbar = toolbar;
    this.viewContainer = viewContainer;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.text_done;
      CustomTextView textDone = ViewBindings.findChildViewById(rootView, id);
      if (textDone == null) {
        break missingId;
      }

      id = R.id.text_title;
      CustomTextView textTitle = ViewBindings.findChildViewById(rootView, id);
      if (textTitle == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.view_container;
      FrameLayout viewContainer = ViewBindings.findChildViewById(rootView, id);
      if (viewContainer == null) {
        break missingId;
      }

      return new ActivitySettingsBinding((LinearLayout) rootView, textDone, textTitle, toolbar,
          viewContainer);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}