package com.goldrush.service;

import javax.servlet.http.HttpServletRequest;

public class img {
	public void printPath(HttpServletRequest request) {
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		System.out.println(img.class.getResource(".").getPath());
	}
}
