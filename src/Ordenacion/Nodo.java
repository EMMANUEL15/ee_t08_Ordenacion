package Ordenacion;
/**
 * @author (Lopez Ramirez Emanuel) 
 */
public class Nodo<T>{
    protected T Dato;
    protected Nodo<T> Siguiente;
    protected Nodo<T> Anterior;
    public Nodo(T dato){
        this.Dato=dato;
        this.Siguiente=null;
        this.Anterior=null;
    }
    public void setDato(T dato){this.Dato=dato;}
    public T getDato(){return Dato;}
    public void setSiguiente(Nodo<T> siguiente){this.Siguiente=siguiente;}
    public Nodo<T> getSiguiente(){return Siguiente;}
    public void setAnterior(Nodo<T> anterior){this.Anterior=anterior;}
    public Nodo<T> getAnterior(){return Anterior;}
}
