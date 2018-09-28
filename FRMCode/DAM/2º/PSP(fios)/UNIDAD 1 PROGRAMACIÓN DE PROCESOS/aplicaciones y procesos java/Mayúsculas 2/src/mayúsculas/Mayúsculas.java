package mayúsculas;

import java.io.*;

/**
 *
 * @author a12cristiance
 */
public class Mayúsculas {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("\nSe necesita un programa a ejecutar y un fichero a crear");
            System.exit(-1);
        }

        File fichero = new File(args[1]);
        FileWriter fw = null;

        try {
            Process hijo = new ProcessBuilder(args[0]).start();
            fw = new FileWriter(fichero);

            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
            PrintStream ps = new PrintStream(hijo.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String texto;

            do {
                texto = in.readLine();
                ps.println(texto);
                ps.flush();

                String line = br.readLine();

                if (line.compareTo("kk") != 0) {
                    fw.write(line + "\r\n");
                }
            } while (texto.compareTo("ff") != 0);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
            }
        }
    }
}