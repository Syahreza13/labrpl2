package com.labti.springHibernate.controller;

import com.labti.springHibernate.app;
import com.labti.springHibernate.config.BarangTableModel;
import com.labti.springHibernate.model.Barang;
import com.labti.springHibernate.view.BarangView;
import java.util.List;
import javax.swing.JOptionPane;

public class BarangController {
    private final BarangView barangView;
    private BarangTableModel barangTableModel;
    private List<Barang> barangs;
    
    public BarangController(BarangView barangView) {
        this.barangView = barangView;
    }
    
    public void tampilData() {
	barangs = app.getBarangService().getBarangs();
	barangTableModel = new BarangTableModel(barangs);	
	this.barangView.getTabel().setModel(barangTableModel);
    }
    
    public void show() {
    int index = this.barangView.getTabel().getSelectedRow();

    if (index >= 0) {
        // Pastikan indeks dalam batas yang valid
        this.barangView.setIdBrg(String.valueOf(this.barangView.getTabel().getValueAt(index, 0)));
        this.barangView.setNamaBrg(String.valueOf(this.barangView.getTabel().getValueAt(index, 1)));
        this.barangView.setHrgBrg(String.valueOf(this.barangView.getTabel().getValueAt(index, 1)));
        this.barangView.setJmlBrg(String.valueOf(this.barangView.getTabel().getValueAt(index, 1)));
    } else {
        // Tampilkan pesan atau lakukan tindakan lain jika indeks tidak valid
        System.out.println("Indeks tidak valid");
    }
}
    
public void clear() {
    this.barangView.setIdBrg("");
    this.barangView.setNamaBrg("");
    this.barangView.setHrgBrg(""); // Menggunakan setHrgBrg dengan String
    this.barangView.setJmlBrg(""); // Menggunakan setJmlBrg dengan String
}
public void updateBarang() {
    Barang barang = new Barang();
    barang.setIdBrg(this.barangView.getIdBrg());
    barang.setNamaBrg(this.barangView.getNamaBrg());
    // Konversi String ke Integer
    barang.setHrgBrg(this.barangView.getHrgBrg());
    barang.setJmlBrg(this.barangView.getJmlBrg());
    app.getBarangService().update(barang);
    JOptionPane.showMessageDialog(null, "Data Berhasil di Edit", "info", JOptionPane.INFORMATION_MESSAGE);
    clear();
    tampilData();
}

public void deleteBarang() {
    if (this.barangView.getIdBrg().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Barang belum dipilih", "error", JOptionPane.ERROR_MESSAGE);
    } else {
        Barang barang = new Barang();
        barang.setIdBrg(this.barangView.getIdBrg());
        int pilih = JOptionPane.showConfirmDialog(null, "Apakah data ingin dihapus ?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pilih == JOptionPane.YES_OPTION) {
            app.getBarangService().delete(barang);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus", "info", JOptionPane.INFORMATION_MESSAGE);
            clear();
            tampilData();
        }
    }
}

public void saveBarang() {
    Barang barang = new Barang();
    barang.setIdBrg(this.barangView.getIdBrg());
    barang.setNamaBrg(this.barangView.getNamaBrg());
    // Konversi String ke Integer
    barang.setHrgBrg(this.barangView.getHrgBrg());
    barang.setJmlBrg(this.barangView.getJmlBrg());
    app.getBarangService().save(barang);
    JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan", "info", JOptionPane.INFORMATION_MESSAGE);
    clear();
    tampilData();
}
}
