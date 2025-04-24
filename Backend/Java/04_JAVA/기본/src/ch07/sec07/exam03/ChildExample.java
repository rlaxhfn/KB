package ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.field1 = "data1";
        parent.method1();
        parent.method2();
        // Parent 클래스에 정의돼 있지 않아 호출 불가
        // parent.field2 = "data2"; //java: cannot find symbol symbol:   variable field2   location: variable parent of type ch07.sec07.exam03.Parent
        // parent.method3(); // java: cannot find symbol   symbol:   method method3()  location: variable parent of type ch07.sec07.exam03.Parent

        Child child = new Child();
        child.field2 = "data2";
        child.method3();
    }
}
