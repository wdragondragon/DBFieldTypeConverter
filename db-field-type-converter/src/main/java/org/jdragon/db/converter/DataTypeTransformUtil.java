package org.jdragon.db.converter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jdragon.db.converter.enums.DataTypeGroup;
import org.jdragon.db.converter.enums.DataTypePool;
import org.jdragon.db.converter.enums.SourcesEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据类型转换工具类
 * @author liuqh
 * @date: 2019年11月4日
 */
@Slf4j
public class DataTypeTransformUtil {

	public static String toHiveType(String dataType){
		if (StringUtils.isNotEmpty(dataType)){
			dataType = dataType.toUpperCase();//换成大写
			DataTypePool dt;
			try{
				dt = DataTypePool.valueOf(dataType);
			}catch (Exception e){
				log.warn("转换类型异常，采用默认类型",e);
				dt = DataTypePool.STRING;
			}


			switch (dt){
				case NUMERIC:
					dt = DataTypePool.DOUBLE;
					break;
				case TINYINT://微整型，只占用1个字节，只能存储0-255的整数
					dt = DataTypePool.TINYINT;
					break;
				case SMALLINT://小整型，占用2个字节，存储范围–32768 到 32767
				case INT2://
					dt = DataTypePool.SMALLINT;
					break;
				case INT:// 整型，占用4个字节，存储范围-2147483648到2147483647
				case INT4:// 整型，占用4个字节，存储范围-2147483648到2147483647
				case SERIAL4://自增4字节整数
				case INTEGER://整数类型
				case SHORT://整数类型
				case BYTE://整数类型
				case INT64:
				case INT16:
				case INT32:
				case UINT8:
				case UINT16:
					dt = DataTypePool.INT;
					break;
				case BIGINT://长整型，占用8个字节，存储范围-2^63到2^63-1
				case INT8://长整型，占用8个字节，存储范围-2^63到2^63-1
				case SERIAL8://自增8字节整数
				case LONG://整数类型
				case MEDIUMINT://范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
				case INT128:
				case INT256:
				case UINT32:
				case UINT64:
				case UINT128:
				case UINT256:
					dt = DataTypePool.BIGINT;
					break;
				case REAL://实数类型。
				case FLOAT://单精度浮点数，4字节（32位）
				case FLOAT4://单精度浮点数，4字节（32位）
				case HALF_FLOAT://浮点类型
				case SCALED_FLOAT://浮点类型
				case FLOAT32:
					dt = DataTypePool.FLOAT;
					break;
				case FLOAT8:
				case DOUBLE://双精度浮点数，8字节（64位）
				case FLOAT64:
					dt = DataTypePool.DOUBLE;
					break;
				case DECIMAL://decimal(10,2)
				case SMALLMONEY://
				case NUMBER://Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数
				case GEO_POINT://地理类型 地理坐标类型
				case DECIMAL32:
				case DECIMAL64:
				case DECIMAL128_1:
				case DECIMAL256:
					dt = DataTypePool.DECIMAL;
					break;
				case TOKEN_COUNT://令牌计数类型
				case STRING://字符串
				case KEYWORD://字符串类型
				case IP://特殊类型 IP类型
					dt = DataTypePool.STRING;
					break;
				case VARCHAR://变长字符串 长度为1-65355
				case VARCHAR2://可变长度字符串 占4000个字节
				case NVARCHAR2://占2000个字符（最多能存2000个字母/中文
				case NVARCHAR://
				case TEXT://字符串类型
				case TINYBLOB://0-255字节	不超过 255 个字符的二进制字符串
				case TINYTEXT: // 0-255字节 短文本字符串
				case BLOB: // 0-65 535字节 二进制形式的长文本数据
				case MEDIUMBLOB: // 0-16 777 215字节 二进制形式的中等长度文本数据
				case MEDIUMTEXT: // 0-16 777 215字节 中等长度文本数据
				case LONGBLOB: // 0-4 294 967 295字节 二进制形式的极大文本数据
				case LONGTEXT: // 0-4 294 967 295字节	极大文本数据
				case OBJECT://对象类型
				case DOCUMENT://文档类型
				case NTEXT://
				case CLOB://字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
				case INTERVAL:
				case Date32:
				case IPV4:
				case IPV6:
				case BINTEXT:
				case SHORTTEXT:
//					dt = DataTypePool.VARCHAR;
					dt = DataTypePool.STRING;
					break;
				case CHAR://0-255字节 定长字符串
//					dt = DataTypePool.CHAR;
					dt = DataTypePool.STRING;
					break;
				case BINARY://二进制类型
				case VARBINARY:
				case IMAGE:
					dt = DataTypePool.BINARY;
					break;
				case DATE://2019-10-26
					dt = DataTypePool.DATE;
					break;
				case YEAR://范围YYYY    年份值
					dt = DataTypePool.STRING;
					break;
				case TIMESTAMP://Integer/Floating/YYYY-MM-DD hh:mm:ss.fffffffff
				case TIME://范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
				case DATETIME2:
				case DATETIMEOFFSET:
				case DATETIME:
				case SMALLDATETIME:
					dt = DataTypePool.TIMESTAMP;
					break;
				case BOOLEAN://true/false
				case BOOL://true/false
					dt = DataTypePool.BOOLEAN;
					break;
				case ARRAY://数组，ARRAY(data_type)
					dt = DataTypePool.ARRAY;
					break;
				default:
					dt = DataTypePool.STRING;
					break;
			}

			return dt.getDataType();
		}
		else{
			return null;
		}
	}

