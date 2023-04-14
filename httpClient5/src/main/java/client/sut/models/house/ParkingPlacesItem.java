package client.sut.models.house;

import com.google.gson.annotations.SerializedName;

public class ParkingPlacesItem{

	@SerializedName("placesCount")
	private int placesCount;

	@SerializedName("isWarm")
	private boolean isWarm;

	@SerializedName("id")
	private int id;

	@SerializedName("isCovered")
	private boolean isCovered;

	public int getPlacesCount(){
		return placesCount;
	}

	public boolean isIsWarm(){
		return isWarm;
	}

	public int getId(){
		return id;
	}

	public boolean isIsCovered(){
		return isCovered;
	}
}