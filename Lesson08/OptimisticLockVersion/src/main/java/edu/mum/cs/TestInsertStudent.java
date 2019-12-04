package edu.mum.cs;

public class TestInsertStudent {
	public static void main(String arg[]) {
		try {
			StudentDao m = new StudentDao();

			Student s = new Student();
			s.setName("John Brown");
			s.setDegree("mca");
			s.setEmail("jbrown@mum.edu");
			s.setPhone("6414511111");
			m.insert(s);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
