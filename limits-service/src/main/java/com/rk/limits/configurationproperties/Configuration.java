package com.rk.limits.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {
	
	private int minimun;
	private int maximum;
	
	public int getMinimun() {
		return minimun;
	}
	public void setMinimun(int minimun) {
		this.minimun = minimun;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
	

}
