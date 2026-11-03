package app.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GetMembership(

    @JsonProperty("Response")
    val response: UserMembershipData,
) {
    data class UserMembershipData(

        @JsonProperty("primaryMembershipId")
        val primaryMembershipId: Long,

        @JsonProperty("destinyMemberships")
        val destinyMemberships: List<GroupUserInfoCard>,
    ) {
        data class GroupUserInfoCard(

            @JsonProperty("membershipType")
            val membershipType: Long,

            @JsonProperty("membershipId")
            val membershipId: Long,
        )
    }
}
