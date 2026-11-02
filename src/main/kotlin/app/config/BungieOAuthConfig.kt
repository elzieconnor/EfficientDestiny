package app.config

import jakarta.validation.constraints.NotBlank
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@Validated
@ConfigurationProperties(prefix = "bungie.oauth")
data class BungieOAuthConfig (

    @NotBlank
    val clientId: String,

    @NotBlank
    val clientSecret: String,
)
