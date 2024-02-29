package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class logintest {

    private static WebDriver driver;

    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Given("Pengguna mengakses halaman login")
    public void Pengguna_mengakses_halaman_login() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("Pengguna memasukan username yang valid")
    public void Pengguna_memasukan_username_yang_valid(){
        loginPage.inputUsername("Admin");
    }

    @And("Pengguna memasukkan password kredensial yang valid")
    public void Pengguna_memasukkan_password_kredensial_yang_valid(){
        loginPage.inputPassword("admin123");
    }

    @And("Pengguna menekan tombol Login")
    public void Pengguna_menekan_tombol_Login(){
        loginPage.clickBtnLogin();
    }

    @Then("User berhasil login dan diarahkan ke halaman urama atau dashboard setelah login")
    public void User_berhasil_login_dan_diarahkan_ke_halaman_urama_atau_dashboard_setelah_login(){
        Assert.assertEquals(loginPage.getTxtDashboard(),"dashboard");
    }




    //Negative Case ------------------------------------------------------------------------------

    @Given("Pengguna berada pada halaman login")
    public void Pengguna_berada_pada_halaman_login(){

    }

    @And("Pengguna memasukkan password kredensial yang tidak valid")
    public void Pengguna_memasukkan_password_kredensial_yang_tidak_valid(){
        loginPage.inputPassword("admin123");
    }
    @Then("User tidak berhasil login dan mendapatkan feedback invalid credential")
    public void User_tidak_berhasil_login_dan_mendapatkan_feedback_invalid_credential(){
        Assert.assertEquals(loginPage.getTxtInvalid(),"Invalid credentials");
    }

}


@AfterStep
    public void getResultStatus(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotPath = Utils.getScreenshot(driver, scenario.getName())
                    .replace(" ","_");
            extentTest.log(LogStatus.FAIL, scenario.getName()+"\n"
                +extentTest.addScreenCapture(screenshotPath));
        }
    }

@AfterStep
    public void getResultStatus(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            String screenshotPath = Utils.getScreenshot(driver, scenario.getName()
                    .replace(" ","_"));
            extentTest.log(LogStatus.FAIL, scenario.getName()+"\n"
                +extentTest.addScreenCapture(screenshotPath));
        }
    }

