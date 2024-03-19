import java.io.*;
import java.util.Scanner;

public class P2AlmacenaDatos {
    private static int TAMANYO_CABECERA = 4;
    private static int TAMANYO_REGISTRO = TAMANYO_CABECERA + 8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea;
        double marca;
        int numRegistros = 0;
        do {
            linea = sc.nextLine();
            linea = linea.replace(" ", "");
            int dia = Integer.parseInt(linea.substring(0, 1));
            if (dia != 0) {
                long registro_actual = 0;
                try {
                    if (dia < 0 || dia > 5) System.out.println("Día incorrecto");
                    else {
                        marca = Double.parseDouble(linea.substring(1));
                        File fichero = new File("marcas.dat");
                        long posicion;
                        if (!fichero.exists()) {
                            try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
                                raf.seek(0);
                                raf.writeInt(numRegistros + 1);
                                raf.writeInt(dia);
                                raf.writeDouble(marca);
                            } catch (IOException e) {
                                System.out.println("Ha ocurrido un error de entrada / salida");
                            }
                        }
                        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
                            posicion = TAMANYO_CABECERA + TAMANYO_REGISTRO * registro_actual;
                            raf.setLength(posicion + TAMANYO_REGISTRO);
                            raf.seek(posicion);
                            raf.writeInt(numRegistros + 1);
                            raf.writeInt(dia);
                            raf.writeDouble(marca);
                        } catch (IOException e) {
                            System.out.println("Ha ocurrido un error de entrada / salida");
                        }
                        registro_actual++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Falta escribir la marca del día");
                }
            }
        } while (linea.charAt(0) != '0');
    }
}
