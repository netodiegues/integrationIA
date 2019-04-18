package com.finch.security.controller

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import io.restassured.specification.RequestSpecification
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.annotation.DirtiesContext
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static io.restassured.RestAssured.given
import static io.restassured.http.ContentType.JSON
import static javax.servlet.http.HttpServletResponse.SC_OK

/**
 *
 * @author jose.diegues
 */

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class OperationNatureControllerTest extends Specification{
    @Shared
    RequestSpecification api

    @LocalServerPort
    int randomServerPort

    def setup() {
        api = given().contentType(JSON)
    }
    
    @Unroll
    def "Test - Should be return statusCode SC_OK"() {
        when:        
        def response = api.headers("Authorization",getToken()).get("http://localhost:${randomServerPort}/security/users")

        def jsonSlurper = new JsonSlurper().parseText(response.asString())
        def jsonBuilder = new JsonBuilder(jsonSlurper)

        then:
        response.statusCode == SC_OK
        println("Return User: " + jsonBuilder.toPrettyString() + "\n")
    }  
    
    def "getToken"(){
        return "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6ImZpbmNoIiwiaWQiOjEsImV4cCI6MTIwMDAwMTU1NTA5Njk2MX0.2ebF6pcWJyEXx2js5nJEMObS71u8WtEusrgT5LANwOAFGDrQWW1zwhqBOG6BAhv8R5qPNihiuPf65WbV7kRoUQ";
    }


}