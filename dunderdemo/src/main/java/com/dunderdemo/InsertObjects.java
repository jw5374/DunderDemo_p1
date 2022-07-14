package com.dunderdemo;

import com.dunderdb.DunderSession;
import com.dunderdemo.democlasses.Demo;
import com.dunderdemo.util.DunderUtil;

public class InsertObjects {
    public static void main( String[] args )
    {
        try(DunderSession ses = DunderUtil.getSession()) {
            Demo d1 = new Demo("John Smith", "email@email.com", 123.45, false);
            Demo d2 = new Demo("John Stanley", "email2@email.com", 234.56, true);
            Demo d3 = new Demo("John Cameron", "email3@email.com", 345.67, false);
            // Demo d4 = new Demo("John Cameron", "email4@email.com", 456.78, true);
            ses.save(d1);
            ses.save(d2);
            ses.save(d3);
            // ses.save(d4); // should throw sqlexception
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
