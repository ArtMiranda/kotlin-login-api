package br.dev.arturmiranda.apikotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .authorizeHttpRequests { it
                .anyRequest().permitAll()
            }
            .headers { it.frameOptions().sameOrigin() }
        return http.build()
    }
}
