package com.example.kotlinpractice

//기본적으로 코틀린은 public이 기본
fun main() {
//    val person = Person("홍길동", 20)
//    print(person)
    //확장함수기능 - 상속 받지 않아도 기능을 추가할수 있는 기능
    val str = "hello"
    str.myLength()
}

fun String.myLength() : Int {
    return this.length
}


//데이타 모델 클래스 인경우 클래스 앞에 data 키워드가 붙음
//data 키워드를 붙이면 toString을 재정의 한것처럼 단순히 객체를 print하면 객체의 내용을 print할수 있음.
//toString 뿐만 아니라 hashcode, equalse도 재정의를 자동으로 해줌!
data class Person(
    val name: String,
    var age: Int
)
