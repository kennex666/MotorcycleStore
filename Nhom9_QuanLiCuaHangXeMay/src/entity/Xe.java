package entity;

public class Xe {
	private String maXe;
	private String tenXe;
	private String loaiXe;
	private String nuocSX;
	private double soPK;
	private String soKhung;
	private String soSuon;
	private String mauXe;
	private double giaXe;
	private String imagePath;
	private int soLuongKho, soLuongBan;
	
	private NhaCungCap ncc;

	public Xe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Xe(String maXe) throws Exception {
		super();
		this.setMaXe(maXe);
	}

	public Xe(String maXe, String tenXe, String loaiXe, String nuocSX, double soPK, String soKhung, String soSuon,
			String mauXe, double giaXe, String imagePath, NhaCungCap ncc, int slKho, int slBan) throws Exception {
		super();
		this.setMaXe(maXe);
		this.setTenXe(tenXe);
		this.setLoaiXe(loaiXe);
		this.setNuocSX(nuocSX);
		this.setSoPK(soPK);
		this.setSoKhung(soKhung);
		this.setSoSuon(soSuon);
		this.setMauXe(mauXe);
		this.setGiaXe(giaXe);
		this.setImagePath(imagePath);
		this.ncc = ncc;
		this.setSoLuongKho(slKho);
		this.setSoLuongBan(slBan);
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) throws Exception {
		if (maXe.trim().equals("")) {
			throw new Exception("Mã xe không được để trống");
		}
		else this.maXe = maXe;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) throws Exception {
		if (tenXe.trim().equals("")) {
			throw new Exception("Tên xe không được để trống");
		}
		else this.tenXe = tenXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) throws Exception {
		if (loaiXe.trim().equals("")) {
			throw new Exception("Loại xe không được để trống");
		}
		else this.loaiXe = loaiXe;
	}

	public String getNuocSX() {
		return nuocSX;
	}

	public void setNuocSX(String nuocSX) throws Exception {
		if (nuocSX.trim().equals("")) {
			throw new Exception("Nước sản xuất không  được để trống");
		}
		else this.nuocSX = nuocSX;
	}

	public double getSoPK() {
		return soPK;
	}

	public void setSoPK(double soPK) throws Exception {
		if (soPK <= 0) {
			throw new Exception("Số phân khối không hợp lệ");
		}
		else this.soPK = soPK;
	}

	public String getSoKhung() {
		return soKhung;
	}

	public void setSoKhung(String soKhung) throws Exception {
		if (soKhung.trim().equals("")) {
			throw new Exception("Số khung không được để trống");
		}
		else this.soKhung = soKhung;
	}

	public String getSoSuon() {
		return soSuon;
	}

	public void setSoSuon(String soSuon) throws Exception {
		if (soSuon.trim().equals("")) {
			throw new Exception("Số sườn không được để trống");
		}
		else this.soSuon = soSuon;
	}

	public String getMauXe() {
		return mauXe;
	}

	public void setMauXe(String mauXe) throws Exception {
		if (mauXe.trim().equals("")) {
			throw new Exception("Màu xe không được để trống");
		}
		else this.mauXe = mauXe;
	}

	public double getGiaXe() {
		return giaXe;
	}

	public void setGiaXe(double giaXe) throws Exception {
		if (giaXe <= 0) {
			throw new Exception("Giá xe không hợp lệ");
		}
		else this.giaXe = giaXe;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) throws Exception {
		if (imagePath.trim().equals("")) {
			throw new Exception("Đường dẫn ảnh không được để trống");
		}
		else this.imagePath = imagePath;
	}

	public NhaCungCap getNcc() {
		return ncc;
	}

	public void setNcc(NhaCungCap ncc) {
		this.ncc = ncc;
	}

	public int getSoLuongKho() {
		return soLuongKho;
	}

	public void setSoLuongKho(int soLuongKho) {
		this.soLuongKho = soLuongKho;
	}

	public int getSoLuongBan() {
		return soLuongBan;
	}

	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}

	
	
	
}
