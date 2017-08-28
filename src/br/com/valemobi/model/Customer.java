package br.com.valemobi.model;

public class Customer {
    private int id_customer;
    private long cpf_cnpj;
    private String nm_customer;
    private int is_active;
    private int vl_total;

    public int getId() {
    return id_customer;
    }

    public void setId(int id_customer) {
    this.id_customer = id_customer;
    }
    
    public long getCpfCnpj() {
    return cpf_cnpj;
    }

    public void setCpfCnpj(long cpf_cnpj) {
    this.cpf_cnpj = cpf_cnpj;
    }

    public String getCustomerName() {
    return nm_customer;
    }

    public void setCustomerName(String nm_customer) {
    this.nm_customer = nm_customer;
    }

    public int getActive() {
    return is_active;
    }

    public void setActive(int is_active) {
    this.is_active = is_active;
    }

    public int getTotal() {
    return vl_total;
    }

    public void setTotal(int vl_total) {
    this.vl_total = vl_total;
    }
}
