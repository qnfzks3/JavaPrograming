package qnfzks3.project.sungjuk.dao;

import qnfzks3.project.sungjuk.model.SungJukVO;

import java.util.List;

public interface SungJukV4DAO {  //파일을 기록하는 부분만 적었다.  - 입력한 성적 데이터를 파일에 저장
    int insertSungJuk(SungJukVO sj);
    List<SungJukVO> selectSungJuk();
    SungJukVO selectOneSungJuk(int sjno);
    int updateSungJuk(SungJukVO sj);
    int deleteSungJuk(int sjno);
// 인터페이스로 미리 클래스에 어떤 함수를 사용했는지 한눈에 알 수 있다. - 목차같은 느낌이라고 생각해도됨
// 이러한 인터페이스는 그때 그때 클래스안에 함수를 정의해서 사용하지 않고 사용할 수 있다. 사용할 땐 오버라이딩(부모클래스의 함수 내용을 수정한다는 의미)을 사용해 사용



}
