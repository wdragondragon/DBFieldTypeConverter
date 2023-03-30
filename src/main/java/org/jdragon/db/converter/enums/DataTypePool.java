package org.jdragon.db.converter.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqh
 * @date: 2020年4月27日
 */
public enum DataTypePool {

    /**
     * 整型数据类型   start
     */
    TINYINT("tinyint", "int"),//微整型，只占用1个字节，只能存储0-255的整数
    SMALLINT("smallint", "int"),//小整型，占用2个字节，存储范围–32768 到 32767
    INT("int", "int"),// 整型，占用4个字节，存储范围-2147483648到2147483647
    INT2("int2", "int"),//(对应smallint)
    INT4("int4", "int"),//int4（对应integer）
    INT8("Int8", "int"),//int8（对应bigint）
    INT16("Int16", "int"),//int8（SMALLINT, INT2）
    INT32("Int32", "int"),//Int32(INT, INT4, INTEGER)
    INT64("Int64", "int"),//Int64(BIGINT)
    INT128("Int128", "int"),//Int128()
    INT256("Int256", "int"),//Int256()

    UINT8("UInt8", "int"),
    UINT16("UInt16", "int"),
    UINT32("UInt32", "int"),
    UINT64("UInt64", "int"),
    UINT128("UInt128", "int"),
    UINT256("UInt256", "int"),

    BIGINT("bigint", "int"),//长整型，占用8个字节，存储范围-2^63到2^63-1
    INTEGER("integer", "int"),//整数类型
    LONG("long", "int"),//整数类型
    SHORT("short", "int"),//整数类型
    BYTE("byte", "int"),//整数类型
    MEDIUMINT("mediumint", "int"),//范围为(-8 388 608，8 388 607)  (0，16 777 215)  大整数值
    REAL("real", "int"),//实数类型。
    NUMERIC("numeric", "int"),//用户声明精度，变长，无限制
    SERIAL("serial", "int"),//4字节，自增整数（1 - 2147483647）
    SERIAL4("serial4", "int"),//serial4(对应serial)
    SERIAL8("serial8", "int"),//serial8（对应bigserial）
    BIGSERIAL("bigserial", "int"),//8字节，大范围自增整数（1 - ）
    NUMBER("number", "int"),//Number（p,s）包含小数位的数值类型。P表示精度，s表示小数后的位数,暂时将它归为int分组


/** 整型类型   end */

    /**
     * 小数类型   start
     */
    FLOAT("float", "decimal"),//单精度浮点数，4字节（32位）
    FLOAT4("float4", "decimal"),//float4(对应real）单精度浮点数字
    FLOAT8("float8", "decimal"),//float8(对应double precision）双精度浮点数字
    FLOAT32("Float32", "decimal"),//float
    FLOAT64("Float64", "decimal"),//double
    DOUBLE("double", "decimal"),//双精度浮点数，8字节（64位）
    DECIMAL("decimal", "decimal"),//decimal(10,2)

    HALF_FLOAT("half_float", "decimal"),//浮点类型
    SCALED_FLOAT("scaled_float", "decimal"),//浮点类型
    GEO_POINT("geo_point", "decimal"),//地理类型 地理坐标类型
    MONEY("money", "decimal"),//货币金额  （pg中）
    SMALLMONEY("smallmoney", "decimal"),//请参考  sqlserver 数据类型

    DECIMAL_CLICKHOUSE("Decimal", "decimal"),//decimal(10,2)
    DECIMAL32("Decimal32", "decimal"),//
    DECIMAL64("Decimal64", "decimal"),//
    DECIMAL128_1("Decimal128", "decimal"),//
    DECIMAL256("Decimal256", "decimal"),//
/** 小数类型   end */

    /**
     * 字符类型   start
     */
    STRING("string", "character"),//字符串
    STRING_CLICKHOUSE("String", "character"),//字符串
    VARCHAR("varchar", "character"),//变长字符串 长度为1-65355
    CHAR("char", "character"),//0-255字节 定长字符串
    BPCHAR("char", "character"),//0-255字节 定长字符串
    KEYWORD("keyword", "character"),//字符串类型
    VARCHAR2("varchar2", "character"),//可变长度字符串 占4000个字节
    NCHAR("nchar", "character"), //根据字符集而定的固定长度字符串 最大长度2000 bytes
    NVARCHAR2("nvarchar2", "character"),//占2000个字符（最多能存2000个字母/中文
    NVARCHAR("nvarchar", "character"),//请参考  sqlserver 数据类型
    OBJECTID("ObjectId", "character"), // mongodb默认主键
    SYMBOL("Symbol", "character"), // mongodb字段类型
    CODEWITHSCOPE("CodeWithScope", "character"), // mongodb字段类型
    DECIMAL128("Decimal128", "character"), // mongodb字段类型
    MAXKEY("MaxKey", "character"), // mongodb字段类型
    MINKEY("MinKey", "character"), // mongodb字段类型
    BSONREGULAREXPRESSION("BSONRegexp", "character"), // mongodb字段类型
    DOCUMENT("Document", "text"), // mongodb文档类型

