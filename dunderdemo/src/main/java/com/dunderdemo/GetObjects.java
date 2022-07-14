package com.dunderdemo;

import java.util.List;

import com.dunderdb.DunderSession;
import com.dunderdemo.democlasses.Demo;
import com.dunderdemo.democlasses.NoTable;
import com.dunderdemo.democlasses.SerialString;
import com.dunderdemo.util.DunderUtil;

public class GetObjects {
    public static void main( String[] args )
    {
        try(DunderSession ses = DunderUtil.getSession()) {
            Demo d1 = ses.get(Demo.class, 1);
            Demo d2 = ses.get(Demo.class, 2);
            System.out.println(d1);
            System.out.println(d2);
            System.out.println("------------------");
            List<Demo> dList = ses.getAll(Demo.class);
            dList.stream().forEach(System.out::println);


                // will throw nullpointer as there is no table annotation
            // List<NoTable> nullList = ses.getAll(NoTable.class);

                // will throw SQLException as no table exists
            // List<SerialString> nullList2 = ses.getAll(SerialString.class);
            // System.out.println(nullList2); // should be null
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
