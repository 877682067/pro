package ${packag}.service;

import ${packag}.entity.${name?cap_first};
import java.util.List;

public interface I${name?cap_first}Service{

    <#assign idType="Integer"/>
    <#list columns as info>
        <#if info.column =="id">
            <#assign idType=info.dataType/>
        </#if>
    </#list>
    public ${name?cap_first} get${name?cap_first}ById(${idType} id);

    public List<${name?cap_first}> list(${name?cap_first} ${name});

    public int insert(${name?cap_first} ${name});

    public int update(${name?cap_first} ${name});

}