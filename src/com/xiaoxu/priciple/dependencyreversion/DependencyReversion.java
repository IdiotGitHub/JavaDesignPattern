package com.xiaoxu.priciple.dependencyreversion;

/**
 * @author Administrator
 */
public class DependencyReversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        //改进
        Person2 person2 = new Person2();
        person2.receive(new Email2());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息：Hello World！";
    }
}
/**
分析：
    1.简单，比较容易想到
    2.如果我们获取端对象是微信、短信等等，则新增类，同时Person类也要增加响应的接受方法
    3.解决思路：引入一个抽象的接口IReceiver， 表示接收者，这样Person类与接口IReciever发生依赖关系
 */
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}

//改进


interface IReceiver {
    /**
     * 获取信息
     * @return 返回信息
     */
   String getInfo();
}

class Email2 implements IReceiver {

    @Override
    public String getInfo() {
        return "电子邮件信息：Hello World！";
    }
}

class WeiXin implements IReceiver {

    @Override
    public String getInfo() {
        return "微信信息：Hello World！";
    }
}

class Person2 {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
