/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beanController;

/**
 *
 * @author wolverine
 */
public class NfProdutos {

    private static final long serialVersionUID = 1L;
    private Integer numeroItem;
    private String codigo;
    private String descricao;
    private double quantidade;
    private String unidade;
    private float valorUnitario;
    private float valorTotal;
    private String codigoNCM;
    private String codigoEAN;
    private float baseICMS;
    private double aliquotaICMS;
    private float valorICMS;
    private double baseICMSST;
    private float aliquotaICSST;
    private float valorICMSST;
    private double mva;
    private float baseIPI;
    private double aliquotaIPI;
    private float valorIPI;
    private boolean entrada;

    public double getAliquotaICMS() {
        return aliquotaICMS;
    }

    public void setAliquotaICMS(double aliquotaICMS) {
        this.aliquotaICMS = aliquotaICMS;
    }

    public float getAliquotaICSST() {
        return aliquotaICSST;
    }

    public void setAliquotaICSST(float aliquotaICSST) {
        this.aliquotaICSST = aliquotaICSST;
    }

    public double getAliquotaIPI() {
        return aliquotaIPI;
    }

    public void setAliquotaIPI(double aliquotaIPI) {
        this.aliquotaIPI = aliquotaIPI;
    }

    public float getBaseICMS() {
        return baseICMS;
    }

    public void setBaseICMS(float baseICMS) {
        this.baseICMS = baseICMS;
    }

    public double getBaseICMSST() {
        return baseICMSST;
    }

    public void setBaseICMSST(double baseICMSST) {
        this.baseICMSST = baseICMSST;
    }

    public float getBaseIPI() {
        return baseIPI;
    }

    public void setBaseIPI(float baseIPI) {
        this.baseIPI = baseIPI;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoEAN() {
        return codigoEAN;
    }

    public void setCodigoEAN(String codigoEAN) {
        this.codigoEAN = codigoEAN;
    }

    public String getCodigoNCM() {
        return codigoNCM;
    }

    public void setCodigoNCM(String codigoNCM) {
        this.codigoNCM = codigoNCM;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getMva() {
        return mva;
    }

    public void setMva(double mva) {
        this.mva = mva;
    }

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        this.numeroItem = numeroItem;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getValorICMS() {
        return valorICMS;
    }

    public void setValorICMS(float valorICMS) {
        this.valorICMS = valorICMS;
    }

    public float getValorICMSST() {
        return valorICMSST;
    }

    public void setValorICMSST(float valorICMSST) {
        this.valorICMSST = valorICMSST;
    }

    public float getValorIPI() {
        return valorIPI;
    }

    public void setValorIPI(float valorIPI) {
        this.valorIPI = valorIPI;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

}
