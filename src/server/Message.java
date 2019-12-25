package server;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import data.*;

public class Message <T> {
//public class Instruction {
	private int opcode;
	private String id;
	private String password;		
	
	//Store various input information (such as the number of a series of courses)
	private Vector<T> vec;

	public Message() {
		vec = new Vector<T>();
	}

	public int getOpcode() {
		return opcode;
	}
	public String getId() {
		return id;
	}
	public String password() {
		return password;
	}

	public void setOpcode(int opcode) {
		this.opcode = opcode;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Vector<T> getVec() {
		return vec;
	}
	public void setVec(Vector<T> vec) {
		this.vec = vec;
	}
}
