val junitVersion = "5.6.1"

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntime("org.junit.jupiter:junit-jupiter:${junitVersion}")
}

tasks.test {
    useJUnitPlatform()
}