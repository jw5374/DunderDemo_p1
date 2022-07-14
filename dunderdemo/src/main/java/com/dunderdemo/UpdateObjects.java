package com.dunderdemo;

import com.dunderdb.DunderSession;
import com.dunderdemo.democlasses.Demo;
import com.dunderdemo.util.DunderUtil;

public class UpdateObjects {
    public static void main( String[] args )
    {
        try(DunderSession ses = DunderUtil.getSession()) {
            Demo d1 = ses.get(Demo.class, 1);
            Demo d2 = ses.get(Demo.class, 2);
            System.out.println(d1);
            System.out.println(d2);
            d1.setBalance(4328.42);
            d2.setEmail("emailNEW@email.com");
            ses.update(d1);
            ses.update(d2);
            System.out.println("---------------------");
            System.out.println(ses.get(Demo.class, 1));
            System.out.println(ses.get(Demo.class, 2));

            // Demo d3 = new Demo("Random Guy", "notanemail@email.com", 0.0);
            // ses.update(d3); // nothing will happen as there is no id found
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
