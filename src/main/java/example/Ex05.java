package example;

import java.io.IOException;
import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        //Q27 LeapYear
        //특정년도에 윤년여부를 출력
        // 조건 1 : 4로 나눠 떨어지고 , 100으로는 나눠 떨어지지않으면 윤년
        // 조건 2 : 400으로 나눠 떨어지면 윤년
        
        //ex) 1988,2000, 2008, 2020 : 윤년
        // 1900, 2100, 2022 : 평년
        Scanner sc=new Scanner(System.in);
        System.out.print("년도는?");
        int year = sc.nextInt();
        if ((year%4==0 && year %100 !=0)||(year%400 ==0)) {
            System.out.println("윤년입니다!");

        }else {
            System.out.println("평년입니다!");
        }

        //16. 고객에게 돌려줘야 하는 잔돈을 화폐단위로 계산하는 프로그램을 작성하시오.
        // 즉, 잔돈을 돌려주기 위해 10원, 50원, 100원, 500원, 1000원, 5000원, 10000원, 50000원 등이 몇 개 필요한지 계산하는 것이다.
        // (Charge)

        System.out.println("지불할 가격을 적어주세요 - 원은 생략");
        int charge= sc.nextInt();

        int w50000=0;
        int w10000=0;
        int w5000=0;
        int w1000=0;
        int w500=0;
        int w100=0;
        int w50=0;
        int w10=0;

        w50000= charge/50000;
        charge %=50000;
        w10000= charge/10000;
        charge %=10000;
        w5000= charge/5000;
        charge %=5000;
        w1000= charge/1000;
        charge %=1000;
        w500= charge/500;
        charge %=500;
        w100= charge/100;
        charge %=100;
        w50= charge/50;
        charge %=50;


        System.out.printf("지불 금액은 50000월권 : %d 장 \n",w50000);
        System.out.printf("지불 금액은 10000월권 : %d 장 \n",w10000);
        System.out.printf("지불 금액은 5000월권 : %d 장 \n",w5000);
        System.out.printf("지불 금액은 1000월권 : %d 장 \n",w1000);
        System.out.printf("지불 금액은 500월권 : %d 장 \n",w500);
        System.out.printf("지불 금액은 100월권 : %d 장 \n",w100);
        System.out.printf("지불 금액은 50월권 : %d 장 \n",w50);

        //26. Tax
        // 미혼인 경우 , 연봉 3000미만 : 10% , 3000이상 : 25%
        // 결혼인 경우 , 연봉 6000미만 : 15% , 6000이상 : 35%
        System.out.println("결혼 여부는? (y/n)");
        String isMarried = sc.next();
        System.out.println("연봉은?");
        int salary = sc.nextInt();
        double tax=0;

        switch (isMarried){
            case "y": case "Y":
                if (salary < 6000){
                    tax = salary * 0.15;
                }else {
                    tax = salary * 0.35;
                }
                break;

            case "n": case "N":
                if (salary < 3000){
                    tax = salary * 0.1;
                }else {
                    tax=salary * 0.25;
                }
                break;
        }
        String fmt = "결혼여부 : %s, 연봉: %d , 세금: %.1f \n";
        System.out.printf(fmt,isMarried,salary,tax);


        //28. GuGuDan
        System.out.println("1-9단중 출력할 단을 선택해주세요 1~9 숫자만");
        while (true){
            int gugudan=sc.nextInt();
            if (gugudan>=1 && gugudan<10){
                for (int i=0 ; i<10; i++ ){
                    int answer=i*gugudan;
                    System.out.printf("%d*%d=%d \n",i,gugudan,answer);
                }
                break;
            }else {
                System.out.println("잘못입력하셧습니다. 1~9 사이의 숫자만 다시 입력해주세요");
            }
        }


        //29. UpperCase
        //사용자로부터 소문자를 입력 받아 대문자로 출력하는 프로그램을 작성해보세요.
        // 단, 소문자 이외의 숫자나 문자를 입력 받으면 “잘못 입력하셨습니다!!”라는 메시지를 출력하도록 합니다.
        //System.in.read() : 키보드로부터 문자 하나를 입력받음
        //단 , 입력받은 문자는 ASCII 코드값( 십진수)이기 때문에 char 형으로의 변환 필요!

        //ex) A의 ASCII 코드값 : 65
        //    a의 ASCII 코드값 : 97
        //   소문자와 대문자의 차이 : 32 만큼 남  그래서 소문자에서 대문자를 32만큼 빼보자

        /*System.out.println("대문자로 변경할 소문자를 적어주세요");
        String alpabet = sc.next();*/


        System.out.println("소문자는?");
        char lwch = (char)System.in.read();   // read는 처음 쓰면 빨간 줄로 안됨 - 마우스 가저다 대면 예외처리 시그니처 추가
        char upch = (char)(lwch-32);
        System.out.printf("입력한 %c의 대문자는 %c 입니다. \n",lwch,upch);   //%c 는 문자  케릭터



        //33. cardcheck
        //임의의 숫자 6자리를 입력하면
        //신용카드의 종류와 은행 정보 출력
        System.out.println("카드번호는?");
        String num = sc.next();

        String cdno1 = num.charAt(0)+"";
        String cdno2 = cdno1 +num.charAt(1);

        String result="";
        if (cdno1.equals("4")){
            result += "비자카드";
            switch (num){
                case "404825": result += "비씨카드"; break;
                case "438676": result += "신한카드"; break;
                case "457973": result += "비씨카드"; break;
            }

        }else if (cdno1.equals("5")){
            result += "마스터카드/";
            switch (num){
                case "515594": result += "비씨카드"; break;
                case "524353": result += "외환카드"; break;
                case "540926": result += "국민은행"; break;
            }

        }else if (cdno2.equals("35")){
            result += "JCB카드/";
            switch (num){
                case "356317": result += "NH농협카드"; break;
                case "356901": result += "신한카드"; break;
                case "356912": result += "KB국민카드"; break;
            }

        }else {
            result = "잘못된 카드번호 입니다.";

        }
        System.out.println(result);




    }
}
