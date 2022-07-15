package com.dunderdemo;

import com.dunderdb.DunderSession;
import com.dunderdb.exceptions.SerialMismatchException;
import com.dunderdb.exceptions.UnexpectedTypeException;
import com.dunderdemo.democlasses.Demo3;
import com.dunderdemo.democlasses.NoTable;
import com.dunderdemo.democlasses.SerialString;
import com.dunderdemo.democlasses.UnknownTypeSQL;
import com.dunderdemo.util.DunderUtil;

public class CreateTable
{
    public static void main( String[] args )
    {
        try(DunderSession ses = DunderUtil.getSession()) {
            ses.createTable(Demo3.class);
            
    // this class has no @Table annotation and will throw IllegalStateException
            // ses.createTable(NoTable.class); 

    // this class has a String marked with a 'serial' constraint and will throw a SerialMmismatchException
            // ses.createTable(SerialString.class); 

    // this class has a field marked by @Column that is of an unknown type and will throw an UnexpectedTypeException
            // ses.createTable(UnknownTypeSQL.class); 

        } catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch(SerialMismatchException e) {
            System.out.println(e.getMessage());
        } catch(UnexpectedTypeException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}