package com.kh.searchfree.project.model.dao;

import static com.kh.searchfree.common.JDBCTemplate.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.searchfree.project.model.vo.MemberStar;
import com.kh.searchfree.project.model.vo.Project;
import com.kh.searchfree.project.model.vo.ProjectApply;
import com.kh.searchfree.project.model.vo.ProjectOrderList;
import com.kh.searchfree.project.model.vo.ProjectRead;
import com.kh.searchfree.project.model.vo.ProjectResource;
import com.kh.searchfree.project.model.vo.Reply;
import com.kh.searchfree.project.model.vo.ReplyRead;
import com.kh.searchfree.project.model.vo.VProjectApply;

import oracle.sql.CLOB;

import com.kh.searchfree.project.model.dao.ProjectDao;

public class ProjectDao {

	private Properties prop = null;

	public ProjectDao() throws Exception {
		String fileName = ProjectDao.class.getResource("/com/kh/searchfree/sql/project/project-query.properties")
				.getPath();
		prop = new Properties();
		prop.load(new FileReader(fileName));
	}

	public ProjectRead selectProject(Connection conn, int projectNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ProjectRead projectRead = null;

		String query = prop.getProperty("selectProject");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, projectNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				projectRead = new ProjectRead(rset.getInt("PROJECT_NO"), rset.getInt("PROJECT_ALT"),
						rset.getInt("MEMBER_NO"), rset.getString("PROJECT_TITLE"), rset.getString("CATEGORY1_NAME"),
						rset.getString("CATEGORY2_NAME"), rset.getString("MEMBER_INTEREST"),
						rset.getString("MEMBER_NM"), rset.getString("PROJECT_SUMMARY"),
						rset.getDate("PROJECT_START_DT"), rset.getDate("PROJECT_EXPIRED_DT"),
						rset.getInt("PROJECT_PRICE"), rset.getString("PROJECT_CONTENT"),
						rset.getInt("REVIEW_STAR_RATING"));

			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return projectRead;
	}

