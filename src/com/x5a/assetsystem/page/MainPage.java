package com.x5a.assetsystem.page;

import com.x5a.assetsystem.page.asset.AssetIndex;
import com.x5a.assetsystem.page.laporan.LaporanIndex;
import com.x5a.assetsystem.page.transaksi.TransaksiIndex;

public class MainPage extends PageBase {
    String result;

    @Override
    public PageBase getResult() {
        switch (result) {
            case "1":
                return new AssetIndex();
            case "2":
                return new TransaksiIndex(this);
            case "3":
                return new LaporanIndex(this);
        }

        return null;
    }

    @Override
    public void display() {
        printLine();
        println("Main Menu :");
        println("1. Data Asset");
        println("2. Transaksi");
        println("3. Laporan");
        print("Choose number (any for exit): ");

        result = scanner.nextLine();
    }
}