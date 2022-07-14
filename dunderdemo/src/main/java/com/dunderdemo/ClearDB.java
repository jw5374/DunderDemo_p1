package com.dunderdemo;

import com.dunderdb.DunderSession;
import com.dunderdemo.util.DunderUtil;

public class ClearDB {
    public static void main( String[] args )
    {
        try(DunderSession ses = DunderUtil.getSession()) {
            ses.removeTable("example");
            ses.removeTable("example2");
            ses.removeTable("example3");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
