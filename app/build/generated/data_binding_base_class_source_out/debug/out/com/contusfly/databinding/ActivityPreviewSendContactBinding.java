// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomRecyclerView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPreviewSendContactBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final AppCompatImageView buttonSendContact;

  @NonNull
  public final CommonToolbarBinding toolBar;

  @NonNull
  public final CustomRecyclerView viewContactList;

  private ActivityPreviewSendContactBinding(@NonNull RelativeLayout rootView,
      @NonNull AppCompatImageView buttonSendContact, @NonNull CommonToolbarBinding toolBar,
      @NonNull CustomRecyclerView viewContactList) {
    this.rootView = rootView;
    this.buttonSendContact = buttonSendContact;
    this.toolBar = toolBar;
    this.viewContactList = viewContactList;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPreviewSendContactBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPreviewSendContactBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_preview_send_contact, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPreviewSendContactBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_send_contact;
      AppCompatImageView buttonSendContact = ViewBindings.findChildViewById(rootView, id);
      if (buttonSendContact == null) {
        break missingId;
      }

      id = R.id.tool_bar;
      View toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }
      CommonToolbarBinding binding_toolBar = CommonToolbarBinding.bind(toolBar);

      id = R.id.view_contact_list;
      CustomRecyclerView viewContactList = ViewBindings.findChildViewById(rootView, id);
      if (viewContactList == null) {
        break missingId;
      }

      return new ActivityPreviewSendContactBinding((RelativeLayout) rootView, buttonSendContact,
          binding_toolBar, viewContactList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}