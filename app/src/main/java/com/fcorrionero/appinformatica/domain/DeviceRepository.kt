package com.fcorrionero.appinformatica.domain

import androidx.room.*
import java.util.*

@Dao
interface DeviceRepository {

    @Query("SELECT * FROM device")
    fun getAll(): List<Device>

    @Query("SELECT * FROM device WHERE uid = :uid")
    fun findOrFailById(uid: UUID): Device

    @Insert
    fun insertAll(vararg devices: Device)

    @Update
    fun updateUsers(vararg devices: Device)

    @Delete
    fun delete(device: Device)

}