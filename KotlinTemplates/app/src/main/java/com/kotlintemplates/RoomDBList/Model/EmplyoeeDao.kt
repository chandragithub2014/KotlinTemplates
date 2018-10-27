package com.kotlintemplates.RoomDBList.Model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface EmplyoeeDao {

    @Query("SELECT * from EmpDetails")
    fun getAllEmployeeDetails(): LiveData<List<EmployeeEntity>>

    @Insert(onConflict = REPLACE)
    fun insert(employeeEntity: EmployeeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun    insertEmps(resultModel: List<EmployeeEntity>)

    @Query("DELETE from EmpDetails")
    fun deleteAll()

}