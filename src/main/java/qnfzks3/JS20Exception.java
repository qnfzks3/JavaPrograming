package qnfzks3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JS20Exception {
    // 오류: 예외exception와 에러error
    // 자바프로그램 작성시 문법에 맞지 않게 코드를 작성하면 컴파일 오류가 발생함
    // 또한, 코드가 제대로 작성되었다 하더라도 실행중에 예상치 못한 상황으로 실행 오류가 발생할 수 있음
    // 이처럼 프로그램 실행중에 예상치 못한 상황으로 프로그램이 영향을 받는 것을 오류와 예외로 구분

    //일반적으로 에러error는 시스템 단계에서 프로그램에 심각한 문제를
    // 야기해서 실행중인 프로그램을 강제 중단시킴
    // -> 네트워크 상 접속 오류, 메모리 부족
    // 이러한 에러는 개발자가 처리할 수 없음

    // 반면, 예외는 오류와 마찬가지로 실행중인 프로그램을 중단시키지만
    // 발생할 수 있는 상황을 미리 예측하여 코드를 통해
    // 프로그램 실행 중단을 방지할수 있음

    // - 잘 쓰이진 않지만 finally 는 err가 나더라도 반드시 실행해야할 때 쓰인다.
    public static void main(String[] args) {
        //예외처리전 1
        System.out.println("프로그램 시작 1");
        System.out.println("프로그램 끝1");
        System.out.println("-----------------------------");

        //예외처리전 2
        System.out.println("프로그램 시작2");
        int a =10, b=20;
        int c= a+b;
        System.out.println(c);
        System.out.println("프로그램 끝2");
        System.out.println("-----------------------------");

        /*//예외처리전 3-- 오류 발생시켜보자
        System.out.println("프로그램 시작3");
        int d = 10, e=0;
        int f= d/e; //에러 발생 그래서 아래는 실행이 안된다. 10나누기0  --실행중단  이 경우 우리 예외처리를 사용한다.
        System.out.println(f);  
        System.out.println("프로그램 끝3");
        System.out.println("-----------------------------");*/

        //예외처리 키워드  구문1.
        //try ~ catch

        //예외처리 구문1
        //try
        //           예외발생 가능성이 있는 코드
        //catch(예외 종류)
        //           예외처리 핸들러

        //예외처리전 4a
        System.out.println("프로그램 시작4");
        int d = 10, e=0;
        try {
            int f= d/e; //에러 발생
            System.out.println(f);

        }catch (Exception ex){  //Exception ex 모든 사항의 error를 감지 - 감지하면 트루 - 아래 실행 
            System.out.println(">> 예외발생!!<<");
            System.out.println(ex.getMessage());
        }
        System.out.println("프로그램 끝4");
        System.out.println("-----------------------------");
        
        //ex) 1~9사이 정수만 입력받아 화면에 출력하는 코드를 작성하세요
        // 단 , 예외처리 코드를 이용해서 문자를 입력했을 때에는 "1 ~ 9 사이 정수만 입력 가능합니다" 라고 출력 하세요
        // - > Scanner , nextInt 사용

        
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1 ~ 9 사이 정수를 적어주세요");


            try {
                int num = sc.nextInt();
                if(0<num && 9>=num) {
                    System.out.printf("%d을 입력하셨습니다.\n", num);
                    break;
                }
            }catch (Exception ex){  //그냥 이거 쓰자 이게 모든 경우라서 이게 좋음
                System.out.println("1 ~ 9 사이 숫자만 입력해주세요");
            }
        }

        //예외처리전 4b
        System.out.println("프로그램 시작4");
        try {
            int f= d/e; //에러 발생
            System.out.println(f);

        }catch (ArithmeticException ex){  // 특정 상황에 맞는 구체적 예외 - 수학적인 연산 에러  5/0 과 같은
            System.out.println(">> 나누기 연산시 0은 사용 불가!<<");
            System.out.println(ex.getMessage());
        }
        System.out.println("프로그램 끝4");
        System.out.println("-----------------------------");


        //ex) 1~9사이 정수만 입력받아 화면에 출력하는 코드를 작성하세요
        // 코드를 작성하세요 (구체적 예외 지정)


        while (true){
            System.out.println("1 ~ 9 사이 정수를 적어주세요");

            try {
                int num = sc.nextInt();
                if(0<num && 9>=num) {
                    System.out.printf("%d을 입력하셨습니다.\n", num);
                    break;
                }
            }catch (InputMismatchException ex){  // 데이터 타입등의 에러 인트형인데 스트링으로 적으면
                System.out.println("1 ~ 9 사이 숫자만 입력해주세요");
            }
        }
        
        // 학생 3명의 이름을 입력받아 화면에 출력하는 코드를 작성
        // 단, 학생수를 초과해서 입력 했을 때 발생하는 예외도 처리함
        String[] names = new String[3];
        try {
            for (int i = 0; i <= names.length; i++) {
                System.out.println("이름은?");
                names[i] = sc.next();
            }
        }catch (ArrayIndexOutOfBoundsException EX){
            System.out.println("초과입력은 금지되어 있습니다.");  //학생수는 3명 배열도 3개의 데이터가 들어가 지지만 4개를 넣으면
        }

        // 예외종류
        // 검사형 예외 : checked exception (런타임 예외)  
        // 비검사형 예외 : unchecked exception(컴파일타임 예외)  - 컴파일 시점에 발생하는 예외

        // 비검사형 예외
        // 명시적인 예외처리를 강제하지 않음 - 개발자에 맡김
        // 예외발생 확인 시점은 실행시임
        // ArithmeticException
        // ArrayIndexOutOfBoundsException
        // InputMismatchException

        // 검사형 예외
        // 명시적인 예외처리를 강제함 (반드시!)
        // 예외발생 확인 시점은 컴파일시임
        // IOException
        // ClassNotFoundException
        //단, 검사형 예외를 피하고 싶으면 throws를 이용해서 예외처리를 외부로 떠넘김 - 비추 (직접 트라이 켓치로 작성하는게 낫다.)


        File f = new File("c:/Java/sungjuk.data"); // 이런 파일 존재하지 않을 때
        try {
            FileInputStream fis=new FileInputStream(f); 
        } catch (FileNotFoundException ex) { //throw 는 상위 메서드로 오류를 던짐 - 보통 이건 예외처리를 한곳에 모아서 하고싶을때 예외를 넘겨서 모아둠
            System.out.println("읽어들일 파일이 없어요");
        }
        
        //예외처리 5 
        //사용자 정의 예외처리  --개발자가 원하는 예외메세지 출력 가능
        // 사용자 정의 예외 클래스는 Exception 클래스를 상속해서 만들어야 함
        System.out.println("프로그램 시작5");
        try {
            try{
                int g= d/e; //에러 발생
                System.out.println(g);

            }catch (Exception ex){ // 예외 ex 를 만들었고 에러가 되면
                throw new ZeroDivideException("0으로 나눌 수 없습니다.");  // 상위로 던졌고 

            }
        }catch (Exception ex){  // throw로 상위로 던진 에러를 ex.getMessage로 넘기도록
            System.out.println(ex.getMessage());

        }
        System.out.println("프로그램 끝5");
        System.out.println("-----------------------------");
        
        


    }
}

//사용자 정의 예외 - 0으로 나눌려고 할 때 발생하는 예외에 대한 예외클래스
class ZeroDivideException extends Exception{
    public ZeroDivideException(String message) {
        super(message);
    }
}