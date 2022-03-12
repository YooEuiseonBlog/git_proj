package EssenceOFJava.ch12;
import static java.lang.annotation.ElementType.*;
/*
    ch12-29 메타 애너테이션 <--- 애너테이션을 만들 때  사용
    - 메타 애너테이션은 '애너테이션을 위한 애너테이션'
    - 메타 애너테이션은 java.lang.annotation패키지에 포함
        @Target         애너테이션이 적용가능한 대상을 지정하는데 사용한다.
        @Documented     애너테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다.
        @Inherited      애너테이션이 자손클래스에 상속되도록 한다.
        @Retention      애너테이션이 유지되는 범위를 지정하는데 사용한다.
        @Repeatable     애너테이션을 반복해서 적용할 수 있게 한다.(JDK1.8)
*/

import java.lang.annotation.Target;

/*
    ch12-30 @Target
    - 애너테이션을 정의할 때, 적용대상 지정에 사용
        @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
        @Rentention(RetentionPolicy.SOURCE)
        public @interface SuppressWarnings {
            String[] value();
        }
    
        ANNOTATION          애너테이션
        CONSTRUCTOR         생성자
        FIELD               필드(멤버변수, enum상수)
        LOCAL_VARIABLE      지역변수
        METHOD              메서드
        PACKAGE             패키지
        PARAMETER           매개변수
        TYPE                타입(클래스, 인터페이스, enum)
        TYPE_PARAMETER      타입 매개변수(JDK1.8)
        TYPE_USE            타입이 사용되는 모든 곳(JDK1.8)
*/
@Target({FIELD, TYPE, TYPE_USE})        //  적용대상이 FIELD, TYPE, TYPE_USE
public @interface MyAnnotation { }   //  MyAnnotation을 정의

@MyAnnotation   //  적용대상이 TYPE인 경우  ---> 클래스, 인터페이스
class MyClass {
    @MyAnnotation   // 적용대상이 FIELD인 경우
    int i;          // 멤버변수

    @MyAnnotation       //  적용대상이 TYPE_USE인 경우
    MyClass mc;
}

/*
    ch12-31 @Retention
    - 애너테이션이 유지(retention)되는 기간을 지정하는데 사용
        SOURSE      소스파일에만 존재. 클래스파일에는 존재하지 않음.
        CLASS       클래스 파일에 존재. 실행시에 사용불가. 기본값
        RUNTIME     클래스 파일에 존재. 실행시에 사용가능.
    - 컴파일러에 의해 사용되는 애너테이션의 유지 정책은 SOURCE이다.
        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.SOURCE)
        public @interface Override {}
    - 실행시 사용 가능한 애너테이션의 정책은 RUNTIME이다.
        @Documented
        @Retention(RetentionPolicy.RUNTIME)----->RUNTIME까지 유지
        @Target(ElementType.TYPE)
        public @interface FunctionalInterface   {}
*/

/*
    ch12-32 @Documented, @Inherited
    - javadoc으로 작성된 문서(*.html)에 포함시키려면 @Documented를 붙인다.
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.TYPE)
        public @interface FuncitonalInterface {}
    - 애너테이션을 자손 클래스에 상속하고자 할 때, @Inherited를 붙인다.
        @Inherited              //@superAnno가 자손까지 영향 미치게// 조상 애너테이션
        @interface SuperAnno {} 

        @SuperAnno
        class Parent{}

        class Child extends Parent {}       //  Child에 애너테이션이 붙은 것으로 인식

*/

/*
    ch12-33 @Repeatable
    - 반복해서 붙일 수 있는 애너테이션을 정의할 때 사용
        @Repaeatable(ToDos.class) //    ToDo애너테이션을 여러 번 반복해서 쓸 수 있게 한다.
        @interface ToDo {
            String value();
        }
    - @Reatable이 붙은 애너테이션은 반복해서 붙일 수 있다.
        @ToDo("delete test codes")
        @ToDO("Override inherited methods")
        class MyClass {
            ...
        }
    - @Repeatable인 @ToDo를 하나로 묶을 컨테이너 애너테이션도 정의해야 함.
        @interface ToDos {//    여러 개의 ToDo애너테이션을 담을 컨테이너 애너테이션 ToDos
            ToDo[] value();     //  ToDo애너테이션 배열타입의 요소를 선언. 이름이 반드시 value이어야 함.

        }

*/


public class ch12_29_MetaAnnotation {
    public static void main(String[] args) {
        
    }
}
