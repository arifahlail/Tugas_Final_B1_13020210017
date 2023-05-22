package booking_hotel.Controller;

import booking_hotel.DAO.DAO_Hotel;
import booking_hotel.DAOImplement.Implement_Hotel;
import booking_hotel.Model.Model_Hotel;
import booking_hotel.Model.Tabel_Model_Hotel;
import booking_hotel.View.View_Hotel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * Kontroller untuk entitas Hotel
 */
public class Controller_Hotel {
    
     View_Hotel frame_hotel;
     Implement_Hotel implement_hotel;
     List<Model_Hotel> hotelList;
    
    public Controller_Hotel(View_Hotel frame_hotel) {
        this.frame_hotel = frame_hotel;
        implement_hotel = new DAO_Hotel();
        hotelList = implement_hotel.getALL();
    }
   
    // Tombol Reset
    public void reset(){
        frame_hotel.getTxtNokmr().setText("");
        frame_hotel.getTxtNamaPelanggan().setText("");
        frame_hotel.getTxtNotelp().setText("");
        frame_hotel.getTxtlamatggl().setText("");
        frame_hotel.getTxtCariData().setText("");
    }
    
    // Tampil Data Ke Tabel
    public void isiTable(){
        hotelList = implement_hotel.getALL();
        Tabel_Model_Hotel tmb = new Tabel_Model_Hotel(hotelList);
        frame_hotel.getTabel_data_hotel().setModel(tmb);
    }
    
    // Menampilkan Data Ke Form Ketika Data Di Klik
    public void isiField(int row) {
        frame_hotel.getTxtId().setText(String.valueOf(hotelList.get(row).getId()));
        frame_hotel.getTxtNokmr().setText(hotelList.get(row).getNoKamar());
        frame_hotel.getTxtNamaPelanggan().setText(hotelList.get(row).getNmPelanggan());
        frame_hotel.getTxtNotelp().setText(hotelList.get(row).getNoTelp());
        frame_hotel.getTxtlamatggl().setText(hotelList.get(row).getLmTinggal());
    }
    
    // Insert Data Dari Form Ke Database
    public void insert(){
        if(!frame_hotel.getTxtNokmr().getText().trim().isEmpty() &&
                !frame_hotel.getTxtNamaPelanggan().getText().trim().isEmpty() &&
                !frame_hotel.getTxtNotelp().getText().trim().isEmpty() &&
                !frame_hotel.getTxtlamatggl().getText().trim().isEmpty()){
            
            Model_Hotel hotel = new Model_Hotel();
            hotel.setNoKamar(frame_hotel.getTxtNokmr().getText());
            hotel.setNmPelanggan(frame_hotel.getTxtNamaPelanggan().getText());
            hotel.setNoTelp(frame_hotel.getTxtNotelp().getText());
            hotel.setLmTinggal(frame_hotel.getTxtlamatggl().getText());
            
            implement_hotel.insert(hotel);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } else {
            JOptionPane.showMessageDialog(frame_hotel, "Data tidak boleh kosong");
        }
    }
    
    // Update Data Dari Tabel Ke Database
    public void update() {
    if (!frame_hotel.getTxtNokmr().getText().trim().isEmpty()) {
        Model_Hotel hotel = new Model_Hotel();
        hotel.setId(Integer.parseInt(frame_hotel.getTxtId().getText()));
        hotel.setNoKamar(frame_hotel.getTxtNokmr().getText());
        hotel.setNmPelanggan(frame_hotel.getTxtNamaPelanggan().getText());
        hotel.setNoTelp(frame_hotel.getTxtNotelp().getText());
        hotel.setLmTinggal(frame_hotel.getTxtlamatggl().getText());

        implement_hotel.update(hotel);
        JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
    } else {
        JOptionPane.showMessageDialog(frame_hotel, "Silahkan pilih data yang akan diupdate");
    }
}
    
    // Hapus Data Pada Tabel berdasarkan ID
public void delete() {
    if (!frame_hotel.getTxtId().getText().trim().isEmpty()) {
        int id = Integer.parseInt
        (frame_hotel.getTxtId().getText());
        implement_hotel.delete(id);
        
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
    } else {
        JOptionPane.showMessageDialog(frame_hotel, "Silahkan pilih data yang akan dihapus");
    }
}
    
    // Cari Data
    public void isiTableCariNama(){
        String keyword = frame_hotel.getTxtCariData().getText();
        hotelList = implement_hotel.getCariNama(keyword);
        Tabel_Model_Hotel tmb = new Tabel_Model_Hotel(hotelList);
        frame_hotel.getTabel_data_hotel().setModel(tmb);
    }
    
    public void cariNama(){
        if(!frame_hotel.getTxtCariData().getText().trim().isEmpty()){
            implement_hotel.getCariNama(frame_hotel.getTxtCariData().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_hotel, "Silahkan masukkan kata kunci pencarian");
        }
    }
}