import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileProcessingException extends Exception {
    
    public FileProcessingException(String message) {
        super(message);
    }

    
    public FileProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}


public class FileProcessor {

    
    public void processFile(String filePath) throws FileProcessingException {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  
            }
        } catch (IOException e) {
           throw new FileProcessingException("Error processing the file: " + filePath, e);
        }
    }

    public static void main(String[] args) {
        
        FileProcessor processor = new FileProcessor();

        
        String filePath = "example.txt";  
        try {
            processor.processFile(filePath);  
        } catch (FileProcessingException e) {
            
            System.err.println("Custom exception caught: " + e.getMessage());
            e.printStackTrace();  
        }
    }
}
