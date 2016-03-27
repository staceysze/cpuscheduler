package cpuscheduler;

import java.util.*;

public class STScheduler {
	Queue<PCB> jobQ = new LinkedList<PCB>();
	Queue<PCB> readyQ = new LinkedList<PCB>();
	
	public STScheduler(){
		while(readyQ.size()<=10){	
			PCB new_pcb = jobQ.remove();
			System.out.println(new_pcb.getJid());
			readyQ.add(new_pcb);
			System.out.println("Current RQ JIDs: " +new_pcb.getJid());
			System.out.println("Current RQ Arrival Times: " +new_pcb.getArrivalTime());	
		}//checking if there are more jobs in jobQ
		

}

}
