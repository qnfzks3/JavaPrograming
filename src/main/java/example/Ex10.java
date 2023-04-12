package example;

import qnfzks3.project.sungjuk.model.SungJukVO;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        // ex) 성적 처리프로그램 v5
        // 클래스 기반 성적 프로그램
        SungJukVO sj = new SungJukVO();

        readSungJuk(sj);
        computeSungJuk(sj);
        printSungJuk(sj);

    }

    public static void readSungJuk(SungJukVO sj) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학생 이름은? ");
        sj.setName(sc.next());

        System.out.print("국어는? ");
        sj.setKor(sc.nextInt());         // set 을 썻다 내보내겠다. - 
                                            // get을 안쓴 이유 - get은 값을 가져오기 위해 사용하는것 하지만 매개변수로 사용된 클라스에는
                                         // 변수만 지정되어있지 변수의 값이 지정되어있지 않기 때문에 get 을 쓰지않고 안에서 값을 지정해주고
                                            // 바로 set을 쓴것
        System.out.print("영어는? ");
        sj.setEng(sc.nextInt());

        System.out.print("수학은? ");
        sj.setMat(sc.nextInt());
    }

    public static void computeSungJuk(SungJukVO sj) {
        sj.setTot(sj.getKor() + sj.getEng() + sj.getMat());
        sj.setAvg((double) sj.getTot() / 3);

        switch ((int) (sj.getAvg() / 10)) {
            case 10:
            case 9:
                sj.setGrd('수');
                break;
            case 8:
                sj.setGrd('우');
                break;
            case 7:
                sj.setGrd('미');
                break;
            case 6:
                sj.setGrd('양');
                break;
            default:
                sj.setGrd('가');
                break;
        }
    }

    public static void printSungJuk(SungJukVO sj) {
        System.out.println(sj);
    }

}

