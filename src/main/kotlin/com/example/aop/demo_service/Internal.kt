package com.example.aop.demo_service

import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import java.time.Instant


@Entity
data class InternalEntity(
    @EmbeddedId val id: InternalId,
)

@Embeddable
data class InternalId(
    val id: String,
    val timestamp: Instant,
)
