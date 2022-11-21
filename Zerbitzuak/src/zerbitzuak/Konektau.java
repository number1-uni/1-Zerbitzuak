package zerbitzuak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author lomana.markel
 */
public class Konektau extends Thread {

    String mezua;
    Runtime r = Runtime.getRuntime();
    String comando = "cmd /c start firefox 192.168.65.13:8069/web/login/";
    final Process[] p = {null};

    Konektau(int i) {
        if (i == 1) {
            mezua = "h1prozesua";
        } else {
            mezua = "h2prozesua";
        }
        setName(mezua);
    }

    @Override
    public void run() {
        while (true) {
            if (mezua.equals("h1prozesua")) {
                //hemen sartu Odoon sartzeko bidan kodigu
                try {
                    p[0] = r.exec(comando);
                    InputStream is = p[0].getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                break;
            }
            //System.out.println(mezua);
            if (mezua.equals("h2prozesua")) {
                //hemen sartu odoon logeetako bidan kodigu

                break; //login
            }

            try {
                sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
