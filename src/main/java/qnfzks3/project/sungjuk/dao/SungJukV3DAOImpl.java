package qnfzks3.project.sungjuk.dao;

import qnfzks3.project.sungjuk.model.SungJukVO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SungJukV3DAOImpl implements SungJukV3DAO {  //DAO 에는 읽고 쓰고 저장하는 함수만 모아두는 클래스
    private final String fname = "c:/Java/sungjukv3.dat";
    private FileWriter fw = null;
    private FileReader fr = null;
    private BufferedWriter bw = null;
    private BufferedReader br = null;

    @Override
    public boolean saveSungJuk(SungJukVO sj) {  
        // 생성된 성적 데이터를 파일에 저장
        try {
            // 파일기록시 추가append 기능 활성화
            fw = new FileWriter(fname, true);
            bw = new BufferedWriter(fw);

            bw.write(sj.toString());  // 파일에 기록
        } catch (Exception ex) {
            System.out.println("성적 데이터 저장중 오류발생!!");
            System.out.println(ex.getMessage());
            return false;
        } finally {
            if (bw != null) try { bw.close(); } catch (Exception ex) { }
            if (fw != null) try { fw.close(); } catch (Exception ex) { }
        }

        return true;
    }

    // 파일에 저장된 성적 데이터들을 모두 읽어서
    // ArrayList 객체에 저장하고 리턴
    @Override
    public List<SungJukVO> loadSungJuk() {            //loadSungJuk이라는 SungJukVO기반의 컬렉션을 만듬
        List<SungJukVO> sjdata = new ArrayList<>();  // 이렇게 컬렉션을 만들어 주면,  SungJukVO 을 기반으로한 안에 속성 요소들을 그대로 사용가능

        try {
            fr = new FileReader(fname);              // 지정 경로에서 파일을 가져와서  읽고
            br = new BufferedReader(fr);             // 깨져서 나오는 파일들을 다시 문자 스트림으로 읽도록 만듬

            while(br.ready()) {  //br의 읽을 수 있는 데이터 개수만큼 반복
                // 파일에서 성적데이터 한줄을 읽어서
                String[] val = br.readLine().split("[ ]"); //한줄 씩 읽도록 readline 사용

                // SungJuk 객체에 개별 값을 저장하고  - set은 값을 변경
                SungJukVO sj = new SungJukVO(
                        val[0], Integer.parseInt(val[1]),
                        Integer.parseInt(val[2]), Integer.parseInt(val[3]),
               Integer.parseInt(val[4]),
                Double.parseDouble(val[5]),
                 val[6].charAt(0) );

                // ArrayList 객체에 저장
                sjdata.add(sj);
            }
        } catch (Exception ex) {
            System.out.println("성적 데이터 불러오는 중 오류발생!!");
            System.out.println(ex.getMessage());
        } finally {
            if (br != null) try { br.close(); } catch (Exception ex) { }
            if (fr != null) try { fr.close(); } catch (Exception ex) { }
        }

        return sjdata;
    }

    @Override
    public void writeSungJuk(List<SungJukVO> sjs) {
        //ArrayList에 저장된 모든 성적데이터를 파일에 기록
        try {
            // 파일기록시 추가append 기능 활성화
            fw = new FileWriter(fname);    //true도 여기에 적으면 기존것들이 새로 하나 더 생기기때문에 지워주자 
            bw = new BufferedWriter(fw);

            for (SungJukVO sj:sjs) bw.write(sj.toString());  // 파일에 기록
        } catch (Exception ex) {
            System.out.println("성적 데이터 기록중 오류발생!!");
            System.out.println(ex.getMessage());
      
        } finally {
            if (bw != null) try { bw.close(); } catch (Exception ex) { }
            if (fw != null) try { fw.close(); } catch (Exception ex) { }
        }


        
    }

}
