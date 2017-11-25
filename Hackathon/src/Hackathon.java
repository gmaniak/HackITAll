
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Hackathon {

    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        URL url = new URL("https://maps.googleapis.com/maps/api/staticmap?center=Bucharest&zoom=13&size=1920x1600&maptype=roadmap" +
"&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318" +
"&markers=color:red%7Clabel:C%7C40.718217,-73.998284" +
"&key=AIzaSyBPdzxz3LQzNkM5u3Fcn-4wvdxOWFEDK9g");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        System.out.println(status);
        
        Image image = null;
        try {
            image = ImageIO.read(url);
            File output = new File("out.jpg");
            ImageIO.write((RenderedImage) image, "jpg", output);
        } catch (IOException e) {
        }
        
        

    }
}
