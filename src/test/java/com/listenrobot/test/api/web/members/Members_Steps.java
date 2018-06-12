package com.listenrobot.test.api.web.members;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Members_Steps extends Members_Hooks {

    private Members_Flows members_flows;

    public Members_Steps(){
        super();
        members_flows = new Members_Flows();
    }
    @Test
    public void members_get(){
        given().when().get("/user").then().assertThat().statusCode(200).body(matchesJsonSchemaInClasspath("jsonResources\\schema\\web\\member\\members_get.json"));


    }

}
