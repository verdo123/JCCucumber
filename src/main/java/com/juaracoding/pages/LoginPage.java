package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


    //Locator find element
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement btnLogin;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement TxtDashboard;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement TxtInvalid;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement sideBar;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;

    public void formLogin(){
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();
    }

    public void inputUsername(String username){
        this.username.sendKeys(username);
    }

    public void inputPassword (String password){
        this.password.sendKeys(password);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

    public String getTxtDashboard(){
        return TxtDashboard.getText();
    }


    public void formBtnLogout(){
        sideBar.click();
        btnLogout.click();
    }

    public String getTxtInvalid(){
        return TxtInvalid.getText();
    }

}
