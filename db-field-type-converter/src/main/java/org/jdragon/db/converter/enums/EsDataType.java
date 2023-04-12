package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * hive 数据类型
 * @author liuqh
 * @date: 2019年11月21日
 */
public enum EsDataType {
	SHORT,//整数类型
	
	INTEGER,//整数类型
	
	LONG,//整数类型
	
	FLOAT,//单精度浮点数，4字节（32位）
	
	HALF_FLOAT,//浮点类型
	
	SCALED_FLOAT,//浮点类型
	
	DOUBLE,//双精度浮点数，8字节（64位）
	
	TEXT,//字符串类型
	
	KEYWORD,//字符串类型
	
	STRING,//字符串
	
	CHAR,//0-255字节 定长字符串
	
	BINARY,//二进制类型 
	
	DATE,//2019-10-26
	
	RANGE,//范围类型 
	
	BOOLEAN,//true/false
	
	ARRAY,//数组，ARRAY(data_type)
	
	OBJECT,//对象类型 
	
	NESTED,//嵌套类型 
	
	GEO_POINT,//地理类型 地理坐标类型
	
	GEO_SHAPE,//地理地图
	
	COMPLETION,//范围类型 
	
	ATTACHMENT,//附件类型
	
	PERCOLATOR,//抽取类型 
	
	IP,//特殊类型 IP类型 
	
	TOKEN_COUNT,//令牌计数类型
	
	other;
	
	/**
	 * 自己定义一个静态方法,通过code返回枚举常量对象
	 * @param code
	 * @return
	 */
	public static EsDataType getByValue(int code) {

		for (EsDataType dt : values()) {
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
		EsDataType[] mdts = EsDataType.values();
		for (EsDataType m : mdts){
			names.add(m.name().toLowerCase());
		}
		
		return names;
	}
	
}


