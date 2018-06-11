package com.listenrobot.test.api.web.members;

import com.listenrobot.test.api.UserAccount;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static com.listenrobot.test.api.HooksApi.driver;

public class Members_Hooks {
    static UserAccount userAccount;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        driver.createNewDriverInstance();
        userAccount = new UserAccount();
        driver.switchToAppUrlWithCookie(userAccount.getCookieMap());
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
