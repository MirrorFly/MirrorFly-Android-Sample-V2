// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomRecyclerView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCountryListBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final CommonToolbarBinding toolBar;

  @NonNull
  public final ViewEmptyDataBinding txt;

  @NonNull
  public final CustomRecyclerView viewCountryList;

  private ActivityCountryListBinding(@NonNull RelativeLayout rootView,
      @NonNull CommonToolbarBinding toolBar, @NonNull ViewEmptyDataBinding txt,
      @NonNull CustomRecyclerView viewCountryList) {
    this.rootView = rootView;
    this.toolBar = toolBar;
    this.txt = txt;
    this.viewCountryList = viewCountryList;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCountryListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCountryListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_country_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCountryListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tool_bar;
      View toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }
      CommonToolbarBinding binding_toolBar = CommonToolbarBinding.bind(toolBar);

      id = R.id.txt;
      View txt = ViewBindings.findChildViewById(rootView, id);
      if (txt == null) {
        break missingId;
      }
      ViewEmptyDataBinding binding_txt = ViewEmptyDataBinding.bind(txt);

      id = R.id.view_country_list;
      CustomRecyclerView viewCountryList = ViewBindings.findChildViewById(rootView, id);
      if (viewCountryList == null) {
        break missingId;
      }

      return new ActivityCountryListBinding((RelativeLayout) rootView, binding_toolBar, binding_txt,
          viewCountryList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}