package com.example.aop.demo_service

import com.core.api.GeoLocationEntity
import com.core.api.GeoLocationId
import jakarta.persistence.EntityManager
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional(propagation = Propagation.REQUIRED)
class MockRepo(
    val entityManager: EntityManager,
) {
    fun processData(id: GeoLocationId): GeoLocationEntity {
        val geoLocation = GeoLocationEntity(
            id
        )
        return entityManager.merge(geoLocation)
    }
    fun processInternalData(id: InternalId): InternalEntity {
        val internal = InternalEntity(
            id
        )
        return entityManager.merge(internal)
    }
}