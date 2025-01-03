package AlgasKalkulators;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class Ramis extends JFrame implements ActionListener {
    JLabel virsraksts, izvele, gadaIzvele, alga, apgad, inval, statuss, min, rez;
    JButton poga;
    JTextField algasApmers, apgadSk, neaplMin, aprekins;
    JComboBox<String> netoBruto, gads, invalGrupas;
    JPanel galvene, ievade, rezultats;
    JCheckBox citiAtviegl;
    Dati dati;
    private static final double VSAOI_LIKME = 0.105;
    double Eiro, Min, Rezultats, neto;
    int Apgad, GadaVert, cituAtvieglSumma, Inval;
    ImageIcon yes, no;

    Font fonts = new Font("Barlow Semi Condensed", Font.BOLD, 18);

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setVisible(true);
        return label;
    }

    private JTextField createTextField(String defaultText, Font font, boolean editable) {
        JTextField textField = new JTextField(defaultText);
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBackground(new Color(194, 216, 185));
        textField.setEditable(editable);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                textField.selectAll();
            }
        });
        return textField;
    }

    private JComboBox<String> createComboBox(String[] options, Font font) {

        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(font);
        ((BasicComboBoxRenderer) comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        comboBox.setBorder(BorderFactory.createRaisedBevelBorder());
        comboBox.setBackground(new Color(194, 216, 185));
        comboBox.addActionListener(this);
        return comboBox;
    }

    private void ievadesPanelis() {
        ievade = new JPanel(new GridLayout(7, 2, 20, 20));
        ievade.setBounds(30, 85, 600, 550);
        ievade.setBackground(new Color(228, 240, 208));

        izvele = createLabel("Ko Tu vēlies āprēķināt?", fonts);
        netoBruto = createComboBox(new String[] { "Neto no Bruto", "Bruto no Neto" }, fonts);

        gadaIzvele = createLabel("Aprēķinu gads", fonts);
        gads = createComboBox(dati.getKeys("gadiApgad"), fonts);
        SwingUtilities.invokeLater(() -> {
            gads.setSelectedIndex(1);
            gads.actionPerformed(new ActionEvent(gads, ActionEvent.ACTION_PERFORMED, null));
            gads.revalidate();
            gads.repaint();
        });

        alga = createLabel("Algas apmērs (EUR)", fonts);
        algasApmers = createTextField("1000", fonts, true);

        apgad = createLabel("Apgādībā esošo personu skaits", fonts);
        apgadSk = createTextField("0", fonts, true);

        min = createLabel("Neapliekamais minimums (EUR)", fonts);
        neaplMin = createTextField("0", fonts, true);

        inval = createLabel("Invaliditāte", fonts);
        invalGrupas = createComboBox(dati.getKeys("invaliditate"), fonts);

        statuss = createLabel(
                "<html>Politiski represētās personas<br/>vai neatkarības pretošanās kustības dalībnieka statuss<html>",
                fonts);
        statuss.setFont(new Font("Barlow Condensed", Font.BOLD, 17));
        citiAtviegl = new JCheckBox();
        citiAtviegl.setHorizontalAlignment(JCheckBox.CENTER);
        citiAtviegl.setBackground(new Color(228, 240, 208));
        citiAtviegl.addActionListener(this);
        yes = new ImageIcon(getClass().getResource("/images/yes.png"));
        no = new ImageIcon(getClass().getResource("/images/no.png"));
        citiAtviegl.setIcon(no);
        citiAtviegl.setSelectedIcon(yes);

        ievade.add(izvele);
        ievade.add(netoBruto);
        ievade.add(gadaIzvele);
        ievade.add(gads);
        ievade.add(alga);
        ievade.add(algasApmers);
        ievade.add(apgad);
        ievade.add(apgadSk);
        ievade.add(min);
        ievade.add(neaplMin);
        ievade.add(inval);
        ievade.add(invalGrupas);
        ievade.add(statuss);
        ievade.add(citiAtviegl);
        this.add(ievade);
    }

    public void galvenesPanelis() {
        galvene = new JPanel();
        galvene.setBounds(0, 15, 1050, 65);
        galvene.setBackground(new Color(228, 240, 208));
        virsraksts = new JLabel("Algas Kalkulators");
        virsraksts.setBounds(100, 135, 100, 100);
        virsraksts.setFont(new Font("Barlow Semi Condensed", Font.BOLD, 35));
        virsraksts.setVisible(true);

        galvene.add(virsraksts);
        this.add(galvene);
    }

    public void aprekinuPanelis() {
        rezultats = new JPanel();
        rezultats.setBounds(675, 150, 300, 150);
        rezultats.setBackground(new Color(228, 240, 208));
        rezultats.setLayout(new GridLayout(2, 1, 0, 20));

        rez = createLabel("REZULTĀTS:", fonts);
        rez.setBackground(new Color(161, 181, 216));
        rez.setOpaque(true);
        rez.setHorizontalAlignment(JTextField.CENTER);
        rezultats.add(rez);

        aprekins = createTextField("00.00", fonts, false);
        aprekins.setBackground(new Color(255, 252, 247));
        rezultats.add(aprekins);
        this.add(rezultats);
    }

    // Pats logs
    Ramis(Dati dati) {
        this.dati = dati;
        galvenesPanelis();
        ievadesPanelis();
        aprekinuPanelis();

        this.setTitle("Algas Kalkulators");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1050, 720);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(228, 240, 208));
        ImageIcon image = new ImageIcon(getClass().getResource("/images/calculator.png"));
        this.setIconImage(image.getImage());

        poga = new JButton();
        poga.setBounds(725, 350, 200, 70);
        poga.addActionListener(this);
        poga.setText("APRĒĶINĀT");
        poga.setFocusable(false);
        poga.setFont(fonts);
        poga.setForeground(Color.white);
        poga.setBackground(new Color(115, 130, 144));
        poga.setBorder(BorderFactory.createRaisedBevelBorder());

        poga.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "pressEnter");
        poga.getActionMap().put("pressEnter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                poga.doClick();
            }
        });
        this.add(poga);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == invalGrupas) {
            String izvelKey = (String) invalGrupas.getSelectedItem();
            Inval = dati.getValue("invaliditate", izvelKey);
            if (gads.getSelectedItem().equals("2025")) {
                if (!izvelKey.equals("NAV")) {
                    neaplMin.setText("500");
                    neaplMin.setToolTipText("Izvēlies starp 500 un 0!");
                    neaplMin.setEditable(true);
                    neaplMin.setBackground(new Color(194, 216, 185));
                    neaplMin.setBorder(BorderFactory.createEtchedBorder());
                } else {
                    neaplMin.setText("510");
                    neaplMin.setEditable(false);
                    neaplMin.setBackground(new Color(209, 216, 207));
                    neaplMin.setBorder(BorderFactory.createEtchedBorder());
                }
            }
        }
        if (e.getSource() == gads) {
            String izvelKey = (String) gads.getSelectedItem();
            GadaVert = dati.getValue("gadiApgad", izvelKey);
            if (izvelKey.equals("2025")) {
                neaplMin.setText("510");
                neaplMin.setEditable(false);
                neaplMin.setBackground(new Color(209, 216, 207));
                neaplMin.setBorder(BorderFactory.createEtchedBorder());
                if (!invalGrupas.getSelectedItem().equals("NAV")) {
                    neaplMin.setText("500");
                }
                neaplMin.setToolTipText("Neapliekamais minimums ir fiksēts!");
            } else {
                neaplMin.setText("0");
                neaplMin.setToolTipText(null);
                neaplMin.setEditable(true);
                neaplMin.setBackground(new Color(194, 216, 185));
            }
        }
        if (e.getSource() == citiAtviegl) {
            if (citiAtviegl.isSelected() == true) {
                cituAtvieglSumma = 154;
            } else {
                cituAtvieglSumma = 0;
            }
        }
        if (e.getSource() == poga) {
            try {
                Eiro = Double.parseDouble(algasApmers.getText());
                Apgad = Integer.parseInt(apgadSk.getText());
                Min = Double.parseDouble(neaplMin.getText());
                if (Eiro < 0 || Apgad < 0 || Min < 0) {
                    JOptionPane.showMessageDialog(null, "Ievadi pozitīvas vērtības!", "Kļūda",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (netoBruto.getSelectedItem().equals("Neto no Bruto")) {
                        if (gads.getSelectedItem().equals("2025")) {
                            Rezultats = Divdesmitpieci.neto25(Eiro, Apgad, Min, GadaVert, cituAtvieglSumma, Inval,
                                    VSAOI_LIKME);
                        } else {
                            Rezultats = NetoNoBruto.netoNoBruto(Eiro, Apgad, Min, GadaVert, cituAtvieglSumma, Inval,
                                    VSAOI_LIKME);
                        }
                    } else {
                        if (gads.getSelectedItem().equals("2025")) {
                            Rezultats = Divdesmitpieci.bruto25(Eiro, Apgad, Min, GadaVert, cituAtvieglSumma, Inval,
                                    VSAOI_LIKME);
                        } else {
                            Rezultats = BrutoNoNeto.brutoNoNeto(Eiro, Apgad, Min, GadaVert, cituAtvieglSumma, Inval,
                                    VSAOI_LIKME);
                        }
                    }
                    aprekins.setText(String.format("%.2f", Rezultats));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ievadi tikai skaitliskas vērtības!", "Kļūda",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}