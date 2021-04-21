
package castañeda_adriana_r5_u3;

import java.util.Random;

public class Runner {
    
    private String name;
    private Integer speed;
    
    public String getName(){ return name; }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Integer getSpeed(){ return speed;}
    
    public void setSpeed(){
        Random rand = new Random();
        int randomSpeed = rand.nextInt(31);
        this.speed = randomSpeed;        
    }
    
}
