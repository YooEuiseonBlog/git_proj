package EssenceOFJava.ch12;

import java.util.ArrayList;

/*
 * ch12-9 제한된 지네릭 클래스
 * - extend로 대입할 수 있는 타입을 제한
 * ------------------------------------------------------------------------------------------
 * class FruitBox<T extends Fruit> {    //  Fruit의 자손만 타입으로 지정가능
 *      ArrayList<T> list = new ArrayList<T>();
 *      ...
 * }
 * FruitBox<Apple> appleBox = new FruitBox<Apple>();    //  OK.
 * FruitBox<Toy>    toyBox  = new FruitBox<Toy>();      //  Error. Toy는 Fruit의 자손이 아님.
 * ------------------------------------------------------------------------------------------
 * - 인터페이스인 경우에도 extends를 사용.
 * ------------------------------------------------------------------------------------------
 * interface Eatable {}
 * class FruitBox<T extends Eatable> { ... }
 * 
 * ch12-11 지네릭스의 제약
 * - 타입 변수에 대입은 인스턴스 별로 다르게 가능
 *   Box<Apple> appleBox = new Box<Apple>();    //  OK. Apple객체만 저장가능
 *   Box<Grape> grapeBox = new Box<Grape>();    //  OK. Grape객체만 저장가능
 * 
 * - static멤버에 타입 변수 사용 불가   // static ---> 모든 인스턴스에 공통
 *   class Box<T> {
 *      static T item;  //  에러.
 *      static int compare(T t1, T t2) { ... } // 에러.
 *          ...
 *      }
 * 
 * - 배열 생성할 때 타입 변수 사용불가. 타입 변수로 배열 선언은 가능 / new 연산자 다음에 타입 변수를 쓸 수 없다!
 *      class Box<T> {
 *          T[] itemArr;        //  OK. T타입의 배열을 위한 참조변수
 *              ...
 *       }
 * 
 *      T[] toArray() {                                                              
 *          T[] tmpArr = new T[itemArr.length]; //  에러. 지네릭 배열 생성 불가  ---->/ new T (X) / 객체 생성이나 배열 생성 둘 다 안됨.
 *              ...                                                                  / new (객체타입 확정)
 *      }
 */
class Fruit implements Eatable {
    public String toString() {return "Fruit";}
}//Fruit
class Apple extends Fruit { public String toString() {return "Apple";}}
class Grape extends Fruit { public String toString() {return "Grape";}}
class Toy                 { public String toString() {return "Toy"  ;}}


interface Eatable {}

public class ch12_9_11_limitGenerics {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
        // FruitBox<Grape> grapeBox = new FruitBox<Apple>();    //  Error. 타입 불일치
        // FruitBox<Toy> toyBox = new FruitBox<Toy>();             //  Error.
        Box<Toy> toyBox2 = new Box<Toy>();                       //  Ok.    // Box는  제약이 없다.
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        // appleBox.add(new Grape());   //  Error. Grape는 Apple의 자손이 아님.
        grapeBox.add(new Grape()); 

        System.out.println("fruitBox-"+fruitBox);
        System.out.println("appleBox-"+appleBox);
        System.out.println("grapetBox-"+grapeBox);
    }//main
}//class

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>(); //  item을 저장할 list
    void add(T item) {  list.add(item); }   //  박스에 item을 추가
    T get(int i) {  return list.get(i); }   //  박스에서 item을 꺼낼 때
    int size()   {  return list.size(); }
    public String toString() { return list.toString();}
}