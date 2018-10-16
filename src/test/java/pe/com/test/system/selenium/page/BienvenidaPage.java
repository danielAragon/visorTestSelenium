package pe.com.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BienvenidaPage {
	private By linkMenu = By.xpath("/html/body/section/div[1]/div");
	private By linkModAlmacen = By.xpath("/html/body/section/div[1]/nav/ul/li/span");
	private By linkMntCategoria = By.linkText("Mnt. de Categoría");
	private WebDriver webDriver = null;
	
	public BienvenidaPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void hacerClicMenuPrincipal() throws Exception{
		this.webDriver.findElement(linkMenu).click();
		Thread.sleep(2000);
	}
	
	public void hacerClicModAlmacen() throws Exception{
		this.webDriver.findElement(linkModAlmacen).click();
		Thread.sleep(2000);
	}
	
	
	public WebDriver getWebDriver() {
		return this.webDriver;
	}

	public void hacerClicMntCategoria() throws Exception {
		this.webDriver.findElement(linkMntCategoria).click();
		Thread.sleep(2000);		
	}
}
