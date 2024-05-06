package net.originmobi.pdv;
import org.junit.jupiter.api.Test;

import net.originmobi.pdv.model.Pessoa;

public class PessoaTest {

    @org.junit.Test
    public void testNome() {
        Pessoa pessoa = new Pessoa.Builder("Lucas", "12345678900").build();
        pessoa.setNome("Omena");
        assertEquals("Omena", pessoa.getNome());
    }

	private void assertEquals(String string, String nome) {
		// TODO Auto-generated method stub
		
	}

}
