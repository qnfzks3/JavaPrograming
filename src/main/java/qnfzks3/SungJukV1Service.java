package qnfzks3;

import java.util.Scanner;

public class SungJukV1Service {
    private Scanner sc = null;
    private SungJukVO[] sjs = null;
    private int idx = 0;

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
            case "1": newSungJuk(); break;
            case "2": readSungJuk(); break;
            case "3": readOneSungJuk(); break;
            case "4": modifySungJuk(); break;
            case "5": removeSungJuk(); break;
            case "0": System.exit(0); break;
            default:
                System.out.println("\n>> 잘못 입력하셨습니다! <<\n");
        }
    }

    private void removeSungJuk() {
    }

    private void modifySungJuk() {

    }

    private void readOneSungJuk() {

    }

    private void readSungJuk() {
        String fmt = " %s %d %d %d\n";
        for (SungJukVO sj : sjs) {
            if (sj != null)  // 배열에 성적데이터가 존재한다면
                System.out.printf(fmt, sj.getName(),
                        sj.getKor(), sj.getEng(), sj.getMat());
        } // sjs 배열에 저장된 모든 성적데이터 출력
    }

    private void newSungJuk() {
        System.out.print("이름은? ");
        String name = sc.next();
        System.out.print("국어는? ");
        int kor = sc.nextInt();
        System.out.print("영어은? ");
        int eng = sc.nextInt();
        System.out.print("수학은? ");
        int mat = sc.nextInt();

        SungJukVO sj = new SungJukVO(name, kor, eng, mat);
        computeSungJuk(sj);    // 성적 처리
        sjs[idx++] = sj;       // 처리된 성적데이터 배열에 저장

    }

    private void computeSungJuk(SungJukVO sj) {
        sj.setTot( sj.getKor() + sj.getEng() + sj.getMat() );
        sj.setAvg( (double) sj.getTot() / 3 );

        switch ((int)(sj.getAvg()/10)) {
            case 10: case 9: sj.setGrd('수'); break;
            case 8: sj.setGrd('우'); break;
            case 7: sj.setGrd('미'); break;
            case 6: sj.setGrd('양'); break;
            default: sj.setGrd('가'); break;
        }
    }


}
