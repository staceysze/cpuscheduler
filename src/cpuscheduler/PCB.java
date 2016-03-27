package cpuscheduler;

public class PCB {
	
	private static int jid = 0;
	private static int arrivalTime;
	private static int cpuBursts;
	private static int burstArr_Size = cpuBursts-1;
	private static int[] bursts;
	private static int currentBurst;
	private static String state;
	
	public PCB(){}
	public PCB(int j, int a, int n, int b[]){
		jid = j;
		arrivalTime = a;
		cpuBursts = n;
		for(int i=0; i<burstArr_Size;i++){
			bursts[i] = b[cpuBursts];
			currentBurst = i+1;
			state = "New";
		}		
	}	
	public void printPCB(){
		System.out.println("----------------------------------------");
		System.out.println("Job started..");
		System.out.println("Job ID: "+jid);
		System.out.println("Arrival Time: "+arrivalTime);
		System.out.println("Amount of CPU Bursts:" +cpuBursts);
		System.out.println("Job ended..");
		System.out.println("----------------------------------------");
	}
	public int getJid(){
		return jid;
	}
	public int getArrivalTime(){
		return arrivalTime;
	}
	public int getCpuBursts(){
		return cpuBursts;
	}
	public int getCurrentBurst(){
		return currentBurst;
	}	
	public String getState(){
		return state;
	}
	public void setCpuBursts(int remaining_burst){
		cpuBursts = remaining_burst;
	}
	public void setCurrentBurst(int new_burst){
		currentBurst = new_burst;
	}
	public void setState(String new_State){
		state = new_State;
	}
	
	
	

}
