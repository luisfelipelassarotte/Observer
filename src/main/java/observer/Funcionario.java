package observer;

import java.util.Observable;
import java.util.Observer;

public class Funcionario implements Observer {

    private String funcionario;
    private String mensagem;

    public Funcionario(String usuario) {
        this.funcionario = usuario;
    }

    public String getUltimaMensagem() {
        return this.mensagem;
    }

    public void adicionar(Grupo grupo) {
        grupo.addObserver(this);
    }

    public void update(Observable grupo, Object arg1) {
        this.mensagem = this.funcionario + ", mensagem recebida: " + grupo.toString();
    }

}
