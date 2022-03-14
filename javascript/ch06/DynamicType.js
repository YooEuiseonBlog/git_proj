/*
    동적타이핑
    ■ 동적 타입 언어와 정적 타입 언어
    정적 타입 언어
        ● 명시적 타입 선언 explicit type declaration
            - 변수를 선언할 때 변수에 할당할 수 있는 값의 종류, 즉 데이터 타입을 사전에 선언해야 한다.  
        
        ● 타입 체크(선언한 데이터 타입에 맞는 값을 할당했는지 검사하는 처리)
            - 타입의 일관성을 강제함으로써 더욱 안정적인 코드의 구현을 통해 런타임 에러를 줄인다.
    
    동적 타입 언어
        ● 동적 타이핑
            - 자바스크립트의 변수는 선언이 아닌 할당에 의해 타입이 결정(타입 추론type inference)된다.
            - 재할당에 의해 변수의 타입은 언제든지 동적으로 변할 수 있다.
    
    ---> 따라서 동적 타입 언어는 유연함 대신 타입을 예측하기가 어려워 안정성이 떨어진다.
    변수를 사용할 때 주의사항
        1. 변수는 꼭 필요한 경우에 한해 제한적으로 사용한다.
        2. 변수의 유효 범위(스코프)는 최대한 좁게 만들어 변수의 부작용을 억제해야 한다.
        3. 전역 변수는 최대한 사용하지 않도록 한다.
        4. 변수보다는 상수를 사용해 값의 변경을 억제한다.
        5. 변수이름은 변수의 목적이나 의미를 파악할 수 있도록 네이밍한다.
        ---> 가독성이 좋은 코드가 좋은 코드다.

*/

//Ex06-23
var foo;
console.log(typeof foo);    //  undefined

foo = 3;
console.log(typeof foo);    //  number

foo = 'Hello';
console.log(typeof foo);    //  string

foo = true;
console.log(typeof foo);    //  boolean

foo = null;
console.log(typeof foo);    //  object

foo = Symbol();  // 심벌
console.log(typeof foo);    //  symbol

foo = {};   //  객체
console.log(typeof foo);    //  object

foo = []; // 배열
console.log(typeof foo);    //  object

foo = function() {};    // 함수
console.log(typeof foo);    //  function


