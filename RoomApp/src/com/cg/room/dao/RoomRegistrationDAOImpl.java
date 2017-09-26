package com.cg.room.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.room.dbutil.DbUtil;
import com.cg.room.dto.FlatRegistrationDTO;
import com.cg.room.exception.RoomApplicationException;

public class RoomRegistrationDAOImpl implements IRoomRegistrationDAO {

	static Logger logger = Logger.getRootLogger();
	public RoomRegistrationDAOImpl()
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	public int addBookingDetails(FlatRegistrationDTO details) throws RoomApplicationException, IOException {
		int idd=0;
		int result = 0;
		try {
			Connection conn=DbUtil.getConnection();
			
			String insertQuery=
					"Insert into Room_Registration values(room_seq.nextval,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(insertQuery);
				ps.setInt(1, details.getHotelId());
				ps.setInt(2, details.getRoomType());
				ps.setInt(3, details.getRoomArea());
				ps.setInt(4, details.getRentAmount());
				ps.setInt(5, details.getPaidAmount());
				
				result=ps.executeUpdate();
				
				if(result==1)
				{
					
				String str="Select room_seq.currval from dual";
				Statement st=conn.createStatement();
				ResultSet rs=st.executeQuery(str);
				while(rs.next())
				{
					idd=rs.getInt(1);
				
				}
				}
				logger.info("Executed Successfully");
		} 
		catch (SQLException e)
		{
			logger.error("Exception Occured "+e.getMessage());
			throw new RoomApplicationException(e.getMessage());
		}
		catch (IOException e)
		{
			logger.error("Exception Occured "+e.getMessage());
			throw new RoomApplicationException(e.getMessage());
		}
	
		return idd;	
	}

	@Override
	public ArrayList<Integer> getAllOwnerId(){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Connection conn;
		try
		{
			conn = DbUtil.getConnection();
			String str="select hotel_Id from hotel_owners";
			PreparedStatement ps=conn.prepareStatement(str);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int rr=rs.getInt(1);
				arr.add(rr);
			}
			
		} 
		catch (IOException | SQLException e)
		{
			e.printStackTrace();
		}
		return arr;
	}	
}
