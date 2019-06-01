package com.myspring.services;

import com.myspring.beans.DBBean;
import com.myspring.beans.DBBean;
import com.myspring.entities.Roles;
import com.myspring.entities.Users;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class UserService implements UserDetailsService {

    private DBBean dbBean;

    public DBBean getDbBean() {
        return dbBean;
    }

    public void setUserBean(DBBean dbBean) {
        this.dbBean = dbBean;
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users myUser = dbBean.getUser(s);
        Set<Roles> roles = myUser.getRoles();
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        for (Roles r : roles) {
            authorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        User securityUser = new User(myUser.getLogin(), myUser.getPassword(), authorities);
        return securityUser;
    }
}
