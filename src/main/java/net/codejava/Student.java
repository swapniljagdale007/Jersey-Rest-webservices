package net.codejava;

public class Student {
       private int studno;
       private String studname;
       private int dob;
       private int doj;
       
       public Student(int studno) {
    	   this.studno = studno;
    	   
      }
       public Student(int studno, String studname, int dob, int doj) {
    	   this.studno = studno;
    	   this.studname = studname;
    	   this.dob = dob;
    	   this.doj = doj;
       }
       
       @Override
       public int hashCode() {
    	   final int prime = 31;
    	   int result = 1;
    	   result = prime * result + studno;
		return result;
    	   
       }
       @Override
       public boolean equals(Object obj) {
    	   if (this == obj)
    		   return true;
    	   if (obj == null)
    		   return false;
    	   if(getClass() != obj.getClass())
    		   return false;
    	   Student other = (Student) obj;
    	   if (studno != other.studno)
    		   return false;
    	   return true;
    	   
    	   
    	   
       }
	public void setId(int newId) {
		// TODO Auto-generated method stub
		
	}
       
       
       
}
