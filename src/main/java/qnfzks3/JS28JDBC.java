package qnfzks3;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class JS28JDBC {
    private static String DRV = "org.mariadb.jdbc.Driver";
    private static String URL = "jdbc:mariadb://fullstacks.cdxqxdvfxgja.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";//"jdbc:mariadb://아마존 주소:3306/fullstacks"
    private static String USR = "admin";
    private static String PWD = "fullstack_2023";

    private static String selectBookSQL = "select * from newbooks order by bookno desc"; //sql 에서 ? 는 매개변수를 의미한다.
                                                                            // 여기서 sql에서는 매개변수를 placeholder라고한다.

    public static void main(String[] args) {
        //newbooks 테이블의 모든 레코드 조회


        try {
            Class.forName(DRV); // 연동된 클래스들을 쓰기위해 JTBC 관련 작업들을 수행
        } catch (ClassNotFoundException e) {
            System.out.println(" db접속 드라이버 오류");
        }


        Connection conn=null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;  //ResultSet 이건 뭘까?   ResultSet는 executeQuery()와 같이 사용한다.
        


        try {
            //데이터베이스 접속
            conn = DriverManager.getConnection(URL,USR,PWD);  //데이터베이스 서버에 연결 할수있도록하는 드라이버매니저  함수
            //실행한 sql문 생성
            pstmt = conn.prepareStatement(selectBookSQL);    //SQL 문을 실행할 수 있도록 해주는 함수 prepareStatement
            
            //SQL문 실행후 결과 확인
            rs = pstmt.executeQuery(); // DML 실행 시 사용 - 실행 한 결과 값을 cnt에 넣어줌   DML이 뭔지도 찾아보기
                                        //executeQuery 도 실행 결과를  전부 가져오는것
                                        //executeUpdate 는 insert, delete, update 명령을 수행했을 때 sql로 명령된 결과 칼럼을 반환
            while (rs.next()){
                System.out.print(rs.getInt(1)+" ");   //get 으로 가져오는건 index 순서도 되고
                System.out.print(rs.getString("title")+" "); // 컬럼 명으로도 가져올 수 있다.
                System.out.print(rs.getString(3)+"\n");
            }

        } catch (Exception e) {
            System.out.println("DB 접속주소나 아이디/비번 혹은 sql 명령문을 확인해주세요!");
        }finally {
            if (rs !=null) try { rs.close();}catch (Exception ex){}//conn 이 접속중이라면 close 닫아라
            if (pstmt !=null) try { conn.close();}catch (Exception ex){} // pstmt가 접속중이면 close 닫아라
            if (conn !=null) try { conn.close();}catch (Exception ex){}
        }







    }
}

class Book {
    private int bookno;
    private String title;
    private String writer;
    private int price;
    private String regdate;

    public Book() {
    }

    public Book(int bookno, String title, String writer, int price, String regdate) {
        this.bookno = bookno;
        this.title = title;
        this.writer = writer;
        this.price = price;
        this.regdate = regdate;
    }

    public int getBookno() {
        return bookno;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public int getPrice() {
        return price;
    }

    public String getRegdate() {
        return regdate;
    }


    public void setBookno(int bookno) {
        this.bookno = bookno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

}