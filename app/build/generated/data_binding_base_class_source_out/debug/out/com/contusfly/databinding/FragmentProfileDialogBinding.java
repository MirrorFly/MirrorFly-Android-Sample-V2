// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.RoundedCornerLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProfileDialogBinding implements ViewBinding {
  @NonNull
  private final RoundedCornerLayout rootView;

  @NonNull
  public final ImageView audioCall;

  @NonNull
  public final LinearLayout audioCallLinearlayout;

  @NonNull
  public final LinearLayout infoLinearlayout;

  @NonNull
  public final ImageView openChatView;

  @NonNull
  public final ImageView openUserProfile;

  @NonNull
  public final TextView userName;

  @NonNull
  public final FrameLayout userProfileImageLayout;

  @NonNull
  public final ImageView userProfileImageViewer;

  @NonNull
  public final ImageView videoCall;

  @NonNull
  public final LinearLayout videoCallLinearlayout;

  private FragmentProfileDialogBinding(@NonNull RoundedCornerLayout rootView,
      @NonNull ImageView audioCall, @NonNull LinearLayout audioCallLinearlayout,
      @NonNull LinearLayout infoLinearlayout, @NonNull ImageView openChatView,
      @NonNull ImageView openUserProfile, @NonNull TextView userName,
      @NonNull FrameLayout userProfileImageLayout, @NonNull ImageView userProfileImageViewer,
      @NonNull ImageView videoCall, @NonNull LinearLayout videoCallLinearlayout) {
    this.rootView = rootView;
    this.audioCall = audioCall;
    this.audioCallLinearlayout = audioCallLinearlayout;
    this.infoLinearlayout = infoLinearlayout;
    this.openChatView = openChatView;
    this.openUserProfile = openUserProfile;
    this.userName = userName;
    this.userProfileImageLayout = userProfileImageLayout;
    this.userProfileImageViewer = userProfileImageViewer;
    this.videoCall = videoCall;
    this.videoCallLinearlayout = videoCallLinearlayout;
  }

  @Override
  @NonNull
  public RoundedCornerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProfileDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProfileDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_profile_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProfileDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.audio_call;
      ImageView audioCall = ViewBindings.findChildViewById(rootView, id);
      if (audioCall == null) {
        break missingId;
      }

      id = R.id.audio_call_linearlayout;
      LinearLayout audioCallLinearlayout = ViewBindings.findChildViewById(rootView, id);
      if (audioCallLinearlayout == null) {
        break missingId;
      }

      id = R.id.info_linearlayout;
      LinearLayout infoLinearlayout = ViewBindings.findChildViewById(rootView, id);
      if (infoLinearlayout == null) {
        break missingId;
      }

      id = R.id.open_chat_view;
      ImageView openChatView = ViewBindings.findChildViewById(rootView, id);
      if (openChatView == null) {
        break missingId;
      }

      id = R.id.open_user_profile;
      ImageView openUserProfile = ViewBindings.findChildViewById(rootView, id);
      if (openUserProfile == null) {
        break missingId;
      }

      id = R.id.user_name;
      TextView userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      id = R.id.user_profile_image_layout;
      FrameLayout userProfileImageLayout = ViewBindings.findChildViewById(rootView, id);
      if (userProfileImageLayout == null) {
        break missingId;
      }

      id = R.id.user_profile_image_viewer;
      ImageView userProfileImageViewer = ViewBindings.findChildViewById(rootView, id);
      if (userProfileImageViewer == null) {
        break missingId;
      }

      id = R.id.video_call;
      ImageView videoCall = ViewBindings.findChildViewById(rootView, id);
      if (videoCall == null) {
        break missingId;
      }

      id = R.id.video_call_linearlayout;
      LinearLayout videoCallLinearlayout = ViewBindings.findChildViewById(rootView, id);
      if (videoCallLinearlayout == null) {
        break missingId;
      }

      return new FragmentProfileDialogBinding((RoundedCornerLayout) rootView, audioCall,
          audioCallLinearlayout, infoLinearlayout, openChatView, openUserProfile, userName,
          userProfileImageLayout, userProfileImageViewer, videoCall, videoCallLinearlayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}