// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutAnonymousCallBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatButton callOption;

  @NonNull
  public final AppCompatButton callOptionAnonymous;

  private LayoutAnonymousCallBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatButton callOption, @NonNull AppCompatButton callOptionAnonymous) {
    this.rootView = rootView;
    this.callOption = callOption;
    this.callOptionAnonymous = callOptionAnonymous;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutAnonymousCallBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutAnonymousCallBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_anonymous_call, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutAnonymousCallBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.call_option;
      AppCompatButton callOption = ViewBindings.findChildViewById(rootView, id);
      if (callOption == null) {
        break missingId;
      }

      id = R.id.call_option_anonymous;
      AppCompatButton callOptionAnonymous = ViewBindings.findChildViewById(rootView, id);
      if (callOptionAnonymous == null) {
        break missingId;
      }

      return new LayoutAnonymousCallBinding((ConstraintLayout) rootView, callOption,
          callOptionAnonymous);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}