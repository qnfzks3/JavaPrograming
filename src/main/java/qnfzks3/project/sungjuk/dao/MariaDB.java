package qnfzks3.project.sungjuk.dao;

import java.sql.*;

public class MariaDB { //자 27부터 31 까지 데이터 검색 수정 삭제 등 다 한곳에 만들수 있도록 중복되는것들을 이곳으로 다 뺌 - 데이터 연결, 데이터 닫음
                           //26 27먼 적용해봄
    private static final String DRV = "org.mariadb.jdbc.Driver"; //마리아 디비 드라이버
    private static final String URL = "jdbc:mariadb://fullstacks.cdxqxdvfxgja.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";//"jdbc:mariadb://아마존 주소:3306/fullstacks"
    private static final String USR = "admin";
    private static final String PWD = "fullstack_2023";

    //데이터베이스 접속 객체 생성
    public static Connection makeConn(){ //void가 없으니 함수이기때문에 return이 있어야한다. , 데이터 연결을 다른 클래스에도 적용해보자.
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

    //데이터베이스 접속 객체 해제
    public static void closeConn(ResultSet rs, PreparedStatement pstmt , Connection conn){
        //이렇게 스테틱으로 하면 객체 생성 없이 바로 사용이 가능하다. - 기본으로 선언하지않아도 어디서나 사용가능하게함
        //JS32JDBCUtil jdbc=new JS32JDBCUtil(); 이런식으로 클라스 객체를 생성하지않아도 사용가능하도록함
        //jdbc.clseConn(rs,pstmt,conn); 사용할 땐 아래처럼 클래스명만 적고 사용
        //JS32JDBCUtil.closeConn(rs,pstmt,conn); 이렇게 바로 적어도 사용가능
        // 반드시, 클래스명,메서드명으로 호출해야한다.
        //static 은 고정- 어디서나 선언 필요없이 사용가능
        //static의 반대는 instance라고 한다 - 해당 클래스에서만 사용
        if (rs !=null) try { rs.close();}catch (Exception ex){}
        if (pstmt !=null) try { conn.close();}catch (Exception ex){}
        if (conn !=null) try { conn.close();}catch (Exception ex){}
        
        
        
    }
    
}
