package app.config

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "bungie.oauth")
data class BungieOAuthConfig (

    @JsonProperty("client-id")
    val clientId: String,

    @JsonProperty("client-secret")
    val clientSecret: String,
)
