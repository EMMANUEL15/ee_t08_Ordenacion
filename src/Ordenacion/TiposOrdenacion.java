package Ordenacion;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * @author (Emanuel Lopez Ramirez) 
 * */
public class TiposOrdenacion<T>{
    protected Nodo<T> Inicio;
    public TiposOrdenacion(){   // CONSTRUCTOR
      this.Inicio=null;
    }
    public void incertarInicio(T dato){     //INCERTA DATOS AL INICIO DE  FILA
        Nodo<T> N=new Nodo<T>(dato);
        N.setSiguiente(Inicio);
        N.setAnterior(null);
        if(Inicio!=null){
        Inicio.setAnterior(N);
       }
       Inicio=N;
    }
    public void incertarFinal(T dato){//    INCERTAR DATOS AL FINAL DE LA LISTAS 
        try{
        Nodo<T> R=Inicio;
        while(R.getSiguiente()!=null){
            R=R.getSiguiente();
        }
        Nodo<T> N=new Nodo<T>(dato);
        R.setSiguiente(N);
        N.setAnterior(R);
        N.setSiguiente(null);
      }catch(Exception x){incertarInicio(dato);}
    }
    public Nodo<T> leer2(String Archivo )  { //  LEE ARCHIVO ARCHIVO COLOCANDO SEPARANDO LOS DATOS POR COMAS PARA CADA NODO
        try{
          FileReader Ar =new FileReader(Archivo);
          String cadena=null;
          BufferedReader s =new BufferedReader(Ar);
          while ((cadena=s.readLine())!=null){
             String arr[]=cadena.split(",");
             for(int i=0;i<arr.length;i++){
                incertarFinal((T)arr[i]);
                }
            }
       }catch(Exception e){}
       return Inicio;
    }
    public void RecorrerRecursivo(Nodo<T> Lista){
        if(Lista!=null){
            System.out.print("["+Lista.getDato()+"]<--");
            if(Lista.getSiguiente()!=null){RecorrerRecursivo(Lista.getSiguiente());}
        }
    }
    public void Burbuja(Nodo<T> inf){
       for(int i=0;i<2;i++){
         Nodo<T> Nodo=inf;
         while(Nodo.getSiguiente()!=null){
           if(String.valueOf(Nodo.getDato()).compareTo(String.valueOf(Nodo.getSiguiente().getDato()))>0){
            T aux=Nodo.getDato();
            Nodo.setDato(Nodo.getSiguiente().getDato());
            Nodo.getSiguiente().setDato(aux);
            while(Nodo.getAnterior()!=null){
              Nodo=Nodo.getAnterior();
             }
            }
           Nodo=Nodo.getSiguiente();
                     }
                    }
    }
    public void BurbujaConSeñal(Nodo<T> inf){
       Nodo<T> var1=inf; boolean sts=true;
       while(var1.getSiguiente()!=null){
          if(String.valueOf(var1.getDato()).compareTo(String.valueOf(var1.getSiguiente().getDato()))>0){
            T aux=var1.getDato();
            var1.setDato(var1.getSiguiente().getDato());
            var1.getSiguiente().setDato(aux); 
            sts=false;
           }
          var1=var1.getSiguiente();
        }
       if(sts==false){BurbujaConSeñal(inf);}
         }
    public void ShakerSort(Nodo<T> inf){
       Nodo<T> var1=inf;  Nodo<T> aux=null;  boolean sts=true; 
       while(var1!=null){
          //System.out.println("["+var1.getDato()+"]-->");
          if(var1.getSiguiente()!=null){
             if(String.valueOf(var1.getDato()).compareTo(String.valueOf(var1.getSiguiente().getDato()))>0){
             T z=var1.getDato();
             var1.setDato(var1.getSiguiente().getDato());
             var1.getSiguiente().setDato(z); 
             sts=false;
           }
          }
          aux=var1;
          var1=var1.getSiguiente();
        }
       while(aux.getAnterior()!=null){
          if(String.valueOf(aux.getDato()).compareTo(String.valueOf(aux.getAnterior().getDato()))<0){
            T z=aux.getDato();
            aux.setDato(aux.getAnterior().getDato());
            aux.getAnterior().setDato(z); 
            sts=false;
          }
          var1=aux;
          aux=aux.getAnterior();
        }
       if(sts==false){ShakerSort(var1.getSiguiente());}
     }
     public void InserciónDirecta(Nodo<T> inf){
       Nodo<T> var1=inf;
       while(var1.getSiguiente()!=null){
          if(String.valueOf(var1.getDato()).compareTo(String.valueOf(var1.getSiguiente().getDato()))>0){
            T aux=var1.getDato();
            var1.setDato(var1.getSiguiente().getDato());
            var1.getSiguiente().setDato(aux); 
            while(var1.getAnterior()!=null){
                if(String.valueOf(var1.getDato()).compareTo(String.valueOf(var1.getAnterior().getDato()))<0){
                T z=var1.getDato();
                var1.setDato(var1.getAnterior().getDato());
                var1.getAnterior().setDato(z); 
              }
              var1=var1.getAnterior();
            }
           }
          var1=var1.getSiguiente();
        }
    }
     public void SeleccionDirecta(Nodo<T> inf){
      Nodo<T> Nodo=inf;
      while(Nodo.getSiguiente()!=null){
         T aux=Nodo.getDato();
         T tem=Nodo.getDato();
         Nodo<T> Var2=null;
         Nodo<T> buscar=Nodo.getSiguiente();
         while(buscar!=null){
           if(String.valueOf(tem).compareTo(String.valueOf(buscar.getDato()))>0){
               Var2=buscar; 
               tem=buscar.getDato();
             }
           if(buscar.getSiguiente()==null){
            try{Var2.setDato(aux);}catch(Exception x){}
            Nodo.setDato(tem);
            }
            buscar=buscar.getSiguiente();
             }
         Nodo=Nodo.getSiguiente();
                     }
    }

    public static void main(String []args){
        TiposOrdenacion l=new TiposOrdenacion();
        Nodo lista2=l.leer2("prueba2.txt");
        l.RecorrerRecursivo(lista2);
        System.out.print("\nOrdenacion:");;
            l.Burbuja(lista2);
            //l.BurbujaConSeñal(lista2);
            //l.ShakerSort(lista2);
            //l.InserciónDirecta(lista2);
            //l.SeleccionDirecta(lista2);
        System.out.println();
        l.RecorrerRecursivo(lista2);
    }
}
