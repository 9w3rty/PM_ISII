/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexión.SQL_Conexión;
import Controlador.Gestor_Cliente;
import Controlador.Gestor_Materia_Prima;
import Controlador.Gestor_Producción;
import Controlador.Gestor_Producto;
import Controlador.Gestor_Variedad_MateriaPrima;
import Controlador.Gestor_Venta;
import Modelo.FFecha;
import Modelo.MP_ViewModel;
import Modelo.Producto;
import Modelo.Variedad_MP;
import com.sun.glass.events.KeyEvent;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josek
 */

public class MenuPrincipal extends javax.swing.JFrame {

    private String codActualSeleccionado="";
    private String nomActualSeleccionado="";
    private float totalPagar=0;
    private ArrayList codigos=new ArrayList();
    private int filaSeleccionada=-1;
    private int clienteSeleccionado=-1;
    private int contFilasSeleccionadas=0;
    
    private float subTotalAnt=0;
    private float sumar=0;
    
    private String nomAnterior="";
    private String codAnterior="";
    private int filaSeleccionadaCambiar=-1;
    
    FFecha ffecha = new FFecha();
    String auxF,auxL;
    ResultSet rs=null;
    Gestor_Producción gp;
    DefaultTableModel modelo;
    /**
     * Creates new form MenuPrincipal
     */
    
    private DefaultTableModel modeloVentaAcumulado;
    
    public MenuPrincipal() {
        initComponents();
        
        JP_info_Productos.removeAll();
        JP_info_Productos.add(JP_Alta_Producto);
        JP_info_Productos.repaint();
        JP_info_Productos.revalidate();
        
        JTF_Nombre_Producto.requestFocus();
        
        mostrarPlaceholder();
        
        cargarTablaProductos_Venta();
        cargarTablaClientes_Venta();
        cargarTablaVentasAcumulado_Venta();
        
        JTF_Nombre_Producto.requestFocus();
        //JTF_NCodigo_Producto.setEditable(false);
        JTF_NCodigo_Producto.setEnabled(false);
    }
    
    private void cargarTablaVentasAcumulado_Venta() {
        modeloVentaAcumulado = new DefaultTableModel();
        
        modeloVentaAcumulado.addColumn("Código");
        modeloVentaAcumulado.addColumn("Nombre");
        modeloVentaAcumulado.addColumn("Precio");
        modeloVentaAcumulado.addColumn("Cantidad");
        modeloVentaAcumulado.addColumn("Subtotal");
        
        
        JT_Ventas_Acumulado.setModel( modeloVentaAcumulado );
    }
    
