package com.x5a.assetsystem.page;

import java.util.Scanner;

public abstract class PageBase {
    public abstract PageBase getResult();
    public abstract void display();

    public static Scanner scanner;

    public PageBase() {
        scanner = new Scanner(System.in);
    }

    public void Close() {
        scanner.close();
    }

    protected void printLine() {
        System.out.println("------------------------");
    }

    protected void printDoubleLine() {
        System.out.println("========================");
    }

    protected void println() {
        System.out.println();
    }

    protected void println(char[] val) {
        System.out.println(val);
    }

    protected void println(char val) {
        System.out.println(val);
    }

    protected void println(String val) {
        System.out.println(val);
    }

    protected void println(boolean val) {
        System.out.println(val);
    }

    protected void println(double val) {
        System.out.println(val);
    }

    protected void println(float val) {
        System.out.println(val);
    }

    protected void println(long val) {
        System.out.println(val);
    }

    protected void print(Object val) {
        System.out.print(val);
    }

    protected void print(boolean val) {
        System.out.print(val);
    }

    protected void print(char val) {
        System.out.print(val);
    }

    protected void print(char[] val) {
        System.out.print(val);
    }

    protected void print(float val) {
        System.out.print(val);
    }

    protected void print(double val) {
        System.out.print(val);
    }

    protected void print(int val) {
        System.out.print(val);
    }

    protected void print(long val) {
        System.out.print(val);
    }
}