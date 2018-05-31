package com.epam.kiryanova_anna.java.lesson1.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Arrays {
    public void print_max_min_elements(int[] array) {
        int min = 1 << 16;
        int min_index = 0;
        int max = -1 * min;
        int max_index = 0;

        for (int i = 0; i < array.length; i++) {
            int element = array[i];

            if (element > 0 && element < min) {
                min = element;
                min_index = i;
            }
            else if (element < 0 && element > max) {
                max = element;
                max_index = i;
            }
        }

        int temp = min;
        array[min_index] = max;
        array[max_index] = temp;

        System.out.println("Результат:");
        System.out.println(java.util.Arrays.toString(array));
    }

    public void print_sum_even_elements(int[] array) {
        int sum = 0;

        for (int i = 1; i < array.length; i += 2)
            sum += array[i];

        System.out.println("Сумма элементов: " + sum);
    }

    public void print_negatives_make_zero_arr(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] < 0)
                array[i] = 0;

        System.out.println("Результат:");
        System.out.println(java.util.Arrays.toString(array));
    }

    public void print_new_array(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > 0 && array[i + 1] < 0)
                array[i] *= 3;

        System.out.println("Результат:");
        System.out.println(java.util.Arrays.toString(array));
    }

    public void print_diff_betw_mean_min(int[] array) {
        int min = array[0];
        int mean = min;

        for (int i = 1; i < array.length; i++) {
            int element = array[i];

            if (element < min)
                min = element;

            mean += element;
        }

        mean /= array.length;

        System.out.println("Результат: " + (Math.abs(mean - min)));
    }

    public void print_numbers_have_met_twice_and_more(int[] array) {
        Set<Integer> met = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int element = array[i];

            if (met.contains(element) && i % 2 == 0)
                result.add(element);
            else met.add(element);
        }

        System.out.println("Результат: " + result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите массив чисел, числа разделяйте пробелом");
        String[] arr = br.readLine().split(" ");

        int[] array = new int[arr.length];
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(arr[i]);

        System.out.println("Введите номер задания");

        Arrays arrays = new Arrays();

        int operation = Integer.parseInt(br.readLine());
        switch (operation) {
            case 1 : {
                arrays.print_max_min_elements(array);

                break;
            }

            case 2 : {
                arrays.print_sum_even_elements(array);

                break;
            }

            case 3 : {
                arrays.print_negatives_make_zero_arr(array);

                break;
            }

            case 4 : {
                arrays.print_new_array(array);

                break;
            }

            case 5 : {
                arrays.print_diff_betw_mean_min(array);

                break;
            }

            case 6 : {
                arrays.print_numbers_have_met_twice_and_more(array);

                break;
            }
        }
    }
}
