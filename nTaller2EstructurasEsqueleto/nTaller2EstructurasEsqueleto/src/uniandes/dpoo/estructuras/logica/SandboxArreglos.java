package uniandes.dpoo.estructuras.logica;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( ){
    	return arregloEnteros.clone();
    	
    	
    }


    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas() {
    	return arregloCadenas.clone();
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
        
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
        
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */

    public void agregarEntero(int entero) {
        int[] copia = new int[arregloEnteros.length + 1];
        for (int i = 0; i < arregloEnteros.length; i++) {
            copia[i] = arregloEnteros[i];
        }
        copia[copia.length - 1] = entero;
        arregloEnteros = copia;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena(String cadena) {
        String[] copia = new String[arregloCadenas.length + 1];
        for (int i = 0; i < arregloCadenas.length; i++) {
            copia[i] = arregloCadenas[i];
        }
        copia[copia.length - 1] = cadena;
        arregloCadenas = copia;
    }
    

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero(int valor) {
        int contador = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                contador++;
            }
        }

        int[] copia = new int[arregloEnteros.length - contador];
        int vigia = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != valor) {
                copia[vigia] = arregloEnteros[i];
                vigia++;
            }
        }

        arregloEnteros = copia; 
    }
    					
    	
    		
    

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena ) {

        int contador = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i].equals(cadena)) { 
                contador++;
            }
        }

        String[] copia = new String[arregloCadenas.length - contador];
        int vigia = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (!arregloCadenas[i].equals(cadena)) {
                copia[vigia] = arregloCadenas[i];
                vigia++;
            }
        }

        arregloCadenas = copia;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero(int entero, int posicion) {
        int[] copia = new int[arregloEnteros.length + 1];

        if (posicion < 0) {
             copia[0] = entero;
            for (int i = 0; i < arregloEnteros.length; i++) {
                copia[i + 1] = arregloEnteros[i];
            }
        } 
        else if (posicion >= arregloEnteros.length) {
            for (int i = 0; i < arregloEnteros.length; i++) {
                copia[i] = arregloEnteros[i];
            }
            copia[arregloEnteros.length] = entero;
        } 
        else {
            for (int i = 0; i < posicion; i++) {
                copia[i] = arregloEnteros[i];
            }
            copia[posicion] = entero;
            for (int i = posicion; i < arregloEnteros.length; i++) {
                copia[i + 1] = arregloEnteros[i];
            }
        }

        arregloEnteros = copia;
    }
    	
    	
    	
   


    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (posicion<0 || posicion >= arregloEnteros.length) {
    		return;}
		
    		
    		
    	int[]copia = new int[arregloEnteros.length-1];
		for (int i = 0; i < posicion;i++) {
			copia[i]= arregloEnteros[i];
		}
		for(int i = posicion+1; i < arregloEnteros.length; i ++) {
			copia[i-1] = arregloEnteros[i];
			
		}
		arregloEnteros = copia;
		
	}
    	
    	
    

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] copia = new int[valores.length];
    	for ( int i= 0; i< valores.length; i++) {
    		int a = (int) valores[i];
    		copia[i] = a;
    	}
    	arregloEnteros = copia;

    	}
    

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas(Object[] objetos) {
        String[] copia = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            copia[i] = objetos[i].toString();
        }
        arregloCadenas = copia;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    for (int i = 0; i  < arregloEnteros.length;i++) {
    	int a = arregloEnteros[i];
    	if (a<0) {
    		a = a*-1;
    		arregloEnteros[i] = a;
    		
    	}
    }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int contador = 0;
    	for(int i = 0; i< arregloEnteros.length;i++) {
    		if (arregloEnteros[i] == valor) {
    			contador ++;
    		}
    	}
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones(String cadena) {
        int contador = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i].equalsIgnoreCase(cadena)) { // 👈 cambio aquí
                contador++;
            }
        }
        return contador;
    }

    /**
/**
 * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
 * @param valor El valor que se debe buscar
 * @return Un arreglo con las posiciones del arreglo de enteros en las que se encuentra el valor buscado.
 *         Si el valor no se encuentra, se retorna un arreglo de tamaño 0.
 */
public int[] buscarEntero(int valor)  {
    int contador = 0;
    for (int i = 0; i < arregloEnteros.length; i++) {
        if (arregloEnteros[i] == valor) {
            contador++;
        }
    }
    int[] resultado = new int[contador];
    int indice = 0;
    for (int i = 0; i < arregloEnteros.length; i++) {
        if (arregloEnteros[i] == valor) {
            resultado[indice] = i;
            indice++;
        }
    }
    return resultado;
}

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	if (arregloEnteros.length == 0) {
    		return new int[0];
    	}
    	
    	int mayor = 0;
    	int menor = 10000000;
    	for (int i = 0; i < arregloEnteros.length;i++) {
    		if(arregloEnteros[i] > mayor) {
    			mayor = arregloEnteros[i];
    		}
    		if(arregloEnteros[i] < menor ) {
    			menor = arregloEnteros[i];
    			}
    		
    		}
    	int[] respuesta = new int[2];
    	respuesta[0] = menor;
    	respuesta[1] = mayor;
    	
    	return respuesta; 
    }
    

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma() {
        HashMap<Integer, Integer> histograma = new HashMap<>();

        for (int i = 0; i < arregloEnteros.length; i++) {
            int v = arregloEnteros[i];
            histograma.put(v, histograma.getOrDefault(v, 0) + 1);
        }

        return histograma;
    }
    

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    
    public int contarEnterosRepetidos() {
        if (arregloEnteros.length == 0) {
            return 0;
        }

        boolean[] yaContado = new boolean[arregloEnteros.length ];
        int contador = 0;

        for (int i = 0; i < arregloEnteros.length ; i++) {
            if (yaContado[i]) {
                continue; // este valor ya fue marcado como repetido
            }

            boolean repetido = false;
            for (int j = i + 1; j < arregloEnteros.length ; j++) {
                if (arregloEnteros[i] == arregloEnteros[j]) {
                    repetido = true;
                    yaContado[j] = true; // marcamos todas las repeticiones
                }
            }

            if (repetido) {
                yaContado[i] = true;
                contador++;
            }
        }
        System.out.println(contador);
        return contador;
    }




    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if(otroArreglo.length == 0 || arregloEnteros.length ==0) {
        	return false;
        }
        	for(int i = 0; i < arregloEnteros.length; i++) {
        	if(arregloEnteros[i]!= otroArreglo[i]) {
        		return false;
        	}
        }
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros(int[] otroArreglo) {
        if (otroArreglo.length != arregloEnteros.length) {
            return false;
        }

        for (int i = 0; i < arregloEnteros.length; i++) {
            int valor = arregloEnteros[i];
            if (contarApariciones(valor, arregloEnteros) != contarApariciones(valor, otroArreglo)) {
                return false;
            }
        }

        return true;
    }
    //metodo auxiliar par funcion de arriba :) (no se si es legal)
    private int contarApariciones(int valor, int[] arreglo) {
        int contador = 0;
        for (int v : arreglo) {
            if (v == valor) {
                contador++;
            }
        }
        return contador;
    }
    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros(int cantidad, int minimo, int maximo) {
        int[] copia = new int[cantidad];

        if (cantidad > 0) {
            copia[0] = minimo;
        }
        if (cantidad > 1) {
            copia[cantidad - 1] = maximo;        }

        for (int i = 1; i < cantidad - 1; i++) {
            int valor = minimo + (int)(Math.random() * (maximo - minimo + 1));
            copia[i] = valor;
        }

        arregloEnteros = copia;
    }

}
