package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * PostgreSql 数据类型
 * @author liuqh
 * @date: 2019年03月03日
 */
public enum PostgreSqlDataType {
	
	//数值类型start
//	INT,//int8（对应bigint）/int4（对应integer）/int2(对应smallint)
	INT2,//(对应smallint)
	INT4,//int4（对应integer）
	INT8,//int8（对应bigint）
	
//	FLOAT,//float8(对应double precision）双精度浮点数字  ,float4(对应real）单精度浮点数字
	FLOAT4,//float4(对应real）单精度浮点数字
	FLOAT8,//float8(对应double precision）双精度浮点数字  
	
	NUMERIC,//用户声明精度，变长，无限制
	
//	SERIAL,//serial8（对应bigserial）/serial4(对应serial) 自增8/4字节整数
	SERIAL4,//serial4(对应serial)
	SERIAL8,//serial8（对应bigserial）
	
	BIT,//定长位串
	
	VARBIT,//变长位串
	
	BOOL,//逻辑布尔量 （真/假）
	
	BOX,//平面中的长方形
	
	BYTEA,//二进制数据（"字节数组"）
	
	VARCHAR,//字符串 变长，有长度限制
	
	CHAR,//字符串， 定长，不足补空白
	
	CIDR,//IPv4 或者 IPv6 网络地址
	
	INET,//IPv4 或者 IPv6 网络地址
	
	CIRCLE,//平面中的圆
	
	DATE,//日历日期（年，月，日）
	
	INTERVAL,//时间间隔
	
	LINE,//平面中的无限长直线
	
	LSEG,//平面中的线段
	
	MACADDR,//MAC 地址
	
	MONEY,//货币金额
	
	DECIMAL,//可选精度的准确数字,对应numeric 
	
	PATH,//平面中的几何路径
	
	POINT,//平面中的点
	
	POLYGON,//平面中的封闭几何路径
	
	TEXT,//变长字符串
	
	TIME,//一天里的时间
	
	TIMETZ,//一天里的时间，包括时区
	
	TIMESTAMP,//日期和时间
	
	TIMESTAMPTZ,//日期和时间
	
	TSQUERY, //全文检索查询
	
	TSVECTOR, //全文检索文档
	
	TXID_SNAPSHOT, //用户级别事务ID快照
	
	UUID, //通用唯一标识符
	
	XML, //XML数据
	
	other;
	
	/**
	 * 自己定义一个静态方法,通过code返回枚举常量对象
	 * @param code
	 * @return
	 */
	public static PostgreSqlDataType getByValue(int code) {

		for (PostgreSqlDataType gs : values()) {
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
		PostgreSqlDataType[] hdts = PostgreSqlDataType.values();
		for (PostgreSqlDataType m : hdts){
			names.add(m.name().toLowerCase());
		}
		
		return names;
	}
}


