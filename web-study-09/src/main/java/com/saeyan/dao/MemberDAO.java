package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saeyan.dto.MemberVO;

public class MemberDAO {
	
	private static MemberDAO instance  = new MemberDAO();
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	//1. DB 연결
	public Connection getConnection() throws Exception{	
		
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String uid = "system";
		String pass = "oracle";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB연결	    
		
		return DriverManager.getConnection(url,uid,pass);
	}

	//userid, pwd 전달받아서, DB랑 연동해서 데이타가 있는지 조회
	public int userCheck(String userid, String pwd) {
		
		/*
		 * 1  : userid, pwd 일치
		 * 0  : userid 일치, pwd 불일치
		 * -1 : userid 불일치 
		 */
		
		int result = -1;
		
		String sql = "select pwd from member where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;  //sql구문이 select일때만 기입!
		
		try {
			//1. DB연결
			conn = getConnection();
			//2. sql구문 전송
			pstmt = conn.prepareStatement(sql);
			//3. sql 맵핑
			pstmt.setString(1, userid);
			//4. sql 구문 실행
			rs = pstmt.executeQuery(); //sql구문이 select일때만 
			
			if(rs.next()) {
				//회원 ID 존재!
				if(rs.getString("pwd") != null && 
						rs.getString("pwd").equals(pwd)) {
					result = 1;  //userid, pwd 일치
				}else {
					result = 0; //pwd만 불일치
				}
			}else {
				//이런 회원id는 없다!
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if ( rs != null) rs.close();
				if ( pstmt != null) pstmt.close();
				if ( conn != null) conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
		return result;
	}

	public MemberVO getMember(String userid) {
		
		MemberVO mVo = null;
		
		String sql = "select * from member where userid = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name"); 
				String id = rs.getString("userid"); 
				String pwd = rs.getString("pwd"); 
				String email = rs.getString("email"); 
				String phone = rs.getString("phone"); 
				int admin = rs.getInt("admin"); 
				
				mVo = new MemberVO();
				mVo.setName(name);
				mVo.setUserid(id);
				mVo.setPwd(pwd);
				mVo.setEmail(email);
				mVo.setPhone(phone);
				mVo.setAdmin(admin);				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null ) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return mVo;
	}

	public int confirmID(String userid) {
		int result = 1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select userid from member where userid = ?";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;  //아이디 존재 => 사용불가 아이디
			}else {
				result = -1; //사용가능 아이디
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//저장
	public int insertMember(MemberVO mVo) {

		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		try {
			//1. DB 연결
			conn = getConnection();
			//2. sql구문 전송
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getPwd());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getPhone());
			pstmt.setInt(6, mVo.getAdmin());
			
			/* 3. sql 구문 실행
				executeUpdate -> insert, update, delete시 사용
				result : 0 -> 저장 실패
				result : 1 -> 저장 성공
				commit은 auto commit;
			*/
			result = pstmt.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			} //end catch
		} //end finally
		
		return result;
	} // end insertMember

	public void updateMember(MemberVO mVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		                              //     1      2        3        4        5               6 
		String sql = "update member set name=?, pwd=?, email=?, phone=?, admin=?  where userid=? ";
		
		try {
			//1. DB 연결
			conn = getConnection();
			//2. sql구문 전송
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getPwd());
			pstmt.setString(3, mVo.getEmail());
			pstmt.setString(4, mVo.getPhone());
			pstmt.setInt(5, mVo.getAdmin());
			pstmt.setString(6, mVo.getUserid());
			
			/* 3. sql 구문 실행
				executeUpdate -> insert, update, delete시 사용
				result : 0 -> 저장 실패
				result : 1 -> 저장 성공
				commit은 auto commit;
			*/
			int result = pstmt.executeUpdate();	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} //end updateMember
}














