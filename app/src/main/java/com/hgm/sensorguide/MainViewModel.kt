package com.hgm.sensorguide

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hgm.sensorguide.sensor.MeasurableSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
      // 注入最顶级的抽象类，好处在于可以灵活地对ViewModel进行单元测试
      private val lightSensor: MeasurableSensor
) : ViewModel() {

      var isDark by mutableStateOf(false)
            private set

      init {
            lightSensor.startListening()
            lightSensor.setOnSensorValueChangedListening { values ->
                  // lux：代表着照明单位
                  val lux = values[0]
                  isDark = lux < 60f
            }
      }
}