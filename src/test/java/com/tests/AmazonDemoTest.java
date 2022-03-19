package com.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.annotations.custom.FrameworkAnnotations;
import com.enums.CategoryTypeEnum;
import com.pages.AmazonHomePage;

public final class AmazonDemoTest extends BaseTest {

    private AmazonDemoTest() {
    }

    @FrameworkAnnotations(author = {"Krishanu", "Vagabond"},
            category = {CategoryTypeEnum.REGRESSION, CategoryTypeEnum.SMOKE})
    @Test
    public void amazonTest(Map<String, String> data) throws Exception {

        String actualTitle = new AmazonHomePage().clickHamburger().clickMobilesAndComputersLink()
                .clickOnSubmenu(data.get("menutext")).getTitle();

        System.out.println(actualTitle);

        Assertions.assertThat(actualTitle).isNotNull();

    }

}
