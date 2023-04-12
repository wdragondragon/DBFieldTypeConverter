package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * hive 数据类型
 * @author liuqh
 * @date: 2019年11月21日
 */
public enum HiveDataType {
	TINYINT,//微整型，只占用1个字节，只能存储0-255的整数
	
	SMALLINT,//小整型，占用2个字节，存储范围–32768 到 32767
	
	INT,// 整型，占用4个字节，存储范围-2147483648到2147483647
	
	BIGINT,//长整型，占用8个字节，存储范围-2^63到2^63-1
	
	BOOLEAN,//true/false
	
	FLOAT,//单精度浮点数，4字节（32位）
	
	DOUBLE,//双精度浮点数，8字节（64位）
	
	STRING,//字符串
	
	DECIMAL,//decimal(10,2)
	
	DATE,//2019-10-26
	
	TIMESTAMP,//Integer/Floating/YYYY-MM-DD hh:mm:ss.fffffffff
	
	CHAR,//最大长度为255
	
//	ARRAY,//数组，ARRAY(data_type)
//	
//	MAP,//MAP <primitive_type, data_type >
//	
//	struct,
//	
//	union,
	
	other;
	
	/**
	 * 自己定义一个静态方法,通过code返回枚举常量对象
	 * @param code
	 * @return
	 */
	public static HiveDataType getByValue(int code) {

		for (HiveDataType gs : values()) {
			if (gs.ordinal() == code) {
				return gs;
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
		HiveDataType[] hdts = HiveDataType.values();
		for (HiveDataType m : hdts){
			names.add(m.name().toLowerCase());
		}
		
		return names;
	}
}


