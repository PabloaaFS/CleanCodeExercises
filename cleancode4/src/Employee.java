import java.util.Scanner;

/**
 * Define una clase llamada Employee que representa a un empleado.
 * La clase tiene dos campos privados: yearlySalary para el salario anual
 * y awards para los premios.
 */
public class Employee {
    private double yearlySalary;
    private double awards;

    /**
     * Define un constructor que acepta el salario anual y los premios del empleado
     * y los asigna a los campos correspondientes de la clase.
     * @param yearlySalary
     * @param awards
     */
    public Employee(double yearlySalary, double awards) {
        this.yearlySalary = yearlySalary;
        this.awards = awards;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public double getAwards() {
        return awards;
    }

    /**
     * Define un metodo que calcula el salario mensual del empleado sumando
     * el salario anual y los premios, y luego dividiendo el resultado entre 12.
     * @return
     */
    public double calculateMonthlySalary() {
        return (yearlySalary + awards) / 12;
    }

    /**
     * Punto de entrada del programa.
     * Crea un objeto Scanner para leer la entrada del usuario desde la consola.
     * Solicita al usuario que introduzca el salario anual y los premios del empleado.
     * Crea un objeto Employee utilizando los datos proporcionados por el usuario.
     * Llama al metodo calculateMonthlySalary para calcular el salario mensual del empleado.
     * Imprime el salario mensual calculado del empleado en la consola.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el salario anual del empleado: ");
        double yearlySalary = scanner.nextDouble();

        System.out.print("Introduce los premios del empleado: ");
        double awards = scanner.nextDouble();

        Employee employee = new Employee(yearlySalary, awards);
        double monthlySalary = employee.calculateMonthlySalary();

        System.out.println("El salario mensual del empleado es: " + monthlySalary);
    }
}
