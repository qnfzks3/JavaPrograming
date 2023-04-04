package example;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args){
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
    
    }
}
