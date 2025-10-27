plugins {
    java
    checkstyle
    id("org.sonarqube") version "7.0.0.6105"
    id("se.patrikerdes.use-latest-versions") version "0.2.19"
    id("com.github.ben-manes.versions") version "0.53.0"
    jacoco
}

sonar {
    properties {
        property("sonar.projectKey", "thygh0st_java-project-78")
        property("sonar.organization", "thygh0st")
        property("sonar.host.url", "https://sonarcloud.io")
        property ("sonar.coverage.jacoco.xmlReportPaths", "/reports/jacoco/test/jacocoTestReport.xml")
    }
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required = true
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}