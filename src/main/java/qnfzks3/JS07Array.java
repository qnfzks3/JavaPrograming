package qnfzks3;

import java.util.ArrayList;
import java.util.Scanner;

public class JS07Array {
    // 배열의 길이는 .length로 계산
    // 배열의 변수는 자료형 뒤에 []를 사용하여 다른 변수와 같이 선언하는것도 가능함
    // 배열 내부의 변수는 인덱스 0부터 시작함
    // 지역변수 또는 메서드 매개변수로도 사용 가능함

    public static void main(String[] args) { //args - 배열 Array 를 뜻함
        Scanner sc= new Scanner(System.in);
        //배열
        // 동일한 자료형의 자료를 여러개 저장하기 위한 자료구조
        // 데이터의 입력 순서 기억, 중복자료 저장 가능
        // 점심메뉴 정의 v1
        String menu1 = "라면";
        String menu2 = "자장면";
        String menu3 = "탕수육";
        String menu4 = "민트초코";
        String menu5 = "떡볶이";
        System.out.printf("%s %s %s %s %s \n",menu1,menu2,menu3,menu4,menu5);

        //점심메뉴 정의v2
        //자료형 변수명[] 혹은  자료형[] 변수명   이렇게 2가지로 Array 정의 가능
        String menus[]={"라면","자장면","탕수육","민트초코","떡볶이"};
        //System.out.printf("%s %s %s %s %s",menus[0],menus[1],menus[2],menus[3],menus[4]);
        for (int i = 0; i < 5; i++) {
            System.out.printf(menus[i]+"\n");
        }
        System.out.println("");

        //점심메뉴 정의v3
        //배열 정의시 한번 설정한 크기는 변경불가능 자료구조임  - 배열의 크기는 고정
        //자료형[] 변수명 = new 자료형[크기]
        String[] menus2 = new String[5];
        
        menus2[0]="라면";
        menus2[1]="자장면";
        menus2[2]="탕수육";
        menus2[3]="민트초코";
        menus2[4]="떡볶이";
        //menus2[5]="라볶이"; 오류 발생 - 위에 길이를 5로 했기때문에

        for (int i = 0; i < menus2.length; i++) {   // length를 이용해서 배열의 크기를 나타낸다.
            System.out.printf(menus2[i]+"\n");
        }
        System.out.println("");

        //점심메뉴 정의 v4
        //동적배열 - ArrayList   -- collection 프레임워크의 한 요소 - 다음에 다시 설명
        //ArrayList<자료형> 변수명 = new ArrayList<>();   자바스크립트에선 Push로 추가했었다;
        ArrayList<String>menus3 = new ArrayList<>();    // 자바는 위에 array를 이렇게 정의해주고 add로 추가해주어야한다.

        menus3.add("라면");
        menus3.add("자장면");
        menus3.add("탕수육");
        menus3.add("민트초코");
        menus3.add("떡볶이");

        for (int i = 0; i < menus3.size(); i++) { //그리고 위처럼 배열을 선언했다면 값을 출력시킬때는 get을 사용해서 출력해주어야한다.
            System.out.println(menus3.get(i)+"");  // 위처럼 배열을 선언 했다면 길이를 쓸때 length가 아닌 size()를 사용해서 길이를 나타낸다.
        }

        //5개의 정수를 입력받아 총합, 평균을 구하고 결과 출력 v3
        System.out.println("정수를 입력해주세요 5번");
        int[] nums= new int[5];
        int sum= 0;
        double avg= 0;

        
        for (int i = 0; i < nums.length ; i++) {
            System.out.println(i+"번째 숫자는?");
            int inputnum=sc.nextInt();
            nums[i]=inputnum;
            sum+=nums[i];   //누적합
        }// 배열 만들기

        avg=sum/nums.length;
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d번째 숫자는 %d \n",i,nums[i]);
        }
        System.out.printf("\n %d %.1f",sum,avg);

        //5개의 정수를 입력받아 총합 , 평균을 구하고 결과 출력 v3b
        //배열에 저장된 값 출력 할 때 코드 개선 - JDK 1.5부터 추가된 enhanced for loop
        // for(변수 선언 : 대상 객체){
        //     변수출력
        // }

        for(int val : nums){
            System.out.printf("%d",val);
        }
        System.out.printf("\n %d %.1f \n",sum,avg);

        //ex) 성적 처리 프로그램 v3
        // 3명의 학생에 대해 이름, 국어, 영어, 수학을 입력받아 총점,평균,학점을 계산한 뒤 결과 출력
        // 단, 학점은 수우미양가 중 하나가 출력되어야 함

       /* String[][] students=new String[3][4];
        String[] score=new String[4];

        for (int i = 1; i < 4; i++) {
            for(int j=1; j<5;j++){

                System.out.println("학생 이름을 적어주세요");
                String name=sc.next();

                System.out.printf("%s학생의 국어 성적은? \n",name);
                int kor= sc.nextInt();

                System.out.printf("%s학생의 영어 성적은? \n",name);
                int eng=sc.nextInt();

                System.out.printf("%s학생의 수학 성적은? \n",name);
                int math=sc.nextInt();
                score[i]=name;
            }
        }*/
        //--------------------------------------------------------------

        String[] names=new String[3];
        int[] kor=new int[3];
        int[] eng=new int[3];
        int[] math=new int[3];


        int[] tots=new int[3];
        double[] avgs= new double[3];
        String[] grds=new String[3];

        for (int i=0; i<names.length; i++){
            System.out.println((i+1)+"번 학생 이름은?");
            names[i]=sc.next();
            System.out.println((i+1)+"번 학생의 국어 성적은?");
            kor[i]=sc.nextInt();
            System.out.println((i+1)+"번 학생의 영어 성적은?");
            eng[i]=sc.nextInt();
            System.out.println((i+1)+"번 학생의 수학 성적은?");
            math[i]=sc.nextInt();

            tots[i]=kor[i]+eng[i]+math[i];
            avgs[i]=tots[i]/3;
            //switch ((int)(avgs[i])/10){
            switch ((int)avgs[i]/10){
                case 10:
                case 9:grds[i]="수"; break;
                case 8:grds[i]="우"; break;
                case 7:grds[i]="미"; break;
                case 6:grds[i]="양"; break;
                default:grds[i]="가"; break;
            }
        }
        String result="";
        for (int i=0; i< names.length; i++){
            result += String.format("%s 학생  국어: %d점 영어: %d점 수학: %d점 \n",names[i],kor[i],eng[i],math[i]);
            result += String.format("총합: %d  평균: %.1f 성적: %s \n",tots[i],avgs[i],grds[i]);
        }
        System.out.println(result);














    
    }
}
