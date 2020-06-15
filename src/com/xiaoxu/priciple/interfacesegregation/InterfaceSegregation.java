package com.xiaoxu.priciple.interfacesegregation;

public class InterfaceSegregation {
    public static void main(String[] args) {
        Interface1 interface1 = new B();
        Interface1 interface2 = new D();
        A a = new A();
        a.depend1(interface1);
        C c = new C();
        c.depend1(interface2);
    }
}

//这种方式违反了，接口隔离原则，将Interface1进行拆分改进
interface Interface1 {
    void operation1();

    void operation2();

    void operation3();

    void operation4();

    void operation5();
}

//改进接口
interface Interface2 {
    void operation1();
}

interface Interface3 {
    void operation2();

    void operation3();
}

interface Interface4 {
    void operation4();

    void operation5();
}
class B implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("B 实现了接口方法1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了接口方法2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了接口方法3");
    }

    @Override
    public void operation4() {
        System.out.println("B 实现了接口方法4");
    }

    @Override
    public void operation5() {
        System.out.println("B 实现了接口方法5");
    }
}

class D implements Interface1 {

    @Override
    public void operation1() {
        System.out.println("D 实现了接口方法1");
    }

    @Override
    public void operation2() {
        System.out.println("D 实现了接口方法2");
    }

    @Override
    public void operation3() {
        System.out.println("D 实现了接口方法3");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现了接口方法4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了接口方法5");
    }
}
class BImprove implements Interface2,Interface3 {

    @Override
    public void operation1() {

    }

    @Override
    public void operation2() {

    }

    @Override
    public void operation3() {

    }
}
//DImprove
class DImprove implements Interface2,Interface4{

    @Override
    public void operation1() {

    }

    @Override
    public void operation4() {

    }

    @Override
    public void operation5() {

    }
}

//A类通过Interface1依赖（使用）B类，但是只会用到1，2，3方法
class A {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface1 i) {
        i.operation2();
    }

    public void depend3(Interface1 i) {
        i.operation3();
    }
}

class C {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface1 i) {
        i.operation4();
    }

    public void depend5(Interface1 i) {
        i.operation5();
    }
}