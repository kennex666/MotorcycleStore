CREATE DATABASE [QuanLyCuaHangXe];
GO

USE [QuanLyCuaHangXe]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaCTHD] [nvarchar](255) NOT NULL,
	[MaHD] [nvarchar](255) NOT NULL,
	[MaSP] [nvarchar](255) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaBan] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSuaCHua]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSuaCHua](
	[MaCTSuaChua] [int] IDENTITY(1,1) NOT NULL,
	[MaPhieuSuaChua] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTSuaChua] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[MaCV] [int] IDENTITY(1,1) NOT NULL,
	[TenCV] [nvarchar](50) NULL,
 CONSTRAINT [PK__ChucVu__27258E76A841EA9C] PRIMARY KEY CLUSTERED 
(
	[MaCV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DaiLy]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DaiLy](
	[MaDaiLy] [nvarchar](50) NOT NULL,
	[TenDaiLy] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK__DaiLy__069B00B3D4558644] PRIMARY KEY CLUSTERED 
(
	[MaDaiLy] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [nvarchar](255) NOT NULL,
	[MaKH] [nvarchar](255) NOT NULL,
	[MaNV] [nvarchar](255) NOT NULL,
	[NgayLapHoaDon] [datetime] NULL,
	[TongTien] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](255) NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [nvarchar](255) NULL,
	[SoCCCD] [nvarchar](255) NULL,
	[GioiTinh] [bit] NOT NULL,
	[NgaySinh] [datetime] NULL,
	[Email] [nvarchar](255) NULL,
 CONSTRAINT [PK__KhachHan__2725CF1E8E6917E4] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LinhKien]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LinhKien](
	[MaLinhKien] [nvarchar](255) NOT NULL,
	[MaNCC] [nvarchar](255) NOT NULL,
	[MaCTSuaChua] [int] NULL,
	[TenLinhKien] [nvarchar](50) NULL,
	[ImgPath] [nvarchar](255) NULL,
	[GiaBan] [real] NOT NULL,
	[SoLuongKho] [int] NULL,
	[SoLuongBan] [int] NULL,
 CONSTRAINT [PK__LinhKien__05E780BF9F856762] PRIMARY KEY CLUSTERED 
(
	[MaLinhKien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [nvarchar](255) NOT NULL,
	[Ten] [nvarchar](50) NULL,
 CONSTRAINT [PK__NhaCungC__3A185DEB1A93DBCC] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](255) NOT NULL,
	[MaPB] [int] NOT NULL,
	[MaCV] [int] NOT NULL,
	[HoTenNV] [nvarchar](50) NULL,
	[NgaySinh] [datetime] NULL,
	[SDT] [nvarchar](255) NULL,
	[SoCCCD] [nvarchar](255) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Email] [nvarchar](255) NULL,
	[GioiTinh] [bit] NOT NULL,
	[TrinhDoHocVan] [nvarchar](50) NULL,
	[BacTho] [nvarchar](50) NULL,
 CONSTRAINT [PK__NhanVien__2725D70AC60AD25D] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuSuaChua]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuSuaChua](
	[MaPhieuSuaChua] [int] IDENTITY(1,1) NOT NULL,
	[NhanXet] [nvarchar](255) NULL,
	[GiaTien] [real] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuSuaChua] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuTiepNhan]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuTiepNhan](
	[MaPhieuTiepNhan] [nvarchar](255) NOT NULL,
	[XeMaXe] [nvarchar](255) NOT NULL,
	[MaPhieuSuaChua] [int] NOT NULL,
	[MaNV] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuTiepNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongBan]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongBan](
	[MaPB] [int] IDENTITY(1,1) NOT NULL,
	[MaDaiLy] [nvarchar](50) NOT NULL,
	[TenPB] [nvarchar](50) NULL,
 CONSTRAINT [PK__PhongBan__2725E7E404961710] PRIMARY KEY CLUSTERED 
(
	[MaPB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Xe]    Script Date: 5/4/2023 3:04:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Xe](
	[MaXe] [nvarchar](255) NOT NULL,
	[MaNCC] [nvarchar](255) NOT NULL,
	[TenXe] [nvarchar](50) NULL,
	[LoaiXe] [nvarchar](50) NULL,
	[NuocSX] [nvarchar](50) NULL,
	[SoPK] [real] NOT NULL,
	[SoKhung] [nvarchar](255) NULL,
	[SoSuon] [nvarchar](255) NULL,
	[MauXe] [nvarchar](255) NULL,
	[Gia] [real] NOT NULL,
	[ImgPath] [nvarchar](255) NULL,
	[NgayNhap] [datetime] NULL,
	[SoLuongKho] [int] NULL,
	[SoLuongBan] [int] NULL,
 CONSTRAINT [PK__Xe__272520CDE0D01F22] PRIMARY KEY CLUSTERED 
(
	[MaXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FKChiTietHoa453357] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FKChiTietHoa453357]
GO
ALTER TABLE [dbo].[ChiTietSuaCHua]  WITH CHECK ADD  CONSTRAINT [FKChiTietSua507954] FOREIGN KEY([MaPhieuSuaChua])
REFERENCES [dbo].[PhieuSuaChua] ([MaPhieuSuaChua])
GO
ALTER TABLE [dbo].[ChiTietSuaCHua] CHECK CONSTRAINT [FKChiTietSua507954]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FKHoaDon185048] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FKHoaDon185048]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FKHoaDon785667] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FKHoaDon785667]
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD  CONSTRAINT [FKLinhKien546903] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[LinhKien] CHECK CONSTRAINT [FKLinhKien546903]
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD  CONSTRAINT [FKLinhKien980768] FOREIGN KEY([MaCTSuaChua])
REFERENCES [dbo].[ChiTietSuaCHua] ([MaCTSuaChua])
GO
ALTER TABLE [dbo].[LinhKien] CHECK CONSTRAINT [FKLinhKien980768]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FKNhanVien198658] FOREIGN KEY([MaCV])
REFERENCES [dbo].[ChucVu] ([MaCV])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FKNhanVien198658]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FKNhanVien20148] FOREIGN KEY([MaPB])
REFERENCES [dbo].[PhongBan] ([MaPB])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FKNhanVien20148]
GO
ALTER TABLE [dbo].[PhieuTiepNhan]  WITH CHECK ADD  CONSTRAINT [FKPhieuTiepN164359] FOREIGN KEY([MaPhieuSuaChua])
REFERENCES [dbo].[PhieuSuaChua] ([MaPhieuSuaChua])
GO
ALTER TABLE [dbo].[PhieuTiepNhan] CHECK CONSTRAINT [FKPhieuTiepN164359]
GO
ALTER TABLE [dbo].[PhieuTiepNhan]  WITH CHECK ADD  CONSTRAINT [FKPhieuTiepN189441] FOREIGN KEY([XeMaXe])
REFERENCES [dbo].[Xe] ([MaXe])
GO
ALTER TABLE [dbo].[PhieuTiepNhan] CHECK CONSTRAINT [FKPhieuTiepN189441]
GO
ALTER TABLE [dbo].[PhieuTiepNhan]  WITH CHECK ADD  CONSTRAINT [FKPhieuTiepN770440] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuTiepNhan] CHECK CONSTRAINT [FKPhieuTiepN770440]
GO
ALTER TABLE [dbo].[PhongBan]  WITH CHECK ADD  CONSTRAINT [FKPhongBan355080] FOREIGN KEY([MaDaiLy])
REFERENCES [dbo].[DaiLy] ([MaDaiLy])
GO
ALTER TABLE [dbo].[PhongBan] CHECK CONSTRAINT [FKPhongBan355080]
GO
ALTER TABLE [dbo].[Xe]  WITH CHECK ADD  CONSTRAINT [FKXe118015] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[Xe] CHECK CONSTRAINT [FKXe118015]
GO





