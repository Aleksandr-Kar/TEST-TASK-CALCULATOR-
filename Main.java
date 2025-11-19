34
package com.example;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пример ");
        String input = scanner.nextLine().trim();// удаление пробелов вокруг строки

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }


    }

    private static String calc(String input) throws Exception {

        String[] parts = input.split("\\s+"); //разделения строки на части

        if (parts.length != 3) { // проверка
            throw new Exception("Неверный формат ввода. Должна быть одна операция вида (число пробел оператор пробел число) Пример: 2 + 2");
        }

        String part1Str = parts[0];
        String part2Operator = parts[1];
        String part3Str = parts[2];

        int num1 = Integer.parseInt(part1Str);// преобразование строки в целое число
        int num2 = Integer.parseInt(part3Str);

        if ((num1 >= 1 && num1 <= 10) && (num2 >= 1 && num2 <= 10)) {
            switch (part2Operator) {
                case "+":
                    return "" + (num1 + num2);
                case "-":
                    return "" + (num1 - num2);
                case "*":
                    return "" + (num1 * num2);
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Деление на ноль!");
                    }
                    return "" + (num1 / num2);
                default:
                    throw new Exception("Недопустимая операция. Поддерживаемые операции: '+', '-', '*', '/'");
            }

        } else {
            throw new Exception("Числа должны быть от 1 до 10 включительно");
        }


    }
}