	public static String toEsType(String dataType){
		if (StringUtils.isNotEmpty(dataType)){
			dataType = dataType.toUpperCase();//换成大写
			DataTypePool dt;
            try{
                dt = DataTypePool.valueOf(dataType);
            }catch (Exception e){
                log.warn("转换类型异常，采用默认类型",e);
                dt = DataTypePool.STRING;
            }

			switch (dt){
				case TINYINT://微整型，只占用1个字节，只能存储0-255的整数
				case SMALLINT://小整型，占用2个字节，存储范围–32768 到 32767
				case SHORT://整数类型
				case INT2://整数类型
					dt = DataTypePool.SHORT;
					break;
				case INT:// 整型，占用4个字节，存储范围-2147483648到2147483647
				case INT4:
				case INTEGER://整数类型
				case BYTE://整数类型
				case REAL://实数类型。
				case SERIAL4://自增4字节整数
				case INT64:
				case INT16:
				case INT32:
				case UINT8:
				case UINT16:
					dt = DataTypePool.INTEGER;
					break;
				case BIGINT://长整型，占用8个字节，存储范围-2^63到2^63-1
				case LONG://整数类型
				case INT8://整数类型
				case MEDIUMINT://范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
				case SERIAL8://自增8字节整数
				case INT128:
				case INT256:
				case UINT32:
				case UINT64:
				case UINT128:
				case UINT256:
					dt = DataTypePool.LONG;
					break;
				case FLOAT://单精度浮点数，4字节（32位）
				case FLOAT4://单精度浮点数，4字节（32位）
				case FLOAT32:
					dt = DataTypePool.FLOAT;
					break;
				case HALF_FLOAT://浮点类型
					dt = DataTypePool.HALF_FLOAT;
					break;
				case SCALED_FLOAT://浮点类型
					dt = DataTypePool.SCALED_FLOAT;
					break;
				case DOUBLE://双精度浮点数，8字节（64位）
				case FLOAT8://PG，双精度浮点数，8字节（64位）
				case DECIMAL://decimal(10,2)
				case SMALLMONEY://
				case NUMBER://Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数
				case FLOAT64:
				case DECIMAL32:
				case DECIMAL64:
				case DECIMAL128_1:
				case DECIMAL256:
					dt = DataTypePool.DOUBLE;
					break;
				case TEXT://字符串类型
				case VARCHAR://变长字符串 长度为1-65355
				case VARCHAR2://可变长度字符串 占4000个字节
				case NVARCHAR2://占2000个字符（最多能存2000个字母/中文
				case TINYTEXT: // 0-255字节 短文本字符串
				case MEDIUMTEXT: // 0-16 777 215字节 中等长度文本数据
				case LONGTEXT: // 0-4 294 967 295字节	极大文本数据
				case NTEXT://
				case CLOB://字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
				case BINTEXT:
				case DOCUMENT://文档类型
				case SHORTTEXT:
					dt = DataTypePool.TEXT;
					break;
				case KEYWORD://字符串类型
					dt = DataTypePool.KEYWORD;
					break;
				case STRING://字符串,从ElasticSearch 5.x开始不再支持string，由text和keyword类型替代
				case NVARCHAR://
				case Date32:
				case IPV4:
				case IPV6:
					dt = DataTypePool.STRING;
					break;
				case IP://特殊类型 IP类型
					dt = DataTypePool.IP;
					break;
				case TOKEN_COUNT://令牌计数类型
					dt = DataTypePool.TOKEN_COUNT;
					break;
				case CHAR://0-255字节 定长字符串
					dt = DataTypePool.CHAR;
					break;
				case BINARY://二进制类型
				case BLOB: // 0-65 535字节 二进制形式的长文本数据
				case TINYBLOB://0-255字节	不超过 255 个字符的二进制字符串
				case MEDIUMBLOB: // 0-16 777 215字节 二进制形式的中等长度文本数据
				case LONGBLOB: // 0-4 294 967 295字节 二进制形式的极大文本数据
				case VARBINARY:
				case IMAGE:
					dt = DataTypePool.BINARY;
					break;
				case DATE://2019-10-26
				case YEAR://范围YYYY    年份值
				case TIMESTAMP://Integer/Floating/YYYY-MM-DD hh:mm:ss.fffffffff
				case TIME://范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
				case DATETIME:
				case DATETIME2:
				case DATETIMEOFFSET:
				case SMALLDATETIME:
					dt = DataTypePool.DATE;
					break;
				case RANGE:
					dt = DataTypePool.RANGE;
					break;
				case BOOLEAN://true/false
					dt = DataTypePool.BOOLEAN;
					break;
				case ARRAY://数组，ARRAY(data_type)
					dt = DataTypePool.ARRAY;
					break;
				case OBJECT://对象类型
					dt = DataTypePool.OBJECT;
					break;
				case NESTED://嵌套类型
					dt = DataTypePool.NESTED;
					break;
				case GEO_POINT:////地理类型 地理坐标类型
					dt = DataTypePool.GEO_POINT;
					break;
				case GEO_SHAPE://地理地图
					dt = DataTypePool.GEO_SHAPE;
					break;
				case COMPLETION://范围类型
					dt = DataTypePool.COMPLETION;
					break;
				case ATTACHMENT://附件类型
					dt = DataTypePool.ATTACHMENT;
					break;
				case PERCOLATOR://抽取类型
					dt = DataTypePool.PERCOLATOR;
					break;
				default:
					dt = DataTypePool.STRING;
					break;
			}

			return dt.getDataType();
		}
		else{
			return null;
		}
	}

