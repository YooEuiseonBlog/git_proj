package EssenceOFJava.ch07;
/*
    ch07-31 추상 클래스(abstract class)
    - 미완성 설계도. 미완성 메서드를 갖고 있는 클래스
        abstract class Player { //  추상클래스(미완성 클래스)
            abstract void play(int pos);     //  추상메서드(몸통{}이 없는 미완성 메서드)
            abstract void stop();            //  추상메서드
        }

    - 다른 클래스 작성에 도움을 주기 위한 것. 인스턴스 생성 불가.
        Player p = new Player();        //  Error. 추상클래스의 인스턴스 생성 불가 ----> 미완성 설계도 => 제품생산 불가
    
    - 상속을 통해 추상 메서드를 완성해야 인스턴스 생성가능
        class AudioPlayer extends Player {//완성된 설계도 ---> 객체 생성 가능
            void play(int pos) { ... }  //  추상메서드를 구현 <--- 추상메서드 몸통{} 만들기
            void stop() { ... }         //  추상메서드를 구현
        }
        //  조상                자손
        Player p       = new AudioPlayer();     //  다형성 ---> 조상인 추상 클래스 Player를 참조변수로 자손 인스턴스 생성가능
        AudioPlayer ap = new AudioPlayer();     //  Ok. //  완성된 설계도

*/

/*
    ch07-32 추상 메서드(abstract method)    <--- 몸통(구현부)가 없는 메서드 / 미완성 메서드
    - 미완성 메서드. 구현부(몸통,{})가 없는 메서드  // 메서드 = 선언부 + 구현부{} X
        /\* 주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다.*\ /
        abstract 리턴타입 메서드이름();   
        abstract : 제어자

    - 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우
        abstract class Player { //  추상클래스
            abstract void play(int pos);        //  추상메서드
            abstract void stop();               //  추상메서드
        }

        class AudioPlayer extends Player {      // 구현: 몸통{} 만들어주기
            void play(int pos) { ... }          //  추상메서드를 구현
            void stop() { ... }                 //  추상메서드를 구현
        }

        abstract class AbstractPlayer extends Player {  <---- 1개만 구현했기 떄문에 abstract 제어자를 붙어준다. --> 미완성
            void play(int pos) { ... }          //  추상메서드를 구현
        }
    
    - 추상 메서드 호출 가능(호출될 때는 선언부만 필요)
        abstract class Player {
            boolean pause;      //  일시상태를 저장하기 위한 변수
            int  currentPos;    //  현재 Play되고 있는 위치를 저장하기 위한 변수
            
            Player() {          //  추상클래스도 생성자가 있어야 한다.
                pause = false;
                currentPos = 0;
            }
            / 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 한다./
            abstract void play(int pos);        //  추상메서드

            //인스턴스 메서드 ---> 객체 생성 ---> 호출
            void play() {
                play(currentPos);               //  추상메서드를 사용할 수 있다.   // 필수기능 ---> 강제효과
            }                                   //  메서드는 선언부만 알면 호출가능하므로 추상메서드도 호출 가능!!!
            // 1.상속을 통해 자손이 추상메서드구현을 통해 완성{} ---> 2.객체생성 ---> 3. 호출
        }

*/   
public class ch07_31_32_AbstractClass {
    public static void main(String[] args) {
        // Player p = new Player();    //  추상 클래스의 객체를 생성 ---> 객체 생성 X
        // AudioPlayer ap = new AudioPlayer();
        Player ap = new AudioPlayer();  //  다형성
        ap.play(100);
        ap.stop();
    }
}

abstract class Player { //  추상 클래스(미완성 클래스, 미완성 설계도)
    abstract void play(int pos);    //  추상 메서드(미완성 메서드)
    abstract void stop();           //  추상 메서드(선언부만 있고, 구현부{}가 없는 메서드)
}

// 추상 클래스는 상속을 통해 완성해야 객체 생성가능
abstract class AudioPlayer extends Player {
    void play(int pos) { System.out.println(pos+"위치부터 play합니다.");}
    // void stop() { System.out.println("재생을 멈춥니다.");}
} 