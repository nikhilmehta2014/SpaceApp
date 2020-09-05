package com.nikhil.spaceapp.ui.asteroid.dto

data class AsteroidDTO(
    val links: Links,
    val element_count: Int,
    val near_earth_objects: NearEarthObjects
) {
    data class Links(
        val next: String,
        val prev: String,
        val self: String
    )

    data class NearEarthObjects(
        val `2019-03-04`: List<X20190304>
    ) {
        data class X20190304(
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
        ) {
            data class Links(
                val self: String
            )

            data class EstimatedDiameter(
                val kilometers: Kilometers,
                val meters: Meters,
                val miles: Miles,
                val feet: Feet
            ) {
                data class Kilometers(
                    val estimated_diameter_min: Double,
                    val estimated_diameter_max: Double
                )

                data class Meters(
                    val estimated_diameter_min: Double,
                    val estimated_diameter_max: Double
                )

                data class Miles(
                    val estimated_diameter_min: Double,
                    val estimated_diameter_max: Double
                )

                data class Feet(
                    val estimated_diameter_min: Double,
                    val estimated_diameter_max: Double
                )
            }

            data class CloseApproachData(
                val close_approach_date: String,
                val close_approach_date_full: String,
                val epoch_date_close_approach: Long,
                val relative_velocity: RelativeVelocity,
                val miss_distance: MissDistance,
                val orbiting_body: String
            ) {
                data class RelativeVelocity(
                    val kilometers_per_second: String,
                    val kilometers_per_hour: String,
                    val miles_per_hour: String
                )

                data class MissDistance(
                    val astronomical: String,
                    val lunar: String,
                    val kilometers: String,
                    val miles: String
                )
            }
        }
    }
}