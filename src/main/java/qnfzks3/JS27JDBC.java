package qnfzks3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JS27JDBC {


    private static final String insertBookSQL = "insert into newbooks(title,writer,price) values (?,?,?)"; //sql 에서 ? 는 매개변수를 의미한다.
                                                                            // 여기서 sql에서는 매개변수를 placeholder라고한다.

    public static void main(String[] args) {
        //mariadb에 있는 newbooks 테이블에 도서정보 저장
        Scanner sc = new Scanner(System.in);

        System.out.println("도서명은?");
        String bkname= sc.next();
        System.out.println("저자는?");
        String author =sc.next();
        System.out.println("가격은?");
        int price =sc.nextInt();





        Connection conn=null;  //연결
        PreparedStatement pstmt = null; //연결 객체


        try {
            //데이터베이스 접속
            /*conn = DriverManager.getConnection(URL,USR,PWD);  //데이터베이스 서버 연결*/
            conn=JS32JDBCUtil.makeConn();
            //실행한 sql문 생성
            pstmt = conn.prepareStatement(insertBookSQL);
            //실행할 sql문 매개변수-(placeholder)에 값 전달
            pstmt.setString(1,bkname);
            pstmt.setString(2,author);
            pstmt.setInt(3,price);   // 파라메타 1,2,3 은 위에서 인설트로 ?,?,? 자리에 들어갈 내용들- 데이터를 전달 

            //SQL문 실행후 결과 확인
            int cnt = pstmt.executeUpdate(); // DML 실행 시 사용
                                            // -executeUpdate()는 INSERT, UPDATE, DELETE와 같은 DML(Data Manipulation Language) 쿼리문을 실행할 때 사용됩니다.
                                            // 이 메서드가 반환하는 값은 실행된 쿼리문으로 인해 영향을 받은 레코드(row)의 수입니다.
                                            //간단하게 테이블을 수정(update하면 사용)

            System.out.println("데이터 입력 확인 : "+ cnt);


            if(!conn.isClosed())
                System.out.println("mariadb접속 성공 ");
        } catch (SQLException e) { //try부분에서 오류가 나면
            System.out.println("DB 접속주소나 아이디/비번, sql 명령문을 확인해주세요!");
        }finally {
            JS32JDBCUtil.closeConn(null,pstmt,conn); // 특정 객체가 없어 안쓸때는 안에 null을 사용한다.
        }







    }
}
