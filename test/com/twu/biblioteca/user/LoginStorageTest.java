package com.twu.biblioteca.user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginStorageTest {
    private LoginStorage loginStorage;

    @Before
    public void init(){
        loginStorage = new LoginStorage();
    }

    @Test
    public void shouldReturnTrueWhenUserInfoIsCorrect(){
        boolean loginStatus = loginStorage.exists("123-1234", "123456");
        assertEquals(true, loginStatus);
    }

    @Test
    public void shouldReturnFalseWhenUserLibraryNumberIsWrong(){
        boolean loginStatus = loginStorage.exists("123-", "123456");
        assertEquals(false, loginStatus);
    }

    @Test
    public void shouldReturnFalseWhenUserPasswordIsWrong(){
        boolean loginStatus = loginStorage.exists("123-1234", "12345678");
        assertEquals(false, loginStatus);
    }
}
