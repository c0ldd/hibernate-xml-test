package com.core.api

import java.time.Instant


data class GeoLocationEntity(
    val id: GeoLocationId,
)

data class GeoLocationId(
    val id: String,
    val timestamp: Instant,
)