	private static String toHanaType(String dataType) {
		if (StringUtils.isNotEmpty(dataType)){
			dataType = dataType.toUpperCase();//换成大写
			DataTypePool dt;
			try{
				dt = DataTypePool.valueOf(dataType);
			}catch (Exception e){
				log.warn("转换类型异常，采用默认类型",e);
				dt = DataTypePool.VARCHAR;
			}
			switch (dt){
				case BOOLEAN://true/false
					dt = DataTypePool.BOOLEAN;
				case TINYINT://微整型，只占用1个字节，只能存储0-255的整数
				case SMALLINT://小整型，占用2个字节，存储范围–32768 到 32767
				case INT2:
					dt = DataTypePool.SMALLINT;
					break;
				case MEDIUMINT://范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
					dt = DataTypePool.BIGINT;
					break;
				case INT:// 整型，占用4个字节，存储范围-2147483648到2147483647
				case INT4:
				case INT16:
				case INT32:
				case UINT8:
				case UINT16:
				case SERIAL4://自增4字节整数
				case INTEGER://整数类型
				case SHORT://整数类型
				case BYTE://整数类型
					dt = DataTypePool.INTEGER;
					break;
				case REAL://实数类型。
					dt = DataTypePool.REAL;
					break;
				case INT8:
				case SERIAL8://自增8字节整数
				case BIGINT://长整型，占用8个字节，存储范围-2^63到2^63-1
				case LONG://整数类型
				case INT64:
				case INT128:
				case INT256:
				case UINT32:
				case UINT64:
				case UINT128:
				case UINT256:
					dt = DataTypePool.BIGINT;
					break;
				case FLOAT://单精度浮点数，4字节（32位）
				case FLOAT4://
				case FLOAT32:
				case HALF_FLOAT://浮点类型
				case SCALED_FLOAT://浮点类型
				case FLOAT8://
				case DOUBLE://双精度浮点数，8字节（64位）
				case FLOAT64:
					dt = DataTypePool.VARCHAR;
					break;
				case DECIMAL://decimal(10,2)
				case SMALLMONEY://
				case NUMBER://Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数
				case GEO_POINT://地理类型 地理坐标类型
				case DECIMAL32:
				case DECIMAL64:
				case DECIMAL128_1:
				case DECIMAL256:
					dt = DataTypePool.DECIMAL;
					break;
				case TOKEN_COUNT://令牌计数类型
				case KEYWORD://字符串类型
				case IP://特殊类型 IP类型
				case CHAR://0-255字节 定长字符串
				case STRING://字符串
				case VARCHAR://变长字符串 长度为1-65355
				case VARCHAR2://可变长度字符串 占4000个字节
				case NVARCHAR2://占2000个字符（最多能存2000个字母/中文
				case NVARCHAR://
				case NTEXT://
				case CLOB://字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
				case INTERVAL:
				case OBJECT://对象类型
				case IPV4:
				case IPV6:
					dt = DataTypePool.VARCHAR;
					break;
				case TINYBLOB://0-255字节	不超过 255 个字符的二进制字符串
				case TEXT://长文本数据
					dt = DataTypePool.BINTEXT;
					break;
				case TINYTEXT: // 0-255字节 短文本字符串
				case MEDIUMTEXT:
				case BINTEXT:
				case DOCUMENT://文档类型
				case SHORTTEXT:
					dt = DataTypePool.TEXT;
					break;
				case BLOB: // 0-65 535字节 二进制形式的长文本数据
				case BINARY://二进制类型
				case MEDIUMBLOB: // 0-16 777 215字节 二进制形式的中等长度文本数据
					dt = DataTypePool.BLOB;
					break;
				case LONGBLOB: // 0-4 294 967 295字节 二进制形式的极大文本数据
				case VARBINARY:
				case IMAGE:
				case LONGTEXT: // 0-4 294 967 295字节	极大文本数据
					dt = DataTypePool.BINTEXT;
					break;
				case DATE://2019-10-26
				case Date32:
					dt = DataTypePool.DATE;
					break;
				case TIME://范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
					dt = DataTypePool.TIME;
					break;
				case YEAR://范围YYYY    年份值
					dt = DataTypePool.VARCHAR;
					break;
				case TIMESTAMP://Integer/Floating/YYYY-MM-DD hh:mm:ss.fffffffff
				case DATETIME2:
				case DATETIMEOFFSET:
				case SMALLDATETIME:
					dt = DataTypePool.TIMESTAMP;
					break;
				case DATETIME:
					dt = DataTypePool.DATETIME;
					break;
				default:
					dt = DataTypePool.VARCHAR;
					break;
			}

			return dt.getDataType();
		}
		else{
			return null;
		}
	}

	public static String toMysqlType(String dataType){
		if (StringUtils.isNotEmpty(dataType)){
			dataType = dataType.toUpperCase();//换成大写
            DataTypePool dt;
            try{
                dt = DataTypePool.valueOf(dataType);
            }catch (Exception e){
                log.warn("转换类型异常，采用默认类型",e);
                dt = DataTypePool.VARCHAR;
            }
			switch (dt){
				case BOOLEAN://true/false
				case TINYINT://微整型，只占用1个字节，只能存储0-255的整数
					dt = DataTypePool.TINYINT;
					break;
				case SMALLINT://小整型，占用2个字节，存储范围–32768 到 32767
				case INT2:
					dt = DataTypePool.SMALLINT;
					break;
				case MEDIUMINT://范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
					dt = DataTypePool.MEDIUMINT;
					break;
				case INT:// 整型，占用4个字节，存储范围-2147483648到2147483647
				case INT4:
				case INT16:
				case INT32:
				case UINT8:
				case UINT16:
				case SERIAL4://自增4字节整数
				case INTEGER://整数类型
				case SHORT://整数类型
				case BYTE://整数类型
					dt = DataTypePool.INT;
					break;
				case INT8:
				case SERIAL8://自增8字节整数
				case BIGINT://长整型，占用8个字节，存储范围-2^63到2^63-1
				case LONG://整数类型
				case INT64:
				case INT128:
				case INT256:
				case UINT32:
				case UINT64:
				case UINT128:
				case UINT256:
					dt = DataTypePool.BIGINT;
					break;
				case FLOAT://单精度浮点数，4字节（32位）
				case FLOAT4://
				case FLOAT32:
				case HALF_FLOAT://浮点类型
				case SCALED_FLOAT://浮点类型
					dt = DataTypePool.FLOAT;
					break;
				case FLOAT8://
				case DOUBLE://双精度浮点数，8字节（64位）
				case FLOAT64:
				case REAL://实数类型。
					dt = DataTypePool.DOUBLE;
					break;
				case DECIMAL://decimal(10,2)
				case SMALLMONEY://
				case NUMBER://Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数
				case GEO_POINT://地理类型 地理坐标类型
				case DECIMAL32:
				case DECIMAL64:
				case DECIMAL128_1:
				case DECIMAL256:
					dt = DataTypePool.DECIMAL;
					break;
				case TOKEN_COUNT://令牌计数类型
				case KEYWORD://字符串类型
				case IP://特殊类型 IP类型
				case CHAR://0-255字节 定长字符串
					dt = DataTypePool.CHAR;
					break;
				case STRING://字符串
				case VARCHAR://变长字符串 长度为1-65355
				case VARCHAR2://可变长度字符串 占4000个字节
				case NVARCHAR2://占2000个字符（最多能存2000个字母/中文
				case NVARCHAR://
				case NTEXT://
				case CLOB://字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
				case INTERVAL:
				case IPV4:
				case IPV6:
				case OBJECT://对象类型
				case Date32:
					dt = DataTypePool.VARCHAR;
					break;
				case TINYBLOB://0-255字节	不超过 255 个字符的二进制字符串
					dt = DataTypePool.TINYBLOB;
					break;
				case TEXT://长文本数据
				case BINTEXT:
				case DOCUMENT://文档类型
				case SHORTTEXT:
                    dt = DataTypePool.TEXT;
					break;
				case TINYTEXT: // 0-255字节 短文本字符串
					dt = DataTypePool.TINYTEXT;
					break;
				case BLOB: // 0-65 535字节 二进制形式的长文本数据
				case BINARY://二进制类型
					dt = DataTypePool.BLOB;
					break;
				case MEDIUMBLOB: // 0-16 777 215字节 二进制形式的中等长度文本数据
					dt = DataTypePool.MEDIUMBLOB;
					break;
				case MEDIUMTEXT: // 0-16 777 215字节 中等长度文本数据
					dt = DataTypePool.MEDIUMTEXT;
					break;
				case LONGBLOB: // 0-4 294 967 295字节 二进制形式的极大文本数据
				case VARBINARY:
				case IMAGE:
					dt = DataTypePool.LONGBLOB;
					break;
				case LONGTEXT: // 0-4 294 967 295字节	极大文本数据
					dt = DataTypePool.LONGTEXT;
					break;
				case DATE://2019-10-26
					dt = DataTypePool.DATE;
					break;
				case TIME://范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
					dt = DataTypePool.TIME;
					break;
				case YEAR://范围YYYY    年份值
					dt = DataTypePool.YEAR;
					break;
				case TIMESTAMP://Integer/Floating/YYYY-MM-DD hh:mm:ss.fffffffff
				case DATETIME2:
				case DATETIMEOFFSET:
				case SMALLDATETIME:
					dt = DataTypePool.TIMESTAMP;
					break;
				case DATETIME:
					dt = DataTypePool.DATETIME;
					break;
				default:
					dt = DataTypePool.VARCHAR;
					break;
			}

			return dt.getDataType();
		}
		else{
			return null;
		}
	}

