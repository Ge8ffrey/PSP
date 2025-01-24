package actividades;

public class Threads implements Runnable {
	private String workerName;
	private int workingTime; //in seconds
	
	//Constructor accepting worker name and eating time
	public Threads(String workerName, int workingTime) {
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
		//Create Runnable instances for workers
		Imp worker1 = new Imp ("Ronald", 5);
		int contador = 0;
		
		for (int i=0; i<99; i++) {
			Thread thread1 = new Thread(worker1);
			thread1.start();
			contador ++;
			System.out.println(worker1 + " is operating machines");
			System.out.println("Thread número: " + contador);
	}
	}
}

