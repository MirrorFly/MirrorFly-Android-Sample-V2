// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.contusfly.R;
import com.contusfly.views.CustomTextView;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ViewEmptyDataBinding implements ViewBinding {
  @NonNull
  private final CustomTextView rootView;

  @NonNull
  public final CustomTextView textEmptyView;

  private ViewEmptyDataBinding(@NonNull CustomTextView rootView,
      @NonNull CustomTextView textEmptyView) {
    this.rootView = rootView;
    this.textEmptyView = textEmptyView;
  }

  @Override
  @NonNull
  public CustomTextView getRoot() {
    return rootView;
  }

  @NonNull
  public static ViewEmptyDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ViewEmptyDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.view_empty_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ViewEmptyDataBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    CustomTextView textEmptyView = (CustomTextView) rootView;

    return new ViewEmptyDataBinding((CustomTextView) rootView, textEmptyView);
  }
}
