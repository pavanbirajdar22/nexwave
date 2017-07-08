// Source File Name:   StatusNow.java 05-Sep-2006

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

class StatusNow
{

    public StatusNow()
    {
        snv = new StationNameVector();
        cjdbc = new CallableJDBC();
        hk = new HouseKeeping();
    }

    JPanel getStatusNow()
    {
        dim1 = new Dimension(90, 25);
        qtm = new QueryTable();
        table = new JTable(qtm);
		table.setFocusable(false);
		
        byte byte0 = 20;
        byte byte1 = 30;
        JScrollPane jscrollpane = new JScrollPane(table, byte0, byte1);
		jscrollpane.setFocusable(false);
 /*     JButton jbutton = new JButton("Present Position");
        jbutton.setFont(new Font("SansSerif", 1, 24));
        jbutton.setBackground(Color.pink);
        jbutton.setForeground(Color.red);
   */   jbTableTitle = new JButton("Table");
        jbTableTitle.setBackground(Color.green);
        jbTableTitle.setForeground(Color.blue);
        jbTableSize = new JButton("No of Crew");
        jbTableSize.setBackground(Color.green);
        jbTableSize.setForeground(Color.blue);
        JButton jbutton1 = new JButton("LocoPilot");
        jbutton1.setBackground(Color.green);
        jbutton1.setForeground(Color.blue);
        jbutton1.setPreferredSize(dim1);
        JButton jbutton2 = new JButton("Booked");
        jbutton2.setBackground(new Color(255, 255, 83));
        jbutton2.setForeground(new Color(0, 0, 255));
        jbutton2.setPreferredSize(dim1);
        JButton jbutton3 = new JButton("Available");
        jbutton3.setBackground(new Color(255, 255, 83));
        jbutton3.setForeground(new Color(0, 0, 255));
        jbutton3.setPreferredSize(dim1);
        JButton jbutton4 = new JButton("On Line");
        jbutton4.setBackground(new Color(255, 255, 83));
        jbutton4.setForeground(new Color(0, 0, 255));
        jbutton4.setPreferredSize(dim1);
        JButton jbutton5 = new JButton("Rest");
        jbutton5.setBackground(new Color(255, 255, 83));
        jbutton5.setForeground(new Color(0, 0, 255));
        jbutton5.setPreferredSize(dim1);
        JButton jbutton6 = new JButton("Casualty");
        jbutton6.setBackground(new Color(255, 255, 83));
        jbutton6.setForeground(new Color(0, 0, 255));
        jbutton6.setPreferredSize(dim1);
        JButton jbutton7 = new JButton("PR");
        jbutton7.setBackground(new Color(255, 255, 83));
        jbutton7.setForeground(new Color(0, 0, 255));
        jbutton7.setPreferredSize(dim1);
        JButton jbutton8 = new JButton("Leave");
        jbutton8.setBackground(new Color(255, 255, 83));
        jbutton8.setForeground(new Color(0, 0, 255));
        jbutton8.setPreferredSize(dim1);
        JButton jbutton9 = new JButton("Assistant");
        jbutton9.setBackground(Color.green);
        jbutton9.setForeground(Color.blue);
        jbutton9.setPreferredSize(dim1);
        JButton jbutton10 = new JButton("Booked");
        jbutton10.setBackground(new Color(255, 255, 83));
        jbutton10.setForeground(new Color(0, 0, 255));
        jbutton10.setPreferredSize(dim1);
        JButton jbutton11 = new JButton("Available");
        jbutton11.setBackground(new Color(255, 255, 83));
        jbutton11.setForeground(new Color(0, 0, 255));
        jbutton11.setPreferredSize(dim1);
        JButton jbutton12 = new JButton("Rest");
        jbutton12.setBackground(new Color(255, 255, 83));
        jbutton12.setForeground(new Color(0, 0, 255));
        jbutton12.setPreferredSize(dim1);
        JButton jbutton13 = new JButton("On Line");
        jbutton13.setBackground(new Color(255, 255, 83));
        jbutton13.setForeground(new Color(0, 0, 255));
        jbutton13.setPreferredSize(dim1);
        JButton jbutton14 = new JButton("Casualty");
        jbutton14.setBackground(new Color(255, 255, 83));
        jbutton14.setForeground(new Color(0, 0, 255));
        jbutton14.setPreferredSize(dim1);
        JButton jbutton15 = new JButton("Leave");
        jbutton15.setBackground(new Color(255, 255, 83));
        jbutton15.setForeground(new Color(0, 0, 255));
        jbutton15.setPreferredSize(dim1);
        JButton jbutton16 = new JButton("PR");
        jbutton16.setBackground(new Color(255, 255, 83));
        jbutton16.setForeground(new Color(0, 0, 255));
        jbutton16.setPreferredSize(dim1);
        JButton jbutton17 = new JButton("Guard");
        jbutton17.setBackground(Color.green);
        jbutton17.setForeground(Color.blue);
        jbutton17.setPreferredSize(dim1);
        JButton jbutton18 = new JButton("Booked");
        jbutton18.setBackground(new Color(255, 255, 83));
        jbutton18.setForeground(new Color(0, 0, 255));
        jbutton18.setPreferredSize(dim1);
        JButton jbutton19 = new JButton("Available");
        jbutton19.setBackground(new Color(255, 255, 83));
        jbutton19.setForeground(new Color(0, 0, 255));
        jbutton19.setPreferredSize(dim1);
        JButton jbutton20 = new JButton("On Line");
        jbutton20.setBackground(new Color(255, 255, 83));
        jbutton20.setForeground(new Color(0, 0, 255));
        jbutton20.setPreferredSize(dim1);
        JButton jbutton21 = new JButton("Rest");
        jbutton21.setBackground(new Color(255, 255, 83));
        jbutton21.setForeground(new Color(0, 0, 255));
        jbutton21.setPreferredSize(dim1);
        JButton jbutton22 = new JButton("Casualty");
        jbutton22.setBackground(new Color(255, 255, 83));
        jbutton22.setForeground(new Color(0, 0, 255));
        jbutton22.setPreferredSize(dim1);
        JButton jbutton23 = new JButton("PR");
        jbutton23.setBackground(new Color(255, 255, 83));
        jbutton23.setForeground(new Color(0, 0, 255));
        jbutton23.setPreferredSize(dim1);
        JButton jbutton24 = new JButton("Leave");
        jbutton24.setBackground(new Color(255, 255, 83));
        jbutton24.setForeground(new Color(0, 0, 255));
        jbutton24.setPreferredSize(dim1);
        GridBagLayout gridbaglayout = new GridBagLayout();
        GridBagConstraints gridbagconstraints = new GridBagConstraints();
        panel1 = new JPanel();
        panel1.setLayout(gridbaglayout);
        gridbagconstraints.fill = 0;
        gridbagconstraints.anchor = 17;
        gridbagconstraints.gridwidth = 1;
        gridbaglayout.setConstraints(jbTableTitle, gridbagconstraints);
        panel1.add(jbTableTitle);
        gridbagconstraints.gridwidth = 0;
        gridbaglayout.setConstraints(jbTableSize, gridbagconstraints);
        panel1.add(jbTableSize);
        panelTable = new JPanel();
        panelTable.setBackground(new Color(0, 128, 128));
        jscrollpane.setPreferredSize(new Dimension(700, 375));
        panelTable.add(jscrollpane);
        gridbaglayout.setConstraints(panelTable, gridbagconstraints);
        panel1.add(panelTable);
        JPanel jpanel = new JPanel(new GridLayout(1, 5));
        jpanel.add(jbutton1);
        jpanel.add(jbutton2);
        jpanel.add(jbutton3);
        jpanel.add(jbutton5);
        jpanel.add(jbutton4);
        jpanel.add(jbutton6);
        jpanel.add(jbutton7);
        jpanel.add(jbutton8);
        gridbaglayout.setConstraints(jpanel, gridbagconstraints);
        panel1.add(jpanel);
        JPanel jpanel1 = new JPanel(new GridLayout(1, 5));
        jpanel1.add(jbutton9);
        jpanel1.add(jbutton10);
        jpanel1.add(jbutton11);
        jpanel1.add(jbutton12);
        jpanel1.add(jbutton13);
        jpanel1.add(jbutton14);
        jpanel1.add(jbutton16);
        jpanel1.add(jbutton15);
        gridbaglayout.setConstraints(jpanel1, gridbagconstraints);
        panel1.add(jpanel1);
        JPanel jpanel2 = new JPanel(new GridLayout(1, 5));
        jpanel2.add(jbutton17);
        jpanel2.add(jbutton18);
        jpanel2.add(jbutton19);
        jpanel2.add(jbutton21);
        jpanel2.add(jbutton20);
        jpanel2.add(jbutton22);
        jpanel2.add(jbutton23);
        jpanel2.add(jbutton24);
        gridbaglayout.setConstraints(jpanel2, gridbagconstraints);
        panel1.add(jpanel2);
        pt = new presentTime();
        jbutton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                qtm.setHostURL("");
                String s = "select a.slno, a.namedriver, to_char(a.departure,'mm/dd hh24:mi') OTLTime, "+
				"to_char(b.date1,'mm/dd hh24:mi') available, to_char(a.bookingtime,'mm/dd hh24:mi') booked, "+
				"b.hoursworked, d.pagerno WLL from bookingdriver a, curravaild b , crewdetails d where  a.pfnodriver = b.pfnodriver "+
				"and a.pfnodriver = d.pfnodriver and b.booked=1 and   a.bookingtime =  (select max(c.bookingtime)   from bookingdriver c where "+
				"c.availabletime = b.date1 and  b.pfnodriver = c.pfnodriver and b.booked=1)  order by a.departure ";
                qtm.setQuery(s);
                jbTableTitle.setText("Booked LocoPilots List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of LocoPilots Booked = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {  qtm.setHostURL("");
                cjdbc.executeProcedure("updatedata()");
                hk.startHouseKeeping();
                boolean flag = HouseKeeping.isFirstWeek;
    //            System.out.println("A First Week : " + flag);
                String s;
                if(flag)
                    s = "Order by to_char(date1,'yyyy/mm/dd hh24:mi'),HoursWorked,restfrom, namedriver";
                else
                    s = "Order by HoursWorked,to_char(date1,'yyyy/mm/dd hh24:mi'),restfrom, namedriver";
                query = "Select depot from depot";
                Vector vector = snv.getStationNameList("", query);
                depot = (String)vector.elementAt(0);
     //           System.out.println(query + " : " + depot);
                if(depot.equals("KZJ"))
                    query = "Select a.NameDriver,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,"+
					" to_char(a.date1,'mm/dd hh24:mi') Available,a.HoursWorked Hours,a.Mileage,"+
		//			" a.kzj_bpq BPQ, a.kzj_amq_snf SNF, a.kzj_bza BZA, a.electric AC, a.diesel DSL "+
					"replace(replace(a.kzj_bpq,1,'BPQ'),0,'-') ||replace(a.kzj_amq_snf,1,'SNF')||replace(replace(a.kzj_bza,1,'BZA'),0,'-')BZA,"+
					"replace(replace(a.electric,1,'AC'),0,'-')||replace(replace(a.diesel,0,'-'),1,'DSL') DSL ,b.pagerno TELNo"+
					" from Curravaild a,crewdetails b  where a.pfnodriver = b.pfnodriver and a.Booked =0 " + s;
                else
                    query = "Select a.NameDriver,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom, to_char(a.date1,'mm/dd hh24:mi') Available,a.HoursWorked Hours,a.Mileage,a.electric||'-'||a.diesel AC_DSL, "+
					"b.pagerno Telno  from Curravaild a, crewdetails b  where a.pfnodriver=b.pfnodriver and a.Booked =0 " + s;
        //        System.out.println(query);
                qtm.setHostURL("");
                qtm.setQuery(query);
                QueryTable _tmp = qtm;
                numbers = "Available LocoPilots = " + QueryTable.noOfRecord;
          //      System.out.println("D 1 : " + numbers);
                qtm.setHostURL("");
                if(depot.equals("KZJ"))
                {
                    qtm.setQuery("select count(namedriver) from curravaild where kzj_bpq = 1 and booked=0");
                    QueryTable _tmp1 = qtm;
                    numbers = numbers + " ,  BPQ = " + QueryTable.noOfRecord;
               //     System.out.println(numbers);
                    qtm.setHostURL("");
                    qtm.setQuery("select count(namedriver) from curravaild where kzj_bza = 1 and booked=0");
                    QueryTable _tmp2 = qtm;
                    numbers = numbers + " ,  BZA = " + QueryTable.noOfRecord;
               //     System.out.println(numbers);
                    qtm.setHostURL("");
                    qtm.setQuery("select count(namedriver) from curravaild where kzj_sc_snf = 1 and booked=0");
                    QueryTable _tmp3 = qtm;
                    numbers = numbers + " ,  SNF = " + QueryTable.noOfRecord;
               //     System.out.println(numbers);
                }
                jbTableTitle.setText("Available LocoPilots List");
                jbTableSize.setText(numbers);
                if(depot.equals("KZJ")){
                    query = "Select a.NameDriver,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,"+
					" to_char(a.date1,'mm/dd hh24:mi') Available,a.HoursWorked Hours,a.Mileage,"+
//					"replace(a.kzj_bpq BPQ, a.kzj_amq_snf SNF, a.kzj_bza BZA, a.electric AC, a.diesel DSL "+
//					" from Curravaild a where a.Booked =0 " + s;
  					"replace(replace(nvl(decode(sign(nvl(c.kzj_bpq,'01-jan-1999') - sysdate),-1,0),1),1,'BPQ'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(c.kzj_bpa,'01-jan-1999') - sysdate),-1,0),1),1,'BPA'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(c.kzj_bza,'01-jan-1999') - sysdate),-1,0),1),1,'BZA'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(c.kzj_dkj,'01-jan-1999') - sysdate),-1,0),1),1,'DKJ'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(c.kzj_amq_snf,'01-jan-1999') - sysdate),-1,0),1),1,'SNF'),0,'-') LR,"+
					"replace(replace(a.electric,1,'AC'),0,'-')||replace(replace(a.diesel,0,'-'),1,'DSL') DSL ,b.pagerno WLL "+
					" from Curravaild a,crewdetails b, lrd c  where a.pfnodriver = c.pfnodriver and a.pfnodriver = b.pfnodriver and a.Booked =0 " + s;
				}//		  System.out.println("272 :"+query); }
				else
                    query = "Select a.NameDriver,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom, to_char(a.date1,'mm/dd hh24:mi') Available,a.HoursWorked Hours,a.Mileage,a.electric||'-'||a.diesel AC_DSL, b.pagerno Telno  from Curravaild a, crewdetails b  where a.pfnodriver=b.pfnodriver and a.Booked =0 " + s;
             //   System.out.println("275:"+query);
                qtm.setHostURL("");
                qtm.setQuery(query);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {  qtm.setHostURL("");
                query = "Select depot from depot";
    //            System.out.println(query);
                Vector vector = snv.getStationNameList("", query);
                query = (String)vector.elementAt(0);
                if(query.equals("KZJ"))
                    qtm.setQuery("Select a.NameDriver,to_char(a.RestFrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.RestTo,'mm/dd hh24:mi') RestUpTo, a.HoursWorked Hours,a.Mileage, "+
					"replace(replace(c.electric,1,'AC'),0,'-')||replace(replace(c.diesel,1,'DSL'),0,'-') AC_DSL ,"+
					"replace(replace(nvl(decode(sign(nvl(b.kzj_bpq,'01-jan-1999') - sysdate),-1,0),1),1,'BPQ'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_bpa,'01-jan-1999') - sysdate),-1,0),1),1,'BPA'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_bza,'01-jan-1999') - sysdate),-1,0),1),1,'BZA'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_dkj,'01-jan-1999') - sysdate),-1,0),1),1,'DKJ'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_amq_snf,'01-jan-1999') - sysdate),-1,0),1),1,'SNF'),0,'-') LR,"+
					" c.pagerno WLL "+
					"from Currrestd a, lrd b , crewdetails c where a.pfnodriver = b.pfnodriver and a.pfnodriver = c.pfnodriver and a.namedriver = b.namedriver  order by to_char(RestTo,'yyyy/mm/dd hh24:mi')");
                else
                    qtm.setQuery("Select a.NameDriver,to_char(a.RestFrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.RestTo,'mm/dd hh24:mi') RestUpTo, a.HoursWorked Hours,a.Mileage, replace(replace(a.prissued,1,'PR'),0,'-')||'-'||replace(a.NOTFOUND,'NO','-') PR_NF, b.pagerno TelNo"+
					"  from Currrestd a, crewdetails b where a.pfnodriver=b.pfnodriver order by a.RestTo");
                jbTableTitle.setText("Drivers Under Rest List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of LocoPilots Under Rest = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                qtm.setQuery("Select Ctrno,NameDriver,to_char(date1,'mm/dd hh24:mi') SignOn,trainno, hoursworked from Curronlined order by date1");
                jbTableTitle.setText("Drivers Currently on Line List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of LocoPilots Currently on Line = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }

        });
        jbutton6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)//||"+"'/'"+"||
            {
                qtm.setHostURL("");
                String s = "Select NameDriver,to_char(date1,'mm/dd/yyyy hh24:mi') date1, Casualty,station from Casualtyd  where CasualtyOver =0 Order by casualty,date1 ";
                qtm.setQuery(s);
                jbTableTitle.setText("Casualty LocoPilots List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of LocoPilots under Casualty = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                String s = pt.getTodayTime();
                qtm.setHostURL("");
                String s1 = "Select NameDriver,to_char(Prfrom,'mm/dd hh24:mi') PRFrom, to_char(PRTo,'mm/dd hh24:mi') PRUPTO, USERENTERED from PRd  where prto >to_date('" + s + "','mm/dd/yyyy hh24:mi') and canceled = 0 ORDER BY PRTO";
                qtm.setQuery(s1);
                jbTableTitle.setText("PR Drivers List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of LocoPilots under PR= " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton8.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                qtm.setHostURL("");
                String s = "Select a.Name, a.lapbalance, a.lhapbalance, a.clbalance, b.pagerno wll from LeaveBalance a,"+
				" crewdetails b where a.designation = 'DRIVER' and a.pfno = b.pfnodriver and b.notthere = 0 order by a.name ";
                qtm.setQuery(s);
                jbTableTitle.setText(" LocoPilots Leave Balance List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of LocoPilots in the depot = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton18.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                qtm.setHostURL("");
                String s = "select a.slno,a.nameGuard, to_char(a.departure,'mm/dd hh24:mi') OTLTime, to_char(b.date1,'mm/dd hh24:mi') available, to_char(a.bookingtime,'mm/dd hh24:mi') booked, b.hoursworked, d.pagerno WLL  from bookingGuard a, curravailg b, guarddetails d  where  a.pfnoGuard = b.pfnoGuard and a.pfnoGuard = d.pfnoGuard and b.booked=1 and   a.bookingtime =  (select max(c.bookingtime)   from bookingGuard c where c.availabletime = b.date1 and  b.pfnoGuard = c.pfnoGuard and b.booked=1)  order by a.departure ";
                qtm.setQuery(s);
                jbTableTitle.setText("Booked Guards List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of Guards Booked = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton19.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {  qtm.setHostURL("");
                cjdbc.executeProcedure("updatedata()");
                hk.startHouseKeeping();
                boolean flag = HouseKeeping.isFirstWeek;
                System.out.println("A First Week : " + flag);
                String s;
                if(flag)
                    s = "Order by to_char(date1,'yyyy/mm/dd hh24:mi'),HoursWorked,restfrom, nameguard";
                else
                    s = "Order by HoursWorked,to_char(date1,'yyyy/mm/dd hh24:mi'),restfrom, nameguard";
                qtm.setHostURL("");
                query = "Select depot from depot";
                System.out.println(query);
                Vector vector = snv.getStationNameList("", query);
                depot = (String)vector.elementAt(0);
                if(depot.equals("KZJ"))
                    query = "Select a.NameGuard,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,to_char(a.date1,'mm/dd hh24:mi') Available, a.HoursWorked,a.Mileage, a.kzj_bpq BPQ, a.kzj_bza BZA, a.electric AC, a.diesel DSL   from Curravailg a where a.Booked =0 " + s;
                else
                    query = "Select a.NameGuard,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.date1,'mm/dd hh24:mi') Available, a.HoursWorked Hours,a.Mileage "+
					"   from Curravailg a where a.Booked =0 " + s;
                qtm.setHostURL("");
                qtm.setQuery(query);
                QueryTable _tmp = qtm;
                numbers = "Available Guards = " + QueryTable.noOfRecord;
                if(depot.equals("KZJ"))
                {
                    qtm.setHostURL("");
                    qtm.setQuery("select count(nameguard) from curravailg where kzj_bpq = 1 and booked = 0");
                    QueryTable _tmp1 = qtm;
                    numbers = numbers + "  ,  BPQ = " + QueryTable.noOfRecord;
                    qtm.setHostURL("");
                    qtm.setQuery("select count(nameguard) from curravailg where kzj_bza = 1 and booked = 0");
                    QueryTable _tmp2 = qtm;
                    numbers = numbers + "  ,  BZA = " + QueryTable.noOfRecord;
                    qtm.setHostURL("");
                    qtm.setQuery("select count(nameguard) from curravailg where kzj_sc_snf = 1 and booked = 0");
                    QueryTable _tmp3 = qtm;
                    numbers = numbers + "  ,  SNF = " + QueryTable.noOfRecord;
                }
                jbTableTitle.setText("Available Guards List");
                jbTableSize.setText(numbers);
                if(depot.equals("KZJ"))
                    query = "Select a.NameGuard,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.date1,'mm/dd hh24:mi') Available, a.HoursWorked Hours,a.Mileage,"+
		//			" a.kzj_bpq BPQ, a.kzj_bza BZA, a.electric AC, a.diesel DSL   "+
//					"replace(replace(a.kzj_bpq,1,'BPQ'),0,'-') ||"+"'-'"+"||replace(replace(a.kzj_amq_snf,1,'SNF'),0,'-')||"+"'-'"+"||replace(replace(a.kzj_bza,1,'BZA'),0,'-') LR, "+
					"b.pagerno telno from Curravailg a, guarddetails b where a.pfnoguard = b.pfnoguard and a.Booked =0 " + s;
                else
                    query = "Select a.NameGuard,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.date1,'mm/dd hh24:mi') Available, a.HoursWorked Hours,a.Mileage, b.pagerno TELNO  from Curravailg a, guarddetails b  where a.pfnoguard=b.pfnoguard and a.Booked =0 " + s;
                qtm.setHostURL("");
                qtm.setQuery(query);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton21.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {  qtm.setHostURL("");
                query = "Select depot from depot";
                System.out.println(query);
                Vector vector = snv.getStationNameList("", query);
                query = (String)vector.elementAt(0);
                if(query.equals("KZJ"))
                    qtm.setQuery("Select a.NameGuard,to_char(a.RestFrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.RestTo,'mm/dd hh24:mi') RestUpTo, a.HoursWorked,a.Mileage, "+
//					"replace(replace(a.prissued,0,'-'),1,'PR')||replace(replace(a.notfound,'NO','-'),'YES','NF') PR_NF ,b.pagerno WLL "+
//					" from CurrrestG a, guarddetails b where a.pfnoguard= b.pfnoguard order by to_char(a.RestTo,'yyyy/mm/dd hh24:mi')");
                
					"replace(replace(a.prissued,1,'PR'),0,'-')||replace(replace(a.notfound,'NO','-'),'YES','NF') PR_NF ,"+
					"replace(replace(nvl(decode(sign(nvl(b.kzj_bpa,'01-jan-1999') - sysdate),-1,0),1),1,'BPQ'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_bpa,'01-jan-1999') - sysdate),-1,0),1),1,'BZA'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_amq_snf,'01-jan-1999') - sysdate),-1,0),1),1,'SNF'),0,'-') LR,"+
					" c.pagerno WLL "+
					" from CurrrestG a, lrg b, guarddetails c where a.pfnoguard= b.pfnoguard and a.pfnoguard= c.pfnoguard order by to_char(a.RestTo,'yyyy/mm/dd hh24:mi')");
				
				else
                    qtm.setQuery("Select a.NameGuard,to_char(a.RestFrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.RestTo,'mm/dd hh24:mi') RestUpTo, a.HoursWorked,a.Mileage, "+
//					"replace(replace(a.prissued,0,'-'),1,'PR')||replace(replace(a.notfound,'NO','-'),'YES','NF') PR_NF ,"+

					"replace(replace(a.prissued,1,'PR'),0,'-')||replace(replace(a.notfound,'NO','-'),'YES','NF') PR_NF ,"+
					"replace(replace(nvl(decode(sign(nvl(b.kzj_BPA,'01-jan-1999') - sysdate),-1,0),1),1,'BPQ'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_BPA,'01-jan-1999') - sysdate),-1,0),1),1,'BZA'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_amq_snf,'01-jan-1999') - sysdate),-1,0),1),1,'SNF'),0,'-') LR,"+
					" c.pagerno Telno "+
					"from CurrrestG a, lrg b, guarddetails c where a.pfnoguard= b .pfnoguard and a.pfnoguard = c.pfnoguard order by to_char(a.RestTo,'yyyy/mm/dd hh24:mi')");
                jbTableTitle.setText("Guards Under Rest List");
                QueryTable _tmp = qtm;
								System.out.println("GRest:");
                jbTableSize.setText("Number of Guards Under Rest = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton20.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                qtm.setQuery("Select Ctrno,NameGuard,to_char(date1,'mm/dd hh24:mi') SignOn,trainno, hoursworked from CurronlineG order by date1");
                jbTableTitle.setText("Guards Currently on Line List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of Guards Currently on Line = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton22.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                qtm.setHostURL("");
                String s = "Select NameGuard,to_char(date1,'mm/dd/yyyy hh24:mi') date1, Casualty from CasualtyG  where CasualtyOver =0 Order by casualty,date1 ";
                qtm.setQuery(s);
                jbTableTitle.setText("Casualty Guards List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of Guards under Casualty = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton23.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                String s = pt.getTodayTime();
                qtm.setHostURL("");
                String s1 = "Select NameGuard,to_char(Prfrom,'mm/dd hh24:mi') PRFrom, to_char(PRTo,'mm/dd hh24:mi') PRUPTO , USERENTERED from PRG  where prto >to_date('" + s + "','mm/dd/yyyy hh24:mi') and canceled = 0 ORDER BY PRTO";
                qtm.setQuery(s1);
                jbTableTitle.setText("PR Guards List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of Guards under PR= " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton24.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                qtm.setHostURL("");
                String s = "Select a.Name,a.lapbalance,a.lhapbalance,a.clbalance, b.pagerno WLL from LeaveBalance  a, guarddetails b where a.pfno = b.pfnoguard and b.notthere=0 Order by a.name ";
                qtm.setQuery(s);
                jbTableTitle.setText(" Guards Leave Balance List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of Guards in the depot = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton10.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {  qtm.setHostURL("");
                String s = "select a.slno,a.nameassistant, to_char(a.departure,'mm/dd hh24:mi') OTLTime, to_char(b.date1,'mm/dd hh24:mi') available, to_char(a.bookingtime,'mm/dd hh24:mi') booked, b.hoursworked, d.pagerno  from bookingassistant a, curravailad b, asstdetails d  where  a.pfnoassistant = b.pfnoassistant and a.pfnoassistant = d.pfnoassistant and b.booked=1 and   a.bookingtime =  (select max(c.bookingtime)   from bookingassistant c where c.availabletime = b.date1 and  b.pfnoassistant = c.pfnoassistant and b.booked=1)  order by a.departure ";
                qtm.setQuery(s);
                jbTableTitle.setText("Booked Asst LocoPilots List");
                QueryTable _tmp = qtm;
                jbTableSize.setText("Number of Asst LocoPilots Booked =" + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton11.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                cjdbc.executeProcedure("updatedata()");
                hk.startHouseKeeping();
                boolean flag = HouseKeeping.isFirstWeek;
                System.out.println("A First Week : " + flag);
                String s;
                if(flag)
                    s = "Order by to_char(date1,'yyyy/mm/dd hh24:mi'),HoursWorked,restfrom, nameassistant";
                else
                    s = "Order by HoursWorked,to_char(date1,'yyyy/mm/dd hh24:mi'),restfrom, nameassistant";
                query = "Select depot from depot";
                System.out.println(query);
                Vector vector = snv.getStationNameList("", query);
                depot = (String)vector.elementAt(0);
                if(depot.equals("KZJ"))
                    query = "Select a.NameAssistant,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.date1,'mm/dd hh24:mi') Available,a.HoursWorked,a.Mileage,"+
		//			"a.kzj_bpq BPQ, a.kzj_bza BZA, a.electric AC, a.diesel DSL  from Curravailad a where a.Booked =0 " + s;
          			"replace(replace(a.kzj_bpq,1,'BPQ'),0,'-') ||"+"'-'"+"||replace(replace(a.kzj_amq_snf,1,'SNF'),0,'-')||replace(replace(a.kzj_bza,1,'BZA'),0,'-') LR,"+
					"replace(replace(a.electric,1,'AC'),0,'-')||replace(replace(a.diesel,0,'-'),1,'DSL') DSL ,b.pagerno WLL "+
					" from Curravailad a,asstdetails b  where a.pfnoassistant = b.pfnoassistant and a.Booked =0 " + s;

				else
                    query = "Select a.NameAssistant,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,to_char(a.date1,'mm/dd hh24:mi') Available,a.HoursWorked,a.Mileage,a.electric AC, a.diesel DSL  from Curravailad a where a.Booked =0 " + s;
                qtm.setHostURL("");
                qtm.setQuery(query);
                QueryTable _tmp = qtm;
                numbers = "Available Asst LocoPilots = " + QueryTable.noOfRecord;
                if(depot.equals("KZJ"))
                {
                    qtm.setHostURL("");
                    qtm.setQuery("select count(nameassistant) from curravailad where kzj_bpq = 1 and booked=0");
                    QueryTable _tmp1 = qtm;
                    numbers = numbers + "  ,  BPQ = " + QueryTable.noOfRecord;
                    qtm.setHostURL("");
                    qtm.setQuery("select count(nameassistant) from curravailad where kzj_bza = 1 and booked=0");
                    QueryTable _tmp2 = qtm;
                    numbers = numbers + "  ,  BZA = " + QueryTable.noOfRecord;
                    qtm.setHostURL("");
                    qtm.setQuery("select count(nameassistant) from curravailad where kzj_sc_snf = 1 and booked=0");
                    QueryTable _tmp3 = qtm;
                    numbers = numbers + "  ,  SNF = " + QueryTable.noOfRecord;
                }
                jbTableTitle.setText("Available Asst LocoPilots List");
                jbTableSize.setText(numbers);
                if(depot.equals("KZJ"))
                    query = "Select a.NameAssistant,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.date1,'mm/dd hh24:mi') Available,a.HoursWorked,a.Mileage,"+
//					"a.kzj_bpq BPQ, a.kzj_bza BZA, a.electric AC, a.diesel DSL  from Curravailad a where a.Booked =0 " + s;
    				"replace(replace(a.kzj_bpq,1,'BPQ'),0,'-') ||"+"'-'"+"||replace(replace(a.kzj_amq_snf,1,'SNF'),0,'-')||replace(replace(a.kzj_bza,1,'BZA'),0,'-') LR,"+
					"replace(replace(a.electric,1,'AC'),0,'-')||replace(replace(a.diesel,0,'-'),1,'DSL') DSL ,b.pagerno WLL "+
					" from Curravailad a,asstdetails b  where a.pfnoassistant = b.pfnoassistant and a.Booked =0 " + s;

				else
                    query = "Select a.NameAssistant,to_char(a.restfrom,'mm/dd hh24:mi') RestFrom,to_char(a.date1,'mm/dd hh24:mi') Available,a.HoursWorked Hours,a.Mileage,a.electric||'-'||a.diesel AC_DSL, b.pagerno TelNo  from Curravailad a, asstdetails b where a.pfnoassistant=b.pfnoassistant and a.Booked =0 " + s;
                qtm.setHostURL("");
                qtm.setQuery(query);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton12.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                query = "Select depot from depot";
                System.out.println(query);
				  qtm.setHostURL("");
                Vector vector = snv.getStationNameList("", query);
                query = (String)vector.elementAt(0);
                if(query.equals("KZJ"))
                    qtm.setQuery("Select a.NameAssistant,to_char(a.RestFrom,'mm/dd hh24:mi') RestFrom,"+
					"to_char(a.RestTo,'mm/dd hh24:mi') RestUpTo, a.HoursWorked,a.Mileage, "+
	//				"a.prissued, a.NOTFOUND,nvl(decode(sign(nvl(b.kzj_bpq,'01-jan-1999') - sysdate) , -1,0),1) BPQ, nvl(decode(sign(nvl(b.kzj_bza,'01-jan-1999') - sysdate) , -1,0),1) BZA from Currrestad a, lrad b  where a.pfnoassistant = b.pfnoassistant and a.nameassistant = b.nameassistant  order by to_char(RestTo,'yyyy/mm/dd hh24:mi')");
   /*   					"replace(replace(a.prissued,1,'PR'),0,'-')||replace(replace(a.notfound,'NO','-'),'YES','NF') PR_NF ,"+
					"nvl(decode(sign(nvl(b.kzj_bpq,'01-jan-1999') - sysdate),-1,0),1) BPQ,"+
					" nvl(decode(sign(nvl(b.kzj_bza,'01-jan-1999') - sysdate) , -1,0),1) BZA ,"+
					" nvl(decode(sign(nvl(b.kzj_amq_snf,'01-jan-1999') - sysdate),-1,0),1) SNF, c.pagerno WLL "+
	*/
"replace(replace(c.electric,1,'AC'),0,'-')||replace(replace(c.diesel,1,'DSL'),0,'-') AC_DSL ,"+
					"replace(replace(nvl(decode(sign(nvl(b.kzj_bpq,'01-jan-1999') - sysdate),-1,0),1),1,'BPQ'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_bza,'01-jan-1999') - sysdate),-1,0),1),1,'BZA'),0,'-')"+
					"||replace(replace(nvl(decode(sign(nvl(b.kzj_amq_snf,'01-jan-1999') - sysdate),-1,0),1),1,'SNF'),0,'-') LR,"+
					" c.pagerno WLL "+
					"from Currrestad a, lrad b , asstdetails c where a.pfnoassistant = b.pfnoassistant and a.pfnoassistant = c.pfnoassistant "+
					"and a.pfnoassistant = b.pfnoassistant  order by to_char(RestTo,'yyyy/mm/dd hh24:mi')");

				else
                  query = "Select a.NameAssistant,to_char(a.RestFrom,'mm/dd hh24:mi') RestFrom,to_char(a.RestTo,'mm/dd hh24:mi') RestUpTo,"+
					"a.HoursWorked, a.Mileage, a.prissued||'-'||a.NOTFOUND PR_NF, b.pagerno telno from Currrestad a, asstdetails b where a.pfnoassistant=b.pfnoassistant order by RestTo";
                qtm.setQuery(query);
				jbTableTitle.setText("Asst LocoPilots Under Rest List");
                jbTableSize.setText("Number of Asst LocoPilots Under Rest = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton13.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {  qtm.setHostURL("");
                qtm.setQuery("Select ctrno,NameAssistant,to_char(date1,'mm/dd hh24:mi') SignOn,trainno, hoursworked from Curronlinead order by date1");
                jbTableTitle.setText("Assistant on Line List");
                jbTableSize.setText("Number of Asst LocoPilots Currently on Line = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton14.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                qtm.setHostURL("");
                String s = "Select NameAssistant,to_char(date1,'mm/dd/yyyy hh24:mi') date1,Casualty from Casualtyad  where CasualtyOver = 0 Order by Casualty,date1";
                qtm.setQuery(s);
                jbTableTitle.setText("Casualty Asst LocoPilots List");
                jbTableSize.setText("Number of Asst LocoPilots under Casualty = " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton16.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                String s = pt.getTodayTime();
                qtm.setHostURL("");
                String s1 = "Select NameAssistant,to_char(Prfrom,'mm/dd hh24:mi') PRFrom, to_char(PRTo,'mm/dd hh24:mi') PRUpTO, USERENTERED from PRad  where prto >to_date('" + s + "','mm/dd/yyyy hh24:mi') and canceled = 0 ORDER BY PRTO";
                qtm.setQuery(s1);
                jbTableTitle.setText("PR Asst LocoPilots  List");
                jbTableSize.setText("Number of Asst LocoPilots under PR= " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        jbutton15.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                qtm.setHostURL("");
                String s = "Select a.Name,a.lapbalance,a.lhapbalance,a.clbalance, b.pagerno Phone from leavebalance  a, asstdetails b where a.designation = 'ASSISTANT'  and a.pfno = b.pfnoassistant and b.notthere = 0 order by a.name ";
                qtm.setQuery(s);
                jbTableTitle.setText(" Asst LocoPilots Leave Balance List");
                jbTableSize.setText("Number of Ass LocoPilot in the depot= " + QueryTable.noOfRecord);
                panelTable.repaint();
                panel1.repaint();
            }
        });
        CompoundBorder compoundborder = new CompoundBorder(new EtchedBorder(), new BevelBorder(0));
        panel1.setBackground(new Color(0, 128, 128));
        panel1.setBorder(compoundborder);
        return panel1;
    }

    public static void main(String args[])
    {
        JFrame jframe = new JFrame("Current Positions WLL  ");
        jframe.addWindowListener(new BasicWindowMonitor());
        StatusNow statusnow = new StatusNow();
        jframe.getContentPane().add(statusnow.getStatusNow(), "Center");
        jframe.pack();
        jframe.setVisible(true);
    }


    QueryTable qtm;
    JTable table;
    JPanel panel1;
    JPanel panelTable;
    JButton jbTableTitle;
    JButton jbTableSize;
    Vector vectorDriver;
    Vector vectorAssistant;
    Vector vectorGuard;
    presentTime pt;
    Dimension dim1;
    HouseKeeping hk;
    CallableJDBC cjdbc;
    String query;
    String numbers;
    String depot;
    StationNameVector snv;
}