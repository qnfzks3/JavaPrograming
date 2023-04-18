package qnfzks3.project.sungjuk.dao;

import qnfzks3.project.sungjuk.model.SungJukVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class SungJukV4DAOImpl implements SungJukV4DAO {

    private String insertSQL = "insert into SungJuk (name,kor,eng,mat,tot,avg,grd) value(?,?,?,?,?,?,?)";
    private String selectSQL = "select * from SungJuk order by sjno desc";
    private String selectOneSQL = "select * from SungJuk where sjno =? ";
    private String updateSQL = "update sungjuk set name=?,kor=?,eng=?,mat=? where sjno=?";
    private String deleteSQL = "delete from sungjuk where sjno=?";



    @Override
    public int insertSungJuk(SungJukVO sj) {
        Connection conn=null;
        PreparedStatement pstmt = null;
        int cnt = -1;

        try{
           conn=MariaDB.makeConn();
           pstmt=conn.prepareStatement(insertSQL);
           pstmt.setString(1,sj.getName());
           pstmt.setInt(2,sj.getKor());
           pstmt.setInt(3,sj.getEng());
           pstmt.setInt(4,sj.getMat());
           pstmt.setInt(5,sj.getTot());
           pstmt.setDouble(6,sj.getAvg());
           pstmt.setString(7,sj.getGrd()+"");

           cnt = pstmt.executeUpdate();


        }catch (Exception ex){
            System.out.println("insertSungJuk에서 오류 발생");
            ex.printStackTrace(); //예외의 자세한 내용 출력

        }finally {
            MariaDB.closeConn(null,pstmt,conn);

        }
        return 0;
    }

    @Override
    public List<SungJukVO> selectSungJuk() {
        return null;
    }

    @Override
    public SungJukVO selectOneSungJuk(int sjno) {
        return null;
    }

    @Override
    public int updateSungJuk(SungJukVO sj) {
        return 0;
    }

    @Override
    public int deleteSungJuk(int sjno) {
        return 0;
    }  //DAO 에는 읽고 쓰고 저장하는 함수만 모아두는 클래스


}
