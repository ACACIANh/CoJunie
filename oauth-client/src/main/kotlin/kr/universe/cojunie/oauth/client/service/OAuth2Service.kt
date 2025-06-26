package kr.universe.cojunie.oauth.client.service

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

/**
 * Service for handling OAuth2 authentication
 */
@Service
class OAuth2Service : OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private val delegate = DefaultOAuth2UserService()

    /**
     * Load a user by OAuth2 user request
     * @param userRequest The OAuth2 user request
     * @return The OAuth2 user
     */
    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        val oAuth2User = delegate.loadUser(userRequest)

        // Extract provider details
        val registrationId = userRequest.clientRegistration.registrationId
        val userNameAttributeName =
            userRequest.clientRegistration
                .providerDetails.userInfoEndpoint.userNameAttributeName

        // Extract user attributes
        val attributes = oAuth2User.attributes

        // Here you would typically:
        // 1. Check if the user exists in your database
        // 2. Create a new user if they don't exist
        // 3. Update user information if needed

        return oAuth2User
    }
}
