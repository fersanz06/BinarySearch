import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        String rutaEntrada = "numeros.txt";
        String rutaSalida = "numerosBS.txt";

        try {
            int[] datos = readNumbersFromFile(rutaEntrada);

            Arrays.sort(datos); // Asegurar que está ordenado
            System.out.println("Arreglo ordenado: " + Arrays.toString(datos));

            Scanner scanner = new Scanner(System.in);
            System.out.print("Número a buscar: ");
            int objetivo = scanner.nextInt();

            int resultado = busquedaBinaria(datos, objetivo);
            System.out.println("Resultado encontrado en índice: " + resultado);

            saveResultToFile(resultado, objetivo, rutaSalida);

            System.out.println("\nArchivo generado en:");
            System.out.println(rutaSalida);

        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }
    }

    public static int busquedaBinaria(int[] arr, int objetivo) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == objetivo) {
                return medio;
            }

            if (arr[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    private static int[] readNumbersFromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<Integer> numbers = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            line = line.replace(",", " ");
            String[] parts = line.trim().split("\\s+");

            for (String p : parts) {
                if (!p.isEmpty()) numbers.add(Integer.parseInt(p));
            }
        }

        br.close();

        int[] arr = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) arr[i] = numbers.get(i);

        return arr;
    }

    private static void saveResultToFile(int resultado, int objetivo, String path) throws IOException {
        FileWriter fw = new FileWriter(path);

        if (resultado != -1) {
            fw.write("Número buscado: " + objetivo + "\n");
            fw.write("Encontrado en el índice: " + resultado + "\n");
        } else {
            fw.write("Número buscado: " + objetivo + "\n");
            fw.write("No se encontró en el arreglo.\n");
        }

        fw.close();
    }
}
