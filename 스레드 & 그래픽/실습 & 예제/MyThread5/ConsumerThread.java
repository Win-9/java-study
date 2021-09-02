package thread.example;

public class ConsumerThread extends Thread{
	
	private MyLabel bar;
	
	public ConsumerThread(MyLabel bar) {
		// TODO Auto-generated constructor stub
		this.bar=bar;
	}
	
	public void run() {
		while(true) {
			try {
				sleep(200);
				bar.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
