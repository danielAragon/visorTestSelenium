package pe.com.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.com.test.system.selenium.driver.VisorDriver;

public class IniciarSesionPage {

	private By cajaUsuario = By.id("txtUsuario"); 
	private By cajaClave = By.id("txtClave");
	private By botonIniciarSesion = By.id("btnIniciarSesion");
	private WebDriver webDriver = null;
	
	public IniciarSesionPage(String navegador, boolean remoto) {
		this.webDriver = VisorDriver.inicializarDriver(navegador, remoto);
	}
	
	public void ingresarPaginaIniciarSesion(String url) throws Exception{
		this.webDriver.get(url);
	}
	
	public void iniciarSesion(String usuario, String clave) throws Exception{
		this.webDriver.findElement(cajaUsuario).clear();
		this.webDriver.findElement(cajaUsuario).sendKeys(usuario);
		this.webDriver.findElement(cajaClave).clear();
		this.webDriver.findElement(cajaClave).sendKeys(clave);
		this.webDriver.findElement(botonIniciarSesion).click();
	}
	
	public void cerrarPagina() throws Exception{
		VisorDriver.cerrarPagina(this.webDriver);
	}
	
	public WebDriver getWebDriver() {
		return this.webDriver;
	}
}