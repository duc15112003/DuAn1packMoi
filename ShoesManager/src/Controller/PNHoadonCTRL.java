package Controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.table.DefaultTableModel;

import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DTO.*;
import GUI.PNHoadonGUI;

public class PNHoadonCTRL {

	List<HoaDonDTO> list = new ArrayList<>();
	List<KhachHangDTO> listkh = new ArrayList<>();
	HoaDonDAO hd = new HoaDonDAO();
	KhachHangDAO kh = new KhachHangDAO();

	public List<HoaDonDTO> getAll() throws SQLException{
		list = hd.select();
		listkh = kh.select();
		return list;
	}

	public void filltoTable() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) PNHoadonGUI.tblhoadon.getModel();
		model.setRowCount(0);
		for (HoaDonDTO hd : list) {
			Object[] ob = new Object[] { hd.getMaHD(), hd.getMaNV(), hd.getMaKH(), hd.getMaKM(), hd.getNgayBan(),hd.getTongTien()};
			model.addRow(ob);
		}
	}
	
	
	
	public void fillToComHoaDon() {
		for(KhachHangDTO kh:listkh) {
			PNHoadonGUI.comMakhachhang.addItem(kh.getMaKH());
		}
	}

	public void Insert() throws SQLException {
		HoaDonDTO hdDTO = getModel();
		hd.insert(hdDTO);
		list.clear();
		filltoTable();
	}

	public void Update() throws SQLException{
		HoaDonDTO hdDTO = getModel();
		hd.Update(hdDTO);
		list.clear();
		filltoTable();
	}
	
	public void fillwhenClickedHoaDon() {
		try {
			int index = PNHoadonGUI.tblhoadon.getSelectedRow();
			PNHoadonGUI.txtMahoadon.setText(list.get(index).getMaHD());
			PNHoadonGUI.txtManhanvien.setText(list.get(index).getMaNV());
			PNHoadonGUI.txtMaKhachhang.setText(list.get(index).getMaKH());
			PNHoadonGUI.comMakhuyenmai.setSelectedItem(list.get(index).getMaKM());
			PNHoadonGUI.dateNgayban.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(list.get(index).getNgayBan()));
			PNHoadonGUI.txtTongtien.setText(String.valueOf(list.get(index).getTongTien()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void Delete() throws SQLException {
		HoaDonDTO hdDonDTO = getModel();
		hd.delete(hdDonDTO);
		list.clear();
		filltoTable();
	}
	
	
	

	public void setModel(HoaDonDTO model) {

		try {
			PNHoadonGUI.txtMahoadon.setText(model.getMaHD());
			PNHoadonGUI.txtManhanvien.setText(model.getMaNV());
			PNHoadonGUI.txtMaKhachhang.setText(model.getMaKH());
			PNHoadonGUI.comMakhuyenmai.setSelectedItem(model.getMaKM());
			PNHoadonGUI.dateNgayban.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getNgayBan()));
			PNHoadonGUI.txtTongtien.setText(String.valueOf(model.getTongTien()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HoaDonDTO getModel() {
		HoaDonDTO model = new HoaDonDTO();
		model.setMaHD(PNHoadonGUI.txtMahoadon.getText());
		model.setMaNV(PNHoadonGUI.txtManhanvien.getText());
		model.setMaKH(PNHoadonGUI.txtMaKhachhang.getText());
		model.setMaKM((String) PNHoadonGUI.comMakhuyenmai.getSelectedItem());
		Date dt = PNHoadonGUI.dateNgayban.getDate();
		String fm = new SimpleDateFormat("dd-MM-yyyy").format(dt);
		model.setNgayBan(fm);
		model.setTongTien(Double.parseDouble(PNHoadonGUI.txtTongtien.getText()));
		return model;
	}

	public void setModel(ChiTietHDDTO model) {

		try {
			
			PNHoadonGUI.txtMaspchitiet.setText(model.getMaGiay());
			PNHoadonGUI.txtMaHDchitiet.setText(model.getMaHD());
			PNHoadonGUI.txtSoluongchitiet.setText(String.valueOf(model.getSoLuong()));
			PNHoadonGUI.txtGiabanchitiet.setText(String.valueOf(model.getGiaBan()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ChiTietHDDTO getModel1() {
		ChiTietHDDTO model = new ChiTietHDDTO();
		model.setMaGiay(PNHoadonGUI.txtMaspchitiet.getText());
		model.setMaHD(PNHoadonGUI.txtMaHDchitiet.getText());
		model.setSoLuong(Integer.parseInt(PNHoadonGUI.txtSoluongchitiet.getText()));
		model.setGiaBan(Integer.parseInt(PNHoadonGUI.txtGiabanchitiet.getText()));
		return model;
	}
}
