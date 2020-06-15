package com.xiaoxu.priciple.singleresponsebility;

public class SingleResponsibility {
    public static void main(String[] args) {
        //使用这种方式，Vehicle类不仅管理了路上跑的对象还管理了天上飞的对象，违反了单一原则
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
        //这种方式遵守了单一原则
        //分析
        //1.遵守了单一职责原则
        //2.但是这样做的改动很大，即将类分解，同时修改客户端
        //3.改进，直接修改Vehicle类，改动的代码会比较少
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("汽车");
        SkyVehicle skyVehicle = new SkyVehicle();
        skyVehicle.run("飞机");
    }
}

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "公路运行....");
    }
}

class RoadVehicle {
    public void run(String roadVehicle) {
        System.out.println(roadVehicle + "公路运行....");
    }
}

class SkyVehicle {
    public void run(String skyVehicle) {
        System.out.println(skyVehicle + "空中运行....");
    }
}
//分析
//1.这种修改方法没有对原来的类做大的修改，只是增加方法
//2.这种修改方法虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，仍然是遵守单一职责原则
class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + "公路运行....");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + "空中运行....");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "水中运行....");
    }
}
