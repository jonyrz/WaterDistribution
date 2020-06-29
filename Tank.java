package itq.dist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import itq.dist.*;


public class Tank {
	float capacity;
	int idtank;
	float currentwater;
	Logger log = LogManager.getLogger(Tank.class);
	
public Tank(float capacity,int idtank,float currentwater) {
		 this.idtank = idtank;
		 this.capacity = capacity;
		 this.currentwater= currentwater;
}

public float getCapacity() {
		return capacity;
}

public void setCapacity(float capacity) {
		this.capacity = capacity;
		
}

public int getIdtank() {
		return idtank;
}

public void setIdtank(int idtank) {
		this.idtank = idtank;
}

public float getCurrentwater() {
		return currentwater;
}

public void setCurrentwater(float currentwater) {
		this.currentwater = currentwater;
}

public boolean updateWater(float reqWater) {
	if(this.currentwater >= reqWater) {
		this.currentwater = this.currentwater - reqWater;
		setCurrentwater(this.currentwater);
		log.info(" Entregada: "+ reqWater+ " Tanque: "+getIdtank()+ " (0)");
		return true;
	}
	else{
			log.error("No se entrego por superar el limite del tanque + "\n Capacidad:"+capacity+" Llenado "+reqWater);
			return false;
		}
	}
}