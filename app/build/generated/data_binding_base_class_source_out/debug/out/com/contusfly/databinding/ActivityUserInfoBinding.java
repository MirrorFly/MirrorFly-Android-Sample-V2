// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.collapsingToolbar.CollapsingToolbarLayout;
import com.contusfly.views.CustomTextView;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityUserInfoBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final CollapsingToolbarLayout collapsingToolbar;

  @NonNull
  public final CoordinatorLayout coordinatorLayout;

  @NonNull
  public final View emailDivider;

  @NonNull
  public final CustomTextView emailText;

  @NonNull
  public final CustomTextView emailTitle;

  @NonNull
  public final RelativeLayout groupMute;

  @NonNull
  public final View mobileNumberDivider;

  @NonNull
  public final CustomTextView mobileNumberText;

  @NonNull
  public final CustomTextView mobileNumberTitle;

  @NonNull
  public final View muteDivider;

  @NonNull
  public final SwitchCompat muteSwitch;

  @NonNull
  public final CustomTextView muteTitle;

  @NonNull
  public final NestedScrollView nestedScrollView;

  @NonNull
  public final PrivateChatToggleLayoutBinding privateChatView;

  @NonNull
  public final ImageView profileImage;

  @NonNull
  public final CustomTextView reportUser;

  @NonNull
  public final View statusDivider;

  @NonNull
  public final CustomTextView statusText;

  @NonNull
  public final CustomTextView statusTitle;

  @NonNull
  public final CustomTextView subTitle;

  @NonNull
  public final CustomTextView textMedia;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final View viewAllMediaDivider;

  private ActivityUserInfoBinding(@NonNull CoordinatorLayout rootView,
      @NonNull AppBarLayout appBarLayout, @NonNull CollapsingToolbarLayout collapsingToolbar,
      @NonNull CoordinatorLayout coordinatorLayout, @NonNull View emailDivider,
      @NonNull CustomTextView emailText, @NonNull CustomTextView emailTitle,
      @NonNull RelativeLayout groupMute, @NonNull View mobileNumberDivider,
      @NonNull CustomTextView mobileNumberText, @NonNull CustomTextView mobileNumberTitle,
      @NonNull View muteDivider, @NonNull SwitchCompat muteSwitch,
      @NonNull CustomTextView muteTitle, @NonNull NestedScrollView nestedScrollView,
      @NonNull PrivateChatToggleLayoutBinding privateChatView, @NonNull ImageView profileImage,
      @NonNull CustomTextView reportUser, @NonNull View statusDivider,
      @NonNull CustomTextView statusText, @NonNull CustomTextView statusTitle,
      @NonNull CustomTextView subTitle, @NonNull CustomTextView textMedia, @NonNull Toolbar toolbar,
      @NonNull View viewAllMediaDivider) {
    this.rootView = rootView;
    this.appBarLayout = appBarLayout;
    this.collapsingToolbar = collapsingToolbar;
    this.coordinatorLayout = coordinatorLayout;
    this.emailDivider = emailDivider;
    this.emailText = emailText;
    this.emailTitle = emailTitle;
    this.groupMute = groupMute;
    this.mobileNumberDivider = mobileNumberDivider;
    this.mobileNumberText = mobileNumberText;
    this.mobileNumberTitle = mobileNumberTitle;
    this.muteDivider = muteDivider;
    this.muteSwitch = muteSwitch;
    this.muteTitle = muteTitle;
    this.nestedScrollView = nestedScrollView;
    this.privateChatView = privateChatView;
    this.profileImage = profileImage;
    this.reportUser = reportUser;
    this.statusDivider = statusDivider;
    this.statusText = statusText;
    this.statusTitle = statusTitle;
    this.subTitle = subTitle;
    this.textMedia = textMedia;
    this.toolbar = toolbar;
    this.viewAllMediaDivider = viewAllMediaDivider;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityUserInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityUserInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_user_info, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityUserInfoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_bar_layout;
      AppBarLayout appBarLayout = ViewBindings.findChildViewById(rootView, id);
      if (appBarLayout == null) {
        break missingId;
      }

      id = R.id.collapsing_toolbar;
      CollapsingToolbarLayout collapsingToolbar = ViewBindings.findChildViewById(rootView, id);
      if (collapsingToolbar == null) {
        break missingId;
      }

      CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView;

      id = R.id.emailDivider;
      View emailDivider = ViewBindings.findChildViewById(rootView, id);
      if (emailDivider == null) {
        break missingId;
      }

      id = R.id.emailText;
      CustomTextView emailText = ViewBindings.findChildViewById(rootView, id);
      if (emailText == null) {
        break missingId;
      }

      id = R.id.emailTitle;
      CustomTextView emailTitle = ViewBindings.findChildViewById(rootView, id);
      if (emailTitle == null) {
        break missingId;
      }

      id = R.id.group_mute;
      RelativeLayout groupMute = ViewBindings.findChildViewById(rootView, id);
      if (groupMute == null) {
        break missingId;
      }

      id = R.id.mobileNumberDivider;
      View mobileNumberDivider = ViewBindings.findChildViewById(rootView, id);
      if (mobileNumberDivider == null) {
        break missingId;
      }

      id = R.id.mobileNumberText;
      CustomTextView mobileNumberText = ViewBindings.findChildViewById(rootView, id);
      if (mobileNumberText == null) {
        break missingId;
      }

      id = R.id.mobileNumberTitle;
      CustomTextView mobileNumberTitle = ViewBindings.findChildViewById(rootView, id);
      if (mobileNumberTitle == null) {
        break missingId;
      }

      id = R.id.muteDivider;
      View muteDivider = ViewBindings.findChildViewById(rootView, id);
      if (muteDivider == null) {
        break missingId;
      }

      id = R.id.muteSwitch;
      SwitchCompat muteSwitch = ViewBindings.findChildViewById(rootView, id);
      if (muteSwitch == null) {
        break missingId;
      }

      id = R.id.muteTitle;
      CustomTextView muteTitle = ViewBindings.findChildViewById(rootView, id);
      if (muteTitle == null) {
        break missingId;
      }

      id = R.id.nestedScrollView;
      NestedScrollView nestedScrollView = ViewBindings.findChildViewById(rootView, id);
      if (nestedScrollView == null) {
        break missingId;
      }

      id = R.id.private_chat_view;
      View privateChatView = ViewBindings.findChildViewById(rootView, id);
      if (privateChatView == null) {
        break missingId;
      }
      PrivateChatToggleLayoutBinding binding_privateChatView = PrivateChatToggleLayoutBinding.bind(privateChatView);

      id = R.id.profileImage;
      ImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.report_user;
      CustomTextView reportUser = ViewBindings.findChildViewById(rootView, id);
      if (reportUser == null) {
        break missingId;
      }

      id = R.id.statusDivider;
      View statusDivider = ViewBindings.findChildViewById(rootView, id);
      if (statusDivider == null) {
        break missingId;
      }

      id = R.id.statusText;
      CustomTextView statusText = ViewBindings.findChildViewById(rootView, id);
      if (statusText == null) {
        break missingId;
      }

      id = R.id.statusTitle;
      CustomTextView statusTitle = ViewBindings.findChildViewById(rootView, id);
      if (statusTitle == null) {
        break missingId;
      }

      id = R.id.subTitle;
      CustomTextView subTitle = ViewBindings.findChildViewById(rootView, id);
      if (subTitle == null) {
        break missingId;
      }

      id = R.id.text_media;
      CustomTextView textMedia = ViewBindings.findChildViewById(rootView, id);
      if (textMedia == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.viewAllMediaDivider;
      View viewAllMediaDivider = ViewBindings.findChildViewById(rootView, id);
      if (viewAllMediaDivider == null) {
        break missingId;
      }

      return new ActivityUserInfoBinding((CoordinatorLayout) rootView, appBarLayout,
          collapsingToolbar, coordinatorLayout, emailDivider, emailText, emailTitle, groupMute,
          mobileNumberDivider, mobileNumberText, mobileNumberTitle, muteDivider, muteSwitch,
          muteTitle, nestedScrollView, binding_privateChatView, profileImage, reportUser,
          statusDivider, statusText, statusTitle, subTitle, textMedia, toolbar,
          viewAllMediaDivider);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}