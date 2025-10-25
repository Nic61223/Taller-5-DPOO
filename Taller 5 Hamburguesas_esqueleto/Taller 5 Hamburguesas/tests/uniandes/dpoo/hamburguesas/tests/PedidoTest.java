	package uniandes.dpoo.hamburguesas.tests;
	
	import static org.junit.jupiter.api.Assertions.assertTrue;
	import static org.junit.jupiter.api.Assertions.assertEquals;

	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.AfterEach;

	
	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	

	
	import uniandes.dpoo.hamburguesas.mundo.Pedido;
	import uniandes.dpoo.hamburguesas.mundo.Producto;
	import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
	import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
	
	public class PedidoTest {
		private Pedido pedido;
		
		@BeforeEach
		void setup() throws Exception{
			pedido = new Pedido("IVANCHO", "Universidad de los Andes");
			ProductoMenu producto = new ProductoMenu("Papas Medianas",12000);
			ProductoMenu producto2 = new ProductoMenu("Hamburguesa", 18000);
			pedido.agregarProducto(producto);
			pedido.agregarProducto(producto2);
	
		}
		
		@AfterEach
		void  tearDown() throws Exception{
			pedido = null;
		} 
		
		@Test
		void testCrearPedido(){
			assertEquals("IVANCHO", pedido.getNombreCliente(), "Pedido generado incorrectamente");
	
		}
		
		
		
		
		@Test
		void testAgregarProducto () {
			ProductoMenu producto3 = new ProductoMenu("Té", 6000);
			pedido.agregarProducto(producto3);
			
			assertEquals(3,pedido.getProductos().size(), "No se agrego el producto correctamente");
			assertEquals(producto3, pedido.getProductos().getLast(), "El producto agragado no es el correcto");
			
		}
		
		@Test
		void testPrecioPedido() {
			assertEquals(35700, pedido.getPrecioTotalPedido(),"El precio no fue calculado correctamente" );
			
		}
		
		@Test
		void testGenerarTextofactura() {
			String factura = pedido.generarTextoFactura();
			assertTrue(factura.contains(pedido.getNombreCliente()));
			assertTrue(factura.contains(String.valueOf(pedido.getPrecioTotalPedido())));
			for(Producto producto : pedido.getProductos()) {
				assertTrue(factura.contains(producto.generarTextoFactura()));
			}
			
		}
		
		@Test
		void testGuardarFactura(){
			File archivo = new File("factura.txt");
			
			try {
				pedido.guardarFactura(archivo);
	
				String linea = Files.readString(Paths.get("factura.txt"));
				for(Producto producto : pedido.getProductos()) {
					assertTrue(linea.contains(producto.generarTextoFactura()));
				}
				archivo.delete();
	
			}
			
			catch(IOException e){
				System.err.println("No se encontro el archivo");
				archivo.delete();
			}
			
		}
		
		
		
	
		
		
		
		
	}
