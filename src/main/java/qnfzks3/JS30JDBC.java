package qnfzks3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//테이블 정보 가져오기
//작업 순서 - 마리아 디비 연결- 드라이버 사용 - 호스트, 아이디,비밀번호 등 적고 내가 얻고 싶은 정보를 sql문으로 적어주기
//psvm 해서 시작! - 항상 각 맥락마다 try - Exception 을 사용 - 컬렉션 생성하고 ,jdbc 드라이버에 접속한다.
//다음으로는 마리아 디비에 접속하며 prepareStatement함수로 sql문을 실행한다.


public class JS30JDBC {
    private static String DRV = "org.mariadb.jdbc.Driver";
    private static String URL = "jdbc:mariadb://fullstacks.cdxqxdvfxgja.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";//"jdbc:mariadb://아마존 주소:3306/fullstacks"
    private static String USR = "admin";
    private static String PWD = "fullstack_2023";

    private static String deleteBookSQL = "delete from newbooks where bookno=  ?  "; //sql 에서 ? 는 매개변수를 의미한다.
                                                                            // 여기서 sql에서는 매개변수를 placeholder라고한다.

    public static void main(String[] args) {
        //newbooks 테이블에서 입력받은 도서번호를 이용해서 레코드 삭제
        List<Book> bookdata =new ArrayList<>();

        //삭제할 도서번호를 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 도서번호는?");
        int bookno = sc.nextInt();


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
            pstmt = conn.prepareStatement(deleteBookSQL);    //SQL 문을 실행할 수 있도록 해주는 함수 prepareStatement

            pstmt.setInt(1,bookno); // 위에 ? 안에 매개변수를 의미한다. --pstmt가 selectBookSQL를 가져온거니까
            //출력 부분이니까 set   ,  문자형이니까 String

            int cnt = pstmt.executeUpdate(); //
            System.out.println("데이터 삭제확인 : "+cnt);




        } catch (Exception e) {
            System.out.println("DB 접속주소나 아이디/비번 혹은 sql 명령문을 확인해주세요!");
        }finally {
            /*if (pstmt !=null) try { conn.close();}catch (Exception ex){} // pstmt가 접속중이면 close 닫아라
            if (conn !=null) try { conn.close();}catch (Exception ex){}*/
            JS32JDBCUtil.closeConn(null,pstmt,conn); // 특정 객체가 없어 안쓸때는 안에 null을 사용한다.
        }


    }
}