	/**
	 * project 등록용
	 * 
	 * @param conn
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int insertProject(Connection conn, Project project, int projectWriter) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertProject");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, project.getProjectNo());
			pstmt.setString(2, project.getProjectTitle());
			pstmt.setInt(3, project.getProjectCategoryCode1());
			pstmt.setInt(4, project.getProjectCategoryCode2());
			pstmt.setDate(5, project.getProjectStartDate());
			pstmt.setDate(6, project.getProjectExpiredDate());
			pstmt.setInt(7, project.getProjectPrice());
			pstmt.setString(8, project.getProjectSummary());
			pstmt.setString(9, project.getProjectContent());
			pstmt.setInt(10, project.getProjectStatus());
			pstmt.setInt(11, projectWriter);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 썸네일 이미지 저장
	 * 
	 * @param conn
	 * @param file
	 * @return result
	 */
	public int insertAttachment(Connection conn, ProjectResource file) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertProjectResource");
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, file.getProjectResourcePath());
			pstmt.setInt(2, file.getProjectNo());
			pstmt.setString(3, file.getFileOriginName());
			pstmt.setString(4, file.getFileChangeName());

			result = pstmt.executeUpdate();

			System.out.println("img input");

		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 새로 생성될 project의 번호 얻어오기
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int selectNextNo(Connection conn) throws Exception {
		Statement stmt = null;
		ResultSet rset = null;
		int projectNo = 0;

		String query = prop.getProperty("selectNextNo");

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				projectNo = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(stmt);
		}

		return projectNo;
	}

	/**
	 * 게시글 이미지 파일 조회용 Dao
	 * 
	 * @param conn
	 * @param projectNo
	 * @return
	 */
	public List<ProjectResource> selectFiles(Connection conn, int projectNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<ProjectResource> files = null;

		String query = prop.getProperty("selectFiles");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, projectNo);
			rset = pstmt.executeQuery();

			files = new ArrayList<ProjectResource>();
			ProjectResource file = null;

			while (rset.next()) {
				file = new ProjectResource(rset.getInt("PROJECT_RESOURCE_NO"), rset.getString("PROJECT_RESOURCE_PATH"),
						rset.getString("FILE_ORIGIN_NAME"), rset.getString("FILE_CHANGE_NAME"),
						rset.getString("PROJECT_RESOURCE_DELETE_YN").charAt(0), rset.getInt("PROJECT_NO"));

				files.add(file);
				System.out.println(file);
			}

		} finally {
			close(rset);
			close(pstmt);
		}
		return files;
	}

	/**
	 * 클라이언트 프로젝트 의뢰 등록 Dao
	 * 
	 * @param conn
	 * @param project
	 * @return result
	 */
	public int insertProject_client(Connection conn, Project project, int projectWriter) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertProject_client");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, project.getProjectNo());
			pstmt.setString(2, project.getProjectTitle());
			pstmt.setInt(3, project.getProjectCategoryCode1());
			pstmt.setInt(4, project.getProjectCategoryCode2());
			pstmt.setDate(5, project.getProjectStartDate());
			pstmt.setDate(6, project.getProjectExpiredDate());
			pstmt.setInt(7, project.getProjectPrice());
			pstmt.setString(8, project.getProjectSummary());
			pstmt.setString(9, project.getProjectContent());
			pstmt.setInt(10, project.getProjectStatus());
			pstmt.setInt(11, projectWriter);

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 프로젝트 수정용 Dao
	 * 
	 * @param conn
	 * @param project
	 * @return result
	 * @throws Exception
	 */
	public int updateProject(Connection conn, Project project) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateProject");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, project.getProjectTitle());
			pstmt.setInt(2, project.getProjectCategoryCode1());
			pstmt.setInt(3, project.getProjectCategoryCode2());
			pstmt.setDate(4, project.getProjectStartDate());
			pstmt.setDate(5, project.getProjectExpiredDate());
			pstmt.setInt(6, project.getProjectPrice());
			pstmt.setString(7, project.getProjectSummary());
			pstmt.setString(8, project.getProjectContent());
			pstmt.setInt(9, project.getProjectStatus());
			pstmt.setInt(10, project.getProjectNo());

			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateAttachment(Connection conn, ProjectResource file) throws Exception {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateProjectResource");
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, file.getProjectResourcePath());
			pstmt.setString(2, file.getFileOriginName());
			pstmt.setString(3, file.getFileChangeName());
			pstmt.setInt(4, file.getProjectNo());

			result = pstmt.executeUpdate();

			System.out.println("img input");

		} finally {
			close(pstmt);
		}

		return result;
	}

	/**
	 * 댓글 등록용 Dao
	 * 
	 * @param conn
	 * @param reply
	 * @param replyWriter
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Connection conn, Reply reply) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertReply");

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getProjectNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 댓글 리스트 조회용 Dao
	 * 
	 * @param conn
	 * @param projectNo
	 * @return rList
	 * @throws Exception
	 */
	public List<ReplyRead> selectReplyList(Connection conn, int projectNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ReplyRead> rList = null;

		String query = prop.getProperty("selectReplyList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, projectNo);
			rset = pstmt.executeQuery();

			rList = new ArrayList<ReplyRead>();
			ReplyRead replyRead = null;

			while (rset.next()) {
				replyRead = new ReplyRead(rset.getInt("REPLY_NO"), rset.getString("REPLY_CONTENT"),
						rset.getDate("REPLY_CREATE_DT"), rset.getInt("REPLY_LEVEL"), rset.getString("MEMBER_NICK"),
						rset.getInt("PROJECT_NO"), rset.getInt("REPLY_NO2"));

				rList.add(replyRead);
			}

		} finally {
			close(rset);
			close(pstmt);
		}
		return rList;
	}

	/**
	 * 프로젝트 삭제(PROJECT_DELETE_YN 'Y'로 바꿔주기 Dao
	 * 
	 * @param conn
	 * @param projectNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteProject(Connection conn, int projectNo) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteProject");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, projectNo);
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 지원하기 Dao(project_apply에 insert)
	 * 
	 * @param conn
	 * @param projectNo
	 * @return result
	 * @throws Exception
	 */
	public int insertApply(Connection conn, int projectNo, int memberNo) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertApply");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, projectNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 지원자 불러오는 Dao (전달 받은 projectNo와 일치하는 것 다 끌어오기)
	 * 
	 * @param conn
	 * @param projectNo
	 * @return vProjectApply
	 * @throws Exception
	 */
	public List<VProjectApply> selectApplyList(Connection conn, String projectNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<VProjectApply> vProjectApply = null;

		String query = prop.getProperty("selectApplyList");

		try {

		} finally {
			close(rset);
			close(pstmt);
		}
		return null;
	}

	/**
	 * @param conn
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public MemberStar selectMemberStar(Connection conn, int memberNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberStar memberStar = null;

		String query = prop.getProperty("selectMemberStar");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				memberStar = new MemberStar(memberNo, rset.getInt("STAR"));
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return memberStar;
	}

	public List<ProjectOrderList> selectProject2(Connection conn, int no) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ProjectOrderList> orderlist = null;

		String query = prop.getProperty("selectProject");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 5);
			rset = pstmt.executeQuery();

			orderlist = new ArrayList<ProjectOrderList>();

			ProjectOrderList projectOrder = null;

			while (rset.next()) {
				projectOrder = new ProjectOrderList(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4),
						rset.getInt(5), rset.getString(6));

				orderlist.add(projectOrder);
			}

		} finally {
			close(rset);
			close(pstmt);
		}

		return orderlist;
	}

	/**
	 * 나의 판매한 프로젝트 목록
	 * 
	 * @param conn
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public List<ProjectOrderList> selledProject(Connection conn, int no) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ProjectOrderList> selledList = null;

		String query = prop.getProperty("selledProject");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 5);
			rset = pstmt.executeQuery();

			selledList = new ArrayList<ProjectOrderList>();

			ProjectOrderList projectOrder = null;

			while (rset.next()) {
				projectOrder = new ProjectOrderList(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4),
						rset.getInt(5), rset.getString(6));

				selledList.add(projectOrder);
			}

		} finally {
			close(rset);
			close(pstmt);
		}

		return selledList;
	}

	/**
	 * 프로젝트 조회시 별점 평균 계산 DAO
	 * 
	 * @param conn
	 * @return averlist
	 * @throws Exception
	 */
	public List<ProjectOrderList> selAverProject(Connection conn) throws Exception {

		Statement stmt = null;
		ResultSet rset = null;
		List<ProjectOrderList> averlist = null;

		String query = prop.getProperty("selAverProject");

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			averlist = new ArrayList<ProjectOrderList>();

			ProjectOrderList projectAver = null;

			while (rset.next()) {
				projectAver = new ProjectOrderList(rset.getInt(1), rset.getInt(2));

				averlist.add(projectAver);

			}

		} finally {
			close(rset);
			close(stmt);
		}

		return averlist;
	}

}
