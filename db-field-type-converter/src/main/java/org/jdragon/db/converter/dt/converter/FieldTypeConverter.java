package org.jdragon.db.converter.dt.converter;

import org.jdragon.db.converter.dt.enums.DataTypeEnumInterface;

public interface FieldTypeConverter {
    DataTypeEnumInterface convert(DataTypeEnumInterface dataTypeEnumInterface);
}
