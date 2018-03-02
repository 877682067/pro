package ${packag}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ${packag}.entity.${name?cap_first};
import java.util.List;
import org.springframework.stereotype.Service;

@Service("${name}Service")
public class ${name?cap_first}ServiceImpl implements ${name?cap_first}Service{
    <#assign mapper = name+"Mapper"/>
    @Autowired
    private ${name?cap_first}Mapper ${mapper};
    <#assign idType="Integer"/>
    <#list columns as info>
        <#if info.column =="id">
            <#assign idType=info.dataType/>
        </#if>
    </#list>
    @Override
    public ${name?cap_first} get${name?cap_first}ById(${idType} id){
        return ${mapper}.get${name?cap_first}ById(id);
    }

    @Override
    public List<${name?cap_first}> list(${name?cap_first} ${name}){
        return ${mapper}.list(${name});
    }

    @Override
    public int insert(${name?cap_first} ${name}){
        return ${mapper}.insert(${name});
    }

    public int update(${name?cap_first} ${name}){
        return ${mapper}.update(${name});
    }

}