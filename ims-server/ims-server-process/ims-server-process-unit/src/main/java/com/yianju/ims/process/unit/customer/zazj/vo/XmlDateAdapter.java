package com.yianju.ims.process.unit.customer.zazj.vo;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class XmlDateAdapter extends XmlAdapter<String, Date> {
	    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	    public Date unmarshal(String v){
	    	try {
	    		if (v == null || "".equals(v.trim())) {
		            return null;  
		        }
		        if(isInteger(v)) {//判断传入的参数是时间戳还是时间格式的字符串
		        	long lt = 0;
		        	lt = Long.parseLong(v) * 1000;
		        	return format.parse(format.format(lt));
		        }else {
		        	String s = v.replace("/", "-");
		        	return format.parse(s);
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return null;  
	    }  
	  
	    public String marshal(Date v) throws Exception {
	    	if(v == null) {
	    		return null;
	    	}
	        return format.format(v);  
	    }
	    
	    public static boolean isInteger(String str) {
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches(); 
	    }
	    
	    public static void main(String[] args) {
	    	XmlDateAdapter m = new XmlDateAdapter();
	    	try {
				Date d= m.unmarshal("2018/06/08 09:09:29");
				System.out.println(d);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

