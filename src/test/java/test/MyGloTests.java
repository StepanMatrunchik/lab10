package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GloHyperX2BeloZolotoyPage;


public class MyGloTests {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver= new ChromeDriver();
    }

    @Test
    public void decreaseAmountOfItemByPlusButton(){
        String expectedAmount = new GloHyperX2BeloZolotoyPage(driver)
                .openPage()
                .confirmAge()
                .changeAmountInput("4")
                .decreaseAmountByPressingMinusButton()
                .getCurrentAmount();

        Assert.assertEquals(expectedAmount,"3","amount is not 3, its "+expectedAmount);
    }

    @Test
    public void increaseAmountOfItemByPlusButton(){
        String expectedAmount = new GloHyperX2BeloZolotoyPage(driver)
                .openPage()
                .confirmAge()
                .changeAmountInput("4")
                .increaseAmountByPressingPlusButton()
                .getCurrentAmount();

        Assert.assertEquals(expectedAmount,"5","amount is not 5, its "+expectedAmount);
    }



    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }

}

