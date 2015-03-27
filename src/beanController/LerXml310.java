/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beanController;

import Interfaces.ItelaConsulta;
import controler.Sigap;
import facade.FornecedorFacade;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.Fornecedor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Woverine
 */
public class LerXml310 implements ILerNFe{

   private DocumentBuilderFactory dbf;
   private DocumentBuilder db;
   private Element raiz;
   private Document doc;
   private List<NfDuplicatas> listaDuplicata;
   private List<NfProdutos> listaProdutos;
   private ItelaConsulta telaConsulta;
   private NotaEletronica nota;
   private Fornecedor fornecedor;


    public LerXml310(String arquivo, ItelaConsulta telaConsulta) throws ParserConfigurationException, SAXException, IOException {

        this.dbf = DocumentBuilderFactory.newInstance();
        this.db = this.dbf.newDocumentBuilder();
        this.doc = this.db.parse(arquivo);
        this.raiz = doc.getDocumentElement();
        this.nota = new NotaEletronica();
        this.listaDuplicata = new ArrayList<NfDuplicatas>();
        this.listaProdutos = new ArrayList<NfProdutos>();
        this.fornecedor = new Fornecedor();
        this.telaConsulta = telaConsulta;
    }
    
   
    
    public void lerNotaFiscal() throws ParseException {

        NodeList nf = raiz.getElementsByTagName("ide");
        Element item = (Element) nf.item(0);
        NodeList nodeLista = item.getElementsByTagName("nNF");
        Node node = nodeLista.item(0).getFirstChild();
        this.nota.setNumero(node.getNodeValue());

        nodeLista = item.getElementsByTagName("dhEmi");
        node = nodeLista.item(0).getFirstChild();
        String data = node.getNodeValue();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date ddata = df.parse(data);
        df = new SimpleDateFormat("dd/MM/yyyy");
        data = df.format(ddata);
        this.nota.setDataEmissao(df.parse(data));

        nodeLista = item.getElementsByTagName("natOp");
        node = nodeLista.item(0).getFirstChild();
        this.nota.setNaturezaOperacao(node.getNodeValue());

        nodeLista = item.getElementsByTagName("serie");
        node = nodeLista.item(0).getFirstChild();
        this.nota.setSerie(node.getNodeValue());
        this.nota.setSubSerie(node.getNodeValue());

        nodeLista = item.getElementsByTagName("tpImp");
        node = nodeLista.item(0).getFirstChild();
        this.nota.setTipoOperacao(node.getNodeValue());

        nodeLista = item.getElementsByTagName("indPag");
        node = nodeLista.item(0).getFirstChild();

        if (node.getNodeValue().equalsIgnoreCase("0")) {
            this.nota.setFormaPagamento("A Vista");
        } else if (node.getNodeValue().equalsIgnoreCase("1")) {
            this.nota.setFormaPagamento("A Prazo");
        }else this.nota.setFormaPagamento("A Prazo");

        //preencher valores Nota Fiscal

        nf = raiz.getElementsByTagName("total");
        item = (Element) nf.item(0);
        nodeLista = item.getElementsByTagName("vBC");
        if (nodeLista.getLength() == 0) {
            this.nota.setBaseICMS(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setBaseICMS(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));
        }

        nodeLista = item.getElementsByTagName("vICMS");
        if (nodeLista.getLength() == 0) {
            this.nota.setValorICMS(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setValorICMS(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));

        }

        nodeLista = item.getElementsByTagName("vBCST");
        if (nodeLista.getLength() == 0) {
            this.nota.setBaseICMSST(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setBaseICMS(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));

        }

        nodeLista = item.getElementsByTagName("vST");
        if (nodeLista.getLength() == 0) {
            this.nota.setValorICMSST(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setValorICMSST(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));

        }

        nodeLista = item.getElementsByTagName("vProd");
        if (nodeLista.getLength() == 0) {
            this.nota.setValorProdutos(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setValorProdutos(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));

        }

        nodeLista = item.getElementsByTagName("vFrete");
        if (nodeLista.getLength() == 0) {
            this.nota.setValorFrete(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setValorFrete(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));

        }

        nodeLista = item.getElementsByTagName("vSeg");
        if (nodeLista.getLength() == 0) {
            this.nota.setValorSeguro(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setValorSeguro(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));

        }

        nodeLista = item.getElementsByTagName("vDesc");
        if (nodeLista.getLength() == 0) {
            this.nota.setValorDesconto(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setValorDesconto(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));

        }

        nodeLista = item.getElementsByTagName("vIPI");
        if (nodeLista.getLength() == 0) {
            this.nota.setValorIPI(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setValorIPI(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));

        }

        nodeLista = item.getElementsByTagName("vNF");
        if (nodeLista.getLength() == 0) {
            this.nota.setValorTotal(0);
        } else {
            node = nodeLista.item(0).getFirstChild();
            this.nota.setValorTotal(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));
        }
    }

    public void lerFornecedor() throws Exception {

        FornecedorFacade fornecedorFacade = new FornecedorFacade();

        NodeList nf = raiz.getElementsByTagName("emit");
        Element item = (Element) nf.item(0);
        NodeList nodeLista = item.getElementsByTagName("CNPJ");
        Node node = nodeLista.item(0).getFirstChild();
        String cnpj = node.getNodeValue();
        String fcnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/"
                + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);

        fornecedor = fornecedorFacade.consultarCNPJ(fcnpj);
        if (fornecedor == null) {
            JOptionPane.showMessageDialog(null, "Favor Cadastrar Fornecedor");
            fornecedor = new Fornecedor();
            fornecedor.setCnpj(fcnpj);
            nodeLista = item.getElementsByTagName("xNome");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                fornecedor.setRazaoSocial(node.getNodeValue());
            }

            nodeLista = item.getElementsByTagName("xFant");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                fornecedor.setNomeFantasia(node.getNodeValue());
            }

            nodeLista = item.getElementsByTagName("xLgr");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                fornecedor.setEndereco(node.getNodeValue());
            }

            nodeLista = item.getElementsByTagName("nro");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                fornecedor.setEndereco(fornecedor.getEndereco() + ", " + node.getNodeValue());
            }

            nodeLista = item.getElementsByTagName("xBairro");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                fornecedor.setBairro(node.getNodeValue());
            }

            nodeLista = item.getElementsByTagName("xMun");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                fornecedor.setCidade(node.getNodeValue());
            }

            String dados = null;
            String formato = null;

            nodeLista = item.getElementsByTagName("CEP");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                dados = node.getNodeValue();
                formato = dados.substring(0, 5) + "-" + dados.substring(5, 8) + dados.substring(8);
                fornecedor.setCep(formato);
            }

            nodeLista = item.getElementsByTagName("UF");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                fornecedor.setUf(node.getNodeValue());
            }

            nodeLista = item.getElementsByTagName("fone");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                dados = node.getNodeValue();
                formato = "(" + dados.substring(0, 2) + ")" + dados.substring(2, 6) + "-" + dados.substring(6, 10);
                fornecedor.setTelefone(formato);
            }

            nodeLista = item.getElementsByTagName("IE");
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(0).getFirstChild();
                fornecedor.setIe(node.getNodeValue());
            }


        }
    }

    public void lerProdutos() {

        NodeList lista = raiz.getElementsByTagName("det");
        Element item;
        NodeList prod;
        Node node;
        NfProdutos produtos = new NfProdutos();
        for (int i = 0; i < lista.getLength(); i++) {

            item = (Element) lista.item(i);
            produtos = new NfProdutos();
            prod = item.getElementsByTagName("xProd");
            produtos.setNumeroItem(Integer.parseInt(item.getAttributeNode("nItem").getValue()));
            if (prod.getLength() == 0) {
                produtos.setDescricao("");
            } else {
                node = prod.item(0).getFirstChild();
                produtos.setDescricao(node.getNodeValue());
            }

            prod = item.getElementsByTagName("cProd");
            if (prod.getLength() == 0) {
                produtos.setCodigo("");
            } else {
                node = prod.item(0).getFirstChild();
                produtos.setCodigo(node.getNodeValue());
            }

            String valor = null;
            prod = item.getElementsByTagName("qCom");
            if (prod.getLength() == 0) {
                produtos.setQuantidade(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setQuantidade((Sigap.ConvercaoMonetariaDouble(valor)));
            }

            prod = item.getElementsByTagName("uCom");
            if (prod.getLength() == 0) {
                produtos.setUnidade("");
            } else {
                node = prod.item(0).getFirstChild();
                produtos.setUnidade(node.getNodeValue());
            }

            prod = item.getElementsByTagName("vUnCom");
            if (prod.getLength() == 0) {
                produtos.setValorUnitario(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setValorUnitario((Sigap.ConvercaoMonetariaFloat(valor)));
            }

            prod = item.getElementsByTagName("vProd");
            if (prod.getLength() == 0) {
                produtos.setValorTotal(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setValorTotal((Sigap.ConvercaoMonetariaFloat(valor)));
            }


            prod = item.getElementsByTagName("NCM");
            if (prod.getLength() == 0) {
                produtos.setCodigoNCM("");
            } else {
                node = prod.item(0).getFirstChild();
                produtos.setCodigoNCM(node.getNodeValue());
            }


            prod = item.getElementsByTagName("Vbc");
            if (prod.getLength() == 0) {
                produtos.setBaseICMS(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setBaseICMS((Sigap.ConvercaoMonetariaFloat(valor)));
            }


            prod = item.getElementsByTagName("pICMS");
            if (prod.getLength() == 0) {
                produtos.setAliquotaICMS(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setAliquotaICMS((Sigap.ConvercaoMonetariaDouble(valor)));
            }


            prod = item.getElementsByTagName("vICMS");
            if (prod.getLength() == 0) {
                produtos.setValorICMS(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setValorICMS((Sigap.ConvercaoMonetariaFloat(valor)));
            }


            prod = item.getElementsByTagName("vBCST");
            if (prod.getLength() == 0) {
                produtos.setBaseICMSST(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setBaseICMSST((Sigap.ConvercaoMonetariaDouble(valor)));
            }


            prod = item.getElementsByTagName("pICMSST");
            if (prod.getLength() == 0) {
                produtos.setValorICMSST(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setValorICMSST((Sigap.ConvercaoMonetariaFloat(valor)));
            }


            prod = item.getElementsByTagName("vICMSST");
            if (prod.getLength() == 0) {
                produtos.setValorICMSST(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setValorICMSST((Sigap.ConvercaoMonetariaFloat(valor)));
            }

            prod = item.getElementsByTagName("pMVSST");
            if (prod.getLength() == 0) {
                produtos.setMva(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setMva((Sigap.ConvercaoMonetariaDouble(valor)));
            }
            
             prod = item.getElementsByTagName("vIPI");
            if (prod.getLength() == 0) {
                produtos.setValorIPI(0);
            } else {
                node = prod.item(0).getFirstChild();
                valor = node.getNodeValue();
                produtos.setValorIPI(Sigap.ConvercaoMonetariaFloat(valor));
            }

            this.listaProdutos.add(produtos);
        }
    }

    public void lerDuplicatas() throws ParseException {

        NodeList lista = raiz.getElementsByTagName("cobr");
        Element item;
        NodeList nodeLista;
        Node node;

        for (int i = 0; i < lista.getLength(); i++) {

            item = (Element) lista.item(i);

            nodeLista = item.getElementsByTagName("nDup");

            NfDuplicatas duplicata;
            if (nodeLista.getLength() > 0) {
                node = nodeLista.item(i).getFirstChild();
                duplicata = new NfDuplicatas();
                duplicata.setNumero(node.getNodeValue());

                nodeLista = item.getElementsByTagName("dVenc");
                if (nodeLista.getLength() > 0) {


                    node = nodeLista.item(0).getFirstChild();
                    String data = node.getNodeValue();
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date ddata = df.parse(data);
                    df = new SimpleDateFormat("dd/MM/yyyy");
                    data = df.format(ddata);
                    duplicata.setDataVencimento(df.parse(data));

                }

                nodeLista = item.getElementsByTagName("vDup");
                if (nodeLista.getLength() > 0) {
                    node = nodeLista.item(i).getFirstChild();
                    duplicata.setValor(Sigap.ConvercaoMonetariaFloat(node.getNodeValue()));
                }
                this.listaDuplicata.add(duplicata);
            }

        }
        telaConsulta.setNFe(listaProdutos, listaDuplicata, nota, fornecedor);
    }

    public DocumentBuilder getDb() {
        return db;
    }

    public void setDb(DocumentBuilder db) {
        this.db = db;
    }

    public DocumentBuilderFactory getDbf() {
        return dbf;
    }

    public void setDbf(DocumentBuilderFactory dbf) {
        this.dbf = dbf;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<NfDuplicatas> getListaDuplicata() {
        return listaDuplicata;
    }

    public void setListaDuplicata(List<NfDuplicatas> listaDuplicata) {
        this.listaDuplicata = listaDuplicata;
    }

    public ItelaConsulta getTelaConsulta() {
        return telaConsulta;
    }

    public void setTelaConsulta(ItelaConsulta telaConsulta) {
        this.telaConsulta = telaConsulta;
    }

   
    public NotaEletronica getNota() {
        return nota;
    }

    public void setNota(NotaEletronica nota) {
        this.nota = nota;
    }

    public List<NfProdutos> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<NfProdutos> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Element getRaiz() {
        return raiz;
    }

    public void setRaiz(Element raiz) {
        this.raiz = raiz;
    }
}
