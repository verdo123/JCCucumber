package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddcartPage {
    private WebDriver driver;

    public AddcartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


    //Locator find element

    @FindBy(xpath = "//input[@name='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    private WebElement appLogo;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement btnAddcart;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private WebElement cartPage;

    public void formBtnCart(){
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();
        btnAddcart.click();
        cartPage.click();

    }
}

