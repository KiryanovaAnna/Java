package com.epam.kiryanova_anna.java.lesson1.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Strings {
    public void print_max_min_length(List<String> list) {
        int max_length = list.get(0).length();
        int max_index = 0;

        int min_length = list.get(0).length();
        int min_index = 0;

        for (int i = 1; i < list.size(); i++) {
            int temp_length = list.get(i).length();

            if (temp_length < min_length) {
                min_length = temp_length;
                min_index = i;
            }

            if (temp_length > max_length) {
                max_length = temp_length;
                max_index = i;
            }
        }

        System.out.println("Самая длинная строка " + list.get(max_index));
        System.out.println("Длина самой длинной строки: " + max_length);
        System.out.println("Самая короткая строка: " + list.get(min_index));
        System.out.println("Длина самой короткой строки " + min_length);
    }

    public void print_longer(List<String> list) {
        int mean_length = 0;
        for (String element : list) mean_length += element.length();

        mean_length /= list.size();

        for (String element : list) {
            int length = element.length();

            if (length > mean_length)
                System.out.println(element + ", длина = " + length);
        }
    }

    public void print_shorter(List<String> list) {
        int mean_length = 0;
        for (String element : list) mean_length += element.length();

        mean_length /= list.size();

        for (String element : list) {
            int length = element.length();

            if (length < mean_length)
                System.out.println(element + ", длина = " + length);
        }
    }

    public void print_min_diff_symbs_word(List<String> list) {
        int diff_symbs = 1 << 16;
        String word = "";

        for (String temp : list) {
            Set<Character> diff = new HashSet<>();
            for (int j = 0; j < temp.length(); j++) {
                char temp_ch = temp.charAt(j);

                if (!diff.contains(temp_ch))
                    diff.add(temp_ch);
            }

            if (diff.size() < diff_symbs) {
                word = temp;
                diff_symbs = diff.size();
            }
        }

        System.out.println(word);
    }

    public void print_only_diff_symbs_word(List<String> list) {
        for (String temp : list) {
            Set<Character> diff = new HashSet<>();
            for (int j = 0; j < temp.length(); j++) {
                char temp_ch = temp.charAt(j);

                if (!diff.contains(temp_ch))
                    diff.add(temp_ch);
            }

            if (diff.size() == temp.length()) {
                System.out.println(temp);

                break;
            }
        }
    }

    public void print_only_numbers_word(List<String> list) {
        List<String> res = new ArrayList<>();

        for (String word : list) {
            String temp = word.replaceAll("[0-9]", "");

            if (temp.length() == 0)
                res.add(word);
        }

        if (res.size() > 1)
            System.out.println(res.get(1));
        else System.out.println(res.get(0));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите строки:");
        List<String> list = new ArrayList<>();

        String read;
        while (!(read = br.readLine()).equals("")) {
            list.add(read);
        }

        System.out.println("Введите номер задания");
        int operation = Integer.parseInt(br.readLine());

        Strings strings = new Strings();

        switch (operation) {
            case 1 : {
                strings.print_max_min_length(list);

                break;
            }

            case 2 : {
                strings.print_longer(list);

                break;
            }

            case 3 : {
                strings.print_shorter(list);

                break;
            }

            case 4 : {
                strings.print_min_diff_symbs_word(list);

                break;
            }

            case 5 : {
                strings.print_only_diff_symbs_word(list);

                break;
            }

            case 6 : {
                strings.print_only_numbers_word(list);

                break;
            }
        }
    }
}
