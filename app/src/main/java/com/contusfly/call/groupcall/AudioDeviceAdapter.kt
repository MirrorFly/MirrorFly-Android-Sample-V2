package com.contusfly.call.groupcall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.contusfly.R

class AudioDeviceAdapter(
    context: Context,
    private val devices: Array<String>,
    private var selectedDevice: String
) : ArrayAdapter<String>(context, R.layout.layout_audio_device_list, devices) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.layout_audio_device_list, parent, false)
        val deviceName = view.findViewById<TextView>(R.id.device_name)
        val tickIcon = view.findViewById<ImageView>(R.id.tick_icon)

        deviceName.text = devices[position]
        tickIcon.visibility = if (devices[position] == selectedDevice) View.VISIBLE else View.GONE

        return view
    }

    fun updateSelection(newSelectedDevice: String) {
        selectedDevice = newSelectedDevice
        notifyDataSetChanged()
    }
}
