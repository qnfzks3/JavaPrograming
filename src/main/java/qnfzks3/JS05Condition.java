package qnfzks3;

import java.util.Scanner;

public class JS05Condition {
    public static void main(String[] args){ // psvm 탭
        //제어문
        //프로그램의 실행 순서를 제어할 수 있는 문장
        //조건문, 반복문,분기문

        // 1. 조건문
        // 조건에 대한 만족 여부에 따라 실행할 코드를 결정하는 명령문
        // ex) 짝수 , 홀수 여부 출력
        int num =15;
        if(num%2==0){
            System.out.println("짝수입니다.");

        }else {
            System.out.println("홀수입니다.");
        }



        //ex) 오전 , 오후 구분
        String time = "09:47:15";
        
        //문자 추출 : charAt(위치)
        int hour = Integer.parseInt(time.charAt(0)+""+time.charAt(1));
        System.out.println(hour);

        if(hour>= 12){
            System.out.println("오후입니다.!");
        }else if (hour < 12){
            System.out.println("오전입니다!");

        }

        //ex) 투표 가능한 나이 구분
        System.out.println("당신의 나이를 입력하세요.");
        Scanner MyAge=new Scanner(System.in); //입력값을 받고
        int age=MyAge.nextInt(); // 입력된 숫자 입력값을 코드로 가져와서 age 변수에 넣어줌

        if (age >= 18){
            System.out.println("투표하실 자격이 있습니다.");
        }else {
            System.out.println("투표할 자격이 없습니다.");
        }
        
        //if ~ else 문
        //평균 점수가 60점 이상이면, 합격  ! 출력
        //평균점ㅅ가 60점 미만이면, 불합격 ! 출력
        System.out.println("점수는?");
        Scanner sc=new Scanner(System.in);                 //스케너는 한번 적어 놓으면 계속 사용 가능하다
        int jumsu=sc.nextInt();
        if (jumsu >= 60){
            System.out.println("합격!");
        }else {
            System.out.println("불합격!");
        }

        //ex) 아이디와 비밀번호를 이용해서
        //로그인 기능 구현하기
        String userid = "abc123";
        String passwd= "987xyz";

        System.out.println("아이디를 입력해주세요");
        String inputid=sc.next();
        System.out.println("비밀번호를 입력해주세요");
        String inputpw=sc.next();

        //String 형 변수 비교시 == 연산자는 대상의 주소값을 비교한다.
        //정수, 실수와는 달리 string은 참조자료형이기 때문에 
        // 따라서, 문자열 자체를 비교하시려면 equals()를 사용
        //if (userid == inputid && passwd == inputpw){
        if (userid.equals(inputid) && passwd.equals(inputpw)){ //이렇게 하면 , 값이 저장 되어있는 곳에 위치를 비교해버리게 된다 그렇기때문에 값으로 바꿔준다. if holse
            System.out.println("로그인 되었습니다.");
        }else{
            System.out.println("로그인 실패하였습니다.");

        }
        
        //중첩 조건문 - 가독성 저하로 비추!
        //if문 안에 도 다른 if 문 작성

        // 특정년도의 윤년여부를 출력 v2
        // 조건1 : 4로 나눠 떨어지고 윤년
        // 조건2 : 4로 나눠 떨어지고, 100으로도 나눠 떨어지면 평년
        // 조건3 : 400으로 나눠 떨어지면 윤년
        int year = 2020;

        if (year%4==0){                         //조건1
            if (year%100==0){                  //조건2
                System.out.println("평년!");
            }else {                           //조건 2b
                System.out.println("윤년!");
            }
        }else {
            if (year%400==0){               //조건3
                System.out.println("윤년!");
            }else {
                System.out.println("평년!");
            }
        }
        //다중 조건문
        //둘 이상의 조건에 대한 처리를 조건문
        //if ~  else if ~ else

        // 평균 점수에 따라 수우미양가 성적 결과 출력
        double avg = 76.4;
        String grd = "";  //성적결과
        if (avg >= 90) grd = "수";
        else if (avg >= 80) grd = "우";
        else if (avg >= 70) grd = "미";
        else if (avg >= 60) grd = "양";
        else grd = "가";
        System.out.printf("평균 : %.1f,성적 : %s \n", avg, grd); //소수점 첫째자리에서 끊고 %s 는 문자형으로 나타내어라
        // 버스 기본요금 부과하기 - 나이를 입력받음
        // 미취학 아동 (~7세) : 0원
        // 어린이 (8~13) : 450원
        // 청소년 (14~19) : 720원
        // 일반 (20~) : 1200원
        // 노인 (70~) : 0원




    }
}





