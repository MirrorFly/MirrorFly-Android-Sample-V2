package com.contusfly.fragments

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.contus.call.CallConstants
import com.contusfly.BuildConfig
import com.contusfly.R
import com.contusfly.call.groupcall.OnGoingCallPreviewActivity
import com.contusfly.checkInternetAndExecute
import com.contusfly.databinding.FragmentScheduleBottomSheetBinding
import com.contusfly.getMessage
import com.contusfly.runOnUiThread
import com.contusfly.showViews
import com.contusfly.viewmodels.ChatParentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mirrorflysdk.flycall.webrtc.api.CallManager
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.views.CustomToast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ScheduleBottomSheetFragment(private val activity: Activity) : BottomSheetDialogFragment(),View.OnClickListener {

    private lateinit var binding: FragmentScheduleBottomSheetBinding
    private var meetLink = Constants.EMPTY_STRING
    private var scheduleTimeStamp:Long = 0L
    private var oldTimeStamp:Long = 0L
    private val TAG = "#schedulemeet"
    private lateinit var parentViewModel: ChatParentViewModel
    private var datePickerDialog:DatePickerDialog?=null
    private var timePickerDialog:TimePickerDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentViewModel = ViewModelProvider(requireActivity())[(ChatParentViewModel::class.java)]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentScheduleBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        timePickerDialog?.dismiss()
        datePickerDialog?.dismiss()
    }

    override fun getTheme(): Int {
        return R.style.ScheduleBottomSheetDialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setClickListeners()
    }

    private fun initView(){
        generateMeetLink()
        binding.switchEnableScheduleMeet.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {
                binding.dateTxtView.text = defaultDate()
                binding.timeTxtView.text = defaultTime().lowercase(Locale.getDefault())
            }
            viewVisibility(isChecked)
        }
    }

    private fun generateMeetLink(){
        requireContext().checkInternetAndExecute {
            try {
                CallManager.createMeetLink { isSuccess, _, createMeetLinkData ->
                    if (isSuccess) {
                        showViews(binding.meetLinkCopy)
                        val scheduleMeetLink = createMeetLinkData["data"] as String
                        binding.joinMeeting.isEnabled = scheduleMeetLink.isNotEmpty()
                        binding.switchEnableScheduleMeet.isEnabled = scheduleMeetLink.isNotEmpty()
                        binding.meetLinkTextView.text =
                            BuildConfig.WEB_CHAT_LOGIN + scheduleMeetLink
                        meetLink = scheduleMeetLink
                        LogMessage.d(
                            TAG,
                            "initView scheduleMeetLink: $scheduleMeetLink"
                        )
                    } else {
                        binding.switchEnableScheduleMeet.isEnabled = false
                        val errorMessage = createMeetLinkData.getMessage()
                        runOnUiThread {
                            CustomToast.show(requireContext(), errorMessage)
                        }
                        dismiss()
                        LogMessage.d(TAG, "Create ScheduleMeet Link Failed with Message $errorMessage")
                    }
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }

    private fun defaultDate():String{
        val calenderInstance = Calendar.getInstance()
        val simpleDateFormat =SimpleDateFormat("dd/MM/yyyy")
        return simpleDateFormat.format(calenderInstance.time).toString()
    }
    private fun defaultTime():String{
        val calenderInstance = Calendar.getInstance()
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        scheduleTimeStamp = calenderInstance.timeInMillis
        LogMessage.e(TAG, "default timestamp::$scheduleTimeStamp")
        return sdf.format(calenderInstance.time).toString()
    }

    private fun viewVisibility(isChecked:Boolean){
        if(isChecked) {
            binding.instantMeetLayout.visibility = View.GONE
            binding.rlScheduleMeetTime.visibility = View.VISIBLE
            binding.scheduleMeetingButton.visibility = View.VISIBLE
        }else{
            binding.instantMeetLayout.visibility = View.VISIBLE
            binding.rlScheduleMeetTime.visibility = View.GONE
            binding.scheduleMeetingButton.visibility = View.GONE
        }
    }

    private fun setClickListeners(){
        binding.scheduleMeetingButton.setOnClickListener(this)
        binding.rlScheduleMeetTime.setOnClickListener(this)
        binding.joinMeeting.setOnClickListener(this)
        binding.meetLinkCopy.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
            when(v?.id){
                R.id.schedule_meeting_button->{
                    LogMessage.e(
                        TAG,
                        "current time in minutes::" + System.currentTimeMillis() / 60000 + "schedule time in minutes is::" + scheduleTimeStamp / 60000
                    )
                    if (System.currentTimeMillis() / 60000 <= scheduleTimeStamp / 60000) {
                        parentViewModel.constructMeetMessageData(
                            scheduleTimeStamp,
                            binding.meetLinkTextView.text.toString()
                        )
                        dismiss()
                    } else {
                        CustomToast.show(context, getString(R.string.schedule_validation_text))
                    }
                }

                R.id.join_meeting->{
                    goToOngoingCallPreviewActivity(
                        context,
                        meetLink
                    )
                    dismiss()
                }

                R.id.meet_link_copy->{
                    val clipboardManager  = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clipData  = ClipData.newPlainText("text", binding.meetLinkTextView.text)
                    clipboardManager .setPrimaryClip(clipData )
                    CustomToast.show(context, context?.getString(R.string.link_copied_clipboard))
                }

                R.id.rl_schedule_meet_time->{
                    dateTimePicker()
                }
            }
    }


    private fun goToOngoingCallPreviewActivity(context: Context?,callLink: String){
        context!!.startActivity(
            Intent(context, OnGoingCallPreviewActivity::class.java).putExtra(
                CallConstants.CALL_LINK, callLink)
        )
    }

    private fun dateTimePicker(){
            val c = Calendar.getInstance()
            c.timeInMillis = scheduleTimeStamp
            val year = c[Calendar.YEAR]
            val month = c[Calendar.MONTH]
            val day = c[Calendar.DAY_OF_MONTH]
            datePickerDialog = DatePickerDialog(activity,
                { _, year, monthOfYear, dayOfMonth ->
                    updateDateText(year, monthOfYear, dayOfMonth)
                    val calenderInstance = Calendar.getInstance()
                    if (oldTimeStamp > 0L)
                        calenderInstance.timeInMillis = oldTimeStamp
                    var mHour = calenderInstance[Calendar.HOUR_OF_DAY]
                    var mMinute = calenderInstance[Calendar.MINUTE]
                    timePickerDialog = TimePickerDialog(activity,
                        { _, hourOfDay, minute ->
                            updateTimeText(hourOfDay,minute)
                    },
                        mHour,
                        mMinute,
                        false
                    )
                    timePickerDialog?.show()
                },
                year,
                month,
                day
            )
        datePickerDialog?.datePicker?.minDate = System.currentTimeMillis()
        datePickerDialog?.show()
    }

    private fun updateDateText(year:Int,month:Int,day:Int){
        val datePick = Calendar.getInstance()
        datePick.set(Calendar.YEAR, year)
        datePick.set(Calendar.MONTH, month)
        datePick.set(Calendar.DAY_OF_MONTH, day)
        scheduleTimeStamp = datePick.timeInMillis
        LogMessage.e(TAG, "selected date timestamp::$scheduleTimeStamp")
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
        val dateTime = simpleDateFormat.format(datePick.time).toString()
        binding.dateTxtView.text = dateTime
        if(oldTimeStamp>0L) {
            datePick.timeInMillis = oldTimeStamp
            updateTimeText(datePick[Calendar.HOUR_OF_DAY], datePick[Calendar.MINUTE])
        }
    }

    private fun updateTimeText(hour:Int,minute:Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        combinedTimeStamp(calendar.timeInMillis, scheduleTimeStamp)
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val formattedTime = sdf.format(calendar.time)
        binding.timeTxtView.text = formattedTime.lowercase(Locale.getDefault())
    }

    private fun combinedTimeStamp(defaultTimeStamp: Long, selectedDateTimeStamp: Long) {

// Create Calendar instances for both timestamps
        val calendarDefaultTimeStamp = Calendar.getInstance()
        calendarDefaultTimeStamp.timeInMillis = defaultTimeStamp

        val calendarSelectedDateTimeStamp = Calendar.getInstance()
        calendarSelectedDateTimeStamp.timeInMillis = selectedDateTimeStamp

// Extract time components from defaultTimeStamp
        val hour = calendarDefaultTimeStamp[Calendar.HOUR_OF_DAY]
        val minute = calendarDefaultTimeStamp[Calendar.MINUTE]
        val second = calendarDefaultTimeStamp[Calendar.SECOND]

// Extract date components from selectedDateTimeStamp
        val year = calendarSelectedDateTimeStamp[Calendar.YEAR]
        val month = calendarSelectedDateTimeStamp[Calendar.MONTH]
        val dayOfMonth = calendarSelectedDateTimeStamp[Calendar.DAY_OF_MONTH]

// Create a new Calendar instance for the combined timestamp
        val combinedCalendar = Calendar.getInstance()
        combinedCalendar.set(year, month, dayOfMonth, hour, minute, second)

// Obtain the combined timestamp
        val combinedTimestamp = combinedCalendar.timeInMillis
        scheduleTimeStamp = combinedTimestamp
        oldTimeStamp = combinedTimestamp
        LogMessage.e(TAG,
            "compare defaultTimeStamp and selectedDateTimeStamp::$combinedTimestamp:: old time stamp::$oldTimeStamp"
        )
    }


}