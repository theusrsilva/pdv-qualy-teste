package net.originmobi.pdv.model;
import org.junit.jupiter.api.Test;

public class PessoaTest {

    @Test
    public void testNome() {
        Pessoa pessoa = new Pessoa.Builder("Lucas", "12345678900").build();
        pessoa.setNome("Omena");
        assertEquals("Omena", pessoa.getNome());
    }

	private void assertEquals(String string, String nome) {
		// TODO Auto-generated method stub
		
	}

}
