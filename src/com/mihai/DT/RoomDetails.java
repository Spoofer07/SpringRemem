package com.mihai.DT;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomDetails {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int roomId;
	private String roomName;
	private int noOfPlaces;
	
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getNoOfPlaces() {
		return noOfPlaces;
	}
	public void setNoOfPlaces(int noOfPlaces) {
		this.noOfPlaces = noOfPlaces;
	}
	
	
	
	
	
}
