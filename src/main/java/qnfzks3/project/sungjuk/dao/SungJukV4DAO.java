package qnfzks3.project.sungjuk.dao;

import qnfzks3.project.sungjuk.model.SungJukVO;

import java.util.List;

public interface SungJukV4DAO {  //파일을 기록하는 부분만 적었다.  - 입력한 성적 데이터를 파일에 저장
    int insertSungJuk(SungJukVO sj);
    List<SungJukVO> selectSungJuk();
    SungJukVO selectOneSungJuk(int sjno);
    int updateSungJuk(SungJukVO sj);
    int deleteSungJuk(int sjno);




}
