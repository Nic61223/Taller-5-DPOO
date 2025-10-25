package uniandes.dpoo.hamburguesas.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest {
	private ProductoAjustado producto;
	
	@BeforeEach
	void setup() throws Exception{
		ProductoMenu producto1 = new ProductoMenu("Papas", 10000);
		
		producto = new ProductoAjustado(producto1);
	}
	@AfterEach
	void tearDown() {
		producto = null;
	}
	
	@Test
	void testGetNombre() {
	assertEquals("Papas", producto.getNombre(),"El producto no se creo correctamente");
	
	}
	@Test
	void testAgregarIngrediente(){
		Ingrediente ingrediente = new Ingrediente("tomate", 4000);
		producto.agregarIngrediente(ingrediente);
		assertEquals(1,producto.getAgregados().size(),"No se agrego un ingrediente correctamente");
	}
	@Test
	void testEliminarIngrediente(){
		Ingrediente ingrediente = new Ingrediente("tomate", 4000);
		producto.eliminarIngrediente(ingrediente);
		assertEquals(1,producto.getEliminados().size(),"No se agrego un ingrediente correctamente");
	}
	@Test
	void testGetPrecio() {
		Ingrediente ingrediente = new Ingrediente("tomate", 4000);
		producto.agregarIngrediente(ingrediente);
		assertEquals(14000, producto.getPrecio(),"El precio del productoAjustado no fue calculado correctamente");
		
	  }

	@Test
	void testGenerarTextoFactura() {
		Ingrediente ingrediente1 = new Ingrediente("Queso", 2000);
		Ingrediente ingrediente2 = new Ingrediente("Tocineta", 3000);
		Ingrediente eliminado = new Ingrediente("Lechuga", 0);

		producto.agregarIngrediente(ingrediente1);
		producto.agregarIngrediente(ingrediente2);
		producto.eliminarIngrediente(eliminado);

		String texto = producto.generarTextoFactura();

		assertTrue(texto.contains("Papas"));

		for (Ingrediente ingrediente : producto.getAgregados()) {
			assertTrue(texto.contains("+" + ingrediente.getNombre()));
			assertTrue(texto.contains(String.valueOf(ingrediente.getCostoAdicional())));
		}

		for (Ingrediente ingrediente : producto.getEliminados()) {
			assertTrue(texto.contains("-" + ingrediente.getNombre()));
		}

		assertTrue(texto.contains(String.valueOf(producto.getPrecio())));
	}
	
	@Test
	void testGetEliminados() {
		assertEquals(0,producto.getEliminados().size());
	}
	
	}
	
	
