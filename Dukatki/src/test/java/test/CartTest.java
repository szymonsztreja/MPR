package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartTest extends BaseTest{

    @Override
    @Before
    public void loginToShop() {
        super.loginToShop();
    }

    @Test
    public void cartTest(){

    }


    @Override
    @After
    public void logoutFromShop() {
        super.logoutFromShop();
    }
}
