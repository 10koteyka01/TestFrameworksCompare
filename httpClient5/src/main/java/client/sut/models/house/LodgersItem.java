package client.sut.models.house;

import com.google.gson.annotations.SerializedName;

public class LodgersItem{

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("money")
	private Object money;

	@SerializedName("sex")
	private String sex;

	@SerializedName("id")
	private int id;

	@SerializedName("age")
	private int age;

	@SerializedName("secondName")
	private String secondName;

	public String getFirstName(){
		return firstName;
	}

	public Object getMoney(){
		return money;
	}

	public String getSex(){
		return sex;
	}

	public int getId(){
		return id;
	}

	public int getAge(){
		return age;
	}

	public String getSecondName(){
		return secondName;
	}
}