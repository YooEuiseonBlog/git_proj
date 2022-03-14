/*
   ● 데이터 타입이 필요한 이유
    - 값을 저장할 때 확보해야 하는 메모리 공간의 크기를 결정하기 위해
    - 값을 참조할 때 한 번에 읽어 들여야 할 메모리의 공간의 크기를 결정하기 위해
    - 메모리에서 읽어 들인 2진수를 어떻게 해석할지 결정하기 위해

*/

/*
    ch06-04 불리언 타입
    - 불리언 타입의 값은 논리적 참, 거짓을 나타내는 true와 false뿐이다.
*/

//Ex06-16
var foo = true;
console.log(foo);   // true

var foo = false;
console.log(foo);   // false

/*  undefined 타입 
    null과 함께 자기자신 한가지 타입만 가지고 있다.
*/

//Ex06-17
var foq;
console.log(foq);   //  undefined

/*  null타입 
    - 변수값이 없다는 것을 표현
    - 함수가 유효한 값을 반환할 수 없는 경우 명시적으로 null을 반환하기도 한다.
*/

//Ex06-18
var foo = 'Lee';
// 이전 참조를 제거. foo 변수는 더 이상 'Lee'를 참조하지 않는다.
// 유용해 보이지는 않는다. 변수의 스코프를 좁게 만들어 변수 자체를 재빨리 소멸시키는 편이 낫다.
foo = null;

//Ex06-19
/*
    <!DOCTYPE html>
    <html>
    <body>
        <script>
            var element = document.querySelector('myClass');

            // HTML 문서에 myClass 클래스를 갖는 요소가 없다면 null을 반환한다.
            console.log(element);   // null
        </script>
    </body>
    </html>
*/

/*
    심벌타입
    - 변경 불가능한 원시 타입의 값
    - 심벌 값은 다른 값과 중복되지 않는 유일무이한 값
    - 주로 이름이 충돌할 위험이 없는 객체의 유일한 프로퍼티 키를 만들기 위해 사용한다.
    - 심벌 이외의 원시 값은 리터럴을 통해 생성하지만, 심벌은 Symbol함수를 호출해 생성한다.
*/

//Ex06-20
//심벌 값 생성
var key = Symbol('key');
console.log(typeof key);

//객체 생성
var obj = {};

//  이름이 충돌할 위험이 없는 유일무이한 값인 심벌을 프로퍼티 키로 사용한다.
obj[key] = 'value';
console.log(obj[key]);  // value
