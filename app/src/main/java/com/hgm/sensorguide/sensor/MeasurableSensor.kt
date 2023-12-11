package com.hgm.sensorguide.sensor

/**
 * @author：HGM
 * @created：2023/12/10 0010
 * @description：可测量的传感器
 **/
abstract class MeasurableSensor(
      protected val sensorType:Int// 传感器类型
) {
      //检测手机是否具有该传感器的功能
      abstract val hasSensorFeature: Boolean

      //开始监听
      abstract fun startListening()

      //停止监听
      abstract fun stopListening()

      //用于接收传感器更改时的值，类型为带参的函数
      protected var onSensorValueChanged: ((List<Float>) -> Unit)? = null

      //设置传感器更改监听事件
      fun setOnSensorValueChangedListening(listener: (List<Float>) -> Unit) {
            onSensorValueChanged = listener
      }
}