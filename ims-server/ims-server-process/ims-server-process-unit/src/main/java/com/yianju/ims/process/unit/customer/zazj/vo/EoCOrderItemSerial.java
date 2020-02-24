package com.yianju.ims.process.unit.customer.zazj.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * 序列号
 * @author MrDuan
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EoCOrderItemSerial implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7758309673033757103L;
	
	private String sn;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}
	
}
