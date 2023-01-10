package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.steps.PetStoreUserSteps;
import io.swagger.petstore.utils.TestUtils;
import net.thucydides.core.annotations.Steps;

public class UserEndPointStepDef {
    static int id = 12345;
    static String username = "kpatel";
    static String firstName = "kiara";
    static String lastName = "patel";
    static String email = TestUtils.getRandomValue()+"kpatel@gmail.com";
    static String password = "kpatelpassword";
    static String phone = "07615445658";
    static int userStatus = 0;
    static ValidatableResponse response;
    @Steps
    PetStoreUserSteps petStoreUserSteps;
    @When("^I send a create request for user$")
    public void iSendACreateRequestForUser() {
        response = petStoreUserSteps.createUser(id,username,firstName,lastName,email,password,phone,userStatus).statusCode(200);
    }

    @When("^I send a get request for user$")
    public void iSendAGetRequestForUser() {
        response = petStoreUserSteps.getUserByUsername(username).statusCode(200);
    }

    @When("^I send an update request for user$")
    public void iSendAnUpdateRequestForUser() {
        lastName = lastName + "_updated";
        response = petStoreUserSteps.updateUser(id,username,firstName,lastName,email,password,phone,userStatus).statusCode(200);
    }

    @When("^I send a delete request for user$")
    public void iSendADeleteRequestForUser() {
        response = petStoreUserSteps.deleteUser(username).statusCode(200);
    }

    @Then("^I must get back a valid user status code (\\d+)$")
    public void iMustGetBackAValidUserStatusCode(int arg0) {
        response.statusCode(200);
    }
}
