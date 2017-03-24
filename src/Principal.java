import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author josePablo
 * Esta es la clase principal donde leeremos los archivos de texto y realzaremos la transcripción
 */
public class Principal {
    public static void main(String[] args) throws IOException{
        
        String palabras;
        String[] datos;
        BSTree<Association> tree= null;
        String cadena = "";
   
        
        BufferedReader bf = new BufferedReader(new FileReader ("C:\\Users\\JoséPablo\\Documents\\NetBeansProjects\\BinaryTree\\HDT7\\src\\diccionario.txt"));
        while ((palabras = bf.readLine()) != null) {
            palabras = palabras.replaceAll("[()]", "");
            datos = palabras.split("\\s*,\\s*");
            
            Association socio = new Association(datos[0],datos[1]);
            
            if(tree==null)
                tree = new BSTree(socio);
            else
                tree.Insertar(socio);
	}

        
        BufferedReader bft = new BufferedReader(new FileReader ("C:\\Users\\JoséPablo\\Documents\\NetBeansProjects\\BinaryTree\\HDT7\\src\\texto.txt"));
        StringBuilder oracion = new StringBuilder();
        while ((palabras = bft.readLine()) != null){
            oracion.append(palabras);
            oracion.append(" ");
        }
        String orac = oracion.toString();
        String [] traduccion = orac.split(" ");
        for(int i=0; i<traduccion.length;i++){
            //traduccion[i] = traduccion[i].replaceAll("[^\\w]", "");
            cadena = cadena + tree.transcripcion(traduccion[i]);
        }
        
        System.out.print(cadena);
        
        
        
       
	
        
    }   
}
