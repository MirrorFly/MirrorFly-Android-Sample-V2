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
import com.contusfly.views.CustomRecyclerView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentViewAllMediaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final TextView emptyView;

  @NonNull
  public final CustomRecyclerView mediaRecyclerView;

  @NonNull
  public final ConstraintLayout progressSpinner;

  private FragmentViewAllMediaBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout constraintLayout, @NonNull TextView emptyView,
      @NonNull CustomRecyclerView mediaRecyclerView, @NonNull ConstraintLayout progressSpinner) {
    this.rootView = rootView;
    this.constraintLayout = constraintLayout;
    this.emptyView = emptyView;
    this.mediaRecyclerView = mediaRecyclerView;
    this.progressSpinner = progressSpinner;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentViewAllMediaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentViewAllMediaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_view_all_media, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentViewAllMediaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout constraintLayout = (ConstraintLayout) rootView;

      id = R.id.empty_view;
      TextView emptyView = ViewBindings.findChildViewById(rootView, id);
      if (emptyView == null) {
        break missingId;
      }

      id = R.id.media_recycler_view;
      CustomRecyclerView mediaRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (mediaRecyclerView == null) {
        break missingId;
      }

      id = R.id.progress_spinner;
      ConstraintLayout progressSpinner = ViewBindings.findChildViewById(rootView, id);
      if (progressSpinner == null) {
        break missingId;
      }

      return new FragmentViewAllMediaBinding((ConstraintLayout) rootView, constraintLayout,
          emptyView, mediaRecyclerView, progressSpinner);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}