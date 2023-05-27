package com.example.lab5.repository

import com.example.lab5.entity.Way
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface WayRepository : JpaRepository<Way, Long>