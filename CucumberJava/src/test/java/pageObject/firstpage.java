package pageObject;
import org.openqa.selenium.WebElement;

import testCommon.basePage;

/**
 * 百度首页
 * po模式：页面元素操作和用例代码分离
 * 1、存储页面所需要的定位元素(搜索文本框、按钮)
 * 2、元素对应的基本操作(输入内容、点击)
 */



public class firstpage extends  basePage {
//搜索框
	public String searchInput="#kw";
//搜索按钮
	public String searchbutton="#su";

	public void searchInputSendkey(String keyword) {
		
		WebElement element=waitElementVisible(ElementWays("css",searchInput));
		sendValues(element,keyword);
	}
	public void searchInputClick() {
		WebElement element=waitElementVisible(ElementWays("css",searchbutton));
		clickButton(element);
	}
}
