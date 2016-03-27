package cpuscheduler;
import java.util.*;

public class CPU{
	PCB pcb;
	private int cpu_timer = 0;
	private int cpuCount = 0; //making sure only one process in CPU
	private Queue<PCB> readyQ = new LinkedList<PCB>();	
	private Queue<PCB> blockedQ = new LinkedList<PCB>();
	public CPU(){
		while(cpuCount == 0 && !(readyQ.isEmpty())){
			pcb = readyQ.remove();
			cpuCount++;
		}	 		
	}
	public void in_CPU(){
		int currentBurst = pcb.getCurrentBurst();
		int cpuBurstNum = pcb.getCpuBursts();		
		if(currentBurst <= cpuBurstNum ){
			cpu_timer += currentBurst;
			blockedQ.add(pcb);
			cpuCount--;
		} else{
			//terminate the process
			cpuCount--;
		}
		//check if there is another cpu burst
		//if not terminate the process
		//else add to blocked Q
		//subtract cpu burst by one 
	}
}
