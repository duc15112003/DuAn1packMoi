package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;
import DTO.*;

public class KhuyenMaiDAO {
	
	ResultSet rs;
	ConnectionSQL cn = new ConnectionSQL();
	public List<KhuyenMaiDTO> select(String sql,Object...args){
		List<KhuyenMaiDTO> list = new ArrayList<>();
		cn.executeQuery(sql, args);
		return list;
	}
	public KhuyenMaiDTO readData(ResultSet rs) {
		KhuyenMaiDTO km = new KhuyenMaiDTO();
		km.setMaKM(null);
		return km;
	}

}
