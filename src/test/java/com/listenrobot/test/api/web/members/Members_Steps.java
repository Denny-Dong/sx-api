package com.listenrobot.test.api.web.members;

import org.junit.Test;
import static io.restassured.RestAssured.given;

public class Members_Steps extends Members_Hooks {

    private Members_Flows members_flows;

    public Members_Steps(){
        super();
        members_flows = new Members_Flows();
    }
    @Test
    public void members_get(){
        given().when().get("/members").then().assertThat().statusCode(200);


    }

}
