package com.gyojincompany.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gyojincompany.board.dto.BoardDto;

public class BoardDao {
	
	private String driverName = "com.mysql.jdbc.Driver"; //MySQL JDBC 드라이버 이름
	private String url = "jdbc:mysql://localhost:3306/springdb?serverTimezone=Asia/Seoul"; //MySQL이 설치된 서버의 주소(ip)와 연결할 DB(스키마) 이름		
	private String username = "root";
	private String password = "12345";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void write(String bname, String btitle, String bcontent) { //DB에 글쓰는 메서드
		
		String sql = "INSERT INTO boardtbl(bname, btitle, bcontent, bhit)"
				+ "VALUES (?,?,?,0)";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<BoardDto> boardlist() { //DB에 있는 게시판 모든 글 목록 가져오기 메서드
		
		String sql = "SELECT * FROM boardtbl ORDER BY bnum DESC";
		List<BoardDto> bDtos = new ArrayList<BoardDto>();
		
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				BoardDto bDto = new BoardDto(rs.getInt("bnum"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"), rs.getInt("bhit"), rs.getString("bdate"));
				bDtos.add(bDto);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bDtos;
		
	}
	
	//유저가 게시판 목록에서 글 제목을 클릭했을때 들어오는 요청 처리 메서드
	public BoardDto contentView(String bnum) { //글 번호에 해당하는 글 레코드를 가져와 boardDto에 넣어서 반환하는 메서드
		
		upHit(bnum); //조회수 증가 함수 호출
		
		String sql = "SELECT * FROM boardtbl WHERE bnum=?";
		BoardDto bDto = new BoardDto();
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {			
				bDto = new BoardDto(rs.getInt("bnum"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"), rs.getInt("bhit"), rs.getString("bdate"));				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bDto;
		
	}
	
	public void upHit(String bnum) { //유저가 클릭한 글번호의 조회수 증가 함수
		
		String sql = "UPDATE boardtbl SET bhit=bhit+1 WHERE bnum=?";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
		
	
	
}
