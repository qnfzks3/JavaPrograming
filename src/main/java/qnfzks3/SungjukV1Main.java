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
        //SungJukVO 를 만든다. - 우리가 원하는 변수들을 만들어서 캡슐화 해준다.

        // 중요!) 6. 이제 서비스로 switch 화면으로 와서 switch에 해당 기능들을 넣어준다. 기능 기본 5개
        // 1. 성적 데이터 추가  함수 만들기=> new SungJuk();
        //new SungJuk 데이터 -> 스케너로 값을 받아서(국어 영어 수학) 이 값들을  SungJukVO 클래스의 매개변수로 생성해준다.
        // 그 이후에 computerSungJuk()로 토탈 평균 등등 을 만들고 성적 처리 함수를 만든다. -
        // 그 후에 이 성적 데이터를 처리해서 배열에 저장해준다. sjs[idx++] =sj          ->idx 는 클래스 처음으로가서 int로 선언함
        // 여담)- 배열안에 들어간 데이터들 보고싶다면 디버그(오른쪽 위 빨간버튼누르고)로 보고싶은 함수 안 찍고 (실행해 값넣은거 f8누르면 데이터 볼수있다.)
        // 다음 - 성적 리스트 조회 (이름, 국어 , 영어, 수학)  - 스위치 2번 readSungJuk() 함수 만들기
        // for 사용해서 성적 출력  - 그런데 여기서 데이터가 안들어갈때가 있는데 - 성적 데이터가 비어있으면 오류가 출력되니깐 - 성적 데이터가 없으면 출력되지 않도록한다.
        //  if(sj != null)



        SungJukV1Service sjsrv = new SungJukV1Service();

        while (true) {
            String menu = sjsrv.displayMenu();

            sjsrv.processMenu(menu);
        }
    }

}
