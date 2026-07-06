

/**
 * Problema 5:
 Una organización local ha creado una plataforma digital para registrar y promover emprendimientos de la ciudad de Loja. 
 * Los emprendimientos pueden clasificarse por tipo (tecnológico, artesanal, agrícola, gastronómico, etc.),
 * y cada uno presenta información detallada sobre su misión, productos o servicios, y datos de contacto. 
 * Algunos emprendimientos requieren acompañamiento técnico por parte de mentores especializados, 
 * quienes brindan asesoría en áreas como marketing, contabilidad o desarrollo de software. Además, 
 * los emprendimientos pueden participar en ferias locales, donde presentan sus productos y compiten por reconocimientos.  Existen emprendimientos que evolucionan a lo largo del tiempo y extienden sus líneas de productos o abren nuevas sedes.
Requisitos funcionales:
Diferenciar los distintos tipos de emprendimientos mediante herencia.
Asociar uno o más mentores a los emprendimientos que lo requieran.
Implementar comportamientos polimórficos en función del tipo de feria o actividad en la que participan.
Permitir registrar productos o servicios que ofrece cada emprendimiento.
Simular la evolución de un emprendimiento con el tiempo (crecimiento, diversificación, expansión).
Note

Plantee una solución polimórfica dada una jerarquía de clases con ventajas de herencia. Para la visualización de resultados use los toString() base.
 * @author Iker
 */
import java.util.ArrayList;

abstract class Emprendimiento {

    public String nombre, mision, servicio;
    public int contanto;
    public ArrayList<Mentor> mentores;
    public int reconocimientosTotales, productosTotales, sedesTotales = 1;
    public String ultimaFeria, ultimaEvolucion;

    public abstract void participarFeria(int reconocimiento, String mensaje);

    public abstract void evolucionar(int producto, int sedesNueavas, String mensaje);

    public Emprendimiento() {
    }

    public Emprendimiento(String nombre, String mision, String servicio, int contanto, ArrayList<Mentor> mentores) {
        this.nombre = nombre;
        this.mision = mision;
        this.servicio = servicio;
        this.contanto = contanto;
        this.mentores = mentores;
    }

    @Override
    public String toString() {
        String texto = "";
        texto += "===================================\n";
        texto += "Emprendimiento : " + nombre + "\n";
        texto += "Mision         : " + mision + "\n";
        texto += "Servicio       : " + servicio + "\n";
        texto += "Contacto       : " + contanto + "\n";
        texto += "Mentores       : " + mentores + "\n";
        texto += "Reconocimientos: " + reconocimientosTotales + "\n";
        texto += "Productos      : " + productosTotales + "\n";
        texto += "Sedes          : " + sedesTotales + "\n";
        texto += "Ultima feria   : " + ultimaFeria + "\n";
        texto += "Ultima evol.   : " + ultimaEvolucion + "\n";
        texto += "===================================";
        return texto;
    }

}

class Mentor {

    public String nombre, areaEspecialidad;

    public Mentor(String nombre, String areaEspecialidad) {
        this.nombre = nombre;
        this.areaEspecialidad = areaEspecialidad;
    }

    @Override
    public String toString() {
        return "Mentor{" + "nombre=" + nombre + ", areaEspecialidad=" + areaEspecialidad + '}';
    }

}

class EmprendimientoTecnologico extends Emprendimiento {

    public String lenguaje;

    public EmprendimientoTecnologico(String lenguaje, String nombre, String mision, String servicio, int contanto, ArrayList<Mentor> mentores) {
        super(nombre, mision, servicio, contanto, mentores);
        this.lenguaje = lenguaje;
    }

    @Override
    public void participarFeria(int reconocimiento, String mensaje) {
        reconocimientosTotales += reconocimiento;
        ultimaFeria = mensaje + " El empredimiento Tecnologico muestra una programa con lenguaje de alto nivel con " + lenguaje + ".";

    }

