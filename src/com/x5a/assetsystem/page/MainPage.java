package com.x5a.assetsystem.page;

import com.x5a.assetsystem.page.kategori.KategoriIndex;

public class MainPage extends PageBase {
    String result;

    @Override
    public PageBase getResult() {
        switch (result) {
            case "1":
                return new MainPage();
            case "2":
                return new KategoriIndex();
        }

        return null;
    }

    @Override
    public void display() {
        System.out.println("Main Menu :");
        System.out.println("1. Main Menu");
        System.out.println("2. Kategori");
        System.out.print("Choose number (any for exit): ");

        result = scanner.nextLine();
    }

}