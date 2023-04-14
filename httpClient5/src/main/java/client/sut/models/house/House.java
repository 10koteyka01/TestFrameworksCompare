package client.sut.models.house;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class House {

	@SerializedName("parkingPlaces")
	private List<ParkingPlacesItem> parkingPlaces;

	@SerializedName("price")
	private Object price;

	@SerializedName("floorCount")
	private int floorCount;

	@SerializedName("id")
	private int id;

	@SerializedName("lodgers")
	private List<LodgersItem> lodgers;

	public List<ParkingPlacesItem> getParkingPlaces(){
		return parkingPlaces;
	}

	public Object getPrice(){
		return price;
	}

	public int getFloorCount(){
		return floorCount;
	}

	public int getId(){
		return id;
	}

	public List<LodgersItem> getLodgers(){
		return lodgers;
	}
}