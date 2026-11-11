package stevens.ej05.repository;

import stevens.ej05.dao.ParticipanteDao;
import stevens.ej05.dao.PersistenciaException;
import stevens.ej05.model.Entrenador;
import stevens.ej05.model.Jugador;
import stevens.ej05.model.Participante;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de Participante.
 *
 * TODO: mantén la colección en memoria y delega la lectura/escritura en los DAO.
 * Regla de oro: guarda primero en los DAO y solo después actualiza la lista.
 */
public class ParticipanteRepository implements JsonRepository<Participante> {

    private final ParticipanteDao daoJugadores;
    private final ParticipanteDao daoEntrenadores;
    private final List<Participante> elementos = new ArrayList<>();

    public ParticipanteRepository(ParticipanteDao daoJugadores, ParticipanteDao daoEntrenadores) {
        this.daoJugadores = daoJugadores;
        this.daoEntrenadores = daoEntrenadores;
    }

    @Override
    public void cargar() throws PersistenciaException {
       List<Participante> participantes = new ArrayList<>();
       participantes.clear();
       participantes.addAll(daoEntrenadores.cargar());
       participantes.addAll(daoJugadores.cargar());
    }

    @Override
    public List<Participante> listar() {
        return new ArrayList<>(elementos);
    }

    @Override
    public void agregar(Participante elemento) throws PersistenciaException {
        List<Participante> copia = new ArrayList<>(elementos);
        copia.add(elemento);
        guardarPorTipo(copia);
        elementos.addAll(copia);
    }

    @Override
    public void eliminar(Participante elemento) throws PersistenciaException {
       List<Participante> copia = new ArrayList<>(elementos);
       copia.remove(elemento);
       guardarPorTipo(copia);
       elementos.remove(copia);
    }

    private void guardarPorTipo(List<Participante> todos) throws PersistenciaException {
        List<Participante> entrenadores = new ArrayList<>();
        List<Participante> jugadores = new ArrayList<>();
        for (Participante participante : todos) {
            if (participante instanceof Entrenador) {
                entrenadores.add(participante);

            }else if (participante instanceof Jugador) {
                jugadores.add(participante);
            }
        }
        daoEntrenadores.guardar(entrenadores);
        daoEntrenadores.guardar(jugadores);

    }
}
