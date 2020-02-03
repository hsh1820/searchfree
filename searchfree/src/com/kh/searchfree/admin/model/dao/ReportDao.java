package com.kh.searchfree.admin.model.dao;

import static com.kh.searchfree.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.searchfree.admin.model.vo.Project;
import com.kh.searchfree.admin.model.vo.ReportAll;

public class ReportDao {
	private Properties prop = null;
	
	public ReportDao() throws Exception{
		String fileName = NoticeDao.class.getResource("/com/kh/searchfree/sql/report/report-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}
	
	public List<ReportAll> selectReportList(Connection conn)throws Exception{
		
		Statement stmt = null;
				ResultSet rset = null;
				
				List<ReportAll> list = null;
				
				String query = prop.getProperty("selectReportList");
				
				try {
					stmt = conn.createStatement();
					rset = stmt.executeQuery(query);
					
					list = new ArrayList<ReportAll>();
					
					ReportAll report = null;
					
					while(rset.next()) {
						
						report = new ReportAll();
						report.setReportCode(rset.getInt(1));
						report.setMemberId(rset.getString(2));
						report.setReportCreateDT(rset.getDate(3));
						report.setReportStatus((rset.getString(4)).charAt(0));		
						list.add(report);
						System.out.println("신고전체 리스트 :  "+report);
					}
				}finally {
					close(rset);
					close(stmt);
				}
				return list;
			}


}
