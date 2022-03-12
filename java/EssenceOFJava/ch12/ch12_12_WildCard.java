package EssenceOFJava.ch12;

import java.util.ArrayList;

/* ch12-12 와일드 카드 <?>
 * - 하나의 참조 변수로 대입된 타입이 다른 객체를 참조 가능
 * --------------------------------------------------------------------------------------------------
 *      ArrayList<? extends Product> list = new ArrayList<Tv>();    //  OK.
 *      ArrayList<? extends Product> list = new ArrayList<Audio>(); //  OK.
 *      ArrayList<Product> list = new ArrayList<Tv>();              //  Error. 대입된 타입 불일치
 * --------------------------------------------------------------------------------------------------
 * <? extends T>    와일드 카드의 상한 제한, T와 그 자손들만 가능
 * <? super T>      와일드 카드의 하한 제한, T와 그 조상들만 가능
 * <?>              제한 없음. 모든 타입이 가능. <? extends Object>와 동일
 * --------------------------------------------------------------------------------------------------
 * - 메서드의 매개변수에 와일드 카드를 사용
 * --------------------------------------------------------------------------------------------------
 * static Juice makeJuice(FruitBox<? extends Fruit> box) {
 *      String tmp = "";
 *      for(Fruit f : box.getList()) tmp+= f + " ";
 *      return new Juice(tmp);
 * }
 * ---> System.out.println(Juicer.makeJuice(new FruitBox<Fruit>()));    //  가능
 * ---> System.out.println(Juicer.makeJuice(new FruitBox<Apple>()));    //  가능
 * 
 */

 /*
 *  ch12-14 지네릭 메서드
 * - 지네릭 타입이 선언된 메서드(타입 변수는 메서드 내에서만 유효)
 *      static <T> void sort (List<T> list, comparator<? super T> c)
 * - 클래스의 타입 매개변수<T>와 메서드의 타입 매개변수 <T>는 별개
 * --------------------------------------------------------------------------------------------------
 *      class FruitBox<T> { <---- 지네릭 클래스
 *              ...
 *          static <T> void sort (List<T> list, comparator<? super T> c) {
 *              ...             //  클래스와 메서드의 타입변수가 일치하지만 메서드 <T>와 클래스<T> 다른 타입 변수!!
 *          } -----> 지네릭 메서드
 * }    
 * --------------------------------------------------------------------------------------------------
 * - 메서드를 호출할 때마다 타입을 대입해야(대부분 생략 가능)
 * --------------------------------------------------------------------------------------------------
 *      Juicer.<Fruit>makeJuice(fruitBox);
 *      Juicer.makeJuice(fruitBox);             ----> 지네릭 타입변수 생략 가능
 *      Juicer.<Apple>makeJuice(fruitBox);
 *      Juicer.makeJuice(fruitBox);             ----> 지네릭 타입변수 생략 가능
 *      
 *      static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
 *  ==  static Juice makeJuice(FruitBox<? extends Fruit> box) {
 *          String tmp = "";
 *          for(Fruit f : box.getList()) tmp += f + " ";
 *          return juice(tmp);
 * }
 * --------------------------------------------------------------------------------------------------
 * - 메서드를 호출할 때 타입을 생략하지 않을 때는 클래스 이름 생략 불가.
 * --------------------------------------------------------------------------------------------------
 *      <Fruit>makeJuice(fruitBox);         --->  에러. 클래스 이름 생략불가
 *      this.<Fruit>makeJuice(fruitBox)         // OK.
 *      Juicer.<Fruit>makeJuice(fruitBox)       // OK.
 * --------------------------------------------------------------------------------------------------
 * - 와일드 카드 : 하나의 참조변수로 서로 다른 타입이 대입된 여러 지네릭 객체를 다루기 위한 것
 * - 지네릭 메서드 : 메서드를 호출할 때마다 다른 지네릭 타입을 대입할 수 있게 한 것 
 */
class Fruit2 {public String toString() {return "Fruit";}}
class Apple2 extends Fruit2 { public String toString() {return "Apple";}}
class Grape2 extends Fruit2 { public String toString() {return "Grape";}}
class Juice {
    String name;
    Juice(String name) {this.name = name + "Juice";}
    public String toString() { return name; }
}

class Juicer {
    static Juice makeJuice(FruitBox2<? extends Fruit2> box) {
        String tmp ="";
        for(Fruit2 f : box.getList())
            tmp += f + " ";
        return new Juice(tmp);
    }
}
public class ch12_12_WildCard {
    public static void main(String[] args) {
        FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
        FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
        // Fruit2와 그 자손들 Apple2, Grape2
        // FruitBox2<? extends Fruit2> appleBox = new FruitBox2<Apple2>();
        // appleBox = new FruitBox2<Fruit2>();
        // appleBox = new FruitBox2<Apple2>();
        // appleBox = new FruitBox2<Grape2>();


        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
        appleBox.add(new Apple2());
        
        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
    }//main
}//class

class FruitBox2<T extends Fruit2> extends Box2<T> {}

class Box2<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) {list.add(item);   }
    T get(int i)    { return list.get(i); }
    ArrayList<T> getList() {return list; }
    int size() {return list.size();}
    public String toString() {return list.toString();}
}
 