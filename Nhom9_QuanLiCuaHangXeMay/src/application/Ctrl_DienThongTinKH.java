package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Ctrl_DienThongTinKH {
	private ToggleGroup radGroup;
	
	@FXML
	private RadioButton radNam, radNu;
	
	@FXML
	private void initialize() { // Khi khởi tạo toàn bộ thì sẽ thực hiện
		radNam.setToggleGroup(radGroup);
		radNu.setToggleGroup(radGroup);
		radNam.setSelected(true);
	}
	
	public Ctrl_DienThongTinKH() {
		radGroup = new ToggleGroup();
		// Tạo giao diện.
		// Tự động
	}
	
	
}
