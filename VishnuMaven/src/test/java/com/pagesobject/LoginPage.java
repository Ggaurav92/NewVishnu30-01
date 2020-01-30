package com.pagesobject;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) { 
		 // initializing instance variable with local variable
		 this.driver = driver;
		 // This initElements method will create all WebElemnts
		 PageFactory.initElements(driver, this);
		 }
	
	

	
	 @FindBy(id="ap_email") 
	 private WebElement EmailInpBox;
	 public void EnterEmail(String eml) {
		 
		 EmailInpBox.sendKeys(eml);
	 }
	 
	 @FindBy(id="continue") 
	 private WebElement ContinueBtnLogin;
	 
	 @FindBy(id="ap_password") 
	 private WebElement PasswordInpBox;
	 
	 @FindBy(id="signInSubmit") 
	 private WebElement SignInClick;
	 
	public void LogintoAccount(String UName, String pwd) {
		
		//System.out.println(userName);
		System.out.println(pwd);
		//driver.findElement(By.id("ap_email")).sendKeys(userName);
		String userName = UName;
		String password = pwd;
		EmailInpBox.sendKeys(userName);
		ContinueBtnLogin.click();
		PasswordInpBox.sendKeys(password);
		SignInClick.click();
		CaptchaHandle(password);
		

		  	}
	
	
	 @FindBy(xpath="//span[@class= 'a-list-item']") 
	 private WebElement CaptchaHeadTxt;
	 
	 @FindBy(id="auth-captcha-guess") 
	 private WebElement CaptchaTextbox;
	 
	public void CaptchaHandle(String password) {
		String captchaText = "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.";
		  try {
			  
		   while(captchaText.equals(CaptchaHeadTxt.getText())) { 
		    
		      // prompt user to enter captcha
		      String captchaVal1 = JOptionPane.showInputDialog("Please enter the captcha value : ");
		      CaptchaTextbox.sendKeys(captchaVal1);
		      PasswordInpBox.sendKeys(password);
		      SignInClick.click();
		    		    }
		  } catch (Exception e) {
		   System.out.println("Captcha didn't appear..");
		  }

		
	}

	String driverLoc = "C:\\Training\\Jar Files\\Drivers\\chromedriver.exe";
	public void LaunchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver",driverLoc);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	
	

}
