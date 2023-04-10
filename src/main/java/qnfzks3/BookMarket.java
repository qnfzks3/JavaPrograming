package qnfzks3;

import java.util.Scanner;

public class BookMarket {
    
    // 프로그램 실행 흐름
    // BookMarket - > Book       Book,Member - > BookService
    public static void main(String[] args) {

        BookMarketService bksrv= new BookMarketService();

        while (true) {
            //bookmarket
            String menu=bksrv.displayMenu();  //가져와서 
            bksrv.processMenu(menu); //메뉴로 매개변수지정한 클래스 가져오기

        } // while

    }//main
}//class




