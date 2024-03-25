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
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")

	//added
	implementation("org.apache.commons:commons-lang3:3.14.0")
	implementation("io.jsonwebtoken:jjwt:0.12.5")
	implementation ("org.modelmapper:modelmapper:3.1.1")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
