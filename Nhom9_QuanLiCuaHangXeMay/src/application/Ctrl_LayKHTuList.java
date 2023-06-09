package application;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import bus.KhachHang_BUS;
import connectDB.ConnectDB;
import entity.KhachHang;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utilities.PopupNotify;
import utilities.SelectedTab;

public class Ctrl_LayKHTuList {
	@FXML
	private TableView tblKhachHang;
	@FXML
	private TabPane allTabs;
	@FXML
	private TableColumn<KhachHang, String> colMaKH, colHoTen, colNgaySinh, colDiaChi, colSDT, colEmail;
	@FXML
	private TableColumn<KhachHang, Boolean> colGioiTinh;
	@FXML
	private TableColumn<KhachHang, Number> colSTT;
	@FXML
	private TextField txtSearch;
	
	private TextField txtLoad;
	
	private KhachHang_BUS kh_bus;
	private ObservableList<KhachHang> listKHObs = FXCollections.observableArrayList();
	private KhachHang khSelected;
	
	@FXML
	private void initialize() {

		// Preload for KhachHang Table
		loadDataTablePropertyKH();
		loadDataKHToTable();
		tblKhachHang.setItems(listKHObs);
		
	}

	
	/*
	 * Handle event Tab KhachHang
	 */
	@FXML
	private void actionBtnSelect(){
		if (txtLoad == null) {
			PopupNotify.showErrorField("Lỗi", "Load dữ liệu thất bại!", null);
			return;
		}
		KhachHang temp = (KhachHang) tblKhachHang.getSelectionModel().getSelectedItem();
		if (temp == null) {
			PopupNotify.showErrorField("Lỗi", "Chưa chọn khách hàng!", "Hãy nhấn vào tên khách hàng để chọn");
			return;
		}
		khSelected = temp;
		txtLoad.setText(temp.getTenKhachHang() + " | " + temp.getSoDT());
		txtLoad.setDisable(true);
		Stage stg = (Stage) tblKhachHang.getScene().getWindow();
		stg.close();
		
	}
	
	private void loadDataTablePropertyKH() {
		colMaKH.setCellValueFactory(new PropertyValueFactory<>("maKhachHang"));
		colHoTen.setCellValueFactory(new PropertyValueFactory<>("tenKhachHang"));
		colSDT.setCellValueFactory(new PropertyValueFactory<>("soDT"));
		colGioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
		colGioiTinh.setCellFactory(column -> {
			return new TableCell<KhachHang, Boolean>(){
				@Override
				protected void updateItem(Boolean item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null) {
						setText(null);
					}else {
						setText(item ? "Nam" : "Nữ");
					}
				}
			};
		});
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colNgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
		
		// Auto numbered
		colSTT.setSortable(false);
		colSTT.setCellValueFactory(col -> 
			new ReadOnlyObjectWrapper<Number>(tblKhachHang.getItems().indexOf(col.getValue()) + 1));

	}
	
	private void loadDataKHToTable() {
		ArrayList<KhachHang> listKH = kh_bus.getAllCustomers();
		for (KhachHang x : listKH)
			listKHObs.add(x);
	}
	
	private void removeAllRowsKH() {
		// TODO Auto-generated method stub
		listKHObs.clear();
	}
	
	@FXML
	private void actionSearchKH() {
		// TODO Auto-generated method stub
		String ma = txtSearch.getText();
		removeAllRowsKH();
		if (ma.isBlank()) {
			loadDataKHToTable();
		}else {
			ArrayList<KhachHang> listSearch = kh_bus.findCustomers(ma);
			for (KhachHang x : listSearch) {
				listKHObs.add(x);
			}
		}
	}
	
	@FXML
	private void actionRefreshTableKH() {
		// TODO Auto-generated method stub
		removeAllRowsKH();
		loadDataKHToTable();
		txtSearch.setText("");
		
	}
	
	public void setKhachHang(KhachHang x) {
		this.khSelected = x;
	}
	
	public KhachHang getKhachHang() {
		return khSelected;
	}
	
	public void setTextFieldLoad(TextField x) {
		txtLoad = x;
	}
	
	
	public Ctrl_LayKHTuList() {
		super();
		ConnectDB.getInstance().connect();
		kh_bus = new KhachHang_BUS();
	}
}