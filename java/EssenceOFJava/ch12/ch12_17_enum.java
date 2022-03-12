package EssenceOFJava.ch12;
/**
 * ch12-17 열거형(enum)
 * - 관련된 상수들을 같이 묶어 놓는 것. java는 타입에 안전한 열거형을 제공	//	값&타입의 체크
 *      class Card {
 *          //  카드 무늬                                                                   class Card {      0      1       2       3
 *          static final int CLOVER = 0;                                                        enum Kind {CLOVER, HEART, DIAMOND, SPADE}   //  열거형 Kind를 정의
 *          static final int HEART = 1;                                                                      0     1     2   
 *          static final int DIAMOND = 2;                                                       enum Value {TWO, THREE, FOUR}               //  열거형 Value를 정의     
 *          static final int SPADE = 3;            -------------------------------->            final Kind kind;        //  타입이 int가 아닌 Kind임에 유의하자.
 *                                                                                              final Value value;  
 *          //  카드 숫자                                                                   }    
 *          static final int Two = 0;
 *          static final int THREE = 1;
 *          static final int FOUR = 2;
 *          
 *          final int kind;
 *          final int num;
 *      }
 * 
 * 			if(Card.CLOVER==Card.TWO)		//	true지만 false이어야 의미상 맞음.
 * 			enum
 * 			if(Card.Kind.CLOVER == Card.Value.TWO) {// 컴파일 에러. 타입이 달라서 비교 불가} ---> Java의 열거형: 값 & 타입 모두 체크한다.
 * 
 */

 /**
	ch12-18 열거형의 정의와 사용
	- 열거형을 정의하는 방법
			enum 열거형 이름 {상수명1, 상수명2, ...	}
			ex) enum Direction {	EAST, SOUTH, WEST, NORTH	}
	- 열거형 타입의 변수를 선언하고 사용하는 방법
			class Unit {
				int x, y;					//	유닛의 위치
				Direction dir;		// 	열거형 인스턴스 변수를 선언

				void init() {
					dir = Direction.EAST; 		//	유닛의 방향을 EAST로 초기화
				}
			}
	- 열거형 상수의 비교에 ==와 compareTo() 사용가능
			if(dir==Direction.EAST) {
					x++;
			} else if (dir > Direction.WEST) {	//	Error. 열거형 상수에 비교연산자 사용 불가
					...
			} else if (dir.compareTo(Dircetion.WEST)>0) {		//	compareTo()는 가능. ---> compareTo(): 왼쪽이 크면 양수, 같으면 0, 오릉쪽이 크면 음수.
					...
			}
  */
	
	/**
	 * ch12-19 열거형의 조상 - java.lang.Enum
	 * - 모든 열거형은 Enum의 자손이므로, 아래의 메서드를 상속받는다.
	 * 		String name()		열거형 상수의 이름을 문자열로 반환
	 * 		int ordinal()		열거형 상수가 정의된 순서를 반환(0부터 시작)
	 * 		T valueOf(Class<T> enumTpye, String name)  지정된 열거형에서 name과 일치하는 열거형 상수를 반환
	 * 
	 * - values(), valueOf()는 컴파일러가 자동으로 추가
	 * 			static E[] values()
	 * 			static E valueOf(String name)		----> Direction d = Direction.valueOf("WEST"); //---> 열거형 상수이름을 매개변수로 사용.
	 * 				
	 * 				Direction[] dArr = Direction.values();
	 * 				
	 * 				for(Direction d : dArr) //--->> for (Direction d : Direction.values())
	 * 						System.out.printf("%s=%d%n", d.name(), d.ordinal());
	 */
enum Dircetion {EAST, SOUTH, WEST, NORTH}
public class ch12_17_enum {
    public static void main(String[] args) {
        Dircetion d1 = Dircetion.EAST;	//	열거형타입.상수이름
				Dircetion d2 = Dircetion.valueOf("WEST");
				Dircetion d3 = Enum.valueOf(Dircetion.class, "EAST");

				System.out.println("d1="+d1);
				System.out.println("d2="+d2);
				System.out.println("d3="+d3);

				System.out.println("d1==d2 ? " + (d1==d2));		//	false
				System.out.println("d1==d3 ? " + (d1==d3));		//	true
				System.out.println("d1.equals(d3) ? " + d1.equals(d3));	// true
				// System.out.println("d2 > d3 ? " + (d1 > d3));		// Error. because of 객체라서.
				System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
				System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));

				switch(d1) {
					case EAST : 		//	Direction.EAST라고 쓸 수 없다.
							System.out.println("The direction is EAST."); break;
					case SOUTH :
							System.out.println("The direction is SOUTH."); break;
					case WEST :
							System.out.println("The direction is WEST."); break;
					case NORTH :
							System.out.println("The direction is NORTH."); break;
					default :
							System.out.println("Invailed direction."); break;
				}//switch

				Dircetion[] dArr = Dircetion.values();		//		열거형의 모든 상수를 배열로 반환

				for(Dircetion d : dArr) {	//	for(Direction d : Direction.values())
					System.out.printf("%s=%d%n", d.name(), d.ordinal());//순서
				}
    }//main
}//class
