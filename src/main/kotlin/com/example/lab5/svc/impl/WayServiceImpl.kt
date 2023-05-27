package com.example.lab5.svc.impl

import org.springframework.stereotype.Service
import com.example.lab5.dto.WayRequest
import com.example.lab5.dto.WayResponse
import com.example.lab5.entity.Way
import com.example.lab5.repository.WayRepository
import com.example.lab5.svc.WayService
import org.springframework.security.access.prepost.PreAuthorize

@Service
class WayServiceImpl(private val wayRepository: WayRepository) : WayService {
    @PreAuthorize("hasAuthority('EDITOR')")
    override fun createWay(wayRequest: WayRequest): WayResponse {
        val way = Way(startPoint = wayRequest.startPoint, destination = wayRequest.destination)
        val savedWay = wayRepository.save(way)
        return WayResponse.fromEntity(savedWay)
    }

    @PreAuthorize("permitAll()")
    override fun getWayById(id: Long): WayResponse {
        val drugs = wayRepository.findById(id).orElseThrow()
        return WayResponse.fromEntity(drugs)
    }

    @PreAuthorize("hasAuthority('EDITOR')")
    override fun updateWay(id: Long, drugsRequest: WayRequest): WayResponse {
        val way = wayRepository.findById(id).orElseThrow()
        way.startPoint = drugsRequest.startPoint.toString()
        way.destination = drugsRequest.destination.toString()
        val updatedWay = wayRepository.save(way)
        return WayResponse.fromEntity(updatedWay)
    }

    @PreAuthorize("hasAuthority('EDITOR')")
    override fun deleteWay(id: Long): Boolean {
        wayRepository.deleteById(id)
        return true
    }
}