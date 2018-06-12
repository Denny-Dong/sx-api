package com.listenrobot.test.api;

import com.listenrobot.test.api.framework.Config;
import com.listenrobot.test.api.framework.driver.APIDriver;
import io.restassured.response.Response;
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

    private Map<String, Object> userInfoMap = new HashMap<>();
    @Getter
    @Setter
    private Map<String, String> cookieMap = new HashMap<>();
    @Getter
    @Setter
    private String tooken;
    @Setter
    @Getter
    private String cookieString = "eyJfaWQiOiIzYzUyZWYzNWVjNjUwMTE3MDUwNzNkZjEwYWE4MTcxMiIsInVzZXJfaWQiOiIxIiwiX2ZyZXNoIjp0cnVlfQ.DgC9QQ.yZkDzrrYmG1kykMYC6VyTTx8aaa";


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
        accountInfo.put("username", config.get("login.user.name"));
        accountInfo.put("password", config.get("login.user.password"));
        Response response = given().log().all().body(accountInfo).cookie("session", this.getCookieString()).when().post(config.get("restful.base.url.login")).then().log().all().assertThat().statusCode(200).extract().response();
        this.setTooken(response.path("data.token.access_token"));
        Map<String, String> cooikeMap = new HashMap<>();
        cooikeMap.put("session", this.getCookieString());
        this.setCookieMap(cooikeMap);
    }


}
