package org.example;
import java.util.Scanner;
public class Ejercicio1 {



        public static double raizCuadrada(double num) throws IllegalArgumentException {
            if (num < 0) {
                throw new IllegalArgumentException("La raíz cuadrada no está definida para un número negativo.");
            }
            return Math.sqrt(num);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introducir un valor: ");
            double num = scanner.nextDouble();
            scanner.close();
            try {
                double raiz = raizCuadrada(num);
                System.out.printf("√%.2f = %.2f\n", num, raiz);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
