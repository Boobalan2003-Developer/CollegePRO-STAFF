package eascpkg;

import static eascpkg.staffDashBoard.profileimg;

import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoginFrame extends javax.swing.JFrame {

    private static Stack<JPanel> Sign_up_panelHistory = new Stack<>();
    List<String> collegedetails = new ArrayList<>();
    List<String> schooldetails = new ArrayList<>();
    int sw, sh;
    public static String username, pass, userID;
    static int random_Number;

    //For enter Key Pressed to ahndle Event..
//    final 
    public LoginFrame() {
        initComponents();

        try {
            File fontstl1 = new File("D:\\Font Styles\\Poppins\\Poppins-Medium.ttf");
            Font f1 = Font.createFont(Font.TRUETYPE_FONT, fontstl1).deriveFont(18f);
            Font f2 = Font.createFont(Font.TRUETYPE_FONT, fontstl1).deriveFont(14f);
            Font f3 = Font.createFont(Font.TRUETYPE_FONT, fontstl1).deriveFont(12f);
            wellbl.setFont(f1);
            lbl1.setFont(f2);
            lbl2.setFont(f2);
            lbl3.setFont(f2);
            forgotpwlbl.setFont(f3);
            forgotpanellbl.setFont(f2);
            enterOTPlbl.setFont(f3);
            confirmbtn1.setFont(f3);
            sendbtn.setFont(f3);
            userRegistrationlbl.setFont(f2);
            newPWlbl.setFont(f3);
            reEnterPWlbl.setFont(f3);
            INCOTPstslbl.setFont(f3);
            deptCBbox.setFont(f3);
            userIdlbl.setFont(f3);
            deptlbl.setFont(f3);
            mailidlbl.setFont(f3);
            clglbl1.setFont(f1);
            clglbl2.setFont(f3);
            clglbl3.setFont(f3);
            clglbl4.setFont(f3);
            otpsendingstslbl.setFont(f2);
            newUserIdlbl.setFont(f3);
            newUserID.setFont(f3);
            newVerifybtn.setFont(f3);
            welllblforsign_uppanel.setFont(f1);
            sign_uplbl.setFont(f3);
            continuelabel.setFont(f1);
            basicDetailslbl.setFont(f2);
            namelbl.setFont(f3);
            nameTF.setFont(f3);
            mobileNumberlbl.setFont(f3);
            basic_Information_Panel.setFont(f3);
            mail_IDlbl.setFont(f3);
            mail_IDTF.setFont(f3);
            newuser_IDTF.setFont(f3);
            newuser_IDlbl.setFont(f3);
            newPW_lbl.setFont(f3);
            newPW_TF.setFont(f3);
            newVerifybtn.setFont(f3);
            stfdeptlbl.setFont(f3);
            deptTF.setFont(f3);
            createNewPWTF.setFont(f3);
            createNewPWlbl.setFont(f3);
            completeProfilelbl.setFont(f2);
            addressTA.setFont(f3);
            addresslbl.setFont(f3);
            choosepicbtn.setFont(f3);
            bloodgrplbl.setFont(f3);
            bloodgrpCB.setFont(f3);
            photolbl.setFont(f3);
            photoFilePathTF.setFont(f3);
            uploadPhotobtn.setFont(f3);
            choosepicbtn.setFont(f3);
            createPWbtn.setFont(f3);
            cancelPWbtn.setFont(f3);
            nextbtn.setFont(f3);
            schooling_info_lbl.setFont(f3);
            tenth_th_lbl.setFont(f3);
            tenth_th_mark_TF.setFont(f3);
            tenth_th_mark_lbl.setFont(f3);
            tenth_th_school_TF.setFont(f3);
            tenth_th_school_lbl.setFont(f3);
            tenth_th_medium_lbl.setFont(f3);
            tenth_th_medium_TF.setFont(f3);
            twelve_th_mark_lbl.setFont(f3);
            twelve_th_mark_TF.setFont(f3);
            twelve_th_medium_lbl.setFont(f3);
            twelve_th_medium_TF.setFont(f3);
            twelve_th_school_lbl.setFont(f3);
            twelve_th_school_TF.setFont(f3);
            next_btn.setFont(f3);
            hint_more_deg_lbl3.setFont(f3);
            hint_more_deg_lbl4.setFont(f3);
            next_btn_collegedetails.setFont(f3);
            college_lbl_panel.setFont(f3);
            course_lbl_Add_more.setFont(f3);
            course_lbl_Add_more1.setFont(f3);
            course_CB_.setFont(f3);
            course_CB_1.setFont(f3);
            major_lbl_Add_more.setFont(f3);
            major_lbl_Add_more1.setFont(f3);
            major_TF.setFont(f3);
            major_TF1.setFont(f3);
            college_lbl_Add_more.setFont(f3);
            college_lbl_Add_more1.setFont(f3);
            college_TF.setFont(f3);
            college_TF1.setFont(f3);
            university_lbl_Add_more.setFont(f3);
            university_lbl_Add_more1.setFont(f3);
            university_TF.setFont(f3);
            university_TF1.setFont(f3);
            add_more_deg_lbl.setFont(f3);
            bachelorofgedlbl.setFont(f3);
            percentageValue1.setFont(f3);
            percentageValue1.setFont(f3);
            scoreLBL_add_more_panel.setFont(f3);
            yop_CB_addMorePanel.setFont(f3);
            yopCB1.setFont(f3);
            yopLbl.setFont(f3);
            yopLbl1.setFont(f3);
            percentageLbl.setFont(f3);
            percentageLbl1.setFont(f3);
            courseLBL_add_more_panel.setFont(f3);
            collegeLBL_add_more_panel.setFont(f3);
            collegeTF_add_more_panel.setFont(f3);
            universityLBL_add_more_panel.setFont(f3);
            university_TF.setFont(f3);
            yopLBL_add_more_panel.setFont(f3);
            masterofgedlbl.setFont(f3);
            newUserPWlbl.setFont(f3);

        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        sw = (int) d.getWidth();
        sh = (int) d.getHeight();
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(255, 255, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\netBeans\\EASCPRJ-STAFF\\src\\Resources\\logo.png"));
    }

    private Image Imagegenerate(String path, int x, int y) {
        int imgHeight = y;
        int imgWidth = x;
        ImageIcon img_source = new ImageIcon(path);
        Image img = img_source.getImage();
        profileimg = img.getScaledInstance(imgWidth, imgHeight, img.SCALE_SMOOTH);
        return profileimg;
    }

    int OTPGenerate() {
        Random rand = new Random();
        random_Number = 100000 + rand.nextInt(900000);
        return random_Number;
    }

    boolean OTPSending(String toAdd, String msg) {
        boolean res = false;
        String to = toAdd;
        String subject = "EASCPRO-Password Authentication";
        String from = "boobalanvellingiri@gmail.com";
        String passKey = "ryvk nuuq kdwt peii";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, passKey);
            }
        });
        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(msg);

            Transport.send(mimeMessage);
            res = true;
        } catch (MessagingException e) {
//	            JOptionPane.showMessageDialog(this, );
            JOptionPane.showMessageDialog(parentpanel, "Error in sending email: " + e.getMessage(), "EmailSender", 2);

        }
        return res;
    }

    void OTPverification() {
        INCOTPstslbl.setText("Incorrect OTP");
        INCOTPstslbl.setForeground(Color.red);
        CRTOTPstslbl.setText("OTP Verified");
        CRTOTPstslbl.setForeground(Color.green);

        CRTOTPstslbl.setVisible(false);
        INCOTPstslbl.setVisible(false);

        if (!(otpTF.getText().equals(""))) {
            if (Integer.parseInt(otpTF.getText()) == random_Number) {
                otpstspanel.removeAll();
                otpstspanel.add(CRTOTPstslbl);
                otpstspanel.repaint();
                otpstspanel.revalidate();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        otpstspanel.removeAll();
                        otpstspanel.add(panel1);
                        otpstspanel.repaint();
                        otpstspanel.revalidate();
                        otpTF.setEnabled(false);
                        newPWTF.setEnabled(true);
                        confirmPWTF.setEnabled(true);
                        confirmbtn1.setEnabled(true);
                        confirmbtn1.setBackground(new Color(102, 200, 215));
                    }
                }, 2000);
            } else {
                otpstspanel.removeAll();
                otpstspanel.add(INCOTPstslbl);
                otpstspanel.repaint();
                otpstspanel.revalidate();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        otpstspanel.removeAll();
                        otpstspanel.add(panel1);
                        otpstspanel.repaint();
                        otpstspanel.revalidate();
                    }
                }, 2000);
            }
        } else {
            JOptionPane.showMessageDialog(parentpanel, "Input Field value missing", "EASCPRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    boolean passwordUpdate() {
        boolean result = false;
        String newPW = newPWTF.getText();
        String confirmPW = confirmPWTF.getText();
        if (newPW.equals(confirmPW)) {
            int res = JOptionPane.showConfirmDialog(parentpanel, "Are You sure want to change Your Password ?", "EASCPRO", JOptionPane.YES_NO_CANCEL_OPTION);

            if (res == 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                    String q = "update loginforstaff set staffpw = ? where staffid=?";
                    PreparedStatement ps1 = con.prepareStatement(q);
                    ps1.setString(1, newPW);
                    ps1.setString(2, userIdTF.getText());
                    ps1.executeUpdate();
                    result = true;
                    parentpanel.removeAll();
                    parentpanel.add(Sign_inPanel);
                    parentpanel.repaint();
                    parentpanel.revalidate();
                    con.close();
                }//try Block ends here...!
                catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(staffDashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }//catch clause end here..!
            }
        } else {
            JOptionPane.showMessageDialog(parentpanel, "Password Fields Value Mismatch..!", "EASCPRO", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    private void sign_up() {
        choosepicbtn.setEnabled(false);
        cancelPWbtn.setVisible(false);
        createNewPWTF.setVisible(false);
        createConfirmPWTF.setVisible(false);
        createNewPWlbl.setVisible(false);
        confirmPWlbl.setVisible(false);
        createPWbtn.setVisible(false);

        String editlogopath = "D:\\netBeans\\EASCPRJ-STAFF\\src\\Resources\\editlogo.png";
        editlogoLBLforCreate_newPW.setIcon(new ImageIcon(Imagegenerate(editlogopath, 20, 20)));

        detailsPanel.removeAll();
        detailsPanel.add(basic_Information_Panel);
        detailsPanel.repaint();
        detailsPanel.revalidate();

        addressTA.setLineWrap(true);
        addressTA.setWrapStyleWord(true);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");

            String q2 = "select * from bloodgroup";
            PreparedStatement ps2 = con.prepareStatement(q2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs1 = ps2.executeQuery();
            if (rs1.next()) {
                bloodgrpCB.removeAllItems();
                bloodgrpCB.addItem("-");
                rs1.first();
                bloodgrpCB.addItem(rs1.getString("bloodGroup"));
                while (rs1.next()) {
                    bloodgrpCB.addItem(rs1.getString("bloodGroup"));
                }
            } else {
                JOptionPane.showMessageDialog(basic_Information_Panel, "Error Occured in adding a Blood Group into the Field...!Please Contact the Admin", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
            }
            String q = "select * from staffdetails where staffid=?";
            PreparedStatement ps = con.prepareStatement(q, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, newUserID.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newUserID.setText(newUserID.getText());
                nameTF.setText(rs.getString("staffname"));
                deptTF.setText(rs.getString("staffdept"));
                mobileTF.setText(rs.getString("staffmob"));
                mail_IDTF.setText(rs.getString("staffmail"));
                newuser_IDTF.setText(rs.getString("staffid"));
                newPW_TF.setText(newUserPW.getPassword().toString());
                con.close();
            } else {
                JOptionPane.showMessageDialog(sign_up_panel, "User Data Not Found..!Please Contact Admin", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
            }

        }//try Block ends here...!
        catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(sign_up_panel, "Error Occured..! Please Contact Admin", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
        }//catch clause end here..!
        //create new password components default visible set false;
    }

    private String chooseFile(FileNameExtensionFilter filter) {
        String filepath = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filepath = selectedFile.getAbsolutePath();
        } else {
            JOptionPane.showMessageDialog(basic_Information_Panel, "No File Selected..! Pease Choose Your Profile Picture", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
        }
        return filepath;
    }

    boolean CollegedetailsUpdate(int index) {
        boolean res = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q = "insert into staffcollege (staffId, staffdegree, major, collegename, university, percentage, yop) "
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(q);
            ps1.setString(1, newuser_IDTF.getText());
            ps1.setString(2, collegedetails.get(index));
            ps1.setString(3, collegedetails.get(index + 1));
            ps1.setString(4, collegedetails.get(index + 3));
            ps1.setString(5, collegedetails.get(index + 4));
            ps1.setString(6, collegedetails.get(index + 2));
            ps1.setString(7, collegedetails.get(index + 5));
            boolean rs1 = ps1.execute();

            if (!rs1) {
                res = true;
            } else {
                res = false;
            }
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    boolean SchooldetailsUpdate(int index) {
        boolean res = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q = "insert into staffschooling (staffid, sslc, school, boardSSLC, hsc, schoolHSC, board) "
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(q);
            ps1.setString(1, newuser_IDTF.getText());
            ps1.setString(2, schooldetails.get(index));
            ps1.setString(3, schooldetails.get(index + 1));
            ps1.setString(4, schooldetails.get(index + 2));
            ps1.setString(5, schooldetails.get(index + 3));
            ps1.setString(6, schooldetails.get(index + 4));
            ps1.setString(7, schooldetails.get(index + 5));
            boolean rs1 = ps1.execute();

            if (!rs1) {
                res = true;
            } else {
                res = false;
            }
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        addressScrollPane = new javax.swing.JScrollPane();
        Clg_Logo_Panel = new javax.swing.JPanel();
        clgname = new javax.swing.JPanel();
        clglbl1 = new javax.swing.JLabel();
        clglbl2 = new javax.swing.JLabel();
        clglbl4 = new javax.swing.JLabel();
        clglbl3 = new javax.swing.JLabel();
        clgimgpanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        mainpanel = new javax.swing.JPanel();
        parentpanel = new javax.swing.JPanel();
        Sign_inPanel = new javax.swing.JPanel();
        wellbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        uid = new javax.swing.JTextField();
        pw = new javax.swing.JPasswordField();
        verifybtn = new javax.swing.JButton();
        resetbtn1 = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        forgotpwlbl = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        sign_uplbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        forgotPWPanel = new javax.swing.JPanel();
        forgotpanellbl = new javax.swing.JLabel();
        userIdlbl = new javax.swing.JLabel();
        deptlbl = new javax.swing.JLabel();
        userIdTF = new javax.swing.JTextField();
        deptCBbox = new javax.swing.JComboBox<>();
        mailIdTF = new javax.swing.JTextField();
        mailidlbl = new javax.swing.JLabel();
        sendbtn = new javax.swing.JButton();
        resetbtnforForgotpwPanel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        enterOTPlbl = new javax.swing.JLabel();
        otpTF = new javax.swing.JTextField();
        newPWlbl = new javax.swing.JLabel();
        newPWTF = new javax.swing.JTextField();
        reEnterPWlbl = new javax.swing.JLabel();
        confirmPWTF = new javax.swing.JTextField();
        confirmbtn1 = new javax.swing.JButton();
        verifyOTPbtn = new javax.swing.JButton();
        otpstspanel = new javax.swing.JPanel();
        panel1 = new javax.swing.JLabel();
        CRTOTPstslbl = new javax.swing.JLabel();
        INCOTPstslbl = new javax.swing.JLabel();
        otpsendingstslbl = new javax.swing.JLabel();
        backbtn_forgotPWpanel = new javax.swing.JButton();
        sign_up_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        userRegistrationlbl = new javax.swing.JLabel();
        newUserIdlbl = new javax.swing.JLabel();
        newUserID = new javax.swing.JTextField();
        newUserPWlbl = new javax.swing.JLabel();
        newUserPW = new javax.swing.JPasswordField();
        newVerifybtn = new javax.swing.JButton();
        welllblforsign_uppanel = new javax.swing.JLabel();
        backBtn_Sign_UP_Panel = new javax.swing.JButton();
        detailsPanel = new javax.swing.JPanel();
        default_panel = new javax.swing.JPanel();
        continuelabel = new javax.swing.JLabel();
        basic_Information_Panel = new javax.swing.JPanel();
        basicDetailslbl = new javax.swing.JLabel();
        namelbl = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        mobileNumberlbl = new javax.swing.JLabel();
        mobileTF = new javax.swing.JTextField();
        mail_IDlbl = new javax.swing.JLabel();
        mail_IDTF = new javax.swing.JTextField();
        newuser_IDlbl = new javax.swing.JLabel();
        newuser_IDTF = new javax.swing.JTextField();
        newPW_lbl = new javax.swing.JLabel();
        newPW_TF = new javax.swing.JTextField();
        createNewPWlbl = new javax.swing.JLabel();
        confirmPWlbl = new javax.swing.JLabel();
        createPWbtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        stfdeptlbl = new javax.swing.JLabel();
        deptTF = new javax.swing.JTextField();
        completeProfilelbl = new javax.swing.JLabel();
        addresslbl = new javax.swing.JLabel();
        bloodgrplbl = new javax.swing.JLabel();
        bloodgrpCB = new javax.swing.JComboBox<>();
        uploadPhotobtn = new javax.swing.JButton();
        editlogoLBLforCreate_newPW = new javax.swing.JLabel();
        photoFilePathTF = new javax.swing.JTextField();
        photolbl = new javax.swing.JLabel();
        choosepicbtn = new javax.swing.JButton();
        createNewPWTF = new javax.swing.JPasswordField();
        createConfirmPWTF = new javax.swing.JPasswordField();
        cancelPWbtn = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        addressTA = new javax.swing.JTextArea();
        school_details_panel = new javax.swing.JPanel();
        backbtn = new javax.swing.JButton();
        schooling_info_lbl = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        tenth_th_lbl = new javax.swing.JLabel();
        tenth_th_mark_lbl = new javax.swing.JLabel();
        tenth_th_mark_TF = new javax.swing.JTextField();
        tenth_th_school_lbl = new javax.swing.JLabel();
        tenth_th_school_TF = new javax.swing.JTextField();
        tenth_th_medium_lbl = new javax.swing.JLabel();
        tenth_th_medium_TF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        twelve_th_mark_lbl = new javax.swing.JLabel();
        twelve_th_medium_lbl = new javax.swing.JLabel();
        twelve_th_school_lbl = new javax.swing.JLabel();
        twelve_th_mark_TF = new javax.swing.JTextField();
        twelve_th_medium_TF = new javax.swing.JTextField();
        twelve_th_school_TF = new javax.swing.JTextField();
        next_btn = new javax.swing.JButton();
        College_details_panel = new javax.swing.JPanel();
        college_lbl_panel = new javax.swing.JLabel();
        course_lbl_Add_more = new javax.swing.JLabel();
        major_lbl_Add_more = new javax.swing.JLabel();
        college_lbl_Add_more = new javax.swing.JLabel();
        university_lbl_Add_more = new javax.swing.JLabel();
        major_TF = new javax.swing.JTextField();
        college_TF = new javax.swing.JTextField();
        university_TF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        course_CB_ = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        hint_more_deg_lbl3 = new javax.swing.JLabel();
        hint_more_deg_lbl4 = new javax.swing.JLabel();
        course_lbl_Add_more1 = new javax.swing.JLabel();
        major_lbl_Add_more1 = new javax.swing.JLabel();
        college_lbl_Add_more1 = new javax.swing.JLabel();
        university_lbl_Add_more1 = new javax.swing.JLabel();
        course_CB_1 = new javax.swing.JComboBox<>();
        major_TF1 = new javax.swing.JTextField();
        college_TF1 = new javax.swing.JTextField();
        university_TF1 = new javax.swing.JTextField();
        next_btn_collegedetails = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        yopLbl = new javax.swing.JLabel();
        percentageLbl = new javax.swing.JLabel();
        percentageSlider = new javax.swing.JSlider();
        yopLbl1 = new javax.swing.JLabel();
        percentageLbl1 = new javax.swing.JLabel();
        percentageSlider1 = new javax.swing.JSlider();
        bachelorofgedlbl = new javax.swing.JLabel();
        masterofgedlbl = new javax.swing.JLabel();
        yopCB1 = new javax.swing.JComboBox<>();
        yopCB = new javax.swing.JComboBox<>();
        percentageValue1 = new javax.swing.JTextField();
        percentageValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        add_more_deg_panel = new javax.swing.JPanel();
        add_more_deg_lbl = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        courseLBL_add_more_panel = new javax.swing.JLabel();
        scoreLBL_add_more_panel = new javax.swing.JLabel();
        collegeLBL_add_more_panel = new javax.swing.JLabel();
        universityLBL_add_more_panel = new javax.swing.JLabel();
        yopLBL_add_more_panel = new javax.swing.JLabel();
        collegeTF_add_more_panel = new javax.swing.JTextField();
        universityTF_add_more_panel = new javax.swing.JTextField();
        PercentageforAddmoreDegree = new javax.swing.JSlider();
        percentageValueforAddMoreDegree = new javax.swing.JLabel();
        yop_CB_addMorePanel = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        PhD_degree_TF = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COLLEGEPRO");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Clg_Logo_Panel.setBackground(new java.awt.Color(102, 153, 255));
        Clg_Logo_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clgname.setBackground(new java.awt.Color(102, 153, 255));
        clgname.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clglbl1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        clglbl1.setForeground(new java.awt.Color(255, 255, 255));
        clglbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clglbl1.setText("ABC ARTS AND SCIENCE COLLEGE");
        clgname.add(clglbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 390, 30));

        clglbl2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clglbl2.setForeground(new java.awt.Color(255, 255, 255));
        clglbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clglbl2.setText("Affiliated to Bharathiar University");
        clgname.add(clglbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 40, 390, -1));

        clglbl4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clglbl4.setForeground(new java.awt.Color(255, 255, 255));
        clglbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clglbl4.setText("ABC-423324");
        clgname.add(clglbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 390, -1));

        clglbl3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clglbl3.setForeground(new java.awt.Color(255, 255, 255));
        clglbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clglbl3.setText("Autonomous (Co-Education)");
        clgname.add(clglbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 390, -1));

        Clg_Logo_Panel.add(clgname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 390, 110));

        clgimgpanel.setBackground(new java.awt.Color(102, 153, 255));
        clgimgpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        clgimgpanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 220, 220));

        Clg_Logo_Panel.add(clgimgpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 370, 500));

        getContentPane().add(Clg_Logo_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 30, 390, 730));

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        parentpanel.setLayout(new java.awt.CardLayout());

        Sign_inPanel.setLayout(null);

        wellbl.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        wellbl.setText("Welcome to EASCPRO");
        Sign_inPanel.add(wellbl);
        wellbl.setBounds(330, 20, 300, 40);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel1.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 250, 30));
        jPanel1.add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 250, 30));

        verifybtn.setBackground(new java.awt.Color(102, 200, 215));
        verifybtn.setMnemonic('v');
        verifybtn.setText("Verify");
        verifybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifybtnActionPerformed(evt);
            }
        });
        jPanel1.add(verifybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 80, 20));

        resetbtn1.setBackground(new java.awt.Color(102, 200, 215));
        resetbtn1.setMnemonic('R');
        resetbtn1.setText("Reset");
        resetbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(resetbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 80, 20));

        lbl1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl1.setText("Sign-in to Continue with us");
        jPanel1.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 260, -1));

        forgotpwlbl.setForeground(new java.awt.Color(102, 153, 255));
        forgotpwlbl.setText("Forgot Password ?");
        forgotpwlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotpwlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotpwlblMouseClicked(evt);
            }
        });
        jPanel1.add(forgotpwlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 140, 30));

        lbl2.setText("User-Id");
        jPanel1.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 100, -1));

        lbl3.setText("Password");
        jPanel1.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 80, -1));

        sign_uplbl.setForeground(new java.awt.Color(102, 153, 255));
        sign_uplbl.setText("New USer/Sign up Here");
        sign_uplbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sign_uplbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sign_uplblMouseClicked(evt);
            }
        });
        jPanel1.add(sign_uplbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 160, 20));

        Sign_inPanel.add(jPanel1);
        jPanel1.setBounds(30, 60, 530, 330);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Authenticationlogo.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        Sign_inPanel.add(jLabel6);
        jLabel6.setBounds(540, 40, 360, 387);

        parentpanel.add(Sign_inPanel, "card2");

        forgotPWPanel.setLayout(null);

        forgotpanellbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotpanellbl.setText("Forgot Password");
        forgotPWPanel.add(forgotpanellbl);
        forgotpanellbl.setBounds(350, 20, 210, 30);

        userIdlbl.setText("User ID");
        forgotPWPanel.add(userIdlbl);
        userIdlbl.setBounds(160, 90, 70, 30);

        deptlbl.setText("Department");
        forgotPWPanel.add(deptlbl);
        deptlbl.setBounds(160, 160, 80, 30);
        forgotPWPanel.add(userIdTF);
        userIdTF.setBounds(160, 120, 250, 30);

        deptCBbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        deptCBbox.setSelectedItem("-");
        forgotPWPanel.add(deptCBbox);
        deptCBbox.setBounds(160, 190, 250, 30);
        forgotPWPanel.add(mailIdTF);
        mailIdTF.setBounds(160, 260, 250, 30);

        mailidlbl.setText("Mail ID");
        forgotPWPanel.add(mailidlbl);
        mailidlbl.setBounds(160, 230, 90, 30);

        sendbtn.setBackground(new java.awt.Color(102, 200, 215));
        sendbtn.setText("Send OTP");
        forgotPWPanel.add(sendbtn);
        sendbtn.setBounds(160, 320, 110, 20);

        resetbtnforForgotpwPanel.setBackground(new java.awt.Color(102, 200, 215));
        resetbtnforForgotpwPanel.setText("Reset");
        resetbtnforForgotpwPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnforForgotpwPanelActionPerformed(evt);
            }
        });
        forgotPWPanel.add(resetbtnforForgotpwPanel);
        resetbtnforForgotpwPanel.setBounds(310, 320, 100, 20);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        forgotPWPanel.add(jSeparator1);
        jSeparator1.setBounds(440, 90, 10, 270);

        enterOTPlbl.setText("Enter OTP");
        forgotPWPanel.add(enterOTPlbl);
        enterOTPlbl.setBounds(470, 90, 130, 30);
        forgotPWPanel.add(otpTF);
        otpTF.setBounds(470, 120, 250, 30);

        newPWlbl.setText("New Password");
        forgotPWPanel.add(newPWlbl);
        newPWlbl.setBounds(470, 160, 120, 30);
        forgotPWPanel.add(newPWTF);
        newPWTF.setBounds(470, 190, 250, 30);

        reEnterPWlbl.setText("Re-Enter password");
        forgotPWPanel.add(reEnterPWlbl);
        reEnterPWlbl.setBounds(470, 230, 160, 30);
        forgotPWPanel.add(confirmPWTF);
        confirmPWTF.setBounds(470, 260, 250, 30);

        confirmbtn1.setText("Confirm");
        forgotPWPanel.add(confirmbtn1);
        confirmbtn1.setBounds(540, 320, 120, 20);

        verifyOTPbtn.setText("Verify");
        forgotPWPanel.add(verifyOTPbtn);
        verifyOTPbtn.setBounds(770, 120, 100, 20);

        otpstspanel.setLayout(new java.awt.CardLayout());
        otpstspanel.add(panel1, "card4");
        otpstspanel.add(CRTOTPstslbl, "card3");
        otpstspanel.add(INCOTPstslbl, "card2");

        forgotPWPanel.add(otpstspanel);
        otpstspanel.setBounds(770, 140, 100, 40);

        otpsendingstslbl.setBackground(new java.awt.Color(102, 255, 102));
        otpsendingstslbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPWPanel.add(otpsendingstslbl);
        otpsendingstslbl.setBounds(340, 380, 200, 30);

        backbtn_forgotPWpanel.setText("<-");
        backbtn_forgotPWpanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtn_forgotPWpanelActionPerformed(evt);
            }
        });
        forgotPWPanel.add(backbtn_forgotPWpanel);
        backbtn_forgotPWpanel.setBounds(40, 30, 72, 23);

        parentpanel.add(forgotPWPanel, "card3");

        sign_up_panel.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        userRegistrationlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userRegistrationlbl.setText("Sign Up");
        jPanel2.add(userRegistrationlbl);
        userRegistrationlbl.setBounds(0, 140, 290, 30);

        newUserIdlbl.setText("User ID :");
        jPanel2.add(newUserIdlbl);
        newUserIdlbl.setBounds(20, 200, 100, 25);
        newUserIdlbl.getAccessibleContext().setAccessibleName("");

        newUserID.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.add(newUserID);
        newUserID.setBounds(100, 200, 160, 25);
        newUserID.getAccessibleContext().setAccessibleName("");

        newUserPWlbl.setText("Password :");
        jPanel2.add(newUserPWlbl);
        newUserPWlbl.setBounds(20, 240, 100, 25);
        newUserPWlbl.getAccessibleContext().setAccessibleName("");

        newUserPW.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.add(newUserPW);
        newUserPW.setBounds(100, 240, 160, 25);
        newUserPW.getAccessibleContext().setAccessibleName("");

        newVerifybtn.setMnemonic('v');
        newVerifybtn.setText("Verify");
        newVerifybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newVerifybtnActionPerformed(evt);
            }
        });
        jPanel2.add(newVerifybtn);
        newVerifybtn.setBounds(160, 300, 90, 20);

        welllblforsign_uppanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welllblforsign_uppanel.setText("Welcome to EASCPRO-STAFF");
        jPanel2.add(welllblforsign_uppanel);
        welllblforsign_uppanel.setBounds(0, 100, 290, 30);

        backBtn_Sign_UP_Panel.setText("Back");
        backBtn_Sign_UP_Panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn_Sign_UP_PanelActionPerformed(evt);
            }
        });
        jPanel2.add(backBtn_Sign_UP_Panel);
        backBtn_Sign_UP_Panel.setBounds(30, 300, 75, 20);

        sign_up_panel.add(jPanel2);
        jPanel2.setBounds(0, 0, 290, 440);

        detailsPanel.setLayout(new java.awt.CardLayout());

        default_panel.setLayout(new java.awt.BorderLayout());

        continuelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        continuelabel.setText("Please Sign up to continue");
        default_panel.add(continuelabel, java.awt.BorderLayout.CENTER);

        detailsPanel.add(default_panel, "card5");

        basic_Information_Panel.setLayout(null);

        basicDetailslbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        basicDetailslbl.setText("Basic Informations");
        basic_Information_Panel.add(basicDetailslbl);
        basicDetailslbl.setBounds(0, 10, 630, 25);

        namelbl.setText("Name :");
        basic_Information_Panel.add(namelbl);
        namelbl.setBounds(20, 60, 80, 25);

        nameTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        nameTF.setEnabled(false);
        basic_Information_Panel.add(nameTF);
        nameTF.setBounds(100, 60, 150, 25);

        mobileNumberlbl.setText("Mobile : ");
        basic_Information_Panel.add(mobileNumberlbl);
        mobileNumberlbl.setBounds(20, 140, 80, 25);

        mobileTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        mobileTF.setEnabled(false);
        basic_Information_Panel.add(mobileTF);
        mobileTF.setBounds(100, 140, 150, 25);

        mail_IDlbl.setText("Mail-ID :");
        basic_Information_Panel.add(mail_IDlbl);
        mail_IDlbl.setBounds(20, 180, 80, 25);

        mail_IDTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        mail_IDTF.setEnabled(false);
        basic_Information_Panel.add(mail_IDTF);
        mail_IDTF.setBounds(100, 180, 150, 25);

        newuser_IDlbl.setText("User-ID :");
        basic_Information_Panel.add(newuser_IDlbl);
        newuser_IDlbl.setBounds(20, 220, 70, 25);

        newuser_IDTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        newuser_IDTF.setEnabled(false);
        basic_Information_Panel.add(newuser_IDTF);
        newuser_IDTF.setBounds(100, 220, 150, 25);

        newPW_lbl.setText("Password :");
        basic_Information_Panel.add(newPW_lbl);
        newPW_lbl.setBounds(20, 260, 80, 25);

        newPW_TF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        newPW_TF.setEnabled(false);
        basic_Information_Panel.add(newPW_TF);
        newPW_TF.setBounds(100, 260, 150, 25);

        createNewPWlbl.setText("New Password");
        basic_Information_Panel.add(createNewPWlbl);
        createNewPWlbl.setBounds(20, 310, 120, 25);

        confirmPWlbl.setText("Confirm Password");
        basic_Information_Panel.add(confirmPWlbl);
        confirmPWlbl.setBounds(20, 350, 140, 25);

        createPWbtn.setMnemonic('m');
        createPWbtn.setText("Modify ");
        createPWbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPWbtnActionPerformed(evt);
            }
        });
        basic_Information_Panel.add(createPWbtn);
        createPWbtn.setBounds(150, 400, 100, 25);

        jSeparator2.setForeground(new java.awt.Color(102, 153, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        basic_Information_Panel.add(jSeparator2);
        jSeparator2.setBounds(290, 60, 20, 360);

        stfdeptlbl.setText("Department");
        basic_Information_Panel.add(stfdeptlbl);
        stfdeptlbl.setBounds(20, 100, 80, 25);

        deptTF.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        deptTF.setEnabled(false);
        basic_Information_Panel.add(deptTF);
        deptTF.setBounds(100, 100, 150, 25);

        completeProfilelbl.setForeground(new java.awt.Color(102, 153, 255));
        completeProfilelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        completeProfilelbl.setText("Complete Your Profile");
        basic_Information_Panel.add(completeProfilelbl);
        completeProfilelbl.setBounds(290, 70, 320, 25);

        addresslbl.setText("Address :");
        basic_Information_Panel.add(addresslbl);
        addresslbl.setBounds(310, 150, 80, 30);

        bloodgrplbl.setText("Blood");
        basic_Information_Panel.add(bloodgrplbl);
        bloodgrplbl.setBounds(310, 220, 60, 25);

        bloodgrpCB.setModel(new javax.swing.DefaultComboBoxModel<>());
        basic_Information_Panel.add(bloodgrpCB);
        bloodgrpCB.setBounds(380, 220, 180, 25);

        uploadPhotobtn.setMnemonic('u');
        uploadPhotobtn.setText("Upload Photo");
        uploadPhotobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadPhotobtnActionPerformed(evt);
            }
        });
        basic_Information_Panel.add(uploadPhotobtn);
        uploadPhotobtn.setBounds(420, 300, 140, 23);

        editlogoLBLforCreate_newPW.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editlogoLBLforCreate_newPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editlogoLBLforCreate_newPWMouseClicked(evt);
            }
        });
        basic_Information_Panel.add(editlogoLBLforCreate_newPW);
        editlogoLBLforCreate_newPW.setBounds(260, 250, 30, 30);

        photoFilePathTF.setEnabled(false);
        basic_Information_Panel.add(photoFilePathTF);
        photoFilePathTF.setBounds(380, 260, 180, 25);

        photolbl.setText("Photo :");
        basic_Information_Panel.add(photolbl);
        photolbl.setBounds(310, 260, 50, 25);

        choosepicbtn.setMnemonic('a');
        choosepicbtn.setText("Choose Another");
        choosepicbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosepicbtnActionPerformed(evt);
            }
        });
        basic_Information_Panel.add(choosepicbtn);
        choosepicbtn.setBounds(420, 340, 140, 20);
        basic_Information_Panel.add(createNewPWTF);
        createNewPWTF.setBounds(150, 310, 100, 22);
        basic_Information_Panel.add(createConfirmPWTF);
        createConfirmPWTF.setBounds(150, 350, 100, 22);

        cancelPWbtn.setMnemonic('x');
        cancelPWbtn.setText("Cancel");
        cancelPWbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPWbtnActionPerformed(evt);
            }
        });
        basic_Information_Panel.add(cancelPWbtn);
        cancelPWbtn.setBounds(20, 400, 90, 23);

        nextbtn.setMnemonic('n');
        nextbtn.setText("Next ->");
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });
        basic_Information_Panel.add(nextbtn);
        nextbtn.setBounds(470, 400, 90, 23);

        addressTA.setColumns(20);
        addressTA.setRows(5);
        basic_Information_Panel.add(addressTA);
        addressTA.setBounds(380, 130, 180, 70);

        detailsPanel.add(basic_Information_Panel, "card3");

        school_details_panel.setLayout(null);

        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        school_details_panel.add(backbtn);
        backbtn.setBounds(160, 330, 80, 23);

        schooling_info_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schooling_info_lbl.setText("Schooling Information");
        school_details_panel.add(schooling_info_lbl);
        schooling_info_lbl.setBounds(0, 30, 610, 25);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        school_details_panel.add(jSeparator3);
        jSeparator3.setBounds(300, 90, 10, 190);

        tenth_th_lbl.setText("SSLC");
        school_details_panel.add(tenth_th_lbl);
        tenth_th_lbl.setBounds(150, 90, 40, 25);

        tenth_th_mark_lbl.setText("Mark");
        school_details_panel.add(tenth_th_mark_lbl);
        tenth_th_mark_lbl.setBounds(20, 130, 60, 25);
        school_details_panel.add(tenth_th_mark_TF);
        tenth_th_mark_TF.setBounds(120, 140, 170, 25);

        tenth_th_school_lbl.setText("School");
        school_details_panel.add(tenth_th_school_lbl);
        tenth_th_school_lbl.setBounds(20, 220, 80, 25);
        school_details_panel.add(tenth_th_school_TF);
        tenth_th_school_TF.setBounds(120, 220, 170, 25);

        tenth_th_medium_lbl.setText("Medium ");
        school_details_panel.add(tenth_th_medium_lbl);
        tenth_th_medium_lbl.setBounds(20, 180, 60, 25);
        school_details_panel.add(tenth_th_medium_TF);
        tenth_th_medium_TF.setBounds(120, 180, 170, 25);

        jLabel4.setText("HSC");
        school_details_panel.add(jLabel4);
        jLabel4.setBounds(460, 90, 40, 25);

        twelve_th_mark_lbl.setText("Mark");
        school_details_panel.add(twelve_th_mark_lbl);
        twelve_th_mark_lbl.setBounds(320, 140, 90, 25);

        twelve_th_medium_lbl.setText("Medium");
        school_details_panel.add(twelve_th_medium_lbl);
        twelve_th_medium_lbl.setBounds(320, 180, 90, 25);

        twelve_th_school_lbl.setText("School");
        school_details_panel.add(twelve_th_school_lbl);
        twelve_th_school_lbl.setBounds(320, 220, 90, 25);
        school_details_panel.add(twelve_th_mark_TF);
        twelve_th_mark_TF.setBounds(420, 140, 170, 25);
        school_details_panel.add(twelve_th_medium_TF);
        twelve_th_medium_TF.setBounds(420, 180, 170, 25);
        school_details_panel.add(twelve_th_school_TF);
        twelve_th_school_TF.setBounds(420, 220, 170, 25);

        next_btn.setText("Next");
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });
        school_details_panel.add(next_btn);
        next_btn.setBounds(360, 330, 80, 23);

        detailsPanel.add(school_details_panel, "card4");

        College_details_panel.setLayout(null);

        college_lbl_panel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        college_lbl_panel.setText("College Details");
        College_details_panel.add(college_lbl_panel);
        college_lbl_panel.setBounds(0, 10, 610, 30);

        course_lbl_Add_more.setText("Course");
        College_details_panel.add(course_lbl_Add_more);
        course_lbl_Add_more.setBounds(20, 90, 100, 25);

        major_lbl_Add_more.setText("Major");
        College_details_panel.add(major_lbl_Add_more);
        major_lbl_Add_more.setBounds(20, 130, 100, 25);

        college_lbl_Add_more.setText("College ");
        College_details_panel.add(college_lbl_Add_more);
        college_lbl_Add_more.setBounds(20, 210, 100, 25);

        university_lbl_Add_more.setText("University");
        College_details_panel.add(university_lbl_Add_more);
        university_lbl_Add_more.setBounds(20, 250, 100, 25);
        College_details_panel.add(major_TF);
        major_TF.setBounds(120, 130, 170, 25);
        College_details_panel.add(college_TF);
        college_TF.setBounds(120, 210, 170, 25);
        College_details_panel.add(university_TF);
        university_TF.setBounds(120, 250, 170, 25);

        jButton1.setText("Add More");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        College_details_panel.add(jButton1);
        jButton1.setBounds(470, 360, 110, 23);

        course_CB_.setModel(new javax.swing.DefaultComboBoxModel<>());
        College_details_panel.add(course_CB_);
        course_CB_.setBounds(120, 90, 170, 25);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        College_details_panel.add(jButton2);
        jButton2.setBounds(30, 390, 72, 23);

        hint_more_deg_lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hint_more_deg_lbl3.setText("(If you have more Degrees, ");
        College_details_panel.add(hint_more_deg_lbl3);
        hint_more_deg_lbl3.setBounds(170, 360, 270, 25);

        hint_more_deg_lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hint_more_deg_lbl4.setText("Please Click the Add More Button)");
        College_details_panel.add(hint_more_deg_lbl4);
        hint_more_deg_lbl4.setBounds(170, 390, 270, 25);

        course_lbl_Add_more1.setText("Course");
        College_details_panel.add(course_lbl_Add_more1);
        course_lbl_Add_more1.setBounds(320, 90, 90, 25);

        major_lbl_Add_more1.setText("Major");
        College_details_panel.add(major_lbl_Add_more1);
        major_lbl_Add_more1.setBounds(320, 130, 90, 25);

        college_lbl_Add_more1.setText("College ");
        College_details_panel.add(college_lbl_Add_more1);
        college_lbl_Add_more1.setBounds(320, 210, 90, 25);

        university_lbl_Add_more1.setText("University");
        College_details_panel.add(university_lbl_Add_more1);
        university_lbl_Add_more1.setBounds(320, 250, 90, 25);

        course_CB_1.setModel(new javax.swing.DefaultComboBoxModel<>());
        College_details_panel.add(course_CB_1);
        course_CB_1.setBounds(420, 90, 170, 25);
        College_details_panel.add(major_TF1);
        major_TF1.setBounds(420, 130, 170, 25);
        College_details_panel.add(college_TF1);
        college_TF1.setBounds(420, 210, 170, 25);
        College_details_panel.add(university_TF1);
        university_TF1.setBounds(420, 250, 170, 25);

        next_btn_collegedetails.setText("Next");
        next_btn_collegedetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btn_collegedetailsActionPerformed(evt);
            }
        });
        College_details_panel.add(next_btn_collegedetails);
        next_btn_collegedetails.setBounds(470, 390, 110, 23);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        College_details_panel.add(jSeparator4);
        jSeparator4.setBounds(310, 80, 10, 250);

        yopLbl.setText("Year of Passing");
        College_details_panel.add(yopLbl);
        yopLbl.setBounds(20, 290, 100, 25);

        percentageLbl.setText("Percentage");
        College_details_panel.add(percentageLbl);
        percentageLbl.setBounds(20, 170, 100, 25);

        percentageSlider.setValue(0);
        percentageSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        percentageSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                percentageSliderStateChanged(evt);
            }
        });
        College_details_panel.add(percentageSlider);
        percentageSlider.setBounds(120, 170, 130, 25);

        yopLbl1.setText("Year of Passing");
        College_details_panel.add(yopLbl1);
        yopLbl1.setBounds(320, 290, 100, 25);

        percentageLbl1.setText("Percentage");
        College_details_panel.add(percentageLbl1);
        percentageLbl1.setBounds(320, 170, 100, 25);

        percentageSlider1.setValue(0);
        percentageSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        percentageSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                percentageSlider1StateChanged(evt);
            }
        });
        College_details_panel.add(percentageSlider1);
        percentageSlider1.setBounds(420, 170, 130, 25);

        bachelorofgedlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bachelorofgedlbl.setText("Bachelor Of Degree");
        College_details_panel.add(bachelorofgedlbl);
        bachelorofgedlbl.setBounds(0, 50, 300, 25);

        masterofgedlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        masterofgedlbl.setText("Master Of Degree");
        College_details_panel.add(masterofgedlbl);
        masterofgedlbl.setBounds(310, 50, 300, 25);

        yopCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        College_details_panel.add(yopCB1);
        yopCB1.setBounds(420, 290, 170, 25);

        yopCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        College_details_panel.add(yopCB);
        yopCB.setBounds(120, 290, 170, 25);

        percentageValue1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentageValue1.setText("10");
        percentageValue1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                percentageValue1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                percentageValue1FocusLost(evt);
            }
        });
        College_details_panel.add(percentageValue1);
        percentageValue1.setBounds(550, 170, 30, 25);

        percentageValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentageValue.setText("10 ");
        percentageValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                percentageValueFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                percentageValueFocusLost(evt);
            }
        });
        College_details_panel.add(percentageValue);
        percentageValue.setBounds(250, 170, 30, 25);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("%");
        College_details_panel.add(jLabel2);
        jLabel2.setBounds(580, 170, 20, 25);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("%");
        College_details_panel.add(jLabel5);
        jLabel5.setBounds(280, 170, 20, 25);

        detailsPanel.add(College_details_panel, "card5");

        add_more_deg_panel.setLayout(null);

        add_more_deg_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_more_deg_lbl.setText("Philosophy Degree");
        add_more_deg_panel.add(add_more_deg_lbl);
        add_more_deg_lbl.setBounds(0, 50, 610, 30);

        jButton3.setText("Back");
        add_more_deg_panel.add(jButton3);
        jButton3.setBounds(450, 160, 100, 23);

        jButton4.setText("Add More");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add_more_deg_panel.add(jButton4);
        jButton4.setBounds(450, 200, 100, 23);

        jButton5.setText("Completed");
        add_more_deg_panel.add(jButton5);
        jButton5.setBounds(450, 240, 100, 23);

        courseLBL_add_more_panel.setText("Course");
        add_more_deg_panel.add(courseLBL_add_more_panel);
        courseLBL_add_more_panel.setBounds(50, 150, 110, 25);

        scoreLBL_add_more_panel.setText("Score");
        add_more_deg_panel.add(scoreLBL_add_more_panel);
        scoreLBL_add_more_panel.setBounds(50, 190, 110, 25);

        collegeLBL_add_more_panel.setText("College");
        add_more_deg_panel.add(collegeLBL_add_more_panel);
        collegeLBL_add_more_panel.setBounds(50, 230, 110, 25);

        universityLBL_add_more_panel.setText("University");
        add_more_deg_panel.add(universityLBL_add_more_panel);
        universityLBL_add_more_panel.setBounds(50, 270, 110, 25);

        yopLBL_add_more_panel.setText("Year Of Passing");
        add_more_deg_panel.add(yopLBL_add_more_panel);
        yopLBL_add_more_panel.setBounds(50, 310, 110, 25);
        add_more_deg_panel.add(collegeTF_add_more_panel);
        collegeTF_add_more_panel.setBounds(190, 230, 170, 25);
        add_more_deg_panel.add(universityTF_add_more_panel);
        universityTF_add_more_panel.setBounds(190, 270, 170, 25);

        PercentageforAddmoreDegree.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PercentageforAddmoreDegreeStateChanged(evt);
            }
        });
        add_more_deg_panel.add(PercentageforAddmoreDegree);
        PercentageforAddmoreDegree.setBounds(190, 190, 140, 25);

        percentageValueforAddMoreDegree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentageValueforAddMoreDegree.setText("10");
        percentageValueforAddMoreDegree.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                percentageValueforAddMoreDegreeFocusGained(evt);
            }
        });
        add_more_deg_panel.add(percentageValueforAddMoreDegree);
        percentageValueforAddMoreDegree.setBounds(330, 190, 20, 25);

        yop_CB_addMorePanel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        add_more_deg_panel.add(yop_CB_addMorePanel);
        yop_CB_addMorePanel.setBounds(190, 310, 170, 25);

        jLabel7.setText("%");
        add_more_deg_panel.add(jLabel7);
        jLabel7.setBounds(360, 190, 20, 25);
        add_more_deg_panel.add(PhD_degree_TF);
        PhD_degree_TF.setBounds(190, 150, 170, 25);

        detailsPanel.add(add_more_deg_panel, "card6");

        sign_up_panel.add(detailsPanel);
        detailsPanel.setBounds(290, 0, 610, 440);

        parentpanel.add(sign_up_panel, "card4");

        mainpanel.add(parentpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 900, 440));

        getContentPane().add(mainpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 1120, 730));

        setSize(new java.awt.Dimension(1550, 796));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void resetbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtn1ActionPerformed
        // TODO add your handling code here:
        uid.setText("");
        pw.setText("");
    }//GEN-LAST:event_resetbtn1ActionPerformed

    private void forgotpwlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotpwlblMouseClicked
        // TODO add your handling code here:
        parentpanel.removeAll();
        parentpanel.add(forgotPWPanel);
        parentpanel.repaint();
        parentpanel.revalidate();

        Sign_up_panelHistory.push(Sign_inPanel);
        otpTF.setEnabled(false);
        confirmPWTF.setEnabled(false);
        newPWTF.setEnabled(false);
        confirmbtn1.setEnabled(false);
        verifyOTPbtn.setEnabled(false);
        deptCBbox.removeAllItems();
        deptCBbox.addItem("-");
        deptCBbox.addItem("Tamil");
        deptCBbox.addItem("English");
        deptCBbox.addItem("Maths");
        deptCBbox.addItem("Physics");
        deptCBbox.addItem("Chemistry");
        deptCBbox.addItem("Computer Technology");
        deptCBbox.addItem("Computer Science");
        deptCBbox.addItem("Information Technology");
        deptCBbox.addItem("Computer Application");
        deptCBbox.addItem("Bio-Chemistry");
        deptCBbox.addItem("Micro-Biology");
        deptCBbox.addItem("Visual Communication");
        deptCBbox.addItem("Cyber Security");
        deptCBbox.addItem("Costume Designing and Fashion");
        deptCBbox.addItem("Business Administration");
        deptCBbox.addItem("Social Work");
        deptCBbox.addItem("Business Administration");
        deptCBbox.addItem("Commerce-BF");
        deptCBbox.addItem("Commerce-BI");
        deptCBbox.addItem("Commerce-PA");
        deptCBbox.addItem("Commerce-CA");
        deptCBbox.addItem("Zoology");
        deptCBbox.addItem("History");
        deptCBbox.addItem("Defense andStrategy Studies");
        deptCBbox.addItem("Food Science and Nutrition");
        deptCBbox.addItem("Political Science");
        deptCBbox.addItem("History");

        sendbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(userIdTF.getText().equals("")) && !(deptCBbox.getSelectedItem().toString().equals("-")) && !(mailIdTF.getText().equals(""))) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                        String q = "select * from loginforstaff where staffid=? and staffemail=? and staffdept=?";
                        PreparedStatement ps1 = con.prepareStatement(q);
                        ps1.setString(1, userIdTF.getText());
                        ps1.setString(2, mailIdTF.getText());
                        ps1.setString(3, deptCBbox.getSelectedItem().toString());
                        ResultSet rs1 = ps1.executeQuery();
                        if (rs1.next()) {
                            username = rs1.getString("staffname");
                            int otp = OTPGenerate();
                            String message = "You have request to update your password of your EASCPRO account \n"
                                    + "\n" + "Your security code is \n" + otp + "\n" + "\n\n\n\nTruly,\n" + "-EASCPRO-Management";

                            boolean res = OTPSending(mailIdTF.getText(), message);
                            if (res) {
                                otpsendingstslbl.setText("OTP Sent Succesful");
                                otpsendingstslbl.setForeground(Color.green);
                                new Timer().schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        otpsendingstslbl.setText("");
                                        mailIdTF.setEnabled(false);
                                        userIdTF.setEnabled(false);
                                        deptCBbox.setEnabled(false);
                                        otpTF.setEnabled(true);
                                        verifyOTPbtn.setEnabled(true);
                                        verifyOTPbtn.setBackground(new Color(102, 200, 215));
                                    }
                                }, 2000);
                            }
                            con.close();
                        } else {
                            JOptionPane.showMessageDialog(parentpanel, "Invalid User Data..!", "EASCPRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }//try Block ends here...!
                    catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                    }//catch clause end here..!  
                } else {
                    JOptionPane.showMessageDialog(parentpanel, "Input Field(s) value missing", "EASCPRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        verifyOTPbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                OTPverification();
            }
        });

        confirmbtn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Dear [" + username + "] This is to confirm that the password for your account has been successfully changed."
                        + "\nYour account is now secured with the new password that you have set. "
                        + "\nIf you did not change your password, please contact us immediately to report any unauthorized access to your account."
                        + "\n\n Truly \n - EASC-Management";
                boolean res = passwordUpdate();
                if (res) {
                    boolean result = OTPSending(mailIdTF.getText(), message);
                    if (result) {
                        JOptionPane.showMessageDialog(parentpanel, "Password Update Successful", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(parentpanel, "Password Update failed", "EASCPRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }//GEN-LAST:event_forgotpwlblMouseClicked

    private void verifybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifybtnActionPerformed
        // TODO add your handling code here:

        userID = uid.getText();
        pass = pw.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            if (!(userID.equals("")) && !(pass.equals(""))) {

                String q = "select * from loginforstaff where staffid=? && staffpw=?";
                PreparedStatement ps1 = con.prepareStatement(q);
                ps1.setString(1, userID);
                ps1.setString(2, pass);
                ResultSet rs1 = ps1.executeQuery();

                if (rs1.next()) {
                    username = rs1.getString("staffname");
                    JOptionPane.showMessageDialog(null, "Authentication Success..!", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new staffDashBoard();
                } else {
                    JOptionPane.showMessageDialog(null, "Authentication Failed..!", "EASCPRO", JOptionPane.ERROR_MESSAGE);
                    uid.setText("");
                    pw.setText("");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Username/password Field(s)are Missing", "EASCPRO", JOptionPane.ERROR_MESSAGE);
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verifybtnActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        new LoginFrame();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void resetbtnforForgotpwPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnforForgotpwPanelActionPerformed
        // TODO add your handling code here:
        userIdTF.setText("");
        mailIdTF.setText("");
        deptCBbox.setSelectedIndex(0);
    }//GEN-LAST:event_resetbtnforForgotpwPanelActionPerformed

    private void sign_uplblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sign_uplblMouseClicked
        // TODO add your handling code here:
        parentpanel.removeAll();
        parentpanel.add(sign_up_panel);
        parentpanel.repaint();
        parentpanel.revalidate();
        Sign_up_panelHistory.push(Sign_inPanel);
    }//GEN-LAST:event_sign_uplblMouseClicked

    private void newVerifybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newVerifybtnActionPerformed
        // TODO add your handling code here:
        if (!(newUserID.getText().equals("") && newUserPW.getText().equals(""))) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                String q = "select * from loginforstaff where staffid=? and staffpw=?";
                PreparedStatement ps1 = con.prepareStatement(q);
                ps1.setString(1, newUserID.getText());
                ps1.setString(2, newUserPW.getText());
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    JOptionPane.showMessageDialog(detailsPanel, "Sign-Up Successfully Completed..!", "EASCPRO-STAFF", JOptionPane.INFORMATION_MESSAGE);
                    detailsPanel.removeAll();
                    detailsPanel.add(basic_Information_Panel);
                    detailsPanel.repaint();
                    detailsPanel.revalidate();
                    newUserID.setEnabled(false);
                    newUserPW.setEnabled(false);
                    newVerifybtn.setEnabled(false);
                    addressTA.requestFocusInWindow();
                    sign_up();
                    con.close();
                } else {
                    JOptionPane.showMessageDialog(detailsPanel, "userNot Found..! Please Contact EASC-ADMIN", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_newVerifybtnActionPerformed

    private void editlogoLBLforCreate_newPWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editlogoLBLforCreate_newPWMouseClicked
        // TODO add your handling code here:
        //new password components are set visible true for updation;
        JOptionPane.showMessageDialog(basic_Information_Panel, "You can only change your password up to three times.",
                "EASCPRO-STAFF", JOptionPane.INFORMATION_MESSAGE);
        createNewPWTF.setVisible(true);
        cancelPWbtn.setVisible(true);
        createConfirmPWTF.setVisible(true);
        createNewPWlbl.setVisible(true);
        confirmPWlbl.setVisible(true);
        createPWbtn.setVisible(true);
    }//GEN-LAST:event_editlogoLBLforCreate_newPWMouseClicked

    private void createPWbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPWbtnActionPerformed
        // TODO add your handling code here:
        if (!(createNewPWTF.getText().equals("") && createConfirmPWTF.getText().equals(""))) {
            if (!(createNewPWTF.getText().equals(createConfirmPWTF.getText().equals("")))) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                    String q = "update loginforstaff set staffpw=? where staffid=?";
                    PreparedStatement ps1 = con.prepareStatement(q);
                    ps1.setString(1, createConfirmPWTF.getText());
                    ps1.setString(2, newuser_IDTF.getText());
                    int res = ps1.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(detailsPanel, "Password Updation Successfully Completed..!", "EASCPRO-STAFF", JOptionPane.INFORMATION_MESSAGE);
                        newPW_TF.setText(createConfirmPWTF.getPassword().toString());
                        createNewPWTF.setVisible(false);
                        createConfirmPWTF.setVisible(false);
                        cancelPWbtn.setVisible(false);
                        createNewPWlbl.setVisible(false);
                        confirmPWlbl.setVisible(false);
                        createPWbtn.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(detailsPanel, "userNot Found..! Please Contact EASC-ADMIN", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                    }
                    con.close();
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(basic_Information_Panel, ex + "Please Contact EASC-ADMIN", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                }
            }//Innner IF
            else {
                JOptionPane.showMessageDialog(detailsPanel, "New Password and Confirm Password Fileds are miss match..! Try Again..!", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(basic_Information_Panel, "Please Fill the All Filds..! ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createPWbtnActionPerformed

    private void uploadPhotobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadPhotobtnActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image Files", "jpg", "png", "jpeg");

        photoFilePathTF.setText("");
        String path = chooseFile(filter);
        photoFilePathTF.setText(path);
        if (!(path.equals(""))) {
            choosepicbtn.setEnabled(true);
            uploadPhotobtn.setEnabled(false);
        }

    }//GEN-LAST:event_uploadPhotobtnActionPerformed

    private void choosepicbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosepicbtnActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image Files", "jpg", "png", "jpeg");
        photoFilePathTF.setText("");
        String path = chooseFile(filter);
        photoFilePathTF.setText(path);
        if (!(path.equals(""))) {
            choosepicbtn.setEnabled(true);
        } else {
            uploadPhotobtn.setEnabled(true);
            choosepicbtn.setEnabled(false);
        }
    }//GEN-LAST:event_choosepicbtnActionPerformed

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
        // TODO add your handling code here:

        if (!(nameTF.getText().equals("")) && !(mail_IDTF.getText().equals("")) && !(deptTF.getText().equals("")) && !(mobileTF.getText().equals(""))
                && !(newuser_IDTF.getText().equals("")) && !(newPW_TF.getText().equals(""))
                && !(addressTA.getText().equals("")) && !(bloodgrpCB.getSelectedItem().toString().equals("-"))
                && !(photoFilePathTF.getText().equals(""))) {

            Sign_up_panelHistory.push(basic_Information_Panel);
            detailsPanel.removeAll();
            detailsPanel.add(school_details_panel);
            detailsPanel.repaint();
            detailsPanel.revalidate();
//            course_ug_CB.removeAll();
            course_CB_.removeAll();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                String q = "select cname from courses where cdegree = ?";
                PreparedStatement ps = con.prepareStatement(q, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.setString(1, "UG");
                ResultSet rs1 = ps.executeQuery();
                if (rs1.next()) {
                    rs1.first();
                    course_CB_.addItem("-");
                    course_CB_.addItem(rs1.getString("cname"));
                    while (rs1.next()) {
//                        course_ug_CB.addItem(rs1.getString("cname"));
                        course_CB_.addItem(rs1.getString("cname"));
                    }
                } else {
                    JOptionPane.showMessageDialog(detailsPanel, "userNot Found..! Please Contact EASC-ADMIN", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                }

                String q1 = "select cname from courses where cdegree = ?";
                PreparedStatement ps1 = con.prepareStatement(q1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps1.setString(1, "PG");
                ResultSet rs2 = ps1.executeQuery();
                if (rs2.next()) {
                    rs2.first();
                    course_CB_1.addItem("-");
                    course_CB_1.addItem(rs2.getString("cname"));
                    while (rs2.next()) {
                        course_CB_1.addItem(rs2.getString("cname"));
                    }
                    con.close();
                } else {
                    JOptionPane.showMessageDialog(detailsPanel, "userNot Found..! Please Contact EASC-ADMIN", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                }
                con.close();

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(detailsPanel, "Please Fill out the all Fields..! Or Contact Admin..!", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nextbtnActionPerformed

    private void cancelPWbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPWbtnActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(basic_Information_Panel, "Are You Sure Want To Exit?", "EASCPRO-STAFF", 2);
        if (res == 0) {
            cancelPWbtn.setVisible(false);
            createNewPWTF.setVisible(false);
            createConfirmPWTF.setVisible(false);
            createNewPWlbl.setVisible(false);
            confirmPWlbl.setVisible(false);
            createPWbtn.setVisible(false);
        }
    }//GEN-LAST:event_cancelPWbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        if (!Sign_up_panelHistory.isEmpty()) {
            JPanel topPanel = Sign_up_panelHistory.pop();
            detailsPanel.removeAll();
            detailsPanel.add(topPanel);
            detailsPanel.repaint();
            detailsPanel.revalidate();
        } else {
            System.out.println(Sign_up_panelHistory.pop());
        }
    }//GEN-LAST:event_backbtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (!Sign_up_panelHistory.isEmpty()) {
            JPanel topPanel = Sign_up_panelHistory.pop();
            detailsPanel.removeAll();
            detailsPanel.add(topPanel);
            detailsPanel.repaint();
            detailsPanel.revalidate();
        } else {
            System.out.println(Sign_up_panelHistory.pop());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void backbtn_forgotPWpanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtn_forgotPWpanelActionPerformed
        // TODO add your handling code here:
//        backbtn_forgotPWpanel
        if (!Sign_up_panelHistory.isEmpty()) {
            JPanel topPanel = Sign_up_panelHistory.pop();
            parentpanel.removeAll();
            parentpanel.add(topPanel);
            parentpanel.repaint();
            parentpanel.revalidate();
        } else {
            System.out.println(Sign_up_panelHistory.pop());
        }
    }//GEN-LAST:event_backbtn_forgotPWpanelActionPerformed

    private void backBtn_Sign_UP_PanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn_Sign_UP_PanelActionPerformed
        // TODO add your handling code here:
        if (!Sign_up_panelHistory.isEmpty()) {
            JPanel topPanel = Sign_up_panelHistory.pop();
            parentpanel.removeAll();
            parentpanel.add(topPanel);
            parentpanel.repaint();
            parentpanel.revalidate();
        } else {
            System.out.println(Sign_up_panelHistory.pop());
        }
    }//GEN-LAST:event_backBtn_Sign_UP_PanelActionPerformed

    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btnActionPerformed
        // TODO add your handling code here:

        int mark10 = 0;
        int mark12 = 0;

        try {
            mark10 = Integer.parseInt(tenth_th_mark_TF.getText());
            mark12 = Integer.parseInt(twelve_th_mark_TF.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(detailsPanel, "Please Enter the Proper 10th or 12th Value..!", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
        }

        if (mark10 > 175 && mark12 > 325) {
            if (!(tenth_th_medium_TF.getText().equals("")) && !(tenth_th_school_TF.getText().equals(""))) {
                if (!(twelve_th_medium_TF.getText().equals("")) && !(twelve_th_school_TF.getText().equals(""))) {

                    int index = 0;

                    schooldetails.add(tenth_th_mark_TF.getText());
                    schooldetails.add(tenth_th_school_TF.getText());
                    schooldetails.add(tenth_th_medium_TF.getText());

                    schooldetails.add(twelve_th_mark_TF.getText());
                    schooldetails.add(twelve_th_school_TF.getText());
                    schooldetails.add(twelve_th_medium_TF.getText());

                    index = schooldetails.indexOf(tenth_th_mark_TF.getText());
                    System.out.println(schooldetails.indexOf(tenth_th_mark_TF.getText()));
                    boolean res = SchooldetailsUpdate(index);

                    if (res) {
                        JOptionPane.showMessageDialog(detailsPanel, "Success.!", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(detailsPanel, "Failed", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    }

                    detailsPanel.removeAll();
                    detailsPanel.add(College_details_panel);
                    detailsPanel.repaint();
                    detailsPanel.revalidate();
                    Sign_up_panelHistory.push(school_details_panel);
                    percentageSlider.setValue(Integer.parseInt(percentageValue.getText().trim()));
                    percentageSlider1.setValue(Integer.parseInt(percentageValue1.getText().trim()));
                    PercentageforAddmoreDegree.setValue(Integer.parseInt(percentageValueforAddMoreDegree.getText().trim()));
                    for (int i = 1980; i <= 2100; i++) {
                        yop_CB_addMorePanel.addItem(String.valueOf(i));
                        yopCB1.addItem(String.valueOf(i));
                        yopCB.addItem(String.valueOf(i));
                    }
                } else {
                    JOptionPane.showMessageDialog(detailsPanel, "Please Fill ut the proper Details of your 12th std..!", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(detailsPanel, "Please Fill ut the proper Details of your 10th std..!", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(detailsPanel, "Please Enter the Proper 10th or 12th Value..!", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_next_btnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void percentageSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_percentageSliderStateChanged
        // TODO add your handling code here:
        int value = percentageSlider.getValue();
        percentageValue.setText(String.valueOf(value));
        percentageSlider.setValue(value);
    }//GEN-LAST:event_percentageSliderStateChanged

    private void percentageSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_percentageSlider1StateChanged
        // TODO add your handling code here:
        int value = percentageSlider1.getValue();
        percentageValue1.setText(String.valueOf(value));
        percentageSlider1.setValue(value);
    }//GEN-LAST:event_percentageSlider1StateChanged

    private void PercentageforAddmoreDegreeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PercentageforAddmoreDegreeStateChanged
        // TODO add your handling code here:
        int value = PercentageforAddmoreDegree.getValue();
        percentageValueforAddMoreDegree.setText(String.valueOf(value));
        PercentageforAddmoreDegree.setValue(value);
    }//GEN-LAST:event_PercentageforAddmoreDegreeStateChanged

    private void percentageValueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentageValueFocusLost
        // TODO add your handling code here:
        int sliderVal = Integer.parseInt(percentageValue.getText().trim());
        percentageSlider.setValue(sliderVal);

    }//GEN-LAST:event_percentageValueFocusLost

    private void percentageValue1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentageValue1FocusLost
        // TODO add your handling code here:
        int sliderVal = Integer.parseInt(percentageValue1.getText().trim());
        percentageSlider1.setValue(sliderVal);
    }//GEN-LAST:event_percentageValue1FocusLost

    private void percentageValueforAddMoreDegreeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentageValueforAddMoreDegreeFocusGained
        // TODO add your handling code here:
        percentageValueforAddMoreDegree.setText(percentageValueforAddMoreDegree.getText());
        KeyAdapter enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Transfer focus to the next component
                    ((JTextField) e.getSource()).transferFocus();
                }

            }
        };
        percentageValueforAddMoreDegree.addKeyListener(enterKeyListener);

    }//GEN-LAST:event_percentageValueforAddMoreDegreeFocusGained

    private void percentageValueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentageValueFocusGained
        // TODO add your handling code here:

        KeyAdapter enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Transfer focus to the next component
                    ((JTextField) e.getSource()).transferFocus();
                }
            }
        };
        percentageValue.addKeyListener(enterKeyListener);
    }//GEN-LAST:event_percentageValueFocusGained

    private void percentageValue1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentageValue1FocusGained
        // TODO add your handling code here:
        KeyAdapter enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Transfer focus to the next component
                    ((JTextField) e.getSource()).transferFocus();
                }

            }
        };
        percentageValue1.addKeyListener(enterKeyListener);
    }//GEN-LAST:event_percentageValue1FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!(course_CB_.getSelectedItem().toString().equals("-"))) {
            if (!(major_TF.getText().equals(""))) {
                if (!(college_TF.getText().equals(""))) {
                    if (!(university_TF.getText().equals(""))) {
                        if (!(yopCB.getSelectedItem().toString().equals(""))) {
                            collegedetails.add(course_CB_.getSelectedItem().toString());
                            collegedetails.add(major_TF.getText());
                            collegedetails.add(percentageValue.getText());
                            collegedetails.add(college_TF.getText());
                            collegedetails.add(university_TF.getText());
                            collegedetails.add(yopCB.getSelectedItem().toString());
                            if (!(course_CB_1.getSelectedItem().toString().equals("-")) && !(major_TF1.getText().equals(""))
                                    && !(college_TF1.getText().equals("")) && !(university_TF1.getText().equals(""))
                                    && !(yopCB1.getSelectedItem().toString().equals(""))) {
                                collegedetails.add(course_CB_1.getSelectedItem().toString());
                                collegedetails.add(major_TF1.getText());
                                collegedetails.add(percentageValue1.getText());
                                collegedetails.add(college_TF1.getText());
                                collegedetails.add(university_TF1.getText());
                                collegedetails.add(yopCB1.getSelectedItem().toString());
                                boolean res1 = CollegedetailsUpdate(collegedetails.indexOf(course_CB_.getSelectedItem().toString()));
                                boolean res2 = CollegedetailsUpdate(collegedetails.indexOf(course_CB_1.getSelectedItem().toString()));
                                if (res1 && res2) {
                                    JOptionPane.showMessageDialog(detailsPanel, "Record Inserted Successfully..!", "EASCPRO-STAFF", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(detailsPanel, "Record Inserted Failed..!", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(detailsPanel, "Please Fill Out The All Fields..! ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                            }

                            course_CB_.setSelectedIndex(0);
                            course_CB_1.setSelectedIndex(0);
                            major_TF.setText("");
                            major_TF1.setText("");
                            college_TF.setText("");
                            college_TF1.setText("");
                            university_TF.setText("");
                            university_TF1.setText("");
                            yopCB.setSelectedIndex(0);
                            yopCB1.setSelectedIndex(0);
                        } else {
                            JOptionPane.showMessageDialog(detailsPanel, "Please Select the Year of Passing When would you Completed ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(detailsPanel, "Please Select the University Where would you Completed ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(detailsPanel, "Please Select the College Where would you Completed ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(detailsPanel, "Please Select the Major What would you Completed ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(detailsPanel, "Please Select the Course What would you Completed ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void next_btn_collegedetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btn_collegedetailsActionPerformed
        // TODO add your handling code here:
        if (!(course_CB_.getSelectedItem().toString().equals("-")) && !(course_CB_1.getSelectedItem().toString().equals("-"))) {
            if (!(major_TF.getText().equals("")) && !(major_TF1.getText().equals(""))) {
                if (!(college_TF.getText().equals("")) && !(college_TF1.getText().equals(""))) {
                    if (!(university_TF.getText().equals("")) && !(university_TF1.getText().equals(""))) {
                        detailsPanel.removeAll();
                        detailsPanel.add(add_more_deg_panel);
                        detailsPanel.repaint();
                        detailsPanel.revalidate();
                        Sign_up_panelHistory.push(College_details_panel);
//                        JOptionPane.showMessageDialog(detailsPanel, "Profile Update Completed ", "EASCPRO-STAFF", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(detailsPanel, "Please Select the University When would you Completed ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(detailsPanel, "Please Select the College When would you Completed ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(detailsPanel, "Please Select the Major What would you Completed ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(detailsPanel, "Please Select the Course What would you Completed ", "EASCPRO-STAFF", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_next_btn_collegedetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CRTOTPstslbl;
    private javax.swing.JPanel Clg_Logo_Panel;
    private javax.swing.JPanel College_details_panel;
    private javax.swing.JLabel INCOTPstslbl;
    private javax.swing.JSlider PercentageforAddmoreDegree;
    private javax.swing.JTextField PhD_degree_TF;
    private javax.swing.JPanel Sign_inPanel;
    private javax.swing.JLabel add_more_deg_lbl;
    private javax.swing.JPanel add_more_deg_panel;
    private javax.swing.JScrollPane addressScrollPane;
    private javax.swing.JTextArea addressTA;
    private javax.swing.JLabel addresslbl;
    private javax.swing.JLabel bachelorofgedlbl;
    private javax.swing.JButton backBtn_Sign_UP_Panel;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton backbtn_forgotPWpanel;
    private javax.swing.JLabel basicDetailslbl;
    private javax.swing.JPanel basic_Information_Panel;
    private javax.swing.JComboBox<String> bloodgrpCB;
    private javax.swing.JLabel bloodgrplbl;
    private javax.swing.JButton cancelPWbtn;
    private javax.swing.JButton choosepicbtn;
    private javax.swing.JPanel clgimgpanel;
    private javax.swing.JLabel clglbl1;
    private javax.swing.JLabel clglbl2;
    private javax.swing.JLabel clglbl3;
    private javax.swing.JLabel clglbl4;
    private javax.swing.JPanel clgname;
    private javax.swing.JLabel collegeLBL_add_more_panel;
    private javax.swing.JTextField collegeTF_add_more_panel;
    private javax.swing.JTextField college_TF;
    private javax.swing.JTextField college_TF1;
    private javax.swing.JLabel college_lbl_Add_more;
    private javax.swing.JLabel college_lbl_Add_more1;
    private javax.swing.JLabel college_lbl_panel;
    private javax.swing.JLabel completeProfilelbl;
    private javax.swing.JTextField confirmPWTF;
    private javax.swing.JLabel confirmPWlbl;
    private javax.swing.JButton confirmbtn1;
    private javax.swing.JLabel continuelabel;
    private javax.swing.JLabel courseLBL_add_more_panel;
    private javax.swing.JComboBox<String> course_CB_;
    private javax.swing.JComboBox<String> course_CB_1;
    private javax.swing.JLabel course_lbl_Add_more;
    private javax.swing.JLabel course_lbl_Add_more1;
    private javax.swing.JPasswordField createConfirmPWTF;
    private javax.swing.JPasswordField createNewPWTF;
    private javax.swing.JLabel createNewPWlbl;
    private javax.swing.JButton createPWbtn;
    private javax.swing.JPanel default_panel;
    private javax.swing.JComboBox<String> deptCBbox;
    private javax.swing.JTextField deptTF;
    private javax.swing.JLabel deptlbl;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JLabel editlogoLBLforCreate_newPW;
    private javax.swing.JLabel enterOTPlbl;
    private javax.swing.JPanel forgotPWPanel;
    private javax.swing.JLabel forgotpanellbl;
    private javax.swing.JLabel forgotpwlbl;
    private javax.swing.JLabel hint_more_deg_lbl3;
    private javax.swing.JLabel hint_more_deg_lbl4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JTextField mailIdTF;
    private javax.swing.JTextField mail_IDTF;
    private javax.swing.JLabel mail_IDlbl;
    private javax.swing.JLabel mailidlbl;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField major_TF;
    private javax.swing.JTextField major_TF1;
    private javax.swing.JLabel major_lbl_Add_more;
    private javax.swing.JLabel major_lbl_Add_more1;
    private javax.swing.JLabel masterofgedlbl;
    private javax.swing.JLabel mobileNumberlbl;
    private javax.swing.JTextField mobileTF;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel namelbl;
    private javax.swing.JTextField newPWTF;
    private javax.swing.JTextField newPW_TF;
    private javax.swing.JLabel newPW_lbl;
    private javax.swing.JLabel newPWlbl;
    private javax.swing.JTextField newUserID;
    private javax.swing.JLabel newUserIdlbl;
    private javax.swing.JPasswordField newUserPW;
    private javax.swing.JLabel newUserPWlbl;
    private javax.swing.JButton newVerifybtn;
    private javax.swing.JTextField newuser_IDTF;
    private javax.swing.JLabel newuser_IDlbl;
    private javax.swing.JButton next_btn;
    private javax.swing.JButton next_btn_collegedetails;
    private javax.swing.JButton nextbtn;
    private javax.swing.JTextField otpTF;
    private javax.swing.JLabel otpsendingstslbl;
    private javax.swing.JPanel otpstspanel;
    private javax.swing.JLabel panel1;
    private javax.swing.JPanel parentpanel;
    private javax.swing.JLabel percentageLbl;
    private javax.swing.JLabel percentageLbl1;
    private javax.swing.JSlider percentageSlider;
    private javax.swing.JSlider percentageSlider1;
    private javax.swing.JTextField percentageValue;
    private javax.swing.JTextField percentageValue1;
    private javax.swing.JLabel percentageValueforAddMoreDegree;
    private javax.swing.JTextField photoFilePathTF;
    private javax.swing.JLabel photolbl;
    private javax.swing.JPasswordField pw;
    private javax.swing.JLabel reEnterPWlbl;
    private javax.swing.JButton resetbtn1;
    private javax.swing.JButton resetbtnforForgotpwPanel;
    private javax.swing.JPanel school_details_panel;
    private javax.swing.JLabel schooling_info_lbl;
    private javax.swing.JLabel scoreLBL_add_more_panel;
    private javax.swing.JButton sendbtn;
    private javax.swing.JPanel sign_up_panel;
    private javax.swing.JLabel sign_uplbl;
    private javax.swing.JLabel stfdeptlbl;
    private javax.swing.JLabel tenth_th_lbl;
    private javax.swing.JTextField tenth_th_mark_TF;
    private javax.swing.JLabel tenth_th_mark_lbl;
    private javax.swing.JTextField tenth_th_medium_TF;
    private javax.swing.JLabel tenth_th_medium_lbl;
    private javax.swing.JTextField tenth_th_school_TF;
    private javax.swing.JLabel tenth_th_school_lbl;
    private javax.swing.JTextField twelve_th_mark_TF;
    private javax.swing.JLabel twelve_th_mark_lbl;
    private javax.swing.JTextField twelve_th_medium_TF;
    private javax.swing.JLabel twelve_th_medium_lbl;
    private javax.swing.JTextField twelve_th_school_TF;
    private javax.swing.JLabel twelve_th_school_lbl;
    private javax.swing.JTextField uid;
    private javax.swing.JLabel universityLBL_add_more_panel;
    private javax.swing.JTextField universityTF_add_more_panel;
    private javax.swing.JTextField university_TF;
    private javax.swing.JTextField university_TF1;
    private javax.swing.JLabel university_lbl_Add_more;
    private javax.swing.JLabel university_lbl_Add_more1;
    private javax.swing.JButton uploadPhotobtn;
    private javax.swing.JTextField userIdTF;
    private javax.swing.JLabel userIdlbl;
    private javax.swing.JLabel userRegistrationlbl;
    private javax.swing.JButton verifyOTPbtn;
    private javax.swing.JButton verifybtn;
    private javax.swing.JLabel wellbl;
    private javax.swing.JLabel welllblforsign_uppanel;
    private javax.swing.JComboBox<String> yopCB;
    private javax.swing.JComboBox<String> yopCB1;
    private javax.swing.JLabel yopLBL_add_more_panel;
    private javax.swing.JLabel yopLbl;
    private javax.swing.JLabel yopLbl1;
    private javax.swing.JComboBox<String> yop_CB_addMorePanel;
    // End of variables declaration//GEN-END:variables
}
//
//class RoundedBorder implements Border {
//    private int radius;
//    private Color borderColor;
//
//    public RoundedBorder(int radius, Color borderColor) {
//        this.radius = radius;
//        this.borderColor = borderColor;
//    }
//
//    @Override
//    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        // Set border color and draw the rounded rectangle
//        g2.setColor(borderColor);
//        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
//
//        g2.dispose();
//    }
//
//    @Override
//    public Insets getBorderInsets(Component c) {
//        return new Insets(radius + 1, radius + 1, radius + 1, radius + 1);
//    }
//
//    @Override
//    public boolean isBorderOpaque() {
//        return false;
//    }
//}
