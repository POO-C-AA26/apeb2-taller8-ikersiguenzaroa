

/**
 * Problema 3:
 Se desea realizar una aplicación que permita a un periodista deportivo llevar las estadísticas de los jugadores de un equipo de fútbol para poder valorar su actuación en el partido.
Cada jugador se identifica por su nombre, número de dorsal y Rut.
Los jugadores se dividen en tres categorías :
1.	Atacantes
2.	Defensores
3.	Porteros
Para todos los jugadores se desea contabilizar el número de goles marcados, además en el caso de los jugadores de campo se contabilizan los pases realizados con éxito y el número de balones recuperados. En el caso de los porteros se contabilizan las atajadas realizadas.
Valoración del jugador
Cálculo base para todos los jugadores:
•	valor_goles = goles * 30
Valor adicional según tipo de jugador:
1.	Atacantes
o	valor += recuperaciones * 3
2.	Defensores
o	valor += recuperaciones * 4
3.	Porteros
o	valor += atajadas * 5
Nota
Se debe aplicar polimorfismo mediante la aplicación de herencia, encapsulamiento de atributos y comportamientos comunes, y especializar comportamiento según el tipo de jugador.

 * @author Iker
 */

abstract class Jugador {
    public String nombre;
    public int dorsal;
    public String rut;
    public int goles;
    public Jugador(String nombre, int dorsal, String rut) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.rut = rut;
        this.goles = 0;
    }
    public abstract double calcularValoracion();
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Dorsal: " + dorsal + ", RUT: " + rut + ", Goles: " + goles;
    }
}

class JugadorCampo extends Jugador {
    public int pasesExito;
    public int recuperaciones;
    public JugadorCampo(String nombre, int dorsal, String rut) {
        super(nombre, dorsal, rut);
        this.pasesExito = 0;
        this.recuperaciones = 0;
    }
    @Override
    public double calcularValoracion() {
        return (goles * 30) + (recuperaciones * 2) + (pasesExito * 0.1);
    }
    @Override
    public String toString() {
        return super.toString() + ", Pases Exito: " + pasesExito + ", Recuperaciones: " + recuperaciones;
    }
}

class Atacante extends JugadorCampo {
    public Atacante(String nombre, int dorsal, String rut) {
        super(nombre, dorsal, rut);
    }
    @Override
    public double calcularValoracion() {
        return (goles * 30) + (recuperaciones * 3);
    }
    @Override
    public String toString() {
        return "Atacante -> " + super.toString() + ", Valoracion: " + calcularValoracion();
    }
}

class Defensor extends JugadorCampo {
    public Defensor(String nombre, int dorsal, String rut) {
        super(nombre, dorsal, rut);
    }
    @Override
    public double calcularValoracion() {
        return (goles * 30) + (recuperaciones * 4);
    }
    @Override
    public String toString() {
        return "Defensor -> " + super.toString() + ", Valoracion: " + calcularValoracion();
    }
}

class Portero extends Jugador {
    public int atajadas;
    public Portero(String nombre, int dorsal, String rut) {
        super(nombre, dorsal, rut);
        this.atajadas = 0;
    }
    @Override
    public double calcularValoracion() {
        return (goles * 30) + (atajadas * 5);
    }
    @Override
    public String toString() {
        return "Portero -> " + super.toString() + ", Atajadas: " + atajadas + ", Valoracion: " + calcularValoracion();
    }
}

public class Problema_3_EjecutarJuegoDeportivo {
    public static void main(String[] args) {
        Atacante j1 = new Atacante("Moises Caicedo", 7, "12678934-0");
        Defensor j2 = new Defensor("Marco Cucurrela", 17, "22500091-1");
        Portero j3 = new Portero("Hernan Galindez", 1, "11573402-I");
        j1.goles = 4;
        j1.pasesExito = 20;
        j1.recuperaciones = 10;
        j2.goles = 1;
        j2.pasesExito = 50;
        j2.recuperaciones = 10;
        j3.goles = 1;
        j3.atajadas = 9;
        System.out.println("--- ESTADISTICAS DEL PARTIDO ---");
        System.out.println(j1);
        System.out.println(j2);
        System.out.println(j3);
        System.out.println("--------------------------------");
    }
}
/*
run:
--- ESTADISTICAS DEL PARTIDO ---
Atacante -> Nombre: Moises Caicedo, Dorsal: 7, RUT: 12678934-0, Goles: 4, Pases Exito: 20, Recuperaciones: 10, Valoracion: 150.0
Defensor -> Nombre: Marco Cucurrela, Dorsal: 17, RUT: 22500091-1, Goles: 1, Pases Exito: 50, Recuperaciones: 10, Valoracion: 70.0
Portero -> Nombre: Hernan Galindez, Dorsal: 1, RUT: 11573402-I, Goles: 1, Atajadas: 9, Valoracion: 75.0
*/