// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.contusfly.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ViewDownloadBinding implements ViewBinding {
  @NonNull
  private final AppCompatTextView rootView;

  @NonNull
  public final AppCompatTextView textFileSize;

  private ViewDownloadBinding(@NonNull AppCompatTextView rootView,
      @NonNull AppCompatTextView textFileSize) {
    this.rootView = rootView;
    this.textFileSize = textFileSize;
  }

  @Override
  @NonNull
  public AppCompatTextView getRoot() {
    return rootView;
  }

  @NonNull
  public static ViewDownloadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ViewDownloadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.view_download, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ViewDownloadBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    AppCompatTextView textFileSize = (AppCompatTextView) rootView;

    return new ViewDownloadBinding((AppCompatTextView) rootView, textFileSize);
  }
}
