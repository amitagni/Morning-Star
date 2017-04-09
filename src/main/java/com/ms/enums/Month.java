/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum Month {
	
	APR((byte)1,"APRIL"),
	MAY((byte)2,"MAY"),
	JUN((byte)3,"JUNE"),
	JUL((byte)4,"JULY"),
	AUG((byte)5,"AUGUST"),
	SEP((byte)6,"SEPTEMBER"),
	OCT((byte)7,"OCTOBER"),
	NOV((byte)8,"NOVEMBER"),
	DEC((byte)9,"DECEMBER"),
	JAN((byte)10,"JANUARY"),
	FEB((byte)11,"FEBRUARY"),
	MAR((byte)12,"MARCH");
	
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
