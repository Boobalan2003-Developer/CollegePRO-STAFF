package eascpkg;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class staffDashBoard extends javax.swing.JFrame {

    String stfname, stfmail, stfmob, stfpic = "", stfdept, stfaddress, stfdesignation, stfyoj;
    String stfUID = LoginFrame.userID;
    private String pass = LoginFrame.pass;
    static Image profileimg;
    static DefaultTableModel tableModel;
    static JTable attendanceTable;
    static String date;
    static String classInchargename;
    static String studept;

    public staffDashBoard() {
        initComponents();
        DateManagement();
//        threadTimeManagement();
        //Get Staff Details here...!
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q1 = "select * from staffdetails where staffid=?";
            PreparedStatement ps1 = con.prepareStatement(q1);
            ps1.setString(1, stfUID);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                stfpic = rs1.getString("staffPic");
                stfname = rs1.getString("staffname");
                stfdept = rs1.getString("staffdept");
                stfaddress = rs1.getString("staffaddress");
                stfmail = rs1.getString("staffMail");
                stfmob = rs1.getString("staffMob");
                stfdesignation = rs1.getString("staffdesignation");
                stfyoj = rs1.getString("YOJ");
                usernamelbl.setText(stfname);
                deptlbl.setText(stfdept);
                useridlbl.setText(stfUID);

            } else {
                System.out.println("Data not Fetched..!");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(staffDashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Font setu[ here...!
        try {
            File fontstl1 = new File("D:\\Font Styles\\Poppins\\Poppins-Medium.ttf");
            Font f1 = Font.createFont(Font.TRUETYPE_FONT, fontstl1).deriveFont(18f);
            Font f2 = Font.createFont(Font.TRUETYPE_FONT, fontstl1).deriveFont(14f);
            Font f3 = Font.createFont(Font.TRUETYPE_FONT, fontstl1).deriveFont(12f);
            clglbl3.setFont(f3);
            clglbl4.setFont(f3);
            clglbl2.setFont(f3);
            clglbl.setFont(f2);
            usernamelbl.setFont(f3);
            useridlbl.setFont(f3);
            deptlbl.setFont(f3);
            profilelbl.setFont(f3);
            schedulelbl.setFont(f3);
            leavelbl.setFont(f3);
            logoutlbl.setFont(f1);
            loggedlbl.setFont(f1);
            academicinfolbl.setFont(f2);
            clsschedulelbl.setFont(f2);
            IIIctlbl.setFont(f3);
            collegelbl.setFont(f1);
            stfdashboardlbl.setFont(f2);
            profileinolbl.setFont(f1);
            unamelblforprofile.setFont(f3);
            deptlabelforprofile.setFont(f3);
            UIDlblforprofile.setFont(f3);
            addlblforprofile.setFont(f2);
            emailidlblforprofile.setFont(f2);
            mobilelblforprofile.setFont(f2);
            addresslblforprofile.setFont(f3);
            mobTFforprofile.setFont(f3);
            mailidTFforprofile.setFont(f3);
            leavemanagementlbl.setFont(f2);
            avgintimelbl.setFont(f3);
            avgouttimelbl.setFont(f3);
            intime.setFont(f3);
            outtime.setFont(f3);
            jLabel9.setFont(f3);
            jLabel6.setFont(f3);
            totalLeavelbl.setFont(f3);
            jLabel8.setFont(f3);
            takenLeavelbl.setFont(f3);
            availableLeavelbl.setFont(f3);
            jLabel19.setFont(f1);
            yojlblforprofile.setFont(f3);
            yojforprofile.setFont(f3);
            lbl1forprofile.setFont(f3);
            lbl2forprofile.setFont(f3);
            lbl3forprofile.setFont(f3);
            designationlblforprofile.setFont(f3);
            designationforprofile.setFont(f3);
            academicInfolbl.setFont(f2);
            schoolingInfolbl.setFont(f3);
            collegeInfolbl.setFont(f3);
            schoolingInfolblforparentPanel.setFont(f2);
            sslclbl.setFont(f2);
            hsclbl.setFont(f2);
            schoollbl10.setFont(f3);
            boardlbl10.setFont(f3);
            scorelbl10.setFont(f3);
            school10.setFont(f3);
            board10.setFont(f3);
            score10.setFont(f3);
            schoollbl12.setFont(f3);
            boardlbl12.setFont(f3);
            scorelbl12.setFont(f3);
            school12.setFont(f3);
            board12.setFont(f3);
            score12.setFont(f3);
            collegeInfolblforParentPanel.setFont(f2);
            clgnamelbl1.setFont(f3);
            universitynamelbl.setFont(f3);
            aggregatelbl.setFont(f3);
            clgnameforug1.setFont(f3);
            universitynameforug1.setFont(f3);
            aggregateforug1.setFont(f3);
            uglbl.setFont(f3);
            degree.setFont(f3);
            deglbl.setFont(f3);
            yopforug1.setFont(f3);
            yoplbl.setFont(f3);
            majorforug1.setFont(f3);
            majorlbl1.setFont(f3);
            schedulelblforSchedulePanel.setFont(f2);
            lblfordefaultpanelacademic.setFont(f2);
            defualtlblforTimeTablePanel.setFont(f2);
            SchedulelblforStaff.setFont(f3);
            SchedulelblforClass.setFont(f3);
            attendancelbl.setFont(f2);
            IIIctlblforAttendance.setFont(f2);
            IICT_lbl.setFont(f2);
            defaultlblforAttenadancemanagement.setFont(f2);
            attendancelblformenupanel.setFont(f3);
            III_ct_attendance.setFont(f2);
            clsinchargenamelblICT.setFont(f2);
            clsinchargenamelbl.setFont(f2);
            submitbtnforAttendance.setFont(f2);
            facultynamelbl.setFont(f3);
            facultyIDlbl.setFont(f3);
            facultyname.setFont(f3);
            facultyID.setFont(f3);
            paperhandlelbl.setFont(f3);
            hourCB.setFont(f3);
            hourlbl.setFont(f3);
            IICT_lbl.setFont(f2);
            II_ct_attendance1.setFont(f2);
            clsinchargenamelbl.setFont(f2);
            facultyIICT.setFont(f3);
            facultyIDlblIICT.setFont(f3);
            facultynamelblICT.setFont(f3);
            facultynameIICT.setFont(f3);
            facultyIICT.setFont(f3);
            paperhandlelblIICT.setFont(f3);
            paperCBIICT.setFont(f3);
            hourlblIICT.setFont(f3);
            hourCBIICT.setFont(f3);

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        //Backgroud image for parent panel..!  
        ImageIcon bgimgaddress = new ImageIcon("D:\\netBeans\\EASCPRJ-STAFF\\src\\Resources\\ClgImg.png");
        Image bgimage = bgimgaddress.getImage();
        Image backimg = bgimage.getScaledInstance(940, 420, bgimage.SCALE_SMOOTH);
        parentpanelbgimg.setIcon(new ImageIcon(backimg));

        ImageIcon logo1 = new ImageIcon("D:\\netBeans\\EASCPRJ-STAFF\\src\\Resources\\logo.png");
        Image img1 = logo1.getImage();
        Image scimg1 = img1.getScaledInstance(90, 90, img1.SCALE_SMOOTH);
        clglogo1.setIcon(new ImageIcon(scimg1));

        //Menu bar creates here..!
        JMenuBar mb1 = new JMenuBar();

        JMenu profilemenu = new JMenu("Profile Management");//Menu-1
        mb1.add(profilemenu);
        JMenuItem personalinfo = new JMenuItem("Personal Info");//menu-1 menu-1
        profilemenu.add(personalinfo);
        JMenuItem academicinfo = new JMenuItem("Academic Information");//menu-1 menu-2
        profilemenu.add(academicinfo);
        JMenuItem leavemanagement = new JMenuItem("Leave Management");//menu-1 menu-1
        profilemenu.add(leavemanagement);
        JMenuItem stftimetable = new JMenuItem("Staff Time Table");
        profilemenu.add(stftimetable);

        JMenuItem quit = new JMenuItem("Quit");
        quit.setMnemonic('x');
        profilemenu.add(quit);

        //Listeners here.!
        personalinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personal_info();
            }
        }
        );

        academicinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                academicInfo();
            }
        });
        leavemanagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leaveManagement();
            }
        });

        stftimetable.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                stfScheduleGenerate();
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(parentPanel, "Are You Sure want to Quit ?", "EASCPRO", 2);

                if (res == 0) {
                    System.exit(0);
                }
            }
        });

        JMenu attendacemanagement = new JMenu("Attendace Management");
        mb1.add(attendacemanagement);
        JMenuItem markattendace = new JMenuItem("Mark Attendance");
        attendacemanagement.add(markattendace);
        JMenuItem viewAttendance = new JMenuItem("View Attendance");
        attendacemanagement.add(viewAttendance);

        JMenu assesments = new JMenu("Assesments");
        mb1.add(assesments);
        JMenuItem scheduleAssesments = new JMenuItem("Schedule Assesments");
        assesments.add(scheduleAssesments);
        JMenuItem mark = new JMenuItem("Enter Marks");
        assesments.add(mark);
        JMenuItem view_updateMarks = new JMenuItem("View/Update Marks");
        assesments.add(view_updateMarks);

        JMenu classRoom = new JMenu("Class Room");
        mb1.add(classRoom);
        JMenuItem clsSchedule = new JMenuItem("Class Scedule");
        classRoom.add(clsSchedule);
        JMenuItem clsAllocation = new JMenuItem("Class Allocation");
        classRoom.add(clsAllocation);

        clsSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classScheduleGenerate();
            }
        });
        JMenu communication = new JMenu("Communication");
        mb1.add(communication);
        JMenuItem notice = new JMenuItem("Notices");
        communication.add(notice);
        JMenuItem stdQueries = new JMenuItem("Student Queries");
        communication.add(stdQueries);

        JMenu report = new JMenu("Reports");
        mb1.add(report);
        JMenuItem genReport = new JMenuItem("Generate Reports");
        report.add(genReport);
        JMenuItem downloadReport = new JMenuItem("Download Report");
        report.add(downloadReport);

        //Frame Set-up here..!
        setTitle("EASCPRO");
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\netBeans\\EASCPRJ-STAFF\\src\\Resources\\logo.png"));
        setJMenuBar(mb1);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void DateManagement() {
        //Date Management..!
        LocalDateTime localDate = LocalDateTime.now(); // fixed: LocalDateTime
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        date = dateFormatter.format(localDate);
    }

    int seconds = 0;

