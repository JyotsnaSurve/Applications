package com.cg.mobile.dao;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.dbutil.DbUtil;
import com.cg.mobile.exception.MobileApplicationException;
public class MobDaoImpl implements IMobileDAO{
	Connection conn=null;

	static Logger logger = Logger.getRootLogger();
	public MobDaoImpl()
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public int addPurchaseDetails(PurchaseDetails p) throws MobileApplicationException {

	int result = 0;
	
		try {
			conn=DbUtil.getConnection();
			String insertQuery=
					"Insert into purchasedetails values(purchase_seq_id.nextval,?,?,?,SYSDATE,?)";
				PreparedStatement ps=conn.prepareStatement(insertQuery);
				ps.setString(1, p.getcName());
				ps.setString(2, p.getMailId());
				ps.setLong(3, p.getPhoneno());
				
				String sql="select mobileid from mobiles where mobileid=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1, p.getMobileId());
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					ps.setInt(4,rs.getInt(1));
					result=ps.executeUpdate();
					System.out.println(result);
				}
				logger.info("Executed Successfully");

			
		} 
		catch (IOException e) {
			
			logger.error("Exception Occured"+e.getMessage());
			e.printStackTrace();


		}
		catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
			
			throw new MobileApplicationException(e.getMessage());
		} 
		return result;
		
	}

	@Override
	public ArrayList<MobileDetails> retrieveDetails() {
		ArrayList<MobileDetails> list=new ArrayList<MobileDetails>();
		try{
		conn=DbUtil.getConnection();
		String sql="Select * from mobiles";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			int mid=rs.getInt(1);
			String name=rs.getString(2);
			int price=rs.getInt(3);
			String quantity=rs.getString(4);
			list.add(new MobileDetails(mid,name,price,quantity));
		}
		}
		catch(SQLException|IOException e)
		{
			System.out.println(e.getMessage());

		}
		return list;
	}
	
}
