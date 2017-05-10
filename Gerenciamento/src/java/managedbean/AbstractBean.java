/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.faces.component.html.HtmlDataTable;

/**
 *
 * @author aluno.unilasalle
 */
public abstract class AbstractBean<T> {
    
    private Class<T> c;
    private T obj;
    private T edt;
    private T selected;
    private HtmlDataTable lista;
    
    
    public AbstractBean(Class<T> classe){
        c = classe;
        
    }
    
    public abstract String salvar();
    public abstract String excluir();
    
    public T getSelecionado(){
        return (T) getSelected();
    }
    
    public void cleanUp(){
        edt = null;
    }
    
    public String cancelar(){
        setEdt(null);
        return null;
    }

    /**
     * @return the c
     */
    public Class<T> getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Class<T> c) {
        this.c = c;
    }

    /**
     * @return the obj
     */
    public T getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj) {
        this.obj = obj;
    }

    /**
     * @return the edt
     */
    public T getEdt() {
        return edt;
    }

    /**
     * @param edt the edt to set
     */
    public void setEdt(T edt) {
        this.edt = edt;
    }

    /**
     * @return the selected
     */
    public T getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(T selected) {
        this.selected = selected;
    }

    /**
     * @return the lista
     */
    public HtmlDataTable getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(HtmlDataTable lista) {
        this.lista = lista;
    }
    
}
