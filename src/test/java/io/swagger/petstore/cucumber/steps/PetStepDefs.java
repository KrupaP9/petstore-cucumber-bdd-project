package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.steps.PetStorePetSteps;
import io.swagger.petstore.utils.TestUtils;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class PetStepDefs {
    static ValidatableResponse response;
    static int id;
    static int idFirst;
    static int idsecond;
    static String name;
    static String nameFirst;
    static String namesecond;
    static PetPojo.CategoryData categoryData;
    ArrayList<PetPojo.TagData> tags;
    static String updatedname;
    static int pet;
    @Steps
    PetStorePetSteps petStorePetSteps;

    @When("^I send a GET request to the pet endpoint$")
    public void iSendAGETRequestToThePetEndpoint() {
        //petStorePetSteps.getPet(id);
    }

    @Then("^I must get back a valid status code (\\d+)$")
    public void iMustGetBackAValidStatusCode(int arg0) {
        response.statusCode(200);
    }

    @When("^I create a new pet by providing the information id \"([^\"]*)\" name \"([^\"]*)\" photoUrl \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateANewPetByProvidingTheInformationIdNamePhotoUrlStatus(String arg0, String arg1, String arg2, String arg3) {

    }

    @Then("^I verify that the pet with \"([^\"]*)\" is created$")
    public void iVerifyThatThePetWithIsCreated(String arg0) {

    }

    @Given("^petstore application is running$")
    public void petstoreApplicationIsRunning() {
    }

    @When("^I get details of pet with \"([^\"]*)\"$")
    public void iGetDetailsOfPetWith(int _id) {
        ValidatableResponse response = petStorePetSteps.getPet(_id);
        HashMap<String, Object> petMap = (HashMap<String, Object>) petStorePetSteps.getPet(_id).log().all().statusCode(200);
        id = (int) petMap.get("id");
        Assert.assertThat(petMap, hasValue(_id));
    }

    @Then("^I verify pet with \"([^\"]*)\" has been created$")
    public void iVerifyPetWithHasBeenCreated(int _id) {

    }

    @Given("^I am in the pet store creating new pet data$")
    public void iAmInThePetStoreCreatingNewPetData() {
    }

    @When("^I create new pet by providing the information id \"([^\"]*)\" idFirst \"([^\"]*)\" name \"([^\"]*)\" nameFirst \"([^\"]*)\" photoUrl\"([^\"]*)\"idsecond \"([^\"]*)\" namesecond \"([^\"]*)\" status\"([^\"]*)\"$")
    public void iCreateNewPetByProvidingTheInformationIdIdFirstNameNameFirstPhotoUrlIdsecondNamesecondStatus(int id, int idFirst, String name, String nameFirst, String photoUrl, int idsecond, String namesecond, String status) {
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        tags = new ArrayList<>();
        PetPojo.TagData tagData = new PetPojo.TagData(idFirst, nameFirst);
        tags.add(tagData);
        categoryData = new PetPojo.CategoryData(idsecond, namesecond);
        String randomname = TestUtils.getRandomValue() + name;
        petStorePetSteps.createPet(id, categoryData, randomname, photoUrls, tags, status).statusCode(200);
    }

    @Then("^I verify that the pet with id \"([^\"]*)\" is created$")
    public void iVerifyThatThePetWithIdIsCreated(int id) {
        response = petStorePetSteps.getPet(id);
        response.log().all().statusCode(200);
    }

    @And("^I update the pet with information id \"([^\"]*)\" idFirst \"([^\"]*)\" name \"([^\"]*)\" nameFirst \"([^\"]*)\" photoUrl\"([^\"]*)\"idsecond \"([^\"]*)\" namesecond \"([^\"]*)\" status\"([^\"]*)\"$")
    public void iUpdateThePetWithInformationIdIdFirstNameNameFirstPhotoUrlIdsecondNamesecondStatus(int id, int idFirst, String name1, String nameFirst, String photoUrl, int idsecond, String namesecond, String status) {
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        tags = new ArrayList<>();
        PetPojo.TagData tagData = new PetPojo.TagData(idFirst, nameFirst);
        tags.add(tagData);
        categoryData = new PetPojo.CategoryData(idsecond, namesecond);
        name = name + "_updated";
        response = petStorePetSteps.updatePet(id, categoryData, name, photoUrls, tags, status).statusCode(200);
    }

    @And("^I verify the pet with id \"([^\"]*)\" is updated successfully$")
    public void iVerifyThePetWithIdIsUpdatedSuccessfully(String name1) {
        HashMap<String, Object> pets = response.extract().path("");
        pet = (int) pets.get("id");
        Assert.assertThat(pets, hasValue(name));
        response.statusCode(200);
    }

    @And("^I delete the pet with id \"([^\"]*)\"$")
    public void iDeleteThePetWithId(int id) {
        response = petStorePetSteps.deletePet(id);
    }

    @Then("^the pet is deleted successfully from the application$")
    public void thePetIsDeletedSuccessfullyFromTheApplication() {
        response.statusCode(200);
        petStorePetSteps.getPet(id).statusCode(404);
    }


}
