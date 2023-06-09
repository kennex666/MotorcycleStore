package bus;

import java.util.ArrayList;

import dao.NhaCungCap_DAO;
import entity.NhaCungCap;

public class NhaCungCap_BUS {
	private NhaCungCap_DAO ncc_DAO;

	public NhaCungCap_BUS() {
		super();
		this.ncc_DAO = new NhaCungCap_DAO();
	}
	
	public ArrayList<NhaCungCap> getAllNCC() {
		ArrayList<NhaCungCap> listNCC = ncc_DAO.getAllNCC();

		return listNCC;
	}
	
	public String getTenNCCByMa(String maNCC) {
		return ncc_DAO.getTenByMa(maNCC);
	}
	
}
