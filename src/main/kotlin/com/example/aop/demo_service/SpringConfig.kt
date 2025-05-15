package com.example.aop.demo_service

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans

val config: ApplicationContextInitializer<GenericApplicationContext> = beans {
    bean<MockRepo>()
    bean<Service> {
        ServiceImpl(ref())
    }
}