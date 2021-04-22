package ru.vsu.kudinov.gui;

import ru.vsu.kudinov.sorts.*;
import ru.vsu.kudinov.utils.ArrayUtils;
import ru.vsu.kudinov.utils.FileUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class MainPanel extends JPanel
{
    private static Sort instance;
    private JLabel firstArrayLabel = new JLabel("Enter an array of objects:");
    private JLabel secondArrayLabel = new JLabel("Enter an array of integers:");
    private JLabel sortArrayLabel = new JLabel("Sorted array:");
    private JButton readFromFileButton = new JButton("Read from file");
    private JButton sortButton = new JButton("Sort");
    private JButton clearButton = new JButton("Clear");
    private JButton writeToFileButton = new JButton("Write to file");
    private JRadioButton bubbleSortButton = new JRadioButton("bubble sort");
    private JRadioButton heapSortButton = new JRadioButton("heap sort");
    private JRadioButton insertionSortButton = new JRadioButton("insertion sort");
    private JRadioButton quickSortButton = new JRadioButton("quick sort");
    private JRadioButton selectionSortButton = new JRadioButton("selection sort");
    private JTextField firstArrayTextField = new JTextField();
    private JTextField secondArrayTextField = new JTextField();
    private JTextField sortArrayTextField = new JTextField();

    private final Font font = new Font("SanSerif", Font.PLAIN, 14);
    private final Color backgroundColor = new Color(136, 236, 239);

    private final int TEXT_FIELD_WIDTH = 450;
    private final int HEIGHT = 30;
    private final int LEFT_EDGE = 30;
    private final int TOP_EDGE = 30;
    private final int BUTTON_WIDTH = 155;
    private final int LABEL_WIDTH = 150;

    private String[] data;
    private Integer[] numbers;

public MainPanel()
{
    setLayout(null);
    setFont(font);
    setBackground(backgroundColor);

    firstArrayLabel.setBounds(LEFT_EDGE, TOP_EDGE, LABEL_WIDTH, HEIGHT);
    add(firstArrayLabel);
    firstArrayTextField.setBounds(LEFT_EDGE + 160, TOP_EDGE, TEXT_FIELD_WIDTH, HEIGHT);
    add(firstArrayTextField);

    secondArrayLabel.setBounds(LEFT_EDGE, TOP_EDGE * 3, LABEL_WIDTH, HEIGHT);
    add(secondArrayLabel);
    secondArrayTextField.setBounds(LEFT_EDGE + 160, TOP_EDGE * 3, TEXT_FIELD_WIDTH, HEIGHT);
    add(secondArrayTextField);

    sortArrayLabel.setBounds(LEFT_EDGE, TOP_EDGE * 10, LABEL_WIDTH - 50, HEIGHT);
    add(sortArrayLabel);
    sortArrayTextField.setBounds(LEFT_EDGE + 110, TOP_EDGE * 10, TEXT_FIELD_WIDTH + 50, HEIGHT);
    sortArrayTextField.setEditable(false);
    add(sortArrayTextField);

    addRadioButtons();
    addButtons();
}

private void addRadioButtons()
{
    bubbleSortButton.setBounds(LEFT_EDGE + 230, 130, 120, 15);
    bubbleSortButton.addActionListener(bubbleSortButtonListener);
    add(bubbleSortButton);

    quickSortButton.setBounds(LEFT_EDGE + 230, 150, 120, 15);
    quickSortButton.addActionListener(quickSortButtonListener);
    add(quickSortButton);

    selectionSortButton.setBounds(LEFT_EDGE + 230, 170, 120, 15);
    selectionSortButton.addActionListener(selectionSortButtonListener);
    add(selectionSortButton);

    heapSortButton.setBounds(LEFT_EDGE + 230, 190, 120, 15);
    heapSortButton.addActionListener(heapSortButtonListener);
    add(heapSortButton);

    insertionSortButton.setBounds(LEFT_EDGE + 230, 210, 120, 15);
    insertionSortButton.addActionListener(insertionSortButtonListener);
    add(insertionSortButton);
}

private void addButtons()
{
    readFromFileButton.setBounds(LEFT_EDGE, TOP_EDGE * 8, BUTTON_WIDTH, HEIGHT);
    readFromFileButton.addActionListener(readFromFileButtonListener);
    add(readFromFileButton);

    sortButton.setBounds(LEFT_EDGE + 185, TOP_EDGE * 8, BUTTON_WIDTH - 50, HEIGHT);
    sortButton.addActionListener(sortButtonListener);
    add(sortButton);

    clearButton.setBounds(LEFT_EDGE + 320, TOP_EDGE * 8, BUTTON_WIDTH - 50, HEIGHT);
    clearButton.addActionListener(clearButtonListener);
    add(clearButton);

    writeToFileButton.setBounds(LEFT_EDGE + 455, TOP_EDGE * 8, BUTTON_WIDTH, HEIGHT);
    writeToFileButton.addActionListener(writeToFileButtonListener);
    add(writeToFileButton);
}

ActionListener readFromFileButtonListener = e ->
{
    try
    {
        String[] input = FileUtils.readFile();
        firstArrayTextField.setText(input[0]);
        secondArrayTextField.setText(input[1]);
    }
    catch (FileNotFoundException fileNotFoundException)
    {
        fileNotFoundException.printStackTrace();
    }
};

ActionListener writeToFileButtonListener = new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            FileUtils.writeFile(data);
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }
};

ActionListener clearButtonListener = e ->
{
    firstArrayTextField.setText(null);
    secondArrayTextField.setText(null);
    sortArrayTextField.setText(null);
};

ActionListener bubbleSortButtonListener = new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        quickSortButton.setSelected(false);
        heapSortButton.setSelected(false);
        insertionSortButton.setSelected(false);
        selectionSortButton.setSelected(false);

        instance = new BubbleSort();
    }
};

    ActionListener quickSortButtonListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            bubbleSortButton.setSelected(false);
            heapSortButton.setSelected(false);
            insertionSortButton.setSelected(false);
            selectionSortButton.setSelected(false);

            instance = new QuickSort();
        }
    };

    ActionListener heapSortButtonListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            quickSortButton.setSelected(false);
            bubbleSortButton.setSelected(false);
            insertionSortButton.setSelected(false);
            selectionSortButton.setSelected(false);

            instance = new HeapSort();
        }
    };

    ActionListener insertionSortButtonListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            quickSortButton.setSelected(false);
            heapSortButton.setSelected(false);
            bubbleSortButton.setSelected(false);
            selectionSortButton.setSelected(false);

            instance = new InsertionSort();
        }
    };

    ActionListener selectionSortButtonListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            quickSortButton.setSelected(false);
            heapSortButton.setSelected(false);
            insertionSortButton.setSelected(false);
            bubbleSortButton.setSelected(false);

            instance = new SelectionSort();
        }
    };

    ActionListener sortButtonListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            data = ArrayUtils.readStringToStrArray(firstArrayTextField.getText());
            numbers = ArrayUtils.readStringToIntArray(secondArrayTextField.getText());
            instance.sort(numbers, data);
            sortArrayTextField.setText(Arrays.toString(data));
        }
    };
}

