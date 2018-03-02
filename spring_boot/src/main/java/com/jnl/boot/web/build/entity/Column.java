package com.jnl.boot.web.build.entity;

public class Column {

    private String catalog;//表限定符。

    private String  schema;//表所有者。

    private String tableName;//表名

    private String column;//字段名字

    private String oriName;//字段原始名字

    private String position;//列标识号

    private String defaultVal;//列的默认值

    private String isNull;//字段是否可为空

    private String dataType;//数据类型。

    private Long maxLength;//以字符为单位的最大长度，适于二进制数据、字符数据，或者文本和图像数据。否则，返回 NULL

    private Long octetLength;//以字节为单位的最大长度，适于二进制数据、字符数据，或者文本和图像数据。否则，返回 NULL。

    private Long numericPrecision;//近似数字数据、精确数字数据、整型数据或货币数据的精度。否则，返回 NULL

    private Long scale;//近似数字数据、精确数字数据、整数数据或货币数据的小数位数。否则，返回 NULL。

    private Long datetimePrecision;//datetime 及 SQL-92interval 数据类型的子类型代码。对于其它数据类型，返回 NULL

    private String setName;//如果列是字符数据或 text 数据类型，那么为排序次序返回唯一的名称。否则，返回 NULL。

    private String collationName;//如果列是字符数据或 text 数据类型，那么为排序次序返回唯一的名称。否则，返回 NULL。

    private String columnType;//

    private String columnKey;//

    private String extra;//

    private String privileges;//权限 select  insert update

    private String columnComment;//备注



    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Long getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    public Long getOctetLength() {
        return octetLength;
    }

    public void setOctetLength(Long octetLength) {
        this.octetLength = octetLength;
    }

    public Long getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(Long numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public Long getScale() {
        return scale;
    }

    public void setScale(Long scale) {
        this.scale = scale;
    }

    public Long getDatetimePrecision() {
        return datetimePrecision;
    }

    public void setDatetimePrecision(Long datetimePrecision) {
        this.datetimePrecision = datetimePrecision;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getOriName() {
        return oriName;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName;
    }
}
