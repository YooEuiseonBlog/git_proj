package EssenceOFJava.ch07;
/*
    ch07-34 추상클래스의 작성   // 다형성 - 2번째 장점:  한 배열에 여러가지 객체를 집어넣을 수 있다.
    - 여러 클래스에 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나 기존 클래스의 공통부분을 뽑아서 추상클래스를 만든다.
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
        // Unit[] group = {new Marine(), new Tank(), new Dropship()}; //---> 생성 + 초기화
        Unit[] group = new Unit[3];
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
        for (int i = 0; i < group.length; i++) {
            group[i].move(100, 200);
        }
    }
}
