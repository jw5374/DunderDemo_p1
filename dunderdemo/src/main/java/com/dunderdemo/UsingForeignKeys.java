package com.dunderdemo;

import com.dunderdb.DunderSession;
import com.dunderdemo.democlasses.Demo;
import com.dunderdemo.democlasses.Demo2;
import com.dunderdemo.util.DunderUtil;

public class UsingForeignKeys {
    public static void main( String[] args )
    {
        try(DunderSession ses = DunderUtil.getSession()) {
            Demo d1 = ses.get(Demo.class, 2);
            Demo2 de2 = new Demo2();
            de2.setDemo1id(d1.getId()); // this is the foreign key
            de2.setName("Somebody");
            de2.setId(32); // this is the primary key of 'example2' table
            System.out.println(de2);
            System.out.println("--------------");
            ses.save(de2);

            Demo2 gettingTheObjectBack = ses.get(Demo2.class, 32); // gets the object back from the table, confirming it was saved properly
            System.out.println(gettingTheObjectBack);

            // we can get the object from the first table, 'example', using the foreignkey of 'gettingTheObjectBack'
            Demo foreignD1 = ses.get(Demo.class, gettingTheObjectBack.getDemo1id());
            System.out.println(foreignD1);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
