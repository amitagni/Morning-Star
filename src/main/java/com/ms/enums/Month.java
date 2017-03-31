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
	JUN((byte)4,"JUNE"),
	JUL((byte)5,"JULY"),
	AUG((byte)6,"AUGUST"),
	SEP((byte)7,"SEPTEMBER"),
	OCT((byte)8,"OCTOBER"),
	NOV((byte)9,"NOVEMBER"),
	DEC((byte)10,"DECEMBER"),
	JAN((byte)11,"JANUARY"),
	FEB((byte)12,"FEBRUARY");
	
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
