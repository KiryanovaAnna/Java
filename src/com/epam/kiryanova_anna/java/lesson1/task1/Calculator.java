package com.epam.kiryanova_anna.java.lesson1.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public void print_result_oper(int a, int b, String operation) {
        switch (operation) {
            case "+" :
                System.out.println(a + b);
                break;

            case "-" :
                System.out.println(a - b);
                break;

            case "*" :
                System.out.println(a * b);
                break;

            case "/" :
                System.out.println(1.0 * a / b);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите два числа и операцию между ними через пробел");

        String[] read = br.readLine().split(" ");

        Calculator calculator = new Calculator();
        calculator.print_result_oper(Integer.parseInt(read[0]), Integer.parseInt(read[2]), read[1]);
    }
}
