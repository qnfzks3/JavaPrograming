package qnfzks3.project.sungjuk.dao;

import qnfzks3.project.sungjuk.model.SungJukVO;

import java.util.List;

public interface SungJukV3DAO {  //파일을 기록하는 부분만 적었다.  - 입력한 성적 데이터를 파일에 저장

    boolean saveSungJuk(SungJukVO sj); //값이 성공적으로 저장 되었는지 안되었는지

    List<SungJukVO> loadSungJuk();

    void writeSungJuk(List<SungJukVO> sjs);
}
