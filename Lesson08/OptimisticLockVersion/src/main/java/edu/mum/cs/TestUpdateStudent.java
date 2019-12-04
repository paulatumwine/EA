package edu.mum.cs;

public class TestUpdateStudent {
    public static void main(String arg[]) {

        Student sa = new Student();
        sa.setId(1);
        sa.setName("Edward Hilton");
        sa.setEmail("ehilton@mum.edu");
        sa.setPhone("6414512222");
        sa.setDegree("bca");

       Student sas = new Student();
        sas.setId(1);
        sas.setName("Tina Xing");
        sas.setEmail("rxing@mum.edu");
        sas.setPhone("6414513333");
        sas.setDegree("Mca");

        StudentDao ms = new StudentDao();
        ms.setStudent(sa);

        StudentDao mss = new StudentDao();
        mss.setStudent(sas);

        ms.start();
        mss.start();


    }
/*
 * Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect): [edu.mum.cs.Student#1]
updation failed

 */
}
