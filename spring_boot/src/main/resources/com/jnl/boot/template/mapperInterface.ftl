package #{url}.entity;


public class #{tableName?cap_first}{
    <#list columns as column>

    private #{column.type} #{column.name};//#{column.columnComment}
    </#list>

    <#list columns as column>
    public void set#{column.name?cap_first}(#{column.type}  #{column.name}){
        this.#{column.name} = #{column.name}
    }
    public #{column.type} get#{column.name?cap_first}(){
        return #{column.name};
    }
    </#list>
}