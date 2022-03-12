package EssenceOFJava.ch07;
/*
    ch07-23 다형성(polymorphism)
    - 여러 가지 형태를 가질 수 있는 능력
    - 조상 타입 참조 변수로 자손 타입 객체를 다루는 것
    - 객체와 참조변수의 타입이 일치할 때와 일치하지 않을 때의 차이?
        smartTv s = new Smart Tv();     //  참조변수와 인스턴스의 타입이 일치               ---->   모든 기능 사용가능
        Tv      t = new Smart Tv();     //  조상 타입 참조변수로 자손 타입 인스턴스 참조    ----> Tv의 클래스 정의된 기능만 가능
    
    - 자손 타입의 참조변수로 조상 타입의 객체를 가리킬 수 없다.
        Tv  t = new SmartTv();      //  Ok. 허용
        Smart Tv s = new Tv();      //  Error. 허용 안됨.

    Q. 참조변수의 타입은 인스턴스의 타입과 반드시 일치해야 하나요?
    A. 아닙니다. 일치하는 것은 보통이지만, 일치 하지 않을 수도 있습니다.
        SmartTv s = new SmartTv();      //     참조변수와 인스턴스의 타입이 일치                ---> 타입 일치
        //  조상        자손
        Tv      t = new SmartTv();      //      조상 타입 참조변수로 자손 타입 인스턴스 참조    --->  타입 불일치

    Q. 참조변수가 조상타입일 때와 자손타입일 때의 차이?
    A. 참조변수로 사용할 수 있는 멤버의 갯수가 달라집니다.

    Q. 자손 타입의 참조변수로 조상 타입의 객체를 가리킬 수 있나요?
    A. 아니요. 허용되지 않습니다.
        Tv      t = new SmartTv();      //  Ok. 허용
        SmartTv s = new Tv();           //  Error. 허용 안됨
*/      
public class ch07_23_polymorphism {
    public static void main(String[] args) {
       /*조상타입*/ Tv t = new SmartTv(); /*자손타입 */       // 타입 불일치 Ok.
    }
}

class Tv {
    boolean power;      //  전원상태(on/off)
    int channel;        //  채널

    void power()        {  power = !power; }
    void channelUp()    { ++channel; }
    void channelDown()  { --channel; }
}

class SmartTv extends Tv {
    String text; //캡션(자막)을 보여 주기 위한 문자열
void caption() {    /*내용생략*/}
}
