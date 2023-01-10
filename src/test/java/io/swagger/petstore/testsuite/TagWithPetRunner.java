package io.swagger.petstore.testsuite;

import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagWithPetRunner extends TestBase {
    @WithTags({@WithTag("petfeature:NEGATIVE"),@WithTag("petfeature:SMOKE")})
    @Title("Provide a 415 status code when incorrect HTTP method is used to access a resource")
    @Test
    public void invalidMethod(){
        SerenityRest.rest()
                .given()
                .when()
                .post("/pet")
                .then()
                .statusCode(415)
                .log().all();
    }
    @WithTags({@WithTag("petfeature:NEGATIVE"),@WithTag("petfeature:SANITY")})
    @Title("Verifies whether a status code of 405 is returned for GET method")
    @Test
    public void verifyIfStatusCodeIs405(){
        SerenityRest.rest()
                .given()
                .when()
                .get("/pet")
                .then()
                .statusCode(405)
                .log().all();
    }
    @WithTags({@WithTag("petfeature:NEGATIVE"),@WithTag("petfeature:REGRESSION")})
    @Title("Provides an error code of 404 when user accesses an invalid resource")
    @Test
    public void verifyIncorrectResource(){
        SerenityRest.rest()
                .given()
                .when()
                .get("/pet1")
                .then()
                .statusCode(404)
                .log().all();
    }
}
