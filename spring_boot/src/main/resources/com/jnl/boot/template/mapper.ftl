<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packag}.mapper.${name?cap_first}Mapper">
    <#assign mapperMap = name+"Map" />
    <#assign mappeType = packag+".entity."+name?cap_first/>
    <resultMap id="${mapperMap}" type="${packag}.entity.${name?cap_first}">
        <#list columns as column>
            <result property="${column.column}" column="${column.oriName}"/>
        </#list>
    </resultMap>
    <sql id="base_column_list" >
        <#assign listColumn =''/>
        <#assign updateEL =''/>
        <#list columns as column>
            <#assign listColumn = listColumn + column.oriName + ","/>
            <#assign updateEL = updateEL + "#\{item."+column.column+"},"/>
        </#list>
        ${listColumn?substring(0,listColumn?length-1)}
    </sql>
    <sql id="where_clause">
        where 1=1
        <trim  suffixOverrides="," >
        <#list columns as column>
            <if test="${column.column} != null and ${column.column} != ''" >
                and ${column.oriName} =   ${r'#{'}${column.column}}
            </if>
        </#list>
        </trim>
    </sql>
    <select id="list" parameterType="${mappeType}" resultMap="${mapperMap}">
        select
            *
        from
            ${baseName}
        <include refid="where_clause"></include>
    </select>
    <select id="get${name}ById" parameterType="Object" resultMap="${mapperMap}">
        select
            *
        from
            ${baseName}
        where
            id = ${r'#{id}'}
    </select>
    <insert id="insert" parameterType="Object">
        insert into ${baseName} (
        <trim  suffixOverrides="," >
        <#list columns as column>
            <if test="${column.column} != null and ${column.column} != ''" >
                ${column.oriName}
            </if>
        </#list>
        </trim>
        ) values (
        <trim  suffixOverrides="," >
        <#list columns as column>
            <if test="${column.column} != null and ${column.column} != ''" >
            ${r'#{'}${column.column}}
            </if>
        </#list>
        </trim>
        )
    </insert>
    <insert id="insertList" parameterType="Object">
        insert into ${baseName} (
            ${listColumn?substring(0,listColumn?length-1)}
        ) values
        <foreach collection="list" item="item" separator=",">
            ( ${updateEL?substring(0,updateEL?length-1)})
        </foreach>

    </insert>

    <update id="update" parameterType="Object">
        update
            ${baseName}
        set
        <trim  suffixOverrides="," >
        <#list columns as column>
            <if test="${column.column} != null and ${column.column} != ''" >
                and ${column.oriName} =  ${r'#{'}${column.column}}
            </if>
            <if test="${column.column} != null  ">
                ${column.oriName}=${r'#{'}${column.column}},
            </if>
        </#list>
        </trim>
        where id=${r'#{id}'}
    </update>
</mapper>