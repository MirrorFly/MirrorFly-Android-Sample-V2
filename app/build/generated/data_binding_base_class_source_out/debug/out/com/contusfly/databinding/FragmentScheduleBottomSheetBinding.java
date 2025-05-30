// Generated by view binder compiler. Do not edit!
package com.contusfly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contusfly.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentScheduleBottomSheetBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout copyLinkHolder;

  @NonNull
  public final AppCompatTextView copyLinkTxtView;

  @NonNull
  public final ImageView datePicker;

  @NonNull
  public final AppCompatTextView dateTxtView;

  @NonNull
  public final ConstraintLayout instantMeetLayout;

  @NonNull
  public final AppCompatTextView instantMeetTxtView;

  @NonNull
  public final AppCompatButton joinMeeting;

  @NonNull
  public final ImageView meetLinkCopy;

  @NonNull
  public final AppCompatTextView meetLinkTextView;

  @NonNull
  public final RelativeLayout rlScheduleMeetTime;

  @NonNull
  public final ConstraintLayout scheduleMeetSwitchLayout;

  @NonNull
  public final AppCompatButton scheduleMeetingButton;

  @NonNull
  public final AppCompatTextView scheduleMeetingTxtView;

  @NonNull
  public final View sliderTopView;

  @NonNull
  public final SwitchCompat switchEnableScheduleMeet;

  @NonNull
  public final AppCompatTextView timeTxtView;

  @NonNull
  public final View viewLineDate;

  private FragmentScheduleBottomSheetBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout copyLinkHolder, @NonNull AppCompatTextView copyLinkTxtView,
      @NonNull ImageView datePicker, @NonNull AppCompatTextView dateTxtView,
      @NonNull ConstraintLayout instantMeetLayout, @NonNull AppCompatTextView instantMeetTxtView,
      @NonNull AppCompatButton joinMeeting, @NonNull ImageView meetLinkCopy,
      @NonNull AppCompatTextView meetLinkTextView, @NonNull RelativeLayout rlScheduleMeetTime,
      @NonNull ConstraintLayout scheduleMeetSwitchLayout,
      @NonNull AppCompatButton scheduleMeetingButton,
      @NonNull AppCompatTextView scheduleMeetingTxtView, @NonNull View sliderTopView,
      @NonNull SwitchCompat switchEnableScheduleMeet, @NonNull AppCompatTextView timeTxtView,
      @NonNull View viewLineDate) {
    this.rootView = rootView;
    this.copyLinkHolder = copyLinkHolder;
    this.copyLinkTxtView = copyLinkTxtView;
    this.datePicker = datePicker;
    this.dateTxtView = dateTxtView;
    this.instantMeetLayout = instantMeetLayout;
    this.instantMeetTxtView = instantMeetTxtView;
    this.joinMeeting = joinMeeting;
    this.meetLinkCopy = meetLinkCopy;
    this.meetLinkTextView = meetLinkTextView;
    this.rlScheduleMeetTime = rlScheduleMeetTime;
    this.scheduleMeetSwitchLayout = scheduleMeetSwitchLayout;
    this.scheduleMeetingButton = scheduleMeetingButton;
    this.scheduleMeetingTxtView = scheduleMeetingTxtView;
    this.sliderTopView = sliderTopView;
    this.switchEnableScheduleMeet = switchEnableScheduleMeet;
    this.timeTxtView = timeTxtView;
    this.viewLineDate = viewLineDate;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentScheduleBottomSheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentScheduleBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_schedule_bottom_sheet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentScheduleBottomSheetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.copy_link_holder;
      ConstraintLayout copyLinkHolder = ViewBindings.findChildViewById(rootView, id);
      if (copyLinkHolder == null) {
        break missingId;
      }

      id = R.id.copy_link_txt_view;
      AppCompatTextView copyLinkTxtView = ViewBindings.findChildViewById(rootView, id);
      if (copyLinkTxtView == null) {
        break missingId;
      }

      id = R.id.date_picker;
      ImageView datePicker = ViewBindings.findChildViewById(rootView, id);
      if (datePicker == null) {
        break missingId;
      }

      id = R.id.date_txt_view;
      AppCompatTextView dateTxtView = ViewBindings.findChildViewById(rootView, id);
      if (dateTxtView == null) {
        break missingId;
      }

      id = R.id.instant_meet_layout;
      ConstraintLayout instantMeetLayout = ViewBindings.findChildViewById(rootView, id);
      if (instantMeetLayout == null) {
        break missingId;
      }

      id = R.id.instant_meet_txt_view;
      AppCompatTextView instantMeetTxtView = ViewBindings.findChildViewById(rootView, id);
      if (instantMeetTxtView == null) {
        break missingId;
      }

      id = R.id.join_meeting;
      AppCompatButton joinMeeting = ViewBindings.findChildViewById(rootView, id);
      if (joinMeeting == null) {
        break missingId;
      }

      id = R.id.meet_link_copy;
      ImageView meetLinkCopy = ViewBindings.findChildViewById(rootView, id);
      if (meetLinkCopy == null) {
        break missingId;
      }

      id = R.id.meet_link_text_view;
      AppCompatTextView meetLinkTextView = ViewBindings.findChildViewById(rootView, id);
      if (meetLinkTextView == null) {
        break missingId;
      }

      id = R.id.rl_schedule_meet_time;
      RelativeLayout rlScheduleMeetTime = ViewBindings.findChildViewById(rootView, id);
      if (rlScheduleMeetTime == null) {
        break missingId;
      }

      id = R.id.schedule_meet_switch_layout;
      ConstraintLayout scheduleMeetSwitchLayout = ViewBindings.findChildViewById(rootView, id);
      if (scheduleMeetSwitchLayout == null) {
        break missingId;
      }

      id = R.id.schedule_meeting_button;
      AppCompatButton scheduleMeetingButton = ViewBindings.findChildViewById(rootView, id);
      if (scheduleMeetingButton == null) {
        break missingId;
      }

      id = R.id.schedule_meeting_txt_view;
      AppCompatTextView scheduleMeetingTxtView = ViewBindings.findChildViewById(rootView, id);
      if (scheduleMeetingTxtView == null) {
        break missingId;
      }

      id = R.id.slider_top_view;
      View sliderTopView = ViewBindings.findChildViewById(rootView, id);
      if (sliderTopView == null) {
        break missingId;
      }

      id = R.id.switch_enable_schedule_meet;
      SwitchCompat switchEnableScheduleMeet = ViewBindings.findChildViewById(rootView, id);
      if (switchEnableScheduleMeet == null) {
        break missingId;
      }

      id = R.id.time_txt_view;
      AppCompatTextView timeTxtView = ViewBindings.findChildViewById(rootView, id);
      if (timeTxtView == null) {
        break missingId;
      }

      id = R.id.view_line_date;
      View viewLineDate = ViewBindings.findChildViewById(rootView, id);
      if (viewLineDate == null) {
        break missingId;
      }

      return new FragmentScheduleBottomSheetBinding((ConstraintLayout) rootView, copyLinkHolder,
          copyLinkTxtView, datePicker, dateTxtView, instantMeetLayout, instantMeetTxtView,
          joinMeeting, meetLinkCopy, meetLinkTextView, rlScheduleMeetTime, scheduleMeetSwitchLayout,
          scheduleMeetingButton, scheduleMeetingTxtView, sliderTopView, switchEnableScheduleMeet,
          timeTxtView, viewLineDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
