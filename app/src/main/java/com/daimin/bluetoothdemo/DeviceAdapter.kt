package com.daimin.bluetoothdemo

import android.bluetooth.BluetoothDevice
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DeviceAdapter : RecyclerView.Adapter<DeviceAdapter.ViewHolder>() {
    private val devices: List<BluetoothDevice>

    init {
        devices = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_device, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val device = devices[position]
//        holder.deviceName.text = device.name

        // 在这里添加连接和断开设备的按钮点击事件处理逻辑
    }

    override fun getItemCount(): Int {
        return devices.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var deviceName: TextView
        private var btnConnect: Button
        private var btnDisconnect: Button

        init {
            deviceName = itemView.findViewById(R.id.deviceName)
            btnConnect = itemView.findViewById(R.id.btnConnect)
            btnDisconnect = itemView.findViewById(R.id.btnDisconnect)
        }
    }
}
