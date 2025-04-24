package ch07.sec07.exam01;

class A {
}

class B extends A {
}
class C extends A {

}
class D extends B {

}
class E extends C {}

public class PromotionExample {
    public static void main(String[] args) {
        B b=new B();
        C c=new C();
        D d=new D();
        E e=new E();

        A a1=b;
        A a2=c;
        A a3=d;
        A a4=e;

        B b1=d;
        C c1=e;

        // 상속 관계에 없기 때문에 컴파일 에러
        // B b3=e; // java: incompatible types: ch07.sec07.exam01.E cannot be converted to ch07.sec07.exam01.B
        // C c2=d; // java: incompatible types: ch07.sec07.exam01.D cannot be converted to ch07.sec07.exam01.C
    }
}
