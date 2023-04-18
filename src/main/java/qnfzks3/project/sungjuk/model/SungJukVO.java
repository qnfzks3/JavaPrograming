package qnfzks3.project.sungjuk.model;

import java.util.StringJoiner;

public class SungJukVO {
    private int sjno;
    private String name;
    private int kor;
    private int eng;
    private int mat;
    private int tot;
    private double avg;
    private char grd;

    public SungJukVO() {
    }                                                            //그냥 가져다 쓸수도 있도록 항상 매개변수가 없을 수도 있기때문에

    public SungJukVO(String name, int kor, int eng, int mat) { //매개변수를 쓰고 가져다가 쓸수도 있도록 2개지 모두 적어준다.
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public SungJukVO(String name, int kor, int eng, int mat, int tot, double avg, char grd) {
        this(name, kor , eng ,mat); //= this를 여기서 쓰면 위에있는 4개짜리 생성자를 그대로 가져온다. 그후 아래 나머지만 따로 정의해줌
        this.tot = tot;
        this.avg = avg;
        this.grd = grd;
    }

    public void setSjno(int sjno) {
        this.sjno = sjno;
    }

    public int getSjno() {
        return sjno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public char getGrd() {
        return grd;
    }

    public void setGrd(char grd) {
        this.grd = grd;
    }


    @Override
    public String toString() {
        String fmt = "%s %d %d %d %d %.1f %s\n";
        return String.format(fmt, name, kor, eng, mat, tot, avg, grd);
    }
}
