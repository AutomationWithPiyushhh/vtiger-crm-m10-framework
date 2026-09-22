package pom_extra;

import org.openqa.selenium.WebElement;

public class DynamicXpath {
	public static void main(String[] args) {
		String orgName = "automationwithpiyush";

		String xpathValue1 = "//a[text()='orgName']";
		String xpathValue2 = "//a[text()='" + orgName + "']";

//		driver.findElement(By.xpath("//a[text()='" + orgName + "']"));
		
//		@FindBy(xpath =  "//a[text()='" + orgName + "']" )
//		private WebElement element;
		
		System.out.println(xpathValue1);
		System.out.println(xpathValue2);
}
}