    private void cargarTablaClientes_Venta() {
        DefaultTableModel modelo1 = new DefaultTableModel();
        
        modelo1.addColumn("Nro. Cliente");
        modelo1.addColumn("Nombre");
        modelo1.addColumn("Dirección");
        modelo1.addColumn("Teléfono");
        modelo1.addColumn("DNI");
        
        JT_Ventas_Clientes.setModel(modelo1);
        
        ResultSet rs = Gestor_Cliente.getClientes();
        String []Datos = new String [5];
        
        try {
            while ( rs.next() ) {
                Datos[0] = rs.getString(5);
                Datos[1] = rs.getString(1);
                Datos[2] = rs.getString(2);
                Datos[3] = rs.getString(3);
                Datos[4] = rs.getString(4);
                
                modelo1.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarTabla() {
        // Muestra la tabla de productos
        DefaultTableModel modelo = new DefaultTableModel();        
        modelo.addColumn("Nombre");
        modelo.addColumn("Código");
        
        JTB_Productos.setModel(modelo);
        
        cargarProductosEnTabla(modelo);
    }
    
    private void cargarTablaProductos_Venta() {
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Código");
        
        JT_Ventas_Productos.setModel(modelo);
        
        cargarProductosEnTabla(modelo);
    }
    
    private void mostrarPlaceholder() {
        //Texto de ayuda para rellenar los campos
        TextPrompt placeholder = new TextPrompt("Nombre del Producto", JTF_Nombre_Producto);
        placeholder.changeAlpha(0.75f);
        placeholder.changeStyle(Font.ITALIC);
        
        TextPrompt placeholder1 = new TextPrompt("Código del Producto", JTF_Codigo_Producto);
        placeholder1.changeAlpha(0.75f);
        placeholder1.changeStyle(Font.ITALIC);
        
        TextPrompt placeholder2 = new TextPrompt("Número de Lote", JTF_Producciones_NLote);
        placeholder2.changeAlpha(0.75f);
        placeholder2.changeStyle(Font.ITALIC);
        
        TextPrompt placeholder_1 = new TextPrompt("Refine su búsqueda por nombre de Producto", JTF_Filtro_Producto);
        placeholder_1.changeAlpha(0.75f);
        placeholder_1.changeStyle(Font.ITALIC);
        
        TextPrompt placeholder_2 = new TextPrompt("Refine su búsqueda por nombre de Cliente", JTF_Filtro_Cliente);
        placeholder_2.changeAlpha(0.75f);
        placeholder_2.changeStyle(Font.ITALIC);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        BG_Buscar_Producciones = new javax.swing.ButtonGroup();
        JTB_Menu = new javax.swing.JTabbedPane();
        JP_Productos = new javax.swing.JPanel();
        JP_botones_Productos = new javax.swing.JPanel();
        JB_Alta_Producto = new javax.swing.JButton();
        JB_Cambiar_Producto = new javax.swing.JButton();
        JB_Baja_Producto = new javax.swing.JButton();
        JP_info_Productos = new javax.swing.JPanel();
        JP_Cambiar_Producto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Productos = new javax.swing.JTable();
        JL_Info_en_cambiar = new javax.swing.JLabel();
        JL_NNombre = new javax.swing.JLabel();
        JL_NCodigo = new javax.swing.JLabel();
        JTF_NNombre_Producto = new javax.swing.JTextField();
        JTF_NCodigo_Producto = new javax.swing.JTextField();
        JB_Aceptar_CambiarProducto = new javax.swing.JButton();
        JB_Limpiar_CambiarProducto = new javax.swing.JButton();
        LF_Info_CambiarProducto2 = new javax.swing.JLabel();
        JP_Baja_Producto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTB_Productos1 = new javax.swing.JTable();
        JL_Info_Baja = new javax.swing.JLabel();
        JB_Eliminar = new javax.swing.JButton();
        JB_Cancelar_Eliminar = new javax.swing.JButton();
        JP_Alta_Producto = new javax.swing.JPanel();
        JL_Nombre_Producto = new javax.swing.JLabel();
        JL_Codigo_Producto = new javax.swing.JLabel();
        JTF_Nombre_Producto = new javax.swing.JTextField();
        JTF_Codigo_Producto = new javax.swing.JTextField();
        JB_Aceptar_NuevoProducto = new javax.swing.JButton();
        JB_Cancelar_NuevoProdu = new javax.swing.JButton();
        JP_MateriaPrima = new javax.swing.JPanel();
        JP_Variedades = new javax.swing.JPanel();
        JP_Proveedores = new javax.swing.JPanel();
        JP_Ventas = new javax.swing.JPanel();
        JP_botones_Ventas = new javax.swing.JPanel();
        JB_Ventas_ComenzarVenta = new javax.swing.JButton();
        JP_info_Ventas = new javax.swing.JPanel();
        JP_Comenzar_Venta = new javax.swing.JPanel();
        JL_info_Venta1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JT_Ventas_Productos = new javax.swing.JTable();
        JTF_Filtro_Producto = new javax.swing.JTextField();
        JL_info_Venta2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JT_Ventas_Acumulado = new javax.swing.JTable();
        JL_SignoARS = new javax.swing.JLabel();
        JL_info_Venta3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JT_Ventas_Clientes = new javax.swing.JTable();
        JTF_Filtro_Cliente = new javax.swing.JTextField();
        JB_Ventas_Finalizar = new javax.swing.JButton();
        JTF_Ventas_Cancelar = new javax.swing.JButton();
        JB_Quitar_Producto = new javax.swing.JButton();
        JP_Producciones = new javax.swing.JPanel();
        JP_botones_Producciones = new javax.swing.JPanel();
        JB_Buscar_Producciones = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        JP_info_Producciones = new javax.swing.JPanel();
        JP_Buscar_Producción = new javax.swing.JPanel();
        jOPTB_BPF = new javax.swing.JRadioButton();
        JBO_Buscar_Produccion_Lote = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        JB_Producciones_Aceptar_Busqueda = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JT_Producciones = new javax.swing.JTable();
        JTF_Producciones_NLote = new javax.swing.JTextField();
        JDC_Producciones_BuscarFecha = new com.toedter.calendar.JDateChooser();
        JP_Cargar_Produccion = new javax.swing.JPanel();
        JL_Seleccione_un_Producto = new javax.swing.JLabel();
        JL_seleccione_variedad = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        JT_Produ_StockActual_MP = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        JT_Produ_Variedad = new javax.swing.JTable();
        JDC_Cargaar_Produ_fecha = new com.toedter.calendar.JDateChooser();
        JL_Cargar_Produ_fecha = new javax.swing.JLabel();
        JL_Produ_Sel_MP = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        JT_Produ_NuevoStock_MP = new javax.swing.JTable();
        JB_Produ_CargarProduccion = new javax.swing.JButton();
        JB_Produ_Cancelar_Produccion = new javax.swing.JButton();
        JL_Produ_indique_cantxprodu = new javax.swing.JLabel();
        JTF_Produ_CantProduxProducto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        JDC_Produ_Vencimiento_fecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        JFT_Produ_LoteProduccion = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        JT_Produ_Productos = new javax.swing.JTable();
        JP_Clientes = new javax.swing.JPanel();
        JP_Botones_Ventas = new javax.swing.JPanel();
        JB_Nuevo_Cliente = new javax.swing.JButton();
        JB_Eliminar_Cliente = new javax.swing.JButton();
        JB_Modificar_Cliente = new javax.swing.JButton();
        JP_info_Clientes = new javax.swing.JPanel();
        JP_Agregar_Cliente = new javax.swing.JPanel();
        JL_Ingrese_DNI = new javax.swing.JLabel();
        JL_Ingrese_DOM = new javax.swing.JLabel();
        JL_Ingrese_NOM = new javax.swing.JLabel();
        JL_Ingrese_TEL = new javax.swing.JLabel();
        JTF_Ingrese_DNI = new javax.swing.JTextField();
        JTF_Ingrese_DOM = new javax.swing.JTextField();
        JTF_Ingrese_NOM = new javax.swing.JTextField();
        JTF_Ingrese_TEL = new javax.swing.JTextField();
        JB_Ingresar_Cliente_Aceptar = new javax.swing.JButton();
        JB_Ingresar_Cliente_Cancelar = new javax.swing.JButton();
        JP_Eliminar_Cliente = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        JP_Modificar_Cliente = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JT_Modificar_Cliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1366, 768));

        JTB_Menu.setBackground(new java.awt.Color(245, 250, 166));
        JTB_Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_MenuMouseClicked(evt);
            }
        });

        JP_Productos.setLayout(new java.awt.BorderLayout());

        JP_botones_Productos.setBackground(new java.awt.Color(245, 250, 166));
        JP_botones_Productos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JB_Alta_Producto.setText("Nuevo Producto");
        JB_Alta_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Alta_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Alta_ProductoActionPerformed(evt);
            }
        });

        JB_Cambiar_Producto.setText("Cambiar Producto");
        JB_Cambiar_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Cambiar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Cambiar_ProductoActionPerformed(evt);
            }
        });

        JB_Baja_Producto.setText("Eliminar Producto");
        JB_Baja_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Baja_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Baja_ProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_botones_ProductosLayout = new javax.swing.GroupLayout(JP_botones_Productos);
        JP_botones_Productos.setLayout(JP_botones_ProductosLayout);
        JP_botones_ProductosLayout.setHorizontalGroup(
            JP_botones_ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_botones_ProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_botones_ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_botones_ProductosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JB_Cambiar_Producto))
                    .addGroup(JP_botones_ProductosLayout.createSequentialGroup()
                        .addGroup(JP_botones_ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_Alta_Producto)
                            .addComponent(JB_Baja_Producto))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        JP_botones_ProductosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JB_Alta_Producto, JB_Baja_Producto, JB_Cambiar_Producto});

        JP_botones_ProductosLayout.setVerticalGroup(
            JP_botones_ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_botones_ProductosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(JB_Alta_Producto)
                .addGap(67, 67, 67)
                .addComponent(JB_Cambiar_Producto)
                .addGap(67, 67, 67)
                .addComponent(JB_Baja_Producto)
                .addContainerGap(576, Short.MAX_VALUE))
        );

        JP_Productos.add(JP_botones_Productos, java.awt.BorderLayout.LINE_START);

        JP_info_Productos.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        JP_info_Productos.setLayout(new java.awt.CardLayout());

        JTB_Productos = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        JTB_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTB_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_ProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Productos);

        JL_Info_en_cambiar.setText("Los campos dejados en blanco serán rellenados automáticamente.");

        JL_NNombre.setText("Ingrese el nuevo Nombre del Producto:");

        JL_NCodigo.setText("Ingrese el nuevo Código del Producto:");

        JTF_NCodigo_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_NCodigo_ProductoActionPerformed(evt);
            }
        });
        JTF_NCodigo_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTF_NCodigo_ProductoKeyTyped(evt);
            }
        });

        JB_Aceptar_CambiarProducto.setText("Aceptar");
        JB_Aceptar_CambiarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Aceptar_CambiarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Aceptar_CambiarProductoActionPerformed(evt);
            }
        });

        JB_Limpiar_CambiarProducto.setText("Cancelar");
        JB_Limpiar_CambiarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Limpiar_CambiarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Limpiar_CambiarProductoActionPerformed(evt);
            }
        });

        LF_Info_CambiarProducto2.setText("Seleccione un Producto para realizarle una modificación:");

        javax.swing.GroupLayout JP_Cambiar_ProductoLayout = new javax.swing.GroupLayout(JP_Cambiar_Producto);
        JP_Cambiar_Producto.setLayout(JP_Cambiar_ProductoLayout);
        JP_Cambiar_ProductoLayout.setHorizontalGroup(
            JP_Cambiar_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Cambiar_ProductoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(JL_Info_en_cambiar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Cambiar_ProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Cambiar_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_NNombre)
                    .addComponent(JL_NCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 501, Short.MAX_VALUE)
                .addGroup(JP_Cambiar_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JP_Cambiar_ProductoLayout.createSequentialGroup()
                        .addComponent(JB_Aceptar_CambiarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JB_Limpiar_CambiarProducto))
                    .addComponent(JTF_NNombre_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_NCodigo_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(289, 289, 289))
            .addGroup(JP_Cambiar_ProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(JP_Cambiar_ProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LF_Info_CambiarProducto2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_Cambiar_ProductoLayout.setVerticalGroup(
            JP_Cambiar_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Cambiar_ProductoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(LF_Info_CambiarProducto2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JL_Info_en_cambiar)
                .addGap(18, 18, 18)
                .addGroup(JP_Cambiar_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Cambiar_ProductoLayout.createSequentialGroup()
                        .addComponent(JL_NNombre)
                        .addGap(18, 18, 18)
                        .addComponent(JL_NCodigo))
                    .addGroup(JP_Cambiar_ProductoLayout.createSequentialGroup()
                        .addComponent(JTF_NNombre_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_NCodigo_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(JP_Cambiar_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Aceptar_CambiarProducto)
                    .addComponent(JB_Limpiar_CambiarProducto))
                .addContainerGap(218, Short.MAX_VALUE))
        );

        JP_info_Productos.add(JP_Cambiar_Producto, "card4");

        JTB_Productos1 = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        JTB_Productos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTB_Productos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_Productos1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTB_Productos1);

        JL_Info_Baja.setText("Seleccine un Producto para eliminarlo:");

        JB_Eliminar.setText("Eliminar");
        JB_Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_EliminarActionPerformed(evt);
            }
        });

        JB_Cancelar_Eliminar.setText("Cancelar");
        JB_Cancelar_Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Cancelar_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Cancelar_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Baja_ProductoLayout = new javax.swing.GroupLayout(JP_Baja_Producto);
        JP_Baja_Producto.setLayout(JP_Baja_ProductoLayout);
        JP_Baja_ProductoLayout.setHorizontalGroup(
            JP_Baja_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Baja_ProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_Eliminar)
                .addGap(87, 87, 87)
                .addComponent(JB_Cancelar_Eliminar)
                .addGap(246, 246, 246))
            .addGroup(JP_Baja_ProductoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(JP_Baja_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
                    .addGroup(JP_Baja_ProductoLayout.createSequentialGroup()
                        .addComponent(JL_Info_Baja)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_Baja_ProductoLayout.setVerticalGroup(
            JP_Baja_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Baja_ProductoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(JL_Info_Baja)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addGroup(JP_Baja_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Eliminar)
                    .addComponent(JB_Cancelar_Eliminar))
                .addGap(86, 86, 86))
        );

        JP_info_Productos.add(JP_Baja_Producto, "card3");

        JL_Nombre_Producto.setText("Ingrese el Nombre del Producto:");

        JL_Codigo_Producto.setText("Ingrese el Código del Producto:");

        JTF_Codigo_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTF_Codigo_ProductoKeyTyped(evt);
            }
        });

        JB_Aceptar_NuevoProducto.setText("Aceptar");
        JB_Aceptar_NuevoProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Aceptar_NuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Aceptar_NuevoProductoActionPerformed(evt);
            }
        });

        JB_Cancelar_NuevoProdu.setText("Limpiar");
        JB_Cancelar_NuevoProdu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Cancelar_NuevoProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Cancelar_NuevoProduActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Alta_ProductoLayout = new javax.swing.GroupLayout(JP_Alta_Producto);
        JP_Alta_Producto.setLayout(JP_Alta_ProductoLayout);
        JP_Alta_ProductoLayout.setHorizontalGroup(
            JP_Alta_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Alta_ProductoLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(JP_Alta_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Nombre_Producto)
                    .addComponent(JL_Codigo_Producto))
                .addGap(194, 194, 194)
                .addGroup(JP_Alta_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JP_Alta_ProductoLayout.createSequentialGroup()
                        .addComponent(JB_Aceptar_NuevoProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(JB_Cancelar_NuevoProdu))
                    .addComponent(JTF_Codigo_Producto)
                    .addComponent(JTF_Nombre_Producto))
                .addContainerGap(582, Short.MAX_VALUE))
        );
        JP_Alta_ProductoLayout.setVerticalGroup(
            JP_Alta_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Alta_ProductoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(JP_Alta_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Nombre_Producto)
                    .addComponent(JTF_Nombre_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(JP_Alta_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Codigo_Producto)
                    .addComponent(JTF_Codigo_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 549, Short.MAX_VALUE)
                .addGroup(JP_Alta_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Aceptar_NuevoProducto)
                    .addComponent(JB_Cancelar_NuevoProdu))
                .addGap(85, 85, 85))
        );

        JP_info_Productos.add(JP_Alta_Producto, "card2");

        JP_Productos.add(JP_info_Productos, java.awt.BorderLayout.CENTER);

        JTB_Menu.addTab("Productos", JP_Productos);

        javax.swing.GroupLayout JP_MateriaPrimaLayout = new javax.swing.GroupLayout(JP_MateriaPrima);
        JP_MateriaPrima.setLayout(JP_MateriaPrimaLayout);
        JP_MateriaPrimaLayout.setHorizontalGroup(
            JP_MateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1441, Short.MAX_VALUE)
        );
        JP_MateriaPrimaLayout.setVerticalGroup(
            JP_MateriaPrimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
        );

        JTB_Menu.addTab("Materia Prima", JP_MateriaPrima);

        javax.swing.GroupLayout JP_VariedadesLayout = new javax.swing.GroupLayout(JP_Variedades);
        JP_Variedades.setLayout(JP_VariedadesLayout);
        JP_VariedadesLayout.setHorizontalGroup(
            JP_VariedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1441, Short.MAX_VALUE)
        );
        JP_VariedadesLayout.setVerticalGroup(
            JP_VariedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
        );

        JTB_Menu.addTab("Variedades", JP_Variedades);

        javax.swing.GroupLayout JP_ProveedoresLayout = new javax.swing.GroupLayout(JP_Proveedores);
        JP_Proveedores.setLayout(JP_ProveedoresLayout);
        JP_ProveedoresLayout.setHorizontalGroup(
            JP_ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1441, Short.MAX_VALUE)
        );
        JP_ProveedoresLayout.setVerticalGroup(
            JP_ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
        );

        JTB_Menu.addTab("Proveedores", JP_Proveedores);

        JP_Ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JP_VentasMouseClicked(evt);
            }
        });
        JP_Ventas.setLayout(new java.awt.BorderLayout());

        JP_botones_Ventas.setBackground(new java.awt.Color(245, 249, 167));
        JP_botones_Ventas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JP_botones_Ventas.setPreferredSize(new java.awt.Dimension(163, 712));

        JB_Ventas_ComenzarVenta.setText("Comenzar Venta");
        JB_Ventas_ComenzarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Ventas_ComenzarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Ventas_ComenzarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_botones_VentasLayout = new javax.swing.GroupLayout(JP_botones_Ventas);
        JP_botones_Ventas.setLayout(JP_botones_VentasLayout);
        JP_botones_VentasLayout.setHorizontalGroup(
            JP_botones_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_botones_VentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JB_Ventas_ComenzarVenta)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        JP_botones_VentasLayout.setVerticalGroup(
            JP_botones_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_botones_VentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JB_Ventas_ComenzarVenta)
                .addContainerGap(770, Short.MAX_VALUE))
        );

        JP_Ventas.add(JP_botones_Ventas, java.awt.BorderLayout.LINE_START);

        JP_info_Ventas.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        JP_info_Ventas.setLayout(new java.awt.CardLayout());

        JL_info_Venta1.setText("Seleccione un Producto para añadir al carrito:");

        JT_Ventas_Productos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        JT_Ventas_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Código"
            }
        ));
        JT_Ventas_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_Ventas_ProductosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JT_Ventas_Productos);

        JTF_Filtro_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Filtro_ProductoActionPerformed(evt);
            }
        });

        JL_info_Venta2.setText("Carrito:");

        JT_Ventas_Acumulado = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if (colIndex==3) return true;
                return false;
            }
        };
        JT_Ventas_Acumulado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Cantidad", "Subtotal"
            }
        ));
        JT_Ventas_Acumulado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_Ventas_AcumuladoMouseClicked(evt);
            }
        });
        JT_Ventas_Acumulado.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JT_Ventas_AcumuladoPropertyChange(evt);
            }
        });
        JT_Ventas_Acumulado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JT_Ventas_AcumuladoKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(JT_Ventas_Acumulado);

        JL_SignoARS.setText("Total:                  $ 0,00");

        JL_info_Venta3.setText("Selecionar Cliente:");

        JT_Ventas_Clientes = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        JT_Ventas_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nro. Cliente", "Nombre", "Dirección", "Teléfono", "DNI"
            }
        ));
        JT_Ventas_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JT_Ventas_ClientesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(JT_Ventas_Clientes);

        JB_Ventas_Finalizar.setText("Registrar venta");
        JB_Ventas_Finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Ventas_Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Ventas_FinalizarActionPerformed(evt);
            }
        });

        JTF_Ventas_Cancelar.setText("Cancelar venta");
        JTF_Ventas_Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JTF_Ventas_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Ventas_CancelarActionPerformed(evt);
            }
        });

        JB_Quitar_Producto.setText("Quitar producto");
        JB_Quitar_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Quitar_ProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Comenzar_VentaLayout = new javax.swing.GroupLayout(JP_Comenzar_Venta);
        JP_Comenzar_Venta.setLayout(JP_Comenzar_VentaLayout);
        JP_Comenzar_VentaLayout.setHorizontalGroup(
            JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                        .addComponent(JTF_Filtro_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                        .addGroup(JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                                .addGroup(JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                                        .addComponent(JB_Ventas_Finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(210, 210, 210)
                                        .addComponent(JTF_Ventas_Cancelar))
                                    .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                                        .addComponent(JL_info_Venta1)
                                        .addGap(375, 375, 375)
                                        .addComponent(JL_info_Venta2))
                                    .addComponent(JTF_Filtro_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                                .addGroup(JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                    .addComponent(JL_info_Venta3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(133, 133, 133)
                                .addGroup(JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                                        .addComponent(JB_Quitar_Producto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JL_SignoARS, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))))
                        .addGap(93, 93, 93))))
        );
        JP_Comenzar_VentaLayout.setVerticalGroup(
            JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                        .addComponent(JL_info_Venta1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTF_Filtro_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Comenzar_VentaLayout.createSequentialGroup()
                        .addComponent(JL_info_Venta2)
                        .addGap(49, 49, 49)))
                .addGroup(JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Comenzar_VentaLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JL_info_Venta3)
                            .addComponent(JL_SignoARS)
                            .addComponent(JB_Quitar_Producto)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(JTF_Filtro_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(JP_Comenzar_VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Ventas_Finalizar)
                    .addComponent(JTF_Ventas_Cancelar))
                .addContainerGap(183, Short.MAX_VALUE))
        );

        JP_info_Ventas.add(JP_Comenzar_Venta, "card7");

        JP_Ventas.add(JP_info_Ventas, java.awt.BorderLayout.CENTER);

        JTB_Menu.addTab("Ventas", JP_Ventas);

        JP_Producciones.setLayout(new java.awt.BorderLayout());

        JP_botones_Producciones.setBackground(new java.awt.Color(245, 249, 167));
        JP_botones_Producciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JP_botones_Producciones.setPreferredSize(new java.awt.Dimension(163, 712));

        JB_Buscar_Producciones.setText("Buscar");
        JB_Buscar_Producciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Buscar_Producciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Buscar_ProduccionesActionPerformed(evt);
            }
        });

        jButton5.setText("Cargar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_botones_ProduccionesLayout = new javax.swing.GroupLayout(JP_botones_Producciones);
        JP_botones_Producciones.setLayout(JP_botones_ProduccionesLayout);
        JP_botones_ProduccionesLayout.setHorizontalGroup(
            JP_botones_ProduccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_botones_ProduccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_botones_ProduccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JB_Buscar_Producciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        JP_botones_ProduccionesLayout.setVerticalGroup(
            JP_botones_ProduccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_botones_ProduccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JB_Buscar_Producciones)
                .addGap(34, 34, 34)
                .addComponent(jButton5)
                .addContainerGap(711, Short.MAX_VALUE))
        );

        JP_Producciones.add(JP_botones_Producciones, java.awt.BorderLayout.LINE_START);

        JP_info_Producciones.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        JP_info_Producciones.setLayout(new java.awt.CardLayout());

        BG_Buscar_Producciones.add(jOPTB_BPF);
        jOPTB_BPF.setText("Por Fecha");

        BG_Buscar_Producciones.add(JBO_Buscar_Produccion_Lote);
        JBO_Buscar_Produccion_Lote.setText("Por Número de Lote");
        JBO_Buscar_Produccion_Lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBO_Buscar_Produccion_LoteActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione un parámetro de búsqueda y complete la información correspondiente:");

        JB_Producciones_Aceptar_Busqueda.setText("Aceptar");
        JB_Producciones_Aceptar_Busqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Producciones_Aceptar_Busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Producciones_Aceptar_BusquedaActionPerformed(evt);
            }
        });

        JT_Producciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(JT_Producciones);

        JTF_Producciones_NLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Producciones_NLoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Buscar_ProducciónLayout = new javax.swing.GroupLayout(JP_Buscar_Producción);
        JP_Buscar_Producción.setLayout(JP_Buscar_ProducciónLayout);
        JP_Buscar_ProducciónLayout.setHorizontalGroup(
            JP_Buscar_ProducciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Buscar_ProducciónLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(JP_Buscar_ProducciónLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(JP_Buscar_ProducciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_Producciones_Aceptar_Busqueda)
                    .addComponent(jLabel1)
                    .addGroup(JP_Buscar_ProducciónLayout.createSequentialGroup()
                        .addGroup(JP_Buscar_ProducciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOPTB_BPF)
                            .addComponent(JDC_Producciones_BuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126)
                        .addGroup(JP_Buscar_ProducciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBO_Buscar_Produccion_Lote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTF_Producciones_NLote))))
                .addContainerGap(776, Short.MAX_VALUE))
        );
        JP_Buscar_ProducciónLayout.setVerticalGroup(
            JP_Buscar_ProducciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Buscar_ProducciónLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(JP_Buscar_ProducciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jOPTB_BPF)
                    .addComponent(JBO_Buscar_Produccion_Lote))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Buscar_ProducciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTF_Producciones_NLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDC_Producciones_BuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(JB_Producciones_Aceptar_Busqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        JP_info_Producciones.add(JP_Buscar_Producción, "card2");

        JL_Seleccione_un_Producto.setText("Seleccione un Producto:");

        JL_seleccione_variedad.setText("Seleccione una Variedad:");

        JT_Produ_StockActual_MP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(JT_Produ_StockActual_MP);

        JT_Produ_Variedad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(JT_Produ_Variedad);

        JL_Cargar_Produ_fecha.setText("Seleccione la fecha del día de Producción: ");

        JL_Produ_Sel_MP.setText("Seleccione la materia prima utilizada:");

        jLabel11.setText("Indique la cantidad de materia prima utilizada, modificando el campo \"Cantidad\".");

        JT_Produ_NuevoStock_MP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane12.setViewportView(JT_Produ_NuevoStock_MP);

        JB_Produ_CargarProduccion.setText("Aceptar");

        JB_Produ_Cancelar_Produccion.setText("Cancelar");

        JL_Produ_indique_cantxprodu.setText("Indique la cantidad producidad:");

        jLabel9.setText("Seleccione la fecha de vencimiento:");

        jLabel10.setText("Ingrese le Lote para la producción:");

        JT_Produ_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(JT_Produ_Productos);

        javax.swing.GroupLayout JP_Cargar_ProduccionLayout = new javax.swing.GroupLayout(JP_Cargar_Produccion);
        JP_Cargar_Produccion.setLayout(JP_Cargar_ProduccionLayout);
        JP_Cargar_ProduccionLayout.setHorizontalGroup(
            JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Cargar_ProduccionLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_Cargar_ProduccionLayout.createSequentialGroup()
                        .addComponent(JL_Produ_indique_cantxprodu)
                        .addGap(82, 82, 82)
                        .addComponent(JTF_Produ_CantProduxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JB_Produ_CargarProduccion)
                    .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Cargar_ProduccionLayout.createSequentialGroup()
                                .addComponent(JL_Cargar_Produ_fecha)
                                .addGap(112, 112, 112)
                                .addComponent(JDC_Cargaar_Produ_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JL_Seleccione_un_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JL_Produ_Sel_MP, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JP_Cargar_ProduccionLayout.createSequentialGroup()
                        .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(JB_Produ_Cancelar_Produccion)
                            .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(JP_Cargar_ProduccionLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JDC_Produ_Vencimiento_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                                .addComponent(JL_seleccione_variedad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(52, 52, 52))
                    .addGroup(JP_Cargar_ProduccionLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JFT_Produ_LoteProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        JP_Cargar_ProduccionLayout.setVerticalGroup(
            JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Cargar_ProduccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JDC_Cargaar_Produ_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JP_Cargar_ProduccionLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9))
                    .addComponent(JDC_Produ_Vencimiento_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JL_Cargar_Produ_fecha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35)
                .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_seleccione_variedad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_Seleccione_un_Producto))
                .addGap(18, 18, 18)
                .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Produ_Sel_MP)
                    .addComponent(jLabel11))
                .addGap(46, 46, 46)
                .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Produ_indique_cantxprodu)
                    .addComponent(JTF_Produ_CantProduxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(JFT_Produ_LoteProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(JP_Cargar_ProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Produ_CargarProduccion)
                    .addComponent(JB_Produ_Cancelar_Produccion))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        JP_info_Producciones.add(JP_Cargar_Produccion, "card3");

        JP_Producciones.add(JP_info_Producciones, java.awt.BorderLayout.CENTER);

        JTB_Menu.addTab("Producciones", JP_Producciones);

        JP_Clientes.setLayout(new java.awt.BorderLayout());

        JP_Botones_Ventas.setPreferredSize(new java.awt.Dimension(163, 720));

        JB_Nuevo_Cliente.setText("Nuevo Cliente");

        JB_Eliminar_Cliente.setText("Eliminar Cliente");

        JB_Modificar_Cliente.setText("Cambiar Cliente");

        javax.swing.GroupLayout JP_Botones_VentasLayout = new javax.swing.GroupLayout(JP_Botones_Ventas);
        JP_Botones_Ventas.setLayout(JP_Botones_VentasLayout);
        JP_Botones_VentasLayout.setHorizontalGroup(
            JP_Botones_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Botones_VentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Botones_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JB_Eliminar_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_Modificar_Cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(JB_Nuevo_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP_Botones_VentasLayout.setVerticalGroup(
            JP_Botones_VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Botones_VentasLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(JB_Nuevo_Cliente)
                .addGap(54, 54, 54)
                .addComponent(JB_Modificar_Cliente)
                .addGap(46, 46, 46)
                .addComponent(JB_Eliminar_Cliente)
                .addContainerGap(585, Short.MAX_VALUE))
        );

        JP_Clientes.add(JP_Botones_Ventas, java.awt.BorderLayout.LINE_START);

        JP_info_Clientes.setLayout(new java.awt.CardLayout());

        JL_Ingrese_DNI.setText("Ingrese el D.N.I:");

        JL_Ingrese_DOM.setText("Ingrese el Domicilio:");

        JL_Ingrese_NOM.setText("Ingrese el Nombre:");

        JL_Ingrese_TEL.setText("Ingrese el Teléfono:");

        JB_Ingresar_Cliente_Aceptar.setText("Aceptar");
        JB_Ingresar_Cliente_Aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JB_Ingresar_Cliente_Cancelar.setText("Cancelar");
        JB_Ingresar_Cliente_Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout JP_Agregar_ClienteLayout = new javax.swing.GroupLayout(JP_Agregar_Cliente);
        JP_Agregar_Cliente.setLayout(JP_Agregar_ClienteLayout);
        JP_Agregar_ClienteLayout.setHorizontalGroup(
            JP_Agregar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Agregar_ClienteLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JP_Agregar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JL_Ingrese_DNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JL_Ingrese_DOM, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(JL_Ingrese_NOM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JL_Ingrese_TEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(91, 91, 91)
                .addGroup(JP_Agregar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JP_Agregar_ClienteLayout.createSequentialGroup()
                        .addComponent(JB_Ingresar_Cliente_Aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addComponent(JB_Ingresar_Cliente_Cancelar))
                    .addComponent(JTF_Ingrese_DNI)
                    .addComponent(JTF_Ingrese_DOM)
                    .addComponent(JTF_Ingrese_NOM)
                    .addComponent(JTF_Ingrese_TEL))
                .addContainerGap(698, Short.MAX_VALUE))
        );
        JP_Agregar_ClienteLayout.setVerticalGroup(
            JP_Agregar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Agregar_ClienteLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(JP_Agregar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Ingrese_DNI)
                    .addComponent(JTF_Ingrese_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(JP_Agregar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Ingrese_DOM)
                    .addComponent(JTF_Ingrese_DOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(JP_Agregar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Ingrese_NOM)
                    .addComponent(JTF_Ingrese_NOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(JP_Agregar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Ingrese_TEL)
                    .addComponent(JTF_Ingrese_TEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(JP_Agregar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Ingresar_Cliente_Aceptar)
                    .addComponent(JB_Ingresar_Cliente_Cancelar))
                .addContainerGap(413, Short.MAX_VALUE))
        );

        JP_info_Clientes.add(JP_Agregar_Cliente, "card4");

        jLabel8.setText("Seleccione el Cliente que desea elminar:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(jTable1);

        jButton3.setText("Aceptar");

        jButton4.setText("Cancelar");

        javax.swing.GroupLayout JP_Eliminar_ClienteLayout = new javax.swing.GroupLayout(JP_Eliminar_Cliente);
        JP_Eliminar_Cliente.setLayout(JP_Eliminar_ClienteLayout);
        JP_Eliminar_ClienteLayout.setHorizontalGroup(
            JP_Eliminar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Eliminar_ClienteLayout.createSequentialGroup()
                .addGroup(JP_Eliminar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Eliminar_ClienteLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(JP_Eliminar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JP_Eliminar_ClienteLayout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(jButton3)
                        .addGap(90, 90, 90)
                        .addComponent(jButton4)))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        JP_Eliminar_ClienteLayout.setVerticalGroup(
            JP_Eliminar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Eliminar_ClienteLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                .addGroup(JP_Eliminar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(211, 211, 211))
        );

        JP_info_Clientes.add(JP_Eliminar_Cliente, "card3");

        JT_Modificar_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(JT_Modificar_Cliente);

        jLabel2.setText("Seleccione un Cliente para cambiar sus datos:");

        jLabel3.setText("Ingrese el nuevo Nombre:");

        jLabel4.setText("Ingrese el nuevo D.N.I:");

        jLabel5.setText("Ingrese el nuevo Domicilio:");

        jLabel6.setText("Ingrese el nuevo Teléfono:");

        jLabel7.setText("Los campos se rellenerán automáticamente con los datos del Cliente seleccionado.");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jButton1.setText("Aceptar");

        jButton2.setText("jButton2");

        javax.swing.GroupLayout JP_Modificar_ClienteLayout = new javax.swing.GroupLayout(JP_Modificar_Cliente);
        JP_Modificar_Cliente.setLayout(JP_Modificar_ClienteLayout);
        JP_Modificar_ClienteLayout.setHorizontalGroup(
            JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Modificar_ClienteLayout.createSequentialGroup()
                .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Modificar_ClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(JP_Modificar_ClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(JP_Modificar_ClienteLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGap(76, 76, 76)
                        .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JP_Modificar_ClienteLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4))))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        JP_Modificar_ClienteLayout.setVerticalGroup(
            JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Modificar_ClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(JP_Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        JP_info_Clientes.add(JP_Modificar_Cliente, "card2");

        JP_Clientes.add(JP_info_Clientes, java.awt.BorderLayout.CENTER);

        JTB_Menu.addTab("Clientes", JP_Clientes);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTB_Menu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTB_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 747, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_Alta_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Alta_ProductoActionPerformed
        // TODO add your handling code here:
        JP_info_Productos.removeAll();
        JP_info_Productos.add(JP_Alta_Producto);
        JP_info_Productos.repaint();
        JP_info_Productos.revalidate();
    }//GEN-LAST:event_JB_Alta_ProductoActionPerformed

    public static void cargarProductosEnTabla(DefaultTableModel modelo) {
        ResultSet rs = Gestor_Producto.getProductos();
        String []Datos = new String [2];
        
        try {
            while ( rs.next() ) {
                Datos[0]=rs.getString(1);
                Datos[1]=rs.getString(2);
                
                modelo.addRow(Datos);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void JB_Cambiar_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Cambiar_ProductoActionPerformed
        // TODO add your handling code here:
        JP_info_Productos.removeAll();
        JP_info_Productos.add(JP_Cambiar_Producto);
        JP_info_Productos.repaint();
        JP_info_Productos.revalidate();
       
        cargarTabla();
    }//GEN-LAST:event_JB_Cambiar_ProductoActionPerformed

    private void cargarTablaEliminar() {
        DefaultTableModel modelo = new DefaultTableModel();        
        modelo.addColumn("Nombre");
        modelo.addColumn("Código");
        
        JTB_Productos1.setModel(modelo);
        
        cargarProductosEnTabla(modelo);
    }
    
    private void JB_Baja_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Baja_ProductoActionPerformed
        // TODO add your handling code here:
        JP_info_Productos.removeAll();
        JP_info_Productos.add(JP_Baja_Producto);
        JP_info_Productos.repaint();
        JP_info_Productos.revalidate(); 
        
        cargarTablaEliminar();
    }//GEN-LAST:event_JB_Baja_ProductoActionPerformed

    private void JBO_Buscar_Produccion_LoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBO_Buscar_Produccion_LoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBO_Buscar_Produccion_LoteActionPerformed

    private void JB_Buscar_ProduccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Buscar_ProduccionesActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        JP_info_Producciones.removeAll();
        JP_info_Producciones.add(JP_Buscar_Producción);
        JP_info_Producciones.repaint();
        JP_info_Producciones.revalidate();
    }//GEN-LAST:event_JB_Buscar_ProduccionesActionPerformed

    private void JTF_Producciones_NLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Producciones_NLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_Producciones_NLoteActionPerformed

    private void actualizarJLabelTotal(float total) {
        String str = "";
        
        str = String.format("Total: $ %.2f", total);
        
        JL_SignoARS.setText(str);
    }
    
    private void iniciarVenta() {
        clienteSeleccionado=-1;
        contFilasSeleccionadas=0;
        
        cargarTablaProductos_Venta();
        cargarTablaClientes_Venta();
        cargarTablaVentasAcumulado_Venta();
        
        codigos=new ArrayList();
        
        totalPagar = 0;
        
        actualizarJLabelTotal(totalPagar);
    }
    
    private void JB_Ventas_ComenzarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Ventas_ComenzarVentaActionPerformed
        // TODO add your handling code here:
        iniciarVenta();
    }//GEN-LAST:event_JB_Ventas_ComenzarVentaActionPerformed

    private void resetCampos() {
        JTF_Nombre_Producto.setText("");
        JTF_Codigo_Producto.setText("");
        JTF_Nombre_Producto.requestFocus();
    }
    
    private void JB_Aceptar_NuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Aceptar_NuevoProductoActionPerformed
        // TODO add your handling code here:
        
        String errorMessage="";
        boolean camposCorrectos=false;
        
        if ( JTF_Nombre_Producto.getText().length() == 0 ) {
            errorMessage+="Nombre\n";
        }
        
        if ( JTF_Codigo_Producto.getText().length() == 0 ) {
            errorMessage+="Código\n";
        }
        
        if ( errorMessage.length() == 0 ) {
            camposCorrectos=true;
        }
        else {
            errorMessage="Faltan ingresar los siguientes campos:\n\n" + errorMessage + "\n";
            JOptionPane.showMessageDialog(null, errorMessage);
            JTF_Nombre_Producto.requestFocus();
        }
        
        if (camposCorrectos) {
            String nombre = JTF_Nombre_Producto.getText();
            String cod = JTF_Codigo_Producto.getText();

            Producto p = new Producto(nombre, cod);

            boolean exito = Gestor_Producto.altaProducto(p);

            if ( exito ) {
                String datos= "Código: " + cod + "\nNombre: " + nombre;

                // Mostramos el éxito de la operación
                JOptionPane.showMessageDialog(null, "Alta del nuevo producto exitosa: \n\n" + datos +"\n\n" );
                resetCampos();
            }
        }
        
    }//GEN-LAST:event_JB_Aceptar_NuevoProductoActionPerformed

    private void JB_Cancelar_NuevoProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Cancelar_NuevoProduActionPerformed
        // TODO add your handling code here:
        resetCampos();
        JTF_Nombre_Producto.requestFocus();
    }//GEN-LAST:event_JB_Cancelar_NuevoProduActionPerformed

    private void JTB_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_ProductosMouseClicked
        // TODO add your handling code here:
        int row = JTB_Productos.rowAtPoint(evt.getPoint());
        filaSeleccionadaCambiar=row;
        
        String codigo="";
        String nombre="";
        
        // SI HAY AL MENOS UNA FILA SELECCIONADA
        if (row >= 0)
        {
            nombre=JTB_Productos.getValueAt(row, 0).toString();
            codigo=JTB_Productos.getValueAt(row, 1).toString();
        }
 
        JTF_NNombre_Producto.setText(nombre);
        JTF_NCodigo_Producto.setText(codigo);
        
        codActualSeleccionado = codigo;
    }//GEN-LAST:event_JTB_ProductosMouseClicked

    private void resetCamposModificar() {
        JTF_NNombre_Producto.setText("");
        JTF_NCodigo_Producto.setText("");
    }
    
    private void JB_Limpiar_CambiarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Limpiar_CambiarProductoActionPerformed
        // TODO add your handling code here:
        resetCamposModificar();
        cargarTabla();
    }//GEN-LAST:event_JB_Limpiar_CambiarProductoActionPerformed

    private void JB_Aceptar_CambiarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Aceptar_CambiarProductoActionPerformed
        // TODO add your handling code here:
        
        boolean camposRepetidos=false;
        boolean camposCorrectos=false;
        
        String codRepetido="Código repetido\n";
        String nomRepetido="Nombre repetido\n";
        
        String repetidos="";
        int contCambios=0;
        
        // FLUJO NORMAL
            if ( JTF_NCodigo_Producto.getText().length()!=0 && JTF_NNombre_Producto.getText().length()!=0 ) {
                camposCorrectos=true;
            }

            if (camposCorrectos) {
                
                if (filaSeleccionadaCambiar>=0) {
                    codAnterior=JTB_Productos.getValueAt(filaSeleccionadaCambiar, 1).toString();
                    nomAnterior=JTB_Productos.getValueAt(filaSeleccionadaCambiar, 0).toString();
                }

                System.out.println("COD ANTERIOR: " + codAnterior);
                System.out.println("NOM ANTERIOR: " + nomAnterior+"\n");
                
                if (codAnterior.equals( JTF_NCodigo_Producto.getText() )) {
                    camposRepetidos=true;
                    repetidos+=codRepetido;
                }
                else {
                    contCambios++;
                }

                if (nomAnterior.equals( JTF_NNombre_Producto.getText() )) {
                    camposRepetidos=true;
                    repetidos+=nomRepetido;
                }
                else {
                    contCambios++;
                }

                if (contCambios==0) {
                    //JOptionPane.showMessageDialog(rootPane, "Se encontraron los siguiente campos repetidos:\n\n" + repetidos + "\n");
                    JOptionPane.showMessageDialog(rootPane, "No se han registrado cambios\n");
                }
                else {
                    Producto nuevoProducto = new Producto();

                    nuevoProducto.setCodigo( JTF_NCodigo_Producto.getText() );
                    nuevoProducto.setNombre( JTF_NNombre_Producto.getText() );

                    boolean exito = Gestor_Producto.actualizarProducto(codActualSeleccionado, nuevoProducto);

                    if (exito) {
                        String datos= "Nombre: " + JTF_NNombre_Producto.getText() + "\nCódigo: " + JTF_NCodigo_Producto.getText();

                        // Mostramos el éxito de la operación
                        JOptionPane.showMessageDialog(null, "Actualización exitosa del nuevo producto: \n\n" + datos +"\n\n" );
                        resetCamposModificar();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Actualizacion NO exitosa, revise los campos" );
                    }
                    
                    cargarTabla();
                    filaSeleccionadaCambiar=-1;
                }
                
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Actualización fallida!\n\nRevise los campos ingresados\n\n");
                cargarTabla();
                filaSeleccionadaCambiar=-1;
            }
            
    }//GEN-LAST:event_JB_Aceptar_CambiarProductoActionPerformed

    private void JTB_Productos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Productos1MouseClicked
        // TODO add your handling code here:
        int row = JTB_Productos1.rowAtPoint(evt.getPoint());
        
        // SI HAY AL MENOS UNA FILA SELECCIONADA
        if (row >= 0)
        {
            nomActualSeleccionado=JTB_Productos1.getValueAt(row, 0).toString();
            codActualSeleccionado=JTB_Productos1.getValueAt(row, 1).toString();
        }
    }//GEN-LAST:event_JTB_Productos1MouseClicked

    private void reiniciarTablasProductos() {
        cargarTablaEliminar();
        cargarTablaProductos_Venta();
        cargarTabla();
    }
    
    private void JB_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_EliminarActionPerformed
        // TODO add your handling code here:
        
        if (!codActualSeleccionado.equals("") && !nomActualSeleccionado.equals("")) {
            String cartel = "Desea eliminar el siguiente producto?\n\n";
               cartel += "Nombre: " + nomActualSeleccionado  + "\n";
               cartel += "Código: " + codActualSeleccionado + "\n\n";
        
            int n = JOptionPane.showConfirmDialog (
                null,
                cartel,"Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

            if(n == JOptionPane.YES_OPTION){
                // Eliminar producto
                if (Gestor_Producto.bajaProducto(codActualSeleccionado)) {
                    JOptionPane.showMessageDialog(null, "El producto con código:\n\n Código: "+ codActualSeleccionado +" \n\nFue dado de baja exitosamente\n\n");
                }

                reiniciarTablasProductos();
            }
            else {
                //JOptionPane.showMessageDialog(null, "No se ha eliminado el producto\n\n");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un producto para eliminar\n");
        }
        
    }//GEN-LAST:event_JB_EliminarActionPerformed
    
    //"Caso de uso Buscar Produccion"
    private void JB_Producciones_Aceptar_BusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Producciones_Aceptar_BusquedaActionPerformed
        // TODO add your handling code here:
                if(jOPTB_BPF.isSelected()){
            
            auxF = ffecha.getFecha(JDC_Producciones_BuscarFecha);
            rs=Gestor_Producción.consultaProduccionFecha(auxF);
            construir_tabla(rs);
        }
        else{
            if(JBO_Buscar_Produccion_Lote.isSelected()){
                if(JTF_Producciones_NLote.getText().length()<10){
                    JOptionPane.showMessageDialog(rootPane,"Númer0 de lote debe tener 10 Caracteres" );
                }else{
                    auxL = JTF_Producciones_NLote.getText();
                     rs=Gestor_Producción.consultaProduccionLote(auxL);
                     construir_tabla(rs);
                }
            }
        }
    }//GEN-LAST:event_JB_Producciones_Aceptar_BusquedaActionPerformed

    private void JTF_Filtro_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Filtro_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_Filtro_ProductoActionPerformed

    private void JTB_MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_MenuMouseClicked
        // TODO add your handling code here:        
    }//GEN-LAST:event_JTB_MenuMouseClicked

    public  boolean verificarSiEstaCargado( String cod ) {
        boolean encontro=false;
        
        encontro=codigos.contains(cod);
        
        return encontro;
    }
    
    private void JT_Ventas_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_Ventas_ProductosMouseClicked
        // TODO add your handling code here:
        contFilasSeleccionadas++;
        int row = JT_Ventas_Productos.rowAtPoint(evt.getPoint());
        
        String nombre="";
        String codProd="";
        String precioStr="";
        
        float precio=0;
        int cant = 1;
        float subt = 100;
        
        boolean yaEstaCargado=false;
        
        // SI HAY AL MENOS UNA FILA SELECCIONADA
        if (row >= 0) 
        {
            nombre=JT_Ventas_Productos.getValueAt(row, 0).toString();
            codProd=JT_Ventas_Productos.getValueAt(row, 1).toString();
            
            yaEstaCargado = verificarSiEstaCargado(codProd);
            
            if (!yaEstaCargado) {
                
                codigos.add(codProd);
                
                String []Datos = new String [5];
        
                // Setear variables
                precio = Gestor_Producto.getPrecio(codProd);
                precioStr=Float.toString(precio);
                cant=1;
                subt = (float) cant * precio;
                totalPagar+=subt;

                // Cargarlos en la jTable        
                Datos[0] = codProd;
                Datos[1] = nombre;
                Datos[2] = precioStr;
                Datos[3] = Integer.toString(cant);
                Datos[4] = Float.toString(subt);

                modeloVentaAcumulado.addRow(Datos);
            }
            
        }
        
        actualizarJLabelTotal(totalPagar);
        
    }//GEN-LAST:event_JT_Ventas_ProductosMouseClicked

    private void JT_Ventas_AcumuladoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_Ventas_AcumuladoMouseClicked
        // TODO add your handling code here:
        
        filaSeleccionada = JT_Ventas_Productos.rowAtPoint(evt.getPoint());
        
        float precio=0;
        int cantidad=0;
        
        precio = Float.parseFloat(JT_Ventas_Acumulado.getValueAt(filaSeleccionada, 2 ).toString());
        cantidad = Integer.parseInt( JT_Ventas_Acumulado.getValueAt(filaSeleccionada, 3).toString() );
        
        subTotalAnt = precio * cantidad;
        sumar = totalPagar;
    }//GEN-LAST:event_JT_Ventas_AcumuladoMouseClicked

    private void deseleccionarTablasVenta() {
        JT_Ventas_Productos.clearSelection();
        JT_Ventas_Acumulado.clearSelection();
        JT_Ventas_Clientes.clearSelection();
    }
    
    private void JTF_Ventas_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Ventas_CancelarActionPerformed
        // TODO add your handling code here:
        iniciarVenta();
    }//GEN-LAST:event_JTF_Ventas_CancelarActionPerformed
    
    private void JT_Ventas_AcumuladoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JT_Ventas_AcumuladoKeyPressed
        // TODO add your handling code here:
        
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER && filaSeleccionada>=0 ) {
            System.out.println("PRESIONASTE ENTER!!");
            actualizarModeloVentaAcumulado();
        }
        
    }//GEN-LAST:event_JT_Ventas_AcumuladoKeyPressed

    private void JB_Quitar_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Quitar_ProductoActionPerformed
        // TODO add your handling code here:
        
        if (filaSeleccionada>=0 && contFilasSeleccionadas>0) {
            
            float precio = 0;
            int cantidad = 0;
            String codigo = "";
            
            codigo = JT_Ventas_Acumulado.getValueAt(filaSeleccionada, 0).toString();
            
            System.out.println("cod: "+codigo);
            
            precio = Float.parseFloat(JT_Ventas_Acumulado.getValueAt(filaSeleccionada, 2).toString()) ;
            cantidad = Integer.parseInt( JT_Ventas_Acumulado.getValueAt(filaSeleccionada, 3).toString() );
            
            totalPagar -= ( (float) precio * cantidad);
            
            actualizarJLabelTotal(totalPagar);
            
            modeloVentaAcumulado.removeRow(filaSeleccionada);
            contFilasSeleccionadas--;
            
            codigos.remove(codigo);
            
            filaSeleccionada = -1;
        }
    }//GEN-LAST:event_JB_Quitar_ProductoActionPerformed

    private void JT_Ventas_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JT_Ventas_ClientesMouseClicked
        // TODO add your handling code here:
        
        clienteSeleccionado = JT_Ventas_Clientes.rowAtPoint(evt.getPoint());
        
    }//GEN-LAST:event_JT_Ventas_ClientesMouseClicked

    private void JB_Ventas_FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Ventas_FinalizarActionPerformed
        // TODO add your handling code here:
        
        if (contFilasSeleccionadas>0) {
            String fecha = "";
            Calendar c1 = new GregorianCalendar();

            String dia, mes, annio;

            dia = Integer.toString(c1.get(Calendar.DATE));
            mes = Integer.toString(c1.get(Calendar.MONTH));
            annio = Integer.toString(c1.get(Calendar.YEAR));

            fecha = annio + "-" + mes + "-" + dia;

            String nombre="";
            float importe=0;

            if (totalPagar>0) {
                importe=totalPagar;
                // Cliente seleccionado
                if ( clienteSeleccionado>=0 ) {
                    nombre=JT_Ventas_Clientes.getValueAt(clienteSeleccionado, 1).toString();
                }
                // Anónimo
                else {
                    nombre="Anónimo";
                }

                //REGISTRAR LA VENTA EN LA BD
                boolean exito=Gestor_Venta.registrarVenta(nombre, importe, fecha);

                if (exito) {
                    JOptionPane.showMessageDialog(null, "Venta registrada exitosamente para el cliente:\n\n" + nombre +"\n" );
                }
                else {
                    JOptionPane.showMessageDialog(null, "La venta no se ha registrado!\n\n" );
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar al menos un producto");
        }
        
    }//GEN-LAST:event_JB_Ventas_FinalizarActionPerformed

    private void actualizarModeloVentaAcumulado() {        
        float precio=0;
        int cant=0;
        float subt=0;
        
        if (contFilasSeleccionadas > 0 && filaSeleccionada>=0) {

            precio = Float.parseFloat(JT_Ventas_Acumulado.getValueAt(filaSeleccionada, 2 ).toString());
            cant = Integer.parseInt( JT_Ventas_Acumulado.getValueAt(filaSeleccionada, 3).toString() );

            subt = precio * cant;

            System.out.println("\nPrecio: "+precio);
            System.out.println("Cantidad: "+cant);
            System.out.println("Subtotal: "+subt+"\n");
            
            // Actualiza el subtotal en la tabla
            JT_Ventas_Acumulado.setValueAt(String.valueOf(subt), filaSeleccionada, 4);
            
            // Actualiza el total
            
            int i;
            String []datos = new String[5];
            
            float total = 0;
            
            for ( i=0; i<modeloVentaAcumulado.getRowCount();i++ ) {
                datos[0] = modeloVentaAcumulado.getValueAt(i, 0 ).toString();
                datos[1] = modeloVentaAcumulado.getValueAt(i, 1 ).toString();
                datos[2] = modeloVentaAcumulado.getValueAt(i, 2 ).toString();
                datos[3] = modeloVentaAcumulado.getValueAt(i, 3 ).toString();
                datos[4] = modeloVentaAcumulado.getValueAt(i, 4 ).toString();
                
                total+=Float.parseFloat( datos[4] );
            }
            
            totalPagar = total;
            
            actualizarJLabelTotal(totalPagar);
            
            // Reset variables globales
            subTotalAnt=0;
        }
    }
    
    private void JT_Ventas_AcumuladoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JT_Ventas_AcumuladoPropertyChange
        // TODO add your handling code here:
        // ACTUALIZAR TODA LA TABLA
        actualizarModeloVentaAcumulado();
    }//GEN-LAST:event_JT_Ventas_AcumuladoPropertyChange

    private void JTF_NCodigo_ProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTF_NCodigo_ProductoKeyTyped
        // TODO add your handling code here:
        int MAX = 6;
        
        if (JTF_NCodigo_Producto.getText().length()>= MAX){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "El código debe tener máximo 6 caracteres");
        }
    }//GEN-LAST:event_JTF_NCodigo_ProductoKeyTyped

    private void JTF_NCodigo_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_NCodigo_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_NCodigo_ProductoActionPerformed

    private void JTF_Codigo_ProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTF_Codigo_ProductoKeyTyped
        // TODO add your handling code here:
        
        int MAX = 6;
        
        if (JTF_Codigo_Producto.getText().length()>= MAX){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "El código debe tener máximo 6 caracteres");
        }
        
    }//GEN-LAST:event_JTF_Codigo_ProductoKeyTyped

    private void JP_VentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JP_VentasMouseClicked
        // TODO add your handling code here:
        //iniciarVenta();
    }//GEN-LAST:event_JP_VentasMouseClicked

    private void JB_Cancelar_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Cancelar_EliminarActionPerformed
        // TODO add your handling code here:
        cargarTablaEliminar();
    }//GEN-LAST:event_JB_Cancelar_EliminarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JP_info_Producciones.removeAll();
        JP_info_Producciones.add(JP_Cargar_Produccion);
        JP_info_Producciones.repaint();
        JP_info_Producciones.revalidate();
        cargarProductosProducciones();
        cargarVariedadesProducciones();
        cargarMPSProducciones();
    }//GEN-LAST:event_jButton5ActionPerformed
    private void cargarMPSProducciones(){
        
        DefaultTableModel m = new DefaultTableModel();
        m.addColumn("Materia Prima");
        m.addColumn("N° Lote");
        m.addColumn("Código M.P.");
        m.addColumn("Stock Actual");
        this.JT_Produ_StockActual_MP.setModel(m);
        ArrayList<MP_ViewModel> ListaMP= new ArrayList<>();
        ListaMP=Gestor_Materia_Prima.traerMateriasPrimas();
        
      
        int i=0;
        Object aux[] = new Object[m.getColumnCount()];
         
         for(i=0 ; i < ListaMP.size() ; i++){

            aux[0]= ListaMP.get(i).getNbre_MP();
            aux[1]= ListaMP.get(i).getLote();
            aux[2]= ListaMP.get(i).getCodigo();
            aux[3]= ListaMP.get(i).getSa();
            m.addRow(aux);

            }
    }
   
    private void cargarVariedadesProducciones(){
        DefaultTableModel m = new DefaultTableModel();
        m.addColumn("Variedad");
        m.addColumn("Código de la Variedad");
        this.JT_Produ_Variedad.setModel(m);
        ArrayList<Variedad_MP> ListaV = new ArrayList<>();
        ListaV=Gestor_Variedad_MateriaPrima.traerVariedadesProductos();
        int auxcant=ListaV.size(), auxit=0;
        
        Object aux[] = new Object[m.getColumnCount()];
        
        for (auxit=0; auxit<auxcant; auxit++){
            aux[0]= ListaV.get(auxit).getNombre();
            aux[1]= ListaV.get(auxit).getCodigo();
            m.addRow(aux);
            
        }
    }
    private void cargarProductosProducciones(){
        
        DefaultTableModel m = new DefaultTableModel();
        m.addColumn("Nombre del Producto");
        m.addColumn("Código del Producto");
        this.JT_Produ_Productos.setModel(m);
        
        ArrayList Lista = new ArrayList();
        Lista=Gestor_Producto.traerListaProductos();
         int auxcant=Lista.size(),auxit,i=0,j=1;
         
         //System.out.println(Lista.get(0));
         Object p[] = new Object[m.getColumnCount()];
         
         for(auxit=0 ; auxit <(int)(auxcant/2) ; auxit++){
             p[0]= Lista.get(i+auxit);
             p[1]= Lista.get(j+auxit);
             i++;j++;
             
             
             m.addRow(p);
         }

     }
    
    
    public void construir_tabla(ResultSet sr){
            modelo= new DefaultTableModel();
            modelo.addColumn("Fecha de Elaboración");
            modelo.addColumn("Fecha de Vencimiento");
            modelo.addColumn("Cantidad Producida");
            modelo.addColumn("Número de Lote");
            modelo.addColumn("Nombre del Producto");
            modelo.addColumn("Variedad del Producto");
            this.JT_Producciones.setModel(modelo);
            ArrayList lista = new ArrayList ();
        //int i;
                try {

            while ( rs.next() ) {

                    lista.add(rs.getDate(1));
                    lista.add(rs.getDate(2));
                    lista.add(rs.getInt(3));
                    lista.add(rs.getString(4));
                    lista.add(rs.getString(5));
                    lista.add(rs.getString(6));
                
                modelo.addRow(lista.toArray());
                
            }
        } catch (SQLException ex) {

        }
        
    }
    
    
    private void jOPTB_BPFActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void JTF_Producciones_NLoteKeyTyped(java.awt.event.KeyEvent evt) {                                                
        // TODO add your handling code here:
        int  MAX=10;
        if(JTF_Producciones_NLote.getText().length()>=10){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"Númer0 de lote debe tener 10 Caracteres" );
        }
    }                                               


    //FIN CU Buscar Produccines.
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_Buscar_Producciones;
    private javax.swing.JRadioButton JBO_Buscar_Produccion_Lote;
    private javax.swing.JButton JB_Aceptar_CambiarProducto;
    private javax.swing.JButton JB_Aceptar_NuevoProducto;
    private javax.swing.JButton JB_Alta_Producto;
    private javax.swing.JButton JB_Baja_Producto;
    private javax.swing.JButton JB_Buscar_Producciones;
    private javax.swing.JButton JB_Cambiar_Producto;
    private javax.swing.JButton JB_Cancelar_Eliminar;
    private javax.swing.JButton JB_Cancelar_NuevoProdu;
    private javax.swing.JButton JB_Eliminar;
    private javax.swing.JButton JB_Eliminar_Cliente;
    private javax.swing.JButton JB_Ingresar_Cliente_Aceptar;
    private javax.swing.JButton JB_Ingresar_Cliente_Cancelar;
    private javax.swing.JButton JB_Limpiar_CambiarProducto;
    private javax.swing.JButton JB_Modificar_Cliente;
    private javax.swing.JButton JB_Nuevo_Cliente;
    private javax.swing.JButton JB_Produ_Cancelar_Produccion;
    private javax.swing.JButton JB_Produ_CargarProduccion;
    private javax.swing.JButton JB_Producciones_Aceptar_Busqueda;
    private javax.swing.JButton JB_Quitar_Producto;
    private javax.swing.JButton JB_Ventas_ComenzarVenta;
    private javax.swing.JButton JB_Ventas_Finalizar;
    private com.toedter.calendar.JDateChooser JDC_Cargaar_Produ_fecha;
    private com.toedter.calendar.JDateChooser JDC_Produ_Vencimiento_fecha;
    private com.toedter.calendar.JDateChooser JDC_Producciones_BuscarFecha;
    private javax.swing.JTextField JFT_Produ_LoteProduccion;
    private javax.swing.JLabel JL_Cargar_Produ_fecha;
    private javax.swing.JLabel JL_Codigo_Producto;
    private javax.swing.JLabel JL_Info_Baja;
    private javax.swing.JLabel JL_Info_en_cambiar;
    private javax.swing.JLabel JL_Ingrese_DNI;
    private javax.swing.JLabel JL_Ingrese_DOM;
    private javax.swing.JLabel JL_Ingrese_NOM;
    private javax.swing.JLabel JL_Ingrese_TEL;
    private javax.swing.JLabel JL_NCodigo;
    private javax.swing.JLabel JL_NNombre;
    private javax.swing.JLabel JL_Nombre_Producto;
    private javax.swing.JLabel JL_Produ_Sel_MP;
    private javax.swing.JLabel JL_Produ_indique_cantxprodu;
    private javax.swing.JLabel JL_Seleccione_un_Producto;
    private javax.swing.JLabel JL_SignoARS;
    private javax.swing.JLabel JL_info_Venta1;
    private javax.swing.JLabel JL_info_Venta2;
    private javax.swing.JLabel JL_info_Venta3;
    private javax.swing.JLabel JL_seleccione_variedad;
    private javax.swing.JPanel JP_Agregar_Cliente;
    private javax.swing.JPanel JP_Alta_Producto;
    private javax.swing.JPanel JP_Baja_Producto;
    private javax.swing.JPanel JP_Botones_Ventas;
    private javax.swing.JPanel JP_Buscar_Producción;
    private javax.swing.JPanel JP_Cambiar_Producto;
    private javax.swing.JPanel JP_Cargar_Produccion;
    private javax.swing.JPanel JP_Clientes;
    private javax.swing.JPanel JP_Comenzar_Venta;
    private javax.swing.JPanel JP_Eliminar_Cliente;
    private javax.swing.JPanel JP_MateriaPrima;
    private javax.swing.JPanel JP_Modificar_Cliente;
    private javax.swing.JPanel JP_Producciones;
    private javax.swing.JPanel JP_Productos;
    private javax.swing.JPanel JP_Proveedores;
    private javax.swing.JPanel JP_Variedades;
    private javax.swing.JPanel JP_Ventas;
    private javax.swing.JPanel JP_botones_Producciones;
    private javax.swing.JPanel JP_botones_Productos;
    private javax.swing.JPanel JP_botones_Ventas;
    private javax.swing.JPanel JP_info_Clientes;
    private javax.swing.JPanel JP_info_Producciones;
    private javax.swing.JPanel JP_info_Productos;
    private javax.swing.JPanel JP_info_Ventas;
    private javax.swing.JTabbedPane JTB_Menu;
    private javax.swing.JTable JTB_Productos;
    private javax.swing.JTable JTB_Productos1;
    private javax.swing.JTextField JTF_Codigo_Producto;
    private javax.swing.JTextField JTF_Filtro_Cliente;
    private javax.swing.JTextField JTF_Filtro_Producto;
    private javax.swing.JTextField JTF_Ingrese_DNI;
    private javax.swing.JTextField JTF_Ingrese_DOM;
    private javax.swing.JTextField JTF_Ingrese_NOM;
    private javax.swing.JTextField JTF_Ingrese_TEL;
    private javax.swing.JTextField JTF_NCodigo_Producto;
    private javax.swing.JTextField JTF_NNombre_Producto;
    private javax.swing.JTextField JTF_Nombre_Producto;
    private javax.swing.JTextField JTF_Produ_CantProduxProducto;
    private javax.swing.JTextField JTF_Producciones_NLote;
    private javax.swing.JButton JTF_Ventas_Cancelar;
    private javax.swing.JTable JT_Modificar_Cliente;
    private javax.swing.JTable JT_Produ_NuevoStock_MP;
    private javax.swing.JTable JT_Produ_Productos;
    private javax.swing.JTable JT_Produ_StockActual_MP;
    private javax.swing.JTable JT_Produ_Variedad;
    private javax.swing.JTable JT_Producciones;
    private javax.swing.JTable JT_Ventas_Acumulado;
    private javax.swing.JTable JT_Ventas_Clientes;
    private javax.swing.JTable JT_Ventas_Productos;
    private javax.swing.JLabel LF_Info_CambiarProducto2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jOPTB_BPF;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
