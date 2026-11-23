import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EksplorasiGUI extends JFrame implements ActionListener {

    private JLabel labelJudul, labelNama, labelNIM, labelHasil;
    private JTextField fieldNama, fieldNIM;
    private JTextArea areaHasil;
    private JButton tombolKirim, tombolHapus, tombolKeluar;
    private JPanel panelUtama, panelForm, panelTengah, panelTombol, panelHasil;

    public EksplorasiGUI() {
        setTitle("Eksplorasi GUI");
        setSize(480, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color warnaUtama = new Color(234, 242, 255);
        Color warnaForm = new Color(232, 248, 240);
        Color warnaHasil = new Color(255, 248, 230);
        Color warnaTombol = new Color(243, 238, 255);

        Color warnaBorder = new Color(160, 168, 178);
        Color warnaTeks = new Color(25, 25, 25);
        Font fontJudul = new Font("SansSerif", Font.BOLD, 18);
        Font fontLabel = new Font("SansSerif", Font.PLAIN, 13);
        Font fontInput = new Font("SansSerif", Font.PLAIN, 13);
        Font fontTombol = new Font("SansSerif", Font.PLAIN, 12);

        panelUtama = new JPanel(new BorderLayout(0, 12));
        panelUtama.setBackground(warnaUtama);
        panelUtama.setBorder(new EmptyBorder(16, 18, 16, 18));

        labelJudul = new JLabel("FORM DATA MAHASISWA", SwingConstants.CENTER);
        labelJudul.setFont(fontJudul);
        labelJudul.setForeground(warnaTeks);
        panelUtama.add(labelJudul, BorderLayout.NORTH);

        panelForm = new JPanel(new GridLayout(2, 2, 10, 10));
        panelForm.setBackground(warnaForm);
        panelForm.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(warnaBorder, 1),
            new EmptyBorder(10, 12, 10, 12)
        ));

        labelNama = new JLabel("Nama Mahasiswa:");
        labelNama.setFont(fontLabel);
        labelNama.setForeground(warnaTeks);

        fieldNama = new JTextField();
        fieldNama.setFont(fontInput);
        fieldNama.setForeground(warnaTeks);
        fieldNama.setBackground(Color.WHITE);
        fieldNama.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(warnaBorder, 1),
            new EmptyBorder(4, 8, 4, 8)
        ));

        labelNIM = new JLabel("NIM:");
        labelNIM.setFont(fontLabel);
        labelNIM.setForeground(warnaTeks);

        fieldNIM = new JTextField();
        fieldNIM.setFont(fontInput);
        fieldNIM.setForeground(warnaTeks);
        fieldNIM.setBackground(Color.WHITE);
        fieldNIM.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(warnaBorder, 1),
            new EmptyBorder(4, 8, 4, 8)
        ));

        panelForm.add(labelNama);
        panelForm.add(fieldNama);
        panelForm.add(labelNIM);
        panelForm.add(fieldNIM);

        panelHasil = new JPanel(new BorderLayout(0, 6));
        panelHasil.setBackground(warnaHasil);
        panelHasil.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(warnaBorder, 1),
            new EmptyBorder(10, 12, 10, 12)
        ));

        labelHasil = new JLabel("Hasil Input:");
        labelHasil.setFont(fontLabel);
        labelHasil.setForeground(warnaTeks);

        areaHasil = new JTextArea(4, 30);
        areaHasil.setFont(fontInput);
        areaHasil.setForeground(warnaTeks);
        areaHasil.setBackground(Color.WHITE);
        areaHasil.setEditable(false);
        areaHasil.setLineWrap(true);
        areaHasil.setWrapStyleWord(true);
        areaHasil.setBorder(new EmptyBorder(6, 8, 6, 8));

        JScrollPane scrollPane = new JScrollPane(areaHasil);
        scrollPane.setBorder(new LineBorder(warnaBorder, 1));
        scrollPane.getViewport().setBackground(Color.WHITE);

        panelHasil.add(labelHasil, BorderLayout.NORTH);
        panelHasil.add(scrollPane, BorderLayout.CENTER);

        panelTengah = new JPanel();
        panelTengah.setLayout(new BoxLayout(panelTengah, BoxLayout.Y_AXIS));
        panelTengah.setOpaque(false);

        panelForm.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelHasil.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelTengah.add(panelForm);
        panelTengah.add(Box.createVerticalStrut(12));
        panelTengah.add(panelHasil);

        panelUtama.add(panelTengah, BorderLayout.CENTER);

        panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 4));
        panelTombol.setBackground(warnaTombol);
        panelTombol.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(warnaBorder, 1),
            new EmptyBorder(6, 10, 6, 10)
        ));

        tombolKirim = buatTombol("Kirim", warnaTeks, warnaBorder, fontTombol);
        tombolHapus = buatTombol("Hapus", warnaTeks, warnaBorder, fontTombol);
        tombolKeluar = buatTombol("Keluar", warnaTeks, warnaBorder, fontTombol);

        panelTombol.add(tombolKirim);
        panelTombol.add(tombolHapus);
        panelTombol.add(tombolKeluar);

        tombolKirim.addActionListener(this);
        tombolHapus.addActionListener(this);
        tombolKeluar.addActionListener(this);

        panelUtama.add(panelTombol, BorderLayout.SOUTH);

        add(panelUtama);
        setVisible(true);
    }

    private JButton buatTombol(String teks, Color warnaTeks, Color warnaBorder, Font font) {
        JButton tombol = new JButton(teks);
        tombol.setFont(font);
        tombol.setForeground(warnaTeks);
        tombol.setBackground(Color.WHITE);
        tombol.setFocusPainted(false);
        tombol.setPreferredSize(new Dimension(92, 28));
        tombol.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(warnaBorder, 1),
            new EmptyBorder(3, 10, 3, 10)
        ));
        return tombol;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolKirim) {
            String nama = fieldNama.getText().trim();
            String nim = fieldNIM.getText().trim();

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
            fieldNama.requestFocus();
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
