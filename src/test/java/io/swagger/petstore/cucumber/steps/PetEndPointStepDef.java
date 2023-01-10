package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.steps.PetStorePetSteps;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;

public class PetEndPointStepDef {
    static int id = 12345;
    static PetPojo.CategoryData category;
    static String name = "Fluffy";
    static java.util.ArrayList<String> photoUrl;
    static ArrayList<PetPojo.TagData> tags;
    static String status = "available";
    static ValidatableResponse response;
    static int idfirst = 4567;
    static String namefirst = "fluffy";
    static int idsecond = 8910;
    static String namesecond = "Rabbit";
    @Steps
    PetStorePetSteps petStorePetSteps;

    @When("^I send a create request for pet$")
    public void iSendACreateRequestForPet() {
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("www.google.com");
        tags = new ArrayList<>();
        PetPojo.TagData tagData = new PetPojo.TagData(idfirst, namefirst);
        tags.add(tagData);
        category = new PetPojo.CategoryData(idsecond, namesecond);
        response = petStorePetSteps.createPet(id, category, name, photoUrls, tags, status).statusCode(200);
    }

    @When("^I send a get request for pet$")
    public void iSendAGetRequestForPet() {
        response = petStorePetSteps.getPet(id).statusCode(200);
    }

    @When("^I send an update request for pet$")
    public void iSendAnUpdateRequestForPet() {
        name = name + "_updated";
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("www.google.com");
        response = petStorePetSteps.updatePet(id, category, name, photoUrls, tags, status).statusCode(200);
    }

    @When("^I send a delete request for pet$")
    public void iSendADeleteRequestForPet() {
        response = petStorePetSteps.deletePet(id).statusCode(200);
    }

    @Then("^I must get back a valid pet status code (\\d+)$")
    public void iMustGetBackAValidPetStatusCode(int arg0) {
        response.statusCode(200);
    }
}
