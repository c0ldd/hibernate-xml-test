plugins {
	kotlin("jvm") version "2.1.0"
	kotlin("plugin.spring") version "2.1.0"
	id("org.springframework.boot") version "3.3.9"
	id("io.spring.dependency-management") version "1.1.7"
	id("io.freefair.aspectj.post-compile-weaving") version "8.12.1"
	kotlin("plugin.jpa") version "2.1.0"
	id("org.hibernate.orm") version "6.5.3.Final"
}

group = "com.example.aop"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(project("demo-api"))

	aspect("org.springframework:spring-aspects")
	implementation("org.aspectj:aspectjrt")

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("org.liquibase:liquibase-core")
	implementation("org.springframework:spring-tx")
	runtimeOnly("com.h2database:h2")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

hibernate {
	useSameVersion = false
	enhancement {
		enableAssociationManagement.set(true)
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
