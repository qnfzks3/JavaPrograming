package qnfzks3;

import java.util.Scanner;

public class BookMarketService { //클래스 파일들 가져다 쓰기위한
    private Scanner sc=null; //값을 저장하기 위한 변수는 아님 그냥 기능을 위해 변수로 정의 했을뿐이래요
    private MemberShip m = null;  //아직 값이 할당 안됨 -  초기값은 null  그냥 클래스와 함수로 만들기

    private BookInfo[] books=null;  // 배열로 만들어보기

    public  BookMarketService(){ //오버로딩 -근데 이걸 왜 이렇게 썻죠?
        sc = new Scanner(System.in);
        registerBooks();

    }
    public String displayMenu(){ //함수에 리턴값으로 준다면 void-없다면 함수도 리턴값의 자료형을 따라 가야한다.
        //bookmarket 메뉴 작성
        StringBuilder sb=new StringBuilder();

        sb.append("----------------------------\n")
                .append("Welcome to Shopping Mall \n")
                .append("Welcome to Shopping Market \n")
                .append("---------------------------- \n")
                .append("1.  고객정보 확인하기 \n")
                .append("2. 장바구니 상품 목록 보기 \n")
                .append("3. 장바구니 비우기 \n")
                .append("4. 장바구니 상품 추가 \n")
                .append("5. 장바구니 주문수량 변경 \n")
                .append("6. 장바구니 항목 삭제 \n")
                .append("7. 상품 주문 영수증 출력 \n")
                .append("0. 프로그램 종료 \n")
                .append("---------------------------- \n")
       .append("작업을 선택하세요 : \n");  // sout 으로 한거랑 크게 다르지 않음 그냥 이런 방법도 있다

        System.out.print(sb);
        String menu = sc.next(); //선택한, 작업할 메뉴를 입력 받기
        return menu;



    }

    public void processMenu(String menu){
        //메뉴에 따라 작업 분기
        switch (menu){
            case "1":
                System.out.println("\n 고객정보 확인 \n");
                System.out.println(m);
                break;
            case "2":
                System.out.println("\n장바구니 상품 목록\n"); break;
            case "3":
                System.out.println("\n장바구니 비우기\n");break;
            case "4":
                System.out.println("\n장바구니 상품 추가\n");
                for (BookInfo b: books) {
                    System.out.println(b);
                }
                break;
            case "5":
                System.out.println("\n주문수량 변경\n"); break;
            case "6":
                System.out.println("\n상품 삭제\n"); break;
            case "7":
                System.out.println("\n주문 영수증 출력\n");break;
            case "0":
                System.out.println("\n프로그램을 종료합니다.\n");
                System.exit(0);break;
            default:
                System.out.println("\n잘못입력하셨습니다. 숫자 0~7사이 번호로만 적어주세요\n");

        }
    }
    //회원 등록
    public void registerMember(){
        System.out.print("회원 이름은? ");
        String name =sc.next();

        System.out.print("회원 이메일은? ");
        String email =sc.next();

        System.out.print("회원 전화번호는? ");
        String hp =sc.next();

        m= new MemberShip(230410,name,email,hp);
    }
    
    //도서 정보 자동 등록
    public void registerBooks(){
        books=new BookInfo[3];
        books[0]=new BookInfo("230412221",
                "JSP웹프로그래밍",27000,"송미영","단계별로 쇼핑몰 구현","2018-10-08","IT전문서");

        books[1]=new BookInfo("2304104567",
                "안드로이드 프로그래밍",33000,"우재남","실습 멘토링 제공","2022-01-22","IT전문서");
        books[2]=new BookInfo("2304107891",
                "스크래치",22000,"고광일","사고력을 키우는 코딩","2019-06-19","컴퓨터입문");
    }






}


