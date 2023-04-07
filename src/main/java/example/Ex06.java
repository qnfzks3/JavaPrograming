package example;

import java.util.Random;
import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //25.  다음 조건을 만족하는 복권 발행 프로그램을 작성하세요. (Lotto)
        // 가 . 사용자로부터 복권 숫자 3자리를 입력 받으시오.
        // 나 . 변수에 임의의 복권 숫자 3자리를 초기화 합니다.
        // 다 . 사용자가 입력한 복권 숫자가 모두 일치: 상금 1백만 지급
        // 라 . 일치하지 않는 경우 : "아쉽지만, 다음 기회를!"라고 출력
        //  완벽한 로또 만들기!

        int n= 6; //로또 번호의 개수 지정
        int[] Lottos=new int[n];
        Random rnd= new Random();  // 난수 생성 정의
        int key=rnd.nextInt(44)+1;  // 난수 범위 지정  - 1 부터 999까지
        //String lottokey =String.valueOf(key);
        //nextInt(경게값): 0~ 경계값-1 사이의 정수 난수 출력
        //1~9 사이 임의의 정수 3개를 난수로 생성
        //lottokey +=rnd.nextInt(9)+1;
        int[] winnum=new int[n];
        for (int i = 0; i < winnum.length ; i++) {
            winnum[i]=key;
            key=rnd.nextInt(44)+1;
        }
        int duple=0;
        int Count=0;
        while (true){ // 복권 기능 수행 
            for (int i = 0; i < winnum.length; i++) {
                System.out.printf("%d번째 복권 번호를 기입하세요!!(1~45)\n",i+1);
                while (true){
                    int Lottofirst= sc.nextInt();  // 복권 값을 입력 받음

                    if (Lottofirst>=1 && Lottofirst<=45 ){
                        Lottos[i]=Lottofirst;
                        System.out.printf("입력하신 %d번째 숫자는 %d입니다. \n",i+1,Lottofirst);
                        break;
                    }else System.out.println("잘못기입하셧습니다.중복되지 않는 1~45 사이 숫자로 기입해주세요");
                }
            }
            for (int j = 0; j < winnum.length; j++) {
                for (int k = 0; k < winnum.length; k++) {
                    if (Lottos[j]==Lottos[k]){
                        duple++;
                    }
                }
            }
            if (duple>winnum.length){
                System.out.println("추첨번호중 중복되는 번호가 있습니다. 다시 시도해주세요");
                duple=0;
            }else break;
        }//while 끝
        System.out.println("내 복권 번호 : ");
        for (int i = 0; i < winnum.length; i++) {
            System.out.printf(" %d ,",Lottos[i]);
        }
        System.out.println("입니다.\n");

        System.out.println("이번주 추첨 번호:");
        for (int i = 0; i < winnum.length; i++) {
            System.out.printf(" %d ,",winnum[i]);
        }
        System.out.println("입니다. \n");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Lottos[i]==winnum[j]){
                    Count+=1;
                }
            }
        }
        if(Count>=3){
            System.out.println("축하합니다. 당첨 되셨습니다.");
        }else {
            System.out.println("낙첨되었습니다. 아쉽지만 다음 기회에");
        }


        /*
        보통 이렇게 하면 되지만 배열 안에 속성이 커질수록 문제가 생긴다 또, Lottos==winnum 는 배열의 참조값이 같은지를 비교한거라 작동 안한다.
        - 이배열이 int배열로 같음? 이런느낌
        if (Lottos[0]==winnum[0]&&Lottos[1]==winnum[1]&&Lottos[2]==winnum[2]){
            System.out.println("축하합니다. 당첨 되셨습니다.");
        }else {
            System.out.println("낙첨 되셨습니다. 아쉽지만 다음 기회에");
        }
        */

        //30. 다음 조건에 따라 숫자 맞추기 프로그램을 작성해보세요. (CatchNumber)
        //가. 사용자로부터 1 - 100사이의 숫자를 입력 받으세요 (num1)
        //나. 변수에 임의의 숫자 3자리를 초기화합니다 (num2)
        //다.  num1이 num2보다 크면 “추측한 숫자가 큽니다”라고 출력하세요
        //라.  num1이 num2보다 작으면 “추측한 숫자가 작습니다”라고 출력하세요
        //마.  num1과 num2가 같으면 “빙고! 숫자를 맞췄습니다”라고 출력하고 종료




        //32. 키보드로 정수를 하나 입력받아 다음 조건에 따라 결과를 출력하는 프로그램을 작성하시오. (CheckNumber)
        //가.   입력한 값이 10000 보다 작으면 “10000미만” 이라 출력
        //나.   입력한 값이 10000 이상 20000미만 이면 “10000~20000” 이라 출력
        //다.   입력한 값이 20000 이상 30000미만 이면 “20000~30000” 이라 출력
        //라.   입력한 값이 그 이외 값이면 “범위 밖 값” 이라 출력



        //48.  지금 현재 수지의 통장잔액이 25,000원이다.
        // 은행이자가 연 6%라 가정할 때,
        // 몇 년이 지나야 통장잔액이 지금의 2배를 넘는지 알아보는 프로그램을  아래 그림을 참고하여 작성하여라.
        // (ComputeInvestment)



    }
}