    @Override
    public void evolucionar(int producto, int sedesNueavas, String mensaje) {
        productosTotales += producto;
        sedesTotales += sedesNueavas;
        ultimaEvolucion = mensaje + " El emprendimiento evoluciono en el area Tecnologica.";
    }

}

class EmprendimientoArtesanal extends Emprendimiento {

    public String tecnicaTradicional;

    public EmprendimientoArtesanal(String tecnicaTradicional, String nombre, String mision, String servicio, int contanto, ArrayList<Mentor> mentores) {
        super(nombre, mision, servicio, contanto, mentores);
        this.tecnicaTradicional = tecnicaTradicional;
    }

    @Override
    public void participarFeria(int reconocimiento, String mensaje) {
        reconocimientosTotales += reconocimiento;
        ultimaFeria = mensaje + " El emprendimiento Artesanal muestra sus artesanias con su tecnica de " + tecnicaTradicional + ".";
    }

    @Override
    public void evolucionar(int producto, int sedesNuevas, String mensaje) {
        productosTotales += producto;
        sedesTotales += sedesNuevas;
        ultimaEvolucion = mensaje + " El emprendimiento evoluciono en el area Artesanal.";
    }
}

class EmprendimientoAgricola extends Emprendimiento {

    public String tipoCultivo;

    public EmprendimientoAgricola(String tipoCultivo, String nombre, String mision, String servicio, int contanto, ArrayList<Mentor> mentores) {
        super(nombre, mision, servicio, contanto, mentores);
        this.tipoCultivo = tipoCultivo;
    }

    @Override
    public void participarFeria(int reconocimiento, String mensaje) {
        reconocimientosTotales += reconocimiento;
        ultimaFeria = mensaje + " El emprendimiento Agricola muestra su produccion de: " + tipoCultivo + ".";
    }

    @Override
    public void evolucionar(int producto, int sedesNuevas, String mensaje) {
        productosTotales += producto;
        sedesTotales += sedesNuevas;
        ultimaEvolucion = mensaje + " El emprendimiento evoluciono en el area Agricola.";
    }
}

class EmprendimientoGastronomico extends Emprendimiento {

    public String enfoqueGastronomico;

    public EmprendimientoGastronomico(String enfoqueGastronomico, String nombre, String mision, String servicio, int contanto, ArrayList<Mentor> mentores) {
        super(nombre, mision, servicio, contanto, mentores);
        this.enfoqueGastronomico = enfoqueGastronomico;
    }

    @Override
    public void participarFeria(int reconocimiento, String mensaje) {
        reconocimientosTotales += reconocimiento;
        ultimaFeria = mensaje + " El emprendimiento Gastronomico muestra su enfoque de platillos de: " + enfoqueGastronomico + ".";
    }

    @Override
    public void evolucionar(int producto, int sedesNuevas, String mensaje) {
        productosTotales += producto;
        sedesTotales += sedesNuevas;
        ultimaEvolucion = mensaje + " El emprendimiento evoluciono en el area Gastronomica.";
    }
}

public class Problema_5_EjecutarPlataformaEmprendimiento {

