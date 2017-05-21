/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum Nationality {
	


	INDIAN ((byte)1,"Indian"),
	NRI((byte)2,"NRI");
	
	
	private Byte code;
	private String name;
	
	private Nationality(Byte code,String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(Nationality nationality : Nationality.values()){
			if(nationality.name.equals(name)){
				return nationality.code;
			}
		}
		return null;
	}
	
	public static String findNameByCode(Byte  code){
		for(Nationality nationality : Nationality.values()){
			if(nationality.code.byteValue() == code.byteValue()){
				return nationality.name;
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
