// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomRecyclerView;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityNewContactsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton buttonMakeCall;

  @NonNull
  public final ViewEmptyDataBinding emptyList;

  @NonNull
  public final ViewNoContactsBinding noContactsView;

  @NonNull
  public final ProgressBar progressSpinner;

  @NonNull
  public final SwipeRefreshLayout swipeToRefreshLayout;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final CustomRecyclerView viewListContacts;

  private ActivityNewContactsBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton buttonMakeCall, @NonNull ViewEmptyDataBinding emptyList,
      @NonNull ViewNoContactsBinding noContactsView, @NonNull ProgressBar progressSpinner,
      @NonNull SwipeRefreshLayout swipeToRefreshLayout, @NonNull Toolbar toolbar,
      @NonNull CustomRecyclerView viewListContacts) {
    this.rootView = rootView;
    this.buttonMakeCall = buttonMakeCall;
    this.emptyList = emptyList;
    this.noContactsView = noContactsView;
    this.progressSpinner = progressSpinner;
    this.swipeToRefreshLayout = swipeToRefreshLayout;
    this.toolbar = toolbar;
    this.viewListContacts = viewListContacts;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityNewContactsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityNewContactsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_new_contacts, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityNewContactsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_make_call;
      MaterialButton buttonMakeCall = ViewBindings.findChildViewById(rootView, id);
      if (buttonMakeCall == null) {
        break missingId;
      }

      id = R.id.empty_list;
      View emptyList = ViewBindings.findChildViewById(rootView, id);
      if (emptyList == null) {
        break missingId;
      }
      ViewEmptyDataBinding binding_emptyList = ViewEmptyDataBinding.bind(emptyList);

      id = R.id.no_contacts_view;
      View noContactsView = ViewBindings.findChildViewById(rootView, id);
      if (noContactsView == null) {
        break missingId;
      }
      ViewNoContactsBinding binding_noContactsView = ViewNoContactsBinding.bind(noContactsView);

      id = R.id.progress_spinner;
      ProgressBar progressSpinner = ViewBindings.findChildViewById(rootView, id);
      if (progressSpinner == null) {
        break missingId;
      }

      id = R.id.swipe_to_refresh_layout;
      SwipeRefreshLayout swipeToRefreshLayout = ViewBindings.findChildViewById(rootView, id);
      if (swipeToRefreshLayout == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.view_list_contacts;
      CustomRecyclerView viewListContacts = ViewBindings.findChildViewById(rootView, id);
      if (viewListContacts == null) {
        break missingId;
      }

      return new ActivityNewContactsBinding((ConstraintLayout) rootView, buttonMakeCall,
          binding_emptyList, binding_noContactsView, progressSpinner, swipeToRefreshLayout, toolbar,
          viewListContacts);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}