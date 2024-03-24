plugins {
	java
	id("org.springframework.boot") version "3.2.3" apply false
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.neonlab"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

dependencyManagement{
	imports {
		mavenBom ("org.springframework.boot:spring-boot-dependencies:3.2.3")
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")
	implementation("com.google.code.gson:gson:2.8.8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")

	//added
	implementation("org.apache.commons:commons-lang3:3.14.0")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
