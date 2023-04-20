package org.jdragon.db.converter.enums;

import lombok.Getter;

public enum SourcesEnum {
    dafault(0),//0

    mysql(1),//1

    oracle(2),//2

    sqlserver(3),//3

    postgresql(4),//4

    hive(5),//5

    kafka(6),//6

    ftp(7),//7

    http(8),//8

    ES(9, "elasticsearch"),//9

    mongoDB(10),//10

    hdfs(11),//11

    hbase(12),//12

    greenplum(13),//13

    tbase(14),//14

    dm(15),//15

    clickhouse(16),//16

    minio(17),//17

    neo4j(18),//18

    kingbasees(19),//19

    db2(20),//20

    redis(21),//21

    gaussdb(22),//22

    fi_hive(23),

    hana(24),
    fi_hetu(25),

    mft(26),

    fi_sparksql(27),

    teradata(28),

    gbase8a(29)
            ;

    @Getter
    private final int code;

    @Getter
    private final String alias;

    SourcesEnum(int code) {
        this.code = code;
        this.alias = name();
    }


    SourcesEnum(int code, String alias) {
        this.code = code;
        this.alias = alias;
    }
}
