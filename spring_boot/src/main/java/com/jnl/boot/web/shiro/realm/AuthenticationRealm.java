package com.jnl.boot.web.shiro.realm;

import com.jnl.boot.web.business.user.entity.User;
import com.jnl.boot.web.business.user.service.IUserService;
import com.jnl.boot.web.business.userAuth.entity.UserAuth;
import com.jnl.boot.web.business.userAuth.service.IUserAuthService;
import com.jnl.boot.web.exception.NotAuthenticationAccountException;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationRealm extends AuthenticatingRealm {
    @Autowired(required = false)
    private IUserAuthService userAuthService;
    @Autowired
    private IUserService userService;

    /**
     * Retrieves authentication data from an implementation-specific datasource (RDBMS, LDAP, etc) for the given
     * authentication token.
     * <p/>
     * For most datasources, this means just 'pulling' authentication data for an associated subject/user and nothing
     * more and letting Shiro do the rest.  But in some systems, this method could actually perform EIS specific
     * log-in logic in addition to just retrieving data - it is up to the Realm implementation.
     * <p/>
     * A {@code null} return value means that no account could be associated with the specified token.
     *
     * @param token the authentication token containing the user's principal and credentials.
     * @return an {@link AuthenticationInfo} object containing account data resulting from the
     * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
     * @throws AuthenticationException if there is an error acquiring data or performing
     *                                 realm-specific authentication logic for the specified <tt>token</tt>
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        String userName = (String)token.getPrincipal();
        UserAuth userAuth = this.userAuthService.getUserByLoginName(userName);
        User user = userService.getUserById(userAuth.getUserId());
        if(userAuth == null){
            throw new UnknownAccountException();
        }
        if(userAuth.getIsLock()){
            throw new LockedAccountException();
        }
        if(!userAuth.getIsAuth()){
            throw new NotAuthenticationAccountException();
        }
        return new SimpleAuthenticationInfo(userAuth.getLoginName(),user.getPassword(),ByteSource.Util.bytes(""),getName());
    }
}
