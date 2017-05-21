/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum Religion {

	HINDU ((byte)1,"Hindu"),
	MUSHLIM((byte)2,"Mushlin"),
	SIKH((byte)2,"Sikh"),
	CHRISTIAM((byte)3,"Christian ");
	
	
	private Byte code;
	private String name;
	
	private Religion(Byte code,String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(Religion religion : Religion.values()){
			if(religion.name.equals(name)){
				return religion.code;
			}
		}
		return null;
	}
	
	public static String findNameByCode(Byte  code){
		for(Religion religion : Religion.values()){
			if(religion.code.byteValue() == code.byteValue()){
				return religion.name;
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