    public static void main(String[] args) {
        ArrayList<Mentor> mentoresT = new ArrayList<>();
        mentoresT.add(new Mentor("Iker", "Desarrollo de Software"));
        ArrayList<Mentor> mentoresA = new ArrayList<>();
        mentoresA.add(new Mentor("Diego", "contabilidad financiera"));
        ArrayList<Mentor> mentoresAgricola = new ArrayList<Mentor>();
        mentoresAgricola.add(new Mentor("Pedro", "marketing"));
        ArrayList<Mentor> mentoresGastronomico = new ArrayList<Mentor>();
        mentoresAgricola.add(new Mentor("Daniel", "Pasteleria"));
        Emprendimiento tec = new EmprendimientoTecnologico("Java", "La casa LojadaWEB", "Ofrecer toda soluciones de software para negocios locales", "Desarrollo de apps", 986466948, mentoresT);
        Emprendimiento artesanal = new EmprendimientoArtesanal("Tejido en macana", "Manos de Loja", "Preservar la tradicion artesanal lojana", "Venta de bolsos", 970587679, mentoresA);
        Emprendimiento agricola = new EmprendimientoAgricola("Cafeartesanal", "AgroValle", "Producir alimentos organicos y artesanales de buena calidad", "Venta de cafe", 989964753, mentoresAgricola);
        Emprendimiento gastronomico = new EmprendimientoGastronomico("Tradicional lojana", "Sabores del Sur", "Hacerse conocer la gastronomia lojana", "Comida tipica", 914886934, mentoresGastronomico);
        ArrayList<Emprendimiento> emp = new ArrayList<Emprendimiento>();
        emp.add(tec);
        emp.add(artesanal);
        emp.add(agricola);
        emp.add(gastronomico);
        for (Emprendimiento e : emp) {
            e.participarFeria(1, "Participacion en la en la feria de emprendimientos en Loja  periodo 2026-2027.");
            e.evolucionar(1, 0, "Registro una nueva evolucion.");
            System.out.println(e);
        }

    }
}
/*
run:
===================================
Emprendimiento : La casa LojadaWEB
Mision         : Ofrecer toda soluciones de software para negocios locales
Servicio       : Desarrollo de apps
Contacto       : 986466948
Mentores       : [Mentor{nombre=Iker, areaEspecialidad=Desarrollo de Software}]
Reconocimientos: 1
Productos      : 1
Sedes          : 1
Ultima feria   : Participacion en la en la feria de emprendimientos en Loja  periodo 2026-2027. El empredimiento Tecnologico muestra una programa con lenguaje de alto nivel con Java.
Ultima evol.   : Registro una nueva evolucion. El emprendimiento evoluciono en el area Tecnologica.
===================================
===================================
Emprendimiento : Manos de Loja
Mision         : Preservar la tradicion artesanal lojana
Servicio       : Venta de bolsos
Contacto       : 970587679
Mentores       : [Mentor{nombre=Diego, areaEspecialidad=contabilidad financiera}]
Reconocimientos: 1
Productos      : 1
Sedes          : 1
Ultima feria   : Participacion en la en la feria de emprendimientos en Loja  periodo 2026-2027. El emprendimiento Artesanal muestra sus artesanias con su tecnica de Tejido en macana.
Ultima evol.   : Registro una nueva evolucion. El emprendimiento evoluciono en el area Artesanal.
===================================
===================================
Emprendimiento : AgroValle
Mision         : Producir alimentos organicos y artesanales de buena calidad
Servicio       : Venta de cafe
Contacto       : 989964753
Mentores       : [Mentor{nombre=Pedro, areaEspecialidad=marketing}, Mentor{nombre=Daniel, areaEspecialidad=Pasteleria}]
Reconocimientos: 1
Productos      : 1
Sedes          : 1
Ultima feria   : Participacion en la en la feria de emprendimientos en Loja  periodo 2026-2027. El emprendimiento Agricola muestra su produccion de: Cafeartesanal.
Ultima evol.   : Registro una nueva evolucion. El emprendimiento evoluciono en el area Agricola.
===================================
===================================
Emprendimiento : Sabores del Sur
Mision         : Hacerse conocer la gastronomia lojana
Servicio       : Comida tipica
Contacto       : 914886934
Mentores       : []
Reconocimientos: 1
Productos      : 1
Sedes          : 1
Ultima feria   : Participacion en la en la feria de emprendimientos en Loja  periodo 2026-2027. El emprendimiento Gastronomico muestra su enfoque de platillos de: Tradicional lojana.
Ultima evol.   : Registro una nueva evolucion. El emprendimiento evoluciono en el area Gastronomica.
===================================
BUILD SUCCESSFUL (total time: 0 seconds)
*/