package com.listenrobot.test.api;

import com.listenrobot.test.api.framework.Config;
import com.listenrobot.test.api.framework.driver.APIDriver;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserAccount {

    private static Config config = Config.getInstance();
    private APIDriver driver;
    // TokenConfiguration

    @Getter @Setter
    private String cooike;
    private Map<String, Object> userInfoMap = new HashMap<>();
    @Getter @Setter
    private Map<String,Object> cookieMap = new HashMap<>();


    public UserAccount() {
        this.driver = HooksApi.driver;
        try {
            setCookies();
//            userInfoMap = this.initializeUserInfo(this.accessToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getUserInfoMap() {
        return userInfoMap;
    }





    public void setCookies() throws IOException {
        HooksApi.logger.info("Start to get Cookies");
        driver.switchToAppUrlWithoutAuthentication();
        Map<String, String> accountInfo = new HashMap<String, String>();
        accountInfo.put("username",config.get("login.user.name"));
        accountInfo.put("password", config.get("login.user.password"));
        this.setCooike(given().body(accountInfo).cookie("session","1c97134f-961a-40fe-acf2-e3550d521nmd").when().post(config.get("restful.base.url.login")).then().assertThat().statusCode(200).extract().cookie("session"));
        cookieMap.put("session", this.getCooike());
    }



}
