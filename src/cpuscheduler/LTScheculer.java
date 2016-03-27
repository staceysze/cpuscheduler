package cpuscheduler;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LTScheculer {
	
	public static void main(String[] args) throws IOException {
		int global_timer = 0;
		Queue<PCB> jobQ = new LinkedList<PCB>();
		Queue<PCB> readyQ = new LinkedList<PCB>();
		int jid, ioTime, processingTime = 0;
		int cpuTime = 0;
		int arrTime;
		int cpuBursts;
		int[] bursts; 		
		PCB pcb;
		Scanner jobInput = new Scanner(new File("JobQueue.txt"));
		while(jobInput.hasNextLine()){
			String line = jobInput.nextLine();
			Scanner jobs = new Scanner(line);
			while(jobs.hasNext()){
				jid = jobs.nextInt();				
				arrTime = jobs.nextInt();				
				cpuBursts = jobs.nextInt();
				bursts = new int[cpuBursts];
				for(int i=0; i<cpuBursts;i++){
					int b = jobs.nextInt();
					cpuTime+=b;
					bursts[i] = b;
				}
				ioTime = (cpuBursts-1)*10;
				processingTime = cpuTime + ioTime;	
				
				//System.out.println("Time spent in CPU: "+cpuTime);
				//System.out.println("Processing time: "+processingTime);
				pcb = new PCB(jid,arrTime,cpuBursts,bursts);
				jobQ.add(pcb);
				pcb.printPCB();
				
			}//testing hasNext 			
			jobs.close();
		}//testing hasNextLine
		jobInput.close();

	
			while(readyQ.size()<=10){	
				PCB new_pcb = jobQ.remove();
				System.out.println(new_pcb.getJid());
				readyQ.add(new_pcb);
				System.out.println("Current RQ JIDs: " +new_pcb.getJid());
				System.out.println("Current RQ Arrival Times: " +new_pcb.getArrivalTime());	
			}//checking if there are more jobs in jobQ
			

	

	}//main ended
	


}//LTScheduler class ended


