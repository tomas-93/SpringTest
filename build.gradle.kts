plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies{
    testImplementation("org.springframework.boot","spring-boot-starter-test","2.1.4.RELEASE")
    implementation("com.google.guava:guava:27.0.1-jre")
    implementation("org.springframework.boot","spring-boot-starter-web","2.1.4.RELEASE")
    implementation("org.springframework.boot","spring-boot-starter-data-mongodb","2.1.4.RELEASE")
    implementation("io.springfox","springfox-swagger2","2.9.2")
    implementation("io.springfox","springfox-swagger-ui","2.9.2")
    implementation("io.springfox","springfox-bean-validators","2.9.2")
    implementation("org.springframework.boot","spring-boot-starter-aop","2.1.4.RELEASE")


}

application {
    mainClassName = "com.tomas.test.App"
}
