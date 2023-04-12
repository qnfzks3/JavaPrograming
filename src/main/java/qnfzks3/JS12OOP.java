package qnfzks3;

public class JS12OOP {

    // 클래스 종류
    // VO/DTO : ValueObject, Data Transfer Object
    // 계층간 데이터교환을 위한 자바빈즈를 의미
    // 값만 저장하기 위해 생성하는 클래스
    // 주로 데이터베이스 테이블의 각 열과 연계해서 작성
    //class는 테이블 class 와 CRUD (함수만 있는)class 구현하는게 자바 목적
    //class에 있는 변수들은 private로 쓴다.

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

    //getXxx 이름 지정 -- 이렇게 프리베잇으로 있는 변수는 따로 public 타입 get~으로 사용해주어야한다. - get 으로 값을 가져올 대 사용
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

    //setXxx                       - set으로 값을 내보낼때 사용  get 과 set 을 하는 이유는 private 로 바로 사용할 수 없으니 
    //                              - get 으로 가져와서 다시 정의한 다음 set 으로 내보내기 위해 다시 정의하고 밖으로 언제든 가져다 쓸수있도록 한다.

    //                              또한 이런 클라스 자체를 매개변수로 사용해서 안에있는 변수들을 get(가져오다)으로 꺼내서(가져와서) 사용할수도 있다.
    //                               ex) Person.getAge(25) 이런식으로 언제든 사용가능
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