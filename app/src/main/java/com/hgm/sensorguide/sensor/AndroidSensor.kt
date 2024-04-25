package com.hgm.sensorguide.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log

/**
 * @author：HGM
 * @created：2023/12/10 0010
 * @description：Android系统传感器
 **/
abstract class AndroidSensor(
      private val context: Context,
      private val sensorFeature: String,
      sensorType: Int
): MeasurableSensor(sensorType), SensorEventListener {

      // 根据外部传入的类型，检查该传感器功能是否可用
      override val hasSensorFeature: Boolean
            get() = context.packageManager.hasSystemFeature(sensorFeature)

      // 创建系统的传感器管理器
      private lateinit var sensorManager: SensorManager

      // 系统的传感器
      private var sensor: Sensor? = null

      // 开始监听
      override fun startListening() {
            if (!hasSensorFeature) {
                  Log.e("TAG", "onSensorChanged: 设备不支持该传感器" )
                  return
            }
            if (!::sensorManager.isInitialized && sensor == null) {
                  sensorManager =
                        context.getSystemService(SensorManager::class.java) as SensorManager
                  sensor = sensorManager.getDefaultSensor(sensorType)
            }

            sensor?.let { sensor ->
                  //注册监听
                  sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            }
      }

      // 停止监听
      override fun stopListening() {
            if (!hasSensorFeature && !::sensorManager.isInitialized) {
                  return
            }
            sensor?.let {
                  //移除监听
                  sensorManager.unregisterListener(this)
            }
      }

      // 传感器更改时执行
      override fun onSensorChanged(event: SensorEvent?) {
            if (!hasSensorFeature) {
                  return
            }
            if (event?.sensor?.type == sensorType) {
                  onSensorValueChanged?.invoke(event.values.toList())
            }
      }

      // 关于精度的改变，这里不需要
      override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit
}