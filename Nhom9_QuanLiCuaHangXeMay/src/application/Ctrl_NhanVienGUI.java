package application;

import java.io.*;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import bus.ChiTietHoaDon_BUS;
import bus.HoaDon_BUS;
import bus.KhachHang_BUS;
import bus.LinhKien_BUS;
import bus.NhaCungCap_BUS;
import bus.NhanVien_BUS;
import bus.Xe_BUS;
import connectDB.ConnectDB;
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
import javafx.event.ActionEvent;
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
import utilities.GenerateID;
import utilities.PopupNotify;

public class Ctrl_NhanVienGUI {
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
	private TableView<Object>tbltk;

	@FXML
	private TableView<Object> tblCart;

	@FXML
	private TableColumn<Xe, Integer> stt;

	@FXML
	private TableColumn<Xe, String> maXe;

	@FXML
	private TableColumn<Xe, String> tenXe;

	@FXML
	private TableColumn<Xe, String> giaBan;

	@FXML
	private TableColumn<Xe, String> hangSX;

	@FXML
	private TableColumn<Xe, Double> soPhanKhoi;

	@FXML
	private TableColumn<Xe, String> nuocSX;

	//thong kê
	@FXML
	private TableColumn<Object, String> masptk;
	@FXML
	private TableColumn<Object, String> tensptk;

	@FXML
	private TableColumn<Object, String> giasptk;
	@FXML
	private TableColumn<Object, String> dtsptk;
	@FXML
	private TableColumn<Object, Integer> slbantk;

	@FXML
	private TableColumn<Object, Integer> slkhotk;

	@FXML
	private TableColumn<Xe, Integer> soLuongKho;

	@FXML
	private TableColumn<Object, String> maSPGen;

	@FXML
	private TableColumn<Object, String> tenSPGen;

	@FXML
	private TableColumn<Object, String> giaBanGen;

	@FXML
	private TableColumn<Object, Integer> soLuongGen;

	@FXML
	private TableColumn<Object, String> maSPCart;

	@FXML
	private TableColumn<Object, String> tenSPCart;

	@FXML
	private TableColumn<Object, String> giaBanCart;

	@FXML
	private TableColumn<Object, Integer> soLuongCart;

	@FXML
	private ComboBox<NhaCungCap> cbNCC;

	@FXML
	private ComboBox<String> cbNSX;

	@FXML
	private TextField txtslban;

	@FXML
	private TextField txtslkho;

	@FXML
	private TextField txtdt;

	@FXML
	private TextField txtthu;

	@FXML
	private TextField txtchi;

	@FXML
	private TextField txttl;

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
	private TableColumn<LinhKien, String> giaLKCol;

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
	private TableColumn<HoaDon, String> tongTienCol;

	@FXML
	private TableColumn<HoaDon, String> tenKHHDCol;	

	@FXML
	private TableColumn<ChiTietHoaDon, Integer> maCTHDCol;	

	@FXML
	private TableColumn<ChiTietHoaDon, String> maSPCTHD;	

	@FXML
	private TableColumn<ChiTietHoaDon, String> tenSPCTHD;	

	@FXML
	private TableColumn<ChiTietHoaDon, String> giaSPCTHD;	

	@FXML
	private TableColumn<ChiTietHoaDon, Integer> soLuongSPCTHD;	

	@FXML
	private TableColumn<ChiTietHoaDon, String> tongTienCTHD;	

	@FXML
	private DatePicker startDate;	

	@FXML
	private TextField txtTimKH;

	@FXML
	private DatePicker endDate;	

	@FXML
	private Button cartRemove;

	@FXML
	private TextField khCart;

	@FXML
	private TableColumn<Object, String> thanhTienCol;

	@FXML
	private TextField txtTongTien;

	@FXML
	private TableColumn<LinhKien, Integer> sttLinhKienCol;

	@FXML
	private TableColumn<KhachHang, Integer> sttKHCol;

	@FXML
	private TableColumn<ChiTietHoaDon, Integer> sttCTHDCol;

	@FXML
	private TableColumn<HoaDon, Integer> sttHDCol;

	@FXML
	private TableColumn<Object, Integer> sttProductCol;	

	@FXML
	private TableColumn<Object, Integer> sttCartCol;	

	@FXML 
	private TextField txtTimLK;


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
	private Ctrl_LayKHTuList ctrl_LayKH;
	private NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
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

		if (listNCC.size() > 0)
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

