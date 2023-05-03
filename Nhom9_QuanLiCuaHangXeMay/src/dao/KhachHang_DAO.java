package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import interfaces.IKhachHang;

public class KhachHang_DAO implements IKhachHang {
	Connection con = ConnectDB.getConnection(); 
	@Override
	public ArrayList<KhachHang> getAllKhachHang() throws Exception{
		ArrayList<KhachHang> list = new ArrayList<>();
		String query = "Select * from KhachHang";
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				String maKH = results.getString("MaKH");
				String tenKH = results.getString("TenKH");
				String diaChi = results.getString("DiaChi");
				String sdt = results.getString("SDT");
				String cccd = results.getString("SoCCCD");
				boolean gioiTinhString = results.getBoolean("GioiTinh");
				Date ngaySinh = results.getDate("NgaySinh");
				
				KhachHang kh = new KhachHang(maKH, tenKH, diaChi, sdt, cccd, gioiTinhString, ngaySinh.toLocalDate());
				list.add(kh);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}