package app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class BungieWebClientConfig(
    private val webClientBuilder: WebClient.Builder
) {

    @Bean
    fun bungieWebClient(
        config: BungiePlatformConfig,
    ): WebClient {
        return webClientBuilder
            .baseUrl(config.baseUrl)
            .defaultHeader(X_API_KEY, config.apiKey)
            .build()
    }

    companion object {
        private const val X_API_KEY = "X-API-Key"
    }
}
