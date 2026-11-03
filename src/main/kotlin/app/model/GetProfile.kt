package app.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GetProfile(

    @JsonProperty("Response")
    val response: DestinyProfileResponse,
) {
    data class DestinyProfileResponse(

        @JsonProperty("characters")
        val characters: DictionaryComponent<DestinyCharacterComponent>,
    ) {
        data class DestinyCharacterComponent(

            @JsonProperty("membershipId")
            val membershipId: String,

            @JsonProperty("membershipType")
            val membershipType: Int,

            @JsonProperty("characterId")
            val characterId: String,
        )
    }
}