	public static String toOracleType(String dataType){
		if (StringUtils.isNotEmpty(dataType)){
			dataType = dataType.toUpperCase();//换成大写
            DataTypePool dt;
            try{
                dt = DataTypePool.valueOf(dataType);
            }catch (Exception e){
                log.warn("转换类型异常，采用默认类型",e);
                dt = DataTypePool.VARCHAR2;
            }
			switch (dt){
				case INT2:
				case INT4:
				case SERIAL4://自增4字节整数
				case TINYINT://微整型，只占用1个字节，只能存储0-255的整数
				case SMALLINT://小整型，占用2个字节，存储范围–32768 到 32767
				case MEDIUMINT://范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
				case INT:// 整型，占用4个字节，存储范围-2147483648到2147483647
				case INTEGER://整数类型
				case SHORT://整数类型
				case BYTE://整数类型
				case INT64:
				case INT16:
				case INT32:
				case UINT8:
				case UINT16:
//					dt = DataTypePool.INTEGER;
					dt = DataTypePool.NUMBER;
					break;
				case INT8:
				case SERIAL8://自增8字节整数
				case SMALLMONEY://
				case BIGINT://长整型，占用8个字节，存储范围-2^63到2^63-1
				case DECIMAL://decimal(10,2)
				case DECIMAL32:
				case DECIMAL64:
				case DECIMAL128_1:
				case DECIMAL256:
					dt = DataTypePool.DECIMAL;
					break;
				case LONG://超长字符串 最大长度2G（231-1） 足够存储大部头著作
				case INT128:
				case INT256:
				case UINT32:
				case UINT64:
				case UINT128:
				case UINT256:
					/*if (se.equals(SourcesEnum.mysql)){
						dt = DataTypePool.LONG;
						break;
					}
					else{
					}*/
					dt = DataTypePool.LONG;
					break;
				case FLOAT://浮点数类型 NUMBER(38)，双精度
				case FLOAT4://
				case HALF_FLOAT://浮点类型
				case SCALED_FLOAT://浮点类型
				case FLOAT32:
				case FLOAT64:
					dt = DataTypePool.FLOAT;
					break;
				case FLOAT8://
				case DOUBLE://双精度浮点数，8字节（64位）
				case GEO_POINT://地理类型 地理坐标类型
				case REAL://实数类型 NUMBER(63)，精度更高
					dt = DataTypePool.REAL;
					break;
				case NUMBER://Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数
					dt = DataTypePool.NUMBER;
					break;
				case BOOL:
				case BOOLEAN://true/false
					dt = DataTypePool.VARCHAR;
					break;
				case TOKEN_COUNT://令牌计数类型
				case KEYWORD://字符串类型
				case IP://特殊类型 IP类型
				case CHAR:// 固定长度字符串 最大长度2000 bytes
					dt = DataTypePool.CHAR;
					break;
				case NCHAR:// 固定长度字符串 最大长度2000 bytes
					dt = DataTypePool.NCHAR ;
					break;
				case STRING://字符串
				case VARCHAR://变长字符串 长度为1-65355
				case VARCHAR2://可变长度字符串 占4000个字节
				case NVARCHAR://
				case INTERVAL: // oracle需要INTERVAL YEAR TO MONTH、INTERVAL DAY TO SECOND，确定不了，先转为字符串
				case Date32:
				case IPV4:
				case OBJECT://对象类型
				case IPV6:
					dt = DataTypePool.VARCHAR2;
					break;
				case NVARCHAR2://占2000个字符（最多能存2000个字母/中文
					dt = DataTypePool.NVARCHAR2;
					break;
				case BLOB: // 二进制数据 最大长度4G
				case TINYBLOB://0-255字节	不超过 255 个字符的二进制字符串
				case LONGBLOB: // 0-4 294 967 295字节 二进制形式的极大文本数据
				case BINARY://二进制类型
				case VARBINARY:
				case IMAGE:
				case MEDIUMBLOB: // 0-16 777 215字节 二进制形式的中等长度文本数据
					dt = DataTypePool.BLOB;
					break;
				case CLOB://字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
				case LONGTEXT: // 0-4 294 967 295字节	极大文本数据
				case TEXT://长文本数据
				case DOCUMENT://文档类型
				case TINYTEXT: // 0-255字节 短文本字符串
				case MEDIUMTEXT: // 0-16 777 215字节 中等长度文本数据
				case NTEXT://
				case BINTEXT:
				case SHORTTEXT:
					dt = DataTypePool.CLOB;
					break;
				case DATE://2019-10-26
				case TIME://范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
				case YEAR://范围YYYY    年份值
				case TIMESTAMP://Integer/Floating/YYYY-MM-DD hh:mm:ss.fffffffff
				case DATETIME:
				case DATETIME2:
				case DATETIMEOFFSET:
				case SMALLDATETIME:
					dt = DataTypePool.DATE;
					break;
				case RAW ://
					dt = DataTypePool.RAW;
					break;
				default:
					dt = DataTypePool.VARCHAR2;
					break;
			}

			return dt.getDataType();
		}
		else{
			return null;
		}
	}

