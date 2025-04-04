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

public final class RowStatusBinding implements ViewBinding {
  @NonNull
  private final CustomTextView rootView;

  @NonNull
  public final CustomTextView rowTextView;

  private RowStatusBinding(@NonNull CustomTextView rootView, @NonNull CustomTextView rowTextView) {
    this.rootView = rootView;
    this.rowTextView = rowTextView;
  }

  @Override
  @NonNull
  public CustomTextView getRoot() {
    return rootView;
  }

  @NonNull
  public static RowStatusBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RowStatusBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.row_status, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RowStatusBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    CustomTextView rowTextView = (CustomTextView) rootView;

    return new RowStatusBinding((CustomTextView) rootView, rowTextView);
  }
}
