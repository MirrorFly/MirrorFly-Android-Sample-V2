// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

public final class ActivityOtpBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final View divider;

  @NonNull
  public final LinearLayout editNumber;

  @NonNull
  public final CustomEditText edtMobileNo;

  @NonNull
  public final OtpViewBinding edtVerifyCode;

  @NonNull
  public final LinearLayout getMobileNumberView;

  @NonNull
  public final LinearLayout getMobileNumberView2;

  @NonNull
  public final LinearLayout mobileNumber;

  @NonNull
  public final TextView otpText;

  @NonNull
  public final LinearLayout otpView;

  @NonNull
  public final View seperator;

  @NonNull
  public final ToolbarTitleCenterViewBinding toolbar;

  @NonNull
  public final CustomTextView txtChangeNumber;

  @NonNull
  public final CustomTextView txtCode;

  @NonNull
  public final CustomTextView txtCountry;

  @NonNull
  public final CustomTextView txtInfo;

  @NonNull
  public final CustomTextView txtResend;

  @NonNull
  public final TextView txtTermsAndConditions;

  @NonNull
  public final TextView txtTermsAndConditionsDescription;

  @NonNull
  public final CustomTextView viewGetOtp;

  @NonNull
  public final CustomTextView viewVerify;

  private ActivityOtpBinding(@NonNull LinearLayout rootView, @NonNull View divider,
      @NonNull LinearLayout editNumber, @NonNull CustomEditText edtMobileNo,
      @NonNull OtpViewBinding edtVerifyCode, @NonNull LinearLayout getMobileNumberView,
      @NonNull LinearLayout getMobileNumberView2, @NonNull LinearLayout mobileNumber,
      @NonNull TextView otpText, @NonNull LinearLayout otpView, @NonNull View seperator,
      @NonNull ToolbarTitleCenterViewBinding toolbar, @NonNull CustomTextView txtChangeNumber,
      @NonNull CustomTextView txtCode, @NonNull CustomTextView txtCountry,
      @NonNull CustomTextView txtInfo, @NonNull CustomTextView txtResend,
      @NonNull TextView txtTermsAndConditions, @NonNull TextView txtTermsAndConditionsDescription,
      @NonNull CustomTextView viewGetOtp, @NonNull CustomTextView viewVerify) {
    this.rootView = rootView;
    this.divider = divider;
    this.editNumber = editNumber;
    this.edtMobileNo = edtMobileNo;
    this.edtVerifyCode = edtVerifyCode;
    this.getMobileNumberView = getMobileNumberView;
    this.getMobileNumberView2 = getMobileNumberView2;
    this.mobileNumber = mobileNumber;
    this.otpText = otpText;
    this.otpView = otpView;
    this.seperator = seperator;
    this.toolbar = toolbar;
    this.txtChangeNumber = txtChangeNumber;
    this.txtCode = txtCode;
    this.txtCountry = txtCountry;
    this.txtInfo = txtInfo;
    this.txtResend = txtResend;
    this.txtTermsAndConditions = txtTermsAndConditions;
    this.txtTermsAndConditionsDescription = txtTermsAndConditionsDescription;
    this.viewGetOtp = viewGetOtp;
    this.viewVerify = viewVerify;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOtpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOtpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_otp, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOtpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.edit_number;
      LinearLayout editNumber = ViewBindings.findChildViewById(rootView, id);
      if (editNumber == null) {
        break missingId;
      }

      id = R.id.edt_mobile_no;
      CustomEditText edtMobileNo = ViewBindings.findChildViewById(rootView, id);
      if (edtMobileNo == null) {
        break missingId;
      }

      id = R.id.edt_verify_code;
      View edtVerifyCode = ViewBindings.findChildViewById(rootView, id);
      if (edtVerifyCode == null) {
        break missingId;
      }
      OtpViewBinding binding_edtVerifyCode = OtpViewBinding.bind(edtVerifyCode);

      id = R.id.get_mobile_number_view;
      LinearLayout getMobileNumberView = ViewBindings.findChildViewById(rootView, id);
      if (getMobileNumberView == null) {
        break missingId;
      }

      id = R.id.get_mobile_number_view_2;
      LinearLayout getMobileNumberView2 = ViewBindings.findChildViewById(rootView, id);
      if (getMobileNumberView2 == null) {
        break missingId;
      }

      id = R.id.mobile_number;
      LinearLayout mobileNumber = ViewBindings.findChildViewById(rootView, id);
      if (mobileNumber == null) {
        break missingId;
      }

      id = R.id.otp_text;
      TextView otpText = ViewBindings.findChildViewById(rootView, id);
      if (otpText == null) {
        break missingId;
      }

      id = R.id.otp_view;
      LinearLayout otpView = ViewBindings.findChildViewById(rootView, id);
      if (otpView == null) {
        break missingId;
      }

      id = R.id.seperator;
      View seperator = ViewBindings.findChildViewById(rootView, id);
      if (seperator == null) {
        break missingId;
      }

      id = R.id.toolbar;
      View toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }
      ToolbarTitleCenterViewBinding binding_toolbar = ToolbarTitleCenterViewBinding.bind(toolbar);

      id = R.id.txt_change_number;
      CustomTextView txtChangeNumber = ViewBindings.findChildViewById(rootView, id);
      if (txtChangeNumber == null) {
        break missingId;
      }

      id = R.id.txt_code;
      CustomTextView txtCode = ViewBindings.findChildViewById(rootView, id);
      if (txtCode == null) {
        break missingId;
      }

      id = R.id.txt_country;
      CustomTextView txtCountry = ViewBindings.findChildViewById(rootView, id);
      if (txtCountry == null) {
        break missingId;
      }

      id = R.id.txt_info;
      CustomTextView txtInfo = ViewBindings.findChildViewById(rootView, id);
      if (txtInfo == null) {
        break missingId;
      }

      id = R.id.txt_resend;
      CustomTextView txtResend = ViewBindings.findChildViewById(rootView, id);
      if (txtResend == null) {
        break missingId;
      }

      id = R.id.txt_terms_and_conditions;
      TextView txtTermsAndConditions = ViewBindings.findChildViewById(rootView, id);
      if (txtTermsAndConditions == null) {
        break missingId;
      }

      id = R.id.txt_terms_and_conditions_description;
      TextView txtTermsAndConditionsDescription = ViewBindings.findChildViewById(rootView, id);
      if (txtTermsAndConditionsDescription == null) {
        break missingId;
      }

      id = R.id.view_get_otp;
      CustomTextView viewGetOtp = ViewBindings.findChildViewById(rootView, id);
      if (viewGetOtp == null) {
        break missingId;
      }

      id = R.id.view_verify;
      CustomTextView viewVerify = ViewBindings.findChildViewById(rootView, id);
      if (viewVerify == null) {
        break missingId;
      }

      return new ActivityOtpBinding((LinearLayout) rootView, divider, editNumber, edtMobileNo,
          binding_edtVerifyCode, getMobileNumberView, getMobileNumberView2, mobileNumber, otpText,
          otpView, seperator, binding_toolbar, txtChangeNumber, txtCode, txtCountry, txtInfo,
          txtResend, txtTermsAndConditions, txtTermsAndConditionsDescription, viewGetOtp,
          viewVerify);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
