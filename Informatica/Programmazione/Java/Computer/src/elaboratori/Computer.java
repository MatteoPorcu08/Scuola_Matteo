package elaboratori;
public class Computer {
    private String marca;
    private String modello;
    private double  prezzo;
    private String cpu;
    private int ram;
    private int storage;

    //costruttore
    public Computer(String marca, String modello, double prezzo, String cpu, int ram, int storage) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
}

//getter
public String getMarca(){
    return marca;
}
public String getModello(){
    return modello;
}
public double getPrezzo(){
    return prezzo;
}
public String getCpu(){
    return cpu;
}
public int getRam(){
    return ram;
}
public int getStorage(){
    return storage;
}

//setter
private void setMarca(String marca){
    this.marca = marca;
}
private void setModello(String modello){
    this.modello = modello;
}
private void setPrezzo(double prezzo){
    this.prezzo = prezzo;
}
private void setCpu(String cpu){
    this.cpu = cpu;
}
private void setRam(int ram){
    this.ram = ram;
}
private void setStorage(int storage){
    this.storage = storage;
}

//toString
public String toString(){
    return "Marca: " + marca + ", Modello: " + modello + ", Prezzo: " + prezzo + ", CPU: " + cpu + ", RAM: " + ram + "GB, Storage: " + storage + "GB";
}

//metodo ottieniFasciaDiPrezzo()
public string ottieniFasciaDiPrezzo(){
    if(prezzo > 1200){
        return "fascia Alta";
    } else if(prezzo >= 700 && prezzo < 1200){
        return "fascia Media";
    } else {
        return "fascia Bassa";
    }
    


}