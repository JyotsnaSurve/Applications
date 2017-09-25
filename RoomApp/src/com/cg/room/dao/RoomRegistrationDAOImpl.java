package com.cg.room.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.room.dbutil.DbUtil;
import com.cg.room.dto.FlatRegistrationDTO;

public class RoomRegistrationDAOImpl implements IRoomRegistrationDAO {
	Connection conn=null;

	@Override
	public int addBookingDetails(FlatRegistrationDTO details) {
		
		int result = 0;
		try {
			conn=DbUtil.getConnection();
			
			String insertQuery=
					"Insert into Room_Registration values(room_seq.nextval,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(insertQuery);
				ps.setInt(1, details.getHotelId());
				ps.setInt(2, details.getRoomType());
				ps.setInt(3, details.getRoomArea());
				ps.setInt(4, details.getRentAmount());
				ps.setInt(5, details.getPaidAmount());
				
				result=ps.executeUpdate();
				System.out.println(result);
				
				
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	
			/*String sql="select hotelId from hotel_owners where hotelId=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, details.getHotelId());
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				ps.setInt(1,rs.getInt(1));
				result=ps.executeUpdate();
				System.out.println(result);
			}*/
		return result;	
	}

	@Override
	public ArrayList<Integer> getAllOwnerId() throws IOException, SQLException {
		ArrayList<Integer> arr=new ArrayList<Integer>();
		conn=DbUtil.getConnection();
		String str="select hotel_Id from hotel_owners";
		PreparedStatement ps=conn.prepareStatement(str);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int rr=rs.getInt(1);
			arr.add(rr);
		}
		return arr;
	}
	
}
