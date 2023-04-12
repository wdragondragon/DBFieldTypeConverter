package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * mysql 数据类型
 * @author liuqh
 * @date: 2019年11月21日
 */
public enum MysqlDataType {
	TINYINT,//	1 字节
	
	SMALLINT,//小整型，占用2个字节，存储范围–32768 到 32767
	
	MEDIUMINT,//大整数值,占用3个字节，存储范围-8 388 608，8 388 607
	
	INT,//大整数值，占用4个字节，存储范围-2147483648到2147483647
	
	INTEGER,//大整数值，占用4个字节，存储范围-2147483648到2147483647
	
	BIGINT,//长整型，占用8个字节，存储范围-2^63到2^63-1
	
//	BOOLEAN,//true/false
	
	FLOAT,//单精度浮点数，4字节（32位）
	
	DOUBLE,//双精度浮点数，8字节（64位）
	
	DECIMAL,//decimal(10,2)
	
	DATE,//格式  YYYY-MM-DD，范围  1000-01-01/9999-12-31
	
	TIME,//格式  HH:MM:SS,范围'-838:59:59'/'838:59:59'
	
	YEAR,//格式YYYY，范围  1901/2155
	
	DATETIME,//格式YYYY-MM-DD HH:MM:SS	，范围  1000-01-01 00:00:00/9999-12-31 23:59:59
	
	TIMESTAMP,//Integer/Floating/YYYY-MM-DD hh:mm:ss.fffffffff
	
	VARCHAR,//0-65535 字节 ,变长字符串
	
	CHAR,//0-255字节，定长字符串
	
	TINYBLOB,//不超过 255 个字符的二进制字符串
	
	TINYTEXT,//短文本字符串，范围  0-65 535字节
	
	BLOB,//二进制形式的长文本数据,范围  0-65 535字节
	
	MEDIUMBLOB,//二进制形式的中等长度文本数据 	0-16 777 215字节
	
	MEDIUMTEXT,//中等长度文本数据 	0-16 777 215字节	
	
	TEXT,//长文本数据
	
	LONGBLOB,//二进制形式的极大文本数据  	0-4 294 967 295字节	
	
	LONGTEXT,//极大文本数据		0-4 294 967 295字节	
	
	other;
	
	/**
	 * 自己定义一个静态方法,通过code返回枚举常量对象
	 * @param code
	 * @return
	 */
	public static MysqlDataType getByValue(int code) {

		for (MysqlDataType dt : values()) {
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
		MysqlDataType[] mdts = MysqlDataType.values();
		for (MysqlDataType m : mdts){
			names.add(m.name().toLowerCase());
		}
		
		return names;
	}
	
}


