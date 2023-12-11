package com.hgm.sensorguide.sensor

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor


/**  光线传感器  **/
class LightSensor(
      context: Context
) : AndroidSensor(
      context = context,
      sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
      sensorType = Sensor.TYPE_LIGHT
)

/**  ...传感器  **/
/**  ...传感器  **/