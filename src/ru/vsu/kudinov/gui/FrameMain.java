package ru.vsu.kudinov.gui;

import javax.swing.*;

public class FrameMain extends JFrame
{


    public FrameMain()
    {
        setTitle("Sort");
        setSize(670, 430);
        add(new MainPanel());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}