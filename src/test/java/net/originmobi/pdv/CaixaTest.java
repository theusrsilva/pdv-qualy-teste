package net.originmobi.pdv;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import java.sql.Timestamp;
import net.originmobi.pdv.model.Caixa;
import net.originmobi.pdv.model.Usuario;
import net.originmobi.pdv.enumerado.caixa.CaixaTipo;

@DisplayName("Testes para a classe Caixa")
public class CaixaTest {

    private Caixa caixa;
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
        caixa = new Caixa("Descrição do Caixa", CaixaTipo.CAIXA, 100.0, 0.0, null, new Date(), null, usuario);
    }

    @Test
    @DisplayName("Teste de criação de instância")
    public void testInstanciaCaixa() {
        assertNotNull(caixa);
    }

        @Test
    @DisplayName("Teste do getter e setter para código")
    public void testCodigoGetterSetter() {
        caixa.setCodigo(123L);
        assertEquals(123L, caixa.getCodigo());
    }

    @Test
    @DisplayName("Teste do getter e setter para descrição")
    public void testDescricaoGetterSetter() {
        caixa.setDescricao("Nova Descrição");
        assertEquals("Nova Descrição", caixa.getDescricao());
    }

    @Test
    @DisplayName("Teste do getter e setter para valor de abertura")
    public void testValorAberturaGetterSetter() {
        caixa.setValor_abertura(200.0);
        assertEquals(200.0, caixa.getValor_abertura(), 0);
    }

    @Test
    @DisplayName("Teste do getter e setter para valor total")
    public void testValorTotalGetterSetter() {
        caixa.setValor_total(500.0);
        assertEquals(500.0, caixa.getValor_total(), 0);
    }

    @Test
    @DisplayName("Teste do getter e setter para valor de fechamento")
    public void testValorFechamentoGetterSetter() {
        caixa.setValor_fechamento(300.0);
        assertEquals(300.0, caixa.getValor_fechamento(), 0);
    }

    @Test
    @DisplayName("Teste do getter e setter para valor de entrada")
    public void testValorEntradaGetterSetter() {
        caixa.setValor_entrada(150.0);
        assertEquals(150.0, caixa.getValor_entrada(), 0);
    }

    @Test
    @DisplayName("Teste do getter e setter para valor de saída")
    public void testValorSaidaGetterSetter() {
        caixa.setValor_saida(50.0);
        assertEquals(50.0, caixa.getValor_saida(), 0);
    }

    @Test
    @DisplayName("Teste do getter e setter para tipo de caixa")
    public void testTipoGetterSetter() {
        caixa.setTipo(CaixaTipo.COFRE);
        assertEquals(CaixaTipo.COFRE, caixa.getTipo());
    }

    @Test
    @DisplayName("Teste do getter e setter para agência")
    public void testAgenciaGetterSetter() {
        caixa.setAgencia("1234");
        assertEquals("1234", caixa.getAgencia());
    }

    @Test
    @DisplayName("Teste do getter e setter para conta")
    public void testContaGetterSetter() {
        caixa.setConta("5678");
        assertEquals("5678", caixa.getConta());
    }

    @Test
    @DisplayName("Teste do getter e setter para data de cadastro")
    public void testDataCadastroGetterSetter() {
        Date dataCadastro = new Date();
        caixa.setData_cadastro(dataCadastro);
        assertEquals(dataCadastro, caixa.getData_cadastro());
    }

    @Test
    @DisplayName("Teste do getter e setter para data de fechamento")
    public void testDataFechamentoGetterSetter() {
        Timestamp dataFechamento = new Timestamp(new Date().getTime());
        caixa.setData_fechamento(dataFechamento);
        assertEquals(dataFechamento, caixa.getData_fechamento());
    }

    @Test
    @DisplayName("Teste do getter e setter para usuário")
    public void testUsuarioGetterSetter() {
        Usuario novoUsuario = new Usuario();
        caixa.setUsuario(novoUsuario);
        assertEquals(novoUsuario, caixa.getUsuario());
    }

    @Test
    @DisplayName("Teste de valores válidos para o tipo de caixa")
    public void testTipoCaixaValido() {
        assertEquals(CaixaTipo.CAIXA, caixa.getTipo());
    }

    @Test
    @DisplayName("Teste de valores inválidos para o tipo de caixa")
    public void testTipoCaixaInvalido() {
        caixa.setTipo(CaixaTipo.valueOf("INVALIDO"));
        assertNotEquals(CaixaTipo.valueOf("INVALIDO"), caixa.getTipo());
    }

    @Test
    @DisplayName("Teste de abertura e fechamento do caixa")
    public void testAberturaFechamentoCaixa() {
        assertTrue(caixa.isAberto());
        caixa.setData_fechamento(new Timestamp(new Date().getTime()));
        assertFalse(caixa.isAberto());
    }

    @Test
    @DisplayName("Teste de cálculos de valores")
    public void testCalculoValores() {
        assertEquals(100.0, caixa.getValor_abertura(), 0);
        assertEquals(0.0, caixa.getValor_total(), 0);
    }

    @Test
    @DisplayName("Teste de validação de descrição")
    public void testValidacaoDescricao() {
        assertEquals("Descrição do Caixa", caixa.getDescricao());
        caixa.setDescricao(""); // Descrição vazia, deve falhar na validação
        assertEquals("Descrição do Caixa", caixa.getDescricao()); // Deve manter o valor original
    }

    @Test
    @DisplayName("Teste de associação com usuário")
    public void testAssociacaoUsuario() {
        assertNotNull(caixa.getUsuario());
    }

    @Test
    @DisplayName("Teste de valores nulos")
    public void testValoresNulos() {
        assertNotNull(caixa.getDescricao());
        assertNotNull(caixa.getTipo());
    }

    @Test
    @DisplayName("Teste de integração com outras entidades")
    public void testIntegracaoOutrasEntidades() {
        assertNotNull(caixa.getUsuario().getCodigo());
    }

    @Test
    @DisplayName("Teste de atualização de valores")
    public void testAtualizacaoValores() {
        assertEquals(0.0, caixa.getValor_saida(), 0);
        caixa.setValor_saida(50.0);
        assertEquals(50.0, caixa.getValor_saida(), 0);
    }
}