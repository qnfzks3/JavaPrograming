package qnfzks3.project.sungjuk.dao;

import qnfzks3.project.sungjuk.model.SungJukVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SungJukV4DAOImpl implements SungJukV4DAO {

    private String insertSQL = "insert into sungjuk (name,kor,eng,mat,tot,avg,grd) value(?,?,?,?,?,?,?)";
    private String selectSQL = "select * from sungjuk order by sjno desc";
    private String selectOneSQL = "select * from sungjuk where sjno =? ";
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
        Connection conn=null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<SungJukVO> sjdata =new ArrayList();

        try{
            conn=MariaDB.makeConn();
            pstmt = conn.prepareStatement(selectSQL);
            rs=pstmt.executeQuery();

            while (rs.next()){
                SungJukVO sj = new SungJukVO(rs.getString(2),rs.getInt(3),
                        rs.getInt(4), rs.getInt(5));
                sj.setSjno(rs.getInt(1));
                sjdata.add(sj);
            }

        }catch (Exception ex){
            System.out.println("selectSugJuk에서 오류 발생!!");
            ex.printStackTrace();

        }finally {
            MariaDB.closeConn(rs,pstmt,conn);
        }

        return sjdata;
    }

    @Override
    public SungJukVO selectOneSungJuk(int sjno) {
        Connection conn=null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;


        try{
            conn=MariaDB.makeConn();

        }catch (Exception ex){
            System.out.println("selectSugJuk에서 오류 발생!!");
            ex.printStackTrace();

        }finally {
            MariaDB.closeConn(rs,pstmt,conn);
        }

        return null;
    }

    @Override
    public int updateSungJuk(SungJukVO sj) {
        Connection conn=null;
        PreparedStatement pstmt =null;

        try{
            conn=MariaDB.makeConn();

        }catch (Exception ex){
            System.out.println("selectSugJuk에서 오류 발생!!");
            ex.printStackTrace();

        }finally {
            MariaDB.closeConn(null,pstmt,conn);
        }


        return 0;
    }

    @Override
    public int deleteSungJuk(int sjno) {
        Connection conn=null;
        PreparedStatement pstmt =null;


        try{
            conn=MariaDB.makeConn();

        }catch (Exception ex){
            System.out.println("selectSugJuk에서 오류 발생!!");
            ex.printStackTrace();

        }finally {
            MariaDB.closeConn(null,pstmt,conn);
        }


        return 0;
    }  //DAO 에는 읽고 쓰고 저장하는 함수만 모아두는 클래스


}
