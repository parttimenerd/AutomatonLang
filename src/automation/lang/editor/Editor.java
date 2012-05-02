package automation.lang.editor;

import automation.lang.Tree;
import automation.lang.Tree.TestReturn;
import automation.lang.editor.panel.Panel;
import automation.lang.editor.panel.Panel.TodoListItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

/**
 * Editor
 *
 * @author Johannes Bechberger
 */
public class Editor extends javax.swing.JFrame {

   /**
    * Dateiendung des verwendeten Dateiformats
    */
   public static String FILE_ENDING = ".al";
   /**
    * Writer, in den das EvoJS Objekt Ausgaben und Errors schreibt
    */
   public static Writer writer;
   private Timer timer;
   private final String[] EXAMPLES = new String[]{
      "Gerade_Zahlen.al"
   };

   /**
    * Creates new form Editor
    */
   public Editor() {
      initComponents();
      DropTargetListener droplistener = new DropTargetListener() {

         @Override
         public void dragEnter(DropTargetDragEvent dtde) {
            //throw new UnsupportedOperationException("Not supported yet.");
         }

         @Override
         public void dragOver(DropTargetDragEvent dtde) {
            //throw new UnsupportedOperationException("Not supported yet.");
         }

         @Override
         public void dropActionChanged(DropTargetDragEvent dtde) {
            //throw new UnsupportedOperationException("Not supported yet.");
         }

         @Override
         public void dragExit(DropTargetEvent dte) {
            //throw new UnsupportedOperationException("Not supported yet.");
         }

         @Override
         @SuppressWarnings("unchecked")
         public void drop(DropTargetDropEvent dtde) {
            Transferable tr = dtde.getTransferable();
            if (tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
               try {
                  dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                  öffnen((List<File>) (dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor)));
                  dtde.getDropTargetContext().dropComplete(true);
               } catch (UnsupportedFlavorException ex) {
                  Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                  Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
               }
            } else {
               dtde.rejectDrop();
            }

         }
      };
      new DropTarget(this, droplistener);
      new DropTarget(tabbed_pane, droplistener);
      new DropTarget(toolbar, droplistener);
      System.setOut(new PrintStream(new OutputStream() {

         @Override
         public void write(int b) {
            ausgaben_fenster.append((char) b + "");
         }
      }));
      ausgaben_fenster.setFont(new java.awt.Font("Monospaced", 0, 12));
      loadExamples();
      timer = new Timer("Update errors and TODO-list");
      timer.schedule(new TimerTask() {

         @Override
         public void run() {
            try {
               updateErrorsTable();
            } catch (Exception exp) {
            }
         }
      }, 100, 500);
      timer.schedule(new TimerTask() {

         @Override
         public void run() {
            updateTodoList();
         }
      }, 100, 300);
      timer.schedule(new TimerTask() {

         @Override
         public void run() {
            updateCurrentPanelTitle();
         }
      }, 100, 400);
      timer.schedule(new TimerTask() {

         @Override
         public void run() {
            if (regelmäßig_alle_speichern_item.isSelected()) {
               Component[] comparr = tabbed_pane.getComponents();
               for (int i = 0; i < comparr.length; i++) {
                  Component comp = comparr[i];
                  if (comp instanceof Panel) {
                     Panel panel = (Panel) comp;
                     if (panel.getCode_file() != null) {
                        panel.ausführen(file_chooser);
                     }
                  }
               }
            }
         }
      }, 100, 1000);
      errors_table.getColumnModel().getColumn(0).setMaxWidth(50);
      errors_table.getColumnModel().getColumn(1).setMaxWidth(60);
   }

   public void updateCurrentPanelTitle() {
      Panel panel = getCurrentPanel();
      if (panel != null) {
         tabbed_pane.setTitleAt(tabbed_pane.getSelectedIndex(), panel.getTitle());
      }
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        file_chooser = new javax.swing.JFileChooser();
        font_ändern_item = new javax.swing.JMenuItem();
        preview_scrollpane = new javax.swing.JScrollPane();
        preview_textpane = new javax.swing.JTextPane();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        beispiele_menu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        toolbar = new javax.swing.JToolBar();
        öffnen_button = new javax.swing.JButton();
        ausführen_button = new javax.swing.JButton();
        neu_button = new javax.swing.JButton();
        speichern_button = new javax.swing.JButton();
        save_all_button = new javax.swing.JButton();
        undo_button = new javax.swing.JButton();
        redo_button = new javax.swing.JButton();
        suchen_button = new javax.swing.JButton();
        tab_nach_rechts_button = new javax.swing.JButton();
        tab_nach_links_button = new javax.swing.JButton();
        hilfe_button = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        tabbed_pane = new javax.swing.JTabbedPane();
        willkommen_panel = new javax.swing.JPanel();
        script_open_button = new javax.swing.JButton();
        neues_script_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tabbed_pane_unten = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ausgaben_fenster = new javax.swing.JTextArea();
        errors_scrollpane = new javax.swing.JScrollPane();
        errors_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        todo_table = new javax.swing.JTable();
        automat_testen_panel = new javax.swing.JPanel();
        autesten_button = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        autesten_ausgabe = new javax.swing.JTextArea();
        autesten_ausdruck_box = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jflap_testarea = new javax.swing.JTextArea();
        menu_bar = new javax.swing.JMenuBar();
        script_menu = new javax.swing.JMenu();
        ausführen_item = new javax.swing.JMenuItem();
        neues_script_item = new javax.swing.JMenuItem();
        öffnen_item = new javax.swing.JMenuItem();
        speichern_item = new javax.swing.JMenuItem();
        speichern_unter_item = new javax.swing.JMenuItem();
        bearbeiten_menu = new javax.swing.JMenu();
        undo_item = new javax.swing.JMenuItem();
        redo_item = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        alles_markieren_item = new javax.swing.JMenuItem();
        auschneiden_item = new javax.swing.JMenuItem();
        kopieren_item = new javax.swing.JMenuItem();
        entfernen_item = new javax.swing.JMenuItem();
        einfügen_item = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        tab_nach_links = new javax.swing.JMenuItem();
        tab_nach_rechts_item = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        suchen_item = new javax.swing.JMenuItem();
        weitersuchen_item = new javax.swing.JMenuItem();
        ersetzen_item = new javax.swing.JMenuItem();
        editor_menu = new javax.swing.JMenu();
        aktuellen_tab_schließen_item = new javax.swing.JMenuItem();
        ausgabefenster_klären_item = new javax.swing.JMenuItem();
        zeilen_bruch_item = new javax.swing.JRadioButtonMenuItem();
        regelmäßig_alle_speichern_item = new javax.swing.JRadioButtonMenuItem();
        hilfe_menu = new javax.swing.JMenu();
        sprachhilfe_item = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        file_chooser.setAccessory(preview_scrollpane);
        file_chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(FILE_ENDING);
            }

            @Override
            public String getDescription() {
                return "AutomationLang (= DSL für einfache Automaten) Dateien";
            }
        });
        file_chooser.setAutoscrolls(true);
        file_chooser.setDragEnabled(true);
        file_chooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                file_chooserPropertyChange(evt);
            }
        });

        font_ändern_item.setText("Schriftart ändern...");
        font_ändern_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                font_ändern_itemActionPerformed(evt);
            }
        });

        preview_scrollpane.setMinimumSize(new java.awt.Dimension(100, 100));
        preview_scrollpane.setPreferredSize(new java.awt.Dimension(200, 100));

        preview_textpane.setContentType("text/html");
        preview_textpane.setEditable(false);
        preview_textpane.setText("<html>\r   <head>\r \r sdfasdfasdf  </head>\r   <body>\r     <p style=\"margin-top: 0\">\r       \r     </p>\r   </body>\r </html>\r ");
        preview_scrollpane.setViewportView(preview_textpane);

        jFormattedTextField1.setText("jFormattedTextField1");

        beispiele_menu.setText("Beispiele");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        toolbar.setFloatable(false);
        toolbar.setRollover(true);
        toolbar.setPreferredSize(new java.awt.Dimension(229, 29));

        öffnen_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Öffnen.png"))); // NOI18N
        öffnen_button.setToolTipText("Script Datei öffnen");
        öffnen_button.setBorderPainted(false);
        öffnen_button.setFocusable(false);
        öffnen_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        öffnen_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        öffnen_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                öffnen_buttonActionPerformed(evt);
            }
        });
        toolbar.add(öffnen_button);

        ausführen_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Ausführen.png"))); // NOI18N
        ausführen_button.setToolTipText("Script ausführen");
        ausführen_button.setBorderPainted(false);
        ausführen_button.setFocusable(false);
        ausführen_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ausführen_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ausführen_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ausführen_buttonActionPerformed(evt);
            }
        });
        toolbar.add(ausführen_button);

        neu_button.setForeground(java.awt.SystemColor.control);
        neu_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Neu.png"))); // NOI18N
        neu_button.setToolTipText("Neues Script erstellen");
        neu_button.setBorderPainted(false);
        neu_button.setFocusable(false);
        neu_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        neu_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        neu_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neu_buttonActionPerformed(evt);
            }
        });
        toolbar.add(neu_button);

        speichern_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Speichern.png"))); // NOI18N
        speichern_button.setToolTipText("Script speichern");
        speichern_button.setBorderPainted(false);
        speichern_button.setFocusable(false);
        speichern_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        speichern_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        speichern_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speichern_buttonActionPerformed(evt);
            }
        });
        toolbar.add(speichern_button);

        save_all_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Alle_speichern.png"))); // NOI18N
        save_all_button.setToolTipText("Alle Scripte speichern");
        save_all_button.setBorderPainted(false);
        save_all_button.setFocusable(false);
        save_all_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save_all_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        save_all_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_all_buttonActionPerformed(evt);
            }
        });
        toolbar.add(save_all_button);

        undo_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Undo.png"))); // NOI18N
        undo_button.setToolTipText("Rückgängig");
        undo_button.setBorderPainted(false);
        undo_button.setFocusable(false);
        undo_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        undo_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        undo_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undo_buttonActionPerformed(evt);
            }
        });
        toolbar.add(undo_button);

        redo_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Redo.png"))); // NOI18N
        redo_button.setToolTipText("Wiederholen");
        redo_button.setBorderPainted(false);
        redo_button.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Redo_disabled.png"))); // NOI18N
        redo_button.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Redo_disabled.png"))); // NOI18N
        redo_button.setFocusable(false);
        redo_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redo_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        redo_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redo_buttonActionPerformed(evt);
            }
        });
        toolbar.add(redo_button);

        suchen_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Suchen.png"))); // NOI18N
        suchen_button.setToolTipText("Suchen");
        suchen_button.setBorderPainted(false);
        suchen_button.setFocusable(false);
        suchen_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        suchen_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        suchen_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suchen_buttonActionPerformed(evt);
            }
        });
        toolbar.add(suchen_button);

        tab_nach_rechts_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/tab_nach_rechts.png"))); // NOI18N
        tab_nach_rechts_button.setToolTipText("Einrücken");
        tab_nach_rechts_button.setBorderPainted(false);
        tab_nach_rechts_button.setFocusable(false);
        tab_nach_rechts_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tab_nach_rechts_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tab_nach_rechts_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_nach_rechts_buttonActionPerformed(evt);
            }
        });
        toolbar.add(tab_nach_rechts_button);

        tab_nach_links_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/tab_nach_links.png"))); // NOI18N
        tab_nach_links_button.setToolTipText("Ausrücken");
        tab_nach_links_button.setBorderPainted(false);
        tab_nach_links_button.setFocusable(false);
        tab_nach_links_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tab_nach_links_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tab_nach_links_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_nach_links_buttonActionPerformed(evt);
            }
        });
        toolbar.add(tab_nach_links_button);

        hilfe_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Hilfe.png"))); // NOI18N
        hilfe_button.setToolTipText("Hilfe");
        hilfe_button.setBorderPainted(false);
        hilfe_button.setFocusable(false);
        hilfe_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hilfe_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        hilfe_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hilfe_buttonActionPerformed(evt);
            }
        });
        toolbar.add(hilfe_button);

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        tabbed_pane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        willkommen_panel.setPreferredSize(new java.awt.Dimension(350, 250));

        script_open_button.setText("Script Datei öffnen...");
        script_open_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                script_open_buttonActionPerformed(evt);
            }
        });

        neues_script_button.setText("Neues Script...");
        neues_script_button.setNextFocusableComponent(script_open_button);
        neues_script_button.setOpaque(false);
        neues_script_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neues_script_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Was möchten sie tun?");

        javax.swing.GroupLayout willkommen_panelLayout = new javax.swing.GroupLayout(willkommen_panel);
        willkommen_panel.setLayout(willkommen_panelLayout);
        willkommen_panelLayout.setHorizontalGroup(
            willkommen_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(willkommen_panelLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(willkommen_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(willkommen_panelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(willkommen_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(script_open_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(neues_script_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(114, 114, 114))
        );
        willkommen_panelLayout.setVerticalGroup(
            willkommen_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, willkommen_panelLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(neues_script_button, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(script_open_button, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        tabbed_pane.addTab("Willkommen", willkommen_panel);
        willkommen_panel.getAccessibleContext().setAccessibleParent(jSplitPane1);

        jSplitPane1.setLeftComponent(tabbed_pane);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(200, 32767));

        ausgaben_fenster.setColumns(20);
        ausgaben_fenster.setRows(5);
        jScrollPane1.setViewportView(ausgaben_fenster);

        tabbed_pane_unten.addTab("Ausgabe", jScrollPane1);

        errors_table.setAutoCreateRowSorter(true);
        errors_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zeile", "Position", "Beschreibung"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        errors_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                errors_tableMouseClicked(evt);
            }
        });
        errors_scrollpane.setViewportView(errors_table);
        errors_table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        tabbed_pane_unten.addTab("Errors", errors_scrollpane);

        todo_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Beschreibung", "Datei", "Zeile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        todo_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                todo_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(todo_table);
        todo_table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        tabbed_pane_unten.addTab("TODO", jScrollPane2);

        automat_testen_panel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                automat_testen_panelFocusGained(evt);
            }
        });

        autesten_button.setText("Testen");
        autesten_button.setToolTipText("Automaten mit Ausdruck testen");
        autesten_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autesten_buttonActionPerformed(evt);
            }
        });

        autesten_ausgabe.setColumns(20);
        autesten_ausgabe.setRows(5);
        jScrollPane3.setViewportView(autesten_ausgabe);

        autesten_ausdruck_box.setEditable(true);

        javax.swing.GroupLayout automat_testen_panelLayout = new javax.swing.GroupLayout(automat_testen_panel);
        automat_testen_panel.setLayout(automat_testen_panelLayout);
        automat_testen_panelLayout.setHorizontalGroup(
            automat_testen_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(automat_testen_panelLayout.createSequentialGroup()
                .addComponent(autesten_ausdruck_box, 0, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(autesten_button)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        automat_testen_panelLayout.setVerticalGroup(
            automat_testen_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(automat_testen_panelLayout.createSequentialGroup()
                .addGroup(automat_testen_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autesten_button)
                    .addComponent(autesten_ausdruck_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );

        tabbed_pane_unten.addTab("Automat testen", automat_testen_panel);

        jflap_testarea.setColumns(20);
        jflap_testarea.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jflap_testarea.setRows(5);
        jScrollPane4.setViewportView(jflap_testarea);

        tabbed_pane_unten.addTab("JFLAP", jScrollPane4);

        jSplitPane1.setBottomComponent(tabbed_pane_unten);

        script_menu.setText("Script");

        ausführen_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        ausführen_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Ausführen.png"))); // NOI18N
        ausführen_item.setText("Ausführen");
        ausführen_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ausführen_itemActionPerformed(evt);
            }
        });
        script_menu.add(ausführen_item);

        neues_script_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        neues_script_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Neu.png"))); // NOI18N
        neues_script_item.setText("Neu");
        neues_script_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neues_script_itemActionPerformed(evt);
            }
        });
        script_menu.add(neues_script_item);

        öffnen_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        öffnen_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Öffnen.png"))); // NOI18N
        öffnen_item.setText("Öffnen...");
        öffnen_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                öffnen_itemActionPerformed(evt);
            }
        });
        script_menu.add(öffnen_item);

        speichern_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        speichern_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Speichern.png"))); // NOI18N
        speichern_item.setText("Speichern");
        speichern_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speichern_itemActionPerformed(evt);
            }
        });
        script_menu.add(speichern_item);

        speichern_unter_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        speichern_unter_item.setText("Speichern unter...");
        speichern_unter_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speichern_unter_itemActionPerformed(evt);
            }
        });
        script_menu.add(speichern_unter_item);

        menu_bar.add(script_menu);

        bearbeiten_menu.setText("Bearbeiten");
        bearbeiten_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearbeiten_menuActionPerformed(evt);
            }
        });

        undo_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undo_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Undo.png"))); // NOI18N
        undo_item.setText("Rückgängig");
        undo_item.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Redo_disabled.png"))); // NOI18N
        undo_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undo_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(undo_item);

        redo_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redo_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Redo.png"))); // NOI18N
        redo_item.setText("Wiederholen");
        redo_item.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Redo_disabled.png"))); // NOI18N
        redo_item.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Redo_disabled.png"))); // NOI18N
        redo_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redo_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(redo_item);
        bearbeiten_menu.add(jSeparator1);

        alles_markieren_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        alles_markieren_item.setText("Alles markieren");
        alles_markieren_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alles_markieren_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(alles_markieren_item);

        auschneiden_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        auschneiden_item.setText("Ausschneiden");
        auschneiden_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auschneiden_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(auschneiden_item);

        kopieren_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        kopieren_item.setText("Kopieren");
        kopieren_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kopieren_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(kopieren_item);

        entfernen_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        entfernen_item.setText("Entfernen");
        entfernen_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entfernen_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(entfernen_item);

        einfügen_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        einfügen_item.setText("Einfügen");
        einfügen_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                einfügen_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(einfügen_item);
        bearbeiten_menu.add(jSeparator2);

        tab_nach_links.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        tab_nach_links.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/tab_nach_links.png"))); // NOI18N
        tab_nach_links.setText("Ausrücken");
        tab_nach_links.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_nach_linksActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(tab_nach_links);

        tab_nach_rechts_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        tab_nach_rechts_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/tab_nach_rechts.png"))); // NOI18N
        tab_nach_rechts_item.setText("Einrücken");
        tab_nach_rechts_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab_nach_rechts_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(tab_nach_rechts_item);
        bearbeiten_menu.add(jSeparator3);

        suchen_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        suchen_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Suchen.png"))); // NOI18N
        suchen_item.setText("Suchen");
        suchen_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suchen_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(suchen_item);

        weitersuchen_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        weitersuchen_item.setText("Weitersuchen");
        weitersuchen_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weitersuchen_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(weitersuchen_item);

        ersetzen_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        ersetzen_item.setText("Ersetzen...");
        ersetzen_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ersetzen_itemActionPerformed(evt);
            }
        });
        bearbeiten_menu.add(ersetzen_item);

        menu_bar.add(bearbeiten_menu);

        editor_menu.setText("Editor");

        aktuellen_tab_schließen_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        aktuellen_tab_schließen_item.setText("Aktuellen Tab löschen");
        aktuellen_tab_schließen_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktuellen_tab_schließen_itemActionPerformed(evt);
            }
        });
        editor_menu.add(aktuellen_tab_schließen_item);

        ausgabefenster_klären_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        ausgabefenster_klären_item.setText("Text im Ausgabefenster löschen");
        ausgabefenster_klären_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ausgabefenster_klären_itemActionPerformed(evt);
            }
        });
        editor_menu.add(ausgabefenster_klären_item);

        zeilen_bruch_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        zeilen_bruch_item.setText("Zeilen im Ausbaubefenster brechen?");
        zeilen_bruch_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeilen_bruch_itemActionPerformed(evt);
            }
        });
        editor_menu.add(zeilen_bruch_item);

        regelmäßig_alle_speichern_item.setText("Regelmäßig alle Dateien speichern?");
        editor_menu.add(regelmäßig_alle_speichern_item);

        menu_bar.add(editor_menu);

        hilfe_menu.setText("Hilfe");

        sprachhilfe_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        sprachhilfe_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automation/lang/editor/resources/Hilfe.png"))); // NOI18N
        sprachhilfe_item.setText("Hilfe...");
        sprachhilfe_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sprachhilfe_itemActionPerformed(evt);
            }
        });
        hilfe_menu.add(sprachhilfe_item);

        jMenuItem3.setText("Version und Autor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        hilfe_menu.add(jMenuItem3);

        menu_bar.add(hilfe_menu);

        setJMenuBar(menu_bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ausführen_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ausführen_buttonActionPerformed
       try {
          Panel panel = getCurrentPanel();
          if (panel != null) {
             panel.ausführen(file_chooser);
          }
          updateErrorsTable();
          updateCurrentPanelTitle();
       } catch (Exception ex) {
          Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_ausführen_buttonActionPerformed

    private void öffnen_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_öffnen_itemActionPerformed
       öffnen();
    }//GEN-LAST:event_öffnen_itemActionPerformed

    private void speichern_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speichern_itemActionPerformed
       speichern();
    }//GEN-LAST:event_speichern_itemActionPerformed

    private void speichernunter_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speichernunter_itemActionPerformed
       speichern_unter();
    }//GEN-LAST:event_speichernunter_itemActionPerformed

    private void aktuellen_tab_schließen_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktuellen_tab_schließen_itemActionPerformed
       if (tabbed_pane.getTabCount() > 0) {
          tabbed_pane.remove(tabbed_pane.getSelectedIndex());
       }
    }//GEN-LAST:event_aktuellen_tab_schließen_itemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       //System.setOut(output);
    }//GEN-LAST:event_formWindowClosing

    private void undo_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undo_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.undo();
       }
    }//GEN-LAST:event_undo_itemActionPerformed

    private void redo_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redo_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.redo();
       }
    }//GEN-LAST:event_redo_itemActionPerformed

    private void script_open_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_script_open_buttonActionPerformed
       öffnen();
       tabbed_pane.remove(0);
    }//GEN-LAST:event_script_open_buttonActionPerformed

    private void neues_script_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neues_script_buttonActionPerformed
       tabbed_pane.insertTab("Unbenannt", null, new Panel(), "", tabbed_pane.getTabCount());
       tabbed_pane.setSelectedIndex(tabbed_pane.getTabCount() - 1);
       tabbed_pane.remove(0);
    }//GEN-LAST:event_neues_script_buttonActionPerformed

    private void ausführen_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ausführen_itemActionPerformed
       this.ausführen_buttonActionPerformed(evt);
    }//GEN-LAST:event_ausführen_itemActionPerformed

    private void neues_script_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neues_script_itemActionPerformed
       tabbed_pane.insertTab("Unbenannt", null, new Panel(), "", tabbed_pane.getTabCount());
       tabbed_pane.setSelectedIndex(tabbed_pane.getTabCount() - 1);
    }//GEN-LAST:event_neues_script_itemActionPerformed

    private void font_ändern_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_font_ändern_itemActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_font_ändern_itemActionPerformed

    private void suchen_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suchen_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.find_window();
       }
    }//GEN-LAST:event_suchen_itemActionPerformed

    private void bearbeiten_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bearbeiten_menuActionPerformed
       Panel panel = getCurrentPanel();
       if (panel == null) {
          return;
       }
       this.kopieren_item.setEnabled(panel.isCopyAvaliable());
       this.auschneiden_item.setEnabled(panel.isCutAvaliable());
       this.entfernen_item.setEnabled(panel.isCutAvaliable());
       this.undo_item.setEnabled(panel.isUndoAvaliable());
       this.redo_item.setEnabled(panel.isRedoAvaliable());
       this.einfügen_item.setEnabled(Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors() != null);
       this.weitersuchen_item.setEnabled(panel.isFindFurtherAvaliable());
    }//GEN-LAST:event_bearbeiten_menuActionPerformed

    private void einfügen_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_einfügen_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.einfügen();
       }
    }//GEN-LAST:event_einfügen_itemActionPerformed

    private void kopieren_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kopieren_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.kopieren();
       }
    }//GEN-LAST:event_kopieren_itemActionPerformed

    private void alles_markieren_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alles_markieren_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.alles_markieren();
       }
    }//GEN-LAST:event_alles_markieren_itemActionPerformed

    private void auschneiden_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auschneiden_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.ausschneiden();
       }
    }//GEN-LAST:event_auschneiden_itemActionPerformed

    private void entfernen_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entfernen_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.entfernen();
       }
    }//GEN-LAST:event_entfernen_itemActionPerformed

    private void weitersuchen_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weitersuchen_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.find_further();
       }
    }//GEN-LAST:event_weitersuchen_itemActionPerformed

    private void ersetzen_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ersetzen_itemActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.replace();
       }
    }//GEN-LAST:event_ersetzen_itemActionPerformed

    private void file_chooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_file_chooserPropertyChange
       if (!file_chooser.isMultiSelectionEnabled()) {
          return;
       }
       if (JFileChooser.SELECTED_FILES_CHANGED_PROPERTY == null ? evt.getPropertyName() == null : JFileChooser.SELECTED_FILES_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
          File[] filelist = (File[]) evt.getNewValue();
          if (filelist == null) {
             return;
          }
          String str = "<html><head></head><body>";
          for (File file : filelist) {
             try {
                str += "<b>" + file.getName() + "</b><blockquote>";
                BufferedReader bufreader = new BufferedReader(new FileReader(file));
                for (int i = 0; i < 5; i++) {
                   String string = bufreader.readLine();
                   if (string != null) {
                      str += string + "<br>";
                   }
                }
                str += "</blockquote>";
             } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
             }
          }
          str += "</body></html>";
          preview_textpane.setText(str);
       }
    }//GEN-LAST:event_file_chooserPropertyChange

    private void suchen_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suchen_buttonActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.find_window();
       }
    }//GEN-LAST:event_suchen_buttonActionPerformed

    private void hilfe_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hilfe_buttonActionPerformed
       java.awt.EventQueue.invokeLater(new Runnable() {

          @Override
          public void run() {
             new Help().setVisible(true);
          }
       });
    }//GEN-LAST:event_hilfe_buttonActionPerformed

    private void öffnen_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_öffnen_buttonActionPerformed
       öffnen();
    }//GEN-LAST:event_öffnen_buttonActionPerformed

    private void neu_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neu_buttonActionPerformed
       tabbed_pane.insertTab("Unbenannt", null, new Panel(), "", tabbed_pane.getTabCount());
       tabbed_pane.setSelectedIndex(tabbed_pane.getTabCount() - 1);
    }//GEN-LAST:event_neu_buttonActionPerformed

    private void speichern_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speichern_buttonActionPerformed
       speichern();
    }//GEN-LAST:event_speichern_buttonActionPerformed

    private void undo_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undo_buttonActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.undo();
       }
    }//GEN-LAST:event_undo_buttonActionPerformed

    private void redo_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redo_buttonActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.redo();
       }
    }//GEN-LAST:event_redo_buttonActionPerformed

    private void sprachhilfe_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sprachhilfe_itemActionPerformed
       java.awt.EventQueue.invokeLater(new Runnable() {

          @Override
          public void run() {
             new Help().setVisible(true);
          }
       });
    }//GEN-LAST:event_sprachhilfe_itemActionPerformed

    private void save_all_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_all_buttonActionPerformed
       Component[] comparr = tabbed_pane.getComponents();
       for (int i = 0; i < comparr.length; i++) {
          Component comp = comparr[i];
          if (comp instanceof Panel) {
             Panel panel = (Panel) comp;
             try {
                panel.speichern(file_chooser);
             } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
             }
             tabbed_pane.setTitleAt(i, panel.getTitle());
          }
       }
    }//GEN-LAST:event_save_all_buttonActionPerformed

    private void tab_nach_rechts_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_nach_rechts_buttonActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.einrücken();
       }
    }//GEN-LAST:event_tab_nach_rechts_buttonActionPerformed

    private void tab_nach_linksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_nach_linksActionPerformed
       Panel panel = getCurrentPanel();
       if (panel != null) {
          panel.ausrücken();
       }
    }//GEN-LAST:event_tab_nach_linksActionPerformed

    private void tab_nach_rechts_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_nach_rechts_itemActionPerformed
       tab_nach_rechts_buttonActionPerformed(evt);
    }//GEN-LAST:event_tab_nach_rechts_itemActionPerformed

    private void tab_nach_links_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab_nach_links_buttonActionPerformed
       tab_nach_linksActionPerformed(evt);
    }//GEN-LAST:event_tab_nach_links_buttonActionPerformed

    private void ausgabefenster_klären_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ausgabefenster_klären_itemActionPerformed
       ausgaben_fenster.setText("");
    }//GEN-LAST:event_ausgabefenster_klären_itemActionPerformed

    private void zeilen_bruch_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeilen_bruch_itemActionPerformed
       ausgaben_fenster.setLineWrap(zeilen_bruch_item.isSelected());
    }//GEN-LAST:event_zeilen_bruch_itemActionPerformed

    private void todo_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todo_tableMouseClicked
       String text = (String) todo_table.getModel().getValueAt(todo_table.getSelectedRow(), 1);
       //int offset = ((TodoListItem)todo_table.getModel().getValueAt(todo_table.getSelectedRow(), 0)).getOffset();
       for (Component comp : this.tabbed_pane.getComponents()) {
          if (comp instanceof Panel) {
             Panel panel = (Panel) comp;
             if (panel.getTitle() == null ? text == null : panel.getTitle().equals(text)) {
                //panel.setCaret(offset);
                tabbed_pane.setSelectedComponent(comp);
                break;
             }
          }
       }
    }//GEN-LAST:event_todo_tableMouseClicked

    private void speichern_unter_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speichern_unter_itemActionPerformed
       speichern_unter();
    }//GEN-LAST:event_speichern_unter_itemActionPerformed

   private void automat_testen_panelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_automat_testen_panelFocusGained
      autesten_ausdruck_box.setModel(new DefaultComboBoxModel(getCurrentPanel().getTestPhrases()));
   }//GEN-LAST:event_automat_testen_panelFocusGained

   private void autesten_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autesten_buttonActionPerformed
      test();
   }//GEN-LAST:event_autesten_buttonActionPerformed

   private void errors_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errors_tableMouseClicked
      // TODO add your handling code here:
   }//GEN-LAST:event_errors_tableMouseClicked

   private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      new Help();
   }//GEN-LAST:event_jMenuItem3ActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /*
       * Set the Nimbus look and feel
       */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
       * If Nimbus (introduced in Java SE 6) is not available, stay with the
       * default look and feel. For details see
       * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /*
       * Create and display the form
       */
      java.awt.EventQueue.invokeLater(new Runnable() {

         public void run() {
            new Editor().setVisible(true);
         }
      });
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aktuellen_tab_schließen_item;
    private javax.swing.JMenuItem alles_markieren_item;
    private javax.swing.JMenuItem auschneiden_item;
    private javax.swing.JButton ausführen_button;
    private javax.swing.JMenuItem ausführen_item;
    private javax.swing.JMenuItem ausgabefenster_klären_item;
    private javax.swing.JTextArea ausgaben_fenster;
    private javax.swing.JComboBox autesten_ausdruck_box;
    private javax.swing.JTextArea autesten_ausgabe;
    private javax.swing.JButton autesten_button;
    private javax.swing.JPanel automat_testen_panel;
    private javax.swing.JMenu bearbeiten_menu;
    private javax.swing.JMenu beispiele_menu;
    private javax.swing.JMenu editor_menu;
    private javax.swing.JMenuItem einfügen_item;
    private javax.swing.JMenuItem entfernen_item;
    private javax.swing.JScrollPane errors_scrollpane;
    private javax.swing.JTable errors_table;
    private javax.swing.JMenuItem ersetzen_item;
    private javax.swing.JFileChooser file_chooser;
    private javax.swing.JMenuItem font_ändern_item;
    private javax.swing.JButton hilfe_button;
    private javax.swing.JMenu hilfe_menu;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jflap_testarea;
    private javax.swing.JMenuItem kopieren_item;
    private javax.swing.JMenuBar menu_bar;
    private javax.swing.JButton neu_button;
    private javax.swing.JButton neues_script_button;
    private javax.swing.JMenuItem neues_script_item;
    private javax.swing.JScrollPane preview_scrollpane;
    private javax.swing.JTextPane preview_textpane;
    private javax.swing.JButton redo_button;
    private javax.swing.JMenuItem redo_item;
    private javax.swing.JRadioButtonMenuItem regelmäßig_alle_speichern_item;
    private javax.swing.JButton save_all_button;
    private javax.swing.JMenu script_menu;
    private javax.swing.JButton script_open_button;
    private javax.swing.JButton speichern_button;
    private javax.swing.JMenuItem speichern_item;
    private javax.swing.JMenuItem speichern_unter_item;
    private javax.swing.JMenuItem sprachhilfe_item;
    private javax.swing.JButton suchen_button;
    private javax.swing.JMenuItem suchen_item;
    private javax.swing.JMenuItem tab_nach_links;
    private javax.swing.JButton tab_nach_links_button;
    private javax.swing.JButton tab_nach_rechts_button;
    private javax.swing.JMenuItem tab_nach_rechts_item;
    private javax.swing.JTabbedPane tabbed_pane;
    private javax.swing.JTabbedPane tabbed_pane_unten;
    private javax.swing.JTable todo_table;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JButton undo_button;
    private javax.swing.JMenuItem undo_item;
    private javax.swing.JMenuItem weitersuchen_item;
    private javax.swing.JPanel willkommen_panel;
    private javax.swing.JRadioButtonMenuItem zeilen_bruch_item;
    private javax.swing.JButton öffnen_button;
    private javax.swing.JMenuItem öffnen_item;
    // End of variables declaration//GEN-END:variables

   private void öffnen() {
      file_chooser.setMultiSelectionEnabled(true);
      file_chooser.showOpenDialog(this);
      File[] files = file_chooser.getSelectedFiles();
      file_chooser.setMultiSelectionEnabled(false);
      öffnen(files);
   }

   /**
    * Öffnet die Dateien des übergebenen Datei Arrays
    *
    * @param files Datei Array
    */
   public void öffnen(File[] files) {
      for (File file : files) {
         if (file.exists() && !file.isDirectory() && file.getName().endsWith(FILE_ENDING)) {
            Panel panel = new Panel();
            try {
               panel.öffnen(file);
               tabbed_pane.insertTab(panel.getTitle(), null, panel, "", tabbed_pane.getTabCount());
               tabbed_pane.setSelectedIndex(tabbed_pane.getTabCount() - 1);
            } catch (IOException ex) {
               Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
      }
   }

   /**
    * Öffnet die Dateien der übergebenen Dateiliste
    *
    * @param filelist Dateiliste
    */
   public void öffnen(List<File> filelist) {
      öffnen((File[]) filelist.toArray());
   }

   /**
    * Speichert den Text des aktuellen Tab Panels
    */
   public void speichern() {
      //ausgaben_area.append("Datei speichern \n");
      Panel panel = getCurrentPanel();
      if (panel == null) {
         return;
      }
      try {
         panel.speichern(file_chooser);
      } catch (IOException ex) {
         Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
      }
      tabbed_pane.setTitleAt(tabbed_pane.getSelectedIndex(), panel.getTitle());
   }

   private void speichern_unter() {
      //ausgaben_area.append("Datei speichern");
      Panel panel = getCurrentPanel();
      if (panel == null) {
         return;
      }
      try {
         panel.speichern_unter(file_chooser);
      } catch (IOException ex) {
         Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
      }
      updateCurrentPanelTitle();
   }

   private Panel getCurrentPanel() {
      Component comp = tabbed_pane.getSelectedComponent();
      if (comp instanceof Panel) {
         return (Panel) comp;
      }
      return null;
   }

   private void loadExamples() {
      int num = 0;
      for (String path : EXAMPLES) {
         path = "/automation/lang/editor/resources/examples/" + path;
         path = getClass().getResource(path).getPath();
         File file = new File(path);
         if (file.getName().endsWith(FILE_ENDING)) {
            JMenuItem item = new JMenuItem();
            item.setText(file.getName().replace('_', ' ').substring(0, file.getName().replace('_', ' ').length() - 3));
            item.setActionCommand(num + "");
            beispiele_menu.add(item);
            item.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                  String path = "/automation/lang/editor/resources/examples/" + EXAMPLES[Integer.parseInt(e.getActionCommand())];
                  öffnen(new File[]{
                             new File(getClass().getResource(path).getFile())
                          });
               }
            });
         }
         num++;
      }
   }

   private synchronized void updateTodoList() {
      todo_table.removeAll();
      ArrayList<Object[]> objlist = new ArrayList<Object[]>();
      for (Component comp : this.tabbed_pane.getComponents()) {
         if (comp instanceof Panel) {
            ArrayList<TodoListItem> list = ((Panel) comp).getTodoList();
            for (TodoListItem item : list) {
               objlist.add(new Object[]{
                          (Object) item,
                          (Object) item.getPanel().getTitle(),
                          (Object) item.getLine()
                       });
            }
         }
      }
      DefaultTableModel model = (DefaultTableModel) todo_table.getModel();
      for (int i = model.getRowCount() - 1; i >= 0; i--) {
         model.removeRow(0);
      }
      for (Object[] objects : objlist) {
         model.addRow(objects);
      }
   }

   public void updateErrorsTable() {
      Panel panel = getCurrentPanel();
      if (panel == null) {
         return;
      }
      panel.simpleExecute();
      ArrayList<Tree.Error> errors = panel.getErrors();
      tabbed_pane_unten.setTitleAt(1, "Errors" + (errors.size() > 0 ? ("(" + errors.size() + ")") : ""));
      DefaultTableModel model = (DefaultTableModel) errors_table.getModel();
      for (int i = model.getRowCount() - 1; i >= 0; i--) {
         model.removeRow(0);
      }
      for (Tree.Error error : errors) {
         model.addRow(new Object[]{
                    (Object) error.line,
                    (Object) error.offset,
                    (Object) error.msg
                 });
      }
      String ser = panel.getTree().serialize();
      if (jflap_testarea.getText() != ser) {
         jflap_testarea.setText(ser);
      }
   }

   private void test() {
      String phrase = (String) autesten_ausdruck_box.getSelectedItem();
      Panel panel = getCurrentPanel();
      panel.addTestPhrase(phrase);
      panel.simpleExecute();
      Tree tree = panel.getTree();
      long time = System.currentTimeMillis();
      TestReturn ret = tree.test(phrase);
      System.out.println("Test phrase (" + (System.currentTimeMillis() - time) + "ms)...");
      String str = "";
      if (tree.getMode() == Tree.Mode.FINITE) {
         if (ret.succeeded) {
            autesten_ausgabe.setBackground(Color.GREEN.brighter().brighter());
            str = "Akzeptiert";
         } else {
            autesten_ausgabe.setBackground(Color.RED.brighter().brighter());
            str = "Nicht akzeptiert";
         }
      } else if (tree.getMode() == Tree.Mode.MEALY) {
         str = ret.text;
      }
      if (!str.equals(autesten_ausgabe.getText())) {
         autesten_ausgabe.setText(str);
      }
   }
}