	/**
	 * 转换为postgreSql类型
	 * @author liuqh
	 * @date: 2020年4月25日
	 * @param dataType
	 * @return
	 */
	public static String toSqlServerType(String dataType){
		if (StringUtils.isNotEmpty(dataType)){
			dataType = dataType.toUpperCase();//换成大写
            DataTypePool dt;
            try{
                dt = DataTypePool.valueOf(dataType);
            }catch (Exception e){
                log.warn("转换类型异常，采用默认类型",e);
                dt = DataTypePool.NVARCHAR;
            }
			switch (dt){
			case TINYINT://微整型，只占用1个字节，只能存储0-255的整数
			case INT2://小整型，占用2个字节，存储范围–32768 到 32767
			case SHORT://整数类型
				dt = DataTypePool.TINYINT;
				break;
			case SMALLINT://小整型，占用2个字节，存储范围–32768 到 32767
				dt = DataTypePool.SMALLINT;
				break;
			case INT:// 整型，占用4个字节，存储范围-2147483648到2147483647
			case INT4:// 整型，占用4个字节，存储范围-2147483648到2147483647
			case BYTE://整数类型
			case BYTEA://整数类型
			case SERIAL4://自增 4字节整数
			case SERIAL://
			case INTEGER://整数类型
			case INT64:
			case INT16:
			case INT32:
			case UINT8:
			case UINT16:
				dt = DataTypePool.INT;
				break;
			case BIGINT://长整型，占用8个字节，存储范围-2^63到2^63-1
			case LONG://超长字符串 最大长度2G（231-1） 足够存储大部头著作
			case MEDIUMINT://范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
			case SERIAL8://自增 8字节整数
			case BIGSERIAL://
			case INT8://
            case INT128:
            case INT256:
            case UINT32:
            case UINT64:
            case UINT128:
            case UINT256:
				dt = DataTypePool.BIGINT;
				break;
			case DECIMAL://decimal(10,2)
            case DECIMAL32:
            case DECIMAL64:
            case DECIMAL128_1:
            case DECIMAL256:
				dt = DataTypePool.DECIMAL;
				break;
			case NUMERIC://decimal(10,2)
			case NUMBER://Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数
				dt = DataTypePool.NUMERIC;
				break;
			case MONEY://
				dt = DataTypePool.MONEY;
				break;
			case SMALLMONEY://
				dt = DataTypePool.SMALLMONEY;
				break;
			case FLOAT://浮点数类型 NUMBER(38)，双精度
			case FLOAT4://
			case HALF_FLOAT://浮点类型
			case SCALED_FLOAT://浮点类型
            case FLOAT32:
				dt = DataTypePool.FLOAT;
				break;
			case GEO_POINT://地理类型 地理坐标类型
			case FLOAT8://
			case DOUBLE://双精度浮点数，8字节（64位）
			case REAL://实数类型 NUMBER(63)，精度更高
            case FLOAT64:
				dt = DataTypePool.REAL;
				break;
			case CIDR://IPv4 或者 IPv6 网络地址
			case INET://IPv4 或者 IPv6 网络地址
			case IP://特殊类型 IP类型
			case TOKEN_COUNT://令牌计数类型
			case KEYWORD://字符串类型
			case BOOLEAN://true/false
			case BOOL://true/false
			case CHAR:// 固定长度字符串 最大长度2000 bytes
				dt = DataTypePool.CHAR;
				break;
			case NCHAR:// 固定长度字符串 最大长度2000 bytes
			case STRING://字符串
			case VARCHAR://变长字符串 长度为1-65355
			case VARCHAR2://可变长度字符串 占4000个字节
			case NVARCHAR://
			case NVARCHAR2://占2000个字符（最多能存2000个字母/中文
			case INTERVAL:
            case Date32:
            case IPV4:
			case OBJECT://对象类型
			case IPV6:
				dt = DataTypePool.NVARCHAR;
				break;
			case BLOB: // 二进制数据 最大长度4G
			case TINYBLOB://0-255字节	不超过 255 个字符的二进制字符串
			case LONGBLOB: // 0-4 294 967 295字节 二进制形式的极大文本数据
			case BINARY://二进制类型
			case VARBINARY:
			case IMAGE:
			case MEDIUMBLOB: // 0-16 777 215字节 二进制形式的中等长度文本数据
			case CLOB://字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
			case LONGTEXT: // 0-4 294 967 295字节	极大文本数据
			case TEXT://长文本数据
			case DOCUMENT://文档类型
			case TINYTEXT: // 0-255字节 短文本字符串
			case MEDIUMTEXT: // 0-16 777 215字节 中等长度文本数据
			case NTEXT://
			case RAW ://
			case BINTEXT:
			case SHORTTEXT:
					dt = DataTypePool.NTEXT;
				break;
			case DATE://2019-10-26
			case YEAR://范围YYYY    年份值
				dt = DataTypePool.DATE;
				break;
			case DATETIME:
			case TIMESTAMP://
			case DATETIME2:
			case DATETIMEOFFSET:
			case SMALLDATETIME:
				dt = DataTypePool.DATETIME;
				break;
			case TIME://范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
				dt = DataTypePool.TIME;
				break;
			default:
				dt = DataTypePool.NVARCHAR;
				break;
			}

			return dt.getDataType();
		}
		else{
			return null;
		}
	}

