package com.cg.donar.service;

import com.cg.donar.DTO.DonarDetails;
import com.cg.donar.dao.DonarDaoImpl;
import com.cg.donar.dao.IDonarDao;

public class DonarServiceImpl implements IDonarService{
		
		IDonarDao dao=new DonarDaoImpl();
		@Override
		public int addDonarDetails(DonarDetails d) {
			int res=0;
			 res= dao.addDonarDetails(d);
			
			return res;
		}
}