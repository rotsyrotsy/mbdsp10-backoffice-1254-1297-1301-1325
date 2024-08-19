package com.itu.mbds

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class CustomUserDetailsService implements UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = User.findByEmail(email)
        if (!user) {
            throw new UsernameNotFoundException("User not found with email: " + email)
        }
        return new org.springframework.security.core.userdetails.User(
                user.email, user.password, user.enabled, true, true, true, user.authorities
        )
    }
}

