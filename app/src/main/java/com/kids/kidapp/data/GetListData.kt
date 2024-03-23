package com.kids.kidapp.data

import android.content.Context
import com.google.gson.Gson
import java.io.IOException

import java.io.InputStream




class GetListData(context: Context) {
    private var context: Context? = null

    init {
        this.context = context
    }


    fun getData() :List<ListData>{
        val dataList = mutableListOf<ListData>()
        try {
            val inputStream: InputStream? = context?.assets?.open("data.json")
            if (inputStream != null) {
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                val json = String(buffer, Charsets.UTF_8)
                val gson = Gson()
                val statusResponse: StatusResponse = gson.fromJson(json, StatusResponse::class.java)
                dataList.addAll(statusResponse.status.data)
                println("response data:")
                // Now you can parse the JSON string
                // For example, using JSONObject or Gson
            } else {
                // Handle case where inputStream is null
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
      return dataList
    }
}