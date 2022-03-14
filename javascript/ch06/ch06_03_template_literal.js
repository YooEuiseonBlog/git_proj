/*
    ch06-03 템플릿 리터럴 Template literal
    - 기능
        - 멀티라인 문자열   multi-line string
            : 템플릿 리터럴 내에서는 이스케이프 시퀀스를 사용하지 않고도 줄바꿈이 허용되며, 모든 공백도 있는 그대로 적용된다.
        - 표현식 삽입       expression interpolation       
        - 태그드 템플릿     tagged template

    - 템플릿 리터럴은 백틱(``)을 사용해 표현한다.
*/
//Ex06-08
var template = `Template literal`;
console.log(template);

/*
    ◇ 일반 문자열
    - 일반 문자열 내에서는 줄바꿈(개행)이 허용되지 않는다.
*/

//Ex06-09
// var str = 'Hello
// world.';
//SyntaxError: Invalid or unexpected token
//----> 줄바꿈 등의 공백 white space을 이용하려면,  이스케이프 시퀀스 escape sequence를 사용해야 한다.

/*
    이스케이프 시퀀스
    \0          null
    \b          백스페이스
    \f          폼 피드Form Feed: 프린트로 출력할 경우 다음 페이지의 시작지점으로 이동한다.
    \n          개행LF Line Feed: 다음 행으로 이동
    \r          개행CR carriage Return: 커서를 처음으로 이동
    \t          탭(수평)
    \v          탭(수직)
    \uXXXX      유니코드. 예를 들어 '\u0041'은 'A', '\uD55C'는 '한', '\u{1F600}'는 😀이다.
    \'          작은따옴표
    \"          큰따옴표
    \\          백슬래시
*/

//Ex06-10
var template = '<ul>\n\t<li><a href="#">Home</a></li>\n</ul>';
console.log(template);

/*
    멀티라인 문자열
    : 템플릿 리터럴 내에서는 이스케이프 시퀀스를 사용하지 않고, 줄바꿈이 허용되며, 모든 공백이 있는 그대로 적용된다.
*/


//Ex06-11
var template = `\n<ul>
<li><a href="#">Home</a><li>
</ul>`;

console.log(template);

/*
    표현식 삽입
*/

//일반 문자열 + 연산자
//Ex06-12,13
var first = 'Ung-mo';
var last = 'Lee';

//ES5:문자열 연결
var str = 'My name is ' + first + ' ' +  last +  '.';   //  My name is Ung-mo Lee.
console.log(str);   

//ES6: 표현식 삽입
//${}은 선택자가 문자열이 아니더라도 강제로 문자열로 반환.
var str_template = `My name is ${first} ${last}.`;  //  My name is Ung-mo Lee.
console.log(str_template);

//Ex06-14
console.log(`1 + 2 = ${1 + 2}`);    //  1 + 2 = 3 ---> ${}내부에서는 계산도 가능하다.
//Ex06-15
console.log('1 + 2 = ${1 + 2}');    // 1 + 2 = ${1 + 2} ---> 템플릿 리터럴내에서 가능하며, 일반 문자열에서는 그냥 문자열로 취급한다.

