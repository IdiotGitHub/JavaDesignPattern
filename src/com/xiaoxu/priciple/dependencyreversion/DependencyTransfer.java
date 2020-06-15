package com.xiaoxu.priciple.dependencyreversion;

/**
 * @author Administrator
 */
public class DependencyTransfer {
}

/**
 * 方式一：通过接口传递依赖
 * 开关的接口
 */
interface IOpenAndClose {

    /**
     * 抽象方法，接收接口
     * @param itv 电视接口
     */
    public void open(ITv itv);
}

/**
 * 电视接口
 */
interface ITv {
    /**
     * 播放
     */
    public void play();
}
class OpenAndClose implements IOpenAndClose{

    @Override
    public void open(ITv itv) {
        itv.play();
    }
}
/**
 * 方式二：通过构造器传递依赖
 * 开关的接口
 */
interface IOpenAndClose2 {

    /**
     * 抽象方法，接收接口
     */
    public void open();
}

/**
 * 电视接口
 */
interface ITv2 {
    /**
     * 播放
     */
    public void play();
}
class OpenAndClose2 implements IOpenAndClose2{
    public ITv iTv;
    OpenAndClose2(ITv iTv) {
        this.iTv = iTv;
    }
    @Override
    public void open() {
        this.iTv.play();
    }
}
/**
 * 方式三：通过setter传递依赖
 * 开关的接口
 */
interface IOpenAndClose3 {

    /**
     * 抽象方法，接收接口
     */
    public void open();
}

/**
 * 电视接口
 */
interface ITv3 {
    /**
     * 播放
     */
    public void play();
}
class OpenAndClose3 implements IOpenAndClose3{
    public ITv iTv;

    public void setItv(ITv iTv) {
        this.iTv = iTv;
    }

    @Override
    public void open() {
        iTv.play();
    }
}
