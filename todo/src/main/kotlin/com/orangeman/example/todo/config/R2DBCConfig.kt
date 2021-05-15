package com.orangeman.example.todo.config

import io.r2dbc.spi.ConnectionFactory
import org.mariadb.r2dbc.MariadbConnectionConfiguration
import org.mariadb.r2dbc.MariadbConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class R2DBConfig : AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return MariadbConnectionFactory(
            MariadbConnectionConfiguration.builder()
                .host("127.0.0.1")
                .port(3306)
                .username("app_user")
                .password("Password123!")
                .database("todo")
                .build()
        )
    }

}