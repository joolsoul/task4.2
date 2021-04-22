package ru.vsu.kudinov.sorts;

public class SelectionSort implements Sort
{
    @Override
    public <T> void sort(Integer[] orderValues, T[] data)
    {
        int size = orderValues.length;
        for (int i = 0; i < size - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < size; j++)
            {
                if (orderValues[j].compareTo(orderValues[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            swap(orderValues, i, minIndex);
            swap(data, i, minIndex);
        }
    }
}
