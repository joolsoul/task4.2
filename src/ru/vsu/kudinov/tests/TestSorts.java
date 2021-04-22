package ru.vsu.kudinov.tests;

import org.junit.Before;
import org.junit.Test;
import ru.vsu.kudinov.sorts.*;
import org.junit.jupiter.api.Assertions;

public class TestSorts
{
    private String[] data;
    private Integer[] numbers;
    private String[] expectedData;

    @Before
    public void setInitialArrays()
    {
        data = new String[]{"green", "red", "blue", "yellow", "black", "white", "brown"};
        numbers = new Integer[]{5, 2, 8, 1, 3, 7, 4};
        expectedData = new String[]{"yellow", "red", "black", "brown", "green", "white", "blue"};
    }

    @Test
    public void BubbleSortTest()
    {
        new BubbleSort().sort(numbers, data);

        for(int i = 0; i < numbers.length; i++)
        {
            Assertions.assertEquals(expectedData[i], data[i]);
        }
    }

    @Test
    public void HeapSortTest()
    {
        new HeapSort().sort(numbers, data);

        for(int i = 0; i < numbers.length; i++)
        {
            Assertions.assertEquals(expectedData[i], data[i]);
        }
    }

    @Test
    public void InsertionSortTest()
    {
        new InsertionSort().sort(numbers, data);

        for(int i = 0; i < numbers.length; i++)
        {
            Assertions.assertEquals(expectedData[i], data[i]);
        }
    }

    @Test
    public void QuickSortTest()
    {
        new QuickSort().sort(numbers, data);

        for(int i = 0; i < numbers.length; i++)
        {
            Assertions.assertEquals(expectedData[i], data[i]);
        }
    }

    @Test
    public void SelectionSortTest()
    {
        new SelectionSort().sort(numbers, data);

        for(int i = 0; i < numbers.length; i++)
        {
            Assertions.assertEquals(expectedData[i], data[i]);
        }
    }
}

