package com.dunderdemo;

import com.dunderdb.DunderSession;
import com.dunderdb.DunderTx;
import com.dunderdb.exceptions.TransactionNotCommittedException;
import com.dunderdemo.democlasses.Demo;
import com.dunderdemo.util.DunderUtil;

public class TransactionAction {
    public static void main( String[] args )
    {
        try(DunderSession ses = DunderUtil.getSession()) {
            System.out.println("--------Baseline-------");
            Demo d1 = ses.get(Demo.class, 2);
            Demo d2 = ses.get(Demo.class, 3);
            Demo d3 = new Demo("Firstname Lastname", "Gmail@email.com", 321.09);
            d1.setBalance(9001.01);
            d2.setEmail("SOMETHING@email.com");
            ses.getAll(Demo.class).stream().forEach(System.out::println);
            System.out.println("--------Rollback Update-------");

            /*******************************************************************/

            DunderTx tx = ses.beginTransaction();
            // tx = ses.beginTransaction(); // would throw TransactionNotCommittedException
            tx.savePoint("a");
            ses.update(d1);
            tx.rollback("a");
            tx.commit();
            ses.getAll(Demo.class).stream().forEach(System.out::println); // should have no change

            // /*******************************************************************/

            // System.out.println("--------Second Update Goes Through-------");
            
            // /*******************************************************************/

            tx = ses.beginTransaction(); // should throw nothing because committed
            tx.savePoint("a");
            ses.update(d1);
            tx.rollback("a");
            tx.releaseSavepoint("a");
            ses.update(d2);
            tx.rollback("a"); // will cause error if 'a' is released, as you cannot rollback to destroyed savepoint
            tx.commit();
            // ses.getAll(Demo.class).stream().forEach(System.out::println);

            // /*******************************************************************/
            
            // System.out.println("--------Plain Transaction with save and update-------");

            //     // regular commit
            // tx = ses.beginTransaction();
            // ses.save(d3);
            // ses.update(d1);
            // tx.commit();
            // ses.getAll(Demo.class).stream().forEach(System.out::println);

        } catch(TransactionNotCommittedException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
