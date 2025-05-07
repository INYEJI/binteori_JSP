package com.magic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.magic.dto.EmployeesVO;

public class EmployeesDAO {
    private EmployeesDAO() {}

    private static EmployeesDAO instance = new EmployeesDAO();

    public static EmployeesDAO getInstance() {
        return instance;
    }

    // DB 연결 (JDBC 방식)
    public Connection getConnection() throws Exception {	
        String url = "jdbc:oracle:thin:@localhost:49161:xe";
        String uid = "system";
        String pwd = "oracle";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, uid, pwd);
    }

    // 로그인 체크
    public int userCheck(String userid, String pwd, String lev) {
        int result = -1; // 기본은 실패
        String sql = "SELECT * FROM employees WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPwd = rs.getString("pwd");
                String dbLev = rs.getString("lev");

                if (dbPwd != null && dbPwd.equals(pwd)) {
                    if (dbLev.equals(lev)) {
                        result = lev.equals("A") ? 0 : 1; // A: 운영자, B: 일반회원
                    } else {
                        result = -1; // 권한 불일치
                    }
                } else {
                    result = -1; // 비밀번호 불일치
                }
            } else {
                result = -1; // ID 없음
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // 회원 정보 조회
    public EmployeesVO getMember(String id) {
        EmployeesVO member = null;
        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    member = new EmployeesVO();
                    member.setId(rs.getString("id"));
                    member.setPwd(rs.getString("pwd")); // 수정됨
                    member.setName(rs.getString("name"));
                    member.setLev(rs.getString("lev"));
                    member.setEnter(rs.getDate("enter"));
                    member.setGender(rs.getInt("gender"));
                    member.setPhone(rs.getString("phone"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return member;
    }

    // 회원 등록
    public void insertMember(EmployeesVO member) {
        String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, SYSDATE, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPwd()); // 수정됨
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getLev());
            pstmt.setInt(5, member.getGender());
            pstmt.setString(6, member.getPhone());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원 정보 수정
    public int updateMember(EmployeesVO eVo) {
        int result = -1;
        String sql = "UPDATE employees SET gender = ?, pwd = ?, name = ?, lev = ?, phone = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, eVo.getGender());
            pstmt.setString(2, eVo.getPwd()); // 수정됨
            pstmt.setString(3, eVo.getName());
            pstmt.setString(4, eVo.getLev());
            pstmt.setString(5, eVo.getPhone());
            pstmt.setString(6, eVo.getId());

            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

