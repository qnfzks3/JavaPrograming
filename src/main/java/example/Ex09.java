package example;

import java.util.StringJoiner;

public class Ex09 {
    public static void main(String[] args) {
        //employees, departments 테이블에 대응하는 클래스 작성
        //서버 마리아db에 있는 board 테이븧에 대응하는 크래스 작성
        Board b= new Board(1,"테스트","abc123","2023-04-07",0,"테스트입니다.");
        System.out.println(b);


        DapartmentsVO d1=new DapartmentsVO(10,"Administration",200,1700);
        System.out.println(d1);

        EmployeesVO e1=new EmployeesVO(100,"Steven","King","SKING",
                "515.123.4567","2003-06-17","AD_PRES",24000,0,0,90);

        // 말 + 클라스 변수는 %s 스트링으로 넣어주자
        System.out.printf("사원 정보 : %s",e1);
    }

}


class Board{
    private int bno;
    private String  title;
    private String  userid ;
    private String  regdate;
    private int views;
    private String contents;

    //알트 인서트 누르면 간편 적기 나온다.
    public Board() {
    }

    public Board(int bno, String title, String userid, String regdate, int views, String contents) {
        this.bno = bno;
        this.title = title;
        this.userid = userid;
        this.regdate = regdate;
        this.views = views;
        this.contents = contents;
    }

    // alt inser  get 자동 완성

    public int getBno() {
        return bno;
    }

    public String getTitle() {
        return title;
    }

    public String getUserid() {
        return userid;
    }

    public String getRegdate() {
        return regdate;
    }

    public int getViews() {
        return views;
    }

    public String getContents() {
        return contents;
    }


    // alt + insert  누르고 set 자동 만듬

    public void setBno(int bno) {
        this.bno = bno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        String fmt="%d %s %s %s %d %s \n";
        return String.format(fmt,bno,title,userid,regdate,views,contents);
    }



}


class DapartmentsVO{
    private int DAPARTMENT_ID;
    private String DAPARTMENT_NAME;
    private int MANAGER_ID ;
    private int LOCATION_ID;

    //생성자
    public DapartmentsVO(int DAPARTMENT_ID, String DAPARTMENT_NAME, int MANAGER_ID, int LOCATION_ID) {
        this.DAPARTMENT_ID = DAPARTMENT_ID;
        this.DAPARTMENT_NAME = DAPARTMENT_NAME;
        this.MANAGER_ID = MANAGER_ID;
        this.LOCATION_ID = LOCATION_ID;
    }
    
    //get
    public int getDAPARTMENT_ID() {
        return DAPARTMENT_ID;
    }

    public String getDAPARTMENT_NAME() {
        return DAPARTMENT_NAME;
    }

    public int getMANAGER_ID() {
        return MANAGER_ID;
    }

    public int getLOCATION_ID() {
        return LOCATION_ID;
    }
    
    
    //set
    public void setDAPARTMENT_ID(int DAPARTMENT_ID) {
        this.DAPARTMENT_ID = DAPARTMENT_ID;
    }

    public void setDAPARTMENT_NAME(String DAPARTMENT_NAME) {
        this.DAPARTMENT_NAME = DAPARTMENT_NAME;
    }

    public void setMANAGER_ID(int MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    public void setLOCATION_ID(int LOCATION_ID) {
        this.LOCATION_ID = LOCATION_ID;
    }

    //toString

    @Override
    public String toString() {
        String fmt = "%d %s %d %d";
        return String.format(fmt,DAPARTMENT_ID,DAPARTMENT_NAME,MANAGER_ID,LOCATION_ID);
}



}

class EmployeesVO{
    private int EMPLOYEE_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String EMAIL;
    private String PHONE_NUMBER;
    private String HIRE_DATE;
    private String JOB_ID;
    private double SALARY;
    private int COMMISSION_PCT;
    private int MANAGER_ID;
    private int DEPARTMENT_ID;

    //생성자
    public EmployeesVO(int EMPLOYEE_ID, String FIRST_NAME, String LAST_NAME, String EMAIL, String PHONE_NUMBER,
                       String HIRE_DATE, String JOB_ID, double SALARY, int COMMISSION_PCT, int MANAGER_ID, int DEPARTMENT_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.EMAIL = EMAIL;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.HIRE_DATE = HIRE_DATE;
        this.JOB_ID = JOB_ID;
        this.SALARY = SALARY;
        this.COMMISSION_PCT = COMMISSION_PCT;
        this.MANAGER_ID = MANAGER_ID;
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    //GET

    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public String getHIRE_DATE() {
        return HIRE_DATE;
    }

    public String getJOB_ID() {
        return JOB_ID;
    }

    public double getSALARY() {
        return SALARY;
    }

    public int isCOMMISSION_PCT() {
        return COMMISSION_PCT;
    }

    public int getMANAGER_ID() {
        return MANAGER_ID;
    }

    public int getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    //SET

    public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setPHONE_NUMBER(String PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public void setHIRE_DATE(String HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    public void setJOB_ID(String JOB_ID) {
        this.JOB_ID = JOB_ID;
    }

    public void setSALARY(double SALARY) {
        this.SALARY = SALARY;
    }

    public void setCOMMISSION_PCT(int COMMISSION_PCT) {
        this.COMMISSION_PCT = COMMISSION_PCT;
    }

    public void setMANAGER_ID(int MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    public void setDEPARTMENT_ID(int DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    //toString


    @Override
    public String toString() {
        String fmt = "%d %s %s %s %s %s %s %f %d %d %d ";
        return String.format(fmt,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT
                ,MANAGER_ID,DEPARTMENT_ID);

    }
}
