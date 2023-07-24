package DAO;

import DTO.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class HoaDonChiTietDAO {
	
	List<ChiTietHDDTO> cthdList = new ArrayList<>();
	ConnectionSQL cn = new ConnectionSQL();
	PreparedStatement ps;
	ResultSet rs;
	
	public void Insert(ChiTietHDDTO cthd) {
		String sql = "use qlcuahanggiaydb;insert into tblchitiethd values(?,?,?,?)";
		cn.executeQuery(sql, cthd.getMaGiay(),cthd.getMaHD(),cthd.getSoLuong(),cthd.getGiaBan());
	}
	
	public void Update(ChiTietHDDTO cthd) {
		String sql = "use qlcuahanggiaydb;update tblchitiethd set Soluong = ?, GiaBan = ? where MaGiay = ? and MaHD = ?";
		cn.executeUpdate(sql, cthd.getSoLuong(),cthd.getGiaBan(),cthd.getMaGiay(),cthd.getMaHD());
	}
	
	public void DeleteAll(ChiTietHDDTO cthd) {
		String sql = "use qlcuahanggiaydb;delete from tblchitiethd where MaHD = ?";
		cn.executeUpdate(sql, cthd.getMaHD());
		
	}
	
	public void Delete(ChiTietHDDTO cthd) {
		String sql = "use qlcuahanggiaydb;delete from tblchitiethd where MaGiay = ? and MaHD = ?";
		cn.executeQuery(sql, cthd.getMaGiay(),cthd.getMaHD());
	}
	
	public List<ChiTietHDDTO> select() throws SQLException{
		String sql = "use qlcuahanggiaydb; select * from tblchitiethd";
		return select(sql);
	}
	
	public List<ChiTietHDDTO> select(String sql,Object...args) throws SQLException{
		List<ChiTietHDDTO> cthdlist = new ArrayList<>();
		rs = cn.executeQuery(sql, args);
		while (rs.next()) {
			ChiTietHDDTO cthd = readData(rs);
			cthdlist.add(cthd);
		}
		return cthdlist;
	}
	
	public ChiTietHDDTO readData(ResultSet rs) throws SQLException {
		
		ChiTietHDDTO cthd = new ChiTietHDDTO();
		cthd.setMaGiay(rs.getString(1));
		cthd.setMaHD(rs.getString(2));
		cthd.setSoLuong(rs.getInt(3));
		cthd.setGiaBan(rs.getInt(4));
		return cthd;
		
	}

}
