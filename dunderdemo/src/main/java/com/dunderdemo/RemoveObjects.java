package com.dunderdemo;

import java.util.List;

import com.dunderdb.DunderSession;
import com.dunderdemo.democlasses.Demo;
import com.dunderdemo.util.DunderUtil;

public class RemoveObjects {
    public static void main( String[] args )
    {
        try(DunderSession ses = DunderUtil.getSession()) {
            List<Demo> dList = ses.getAll(Demo.class);
            dList.stream().forEach(System.out::println);
            ses.remove(Demo.class, 1);
            System.out.println("-----------------");
            dList = ses.getAll(Demo.class);
            dList.stream().forEach(System.out::println);
            System.out.println(ses.get(Demo.class, 1)); // should be null
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
