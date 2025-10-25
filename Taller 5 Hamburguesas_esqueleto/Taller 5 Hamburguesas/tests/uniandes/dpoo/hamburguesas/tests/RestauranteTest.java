package uniandes.dpoo.hamburguesas.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {
	 public Restaurante restaurante;
	 
		@TempDir
		File tempDir;
		@TempDir
		File tempDir2;
		
		@TempDir
		File TempDir3;
		

	 
	 @BeforeEach
	 void setUp() {
		 restaurante = new Restaurante();
		 
	 }
	 @AfterEach
	 void tearDown() {
		 	restaurante = null;
	 }
	 
	 
	 @Test
	 void testIniciarPedido() {
		 try {
			restaurante.iniciarPedido("IVAN", "ML 701");
			assertNotNull(restaurante.getPedidoEnCurso());
			assertEquals("IVAN",restaurante.getPedidoEnCurso().getNombreCliente(), "el nombre del cliente enel pedido en curso no es el correcto");
		 }
		 catch (YaHayUnPedidoEnCursoException e) {
			e.printStackTrace();
		 }
		 
	 }
	 
	 @Test
	 void testCerrarYGuardarPedido() throws YaHayUnPedidoEnCursoException, NoHayPedidoEnCursoException, IOException{
		 restaurante.iniciarPedido("IVAN", "ML 701");
		 
		 restaurante.getPedidoEnCurso().agregarProducto(new ProductoMenu("papas", 14000));
		 restaurante.cerrarYGuardarPedido();
		 
		 assertNull(restaurante.getPedidoEnCurso());
	 }
	 
	 @Test
	 void testCargarMenu() throws IOException, NumberFormatException, HamburguesaException{
		 File archivoMenu = new File(tempDir,"Menu.txt");
		 FileWriter writer = new FileWriter(archivoMenu);
		 writer.write("Papas;16000\n");
		 writer.write("Gaseosa;4000");

		 writer.close();
		 
		 File ArchivoIngredientes = new File(tempDir2, "Ingredientes.txt");
		 FileWriter writer2 = new FileWriter(ArchivoIngredientes);
		 writer2.write("Tomate;4000\n");
		 writer2.write("cebolla;7000");

		 writer2.close();
		 File ArchivoCombos = new File(TempDir3, "Combos.txt");
		 FileWriter writer3 = new FileWriter(ArchivoCombos);
		 writer3.write("gold;100%;Papas;Gaseosa\n");
		 writer3.write("silver;50%;Papas\n");
		 writer3.write("coper;2%;Gaseosa");
		 writer3.close();
		 
		 
		 restaurante.cargarInformacionRestaurante(ArchivoIngredientes, archivoMenu, ArchivoCombos);
	 
		 assertEquals(2,restaurante.getMenuBase().size(),"Los productosMenu no se cargaron correctamente");
		 assertEquals(2,restaurante.getIngredientes().size(),"Los Ingedientes no se cargaron correctamente");
		 assertEquals(3,restaurante.getMenuCombos().size(),"Los productosMenu no se cargaron correctamente");
		 
	 
	 }
	 

	 
	 
	 @Test
	 void testGetPedidos() {
		 assertEquals(0,restaurante.getPedidos().size());
	 }
	 
	 
	 
		@Test
		void testCerrarYGuardarPedidoSinPedidoEnCurso() {
			assertThrows(NoHayPedidoEnCursoException.class, () -> {restaurante.cerrarYGuardarPedido();});
		}
		
		@Test
		void testIniciarPedidoCuandoYaHayUnoEnCurso() throws YaHayUnPedidoEnCursoException {
		    restaurante.iniciarPedido("IVANCHO", "W 204");
		    assertThrows(YaHayUnPedidoEnCursoException.class, () -> {
		        restaurante.iniciarPedido("YO XD", "Flamenco");
		    });
		}
		@Test
		void testCargarIngredientesRepetidos() throws Exception {
		    File archivoIngredientes = new File(tempDir, "ingredientes.txt");
		    FileWriter writer = new FileWriter(archivoIngredientes);
		    writer.write("Tomate;4000\n");
		    writer.write("Tomate;4000"); 
		    writer.close();

		    assertThrows(uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException.class, () -> {
		        restaurante.cargarInformacionRestaurante(archivoIngredientes, new File("menu.txt"), new File("combos.txt"));});
		}
		
		
		@Test
		void testCargarComboConProductoFaltante() throws Exception {
		    File archivoMenu = new File(tempDir, "menu.txt");
		    FileWriter writer = new FileWriter(archivoMenu);
		    writer.write("Papas;16000\n");
		    writer.close();

		    File ArchivoIngredientes = new File(tempDir2, "ingredientes.txt");
		    new FileWriter(ArchivoIngredientes).close();
		    
		    File archivoCombos = new File(TempDir3, "combos.txt");
		    FileWriter writer3 = new FileWriter(archivoCombos);
		    writer3.write("gold;10%;Hamburguesa"); 
		    writer3.close();

		    assertThrows(uniandes.dpoo.hamburguesas.excepciones.ProductoFaltanteException.class, () -> {
		        restaurante.cargarInformacionRestaurante(ArchivoIngredientes, archivoMenu, archivoCombos);
		    });
		}
		@Test
		void testCargarComboConRepeticion() throws Exception {
		    File archivoMenu = new File(tempDir, "menu.txt");
		    FileWriter writer = new FileWriter(archivoMenu);
		    writer.write("gold;10%;Hamburguesa;Hamburguesa");
		    writer.write("gold;10%;Hamburguesa;Hamburguesa");

		    writer.close();

			 File ArchivoIngredientes = new File(tempDir2, "Ingredientes.txt");
			 FileWriter writer2 = new FileWriter(ArchivoIngredientes);
			 writer2.write("Tomate;4000\n");
			 writer2.write("cebolla;7000");
			 writer2.write("cebolla;7000");

			 
		    File archivoCombos = new File(TempDir3, "combos.txt");
		    FileWriter writer3 = new FileWriter(archivoCombos);
		    writer3.write("c;10%;Hamburguesa"); 
		    writer3.write("c;10%;Hamburguesa"); 

		    writer3.close();

		    assertThrows(uniandes.dpoo.hamburguesas.excepciones.ProductoRepetidoException.class, () -> {
		        restaurante.cargarInformacionRestaurante(ArchivoIngredientes, archivoMenu, archivoCombos);
		    });
		}		



	 
}
