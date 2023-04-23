package entity;

import java.util.Objects;

public class LinhKien {
	private Kho kho;
	private String id, ten, imagePath;
	
	public LinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LinhKien(String id) throws Exception{
		super();
		setId(id);
	}
	public LinhKien(String id, String ten, Kho kho, String imagePath) throws Exception{
		super();
		setId(id);
		setKho(kho);
		setTen(ten);
		setImagePath(imagePath);
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
	public Kho getKho() {
		return kho;
	}
	public String getTen() {
		return ten;
	}
	public void setId(String id) throws Exception{
		if (id.trim() == "" || id.isEmpty() || id.isBlank())
			throw new Exception("ID không hợp lệ. Lỗi trong quá trình phát sinh!");
		this.id = id;
	}
	public void setKho(Kho kho) throws Exception{
		if (kho == null)
			throw new Exception("Chưa có kho. Vui lòng kiểm tra lại!");
		this.kho = kho;
	}
	public void setTen(String ten) throws Exception{
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
	
	
	
}