// public void timeManagement()
// {
//    LocalDateTime  localDate = LocalDateTime.now();
//    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
//    DateTimeFormatter secFormatter = DateTimeFormatter.ofPattern("ss");
//    String time=timeFormatter.format(localDate);
//    String secStr=secFormatter.format(localDate);
//    int sec=Integer.parseInt(secStr);
//    seconds=sec*1000;
//    timelbl.setText(time);
// }
// private void threadTimeManagement()
// {
//     Thread incrementThread = new Thread(() -> {
//          boolean running=true;
//            while (running) {
//                timeManagement();
//                try {
//                    Thread.sleep(60000-seconds); // Sleep for 60 second
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//     incrementThread.start();
// }
//    
    private Image userProfileImagegenerate(int x, int y) {
        int imgHeight = y;
        int imgWidth = x;
        ImageIcon img_source = new ImageIcon(stfpic);
        Image img = img_source.getImage();
        profileimg = img.getScaledInstance(imgWidth, imgHeight, img.SCALE_SMOOTH);
        return profileimg;
    }

    private void personal_info() {
        parentPanel.removeAll();
        parentPanel.add(profilePanel);
        parentPanel.repaint();
        parentPanel.revalidate();
        addresslblforprofile.setLineWrap(true);
        addresslblforprofile.setText(stfaddress);
        addresslblforprofile.setMargin(new Insets(10, 10, 10, 10));//set padding to Address TextArea..!
        mobTFforprofile.setText("+91 " + stfmob);
        mailidTFforprofile.setText(stfmail);
        imglbl.setIcon(new ImageIcon(userProfileImagegenerate(150, 200)));
        unamelblforprofile.setText(stfname);
        deptlabelforprofile.setText(stfdept);
        UIDlblforprofile.setText(stfUID);
        yojforprofile.setText(stfyoj);
        designationforprofile.setText(stfdesignation);
        ImageIcon editlogoimgadd = new ImageIcon("D:\\netBeans\\EASCPRJ-STAFF\\src\\Resources\\editlogo.png");
        Image image = editlogoimgadd.getImage();
        Image res = image.getScaledInstance(30, 20, image.SCALE_SMOOTH);
        editlogoimg1.setIcon(new ImageIcon(res));

        editlogoimg2.setIcon(new ImageIcon(res));
        editlogoimg3.setIcon(new ImageIcon(res));

    }

    public void academicInfo() {
        parentPanel.removeAll();
        parentPanel.add(academicInfo);
        parentPanel.repaint();
        parentPanel.revalidate();
    }

    void leaveManagement() {
        parentPanel.removeAll();
        parentPanel.add(leavemanagement);
        parentPanel.repaint();
        parentPanel.revalidate();
        applyleavebtnforattendance.setEnabled(false);
        deptnameforleavemanagementlbl.setText(stfdept);
        cancelleavebtnforattendance.setEnabled(false);
        try {
            int takenLeave, availableLeave = 0, totalLeave;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q = "select * from staffLeaveManagement where stfId=?";
            PreparedStatement ps1 = con.prepareStatement(q);
            ps1.setString(1, stfUID);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                takenLeave = rs1.getInt("takenLeave");
                totalLeave = rs1.getInt("totalLeave");

                takenLeavelbl.setText(String.valueOf(takenLeave));
                totalLeavelbl.setText(String.valueOf(totalLeave));

                if (takenLeave < totalLeave) {
                    availableLeave = totalLeave - takenLeave;
                    applyleavebtnforattendance.setEnabled(true);
                    cancelleavebtnforattendance.setEnabled(true);
                    availableLeavelbl.setText(String.valueOf(availableLeave));
                } else {
                    availableLeavelbl.setText(String.valueOf(availableLeave));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        unamelblforattendance.setText(stfname);
        desgnationlblforattendace.setText(stfdesignation);
        useridlblforattendancepanel.setText(stfUID);
        profilepicforattendancepanel.setIcon(new ImageIcon(userProfileImagegenerate(140, 170)));
    }

    public void Schedule() {
        parentPanel.removeAll();
        parentPanel.add(SchedulePanel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }

    public void classScheduleGenerate() {
        ParentPanelforTimeTable.removeAll();
        ParentPanelforTimeTable.add(classSchedule);
        ParentPanelforTimeTable.repaint();
        ParentPanelforTimeTable.revalidate();
    }

    public void stfScheduleGenerate() {
        ParentPanelforTimeTable.removeAll();
        ParentPanelforTimeTable.add(stfSchedule);
        ParentPanelforTimeTable.repaint();
        ParentPanelforTimeTable.revalidate();
    }

    private void schoolingInfo() {
        parentpanel.removeAll();
        parentpanel.add(schoolingInfoPanel);
        parentpanel.repaint();
        parentpanel.revalidate();

        profilepicforsclinfo.setIcon(new ImageIcon(userProfileImagegenerate(160, 200)));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q = "select * from staffschooling where staffid=?";
            PreparedStatement ps1 = con.prepareStatement(q);
            ps1.setString(1, stfUID);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                school10.setText(rs.getString("school"));
                board10.setText(rs.getString("boardSSLC"));
                score10.setText(rs.getString("sslc"));

                school12.setText(rs.getString("schoolHSC"));
                board12.setText(rs.getString("board"));
                score12.setText(rs.getString("hsc"));
            } else {
                JOptionPane.showMessageDialog(parentPanel, "Invalid User Data ..!", "EASCPRO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void collegeInfo() {
        parentpanel.removeAll();
        parentpanel.add(collegeInfoPanel);
        parentpanel.repaint();
        parentpanel.revalidate();

        profilepicforclginfo.setIcon(new ImageIcon(userProfileImagegenerate(160, 200)));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q = "select * from staffcollege where staffid=?";
            PreparedStatement ps1 = con.prepareStatement(q);
            ps1.setString(1, stfUID);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                degree.setText(rs.getString("staffdegree"));
                majorforug1.setText(rs.getString("major"));
                clgnameforug1.setText(rs.getString("collegename"));
                universitynameforug1.setText(rs.getString("university"));
                aggregateforug1.setText(rs.getString("percentage") + " %");
                yopforug1.setText(rs.getString("yop"));
            } else {
                JOptionPane.showMessageDialog(parentPanel, "Invalid User Data ..!", "EASCPRO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    void attendancemanagement(String yoj, JPanel panel) {
        String[] items = {"-", "Tamil", "English", "Maths", "Programming C", "Lab-C", "EVS"};

        for (int i = 0; i < items.length; i++) {
            paperCB.addItem(items[i]);
            if (i <= 5) {
                hourCB.addItem(String.valueOf(i));
            }
        }

        facultyname.setText(stfname);
        facultynameIICT.setText(stfname);
        facultyID.setText(LoginFrame.userID);
        facultyIICT.setText(LoginFrame.userID);

        String[] columnNames = {"S.No", "Student ID", "Student Name", "Attendance"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // All cells are non-editable
            }

        };
        attendanceTable = new JTable(tableModel) {
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 3 ? Boolean.class : String.class;
            }
        };
        JScrollPane tableScrollPane = new JScrollPane(attendanceTable);
        attendanceTable.setRowHeight(25);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < attendanceTable.getColumnCount() - 1; i++) {
            TableColumn column = attendanceTable.getColumnModel().getColumn(i);
            column.setCellRenderer(centerRenderer);
        }

        TableColumn snoColumn = attendanceTable.getColumnModel().getColumn(0);
        snoColumn.setMaxWidth(35);
        int sno = 1;
        try {
            System.out.println(yoj);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q1 = "select * from bscctbatch22 where yoj=? ";
            PreparedStatement ps1 = con.prepareStatement(q1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps1.setString(1, yoj);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.first()) {
                classInchargename = rs1.getString("classincharge");
                clsinchargenamelbl.setText("Class Incharge: " + classInchargename);
                clsinchargenamelblICT.setText("Class Incharge: " + classInchargename);
                studept = rs1.getString("dept");
                rs1.first();
                String stdname = rs1.getString("sname");
                String stuid = rs1.getString("stuid");
                tableModel.addRow(new Object[]{sno, stdname, stuid, true});
                sno++;
                while (rs1.next()) {
                    stdname = rs1.getString("sname");
                    stuid = rs1.getString("stuid");
                    tableModel.addRow(new Object[]{sno, stdname, stuid, true});
                    sno++;
                }
            } else {
                System.out.println("Data Not fetched..!");
            }
        } catch (ClassNotFoundException | SQLException cse) {
            cse.printStackTrace();
        }
        panel.add(tableScrollPane, BorderLayout.CENTER);

        submitbtnforAttendance.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String paper = paperCB.getSelectedItem().toString();
                String hour = hourCB.getSelectedItem().toString();
                if (!(paper.equals("-")) && !(hour.equals("0"))) {
                    submitStudentAttendance(facultyname.getText(), paper, hour);
                } else {
                    JOptionPane.showMessageDialog(parentPanel, "Check and Fill the All Faculty Fields..!", "EASCPRO", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    private void submitStudentAttendance(String facultyname, String paper, String hour) {
        boolean res = false;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int sno = (int) tableModel.getValueAt(i, 0);
            String studname = (String) tableModel.getValueAt(i, 1);
            String stuid = (String) tableModel.getValueAt(i, 2);
            Boolean attendance = (Boolean) tableModel.getValueAt(i, 3);
            System.out.println(studname);
            String attendanceStatus = "AA";
            if (attendance) {
                attendanceStatus = "Present";
            }
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                String q1 = "insert into ctattendance2021(stuid,stuname,studept,classIncharge,hour,date,peperofHandling,PaperIncharge,AttendanceStatus) values(?,?,?,?,?,?,?,?,?)";//?==> sno,stuid,stuname,studept,hour,date,incharge..!
                PreparedStatement ps1 = con.prepareStatement(q1);
//            ps1.setInt(1,i);
                ps1.setString(1, stuid);
                ps1.setString(2, studname);
                System.out.println("123" + studname);
                ps1.setString(3, studept);
                ps1.setString(4, classInchargename);
                ps1.setString(5, hour);
                ps1.setString(6, date);
                ps1.setString(7, paper);
                ps1.setString(8, facultyname);
                ps1.setString(9, attendanceStatus);
                ps1.execute();
                res = true;
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(staffDashBoard.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (res) {
            JOptionPane.showMessageDialog(parentPanel, "Attendance Updated..!", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(parentPanel, "Attendance Update Failed..!", "EASCPRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        menupanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        loggedlbl = new javax.swing.JLabel();
        usernamelbl = new javax.swing.JLabel();
        useridlbl = new javax.swing.JLabel();
        deptlbl = new javax.swing.JLabel();
        logoutlbl = new javax.swing.JLabel();
        profilelbl = new javax.swing.JLabel();
        schedulelbl = new javax.swing.JLabel();
        leavelbl = new javax.swing.JLabel();
        attendancelblformenupanel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        clglogo1 = new javax.swing.JLabel();
        clglbl = new javax.swing.JLabel();
        clglbl4 = new javax.swing.JLabel();
        clglbl2 = new javax.swing.JLabel();
        clglbl3 = new javax.swing.JLabel();
        parentPanel = new javax.swing.JPanel();
        welcomepanel = new javax.swing.JPanel();
        collegelbl = new javax.swing.JLabel();
        stfdashboardlbl = new javax.swing.JLabel();
        bgpanel = new javax.swing.JPanel();
        parentpanelbgimg = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        imglbl = new javax.swing.JLabel();
        lbl1forprofile = new javax.swing.JLabel();
        lbl2forprofile = new javax.swing.JLabel();
        lbl3forprofile = new javax.swing.JLabel();
        UIDlblforprofile = new javax.swing.JLabel();
        deptlabelforprofile = new javax.swing.JLabel();
        unamelblforprofile = new javax.swing.JLabel();
        profileinolbl = new javax.swing.JLabel();
        addlblforprofile = new javax.swing.JLabel();
        addresslblforprofile = new javax.swing.JTextArea();
        emailidlblforprofile = new javax.swing.JLabel();
        mailidTFforprofile = new javax.swing.JTextField();
        mobilelblforprofile = new javax.swing.JLabel();
        mobTFforprofile = new javax.swing.JTextField();
        editlogoimg1 = new javax.swing.JLabel();
        editlogoimg2 = new javax.swing.JLabel();
        editlogoimg3 = new javax.swing.JLabel();
        yojlblforprofile = new javax.swing.JLabel();
        yojforprofile = new javax.swing.JLabel();
        designationlblforprofile = new javax.swing.JLabel();
        designationforprofile = new javax.swing.JLabel();
        leavemanagement = new javax.swing.JPanel();
        leavemanagementlbl = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        profilepicforattendancepanel = new javax.swing.JLabel();
        unamelblforattendance = new javax.swing.JLabel();
        desgnationlblforattendace = new javax.swing.JLabel();
        useridlblforattendancepanel = new javax.swing.JLabel();
        deptnameforleavemanagementlbl = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        applyleavebtnforattendance = new javax.swing.JButton();
        cancelleavebtnforattendance = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        totalLeavelbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        takenLeavelbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        availableLeavelbl = new javax.swing.JLabel();
        avgintimelbl = new javax.swing.JLabel();
        intime = new javax.swing.JLabel();
        outtime = new javax.swing.JLabel();
        avgouttimelbl = new javax.swing.JLabel();
        academicInfo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        academicInfolbl = new javax.swing.JLabel();
        schoolingInfolbl = new javax.swing.JLabel();
        collegeInfolbl = new javax.swing.JLabel();
        parentpanel = new javax.swing.JPanel();
        defaultPanel = new javax.swing.JPanel();
        lblfordefaultpanelacademic = new javax.swing.JLabel();
        schoolingInfoPanel = new javax.swing.JPanel();
        schoolingInfolblforparentPanel = new javax.swing.JLabel();
        sslclbl = new javax.swing.JLabel();
        schoollbl10 = new javax.swing.JLabel();
        boardlbl10 = new javax.swing.JLabel();
        scorelbl10 = new javax.swing.JLabel();
        hsclbl = new javax.swing.JLabel();
        schoollbl12 = new javax.swing.JLabel();
        boardlbl12 = new javax.swing.JLabel();
        scorelbl12 = new javax.swing.JLabel();
        school10 = new javax.swing.JLabel();
        board10 = new javax.swing.JLabel();
        score10 = new javax.swing.JLabel();
        school12 = new javax.swing.JLabel();
        board12 = new javax.swing.JLabel();
        score12 = new javax.swing.JLabel();
        profilepicforsclinfo = new javax.swing.JLabel();
        collegeInfoPanel = new javax.swing.JPanel();
        collegeInfolblforParentPanel = new javax.swing.JLabel();
        uglbl = new javax.swing.JLabel();
        clgnamelbl1 = new javax.swing.JLabel();
        universitynamelbl = new javax.swing.JLabel();
        aggregatelbl = new javax.swing.JLabel();
        clgnameforug1 = new javax.swing.JLabel();
        universitynameforug1 = new javax.swing.JLabel();
        aggregateforug1 = new javax.swing.JLabel();
        deglbl = new javax.swing.JLabel();
        degree = new javax.swing.JLabel();
        yoplbl = new javax.swing.JLabel();
        yopforug1 = new javax.swing.JLabel();
        majorforug1 = new javax.swing.JLabel();
        majorlbl1 = new javax.swing.JLabel();
        profilepicforclginfo = new javax.swing.JLabel();
        SchedulePanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        schedulelblforSchedulePanel = new javax.swing.JLabel();
        SchedulelblforStaff = new javax.swing.JLabel();
        SchedulelblforClass = new javax.swing.JLabel();
        ParentPanelforTimeTable = new javax.swing.JPanel();
        defaultpanelforTimeTable = new javax.swing.JPanel();
        defualtlblforTimeTablePanel = new javax.swing.JLabel();
        classSchedule = new javax.swing.JPanel();
        clsschedulelbl = new javax.swing.JLabel();
        IIIctlbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        stfSchedule = new javax.swing.JPanel();
        academicinfolbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stfschedule = new javax.swing.JTable();
        attendance_Management = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        attendancelbl = new javax.swing.JLabel();
        IIIctlblforAttendance = new javax.swing.JLabel();
        IICT_lbl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        defaultlblforAttenadancemanagement = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        III_ct_attendance = new javax.swing.JLabel();
        clsinchargenamelbl = new javax.swing.JLabel();
        submitbtnforAttendance = new javax.swing.JButton();
        facultynamelbl = new javax.swing.JLabel();
        facultyname = new javax.swing.JLabel();
        facultyIDlbl = new javax.swing.JLabel();
        facultyID = new javax.swing.JLabel();
        paperhandlelbl = new javax.swing.JLabel();
        paperCB = new javax.swing.JComboBox<>();
        hourlbl = new javax.swing.JLabel();
        hourCB = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        II_ct_attendance1 = new javax.swing.JLabel();
        clsinchargenamelblICT = new javax.swing.JLabel();
        submitbtnforAttendance1 = new javax.swing.JButton();
        facultynamelblICT = new javax.swing.JLabel();
        facultynameIICT = new javax.swing.JLabel();
        facultyIDlblIICT = new javax.swing.JLabel();
        facultyIICT = new javax.swing.JLabel();
        paperhandlelblIICT = new javax.swing.JLabel();
        paperCBIICT = new javax.swing.JComboBox<>();
        hourlblIICT = new javax.swing.JLabel();
        hourCBIICT = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COLLEGEPRO");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menupanel.setBackground(new java.awt.Color(82, 155, 255));
        menupanel.setLayout(null);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Shortcuts");
        menupanel.add(jLabel19);
        jLabel19.setBounds(0, 20, 200, 20);

        loggedlbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loggedlbl.setForeground(new java.awt.Color(255, 255, 255));
        loggedlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loggedlbl.setText("Logged In");
        menupanel.add(loggedlbl);
        loggedlbl.setBounds(0, 410, 200, 30);

        usernamelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernamelbl.setText("UserName");
        usernamelbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menupanel.add(usernamelbl);
        usernamelbl.setBounds(0, 450, 200, 30);

        useridlbl.setBackground(new java.awt.Color(82, 105, 255));
        useridlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        useridlbl.setText("User-Id");
        menupanel.add(useridlbl);
        useridlbl.setBounds(0, 480, 200, 30);

        deptlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deptlbl.setText("Department");
        menupanel.add(deptlbl);
        deptlbl.setBounds(0, 510, 200, 30);

        logoutlbl.setForeground(new java.awt.Color(255, 255, 255));
        logoutlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutlbl.setText("Logout");
        logoutlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutlblMouseClicked(evt);
            }
        });
        menupanel.add(logoutlbl);
        logoutlbl.setBounds(0, 610, 200, 30);

        profilelbl.setText("Profile Info");
        profilelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profilelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilelblMouseClicked(evt);
            }
        });
        menupanel.add(profilelbl);
        profilelbl.setBounds(10, 60, 190, 30);

        schedulelbl.setText("Schedule");
        schedulelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        schedulelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                schedulelblMouseClicked(evt);
            }
        });
        menupanel.add(schedulelbl);
        schedulelbl.setBounds(10, 90, 190, 30);

        leavelbl.setText("Leave Management");
        leavelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leavelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leavelblMouseClicked(evt);
            }
        });
        menupanel.add(leavelbl);
        leavelbl.setBounds(10, 120, 190, 30);

        attendancelblformenupanel.setText("Attendance Management");
        attendancelblformenupanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        attendancelblformenupanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendancelblformenupanelMouseClicked(evt);
            }
        });
        menupanel.add(attendancelblformenupanel);
        attendancelblformenupanel.setBounds(10, 150, 190, 30);

        jPanel2.add(menupanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 144, 200, 660));

        jPanel1.setBackground(new java.awt.Color(82, 155, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(clglogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        clglbl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        clglbl.setForeground(new java.awt.Color(255, 255, 255));
        clglbl.setText("ABC Arts and Science College");
        jPanel1.add(clglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 280, 30));

        clglbl4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clglbl4.setForeground(new java.awt.Color(255, 255, 255));
        clglbl4.setText("ABC- 630323");
        jPanel1.add(clglbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 170, -1));

        clglbl2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clglbl2.setForeground(new java.awt.Color(255, 255, 255));
        clglbl2.setText("Affiliated to Bharathiar University");
        jPanel1.add(clglbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 260, -1));

        clglbl3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clglbl3.setForeground(new java.awt.Color(255, 255, 255));
        clglbl3.setText("Autonomous (Co-Education)");
        jPanel1.add(clglbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 230, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 1530, 140));

        parentPanel.setBackground(new java.awt.Color(255, 51, 255));
        parentPanel.setLayout(new java.awt.CardLayout());

        welcomepanel.setBackground(new java.awt.Color(245, 245, 245));
        welcomepanel.setLayout(null);

        collegelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collegelbl.setText("ABC Arts And Science College");
        welcomepanel.add(collegelbl);
        collegelbl.setBounds(430, 30, 510, 70);

        stfdashboardlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stfdashboardlbl.setText("Affiliated to Bharathiar University");
        welcomepanel.add(stfdashboardlbl);
        stfdashboardlbl.setBounds(450, 70, 470, 50);

        bgpanel.setLayout(new java.awt.BorderLayout());
        bgpanel.add(parentpanelbgimg, java.awt.BorderLayout.CENTER);

        welcomepanel.add(bgpanel);
        bgpanel.setBounds(180, 170, 940, 420);

        parentPanel.add(welcomepanel, "card11");

        profilePanel.setLayout(null);

        imglbl.setBackground(new java.awt.Color(204, 204, 255));
        imglbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imglbl.setText("Profile Image");
        profilePanel.add(imglbl);
        imglbl.setBounds(360, 120, 150, 200);

        lbl1forprofile.setText("User Name");
        profilePanel.add(lbl1forprofile);
        lbl1forprofile.setBounds(570, 120, 100, 20);

        lbl2forprofile.setText("Department");
        profilePanel.add(lbl2forprofile);
        lbl2forprofile.setBounds(570, 160, 100, 20);

        lbl3forprofile.setText("User ID");
        profilePanel.add(lbl3forprofile);
        lbl3forprofile.setBounds(570, 200, 100, 20);

        UIDlblforprofile.setText("User ID");
        profilePanel.add(UIDlblforprofile);
        UIDlblforprofile.setBounds(690, 200, 200, 20);

        deptlabelforprofile.setText("Department");
        profilePanel.add(deptlabelforprofile);
        deptlabelforprofile.setBounds(690, 160, 200, 20);

        unamelblforprofile.setText("uname");
        profilePanel.add(unamelblforprofile);
        unamelblforprofile.setBounds(690, 120, 200, 20);

        profileinolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileinolbl.setText("Profile Info");
        profilePanel.add(profileinolbl);
        profileinolbl.setBounds(560, 50, 180, 20);

        addlblforprofile.setText("Address");
        profilePanel.add(addlblforprofile);
        addlblforprofile.setBounds(570, 400, 90, 30);

        addresslblforprofile.setColumns(20);
        addresslblforprofile.setRows(5);
        profilePanel.add(addresslblforprofile);
        addresslblforprofile.setBounds(690, 400, 220, 84);

        emailidlblforprofile.setText("Email-ID");
        profilePanel.add(emailidlblforprofile);
        emailidlblforprofile.setBounds(570, 320, 90, 30);

        mailidTFforprofile.setText("Mail-ID");
        mailidTFforprofile.setToolTipText("Mail-ID");
        mailidTFforprofile.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        mailidTFforprofile.setEnabled(false);
        profilePanel.add(mailidTFforprofile);
        mailidTFforprofile.setBounds(690, 320, 220, 30);

        mobilelblforprofile.setText("Mobile");
        profilePanel.add(mobilelblforprofile);
        mobilelblforprofile.setBounds(570, 360, 90, 30);

        mobTFforprofile.setText("+91 ");
        mobTFforprofile.setToolTipText("Mobile");
        mobTFforprofile.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        mobTFforprofile.setEnabled(false);
        profilePanel.add(mobTFforprofile);
        mobTFforprofile.setBounds(690, 360, 220, 30);

        editlogoimg1.setToolTipText("Edit");
        editlogoimg1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editlogoimg1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editlogoimg1MouseClicked(evt);
            }
        });
        profilePanel.add(editlogoimg1);
        editlogoimg1.setBounds(920, 420, 30, 20);

        editlogoimg2.setToolTipText("Edit");
        editlogoimg2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editlogoimg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editlogoimg2MouseClicked(evt);
            }
        });
        profilePanel.add(editlogoimg2);
        editlogoimg2.setBounds(920, 320, 30, 20);

        editlogoimg3.setToolTipText("Edit");
        editlogoimg3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editlogoimg3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editlogoimg3MouseClicked(evt);
            }
        });
        profilePanel.add(editlogoimg3);
        editlogoimg3.setBounds(920, 360, 30, 20);

        yojlblforprofile.setText("Year of Joining");
        profilePanel.add(yojlblforprofile);
        yojlblforprofile.setBounds(570, 280, 90, 20);

        yojforprofile.setText("yoj");
        profilePanel.add(yojforprofile);
        yojforprofile.setBounds(690, 280, 90, 20);

        designationlblforprofile.setText("Designation");
        profilePanel.add(designationlblforprofile);
        designationlblforprofile.setBounds(570, 240, 120, 20);

        designationforprofile.setText("Designation");
        profilePanel.add(designationforprofile);
        designationforprofile.setBounds(690, 240, 220, 20);

        parentPanel.add(profilePanel, "card3");

        leavemanagement.setLayout(null);

        leavemanagementlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leavemanagementlbl.setText("Leave Management");
        leavemanagement.add(leavemanagementlbl);
        leavemanagementlbl.setBounds(540, 80, 390, 40);

        jPanel12.setBackground(new java.awt.Color(222, 222, 222));
        jPanel12.setLayout(null);

        jPanel11.setBackground(new java.awt.Color(255, 204, 102));
        jPanel11.setLayout(new java.awt.BorderLayout());
        jPanel11.add(profilepicforattendancepanel, java.awt.BorderLayout.PAGE_END);

        jPanel12.add(jPanel11);
        jPanel11.setBounds(10, 20, 140, 170);

        unamelblforattendance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unamelblforattendance.setText("User Name");
        jPanel12.add(unamelblforattendance);
        unamelblforattendance.setBounds(160, 30, 170, 30);

        desgnationlblforattendace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desgnationlblforattendace.setText("Designation");
        jPanel12.add(desgnationlblforattendace);
        desgnationlblforattendace.setBounds(160, 70, 170, 30);

        useridlblforattendancepanel.setBackground(new java.awt.Color(210, 210, 210));
        useridlblforattendancepanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        useridlblforattendancepanel.setText("User ID");
        jPanel12.add(useridlblforattendancepanel);
        useridlblforattendancepanel.setBounds(160, 150, 170, 30);

        deptnameforleavemanagementlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deptnameforleavemanagementlbl.setText("Department");
        jPanel12.add(deptnameforleavemanagementlbl);
        deptnameforleavemanagementlbl.setBounds(160, 110, 170, 30);

        leavemanagement.add(jPanel12);
        jPanel12.setBounds(210, 160, 330, 210);

        jPanel17.setBackground(new java.awt.Color(240, 240, 240));
        jPanel17.setLayout(null);
        leavemanagement.add(jPanel17);
        jPanel17.setBounds(10, 240, 130, 80);

        applyleavebtnforattendance.setBackground(new java.awt.Color(240, 240, 240));
        applyleavebtnforattendance.setText("Apply Leave");
        applyleavebtnforattendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyleavebtnforattendanceActionPerformed(evt);
            }
        });
        leavemanagement.add(applyleavebtnforattendance);
        applyleavebtnforattendance.setBounds(600, 370, 130, 23);

        cancelleavebtnforattendance.setBackground(new java.awt.Color(240, 240, 240));
        cancelleavebtnforattendance.setText("Cancel Leave");
        cancelleavebtnforattendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelleavebtnforattendanceActionPerformed(evt);
            }
        });
        leavemanagement.add(cancelleavebtnforattendance);
        cancelleavebtnforattendance.setBounds(780, 370, 130, 23);

        jLabel6.setBackground(new java.awt.Color(210, 210, 210));
        jLabel6.setText("Total Leave");
        leavemanagement.add(jLabel6);
        jLabel6.setBounds(650, 230, 130, 30);

        totalLeavelbl.setBackground(new java.awt.Color(210, 210, 210));
        totalLeavelbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLeavelbl.setText("Leave Days");
        leavemanagement.add(totalLeavelbl);
        totalLeavelbl.setBounds(790, 230, 70, 30);

        jLabel8.setText("Taken Leaves");
        leavemanagement.add(jLabel8);
        jLabel8.setBounds(650, 270, 130, 30);

        takenLeavelbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        takenLeavelbl.setText("N/N");
        leavemanagement.add(takenLeavelbl);
        takenLeavelbl.setBounds(790, 270, 70, 30);

        jLabel9.setText("Available Leaves");
        leavemanagement.add(jLabel9);
        jLabel9.setBounds(650, 310, 130, 30);

        availableLeavelbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        availableLeavelbl.setText("N/N");
        leavemanagement.add(availableLeavelbl);
        availableLeavelbl.setBounds(790, 310, 70, 30);

        avgintimelbl.setText("Average In-Time");
        leavemanagement.add(avgintimelbl);
        avgintimelbl.setBounds(650, 150, 130, 30);

        intime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        intime.setText("9.45 AM");
        leavemanagement.add(intime);
        intime.setBounds(810, 150, 50, 30);

        outtime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        outtime.setText("5.45 PM");
        leavemanagement.add(outtime);
        outtime.setBounds(810, 190, 50, 30);

        avgouttimelbl.setText("Average Out Time");
        leavemanagement.add(avgouttimelbl);
        avgouttimelbl.setBounds(650, 190, 130, 30);

        parentPanel.add(leavemanagement, "card4");

        academicInfo.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(null);

        academicInfolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        academicInfolbl.setText("Academic Information");
        jPanel4.add(academicInfolbl);
        academicInfolbl.setBounds(0, 30, 250, 60);

        schoolingInfolbl.setForeground(new java.awt.Color(102, 102, 255));
        schoolingInfolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolingInfolbl.setText("Schooling Information");
        schoolingInfolbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        schoolingInfolbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                schoolingInfolblMouseClicked(evt);
            }
        });
        jPanel4.add(schoolingInfolbl);
        schoolingInfolbl.setBounds(0, 90, 250, 40);

        collegeInfolbl.setForeground(new java.awt.Color(102, 102, 255));
        collegeInfolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collegeInfolbl.setText("College Info");
        collegeInfolbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        collegeInfolbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                collegeInfolblMouseClicked(evt);
            }
        });
        jPanel4.add(collegeInfolbl);
        collegeInfolbl.setBounds(0, 130, 250, 40);

        academicInfo.add(jPanel4);
        jPanel4.setBounds(0, 0, 250, 650);

        parentpanel.setBackground(new java.awt.Color(212, 212, 212));
        parentpanel.setLayout(new java.awt.CardLayout());

        defaultPanel.setLayout(new java.awt.BorderLayout());

        lblfordefaultpanelacademic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfordefaultpanelacademic.setText("Please Select What you need ?");
        defaultPanel.add(lblfordefaultpanelacademic, java.awt.BorderLayout.CENTER);

        parentpanel.add(defaultPanel, "card4");

        schoolingInfoPanel.setLayout(null);

        schoolingInfolblforparentPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolingInfolblforparentPanel.setText("Schooling Information");
        schoolingInfoPanel.add(schoolingInfolblforparentPanel);
        schoolingInfolblforparentPanel.setBounds(0, 20, 1080, 25);

        sslclbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sslclbl.setText("SSLC");
        schoolingInfoPanel.add(sslclbl);
        sslclbl.setBounds(120, 110, 100, 25);

        schoollbl10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        schoollbl10.setText("School");
        schoolingInfoPanel.add(schoollbl10);
        schoollbl10.setBounds(190, 150, 100, 25);

        boardlbl10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boardlbl10.setText("Board of Study");
        schoolingInfoPanel.add(boardlbl10);
        boardlbl10.setBounds(190, 180, 100, 25);

        scorelbl10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scorelbl10.setText("Score");
        schoolingInfoPanel.add(scorelbl10);
        scorelbl10.setBounds(190, 210, 100, 25);

        hsclbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hsclbl.setText("HSC");
        schoolingInfoPanel.add(hsclbl);
        hsclbl.setBounds(120, 270, 100, 25);

        schoollbl12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        schoollbl12.setText("School");
        schoolingInfoPanel.add(schoollbl12);
        schoollbl12.setBounds(190, 310, 100, 25);

        boardlbl12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boardlbl12.setText("Board of Study");
        schoolingInfoPanel.add(boardlbl12);
        boardlbl12.setBounds(190, 350, 100, 25);

        scorelbl12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scorelbl12.setText("Score");
        schoolingInfoPanel.add(scorelbl12);
        scorelbl12.setBounds(190, 390, 100, 25);

        school10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        school10.setText("School Name");
        schoolingInfoPanel.add(school10);
        school10.setBounds(370, 150, 440, 25);

        board10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        board10.setText("Board of Study");
        schoolingInfoPanel.add(board10);
        board10.setBounds(370, 180, 440, 25);

        score10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        score10.setText("Score");
        schoolingInfoPanel.add(score10);
        score10.setBounds(370, 210, 100, 25);

        school12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        school12.setText("School Name");
        schoolingInfoPanel.add(school12);
        school12.setBounds(370, 310, 440, 25);

        board12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        board12.setText("Board of Study");
        schoolingInfoPanel.add(board12);
        board12.setBounds(370, 350, 440, 25);

        score12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        score12.setText("Score");
        schoolingInfoPanel.add(score12);
        score12.setBounds(370, 390, 100, 25);
        schoolingInfoPanel.add(profilepicforsclinfo);
        profilepicforsclinfo.setBounds(760, 110, 160, 200);

        parentpanel.add(schoolingInfoPanel, "card2");

        collegeInfoPanel.setLayout(null);

        collegeInfolblforParentPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collegeInfolblforParentPanel.setText("College Information");
        collegeInfoPanel.add(collegeInfolblforParentPanel);
        collegeInfolblforParentPanel.setBounds(0, 20, 1080, 25);

        uglbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uglbl.setText("UG");
        collegeInfoPanel.add(uglbl);
        uglbl.setBounds(120, 110, 100, 25);

        clgnamelbl1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        clgnamelbl1.setText("College Name");
        collegeInfoPanel.add(clgnamelbl1);
        clgnamelbl1.setBounds(190, 240, 110, 25);

        universitynamelbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        universitynamelbl.setText("University Name");
        collegeInfoPanel.add(universitynamelbl);
        universitynamelbl.setBounds(190, 270, 110, 25);

        aggregatelbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aggregatelbl.setText("Aggregate");
        collegeInfoPanel.add(aggregatelbl);
        aggregatelbl.setBounds(190, 300, 110, 25);

        clgnameforug1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        clgnameforug1.setText("CollegeName");
        collegeInfoPanel.add(clgnameforug1);
        clgnameforug1.setBounds(330, 240, 510, 25);

        universitynameforug1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        universitynameforug1.setText("University Name");
        collegeInfoPanel.add(universitynameforug1);
        universitynameforug1.setBounds(330, 270, 510, 25);

        aggregateforug1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aggregateforug1.setText("Aggregate");
        collegeInfoPanel.add(aggregateforug1);
        aggregateforug1.setBounds(330, 300, 510, 25);

        deglbl.setText("Degree");
        collegeInfoPanel.add(deglbl);
        deglbl.setBounds(190, 150, 110, 25);

        degree.setText("Degree");
        collegeInfoPanel.add(degree);
        degree.setBounds(330, 150, 360, 25);

        yoplbl.setText("Year of Passing");
        collegeInfoPanel.add(yoplbl);
        yoplbl.setBounds(190, 210, 130, 25);

        yopforug1.setText("Year");
        collegeInfoPanel.add(yopforug1);
        yopforug1.setBounds(330, 210, 300, 25);

        majorforug1.setText("Major");
        collegeInfoPanel.add(majorforug1);
        majorforug1.setBounds(330, 180, 390, 25);

        majorlbl1.setText("Major");
        collegeInfoPanel.add(majorlbl1);
        majorlbl1.setBounds(190, 180, 110, 25);
        collegeInfoPanel.add(profilepicforclginfo);
        profilepicforclginfo.setBounds(760, 110, 160, 200);

        parentpanel.add(collegeInfoPanel, "card3");

        academicInfo.add(parentpanel);
        parentpanel.setBounds(250, 0, 1080, 650);

        parentPanel.add(academicInfo, "card7");

        SchedulePanel.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setLayout(null);

        schedulelblforSchedulePanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schedulelblforSchedulePanel.setText("Schedule");
        jPanel6.add(schedulelblforSchedulePanel);
        schedulelblforSchedulePanel.setBounds(0, 40, 250, 30);

        SchedulelblforStaff.setForeground(new java.awt.Color(102, 102, 255));
        SchedulelblforStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SchedulelblforStaff.setText("Staff");
        SchedulelblforStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SchedulelblforStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SchedulelblforStaffMouseClicked(evt);
            }
        });
        jPanel6.add(SchedulelblforStaff);
        SchedulelblforStaff.setBounds(0, 90, 250, 40);

        SchedulelblforClass.setForeground(new java.awt.Color(102, 102, 255));
        SchedulelblforClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SchedulelblforClass.setText("Class");
        SchedulelblforClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SchedulelblforClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SchedulelblforClassMouseClicked(evt);
            }
        });
        jPanel6.add(SchedulelblforClass);
        SchedulelblforClass.setBounds(0, 130, 250, 40);

        SchedulePanel.add(jPanel6);
        jPanel6.setBounds(0, 0, 250, 650);

        ParentPanelforTimeTable.setLayout(new java.awt.CardLayout());

        defaultpanelforTimeTable.setLayout(new java.awt.BorderLayout());

        defualtlblforTimeTablePanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defualtlblforTimeTablePanel.setText("Please Select What you need ?");
        defaultpanelforTimeTable.add(defualtlblforTimeTablePanel, java.awt.BorderLayout.CENTER);

        ParentPanelforTimeTable.add(defaultpanelforTimeTable, "card2");

        classSchedule.setLayout(null);

        clsschedulelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clsschedulelbl.setText("Class Schedule");
        classSchedule.add(clsschedulelbl);
        clsschedulelbl.setBounds(0, 20, 1060, 30);

        IIIctlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IIIctlbl.setText("III-Computer Technology");
        classSchedule.add(IIIctlbl);
        IIIctlbl.setBounds(0, 50, 1060, 30);

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Monday", "subject", "subject", "subject", "subject", "subject"},
                {"Tuesday", "subject", "subject", "subject", "subject", "subject"},
                {"Wednesday", "subject", "subject", "subject", "subject", "subject"},
                {"Thursday", "subject", "subject", "subject", "subject", "subject"},
                {"Friday", "subject", "subject", "subject", "subject", "subject"}
            },
            new String [] {
                "Day/Period", "1", "2", "3", "4", "5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(50);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setUpdateSelectionOnSort(false);
        jTable1.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        classSchedule.add(jScrollPane2);
        jScrollPane2.setBounds(170, 100, 700, 280);

        ParentPanelforTimeTable.add(classSchedule, "card6");

        stfSchedule.setLayout(null);

        academicinfolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        academicinfolbl.setText("Staff Schedule");
        stfSchedule.add(academicinfolbl);
        academicinfolbl.setBounds(0, 20, 1080, 30);

        stfschedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Monday", "2-CT LAB", "2-CT LAB", "1-CT", "1-B.Com", "2-CT LAB"},
                {"Tuesday", "2-CT LAB", "2-CT LAB", "2-CT LAB", "2-CT LAB", "2-CT LAB"},
                {"Wednesday", "2-CT LAB", "2-CT LAB", "2-CT LAB", "2-CT LAB", "2-CT LAB"},
                {"Thursday", "2-CT LAB", "2-CT LAB", "2-CT LAB", "2-CT LAB", "2-CT LAB"},
                {"Friday", "2-CT LAB", "2-CT LAB", "2-CT LAB", "2-CT LAB", "2-CT LAB"}
            },
            new String [] {
                "Day/Hours", "1", "2", "3", "4", "5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stfschedule.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        stfschedule.setMinimumSize(new java.awt.Dimension(90, 250));
        stfschedule.setRowHeight(50);
        stfschedule.setRowSelectionAllowed(false);
        stfschedule.setShowGrid(true);
        stfschedule.getTableHeader().setResizingAllowed(false);
        stfschedule.getTableHeader().setReorderingAllowed(false);
        stfschedule.setUpdateSelectionOnSort(false);
        stfschedule.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(stfschedule);
        if (stfschedule.getColumnModel().getColumnCount() > 0) {
            stfschedule.getColumnModel().getColumn(0).setResizable(false);
            stfschedule.getColumnModel().getColumn(1).setResizable(false);
            stfschedule.getColumnModel().getColumn(2).setResizable(false);
            stfschedule.getColumnModel().getColumn(3).setResizable(false);
            stfschedule.getColumnModel().getColumn(4).setResizable(false);
            stfschedule.getColumnModel().getColumn(5).setResizable(false);
        }

        stfSchedule.add(jScrollPane1);
        jScrollPane1.setBounds(170, 100, 700, 280);

        ParentPanelforTimeTable.add(stfSchedule, "card5");

        SchedulePanel.add(ParentPanelforTimeTable);
        ParentPanelforTimeTable.setBounds(250, 0, 1100, 650);

        parentPanel.add(SchedulePanel, "card8");

        attendance_Management.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        attendancelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        attendancelbl.setText("Attendance Management");
        jPanel3.add(attendancelbl);
        attendancelbl.setBounds(0, 30, 250, 30);

        IIIctlblforAttendance.setForeground(new java.awt.Color(82, 155, 255));
        IIIctlblforAttendance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IIIctlblforAttendance.setText("III-CT");
        IIIctlblforAttendance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IIIctlblforAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IIIctlblforAttendanceMouseClicked(evt);
            }
        });
        jPanel3.add(IIIctlblforAttendance);
        IIIctlblforAttendance.setBounds(0, 80, 250, 30);

        IICT_lbl.setForeground(new java.awt.Color(82, 155, 255));
        IICT_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IICT_lbl.setText("II-CT");
        IICT_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IICT_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IICT_lblMouseClicked(evt);
            }
        });
        jPanel3.add(IICT_lbl);
        IICT_lbl.setBounds(0, 110, 250, 30);

        attendance_Management.add(jPanel3);
        jPanel3.setBounds(0, 0, 250, 650);

        jPanel5.setLayout(new java.awt.CardLayout());

        jPanel7.setLayout(new java.awt.BorderLayout());

        defaultlblforAttenadancemanagement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defaultlblforAttenadancemanagement.setText("Please Select What You Need?");
        jPanel7.add(defaultlblforAttenadancemanagement, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel7, "card3");

        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(212, 212, 212));
        jPanel9.setLayout(new java.awt.BorderLayout());
        jPanel8.add(jPanel9);
        jPanel9.setBounds(100, 170, 910, 390);

        III_ct_attendance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        III_ct_attendance.setText("III-CT Attendance");
        jPanel8.add(III_ct_attendance);
        III_ct_attendance.setBounds(0, 30, 1100, 30);

        clsinchargenamelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clsinchargenamelbl.setText("Class Incharge ");
        jPanel8.add(clsinchargenamelbl);
        clsinchargenamelbl.setBounds(0, 60, 1100, 30);

        submitbtnforAttendance.setBackground(new java.awt.Color(82, 155, 255));
        submitbtnforAttendance.setText("Submit");
        jPanel8.add(submitbtnforAttendance);
        submitbtnforAttendance.setBounds(880, 580, 130, 30);

        facultynamelbl.setText("Faculty Name:");
        jPanel8.add(facultynamelbl);
        facultynamelbl.setBounds(100, 120, 110, 25);

        facultyname.setText("Staff Name");
        jPanel8.add(facultyname);
        facultyname.setBounds(190, 120, 140, 25);

        facultyIDlbl.setText("Faculty ID: ");
        jPanel8.add(facultyIDlbl);
        facultyIDlbl.setBounds(290, 120, 70, 25);

        facultyID.setText("Staff ID");
        jPanel8.add(facultyID);
        facultyID.setBounds(360, 120, 120, 25);

        paperhandlelbl.setText("Paper of Handling:");
        jPanel8.add(paperhandlelbl);
        paperhandlelbl.setBounds(460, 120, 140, 25);

        jPanel8.add(paperCB);
        paperCB.setBounds(600, 120, 160, 25);

        hourlbl.setText("Hour");
        jPanel8.add(hourlbl);
        hourlbl.setBounds(790, 120, 40, 25);

        jPanel8.add(hourCB);
        hourCB.setBounds(840, 120, 170, 25);

        jPanel5.add(jPanel8, "card3");

        jPanel10.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(212, 212, 212));
        jPanel13.setLayout(new java.awt.BorderLayout());
        jPanel10.add(jPanel13);
        jPanel13.setBounds(100, 160, 910, 390);

        II_ct_attendance1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        II_ct_attendance1.setText("II-CT Attendance");
        jPanel10.add(II_ct_attendance1);
        II_ct_attendance1.setBounds(0, 30, 1100, 30);

        clsinchargenamelblICT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clsinchargenamelblICT.setText("Class Incharge ");
        jPanel10.add(clsinchargenamelblICT);
        clsinchargenamelblICT.setBounds(0, 60, 1100, 30);

        submitbtnforAttendance1.setBackground(new java.awt.Color(82, 155, 255));
        submitbtnforAttendance1.setText("Submit");
        jPanel10.add(submitbtnforAttendance1);
        submitbtnforAttendance1.setBounds(880, 580, 130, 30);

        facultynamelblICT.setText("Faculty Name:");
        jPanel10.add(facultynamelblICT);
        facultynamelblICT.setBounds(100, 120, 120, 25);

        facultynameIICT.setText("Staff Name");
        jPanel10.add(facultynameIICT);
        facultynameIICT.setBounds(190, 120, 140, 25);

        facultyIDlblIICT.setText("Faculty ID: ");
        jPanel10.add(facultyIDlblIICT);
        facultyIDlblIICT.setBounds(290, 120, 70, 25);

        facultyIICT.setText("Staff ID");
        jPanel10.add(facultyIICT);
        facultyIICT.setBounds(360, 120, 120, 25);

        paperhandlelblIICT.setText("Paper of Handling:");
        jPanel10.add(paperhandlelblIICT);
        paperhandlelblIICT.setBounds(460, 120, 140, 25);

        jPanel10.add(paperCBIICT);
        paperCBIICT.setBounds(600, 120, 160, 25);

        hourlblIICT.setText("Hour");
        jPanel10.add(hourlblIICT);
        hourlblIICT.setBounds(790, 120, 40, 25);

        jPanel10.add(hourCBIICT);
        hourCBIICT.setBounds(840, 120, 170, 25);

        jPanel5.add(jPanel10, "card4");

        attendance_Management.add(jPanel5);
        jPanel5.setBounds(250, 0, 1100, 650);

        parentPanel.add(attendance_Management, "card7");

        jPanel2.add(parentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 144, 1327, 655));

        mainpanel.setViewportView(jPanel2);

        getContentPane().add(mainpanel, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1550, 871);
    }// </editor-fold>//GEN-END:initComponents

    private void editlogoimg1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editlogoimg1MouseClicked
        // TODO add your handling code here:
        String newAdd = "";
        newAdd = JOptionPane.showInputDialog(parentPanel, "Enter a New Address here ", "Type here");
        if (!(newAdd).equals("")) {
            int res = JOptionPane.showConfirmDialog(parentPanel, "Are You sure want to make this Modification ?", "EASCPRO", 2);
            if (res == 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                    String q = "update staffdetails set staffaddress= ? where staffid=?";
                    PreparedStatement ps1 = con.prepareStatement(q);
                    ps1.setString(1, newAdd);
                    ps1.setString(2, stfUID);
                    ps1.executeUpdate();
                    JOptionPane.showMessageDialog(parentPanel, "Your Address Modification process is Completed..!", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    addresslblforprofile.setText(newAdd);
                }//try Block ends here...!
                catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(staffDashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }//catch clause end here..!  
            }//Inner IF ends here..!
        }//Outer If ends here..!
    }//GEN-LAST:event_editlogoimg1MouseClicked

    private void editlogoimg2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editlogoimg2MouseClicked
        // TODO add your handling code here:
        String newMail = JOptionPane.showInputDialog(parentPanel, "Enter a New Mail Address here ", "Type here");
        if (!(newMail).equals("")) {
            int res = JOptionPane.showConfirmDialog(parentPanel, "Are You sure want to make this Modification ?", "EASCPRO", 2);
            if (res == 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                    String q = "update staffdetails set staffMail= ? where staffid=?";
                    PreparedStatement ps1 = con.prepareStatement(q);
                    ps1.setString(1, newMail);
                    ps1.setString(2, stfUID);
                    ps1.executeUpdate();
                    JOptionPane.showMessageDialog(parentPanel, "Your  Address Modification process is Completed..!", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    mailidTFforprofile.setText(newMail);
                }//try Block ends here...!
                catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(staffDashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }//catch clause end here..!
            }//Inner If ends here..!
        } //Outer If ends here..!
    }//GEN-LAST:event_editlogoimg2MouseClicked

    private void editlogoimg3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editlogoimg3MouseClicked
        // TODO add your handling code here:
        String newMob = JOptionPane.showInputDialog(parentPanel, "Enter a New Mobile Number here ", "Type here");
        if (!(newMob).equals("")) {
            int res = JOptionPane.showConfirmDialog(parentPanel, "Are You sure want to make this Modification ?", "EASCPRO", 2);
            if (res == 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                    String q = "update staffdetails set staffmob= ? where staffid=?";
                    PreparedStatement ps1 = con.prepareStatement(q);
                    ps1.setString(1, newMob);
                    ps1.setString(2, stfUID);
                    ps1.executeUpdate();
                    JOptionPane.showMessageDialog(parentPanel, "Your  Mobile Modification process is Completed..!", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    mobTFforprofile.setText(newMob);
                }//try Block ends here...!
                catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(staffDashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }//catch clause end here..!
            }//Inner If ends here..!
        } //Outer If ends here..! 
    }//GEN-LAST:event_editlogoimg3MouseClicked

    private void applyleavebtnforattendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyleavebtnforattendanceActionPerformed
        // TODO add your handling code here:
        leaveManagement();
    }//GEN-LAST:event_applyleavebtnforattendanceActionPerformed

    private void cancelleavebtnforattendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelleavebtnforattendanceActionPerformed
        // TODO add your handling code here:
        leaveManagement();
    }//GEN-LAST:event_cancelleavebtnforattendanceActionPerformed

    private void logoutlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlblMouseClicked
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(parentPanel, "Are you sure want to Logout ?", "EASCPRO", 2);
        if (res == 0) {
            this.dispose();
            new LoginFrame().setVisible(true);
        }
    }//GEN-LAST:event_logoutlblMouseClicked

    private void schoolingInfolblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schoolingInfolblMouseClicked
        // TODO add your handling code here:
        schoolingInfo();
    }//GEN-LAST:event_schoolingInfolblMouseClicked

    private void collegeInfolblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_collegeInfolblMouseClicked
        // TODO add your handling code here:
        collegeInfo();
    }//GEN-LAST:event_collegeInfolblMouseClicked

    private void profilelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilelblMouseClicked
        // TODO add your handling code here:
        personal_info();
    }//GEN-LAST:event_profilelblMouseClicked

    private void leavelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leavelblMouseClicked
        // TODO add your handling code here:
        leaveManagement();
    }//GEN-LAST:event_leavelblMouseClicked

    private void schedulelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedulelblMouseClicked
        // TODO add your handling code here:
        Schedule();
    }//GEN-LAST:event_schedulelblMouseClicked

    private void SchedulelblforStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedulelblforStaffMouseClicked
        // TODO add your handling code here:
        stfScheduleGenerate();
    }//GEN-LAST:event_SchedulelblforStaffMouseClicked

    private void SchedulelblforClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SchedulelblforClassMouseClicked
        // TODO add your handling code here:
        classScheduleGenerate();
    }//GEN-LAST:event_SchedulelblforClassMouseClicked

    private void IIIctlblforAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IIIctlblforAttendanceMouseClicked
        // TODO add your handling code here:
        jPanel5.removeAll();
        jPanel5.add(jPanel8);
        jPanel5.repaint();
        jPanel5.revalidate();
        String yoj = "2021";
        attendancemanagement(yoj, jPanel9);
    }//GEN-LAST:event_IIIctlblforAttendanceMouseClicked

    private void attendancelblformenupanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendancelblformenupanelMouseClicked
        // TODO add your handling code here:
        parentPanel.removeAll();
        parentPanel.add(attendance_Management);
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_attendancelblformenupanelMouseClicked

    private void IICT_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IICT_lblMouseClicked
        // TODO add your handling code here:
        jPanel5.removeAll();
        jPanel5.add(jPanel10);
        jPanel5.repaint();
        jPanel5.revalidate();
        String yoj = "2022";
        attendancemanagement(yoj, jPanel13);
    }//GEN-LAST:event_IICT_lblMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IICT_lbl;
    private javax.swing.JLabel III_ct_attendance;
    private javax.swing.JLabel IIIctlbl;
    private javax.swing.JLabel IIIctlblforAttendance;
    private javax.swing.JLabel II_ct_attendance1;
    private javax.swing.JPanel ParentPanelforTimeTable;
    private javax.swing.JPanel SchedulePanel;
    private javax.swing.JLabel SchedulelblforClass;
    private javax.swing.JLabel SchedulelblforStaff;
    private javax.swing.JLabel UIDlblforprofile;
    private javax.swing.JPanel academicInfo;
    private javax.swing.JLabel academicInfolbl;
    private javax.swing.JLabel academicinfolbl;
    private javax.swing.JLabel addlblforprofile;
    private javax.swing.JTextArea addresslblforprofile;
    private javax.swing.JLabel aggregateforug1;
    private javax.swing.JLabel aggregatelbl;
    private javax.swing.JButton applyleavebtnforattendance;
    private javax.swing.JPanel attendance_Management;
    private javax.swing.JLabel attendancelbl;
    private javax.swing.JLabel attendancelblformenupanel;
    private javax.swing.JLabel availableLeavelbl;
    private javax.swing.JLabel avgintimelbl;
    private javax.swing.JLabel avgouttimelbl;
    private javax.swing.JPanel bgpanel;
    private javax.swing.JLabel board10;
    private javax.swing.JLabel board12;
    private javax.swing.JLabel boardlbl10;
    private javax.swing.JLabel boardlbl12;
    private javax.swing.JButton cancelleavebtnforattendance;
    private javax.swing.JPanel classSchedule;
    private javax.swing.JLabel clglbl;
    private javax.swing.JLabel clglbl2;
    private javax.swing.JLabel clglbl3;
    private javax.swing.JLabel clglbl4;
    public javax.swing.JLabel clglogo1;
    private javax.swing.JLabel clgnameforug1;
    private javax.swing.JLabel clgnamelbl1;
    private javax.swing.JLabel clsinchargenamelbl;
    private javax.swing.JLabel clsinchargenamelblICT;
    private javax.swing.JLabel clsschedulelbl;
    private javax.swing.JPanel collegeInfoPanel;
    private javax.swing.JLabel collegeInfolbl;
    private javax.swing.JLabel collegeInfolblforParentPanel;
    private javax.swing.JLabel collegelbl;
    private javax.swing.JPanel defaultPanel;
    private javax.swing.JLabel defaultlblforAttenadancemanagement;
    private javax.swing.JPanel defaultpanelforTimeTable;
    private javax.swing.JLabel defualtlblforTimeTablePanel;
    private javax.swing.JLabel deglbl;
    private javax.swing.JLabel degree;
    private javax.swing.JLabel deptlabelforprofile;
    private javax.swing.JLabel deptlbl;
    private javax.swing.JLabel deptnameforleavemanagementlbl;
    private javax.swing.JLabel desgnationlblforattendace;
    private javax.swing.JLabel designationforprofile;
    private javax.swing.JLabel designationlblforprofile;
    private javax.swing.JLabel editlogoimg1;
    private javax.swing.JLabel editlogoimg2;
    private javax.swing.JLabel editlogoimg3;
    private javax.swing.JLabel emailidlblforprofile;
    private javax.swing.JLabel facultyID;
    private javax.swing.JLabel facultyIDlbl;
    private javax.swing.JLabel facultyIDlblIICT;
    private javax.swing.JLabel facultyIICT;
    private javax.swing.JLabel facultyname;
    private javax.swing.JLabel facultynameIICT;
    private javax.swing.JLabel facultynamelbl;
    private javax.swing.JLabel facultynamelblICT;
    private javax.swing.JComboBox<String> hourCB;
    private javax.swing.JComboBox<String> hourCBIICT;
    private javax.swing.JLabel hourlbl;
    private javax.swing.JLabel hourlblIICT;
    private javax.swing.JLabel hsclbl;
    private javax.swing.JLabel imglbl;
    private javax.swing.JLabel intime;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl1forprofile;
    private javax.swing.JLabel lbl2forprofile;
    private javax.swing.JLabel lbl3forprofile;
    private javax.swing.JLabel lblfordefaultpanelacademic;
    private javax.swing.JLabel leavelbl;
    private javax.swing.JPanel leavemanagement;
    private javax.swing.JLabel leavemanagementlbl;
    private javax.swing.JLabel loggedlbl;
    private javax.swing.JLabel logoutlbl;
    private javax.swing.JTextField mailidTFforprofile;
    private javax.swing.JScrollPane mainpanel;
    private javax.swing.JLabel majorforug1;
    private javax.swing.JLabel majorlbl1;
    private javax.swing.JPanel menupanel;
    private javax.swing.JTextField mobTFforprofile;
    private javax.swing.JLabel mobilelblforprofile;
    private javax.swing.JLabel outtime;
    private javax.swing.JComboBox<String> paperCB;
    private javax.swing.JComboBox<String> paperCBIICT;
    private javax.swing.JLabel paperhandlelbl;
    private javax.swing.JLabel paperhandlelblIICT;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel parentpanel;
    private javax.swing.JLabel parentpanelbgimg;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel profileinolbl;
    private javax.swing.JLabel profilelbl;
    private javax.swing.JLabel profilepicforattendancepanel;
    private javax.swing.JLabel profilepicforclginfo;
    private javax.swing.JLabel profilepicforsclinfo;
    private javax.swing.JLabel schedulelbl;
    private javax.swing.JLabel schedulelblforSchedulePanel;
    private javax.swing.JLabel school10;
    private javax.swing.JLabel school12;
    private javax.swing.JPanel schoolingInfoPanel;
    private javax.swing.JLabel schoolingInfolbl;
    private javax.swing.JLabel schoolingInfolblforparentPanel;
    private javax.swing.JLabel schoollbl10;
    private javax.swing.JLabel schoollbl12;
    private javax.swing.JLabel score10;
    private javax.swing.JLabel score12;
    private javax.swing.JLabel scorelbl10;
    private javax.swing.JLabel scorelbl12;
    private javax.swing.JLabel sslclbl;
    private javax.swing.JPanel stfSchedule;
    private javax.swing.JLabel stfdashboardlbl;
    private javax.swing.JTable stfschedule;
    private javax.swing.JButton submitbtnforAttendance;
    private javax.swing.JButton submitbtnforAttendance1;
    private javax.swing.JLabel takenLeavelbl;
    private javax.swing.JLabel totalLeavelbl;
    private javax.swing.JLabel uglbl;
    private javax.swing.JLabel unamelblforattendance;
    private javax.swing.JLabel unamelblforprofile;
    private javax.swing.JLabel universitynameforug1;
    private javax.swing.JLabel universitynamelbl;
    private javax.swing.JLabel useridlbl;
    private javax.swing.JLabel useridlblforattendancepanel;
    private javax.swing.JLabel usernamelbl;
    private javax.swing.JPanel welcomepanel;
    private javax.swing.JLabel yojforprofile;
    private javax.swing.JLabel yojlblforprofile;
    private javax.swing.JLabel yopforug1;
    private javax.swing.JLabel yoplbl;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]) {
        new staffDashBoard();
    }
}

//Rounded Border Class and methods...!
//class RoundedBorder implements Border {
//    private final int radius;
//
//    RoundedBorder(int radius) {
//        this.radius = radius;
//    }
//
//    @Override
//    public Insets getBorderInsets(Component c) {
//        return new Insets(radius + 1, radius + 1, radius + 2, radius);
//    }
//
//    @Override
//    public boolean isBorderOpaque() {
//        return true;
//    }
//
//    @Override
//    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//        g.setColor(Color.GRAY);
//        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
//    }
//}Give me the proper alignment in this java Program

