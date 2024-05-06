package net.originmobi.pdv.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
// PROBLEMAS RESOLVIDOS,OMENA: 
//Pessoa.java	null	Rename this field "data_cadastro" to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Rename this field "data_nascimento" to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Rename this local variable to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Rename this local variable to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Rename this local variable to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Rename this local variable to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Rename this method name to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Rename this method name to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Rename this method name to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Rename this method name to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
//Pessoa.java	null	Constructor has 8 parameters, which is greater than 7 authorized.
@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "nome não pode ser vazio")
    @Size(min = 5, max = 250)
    private String nome;

    @Size(max = 250)
    private String apelido;

    @Column(unique = true)
    private String cpfcnpj;

    private String observacao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "endereco_codigo")
    private Endereco endereco;

    @OneToMany
    private List<Telefone> telefone;

    private Pessoa(Builder builder) {
        this.nome = builder.nome;
        this.apelido = builder.apelido;
        this.cpfcnpj = builder.cpfcnpj;
        this.observacao = builder.observacao;
        this.dataCadastro = builder.dataCadastro;
        this.dataNascimento = builder.dataNascimento;
        this.endereco = builder.endereco;
        this.telefone = builder.telefone;
    }

    public static class Builder {
        private String nome;
        private String apelido;
        private String cpfcnpj;
        private String observacao;
        private Date dataNascimento;
        private Date dataCadastro;
        private Endereco endereco;
        private List<Telefone> telefone;

        public Builder(String nome, String cpfcnpj) {
            this.nome = nome;
            this.cpfcnpj = cpfcnpj;
        }

        public Builder apelido(String apelido) {
            this.apelido = apelido;
            return this;
        }

        public Builder observacao(String observacao) {
            this.observacao = observacao;
            return this;
        }

        public Builder dataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder dataCadastro(Date dataCadastro) {
            this.dataCadastro = dataCadastro;
            return this;
        }

        public Builder endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder telefone(List<Telefone> telefone) {
            this.telefone = telefone;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(this);
        }
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }
}
