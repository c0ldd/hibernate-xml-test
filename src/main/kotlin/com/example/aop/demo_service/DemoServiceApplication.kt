package com.example.aop.demo_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.support.GenericApplicationContext
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication(proxyBeanMethods = false)
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@ComponentScan(basePackages = ["com.example.aop","com.core.api"])
@EntityScan(basePackages = ["com.example.aop","com.core.api"])
class DemoServiceApplication

fun main(args: Array<String>) {
    runApplication<DemoServiceApplication>(*args)
}

object AppInitializer : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(applicationContext: GenericApplicationContext) {
        config.initialize(applicationContext)
    }
}
