
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EksplorasiGUI extends JFrame implements ActionListener {

    private JLabel labelJudul, labelNama, labelNIM, labelHasil;
    private JTextField fieldNama, fieldNIM;
    private JTextArea areaHasil;
    private JButton tombolProses, tombolHapus, tombolKeluar;

    private JPanel panelUtama, panelForm, panelTombol, panelHasil;

    public EksplorasiGUI() {

        setTitle("Eksplorasi GUI - Java Swing");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelUtama = new JPanel(new BorderLayout(10, 10));
        panelUtama.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        labelJudul = new JLabel(
            "FORM DATA MAHASISWA",
            SwingConstants.CENTER
        );
        labelJudul.setFont(new Font("Arial", Font.BOLD, 20));

        panelUtama.add(labelJudul, BorderLayout.NORTH);

        panelForm = new JPanel(new GridLayout(2, 2, 10, 15));

        labelNama = new JLabel("Nama Mahasiswa:");
        fieldNama = new JTextField();

        labelNIM = new JLabel("NIM:");
        fieldNIM = new JTextField();

        panelForm.add(labelNama);
        panelForm.add(fieldNama);
        panelForm.add(labelNIM);
        panelForm.add(fieldNIM);

        panelUtama.add(panelForm, BorderLayout.CENTER);

        panelHasil = new JPanel(new BorderLayout(5, 5));

        labelHasil = new JLabel("Hasil Input:");
        areaHasil = new JTextArea(5, 30);
        areaHasil.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(areaHasil);

        panelHasil.add(labelHasil, BorderLayout.NORTH);
        panelHasil.add(scrollPane, BorderLayout.CENTER);

        panelUtama.add(panelHasil, BorderLayout.SOUTH);

        panelTombol = new JPanel(new FlowLayout());

        tombolProses = new JButton("Proses");
        tombolHapus = new JButton("Hapus");
        tombolKeluar = new JButton("Keluar");

        panelTombol.add(tombolProses);
        panelTombol.add(tombolHapus);
        panelTombol.add(tombolKeluar);

        tombolProses.addActionListener(this);
        tombolHapus.addActionListener(this);
        tombolKeluar.addActionListener(this);

        panelUtama.add(panelTombol, BorderLayout.PAGE_END);

        add(panelUtama);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == tombolProses) {

            String nama = fieldNama.getText();
            String nim = fieldNIM.getText();

            if (nama.isEmpty() || nim.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Nama dan NIM harus diisi!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
                );
            } else {
                areaHasil.setText(
                    "Data Mahasiswa\n" +
                    "Nama : " + nama + "\n" +
                    "NIM  : " + nim
                );
            }

        } else if (e.getSource() == tombolHapus) {

            fieldNama.setText("");
            fieldNIM.setText("");
            areaHasil.setText("");

        } else if (e.getSource() == tombolKeluar) {

            dispose();

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EksplorasiGUI();
        });
    }
}
