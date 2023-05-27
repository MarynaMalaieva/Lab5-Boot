package com.example.lab5.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.example.lab5.dto.WayRequest
import com.example.lab5.dto.WayResponse
import com.example.lab5.svc.impl.WayServiceImpl

@RestController
@RequestMapping("/way")
class WayController(private val wayService: WayServiceImpl) {
    @PostMapping
    fun createWay(@RequestBody req: WayRequest): ResponseEntity<WayResponse> {
        val resp = wayService.createWay(req)
        return ResponseEntity(resp, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getWayById(@PathVariable id: Long): ResponseEntity<WayResponse> {
        val resp = wayService.getWayById(id)
        return ResponseEntity(resp, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateWay(@PathVariable id: Long, @RequestBody req: WayRequest): ResponseEntity<WayResponse> {
        val reps = wayService.updateWay(id, req)
        return ResponseEntity(reps, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteWay(@PathVariable id: Long): ResponseEntity<Void> {
        wayService.deleteWay(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}