package com.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.DTO.BoardDTO;
import com.java.DTO.ItemDTO;

public class BoardDAO {
	private final String DRIVER = MenuDAO.getDriver();
	private final String URL = MenuDAO.getUrl();
	private final String USER = MenuDAO.getUser();
	private final String PW = MenuDAO.getPw();

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static private BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public BoardDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getLastRef() {
		String sql = "SELECT ref FROM board ORDER BY ref DESC LIMIT 1";

		int lastRef = 0;

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				lastRef = rs.getInt("ref");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return lastRef;
	}

	
	public String[] getOrderNo(String writer) {
		String query = " select orderNo from board where writer=?";
		String[] orderNo=new String[30];
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				orderNo[i]=rs.getString("orderNo");
			}
		
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return orderNo;
		
		
	}
	public int upload(String brdDate, String writer, String brdType, String title, String orderNo, String email,
			String mobile, String contents) {
		
		int lastRef=getLastRef();
	
		
		String query = " INSERT INTO `kurly`.`board` (`brdDate`, `brdType`, `title`, `orderNo`, `writer`, `email`, `mobile`, `contents`, `ref`, `restep`, `cmt`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, brdDate);
			pstmt.setString(2, brdType);
			pstmt.setString(3, title);
			pstmt.setString(4, orderNo);
			pstmt.setString(5, writer);
			pstmt.setString(6, email);
			pstmt.setString(7, mobile);
			pstmt.setString(8, contents);
			pstmt.setInt(9, lastRef+1);
			pstmt.setInt(10, 1);
			pstmt.setString(11, "N");
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return -1;
	}

	
	public int updateCmt(String brdNo, String ordNo) {
		String query = "UPDATE board SET cmt = 'Y' WHERE brdNo = ? and orderNo=?";	
		//String query = " INSERT INTO `kurly`.`board` (`brdDate`, `brdType`, `title`, `orderNo`, `writer`, `email`, `mobile`, `contents`, `ref`, `restep`, `cmt`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, brdNo);
			pstmt.setString(2, ordNo);
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return -1;
	}
	
	
	
	public int writeComment(BoardDTO brd, String replying, String date) {

		String query = " INSERT INTO `kurly`.`board` (`brdDate`, `brdType`, `title`, `orderNo`, `writer`, `email`, `mobile`, `contents`, `ref`, `restep`, `cmt` ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		String brdDate = date;
		String brdType = brd.getBrdType();
		String title = brd.getTitle();
		String orderNo = brd.getOrderNo();
		String writer = "admin";
		String email = brd.getEmail();
		String mobile = brd.getMobile();
		String contents = replying;
		int ref = brd.getRef();
		int restep = brd.getRestep() + 1;
		String cmt="Y";
		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, brdDate);
			pstmt.setString(2, brdType);
			pstmt.setString(3, title);
			pstmt.setString(4, orderNo);
			pstmt.setString(5, writer);
			pstmt.setString(6, email);
			pstmt.setString(7, mobile);
			pstmt.setString(8, contents);
			pstmt.setInt(9, ref);
			pstmt.setInt(10, restep);
			pstmt.setString(11, cmt);
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return -1;
	}

	public List<BoardDTO> getBoard(String userId) {

		String sql = "select * from board where writer=?";
		List<BoardDTO> brdList = new ArrayList<>();

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int brdNo = rs.getInt("brdNo");
				String brdDate = rs.getString("brdDate");
				String brdType = rs.getString("brdType");
				String title = rs.getString("title");
				String orderNo = rs.getString("orderNo");
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String contents = rs.getString("contents");
				int ref = rs.getInt("ref");
				int restep = rs.getInt("restep");
				String cmt = rs.getString("cmt");

				BoardDTO brd = new BoardDTO(brdNo, brdDate, brdType, title, orderNo, writer, email, mobile, contents,
						ref, restep, cmt);
				
				brdList.add(brd);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return brdList;
	}

	public List<BoardDTO> adminGetBoard() {

		String sql = "select * from board where writer not in('admin')";
		List<BoardDTO> arr = new ArrayList<>();

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int brdNo = rs.getInt("brdNo");
				String brdDate = rs.getString("brdDate");
				String brdType = rs.getString("brdType");
				String title = rs.getString("title");
				String orderNo = rs.getString("orderNo");
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String contents = rs.getString("contents");
				int ref = rs.getInt("ref");
				int restep = rs.getInt("restep");
				String cmt=rs.getString("cmt");

				BoardDTO temp = new BoardDTO(brdNo, brdDate, brdType, title, orderNo, writer, email, mobile, contents,
						ref, restep, cmt);

				arr.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return arr;
	}

	public BoardDTO getBoardDetail(String boardNo) {
		System.out.println(boardNo);
		String sql = "select * from board where brdNo=?";
		BoardDTO brd = null;

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				int brdNo = rs.getInt("brdNo");
				String brdDate = rs.getString("brdDate");
				String brdType = rs.getString("brdType");
				String title = rs.getString("title");
				String orderNo = rs.getString("orderNo");
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String contents = rs.getString("contents");
				int ref = rs.getInt("ref");
				int restep = rs.getInt("restep");
				String cmt=rs.getString("cmt");
				
				brd = new BoardDTO(brdNo, brdDate, brdType, title, orderNo, writer, email, mobile, contents, ref,
						restep, cmt);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return brd;
	}
	
	public List<BoardDTO> printBoardDetail(String ordNo) {
		System.out.println(ordNo);
		String sql = "select * from board where orderNo=?";
		List<BoardDTO> brdList = new ArrayList<>();

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ordNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				int brdNo = rs.getInt("brdNo");
				String brdDate = rs.getString("brdDate");
				String brdType = rs.getString("brdType");
				String title = rs.getString("title");
				String orderNo = rs.getString("orderNo");
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String contents = rs.getString("contents");
				int ref = rs.getInt("ref");
				int restep = rs.getInt("restep");
				String cmt=rs.getString("cmt");

				BoardDTO brd = new BoardDTO(brdNo, brdDate, brdType, title, orderNo, writer, email, mobile, contents, ref,
						restep, cmt);
				
				brdList.add(brd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return brdList;
	}
	
	public BoardDTO getOrderView(String ordNo, String userId) {
		System.out.println(ordNo);
		String sql = "select * from board where orderNo=? and writer=?";
		BoardDTO brd = null;

		try {
			con = DriverManager.getConnection(URL, USER, PW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ordNo);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int brdNo = rs.getInt("brdNo");
				String brdDate = rs.getString("brdDate");
				String brdType = rs.getString("brdType");
				String title = rs.getString("title");
				String orderNo = rs.getString("orderNo");
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String contents = rs.getString("contents");
				int ref = rs.getInt("ref");
				int restep = rs.getInt("restep");
				String cmt=rs.getString("cmt");

				brd = new BoardDTO(brdNo, brdDate, brdType, title, orderNo, writer, email, mobile, contents, ref,
						restep, cmt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return brd;
	}

	private void close(Connection con, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
