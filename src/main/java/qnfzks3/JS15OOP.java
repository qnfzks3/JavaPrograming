package qnfzks3;

public class JS15OOP {
    // 클래스 종류
    // Service : 비지니스 로직 처리를 담당하는 클래스
    // VO로 저장된 데이터를 DAO로 넘기기 전에
    // 처리해야 하는 일반적인 작업을 기능으로 구현한 클래스
    // 메서드만 저장하기 위해 생성하는 클래스

    // 일반적인 프로그래밍 작성 흐름
    // J2EE 개발에 최적화된 방식
    // VO - Service - DAO - DB    VO로 데이터를 입력  -
    //                             Service에서 학점, 총점,평균학점 등 처리 후 -
    //                             DAO(Data Access Object) 데이터베이스에 위에서 만든 데이터들과 접근(Access) 할 수 있도록 연결 후 -
    //                             데이터베이스로 저장

    public static void main(String[] args) {
        //회원처리 기능이
        MemberService msrv =new MemberService();
        Member m =new Member("홍길동","010","1234","5678","abc123","xyz987.com");

        msrv.newMember(m);
        msrv.readMember();
        msrv.readOneMember("홍길동");
        msrv.modifyMember("홍길동");
        msrv.removeMember("홍길동");

    }
}

class Member{
    private String name;
    private String hp1;   // 지역번호
    private String hp2;  // 국번
    private String hp3;  // 국번
    private String email1;
    private String email2;


    public Member(String name,String hp1,String hp2,String hp3,String email1,String email2){

    }
}

//회원정보와 관련된 CRUD 기능 구현
class MemberService{  // Service를 만들 때는 반드시 아래 5개를 적어주는 규칙으로 대부분의 회사에서 정한다.


    //회원 생성 : new ~
    public boolean newMember(Member mvo){ //위에  Member 클래스의 이름을 반드시 따서 newMember로 지정해주자!
        return false;
    }

    //회원 조회R : read~
    public Member[] readMember(){  // 배열로 만들어보자
        System.out.println("회원정보 리스트 조회");
        return null;
    }

    //회원 조회R : readOne~
    public Member readOneMember(String name){
        System.out.println("회원정보 리스트 조회");
        return null;
    }

    //회원 수정U : modify~
    public boolean modifyMember(String name){
        System.out.println("회원정보 수정");
        return false;
    }

    //회원 삭제D: remove~
    public boolean removeMember(String name){
        System.out.println("회원정보 삭제");
        return false;
    }







}











