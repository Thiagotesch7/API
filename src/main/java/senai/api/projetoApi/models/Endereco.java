package senai.api.projetoApi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String logradouro;
    private String localidade;
    private String cep;
    private int numero;
    private String complemento;
    private String bairro;
    private String referencia;

    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Endereco() {}

    public Endereco(String logradouro, String localidade, String cep, int numero, String complemento,
                    String bairro, String referencia, Usuario usuario) {
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.referencia = referencia;
        this.usuario = usuario;
    }

   
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getLocalidade() { return localidade; }
    public void setLocalidade(String localidade) { this.localidade = localidade; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}

