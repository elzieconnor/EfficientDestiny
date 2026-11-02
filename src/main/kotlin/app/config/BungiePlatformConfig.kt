package app.config

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "bungie.platform")
data class BungiePlatformConfig (

    @JsonProperty("api-key")
    val apiKey: String,

    @JsonProperty("base-url")
    val baseUrl: String,
)
