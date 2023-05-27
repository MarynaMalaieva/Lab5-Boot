package com.example.lab5.svc

import com.example.lab5.dto.WayRequest
import com.example.lab5.dto.WayResponse
interface WayService {
    fun createWay(drugsRequest: WayRequest): WayResponse
    fun getWayById(id: Long): WayResponse
    fun updateWay(id: Long, drugsRequest: WayRequest): WayResponse
    fun deleteWay(id: Long): Boolean
}