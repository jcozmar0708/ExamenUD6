import java.io.*;

public class P1CalculaLluvia {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("lluvia.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"))) {
            int minimo = 0;
            boolean flag = false;
            int cantidadTotal = 0;
            while (true) {
                String linea = br.readLine();
                if (linea == null) break;
                if (!flag) {
                    minimo = Integer.parseInt(linea);
                    flag = true;
                } else {
                    String[] split = linea.split(" ");
                    String mes = split[0];
                    int cantidadMes = 0;
                    for (int i = 1; Integer.parseInt(split[i]) != -1; i++) {
                        cantidadMes += Integer.parseInt(split[i]);
                    }
                    if (cantidadMes >= minimo) {
                        bw.write(mes + " " + cantidadMes + "\n");
                        cantidadTotal += cantidadMes;
                    }
                }
            }
            bw.write("TOTAL: " + cantidadTotal);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de entrada/salida");
        }

        try (BufferedReader br = new BufferedReader(new FileReader("salida.txt"))) {
            while (true) {
                String linea = br.readLine();
                String total = br.readLine();
                if (linea == null) break;
                System.out.println(linea);
                System.out.println(total);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de entrada/salida");
        }
    }
}
