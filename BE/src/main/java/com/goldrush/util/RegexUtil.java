package com.goldrush.util;

public class RegexUtil {
	String regexForEmail = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
	String regexForName = "^[가-힣]{2,4}$/";
	String regexForPassword = "/^[a-z0-9]{4,12}$/";
}
