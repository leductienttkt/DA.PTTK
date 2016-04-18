package Class;

public class NGUOIDUNG {
	private int MaNguoiDung;
	private String TaiKhoan,MatKhau,Quyen,MaNhanVien;
	public NGUOIDUNG(int maNguoiDung, String taiKhoan, String matKhau, String quyen, String maNhanVien) {
		super();
		MaNguoiDung = maNguoiDung;
		TaiKhoan = taiKhoan;
		MatKhau = matKhau;
		Quyen = quyen;
		MaNhanVien = maNhanVien;
	}
	public NGUOIDUNG( String taiKhoan, String matKhau, String quyen) {
		super();
		TaiKhoan = taiKhoan;
		MatKhau = matKhau;
		Quyen = quyen;
	}
	public int getMaNguoiDung() {
		return MaNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getQuyen() {
		return Quyen;
	}
	public void setQuyen(String quyen) {
		Quyen = quyen;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	
}
