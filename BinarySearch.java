public class BinarySearch {

    public static void main(String[] args) {
        int[] datos = {1, 3, 5, 7, 9, 11, 13};
        int resultado = busquedaBinaria(datos, 7);
        System.out.println("Resultado: " + resultado);
    }

    public static int busquedaBinaria(int[] arr, int objetivo) {
        int inicio = 0;
        int fin = arr.length - 1;


        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (arr[medio] == objetivo) {
                return medio;
            }

            if (arr[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                // ERROR SUTÍL: debería ser `fin = medio - 1`
                fin = medio;
            }
        }
        return -1;
    }
}