package qnfzks3;

public class JS14OOP {
    public static void main(String[] args) {

        // 캡슐화
        // 클래스와 멤버변수 선언시 정보의 은닉정도를 부여
        // 정보은닉 : 사용자가 굳이 알 필요가 없는 정보는
        // 사용자로부터 숨겨야 한다는 개념
        // 최소한의 정보만으로 보안과 보호를 구현할 수 있음
        //-- 어디까지 가져다가 사용할 수 있는건가?

        // 자바에서 지원하는 4가지 접근 제한자
        // public >protected > default(같은 패키지끼리는 허용) > private(나만 사용)- 해당 클라스만 사용

        Address addr= new Address();
        
        //addr.name = "홍길동"; // private 으로 선언됨! - 접근 불가!- 오류
        addr.email="abc123@hanmail.com";  //default로 선언됨
        addr.addr ="서울 구로구";     // public 으로 선언됨


    }
}

class Address{
    private String name;
    String email;
    public String addr;


}
//POJO 클래스 라고도 한다. (어떤 클라스에서도 종속되지 않은 클래스를 말함-POJO클래스)

// 자바빈즈Beans : 식별가능하고, 재사용성이 높은 소프트웨어를 만들기 위한 기본 규칙
// 멤버변수는 반드시 private으로 선언
// 기본생성자가 있어야 함
// setter/getter 메서드가 정의되어야 함






