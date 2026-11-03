package app.controller

import app.constant.ACCESS_TOKEN
import app.model.GetProfile
import app.service.ProfileService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfileController(
    private val profileService: ProfileService,
) {

    @GetMapping("/profile")
    suspend fun getProfile(
        @RequestParam(ACCESS_TOKEN) accessToken: String,
    ): ResponseEntity<GetProfile> =
        ResponseEntity
            .ok()
            .body(profileService.getProfile(accessToken))
}
