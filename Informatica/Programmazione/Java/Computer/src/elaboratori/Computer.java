package elaboratori;

import programmi.ProgrammiComputer;

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
public String ottieniFasciaDiPrezzo(){
    if(prezzo > 1200){
        return "fascia Alta";
    } else if(prezzo >= 700 && prezzo < 1200){
        return "fascia Media";
    } else {
        return "fascia Bassa";
    }

//metodi aggiuntivi

//metodo aggiornaprezzo(double scontoPercentuale)
public String aggiornaPrezzo(double scontoPercentuale){
    


}

//metodo upgradeRam(int nuovaRam)
public void upgradeRam(int nuovaRam){
    if(nuovaRam > ram){
        ram = nuovaRam;
    }
    else {
        System.out.println("La nuova RAM deve essere maggiore di quella attuale.");
    }
}

//metodo confrontaComputer(Computer altroComputer)
public int confrontaComputer(Computer altroComputer) {
        return Integer.confronta(this.prezzo, altroComputer.getPrezzo());
    }

//metodo ottieniInfoDettagliata()
public String ottieniInfoDettagliata() {
        String stringa="";
        stringa+=toString();
        stringa+="Fascia di Prezzo: " + ottieniFasciaDiPrezzo();
        return stringa;
    }
}