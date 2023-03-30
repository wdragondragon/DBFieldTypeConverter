package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * hive 数据类型
 * @author liuqh
 * @date: 2019年11月21日
 */
public enum OracleDataType {
	Integer,// 整数类型，小的整数。
	
	Float,// 浮点数类型。
	
	Real,// 实数类型。
	
	Number,//（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数。
	
	CHAR,// 固定长度字符串 占2000个字节
	
	Varchar2,// 可变长度字符串 占4000个字节
	
	Nvarchar2,// 占2000个字符（最多能存2000个字母/中文）
	
	Blob,//二进制数据 最大长度4G  用于存一些图片，视频，文件。
	
	Clob,//字符数据 最大长度4G，，数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收。
	
	Date,// 日期（日-月-年） DD-MM-YY(HH-MI-SS)
	
	Timestamp,// 跟date比 它可以精确到微秒。精确范围0~9 默认为6.
	
	other;
	
	/**
	 * 自己定义一个静态方法,通过code返回枚举常量对象
	 * @param code
	 * @return
	 */
	public static OracleDataType getByValue(int code) {

		for (OracleDataType dt : values()) {
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
		OracleDataType[] odts = OracleDataType.values();
		for (OracleDataType m : odts){
			names.add(m.name().toLowerCase());
		}
		
		return names;
	}
}


