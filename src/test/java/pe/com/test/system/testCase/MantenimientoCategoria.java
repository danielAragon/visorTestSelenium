package pe.com.test.system.testCase;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pe.com.test.system.selenium.page.BienvenidaPage;
import pe.com.test.system.selenium.page.CategoriaPage;
import pe.com.test.system.selenium.page.IniciarSesionPage;

public class MantenimientoCategoria {
	
	private IniciarSesionPage iniciarSesionPage;
	private BienvenidaPage bienvenidaPage;
	private CategoriaPage categoriaPage;
	
	@BeforeTest
	@Parameters({"navegador","remoto"})
	public void antesDelTest(String navegador, int remoto) {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, remoto == 1);
		this.bienvenidaPage = new BienvenidaPage(this.iniciarSesionPage.getWebDriver());
		this.categoriaPage = new CategoriaPage(this.bienvenidaPage.getWebDriver());
	}
	
	@Test
	public void insertarCategoria_Criterio01() {
		try {
			String valorEsperado = "Se guardó de manera correcta la Categoría";
			this.iniciarSesionPage.ingresarPaginaIniciarSesion("http://localhost:8080/VisorWeb/");
			this.iniciarSesionPage.iniciarSesion("admin","clave");
			
			this.bienvenidaPage.hacerClicMenuPrincipal();
			this.bienvenidaPage.hacerClicModAlmacen();
			this.bienvenidaPage.hacerClicMntCategoria();
		
			this.categoriaPage.hacerClicBotonNuevo();
			this.categoriaPage.escribirCampoNombre("Chocolates");
			
			String valorObtenido = this.categoriaPage.hacerClicBotonNuevo();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = {"insertarCategoria_Criterio01"})
	public void insertarCategoria_Criterio02() {
		try {
			String valorEsperado = "Nombre: Validation Error: Value is required";
			this.iniciarSesionPage.ingresarPaginaIniciarSesion("https://localhost:8080/VisorWeb/");
			this.iniciarSesionPage.iniciarSesion("admin","clave");
			
			this.bienvenidaPage.hacerClicMenuPrincipal();
			this.bienvenidaPage.hacerClicModAlmacen();
			this.bienvenidaPage.hacerClicMntCategoria();
		
			this.categoriaPage.hacerClicBotonNuevo();
			this.categoriaPage.escribirCampoNombre("");
			
			String valorObtenido = this.categoriaPage.hacerClicBotonNuevo();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@AfterTest
	public void despuesDelTest() {
		try {
			this.categoriaPage.cerrarPagina();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
