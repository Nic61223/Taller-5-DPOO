package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {

	
		private ProductoMenu producto;
		
		
	@BeforeEach
	void setup() throws Exception{
		producto =  new ProductoMenu("Arroz", 12000);
	}
	
	@AfterEach
	void tearDown() throws Exception{
		this.producto = null;
	}
	
	@Test
	void testGetName() {
		assertEquals("Arroz", producto.getNombre(),"El nombre del producto dentro del menu es incorrecto");
		
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(12000, producto.getPrecio(), "El precio obtenido fue incorrecto");
	}
	
    @Test
    void testGenerarTextoFactura() {
        StringBuffer sb = new StringBuffer();
        sb.append("Arroz\n");
        sb.append("            12000\n");

        assertEquals(sb.toString(), producto.generarTextoFactura(),"El texto generado no es correspondiente");
    }
	
}
