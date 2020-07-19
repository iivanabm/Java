package trabalho;

public class Filme {
    
    private String titulo;
    private int ano;
    private double nota;
    
    public Filme(String titulo, int ano, double nota){
        this.titulo = titulo;
        this.ano = ano;
        this.nota = nota;
}
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public void setAno(int ano){
        this.ano = ano;
    }
    
    public double getNota(){
        return this.nota;
    }
    
    public void setNota(double nota){
        this.nota = nota;
    }

    @Override
    public String toString(){
        return "Filme{" + "titulo=" + titulo +
                ", ano=" + ano + ", nota=" + nota + '}';
    }
    
    
}
