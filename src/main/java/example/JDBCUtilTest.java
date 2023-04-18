package example;

import java.sql.*;

public class JDBCUtilTest {
    private static final String DRV = "oracle.jdbc.driver.OracleDriver"; //오라클 접속 드라이버
    private static final String URL = "jdbc:oracle:thin:@13.124.192.232 :1521:XE";//"jdbc:mariadb://아마존 주소:3306/fullstacks"
    private static final String USR = "hr";
    private static final String PWD = "hr";
    public static Connection testConn(){
        Connection conn= null;
        try {

            Class.forName(DRV); // 연동된 클래스들을 쓰기위해 JDBC 관련 작업들을 수행 - 드라이버 접속
            conn = DriverManager.getConnection(URL,USR,PWD);  //데이터베이스 서버 연결

        } catch (ClassNotFoundException e) {
            System.out.println(" db접속 드라이버 오류");
        }catch (SQLException e) { //try부분에서 오류가 나면
            System.out.println("DB 접속주소나 아이디/비번, sql 명령문을 확인해주세요!");   //경우 전부 넣어준다 한번에
        }
        return conn;
    }

    public static void closeConn(ResultSet rs, PreparedStatement pstmt , Connection conn){
        if (rs !=null) try { rs.close();}catch (Exception ex){}
        if (pstmt !=null) try { conn.close();}catch (Exception ex){}
        if (conn !=null) try { conn.close();}catch (Exception ex){}
    }



}
