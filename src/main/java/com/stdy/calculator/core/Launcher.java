package com.stdy.calculator.core;

import com.stdy.calculator.view.MainWindow;

import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });


    }
}
