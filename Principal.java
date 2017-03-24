import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Principal {
    public static void main(String[] args) throws IOException{
        
        String palabras;
        String ingles="";
        String español="";
        
        BSTNode<Association<String, String>> b = new BSTNode<>();
        
        BufferedReader bf = new BufferedReader(new FileReader ("texto.txt"));
        while ((palabras = bf.readLine()) != null) {
            palabras = palabras.replaceAll("[()]", "");
            String[] datos = palabras.split("\\s*,\\s*");
			
            b.insert(new Association<String, String>(datos[0], datos[1]));
			
	}
	
        
    }   
}
