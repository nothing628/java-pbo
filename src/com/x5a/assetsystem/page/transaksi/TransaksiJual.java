package com.x5a.assetsystem.page.transaksi;

import java.util.ArrayList;
import java.util.Date;

import com.x5a.assetsystem.AssetSystem;
import com.x5a.assetsystem.database.Asset;
import com.x5a.assetsystem.database.AssetDetail;
import com.x5a.assetsystem.database.Transaksi;
import com.x5a.assetsystem.database.TransaksiDetail;
import com.x5a.assetsystem.page.PageBase;

public class TransaksiJual extends PageBase {

	PageBase returnPage;

    public TransaksiJual(PageBase return_page) {
        this.returnPage = return_page;
    }
    
	@Override
	public PageBase getNextPage() {
		return returnPage;
	}

	@Override
	public void display() {
		Asset orm = new Asset();
		AssetDetail orm_asset_detail = new AssetDetail();
		Transaksi orm_transaksi = new Transaksi();
		TransaksiDetail orm_detail = new TransaksiDetail();
		
		try {
			ArrayList<Asset> list_asset = orm.Select();
			
			printLine();
			println("Daftar Asset");
			for (Asset item : list_asset) {
				println(String.format("| %2s | %20s | %12s | %10s |", item.id, item.nama_asset, item.kategori, item.jenis));
	        }
			
			printLine();
			print("Masukkan ID Asset     : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			
			ArrayList<AssetDetail> list_detail = orm_asset_detail.Select("(kondisi = 'Baik' OR kondisi = 'Rusak') AND id_asset = " + id);
			
			printLine();
			println("Daftar Barang");
			for (AssetDetail item : list_detail) {
				println(String.format("| %2s | %10s | %10s |", item.id, item.lokasi, item.pegawai));
	        }
			
			printLine();
			print("Masukkan ID Barang     : ");
			int id_asset_detail = scanner.nextInt();
			scanner.nextLine();
			
			AssetDetail detail = orm_asset_detail.Find(id_asset_detail);
			
			print("Pembeli  : ");
			orm_transaksi.penerima = scanner.nextLine();
			orm_transaksi.penjual = AssetSystem.NamaPerusahaan;
			print("Harga    : ");
			int harga = scanner.nextInt();
			scanner.nextLine();
			
			orm_transaksi.tgl_transaksi = (new Date()).toString();
			orm_transaksi.jenis = "Jual";
			orm_transaksi.Insert();
			
			UpdateAssetDetail(detail);
			
			orm_detail.id_asset_detail = detail.id;
			orm_detail.id_transaksi = orm_transaksi.id;
			orm_detail.harga = harga;
			orm_detail.Insert();
		} catch (Exception e) {
			println("Gagal melakukan transaksi");
		}
	}
	
	private void UpdateAssetDetail(AssetDetail detail) {
		detail.kondisi = "Dijual";
		detail.Update();
	}

}
