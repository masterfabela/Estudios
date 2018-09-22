/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxectoalarma;

/**
 *
 * @author femio23
 */
public class Display {
    static boolean modoalarma=true;
    /**
     *Metodo para imprimir a hora actual do reloxo.
     */
    public static void showhora(){
        System.out.println("Hora actual "+Config.hora.getHours()+":"+Config.hora.getMinutes()+":"+Config.hora.getSeconds());
    }
    /**
     * Metodo para imprimir a hora da alarma do reloxo.
     */
    public static void showhalarma(){
        System.out.println("Alarma actual "+Config.halarma.getHours()+":"+Config.halarma.getMinutes()+":"+Config.halarma.getSeconds());
    }
    /**
     * Metodo para cambiar o modo de visualización do reloxo.
     */
    public static void cambiovista(){
        if(!isModoalarma()){
            setModoalarma(true);
        }else{
            setModoalarma(false);
        }
    }
    /**
     * Metodo de consulta da variable modo alarma.
     * @return devolverase true, cando o reloxo estea en modo alarma, e false cando estea en modo hora actual.
     */
    public static boolean isModoalarma() {
        return modoalarma;
    }
/**
 * setter para a variable modoalarma.
 * @param modoalarma cambia o valor da variable por o valor introducido.
 */
    public static void setModoalarma(boolean modoalarma) {
        Display.modoalarma = modoalarma;
    }
    
    /**
     * Metodo que en función do modo de visualización, imprime ou a hora ou a a alarma.
     */
    public static void visualizar(){
        if(!isModoalarma()){
            showhora();
        }else{
            showhalarma();
        }
    }
}
