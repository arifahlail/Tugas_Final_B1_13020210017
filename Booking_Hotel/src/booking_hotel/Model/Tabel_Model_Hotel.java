/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package booking_hotel.Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * author Kyy
 */
public class Tabel_Model_Hotel extends AbstractTableModel {
    
    private List<Model_Hotel> hotelList;
    
    public Tabel_Model_Hotel(List<Model_Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    @Override
    public int getRowCount() {
        return hotelList.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "No Kamar";
            case 2:
                return "Nama Pelanggan";
            case 3:
                return "No Telepon";
            case 4:
                return "Lama Tinggal";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        Model_Hotel hotel = hotelList.get(row);
        switch (column) {
            case 0:
                return hotel.getId();
            case 1:
                return hotel.getNoKamar();
            case 2:
                return hotel.getNmPelanggan();
            case 3:
                return hotel.getNoTelp();
            case 4:
                return hotel.getLmTinggal();
            default:
                return null;
        }
    }
}