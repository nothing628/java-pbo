package com.x5a.assetsystem.page;

public class MainPage extends PageBase {
    String result;

    @Override
    public PageBase getResult() {
        switch (result) {
            case "1":
                return new MainPage();
            case "2":
                return null;
        }

        return null;
    }

    @Override
    public void display() {
        System.out.println("Main Menu :");
        System.out.println("1. Main Menu");
        System.out.println("2. Exit");
        System.out.print("Choose number : ");

        result = scanner.nextLine();
    }

}