package senhas;

public class SenhasDeAtendimento implements Comparable<SenhasDeAtendimento> {

    protected long timeStamp;
    protected boolean preferencial;
    
    public SenhasDeAtendimento(boolean preferencial) {
        this.preferencial = preferencial;
        timeStamp = System.nanoTime();        
    }
  
    public long getTimeStamp() {
        return timeStamp;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }
    
    @Override
    public int compareTo(SenhasDeAtendimento outra) {
        if (this.preferencial && !outra.preferencial) {
            return -1;
        } else if (!this.preferencial && outra.preferencial) {
            return 1;
        }else{
            if(this.timeStamp < outra.timeStamp){
                return -1;
            }else if(this.timeStamp > outra.timeStamp){
                return 1;
            }else{
                return 0;
            }
        }
    }
}