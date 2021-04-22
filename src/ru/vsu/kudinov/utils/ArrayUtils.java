package ru.vsu.kudinov.utils;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ArrayUtils
{
    public static Integer[] readStringToIntArray(String line)
    {
        Scanner scanner = new Scanner(line);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        java.util.List<Integer> list = new ArrayList<>();
        while (scanner.hasNext())
        {
            list.add(scanner.nextInt());
        }

        return list.toArray(new Integer[0]);
    }

    public static String[] readStringToStrArray(String line)
    {
        Scanner scanner = new Scanner(line);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        java.util.List<String> list = new ArrayList<>();
        while (scanner.hasNext())
        {
            list.add(scanner.next());
        }

        return list.toArray(new String[0]);
    }
}