    FIXEDSTRING("FixedString", "character"),
/** 字符类型   end */

    /**
     * 位类型   start
     */
    BIT("bit", "bit"),//定长位串		（pg中）
    VARBIT("varbit", "bit"),//变长位串	（pg中）
/** 位类型   end */

    /**
     * 文本类型   start
     */
    TEXT("text", "text"),//字符串类型
    NTEXT("ntext", "text"),//请参考  sqlserver 数据类型
    TINYBLOB("tinyblob", "text"),//0-255字节	不超过 255 个字符的二进制字符串
    TINYTEXT("tinytext", "text"), // 0-255字节 短文本字符串
    MEDIUMBLOB("mediumblob", "text"), // 0-16 777 215字节 二进制形式的中等长度文本数据
    MEDIUMTEXT("mediumtext", "text"), // 0-16 777 215字节 中等长度文本数据
    LONGBLOB("longblob", "text"), // 0-4 294 967 295字节 二进制形式的极大文本数据
    LONGTEXT("longtext", "text"), // 0-4 294 967 295字节	极大文本数据
    BINARY("binary", "text"),//二进制类型
    VARBINARY("varbinary", "text"),//请参考  sqlserver 数据类型
    OBJECT("object", "text"),//对象类型
    BLOB("blob", "text"), // 0-65 535字节 二进制形式的长文本数据
    CLOB("clob", "text"),//字符数据 最大长度4G,数据库中无论用varchar2或nvarchar2类型，还是用clob，在java端都使用String接收
    RAW("raw", "text"),//固定长度的二进制数据 最大长度2000 bytes 可存放多媒体图象声音等(oracle)
    BYTEA("bytea", "text"),//二进制数据（"字节数组"） （pg中）
    BINTEXT("bintext","text"),// hana 数据类型
    SHORTTEXT("shorttext","test"), // hana数据类型
/** 文本类型   end */

    /**
     * date类型   start
     */
    DATE("date", "time"),//2019-10-26
    TIMESTAMP("timestamp", "time"),//Integer/Floating/YYYY-MM-DD hh:mm:ss.fffffffff
    TIME("time", "time"),//范围为'-838:59:59'/'838:59:59'，格式为  HH:MM:SS    时间值或持续时间
    YEAR("year", "time"),//范围YYYY    年份值
    DATETIME("datetime", "time"),
    DATETIME2("datetime2", "time"),  //请参考  sqlserver 数据类型
    SMALLDATETIME("smalldatetime", "time"),  //请参考  sqlserver 数据类型
    DATETIMEOFFSET("datetimeoffset", "time"),  //请参考  sqlserver 数据类型
    TIMETZ("timetz", "time"),//一天里的时间，包括时区  (pg中)
    TIMESTAMPTZ("timestamptz", "time"),//日期和时间  （pg中）
    INTERVAL("interval", "time"),//时间间隔  （pg中）

    DATE_CLICKHOUSE("Date", "time"),//2019-10-26
    Date32("Date32", "time"),//[1925-01-01, 2283-11-11]

/** date类型   end */

    /**
     * 平面图类型   start
     */
    BOX("box", "graph"),//平面中的长方形  	（pg中）
    CIRCLE("circle", "graph"),//平面中的圆		（pg中）
    LINE("line", "graph"),//平面中的无限长直线		（pg中）
    LSEG("lseg", "graph"),//平面中的线段		（pg中）
    PATH("path", "graph"),//平面中的几何路径		（pg中）
    POINT("point", "graph"),//平面中的点		（pg中）
    POLYGON("polygon", "graph"),//平面中的封闭几何路径		（pg中）
/** 平面图类型   end */

    /**
     * ip类型   start
     */
    IP("ip", "ip"),//特殊类型 IP类型
    IPV4("ipv4", "ip"),//特殊类型 IP类型
    IPV6("ipv6", "ip"),//特殊类型 IP类型
    CIDR("cidr", "ip"),//IPv4 或者 IPv6 网络地址  	（pg中）
    INET("inet", "ip"),//IPv4 或者 IPv6 网络地址	（pg中）
    MACADDR("macaddr", "ip"),//MAC 地址			（pg中）
/** ip类型   end */

