package pckg;

import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;

import pckg.Proses.processState;

import java.util.List;

public class MultiLevelQueue {
	
	
	public MultiLevelQueue ( ) 
	{
		
		
	}


	public int RunMultiLevelQueue(UserJobQueue userjobQueue, int time,int fcfsarrival) throws IOException 
	{
		Iterator<Proses> iteratorUser1 =userjobQueue.firstQueue.iterator(); // ilk kullanici kuyrugu icin iterator
		Iterator<Proses> iteratorUser2 =userjobQueue.secondQueue.iterator();
		Iterator<Proses> iteratorUser3 =userjobQueue.thirdQueue.iterator();
		Proses firstProses=null;
		Proses secondProses=null;
		Proses thirdProses=null;
		
		if(iteratorUser1.hasNext()) firstProses=iteratorUser1.next();  
		else firstProses=new Proses(65000,0,0);
		
		if(iteratorUser2.hasNext()) secondProses=iteratorUser2.next();  
		else secondProses=new Proses(65000,0,0);
		
		if(iteratorUser3.hasNext()) thirdProses=iteratorUser3.next();  
		else thirdProses=new Proses(65000,0,0);
		
		
		if(iteratorUser1!=null && firstProses.getArrivalTime()<=time) // eger ilk kullanici kuyrugu bos degilse ilk prosesi bir sn calissin
		{
				firstProses.ProsesRunning(); //Proses builder
				firstProses.state=processState.Running;
				firstProses.ProsesDurum();
				// user1'in kalan zamani azaltilip alt kuyruga gonderilecek.
				firstProses.updateRemainingTime(); // prosessin kalan zamanini 1 sn azaltsin
				firstProses.increasePriority();
				firstProses.ProsesDurum();
				time++;
				boolean atildiMi=false;
			
			
			if(firstProses.getRemainingTime()!=0)
			{
				for(Proses proses :userjobQueue.secondQueue)
				{
					if(proses.getArrivalTime()>=time)
					{
						userjobQueue.secondQueue.add(userjobQueue.secondQueue.indexOf(proses),firstProses);
						firstProses.state=processState.Waiting;
						System.out.println("birincikuyruk kesildi");
						atildiMi=true;
						break;
					}
				}
				if(!atildiMi) {
					userjobQueue.secondQueue.add(firstProses);
					firstProses.state=processState.Waiting;
					System.out.println("birincikuyruk kesildi");
				}
			}
			iteratorUser1.remove();
			//userjobQueue.firstQueue.remove(0);// kuyruktaki ilk prosesi kaldirir.
			if(time>=fcfsarrival) 
			{
					System.out.println("birincikuyruk fcfsyle kesildi");
					firstProses.state=processState.Waiting;
					return  time;
			}
		}
		else if  (iteratorUser2!=null && secondProses.getArrivalTime()<=time )
		{
				secondProses.ProsesRunning(); //Proses builder
				secondProses.state=processState.Running;
				secondProses.ProsesDurum();
				// user1'in kalan zamani azaltilip alt kuyruga gonderilecek.
				secondProses.updateRemainingTime(); // prosessin kalan zamanini 1 sn azaltsin
				secondProses.increasePriority();
				secondProses.ProsesDurum();
				time++;
				boolean atildiMi=false;
				
				System.out.println(secondProses.getRemainingTime());
				if(secondProses.getRemainingTime()!=0)
				{
					for(Proses proses :userjobQueue.thirdQueue)
					{
						if(proses.getArrivalTime()>=time)
						{
							userjobQueue.thirdQueue.add(userjobQueue.secondQueue.indexOf(proses),secondProses);
							secondProses.state=processState.Waiting;
							System.out.println("ikinci kuyruk kesildi");
							atildiMi=true;
							break;
						}
					}
					if(!atildiMi) {
						
							userjobQueue.thirdQueue.add(secondProses);
							secondProses.state=processState.Waiting;
							System.out.println("ikinci kuyruk kesildi");
						
					}
				}
				iteratorUser2.remove();
				//userjobQueue.secondQueue.remove(0);// kuyruktaki ilk prosesi kaldirir.
				if(time>=fcfsarrival)  
				{
						System.out.println("ikinci kuyruk fcfsyle kesildi");
						secondProses.state=processState.Waiting;
					
					return  time;
				}
		}
		else if (iteratorUser3!=null && thirdProses.getArrivalTime()<=time ) // buradaki prosesler 1 sn calisip kuyrugun sonuna yollanıcak , rr modu
		{
			thirdProses.ProsesRunning(); //Proses builder
			thirdProses.state=processState.Running;
			thirdProses.ProsesDurum();
			// user1'in kalan zamani azaltilip alt kuyruga gonderilecek.
			thirdProses.updateRemainingTime(); // prosessin kalan zamanini 1 sn azaltsin
			thirdProses.ProsesDurum();
			time++;
			userjobQueue.thirdQueue.remove(0);
				if(thirdProses.getRemainingTime()!=0)
				{
					
						userjobQueue.thirdQueue.add(thirdProses);
						thirdProses.state=processState.Waiting;
						System.out.println("ucuncu kuyruk kesildi");

					
				}
				if(time>=fcfsarrival) {
						System.out.println("ucuncu kuyruk fcfsyle kesildi");
						thirdProses.state=processState.Waiting;
					
					return  time;
				}
		}
		
		return time;
	}
	
	

}

