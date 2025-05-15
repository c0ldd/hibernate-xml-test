package com.example.aop.demo_service

import com.core.api.GeoLocationId
import org.springframework.transaction.annotation.Transactional

@Transactional
interface Service {
    fun processRequest(id: GeoLocationId)
    fun processRequest(id: InternalId)
}

class ServiceImpl(
    val repo: MockRepo
) : Service {
    override fun processRequest(id: GeoLocationId) {
        repo.processData(id)
    }

    override fun processRequest(id: InternalId) {
        repo.processInternalData(id)
    }
}
