// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import com.contusfly.views.CustomNumericKeyboard;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPinBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatTextView enterPinTextview;

  @NonNull
  public final AppCompatImageView filledPin1;

  @NonNull
  public final AppCompatImageView filledPin2;

  @NonNull
  public final AppCompatImageView filledPin3;

  @NonNull
  public final AppCompatImageView filledPin4;

  @NonNull
  public final AppCompatTextView forgotPin;

  @NonNull
  public final CustomNumericKeyboard keyboardNumeric;

  @NonNull
  public final AppCompatImageView logo;

  @NonNull
  public final AppCompatImageView pin1;

  @NonNull
  public final AppCompatImageView pin2;

  @NonNull
  public final AppCompatImageView pin3;

  @NonNull
  public final AppCompatImageView pin4;

  @NonNull
  public final AppCompatEditText pinEditText;

  @NonNull
  public final LinearLayout pinLayout;

  private ActivityPinBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatTextView enterPinTextview, @NonNull AppCompatImageView filledPin1,
      @NonNull AppCompatImageView filledPin2, @NonNull AppCompatImageView filledPin3,
      @NonNull AppCompatImageView filledPin4, @NonNull AppCompatTextView forgotPin,
      @NonNull CustomNumericKeyboard keyboardNumeric, @NonNull AppCompatImageView logo,
      @NonNull AppCompatImageView pin1, @NonNull AppCompatImageView pin2,
      @NonNull AppCompatImageView pin3, @NonNull AppCompatImageView pin4,
      @NonNull AppCompatEditText pinEditText, @NonNull LinearLayout pinLayout) {
    this.rootView = rootView;
    this.enterPinTextview = enterPinTextview;
    this.filledPin1 = filledPin1;
    this.filledPin2 = filledPin2;
    this.filledPin3 = filledPin3;
    this.filledPin4 = filledPin4;
    this.forgotPin = forgotPin;
    this.keyboardNumeric = keyboardNumeric;
    this.logo = logo;
    this.pin1 = pin1;
    this.pin2 = pin2;
    this.pin3 = pin3;
    this.pin4 = pin4;
    this.pinEditText = pinEditText;
    this.pinLayout = pinLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPinBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_pin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPinBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.enter_pin_textview;
      AppCompatTextView enterPinTextview = ViewBindings.findChildViewById(rootView, id);
      if (enterPinTextview == null) {
        break missingId;
      }

      id = R.id.filled_pin1;
      AppCompatImageView filledPin1 = ViewBindings.findChildViewById(rootView, id);
      if (filledPin1 == null) {
        break missingId;
      }

      id = R.id.filled_pin2;
      AppCompatImageView filledPin2 = ViewBindings.findChildViewById(rootView, id);
      if (filledPin2 == null) {
        break missingId;
      }

      id = R.id.filled_pin3;
      AppCompatImageView filledPin3 = ViewBindings.findChildViewById(rootView, id);
      if (filledPin3 == null) {
        break missingId;
      }

      id = R.id.filled_pin4;
      AppCompatImageView filledPin4 = ViewBindings.findChildViewById(rootView, id);
      if (filledPin4 == null) {
        break missingId;
      }

      id = R.id.forgot_pin;
      AppCompatTextView forgotPin = ViewBindings.findChildViewById(rootView, id);
      if (forgotPin == null) {
        break missingId;
      }

      id = R.id.keyboard_numeric;
      CustomNumericKeyboard keyboardNumeric = ViewBindings.findChildViewById(rootView, id);
      if (keyboardNumeric == null) {
        break missingId;
      }

      id = R.id.logo;
      AppCompatImageView logo = ViewBindings.findChildViewById(rootView, id);
      if (logo == null) {
        break missingId;
      }

      id = R.id.pin_1;
      AppCompatImageView pin1 = ViewBindings.findChildViewById(rootView, id);
      if (pin1 == null) {
        break missingId;
      }

      id = R.id.pin_2;
      AppCompatImageView pin2 = ViewBindings.findChildViewById(rootView, id);
      if (pin2 == null) {
        break missingId;
      }

      id = R.id.pin_3;
      AppCompatImageView pin3 = ViewBindings.findChildViewById(rootView, id);
      if (pin3 == null) {
        break missingId;
      }

      id = R.id.pin_4;
      AppCompatImageView pin4 = ViewBindings.findChildViewById(rootView, id);
      if (pin4 == null) {
        break missingId;
      }

      id = R.id.pin_edit_text;
      AppCompatEditText pinEditText = ViewBindings.findChildViewById(rootView, id);
      if (pinEditText == null) {
        break missingId;
      }

      id = R.id.pin_layout;
      LinearLayout pinLayout = ViewBindings.findChildViewById(rootView, id);
      if (pinLayout == null) {
        break missingId;
      }

      return new ActivityPinBinding((ConstraintLayout) rootView, enterPinTextview, filledPin1,
          filledPin2, filledPin3, filledPin4, forgotPin, keyboardNumeric, logo, pin1, pin2, pin3,
          pin4, pinEditText, pinLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}