package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class logintest {

    private static WebDriver driver;

    private static LoginPage loginPage = new LoginPage();

    public logintest(){
        driver = Hooks.driver;

    }


    @Given("Pengguna mengakses halaman login")
    public void Pengguna_mengakses_halaman_login() {
        driver.get("https://www.saucedemo.com/");

    }

    @When("Pengguna memasukan username yang valid")
    public void Pengguna_memasukan_username_yang_valid(){
        loginPage.inputUsername("standard_user");

    }

    @And("Pengguna memasukkan password kredensial yang valid")
    public void Pengguna_memasukkan_password_kredensial_yang_valid(){
        loginPage.inputPassword("secret_sauce");

    }

    @And("Pengguna menekan tombol Login")
    public void Pengguna_menekan_tombol_Login(){
        loginPage.clickBtnLogin();

    }

    @Then("User berhasil login dan diarahkan ke halaman utama")
    public void User_berhasil_login_dan_diarahkan_ke_halaman_utama(){
        Assert.assertEquals(loginPage.getTxtDashboard(),"Products");

    }


//Negative Case ------------------------------------------------------------------------------


    @Given("Pengguna berada pada halaman login")
    public void Pengguna_berada_pada_halaman_login(){
        loginPage.formBtnLogout();

    }

    @And("Pengguna memasukkan password kredensial yang tidak valid")
    public void Pengguna_memasukkan_password_kredensial_yang_tidak_valid(){
        loginPage.inputPassword("admin123");

    }

    @Then("User tidak berhasil login dan mendapatkan feedback invalid credential")
    public void User_tidak_berhasil_login_dan_mendapatkan_feedback_invalid_credential(){
        Assert.assertEquals(loginPage.getTxtInvalid(),"Epic sadface: Username and password do not match any user in this service");

    }

}

