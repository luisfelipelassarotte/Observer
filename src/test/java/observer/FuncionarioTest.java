package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void deveNotificarStatusUmFuncionario() {
        Grupo grupo = new Grupo("Torre", "OK");
        Funcionario funcionario = new Funcionario("Cleitinho");
        funcionario.adicionar(grupo);
        grupo.enviarMensagem();
        assertEquals("Cleitinho, mensagem recebida: Status { Sensor: Torre, Status: OK }", funcionario.getUltimaMensagem());
    }

    @Test
    void deveNotificarStatusDoisFuncionarios() {
        Grupo grupo = new Grupo("Torre", "OK");
        Funcionario funcionario1 = new Funcionario("Cleitinho");
        Funcionario funcionario2 = new Funcionario("Zezinho");
        funcionario1.adicionar(grupo);
        funcionario2.adicionar(grupo);
        grupo.enviarMensagem();
        assertEquals("Cleitinho, mensagem recebida: Status { Sensor: Torre, Status: OK }", funcionario1.getUltimaMensagem());
        assertEquals("Zezinho, mensagem recebida: Status { Sensor: Torre, Status: OK }", funcionario2.getUltimaMensagem());
    }

    @Test
    void naoDeveNotificarFuncionario() {
        Grupo grupo = new Grupo("Torre", "OK");
        Funcionario funcionario = new Funcionario("Cleitinho");
        grupo.enviarMensagem();
        assertEquals(null, funcionario.getUltimaMensagem());
    }

    @Test
    void deveNotificarFuncionarioGrupoTorre() {
        Grupo grupo1 = new Grupo("Torre", "OK");
        Grupo grupo2 = new Grupo("Portão", "OK");
        Funcionario funcionario1 = new Funcionario("Cleitinho");
        Funcionario funcionario2 = new Funcionario("Zezinho");
        funcionario1.adicionar(grupo1);
        funcionario2.adicionar(grupo2);
        grupo1.enviarMensagem();
        assertEquals("Cleitinho, mensagem recebida: Status { Sensor: Torre, Status: OK }", funcionario1.getUltimaMensagem());
        assertEquals(null, funcionario2.getUltimaMensagem());
    }

}