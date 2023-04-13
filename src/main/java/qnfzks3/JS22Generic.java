package qnfzks3;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

public class JS22Generic {
    // 지네릭Generic
    // 데이터 유형을 일반화(통일)한다는 것을 의미


    public static void main(String[] args) {
        // 여러 유형의 데이터를 사용하는 클래스의 경우
        // 매개변수의 유형을 Object로 선언하는 경우, 경우에 따라 원래의 유형으로 변환해야하는
        // 번거로움이 존재하고 오류가 발생할 수 있는 가능성 존재

        //예제 : 동물원  part1. 동물원 객체 생성
        Object[] zoo = new Object[10];    // Object 사용

        //동물들을 동물원 우리에 가둠
        zoo[0]= new Lion();       // zoo의 각 위치에 요소정의
        zoo[1]= new Tiger();
        zoo[2]=new Zebra();

        // 우리에서 동물우리를 하나씩 빼서 사용함
        // 하지만 , 배열에 저장된 데이터를 빼낼때는 적절한 형변환이 필요!
        //Lion l1 = zoo[0];  <-그냥 쓰면 오류가 난다 -

        Lion l1=(Lion)zoo[0];  //<- 빼서 가져와 쓰려면 형변환이 필요하다. (Lion 타입으로)   ,
        Tiger t1 = (Tiger)zoo[1];
        Zebra z1 = (Zebra) zoo[2];


        //그래서 번거롭기 때문에 우린 제네릭을 이용한다.
        // 지네릭을 이용하면 데이터의 타입을 통일시켜 컴파일시 타입체크 오류 방지와 불필요한 형변환을 없앨수 있음
        // type-parameter (<>)를 이용해서 자료구조의 데이터 유형을 미리 설정해 둠

        List<Lion> lionzoo=new ArrayList<>();   // <데이터 유형> 이런 데이터 타입만 저장할 수 있다 명시함 ex) Lion 데이타 타입만 사용

        lionzoo.add(new Lion());
        //lionzoo.add(new Tiger()); //오류발생!  -- 사자우리는 사자만 들어가야함 
        
        //자동형 변환이 되므로 오류 없이 실행됨
        Lion l2 = lionzoo.get(0);

        // 제네릭 타입
        // 임의의 숫자를 입력 받아 더하는 메서드를 만듬
        //
        Adds example = new Adds();

        System.out.println(example.add(3,3));
        System.out.println(example.add(4.5,4.5));
        System.out.println(example.add(5.5f,6.5f));
        
        //제네릭 타입 
        //클래스나 메서드의 자료형을 미리 정해두고 사용하는 것이 아니고, 외부에서 사용자에 의해 정해지도록 
        //지정하는 것을 의미 한다.
        //즉, 특정 타입을 미리 작성하고 사용하는 것이 아니고, 실행 중에 필요에 따라 타입을 매개변수 형태로 받아 사용함
        // 비슷한 기능을 지원하는 코드들을 간략하게 작성할 수 있어서 코드의 재사용성을 높인다.

        //아래 정의한 add 제네릭을 가져와서 사용해보자
        System.out.println(
                example.add(new Integer(10),new Integer(100))
        );
        System.out.println(
                example.add(new Double(5.5),new Double(10.3))
        );
        System.out.println(
                example.add(new Float(3.5),new Float(7.3))
        );

    }

}

class Lion { }
class Tiger {}
class Zebra { }

class Adds{
    
    public int add(int a, int b){
        System.out.println("int add");
        return a+b;
    }
    public double add(double a,double b){
        System.out.println("double add");
        return a+b;
    }
    public float add(float a,float b){
        System.out.println("float add");
        return a+b;
    }
    //위에 보면 데이터 타입을 제외한 나머지 부분은 전부 동일하다 , 이때 제네릭을 사용

    public <T> T add(T a,T b){  //<> 제너릭 선언 - T 데이터 타입 매개변수
        T sum = null;

        if (a.getClass()==Integer.class){  //a 변수의 클래스형이 Integer 라면 아래를 실행하라
            System.out.println("Integer add");
            return (T)(Integer) ((Integer)a + (Integer)b);
        } else if (a.getClass()== Double.class) {  // a 변수의 클래스형이 Double이면 아래를 실행~
            System.out.println("Double add");
            return (T)(Double) ((Double)a+(Double)b);
        }else if (a.getClass()== Float.class){
            System.out.println("Float add");
            return (T)(Float) ((Float)a+(Float) b);
        }
        return sum;
    }


    // 이렇게 정의해주고 T 에 데이터타입을 가져올때 정의 해주고 쓰면 된다.
    
    
}


