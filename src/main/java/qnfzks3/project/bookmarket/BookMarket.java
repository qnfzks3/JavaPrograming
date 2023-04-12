package qnfzks3.project.bookmarket;

public class BookMarket {
    
    // 프로그램 실행 흐름
    // BookMarket - > Book       Book,Member - > BookService
    // 매인 자바 <- 기능 자바   <- 캡슐화 자바
    public static void main(String[] args) { //일단 여긴 매인

        BookMarketService bksrv= new BookMarketService();

        bksrv.registerMember();;//회원 등록 및 정보 확인

        while (true) {
            //bookmarket
            String menu=bksrv.displayMenu();  //가져와서 
            bksrv.processMenu(menu); //메뉴로 매개변수지정한 클래스 가져오기

        } // while

    }//main
}//class




