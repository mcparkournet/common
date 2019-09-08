plugins {
	`java-library`
}

subprojects {
	apply {
		plugin("java-library")
	}

	repositories {
		jcenter()
	}

	dependencies {
		compileOnly("org.jetbrains:annotations:17.0.0")
		testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
		testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
		testCompileOnly("org.jetbrains:annotations:17.0.0")
	}

	java {
		sourceCompatibility = JavaVersion.VERSION_12
		targetCompatibility = JavaVersion.VERSION_12
	}

	tasks {
		test {
			useJUnitPlatform()
		}
	}
}
