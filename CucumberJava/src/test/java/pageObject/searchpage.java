package pageObject;

import org.openqa.selenium.WebElement;

import testCommon.basePage;

public class searchpage extends  basePage {

	public String resultLabel="nums_text";
	
	public String resultLabelgetText() {
		WebElement element=waitElementVisible(ElementWays("classname",resultLabel));
		return getText(element);
	}
	
}
