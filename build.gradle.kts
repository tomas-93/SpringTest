plugins {
    java
    application
    id("io.franzbecker.gradle-lombok") version "3.0.0"
}

repositories {
    jcenter()
}

dependencies{
    testImplementation("org.springframework.boot","spring-boot-starter-test","2.0.6.RELEASE")
    implementation("com.google.guava:guava:27.0.1-jre")
    implementation("org.springframework.boot","spring-boot-starter-web","2.0.6.RELEASE")
    implementation("org.springframework.boot","spring-boot-starter-data-mongodb","2.0.6.RELEASE")
    implementation("io.springfox","springfox-swagger2","2.9.2")
    implementation("io.springfox","springfox-swagger-ui","2.9.2")
    implementation("io.springfox","springfox-bean-validators","2.9.2")
    implementation("org.springframework.boot","spring-boot-starter-aop","2.0.6.RELEASE")
    compileOnly("org.projectlombok", "lombok", "1.18.6")

}

application {
    mainClassName = "com.tomas.test.App"
}
