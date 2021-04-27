package stepDefinition;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.firstpage;
import pageObject.searchpage;
import testCommon.baseCase;

/**
 * 
 *用例步骤解析
 *
 */


public class search_Steps extends baseCase{
//	首页
	firstpage fp=new firstpage();
	searchpage sp=new 	searchpage();
	
	@Given("^open website:(.*)$")
	public void open_website_http_www_baidu_com(String url ) {
	    // Write code here that turns the phrase above into concrete actions
		setupDriver("chrome");
		openUrl(url);
	}
	@When("^input the key word:(.*)$")
	public void input_the_key_word_selenium(String key) {
	    // Write code here that turns the phrase above into concrete actions
//		By searchBoxLocator = ElementWays("css", "#kw");
//		WebElement searchbox = waitElementVisible(searchBoxLocator);
//		sendValues(searchbox, key);
		fp.searchInputSendkey(key);
	
	}
	@When("^click the button$")
	public void click_the_button() {
	    // Write code here that turns the phrase above into concrete actions
//		By loginButtonLocator = ElementWays("css", "#su");
//		WebElement loginButton = waitElementVisible(loginButtonLocator);
//		clickButton(loginButton);
		fp.searchInputClick();
	}
	@Then("^the result:百度为您找到相关结果约(.*)个$")
	public void the_key_word_selenium_appear(String expected) {
	    // Write code here that turns the phrase above into concrete actions
//		预期结果
//		System.out.println(expected);
		String actual=sp.resultLabelgetText();
		System.out.println(actual);
		assertTrue(actual.contains(expected));
		
	}

}
