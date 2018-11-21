package com.kotlintemplates.RoomDBList.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "EmpDetails")

data class EmployeeEntity(
        @PrimaryKey(autoGenerate = true) var id:Long?,
        @ColumnInfo(name="empName") var empName:String,
        @ColumnInfo(name="empAge")var empAge:Int,
        @ColumnInfo(name="empCountry")var empCountry:String
  )
{

    @Ignore   constructor():this(null,"",0,"")
}