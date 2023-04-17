package qnfzks3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JS33JDBC { //한파일에 모든 클라스 다만들어보자 1. VO
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //사원 등록
       /* System.out.println("사원등록을 진행합니다."); //1사원 등록은 이렇게 값을 받고

        System.out.println("사원번호는?");
        int empno= sc.nextInt();
        System.out.println("성은?");
        String fname =sc.next();
        System.out.println("이름은?");
        String lname =sc.next();
        System.out.println("이메일은?");
        String email =sc.next();
        System.out.println("핸드폰 번호는?");
        String phone =sc.next();
        System.out.println("고용된 일자는?");
        String hdate =sc.next();
        System.out.println("직업 아이디는?");
        String jobid=sc.next();
        System.out.println("연봉은?");
        int sal =sc.nextInt();
        System.out.println("수당은?");
        Double comm =sc.nextDouble();
        System.out.println("관리자 번호는?");
        int mgrid =sc.nextInt();
        System.out.println("부서번호는?");
        int deptno =sc.nextInt();

        EMPVO emp = new EMPVO(empno,fname,lname,email,phone,hdate,jobid,sal,comm,mgrid,deptno);//2 컬렉션 만들기
        int cnt = EMPDAOImpl.insertEmp(emp);
        if(cnt>0) System.out.println("사원정보 입력 성공!!");*/

        //사원 조회

        List<EMPVO> empdata= EMPDAOImpl.selectEmp();


        for (EMPVO semp:empdata){
            System.out.print(semp+" ");
        }

        //사원 상세조회
       /* System.out.println("조회할 사원번호는?");
        int empno = sc.nextInt();
        EMPVO emp = EMPDAOImpl.selectOneEmp(empno);
        if(emp != null) System.out.println(empno);

        System.out.println(emp);*/

        
        //사원 수정
        
        //사원 삭제



    }



}
class EMPVO{  //이 경우 돌려쓰면 안되니 static이 아닌 instance - 각자마다 다 제공하지않는다.
    private int empno;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String hdate;
    private String jobid;
    private int sal;
    private double comm;
    private int mgrid;
    private int deptno;

    public EMPVO(int empno, String fname, String lname, String email, String phone, String hdate, String jobid, int sal, double comm, int mgrid, int deptno) {
        this.empno = empno;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.hdate = hdate;
        this.jobid = jobid;
        this.sal = sal;
        this.comm = comm;
        this.mgrid = mgrid;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getHdate() {
        return hdate;
    }

    public String getJobid() {
        return jobid;
    }

    public int getSal() {
        return sal;
    }

    public double getComm() {
        return comm;
    }

    public int getMgrid() {
        return mgrid;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public void setMgrid(int mgrid) {
        this.mgrid = mgrid;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        String fmt= "%d,%s,%s,%s,%s,%s,%s,%d,%f,%d,%d";
        return String.format(fmt,empno,fname, lname,email,phone,hdate,jobid,sal,comm,mgrid,deptno);
    }
} //0. 각 클래스 어떻게 짤지 다 만들었다면 캡슐화부터 진행

interface EMPDAO{
    int insertEmp(EMPVO emp);
    List<EMPVO> selectEmp();
    EMPVO selectOneEmp(int empno);
    int updateEMP(EMPVO emp);
    int deleteEMP(EMPVO emp);
}


class EMPDAOImpl{  //5개 작성해야한다  insert select 전체 , select 검색, update 수정  , delete 삭제
    private static final String insertEMPSQL = "insert into EMPLOYEES values (?,?,?,?,?,?,?,?,?,?,?)";  //실무에서 밖에 빼면 로딩이 늦어짐 암튼 4.SQL 만들기-
                                                                // 여기서 값중에서 외래키로 지정됬다면 외래키에 내용을 따라가지않으면 오류남
    private static final String selectEMPSQL = "select * from EMPLOYEES order by EMPLOYEE_ID desc";
    private static final String selectOneEMPSQL = "select * from EMPLOYEES where EMPLOYEE_ID like ? order by EMPLOYEE_ID desc ";
    private static final String deleteEMPSQL = "delete from EMPLOYEES where EMPLOYEE_ID =  ?  ";
    private static final String updateBookSQL = "update EMPLOYEES set title =?, writer= ?,price=? where empno=?  ";

    public static int insertEmp(EMPVO emp){ //inser
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt= 0;

        try {
            conn=JS34JDBCUtil.makeConn();
            pstmt=conn.prepareStatement(insertEMPSQL);
            pstmt.setInt(1,emp.getEmpno());
            pstmt.setString(2,emp.getFname());
            pstmt.setString(3,emp.getLname());
            pstmt.setString(4,emp.getEmail());
            pstmt.setString(5,emp.getPhone());
            pstmt.setString(6,emp.getHdate());
            pstmt.setString(7,emp.getJobid());
            pstmt.setInt(8,emp.getSal());
            pstmt.setDouble(9,emp.getComm());
            pstmt.setInt(10,emp.getMgrid());
            pstmt.setInt(11,emp.getDeptno());
            cnt=pstmt.executeUpdate();

        }catch (Exception ex){
            System.out.println("insertEmp에서 오류 발생!!");
            System.out.println(ex.getMessage());
        }finally {
            JS34JDBCUtil.closeConn(null,pstmt,conn);

        }
        return cnt;
    }
    public static List<EMPVO> selectEmp(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<EMPVO> empdata=new ArrayList<>(); //컬렉션만들기

        try {
            conn=JS34JDBCUtil.makeConn();
            pstmt=conn.prepareStatement(selectEMPSQL);
            rs=pstmt.executeQuery();

            while (rs.next()){
                EMPVO emp=new EMPVO(
                        rs.getInt(1),rs.getString(2),"",rs.getString(3),"",
                        "",rs.getString(4),
                        0,0.0,0,rs.getInt(5)
                );
                empdata.add(emp);
            }
        }catch (Exception ex){
            System.out.println("selectEmp에서 오류 발생!!");
           ex.printStackTrace();
        }finally {
            JS34JDBCUtil.closeConn(rs,pstmt,conn);

        }

        return empdata;
    }

    public static EMPVO selectOneEmp(int empno){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        EMPVO emp=null;

        try {
            conn=JS34JDBCUtil.makeConn();
            pstmt=conn.prepareStatement(selectOneEMPSQL);
            pstmt.setInt(1,empno);

            rs=pstmt.executeQuery();
            while (rs.next()){
                emp = new EMPVO(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7), rs.getInt(8),
                        rs.getDouble(9),rs.getInt(10),rs.getInt(11));
            }

        }catch (Exception ex){
            System.out.println("selectOneEmp에서 오류 발생!!");
            System.out.println(ex.getMessage());
        }finally {
            JS34JDBCUtil.closeConn(rs,pstmt,conn);
        }

        return emp;
    }



    public static int updateEMP(EMPVO enp){





        try {

        }catch (Exception ex){
            System.out.println("updateEMP에서 오류 발생!!");
            System.out.println(ex.getMessage());
        }


        return 0;
    }
    public static int deleteEMP(int empno){


        try {

        }catch (Exception ex){
            System.out.println("deleteEMP에서 오류 발생!!");
            System.out.println(ex.getMessage());
        }


        return 0;


        
    }


}

