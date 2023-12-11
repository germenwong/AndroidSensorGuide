package com.hgm.sensorguide.sensor

/**
 * @author：HGM
 * @created：2023/12/10 0010
 * @description：可测量的传感器
 **/
abstract class MeasurableSensor(
      protected val sensorType:Int// 传感器类型
) {
      abstract val hasSensorFeature: Boolean

      abstract fun startListening()

      abstract fun stopListening()

      protected var onSensorValueChanged: ((List<Float>) -> Unit)? = null

      fun setOnSensorValueChangedListening(listener: (List<Float>) -> Unit) {
            onSensorValueChanged = listener
      }
}