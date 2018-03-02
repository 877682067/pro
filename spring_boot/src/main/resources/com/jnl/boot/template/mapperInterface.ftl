package ${packag}.entity;

import ${packag}.entity.${name?cap_first};
import java.util.List;

public interface ${name?cap_first}Mapper{

    <#assign idType="Integer"/>
    <#list columns as column>
        <#if column.oriName =="id">
            <#assign idType=column.dataType/>
        </#if>
    </#list>
    public ${name?cap_first} get${name?cap_first}ById(${idType} id);

    public List<${name?cap_first}> list(${name?cap_first} ${name});

    public int insert(${name?cap_first} ${name});

    public int update(${name?cap_first} ${name});

}