package entity;

import java.util.Objects;

public class ChiTietHoaDon {
	private int id;
	private int soLuongXe;
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(int id, int soLuongXe) throws Exception {
		super();
		setId(id);
		setSoLuongXe(soLuongXe);
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) throws Exception {
		if (id<=0)
			throw new Exception("Đã có lỗi trong quá trình phát sinh ID chi tiết hóa đơn");
		this.id = id;
	}
	public int getSoLuongXe() {
		return soLuongXe;
	}
	public void setSoLuongXe(int soLuongXe) throws Exception {
		if (soLuongXe<=0)
			throw new Exception("Số lượng xe phải lớn hơn 0");
		this.soLuongXe = soLuongXe;
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
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [id=" + id + ", soLuongXe=" + soLuongXe + "]";
	}
	
	
}