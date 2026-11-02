package app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class BungieWebClientConfig(
    private val config: BungiePlatformConfig,
) {

    @Bean
    fun bungieWebClient(): WebClient {
        return WebClient
            .builder()
            .baseUrl(config.baseUrl)
            .defaultHeader(API_KEY, config.apiKey)
            .build()
    }

    companion object {
        const val API_KEY = "X-API-Key"
    }
}
