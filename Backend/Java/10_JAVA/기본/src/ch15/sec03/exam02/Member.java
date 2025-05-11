package ch15.sec03.exam02;

public class Member {
    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int hashCode(){
        return name.hashCode();
    }

    public boolean equals(Object obj){
        if(obj instanceof Member){
            return name.equals(name)&&(age==age);
        } else {return false;}
    }
}
