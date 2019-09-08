import com.jfrog.bintray.gradle.BintrayExtension

plugins {
	`java-library`
	`maven-publish`
	id("com.jfrog.bintray") version "1.8.4" apply false
}

subprojects {
	apply {
		plugin("java-library")
		plugin("maven-publish")
		plugin("com.jfrog.bintray")
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

	task<Jar>("sourcesJar") {
		from(sourceSets["main"].allSource)
		archiveClassifier.set("sources")
	}

	publishing {
		publications {
			create<MavenPublication>("maven") {
				from(components["java"])
				artifact(tasks["sourcesJar"])
			}
		}
	}

	configure<BintrayExtension> {
		user = properties["bintray-user"] as String?
		key = properties["bintray-api-key"] as String?
		publish = true
		setPublications("maven")
		pkg(closureOf<BintrayExtension.PackageConfig> {
			repo = properties["mcparkour-bintray-repository"] as String?
			userOrg = properties["mcparkour-bintray-organization"] as String?
			name = project.name
			desc = project.description
			websiteUrl = "https://github.com/mcparkournet/common"
			issueTrackerUrl = "$websiteUrl/issues"
			vcsUrl = "$websiteUrl.git"
			setLicenses("MIT")
			setLabels("java", "common", "utils", "utilities")
		})
	}
}
