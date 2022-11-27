package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GloHyperX2BeloZolotoyPage {
    private static final String HOMEPAGE_URL="https://shop.myglo.by/catalog/glo-hyper-x2-belo-zolotoy/";
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='btn btn--primary']")
    private WebElement ageConfirmation;

    @FindBy(xpath = "//input[@class='counter-input js-counter-input']")
    private WebElement amountInput;

    @FindBy(xpath = "//button[@class='counter-btn counter-plus js-counter-plus']")
    private WebElement plusButton;

    @FindBy(xpath = "//button[@class='counter-btn counter-minus js-counter-minus']")
    private WebElement minusButton;

    public GloHyperX2BeloZolotoyPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public GloHyperX2BeloZolotoyPage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='btn btn--primary']")));
        return this;
    }

    public GloHyperX2BeloZolotoyPage confirmAge(){
        ageConfirmation.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='counter-input js-counter-input']")));
        return this;
    }

    public GloHyperX2BeloZolotoyPage changeAmountInput(String amount){
        for(int i=0; i<amountInput.getAttribute("value").length(); i++){
            amountInput.sendKeys(Keys.BACK_SPACE);
        }
        amountInput.sendKeys(amount);
        amountInput.sendKeys(Keys.ENTER);
        return this;
    }

    public GloHyperX2BeloZolotoyPage increaseAmountByPressingPlusButton(){
        plusButton.click();
        return this;
    }

    public GloHyperX2BeloZolotoyPage decreaseAmountByPressingMinusButton(){
        minusButton.click();
        return this;
    }

    public String getCurrentAmount(){
        return amountInput.getAttribute("value");
    }

}
