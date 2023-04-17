package qnfzks3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//테이블 정보 가져오기
//작업 순서 - 마리아 디비 연결- 드라이버 사용 - 호스트, 아이디,비밀번호 등 적고 내가 얻고 싶은 정보를 sql문으로 적어주기
//psvm 해서 시작! - 항상 각 맥락마다 try - Exception 을 사용 - 컬렉션 생성하고 ,jdbc 드라이버에 접속한다.
//다음으로는 마리아 디비에 접속하며 prepareStatement함수로 sql문을 실행한다.


public class JS31JDBC {
    private static final String DRV = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mariadb://fullstacks.cdxqxdvfxgja.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";//"jdbc:mariadb://아마존 주소:3306/fullstacks"
    private static final String USR = "admin";
    private static final String PWD = "fullstack_2023";

    private static final String updateBookSQL = "update newbooks set title =?, writer=  ?,price=? where bookno=?  "; //sql 에서 ? 는 매개변수를 의미한다.
                                                                            // 여기서 sql에서는 매개변수를 placeholder라고한다.

    public static void main(String[] args) {
        //newbooks 테이블에서 입력받은 도서정보(도서번호, 도서명, 저자,가격)를 이용해서 레코드 수정
        
        //수정할 도서번호를 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.println("수정할 도서번호는?");
        int bookno = sc.nextInt();
        System.out.println("수정할 도서명은?");
        String bkname= sc.next();
        System.out.println("수정할 저자는?");
        String author =sc.next();
        System.out.println("수정할 가격은?");
        int price =sc.nextInt();


        try {
            Class.forName(DRV); // 연동된 클래스들을 쓰기위해 JDBC 관련 작업들을 수행 - 드라이버 접속
        } catch (ClassNotFoundException e) {
            System.out.println(" db접속 드라이버 오류");
        }


        Connection conn=null; //연결
        PreparedStatement pstmt = null; //sql문실행


        try {
            //데이터베이스 접속
            conn = DriverManager.getConnection(URL,USR,PWD);  //데이터베이스 서버에 연결 할수있도록하는 드라이버매니저  함수
            //실행한 sql문 생성
            pstmt = conn.prepareStatement(updateBookSQL);    //SQL 문을 실행할 수 있도록 해주는 함수 prepareStatement

            pstmt.setString(1,bkname);
            pstmt.setString(2,author);
            pstmt.setInt(3,price);
            pstmt.setInt(4,bookno);

            int cnt = pstmt.executeUpdate();
            System.out.println("데이터 수정확인 : " + cnt);



        } catch (Exception e) {
            System.out.println("DB 접속주소나 아이디/비번 혹은 sql 명령문을 확인해주세요!");
        }finally {
            /*if (pstmt !=null) try { conn.close();}catch (Exception ex){} // pstmt가 접속중이면 close 닫아라
            if (conn !=null) try { conn.close();}catch (Exception ex){}*/
            JS32JDBCUtil.closeConn(null,pstmt,conn); //위에처럼 일일이 매파일마다 이렇게 하지않고 특정 객체가 없어 안쓸때는 안에 null을 사용한다.
        }


    }
}

