package com.listenrobot.test.api.web.user;

import com.listenrobot.test.api.HooksApi;
import com.listenrobot.test.api.UserAccount;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Users_Hooks extends HooksApi {
    static UserAccount userAccount;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        HooksApi.driver.createNewDriverInstance();
        userAccount = new UserAccount();
        driver.switchToAppUrlWithAuthentication(userAccount.getAccessToken());
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }

    @Before
    public void setUp() throws Throwable {
    }

    @After
    public void tearDown() {

    }
}
