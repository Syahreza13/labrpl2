package com.labti.springHibernate.config;
import com.labti.springHibernate.model.Barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BarangTableModel extends AbstractTableModel {
    private List<Barang> barangs = new ArrayList<>();
    private final String HEADER[] = {"IdBrg", "NamaBrg", "HrgBrg", "JmlhBrg"};
    
    public BarangTableModel(List<Barang> barangs) {
	this.barangs = barangs;
    }
    
    @Override
    public int getRowCount() {
	return barangs.size();
    }
    
    @Override
    public int getColumnCount() {
	return HEADER.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
	return HEADER[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	Barang barang = barangs.get(rowIndex);
            switch (columnIndex) {
		case 0:
                    return barang.getIdBrg();
		case 1:
                    return barang.getNamaBrg();
		case 2:
                    return barang.getHrgBrg();
		case 3:
                    return barang.getJmlBrg();
		default:
                    return null;
		}
    }
}
