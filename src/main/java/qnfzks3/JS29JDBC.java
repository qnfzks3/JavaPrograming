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


public class JS29JDBC {
    private static String DRV = "org.mariadb.jdbc.Driver";
    private static String URL = "jdbc:mariadb://fullstacks.cdxqxdvfxgja.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";//"jdbc:mariadb://아마존 주소:3306/fullstacks"
    private static String USR = "admin";
    private static String PWD = "fullstack_2023";

    private static String selectBookSQL = "select * from newbooks where title like ? order by bookno desc "; //sql 에서 ? 는 매개변수를 의미한다.
                                                                            // 여기서 sql에서는 매개변수를 placeholder라고한다.

    public static void main(String[] args) { //static 정적- static으로 생성된 건 프로그램 실행전 미리 다 만들고 필요할 때 가져다 쓸수있도록 한다.
        //newbooks 테이블에서 도서명에 'IT CookBook'이 포함된 레코드 조회
        List<Book> bookdata =new ArrayList<>();

        //검색할 도서명을 입력 받음
        Scanner sc = new Scanner(System.in);
        System.out.println("조회하고 싶은 도서명은?");
        String findbook = sc.nextLine();  // nextLine 으로 받아야한다    - 검색할 도서명 직접 씀


        try {
            Class.forName(DRV); // 연동된 클래스들을 쓰기위해 JDBC 관련 작업들을 수행 - 드라이버 접속
        } catch (ClassNotFoundException e) {
            System.out.println(" db접속 드라이버 오류");
        }


        Connection conn=null; //연결
        PreparedStatement pstmt = null; //sql문실행
        ResultSet rs =null;  //ResultSet 이건 뭘까?   ResultSet는 executeQuery()와 같이 사용한다. -받아온 sql문 값을 받아옴
                             //내가 sql문으로 얻어온 정보를 ResultSet를 사용하여 rs에 저장
        


        try {
            //데이터베이스 접속
            conn = DriverManager.getConnection(URL,USR,PWD);  //데이터베이스 서버에 연결 할수있도록하는 드라이버매니저  함수
            //실행한 sql문 생성
            pstmt = conn.prepareStatement(selectBookSQL);    //SQL 문을 실행할 수 있도록 해주는 함수 prepareStatement

            pstmt.setString(1,"%"+findbook+"%"); // 위에 ? 안에 매개변수를 의미한다. --pstmt가 selectBookSQL를 가져온거니까
            //출력 부분이니까 set   ,  문자형이니까 String

            //SQL문 실행후 결과 확인
            rs = pstmt.executeQuery(); // DML 실행 시 사용 - 실행 한 결과 값을 cnt에 넣어줌   DML이 뭔지도 찾아보기
                                        //executeQuery 도 실행 결과를  전부 가져오는것 - 조회
                                        //executeUpdate 는 insert, delete, update 명령을 수행했을 때 sql로 명령된 결과 칼럼을 반환
            while (rs.next()){ //rs에 있는 테이블 각행씩 반복 더이상 행이 없을때까지 true 반환
                Book book = new Book(rs.getInt(1), //당연하지만 클래스로 정의한 매개변수들을 맞게 안넣으면 안됨
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
                bookdata.add(book); // 북데이터에 북을 넣는 함수  - 북데이터는 컬렉션으로 위에 정의했음 - 데이터 추가


                System.out.print(rs.getInt(1)+" ");//get 으로 가져오는건 index 순서도 되고-첫번째 칼럼을 출력해줘 rs에있는(sql문으로 가져온 데이터)
                System.out.print(rs.getString("title")+" "); // 컬럼 명으로도 가져올 수 있다.
                System.out.print(rs.getString(3)+"\n");
            }

        } catch (Exception e) {
            System.out.println("DB 접속주소나 아이디/비번 혹은 sql 명령문을 확인해주세요!");
        }finally {
            JS32JDBCUtil.closeConn(rs,pstmt,conn);    //JS32JDBCUtil 에서 서버를 close 하는 소스를 져와서 닫자 -- 중복되는것
        }
        //도서정보 출력
        for(Book b:bookdata){ //컬렉션 bookdata 안에서 b를 출력
            System.out.println(b);
        }  //출력은 여기서 출력함 while (rs.next()){  위에 while 안에 bookdata 안에 넣은 데이터들을 출력

    }
}

