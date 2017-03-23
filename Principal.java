import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Principal {
    

BufferedReader br;

    public Principal() throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader("texto.txt"));
    }
    
    
    
    
}
