package ${packag}.entity;

import ${packag}.entity.${name?cap_first};
import java.util.List;
import org.apache.ibatis.annotations.Param;

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

    public int insertList(@Param("list")List<${name?cap_first}> ${name}List);

    public int update(${name?cap_first} ${name});

}