	/**
	 * 转换为postgreSql类型
	 * @author liuqh
	 * @date: 2020年4月25日
	 * @param dataType
	 * @return
	 */
	public static String toPostgreSqlType(String dataType){
		if (StringUtils.isNotEmpty(dataType)){
			dataType = dataType.toUpperCase();//换成大写
            DataTypePool dt;
            try{
                dt = DataTypePool.valueOf(dataType);
            }catch (Exception e){
                log.warn("转换类型异常，采用默认类型",e);
                dt = DataTypePool.VARCHAR;
            }

			switch (dt){
			case TINYINT://微整型，只占用1个字节，只能存储0-255的整数
			case SMALLINT://小整型，占用2个字节，存储范围–32768 到 32767
			case INT2://小整型，占用2个字节，存储范围–32768 到 32767
			case SHORT://整数类型
				dt = DataTypePool.INT2;
				break;
			case INT:// 整型，占用4个字节，存储范围-2147483648到2147483647
			case INT4:// 整型，占用4个字节，存储范围-2147483648到2147483647
			case INTEGER://整数类型
            case INT64:
            case INT16:
            case INT32:
            case UINT8:
            case UINT16:
				dt = DataTypePool.INT4;
				break;
			case BIGINT://长整型，占用8个字节，存储范围-2^63到2^63-1
			case LONG://超长字符串 最大长度2G（231-1） 足够存储大部头著作
			case INT8://
            case INT128:
            case INT256:
            case UINT32:
            case UINT64:
            case UINT128:
            case UINT256:
				dt = DataTypePool.INT8;
				break;
			case BYTE://整数类型
			case BYTEA://整数类型
				dt = DataTypePool.BYTEA;
				break;
			case MEDIUMINT://范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
			case DECIMAL://decimal(10,2)
			case NUMERIC://decimal(10,2)
			case SMALLMONEY://
			case NUMBER://Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数
            case DECIMAL32:
            case DECIMAL64:
            case DECIMAL128_1:
            case DECIMAL256:
				dt = DataTypePool.NUMERIC;
				break;
			case FLOAT://浮点数类型 NUMBER(38)，双精度
			case FLOAT4://
			case HALF_FLOAT://浮点类型
			case SCALED_FLOAT://浮点类型
            case FLOAT32:
				dt = DataTypePool.FLOAT4;
				break;
			case GEO_POINT://地理类型 地理坐标类型
			case FLOAT8://
			case DOUBLE://双精度浮点数，8字节（64位）
			case REAL://实数类型 NUMBER(63)，精度更高
            case FLOAT64:
				dt = DataTypePool.FLOAT8;
				break;
			case CIDR://IPv4 或者 IPv6 网络地址
				dt = DataTypePool.CIDR;
				break;
			case SERIAL4://自增 4字节整数
			case SERIAL://
				dt = DataTypePool.SERIAL4;
				break;
			case SERIAL8://自增 8字节整数
			case BIGSERIAL://
				dt = DataTypePool.SERIAL8;
				break;
			case INET://IPv4 或者 IPv6 网络地址
				dt = DataTypePool.CIDR;
				break;
			case IP://特殊类型 IP类型
			case TOKEN_COUNT://令牌计数类型
			case KEYWORD://字符串类型
			case BOOLEAN://true/false
			case CHAR:// 固定长度字符串 最大长度2000 bytes
				dt = DataTypePool.CHAR;
				break;
			case NCHAR:// 固定长度字符串 最大长度2000 bytes
			case STRING://字符串
			case VARCHAR://变长字符串 长度为1-65355
			case VARCHAR2://可变长度字符串 占4000个字节
			case NVARCHAR://
			case NVARCHAR2://占2000个字符（最多能存2000个字母/中文、
            case Date32:
            case IPV4:
			case OBJECT://对象类型
			case IPV6:
				dt = DataTypePool.VARCHAR;
				break;
			case BLOB: // 二进制数据 最大长度4G
			case TINYBLOB://0-255字节	不超过 255 个字符的二进制字符串
			case LONGBLOB: // 0-4 294 967 295字节 二进制形式的极大文本数据
			case BINARY://二进制类型
			case VARBINARY:
			case IMAGE:
			case MEDIUMBLOB: // 0-16 777 215字节 二进制形式的中等长度文本数据
			case CLOB://字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
			case LONGTEXT: // 0-4 294 967 295字节	极大文本数据
			case TEXT://长文本数据
			case TINYTEXT: // 0-255字节 短文本字符串
			case MEDIUMTEXT: // 0-16 777 215字节 中等长度文本数据
			case NTEXT://
			case RAW ://
			case BINTEXT:
			case DOCUMENT://文档类型
			case SHORTTEXT:
				dt = DataTypePool.TEXT;
				break;
			case DATE://2019-10-26
			case YEAR://范围YYYY    年份值
				dt = DataTypePool.DATE;
				break;
			case DATETIME:
			case TIMESTAMP://
			case DATETIME2:
			case DATETIMEOFFSET:
			case SMALLDATETIME:
				dt = DataTypePool.TIMESTAMP;
				break;
			case TIME://范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
				dt = DataTypePool.TIME;
				break;
			default:
				dt = DataTypePool.VARCHAR;
				break;
			}

			return dt.getDataType();
		}
		else{
			return null;
		}
	}

