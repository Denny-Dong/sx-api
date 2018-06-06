package com.listenrobot.test.api.runner;

import com.listenrobot.test.api.web.user.Users_Steps;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Users_Steps.class})
public class WebRunner {

}
