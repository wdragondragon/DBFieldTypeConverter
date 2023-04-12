package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * ftp自定义数据类型
 * @author liuqh
 * @date: 2020年5月9日
 */
public enum FtpDataType {
	INT,//整数类型
	
	LONG,//长整型
	
	DOUBLE,//双精度浮点数，8字节（64位）
	
	TEXT,//文本类型
	
	STRING,//字符串

	DATE
	;
	
	/**
	 * 自己定义一个静态方法,通过code返回枚举常量对象
	 * @param code
	 * @return
	 */
	public static FtpDataType getByValue(int code) {

		for (FtpDataType dt : values()) {
			if (dt.ordinal() == code) {
				return dt;
			}
		}
		return null;

	}

	/**
	 * @author liuqh
	 * @date: 2019年11月21日
	 * @return
	 */
	public static List<String> getNames() {
		List<String> names = new ArrayList<String>();
		FtpDataType[] mdts = FtpDataType.values();
		for (FtpDataType m : mdts){
			names.add(m.name().toLowerCase());
		}
		
		return names;
	}
	
}


