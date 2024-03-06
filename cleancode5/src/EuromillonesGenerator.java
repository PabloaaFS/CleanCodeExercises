import java.util.Arrays;
import java.util.Random;

public class EuromillonesGenerator {
    public static void main(String[] args) {
        // Generacion de los numeros principales y estrella del Euromillon.
        int[] mainNumbers = generateNumbers(5, 1, 50);
        int[] starNumbers = generateNumbers(2, 1, 12);

        System.out.println("Euromillones numbers:");
        System.out.println("Main numbers: " + Arrays.toString(mainNumbers));
        System.out.println("Star numbers: " + Arrays.toString(starNumbers));
    }

    // Genera numeros unicos dentro de un rango especifico.
    private static int[] generateNumbers(int count, int min, int max) {
        // Inicializacion de un objeto Random para generar numeros aleatorios.
        Random random = new Random();

        // Inicializacion de arrays para almacenar los numeros generados y controlar su uso.
        int[] numbers = new int[count]; // Almacena los numeros generados.
        boolean[] used = new boolean[max - min + 1]; // Controla los numeros ya utilizados.

        // Bucle para generar numeros unicos.
        for (int i = 0; i < count; i++) {
            int randomNumber; // Variable para almacenar el numero aleatorio generado.
            // Bucle para garantizar que el numero generado sea unico.
            do {
                // Generación de un numero aleatorio dentro del rango especificado por min y max.
                randomNumber = random.nextInt(max - min + 1) + min;
            } while (used[randomNumber - min]); // Comprobacion de si el numero ya ha sido utilizado.
            numbers[i] = randomNumber; // Almacenamiento del numero generado en el array numbers.
            used[randomNumber - min] = true; // Marcar el numero generado como utilizado en el array used.
        }

        return numbers;
    }
}
