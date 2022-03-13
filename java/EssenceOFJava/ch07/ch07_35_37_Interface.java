package EssenceOFJava.ch07;
/*
    ch07-35 인터페이스(interface) : only 추상메서드 / 멤버변수X   <----------->   추상클래스 : 추상 메서드를 가지고 있는 일반 클래스
    - 추상 메서드의 집합    <---- 프로그래밍 관점                                              멤버변수 O 
    - 구현된 것이 전혀 없는 설계도. 껍데기(모든 멤버가 public)
        interface 인터페이스이름 {
            public static final 타입 상수이름 = 값;     <--- 상수   // 변수 X iv X cv X
            public abstract 메서드 이름(매개변수목록);  <--- 추상 메서드***
        }

        interface PlayingCard {
            //  상수
            public static final int SPADE = 4;  //  항상 public static final(상수). 예외없이/ 그래서 생략 가능!
            final int DIAMOND = 3;              //  public static final int DIAMOND = 3;
            static int HEART = 2;               //  public static final int HEART = 2;
            int CLOVER = 1;                     //  public static final int CLOVER = 1;

            //  추상 메서드
            public abstract String getCardNumber();
            String getCardKind();               //  public abstract String getCardKind();   //  생략 가능
        }
*/

/*
    ch07-36 인터페이스의 상속
    - 인터페이스의 조상은 인터페이스만 가능(Object가 최고 조상이 아님)
    - 다중 상속이 가능.(추상메서드는 충돌해도 문제 없음)    //  선언부가 다르면, 둘 다 상속받으면 그만인데. 선언부가 같고, 내용{}이 다르면 
                                                         //   어느쪽을 상속 받을지 결정할 수 없다. 
        interface Fightable extends Moveable, Attackable { *멤버가 두개*(각각 조상인터페이스에서 상속받아서) }

        interface Moveable {
            // 지정된 위치(x, y)로 이동하는 기능의 메서드
            void move(int x, int y);
        }

        interface Attackable {
            //  지정된 대상(u)을 공격하는 기능의 메서드
            void attack(Unit u);
        }
*/

/*
    ch07-37 인터페이스의 구현 //    인터페이스 <--- 미완성 설게도 => 완성: 인터페이스의 구현
    - 인터페이스에 정의된 추상 메서드를 완성하는 것
    //                     extends 추상클래스
        class 클래스이름 implements 인터페이스 이름 {
            //  인터페이스에 정의된 추상메서드를 모두 구현해야 한다.
        }

        // Fighter클래스는 Fightable 인터페이스를 구현했다.
        class Fighter implements Fightable {
            public void move(int x, int y) { *내용 생략* }  // 구현: 몸통{} 만들기
            public void attack(Unit u)     { *내용 생략* }
        }
    
     - 일부만 구현하는 경우, 클래스 앞에 abstract를 붙여야 함.
        
        abstract class Fighter implements Fightable {   ---->   추상 클래스
            public void move(int x, int y) { *내용 생략* }
            (public abstract void attack(Unit u);) ---> 안보이지만 존재함.
        }
*/

/*
    Q. 인터페이스란?
    A. 추상 메서드의 집합

    Q. 인터페이스의 구현이란?
    A. 인터페이스의 추상메서드 몸통{} 만들기(미완성 설계도 완성하기)
        
        abstract class Player {//   추상클래스(미완성클래스)
            abstract void play(int pos); // 추상메서드
            abstract void stop();        // 추상메서드
        }
        
        interface Fightable { // 인터페이스(미완성 클래스)
            void move(int x, int y);
            void attack(Unit u);
        }
        
        // 추상클래스의 구현
        class AudioPlayer extends Player {
            void play(int pos) { *내용 생략* }      // 추상메서드 구현
            void stop()        { *내용 생략* }      // 추상메서드 구현
        }


        // 인터페이스의 구현
        class Fighter implements Fightable {
            pulbic void move(int x, int y) { *내용 생략* }
            pulbic void attack(Unit u)     { *내용 생략* }
        }

    Q. 추상 클래스와 인터페이스의 공통점은?
    A. 추상 메서드를 가지고 있다.(미완성 설계도)

    Q. 추상 클래스와 인터페이스의 차이점은?
    A. 인터페이스는 iv를 가질 수 없다. ----> 인터페이스는 iv, 생성자, 인스턴스 메서드 불가능하다. only 추상메서드만 가능 
                                            (but static메서드/상수/추상메서드/디폴트메서드 가능)
*/
public class ch07_35_37_Interface {
    public static void main(String[] args) {
        
    }
}
