
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, String> accounts = new HashMap<String, String>();
    
    public static void main(String[] args) throws FileNotFoundException {
        
        try {
            BufferedReader buf = new BufferedReader(new FileReader("accounts.txt"));
            String line;
        
            while ((line = buf.readLine()) != null) {
                String[] words = line.split(" ");
                accounts.put(words[0], words[1]);
            }

            buf.close();
        } catch (Exception e) {
            PrintWriter writer = new PrintWriter("accounts.txt");
            writer.close();
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
