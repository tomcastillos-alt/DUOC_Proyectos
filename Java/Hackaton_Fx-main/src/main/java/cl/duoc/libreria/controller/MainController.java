package cl.duoc.libreria.controller;

import cl.duoc.libreria.model.Libro;
import cl.duoc.libreria.model.Publicacion;
import cl.duoc.libreria.model.Revista;
import cl.duoc.libreria.repository.PersistenciaException;
import cl.duoc.libreria.repository.RepositoryLibro;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MainController {

    private final RepositoryLibro repositorio = new RepositoryLibro();
    private final ObservableList<Publicacion> publicacions = FXCollections.observableArrayList();
    public final static String LIBRO = "Libro";
    public final static String REVISTA = "Revista";


    @FXML
    private TextField campoAntiguedad;

    @FXML
    private TextField campoAutor;

    @FXML
    private TextField campoCantidad;

    @FXML
    private CheckBox campoListo;

    @FXML
    private TextField campoNumero;

    @FXML
    private TextField campoPaginas;

    @FXML
    private CheckBox campoTapaDura;

    @FXML
    private TextField campoTitulo;

    @FXML
    private TableColumn<Publicacion, Integer> colCantidad;

    @FXML
    private TableColumn<Publicacion, String> colDatos;

    @FXML
    private TableColumn<Publicacion, Integer> colPaginas;

    @FXML
    private TableColumn<Publicacion, Integer> colPrecio;

    @FXML
    private TableColumn<Publicacion, String> colTipo;

    @FXML
    private TableColumn<Publicacion, String> colTitulo;

    @FXML
    private Label lblAlerta;

    @FXML
    private GridPane selTipo;

    @FXML
    private ComboBox<String> selectorTipo;

    @FXML
    private TableView<Publicacion> tablaLibreria;

    @FXML
    void onAgregar() {
        Publicacion publi;
        try{
            String tipo = this.selectorTipo.getValue();
        if (tipo == null || tipo.isBlank()){
            setMensaje("Seleccione tipo de curso", true);
            return;
        }
        String nombre = this.campoTitulo.getText().strip();
        if(nombre.isBlank()){
            setMensaje("El nombre de la publicacion no puede quedar vacio", true);
        }
        int paginas = Integer.parseInt(this.campoPaginas.getText().strip());
        if(paginas < 1 || paginas > 1500){
            setMensaje("Error: el numero de paginas debe estar entre 1 y 1500", true);
            return;
        }
        int cantidad = Integer.parseInt(this.campoCantidad.getText().strip());
        if(cantidad < 1 || cantidad > 300){
            setMensaje("Error: la cantidad debe se superior a 1 y menor a 300", true);
        }
        switch(tipo){
            case LIBRO:
                String autor = this.campoAutor.getText().strip();
                if(autor.isBlank()){
                    setMensaje("Error: El campo autor no puede quedar vacio", true);
                    return;
                }
                boolean tapa = this.campoTapaDura.isSelected();
                publi = new Libro(nombre,paginas,cantidad,autor,tapa);
                break;
            case REVISTA:
                int numero = Integer.parseInt(this.campoNumero.getText().strip());
                boolean devolucion = this.campoListo.isSelected();
                if(numero < 1 || numero > 99){
                    setMensaje("Error: el numero debe ser superior a 1 e inferior a 99", true);
                return;
                }
                int antiguedad = Integer.parseInt(this.campoAntiguedad.getText().strip());
                if(antiguedad < 0 || antiguedad > 120){
                    setMensaje("Error: la antiguedad debe estar entre 0 y 120 meses", true);
                    return;
                }
                publi = new Revista(nombre,paginas,cantidad,numero,antiguedad);
                if(devolucion)
                    ((Revista) publi).estaListaParaDevolucion();
                break;
            default:
                this.setMensaje("Seleccione un tipo para continuar", true);
                return;
        }
        try {
            this.repositorio.registrar(publi);
            this.actualizarTableView();
        }catch(PersistenciaException e){
            this.setMensaje(e.getMessage(), true);
            return;
        }
        this.setMensaje("Registrado con exito", false);
            }catch(PersistenciaException e){
            this.setMensaje("Campos no validos, intente nuevamente", true);

        }

    }

    @FXML
    void onEliminar() {
        Publicacion seleccion = tablaLibreria.getSelectionModel().getSelectedItem();
        if(seleccion == null){
            this.setMensaje("Error: seleccione algo para eliminar", true);
            return;
        }
        try{
            if(!this.repositorio.eliminar(seleccion)){
                this.setMensaje("Error: no se pudo eliminar", true);
                this.actualizarTableView();
                return;
        }
        }catch (PersistenciaException e){
            this.setMensaje("Error: no se pudo guardar la eliminacion", true);
            return;
        }
        this.actualizarTableView();
        this.setMensaje("Eliminado correctamente", false);

    }

    @FXML
    void onLimpiar() {
        this.campoTitulo.clear();
        this.campoTapaDura.setDisable(false);
        this.campoAutor.clear();
        this.campoNumero.clear();
        this.campoAntiguedad.clear();
        this.campoCantidad.clear();
        this.campoPaginas.clear();
        this.campoListo.setDisable(false);

    }

    public void onSeleccionarTipo(){
        String tipoPublicacion = this.selectorTipo.getValue();
        switch(tipoPublicacion){
            case LIBRO:
                this.campoAntiguedad.setDisable(true);
                this.campoNumero.setDisable(true);
                this.campoAutor.setDisable(false);
                this.campoTapaDura.setDisable(false);
                break;
            case REVISTA:
                this.campoAntiguedad.setDisable(false);
                this.campoNumero.setDisable(false);
                this.campoAutor.setDisable(true);
                this.campoTapaDura.setDisable(true);
                break;
            default:
                this.campoAntiguedad.setDisable(true);
                this.campoNumero.setDisable(true);
                this.campoAutor.setDisable(true);
                this.campoTapaDura.setDisable(true);
                break;
        }
    }

    public void initialize(){
        this.selectorTipo.getItems().add(LIBRO);
        this.selectorTipo.getItems().add(REVISTA);

        this.campoTapaDura.setDisable(true);
        this.campoAutor.setDisable(true);
        this.campoAntiguedad.setDisable(true);
        this.campoNumero.setDisable(true);

        this.configurarTableView();
        try{
            this.repositorio.cargar();
            this.actualizarTableView();
        }catch(PersistenciaException e){
            this.setMensaje(e.getMessage(),true);
        }

    }

    public void actualizarTableView(){
        publicacions.setAll(repositorio.listar());

    }

    public void setMensaje(String mensaje, boolean esError){
        lblAlerta.setText(mensaje == null ? "" : mensaje);
        lblAlerta.setTextFill(esError ? Color.RED : Color.GREEN);
        lblAlerta.setVisible(mensaje != null && !mensaje.isBlank());
    }

    public void configurarTableView(){
        this.colTitulo.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getTitulo()));
        this.colCantidad.setCellValueFactory(celda -> new ReadOnlyObjectWrapper<>(celda.getValue().getCantidad()));
        this.colPaginas.setCellValueFactory(celda -> new ReadOnlyObjectWrapper<>(celda.getValue().getPaginas()));
        this.colTipo.setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getTipo()));
        this.colPrecio.setCellValueFactory(celda -> new ReadOnlyObjectWrapper<>(celda.getValue().calcularPrecio()));
        this.colDatos.setCellValueFactory(celda -> new ReadOnlyObjectWrapper<>(celda.getValue().toString()));
        this.tablaLibreria.setItems(this.publicacions);
    }


}
