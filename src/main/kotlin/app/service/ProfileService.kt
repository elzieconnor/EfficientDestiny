package app.service

import app.constant.COMPONENTS
import app.enum.Components.CHARACTERS
import app.model.GetMembership
import app.model.GetProfile
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class ProfileService(
    private val client: WebClient,
) {
    suspend fun getProfile(
        accessToken: String,
    ): GetProfile {
        val userMembershipData = getMembership(accessToken).response

        val destinyMembership = userMembershipData.destinyMemberships.let { destinyMemberships ->
            userMembershipData.primaryMembershipId
                .let { primaryMembershipId ->
                    destinyMemberships.find { it.membershipId == primaryMembershipId }
                }
                ?: destinyMemberships.singleOrNull()
                ?: throw IllegalStateException(
                    "Could not determine primary Destiny membership"
                )
        }

        return client
            .get()
            .uri { builder ->
                builder
                    .path("/Destiny2/{type}/Profile/{id}/")
                    .queryParam(COMPONENTS, CHARACTERS.getCode())
                    .build(
                        destinyMembership.membershipType,
                        destinyMembership.membershipId
                    )
            }
            .retrieve()
            .awaitBody()
    }

    private suspend fun getMembership(accessToken: String): GetMembership =
        client
            .get()
            .uri("/User/GetMembershipsForCurrentUser/")
            .headers { it.setBearerAuth(accessToken) }
            .retrieve()
            .awaitBody()
}
