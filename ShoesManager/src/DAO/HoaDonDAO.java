package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.HoaDonDTO;

public class HoaDonDAO{
	ResultSet rs;
	String MaHD;
    String MaNV;
    String MaKH;
    String MaKM;
    String NgayBan;
    double tongTien;
    PreparedStatement ps;
    ConnectionSQL cn = new ConnectionSQL();
	
	public void insert(HoaDonDTO hd) {
		String sql = "use qlcuahangbangiay;insert into tblhoadon values (?,?,?,?,?,?)";
		cn.executeQuery(sql, hd.getMaHD(),hd.getMaKH(),hd.getMaKM(),hd.getMaNV(),hd.getNgayBan(),hd.getTongTien());
	}
	public List<HoaDonDTO> select(String sql, Object...args) throws SQLException{
		List<HoaDonDTO> list = new ArrayList<>();
		rs =  cn.executeQuery(sql, args);
		while (rs.next()) {
			HoaDonDTO hd = readFromResultSet(rs);
			list.add(hd);	
		}
		return list;
	}
	
	public void Update(HoaDonDTO hd) {
		String query = "use qlcuahangbangiay; Update tblhoadon set where MaHD = ?";
		cn.executeUpdate(query, hd.getMaKH(),hd.getMaKM(),hd.getMaNV(),hd.getNgayBan(),hd.getTongTien(),hd.getMaHD());
	}
	
	
	public void delete(HoaDonDTO hd) {
		String query = "use qlcuahanggiaydb; delete from tblhoadon where MaHD = ?";
		cn.executeQuery(query, hd.getMaHD());
	}
	
	public List<HoaDonDTO> select() throws SQLException{
		String sql = "use qlcuahanggiaydb; select * from tblhoadon";
		return select(sql);
	}
	
	private HoaDonDTO readFromResultSet(ResultSet rs) throws SQLException{
		HoaDonDTO hd =new HoaDonDTO();
		hd.setMaHD(rs.getString(1));
		hd.setMaKH(rs.getString(2));
		hd.setMaKM(rs.getString(3));
		hd.setMaNV(rs.getString(4));
		hd.setNgayBan(rs.getString(5));
		hd.setTongTien(rs.getInt(6));
		 return hd;
	}

}
