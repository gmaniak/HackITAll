
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
        URL url = new URL("https://maps.googleapis.com/maps/api/staticmap?center=Australia&size=640x400&style=element:labels|visibility:off&style=element:geometry.stroke|visibility:off&style=feature:landscape|element:geometry|saturation:-100&style=feature:water|saturation:-100|invert_lightness:true&key=AIzaSyBPdzxz3LQzNkM5u3Fcn-4wvdxOWFEDK9g");
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
