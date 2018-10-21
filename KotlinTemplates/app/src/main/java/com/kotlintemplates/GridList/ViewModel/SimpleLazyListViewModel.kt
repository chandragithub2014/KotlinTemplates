package com.kotlintemplates.GridList.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.kotlintemplates.SimpleLazyList.Model.SimpleLazyModel
import java.util.ArrayList

class SimpleLazyListViewModel : AndroidViewModel {
    private  var mAllLists: LiveData<List<SimpleLazyModel>>
    constructor(application: Application) : super(application){
        mAllLists = getSimpleListData()
    }

/*
https://via.placeholder.com/80.png/09f/fff
https://via.placeholder.com/80.png/0ff/fff
https://via.placeholder.com/80.png/ff0000/fff
https://via.placeholder.com/80.png/ffff00/fff
https://via.placeholder.com/80.png/ff00ff/fff
https://via.placeholder.com/80.png/0000ff/fff
https://via.placeholder.com/80.png/#808080/fff
 */
    fun getSimpleListData(): LiveData<List<SimpleLazyModel>> {
        val dataList = ArrayList<SimpleLazyModel>()
        val images = arrayOf("https://via.placeholder.com/80.png/09f/fff","https://via.placeholder.com/80.png/0ff/fff",
                "https://via.placeholder.com/80.png/ff0000/fff","https://via.placeholder.com/80.png/ff0000/fff",
                "https://via.placeholder.com/80.png/ff00ff/fff","https://via.placeholder.com/80.png/0000ff/fff","https://via.placeholder.com/80.png/#808080/fff")
        val titles = arrayOf("India", "Brazil", "EEUU", "Iran", "Malaysia", "NetherLands", "Romania")

        var i = 0
        while (i < titles.size && i < images.size) {
            val temp = SimpleLazyModel(titles[i], images[i])
            /*temp.iconId = images[i]
            temp.title = titles[i]*/
            dataList.add(temp)
            i++

        }
        val data = MutableLiveData<List<SimpleLazyModel>>()
        data.value = dataList
        return data
    }

}