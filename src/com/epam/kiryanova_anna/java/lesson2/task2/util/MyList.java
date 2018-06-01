package com.epam.kiryanova_anna.java.lesson2.task2.util;

import java.util.Comparator;

public class MyList<Type> {
    private Type[] list;
    private int size;

    public MyList() {
        size = 0;
        list = (Type[]) new Object[10];
    }

    public void add(Type e) {
        if (size == list.length) {
            Type[] arr = (Type[]) new Object[size + 10];

            System.arraycopy(list, 0, arr, 0, list.length);
            list = arr;
        }

        list[size] = e;
        size++;
    }

    public Type get(int i) {
        if (i < size)
            return list[i];

        throw new ArrayIndexOutOfBoundsException(i);
    }

    public int size() {
        return size;
    }

    public void sort(Comparator<Type> comparator) {
        qucikSort(0, size - 1, comparator);
    }

    public void qucikSort(int lo, int hi, Comparator<Type> comparator) {
        if (lo < hi) {
            int p = partition(lo, hi, comparator);

            qucikSort(lo, p - 1, comparator);
            qucikSort(p + 1, hi, comparator);
        }
    }

    private int partition(int lo, int hi, Comparator<Type> comparator) {
        Type pivot = list[hi];

        int i = lo - 1;
        for (int j = lo; j < hi; j++)
            if (comparator.compare(list[j], pivot) == -1) {
                Type temp = list[j];
                list[j] = list[i];
                list[i] = temp;

                i++;
            }

        Type temp = list[i + 1];
        list[i + 1] = list[hi];
        list[hi] = temp;

        return i + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(list[i]);
            if (i < size-1)
                sb.append(", ");
        }

        return sb.append("]").toString();
    }
}