DELETE FROM [dbo].[KhachHang]
GO
DELETE FROM [dbo].[NhanVien]
GO
DELETE FROM [dbo].[PhongBan]
GO
DELETE FROM [dbo].[DaiLy]
GO
DELETE FROM [dbo].[ChucVu]
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([MaCV], [TenCV]) VALUES (1, N'Nhân viên quản Lý')
INSERT [dbo].[ChucVu] ([MaCV], [TenCV]) VALUES (2, N'Nhân viên bán hàng')
INSERT [dbo].[ChucVu] ([MaCV], [TenCV]) VALUES (3, N'Nhân viên kĩ thuật')
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
INSERT [dbo].[DaiLy] ([MaDaiLy], [TenDaiLy], [DiaChi]) VALUES (N'2', N'Đại lí 9', N'12 Nguyễn Văn Bảo, Gò Vấp, tp Hồ Chí Minh')
GO
SET IDENTITY_INSERT [dbo].[PhongBan] ON 

INSERT [dbo].[PhongBan] ([MaPB], [MaDaiLy], [TenPB]) VALUES (5, N'2', N'Phòng Kinh Doanh')
INSERT [dbo].[PhongBan] ([MaPB], [MaDaiLy], [TenPB]) VALUES (6, N'2', N'Phòng Kĩ Thuật')
INSERT [dbo].[PhongBan] ([MaPB], [MaDaiLy], [TenPB]) VALUES (7, N'2', N'Phòng Nhân Sự')
SET IDENTITY_INSERT [dbo].[PhongBan] OFF
GO
INSERT [dbo].[NhanVien] ([MaNV], [MaPB], [MaCV], [HoTenNV], [NgaySinh], [SDT], [SoCCCD], [DiaChi], [Email], [GioiTinh], [TrinhDoHocVan], [BacTho]) VALUES (N'BH-002-0002', 5, 2, N'Võ Ngọc Thắng', CAST(N'2003-12-19T00:00:00.000' AS DateTime), N'0862918261', N'102093826', N'Tp Hồ Chí Minh', N'thangdevweb@github.com', 1, N'Đại học', N'')
INSERT [dbo].[NhanVien] ([MaNV], [MaPB], [MaCV], [HoTenNV], [NgaySinh], [SDT], [SoCCCD], [DiaChi], [Email], [GioiTinh], [TrinhDoHocVan], [BacTho]) VALUES (N'KT-002-0003', 5, 3, N'Trần Trọng Nhân', CAST(N'2003-07-17T00:00:00.000' AS DateTime), N'0972519251', N'109261091', N'Tỉnh Tiền Giang', N'trantrongnhan11@gmail.com', 1, N'Đại học', N'4')
INSERT [dbo].[NhanVien] ([MaNV], [MaPB], [MaCV], [HoTenNV], [NgaySinh], [SDT], [SoCCCD], [DiaChi], [Email], [GioiTinh], [TrinhDoHocVan], [BacTho]) VALUES (N'KT-002-0004', 5, 2, N'Dương Văn Phấn', CAST(N'2003-01-01T00:00:00.000' AS DateTime), N'0926172611', N'070203009011', N'Nguyễn Văn Bảo, tp Hồ Chí Minh', N'phandz@gmail.com', 1, N'Đại học', N'')
INSERT [dbo].[NhanVien] ([MaNV], [MaPB], [MaCV], [HoTenNV], [NgaySinh], [SDT], [SoCCCD], [DiaChi], [Email], [GioiTinh], [TrinhDoHocVan], [BacTho]) VALUES (N'QL-002-0001', 5, 2, N'Dương Thái Bảo', CAST(N'2003-12-19T00:00:00.000' AS DateTime), N'0869510030', N'010203008712', N'Bù Đốp, tỉnh Bình Phước', N'bao@1boxstudios.com', 1, N'Đại học', N'')
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0001', N'Dương Thái Bảo', N'Huyện Bù Đốp, tỉnh Bình Phước', N'0869510030', N'285000129', 1, CAST(N'2003-12-19T00:00:00.000' AS DateTime), N'bao@1boxstudios.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0002', N'Trần Trọng Nhân', N'Thị xã Cai Lạy, tỉnh Tiền Giang', N'0943899717', N'273009811', 1, CAST(N'2003-07-17T00:00:00.000' AS DateTime), N'trantrongnhan11@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0003', N'Dương Văn Phấn', N'Gò Vấp, tp Hồ Chí Minh', N'0972600871', N'026726812', 1, CAST(N'2003-01-01T00:00:00.000' AS DateTime), N'phandz@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0004', N'Võ Ngọc Thắng', N'Gò Vấp, tp Hồ Chí Minh', N'0897219211', N'817037182', 1, CAST(N'2003-01-01T00:00:00.000' AS DateTime), N'thangdevweb@github.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0005', N'Võ Hoàng Anh', N'Thị xã Đồng Xoài, Bình Phước', N'0986281621', N'926192124', 1, CAST(N'2000-02-09T00:00:00.000' AS DateTime), N'vohoanganh@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0006', N'Phạm Văn Phú', N'Thanh Hoà, tỉnh Bình Phước', N'0862917211', N'972081284', 1, CAST(N'2003-11-25T00:00:00.000' AS DateTime), N'phamvanphu@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0007', N'Trần Thị Yến Nhi', N'Số 14, Nguyễn Văn Công, Thành phố Hồ Chí Minh', N'0899628461', N'926940172', 0, CAST(N'1999-03-09T00:00:00.000' AS DateTime), N'tranyennhi@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0008', N'Võ Trần Quốc Bảo', N'Tỉnh Bình Định', N'0879391621', N'010204007629', 1, CAST(N'2004-08-10T00:00:00.000' AS DateTime), N'quocbao@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0009', N'Phạm Thị Lan Anh', N'Quận 1, tp Hồ Chí Minh', N'0376863999', N'891736281', 0, CAST(N'2002-05-20T00:00:00.000' AS DateTime), N'lananh.depgai@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0010', N'Nguyễn Thị Kim Hoa', N'127 Nguyễn Văn Bảo, Gò Vấp, tp Hồ Chí Minh', N'0728666891', N'209236863', 0, CAST(N'2003-11-24T00:00:00.000' AS DateTime), N'kimhoa.xinh@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0011', N'Nguyễn Ngọc Ánh', N'Tỉnh Bình Dương', N'0987618291', N'182936988', 0, CAST(N'1987-10-29T00:00:00.000' AS DateTime), N'nguyenanh@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0012', N'Trần Anh Anh', N'Tp Hồ Chí Minh', N'0987192611', N'827087382', 0, CAST(N'1995-02-09T00:00:00.000' AS DateTime), N'anhanhtran@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0013', N'Quốc Toản', N'Tỉnh Tiền Giang', N'0987261921', N'072972001', 1, CAST(N'2001-08-29T00:00:00.000' AS DateTime), N'toandz@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0014', N'Đỗ Huy Khang', N'Tỉnh Bình Dương', N'0966172228', N'192030309', 1, CAST(N'1994-02-05T00:00:00.000' AS DateTime), N'gayafso2khumaisomot@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0015', N'Vũ Văn Hùng', N'Thanh Hoà, tỉnh Bình Phước', N'0987187877', N'092819281', 1, CAST(N'2004-09-23T00:00:00.000' AS DateTime), N'vuvanhung23@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0016', N'Mai Hồng Hạnh', N'923 Nguyễn Kiệm, tp Hồ Chí Minh', N'0927999523', N'024917201', 0, CAST(N'2001-09-25T00:00:00.000' AS DateTime), N'hanh.xinh.hong@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0017', N'Nguyễn Thu Hà', N'Tỉnh Bình Phước', N'0926391620', N'098729192', 0, CAST(N'1994-05-04T00:00:00.000' AS DateTime), N'hadepgai@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0018', N'Nguyễn Quốc Nam', N'Ấp 10, tỉnh Gia Lai', N'0917972836', N'092638991', 1, CAST(N'1992-02-09T00:00:00.000' AS DateTime), N'quocnam@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0019', N'Trần Kiến Thức', N'120 Nguyễn Thái Sơn, Gò Vấp, tp Hồ Chí Minh', N'0972937777', N'129263927', 1, CAST(N'1992-11-02T00:00:00.000' AS DateTime), N'thuc@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0020', N'Nguyễn Thị Nguyệt', N'Tỉnh Gia Lai', N'0817291711', N'108929373', 0, CAST(N'1997-09-12T00:00:00.000' AS DateTime), N'nguyet1997@gmail.com')
GO
DELETE FROM [dbo].[Xe]
GO
DELETE FROM [dbo].[LinhKien]
GO
DELETE FROM [dbo].[NhaCungCap]
GO
DELETE FROM [dbo].[ChiTietHoaDon]
GO
DELETE FROM [dbo].[HoaDon]
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505041324859', N'KH-002-0004', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 6.05E+07)
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505042157075', N'KH-002-0001', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 3.202E+08)
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505042205769', N'KH-002-0008', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 5.6E+08)
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505042542443', N'KH-002-0003', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 3.2E+07)
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505042822929', N'KH-002-0015', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 400000)
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505041324914', N'HD20230505041324859', N'Vinfast05042023H7BR', 1, 2E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505041324918', N'HD20230505041324859', N'Yamaha050020238R48', 1, 4E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505041324919', N'HD20230505041324859', N'LK20230505040758299', 1, 500000)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042157097', N'HD20230505042157075', N'Vinfast05022023DP8E', 20, 1.6E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042157100', N'HD20230505042157075', N'LK20230505040447240', 1, 200000)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042205772', N'HD20230505042205769', N'Yamaha050020238R48', 14, 4E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042542460', N'HD20230505042542443', N'Vinfast05022023DP8E', 2, 1.6E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042822951', N'HD20230505042822929', N'LK20230505040447240', 2, 200000)
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [Ten]) VALUES (N'NCC1', N'Honda')
INSERT [dbo].[NhaCungCap] ([MaNCC], [Ten]) VALUES (N'NCC2', N'Yamaha')
INSERT [dbo].[NhaCungCap] ([MaNCC], [Ten]) VALUES (N'NCC3', N'Vinfast')
GO
INSERT [dbo].[LinhKien] ([MaLinhKien], [MaNCC], [MaCTSuaChua], [TenLinhKien], [ImgPath], [GiaBan], [SoLuongKho], [SoLuongBan]) VALUES (N'LK20230505040447240', N'NCC1', NULL, N'Bugi Xe Máy', N'"path"', 200000, 17, 2)
INSERT [dbo].[LinhKien] ([MaLinhKien], [MaNCC], [MaCTSuaChua], [TenLinhKien], [ImgPath], [GiaBan], [SoLuongKho], [SoLuongBan]) VALUES (N'LK20230505040758299', N'NCC1', NULL, N'Côn Xe Máy', N'"path"', 500000, 9, 1)
GO
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Honda05492023FOQ2', N'NCC1', N'Air Blade', N'Xe Ga', N'Hàn Quốc', 160, N'ME4KF197KK8000001', N'RLHKE081KT010000 đến RLHKE081KT010999', N'Đen', 3E+07, N'"path"', 40, 0)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Honda0555202374L6', N'NCC1', N'Sirius', N'Xe Số', N'Nhật Bản', 100, N'ME4KF257ML8000001 ', N' RLHKE091LK100000', N'Đen', 1.5E+07, N'"path"', 20, 0)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Vinfast05022023DP8E', N'NCC3', N'VinFast Evo200', N'Xe Máy Điện', N'Việt Nam', 120, N'ME4KF151JJ8000001 ', N'RLHKE141MS806999', N'Trắng', 1.6E+07, N'"path"', 28, 2)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Vinfast05042023H7BR', N'NCC3', N'Theon S', N'Xe Máy Điện', N'Việt Nam', 100, N'ME4KF151JJ8005000', N'RLHKE071JJ800000 ', N'Đen', 2E+07, N'"path"', 19, 1)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Yamaha050020238R48', N'NCC2', N'Exciter', N'Xe Số', N'Nhật Bản', 160, N'ME4KF151HH8010000', N'RLHKE071HH810999', N'Xanh Lam', 4E+07, N'"path"', 45, 14)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Yamaha050120237SES', N'NCC2', N'Winer', N'Xe Số', N'Hàn Quốc', 180, N'ME4KF197KK8002000', N'RLHKE071HH800000 ', N'Đen', 4.5E+07, N'"path"', 50, 0)
GO
