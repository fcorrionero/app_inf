package com.fcorrionero.appinformatica.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Device(
    @PrimaryKey val uid: UUID,

    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "dni") val dni: String?,
    @ColumnInfo(name = "address") val address: String?,

    @ColumnInfo(name = "device_brand_model") val deviceBrandModel: String?,
    @ColumnInfo(name = "device_accessories") val deviceAccessories: String?,
    @ColumnInfo(name = "device_serial_imei") val deviceSerialImei: String?,

    @ColumnInfo(name = "issue_type") val issueType: String?,
    @ColumnInfo(name = "issue_solution") val issueSolution: String?,
    @ColumnInfo(name = "issue_comments") val issueComments: String?,

    @ColumnInfo(name = "budget_quantity") val budgetQuantity: Int?,
    @ColumnInfo(name = "budget_acceptation") val budgetAcceptation: Boolean?,

    @ColumnInfo(name = "created_at") val createdAt: Date?,
    @ColumnInfo(name = "updated_at") val updatedAt: Date?

    ) {
}