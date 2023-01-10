package io.swagger.petstore.testsuite;

import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.steps.PetStorePetSteps;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@Concurrent(threads = "2x")
@UseTestDataFrom("src/test/java/resources/testdata/petdata.csv")
@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenTestPet extends TestBase {
    private int id;
    private int id1;
    private String name;
    private String name1;
    private String photoUrl;
    private int id2;
    private String name2;
    private String status;

    @Steps
    PetStorePetSteps petStorePetSteps;
    @Title("Data driven test for adding multiple students")
    @Test
    public void createMultiplePets(){
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        ArrayList<PetPojo.TagData> tags  = new ArrayList<>();
        PetPojo.TagData tagData = new PetPojo.TagData(id2,name2);
        tags.add(tagData);
        PetPojo.CategoryData category = new PetPojo.CategoryData(id1,name1);
        petStorePetSteps.createPet(id,category,name,photoUrls,tags,status).statusCode(200);
    }
}
