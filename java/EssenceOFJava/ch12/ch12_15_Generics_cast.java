package EssenceOFJava.ch12;

import java.util.ArrayList;

public class ch12_15_Generics_cast {
  /*
   * ch12-15 지네릭 타입의 형변환
   * - 지네릭 타입과 원시타입 간의 형변환은 바람직하지 않다.(경고 발생)
   *    Box<Object> objBox = null;
   *    Box box = (box)objBox;              //  ok. 지네릭 타입 ----> 원시타입 *경고 발생
   *    objBox = (box<Object>)box;          //  ok. 원시타입 ----->  지네릭타입 *경고 발생
   *    
   * 
   *    Box<Object> objBox = null;
   *    Box<String> strBox = null;
   *    objBox = (Box<Object>)strBox;       //  Error. Box<String> ---> Box<Object>
   *    strBox = (Box<String>)objBox;       //  Error. Box<Object> ---> Box<String>
   * 
   * - 와일드 카드가 사용된 지네릭 타입으로는 형변환 가능
   *    Box<Object>     objBox = (Box<Object>)new Box<String>(); //  Error. 형변환 불가능
   *    Box<? extends Object> wBox = (Box<? extends Object>)new Box<String>();  //  OK.
   *    
   *    Box<? extends Object> wBox = (Box<? extends  Object>)(생략)new Box<String>(); // 위 문장과 동일
   *    Box<? extends Object> wBox = new Box<String>(); // 위 문장과 동일
   *    // Object와 그 자손
   *    
   *    //매개변수로 FruitBox<Fruit>, FruitBox<Apple>, FruitBox<Grape>등이 가능
   *    static Juice makeJuice(FruitBox<? extends Fruit> box) { ... }
   *    FruitBox<? extends Fruit> box = new FruitBox<Fruit>();    // OK.
   *    //  FruitBox<? extends Fruit> box = (FruitBox<? extends Fruit>) new FruitBox<Fruit>();
   *    FruitBox<? extends Fruit> box = new FruitBox<Apple>();    // OK.
   *    //  FruitBox<? extends Fruit> box = (FruitBox<? extends Fruit>) new FruitBox<Apple>();
   *    
   */
  
    public static void main(String[] args) {
        FruitBox<? extends Fruit> fbox = (FruitBox<? extends Fruit>)new FruitBox<Fruit>();
        // FruitBox<Apple> -> FruitBox<? extends Fruit> 가능
        FruitBox<? extends Fruit> abox =  new FruitBox<Apple>();  //  타입 불일치 ---> 형변환 필요

        // FruitBox<? extends Fruit> -> FruitBox<Apple> 가능? 가능!!!
        FruitBox<Apple> appleBox = (FruitBox<Apple>)abox;   //  OK. 경고 발생


    } // main
}// class

class Fruit implements Eatable {
  public String toString() {return "Fruit";}  
}//Fruit

class Apple extends Fruit { public String toString() {return "Apple";}}
class Grape extends Fruit { public String toString() {return "Grape";}}
class Toy                 { public String toString() {return "Toy";}}

interface Eatable {}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

class Box<T> {
  ArrayList<T> list = new ArrayList<T>();   //  item을 저장할 list
  void add(T item) {  list.add(item); }     //  박스에 item을 추가
  T get(int i)     {  return list.get(i); } //  박스에서 item을 꺼낼 때
  int size()       {  return list.size(); }
  public String toStiString() { return list.toString(); }
}