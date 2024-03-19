import java.io.*;

public class P2AlmacenaDatos {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String linea = br.readLine();
                if (linea.equals("0")) break;
                String[] split = linea.split(" ");
                int dia = Integer.parseInt(split[0]);
                if (dia < 0 || dia > 5) System.out.println("Día incorrecto");
                else {
                    double marca = Double.parseDouble(split[1]);
                    File fichero = new File("marcas.dat");
                    try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
                        if (!fichero.exists()) {
                            for (int i = 1; i <= 5; i++) {
                                raf.writeDouble(Double.NaN);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de entrada/salida");
        }
    }
}
