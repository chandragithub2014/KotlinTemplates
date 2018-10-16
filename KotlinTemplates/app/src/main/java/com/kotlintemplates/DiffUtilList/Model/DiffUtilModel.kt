package com.kotlintemplates.DiffUtilList.Model

data class DiffUtilModel(var firstName:String,var lastName:String,var group:String,var registrationId:String){
    constructor() : this("", "","","")


    override fun equals(other: Any?): Boolean {
        if(other == null || other !is DiffUtilModel)
            return false
        return registrationId == other.registrationId && group==other.group
    }

    override fun hashCode(): Int =
            group.hashCode() * 31+registrationId.toInt()
}