package com.dio.stepdef.web;

import com.dio.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksWeb extends BaseTest {
    @Before
    public void beforeTest(){
        getDriver();
    }

    @After
    public void afterTest() {
        driver.close();

    }
}
