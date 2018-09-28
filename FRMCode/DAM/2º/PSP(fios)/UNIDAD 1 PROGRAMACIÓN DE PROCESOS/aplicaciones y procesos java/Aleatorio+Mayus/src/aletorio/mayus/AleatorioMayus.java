package aletorio.mayus;

import java.io.*;

/**
 * Version de aleatorio+mayus que instancia y destruye mayusculas.exe dentro del
 * ciclo
 *
 * @author a12cristiance
 */
public class AleatorioMayus {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("\nSe necesita dos programa a ejecutar");
            System.exit(-1);
        }

        File fichero = new File(args[2]);
        FileWriter fw = null;

        try {
            Process aleatorios = new ProcessBuilder(args[0]).start();
            fw = new FileWriter(fichero);

            BufferedReader brA
                    = new BufferedReader(new InputStreamReader(aleatorios.getInputStream()));
            PrintStream psA
                    = new PrintStream(aleatorios.getOutputStream());
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(System.in));

            String line;
            System.out.println("Escribe cualquier cosa para empezar y final para terminar");

            while ((line = in.readLine()).compareTo("final") != 0) {
                Process mayusculas = new ProcessBuilder(args[1]).start();

                BufferedReader brM
                        = new BufferedReader(new InputStreamReader(mayusculas.getInputStream()));
                PrintStream psM
                        = new PrintStream(mayusculas.getOutputStream());

                psA.println(" ");
                psA.flush();

                line = brA.readLine();
                int n = Integer.parseInt(line);
                System.out.println("\nIntroduce " + n + " cadenas(f en el primer o segundo "
                        + "carácter para terminar)");

                for (int i = 0; i < n; i++) {
                    line = in.readLine();

                    if (!line.substring(0).equals("f") && !line.substring(1).equals("f")) {
                        psM.println(line);
                        psM.flush();

                        fw.write((line = brM.readLine()) + "\r\n");
                    } else {
                        break;
                    }

                }

                mayusculas.destroy();
                System.out.println("\nEscribe cualquier cosa para empezar y final para terminar");
            }

            aleatorios.destroy();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
