package ru.vsu.kudinov.sorts;

public interface Sort
{
    default <T> void swap(T[] array, int i, int j)
    {
        T tempTwo = array[i];
        array[i] = array[j];
        array[j] = tempTwo;
    }

    abstract <T> void sort(Integer[] orderValues, T[] data);
}
