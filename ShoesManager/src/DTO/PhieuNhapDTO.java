package DTO;

public class PhieuNhapDTO {
	
	String MaPN,MaNCC,MaNV,NgayNhap,TongTien;
	
	public PhieuNhapDTO() {
		// TODO Auto-generated constructor stub
	}

	public PhieuNhapDTO(String maPN, String maNCC, String maNV, String ngayNhap, String tongTien) {
		MaPN = maPN;
		MaNCC = maNCC;
		MaNV = maNV;
		NgayNhap = ngayNhap;
		TongTien = tongTien;
	}

	public String getMaPN() {
		return MaPN;
	}

	public void setMaPN(String maPN) {
		MaPN = maPN;
	}

	public String getMaNCC() {
		return MaNCC;
	}

	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getNgayNhap() {
		return NgayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		NgayNhap = ngayNhap;
	}

	public String getTongTien() {
		return TongTien;
	}

	public void setTongTien(String tongTien) {
		TongTien = tongTien;
	}
}
