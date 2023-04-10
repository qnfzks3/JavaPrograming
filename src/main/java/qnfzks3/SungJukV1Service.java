package qnfzks3;

import java.util.Scanner;

public class SungJukV1Service {
    private Scanner sc = null;
    private SungJukVO[] sjs = null;

    public SungJukV1Service() {
        sc = new Scanner(System.in);
        sjs = new SungJukVO[10];
    }

    // 성적 프로그램 메뉴
    public String displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------- \n")
                .append(" 성적 처리 프로그램 v1 \n")
                .append("---------------------------- \n")
                .append(" 1. 성적데이터 추가 \n")
                .append(" 2. 성적데이터 조회 \n")
                .append(" 3. 성적데이터 상세조회 \n")
                .append(" 4. 성적데이터 수정 \n")
                .append(" 5. 성적데이터 삭제 \n")
                .append(" 0. 프로그램 종료 \n")
                .append("---------------------------- \n")
                .append(" 작업을 선택하세요 : ");
        System.out.print(sb);
        String menu = sc.next();

        return menu;
    }

    public void processMenu(String menu) {
        switch (menu) {
            case "1": break;
            case "2": break;
            case "3": break;
            case "4": break;
            case "5": break;
            case "0": System.exit(0); break;
            default:
                System.out.println("\n>> 잘못 입력하셨습니다! <<\n");
        }
    }


}
