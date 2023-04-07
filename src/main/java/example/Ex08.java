package example;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Ex08 {
    public static void main(String[] args) {
        //백엔드는 이렇게 데이터를 담아서 사용한다 - 프론트는 데이터베이스로 json으로 가져와서 사용한다면 백은 직접 데이터베이스를 만들고 관리한다.

        //학생 Student 클래스를 선언하고 객체 초기화한 후 출력
        Student s1=new Student(201350050,"김태희","경기도고양시","1985.3.22","컴공과",504);
        /*System.out.printf("학번:%d \n 학생 이름: %s\n 주소:%s\n 생년월일: %s\n 학과명:%s\n 담당교수:%d\n"
                ,s1.hakbun,s1.name,s1.addr,s1.birth,s1.major,s1.prof);*/
        System.out.println(s1);


        //교수 Professor 클래스를 선언하고 객체 초기화한 후 출력
        Professor p1=new Professor(301,"이순신","프로그래밍");
        //System.out.printf("교수 번호: %d \n 교수 이름: %s \n 전공분야 %s",p1.profnum,p1.name,p1.sunject);
        System.out.println(p1);

    }
}

class Student{
    private int hakbun;
    private String name;
    private String addr;
    private String birth;
    private String major;
    private int prof;

    public Student(int hakbun,String name, String addr , String birth,String major,int prof){
        this.hakbun=hakbun;
        this.name=name;
        this.addr=addr;
        this.birth=birth;
        this.major=major;
        this.prof=prof;

    }
    //get set 으로 만들기
    //get
    public int getHakbun(){
        return hakbun;
    }
    public String getName(){
        return name;
    }
    public String getaddr(){
        return addr;
    }
    public String getBirth(){
        return birth;
    }
    public String getMajor(){
        return major;
    }
    public int getprof(){
        return prof;
    }
    //set
    public void setHakbun(int hakbun){
        this.hakbun=hakbun;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAddr(String addr){
        this.addr=addr;
    }
    public void setBirth(String birth){
        this.birth=birth;
    }
    public void setMajor(String major){
        this.major=major;
    }
    public void setProf(int prof){
        this.prof=prof;
    }

    //toString
    @Override
    public String toString() {
        String fmt = "%d %s %s %s %s %d ";
        return String.format(fmt,hakbun,name,addr,birth,major,prof);

    }
}

class Professor{
    public int profnum;
    public String name;
    public String sunject;

    public Professor(int profnum, String name , String sunject) {
        this.profnum = profnum;
        this.name = name;
        this.sunject = sunject;

    }

    public int getProfnum() {
        return profnum;
    }
    public String getName() {
        return name;
    }
    public String getSunject() {
        return sunject;
    }


    public void setProfnum(int profnum){
        this.profnum=profnum;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setProfnum(String sunject){
        this.sunject=sunject;
    }

    @Override
    public String toString() {
        String fmt="%d %s %s";
       return String.format(fmt,profnum,name,sunject);
    }
}