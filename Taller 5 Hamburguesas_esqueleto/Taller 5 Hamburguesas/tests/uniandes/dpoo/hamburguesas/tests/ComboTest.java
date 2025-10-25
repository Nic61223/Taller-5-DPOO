package uniandes.dpoo.hamburguesas.tests;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {

	private Combo combo;
	
	@BeforeEach
	void setUp() throws Exception{
		ArrayList<ProductoMenu> items = new ArrayList<ProductoMenu>();
		items.add(new ProductoMenu("Hamburguesa", 16000));
		items.add(new ProductoMenu("Papas", 8000));
		
		
		combo = new Combo("gold", 0.5,items);
		
	}
	
	@AfterEach
	void tearDown() throws Exception{
		combo = null;
	}
	
	@Test
	void testGetNombre() {
		assertEquals("gold", combo.getNombre(), "El nombre del combo creado no es el correcto");
		
	}
	
	
	@Test
	void testGetPrecio() {
		assertEquals(12000,combo.getPrecio(),"El precio del combo no es correcto");
		
	}
	@Test
	void testGenerarTextoFactura () {
	String texto = combo.generarTextoFactura();
	for (ProductoMenu item : combo.getProductos()) {
		assertTrue(texto.contains(item.getNombre()));
		assertTrue(texto.contains(String.valueOf(item.getPrecio())));
		
	}
}
	}
