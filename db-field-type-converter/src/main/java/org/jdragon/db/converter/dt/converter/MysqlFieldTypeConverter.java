package org.jdragon.db.converter.dt.converter;

import org.jdragon.db.converter.dt.enums.DataTypeEnumInterface;
import org.jdragon.db.converter.dt.enums.DataTypeGroup;

public class MysqlFieldTypeConverter implements FieldTypeConverter {
    @Override
    public DataTypeEnumInterface convert(DataTypeEnumInterface dataTypeEnumInterface) {
        DataTypeGroup group = dataTypeEnumInterface.getGroup();
        Integer maxLength = dataTypeEnumInterface.getMaxLength();
        Integer maxPrecision = dataTypeEnumInterface.getMaxPrecision();

        switch (group) {
            case STRING:
                break;
            case DATE:
                break;
            case TIME:
                break;
            case NUMBER:
                break;
            case BOOLEAN:
                break;
            case BINARY:
                break;
            case BLOB:
                break;
            case CLOB:
                break;
            case TEXT:
                break;
            case OTHER:
                break;
            default:
                break;
        }

        return null;
    }
}
