package automatonlang.editor.panel;

/**
 * Klasse, die als GUI für die Ersetzenmethode dient
 * 
 * @author Johannes Bechberger
 */
public class ReplaceFrame extends javax.swing.JFrame {

    /**
     * Suchen Listener
     */
    public abstract static class SuchenListener {

        /**
         * Methode die aufgerufen wird, wenn der Benutzer ein Suchwort eingibt
         * @param evt Such Event
         */
        public abstract void actionPerformed(SuchenEvent evt);
    }

    /**
     * Suchen Event
     */
    public static class SuchenEvent {

        private String suchwort;

        /**
         * Konstruktor dieser Klasse
         * @param suchwort 
         */
        public SuchenEvent(String suchwort) {
            this.suchwort = suchwort;
        }

        /**
         * Gibt das Suchwort zurück
         * @return Suchwort
         */
        public String getSuchwort() {
            return suchwort;
        }
    }

    /**
     * Ersetzen Listener
     */
    public abstract static class ErsetzenListener {

        /**
         * Methode die aufgerufen wird wenn der Benutzer ein Wort ersetzen will
         * @param evt Ersetzen Event
         */
        public abstract void actionPerformed(ErsetzenEvent evt);
    }

    /**
     * Ersetzen Event
     */
    public static class ErsetzenEvent {

        private String suchwort;
        private String ersetzungswort;

        /**
         * Konstruktor dieser Klasse
         * @param suchwort Zu ersetzendes Wort
         * @param ersetzungswort Wort, mit dem das zu ersetzende Wort ersetzt wird
         */
        public ErsetzenEvent(String suchwort, String ersetzungswort) {
            this.suchwort = suchwort;
            this.ersetzungswort = ersetzungswort;
        }

        /**
         * Gibt das zu ersetzende Wort zurück
         * @return Das zu ersetzende Wort
         */
        public String getSuchwort() {
            return suchwort;
        }

        /**
         * Gibt das Wort zurück, mit dem das zu ersetzende Wort ersetzt wird
         * @return Ersetzungswort
         */
        public String getErsetzungswort() {
            return ersetzungswort;
        }
    }
    private ErsetzenListener ersetzen_listener;
    private SuchenListener suchen_listener;

    /** Creates new form ReplaceFrame */
    public ReplaceFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        suchbegriff_feld = new javax.swing.JTextField();
        ersetzen_button = new javax.swing.JButton();
        ersetzungstext_feld = new javax.swing.JTextField();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("automatonlang/editor/resources/localizations/localization"); // NOI18N
        setTitle(bundle.getString("ERSETZEN")); // NOI18N
        setAlwaysOnTop(true);
        setResizable(false);

        suchbegriff_feld.setToolTipText(bundle.getString("ZU ERSETZENDER STRING")); // NOI18N
        suchbegriff_feld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                suchbegriff_feldKeyReleased(evt);
            }
        });

        ersetzen_button.setText(bundle.getString("ERSETZEN")); // NOI18N
        ersetzen_button.setFocusCycleRoot(true);
        ersetzen_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ersetzen_buttonActionPerformed(evt);
            }
        });

        ersetzungstext_feld.setToolTipText(bundle.getString("STRING MIT WELCHEM DER NEBENSTEHENDE ERSETZT WIRD")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(suchbegriff_feld, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ersetzungstext_feld, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ersetzen_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(suchbegriff_feld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ersetzen_button)
                .addComponent(ersetzungstext_feld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ersetzen_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ersetzen_buttonActionPerformed
        ersetzen_listener.actionPerformed(new ErsetzenEvent(suchbegriff_feld.getText(), ersetzungstext_feld.getText()));
}//GEN-LAST:event_ersetzen_buttonActionPerformed

    private void suchbegriff_feldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suchbegriff_feldKeyReleased
        if (suchbegriff_feld.getText().matches(java.util.ResourceBundle.getBundle("automation/lang/editor/resources/localization").getString("(SUCHBEGRIFF)+"))) {
            suchbegriff_feld.setText(evt.getKeyChar() + "");
        }
        suchen_listener.actionPerformed(new SuchenEvent(suchbegriff_feld.getText()));
    }//GEN-LAST:event_suchbegriff_feldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ReplaceFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ersetzen_button;
    private javax.swing.JTextField ersetzungstext_feld;
    private javax.swing.JTextField suchbegriff_feld;
    // End of variables declaration//GEN-END:variables

    /**
     * @param ersetzen_listener the ersetzen_listener to set
     */
    public void setErsetzen_listener(ErsetzenListener ersetzen_listener) {
        this.ersetzen_listener = ersetzen_listener;
    }

    /**
     * @param suchen_listener the suchen_listener to set
     */
    public void setSuchen_listener(SuchenListener suchen_listener) {
        this.suchen_listener = suchen_listener;
    }

    /**
     * Setzt den Suchtext, der im Suchtext Fenster als zu ersetzender Text gesetzt
     * wird
     * @param text Suchtext
     */
    public void setSuchentext(String text) {
        this.suchbegriff_feld.setText(text == null ? "" : text);
    }
}
