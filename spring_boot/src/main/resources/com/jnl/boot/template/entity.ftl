package ${packag}.entity;

import java.util.Date;

public class ${name?cap_first}{
    <#list columns as column>

    private ${column.dataType} ${column.column};//${column.columnComment}
    </#list>

    <#list columns as column>
    public void set${column.column?cap_first}(${column.dataType}  ${column.column}){
        this.${column.column} = ${column.column};
    }
    public ${column.dataType} get${column.column?cap_first}(){
        return ${column.column};
    }
    </#list>
}