    /**
     * 布尔类型   start
     */
    BOOLEAN("boolean", "bool"),//true/false
    BOOL("bool", "bool"),//逻辑布尔量 （真/假） pg中	（pg中）
    BOOL_CLICKHOUSE("Bool", "bool"),//逻辑布尔量 （真/假） pg中	（pg中）
    /**
     * 布尔类型   end
     */

    TSQUERY("tsquery", "other"), //全文检索查询  		（pg中）

    TSVECTOR("tsvector", "other"), //全文检索文档	（pg中）

    TXID_SNAPSHOT("txid_snapshot", "other"), //用户级别事务ID快照	（pg中）

    UUID("uuid", "other"), //通用唯一标识符	（pg中）

    XML("xml", "other"), //XML数据	（pg中）

    ARRAY("array", "other"),//数组，ARRAY(data_type)
//	
//	MAP,//MAP <primitive_type, data_type >
//	
//	struct,
//	
//	union,

    RANGE("range", "other"),//范围类型

    COMPLETION("completion", "other"),//范围类型

    NESTED("nested", "other"),//嵌套类型

    GEO_SHAPE("geo_shape", "other"),//地理地图

    TOKEN_COUNT("token_count", "other"),//令牌计数类型

    ATTACHMENT("attachment", "other"),//附件类型

    PERCOLATOR("percolator", "other"),//抽取类型

    IMAGE("image", "other")    //请参考  sqlserver 数据类型

    ;

    private String dataType;//数据类型

    private String dataGroup;//数据分组

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataGroup() {
        return dataGroup;
    }

    public void setDataGroup(String dataGroup) {
        this.dataGroup = dataGroup;
    }

    /**
     * @param dataType
     * @param dataGroup
     */
    private DataTypePool(String dataType, String dataGroup) {
        this.dataType = dataType;
        this.dataGroup = dataGroup;
    }

    /**
     * 根据数据类型获取类型的分组
     *
     * @param dataType
     * @return
     * @author liuqh
     * @date: 2020年4月27日
     */
    public static DataTypePool getByDataType(String dataType) {
        for (DataTypePool dt : values()) {
            if (dt.getDataType().equalsIgnoreCase(dataType)) {
                return dt;
            }
        }
        return null;
    }

    public static Boolean isDecimalGroup(String dataType) {
        for (DataTypePool dataTypePool : values()) {
            if (dataTypePool.getDataType().equals(dataType)) {
                return dataTypePool.getDataGroup().equals("decimal");
            }
        }
        return false;
    }

    public static List<String> getDataTypeBySource(SourcesEnum se) {
        List<String> names = new ArrayList<>();
        switch (se) {
            case ftp:
            case mft:
                names = FtpDataType.getNames();
                break;
            case mysql:
                names = MysqlDataType.getNames();
                break;
            case oracle:
                names = OracleDataType.getNames();
                break;
            case hive:
            case fi_hive:
                names = HiveDataType.getNames();
                break;
            case postgresql:
            case gaussdb:
            case tbase:
            case kingbasees:
                names = PostgreSqlDataType.getNames();
                break;
            case greenplum:
                names = GreenPlumDataType.getNames();
                break;
            case ES:
                names = EsDataType.getNames();
                break;
            case clickhouse:
                names = ClickhouseDataType.getNames();
                break;
            case sqlserver:
                names = SqlServerDataType.getNames();
                break;
            default:
                break;
        }
        return names;
    }

    /**
     * 根据分组获取对应分组下的数据类型
     *
     * @param DtList 分组枚举集合
     * @param se     数据源种类
     * @return
     * @author liuqh
     * @date: 2020年4月27日
     */
    public static List<DataTypePool> getBydataGroup(List<DataTypeGroup> DtList, SourcesEnum se) {
        if (DtList != null && DtList.size() > 0) {
            List<DataTypePool> poolList = new ArrayList<DataTypePool>();
            for (DataTypeGroup dg : DtList) {
                for (DataTypePool dt : values()) {
                    if (dg.name().equalsIgnoreCase(dt.getDataGroup())) {
                        poolList.add(dt);
                    }
                }
            }

            //判断分组得到的数据类型中，哪些是属于se的类型
            if (se != null) {
                List<String> names = getDataTypeBySource(se);
                //去掉对应数据库中不存在的DataTypePool
                if (names != null && names.size() > 0) {
                    List<DataTypePool> dpList = new ArrayList<>();
                    for (DataTypePool pl : poolList) {
                        if (names.contains(pl.getDataType().toLowerCase())) {
                            dpList.add(pl);
                        }
                    }

                    return dpList;
                } else {
                    return poolList;
                }
            } else {
                return poolList;
            }
        }

        return null;
    }
}
