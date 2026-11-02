package app.config

import jakarta.validation.constraints.NotBlank
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@Validated
@ConfigurationProperties(prefix = "bungie.platform")
data class BungiePlatformConfig (

    @NotBlank
    val apiKey: String,

    @NotBlank
    val baseUrl: String,
)
