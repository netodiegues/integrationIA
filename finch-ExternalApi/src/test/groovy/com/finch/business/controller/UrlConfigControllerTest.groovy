package com.finch.business.controller

import com.finch.business.domain.model.UrlConfig
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import io.restassured.specification.RequestSpecification
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static io.restassured.RestAssured.given
import static io.restassured.http.ContentType.JSON
import static javax.servlet.http.HttpServletResponse.*

/**
 *
 * @author jose.diegues
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class UrlConfigControllerTest extends Specification {
    
    @Shared
    RequestSpecification api
    
    @Shared
    UrlConfig urlConfig
    
    @LocalServerPort
    int randomServerPort

    def setup() {
        api = given().contentType(JSON)
    }

    @Unroll
    def "Test - Should be create the UrlConfig return statusCode SC_CREATED"() {
        given:
        urlConfig = [urlAta    : urlAta,            
            urlPublicacao : urlPublicacao]

        when:
        def response = api.headers("Authorization", getToken()).body(urlConfig).post("http://localhost:${randomServerPort}/urls")        
       
        def jsonSlurper = new JsonSlurper().parseText(response.asString())
        def jsonBuilder = new JsonBuilder(jsonSlurper)
        
        then:        
        assert response.find(){urlConfig.urlAta  == "​http://144.22.92.189:5050/classify_ata"}
        assert response.find(){urlConfig.urlPublicacao  == "http://144.22.92.189:5060/classify_publicacao​"}
        
        response.statusCode == SC_CREATED
        println("UrlConfig created: " + jsonBuilder.toPrettyString() + "\n")

        where:
        urlAta                                     | urlPublicacao
        "​http://144.22.92.189:5050/classify_ata"   | "http://144.22.92.189:5060/classify_publicacao​"
    }
    
    @Unroll
    def "Test - Should be updating UrlConfig statusCode SC_OK"() {
        given:
        urlConfig = createUrlConfig().as(UrlConfig)
        urlConfig = [id  :id,
            urlAta    : urlAta,            
            urlPublicacao : urlPublicacao]
        
        when:
        def response = api.headers("Authorization", getToken()).body(urlConfig).put("http://localhost:${randomServerPort}/urls/{id}", urlConfig.id)
        
        def jsonSlurper = new JsonSlurper().parseText(response.asString())
        def jsonBuilder = new JsonBuilder(jsonSlurper)
        
        then:
        assert response.find(){urlConfig.urlAta  == "http://144.22.92.189:5050/classify_ata1"}
        
        response.statusCode == SC_OK
        println("UrlConfig updated: " + jsonBuilder.toPrettyString() + "\n")
        
        where:
        id | urlAta                                      | urlPublicacao
        1  | "http://144.22.92.189:5050/classify_ata1"   | "http://144.22.92.189:5060/classify_publicacao​" 
    }
            
    @Unroll
    def "Test - Should be deleting UrlConfig statusCode SC_NO_CONTENT"() {
        given:
        urlConfig = createUrlConfig().as(UrlConfig)
        
        when:
        def response = api.headers("Authorization", getToken()).delete("http://localhost:${randomServerPort}/urls/{id}", urlConfig.getId())
        
        then:
        response.statusCode == SC_NO_CONTENT
        println("UrlConfig deleted\n")
    }
    
    @Unroll
    def "Test - Should be return statusCode SC_OK"() {
        when:        
        def response = api.headers("Authorization", getToken()).get("http://localhost:${randomServerPort}/urls")
        
        def jsonSlurper = new JsonSlurper().parseText(response.asString())
        def jsonBuilder = new JsonBuilder(jsonSlurper)
        
        then:
        response.statusCode == SC_OK
        println("Return UrlConfig: " + jsonBuilder.toPrettyString() + "\n")
    }
    
    def "createUrlConfig"(){
        def urlConfig = [urlAta  : "http://144.22.92.189:5050/classify_ata",            
            urlPublicacao        : "http://144.22.92.189:5060/classify_publicacao​"]
              
        api.headers("Authorization", getToken()).body(urlConfig).post("http://localhost:${randomServerPort}/urls")
    }
        
    def "getToken"(){
        return "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6ImZpbmNoIiwiaWQiOjEsImV4cCI6MTIwMDAwMTU1NTA5Njk2MX0.2ebF6pcWJyEXx2js5nJEMObS71u8WtEusrgT5LANwOAFGDrQWW1zwhqBOG6BAhv8R5qPNihiuPf65WbV7kRoUQ";
    }
}