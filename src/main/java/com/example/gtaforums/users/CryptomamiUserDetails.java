package com.example.gtaforums.users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CryptomamiUserDetails extends User implements UserDetails {

    public CryptomamiUserDetails(Long id, String username, String password, String cryptoAddress, String profileaImg) {
        super(id, username, password, cryptoAddress , profileaImg);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
