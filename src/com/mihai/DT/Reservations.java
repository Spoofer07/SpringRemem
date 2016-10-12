package com.mihai.DT;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservations {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int reservId;
	private int reservBool;
	private int reservRoomId;
	
	
	public int getReservId() {
		return reservId;
	}
	public void setReservId(int reservId) {
		this.reservId = reservId;
	}
	public int getReservBool() {
		return reservBool;
	}
	public void setReservBool(int reservBool) {
		this.reservBool = reservBool;
	}
	public int getReservRoomId() {
		return reservRoomId;
	}
	public void setReservRoomId(int reservRoomId) {
		this.reservRoomId = reservRoomId;
	}
	
	
}
