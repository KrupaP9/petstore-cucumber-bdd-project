package io.swagger.petstore.steps;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.constants.EndPoints;
import io.swagger.petstore.model.UserPojo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PetStoreUserSteps {
    @Step("Create user with id: {0}, username : {1}, firstname: {2}, lastname : {3}, email : {4}, password : {5}, phone {6}, status {7} ")
    public ValidatableResponse createUser(int id,String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        UserPojo userPojo = new UserPojo();
        userPojo.setId(id);
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("accept", "application/json")
                .body(userPojo)
                .when()
                .post(EndPoints.CREATE_A_USER)
                .then().statusCode(200);
    }
    @Step("Getting user information from the username : {0}")
    public ValidatableResponse getUserByUsername(String username){
        return SerenityRest.given().log().all()
                .pathParam("username",username)
                .when()
                .get(EndPoints.GET_A_USER)
                .then().log().all();
    }
    @Step("Updating user with  id: {0}, username : {1}, firstname: {2}, lastname : {3}, email : {4}, password : {5}, phone {6}, status {7} ")
    public ValidatableResponse updateUser(int id,String username, String firstName, String lastName, String email, String password, String phone, int userStatus){
        UserPojo userPojo = new UserPojo();
        userPojo.setId(id);
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("accept", "application/json")
                .pathParam("username", username)
                .body(userPojo)
                .when()
                .put(EndPoints.UPDATE_A_USER)
                .then().statusCode(200);
    }
    @Step("Deleting user information with bookingid: {0}")
    public ValidatableResponse deleteUser(String username) {
        return SerenityRest.given().log().all()
                .pathParam("username", username)
                .when()
                .delete(EndPoints.DELETE_A_USER)
                .then();
    }

    @Step("Getting student information with studentId: {0}")
    public ValidatableResponse getUser(String username){
        return SerenityRest.given().log().all()
                .pathParam("username", username)
                .when()
                .get(EndPoints.GET_A_USER)
                .then();
    }

}
