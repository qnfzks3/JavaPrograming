package qnfzks3;

public class JS06Loop {
    public static void main(String[] args) {
        // 반복문
        // 일정횟수만큼 어떤 코드(들)을 반복해서 실행하는 제어문
        // 반복적으로 실행하는 동작을 loop이라고 함
        // 자바에서는 기본적으로 for , while , do-while등이 지원되고 , for-in 등이 있음

        //for문
        // 1~5까지 정수 출력
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");

        // 1~5까지 정수 출력
        for (int i=1; i<=5;i++ ){
            System.out.println(i);
        }
        System.out.println("------------");

        // 1부터 100사이 짝수 출력 v1
        for (int i=2;i<=100;i++) {
            if (i%2==0){
                System.out.println(i);
            }
        }

        //1부터 100사이 짝수 출력 v2

        /*
        for (int i=0; i<=50;i++){
            int m=i*2;
            System.out.println(m);
        }
        */
        for (int i=2; i<=100; i+=2){
            System.out.println(i);
        }

        System.out.println("---------");


        // 1 ~ 100까지의 정수의 총합 출력 v1
        int sum =0;
        for (int i=0;i<=100;i++){
            sum+=i;
            if (i==100){
                System.out.println(sum);
            }
        }
        // 1 ~ 100까지의 정수의 총합 출력 v2 가우스 덧셈
        //(시작 숫자 + 종료 숫자 x (종료숫자 - 시작숫자 +1)) /2
        int stnum=1,ednum=100;

        sum=stnum+ednum *((ednum-stnum+1)/2);
        System.out.println(sum);









    }
}
