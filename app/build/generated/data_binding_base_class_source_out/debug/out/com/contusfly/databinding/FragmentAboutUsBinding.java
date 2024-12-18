// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAboutUsBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final CustomTextView textCallOne;

  @NonNull
  public final CustomTextView textCallTwo;

  @NonNull
  public final CustomTextView textLink;

  @NonNull
  public final CustomTextView textMail;

  private FragmentAboutUsBinding(@NonNull ScrollView rootView, @NonNull CustomTextView textCallOne,
      @NonNull CustomTextView textCallTwo, @NonNull CustomTextView textLink,
      @NonNull CustomTextView textMail) {
    this.rootView = rootView;
    this.textCallOne = textCallOne;
    this.textCallTwo = textCallTwo;
    this.textLink = textLink;
    this.textMail = textMail;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAboutUsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAboutUsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_about_us, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAboutUsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.text_call_one;
      CustomTextView textCallOne = ViewBindings.findChildViewById(rootView, id);
      if (textCallOne == null) {
        break missingId;
      }

      id = R.id.text_call_two;
      CustomTextView textCallTwo = ViewBindings.findChildViewById(rootView, id);
      if (textCallTwo == null) {
        break missingId;
      }

      id = R.id.text_link;
      CustomTextView textLink = ViewBindings.findChildViewById(rootView, id);
      if (textLink == null) {
        break missingId;
      }

      id = R.id.text_mail;
      CustomTextView textMail = ViewBindings.findChildViewById(rootView, id);
      if (textMail == null) {
        break missingId;
      }

      return new FragmentAboutUsBinding((ScrollView) rootView, textCallOne, textCallTwo, textLink,
          textMail);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
