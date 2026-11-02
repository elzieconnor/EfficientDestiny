package app.controller

import app.config.BungieOAuthConfig
import app.constant.CLIENT_ID
import app.constant.CODE
import app.constant.RESPONSE_TYPE
import app.model.AccessTokenResponse
import app.service.OAuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api")
class OAuthController(
    private val config: BungieOAuthConfig,
    private val oAuthService: OAuthService
) {

    @GetMapping("/authorize")
    fun authorize(): ResponseEntity<Void> =
        ResponseEntity
            .status(HttpStatus.FOUND)
            .location(
                UriComponentsBuilder
                    .fromUriString("https://www.bungie.net/en/oauth/authorize")
                    .queryParam(CLIENT_ID, config.clientId)
                    .queryParam(RESPONSE_TYPE, CODE)
                    .build()
                    .toUri()
            )
            .build()

    @GetMapping("/token/exchange")
    suspend fun exchange(
        @RequestParam(CODE) code: String,
    ): ResponseEntity<AccessTokenResponse> =
        ResponseEntity
            .ok()
            .body(oAuthService.exchange(code))
}
