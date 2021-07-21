package com.orangeman.example.todo.config

import io.r2dbc.spi.ConnectionFactory
import org.mariadb.r2dbc.MariadbConnectionConfiguration
import org.mariadb.r2dbc.MariadbConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class R2DBConfig: AbstractR2dbcConfiguration() {

    @field:Value("\${database.host}")
    private lateinit var host: String

    @field:Value("\${database.port}")
    private var port: Int = 0

    @field:Value("\${database.username}")
    private lateinit var username: String


    @field:Value("\${database.password}")
    private lateinit var password: String

    @field:Value("\${database.dbname}")
    private lateinit var dbname: String

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return MariadbConnectionFactory(
            MariadbConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .username(username)
                .password(password)
                .database(dbname)
                .build()
        )
    }

}