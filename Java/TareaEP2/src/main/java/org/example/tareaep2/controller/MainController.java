package org.example.tareaep2.controller;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.example.tareaep2.model.Curso;
import org.example.tareaep2.model.CursoCertificado;
import org.example.tareaep2.model.CursoLibre;
import org.example.tareaep2.repository.CursoRepository;
import org.example.tareaep2.repository.PersistenciaException;

public class MainController {

    public final static String CURSOCERTIFICADO  = "Curso Certificado";
    public final static String CURSOLIBRE  = "Curso Libre";


    public final static String MSJ_DEFAULT = "Sin Alerta";
    public final static String MSJ_EXITO = "Registro Exitoso";
    public final static String MSJ_NO_VALIDO = "Dato no valido";
    public final static String MSJ_ELIMINADO = "Registro eliminado";
    public final static String MSJ_NO_SELECCIONADO = "Falta de seleccion";
    public final static String MSJ_LECTURA = "Error al leer archivo";
    public final static String MSJ_ESCRITURA = "Error al escribir archivo";

    private final CursoRepository repository = new CursoRepository();
    private final ObservableList<Curso> cursos = FXCollections.observableArrayList();

    @FXML
    private TextField campoCantInscritos;

    @FXML
    private TextField campoCupMax;

    @FXML
    private TextField campoDurHoras;

    @FXML
    private TextField campoEntidadCert;

    @FXML
    private TextField campoNomCurso;

    @FXML
    private CheckBox checkDiplomaEmitido;

    @FXML
    private CheckBox checkEvFinalDia;

    @FXML
    private TableColumn<Curso, Integer> colCupMax;

    @FXML
    private TableColumn<Curso, Integer> colDur;

    @FXML
    private TableColumn<Curso, String> colNombre;

    @FXML
    private TableColumn<Curso, String> colPrecio;

    @FXML
    private TableColumn<Curso, String> colTipo;

    @FXML
    private Label mensajeEstado;

    @FXML
    private ComboBox<String> selectorTipo;

    @FXML
    private TableView<Curso> tablaCurso;

    @FXML
    void onAgregar(){
        Curso curso;
        try{
            String tipo = this.selectorTipo.getValue();
            String nombre = this.campoNomCurso.getText();
            int duracionHrs = Integer.parseInt(this.campoDurHoras.getText());
            int cupoMax = Integer.parseInt(this.campoCupMax.getText());
            switch (tipo){
                case CURSOCERTIFICADO:
                    String nomEntidadCert = this.campoEntidadCert.getText();
                    boolean diplomaEmitido = this.checkDiplomaEmitido.isSelected();
                    boolean evaluacionDia = this.checkEvFinalDia.isSelected();
                    if(nomEntidadCert.strip().isBlank()){
                        this.setMensaje(MSJ_NO_VALIDO, "Error: el campo nombre no puede quedar vacio");
                        return;
                    }
                    curso = new CursoCertificado(nombre,duracionHrs,cupoMax,evaluacionDia,nomEntidadCert);
                    if(diplomaEmitido){
                        ((CursoCertificado) curso).emitirDiploma();
                    }
                    break;
                case CURSOLIBRE:
                    int cantInscritos = Integer.parseInt(this.campoCantInscritos.getText());
                    if(cantInscritos < 0){
                        this.setMensaje(MSJ_NO_VALIDO, "Error: el campo de inscritos no puede ser inferior a 0");
                        return;
                    }
                    curso = new CursoLibre(nombre,duracionHrs,cupoMax,cantInscritos);
                    break;
                default:
                    this.setMensaje(MSJ_NO_SELECCIONADO,"Por favor, seleccione un tipo de curso para empezar");
                    return;
            }
            try{
                this.repository.registrar(curso);
                this.actualizarTableView();
            }catch (PersistenciaException e){
                this.setMensaje(e.getMessage(), "Error guardando nuevo registro.");
                return;
            }
            this.setMensaje(MSJ_EXITO, "Curso: "+curso.getCodigoCurso() + " agregado correctamente");

        } catch (IllegalArgumentException e){
            this.setMensaje(MSJ_NO_VALIDO, e.getMessage());
        }
    }


