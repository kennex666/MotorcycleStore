package entity;

import java.util.Objects;

public class LinhKien {
	private String id, ten, imagePath;
	private NhaCungCap nhaCungCap;
	private double giaLinhKien;
	private int soLuongKho, soLuongBan;

	public LinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinhKien(String id) throws Exception {
		super();
		setId(id);
	}

	public LinhKien(String id, String ten, String imagePath, NhaCungCap nhaCungCap, 
			double giaLinhKien, int slKho, int slBan) throws Exception {
		super();
		setId(id);
		setTen(ten);
		setImagePath(imagePath);
		this.nhaCungCap = nhaCungCap;
		setGiaLinhKien(giaLinhKien);
		this.setSoLuongKho(slKho);
		this.setSoLuongBan(slBan);
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		// Nếu không có sẽ được gắn hình mặc định.
		this.imagePath = imagePath;
	}

	public String getId() {
		return id;
	}

	public String getTen() {
		return ten;
	}

	public void setId(String id) throws Exception {
		if (id.trim() == "" || id.isEmpty() || id.isBlank())
			throw new Exception("ID không hợp lệ. Lỗi trong quá trình phát sinh!");
		this.id = id;
	}

	public void setTen(String ten) throws Exception {
		if (ten.trim() == "" || ten.isEmpty() || ten.isBlank())
			throw new Exception("Tên linh kiện rỗng!");
		this.ten = ten;
	}

	@Override
	public String toString() {
		return "LinhKien [id=" + id + ", ten=" + ten + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinhKien other = (LinhKien) obj;
		return Objects.equals(id, other.id);
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}


	public double getGiaLinhKien() {
		return giaLinhKien;
	}

	public void setGiaLinhKien(double giaLinhKien) throws Exception {
		if (giaLinhKien <= 0) {
			throw new Exception("Giá xe không hợp lệ");
		} else
			this.giaLinhKien = giaLinhKien;
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