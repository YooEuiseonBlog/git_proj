package EssenceOFJava.ch12;
/**
 * ch12-16 지네릭 타입의 제거 -------> 하위호환성 ----> 안정성
 * - 컴파일러는 지네릭 타입을 제거하고, 필요한 곳에 형변환을 넣는다.
 *      ① 지네릭 타입의 경계(bound)를 제거										compiler					Object ---> <T> //	--- compile --->	//	<T> ---> Object //하위호환성 
 *      	class Box<T extends Fruit> {						---->  		class Box {
 *      		void add (T t) {																	void add(Fruit t) {		----> 원래 Object로 바뀌지만, extends로 제한된 경우는 최상위 조상으로 치환됨.	
 * 									...																						...
 * 					}																									}
 *      }																									}
 * 			② 지네릭 타입 제거 후에 타입이 불일치하면, 형변환을 추가
 * 				T get(int i) {																							Fruit get(int i) {
 * 						return list.get(i);							------------->							return (Fruit)list.get(i);---> list.get(i)---> Object
 * 				}																														}
 * 
 * 			③ 와일드 카드가 포함된 경우, 적절한 타입으로 형변환 추가
 * 				static Juice makeJuice(FruitBox<? extends Fruit> box) {																	static Juice makeJuice(FruitBox box) {
 * 						String tmp ="";																																					String tmp = "";
 * 						for(Fruit f : box.getList())												-----------------------------> 			Iterator it = box.getList().iterator();		
 * 								tmp += f + " ";																																			while(it.hasNext()) {
 * 						return new Juice(tmp);																																			tmp +=  (Fruit)it.next() +  " "; // it.next --> Object객체
 * 			}																																															}
 * 																																																		return new Juice(tmp);
 * 																																																}
 * 																																							
 */			
public class ch12_16_DeleteGenerics {
    public static void main(String[] args) {
        
    }
}
