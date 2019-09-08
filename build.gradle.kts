plugins {
	`java-library`
}

repositories {
	jcenter()
}

dependencies {
	compileOnly("org.jetbrains:annotations:17.0.0")
}

java {
	sourceCompatibility = JavaVersion.VERSION_12
	targetCompatibility = JavaVersion.VERSION_12
}
