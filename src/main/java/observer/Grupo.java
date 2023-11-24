package observer;

import java.util.Observable;

public class Grupo extends Observable {

    private String nome;
    private String status;

    public Grupo(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }

    public void enviarMensagem() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Status { " + "Sensor: " + nome + ", Status: " + this.status + " }";
    }

}
