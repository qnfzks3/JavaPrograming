package qnfzks3;

public class JS12OOP {
    public static void main(String[] args) {
        Person2 p1=new Person2();
        
        //객체 멤버 변수 초기화 - private  = > 실패 : public으로만
        //p1.sname = "혜교";
        //p1.job = "학생";
        //p1.age = 35;
        //p1.gender = '여';


        //setter로 변수 초기화
        p1.setName("혜교");
        p1.setJob("학생");
        p1.setAge(35);
        p1.setGender('여');

        //객체 출력1
        System.out.println(p1.getName());
        System.out.println(p1.getJob());
        System.out.println(p1.getAge());
        System.out.println(p1.getGender());

        //객체 출력2
        System.out.println(p1);  // -private으로 변수 지정했다면, 클라스안에 , get set으로 정의후에 toString 으로 만들어서 한번에 값이 나오게한다.


    }
}
//접근제한자 - 총 4가지  -  public , protected , default(안씀) , private

class Person2 { 
    //맴버변수 캡슐화
    //접근 제한자를 이용해서 맴버변수의 직접 접근을 막음
    private String name;
    private String job;
    private int age;
    private char gender;
    // 생성자 : 멤버변수에 값을 초기화하는 특별한 메서드
    // public 클래스 명(매개변수,...){
    //  변수 초기화
    //}
    public Person2(){
    }
    //getter/ setter 선언
    //private 으로 선언된 변수를 외부에 접근할 수 있도록
    //정의하는 특수한 메서드

    //getXxx 이름 지정 -- 이렇게 프리베잇으로 있는 변수는 따로 public 타입 get~으로 사용해주어야한다.
    public String getName(){
        return name;
    }
    public String getJob(){
        return job;
    }
    public int getAge(){
        return age;
    }
    public char getGender(){
        return gender;
    }

    //setXxx
    public void setName(String name){
        this.name=name;
    }
    public void setJob(String job){
        this.job=job;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setGender(char gender){
        this.gender=gender;
    }
    
    //toString : 모든 맴버 변수 값을 출력할 때 사용하는 메서드

    @Override
    public String toString() {  //자손 메서드이다.  -
        String fmt = "%s %s %d %s";
        return String.format(fmt,name,job,age,gender);
    }
}