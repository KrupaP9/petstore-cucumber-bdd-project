package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.steps.PetStoreUserSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class UserStepsDefs {
    static ValidatableResponse response;
    static String name;
    @Steps
    PetStoreUserSteps petStoreUserSteps;

    @Given("^I am in the pet store creating new user data$")
    public void iAmInThePetStoreCreatingNewUserData() {
    }
    @When("^I create new user by providing the information id \"([^\"]*)\" username \"([^\"]*)\" firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" phone \"([^\"]*)\" userStatus \"([^\"]*)\"$")
    public void iCreateNewUserByProvidingTheInformationIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatus(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus){
        response = petStoreUserSteps.createUser(id, username, firstName, lastName, email, password, phone, userStatus).statusCode(200);
    }
    @Then("^I verify that the user with username \"([^\"]*)\" is created$")
    public void iVerifyThatTheUserWithUsernameIsCreated(String username) {
        response = petStoreUserSteps.getUserByUsername(username);
        HashMap<String, Object> userlist = response.extract().path("");
        Assert.assertThat(userlist, hasValue(username));
        response.statusCode(200);
    }

    @And("^I update the user with information id \"([^\"]*)\" username \"([^\"]*)\" firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" phone \"([^\"]*)\" userStatus \"([^\"]*)\"$")
    public void iUpdateTheUserWithInformationIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatus(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus){
        response = petStoreUserSteps.updateUser(id, username, firstName, lastName, email, password, phone, userStatus).statusCode(200);
    }
    @And("^I verify the user with username \"([^\"]*)\" is updated successfully$")
    public void iVerifyTheUserWithUsernameIsUpdatedSuccessfully(String username){
        response = petStoreUserSteps.getUserByUsername(username);
        HashMap<String, Object> userlists = response.extract().path("");
        Assert.assertThat(userlists, hasValue(username));
        response.statusCode(200);
    }

    @And("^I delete the user with username \"([^\"]*)\"$")
    public void iDeleteTheUserWithUsername(String username) {
        petStoreUserSteps.deleteUser(username).statusCode(200);
    }

    @Then("^the user with username \"([^\"]*)\" is deleted successfully from the application$")
    public void theUserWithUsernameIsDeletedSuccessfullyFromTheApplication(String username) {
        petStoreUserSteps.getUserByUsername(username).statusCode(404);
    }







}
