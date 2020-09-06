package com.nikhil.spaceapp.feature.asteroid.dto

import com.squareup.moshi.JsonClass
import java.io.Serializable

//TODO: Improve ":Serializable" everytime declaration
@JsonClass(generateAdapter = true)
data class Asteroid(
    val links: Links,
    val id: String,
    val neo_reference_id: String,
    val name: String,
    val nasa_jpl_url: String,
    val absolute_magnitude_h: Double,
    val estimated_diameter: EstimatedDiameter,
    val is_potentially_hazardous_asteroid: Boolean,
    val close_approach_data: List<CloseApproachData>,
    val is_sentry_object: Boolean
) : Serializable

data class Links(
    val self: String
) : Serializable

data class EstimatedDiameter(
    val kilometers: Kilometers,
    val meters: Meters,
    val miles: Miles,
    val feet: Feet
) : Serializable {
    data class Kilometers(
        val estimated_diameter_min: Double,
        val estimated_diameter_max: Double
    ) : Serializable

    data class Meters(
        val estimated_diameter_min: Double,
        val estimated_diameter_max: Double
    ) : Serializable

    data class Miles(
        val estimated_diameter_min: Double,
        val estimated_diameter_max: Double
    ) : Serializable

    data class Feet(
        val estimated_diameter_min: Double,
        val estimated_diameter_max: Double
    ) : Serializable
}

data class CloseApproachData(
    val close_approach_date: String,
    val close_approach_date_full: String? = null,
    val epoch_date_close_approach: Long,
    val relative_velocity: RelativeVelocity,
    val miss_distance: MissDistance,
    val orbiting_body: String
) : Serializable {
    data class RelativeVelocity(
        val kilometers_per_second: String,
        val kilometers_per_hour: String,
        val miles_per_hour: String
    ) : Serializable

    data class MissDistance(
        val astronomical: String,
        val lunar: String,
        val kilometers: String,
        val miles: String
    ) : Serializable
}