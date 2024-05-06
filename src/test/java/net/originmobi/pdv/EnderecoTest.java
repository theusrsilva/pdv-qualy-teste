package net.originmobi.pdv;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class EnderecoTest {

    private Endereco endereco;

    @Before
    public void setUp() {
        
        endereco = new Endereco("Rua MinasGerais", "Bairro Brasilandia", "123", "12345-678", "Casa com portao branco", new Date(System.currentTimeMillis()), new Cidade());
    }

    @Test
    public void testGetRua() {
        assertEquals("Rua MinasGerais", endereco.getRua());
    }

    @Test
    public void testGetBairro() {
        assertEquals("Bairro Brasilandia", endereco.getBairro());
    }

    @Test
    public void testGetNumero() {
        assertEquals("123", endereco.getNumero());
    }

    @Test
    public void testGetCep() {
        assertEquals("12345-678", endereco.getCep());
    }

    @Test
    public void testGetReferencia() {
        assertEquals("Casa com portao branco", endereco.getReferencia());
    }

    @Test
    public void testGetDataCadastro() {
        assertNotNull(endereco.getData_cadastro());
    }

    @Test
    public void testGetCidade() {
        assertNotNull(endereco.getCidade());
    }

}