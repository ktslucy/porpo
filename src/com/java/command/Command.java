package com.java.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	String excecute(HttpServletRequest request, HttpServletResponse response);
}
