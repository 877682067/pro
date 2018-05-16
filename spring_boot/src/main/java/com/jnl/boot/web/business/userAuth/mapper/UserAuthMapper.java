package com.jnl.boot.web.business.userAuth.mapper;

import com.jnl.boot.web.business.userAuth.entity.UserAuth;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAuthMapper{

    UserAuth getUserAuthById(Integer id);

    List<UserAuth> list(UserAuth userAuth);

    int insert(UserAuth userAuth);

    int insertList(@Param("list") List<UserAuth> userAuthList);

    int update(UserAuth userAuth);

}