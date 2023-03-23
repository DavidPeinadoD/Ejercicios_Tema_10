package org.example;
import java.util.Scanner;
public class Ejercicio2{


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introducir el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Introducir el segundo número: ");
        int num2 = scanner.nextInt();
        scanner.close();

        try {
            int suma = Math.addExact(num1, num2);
            int resta = Math.subtractExact(num1, num2);
            int multiplicacion = Math.multiplyExact(num1, num2);
            int divisionEntera = num1 / num2;
            int resto = num1 % num2;

            System.out.printf("Suma: %d\nResta: %d\nMultiplicación: %d\nDivisión entera: %d\nResto: %d\n",
                    suma, resta, multiplicacion, divisionEntera, resto);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}


