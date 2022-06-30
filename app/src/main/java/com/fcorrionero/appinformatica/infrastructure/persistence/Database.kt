package com.fcorrionero.appinformatica.infrastructure.persistence

import androidx.room.Database
import com.fcorrionero.appinformatica.domain.Device
import com.fcorrionero.appinformatica.domain.DeviceRepository

@Database(entities = [Device::class], version = 1)
abstract class Database {

    abstract fun deviceDao(): DeviceRepository

}