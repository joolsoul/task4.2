package ru.vsu.kudinov.sorts;

public class HeapSort implements Sort
{
    @Override
    public <T> void sort(Integer[] orderValues, T[] data)
    {
        int heapSize = orderValues.length;

        for (int i = heapSize / 2; i >= 0; i--)
        {
            siftDown(orderValues, data, i, heapSize);
        }

        while (heapSize > 1)
        {
            swap(data, 0, heapSize - 1);
            swap(orderValues, 0, heapSize - 1);

            heapSize--;

            siftDown(orderValues, data, 0, heapSize);
        }
    }

    private <T> void siftDown(Integer[] arr, T[] data, int k, int n)
    {
        T value = data[k];
        Integer digit = arr[k];

        while (true)
        {
            int childIndex = 2 * k + 1;

            if (childIndex >= n)
            {
                break;
            }

            if (childIndex + 1 < n && arr[childIndex + 1].compareTo(arr[childIndex]) > 0)
            {
                childIndex++;
            }

            if (digit > arr[childIndex])
            {
                break;
            }

            arr[k] = arr[childIndex];
            data[k] = data[childIndex];
            k = childIndex;
        }
        arr[k] = digit;
        data[k] = value;
    }

}
