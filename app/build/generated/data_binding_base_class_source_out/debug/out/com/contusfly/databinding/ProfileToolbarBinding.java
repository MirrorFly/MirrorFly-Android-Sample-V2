// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProfileToolbarBinding implements ViewBinding {
  @NonNull
  private final Toolbar rootView;

  @NonNull
  public final TextView profile;

  @NonNull
  public final Toolbar toolbar;

  private ProfileToolbarBinding(@NonNull Toolbar rootView, @NonNull TextView profile,
      @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.profile = profile;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public Toolbar getRoot() {
    return rootView;
  }

  @NonNull
  public static ProfileToolbarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProfileToolbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.profile_toolbar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProfileToolbarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.profile;
      TextView profile = ViewBindings.findChildViewById(rootView, id);
      if (profile == null) {
        break missingId;
      }

      Toolbar toolbar = (Toolbar) rootView;

      return new ProfileToolbarBinding((Toolbar) rootView, profile, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
