plugins {
	`java-library`
	kotlin("jvm")
	kotlin("plugin.allopen")
	id("io.freefair.aspectj.post-compile-weaving")
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
	implementation(platform("org.springframework.boot:spring-boot-dependencies:3.3.9"))

	aspect("org.springframework:spring-aspects:6.1.17")
	implementation("org.aspectj:aspectjrt")

	implementation("org.springframework:spring-aop")
	implementation("org.springframework:spring-tx")
	implementation("org.springframework.boot:spring-boot")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
