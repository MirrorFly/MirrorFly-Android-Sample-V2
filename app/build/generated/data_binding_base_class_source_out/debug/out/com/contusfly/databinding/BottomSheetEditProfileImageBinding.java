// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BottomSheetEditProfileImageBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView actionGallery;

  @NonNull
  public final TextView actionRemove;

  @NonNull
  public final TextView actionTake;

  @NonNull
  public final Space space;

  private BottomSheetEditProfileImageBinding(@NonNull LinearLayout rootView,
      @NonNull TextView actionGallery, @NonNull TextView actionRemove, @NonNull TextView actionTake,
      @NonNull Space space) {
    this.rootView = rootView;
    this.actionGallery = actionGallery;
    this.actionRemove = actionRemove;
    this.actionTake = actionTake;
    this.space = space;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BottomSheetEditProfileImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BottomSheetEditProfileImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bottom_sheet_edit_profile_image, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BottomSheetEditProfileImageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.action_gallery;
      TextView actionGallery = ViewBindings.findChildViewById(rootView, id);
      if (actionGallery == null) {
        break missingId;
      }

      id = R.id.action_remove;
      TextView actionRemove = ViewBindings.findChildViewById(rootView, id);
      if (actionRemove == null) {
        break missingId;
      }

      id = R.id.action_take;
      TextView actionTake = ViewBindings.findChildViewById(rootView, id);
      if (actionTake == null) {
        break missingId;
      }

      id = R.id.space;
      Space space = ViewBindings.findChildViewById(rootView, id);
      if (space == null) {
        break missingId;
      }

      return new BottomSheetEditProfileImageBinding((LinearLayout) rootView, actionGallery,
          actionRemove, actionTake, space);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}