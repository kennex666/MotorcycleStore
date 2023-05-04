package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import bus.ChiTietHoaDon_BUS;
import bus.HoaDon_BUS;
import bus.KhachHang_BUS;
import bus.LinhKien_BUS;
import bus.NhaCungCap_BUS;
import bus.NhanVien_BUS;
import bus.Xe_BUS;
import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;
import dao.Xe_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Xe;
import interfaces.IXe;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class Ctrl_MainMenu {
	@FXML
	private Button btnXe;

	@FXML
	private Button btnLinhKien;

	@FXML
	private SplitPane splitPaneXe;

	@FXML
	private SplitPane splitPaneLK;

	@FXML
	private SplitPane splitPaneBH;

	@FXML
	private Tab tabProduct;

	@FXML
	private AnchorPane productModal;

	@FXML
	private TabPane allTabs;

	@FXML
	private TableView<Xe> tblXe;

	@FXML
	private TableView<Object> tblProduct;

	@FXML
	private TableView<Object> tblCart;

	@FXML
	private TableColumn<Xe, Integer> stt;

	@FXML
	private TableColumn<Xe, String> maXe;

	@FXML
	private TableColumn<Xe, String> tenXe;

	@FXML
	private TableColumn<Xe, Double> giaBan;

	@FXML
	private TableColumn<Xe, String> hangSX;

	@FXML
	private TableColumn<Xe, Double> soPhanKhoi;

	@FXML
	private TableColumn<Xe, String> nuocSX;

	@FXML
	private TableColumn<Xe, Integer> soLuongKho;

	@FXML
	private TableColumn<Object, String> maSPGen;

	@FXML
	private TableColumn<Object, String> tenSPGen;

	@FXML
	private TableColumn<Object, Double> giaBanGen;

	@FXML
	private TableColumn<Object, Integer> soLuongGen;

	@FXML
	private TableColumn<Object, String> maSPCart;

	@FXML
	private TableColumn<Object, String> tenSPCart;

	@FXML
	private TableColumn<Object, Double> giaBanCart;

	@FXML
	private TableColumn<Object, Integer> soLuongCart;

	@FXML
	private ComboBox<NhaCungCap> cbNCC;

	@FXML
	private ComboBox<String> cbNSX;

	@FXML
	private TextField queryXe;

	@FXML
	private TextField maSPModal;

	@FXML
	private TextField tenSPModal;

	@FXML
	private TextField tenNCCModal;

	@FXML
	private TextField soLuongKhoModal;

	@FXML
	private TextField soPKModal;

	@FXML
	private TextField soKhungModal;

	@FXML
	private TextField soSuonModal;

	@FXML
	private TextField nuocSXModal;

	@FXML
	private TextField giaXeModal;

	@FXML
	private TextField ngayNhapModal;

	@FXML
	private ImageView imgPathModal;

	@FXML
	private TextField txtQuantity;

	@FXML
	private TableView<KhachHang> tblKhachHang;

	@FXML
	private TableColumn<KhachHang, String> maKHCol;

	@FXML
	private TableColumn<KhachHang, String> tenKHCol;

	@FXML
	private TableColumn<KhachHang, String> diaChiCol;

	@FXML
	private TableColumn<KhachHang, String> gioiTinhCol;

	@FXML
	private TableColumn<KhachHang, String> ngaySinhCol;

	@FXML
	private TableColumn<KhachHang, String> sdtCol;

	@FXML
	private TableColumn<KhachHang, String> cccdCol;

	@FXML
	private TableView<LinhKien> tblLinhKien;

	@FXML
	private TableColumn<LinhKien, String> maLKCol;

	@FXML
	private TableColumn<LinhKien, String> tenLKCol;

	@FXML
	private TableColumn<LinhKien, Double> giaLKCol;

	@FXML
	private TableColumn<LinhKien, String> hangSXCol;

	@FXML
	private TableColumn<LinhKien, Integer> soLuongCol;
	
	@FXML
	private TableView<HoaDon> tblHoaDon;

	@FXML
	private TableView<ChiTietHoaDon> tblCTHD;
	
	@FXML
	private TableColumn<HoaDon, String> maHDCol;
	
	@FXML
	private TableColumn<HoaDon, String> tenNVCol;
	
	@FXML
	private TableColumn<HoaDon, String> ngayLapHDCol;
	
	@FXML
	private TableColumn<HoaDon, Double> tongTienCol;
	
	@FXML
	private TableColumn<HoaDon, String> tenKHHDCol;	
	
	@FXML
	private TableColumn<ChiTietHoaDon, Integer> maCTHDCol;	
	
	@FXML
	private TableColumn<ChiTietHoaDon, String> maSPCTHD;	
	
	@FXML
	private TableColumn<ChiTietHoaDon, String> tenSPCTHD;	
	
	@FXML
	private TableColumn<ChiTietHoaDon, Double> giaSPCTHD;	
	
	@FXML
	private TableColumn<ChiTietHoaDon, Integer> soLuongSPCTHD;	
	
	@FXML
	private TableColumn<ChiTietHoaDon, Double> tongTienCTHD;	
	
	@FXML
	private DatePicker startDate;	
	
	@FXML
	private DatePicker endDate;	
	
	@FXML
	private Button cartRemove;
	
	@FXML
	private TextField khCart;

	private NhaCungCap_BUS ncc_BUS;
	private LinhKien_BUS linhKien_BUS;
	private KhachHang_BUS kh_BUS;
	private HoaDon_BUS hd_BUS;
	private NhanVien_BUS nv_BUS;
	private ChiTietHoaDon_BUS cthd_BUS;
	private Xe_BUS xe_BUS = new Xe_BUS();
	private ArrayList<Xe> listXe;
	private ArrayList<Xe> listXeCart;
	private ArrayList<LinhKien> listLinhKien;
	private ArrayList<LinhKien> listLinhKienCart;
	private ArrayList<KhachHang> listKH;
	private ArrayList<HoaDon> listHD;
	private ArrayList<ChiTietHoaDon> listCTHD;
	private KhachHang khHoaDon;

	@FXML
	private Button btnThemKH;

	@FXML 
	private void addCboNCC() {
		ArrayList<NhaCungCap> listNCC = ncc_BUS.getAllNCC();

		cbNCC.getItems().add(new NhaCungCap(null, "Tất cả"));
		cbNCC.getItems().addAll(listNCC);

		cbNCC.setConverter(new StringConverter<NhaCungCap>() {
			@Override
			public String toString(NhaCungCap nhaCungCap) {
				return nhaCungCap == null ? null : nhaCungCap.getTenNCC();
			}

			@Override
			public NhaCungCap fromString(String string) {
				return null;
			}
		});

		cbNCC.setValue(listNCC.get(0));

	}

	private void addCboNuocSX(ArrayList<Xe> listXe) {
		ArrayList<String> listNSX = new ArrayList<>();
		for (Xe xe: listXe) {
			if (!listNSX.contains(xe.getNuocSX())) {
				listNSX.add(xe.getNuocSX());
			}

		}

		cbNSX.getItems().add("Tất cả");
		cbNSX.getItems().addAll(listNSX);

		cbNSX.setValue(listNSX.get(0));
	}

	private void renderXeInfoToView() throws Exception {

		listXe = xe_BUS.getAllXe();

		tblXe.getItems().addAll(listXe);


		addCboNuocSX(listXe);
	}
	
	private void renderHoaDonToTable() throws Exception {
		listHD = hd_BUS.getAllHoaDon();
		
		for (HoaDon i: listHD) {
			i.getKh().setTenKhachHang(kh_BUS.getTenByMaKH(i.getKh().getMaKhachHang()));
			i.getNv().setHoTenNV(nv_BUS.getTenByMa(i.getNv().getID()));
		}
		
		maHDCol.setCellValueFactory(new PropertyValueFactory<HoaDon, String>("id"));
		tenNVCol.setCellValueFactory(cellData -> {
			return new SimpleStringProperty(cellData.getValue().getNv().getHoTenNV());
		});
		tenKHHDCol.setCellValueFactory(cellData -> {
			return new SimpleStringProperty(cellData.getValue().getKh().getTenKhachHang());
		});
		ngayLapHDCol.setCellValueFactory(new PropertyValueFactory<HoaDon, String>("ngayLapHoaDon"));
		tongTienCol.setCellValueFactory(new PropertyValueFactory<HoaDon, Double>("tongTien"));
		
		tblHoaDon.getItems().addAll(listHD);
	}
	
	private void timKiemHoaDon() {
		ArrayList<HoaDon> listTimKiem = new ArrayList<>();
		for (HoaDon i: tblHoaDon.getItems()) {
			if (i.getNgayLapHoaDon().toLocaleString().compareTo(startDate.toString()) >= 0 && 
					i.getNgayLapHoaDon().toLocaleString().compareTo(endDate.toString()) <=0) {
				listTimKiem.add(i);
			}
		}
	}
	
	@FXML
	private void xemCTHD() throws Exception {
		HoaDon hd = tblHoaDon.getSelectionModel().getSelectedItem();
		listCTHD = cthd_BUS.getCTHDByMaHD(hd.getId());
		
		maCTHDCol.setCellValueFactory(new PropertyValueFactory<ChiTietHoaDon, Integer>("id"));
		maSPCTHD.setCellValueFactory(new PropertyValueFactory<ChiTietHoaDon, String>("maSP"));
		giaSPCTHD.setCellValueFactory(new PropertyValueFactory<>("giaBan"));
		soLuongSPCTHD.setCellValueFactory(new PropertyValueFactory<>("soLuongXe"));
		
		tblCTHD.getItems().clear();
		tblCTHD.getItems().addAll(listCTHD);
	}

	@FXML
	private void timKiemTrenTable() {
		String tenNCC = cbNCC.getSelectionModel().getSelectedItem().getTenNCC();
		String nuocSX = cbNSX.getSelectionModel().getSelectedItem().toString();
		String query = queryXe.getText();
		ArrayList<Xe> listXe_TimKiem = new ArrayList<>();
		for (Xe xe: listXe) {
			String productName = xe.getTenXe();
			String country = xe.getNuocSX();
			String manufacturer = ncc_BUS.getTenNCCByMa(xe.getNcc().getMaNCC());
			boolean isProductNameContains = productName.toLowerCase().contains(query.trim().toLowerCase());
			boolean isCountryEquals = country.toLowerCase().equals(nuocSX.trim().toLowerCase());
			boolean isManufacturerEquals = manufacturer.toLowerCase().equals(tenNCC.trim().toLowerCase());

			//		    Lọc cả 3 điều kiện
			if (!query.trim().equals("") && !tenNCC.equals("Tất cả") && !nuocSX.equals("Tất cả")) {
				if (isProductNameContains && isCountryEquals && isManufacturerEquals) {
					listXe_TimKiem.add(xe);
				}
			}
			else if (!query.trim().equals("") && !tenNCC.equals("Tất cả")) {
				if (isProductNameContains && isManufacturerEquals) {
					listXe_TimKiem.add(xe);
				}
			}
			else if (!query.trim().equals("") && !nuocSX.equals("Tất cả")) {
				if (isProductNameContains && isCountryEquals) {
					listXe_TimKiem.add(xe);
				}
			}
			else if (!query.trim().equals("") && isProductNameContains) {
				listXe_TimKiem.add(xe);
			}
			else if (!tenNCC.equals("Tất cả") && isManufacturerEquals) {
				listXe_TimKiem.add(xe);
			}
			else if (isCountryEquals) {
				listXe_TimKiem.add(xe);
			}
		}

		tblXe.getItems().clear();
		tblXe.getItems().addAll(listXe_TimKiem);

	}

	private void addKHToTable() throws Exception {
		listKH = kh_BUS.getAllKhachHang();

		maKHCol.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("maKhachHang"));
		tenKHCol.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("tenKhachHang"));
		diaChiCol.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("diaChi"));
		sdtCol.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("soDT"));
		gioiTinhCol.setCellValueFactory(cellData -> {
			if (cellData.getValue().isGioiTinh() == true) return new SimpleStringProperty("Nam");
			else return new SimpleStringProperty("Nữ");
		});
		cccdCol.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("soCCCD"));
		ngaySinhCol.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("ngaySinh"));

		tblKhachHang.getItems().clear();
		tblKhachHang.getItems().addAll(listKH);
	}

	private void addLinhKienToTable() throws Exception {
		listLinhKien = linhKien_BUS.getAllLinhKien();

		maLKCol.setCellValueFactory(new PropertyValueFactory<LinhKien, String>("id"));
		tenLKCol.setCellValueFactory(new PropertyValueFactory<LinhKien, String>("ten"));
		giaLKCol.setCellValueFactory(new PropertyValueFactory<LinhKien, Double>("giaLinhKien"));
		hangSXCol.setCellValueFactory(cellData -> {
			return new ReadOnlyObjectWrapper<>(ncc_BUS.getTenNCCByMa(cellData.getValue().getNhaCungCap().getMaNCC()));
		});
		soLuongCol.setCellValueFactory(cellData -> {
			return new ReadOnlyObjectWrapper<>(cellData.getValue().getSoLuongKho());
		});

		tblLinhKien.getItems().clear();
		tblLinhKien.getItems().addAll(listLinhKien);

	}

	@FXML
	private void initialize() throws Exception {
		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connect");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ncc_BUS = new NhaCungCap_BUS();
		xe_BUS = new Xe_BUS();
		linhKien_BUS = new LinhKien_BUS();
		kh_BUS = new KhachHang_BUS();
		hd_BUS = new HoaDon_BUS();
		nv_BUS = new NhanVien_BUS();
		cthd_BUS = new ChiTietHoaDon_BUS();

		tabProduct.getTabPane().getTabs().remove(tabProduct);

		stt.setCellValueFactory(new PropertyValueFactory<>("id"));
		//		Set STT auto increase
		stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Xe,Integer>, ObservableValue<Integer>>() {

			@Override
			public ObservableValue<Integer> call(CellDataFeatures<Xe, Integer> xe) {
				// TODO Auto-generated method stub
				return new ReadOnlyObjectWrapper<>(tblXe.getItems().indexOf(xe.getValue()) + 1);
			}
		});

		maXe.setCellValueFactory(new PropertyValueFactory<Xe, String>("maXe"));
		tenXe.setCellValueFactory(new PropertyValueFactory<Xe, String>("tenXe"));
		giaBan.setCellValueFactory(new PropertyValueFactory<Xe, Double>("giaXe"));
		hangSX.setCellValueFactory(cellData -> 
		new SimpleStringProperty(ncc_BUS.getTenNCCByMa(cellData.getValue().getNcc().getMaNCC())));
		soPhanKhoi.setCellValueFactory(new PropertyValueFactory<Xe, Double>("soPK"));
		nuocSX.setCellValueFactory(new PropertyValueFactory<Xe, String>("nuocSX"));
		soLuongKho.setCellValueFactory(new PropertyValueFactory<Xe, Integer>("soLuongKho"));

		renderXeInfoToView();
		addCboNCC();
	}

	@FXML
	private void handleClickTabKH() throws Exception {
		addKHToTable();
	}
	
	@FXML
	private void handleClickTabHD () throws Exception {
		renderHoaDonToTable();
	}

	@FXML
	private void actionListProduct(){
		allTabs.getTabs().add(tabProduct);
	}

	@FXML
	private void actionAddSplitPaneXe() {
		allTabs.getTabs().add(tabProduct);
		splitPaneXe.setVisible(true);
		splitPaneLK.setVisible(false);
		splitPaneBH.setVisible(false);
	}

	@FXML
	private void actionAddSplitPaneLK() throws Exception {
		allTabs.getTabs().add(tabProduct);
		splitPaneLK.setVisible(true);
		splitPaneXe.setVisible(false);
		splitPaneBH.setVisible(false);
		addLinhKienToTable();
	}

	@FXML
	private void actionAddSplitPaneBH() throws Exception {
		allTabs.getTabs().add(tabProduct);
		splitPaneBH.setVisible(true);
		splitPaneXe.setVisible(false);
		splitPaneLK.setVisible(false);
		renderDataToProductTbl();
	}

	@FXML
	private void handleClickRowTable(MouseEvent e) {
		Xe xe = tblXe.getSelectionModel().getSelectedItem();
		if (xe != null && e.getClickCount() == 2) {
			productModal.setVisible(true);
			maSPModal.setText(xe.getMaXe());
			tenSPModal.setText(xe.getTenXe());
			tenNCCModal.setText(ncc_BUS.getTenNCCByMa(xe.getNcc().getMaNCC()));
			soLuongKhoModal.setText(xe.getSoLuongKho()+"");
			soPKModal.setText(String.valueOf(xe.getSoPK()));
			soKhungModal.setText(xe.getSoKhung());
			soSuonModal.setText(xe.getSoSuon());
			nuocSXModal.setText(xe.getNuocSX());
			giaXeModal.setText(String.valueOf(xe.getGiaXe()));

			Image image = new Image(xe.getImagePath());
			imgPathModal.setImage(image);
		}
	}
	
	@FXML 
	private void handleRemoveFromCart() {
//		int index = tblCart.getSelectionModel().getSelectedIndex();
//		Object obj = tblCart.getItems().get(index);
//		tblCart.getItems().remove(index);
	}
	
	@FXML 
	private void handleChonKH() {
		 BorderPane root;
		try {
//			root = (BorderPane)FXMLLoader.load(getClass().getResource("FrmDienThongTinKH.fxml"));
			FXMLLoader fxml = new FXMLLoader(getClass().getResource("FrmLayKHTuList.fxml"));
			root = (BorderPane) fxml.load();
			Ctrl_LayKHTuList ctrl_LayKH = fxml.getController();
			Scene scene = new Scene(root);
			Stage modalStage = new Stage();
			modalStage.setScene(scene);
			modalStage.show();
//	        modalStage.initModality(Modality.APPLICATION_MODAL);
//	        modalStage.initOwner(btnThemKH.getScene().getWindow());
//	        modalStage.setScene(scene);
//	        modalStage.showAndWait();
			ctrl_LayKH.setTextFieldLoad(khCart);
			ctrl_LayKH.setKhachHang(khHoaDon);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void handleCloseModal() {
		productModal.setVisible(false);
	}

	private void renderDataToProductTbl() throws Exception {
		System.out.println("RUN");
		listLinhKien = linhKien_BUS.getAllLinhKien();
		listXe = xe_BUS.getAllXe();

		maSPGen.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new SimpleStringProperty(((Xe) obj).getMaXe());
			}
			else return new SimpleStringProperty(((LinhKien) obj).getId());
		});

		tenSPGen.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new SimpleStringProperty(((Xe) obj).getTenXe());
			}
			else return new SimpleStringProperty(((LinhKien) obj).getTen());
		});

		soLuongGen.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new ReadOnlyObjectWrapper<>(((Xe)cellData.getValue()).getSoLuongKho());
			}
			else return new ReadOnlyObjectWrapper<>(((LinhKien)cellData.getValue()).getSoLuongKho());
		});

		giaBanGen.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new ReadOnlyObjectWrapper<>(((Xe) obj).getGiaXe());
			}
			else return new ReadOnlyObjectWrapper<>(((LinhKien) obj).getGiaLinhKien());
		});

		tblProduct.getItems().clear();
		tblProduct.getItems().addAll(listXe);
		tblProduct.getItems().addAll(listLinhKien);

	}

	@FXML
	private void handleAddToCart() throws Exception {
		listXeCart = xe_BUS.getAllXe();
		listLinhKienCart = linhKien_BUS.getAllLinhKien();
		int quantity = Integer.parseInt(txtQuantity.getText());
		Object productSelected = tblProduct.getSelectionModel().getSelectedItem();
		int quantityKho;

		maSPCart.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new SimpleStringProperty(((Xe) obj).getMaXe());
			}
			else return new SimpleStringProperty(((LinhKien) obj).getId());
		});

		tenSPCart.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new SimpleStringProperty(((Xe) obj).getTenXe());
			}
			else return new SimpleStringProperty(((LinhKien) obj).getTen());
		});

		soLuongCart.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				//				((Xe)cellData.getValue()).getKho().getSoLuong()
				return new ReadOnlyObjectWrapper<>(((Xe)cellData.getValue()).getSoLuongKho());
			}
			else return new ReadOnlyObjectWrapper<>(((LinhKien)cellData.getValue()).getSoLuongKho());
		});

		giaBanCart.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new ReadOnlyObjectWrapper<>(((Xe) obj).getGiaXe());
			}
			else return new ReadOnlyObjectWrapper<>(((LinhKien) obj).getGiaLinhKien());
		});

		if (productSelected instanceof Xe) {
			quantityKho = ((Xe) productSelected).getSoLuongKho();
		} else quantityKho = ((LinhKien) productSelected).getSoLuongKho();
		System.out.println(quantityKho);
		if (quantity > quantityKho) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Không đủ số lượng");
			alert.setHeaderText(null);
			alert.setContentText("Sản phẩm không đủ số lượng");
			alert.showAndWait();
		}
		else {

			if (productSelected instanceof Xe) {
				Xe xeSelected = ((Xe) productSelected);
				((Xe) productSelected).setSoLuongKho(quantityKho - quantity);

				int isHave = 0;

				for (Xe i: listXeCart) {
					if (xeSelected.getMaXe().equals(i.getMaXe())) {
						i.setSoLuongKho(quantity);

						for (Object obj: tblCart.getItems()) {
							if (obj instanceof Xe) {
								Xe x = (Xe) obj;
								if (((Xe) obj).getMaXe().equals(i.getMaXe())) {
									isHave = 1;
									System.out.println(x.getSoLuongKho());
									x.setSoLuongKho(x.getSoLuongKho() + quantity);
								}
							}
						}
						if (isHave == 0) 
							tblCart.getItems().add(i);
					}
				}
			}
			else {
				LinhKien lkSelected = ((LinhKien) productSelected);
				lkSelected.setSoLuongKho(quantityKho - quantity);
				int isHave = 0;

				for (LinhKien i: listLinhKienCart) {
					if (lkSelected.getId().equals(i.getId())) {
						i.setSoLuongKho(quantity);

						for (Object obj: tblCart.getItems()) {
							if (obj instanceof LinhKien) {
								LinhKien x = (LinhKien) obj;
								if (x.getId().equals(i.getId())) {
									isHave = 1;
									x.setSoLuongKho(x.getSoLuongKho() + quantity);
								}
							}
						}
						if (isHave == 0) 
							tblCart.getItems().add(i);
					}
				}
			}

			tblProduct.refresh();
			tblCart.refresh();

		}

	}

	@FXML
	private void handleClickThanhToan() throws Exception {
		for (Object obj: tblProduct.getItems()) {
			if (obj instanceof Xe) {
				Xe xe = (Xe) obj;
				xe_BUS.updateSLKho(xe.getSoLuongKho(), xe.getMaXe());
			}
			else {
				LinhKien lk = (LinhKien) obj;
				linhKien_BUS.updateSLKho(lk.getSoLuongKho(), lk.getId());
			}
		}
		for (Object obj: tblCart.getItems()) {
			if (obj instanceof Xe) {
				Xe xe = (Xe) obj;
				xe_BUS.updateSLBan(xe.getSoLuongKho(), xe.getMaXe());
			}
			else {
				LinhKien lk = (LinhKien) obj;
				linhKien_BUS.updateSLBan(lk.getSoLuongKho(), lk.getId());
			}
		}
		NhanVien nv = new NhanVien("NV001");
		HoaDon hd = new HoaDon("1", java.sql.Date.valueOf(LocalDate.now()), khHoaDon, nv, 100000);
		HoaDon_BUS hd_BUS = new HoaDon_BUS();
		hd_BUS.taoHoaDon(hd);
		renderDataToProductTbl();

	}
	
	@FXML 
	private void openModalThemKH() {
			 BorderPane root;
			try {
				root = (BorderPane)FXMLLoader.load(getClass().getResource("FrmDienThongTinKH.fxml"));
				Scene scene = new Scene(root);
//				stageTheLabelBelongs.setScene(scene);
//				stageTheLabelBelongs.centerOnScreen();
				Stage modalStage = new Stage();
		        modalStage.initModality(Modality.APPLICATION_MODAL);
		        modalStage.initOwner(btnThemKH.getScene().getWindow());
		        modalStage.setScene(scene);
		        modalStage.showAndWait();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}

	public Ctrl_MainMenu() {
		super();
	}
}