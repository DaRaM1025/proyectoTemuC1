package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;



/**
 * Clase que gestiona la creación y manipulación de archivos en el sistema.
 * Permite la creación de carpetas, la escritura en archivos de texto y la
 * serialización de objetos.
 *
 * @author Nataly Rengifo
 */
public class FileManager {
	/**
	 * Objeto de tipo File que buscará un archivo
	 */
	private static File archivo;
	/**
	 * Scanner que permite leer los archivos
	 */
	private static Scanner lectorArchivoTexto;
	/**
	 * PrintWriter que permite escribir en los archivos
	 */
	private static PrintWriter escritorArchivoTexto;
	/*
	 * Ubicación de donde se van a crear los archivos
	 */

	private static final String RUTA_CARPETA =
	        System.getProperty("user.home") + File.separator + "Documents";

	/**
	 * Flujo de salida de archivo utilizado para escribir objetos en un archivo.
	 */
	private static FileOutputStream fos;

	/**
	 * Flujo de salida de objetos utilizado para serializar objetos en un archivo.
	 */
	private static ObjectOutputStream oos;

	/**
	 * Flujo de entrada de archivo utilizado para leer datos de un archivo.
	 */
	private static FileInputStream fis;

	/**
	 * Flujo de entrada de objetos utilizado para deserializar objetos desde un
	 * archivo.
	 */
	private static ObjectInputStream ois;

	/**
	 * Método que crea la carpeta especificada en la ruta, en caso de que no exista.
	 */
	private static void crearCarpeta() {
	    File carpeta = new File(RUTA_CARPETA);
	    if (!carpeta.exists()) {
	        boolean creada = carpeta.mkdirs();
	        System.out.println("¿Carpeta si se creo?: " + creada + " ->aqui " + carpeta.getAbsolutePath());
	    } else {
	        System.out.println("la carpeta existe en la ruta: " + carpeta.getAbsolutePath());
	    }
	}

	/**
	 * Método que escribe contenido en un archivo de texto. Si el archivo no existe,
	 * lo crea.
	 *
	 * @param nombreArchivo El nombre del archivo en el que se escribirá el
	 *                      contenido.
	 * @param contenido     El contenido que se escribirá en el archivo.
	 */
	public static void escribirEnArchivoTexto(String nombreArchivo, String contenido) {
		try {
			archivo = new File(RUTA_CARPETA + File.separator + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritorArchivoTexto = new PrintWriter(new FileOutputStream(archivo, false));

			escritorArchivoTexto.println(contenido);

			escritorArchivoTexto.close();

		} catch (IOException e) {
			System.out.println("Error al crear el archivo (escritura)");
			e.printStackTrace();

		}
	}

	/**
	 * Método que escribe en un archivo de forma serializada. Si el archivo no
	 * existe, lo crea.
	 *
	 * @param nombreArchivo El nombre del archivo en el que se escribirá.
	 * @param contenido     El objeto que se escribirá en el archivo.
	 */
	public static void escribirArchivoSerializado(String nombreArchivo, Object contenido) {
	    try {
	        crearCarpeta(); 
	        File archivo = new File(RUTA_CARPETA, nombreArchivo);

	       
	        System.out.println("Guardando en: " + archivo.getAbsolutePath());

	        if (!archivo.exists()) {
	            archivo.createNewFile();
	            System.out.println("Archivo creado en: " + archivo.getAbsolutePath());
	        }

	        fos = new FileOutputStream(archivo);
	        oos = new ObjectOutputStream(fos);
	        oos.writeObject(contenido);
	        oos.close();
	        fos.close();

	        System.out.println("Escritura corrcta (" + nombreArchivo + ")");
	    } catch (Exception e) {
	        System.out.println("Error en la escritura del archivo serializado");
	        e.printStackTrace();
	    }
	}


	/**
	 * Método para leer el contenido de un archivo de texto y lo devuelve como una
	 * cadena de caracteres. Si el archivo no existe, lo crea.
	 *
	 * @param nombreArchivo El nombre del archivo que se va a leer.
	 * @return El contenido del archivo como una cadena, o null si ocurre un error.
	 */
	public static String leerArchivoTexto(String nombreArchivo) {
		try {
			archivo = new File(RUTA_CARPETA + File.separator + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorArchivoTexto = new Scanner(archivo);
			String contenido = "";
			while (lectorArchivoTexto.hasNext()) {
				contenido += lectorArchivoTexto.nextLine() + "\n";

			}

			lectorArchivoTexto.close();

			return contenido;
		} catch (IOException e) {
			System.out.println("Error al crear el archivo (lectura)");
			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Método que lee un objeto de un archivo de forma serializada. Si el archivo no
	 * existe o está vacío, devuelve null.
	 *
	 * @param nombreArchivo El nombre del archivo desde el cual se leerá el objeto.
	 * @return El objeto leído del archivo, o null si el archivo no existe o está
	 *         vacío.
	 */
	public static Object leerArchivoSerializado(String nombreArchivo) {
	    Object contenido = null;
	    try {
	        crearCarpeta(); 
	        File archivo = new File(RUTA_CARPETA, nombreArchivo);

	       
	        System.out.println("Leyendo desde: " + archivo.getAbsolutePath());

	        if (!archivo.exists() || archivo.length() == 0) {
	            System.out.println("el Archivo no existe o está vacío");
	            return null;
	        }

	        fis = new FileInputStream(archivo);
	        ois = new ObjectInputStream(fis);
	        contenido = ois.readObject();
	        fis.close();
	        ois.close();

	        System.out.println("lectura correcta (" + nombreArchivo + ")");
	    } catch (IOException e) {
	        System.out.println("Error al leer archivo serializado");
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        System.out.println("Error: Clase no encontrada en el archivo");
	        e.printStackTrace();
	    }
	    return contenido;

	}
}