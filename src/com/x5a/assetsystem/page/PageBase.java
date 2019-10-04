package com.x5a.assetsystem.page;

import java.util.Scanner;

public abstract class PageBase {
    public abstract PageBase getResult();
    public abstract void display();

    static Scanner scanner;

    public PageBase() {
        scanner = new Scanner(System.in);
    }

    public void Close() {
        scanner.close();
    }
}