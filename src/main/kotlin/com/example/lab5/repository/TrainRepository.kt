package com.example.lab5.repository

import com.example.lab5.entity.Train
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainRepository : JpaRepository<Train, Long>