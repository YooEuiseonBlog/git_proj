package EssenceOFJava.ch07;
/*
    ch07-34 추상클래스의 작성   // 다형성 - 2번째 장점:  한 배열에 여러가지 객체를 집어넣을 수 있다.
    - 여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나 기존 클래스의 공통부분을 뽑아서 추상클래스를 만든다.
*/

/*
    ch07-34 추상클래스의 작성
    - 추상화 /불명확 <----> 구체화 /명확, 구체적
    - 추상화된 코드는 구체화된 코드보다 유연하다. 변경에 유리
        GregorianCalendar cal = new GragorianCalendar();    //  구체적
        Calendar cal = Calendar.getInstance();      //  추상적  -----> calendar 자손 객체를 반환 ---> 불분명 / 뭘 반환할지 모름 / 추상화
        
        public static Calendar getInstance(Locale aLocale) {
            return createCalendar(TimeZone.getDefault(), aLocale);
        }
    */
abstract class Unit {
    int x, y;
    abstract void move(int x, int y);
    void stop() {/* 현재 위치에 정지 */}
}

class Marine extends Unit {
    void move(int x, int y) {
        System.out.println("Marine[x=" + x + ", y=" + y + "]");
    }
    void stimPack() {/* 스팀팩을 사용한다. */}
}

class Tank extends Unit {
    void move(int x, int y) {
        System.out.println("Tank[x=" + x + ", y=" + y + "]");
    }
    void changeMode() {/* 공격모드를 변환한다. */}
}

class Dropship extends Unit {
    void move(int x, int y) {
        System.out.println("Dropship[x=" + x + ", y=" + y + "]");
    }
    void load() {/* 선택된 대상을 태운다. */}
    void unload() {/* 선택된 대상을 내린다. */}
}
public class ch07_33_34_CreateAbstractClass {
    public static void main(String[] args) {
        // Unit[] group = {new Marine(), new Tank(), new Dropship()}; //---> 생성 + 초기화 // 객체배열!
        // 객체 배열 : 참조변수들을 묶은 것
        Unit[] group = new Unit[3];
        // Object[] group = new Unit[3];   // Object--> move메서드가 존재하지 않음. --->  에러가 발생함.
        group[0] = new Marine();
        group[1] = new Tank();
        group[2] = new Dropship();
        // int[] group = {1,2,3};
        /*
            int[] group = new int[3];
            group[0] = 1;
            group[1] = 2;
            group[2] = 3;
            ----> 위의 예시와 같은 원리이다.
        */

        // group의 타입은 Unit[], group[0], group[1], group[2]의 타입은 Unit
        for (int i = 0; i < group.length; i++) {
            group[i].move(100, 200);
        }
        /*  
            // group의 타입은 Unit[], group[0], group[1], group[2]의 타입은 Unit
            group[0].move(100, 200);    // Marine객체의 move(100, 200)을 호출
            group[1].move(100, 200);    // Tank객체의 move(100, 200)을 호출
            group[2].move(100, 200);    // Dropship객체의 move(100, 200)을 호출
        */
    }
}
