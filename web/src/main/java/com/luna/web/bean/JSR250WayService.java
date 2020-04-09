package com.luna.web.bean;
 
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
 
public class JSR250WayService {

	@PostConstruct //1在构造函数执行完之后执行
    public void init(){
        System.out.println("jsr250-init-method//1在构造函数执行完之后执行");
    }
    public JSR250WayService() {
        super();
        System.out.println("初始化构造函数-JSR250WayService");
    }
    @PreDestroy //2在bean销毁之前执行
    public void destroy(){
        System.out.println("jsr250-destory-method//2在bean销毁之前执行");
    }
 
}