	/**
	 * 转换为greenPlum类型
	 * @author liuqh
	 * @date: 2020年3月3日
	 * @param dataType
	 * @return
	 */
	public static String toGreenPlumType(String dataType){
		if (StringUtils.isNotEmpty(dataType)){
			dataType = dataType.toUpperCase();//换成大写
            DataTypePool dt;
            try{
                dt = DataTypePool.valueOf(dataType);
            }catch (Exception e){
                log.warn("转换类型异常，采用默认类型",e);
                dt = DataTypePool.VARCHAR;
            }
			switch (dt){
			case TINYINT://微整型，只占用1个字节，只能存储0-255的整数
			case SMALLINT://小整型，占用2个字节，存储范围–32768 到 32767
			case SHORT://整数类型
			case INT2://整数类型
				dt = DataTypePool.SMALLINT;
				break;
			case INT:// 整型，占用4个字节，存储范围-2147483648到2147483647
			case INTEGER://整数类型
			case INT4://整数类型
			case BYTE://整数类型
			case SERIAL4://自增4字节整数
            case INT64:
            case INT16:
            case INT32:
            case UINT8:
            case UINT16:
				dt = DataTypePool.INTEGER;
				break;
			case SERIAL8://自增8字节整数
			case BIGINT://长整型，占用8个字节，存储范围-2^63到2^63-1
			case INT8://
            case INT128:
            case INT256:
            case UINT32:
            case UINT64:
            case UINT128:
            case UINT256:
				dt = DataTypePool.BIGINT;
				break;
			case MEDIUMINT://范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
			case DECIMAL://decimal(10,2)
			case SMALLMONEY://
            case FLOAT32:
            case FLOAT64:
            case DECIMAL32:
            case DECIMAL64:
            case DECIMAL128_1:
            case DECIMAL256:
				dt = DataTypePool.DECIMAL;
				break;
			case LONG://超长字符串 最大长度2G（231-1） 足够存储大部头著作
			case FLOAT://浮点数类型 NUMBER(38)，双精度
			case FLOAT4://
			case FLOAT8://
			case HALF_FLOAT://浮点类型
			case SCALED_FLOAT://浮点类型
			case DOUBLE://双精度浮点数，8字节（64位）
			case GEO_POINT://地理类型 地理坐标类型
			case REAL://实数类型 NUMBER(63)，精度更高
				dt = DataTypePool.REAL;
				break;
			case NUMBER://Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数
				dt = DataTypePool.NUMERIC;
				break;
			case TOKEN_COUNT://令牌计数类型
			case KEYWORD://字符串类型
			case IP://特殊类型 IP类型
			case BOOLEAN://true/false
			case CHAR:// 固定长度字符串 最大长度2000 bytes
				dt = DataTypePool.CHAR;
				break;
			case NCHAR:// 固定长度字符串 最大长度2000 bytes
			case STRING://字符串
			case VARCHAR://变长字符串 长度为1-65355
			case VARCHAR2://可变长度字符串 占4000个字节
			case NVARCHAR2://占2000个字符（最多能存2000个字母/中文
			case NVARCHAR://
            case Date32:
            case IPV4:
            case IPV6:
				dt = DataTypePool.VARCHAR;
				break;
			case BLOB: // 二进制数据 最大长度4G
			case TINYBLOB://0-255字节	不超过 255 个字符的二进制字符串
			case LONGBLOB: // 0-4 294 967 295字节 二进制形式的极大文本数据
			case BINARY://二进制类型
			case VARBINARY:
			case IMAGE:
			case MEDIUMBLOB: // 0-16 777 215字节 二进制形式的中等长度文本数据
			case CLOB://字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
			case LONGTEXT: // 0-4 294 967 295字节	极大文本数据
			case TEXT://长文本数据
			case TINYTEXT: // 0-255字节 短文本字符串
			case MEDIUMTEXT: // 0-16 777 215字节 中等长度文本数据
			case NTEXT://
			case RAW ://
			case DOCUMENT://文档类型
			case BINTEXT:
			case SHORTTEXT:
				dt = DataTypePool.TEXT;
				break;
			case DATE://2019-10-26
			case YEAR://范围YYYY    年份值
				dt = DataTypePool.DATE;
				break;
			case DATETIME:
			case TIMESTAMP://
			case DATETIME2:
			case DATETIMEOFFSET:
			case SMALLDATETIME:
				dt = DataTypePool.TIMESTAMP;
				break;
			case TIME://范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
				dt = DataTypePool.TIME;
				break;
			default:
				dt = DataTypePool.VARCHAR;
				break;
			}

			return dt.getDataType();
		}
		else{
			return null;
		}
	}


	public static String toClickHouseType(String dataType){
		if (StringUtils.isNotEmpty(dataType)){
			dataType = dataType.toUpperCase();//换成大写
			DataTypePool dt = DataTypePool.getByDataType(dataType);
            if(dt==null){
                return DataTypePool.STRING_CLICKHOUSE.getDataType();
            }
			switch (dt){
				case BOOLEAN://true/false
					dt = DataTypePool.BOOL_CLICKHOUSE;
					break;
				case TINYINT://微整型，只占用1个字节，只能存储0-255的整数
					dt = DataTypePool.UINT8;
					break;
				case SMALLINT://小整型，占用2个字节，存储范围–32768 到 32767
				case INT2:
					dt = DataTypePool.INT16;
					break;
				case MEDIUMINT://范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
				case INT:// 整型，占用4个字节，存储范围-2147483648到2147483647
				case INT4:
				case INT16:
				case INT32:
				case UINT8:
				case UINT16:
				case SERIAL4://自增4字节整数
				case INTEGER://整数类型
				case SHORT://整数类型
				case BYTE://整数类型
				case REAL://实数类型。
					dt = DataTypePool.INT32;
					break;
				case INT8:
				case SERIAL8://自增8字节整数
				case BIGINT://长整型，占用8个字节，存储范围-2^63到2^63-1
				case LONG://整数类型
					dt = DataTypePool.INT64;
					break;
				case FLOAT://单精度浮点数，4字节（32位）
				case FLOAT4://
				case HALF_FLOAT://浮点类型
				case SCALED_FLOAT://浮点类型
					dt = DataTypePool.FLOAT32;
					break;
				case FLOAT8://
				case DOUBLE://双精度浮点数，8字节（64位）
					dt = DataTypePool.FLOAT64;
					break;
				case DECIMAL://decimal(10,2)
				case SMALLMONEY://
				case NUMBER://Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数
				case GEO_POINT://地理类型 地理坐标类型
					dt = DataTypePool.DECIMAL256;
					break;
				case TOKEN_COUNT://令牌计数类型
				case KEYWORD://字符串类型
				case IP://特殊类型 IP类型
				case CHAR://0-255字节 定长字符串
				case STRING://字符串
				case VARCHAR://变长字符串 长度为1-65355
				case VARCHAR2://可变长度字符串 占4000个字节
				case NVARCHAR2://占2000个字符（最多能存2000个字母/中文
				case NVARCHAR://
				case OBJECT://对象类型
				case DOCUMENT://文档类型
				case NTEXT://
				case CLOB://字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
				case INTERVAL:
				case TINYBLOB://0-255字节	不超过 255 个字符的二进制字符串
				case TEXT://长文本数据
				case TINYTEXT: // 0-255字节 短文本字符串
				case BLOB: // 0-65 535字节 二进制形式的长文本数据
				case BINARY://二进制类型
				case MEDIUMBLOB: // 0-16 777 215字节 二进制形式的中等长度文本数据
				case MEDIUMTEXT: // 0-16 777 215字节 中等长度文本数据
				case LONGBLOB: // 0-4 294 967 295字节 二进制形式的极大文本数据
				case VARBINARY:
				case IMAGE:
				case LONGTEXT: // 0-4 294 967 295字节	极大文本数据
				case BINTEXT:
				case SHORTTEXT:
				case TIME://范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
					dt = DataTypePool.STRING_CLICKHOUSE;
					break;
				case DATE://2019-10-26
				case YEAR://范围YYYY    年份值
				case DATETIME:
				case DATETIME2:
				case DATETIMEOFFSET:
				case SMALLDATETIME:
					dt = DataTypePool.DATE_CLICKHOUSE;
					break;
				case TIMESTAMP://Integer/Floating/YYYY-MM-DD hh:mm:ss.fffffffff
					dt = DataTypePool.UINT64;
					break;
				default:
					dt = DataTypePool.STRING_CLICKHOUSE;
					break;
			}

			return dt.getDataType();
		}
		else{
			return null;
		}
	}

