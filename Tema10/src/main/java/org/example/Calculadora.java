package org.example;

import java.util.Scanner;


class DesbordaCapacidadException extends Exception {
    public DesbordaCapacidadException(String message) {
        super(message);
    }
}

// Clase de utilidad Operacion
class Operacion {
    public static int sumar(int a, int b) throws DesbordaCapacidadException {
        long resultado = (long) a + (long) b;
        if (resultado > Integer.MAX_VALUE || resultado < Integer.MIN_VALUE) {
            throw new DesbordaCapacidadException("El resultado desborda la capacidad de esta calculadora");
        }
        return a + b;
    }

    public static int restar(int a, int b) throws DesbordaCapacidadException {
        long resultado = (long) a - (long) b;
        if (resultado > Integer.MAX_VALUE || resultado < Integer.MIN_VALUE) {
            throw new DesbordaCapacidadException("El resultado desborda la capacidad de esta calculadora");
        }
        return a - b;
    }

    public static int multiplicar(int a, int b) throws DesbordaCapacidadException {
        long resultado = (long) a * (long) b;
        if (resultado > Integer.MAX_VALUE || resultado < Integer.MIN_VALUE) {
            throw new DesbordaCapacidadException("El resultado desborda la capacidad de esta calculadora");
        }
        return a * b;
    }
}

// Clase principal Calculadora
public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, resultado = 0;
        String operador;

        while (true) {
            try {
                System.out.print("\nIntroducir un número entero: ");
                a = Integer.parseInt(sc.nextLine());
                System.out.println(a);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor introducido incorrecto. Inténtelo de nuevo...");
            }
        }

        while (true) {
            try {
                System.out.print("\n¿operador? (+ - * / % o s para salir): ");
                operador = sc.nextLine();
                if (operador.equals("s")) {
                    break;
                } else if (!operador.equals("+") && !operador.equals("-") && !operador.equals("*") && !operador.equals("/") && !operador.equals("%")) {
                    System.out.println("Operador incorrecto. Inténtelo de nuevo...");
                    continue;
                }
                System.out.print("Introducir otro número entero: ");
                b = Integer.parseInt(sc.nextLine());
                if (operador.equals("/") && b == 0) {
                    throw new ArithmeticException("División por cero no definida matemáticamente.");
                }
                switch (operador) {
                    case "+":
                        resultado = Operacion.sumar(a, b);
                        break;
                    case "-":
                        resultado = Operacion.restar(a, b);
                        break;
                    case "*":
                        resultado = Operacion.multiplicar(a, b);
                        break;
                    case "/":
                        resultado = a / b;
                        break;
                    case "%":
                        resultado = a % b;
                        break;
                    default:
                        System.out.println("Operador no válido. Inténtelo de nuevo...");
                        break;
                }
                System.out.println("Resultado: " + resultado);
            } catch (NumberFormatException e) {
                System.out.println("Valor introducido incorrecto. Inténtelo de nuevo...");
            } catch (DesbordaCapacidadException e) {
                System.out.println(e.getMessage() + " Inténtelo de nuevo...");}

            }
        }
    }

