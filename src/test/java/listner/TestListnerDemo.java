package listner;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listner.TestNgListner.class)
public class TestListnerDemo {

    @Test
    public void test1(){
        System.out.println("I am inside test 1");
    }

    @Test
    public void test2(){
        System.out.println("I am inside test 2");
    }

    @Test
    public void test5(){
        System.out.println("I am inside test 5");
    }


    @Test
    public void test3(){
        Assert.assertTrue(false);
        System.out.println("I am inside test 3");
    }

    @Test
    public void test4(){
        System.out.println("I am inside test 4");
        throw new SkipException("skip");
    }


}


