package ru.vsu.kudinov.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileUtils
{
    public static <T> void writeFile(T[] sortedArray) throws IOException
    {
        FileWriter outputFile = new FileWriter("src\\ru\\vsu\\kudinov\\files\\result.txt");
        outputFile.write(Arrays.toString(sortedArray));
        outputFile.close();
    }

    public static String[] readFile() throws FileNotFoundException
    {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File("src\\ru\\vsu\\kudinov\\files\\input.txt"), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext())
            {
                lines.add(scanner.nextLine());
            }
        }
        return lines.toArray(new String[0]);
    }
}
