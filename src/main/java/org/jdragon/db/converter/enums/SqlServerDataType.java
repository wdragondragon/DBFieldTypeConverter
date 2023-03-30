package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * sqlserver 数据类型
 * @author liuqh
 * @date: 2020年07月09日
 */
public enum SqlServerDataType {
	
	//Character 字符串
	CHAR,	//固定长度的字符串。最多 8,000 个字符。	n
	VARCHAR,	//可变长度的字符串。最多 8,000 个字符。	 
	TEXT,	//可变长度的字符串。最多 2GB 字符数据。;
	
	//Unicode 字符串
	NCHAR, 	//固定长度的 Unicode 数据。最多 4,000 个字符。	 
	NVARCHAR,	//可变长度的 Unicode 数据。最多 4,000 个字符。	 
	NTEXT,	//可变长度的 Unicode 数据。最多 2GB 字符数据。
	
	//Binary 类型
	BIT,	//允许 0、1 或 NULL	 
	BINARY,	//固定长度的二进制数据。最多 8,000 字节。	 
	VARBINARY,	//可变长度的二进制数据。最多 8,000 字节。	 
	IMAGE,	//可变长度的二进制数据。最多 2GB
	
	//Number 类型
	TINYINT,	//允许从 0 到 255 的所有数字。	1 字节
	SMALLINT,	//允许从 -32,768 到 32,767 的所有数字。	2 字节
	INT,	//允许从 -2,147,483,648 到 2,147,483,647 的所有数字。	4 字节
	BIGINT,	//允许介于 -9,223,372,036,854,775,808 和 9,223,372,036,854,775,807 之间的所有数字。	8 字节
	DECIMAL,	/**固定精度和比例的数字。允许从 -10^38 +1 到 10^38 -1 之间的数字。p 参数指示可以存储的最大位数（小数点左侧和右侧）。p 必须是 1 到 38 之间的值。默认是 18。
					s 参数指示小数点右侧存储的最大位数。s 必须是 0 到 p 之间的值。默认是 0。
					5-17 字节
				*/
	
	NUMERIC,	/**	固定精度和比例的数字。允许从 -10^38 +1 到 10^38 -1 之间的数字。
					p 参数指示可以存储的最大位数（小数点左侧和右侧）。p 必须是 1 到 38 之间的值。默认是 18。
					s 参数指示小数点右侧存储的最大位数。s 必须是 0 到 p 之间的值。默认是 0。
					5-17 字节
	 			*/
	SMALLMONEY,	//介于 -214,748.3648 和 214,748.3647 之间的货币数据。	4 字节
	MONEY,	//介于 -922,337,203,685,477.5808 和 922,337,203,685,477.5807 之间的货币数据。	8 字节
	FLOAT,	//从 -1.79E + 308 到 1.79E + 308 的浮动精度数字数据。 参数 n 指示该字段保存 4 字节还是 8 字节。float(24) 保存 4 字节，而 float(53) 保存 8 字节。n 的默认值是 53。	4 或 8 字节
	REAL,	//从 -3.40E + 38 到 3.40E + 38 的浮动精度数字数据
	
	//Date 类型
	DATETIME,	//从 1753 年 1 月 1 日 到 9999 年 12 月 31 日，精度为 3.33 毫秒。	8 bytes
	DATETIME2,	//从 1753 年 1 月 1 日 到 9999 年 12 月 31 日，精度为 100 纳秒。	6-8 bytes
	SMALLDATETIME,	//从 1900 年 1 月 1 日 到 2079 年 6 月 6 日，精度为 1 分钟。	4 bytes
	DATE,	//仅存储日期。从 0001 年 1 月 1 日 到 9999 年 12 月 31 日。	3 bytes
	TIME,	//仅存储时间。精度为 100 纳秒。	3-5 bytes
	DATETIMEOFFSET,	//与 datetime2 相同，外加时区偏移。	8-10 bytes
	TIMESTAMP,	//存储唯一的数字，每当创建或修改某行时，该数字会更新。timestamp 基于内部时钟，不对应真实时间。每个表只能有一个 timestamp 变量
	
	//其他数据类型
	SQL_VARIANT,	//存储最多 8,000 字节不同数据类型的数据，除了 text、ntext 以及 timestamp。
	UNIQUEIDENTIFIER,	//存储全局标识符 (GUID)。
	XML,	//存储 XML 格式化数据。最多 2GB。
	CURSOR,	//存储对用于数据库操作的指针的引用。
	TABLE	//存储结果集，供稍后处理
	
	;
	
	/**
	 * 自己定义一个静态方法,通过code返回枚举常量对象
	 * @param code
	 * @return
	 */
	public static SqlServerDataType getByValue(int code) {

		for (SqlServerDataType dt : values()) {
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
		SqlServerDataType[] mdts = SqlServerDataType.values();
		for (SqlServerDataType m : mdts){
			names.add(m.name().toLowerCase());
		}
		
		return names;
	}
	
}


