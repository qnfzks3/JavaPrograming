package qnfzks3;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JS19Package {
    public static void main(String[] args) {
        int a =4 , b=10, c=1;
        double d=4.51,e=5.41;

        System.out.println(Math.max(a,b)+"/"+Math.max(b,c));
        System.out.println(Math.min(b,c)+"/"+Math.min(a,b));

        System.out.println(Math.round(d)+"/"+Math.round(e));
        System.out.println(Math.ceil(d)+"/"+Math.floor(e));
        System.out.println(Math.ceil(d)+"/"+Math.floor(e));

        double r= Math.random();
        System.out.println(r);
        System.out.println((int)(r*5)); // 0~4 사이 난수
        System.out.println((int)(r*10));// 0~9 사이 난수
        System.out.println(((int)(r*5))+1);// 1~5 사이 난수
        System.out.println(((int)(r*10))+1);// 1~10 사이 난수

        //1~45 사이 임의의 난수 6개 생성
        for (int i = 0; i < 6; i++) {
            double x= Math.random();
            System.out.print(((int)(x*45))+1+" ");
        }
        System.out.println();
        //String 클래스
        //ex) 파일 명이 abc123.png라 할 때 파일명과 확장자를 분리해서 출력

        String filename= "abc123.png";
        String fname=filename.substring(0, 6);
        String ext=filename.substring(7,10);

        System.out.println(fname+"/"+ext); // 하지만 이렇게 하면 파일 이름이 바뀌거나 확장자명이 다르면 이런 방법은 안된다. 그래서 아래와 같이 사용

        String filename2= "abc123.jpeg";
        String fname2=filename2.substring(0, filename2.indexOf('.'));
        String ext2=filename2.substring(filename2.indexOf('.')+1);

        System.out.println(fname2+"/"+ext2);



        String[] names= filename.split("[.]");//점을 기준으로 나눈다. - split
        System.out.println(names[0]+"/"+names[1]);                             //

        //문자열 합치기 : +, concat(비추), StringBuilder, StringBuffer
        //+ : 내부적으로 StringBuilder를 이용해서 출력 +는 짧을때만    긴것들은 buffer로 따로 정의해주자
        
        //StringBuilder(동기화 x)  -> StringBuffer(동기화 o)
        //하지만 실무에서는 StringBuffer를 주로사용 -

        //Date 클래스
        Date today=new Date();
        System.out.println(today);
        
        //Calendar 클래스

        Calendar cal = Calendar.getInstance();
        //System.out.println(cal.toString());  -- 이렇게 찍으면 쭉 다 나오게 된다 .그래서 우리가 년도만 보고싶다 하면

        System.out.println(cal.getTime()); //시간 나옴

        System.out.println(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.HOUR)+":"+cal.get(Calendar.SECOND)+":"+cal.get(Calendar.AM_PM));


        //날짜는 이렇게 출력한다.
        //SimpleDateFormat 클래스 -- sql 과 비슷
        //날짜나 시간 표시를 좀 더 편하게 다루기 위해 사용
        String dfmt="yyyy-MM-dd";  //년월일   월만 대문자를 사용한다.
        String tfmt="HH-mm-ss E";   //시분초 요일
        
        SimpleDateFormat sdf=new SimpleDateFormat(dfmt);
        System.out.println(sdf.format(today));  //Date today=new Date(); 위에 이렇게 정의해줬음

        sdf=new SimpleDateFormat(tfmt);
        System.out.println(sdf.format(today));





        //래퍼클래스
        //기본자료형 데이터를 클래스형 데이터로 취급 할 때 사용하는 클래스

        int f = 1;
        System.out.println(f);
        
        Integer g=new Integer(f);  //이걸 박싱이라 한다 -  박싱 : 기본형->클래스형 으로 변경시킴 -출력 해본다면 별차이는 없다 형태만 변한 것이기에
        System.out.println(g);

        int h = g.intValue();  // 언박싱 : 클래스형 - > 기본형
        System.out.println(h);

        //문자열 값을 기본 자료형/클래스형으로 변환  : parseXxx 사용

        int i = Integer.parseInt("12345");
        Integer j = Integer.parseInt("12345");


    }

}
