// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomEditText;
import com.contusfly.views.CustomTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileStartStatusBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ListView listStatus;

  @NonNull
  public final CustomTextView textEdit;

  @NonNull
  public final CustomEditText textEditStatus;

  @NonNull
  public final TextView textSelectStatus;

  @NonNull
  public final CommonToolbarBinding toolBar;

  private ActivityProfileStartStatusBinding(@NonNull LinearLayout rootView,
      @NonNull ListView listStatus, @NonNull CustomTextView textEdit,
      @NonNull CustomEditText textEditStatus, @NonNull TextView textSelectStatus,
      @NonNull CommonToolbarBinding toolBar) {
    this.rootView = rootView;
    this.listStatus = listStatus;
    this.textEdit = textEdit;
    this.textEditStatus = textEditStatus;
    this.textSelectStatus = textSelectStatus;
    this.toolBar = toolBar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileStartStatusBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileStartStatusBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile_start_status, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileStartStatusBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.list_status;
      ListView listStatus = ViewBindings.findChildViewById(rootView, id);
      if (listStatus == null) {
        break missingId;
      }

      id = R.id.text_edit;
      CustomTextView textEdit = ViewBindings.findChildViewById(rootView, id);
      if (textEdit == null) {
        break missingId;
      }

      id = R.id.text_edit_status;
      CustomEditText textEditStatus = ViewBindings.findChildViewById(rootView, id);
      if (textEditStatus == null) {
        break missingId;
      }

      id = R.id.text_select_status;
      TextView textSelectStatus = ViewBindings.findChildViewById(rootView, id);
      if (textSelectStatus == null) {
        break missingId;
      }

      id = R.id.tool_bar;
      View toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }
      CommonToolbarBinding binding_toolBar = CommonToolbarBinding.bind(toolBar);

      return new ActivityProfileStartStatusBinding((LinearLayout) rootView, listStatus, textEdit,
          textEditStatus, textSelectStatus, binding_toolBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
