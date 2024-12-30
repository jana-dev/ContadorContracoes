/*
package com.janatavares.contadorcontracoes.domain

import com.janatavares.contadorcontracoes.data.model.Contraction

class ContractionManager {
    private val contractions = mutableListOf<Contraction>()

    fun addContraction(contraction: Contraction){
        contractions.add(contraction)
    }

    fun getLastHourContractions(): List<Contraction>{
        val currentTime = System.currentTimeMillis()
        val oneHourAgo = currentTime - (60 * 60 * 1000)
        return contractions.filter { it.startTime >= oneHourAgo }
    }

    fun getAverageDuration(): Int{
        if (contractions.isEmpty()) return 0
        return contractions.map { it.duration }.average().toInt()
    }

  */
/*  fun getFrequency(): Int {
        if (contractions.size < 2) return 0
        val timestamps = contractions.map { it.timestamp.toLong() }
        val intervals = timestamps.zipWithNext { a, b -> b - a }
        return intervals.average().toInt()
    }*//*

}*/
