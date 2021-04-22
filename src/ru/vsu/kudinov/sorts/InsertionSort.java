package ru.vsu.kudinov.sorts;

public class InsertionSort implements Sort
{
    @Override
    public <T> void sort(Integer[] orderValues, T[] data)
    {
        int size = orderValues.length;
        for (int i = 0; i < size; i++)
        {
            T value = data[i];
            Integer digit = orderValues[i];
            int j;
            for (j = i - 1; j >= 0 && orderValues[j].compareTo(digit) > 0; j--)
            {
                swap(orderValues, j, j + 1);
                swap(data, j, j + 1);
            }
            data[j + 1] = value;
            orderValues[j + 1] = digit;
        }
    }
}
