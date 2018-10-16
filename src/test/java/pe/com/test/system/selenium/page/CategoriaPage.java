package pe.com.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.test.system.selenium.driver.VisorDriver;
public class CategoriaPage {
	
	private By message = By.id("messages");

	private WebDriver webDriver = null;

	public CategoriaPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public String hacerClicBotonNuevo() throws Exception {
		this.webDriver.findElement(By.id("btnNuevo")).click();
		Thread.sleep(2000);
		return this.webDriver.findElement(message).getText();
	}

	public void escribirCampoNombre(String string) {
		try {
			this.webDriver.findElement(By.id("txtNombre")).sendKeys("string");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cerrarPagina() {
		VisorDriver.cerrarPagina(this.webDriver);
	}
}

