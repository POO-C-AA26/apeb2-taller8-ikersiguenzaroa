/**
 Problema01:
En un juego de rol, se desea implementar un sistema de combate en el 
que participen diferentes tipos de personajes: guerreros, magos y arqueros. Cada
personaje tiene atributos y habilidades únicas, así como diferentes métodos de 
ataque y defensa.
El objetivo del juego es enfrentar a los personajes en batallas y determinar el 
ganador en función de sus habilidades, estrategias y atributos. Los guerreros se
destacan por su fuerza y habilidades cuerpo a cuerpo, los magos por sus hechizos
y poderes mágicos, y los arqueros por su precisión y habilidades a distancia.
El sistema debe permitir crear nuevos personajes de cada tipo, asignarles 
atributos iniciales, como puntos de vida y nivel de experiencia, y permitirles 
subir de nivel a medida que ganan batallas. Además, se debe implementar un 
algoritmo de combate que evalúe las habilidades de cada personaje y determine 
el resultado de la batalla.
Utilizando programación orientada a objetos, herencia y polimorfismo, 
implementa el sistema de combate y las clases necesarias para representar a 
los diferentes tipos de personajes. Asegúrate de que cada tipo de personaje 
tenga sus propias habilidades y métodos de ataque y defensa, y que puedan 
interactuar entre sí en las batallas
 * @author Iker
 */
import java.util.Arrays;
import java.util.Random;
abstract class Personaje{
    public int vida;
    public int experiencia;
    public int batallasGanadas;
    public Personaje(int vida) {
        this.vida = vida;
    }
    public abstract boolean ataque(Personaje personaje);
    public abstract boolean defensa(Personaje personaje);
    @Override
    public String toString() {
        return "Personaje{" + "vidas=" + vida + ", xp=" + experiencia + ", victorias=" + batallasGanadas + '}';
    }
    
}
class Guerrero extends Personaje{
    public int fuerza;
    
    public Guerrero(int fuerza, int vidas) {
        super(vidas);
        this.fuerza = fuerza;
    }
    public boolean ataque(Personaje personaje){
        if (vida>0) {
            this.experiencia++;
            personaje.experiencia++;

            Random ale = new Random();
            boolean pelea = ale.nextBoolean();
            if (pelea) {
                this.batallasGanadas++;
                personaje.vida--;
            }else{
                this.vida--;
                personaje.batallasGanadas++;
            }
            return pelea;
        }else{
            
            return false;
        }
    }
    public boolean defensa(Personaje personaje){
        if (vida>0) {
            Random ale = new Random();
            boolean def = ale.nextBoolean();
            if (def) {
                this.vida++;
            }
            return def;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return "Guerrero{" + "fuerza=" + fuerza + '}'+ super.toString();
    }
    

}
class Mago extends Personaje{
    public String[] hechizos;

    public Mago(String[] hechizos, int vidas) {
        super(vidas);
        this.hechizos = hechizos;
    }
    public boolean ataque(Personaje personaje){
        if (vida>0) {
            this.experiencia++;
            personaje.experiencia++;

            Random ale = new Random();
            boolean pelea = ale.nextBoolean();
            if (pelea) {
                this.batallasGanadas++;
                personaje.vida--;
            }else{
                this.vida--;
                personaje.batallasGanadas++;
            }
            return pelea;
        }else{
            
            return false;
        }
    }
    public boolean defensa(Personaje personaje){
        if (vida>0) {
            Random ale = new Random();
            boolean def = ale.nextBoolean();
            if (def) {
                this.vida++;
            }
            return def;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return "Mago{" + "hechizos=" + Arrays.toString(hechizos) + '}'+ super.toString();
    }
}
class Arquero extends Personaje{
    public int precision;
    public Arquero(int precision, int vidas) {
        super(vidas);
        this.precision = precision;
    }
    public boolean ataque(Personaje personaje){
        if (vida>0) {
            this.experiencia++;
            personaje.experiencia++;

            Random ale = new Random();
            boolean pelea = ale.nextBoolean();
            if (pelea) {
                this.batallasGanadas++;
                personaje.vida--;
            }else{
                this.vida--;
                personaje.batallasGanadas++;
            }
            return pelea;
        }else{
            
            return false;
        }
    }
     public boolean defensa(Personaje personaje){
        if (vida>0) {
            Random ale = new Random();
            boolean def = ale.nextBoolean();
            if (def) {
                this.vida++;
            }
            return def;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return "Arquero{" + "precision=" + precision + '}' + super.toString();
    }
} 
public class Problema_1_EjecutarBatalla {
    public static void main(String[] args) {
        String hechizos[]= {"arcoiris","brillitos","campo de flores"};
        Personaje Guerrero = new Guerrero(5,2);
        Personaje Mago = new Mago(hechizos,1);
        Personaje Arquero = new Arquero(4,3);
        
        System.out.println("Resultado de guerrero con arquero: "+Guerrero.ataque(Arquero));
        System.out.println(Arquero);
        System.out.println(Guerrero);
        
        System.out.println("Resultado de guerrero con Mago: "+Guerrero.ataque(Mago));
        if (Guerrero.vida >0) {
        System.out.println(Guerrero);
        System.out.println(Mago);
        }else{
            System.out.println("no se puede pelear porque el guerrero esta muerto");
        }
        
        System.out.println("Resultado de defensa guerrero en su pelea contra arquero: "+ Guerrero.defensa(Arquero));
       if (Guerrero.vida >0) {
        System.out.println(Guerrero);
        System.out.println(Arquero);
        }else{
            System.out.println("no se puede defender porque el guerrero esta muerto");
        }
    }
}
/*
run:
Resultado de guerrero con arquero: false
Arquero{precision=4}Personaje{vidas=3, xp=1, victorias=1}
Guerrero{fuerza=5}Personaje{vidas=1, xp=1, victorias=0}
Resultado de guerrero con Mago: true
Guerrero{fuerza=5}Personaje{vidas=1, xp=2, victorias=1}
Mago{hechizos=[arcoiris, brillitos, campo de flores]}Personaje{vidas=0, xp=1, victorias=0}
Resultado de defensa guerrero en su pelea contra arquero: false
Guerrero{fuerza=5}Personaje{vidas=1, xp=2, victorias=1}
Arquero{precision=4}Personaje{vidas=3, xp=1, victorias=1}
BUILD SUCCESSFUL (total time: 0 seconds)

*/