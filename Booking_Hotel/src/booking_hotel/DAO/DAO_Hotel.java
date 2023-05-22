/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package booking_hotel.DAO;

import booking_hotel.DAOImplement.Implement_Hotel;
import booking_hotel.Koneksi.Koneksi_HotelDB;
import booking_hotel.Model.Model_Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Hotel implements Implement_Hotel {

    Connection connection;
    final String insert = "INSERT INTO tbl_data_hotel (no_kamar, nm_pelanggan, no_telp, lm_tinggal) VALUES (?,?,?,?);";
    final String update = "UPDATE tbl_data_hotel SET no_kamar=?, nm_pelanggan=?, no_telp=?, lm_tinggal=? WHERE id=? ;";
    final String delete = "DELETE FROM tbl_data_hotel WHERE id=? ;";
    final String selectAll = "SELECT * FROM tbl_data_hotel;";
    final String searchByNama = "SELECT * FROM tbl_data_hotel WHERE nm_pelanggan LIKE ?;";
    
    private List<Model_Hotel> hotelList;
    
    public DAO_Hotel(){
        connection = Koneksi_HotelDB.connection();
        hotelList = new ArrayList<>();
    }

    @Override
    public void insert(Model_Hotel hotel) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, hotel.getNoKamar());
            statement.setString(2, hotel.getNmPelanggan());
            statement.setString(3, hotel.getNoTelp());
            statement.setString(4, hotel.getLmTinggal());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Model_Hotel hotel) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, hotel.getNoKamar());
            statement.setString(2, hotel.getNmPelanggan());
            statement.setString(3, hotel.getNoTelp());
            statement.setString(4, hotel.getLmTinggal());
            statement.setInt(5, hotel.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
public List<Model_Hotel> getALL() {
    List<Model_Hotel> hotelList = new ArrayList<>();
    try {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectAll);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String noKamar = resultSet.getString("no_kamar");
            String namaPelanggan = resultSet.getString("nm_pelanggan");
            String noTelepon = resultSet.getString("no_telp");
            String lamaTinggal = resultSet.getString("lm_tinggal");
            Model_Hotel hotel = new Model_Hotel();
            hotel.setId(id);
            hotel.setNoKamar(noKamar);
            hotel.setNmPelanggan(namaPelanggan);
            hotel.setNoTelp(noTelepon);
            hotel.setLmTinggal(lamaTinggal);
            hotelList.add(hotel);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAO_Hotel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return hotelList;

    }

    @Override
    public List<Model_Hotel> getCariNama(String keyword) {
        List<Model_Hotel> hotelList = new ArrayList<>();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
        String query = "SELECT * FROM tbl_data_hotel WHERE no_kamar LIKE ? OR nm_pelanggan LIKE ? OR no_telp LIKE ? OR lm_tinggal LIKE ?";
        statement = connection.prepareStatement(query);
        String searchKeyword = "%" + keyword + "%";
        for (int i = 1; i <= 4; i++) {
            statement.setString(i, searchKeyword);
        }
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String noKamar = resultSet.getString("no_kamar");
            String namaPelanggan = resultSet.getString("nm_pelanggan");
            String noTelepon = resultSet.getString("no_telp");
            String lamaTinggal = resultSet.getString("lm_tinggal");
            Model_Hotel hotel = new Model_Hotel();
            hotel.setId(id);
            hotel.setNoKamar(noKamar);
            hotel.setNmPelanggan(namaPelanggan);
            hotel.setNoTelp(noTelepon);
            hotel.setLmTinggal(lamaTinggal);
            hotelList.add(hotel);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return hotelList;
}
}