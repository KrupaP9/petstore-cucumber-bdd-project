package io.swagger.petstore.steps;

import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.constants.EndPoints;
import io.swagger.petstore.model.PetPojo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;

public class PetStorePetSteps {
    @Step("Create Pet")
    public ValidatableResponse createPet(int id, PetPojo.CategoryData category, String name, ArrayList<String> photoUrls, ArrayList<PetPojo.TagData> tags, String status) {
        //photoUrls.add("www.google.com");
        PetPojo petPojo = new PetPojo();
        petPojo.setId(id);
        petPojo.setCategory(category);
        petPojo.setName(name);
        petPojo.setPhotoUrls(photoUrls);
        petPojo.setTags(tags);
        petPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .post(EndPoints.CREATE_A_PET)
                .then().log().all().statusCode(200);
    }

    @Step("Get Pet")
    public ValidatableResponse getPet(int id) {
        return SerenityRest.given().log().all()
                .pathParam("pet_id", id)
                .when()
                .get(EndPoints.GET_A_PET)
                .then().log().all();
    }

    @Step("Update a Pet")
    public ValidatableResponse updatePet(int id, PetPojo.CategoryData category, String name, ArrayList<String> photoUrls, ArrayList<PetPojo.TagData> tags, String status) {
        PetPojo petPojo = new PetPojo();
        petPojo.setId(id);
        petPojo.setCategory(category);
        petPojo.setName(name);
        petPojo.setPhotoUrls(photoUrls);
        petPojo.setTags(tags);
        petPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .put(EndPoints.UPDATE_A_PET)
                .then().log().all().statusCode(200);
    }

    @Step("Deleting information with id: {0}")
    public ValidatableResponse deletePet(int id) {
        return SerenityRest.given().log().all()
                .pathParam("pet_id", id)
                .when()
                .delete(EndPoints.DELETE_A_PET)
                .then().log().all();
    }

}
