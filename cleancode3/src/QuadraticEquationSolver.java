/**
 * Division del metodo calcQuadraticEq, se ha dividido en tres
 * mas pequeños y especificos para que sea más modular y fácil de entender.
 * calculateDiscriminant, calculateRealRoots y calculateSingleRoot.
 * Nombres de variables mas descriptivos.
 * Maneja todos los casos posibles de la ecuación cuadratica: dos raices reales, una raiz real y ninguna raiz real.
 * Elimina el calculo del discriminante duplicado, se realiza en un metodo separado (calculateDiscriminant).
 */
public class QuadraticEquationSolver {
    // Parametros de entrada(a, b, c) representan los coeficientes de la ecuación cuadratica.
    public void solveQuadraticEquation(double a, double b, double c) {
        // Calcular el discriminante de la ecuación cuadratica utilizando la formula D=b^2-4ac
        double discriminant = calculateDiscriminant(a, b, c);
        // Si el discriminante es mayor que 0, la ecuacion tiene dos raices reales distintas.
        // Utilizamos la formula del metodo calculateRoots
        if (discriminant > 0) {
            double[] roots = calculateRoots(a, b, discriminant);
            System.out.println("x1 = " + roots[0] + ", x2 = " + roots[1]);
        // Si el discriminante es igual a 0, significa que la ecuacion tiene una raiz real doble.
        // Utilizamos la formula del metodo calculateSingleRoot
        } else if (discriminant == 0) {
            double root = calculateSingleRoot(a, b);
            System.out.println("x = " + root);
        // Si el discriminante es menor que 0, significa que la ecuacion no tiene raices reales.
        } else {
            System.out.println("La ecuacion no tiene raices reales");
        }
    }

    // Metodo que calcula el discriminante con la formula pertinente (D=b^2-4ac)
    private double calculateDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    // Si el discriminante es mayor que 0, se calculan las dos raices reales utilizando la formula cuadratica.
    private double[] calculateRoots(double a, double b, double discriminant) {
        double root1 = (-b - Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b + Math.sqrt(discriminant)) / (2 * a);
        return new double[]{root1, root2};
    }

    // Si el discriminante es igual a 0, se calcula una sola raiz real utilizando la formula.
    private double calculateSingleRoot(double a, double b) {
        return -b / (2 * a);
    }

}