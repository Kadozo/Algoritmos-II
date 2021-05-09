/*******************************************************************************
Autor: Thiago Cardozo de Jesus
Componente Curricular: Algoritmos & Programação II I
Concluido em: 05/05/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package br.uefs.ecomp.delivery.model;

/**
 * Classe destinada a guardar as informaçoes dos clientes
 * @author Thiago Cardozo
 */
public class Cliente{
    private String name;
    private String phone;
    private String email;

    /**
     * Construtor de Cliente que recebe 3 parametros: nome, telefone e email.
     * @param name
     * @param phone
     * @param email
     */
    public Cliente(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /**
     *retorna o nome do cliente
     * @return nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * muda o nome atual do cliente para o parâmetro passado 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * retorna o telefone do cliente
     * @return telefone do cliente
     */
    public String getPhone() {
        return phone;
    }

    /**
     * muda o atual telefone do cliente para o parâmetro passado
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * retorna o email do cliente
     * @return o email do cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * muda o atual email do cliente para o parametro passado
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * metodo equal para cliente, se o cliente passado como parametro for igual
     * ao cliente que chamou o metodo, entao o retorno será true, caso contrário
     * será false
     * @param cliente
     * @return boolean
     */
    public boolean equals (Cliente cliente){
        boolean a = this.name.equals(cliente.getName()) && this.phone.equals(cliente.getPhone());
        boolean b = this.email.equals(cliente.getEmail());
            return a && b;
    }
}