package qnfzks3.project.sungjuk.dao;

import qnfzks3.project.sungjuk.model.SungJukVO;

import java.util.List;

public interface SungJukV3DAO {

    boolean saveSungJuk(SungJukVO sj); //값이 성공적으로 저장 되었는지 안되었는지

    List<SungJukVO> loadSungJuk();
}
