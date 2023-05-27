package com.example.lab5.svc.impl

import org.springframework.stereotype.Service
import com.example.lab5.dto.TrainRequest
import com.example.lab5.dto.TrainResponse
import com.example.lab5.entity.Train
import com.example.lab5.repository.TrainRepository
import com.example.lab5.svc.TrainService
import org.springframework.security.access.prepost.PreAuthorize

@Service
class TrainServiceImpl(private val trainRepository: TrainRepository) : TrainService {
    @PreAuthorize("hasAuthority('EDITOR')")
    override fun createTrain(trainRequest: TrainRequest): TrainResponse {
        val train = Train(model = trainRequest.model, manufacturer = trainRequest.manufacturer)
        val savedHospital = trainRepository.save(train)
        return TrainResponse.fromEntity(savedHospital)
    }

    @PreAuthorize("permitAll()")
    override fun getTrainById(id: Long): TrainResponse {
        val hospital = trainRepository.findById(id).orElseThrow()
        return TrainResponse.fromEntity(hospital)
    }

    @PreAuthorize("hasAuthority('EDITOR')")
    override fun updateTrain(id: Long, trainRequest: TrainRequest): TrainResponse {
        val train = trainRepository.findById(id).orElseThrow()
        train.model = trainRequest.model
        train.manufacturer = trainRequest.manufacturer
        val updatedTrain = trainRepository.save(train)
        return TrainResponse.fromEntity(updatedTrain)
    }

    @PreAuthorize("hasAuthority('EDITOR')")
    override fun deleteTrain(id: Long): Boolean {
        trainRepository.deleteById(id)
        return true
    }
}