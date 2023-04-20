package org.jdragon.db.drivers;

import lombok.Getter;
import org.jdragon.db.drivers.api.DriverHelper;

import java.util.Map;
import java.util.Set;

/**
 * @author: benwei cai
 * @create: 2023-04-19 18:55
 */
public class TeradataHelper extends DriverHelper {

    private final String port;

    @Getter
    private SourcesEnum type = SourcesEnum.teradata;

    @Getter
    private final String driver = "com.teradata.jdbc.TeraDriver";

    @Getter
    private final String jdbc = "jdbc:teradata://%s/DATABASE=%s,DBS_PORT=%s";

    @Getter
    private final String separator = ",";

    public TeradataHelper(String host,String port, String database, String username, String password, Map<String, String> otherParameter) {
        super(host, database, username, password, otherParameter);
        this.port = port;
    }

    @Override
    public String joinJdbcUrl(String host, String database, Map<String, String> otherParameter) {
        String result = String.format(getJdbc(), host, database,port);
        if (otherParameter != null && otherParameter.size() > 0) {
            Set<String> keys = otherParameter.keySet();
            StringBuilder str = new StringBuilder();
            for (String key : keys) {
                str.append(String.format("%s=%s%s", key, otherParameter.get(key), getSeparator()));
            }
            str.deleteCharAt(str.length() - 1);
            result += getExtraParameterStart() + str;
        }
        return result;
    }

    @Override
    public String getFullTypeCreateSql() {
        return "CREATE MULTISET TABLE full_type ,NO FALLBACK (" +
                "      Column1 BYTE(4),\n" +
                "      Column2 BLOB,\n" +
                "      Column3 VARCHAR(100) CHARACTER SET LATIN NOT CASESPECIFIC,\n" +
                "      Column4 CHAR(20) CHARACTER SET LATIN NOT CASESPECIFIC,\n" +
                "      Column5 CLOB CHARACTER SET LATIN,\n" +
                "      Column6 VARBYTE(100),\n" +
                "      Column7 DECIMAL(5,0),\n" +
                "      Column8 DATE FORMAT 'YY/MM/DD',\n" +
                "      Column9 FLOAT,\n" +
                "      Column10 INTEGER,\n" +
                "      Column11 BYTEINT,\n" +
                "      Column12 SMALLINT,\n" +
                "      Column13 BIGINT,\n" +
                "      Column14 TIMESTAMP(6),\n" +
                "      Column15 NUMBER,\n" +
                "      Column16 TIME(6))\n" +
                "PRIMARY INDEX ( Column10 );";
    }
}
