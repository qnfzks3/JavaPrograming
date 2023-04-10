package qnfzks3;

public class JS13OOP {

    // 메서드 다중정의
    // 객체지향 3대 중요개념 중 하나인 다형성에 해당
    // 같은 이름의 메서드를 중복해서 정의하는 것을 의미
    // 한 클래스에 같은 이름의 메서드가 2개 이상 존재할 수 있음
    // 이때 메서드의 서명만 다르게 작성한다면 정의 가능
    public static void main(String[] args) {
        Cat persian=new Cat();
        NotOverloading nol = new NotOverloading();
        ApplyOverloading aol= new ApplyOverloading();

        System.out.println(nol.addInt(10,10));
        System.out.println(nol.addDouble(10.5,10.5));
        System.out.println(nol.addIntTree(10,20,30));

        System.out.println(aol.add(10,10));
        System.out.println(aol.add(10.5,10.5));
        System.out.println(aol.add(10,20,30));

    }
}


class Cat {
    private String breed;
    private String color;

    //생성자 다중정의 - 메서드 오버로딩
    public Cat() {
    }

    //알트 insert 생성자 생성
    public Cat(String breed, String color) {
        this.breed = breed;
        this.color = color;

    }

    public Cat(String breed) {
        this.breed = breed;
    }

    //오버 로딩 적용한 것과 적용하지 않은 것  차이 확인


}

class NotOverloading{
    // 간단한 덧셈 프로그램
    // 1. 정수2개를 더하는 프로그램
    public int addInt(int x,int y){
        return x+y;
    }
    // 2. 실수2개를 더하는 프로그램
    public double addDouble(double x, double y){
        return x+y;
    }
    // 3. 정수3개를 더하는 프로그램
    public int addIntTree(int x,int y, int z){
        return x+y+z;
    }
    //메서드 오버로딩을 사용하지 않는 경우
    //생성할 메서드마다 이름을 제각각으로 정해야하므로
    //개발자가 일일히 기억해서 사용해야하는 불편 발생

}

//메서드 오버로딩 적용
class ApplyOverloading{
    // 간단한 덧셈 프로그램
    // 1. 정수2개를 더하는 프로그램
    public int add(int x,int y){
        return x+y;
    }
    // 2. 실수2개를 더하는 프로그램
    public double add(double x, double y){
        return x+y;
    }
    // 3. 정수3개를 더하는 프로그램
    public int add(int x,int y, int z){
        return x+y+z;
    }
    //메서드 다중정의를 적용하면 메서드의 이름을 하나로 통일해서 작성가능
    //개발자가 외울 메서드의 이름이 줄어든다  단 , 메서드를 어떻게 호출할지만 알고 있으면 됨

}