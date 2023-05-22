/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package booking_hotel.DAOImplement;

import booking_hotel.Model.Model_Hotel;
/**
 *
 * @author Kyy
 */
public interface Implement_Hotel{
    
    public void insert(Model_Hotel hotel);
    
    public void update(Model_Hotel hotel);
    
    public void delete(int id);
    
    public java.util.List<Model_Hotel> getALL();
    
    public java.util.List<Model_Hotel> getCariNama(String nmPelanggan);
    
}
