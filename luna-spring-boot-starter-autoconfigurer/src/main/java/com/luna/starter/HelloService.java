package com.luna.starter;

/**
 * @author Luna@win10
 * @date 2020/4/7 17:01
 */
public class HelloService {

    HelloProperties helloProperties;

    public String syaHello(String name) {
        return helloProperties.getPrefix() + "-" + name + helloProperties.getSuffix();
    }

	public HelloProperties getHelloProperties() {
		return helloProperties;
	}

	public void setHelloProperties(HelloProperties helloProperties) {
		this.helloProperties = helloProperties;
	}
}
