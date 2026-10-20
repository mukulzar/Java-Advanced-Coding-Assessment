import javax.swing.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {

    JLabel rollLabel, nameLabel, ageLabel, genderLabel;
    JLabel emailLabel, mobileLabel, courseLabel, addressLabel;

    JTextField rollField, nameField, ageField;
    JTextField emailField, mobileField;

    JTextArea addressArea;

    JRadioButton male, female, other;
    ButtonGroup genderGroup;

    JComboBox<String> courseBox;

    JCheckBox terms;

    JButton submitButton, resetButton;

    public StudentRegistration() {

        setTitle("Student Registration Form");
        setSize(500, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rollLabel = new JLabel("Roll No:");
        rollLabel.setBounds(30, 20, 100, 25);
        add(rollLabel);

        rollField = new JTextField();
        rollField.setBounds(150, 20, 200, 25);
        add(rollField);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 60, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 200, 25);
        add(nameField);

        // RESTRICTION 1: Name field - Allow ONLY letters and spaces
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignore input
                }
            }
        });

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(30, 100, 100, 25);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 100, 200, 25);
        add(ageField);

        // RESTRICTION 2: Age field - Allow ONLY numbers and MAX 2 digits
        ageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || ageField.getText().length() >= 2) {
                    e.consume(); // Ignore input
                }
            }
        });

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 140, 100, 25);
        add(genderLabel);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        male.setBounds(150, 140, 70, 25);
        female.setBounds(230, 140, 80, 25);
        other.setBounds(320, 140, 80, 25);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        add(male);
        add(female);
        add(other);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 180, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 180, 200, 25);
        add(emailField);

        mobileLabel = new JLabel("Mobile:");
        mobileLabel.setBounds(30, 220, 100, 25);
        add(mobileLabel);

        mobileField = new JTextField();
        mobileField.setBounds(150, 220, 200, 25);
        add(mobileField);

        // RESTRICTION 3: Mobile field - Allow ONLY numbers and MAX 10 digits
        mobileField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || mobileField.getText().length() >= 10) {
                    e.consume(); // Ignore input
                }
            }
        });

        courseLabel = new JLabel("Course:");
        courseLabel.setBounds(30, 260, 100, 25);
        add(courseLabel);

        String[] courses = {
                "B.Tech CSE",
                "B.Tech AI",
                "BCA",
                "MCA",
                "MBA"
        };

        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(150, 260, 200, 25);
        add(courseBox);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 300, 100, 25);
        add(addressLabel);

        addressArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(addressArea);
        scrollPane.setBounds(150, 300, 200, 60);
        add(scrollPane);

        terms = new JCheckBox("I accept Terms and Conditions");
        terms.setBounds(120, 380, 250, 25);
        add(terms);

        submitButton = new JButton("Submit");
        submitButton.setBounds(120, 430, 100, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(250, 430, 100, 30);

        submitButton.addActionListener(this);
        resetButton.addActionListener(this);

        add(submitButton);
        add(resetButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            String roll = rollField.getText().trim();
            String name = nameField.getText().trim();
            String age = ageField.getText().trim();
            String email = emailField.getText().trim();
            String mobile = mobileField.getText().trim();
            String address = addressArea.getText().trim();
            String course = (String) courseBox.getSelectedItem();

            String gender = "";

            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else if (other.isSelected()) {
                gender = "Other";
            }

            // Empty field check
            if (roll.isEmpty() || name.isEmpty() || age.isEmpty()
                    || email.isEmpty() || mobile.isEmpty()
                    || gender.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please fill all the details.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Additional Length check on Mobile to ensure full 10 digits were entered
            if (mobile.length() < 10) {
                JOptionPane.showMessageDialog(this,
                        "Mobile number must be exactly 10 digits.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Terms Check
            if (!terms.isSelected()) {
                JOptionPane.showMessageDialog(this,
                        "Please accept Terms and Conditions.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Success Dialog
            JOptionPane.showMessageDialog(this,
                    "Registration Successful!\n\n"
                            + "Roll No : " + roll
                            + "\nName : " + name
                            + "\nAge : " + age
                            + "\nGender : " + gender
                            + "\nEmail : " + email
                            + "\nMobile : " + mobile
                            + "\nCourse : " + course
                            + "\nAddress : " + address);
        }

        if (e.getSource() == resetButton) {

            rollField.setText("");
            nameField.setText("");
            ageField.setText("");
            emailField.setText("");
            mobileField.setText("");
            addressArea.setText("");

            genderGroup.clearSelection();
            courseBox.setSelectedIndex(0);
            terms.setSelected(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistration());
    }
}