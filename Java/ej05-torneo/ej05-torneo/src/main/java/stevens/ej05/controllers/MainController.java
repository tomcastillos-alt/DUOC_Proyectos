package stevens.ej05.controllers;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import stevens.ej05.dao.PersistenciaException;
import stevens.ej05.model.Entrenador;
import stevens.ej05.model.Jugador;
import stevens.ej05.model.Participante;
import stevens.ej05.repository.ParticipanteRepository;

/**
 * Controlador de la vista principal del torneo.
 *
 * TODO: completa initialize(), los manejadores y el cálculo del puntaje total.
 * Los @FXML ya declaran los controles que debe tener la vista; usa los mismos
 * fx:id en Scene Builder.
 */
public class MainController {
    public final static String ENTRENADOR = "Entrenador";
    public final static String JUGADOR = "Jugador";

    @FXML
    private ComboBox<String> cmbTipo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEquipo;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNickname;

    @FXML
    private TextField txtRol;

    @FXML
    private TextField txtPartidasGanadas;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtAniosExperiencia;

    @FXML
    private Label lblNickname;

    @FXML
    private Label lblRol;

    @FXML
    private Label lblPartidasGanadas;

    @FXML
    private Label lblEspecialidad;

    @FXML
    private Label lblAniosExperiencia;

    @FXML
    private Label lblMensaje;

    @FXML
    private Label lblPuntajeTotal;

    @FXML
    private TableView<Participante> tblParticipantes;

    @FXML
    private TableColumn<Participante, String> colTipo;

    @FXML
    private TableColumn<Participante, String> colNombre;

    @FXML
    private TableColumn<Participante, String> colEquipo;

    @FXML
    private TableColumn<Participante, Integer> colEdad;

    @FXML
    private TableColumn<Participante, Integer> colPuntaje;

    @FXML
    private TableColumn<Participante, String> colDatosEspecificos;

    private final ObservableList<Participante> participantes = FXCollections.observableArrayList();
    private ParticipanteRepository participanteRepo;

    private String datosEspecificos(Participante participante) {
        if (participante instanceof Jugador jugador) {
            return "nick" +jugador.getNickname()+"\nrol "+jugador.getRol()+"\npartidos"+jugador.getPartidasGanadas();
        } else if (participante instanceof Entrenador entrenador) {
            return entrenador.getEspecialidad()+"\naños"+entrenador.getAniosExperiencia();
        }
        return "";
    }


    @FXML
    public void initialize() {
        this.cmbTipo.getItems().add(ENTRENADOR);
        this.cmbTipo.getItems().add(JUGADOR);
        this.txtAniosExperiencia.setDisable(true);
        this.txtEdad.setDisable(true);
        this.txtEquipo.setDisable(true);
        this.txtEspecialidad.setDisable(true);
        this.txtNickname.setDisable(true);




        this.configurarTableView();
        try{
            this.participanteRepo.cargar();
            this.actualizarTableView();
        }catch (PersistenciaException e){
            this.mostrarMensaje(e.getMessage(), false);
        }

        // TODO 1: crear participanteRepo con dos GsonParticipanteDao:
        //         new ParticipanteRepository(
        //             new GsonParticipanteDao(Paths.JUGADORES, Jugador.class),
        //             new GsonParticipanteDao(Paths.ENTRENADORES, Entrenador.class));
        // TODO 2: configurar las columnas con ReadOnlyObjectWrapper.
        // TODO 3: tblParticipantes.setItems(participantes);
        // TODO 4: cmbTipo.getItems().addAll("Jugador", "Entrenador") y mostrar el primer tipo.
        // TODO 5: cargar los datos con participanteRepo.cargar() y refrescar la tabla.
    }

    @FXML
    public void cmbTipoCambio(ActionEvent event) {
        // TODO: mostrar solo los campos del subtipo seleccionado.
    }

    @FXML
    public void btnRegistrar(ActionEvent event) {
        // TODO: validar, crear Jugador o Entrenador, llamar a agregar(...) y refrescar.
    }

    @FXML
    public void btnEliminar(ActionEvent event) {
        // TODO: comprobar que haya una fila seleccionada, eliminar y refrescar.
    }

    private void actualizarPuntajeTotal() {
        // TODO: sumar participante.calcularPuntaje() y mostrarlo en lblPuntajeTotal.
    }

    private void mostrarMensaje(String texto, boolean exito) {
        if (lblMensaje != null){
            lblMensaje.setText(texto);
        }
    }

    public void configurarTableView(){
        this.colDatosEspecificos.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getTipo()));
        this.colEdad.setCellValueFactory(celda -> new ReadOnlyObjectWrapper<>(celda.getValue().getEdad()));
        this.colEquipo.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getEquipo()));
        this.colNombre.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getNombre()));
        this.colTipo.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getTipo()));
        this.colPuntaje.setCellValueFactory(celda -> new ReadOnlyObjectWrapper<>(celda.getValue().calcularPuntaje()));
        this.tblParticipantes.setItems(this.participantes);
    }

    public void actualizarTableView(){
        participantes.setAll(participanteRepo.listar());
    }
}
