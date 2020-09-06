package com.nikhil.spaceapp.feature.asteroid.util

import com.nikhil.spaceapp.feature.asteroid.dto.Asteroid
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.json.JSONObject
import timber.log.Timber

class AsteroidTransformer(
    private val anyData: String
) {

    private var asteroidList: MutableList<JSONObject> = mutableListOf()

    //TODO: Improve this logic
    fun transform(): List<Asteroid> {
        Timber.d("Response class type = ${anyData::class.java}")
        val jsonObject = JSONObject(anyData)
        val keys = jsonObject.keys()
        while (keys.hasNext()) {
            val dynamicKey = keys.next()
            if (dynamicKey == "near_earth_objects") {
                val jsonObject1 = jsonObject.getJSONObject(dynamicKey)
                val keys1 = jsonObject1.keys()
                while (keys1.hasNext()) {
                    val dynamicKey1 = keys1.next()
                    val dateData = jsonObject1.getJSONArray(dynamicKey1)
                    for (i in 0 until dateData.length()) {
                        val jsonObject2 = dateData.getJSONObject(i)
                        asteroidList.add(jsonObject2)
                    }
                }
            }
        }

        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val dataListType = newParameterizedType(List::class.java, Asteroid::class.java)
        val adapter: JsonAdapter<List<Asteroid>> = moshi.adapter(dataListType)
        val asteroidList = adapter.fromJson(asteroidList.toString())
        return asteroidList ?: emptyList()
    }
}