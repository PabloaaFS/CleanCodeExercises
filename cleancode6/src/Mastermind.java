import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {
    /**
     * Definicion de constantes COLORS, CODE_LENGTH y MAX_ATTEMPTS.
     * COLORS es un array que contiene los colores disponibles para el juego.
     * CODE_LENGTH la longitud de la secuencia de colores a adivinar, 4.
     * MAX_ATTEMPTS numero maximo de intentos permitidos para el jugador.
     */
    private static final String[] COLORS = {"Azul", "Rojo", "Verde", "Amarillo"};
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;

    /**
     * Punto de entrada del programa. Se genera la secuencia de colores secreta llamando
     * a la funcion generateSecretCode, luego se imprime un mensaje de bienvenida
     * y se inicia un bucle para los intentos del jugador, que continúa mientras no se exceda el limite de intentos.
     * @param args
     */
    public static void main(String[] args) {
        String[] secretCode = generateSecretCode();

        System.out.println("Bienvenido a Mastermind 2.0!");
        System.out.println("Intenta adivinar la secuencia de colores.");

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.println("\nIntento " + attempt + ":");
            String[] guess = getGuessFromUser();

            int[] result = evaluateGuess(secretCode, guess);
            System.out.println("Resultado: " + result[0] + " blancas, " + result[1] + " negras.");

            if (result[0] == CODE_LENGTH) {
                System.out.println("¡Felicidades! Has adivinado la secuencia en el intento " + attempt + ".");
                return;
            }
        }

        System.out.println("Lo siento, has agotado tus 10 intentos. La secuencia correcta era: " + Arrays.toString(secretCode));
    }

    /**
     * Utiliza un generador de numeros aleatorios para seleccionar aleatoriamente los colores de la secuencia secreta.
     * @return
     */
    private static String[] generateSecretCode() {
        Random random = new Random();
        String[] code = new String[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            code[i] = COLORS[random.nextInt(COLORS.length)];
        }
        return code;
    }

    /**
     * Se itera a traves de los intentos del jugador en un bucle for.
     * En cada iteracion, se solicita al jugador que introduzca su intento llamando a la funcion getGuessFromUser.
     * @return
     */
    private static String[] getGuessFromUser() {
        Scanner scanner = new Scanner(System.in);
        String[] guess = new String[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            System.out.print("Introduce color " + (i + 1) + " (Azul, Rojo, Verde, Amarillo): ");
            guess[i] = getValidColor(scanner);
        }
        return guess;
    }

    /**
     * Validacion para que el input escrito por el usuario solo pueda ser el nombre de un color.
     * @param scanner
     * @return
     */
    private static String getValidColor(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.nextLine();
            if (Arrays.asList(COLORS).contains(input)) {
                break;
            } else {
                System.out.print("Por favor, introduce un color valido (Azul, Rojo, Verde, Amarillo): ");
            }
        }
        return input;
    }

    /**
     * Introducido el intento, se llama a la función evaluateGuess para evaluar
     * si ha adivinado correctamente la secuencia secreta.
     * Esta función devuelve el número de bolas blancas (colocadas en la posición correcta)
     * y negras (colores correctos pero en la posición incorrecta).
     * @param secretCode
     * @param guess
     * @return
     */
    private static int[] evaluateGuess(String[] secretCode, String[] guess) {
        int[] result = new int[2]; // [blancas, negras]
        boolean[] checked = new boolean[CODE_LENGTH];

        /*
        Inicializar el contador de bolas blancas (colocadas en la posición correcta)
        y un array booleano para rastrear las bolas que ya han sido comprobadas.
        El array checked se utiliza para asegurarse de que no se cuenten las mismas bolas
        dos veces (por ejemplo, si un color aparece en la secuencia varias veces).
         */

        for (int i = 0; i < CODE_LENGTH; i++) {
            // Comprobar si la bola del intento actual está en la posicion correcta.
            if (guess[i].equals(secretCode[i])) {
                result[0]++; // Incrementar el contador de bolas blancas.
                checked[i] = true; // Marcar esta bola como comprobada.
            }
        }

        // Comprobar si hay bolas en la secuencia secreta que no están en la posicion correcta.
        for (int i = 0; i < CODE_LENGTH; i++) {
            // Si la bola ya ha sido comprobada en el paso anterior, pasar a la siguiente iteracion.
            if (!checked[i]) {
                // Si la bola no esta en la posicion correcta, buscar si aparece en otra posicion de la secuencia.
                for (int j = 0; j < CODE_LENGTH; j++) {
                    // Si la bola esta en la secuencia secreta pero no en la posicion correcta,
                    // incrementar el contador de bolas negras y marcar la bola como comprobada.
                    if (!checked[j] && guess[i].equals(secretCode[j])) {
                        result[1]++; // Incrementar el contador de bolas negras.
                        checked[j] = true; // Marcar esta bola como comprobada.
                        break; // Salir del bucle interno, ya que hemos encontrado una coincidencia.
                    }
                }
            }
        }

        return result;
    }
}

