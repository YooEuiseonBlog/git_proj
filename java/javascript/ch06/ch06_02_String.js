/*
    ch06-02 문자열 타입 String
    - 텍스트 데이터 표현
    - 유니코드 문자(UTF-16)
*/
//Ex06-06
//문자열 타입
var String;
String = '문자열';  //  작은따옴표
String = "문자열";  //  큰따옴표
String = `문자열`;  //  백틱(ES6)

String = '작은따옴표로 감싼 문자열 내의 "큰따옴표"는 문자열로 인식된다.';
String = "큰따옴표로 감싼 문자열 내의 '작은따옴표'는 문자열로 인식된다.";

//Ex06-07
// 따옴표로 감싸지 않은 hello를 식별자로 인식한다.
var String = hello; //  ReferenceError: hello is not defined
