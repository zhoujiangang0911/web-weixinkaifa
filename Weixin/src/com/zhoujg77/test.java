package com.zhoujg77;

import com.thoughtworks.xstream.XStream;

public class test {
	public static void main(String[] args) {
		XStream xStream = new XStream();
		System.out.println(xStream);
		System.out.println(CheckUtil.SHA1("test"));
	}
}
