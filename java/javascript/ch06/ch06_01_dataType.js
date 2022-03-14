/*
    ch06 데이터 타입
    - 원시타입
        - 숫자타입(number)      : 숫자, 정수와 실수 구분없이 하나의 숫자타입만 존재
        - 문자열타입(String)    : 문자열
        - 불리언타입(boolean)   : 논리적 참(true)과 거짓(false)
        - undefined타입         : var 키워드로 선언된 변수에 암묵적으로 할당되는 값
        - null 타입             : 값이 없다는 것을 의도적으로 명시할 때 사용하는 값
        - 심벌symbol타입        : ES6에서 추가된 7번째 타입
    
    - 객체타입
        - 객체, 함수, 배열등  
*/

/*
    ch06-1 숫자 타입
    - 하나의 숫자타입만 갖는다.(배정밀도 65비트 부동소수점 형식)
*/
//Ex 06-01
/*모두 숫자 타입이다. */
var integer = 10;   //정수
var double = 10.12; //실수
var negativ = -20;  //음의 정수

//Ex 06-02
var binary = 0b01000001; // 2진수
var octal = 0o101;       // 8진수
var hex = 0x41;          // 16진수

// 표기법만 다를 뿐 모두 같은 값이다.
console.log(binary);            //  65
console.log(octal);             //  65
console.log(hex);              //  65
console.log(binary === octal);   //  true
console.log(octal ===  hex);     //  ture

//Ex 06-03
// 숫자타입은 모두 실수로 처리된다.
console.log(1 === 1.0); //  true
console.log(4/2);       //  2
console.log(3/2);       //  1.5

/*
    ● Infinity: 양의 무한대
    ● -Infinity: 음의 무한대
    ● NaN 산술 연산 불가(not-a-number)
*/

//Ex 06-04
//  숫자타입의 세 가지 특별한 값
console.log(10/0);          //  Infinity
console.log(10/-0);         //  -Infinity
console.log(1*'String');    //  NaN

//Ex 06-05
//자바스크립트는 대소문자 구별한다.
var x = nan;





