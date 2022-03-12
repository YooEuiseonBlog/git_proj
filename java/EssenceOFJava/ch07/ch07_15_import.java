package EssenceOFJava.ch07;
/*
    ch07-15 import문
    - 클래스를 사용할 때 패키지 이름을 생략할 수 있다.
    - 컴파일러에게 클래스가 속한 패키지를 알려준다.
    - java.lang 패키지의 클래스는 import하지 않고도 사용할 수 있다.
        String, Object, System, Thread ...
*/

/*
    ch07-15 import문 선언
    - import문을 선언하는 방법은 다음과 같다.
        import 패키지명.클래스명;
            또는
        import 패키지명.*; * <---모든클래스
    
    - import문은 패키지문과 클래스선언의 사이에 선언한다.
    - import문은 컴파일 시에 처리되므로 프로그램의 성능에 영향없음.
    - 다음 두 코드는 서로 의미가 다르다.
        import java.util.*;     <---->       import java.*; // java 패키지의 모든 클래스(패키지는 포함안됨)
        import java.text.*;
    
    - 이름이 같은 클래스가 속한 두 패키지를 import할 때는 클래스 앞에 패키지명을 붙여줘야 한다.
        import java.sql.*;      //  java.sql.Date
        import java.util.*;     //  java.util.Date
            ...
            java.util.Date  today = new java.util.Date();
            ...
*/

/*
    ch07-16 static import문
    - static멤버를 사용할 때 클래스 이름을 생략할 수 있게 해준다.
        import static java.lang.Integer.*;      //  Integer클래스의 모든 static메서드 / * <--- 모든 static멤버(static변수, static메서드)
        import static java.lang.Math.random;    //  Math.random()만. 괄호 안붙임.
        import static java.lang.System.out;     //  System.out을 out만으로 참조가능 / out--->static변수

        System.out.println(Math.random());  <-------> out.println(random());
*/
import static java.lang.System.out;
import static java.lang.Math.*; // Math클래스의 모든 static멤버
public class ch07_15_import {
    public static void main(String[] args) {
        // System.out.println(Math.random());
        out.println(random());

        // System.out.println("Math.PI :" + Math.PI);
        out.println("Math.PI :" + PI);
    }
}
