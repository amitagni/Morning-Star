/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum Month {
	MAR((byte)1,"MARCH"),
	APR((byte)2,"APRIL"),
	MAY((byte)3,"MAY"),
	JUN((byte)3,"JUNE"),
	JUL((byte)3,"JULY"),
	AUG((byte)3,"AUGUST"),
	SEP((byte)3,"SEPTEMBER"),
	OCT((byte)3,"OCTOBER"),
	NOV((byte)3,"NOVEMBER"),
	DEC((byte)3,"DECEMBER"),
	JAN((byte)3,"JANUARY"),
	FEB((byte)3,"FEBRUARY");
	
	private Byte code;
	private String name;
	
	/**
	 * 
	 */
	private Month(byte code, String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(Month month : Month.values()){
			if(month.name.equals(name)){
				return month.code;
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
