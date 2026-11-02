package app.config

import app.constant.API_KEY
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
}
