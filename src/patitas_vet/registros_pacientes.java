package patitas_vet;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class registros_pacientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(registros_pacientes.class.getName());
    static String[] data;
    public registros_pacientes(String[] dato) {
        initComponents();
        data = dato;
        getContentPane().setBackground(new java.awt.Color(250, 230, 198));
        this.setExtendedState(this.MAXIMIZED_BOTH);   
        if (data != null){
            btnClientes3.setText("Editar");
            txtID_titular.setText(data[1]);
            txtNombrePaciente.setText(data[2]);
            txtApellidPaciente.setText(data[3]);
            String newTipo = "";
            if("01".equals(data[4].substring(0, 2))){
                newTipo = "Perro";
            }else if("02".equals(data[4].substring(0, 2))){
                newTipo = "Gato";
            }else if("03".equals(data[4].substring(0, 2))){
                newTipo = "Conejo";
            }else if("04".equals(data[4].substring(0, 2))){
                newTipo = "Caballo";
            }
            cmbTipo1.setSelectedItem(newTipo);
            txtFechaNac.setText(data[5]);

            // txtFechaFallecimiento.setText(data[6]);

            cmbSexo.setSelectedItem((data[7]=="M")? "Macho":"Hembra");
            txtColor.setText(data[8]);
            cbEsteril.setSelected(Boolean.parseBoolean(data[9]));
            jspLongitud.setValue(Integer.parseInt(data[10]));
            jspAltura.setValue(Integer.parseInt(data[11]));
            jspPeso.setValue(Integer.parseInt(data[12]));
            txtMorfologia.setText(data[13]);
            cmbGrupoSang.setSelectedItem(data[14].trim());
            cbMicrochip.setSelected(Boolean.parseBoolean(data[15]));
            cbTatuaje.setSelected(Boolean.parseBoolean(data[16]));
            txtObs.setText(data[17]);
        }
    }
    public void setMicrochip(boolean microchip) {
        cbMicrochip.setSelected(microchip);
    }
    
    public void setNombrePaciente(String nombre){
            txtNombrePaciente.setText(nombre);
    }
    public void setApellidPaciente(String apellidos) {
        txtApellidPaciente.setText(apellidos);
    }

    public void setFechaNacimiento(String fecha) {
        txtFechaNac.setText(fecha);
    }

    public void setSexo(String sexo) {
        cmbSexo.setSelectedItem(sexo);
    }

    public void setColor(String color) {
        txtColor.setText(color);
    }

    public void setEsterilizado(boolean esterilizado) {
        cbEsteril.setSelected(esterilizado);
    }

    public void setTatuaje(boolean tatuaje) {
        cbTatuaje.setSelected(tatuaje);
    }

    public void setLongitud(double longitud) {
        jspLongitud.setValue((int) longitud);
    }

    public void setAltura(double altura) {
        jspAltura.setValue((int) altura);
    }

    public void setPeso(double peso) {
        jspPeso.setValue((int) peso);
    }

    public void setMorfologia(String morfologia) {
        txtMorfologia.setText(morfologia);
    }

    public void setGrupoSanguineo(String grupo) {
        cmbGrupoSang.setSelectedItem(grupo);
    }

    public void setIDTitular(String idTitular) {
        txtID_titular.setText(idTitular);
    }

    public void setObservaciones(String obs) {
        txtObs.setText(obs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        db_fondo = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        calendario = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnSemana = new javax.swing.JButton();
        btnMes = new javax.swing.JButton();
        registro = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnClientes = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        btnRegistro1 = new javax.swing.JButton();
        logo_image = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombrePaciente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidPaciente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        txtFechaNac = new javax.swing.JTextField();
        cmbTipo1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        cbEsteril = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        cbMicrochip = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        cbTatuaje = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jspAltura = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jspLongitud = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jspPeso = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        txtMorfologia = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cmbGrupoSang = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        txtID_titular = new javax.swing.JTextField();
        btnLimpiarCampos = new javax.swing.JButton();
        btnClientes3 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btnBD_PACIENTES = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        db_fondo.setBackground(new java.awt.Color(109, 151, 115));

        btnDashboard.setBackground(new java.awt.Color(255, 185, 2));
        btnDashboard.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnDashboard.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        calendario.setBackground(new java.awt.Color(255, 185, 2));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Calendario");

        btnSemana.setBackground(new java.awt.Color(250, 230, 200));
        btnSemana.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnSemana.setForeground(new java.awt.Color(110, 150, 115));
        btnSemana.setText("Semana");
        btnSemana.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnSemana.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        btnMes.setBackground(new java.awt.Color(250, 230, 200));
        btnMes.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnMes.setForeground(new java.awt.Color(110, 150, 115));
        btnMes.setText("Mes");
        btnMes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnMes.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout calendarioLayout = new javax.swing.GroupLayout(calendario);
        calendario.setLayout(calendarioLayout);
        calendarioLayout.setHorizontalGroup(
            calendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarioLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(calendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calendarioLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calendarioLayout.createSequentialGroup()
                        .addComponent(btnSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calendarioLayout.createSequentialGroup()
                        .addComponent(btnMes, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        calendarioLayout.setVerticalGroup(
            calendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        registro.setBackground(new java.awt.Color(255, 185, 2));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Base de Datos");

        btnClientes.setBackground(new java.awt.Color(250, 230, 200));
        btnClientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(110, 150, 115));
        btnClientes.setText("Clientes");
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnPacientes.setBackground(new java.awt.Color(250, 230, 200));
        btnPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnPacientes.setForeground(new java.awt.Color(110, 150, 115));
        btnPacientes.setText("Pacientes");
        btnPacientes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnPacientes.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });

        btnRegistro.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnRegistro.setText("Registro");
        btnRegistro.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnRegistro1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnRegistro1.setText("Vacunas");
        btnRegistro1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnRegistro1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnRegistro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistro1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registroLayout = new javax.swing.GroupLayout(registro);
        registro.setLayout(registroLayout);
        registroLayout.setHorizontalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroLayout.createSequentialGroup()
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroLayout.createSequentialGroup()
                        .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroLayout.createSequentialGroup()
                        .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroLayout.createSequentialGroup()
                        .addComponent(btnRegistro1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        registroLayout.setVerticalGroup(
            registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistro1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        logo_image.setBackground(new java.awt.Color(12, 58, 45));

        javax.swing.GroupLayout logo_imageLayout = new javax.swing.GroupLayout(logo_image);
        logo_image.setLayout(logo_imageLayout);
        logo_imageLayout.setHorizontalGroup(
            logo_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        logo_imageLayout.setVerticalGroup(
            logo_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btnVolver.setBackground(new java.awt.Color(255, 185, 2));
        btnVolver.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(255, 185, 2));
        btnCerrarSesion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout db_fondoLayout = new javax.swing.GroupLayout(db_fondo);
        db_fondo.setLayout(db_fondoLayout);
        db_fondoLayout.setHorizontalGroup(
            db_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, db_fondoLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(db_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        db_fondoLayout.setVerticalGroup(
            db_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(db_fondoLayout.createSequentialGroup()
                .addComponent(logo_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarSesion)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        getContentPane().add(db_fondo);
        db_fondo.setBounds(0, 0, 260, 910);

        jPanel1.setBackground(new java.awt.Color(109, 151, 115));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Datos Básicos del Paciente ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        txtNombrePaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Apellido:");

        txtApellidPaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tipo:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Fecha Nacimiento:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Sexo:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Color:");

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ㅤ", "Macho", "Hembra" }));

        cmbTipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ㅤ", "Perro", "Gato", "Conejo", "Caballo" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Esterilizado");

        txtColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cbEsteril.setText("Esterilizado");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Microchip");

        cbMicrochip.setText("Microchip");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Tatuaje");

        cbTatuaje.setText("Tatuaje");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtColor)
                        .addComponent(jLabel9)
                        .addComponent(cmbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addComponent(txtFechaNac)
                        .addComponent(jLabel7)
                        .addComponent(cmbTipo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addComponent(txtApellidPaciente)
                        .addComponent(jLabel4)
                        .addComponent(txtNombrePaciente)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(cbTatuaje)
                                    .addGap(23, 23, 23))
                                .addComponent(cbEsteril, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbMicrochip))
                            .addGap(43, 43, 43))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbEsteril))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbMicrochip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbTatuaje))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(300, 100, 500, 670);

        jPanel2.setBackground(new java.awt.Color(109, 151, 115));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Datos Físicos del Paciente");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Longitud (cm)");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Altura (cm)");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Peso (kg)");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Morfología");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Grupo Sanguíneo");

        cmbGrupoSang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ㅤ", "A-", "A+", "AB-", "AB+", "B-", "B+", "O-", "O+" }));
        cmbGrupoSang.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(69, 69, 69)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMorfologia)
                    .addComponent(jspPeso)
                    .addComponent(jspAltura)
                    .addComponent(jspLongitud)
                    .addComponent(cmbGrupoSang, 0, 283, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jspLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jspAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jspPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMorfologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cmbGrupoSang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(820, 100, 690, 350);

        jPanel3.setBackground(new java.awt.Color(109, 151, 115));

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Datos Administrativos y/o otros");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("ID_Titular:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Observaciones:");

        txtObs.setColumns(20);
        txtObs.setRows(5);
        jScrollPane1.setViewportView(txtObs);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(txtID_titular, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID_titular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(820, 470, 703, 230);

        btnLimpiarCampos.setBackground(new java.awt.Color(250, 230, 200));
        btnLimpiarCampos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnLimpiarCampos.setForeground(new java.awt.Color(110, 150, 115));
        btnLimpiarCampos.setText("Limpiar Campos");
        btnLimpiarCampos.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnLimpiarCampos.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiarCampos);
        btnLimpiarCampos.setBounds(1310, 720, 200, 38);

        btnClientes3.setBackground(new java.awt.Color(250, 230, 200));
        btnClientes3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnClientes3.setForeground(new java.awt.Color(110, 150, 115));
        btnClientes3.setText("Registrar");
        btnClientes3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnClientes3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnClientes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientes3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes3);
        btnClientes3.setBounds(1060, 720, 200, 38);

        jPanel13.setBackground(new java.awt.Color(109, 151, 115));

        jPanel14.setBackground(new java.awt.Color(102, 102, 102));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Buscar:");

        btnBD_PACIENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBD_PACIENTESActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBD_PACIENTES, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnBD_PACIENTES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel13);
        jPanel13.setBounds(290, 10, 1220, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        main_page MAINPAGE = new main_page();
        MAINPAGE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMesActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        registro_clientes registroClientes = new registro_clientes(null);
        registroClientes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        registros_pacientes registrosPacientes = new registros_pacientes(null);
        registrosPacientes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        main_page MAINPAGE = new main_page();
        MAINPAGE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        LOG_IN LOGIN = new LOG_IN();
        LOGIN.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        btnClientes3.setText("Registrar");
        txtNombrePaciente.setText(" ");
        txtApellidPaciente.setText("");
        txtColor.setText("");
        txtFechaNac.setText("");
        txtID_titular.setText("");
        txtMorfologia.setText("");
        
        txtObs.setText("");
        
        cbEsteril.setSelected(false);
        cbMicrochip.setSelected(false);
        cbTatuaje.setSelected(false);

        cmbGrupoSang.setSelectedIndex(0);
        cmbSexo.setSelectedIndex(0);
        cmbTipo1.setSelectedIndex(0);
        
        jspAltura.setValue(0);
        jspLongitud.setValue(0);
        jspPeso.setValue(0);

        
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed
    ConnectToServer bd = new ConnectToServer();
    private void btnClientes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientes3ActionPerformed
        String Genero = (String) cmbSexo.getSelectedItem();
        Genero = Genero == "Macho"?"M":"F";
        String Tipo = (String) cmbTipo1.getSelectedItem();
        if(Tipo == "Perro"){
            Tipo = "0101";
        }else if(Tipo == "Gato"){
            Tipo = "0201";
        }else if(Tipo == "Conejo"){
            Tipo = "0301";
        }else if(Tipo == "Caballo"){
            Tipo = "0401";
        }
        
        try {
            bd.conectaSql();
            if(registros_pacientes.data == null){
                bd.crearPaciente(txtID_titular.getText(), txtNombrePaciente.getText(), txtApellidPaciente.getText(),
                        Tipo, txtFechaNac.getText(),
                        Genero, txtColor.getText(), cbEsteril.isSelected()+"", jspLongitud.getValue().toString(),
                        jspAltura.getValue().toString(), jspPeso.getValue().toString(),txtMorfologia.getText(), 
                        cmbGrupoSang.getSelectedItem().toString(), cbMicrochip.isSelected()+"", cbTatuaje.isSelected()+"", txtObs.getText());
            }else{
                btnClientes3.setText("Editar");
                String ID = registro_clientes.data[0];
                bd.UpdateColumnFromTable("Paciente", "ID_titular", txtID_titular.getText(), ID);
                bd.UpdateColumnFromTable("Paciente", "nombre", txtNombrePaciente.getText(), ID);
                bd.UpdateColumnFromTable("Paciente", "apellidos", txtApellidPaciente.getText(), ID);
                bd.UpdateColumnFromTable("Paciente", "tipo", Tipo, ID);
                bd.UpdateColumnFromTable("Paciente", "fecha_nacimiento", txtFechaNac.getText(), ID);
                bd.UpdateColumnFromTable("Paciente", "sexo", Genero, ID);
                bd.UpdateColumnFromTable("Paciente", "color", txtColor.getText(), ID);
                bd.UpdateColumnFromTable("Paciente", "esterilizado", cbEsteril.isSelected()+"", ID);
                bd.UpdateColumnFromTable("Paciente", "longitud", jspLongitud.getValue().toString(),ID);
                bd.UpdateColumnFromTable("Paciente", "altura", jspAltura.getValue().toString(), ID);
                bd.UpdateColumnFromTable("Paciente", "peso", jspPeso.getValue().toString(),ID);
                bd.UpdateColumnFromTable("Paciente", "morfologia", txtMorfologia.getText(), ID);
                bd.UpdateColumnFromTable("Paciente", "grupo_sanguineo", cmbGrupoSang.getSelectedItem().toString(), ID);
                bd.UpdateColumnFromTable("Paciente", "microchip", cbMicrochip.isSelected()+"", ID);
                bd.UpdateColumnFromTable("Paciente", "tatuaje", cbTatuaje.isSelected()+"", ID);
                bd.UpdateColumnFromTable("Paciente", "observaciones", txtObs.getText(), ID);
            }
            
            bd.cierraSql();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btnClientes3ActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        registro REGISTRO = new registro(null, null);
        REGISTRO.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnBD_PACIENTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBD_PACIENTESActionPerformed
        bd_pacientes BD_PACIENTES = new bd_pacientes();
        BD_PACIENTES.setVisible(true);
        if(BD_PACIENTES.isActive() == false){
            this.dispose();
        }
    }//GEN-LAST:event_btnBD_PACIENTESActionPerformed

    private void btnRegistro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistro1ActionPerformed
       vacunas VACUNAS = new vacunas();
       VACUNAS.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnRegistro1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new registros_pacientes(null).setVisible(true));
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBD_PACIENTES;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnClientes3;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnMes;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnRegistro1;
    private javax.swing.JButton btnSemana;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel calendario;
    private javax.swing.JCheckBox cbEsteril;
    private javax.swing.JCheckBox cbMicrochip;
    private javax.swing.JCheckBox cbTatuaje;
    private javax.swing.JComboBox<String> cmbGrupoSang;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JComboBox<String> cmbTipo1;
    private javax.swing.JPanel db_fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jspAltura;
    private javax.swing.JSpinner jspLongitud;
    private javax.swing.JSpinner jspPeso;
    private javax.swing.JPanel logo_image;
    private javax.swing.JPanel registro;
    private javax.swing.JTextField txtApellidPaciente;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtID_titular;
    private javax.swing.JTextField txtMorfologia;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextArea txtObs;
    // End of variables declaration//GEN-END:variables
}
