import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {
    private JLabel inputLabel;
    private JTextField inputField;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounterApp() {
        setTitle("Word Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputLabel = new JLabel("Enter Paragraph:");
        inputField = new JTextField(20);
        countButton = new JButton("Count Words");
        resultLabel = new JLabel();

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                int wordCount = countWords(inputText);
                resultLabel.setText("Number of words: " + wordCount);
            }
        });

        JPanel panel = new JPanel();
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(countButton);
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterApp();
            }
        });
    }
}
