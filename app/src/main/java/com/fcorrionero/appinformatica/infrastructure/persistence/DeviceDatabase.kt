package com.fcorrionero.appinformatica.infrastructure.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fcorrionero.appinformatica.domain.Device
import com.fcorrionero.appinformatica.domain.DeviceRepository

@Database(entities = [Device::class], version = 1)
abstract class DeviceDatabase: RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "device-db"
    }

    abstract fun deviceDao(): DeviceRepository

}