package io.swagger.petstore.testsuite;

import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.steps.PetStoreUserSteps;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "2x")
@UseTestDataFrom("src/test/java/resources/testdata/userdata.csv")
@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenTestUser extends TestBase {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private int status;

    @Steps
    PetStoreUserSteps petStoreUserSteps;

    @Title("Data driven test for adding multiple users")
    @Test
    public void createMultipleUsers() {
        ValidatableResponse response = petStoreUserSteps.createUser(id, username, firstname, lastname, email, password, phone, status);
        response.log().all().statusCode(200);
    }
}