		if (listNSX.size() > 0)
			cbNSX.setValue(listNSX.get(0));
	}

	private void renderXeInfoToView() throws Exception {

		listXe = xe_BUS.getAllXe();

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
		giaBan.setCellValueFactory(cellData -> {
			return new SimpleObjectProperty<>(format.format(cellData.getValue().getGiaXe()).toString());
		});
		hangSX.setCellValueFactory(cellData -> 
		new SimpleStringProperty(ncc_BUS.getTenNCCByMa(cellData.getValue().getNcc().getMaNCC())));
		soPhanKhoi.setCellValueFactory(new PropertyValueFactory<Xe, Double>("soPK"));
		nuocSX.setCellValueFactory(new PropertyValueFactory<Xe, String>("nuocSX"));
		soLuongKho.setCellValueFactory(new PropertyValueFactory<Xe, Integer>("soLuongKho"));

		tblXe.getItems().addAll(listXe);


		addCboNuocSX(listXe);
	}

	private void renderHoaDonToTable() throws Exception {
		listHD = hd_BUS.getAllHoaDon();

		for (HoaDon i: listHD) {
			i.getKh().setTenKhachHang(kh_BUS.getHoTenByMa(i.getKh().getMaKhachHang()));
			i.getNv().setTenNhanVien(nv_BUS.getTenByMaNV(i.getNv().getMaNhanVien()));
		}
		//		sttHDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		//		Set STT auto increase
		sttHDCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HoaDon,Integer>, ObservableValue<Integer>>() {

			@Override
			public ObservableValue<Integer> call(CellDataFeatures<HoaDon, Integer> hd) {
				// TODO Auto-generated method stub
				return new ReadOnlyObjectWrapper<>(tblHoaDon.getItems().indexOf(hd.getValue()) + 1);
			}
		});

		maHDCol.setCellValueFactory(new PropertyValueFactory<HoaDon, String>("id"));
		tenNVCol.setCellValueFactory(cellData -> {
			return new SimpleStringProperty(cellData.getValue().getNv().getTenNhanVien());
		});
		tenKHHDCol.setCellValueFactory(cellData -> {
			return new SimpleStringProperty(cellData.getValue().getKh().getTenKhachHang());
		});
		ngayLapHDCol.setCellValueFactory(new PropertyValueFactory<HoaDon, String>("ngayLapHoaDon"));
		tongTienCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(format.format(cellData.getValue().getTongTien() * 1.1)));

		tblHoaDon.getItems().clear();
		tblHoaDon.getItems().addAll(listHD);
	}

	@FXML
	private void timKiemHoaDon() {
		ArrayList<HoaDon> listTimKiem = new ArrayList<>();
		for (HoaDon i: listHD) {
			if (i.getNgayLapHoaDon().compareTo(java.sql.Date.valueOf(startDate.getValue())) >= 0 && 
					i.getNgayLapHoaDon().compareTo(java.sql.Date.valueOf(endDate.getValue())) <= 0 ) {
				listTimKiem.add(i);
			}
		}
		tblHoaDon.getItems().clear();
		tblHoaDon.getItems().addAll(listTimKiem);
	}

	@FXML
	private void xemCTHD() throws Exception {
		HoaDon hd = tblHoaDon.getSelectionModel().getSelectedItem();

		if (hd != null) {
			listCTHD = cthd_BUS.getCTHDByMaHD(hd.getId());
			sttCTHDCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHoaDon,Integer>, ObservableValue<Integer>>() {

				@Override
				public ObservableValue<Integer> call(CellDataFeatures<ChiTietHoaDon, Integer> cthd) {
					// TODO Auto-generated method stub
					return new ReadOnlyObjectWrapper<>(tblCTHD.getItems().indexOf(cthd.getValue()) + 1);
				}
			});
			maCTHDCol.setCellValueFactory(new PropertyValueFactory<ChiTietHoaDon, Integer>("id"));
			maSPCTHD.setCellValueFactory(new PropertyValueFactory<ChiTietHoaDon, String>("maSP"));
			giaSPCTHD.setCellValueFactory(cellData -> new SimpleObjectProperty<>(format.format(cellData.getValue().getGiaBan())));
			soLuongSPCTHD.setCellValueFactory(new PropertyValueFactory<>("soLuongXe"));
			tongTienCTHD.setCellValueFactory(cellData -> new SimpleObjectProperty<>(format.format(cellData.getValue().getGiaBan() * cellData.getValue().getSoLuongXe())));
			tenSPCTHD.setCellValueFactory(cellData -> {
				String ten = xe_BUS.getTenByMa(cellData.getValue().getMaSP());
				if (ten == null) {
					ten = linhKien_BUS.getTenByMa(cellData.getValue().getMaSP());
				}
				return new SimpleStringProperty(ten);
			});


			tblCTHD.getItems().clear();
			tblCTHD.getItems().addAll(listCTHD);
		}
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

		sttKHCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<KhachHang,Integer>, ObservableValue<Integer>>() {

			@Override
			public ObservableValue<Integer> call(CellDataFeatures<KhachHang, Integer> kh) {
				// TODO Auto-generated method stub
				return new ReadOnlyObjectWrapper<>(tblKhachHang.getItems().indexOf(kh.getValue()) + 1);
			}
		});
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

	@FXML
	private void handleTimLK() throws Exception {
		tblLinhKien.getItems().clear();
		tblLinhKien.getItems().addAll(linhKien_BUS.findLinhKien(txtTimLK.getText().trim()));
	}

	private void addLinhKienToTable() throws Exception {
		listLinhKien = linhKien_BUS.getAllLinhKien();

		sttLinhKienCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LinhKien,Integer>, ObservableValue<Integer>>() {

			@Override
			public ObservableValue<Integer> call(CellDataFeatures<LinhKien, Integer> lk) {
				// TODO Auto-generated method stub
				return new ReadOnlyObjectWrapper<>(tblLinhKien.getItems().indexOf(lk.getValue()) + 1);
			}
		});
		maLKCol.setCellValueFactory(new PropertyValueFactory<LinhKien, String>("id"));
		tenLKCol.setCellValueFactory(new PropertyValueFactory<LinhKien, String>("ten"));
		giaLKCol.setCellValueFactory(cellData -> {
			return new SimpleObjectProperty<>(format.format(cellData.getValue().getGiaLinhKien()));
		});
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
		} catch (Exception e) {
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
	private void handleclickTabTK() throws Exception{
		renderDatatotbltxe();
		
	}

	public void btndt(ActionEvent e) throws Exception {

		listLinhKien = linhKien_BUS.getAllLinhKien();
		listXe = xe_BUS.getAllXe();
		int slban=0;
		int slkho=0;
		double dt=0.0;
		for(LinhKien lk:listLinhKien) {
			slban+=lk.getSoLuongBan();
			slkho+=lk.getSoLuongKho();
			dt+=(lk.getGiaLinhKien()*lk.getSoLuongBan());
		}
		for(Xe xe:listXe) {
			slban+=xe.getSoLuongBan();
			slkho+=xe.getSoLuongKho();
			dt+=(xe.getSoLuongBan()*xe.getGiaXe());
		}
		txtslban.setText(slban+"");
		txtslkho.setText(slkho+"");
		txtdt.setText(format.format(dt)+"");

	}
	public void btnthuchi(ActionEvent e) throws Exception {

		listLinhKien = linhKien_BUS.getAllLinhKien();
		listXe = xe_BUS.getAllXe();
		double tl=0.0;
		double chi=0.0;
		double dt=0.0;
		for(LinhKien lk:listLinhKien) {

			dt+=(lk.getGiaLinhKien()*lk.getSoLuongBan());
		}
		for(Xe xe:listXe) {

			dt+=(xe.getSoLuongBan()*xe.getGiaXe());
		}
		chi=dt*0.3;
		tl=((dt*1.0)/(chi*1.0));
		txtthu.setText(format.format(dt)+"");

		txtchi.setText(format.format(chi)+"");
		txttl.setText(tl+"");

	}


	private void renderDatatotbltxe() throws Exception {
		listLinhKien = linhKien_BUS.getAllLinhKien();
		listXe = xe_BUS.getAllXe();
		masptk.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new SimpleStringProperty(((Xe) obj).getMaXe());
			}
			else return new SimpleStringProperty(((LinhKien) obj).getId());
		});

		tensptk.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new SimpleStringProperty(((Xe) obj).getTenXe());
			}
			else return new SimpleStringProperty(((LinhKien) obj).getTen());
		});

		slkhotk.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new ReadOnlyObjectWrapper<>(((Xe)cellData.getValue()).getSoLuongKho());
			}
			else return new ReadOnlyObjectWrapper<>(((LinhKien)cellData.getValue()).getSoLuongKho());
		});
		slbantk.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new ReadOnlyObjectWrapper<>(((Xe)cellData.getValue()).getSoLuongBan());
			}
			else return new ReadOnlyObjectWrapper<>(((LinhKien)cellData.getValue()).getSoLuongBan());
		});

		giasptk.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new ReadOnlyObjectWrapper<>(format.format(((Xe) obj).getGiaXe()));
			}
			else return new ReadOnlyObjectWrapper<>(format.format(((LinhKien) obj).getGiaLinhKien()));
		});
		dtsptk.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) {
				return new ReadOnlyObjectWrapper<>(format.format(((Xe) obj).getGiaXe()*((Xe) obj).getSoLuongBan()));
			}
			else return new ReadOnlyObjectWrapper<>(format.format(((LinhKien) obj).getGiaLinhKien()*((LinhKien) obj).getSoLuongBan()));
		});
		tbltk.getItems().clear();
		tbltk.getItems().addAll(listXe);
		tbltk.getItems().addAll(listLinhKien);

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
		int index = tblCart.getSelectionModel().getSelectedIndex();
		Object obj = tblCart.getItems().get(index);
		for (Object i: tblProduct.getItems()) {
			if (obj instanceof Xe) {
				if (i instanceof Xe) {
					Xe xe = (Xe) i;
					Xe xeDel = (Xe) obj;
					if (((Xe) i).getMaXe().equals(((Xe) obj).getMaXe())) {
						xe.setSoLuongKho(xe.getSoLuongKho() + xeDel.getSoLuongKho());
					}
				}
			}
			else {
				if (i instanceof LinhKien) {
					LinhKien lk = (LinhKien) i;
					LinhKien lkDel = (LinhKien) obj;
					if (lk.getId().equals(lkDel.getId())) {
						lk.setSoLuongKho(lk.getSoLuongKho() + lkDel.getSoLuongKho());
					}
				}
			}
		}
		tblCart.getItems().remove(index);
		tblProduct.refresh();
	}

	@FXML 
	private void handleChonKH() {
		BorderPane root;
		try {
			//			root = (BorderPane)FXMLLoader.load(getClass().getResource("FrmDienThongTinKH.fxml"));
			FXMLLoader fxml = new FXMLLoader(getClass().getResource("FrmLayKHTuList.fxml"));
			root = (BorderPane) fxml.load();
			ctrl_LayKH = fxml.getController();
			Scene scene = new Scene(root);
			Stage modalStage = new Stage();
			modalStage.setScene(scene);
			modalStage.show();
			//	        modalStage.initModality(Modality.APPLICATION_MODAL);
			//	        modalStage.initOwner(btnThemKH.getScene().getWindow());
			//	        modalStage.setScene(scene);
			//	        modalStage.showAndWait();
			ctrl_LayKH.setTextFieldLoad(khCart);
			//			khHoaDon = new KhachHang();
			ctrl_LayKH.setKhachHang(khHoaDon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void handleTimKiemKH() {
		ArrayList<KhachHang> listTimKiem;
		listTimKiem = kh_BUS.findCustomers(txtTimKH.getText().trim());
		tblKhachHang.getItems().clear();
		tblKhachHang.getItems().addAll(listTimKiem);
	}

	@FXML
	private void handleCloseModal() {
		productModal.setVisible(false);
	}

	private void renderDataToProductTbl() throws Exception {
		listLinhKien = linhKien_BUS.getAllLinhKien();
		listXe = xe_BUS.getAllXe();

		sttProductCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Object,Integer>, ObservableValue<Integer>>() {

			@Override
			public ObservableValue<Integer> call(CellDataFeatures<Object, Integer> obj) {
				// TODO Auto-generated method stub
				return new ReadOnlyObjectWrapper<>(tblProduct.getItems().indexOf(obj.getValue()) + 1);
			}
		});

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
				return new SimpleObjectProperty<>(format.format(((Xe) obj).getGiaXe()));
			}
			else return new SimpleObjectProperty<>(format.format(((LinhKien) obj).getGiaLinhKien()));
		});

		tblProduct.getItems().clear();
		tblProduct.getItems().addAll(listXe);
		tblProduct.getItems().addAll(listLinhKien);

	}

	@FXML
	private void handleAddToCart() throws Exception {
		double tongTien = 0;
		listXeCart = xe_BUS.getAllXe();
		listLinhKienCart = linhKien_BUS.getAllLinhKien();
		int quantity = Integer.parseInt(txtQuantity.getText());
		Object productSelected = tblProduct.getSelectionModel().getSelectedItem();
		int quantityKho;

		sttCartCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Object,Integer>, ObservableValue<Integer>>() {

			@Override
			public ObservableValue<Integer> call(CellDataFeatures<Object, Integer> obj) {
				// TODO Auto-generated method stub
				return new ReadOnlyObjectWrapper<>(tblCart.getItems().indexOf(obj.getValue()) + 1);
			}
		});

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
				return new SimpleObjectProperty<>(format.format(((Xe) obj).getGiaXe()));
			}
			else return new SimpleObjectProperty<>(format.format(((LinhKien) obj).getGiaLinhKien()));
		});
		thanhTienCol.setCellValueFactory(cellData -> {
			Object obj = cellData.getValue();
			if (obj instanceof Xe) return new SimpleObjectProperty<>(format.format(((Xe) obj).getGiaXe() * ((Xe) obj).getSoLuongKho()));
			else return new SimpleObjectProperty<>(format.format(((LinhKien) obj).getGiaLinhKien() * ((LinhKien) obj).getSoLuongKho()));
		});

		if (productSelected instanceof Xe) {
			quantityKho = ((Xe) productSelected).getSoLuongKho();
		} else quantityKho = ((LinhKien) productSelected).getSoLuongKho();
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
			txtQuantity.setText("");
			tblProduct.refresh();
			tblCart.refresh();

			//			Tinh Tong Tien
			for (Object i: tblCart.getItems()) {
				if (i instanceof Xe) {
					Xe x = (Xe) i;
					tongTien += x.getGiaXe() * x.getSoLuongKho();
				}
				else {
					LinhKien lk = (LinhKien) i;
					tongTien += lk.getGiaLinhKien() * lk.getSoLuongKho();
				}
			}
			//			Tính thuế VAT 10%
			txtTongTien.setText(format.format(tongTien * 1.1));
		}

	}

	@FXML
	private void handleClickThanhToan() throws Exception {
		//		khHoaDon = new KhachHang();
		if (tblCart.getItems().size() == 0) {
			PopupNotify.showErrorField("Chọn sản phẩm", "Giỏ hàng trống", "Vui lòng thêm sản phẩm vào giỏ hàng");
		}
		if (ctrl_LayKH != null) {
			khHoaDon = ctrl_LayKH.getKhachHang();
			for (Object obj: tblProduct.getItems()) {
				if (obj instanceof Xe) {
					Xe xe = (Xe) obj;
					xe_BUS.updateSoLuongKho(xe.getSoLuongKho(), xe.getMaXe());
				}
				else {
					LinhKien lk = (LinhKien) obj;
					linhKien_BUS.updateSLKho(lk.getSoLuongKho(), lk.getId());
				}
			}
			for (Object obj: tblCart.getItems()) {
				if (obj instanceof Xe) {
					Xe xe = (Xe) obj;
					xe_BUS.updateSoLuongBan(xe.getSoLuongKho(), xe.getMaXe());
				}
				else {
					LinhKien lk = (LinhKien) obj;
					linhKien_BUS.updateSLBan(lk.getSoLuongKho(), lk.getId());
				}
			}
			//			*******
			double tongTien = 0;
			for (Object i: tblCart.getItems()) {
				if (i instanceof Xe)  {
					tongTien += ((Xe) i).getGiaXe() * ((Xe) i).getSoLuongKho();
				}
				else  {
					tongTien += ((LinhKien) i).getGiaLinhKien() * ((LinhKien) i).getSoLuongKho();
				}
			}
			NhanVien nv = nv_BUS.getAllEmployees().get(0);
			HoaDon hd = new HoaDon(GenerateID.taoMaHD(), java.sql.Date.valueOf(LocalDate.now()), khHoaDon, nv, tongTien);
			HoaDon_BUS hd_BUS = new HoaDon_BUS();
			hd_BUS.taoHoaDon(hd);

			for (Object i: tblCart.getItems()) {
				ChiTietHoaDon cthd;
				if (i instanceof Xe) {
					Xe xe = (Xe) i;
					cthd = new ChiTietHoaDon(GenerateID.taoMaCTHD(), xe.getSoLuongKho(), xe.getGiaXe(), xe.getMaXe(), hd);
				}
				else {
					LinhKien lk = (LinhKien) i;
					cthd = new ChiTietHoaDon(GenerateID.taoMaCTHD(), lk.getSoLuongKho(), lk.getGiaLinhKien(),lk.getId(), hd);
				}
				cthd_BUS.taoChiTietHoaDon(cthd);
			}
			renderDataToProductTbl();
			PopupNotify.successNotify("Thanh toán thành công", "Thanh toán thành công", "Chúc mừng bạn đã thanh toán thành công");
			tblCart.getItems().clear();
		}
		else if (khHoaDon == null) PopupNotify.showErrorField("Chọn khách hàng", "Khách hàng chưa được chọn", "Vui lòng chọn khách hàng thanh toán");
		else PopupNotify.showErrorField("Chọn khách hàng", "Khách hàng chưa được chọn", "Vui lòng chọn khách hàng thanh toán");


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

	public Ctrl_NhanVienGUI() {
		super();
	}
}