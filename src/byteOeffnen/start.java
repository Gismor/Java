package byteOeffnen; /**
 * Created by dneubauer on 18.09.2015.
 */

import java.io.*;
public class start{

    public static void main(String[] args) {

        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("katze.jpg"))) {
            byte[] b = new byte[16];
            int c = 0;
            while ((c =bis.read(b)) != -1 ){
                System.out.println();
                for (int i = 0; i < c ; i++) {
                    int h = b[i];
                    if (h < 0) h = 256 + h;
                    String hex = Integer.toHexString(h).toUpperCase();
                    if (hex.length() == 1 ) hex = "0" + hex;
                    System.out.println(hex + "");
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim auslesen ...");
        }

    }

}










