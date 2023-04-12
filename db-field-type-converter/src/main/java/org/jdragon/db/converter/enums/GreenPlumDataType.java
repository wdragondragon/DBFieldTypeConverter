package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * greenPlum 数据类型
 * @author liuqh
 * @date: 2019年03月03日
 */
public enum GreenPlumDataType {
	
	//数值类型start
	SMALLINT,//小整型，占用2个字节，存储范围–32768 到 32767
	
	INTEGER,// 整型，占用4个字节，存储范围-2147483648到2147483647
	
	BIGINT,//长整型，占用8个字节，存储范围-2^63到2^63-1
	
	DECIMAL,//decimal(10,2)
	
	NUMERIC,//用户声明精度，变长，无限制
	
	REAL,//4字节，变精度，不精确
	
	SERIAL,//4字节，自增整数（1 - 2147483647）
	
	BIGSERIAL,//8字节，大范围自增整数（1 - ）
	//数值类型end
	
	VARCHAR,//字符串 变长，有长度限制
	
	CHAR,//字符串， 定长，不足补空白
	
	TEXT,//字符串，变长，无长度限制
	
	DATE,//4字节，只用于表示日期，最低值4713BC,最高值5874897AD,精度1天
	
	TIMESTAMP,//8字节，日期和时间，最低值4713BC,最高值5874897AD,精度1毫秒
	
	TIME,//8字节，只用于表示一日内时间，最低值00:00:00,最高值24:00:00,精度1毫秒
	
	other;
	
	/**
	 * 自己定义一个静态方法,通过code返回枚举常量对象
	 * @param code
	 * @return
	 */
	public static GreenPlumDataType getByValue(int code) {

		for (GreenPlumDataType gs : values()) {
			if (gs.ordinal() == code) {
				return gs;
			}
		}
		return null;

	}
	
	/**
	 * @author liuqh
	 * @date: 2020年03月03日
	 * @return
	 */
	public static List<String> getNames() {
		List<String> names = new ArrayList<String>();
		GreenPlumDataType[] hdts = GreenPlumDataType.values();
		for (GreenPlumDataType m : hdts){
			names.add(m.name().toLowerCase());
		}
		
		return names;
	}
}


