package bus;

import java.util.ArrayList;

import dao.HoaDon_DAO;
import entity.HoaDon;

public class HoaDon_BUS {
	HoaDon_DAO hd_DAO;

	public HoaDon_BUS() {
		super();
		hd_DAO = new HoaDon_DAO();
	}
	
	public ArrayList<HoaDon> getAllHoaDon() throws Exception {
		return hd_DAO.getAllHoaDon();
	}
	
	public void taoHoaDon(HoaDon hd) {
		hd_DAO.taoHoaDon(hd);
	}
	
}
