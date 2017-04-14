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
	I((byte)4,"Ist"),
	II((byte)5,"Ist"),
	III((byte)6,"Ist"),
	IV((byte)7,"Ist"),
	V((byte)8,"Ist"),
	VI((byte)9,"Ist"),
	VII((byte)10,"Ist"),
	VIII((byte)11,"Ist"),
	IX((byte)12,"Ist"),
	X((byte)13,"Ist"),
	XI((byte)14,"Ist"),
	XII((byte)15,"Ist");
	
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
