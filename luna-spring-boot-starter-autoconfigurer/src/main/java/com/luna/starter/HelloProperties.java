package com.luna.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Luna@win10
 * @date 2020/4/7 17:02
 */
@ConfigurationProperties(prefix = "luna.hello")
public class HelloProperties {

	private String prefix;
	private String suffix;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