	/**
	 * 根据源字段类型，返回对应到source种类的数据类型
	 * @author liuqh
	 * @date: 2019年11月27日
	 * @param te 目标源
	 * @param sourceDataType
	 * 	注：在postgresql/greenPlum中，有些查询出来的类型会带有数字，如int4,
	 * @return
	 */
	public static String returnDataType(SourcesEnum te ,String sourceDataType){
		String dataType = null;
		if (te != null && StringUtils.isNotEmpty(sourceDataType)){
//			sourceDataType = com.bmsoft.dc.utils.StringUtils.reserveLetter(sourceDataType);

			switch (te){
				case mysql:
					dataType = toMysqlType(sourceDataType);
					break;
				case oracle:
				case dm:
					dataType = toOracleType(sourceDataType);
					break;
				case hive: case fi_hive:
					dataType = toHiveType(sourceDataType);
					break;
				case ES:
					dataType = toEsType(sourceDataType);
					break;
				case greenplum:
					dataType = toGreenPlumType(sourceDataType);
					break;
				case postgresql:
				case gaussdb:
				case kingbasees:
				case tbase:
					dataType = toPostgreSqlType(sourceDataType);
					break;
				case sqlserver:
					dataType = toSqlServerType(sourceDataType);
					break;
                case clickhouse:
                    dataType = toClickHouseType(sourceDataType);
                    break;
				case hana:
					dataType = toHanaType(sourceDataType);
					break;
				default:
					break;
			}
		}

		return dataType;
	}

	/**
	 * 获取某数据源下可做为业务/增量字段的数据类型集合(暂时整型/字符串型/时间类型)
	 * @author liuqh
	 * @date: 2020年4月27日
	 * @param se
	 * @return
	 */
	public static List<Map<String, String>> getBusinessColumns(SourcesEnum se) {
		List<DataTypeGroup> dgList = new ArrayList<>();
        dgList.add(DataTypeGroup.INT);
        dgList.add(DataTypeGroup.CHARACTER);
        dgList.add(DataTypeGroup.TIME);
        List<DataTypePool> poolList = DataTypePool.getBydataGroup(dgList, se);

        List<Map<String, String>> dataTypes = null;
        if (poolList != null && poolList.size() > 0){
        	dataTypes  = new ArrayList<>();
        	for (DataTypePool dp : poolList){
        		Map<String,String> map = new HashMap<String, String>();
        		map.put("label", dp.getDataType().toLowerCase());
        		map.put("value", dp.getDataType().toLowerCase());
        		map.put("dataGroup", dp.getDataGroup());

        		dataTypes.add(map);
        	}
        }

        return dataTypes;
	}
	/**
	 * 获取某数据源下时间类型集合
	 * @author liuqh
	 * @date: 2020年4月27日
	 * @param se
	 * @return
	 */
	public static List<Map<String, String>> getTimeColumns(SourcesEnum se) {
		List<DataTypeGroup> dgList = new ArrayList<>();
		dgList.add(DataTypeGroup.TIME);
		List<DataTypePool> poolList = DataTypePool.getBydataGroup(dgList, se);

		List<Map<String, String>> dataTypes = null;
		if (poolList != null && poolList.size() > 0){
			dataTypes  = new ArrayList<>();
			for (DataTypePool dp : poolList){
				Map<String,String> map = new HashMap<String, String>();
				map.put("label", dp.getDataType().toLowerCase());
				map.put("value", dp.getDataType().toLowerCase());
				map.put("dataGroup", dp.getDataGroup());

				dataTypes.add(map);
			}
		}
		return dataTypes;
	}

	/**
	 * 获取某数据源下可切分类型集合
	 * @author liuqh
	 * @date: 2020年4月27日
	 * @param se
	 * @return
	 */
	public static List<Map<String, String>> getSplitColumns(SourcesEnum se) {
		List<DataTypeGroup> dgList = new ArrayList<>();
		dgList.add(DataTypeGroup.INT);
		dgList.add(DataTypeGroup.CHARACTER);
		List<DataTypePool> poolList = DataTypePool.getBydataGroup(dgList, se);

		List<Map<String, String>> dataTypes = null;
		if (poolList != null && poolList.size() > 0){
			dataTypes  = new ArrayList<>();
			for (DataTypePool dp : poolList){
				Map<String,String> map = new HashMap<>();
				map.put("label", dp.getDataType().toLowerCase());
				map.put("value", dp.getDataType().toLowerCase());
				map.put("dataGroup", dp.getDataGroup());

				dataTypes.add(map);
			}
		}
		return dataTypes;
	}

	public static void main(String[] args) {
		String aa = returnDataType(SourcesEnum.oracle, "int8");
		System.out.println(aa);
	}
}
