package com.hgm.sensorguide.di

import android.app.Application
import com.hgm.sensorguide.sensor.LightSensor
import com.hgm.sensorguide.sensor.MeasurableSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

      @Provides
      @Singleton
      fun provideLightSensor(app: Application): MeasurableSensor {
            return LightSensor(app)
      }
}