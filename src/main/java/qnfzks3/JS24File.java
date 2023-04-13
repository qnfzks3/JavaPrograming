package qnfzks3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringJoiner;

public class JS24File {
    public static void main(String[] args) {
        // 학번,이름,주소,생년월일,학과명,교수등으로
        // 구성된 2차원 표형태의 데이터를 student.dat에 저장
        
        //학생 객체 생성  - 이렇게 하는 이유 : 파일로 저장할 때 한줄 한줄 데이터가 나오기 때문에 알아보기가 힘들다. 그러면 이렇게 클래스 단위로 묶어보자
        Student std01 = new Student(201350050,"김무식","경기도 고양시","1988.3.22","컴공과",504);
        
        // 학생정보  파일 저장 위치 지정
        String fname = "c:/Java/students.dat";
        System.out.println(std01);
        //학생정보 파일에 저장
        FileWriter fw=null;
        try{
            fw=new FileWriter(fname);
            fw.write(std01.toString());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (Exception ex){

                }
            }

        }
        //파일에 저장된 학생정보를 읽어서 변수 (stdinfo)에 저장
        BufferedReader br = null;  // 항상 초기화로 시작이 관행으로 되어있다.
        FileReader fr= null;
        String stdinfo = "";

        try {
            fr = new FileReader(fname); //fname 저장 경로에 적은것들을 읽어와 fr 에 저장한 후에 버퍼로 더 효율적으로 읽을 수있게 한다.
            br = new BufferedReader(fr);

            while (br.ready()){
                stdinfo= br.readLine();
                System.out.println(br.readLine());
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            if(br !=null){
            }

        }
        //변수에 저장된 학생정보 출력 1
        System.out.println(stdinfo);

        // 변수에 저장된 학생정보 출력 2
        String[] info= stdinfo.split("[ ]"); // split를 사용하여 공백으로 으로 나누어서 info 배열에 저장

        System.out.println("학번 : "+ info[0]);
        System.out.println("이름 : "+ info[1]);
        System.out.println("주소 : "+ info[2]+info[3]);
        System.out.println("생년월일 : "+info[4]);
        System.out.println("학과 : "+ info[5]);
        System.out.println("교수 : "+ info[6]);

        //객체의 맴버변수 성질을 잃어버린채
        //모두 문자형으로 출력됨
        // 파일을 저장할때 클래스의 성질을 그대로 저장하고 나중에 가져올때 그대로 가져올수 있다 - JS25File 에서 계속...


    }
}

class Student {
    int hakbun;
    String name;
    String addr;
    String birth;
    String dept;
    int prof;



    public Student(int hakbun, String name, String addr, String birth, String dept, int prof) {
        this.hakbun = hakbun;
        this.name = name;
        this.addr = addr;
        this.birth = birth;
        this.dept = dept;
        this.prof = prof;


    }

    @Override
    public String toString() {
        String fmt="%d %s %s %s %s %d \n";
        return String.format(fmt, hakbun,name,addr,birth,dept,prof);
    }


}

