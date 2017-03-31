/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum StudentClass {

	PRE_NUR((byte)1,"Pre. Nur."),
	NUR((byte)2,"Nur."),
	KG((byte)3,"K.G"),
	I((byte)4,"Ist");
	
	private Byte code;
	private String name;
	
	/**
	 * 
	 */
	private StudentClass(byte code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static Byte findCodeByName(String  name){
		for(StudentClass studentClass : StudentClass.values()){
			if(studentClass.name.equals(name)){
				return studentClass.code;
			}
		}
		return null;
	}

	
	public static String findNameByCode(Byte  code){
		for(StudentClass studentClass : StudentClass.values()){
			if(studentClass.code.byteValue() == code.byteValue()){
				return studentClass.name;
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
