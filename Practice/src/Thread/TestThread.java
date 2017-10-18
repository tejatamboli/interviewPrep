package Thread;

public class TestThread {

	   public static void main(String args[]) {
	      basicRun T1 = new basicRun( "Thread-1");
	      T1.start();
	      
	      basicRun T2 = new basicRun( "Thread-2");
	      T2.start();
	   }   
	}