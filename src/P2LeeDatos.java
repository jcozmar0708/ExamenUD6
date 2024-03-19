import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class P2LeeDatos {
    public static void main(String[] args) {
        File fichero = new File("marcas.dat");
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            int tamanyo = raf.readInt();
            System.out.println(tamanyo);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de entrada / salida");
        }
    }
}
