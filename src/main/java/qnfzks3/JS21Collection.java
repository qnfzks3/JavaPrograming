package qnfzks3;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class JS21Collection {
    // Colletion   - Arraylist
    // 데이터를 저장하는 자료구조와 데이터를 처리 (CRUD)하는 자료구조
    // 인터페이스와 클래스로 구현해 놓은 프레임워크

    // 컬렉션과 배열 차이 - 둘다 위치에 요소를 저장하지만 차이가 있다 .
    //                 1. 배열의 경우 int면 int요소만 저장 string이면 string만 저장이지만 컬렉션은 다양한 요소 타입으로 저장 가능하다.
    //                 2. 배열은 크기가 고정된다 정해진 크기만 지정하고 사용하지만 컬렉션은 정해지지않은 동적이다 언제든 크기를 변화시킬수있다.
    //                 3. 수식도 그래서 다르다 . ex) 배열- length 크기    ,  컬렉션 -  size() 크기


    public static void main(String[] args) {
        // ArrayList
        // 동적배열의 한 종류
        // List 인터페이스를 구현해서 만든 컬렉션 프레임워크
        // 요소의 저장순서가 유지
        // 중복으로 데이터를 저장할 수 있음
        // 크기가 늘어나면 새로운 배열을 생성하고
        // 기존의 요소들을 옮겨야 하는 복잡한 과정이 동반됨

        List<String> names= new ArrayList(); //엔터페이스의 기능 활용  - 컬렉션 = 얼레이리스트
        //ArrayList names= new ArrayList();
        
        //데이터 추가 : add(대상)
        names.add("혜교");    //배열에 위치 0,1,2,3 이런식으로 지정할 필요없이 추가 한다.
        names.add("지현");    // 만약 특정 위치에 데이터를 추가 하고 싶다면 : add(위치, 대상)
        names.add("혜지");

        
        names.add(1,"원영"); //이렇게 따로 또 지정이 가능하다. 만약 기존 1번자리에 위에처럼 지현이 들어가있다면
                                            // 지현은 1번에서 2번자리로 가게되고 1번 자리에는 "원영" 이 온다.

        //조회 : enhanced for

        for(String name : names){
            System.out.print(name+" ");
        }
        System.out.println();

        //특정요소를 조회하고 싶다면?  : get(위치) 사용 -
        System.out.println(names.get(1)); //names의 2번째 요소 
        
        //set(위치 , 새로운 값): 특정요소 변경
        names.set(1,"윤아");
        System.out.println(names.get(1));

        //특정요소 제거 : remove(위치)

        names.remove(1);
        System.out.println(names.get(1));

        //특정요소 제거 : remove(값)

        names.remove("혜지");
        System.out.println(names.get(names.size()-1));  //-1 을 준건 컬렉션도 0부터 시작하기 때문에 - 마지막 위치에있는 요소 출력



        for(String name : names){
            System.out.print(name+" ");
        }
        System.out.println();

        // 배열에서 데이터 검색 - 위치로 찾음 : get(위치)   , indexOf
        //                   - 값으로 찾음 : contains, indexOf
        // '지현'을 검색 1
        for (int i = 0; i < names.size(); i++) {         // 검색하는 방법 자체를 외워보자   (size는 컬랙션의 크기)
            if(names.get(i).equals("지현")){ // i번째에서 지현이 있어?
                System.out.printf("%d번째 자리에서 지현을 찾음",i); // 지현이 몇번째에 위치했는지 알려줌
            }
        }//위치 기반 검색 -- 이젠 옜날방식이다.

        //'지현'을 검색2

        for(String name : names){
            if (name.equals("지현")){     //equals는 불린값이다 만약에 네임 컬렉션에서 "지현"이라는 요소가 있어?  참 거짓
                System.out.println("데이터 찾음");
            }
        }//값 기반 검색 이젠 이렇게 검색함

        //'지현'을 검색 4
        if(names.contains("지현")){
            System.out.println("데이터 찾음");
        }

        //게임정보 객체 생성  -- 예제 (클래스로 요소를 정의해놓고 데이터를 컬렉션에 넣어서 출력해보자)
        List<GameInfo> games = new ArrayList<>(); //컬렉션 선언
        games.add(new GameInfo("디아블로",89600));
        games.add(new GameInfo("젤다의 전설",74800));
        games.add(new GameInfo("바이오하자드 4 RE",67000));

        //조회 - GameInfo 타입은 객체형이므로 객체자체를 출력 시 객체의 메모리 주소가 출력된다.
        // 그렇기 때문에 반드시 toSring.valueOf() 를 사용해서 객체의 값을 문자형으로 변경 시켜야 정상적으로 출력된다.
        //그래서 그냥 GameInfo 클래스에 알트 인서트 해서 toSring() 으로 정의하자 

        for (int i = 0; i <games.size() ; i++) {
            System.out.print(games.get(i)+"");
        } //일케 하니깐 이상하게 나옴


        for (GameInfo game:games){
            System.out.print(game);
        }
        
        //'젤다의 전설'의 가격을 조회
        
        //v1- for
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).name.equals("젤다의 전설")){
                System.out.println(games.get(i).price);
            }
        }

        //v2- foreach  - 추천
        for (GameInfo game: games){  // games 안에 있는 각각 요소들 차례대로 반복 -> game은 첫번째 요소이다. game은 두번째 요소이다. game은 세번째 요소이다.
            if (game.name.equals("젤다의 전설")){
                System.out.println(game.price);
            }
        }

        //v3 - contains  - 객체형일땐 for을 사용해야함  -추천
        // contains() 은 해당 ()안에 문자내용이 포함 되어있는지 찾는 함수
        for (GameInfo game : games){
            if (game.name.contains("젤다")){
                System.out.println(game.price);

            }
            if (game.name.contains("젤다의 전설")){
                System.out.println(game.price);

            }
        }

        //v4 - indexOf
        for (GameInfo game : games){
            if (game.name.indexOf("젤다의 전설")>-1){
                System.out.println(game.price);

            }
        }

     
        
        



        
    }
}

class GameInfo{ // 보통 다중 타입을 쓰고싶으면 클래스로 한다. 단일이면 <String>을 바로 사용해서 나타내고 
     String name;
     int price;

    public GameInfo(String name, int price) {  //생성자는 어떤 형식으로 사용할 것인지
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        String fmt= "%s %d \n";
        return String.format(fmt, name, price);
    }
}