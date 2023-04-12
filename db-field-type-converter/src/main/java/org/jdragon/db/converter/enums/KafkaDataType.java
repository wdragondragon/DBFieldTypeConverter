package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * kafka 自定义常用的 数据类型
 * @author liuqh
 * @date: 2020年5月9日
 */
public enum KafkaDataType {
	INT,//整数类型
	
	LONG,//长整型
	
	DOUBLE,//双精度浮点数，8字节（64位）
	
	TEXT,//文本类型
	
	STRING//字符串
	;
	
	/**
	 * 自己定义一个静态方法,通过code返回枚举常量对象
	 * @param code
	 * @return
	 */
	public static KafkaDataType getByValue(int code) {

		for (KafkaDataType dt : values()) {
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
		KafkaDataType[] mdts = KafkaDataType.values();
		for (KafkaDataType m : mdts){
			names.add(m.name().toLowerCase());
		}
		
		return names;
	}
	
}


