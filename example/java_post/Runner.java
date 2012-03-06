import java.io.IOException;


public class Runner {
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < 100000; i++)
		{
			Thread t = new Thread() {
	              public void run() {
	                 Task task = new Task();
	                 try {
	                
	                	while(true){
	                		task.run();
	                	}
					} catch (Exception e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
	              }
	        };
	        t.start();
		}
	}
}
