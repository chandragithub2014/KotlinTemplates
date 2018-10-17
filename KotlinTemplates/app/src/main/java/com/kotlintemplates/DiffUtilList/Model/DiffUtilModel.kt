package com.kotlintemplates.DiffUtilList.Model

import java.util.*

data class DiffUtilModel(var firstName:String,var lastName:String,var group:String,var registrationId:String){
    constructor() : this("", "","","")


    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val diUtilModel = o as DiffUtilModel?
        return firstName == diUtilModel!!.firstName &&
                lastName == diUtilModel!!.lastName &&
                group == diUtilModel!!.group  &&
                registrationId==diUtilModel!!.registrationId
    }

    override fun hashCode(): Int {

        return Objects.hash(firstName, lastName, group,registrationId)
    }
}