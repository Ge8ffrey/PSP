package actividades;

class Imp implements Runnable {
	private String workerName;
	private int workingTime; //in seconds
	
	//Constructor accepting worker name and eating time
	public Imp (String workerName, int workingTime) {
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
		Imp worker1 = new Imp ("Ronald", 1);
		Imp worker2 = new Imp ("Adri", 12);
		Imp worker3 = new Imp ("Isma", 15);
		
		//Create and start threads
		Thread thread1 = new Thread(worker1);
		Thread thread2 = new Thread(worker2);
		Thread thread3 = new Thread(worker3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("All workers are operating machines");
	}
}
