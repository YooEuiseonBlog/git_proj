package EssenceOFJava.ch12;
/*
 * ch12-23 애너테이션이란?
 * - 주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보를 제공
 * - 애너테이션의 사용예
 *      @test // 이 메서드가 테스트 대상임을 테스트 프로그램에게 알린다.
 *      public void method() {
 *              ... 
 *      } 
 */

 /*
 * ch12-24 표준 애너테이션
 * - Java에서 제공하는 애너테이션
 *      @Override 컴파일러에게 오버라이딩 당하는 메서드라는 것을 알린다.
 *      @Deprecated 앞으로 사용하지 않는 것을 권장하는 대상에 붙인다.
 *      @SuppressWarnings  컴파일러의 특정 경고메세지가 나타나지 않게 해준다.
 *      @SafeVarargs 지네릭스 타입의 가변인자에 사용한다.
 *      @FunctionalInterface 함수형 인터페이스라는 것을 알린다.
 *      @Native native메서드에서 참조되는 상수 앞에 붙인다.
 * ---------- 메타 애니테이션 : 애니테이션을 만들 때 사용-----------------------------------------------------------
 *      @Target* 애너테이션이 적용가능한 대상을 지정하는데 사용한다.
 *      @Documented* 애너테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다.
 *      @Inherited* 애너테이션이 자손 클래스에 상속되도록 한다.
 *      @Retention* 애너테이션이 유지되는 범위를 지정하는데 사용한다.
 *      @Repeatable*    애너테이션을 반복해서 적용할 수 있게 한다.  
 */

 /*
    12-25 @Override     ------------> javac.exe
    - 오버라이딩을 올바르게 했는지 컴파일러가 체크하게 한다.
    - 오버라이딩할 때 메서드 이름을 잘못적는 실수를 하는 경우가 많다.
    - 오버라이딩할 때는 메서드 선언부 앞에 @Override를 붙이자.
        class Child extends Parents {                        class Child extends Parents {
            void parentmethod(){ }          ----------->        @Override
        }                                                       void parentmethod() {}
                                                                }
 */

 /* 
   ch12-26 @Deprecated
   - 앞으로 사용하지 않을 것을 권장하는 필드나 메서드에 붙인다.
   - @Deprecated의 사용 예, Date클래스의 getDate()
        @Deprecated
        public int getDate() {
            return normalize().getDayOfMonth();
        }
   - @Deprecated가 붙은 대상이 사용된 코드를 컴파일하면 나타나는 메세지
        Note: AnnotationEx2.java uses or overrides a deprecated API.
        Note: Recompile with -Xlint:deprecation for details. 
 */

 /*
   ch12-27 @FuncitonalInterface
   - 함수형 인터페이스에 붙이면, 컴파일러가 올바르게 작성했는지 체크
   - 함수형 인터페이스에는 하나의 추상메서드만 가져야한다는 제약이 있음.
        @FunctionalInterface
        public interface Runnable {
            public abstract void run(); // 추상 메서드
        }
 */
/*
    ch12-28 @SuppressWarnings
    - 컴파일러의 경고메시지가 나타나지 않도록 억제한다.
    - 괄호()안에 억제하고자하는 경고의 종류를 문자열로 지정
        @SuppressWarnings("unchecked")      //  지네릭스와 관련된 경고를 억제
        ArrayList list = new ArrayList();   //  지네릭 타입을 지정하지 않았음.
        list.add(obj);                      //  여기서 경고가 발생
    - 둘 이상의 경고를 동시에 억제하려면 다음과 같이 한다.
        @SuppressWarnings({"deprecation", "unchecked", "varargs"})
    - '-Xlint'옵션으로 컴파일하면, 경고메세지를 확인할 수 있다.
        괄호[]안이 경고의 종류. 아래의 경우 rawtypes
            -Xlint AnnotationTest.java
                ...warning: |rawtypes| found raw type: List...
*/
public class ch12_23_24_Annotation {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Child c = new Child();
        c.parentmMethod();   // deprecated된 메서드 사용
    }
}

class Parents2 {
    void parentmMethod() {}
}

class Child extends Parents2 {
    @Override
    @Deprecated
    void parentmMethod() {}    // 조상 메서드의 이름을 잘못 적었음.
    //
}   
@FunctionalInterface    //  함수형 인터페이스는 하나의 추상 메서드만 가능      
interface Testable {    //  Invalid '@FunctionalInterface' annotation; Testable is not a functional interface
    void test(); // 추상 메서드
    // void check(); // 추상 메서드 
}
