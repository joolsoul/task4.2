package ru.vsu.kudinov.sorts;

public class QuickSort implements Sort
{
    @Override
    public <T> void sort(Integer[] orderValues, T[] data)
    {
        quickSort(orderValues, data, 0, data.length);
    }

    private <T> int partition(Integer[] arr, T[] data, int left, int right)
    {
        int l = left;
        int r = right - 1;
        int x = arr[(l + r) / 2];
        while (l <= r) {
            while (arr[l] < x)
            {
                l++;
            }
            while (arr[r] > x)
            {
                r--;
            }
            if (l <= r)
            {
                swap(arr, r, l);
                swap(data, r, l);
                l++;
                r--;
            }
        }
        if (l == right)
        {
            l--;
        }

        return l;
    }

    private <T> void quickSort(Integer[] arr, T[] data, int left, int right)
    {
        if (left < right - 1)
        {
            int xIndex = partition(arr, data, left, right);
            quickSort(arr, data, left, xIndex);
            quickSort(arr, data, xIndex, right);
        }
    }
}
