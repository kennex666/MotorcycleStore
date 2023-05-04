package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import interfaces.IChiTietHoaDon;

public class ChiTietHoaDon_DAO implements IChiTietHoaDon{
	Connection con = ConnectDB.getConnection();

	@Override
	public ArrayList<ChiTietHoaDon> getCTHDByMaHD(String maHD) throws Exception {
		ArrayList<ChiTietHoaDon> list = new ArrayList<>();
		String query = "Select * from ChiTietHoaDon WHERE MaHD = '" + maHD + "'";;
		try {
			Statement stm = con.createStatement();
			ResultSet results = stm.executeQuery(query);
			while (results.next()) {
				int maCTHD = results.getInt("MaCTHD");
				HoaDon hd = new HoaDon(results.getString("MaHD"));
				int soLuong = results.getInt("SoLuong");
				String maSP = results.getString("MaSP");
				double giaBan = results.getDouble("GiaBan");
				
				ChiTietHoaDon cthd = new ChiTietHoaDon(maCTHD, soLuong, giaBan, maSP, hd);
				
				list.add(cthd);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
