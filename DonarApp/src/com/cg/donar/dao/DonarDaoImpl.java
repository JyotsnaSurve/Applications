package com.cg.donar.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.donar.DTO.DonarDetails;
import com.cg.donar.dbutil.DbUtil;


public class DonarDaoImpl implements IDonarDao{

	Connection conn=null;

	public int addDonarDetails(DonarDetails d){

	int result = 0;
		try {
			conn=DbUtil.getConnection();
			String insertQuery=
					"Insert into donar values(donar_id_seq.nextval,?,?,?,?,SYSDATE)";
				PreparedStatement ps=conn.prepareStatement(insertQuery);
				ps.setString(1, d.getDonarName());
				ps.setString(2, d.getPhoneNo());
				ps.setString(3, d.getAddress());
				ps.setInt(4, d.getDonationAmt());
				result = ps.executeUpdate();
		
		} 
		catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;	
	}

}
