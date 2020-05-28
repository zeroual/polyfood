package org.polytech.polyfood.buisness;

public class PasswordEncoderImpl implements PasswordEncoder {

    @Override
    public String encode(String password) {
        return password;
    }
}
