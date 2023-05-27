package com.example.lab5.svc

import com.example.lab5.dto.TrainRequest
import com.example.lab5.dto.TrainResponse

interface TrainService {
    fun createTrain(trainRequest: TrainRequest): TrainResponse
    fun getTrainById(id: Long): TrainResponse
    fun updateTrain(id: Long, trainRequest: TrainRequest): TrainResponse
    fun deleteTrain(id: Long): Boolean
}