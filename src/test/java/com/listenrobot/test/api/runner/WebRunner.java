package com.listenrobot.test.api.runner;

import com.listenrobot.test.api.web.members.Members_Steps;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Members_Steps.class})
public class WebRunner {

}