    public void onLimpiar() {
        this.setMensaje(MSJ_DEFAULT, "");
        this.checkEvFinalDia.setSelected(false);
        this.checkDiplomaEmitido.setSelected(false);
        this.campoCantInscritos.setText("");
        this.campoEntidadCert.setText("");
        this.campoCupMax.setText("");
        this.campoDurHoras.setText("");
        this.campoNomCurso.setText("");
        this.selectorTipo.setValue("");

    }

    @FXML
    public void onSeleccionarTipo(){
        String tipoCurso = this.selectorTipo.getValue();
        switch (tipoCurso){
            case CURSOCERTIFICADO:
                this.campoCantInscritos.setDisable(true);
                this.campoEntidadCert.setDisable(false);
                this.checkEvFinalDia.setDisable(false);
                this.checkDiplomaEmitido.setDisable(false);
                break;
            case CURSOLIBRE:
                this.campoCantInscritos.setDisable(false);
                this.campoEntidadCert.setDisable(true);
                this.checkEvFinalDia.setDisable(true);
                this.checkDiplomaEmitido.setDisable(true);
                break;
            default:
                this.campoCantInscritos.setDisable(true);
                this.campoEntidadCert.setDisable(true);
                this.checkEvFinalDia.setDisable(true);
                this.checkDiplomaEmitido.setDisable(true);
                this.setMensaje(MSJ_NO_SELECCIONADO, "Por favor, seleccione un tipo de curso.");
                break;
        }
    }


    @FXML
    public void initialize() {
        this.selectorTipo.getItems().add(CURSOLIBRE);
        this.selectorTipo.getItems().add(CURSOCERTIFICADO);

        this.checkDiplomaEmitido.setDisable(true);
        this.checkEvFinalDia.setDisable(true);
        this.campoEntidadCert.setDisable(true);
        this.campoCantInscritos.setDisable(true);

        this.configurarTableView();
        try {
            this.repository.cargar();
            this.actualizarTableView();
        } catch (PersistenciaException e) {
            this.setMensaje(e.getMessage(), "Error en la carga inicial. Reinicie el programa e intente nuevamente");
        }
    }




    public void configurarTableView(){
        this.colTipo.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getTipo()));
        this.colNombre.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getCodigoCurso()));
        this.colCupMax.setCellValueFactory(celda-> new ReadOnlyObjectWrapper<>(celda.getValue().getCupoMaximo()));
        this.colDur.setCellValueFactory(celda -> new ReadOnlyObjectWrapper<>(celda.getValue().getDuracionHoras()));
        this.colPrecio.setCellValueFactory(celda -> new ReadOnlyStringWrapper(Curso.pesos(celda.getValue().calcularPrecio())));
        this.tablaCurso.setItems(this.cursos);


    }

    public void actualizarTableView(){
        cursos.setAll(repository.listar());
    }

    private void setMensaje(String tipo, String mensaje){
        if(mensaje.trim().isBlank()){
            mensaje = tipo;
        }else{
            mensaje = tipo + ": " + mensaje;
        }
        switch (tipo){
            case MSJ_EXITO:
            case MSJ_ELIMINADO:
                this.mensajeEstado.setVisible(true);
                this.mensajeEstado.setTextFill(Color.GREEN);
                break;
            case MSJ_NO_VALIDO:
            case MSJ_NO_SELECCIONADO:
            case MSJ_ESCRITURA:
            case MSJ_LECTURA:
                this.mensajeEstado.setVisible(true);
                this.mensajeEstado.setTextFill(Color.RED);
                break;
            default:
                this.mensajeEstado.setVisible(false);
                this.mensajeEstado.setTextFill(Color.BLACK);
        }
        this.mensajeEstado.setText(mensaje);
    }

    @FXML
    void onEliminar() {
        Curso seleccion = this.tablaCurso.getSelectionModel().getSelectedItem();
        if(seleccion == null){
            this.setMensaje(MSJ_NO_SELECCIONADO, "Error: debe seleccionar algo para proceder con la eliminacion");
            return;
        }
        try {
            if (!this.repository.eliminar(seleccion)) {
                this.setMensaje(MSJ_NO_VALIDO, "Error: no se pudo eliminar.");
                this.actualizarTableView();
                return;
            }
        }catch(PersistenciaException e){
            this.setMensaje(MSJ_ESCRITURA, "Error: No se pudo guardar el cambio.");
            return;
        }
        this.actualizarTableView();
        this.setMensaje(MSJ_ELIMINADO, "");

    }



}
