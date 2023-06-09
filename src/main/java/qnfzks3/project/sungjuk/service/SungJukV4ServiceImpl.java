package qnfzks3.project.sungjuk.service;


import qnfzks3.project.sungjuk.dao.SungJukV3DAO;
import qnfzks3.project.sungjuk.dao.SungJukV3DAOImpl;
import qnfzks3.project.sungjuk.dao.SungJukV4DAO;
import qnfzks3.project.sungjuk.dao.SungJukV4DAOImpl;
import qnfzks3.project.sungjuk.model.SungJukVO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SungJukV4ServiceImpl implements SungJukV2Service {
    private Scanner sc = null;
    private List<SungJukVO> sjs = null;
    private SungJukV4DAO sjdao = null;

    public SungJukV4ServiceImpl() {
        sc = new Scanner(System.in);
        sjdao = new SungJukV4DAOImpl();
    }

    // 성적 프로그램 메뉴
    public int displayMenu() {
        int menu = -1;

        StringBuffer sb = new StringBuffer();
        sb.append("---------------------------- \n")
                .append(" 성적 처리 프로그램 v4 \n")
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

        try {
            menu = sc.nextInt();
        } catch (InputMismatchException ex) {
            // nextInt 시 문자를 입력했을때 입력 버퍼에 남은 문자찌꺼기 제거
            sc.nextLine();
            // 숫자가 아닌 그 이외 문자 입력시 menu에 -1 대입
            menu = -1;
        }

        return menu;
    }

    public void processMenu(int menu) {
        switch (menu) {
            case 1: newSungJuk(); break;
            case 2: readSungJuk(); break;
            case 3: readOneSungJuk(); break;
            case 4: modifySungJuk(); break;
            case 5: removeSungJuk(); break;
            case 0: System.exit(0); break;
            default:
                System.out.println("\n>> 잘못 입력하셨습니다! <<\n");
        }
    }

    public void removeSungJuk() {
        // 이름입력 -> 대상검색 -> 대상제거
        System.out.print("삭제할 학생번호는? ");
        int sjno = sc.nextInt();

       if(sjdao.deleteSungJuk(sjno)>0)
           System.out.println("성적데이터 삭제 완료");

    }

    public void modifySungJuk() {
        // 이름입력 -> 대상검색 -> 새로운데이터입력 -> 성적처리
        System.out.print("수정할 학생이름은? ");
        String name = sc.next();

        for (int i = 0; i < sjs.size(); i++) {
            try {
                if (sjs.get(i).getName().equals(name)) {
                    System.out.print("국어는? ");
                    int kor = sc.nextInt();
                    System.out.print("영어은? ");
                    int eng = sc.nextInt();
                    System.out.print("수학은? ");
                    int mat = sc.nextInt();

                    SungJukVO newOne = new SungJukVO(name, kor, eng, mat);
                    computeSungJuk(newOne);
                    sjs.set(i, newOne);   // 기존 성적데이터 위치에 새롭게 생성한 객체 대입
                    System.out.println("\n수정완료!!\n");
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("\n잘못 입력하셨습니다... 다시 시도하세요!\n");
                sc.nextLine();
                return;
            } // try - catch
        } // for

    }

    public void readOneSungJuk() {
        // 번호입력 -> 대상검색 -> 대상출력
        System.out.print("조회할 학생번호는? ");
        int sjno = sc.nextInt();

        SungJukVO sj = sjdao.selectOneSungJuk(sjno);

        if (sj != null) {
            System.out.printf("\n %s \n\n", sj);
        } else {
            System.out.println("\n찾는 데이터가 없습니다!\n");
        }

    }

    // 성적 리스트 조회 (이름,국어,영어,수학)
    public void readSungJuk() {
        String fmt = "\n %d %s %d %d %d \n";
        //SungJukVO sjs =sjdao.selectSungJuk(); 원래는 이렇게 하는데 아래처럼 간당하게 만듬

        try {
            for (SungJukVO sj : sjdao.selectSungJuk()) { // for() 괄호안
                System.out.printf(fmt, sj.getSjno(), sj.getName(),
                        sj.getKor(), sj.getEng(), sj.getMat());
            } // sjs 배열에 저장된 모든 성적데이터 출력
        } catch (NullPointerException ex) {
        }
    }

    // 성적 데이터 추가
    public void newSungJuk() {
        SungJukVO sj = null;

        try {
            sj = scanSungJuk();
            computeSungJuk(sj);
        } catch (InputMismatchException ime) {
            System.out.println("\n잘못 입력하셨습니다... 다시 시도하세요!\n");
            return;
        }

        int cnt = sjdao.insertSungJuk(sj);
        if (cnt > 0) System.out.println("성적데이터 저장 완료!!");

    }

    // 성적 데이터 입력받기
    private SungJukVO scanSungJuk() {
        String name = "";
        int kor = 0, eng = 0, mat = 0;

        try {
            System.out.print("이름은? ");
            name = sc.next();
            System.out.print("국어는? ");
            kor = sc.nextInt();
            System.out.print("영어은? ");
            eng = sc.nextInt();
            System.out.print("수학은? ");
            mat = sc.nextInt();
        } catch (InputMismatchException ex) {
            sc.nextLine();
            // scanSungJuk메서드를 호출한 상위 메서드로 예외를 전파함
            throw new InputMismatchException();
        }

        return new SungJukVO(name, kor, eng, mat);
    }

    public void computeSungJuk(SungJukVO sj) {
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