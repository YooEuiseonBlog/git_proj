package EssenceOFJava.ch12;
/*
    ch12-34 애너테이션 타입 정의하기
    - 애너테이션을 직접  만들어 쓸 수 있다.
        @interface 애너테이션이름 {
            타입 요소이름();        //  애너테이션의 요소를 선언한다.
                ...
        }
        @interface DataTime {
            String yymmdd();
            String hhmmss();
        }
    - 애너테이션의 메서드는 추상 메서드(구현X)이며, 애너테이션을 적용할 때 지정(순서X)
        
        @interface TestInfo {
            int         count();
            String      testedBy();
            String[]    testTools();
            TestType    testType(); //  enum TestType{FIRST, FINAL}
            DateTime    testDate(); //  자신이 아닌 다른 애너테이션(@DateTime)을 포함할 수 있다.    
        }

        @TestInfo (
            count=3, testedBy="kim", 
            testTools={"JUnit", "AutoTester"},
            testType=TestType.FIRST,
            testDate=@DateTime(yymmdd="160101" hhmmss="235959")
        )
        public class NewClass { ... }
*/

import java.lang.annotation.*;

/*
    ch12-35 애너테이션의 요소
    - 적용시 값을 지정하지 않으면, 사용될 수 있는 기본값 지정 가능(null제외)
        @interface TestInfo {
            int count() default 1;      //  기본값을 1로 지정
        }
        @TestInfo                       //  TestInfo(count=1)과 동일
        public class NewClass { ... }

    - 요소가 하나이고, 이름이 value일 때는 요소의 이름 생략가능 // ! 요소의 이름이 별루(value)일 때는 생략 가능!!
        @interface TestInfo {
            String value();
        }

        @TestInfo("passed")     //  @TestInfo(value="passed")와 동일
        class NewClass { ... }
    - 요소의 타입이 배열인 경우 괄호{}를 사용해야 한다.
        @interface Test {
            String[] testTools();
        }

        @Test(testTools={"JUnit", "AutoTester"})
        @Test(testTools="JUnit")
        @Test(testTools={})     //  값이 없을 때는 괄호{}가 반드시 필요

*/

/*
    ch12-36 모든 애너테이션의 조상 - java.lang.annotation.Annotation
    - Annotation은 모든 애너테이션의 조상이지만 상속은 불가
        @interface TestInfo extends Annotation {    //  에러.   허용되지 않는 표현
            int     count();
            String  testBy();
                ...
        }
    - 사실 Annotation은 인터페이스이다.
        package java.lang.annotation;
        
        public interface Annotation {   //  Annotation자신은 인터페이스이다.
            //추상메서드    ---> 구현 X But 사용가능
            boolean equals(Object obj);
            int hashCode();
            String toString();

            Class<? extends Annotation> annotationType();       //  애너테이션의 타입을 반환

        }
*/

/*
    ch12-37 마커애너테이션 - Marker Annotation
    - 요소가 하나도 정의되지 않은 애너테이션
        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.SOURCE)
        public @interface Override {}       //  마커 애너테이션. 정의된 요소가 하나도 없다.
        
        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.SOURCE)
        public @interface Test {}           //  마커 애너테이션. 정의된 요소가 하나도 없다.

        @Test //    이 메서드는 테스트 대상임을 테스트 프로그램에게 알린다.
        public void method() {
                ...
        }
        
        @Deprecated
        public int getDate() {
            return normalize().getDayOfMonth();
        }
*/

/*
    ch12-38 애너테이션 요소의 규칙
    - 애너테이션의 요소를 선언할 때 아래의 규칙을 반드시 지켜야 한다.
        ● 요소의 타입은 기본형, String, enum, 애너테이션(Annotation), Class(설계도 객체/ 9장 참고)만 허용
        ● 괄호()안에 매개변수를 선언할 수 없다.
        ● 예외를 선언할 수 없다.
        ● 요소를 타입 매개변수로 정의할 수 없다.

    - 아래의 코드에서 잘못된 부분이 무엇인지 생각해보자.
        @interface AnnoTest {
            (static final) int id = 100;    <--- 상수 Ok.  default메서드 X
            String major(int i, int j);     <--- 매개변수 X
            String minor() throws Exception;    <--- 예외 선언 X
            ArrayList<T> list();        <--- 타입 매개변수 X
        }
*/
@Deprecated
@SuppressWarnings("1111")      //   유효하지 않은 애너테이션은 무시된다.
@TestInfo(testedBy ="aaa", testTools = {"JUnit", "JUnit5"} , testDate = @DateTime(yymmdd="160101", hhmmss="235959"))
public class Ch12_34_DefineAnnotation {
    // Ch12_34_DefineAnnotation의 Class객체를 얻는다.
    public static void main(String[] args) {
        Class<Ch12_34_DefineAnnotation> cls = Ch12_34_DefineAnnotation.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testBy()="+anno.testedBy());
        System.out.println("anno.testDate().yymmdd()="+ anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss()="+ anno.testDate().hhmmss());

        for(String str : anno.testTools())
            System.out.println("testTools="+str);
        System.out.println();
        
        // Ch12_34_DefineAnnotation에 적용된 모든 애너테이션을 가져온다.
        Annotation[] annoArr = cls.getAnnotations();

        for (Annotation a : annoArr) {
            System.out.println(a);
        }
    }//main
}// main class

@Retention(RetentionPolicy.RUNTIME) //  실행 시에 사용가능하도록 지정
@interface TestInfo {
    int         count()         default 1;
    String      testedBy();
    String[]    testTools()     default "JUnit";
    TestType    testType()      default TestType.FIRST;
    DateTime    testDate();
}

@Retention(RetentionPolicy.RUNTIME) //  실행 시에 사용가능하도록 지정
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType {FIRST, FINAL}

