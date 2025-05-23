// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CircularImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ViewCreateCallLinkBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView createNewMeeting;

  @NonNull
  public final CircularImageView meetLink;

  @NonNull
  public final TextView shareLink;

  private ViewCreateCallLinkBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView createNewMeeting, @NonNull CircularImageView meetLink,
      @NonNull TextView shareLink) {
    this.rootView = rootView;
    this.createNewMeeting = createNewMeeting;
    this.meetLink = meetLink;
    this.shareLink = shareLink;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ViewCreateCallLinkBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ViewCreateCallLinkBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.view_create_call_link, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ViewCreateCallLinkBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.create_new_meeting;
      TextView createNewMeeting = ViewBindings.findChildViewById(rootView, id);
      if (createNewMeeting == null) {
        break missingId;
      }

      id = R.id.meet_link;
      CircularImageView meetLink = ViewBindings.findChildViewById(rootView, id);
      if (meetLink == null) {
        break missingId;
      }

      id = R.id.share_link;
      TextView shareLink = ViewBindings.findChildViewById(rootView, id);
      if (shareLink == null) {
        break missingId;
      }

      return new ViewCreateCallLinkBinding((ConstraintLayout) rootView, createNewMeeting, meetLink,
          shareLink);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
