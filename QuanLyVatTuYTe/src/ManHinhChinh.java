import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Class.NGUOIDUNG;
import HeThong.ChinhSuaNguoiDung;
import HeThong.DanhSachNguoiDung;
import HeThong.ThayDoiMatKhau;
import HeThong.ThemMoiNguoiDung;
import HeThong.ThongTinNguoiDung;
import TroGiup.ThongTinSanPham;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class ManHinhChinh extends JFrame implements MenuListener, ActionListener{

	private JPanel contentPane;
	JMenu menuGiaoDich, menuQuanLy,menuBaoCao,menuHeThong,menuTroGiup;
	JMenuBar menuBar;
	JMenuItem itemThayDoiMatKhau,itemThongTinNguoiDung,itemChinhSuaNguoiDung,itemThemMoiNguoiDung,itemDanhSachNguoiDung;
	private JMenuItem itemQuanLyNhanVien, itemQuanLyVatTu, itemQuanLyNhaCungCap,itemBaoCaoNhap,itemBaoCaoXuat,itemBaoCaoThuChi,itemHuongDan,itemThongTinSanPham;
	NGUOIDUNG user;
	JPanel mainPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				//thay đổi user sau khi đăng nhập thành công vào đây
					
					ManHinhChinh frame = new ManHinhChinh(new NGUOIDUNG("truongcongpha", "06082301", "Admin"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManHinhChinh(NGUOIDUNG user) {
		this.user = user; 
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhChinh.class.getResource("/images/medical.png")));
		setTitle("QUẢN LÝ VẬT TƯ Y TẾ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 884, 32);
			contentPane.add(menuBar);
		
		menuGiaoDich = new JMenu("Giao dịch");
			menuGiaoDich.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/buy.png")));
			// thêm sự kiện khi click menu Giao dịch của Tiến váo đây
			menuGiaoDich.addMenuListener(this);
			menuBar.add(menuGiaoDich);
		
		menuQuanLy = new JMenu("Danh mục quản lý");
			menuQuanLy.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/manager (2).png")));
			menuBar.add(menuQuanLy);
			
			itemQuanLyVatTu = new JMenuItem("Quản lý vật tư");
				itemQuanLyVatTu.addActionListener(this);
				itemQuanLyVatTu.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/pill.png")));
				menuQuanLy.add(itemQuanLyVatTu);
			
			itemQuanLyNhaCungCap = new JMenuItem("Quản lý nhà cung cấp");
				itemQuanLyNhaCungCap.addActionListener(this);
				itemQuanLyNhaCungCap.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/suppliers.png")));
				menuQuanLy.add(itemQuanLyNhaCungCap);
			
			itemQuanLyNhanVien = new JMenuItem("Quản lý nhân viên");
				itemQuanLyNhanVien.addActionListener(this);
				itemQuanLyNhanVien.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/employee.png")));
				menuQuanLy.add(itemQuanLyNhanVien);
		
		menuBaoCao = new JMenu("Báo cáo");
			menuBaoCao.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/report.png")));
			menuBar.add(menuBaoCao);
			
			itemBaoCaoNhap = new JMenuItem("Báo cáo hàng hóa nhập");
				itemBaoCaoNhap.addActionListener(this);
				itemBaoCaoNhap.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/reportImport.png")));
				menuBaoCao.add(itemBaoCaoNhap);
			
			itemBaoCaoXuat = new JMenuItem("Báo cáo hàng hóa xuất");
				itemBaoCaoXuat.addActionListener(this);
				itemBaoCaoXuat.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/reportExport.png")));
				menuBaoCao.add(itemBaoCaoXuat);
			
			itemBaoCaoThuChi = new JMenuItem("Báo cáo thu chi");
				itemBaoCaoThuChi.addActionListener(this);
				itemBaoCaoThuChi.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/thuchi.png")));
				menuBaoCao.add(itemBaoCaoThuChi);
		
		menuHeThong = new JMenu("Hệ thống");
			menuHeThong.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/1441360247_Settings.png")));
			menuBar.add(menuHeThong);
		
			itemThayDoiMatKhau = new JMenuItem("Thay đổi mật khẩu");
				itemThayDoiMatKhau.addActionListener(this);
				itemThayDoiMatKhau.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/changepass.png")));
				menuHeThong.add(itemThayDoiMatKhau);
		
			itemThongTinNguoiDung= new JMenuItem("Thông tin người dùng");
				itemThongTinNguoiDung.addActionListener(this);
				itemThongTinNguoiDung.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/userinfo.png")));
				menuHeThong.add(itemThongTinNguoiDung);
		
			itemChinhSuaNguoiDung = new JMenuItem("Chỉnh sửa người dùng");
				itemChinhSuaNguoiDung.addActionListener(this);
				itemChinhSuaNguoiDung.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/edituser.png")));
				menuHeThong.add(itemChinhSuaNguoiDung);
		
			itemThemMoiNguoiDung= new JMenuItem("Thêm mới người dùng");
				itemThemMoiNguoiDung.addActionListener(this);
				itemThemMoiNguoiDung.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/adduser.png")));
				menuHeThong.add(itemThemMoiNguoiDung);
		
			itemDanhSachNguoiDung = new JMenuItem("Danh sách người dùng");
				itemDanhSachNguoiDung.addActionListener(this);
				itemDanhSachNguoiDung.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/listUser.png")));
				menuHeThong.add(itemDanhSachNguoiDung);
		
		menuTroGiup = new JMenu("Trợ giúp");
			menuTroGiup.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/help (1).png")));
			menuBar.add(menuTroGiup);
			
			itemHuongDan = new JMenuItem("Hướng dẫn");
				itemHuongDan.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/helpicon.png")));
				menuTroGiup.add(itemHuongDan);
			
			itemThongTinSanPham = new JMenuItem("Thông tin sản phẩm");
				itemThongTinSanPham.addActionListener(this);
				itemThongTinSanPham.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/images/information (1).png")));
				menuTroGiup.add(itemThongTinSanPham);
				
	mainPane = new JPanel();
				mainPane.setBounds(0, 43, 884, 519);
				contentPane.add(mainPane);
				mainPane.setLayout(null);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		//code xử lý Giao dịch của Tiến
		if(e.getSource() == menuGiaoDich){
			
		}
		
		//code xử lý của Ngọc và Vũ
		else if(e.getSource() == itemQuanLyNhaCungCap){
			
		} else if(e.getSource() == itemQuanLyNhanVien){
			
		}else if(e.getSource() == itemQuanLyVatTu){
			
		} 
		
		//code xử lý của Minh
		else if(e.getSource() == itemBaoCaoNhap){
			
		}else if(e.getSource() == itemBaoCaoXuat){
			
		}else if(e.getSource() == itemBaoCaoThuChi){
			
		}
		
		//code của Pha
		else if(e.getSource() == itemThayDoiMatKhau){
			new ThayDoiMatKhau(user);
		}else if(e.getSource() == itemThongTinNguoiDung){
			new ThongTinNguoiDung(user);
		}else if(e.getSource() == itemChinhSuaNguoiDung){
			new ChinhSuaNguoiDung(user);
		}else if(e.getSource() == itemThemMoiNguoiDung){
			new ThemMoiNguoiDung();
		}else if(e.getSource() == itemDanhSachNguoiDung){
			mainPane.add(this,new DanhSachNguoiDung(mainPane));
		}else if(e.getSource() == itemThongTinSanPham){
			new ThongTinSanPham();
		}
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}
