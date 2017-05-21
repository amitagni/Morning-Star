/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum House {
	ARAVALI ((byte)1,"Aravali"),
	SHIVALIK((byte)2,"Shivalik"),
	VINDHYACHAL((byte)2,"Vindhyachal"),
	NILGIRI((byte)3,"Nilgiri");
	
	
	private Byte code;
	private String name;
	
	private House(Byte code,String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(House house : House.values()){
			if(house.name.equals(name)){
				return house.code;
			}
		}
		return null;
	}
	
	public static String findNameByCode(Byte  code){
		for(House house : House.values()){
			if(house.code.byteValue() == code.byteValue()){
				return house.name;
			}
		}
		return null;
	}
	/**
	 * @return the code
	 */
	public Byte getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Byte code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
