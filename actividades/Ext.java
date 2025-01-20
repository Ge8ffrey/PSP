package actividades;

public class Ext extends Thread {
	private String workerName;
	private int workingTime; //in seconds
	
	//Constructor accepting worker name and eating time
	public Ext (String workerName, int workingTime) {
		this.workerName = workerName;
		this.workingTime = workingTime;
	}
	@Override
	public void run() {
		System.out.println(workerName + " started working.");
		try {
			//Simulate eating time
			Thread.sleep(workingTime * 1000L); // Convert seconds to miliseconds
		} catch (InterruptedException e) {
			System.out.println(workerName + " was interrupted while working.");
			Thread.currentThread().interrupt();
		}
		System.out.println(workerName + " finished working.");
	}
	
	public static void main(String[] args) {
		Ext worker1 = new Ext ("Ronald", 1);
		Ext worker2 = new Ext ("Adri", 12);
		Ext worker3 = new Ext ("Isma", 15);
		
		worker1.start();
		worker2.start();
		worker3.start();
		
		System.out.println("All workers are operating machines");
	}
}
