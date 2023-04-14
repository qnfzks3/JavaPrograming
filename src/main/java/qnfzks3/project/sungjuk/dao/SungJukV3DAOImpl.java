package qnfzks3.project.sungjuk.dao;

import qnfzks3.project.sungjuk.model.SungJukVO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class SungJukV3DAOImpl implements SungJukV3DAO {
    private Scanner sc = null;
    private List<SungJukVO> sjs = null;
    private int idx = 0;

    private String fname = "c:/Java/sungjukv3.dat";
    private FileWriter fw=null;  // 처음에는 항상 초기화 null을 써주자
    private FileReader fr=null;
    private BufferedWriter bw=null;
    private BufferedReader br=null;

    @Override
    public boolean saveSungJuk(SungJukVO sj) {

        //생성된 성적 데이터를 파일로 저장
        try {
            fw=new FileWriter(fname,true);
            bw=new BufferedWriter(fw);
            bw.write(sj.toString()); //파일에기록
        } catch (Exception ex) {
            System.out.println("성적 데이터 저장중 오류발생!");
            System.out.println(ex.getMessage());
            return false;
        } finally {
            if (bw != null) {try {bw.close();} catch (Exception ex) {}}
            if (bw != null) {try {fw.close();} catch (Exception ex) {} //쓰기만 적ㅇㅁ
            }
        }
        return true;
    }
}
