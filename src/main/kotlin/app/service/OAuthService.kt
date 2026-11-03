package app.service

import app.config.BungieOAuthConfig
import app.constant.CODE
import app.model.AccessToken
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class OAuthService(
    private val config: BungieOAuthConfig,
    private val client: WebClient,
) {
    suspend fun exchange(
       code: String,
    ): AccessToken =
        client
            .post()
            .uri("/app/oauth/token/")
            .headers {
                it.setBasicAuth(
                    config.clientId,
                    config.clientSecret
                )
            }
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(
                BodyInserters
                    .fromFormData(GRANT_TYPE, AUTHORIZATION_CODE)
                    .with(CODE, code)
            )
            .retrieve()
            .awaitBody()

    companion object {
        private const val AUTHORIZATION_CODE: String = "authorization_code"
        private const val GRANT_TYPE: String = "grant_type"
    }
}
