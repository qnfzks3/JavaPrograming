package qnfzks3;

public class SungjukV1Main {
    public static void main(String[] args) {
        //성적 처리프로그램 v1
        //배열과 클래스를 이용해서 성적을 입력하면 총점, 평균 , 학점을 계산함
        //입력가능한 학생 성적 데이터는 최대 10명 까지
        //SungJukV1Main , SungJukVO , SungJukV1Service
        //1.성적 데이터 입력
        //2.성적 데이터 조회 (이름, 국어,영어,수학)
        //3.성적데이터 상세조회 (모두)
        //4.성적데이터 수정
        //5.성적데이터 삭제
        //0.프로그램 종료
        //service 클래스에  서비스 할 내용들을 적은 후 이제 입력 함수를 만들어서 입력 된 값들 함수 만들고 그 걸 매인에 넣어서 사용해준다.
        //순서 - 1. 매인 자바 파일 생성  2. 서비스 자바 파일 생성 
        // 3. 성적 서비스 기능을 만들어준다 - private Scanner sc = null; 부터 만듬 - private이라 한번에 안씀 private SungJukVO[] sjs =null;
        // 생성자 생성해준다. - 생성자에다가는 스케너를 적어주고  성적 new SungJukVO [10] 적어줌 - 시작
        //4.성적 프로그램 메뉴 만들기 public String displayMenu()
        // StringBuilder sb= new StringBuilder(); 이건 뭔지 다음에 챗봇으로 알아보자
        // 내용 적기 1. 2. 3. 4. 5. 0. 이렇게  - sout으로 보여주기
        //5. 매인으로 가서 성적 클래스 사용 선언 SungJukV1Service sjsrv = new SungJukV1Service();
        // sjsrv.displayMenu() 선언햇으니 클래스안에 함수 꺼내서 사용  - while로 무한 반복으로 사용
        //sjsrv.processMenu() 사용 -- 스위치 만들어주는 함수 - 우리가 적은 숫자를 스위치로 받아서 작동시키기 위한 함수만들기
        // 서비스 함수에는 메뉴 출력하는 함수  , 매뉴를 보고 유저가 한 작동에 대한 정보를 출력하도록 하는 함수 ,
        
        
        




    }
}
