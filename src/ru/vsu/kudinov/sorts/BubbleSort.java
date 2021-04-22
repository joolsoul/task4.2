package ru.vsu.kudinov.sorts;

public class BubbleSort implements Sort
{
    @Override
    public <T> void sort(Integer[] orderValues, T[] data)
    {
        for (int i = orderValues.length - 1; i >= 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (orderValues[j].compareTo(orderValues[j + 1]) > 0)
                {
                    swap(orderValues, j, j + 1);
                    swap(data, j, j + 1);
                }
            }
        }
    }
}

