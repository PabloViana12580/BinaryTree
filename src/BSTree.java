/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author josePablo
 * Esta es la clase donde nace nuestro arbol
 */

public class BSTree<E>{

	private Association word;
	private BSTree<E> left, right,raiz;  
	
        /**
         * Constructor
         * @param word 
         */
	public BSTree(Association word)
        {
		this.word = word;
		left= null;
		right=null;
                raiz = null;
	}
	
        public void Insertar(Association diccio){
        if(raiz == null)
            raiz = new BSTree(diccio);
        else if (!word.equals(diccio))
            left = new BSTree(diccio);
        else
            right = new BSTree(diccio);
        }
        
        public void inOnder(){
            ayudanteInorden(raiz);
        }
     
    //metodo recursivo para recorrido inorden
    private void ayudanteInorden(BSTree<E> nodo)
    {
        if(nodo == null)
            return;
         
        ayudanteInorden(nodo.left);
        System.out.print(nodo.word + "");
        ayudanteInorden(nodo.right);
    }
    
    public String transcripcion(String en){
        String res="";
        if((en.compareTo((String) word.getKey())>0)& (right!=null))
                res =  right.transcripcion(en);
        else if(left!=null)
                res = left.transcripcion(en);
        else if(en.compareTo((String) word.getKey())== 0)
                res = (String) word.getValue();
        else
                res = "*"+en+"*";
        
        return res;

    }

}
