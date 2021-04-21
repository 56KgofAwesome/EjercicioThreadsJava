
package castañeda_adriana_r5_u3;

import javax.swing.JTextArea;


public class ThreadRunner implements Runnable{
    
    
    private int runnerSpeed;
    private String nombreCorredor;
    private JTextArea jta;
    
    public ThreadRunner(String nombreCorredor,int runnerSpeed, JTextArea jta){
     
        this.runnerSpeed = runnerSpeed;
        this.nombreCorredor = nombreCorredor;
        this.jta = jta;
    }
    
    @Override
    public void run() {
        
        try{
            long milis = this.runnerSpeed * 1000;
            
            Thread.sleep(milis);            
            jta.append("Corredor: " + nombreCorredor + "- Tiempo:" + this.runnerSpeed + " segundos. \n");
            
        }catch(Exception e){
        
        }
    }
    
}
