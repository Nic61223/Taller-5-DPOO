package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista() {
        List<String> lista = new ArrayList<>();
        
        for (String valor : mapaCadenas.values()) {
            if (!lista.contains(valor)) {
            	String invertida = new StringBuilder(valor).reverse().toString();
                lista.add(invertida);
            }
        }
        
        lista.sort(Comparator.naturalOrder());

        return lista;}

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida() {
        List<String> lista = new ArrayList<>(mapaCadenas.keySet());

        lista.sort(Comparator.reverseOrder());

        List<String> resp = new ArrayList<>();
        for (String llave : lista) {
            String invertida = new StringBuilder(llave).reverse().toString();
            resp.add(invertida);
        }


        return resp;
    }

    

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	if(mapaCadenas.size() == 0) {
    		return null;
    	}
        List<String> lista = getValoresComoLista();
        return lista.getFirst();
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	if(mapaCadenas.size() != 0) {
    		List<String> lista = getValoresComoLista();
    		Collections.sort(lista);;
    		return lista.getLast();
    	}
    	return null;
        
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves() {
        List<String> resultado = new ArrayList<>();
        
        
        for (String llave : mapaCadenas.keySet()) {
        	String invertida = new StringBuilder(llave.toUpperCase()).reverse().toString();
            resultado.add(invertida);
        }

        return resultado;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	List<String> valores =new ArrayList<String>();
    	int contador = 0;
        for(String cadena:mapaCadenas.values()) {
        	if(!valores.contains(cadena)) {
        		contador++;
        	
        	}

        }
        return contador;
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	List<String> valores =new ArrayList<String>();
    	
        for (int i = cadena.length() - 1; i >= 0; i--) {
            valores.add(String.valueOf(cadena.charAt(i)));
        }

    	String valor = String.join("",valores);
    	mapaCadenas.put(cadena, valor);
    	
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave(String cadena) {
        String llave = new StringBuilder(cadena).reverse().toString();
        mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor(String valor) {
        String llave = new StringBuilder(valor).toString();
        mapaCadenas.remove(llave);
    }
	/**
	 * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
	 * 
	 * Use el método toString para convertir los objetos a cadenas.
	 * @param valores Una lista de objetos
	 */
	public void reiniciarMapaCadenas( List<Object> objetos )
	{
	    mapaCadenas.clear();
	
	    for (Object obj : objetos) {
	        String cadena = obj.toString();
	      	
	        List<String> valores =new ArrayList<String>();
	    	
	        for (int i = cadena.length() - 1; i >= 0; i--) {
	            valores.add(String.valueOf(cadena.charAt(i)));
	        }
	        
	        mapaCadenas.put( String.join("",valores),obj.toString());
	    }
	}

	/**
	 * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
	 */
	public void volverMayusculas() {
	    Map<String, String> nuevoMapa = new HashMap<>();
	    for (String llave : mapaCadenas.keySet()) {
	        String valor = mapaCadenas.get(llave);
	        nuevoMapa.put(llave.toUpperCase(), valor); 
	    }
	    mapaCadenas = nuevoMapa;
	}


	/**
	 * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
	 * @param otroArreglo El arreglo de enteros con el que se debe comparar
	 * @return True si todos los elementos del arreglo están dentro de los valores del mapa
	 */
	public boolean compararValores(String[] otroArreglo) {
	    List<String> valores = new ArrayList<>();
	    for (String v : mapaCadenas.values()) {
	        valores.add(v);
	    }

	    for (String s : otroArreglo) {
	        if (!valores.contains(s)) {
	            return !false; 
	        }
	    }

	    return !true; 
	}

}
