package com.daimin.bluetoothdemo

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class BluetoothActivity : AppCompatActivity() {
    private var bluetoothAdapter: BluetoothAdapter? = null
    private var deviceRecyclerView: RecyclerView? = null
    private var deviceAdapter: DeviceAdapter? = null
    private val btnEnableBluetooth = findViewById<Button>(R.id.btnEnableBluetooth)
    val btnScanDevices = findViewById<Button>(R.id.btnScanDevices)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        deviceRecyclerView = findViewById(R.id.deviceRecyclerView)

        // 初始化RecyclerView和适配器

        // 初始化RecyclerView和适配器
        deviceAdapter = DeviceAdapter()
        deviceRecyclerView.setLayoutManager(LinearLayoutManager(this))
        deviceRecyclerView.setAdapter(deviceAdapter)



        initListener()
    }

    private fun initListener() {
        // 打开蓝牙
        btnEnableBluetooth.setOnClickListener {
            if (!bluetoothAdapter!!.isEnabled) {
                val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
            } else {
                Toast.makeText(this@BluetoothActivity, "蓝牙已经打开", Toast.LENGTH_SHORT).show()
            }
        }



    }
}