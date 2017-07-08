//ODA rectified 30-aug-06
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.Vector;

public class SignOfPanel
{
	JButton jbEngineno,jbTrainno,jbService,jbService1,jbFrom,jbTo,jbLoad,jbTitle,jbSiding,jbLoad1,
		jbSubmit,	jbTrainHrs, jbEngineHrs,jbShuntingHrs,	jbShow, jbTitleD, jbTitleD1,  jbSection,
		jbTitleAD, jbTitleAD1, jbCtrNo, jbVHF, jbPTPhone, jbShunting, jbVerify, jbKms, jbSDA, jbDetention;
	JTextField jtfCtrNo, jtfVHF, jtfPTPhone, jtfShunting, jtfSDA, jtfDetention;
	JPanel jpEngine,jpTrain,panel1,jpSiding,jpSiding1, panelCrew,panelAssistant, jpSignD,jpSignG,jpSignAD,
						panelAssistantName,panelDriver,panelDriverName, panel4, panel5, panel6, panel7,
						panelGuard, panelGuardName, jpSignArrl;
	JFormattedTextField jftfLoco1, jftfLoco2, jftfLoco3, jftfLoco4, jftfLoco5, jftfLoco6, 
			jftfLoco7, jftfLoco8, jftfLoco9, jftfLoco10, jftfLoco11, jftfLoco12,
			jftfLoad1, jftfLoad2, jftfLoad3, jftfLoad4, jftfLoad5, jftfLoad6,
					jftfLoad7, jftfLoad8, jftfLoad9, jftfLoad10, jftfLoad11, jftfLoad12;
	MaskFormatter mf1, mf2;
	rbgCrew rbg;
	nameComboBox ncbTrainno,ncbService,ncbFrom,ncbTo,ncbLoco,ncbSiding, ncbLoad, ncbDep1, ncbArr1, 		
				ncbDriver, ncbAssistant, ncbCoDriver, ncbPilotFrom, ncbPilotTo, ncbPilotFrom1, ncbPilotTo1,
				ncbDep2, ncbArr2,  ncbDep3, ncbArr3,  ncbDep4, ncbArr4,   ncbDep5, ncbArr5, ncbDep6, ncbArr6,
				ncbDep7, ncbArr7,  ncbDep8, ncbArr8, ncbDep9, ncbArr9,  ncbDep10, ncbArr10, 
				ncbDep11, ncbArr11,  ncbDep12, ncbArr12, ncbGuard, ncbSection;
	JComboBox jcbTrainno1,jcbTrainno2,jcbTrainno3,jcbTrainno4,jcbTrainno5,jcbTrainno6,jcbTrainno7,
				jcbTrainno8,jcbTrainno9,jcbTrainno10,jcbTrainno11,jcbTrainno12, jcbTrainno13,				
				jcbService,jcbService1,jcbService2,jcbService3,jcbService4,jcbService5,
				jcbService6,jcbService7,jcbService8,
				jcbService9,jcbService10,jcbService11,jcbService12,jcbService13,
				jcbFrom1,jcbFrom2,jcbFrom3,jcbFrom4,jcbFrom5, jcbFrom6,jcbFrom7, jcbFrom8,
				jcbFrom9, jcbFrom10,jcbFrom11, jcbFrom12,
				jcbTo1,jcbTo2,jcbTo3,jcbTo4, jcbTo5, jcbTo6,jcbTo7, jcbTo8, jcbTo9, jcbTo10,jcbTo11, jcbTo12, 
				jcbSiding1,jcbSiding2,jcbSiding3,jcbSiding4,jcbSiding5, jcbSiding6,
				jcbSiding7,jcbSiding8,jcbSiding9,jcbSiding10,jcbSiding11, jcbSiding12,
				jcbLoco1,jcbLoco2,jcbLoco3,jcbLoco4,jcbLoco5,jcbLoco6,jcbLoco7,jcbLoco8,jcbLoco9,jcbLoco10,
				jcbLoco11,jcbLoco12, jcbLoco13,
				jcbLoad1,jcbLoad2,jcbLoad3,jcbLoad4,jcbLoad5,jcbLoad6,jcbLoad7,jcbLoad8, jcbLoad9,
				jcbLoad10, jcbLoad11, jcbLoad12, jcbLoad13, jcbDep1, jcbArr1, jcbDep2, jcbArr2,  jcbDep3, jcbArr3,
				jcbDep4, jcbArr4,  jcbDep5, jcbArr5, jcbDep6, jcbArr6, jcbDep7, jcbArr7,
				jcbDep8, jcbArr8, jcbDep9, jcbArr9, jcbDep10, jcbArr10, jcbDep11, jcbArr11,jcbDep12, jcbArr12,
				jcbDep13, jcbArr13,jcbDriverName, jcbAssistantName, jcbCoDriverName, jcbPilotFrom, jcbPilotTo,
				jcbPilotFrom1, jcbPilotTo1, jcbGuardName, jcbSection1, jcbSection2, jcbSection3, jcbSection4, 
				jcbSection5, jcbSection6, jcbSection7, jcbSection8, jcbSection9, jcbSection10, jcbSection11, jcbSection12;
	JButton label1, label2, label3, label4,label5,label6,label7,label8,label9,label10,label11,label12;
	int load, indx,  distPilot, dist, distPilot1, distPilot2,  shuntingHour, odaKm, odaKmD, odaKmA, len;
	double 	workingHours, hour1, hour2, hour3, hour4, hour5, hour6, hour7, hour8, hour9, hour10,
				hour11, hour12, hourSdg1, hourSdg2, hourSdg3, hourSdg4, hourSdg5, hourSdg6, hourSdg7, hourSdg8, 
				hourSdg9, hourSdg10, hourSdg11, hourSdg12, sidingHours,
				hourShtg1, hourShtg2, hourShtg3, hourShtg4, hourShtg5, hourShtg6, hourShtg7, hourShtg8, 
				hourShtg9, hourShtg10, hourShtg11, hourShtg12, shuntingHours,
				hourPilot1, hourPilot2, hourPilot3, hourPilot4, hourPilot5, hourPilot6, hourPilot7,
				hourPilot8, hourPilot9, hourPilot10, hourPilot11, hourPilot12,pilotHours,
				guardHours, driverHours, assistantHours, periodhoursg, periodhoursd, periodhoursa, houra1, hourg1; 
	Dimension dim, dim2, dim1, dim3, dim4, dim5, dim6, dim7, dim8, dim9;	
	Vector vectorDriver, vectorAssistant, vectorDriverCoaching, vectorAssistantCoaching, vectorCoaching, 
				vecCtrD, vecCtrA,vecCtrCoD , vector , vecOut, vecLoco, out, vectorGuard, vectorGuardCoaching;
	String sLRStation,sLRCode, StationCode, lrstation, select, insert , update, delete, ctrx, ctry, ctrz, 
		xctr, RestTo;
	String ctrnos = "";
	datePanel1 dpD,dpA, dpG,dpSof, dpArrl;
	hourPanel1 hpD,hpA, hpG, hpSof, hpArrl;
	minutePanel1 mpD,mpA, mpG, mpSof, mpArrl;
	checkBoxCrew cbcHandicap;
	JCheckBox jcContinuous, jcVia, jcHandicap, jcNRRA, jcNCA;
	Connection con, conn;
	Statement stmt,stmt1, stmt2;
	ResultSet rs, rs2;
	int  throughgoodskm, lekm, ballastkm, cranesplkm,breakdownkm, medicalreliefkm, shuntingkm,
		coalpilotskm, lelakm, materialtrainkm, pilotkm, enggsplkm, hg1km, hg2km,  sidingkm, shuttlingkm, 
		yardreliefkm, pilotsectionkm, lrkm, srtrainkm, iNRRA, iNCA, enggkm, days;
	double throughgoodshrs, lehrs, ballasthrs, cranesplhrs,breakdownhrs, medicalreliefhrs, shuntinghrs,
		coalpilotshrs, lelahrs, materialtrainhrs, pilothrs, enggsplhrs, hg1hrs, hg2hrs,  sidinghrs,
		yardreliefhrs, pilotsectionhrs, lrhrs, srtrainhrs, sda, shuttlinghrs;
					
	String url = "jdbc:odbc:javacrew",ctrno,trainno,service,engineno,
		engine1,engine2,engine3,engine4,engine5,engine6,engine7,engine8, engine9,engine10,engine11,engine12,
		train1,train2,train3,train4,train5,train6,train7,train8, train9,train10,train11,train12,
		service1,service2,service3,service4,service5,service6,service7,service8, service9,service10,service11,service12,
		from1,from2,from3,from4,from5,from6,from7,from8,from9,from10,from11,from12,
		to1,to2,to3,to4,to5,to6, to7, to8,to9,to10,to11, to12,
		siding1,siding2,siding3,siding5,siding4,siding6,siding7,siding8,siding9,siding10,siding11,siding12, 
		strInsert,querySiding,strWeight, ctrs, ctr, lock,
		dep1,dep2,dep3,dep4,dep5,dep6,dep7,dep8,dep9,dep10, dep11, dep12,
		arr1,arr2,arr3,arr4,arr5,arr6,arr7,arr8,arr9,arr10,arr11,arr12 ,
		section1, section2, section3, section4, section5, section6, section7, section8, section9,
		section10, section11, section12, relief, relief1, relief2;
	String strstn,strstn1,strstn2,strstn3,strstn4,strstn5,strstn6, strstn7, strstn8,strstn9,
		strstn10,strstn11, strstn12, 		lastSignOf, lastSignOfDate, signoflast="null", 
		insertCtrlist, strType, ddate, adate,gdate, xdate1, xdate1hh, xdate1mm, depot,
		queryDriver, queryDriverCoaching, queryAsst, queryAsstCoaching,
		load1,load2,load3,load4,load5,load6,load7,load8, load9,load10,load11,load12,
		optionSelected, driverNamePfNo, codriverNamePfNo, assistantNamePfNo, driverName,driverPfNo, 
		guardNamePfNo, guardName, guardPfNo, outofhqD, outofhqAD, outofhqG,
		codriverName, codriverPfNo, assistantName, assistantPfNo, strservice, strCtrNo,			driverDate, 
		driverDate1, driverHour, driverMinute, assistantDate, assistantDate1, assistantHour, 
		assistantMinute, guardDate, 	guardDate1, guardHour, guardMinute, signOfHour, signOfMinute,
		departureDate, departureHour, departureMinute, arrivalDate, arrivalHour, arrivalMinute, nextDate,
		signOfDate, query, inArrivalDate, inArrivalHour, inArrivalMinute;
	String ddep1 , aarr1, ddep2 , aarr2, ddep3 , aarr3, ddep4 , aarr4, ddep5 , aarr5, ddep6 , aarr6,
			ddep7 , aarr7, ddep8 , aarr8, ddep9 , aarr9, ddep10 , aarr10, ddep11 , aarr11, ddep12 , aarr12;
	String sdate ,shour, sminute, month, day , coa, vhfno, ptphoneno , pilotFrom, pilotTo,
				pilotFrom1, pilotTo1,pilotFrom2, pilotTo2, loco, noloco="",loconotfound="", radioname,lrsection;
	double		dutyHourDriver, dutyHourAssistant, ndad, ndaa, hrest,hrestd, hresta, orest,orestd, oresta, 
		ndag, orestg, hrestg, dutyHourGuard;
	double mileagex = 0, mileage = 0, amileage = 0, dmileage=0, gmileage=0, xhours;
					
	int smin, sh, xday, iHandicap, iContinuous, iVia, detention;		
	int dist1 , dist2,dist3,dist4,dist5,dist6,dist7,dist8, dist9,dist10,dist11,dist12,
		distSdg1 , distSdg2,distSdg3,distSdg4,distSdg5,distSdg6,distSdg7, distSdg8,distSdg9,
		distSdg10,distSdg11,distSdg12,
		distShtg1 , distShtg2,distShtg3,distShtg4,distShtg5,distShtg6,distShtg7, distShtg8,distShtg9,
		distShtg10,distShtg11,distShtg12,
		distSiding1, distSiding2, distSiding3, distSiding4, distSiding5, distSiding6, 
		distSiding7, distSiding8, distSiding9, distSiding10, distSiding11, distSiding12,
		gtkm1,gtkm2,gtkm3,gtkm4,gtkm5,gtkm6,gtkm7,gtkm9,gtkm10,gtkm11,gtkm12, 
		ekm1, ekm2, ekm3, ekm4, ekm5 , ekm6, ekm7, ekm8, ekm9, ekm10, ekm11,locoWeight=0,
		index , nooflocos;
	
	boolean blnBase=false, blnBaseStation=false, blnDriver, blnAssistant, blnCoDriver, blnOSD, blnCtrD,
					blnOSA, blnCtrA, blnContinuous, blnVia, blnHandicap, blnNextDate, blnFirst, blnFirst1,
					blnFirst2, blnFirst3, blnFirst4, blnFirst5, blnFirst6, blnFirst7, blnFirst8, blnFirst9,
					 blnFirst10, blnFirst11, blnFirst12,blnClear, blnGuard, blnCtrG, blnOSG, blnLRS,
					  blnNRRA, blnNCA, blnSpecial, blnLRPilot;
	static String  ddate1="", adate1="", gdate1="", continuedate;
	JRadioButton jrbDriver, jrbAssistant, jrbGuard, jrbWithoutGuard, jrbWithGuard;
	ButtonGroup group;
	insertSQL isql ;
	StationNameVector snv;
	calculateDistance cd;
	SidingKm sk;
	QueryTableModel qtm;
	MusterRoll mr;
	changeDayMonthFormat cdmf;
	CrewNameVector cnv;
	calculateTime ct;
	addTime at;
	presentTime pt;
	updateWorkingHrsG upwhg;
	updateWorkingHrsD upwhd;
	updateWorkingHrsA upwha;
	MileageA ma;
	MileageD md;
	MileageG mg;
	Font f1, f2, f3;
	compareTime cmpt;
	MileageEarned me;
	CallableJDBC cjdbc;
	public SignOfPanel()
	{
		cjdbc = new CallableJDBC();
		me = new MileageEarned();
		ma = new MileageA();
		md = new MileageD();
		mg = new MileageG();
		upwhg = new updateWorkingHrsG();
		upwha = new updateWorkingHrsA();
		upwhd = new updateWorkingHrsD();
		pt = new presentTime();
		cd = new calculateDistance();
		qtm = new QueryTableModel();
		sk = new SidingKm();
		snv = new StationNameVector();
		mr = new MusterRoll();
		cdmf = new changeDayMonthFormat();
		cnv  = new CrewNameVector();
		ct = new calculateTime();
		at = new addTime();
		cmpt = new compareTime();
		
		dim  = new Dimension(82,21);
		dim1 = new Dimension(55,21);
		dim2 = new Dimension(80,21);
		dim3  = new Dimension(250,21);
		dim4 = new Dimension(50,21);
		dim5 = new Dimension(65,21);
		dim6 = new Dimension(90,21);
		dim7 = new Dimension(200,21);
		dim8 = new Dimension(110,21);
		dim9 = new Dimension(60,21);
		dist = 0; distPilot = 0; 
		blnBaseStation = false;
		blnFirst = true;
		blnClear = true;
		vecOut = new Vector();
		f1 = new Font(null,Font.BOLD,11);
		f2 = new Font(null,Font.BOLD,9);
		f3 = new Font(null,Font.BOLD,10);
/*		
		dim  = new Dimension(105,22);
		dim1 = new Dimension(60,22);
		dim2 = new Dimension(85,22);
		dim3  = new Dimension(150,22);
		dim4 = new Dimension(50,22);
		dim5 = new Dimension(65,22);
		dim6 = new Dimension(200,25);
		f1 = new Font(null,Font.BOLD,10);
		f2 = new Font(null,Font.BOLD,11);
		dist = 0; distPilot = 0; 
		blnBaseStation = false;
		blnFirst = true;
		blnClear = true;
		vecOut = new Vector();
*/
		vectorCoaching = new Vector();
		try
		{
			mf1 =	new MaskFormatter("#####+#####+#####+#####+#####");
			mf1.setPlaceholderCharacter('0');		
			mf2 =	new MaskFormatter("##+#/###/####");
			mf2.setPlaceholderCharacter('0');		
		}
		catch(Exception ex)
		{
		}
	}
	public JPanel getSignOfPanel()
	{
		jbKms = new JButton("Total Kms : 0  & Pilot Kms : 0 & Hours Worked : 0");
		jbKms.setBackground(Color.green);
		jbKms.setForeground(Color.blue);
		jbKms.setFocusable(false);
		jbKms.setFont(f2);

		label1 = new JButton("0");
		label1.setBackground(Color.green);
		label1.setForeground(Color.blue);
		label1.setPreferredSize(dim1);
		label1.setMargin(new Insets(0,0,0,0));
		label2 = new JButton("0");
		label2.setBackground(Color.green);
		label2.setForeground(Color.blue);
		label2.setPreferredSize(dim1);
		label2.setMargin(new Insets(0,0,0,0));
		label3 = new JButton("0");
		label3.setBackground(Color.green);
		label3.setForeground(Color.blue);
		label3.setPreferredSize(dim1);
		label3.setMargin(new Insets(0,0,0,0));
		label4 = new JButton("0");
		label4.setBackground(Color.green);
		label4.setForeground(Color.blue);
		label4.setPreferredSize(dim1);
		label4.setMargin(new Insets(0,0,0,0));
		label5 = new JButton("0");
		label5.setBackground(Color.green);
		label5.setForeground(Color.blue);
		label5.setPreferredSize(dim1);
		label5.setMargin(new Insets(0,0,0,0));
		label6 = new JButton("0");
		label6.setBackground(Color.green);
		label6.setForeground(Color.blue);
		label6.setPreferredSize(dim1);
		label6.setMargin(new Insets(0,0,0,0));
		label7 = new JButton("0");
		label7.setBackground(Color.green);
		label7.setForeground(Color.blue);
		label7.setPreferredSize(dim1);
		label7.setMargin(new Insets(0,0,0,0));
		label8 = new JButton("0");
		label8.setBackground(Color.green);
		label8.setForeground(Color.blue);
		label8.setPreferredSize(dim1);
		label8.setMargin(new Insets(0,0,0,0));
		label9 = new JButton("0");
		label9.setBackground(Color.green);
		label9.setForeground(Color.blue);
		label9.setPreferredSize(dim1);
		label9.setMargin(new Insets(0,0,0,0));
		label10 = new JButton("0");
		label10.setBackground(Color.green);
		label10.setForeground(Color.blue);
		label10.setPreferredSize(dim1);
		label10.setMargin(new Insets(0,0,0,0));
		label11 = new JButton("0");
		label11.setBackground(Color.green);
		label11.setForeground(Color.blue);
		label11.setPreferredSize(dim1);
		label11.setMargin(new Insets(0,0,0,0));
		label12 = new JButton("0");
		label12.setBackground(Color.green);
		label12.setForeground(Color.blue);
		label12.setPreferredSize(dim1);
		label12.setMargin(new Insets(0,0,0,0));

		label1.setFocusable(false);
		label2.setFocusable(false);
		label3.setFocusable(false);
		label4.setFocusable(false);
		label5.setFocusable(false);
		label6.setFocusable(false);
		label7.setFocusable(false);		
		label8.setFocusable(false);
		label9.setFocusable(false);
		label10.setFocusable(false);
		label11.setFocusable(false);
		label12.setFocusable(false);

		jbTitleD = new JButton("Driver");
		jbTitleD.setFocusable(false);
		jbTitleD.setMargin(new Insets(0,0,0,0));
		jbTitleD.setBackground(Color.green);
		jbTitleD.setForeground(Color.blue);

		jbTitleD1 = new JButton("Driver");
		jbTitleD1.setFocusable(false);
		jbTitleD1.setBackground(Color.yellow);
		jbTitleD1.setForeground(Color.blue);

		JButton jbTitleG = new JButton("Guard");
		jbTitleG.setFocusable(false);
		jbTitleG.setMargin(new Insets(0,0,0,0));
		jbTitleG.setBackground(Color.green);
		jbTitleG.setForeground(Color.blue);

		JButton jbTitleG1 = new JButton("Guard");
		jbTitleG1.setFocusable(false);
		jbTitleG1.setBackground(Color.green);
		jbTitleG1.setForeground(Color.blue);

		jbTitleAD = new JButton("Assistant");
		jbTitleAD.setFocusable(false);
		jbTitleAD.setMargin(new Insets(0,0,0,0));
		jbTitleAD.setBackground(Color.green);
		jbTitleAD.setForeground(Color.blue);

		jbTitleAD1 = new JButton("Assistant");
		jbTitleAD1.setFocusable(false);
		jbTitleAD1.setBackground(Color.green);
		jbTitleAD1.setForeground(Color.blue);

		jbCtrNo = new JButton("CTRNo");
		jbCtrNo.setFocusable(false);
		jbCtrNo.setBackground(Color.green);
		jbCtrNo.setForeground(Color.blue);
		jbCtrNo.setMargin(new Insets(0,0,0,0));
		jtfCtrNo = new JTextField(6);

		jbDetention = new JButton("Detention");
		jbDetention.setFocusable(false);
		jbDetention.setBackground(Color.green);
		jbDetention.setForeground(Color.blue);
		jbDetention.setMargin(new Insets(0,0,0,0));
		jtfDetention = new JTextField(6);
		jtfDetention.setText("0");

		String currentDate = pt.getTodayTime();
		String mon= currentDate.substring(0,2);
		String day=currentDate.substring(3,5);
		String currentDate1 = mon+day;
		jtfCtrNo.setText(currentDate1);//.substring(0,4)

		jbVHF = new JButton("VHF");
		jbVHF.setFocusable(false);
		jbVHF.setBackground(Color.green);
		jbVHF.setForeground(Color.blue);
		jbVHF.setMargin(new Insets(0,0,0,0));
		jtfVHF = new JTextField(6);
		jtfVHF.setFocusable(false);
		jtfVHF.setToolTipText("It gets displayed on pressing 'TotalKms' button");
		jbPTPhone = new JButton("PTPhone");
		jbPTPhone.setMargin(new Insets(0,0,0,0));
		jbPTPhone.setFocusable(false);
		jbPTPhone.setBackground(Color.green);
		jbPTPhone.setForeground(Color.blue);
		jtfPTPhone = new JTextField(8);
		jtfPTPhone.setFocusable(false);

		jbVerify = new JButton("Verify Data");
		jbVerify.setBackground(new Color(255,255,83));
		jbVerify.setForeground(new Color(0,0,255));
		jbVerify.setMnemonic('V');
		jbVerify.setPreferredSize(dim8);

		jbShunting = new JButton("S.Hrs");
		jbShunting.setFocusable(false);
		jbShunting.setBackground(Color.green);
		jbShunting.setForeground(Color.blue);
		jbShunting.setMargin(new Insets(0,0,0,0));
		jtfShunting = new JTextField(2);
		jtfShunting.setText("0");

		jbSDA = new JButton("SDA");
		jbSDA.setFocusable(false);
		jbSDA.setBackground(Color.green);
		jbSDA.setForeground(Color.blue);
		jbSDA.setMargin(new Insets(0,0,0,0));
		jtfSDA = new JTextField(2);
		jtfSDA.setText("0");

		JButton jbDateD = new JButton("Date");
		jbDateD.setBackground(Color.green);
		jbDateD.setForeground(Color.blue);
		dpD = new datePanel1();
		JPanel dateDriver = dpD.getDateDisplayPanel();

		JButton jbHourD = new JButton("Hours");
		jbHourD.setBackground(Color.green);
		jbHourD.setForeground(Color.blue);
		hpD = new hourPanel1();
		JPanel hourDriver = hpD.getHourDisplayPanel();

		JButton jbMinuteD = new JButton("Minutes");
		jbMinuteD.setBackground(Color.green);
		jbMinuteD.setForeground(Color.blue);
		mpD = new minutePanel1();
		JPanel minuteDriver = mpD.getMinuteDisplayPanel();

		JButton jbDateG = new JButton("Date");
		jbDateG.setBackground(Color.green);
		jbDateG.setForeground(Color.blue);
		dpG = new datePanel1();
		JPanel dateGuard = dpG.getDateDisplayPanel();

		JButton jbHourG = new JButton("Hours");
		jbHourG.setBackground(Color.green);
		jbHourG.setForeground(Color.blue);
		hpG = new hourPanel1();
		JPanel hourGuard = hpG.getHourDisplayPanel();

		JButton jbMinuteG = new JButton("Minutes");
		jbMinuteG.setBackground(Color.green);
		jbMinuteG.setForeground(Color.blue);
		mpG = new minutePanel1();
		JPanel minuteGuard = mpG.getMinuteDisplayPanel();

		JButton jbDateAD = new JButton("Date");
		jbDateAD.setBackground(Color.green);
		jbDateAD.setForeground(Color.blue);
		dpA = new datePanel1();
		JPanel dateAssistant = dpA.getDateDisplayPanel();

		JButton jbHourAD = new JButton("Hours");
		jbHourAD.setBackground(Color.green);
		jbHourAD.setForeground(Color.blue);
		hpA = new hourPanel1();
		JPanel hourAssistant = hpA.getHourDisplayPanel();

		JButton jbMinuteAD = new JButton("Minutes");
		jbMinuteAD.setBackground(Color.green);
		jbMinuteAD.setForeground(Color.blue);
		mpA = new minutePanel1();
		JPanel minuteAssistant = mpA.getMinuteDisplayPanel();

		JButton jbTitleArrl = new JButton("In Tr Arrl");
		jbTitleArrl.setFocusable(false);
		jbTitleArrl.setBackground(Color.green);
		jbTitleArrl.setForeground(Color.blue);

		JButton jbDateArrl = new JButton("Date");
		jbDateArrl.setBackground(Color.green);
		jbDateArrl.setForeground(Color.blue);
		dpArrl = new datePanel1();
		JPanel dateArrival = dpArrl.getDateDisplayPanel();

		JButton jbHourArrl = new JButton("Hours");
		jbHourArrl.setBackground(Color.green);
		jbHourArrl.setForeground(Color.blue);
		hpArrl = new hourPanel1();
		JPanel hourArrival = hpArrl.getHourDisplayPanel();

		JButton jbMinuteArrl = new JButton("Minutes");
		jbMinuteArrl.setBackground(Color.green);
		jbMinuteArrl.setForeground(Color.blue);
		mpArrl = new minutePanel1();
		JPanel minuteArrival = mpArrl.getMinuteDisplayPanel();

		JButton jbTitleSof = new JButton("Sign OFF");
		jbTitleSof.setFocusable(false);
		jbTitleSof.setBackground(Color.green);
		jbTitleSof.setForeground(Color.blue);

		JButton jbDateSof = new JButton("Date");
		jbDateSof.setBackground(Color.green);
		jbDateSof.setForeground(Color.blue);
		dpSof = new datePanel1();
		JPanel dateSignOf = dpSof.getDateDisplayPanel();

		JButton jbHourSof = new JButton("Hours");
		jbHourSof.setBackground(Color.green);
		jbHourSof.setForeground(Color.blue);
		hpSof = new hourPanel1();
		JPanel hourSignOf = hpSof.getHourDisplayPanel();

		JButton jbMinuteSof = new JButton("Minutes");
		jbMinuteSof.setBackground(Color.green);
		jbMinuteSof.setForeground(Color.blue);
		mpSof = new minutePanel1();
		JPanel minuteSignOf = mpSof.getMinuteDisplayPanel();
	
		query = " Select NameDriver, PfNoDriver from Curronlined order by NameDriver";
		vectorDriver =cnv.getCrewNameList(url,query);
		ncbDriver = new nameComboBox();
		query = " Select NameDriver,PfNoDriver from Casualtyd where  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1)) = 'COACHING'"+
						" and casualtyover=0";
		vectorDriverCoaching =cnv.getCrewNameList(url,query);
		vectorDriver.addAll(vectorDriverCoaching);
		jcbDriverName = ncbDriver.namePanel(vectorDriver);
		jcbDriverName.setFont(f1);
		jcbDriverName.setPreferredSize(dim7);

		query = "Select NameAssistant, PfNoAssistant from Curronlinead order by NameAssistant";
		vectorAssistant =	cnv.getCrewNameList(url,query);
		ncbAssistant = new nameComboBox();
		query = "Select NameAssistant,PfNoAssistant from Casualtyad "+
						"where  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1)) = 'COACHING' and casualtyover=0";
		vectorAssistantCoaching =	cnv.getCrewNameList(url,query);
		vectorAssistant.addAll(vectorAssistantCoaching);
		jcbAssistantName = ncbAssistant.namePanel(vectorAssistant);
		jcbAssistantName.setFont(f1);
		jcbAssistantName.setPreferredSize(dim7);

		query = "Select NameGuard, PfNoGuard from CurronlineG order by NameGuard";
		vectorGuard =cnv.getCrewNameList(url,query);
		ncbGuard = new nameComboBox();
		query = "Select NameGuard, PfNoGuard from CasualtyG where  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1)) ='COACHING'"+
						" and casualtyover=0";
		vectorGuardCoaching =cnv.getCrewNameList(url,query);
		vectorGuard.addAll(vectorGuardCoaching);
		jcbGuardName = ncbGuard.namePanel(vectorGuard);
		jcbGuardName.setFont(f1);
		jcbGuardName.setPreferredSize(dim7);
/*
		select = "Select depot from depot";
		vector =	snv.getStationNameList("",select);
		depot = (String)(vector.elementAt(0));
*/
		jbSubmit = new JButton("SUBMIT");
		jbSubmit.setEnabled(false);
		jbSubmit.setForeground(Color.blue);
		jbSubmit.setBackground(Color.yellow);
		jbSubmit.setBackground(new Color(255,255,83));
		jbSubmit.setForeground(new Color(0,0,255));
		jbSubmit.setMnemonic('S');
		jbSubmit.setPreferredSize(dim8);

		jbEngineno = new JButton("Engine No");
		jbEngineno.setBackground(Color.green);
		jbEngineno.setForeground(Color.blue);
		jbEngineno.setPreferredSize(dim);
		jbEngineno.setFocusable(false);
		jbTrainno = new JButton("Train No");
		jbTrainno.setBackground(Color.green);
		jbTrainno.setForeground(Color.blue);
		jbTrainno.setPreferredSize(dim2);
		jbTrainno.setFocusable(false);
		jbService = new JButton("Service");
		jbService.setBackground(Color.green);
		jbService.setForeground(Color.blue);
		jbService.setPreferredSize(dim);
		jbService.setFocusable(false);
		jbSection = new JButton("Section");
		jbSection.setBackground(Color.green);
		jbSection.setForeground(Color.blue);
		jbSection.setPreferredSize(dim6);
		jbSection.setFocusable(false);
		jbFrom = new JButton("From");
		jbFrom.setBackground(Color.green);
		jbFrom.setForeground(Color.blue);
		jbFrom.setPreferredSize(dim1);
		jbFrom.setFocusable(false);
		jbFrom.setMargin(new Insets(0,0,0,0));
		jbTo = new JButton("To");
		jbTo.setBackground(Color.green);
		jbTo.setForeground(Color.blue);
		jbTo.setPreferredSize(dim1);
		jbTo.setFocusable(false);
		jbTo.setMargin(new Insets(0,0,0,0));
		jbSiding = new JButton("Siding");
		jbSiding.setBackground(Color.green);
		jbSiding.setForeground(Color.blue);
		jbSiding.setPreferredSize(dim5);
		jbSiding.setFocusable(false);
		jbSiding.setMargin(new Insets(0,0,0,0));
		jbLoad = new JButton("Load");
		jbLoad.setBackground(Color.green);
		jbLoad.setForeground(Color.blue);
		jbLoad.setPreferredSize(dim);
		jbLoad.setFocusable(false);
		jbTrainHrs = new JButton(" Dep ");
		jbTrainHrs.setBackground(Color.green);
		jbTrainHrs.setForeground(Color.blue);
		jbTrainHrs.setPreferredSize(dim1);
		jbTrainHrs.setFocusable(false);
		jbTrainHrs.setMargin(new Insets(0,0,0,0));
		jbEngineHrs = new JButton("  Arr  ");
		jbEngineHrs.setBackground(Color.green);
		jbEngineHrs.setForeground(Color.blue);
		jbEngineHrs.setPreferredSize(dim1);
		jbEngineHrs.setFocusable(false);
		jbEngineHrs.setMargin(new Insets(0,0,0,0));
		jbShuntingHrs = new JButton("Kms/Hrs");
		jbShuntingHrs.setBackground(Color.green);
		jbShuntingHrs.setForeground(Color.blue);
		jbShuntingHrs.setMargin(new Insets(0,0,0,0));
		jbShuntingHrs.setPreferredSize(dim1);
		jbShuntingHrs.setFocusable(false);
		jbShuntingHrs.setMargin(new Insets(0,0,0,0));

		try
		{
			select = " Select distinct stationname from lrstation order by stationname ";
			Vector vectorz = snv.getStationNameList("",select);
			ncbSection = new nameComboBox();
			jcbSection1 = ncbSection.namePanel(vectorz);
			jcbSection1.setPreferredSize(dim6);
			jcbSection2 = ncbSection.namePanel(vectorz);
			jcbSection2.setPreferredSize(dim6);
			jcbSection3 = ncbSection.namePanel(vectorz);
			jcbSection3.setPreferredSize(dim6);
			jcbSection4 = ncbSection.namePanel(vectorz);
			jcbSection4.setPreferredSize(dim6);
			jcbSection5 = ncbSection.namePanel(vectorz);
			jcbSection5.setPreferredSize(dim6);
			jcbSection6 = ncbSection.namePanel(vectorz);
			jcbSection6.setPreferredSize(dim6);
			jcbSection7 = ncbSection.namePanel(vectorz);
			jcbSection7.setPreferredSize(dim6);
			jcbSection8 = ncbSection.namePanel(vectorz);
			jcbSection8.setPreferredSize(dim6);
			jcbSection9 = ncbSection.namePanel(vectorz);
			jcbSection9.setPreferredSize(dim6);
			jcbSection10 = ncbSection.namePanel(vectorz);
			jcbSection10.setPreferredSize(dim6);
			jcbSection11 = ncbSection.namePanel(vectorz);
			jcbSection11.setPreferredSize(dim6);
			jcbSection12 = ncbSection.namePanel(vectorz);
			jcbSection12.setPreferredSize(dim6);
			jcbSection1.setFont(f1);
			jcbSection2.setFont(f1);
			jcbSection3.setFont(f1);
			jcbSection4.setFont(f1);
			jcbSection5.setFont(f1);
			jcbSection6.setFont(f1);
			jcbSection7.setFont(f1);
			jcbSection8.setFont(f1);
			jcbSection9.setFont(f1);
			jcbSection10.setFont(f1);
			jcbSection11.setFont(f1);
			jcbSection12.setFont(f1);

			select = " Select TrainNo from TrainNo";
			Vector vectorp = snv.getStationNameList("",select);
			ncbTrainno = new nameComboBox();
			jcbTrainno1 = ncbTrainno.namePanel(vectorp);
			jcbTrainno1.setPreferredSize(dim2);
			ncbTrainno.editSet();
			jcbTrainno2 = ncbTrainno.namePanel(vectorp);
			jcbTrainno2.setPreferredSize(dim2);
			ncbTrainno.editSet();
			jcbTrainno3 = ncbTrainno.namePanel(vectorp);
			jcbTrainno3.setPreferredSize(dim2);
			ncbTrainno.editSet();
			jcbTrainno4 = ncbTrainno.namePanel(vectorp);
			jcbTrainno4.setPreferredSize(dim2);
			ncbTrainno.editSet();								
			jcbTrainno5 = ncbTrainno.namePanel(vectorp);
			jcbTrainno5.setPreferredSize(dim2);
			ncbTrainno.editSet();
			jcbTrainno6 = ncbTrainno.namePanel(vectorp);
			jcbTrainno6.setPreferredSize(dim2);
			ncbTrainno.editSet();		
			jcbTrainno7 = ncbTrainno.namePanel(vectorp);
			jcbTrainno7.setPreferredSize(dim2);
			ncbTrainno.editSet();		
			jcbTrainno8 = ncbTrainno.namePanel(vectorp);
			jcbTrainno8.setPreferredSize(dim2);
			ncbTrainno.editSet();
			jcbTrainno9 = ncbTrainno.namePanel(vectorp);
			jcbTrainno9.setPreferredSize(dim2);
			ncbTrainno.editSet();
			jcbTrainno10 = ncbTrainno.namePanel(vectorp);
			jcbTrainno10.setPreferredSize(dim2);
			ncbTrainno.editSet();
			jcbTrainno11 = ncbTrainno.namePanel(vectorp);
			jcbTrainno11.setPreferredSize(dim2);
			ncbTrainno.editSet();								
			jcbTrainno12 = ncbTrainno.namePanel(vectorp);
			jcbTrainno12.setPreferredSize(dim2);
			ncbTrainno.editSet();		

			jbService1 = new JButton("Service");
			jbService1.setBackground(Color.green);
			jbService1.setForeground(Color.blue);
			jbService1.setFocusable(false);
//			vector.removeAllElements();
//			vector.trimToSize();
			select = " Select Service from Service order by service";
			Vector vectorx = snv.getStationNameList("",select);
			ncbService = new nameComboBox();
			jcbService = ncbService.namePanel(vectorx);
			jcbService.setPreferredSize(dim);
			jcbService1 = ncbService.namePanel(vectorx);
			jcbService1.setPreferredSize(dim);
			jcbService2 = ncbService.namePanel(vectorx);
			jcbService2.setPreferredSize(dim);
			jcbService3 = ncbService.namePanel(vectorx);
			jcbService3.setPreferredSize(dim);
			jcbService4 = ncbService.namePanel(vectorx);
			jcbService4.setPreferredSize(dim);
			jcbService5 = ncbService.namePanel(vectorx);
			jcbService5.setPreferredSize(dim);
			jcbService6 = ncbService.namePanel(vectorx);
			jcbService6.setPreferredSize(dim);
			jcbService7 = ncbService.namePanel(vectorx);
			jcbService7.setPreferredSize(dim);
			jcbService8 = ncbService.namePanel(vectorx);
			jcbService8.setPreferredSize(dim);
			jcbService9 = ncbService.namePanel(vectorx);
			jcbService9.setPreferredSize(dim);
			jcbService10 = ncbService.namePanel(vectorx);
			jcbService10.setPreferredSize(dim);
			jcbService11 = ncbService.namePanel(vectorx);
			jcbService11.setPreferredSize(dim);
			jcbService12 = ncbService.namePanel(vectorx);
			jcbService12.setPreferredSize(dim);
			jcbService1.setFont(f1);
			jcbService2.setFont(f1);
			jcbService3.setFont(f1);
			jcbService4.setFont(f1);
			jcbService5.setFont(f1);
			jcbService6.setFont(f1);
			jcbService7.setFont(f1);
			jcbService8.setFont(f1);
			jcbService9.setFont(f1);
			jcbService10.setFont(f1);
			jcbService11.setFont(f1);
			jcbService12.setFont(f1);

//			vector.removeAllElements();
//			vector.trimToSize();
			select = " Select DISTINCT Sta_name from Kms ORDER BY STA_NAME";
			Vector vectory = snv.getStationNameList("",select);
			ncbFrom = new nameComboBox();
			jcbFrom1 = ncbFrom.namePanel(vectory);
			jcbFrom1.setPreferredSize(dim1);
			jcbFrom2 = ncbFrom.namePanel(vectory);
			jcbFrom2.setPreferredSize(dim1);
			jcbFrom3 = ncbFrom.namePanel(vectory);
			jcbFrom3.setPreferredSize(dim1);
			jcbFrom4 = ncbFrom.namePanel(vectory);
			jcbFrom4.setPreferredSize(dim1);
			jcbFrom5 = ncbFrom.namePanel(vectory);
			jcbFrom5.setPreferredSize(dim1);
			jcbFrom6 = ncbFrom.namePanel(vectory);
			jcbFrom6.setPreferredSize(dim1);
			jcbFrom7 = ncbFrom.namePanel(vectory);
			jcbFrom7.setPreferredSize(dim1);
			jcbFrom8 = ncbFrom.namePanel(vectory);
			jcbFrom8.setPreferredSize(dim1);
			jcbFrom9 = ncbFrom.namePanel(vectory);
			jcbFrom9.setPreferredSize(dim1);
			jcbFrom10 = ncbFrom.namePanel(vectory);
			jcbFrom10.setPreferredSize(dim1);
			jcbFrom11 = ncbFrom.namePanel(vectory);
			jcbFrom11.setPreferredSize(dim1);
			jcbFrom12 = ncbFrom.namePanel(vectory);
			jcbFrom12.setPreferredSize(dim1);
			jcbFrom1.setFont(f1);
			jcbFrom2.setFont(f1);
			jcbFrom3.setFont(f1);
			jcbFrom4.setFont(f1);
			jcbFrom5.setFont(f1);
			jcbFrom6.setFont(f1);
			jcbFrom7.setFont(f1);
			jcbFrom8.setFont(f1);
			jcbFrom9.setFont(f1);
			jcbFrom10.setFont(f1);
			jcbFrom11.setFont(f1);
			jcbFrom12.setFont(f1);

			ncbTo = new nameComboBox();
			jcbTo1 = ncbTo.namePanel(vectory);
			jcbTo1.setPreferredSize(dim1);
			jcbTo2 = ncbTo.namePanel(vectory);
			jcbTo2.setPreferredSize(dim1);
			jcbTo3 = ncbTo.namePanel(vectory);
			jcbTo3.setPreferredSize(dim1);
			jcbTo4 = ncbTo.namePanel(vectory);
			jcbTo4.setPreferredSize(dim1);
			jcbTo5 = ncbTo.namePanel(vectory);
			jcbTo5.setPreferredSize(dim1);
			jcbTo6 = ncbTo.namePanel(vectory);
			jcbTo6.setPreferredSize(dim1);
			jcbTo7 = ncbTo.namePanel(vectory);
			jcbTo7.setPreferredSize(dim1);
			jcbTo8 = ncbTo.namePanel(vectory);
			jcbTo8.setPreferredSize(dim1);
			jcbTo9 = ncbTo.namePanel(vectory);
			jcbTo9.setPreferredSize(dim1);
			jcbTo10 = ncbTo.namePanel(vectory);
			jcbTo10.setPreferredSize(dim1);
			jcbTo11 = ncbTo.namePanel(vectory);
			jcbTo11.setPreferredSize(dim1);
			jcbTo12 = ncbTo.namePanel(vectory);
			jcbTo12.setPreferredSize(dim1);
			jcbTo1.setFont(f1);
			jcbTo2.setFont(f1);
			jcbTo3.setFont(f1);
			jcbTo4.setFont(f1);
			jcbTo5.setFont(f1);
			jcbTo6.setFont(f1);
			jcbTo7.setFont(f1);
			jcbTo8.setFont(f1);
			jcbTo9.setFont(f1);
			jcbTo10.setFont(f1);
			jcbTo11.setFont(f1);
			jcbTo12.setFont(f1);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		jftfLoco1 = new	JFormattedTextField(mf1);
		jftfLoco2 = new	JFormattedTextField(mf1);
		jftfLoco3 = new	JFormattedTextField(mf1);
		jftfLoco4 = new	JFormattedTextField(mf1);
		jftfLoco5 = new	JFormattedTextField(mf1);
		jftfLoco6 = new	JFormattedTextField(mf1);
		jftfLoco7 = new	JFormattedTextField(mf1);
		jftfLoco8 = new	JFormattedTextField(mf1);
		jftfLoco9 = new	JFormattedTextField(mf1);
		jftfLoco10 = new	JFormattedTextField(mf1);
		jftfLoco11 = new	JFormattedTextField(mf1);
		jftfLoco12 = new	JFormattedTextField(mf1);
		jftfLoco1.setPreferredSize(dim);
		jftfLoco2.setPreferredSize(dim);
		jftfLoco3.setPreferredSize(dim);
		jftfLoco4.setPreferredSize(dim);
		jftfLoco5.setPreferredSize(dim);
		jftfLoco6.setPreferredSize(dim);
		jftfLoco7.setPreferredSize(dim);
		jftfLoco8.setPreferredSize(dim);
		jftfLoco9.setPreferredSize(dim);
		jftfLoco10.setPreferredSize(dim);
		jftfLoco11.setPreferredSize(dim);
		jftfLoco12.setPreferredSize(dim);
		jftfLoco1.setFont(f1);
		jftfLoco2.setFont(f1);
		jftfLoco3.setFont(f1);
		jftfLoco4.setFont(f1);
		jftfLoco5.setFont(f1);
		jftfLoco6.setFont(f1);
		jftfLoco7.setFont(f1);
		jftfLoco8.setFont(f1);
		jftfLoco9.setFont(f1);
		jftfLoco10.setFont(f1);
		jftfLoco11.setFont(f1);
		jftfLoco12.setFont(f1);

		jftfLoad1 = new JFormattedTextField(mf2);
		jftfLoad1.setPreferredSize(dim);
		jftfLoad1.setBackground(Color.white);
		jftfLoad1.setEditable(true);
		jftfLoad1.setValue("00+0/000/0000");
		jftfLoad2 = new JFormattedTextField(mf2); 
		jftfLoad2.setPreferredSize(dim);
		jftfLoad2.setBackground(Color.white);
		jftfLoad2.setEditable(true);
		jftfLoad2.setValue("00+0/000/0000");
		jftfLoad3 = new JFormattedTextField(mf2); 
		jftfLoad3.setPreferredSize(dim);
		jftfLoad3.setBackground(Color.white);
		jftfLoad3.setEditable(true);
		jftfLoad3.setValue("00+0/000/0000");
		jftfLoad4 = new JFormattedTextField(mf2); 
		jftfLoad4.setPreferredSize(dim);
		jftfLoad4.setEditable(true);
		jftfLoad4.setBackground(Color.white);
		jftfLoad4.setValue("00+0/000/0000");
		jftfLoad5 = new JFormattedTextField(mf2); 
		jftfLoad5.setPreferredSize(dim);
		jftfLoad5.setBackground(Color.white);
		jftfLoad5.setEditable(true);
		jftfLoad5.setValue("00+0/000/0000");
		jftfLoad6 = new JFormattedTextField(mf2); 
		jftfLoad6.setPreferredSize(dim);
		jftfLoad6.setBackground(Color.white);
		jftfLoad6.setEditable(true);
		jftfLoad6.setValue("00+0/000/0000");
		jftfLoad7 = new JFormattedTextField(mf2); 
		jftfLoad7.setPreferredSize(dim);
		jftfLoad7.setBackground(Color.white);
		jftfLoad7.setEditable(true);
		jftfLoad7.setValue("00+0/000/0000");
		jftfLoad8 = new JFormattedTextField(mf2); 
		jftfLoad8.setPreferredSize(dim);
		jftfLoad8.setBackground(Color.white);
		jftfLoad8.setEditable(true);
		jftfLoad8.setValue("00+0/000/0000");
		jftfLoad9 = new JFormattedTextField(mf2); 
		jftfLoad9.setPreferredSize(dim);
		jftfLoad9.setBackground(Color.white);
		jftfLoad9.setEditable(true);
		jftfLoad9.setValue("00+0/000/0000");
		jftfLoad10 = new JFormattedTextField(mf2); 
		jftfLoad10.setPreferredSize(dim);
		jftfLoad10.setBackground(Color.white);
		jftfLoad10.setEditable(true);
		jftfLoad10.setValue("00+0/000/0000");
		jftfLoad11 = new JFormattedTextField(mf2); 
		jftfLoad11.setPreferredSize(dim);
		jftfLoad11.setBackground(Color.white);
		jftfLoad11.setEditable(true);
		jftfLoad11.setValue("00+0/000/0000");
		jftfLoad12 = new JFormattedTextField(mf2); 
		jftfLoad12.setPreferredSize(dim);
		jftfLoad12.setBackground(Color.white);
		jftfLoad12.setEditable(true);
		jftfLoad12.setValue("00+0/000/0000");
		jftfLoad1.setFont(f1);
		jftfLoad2.setFont(f1);
		jftfLoad3.setFont(f1);
		jftfLoad4.setFont(f1);
		jftfLoad5.setFont(f1);
		jftfLoad6.setFont(f1);
		jftfLoad7.setFont(f1);
		jftfLoad8.setFont(f1);
		jftfLoad9.setFont(f1);
		jftfLoad10.setFont(f1);
		jftfLoad11.setFont(f1);
		jftfLoad12.setFont(f1);

		select = " Select xtime from times order by xtime";
		Vector vectorTime = snv.getStationNameList("",select);
		ncbDep1 = new nameComboBox();
		ncbArr1 = new nameComboBox();
		ncbDep2 = new nameComboBox();
		ncbArr2 = new nameComboBox();
		ncbDep3 = new nameComboBox();
		ncbArr3 = new nameComboBox();
		ncbDep4 = new nameComboBox();
		ncbArr4 = new nameComboBox();
		ncbDep5 = new nameComboBox();
		ncbArr5 = new nameComboBox();
		ncbDep6 = new nameComboBox();
		ncbArr6 = new nameComboBox();
		ncbDep7 = new nameComboBox();
		ncbArr7 = new nameComboBox();
		ncbDep8= new nameComboBox();
		ncbArr8 = new nameComboBox();
		ncbDep9 = new nameComboBox();
		ncbArr9 = new nameComboBox();
		ncbDep10 = new nameComboBox();
		ncbArr10 = new nameComboBox();
		ncbDep11 = new nameComboBox();
		ncbArr11 = new nameComboBox();
		ncbDep12 = new nameComboBox();
		ncbArr12 = new nameComboBox();
		jcbDep1 = ncbDep1.namePanel(vectorTime);
		jcbDep1.setPreferredSize(dim9);
		jcbDep1.setBackground(Color.white);
		jcbArr1 = ncbArr1.namePanel(vectorTime);
		jcbArr1.setPreferredSize(dim9);
		jcbArr1.setBackground(Color.white);
		jcbDep2 = ncbDep2.namePanel(vectorTime);
		jcbDep2.setPreferredSize(dim9);
		jcbDep2.setBackground(Color.white);
		jcbArr2 = ncbArr2.namePanel(vectorTime);
		jcbArr2.setPreferredSize(dim9);
		jcbArr2.setBackground(Color.white);
		jcbDep3 = ncbDep3.namePanel(vectorTime);
		jcbDep3.setPreferredSize(dim9);
		jcbDep3.setBackground(Color.white);
		jcbArr3 = ncbArr3.namePanel(vectorTime);
		jcbArr3.setPreferredSize(dim9);
		jcbArr3.setBackground(Color.white);
		jcbDep4 = ncbDep4.namePanel(vectorTime);
		jcbDep4.setPreferredSize(dim9);
		jcbDep4.setBackground(Color.white);
		jcbArr4 = ncbArr4.namePanel(vectorTime);
		jcbArr4.setPreferredSize(dim9);
		jcbArr4.setBackground(Color.white);
		jcbDep5 = ncbDep5.namePanel(vectorTime);
		jcbDep5.setPreferredSize(dim9);
		jcbDep5.setBackground(Color.white);
		jcbArr5 = ncbArr5.namePanel(vectorTime);
		jcbArr5.setPreferredSize(dim9);
		jcbArr5.setBackground(Color.white);
		jcbDep6 = ncbDep6.namePanel(vectorTime);
		jcbDep6.setPreferredSize(dim9);
		jcbDep6.setBackground(Color.white);
		jcbArr6 = ncbArr6.namePanel(vectorTime);
		jcbArr6.setPreferredSize(dim9);
		jcbArr6.setBackground(Color.white);
		jcbDep7 = ncbDep7.namePanel(vectorTime);
		jcbDep7.setPreferredSize(dim9);
		jcbDep7.setBackground(Color.white);
		jcbArr7 = ncbArr7.namePanel(vectorTime);
		jcbArr7.setPreferredSize(dim9);
		jcbArr7.setBackground(Color.white);
		jcbDep8 = ncbDep8.namePanel(vectorTime);
		jcbDep8.setPreferredSize(dim9);
		jcbDep8.setBackground(Color.white);
		jcbArr8 = ncbArr8.namePanel(vectorTime);
		jcbArr8.setPreferredSize(dim9);
		jcbArr8.setBackground(Color.white);
		jcbDep9 = ncbDep9.namePanel(vectorTime);
		jcbDep9.setPreferredSize(dim9);
		jcbDep9.setBackground(Color.white);
		jcbArr9 = ncbArr9.namePanel(vectorTime);
		jcbArr9.setPreferredSize(dim9);
		jcbArr9.setBackground(Color.white);
		jcbDep10 = ncbDep10.namePanel(vectorTime);
		jcbDep10.setPreferredSize(dim9);
		jcbDep10.setBackground(Color.white);
		jcbArr10 = ncbArr10.namePanel(vectorTime);
		jcbArr10.setPreferredSize(dim9);
		jcbArr10.setBackground(Color.white);
		jcbDep11 = ncbDep11.namePanel(vectorTime);
		jcbDep11.setPreferredSize(dim9);
		jcbDep11.setBackground(Color.white);
		jcbArr11 = ncbArr11.namePanel(vectorTime);
		jcbArr11.setPreferredSize(dim9);
		jcbArr11.setBackground(Color.white);
		jcbDep12 = ncbDep12.namePanel(vectorTime);
		jcbDep12.setPreferredSize(dim9);
		jcbDep12.setBackground(Color.white);
		jcbArr12 = ncbArr12.namePanel(vectorTime);
		jcbArr12.setPreferredSize(dim1);
		jcbArr12.setBackground(Color.white);
				jcbDep1.setFont(f1);
			jcbDep2.setFont(f1);
			jcbDep3.setFont(f1);
			jcbDep4.setFont(f1);
			jcbDep5.setFont(f1);
			jcbDep6.setFont(f1);
			jcbDep7.setFont(f1);
			jcbDep8.setFont(f1);
			jcbDep9.setFont(f1);
			jcbDep10.setFont(f1);
			jcbDep11.setFont(f1);
			jcbDep12.setFont(f1);
			jcbArr1.setFont(f1);
			jcbArr2.setFont(f1);
			jcbArr3.setFont(f1);
			jcbArr4.setFont(f1);
			jcbArr5.setFont(f1);
			jcbArr6.setFont(f1);
			jcbArr7.setFont(f1);
			jcbArr8.setFont(f1);
			jcbArr9.setFont(f1);
			jcbArr10.setFont(f1);
			jcbArr11.setFont(f1);
			jcbArr12.setFont(f1);


//		vector.removeAllElements();
//		vector.trimToSize();
		select = " Select DISTINCT name from Sidings order by name";
		Vector vectors = snv.getStationNameList("",select);
		ncbSiding = new nameComboBox();
		jcbSiding1 = ncbSiding.namePanel(vectors);
		jcbSiding1.setPreferredSize(dim5);
		jcbSiding2 = ncbSiding.namePanel(vectors);
		jcbSiding2.setPreferredSize(dim5);
		jcbSiding3 = ncbSiding.namePanel(vectors);
		jcbSiding3.setPreferredSize(dim5);
		jcbSiding4 = ncbSiding.namePanel(vectors);
		jcbSiding4.setPreferredSize(dim5);
		jcbSiding5 = ncbSiding.namePanel(vectors);
		jcbSiding5.setPreferredSize(dim5);
		jcbSiding6 = ncbSiding.namePanel(vectors);
		jcbSiding6.setPreferredSize(dim5);
		jcbSiding7 = ncbSiding.namePanel(vectors);
		jcbSiding7.setPreferredSize(dim5);
		jcbSiding8 = ncbSiding.namePanel(vectors);
		jcbSiding8.setPreferredSize(dim5);
		jcbSiding9 = ncbSiding.namePanel(vectors);
		jcbSiding9.setPreferredSize(dim5);
		jcbSiding10 = ncbSiding.namePanel(vectors);
		jcbSiding10.setPreferredSize(dim5);
		jcbSiding11 = ncbSiding.namePanel(vectors);
		jcbSiding11.setPreferredSize(dim5);
		jcbSiding12 = ncbSiding.namePanel(vectors);
		jcbSiding12.setPreferredSize(dim5);
		jcbSiding1.setFont(f1);
		jcbSiding2.setFont(f1);
		jcbSiding3.setFont(f1);
		jcbSiding4.setFont(f1);
		jcbSiding5.setFont(f1);
		jcbSiding6.setFont(f1);
		jcbSiding7.setFont(f1);
		jcbSiding8.setFont(f1);
		jcbSiding9.setFont(f1);
		jcbSiding10.setFont(f1);
		jcbSiding11.setFont(f1);
		jcbSiding12.setFont(f1);

//		cbcHandicap = new checkBoxCrew();
//		JPanel cbHandicap = cbcHandicap.getCBPanel("Handi");
		jcHandicap = new JCheckBox("Handi");		
		jcHandicap.setBackground(new Color(252,189,253));
		jcHandicap.setMargin(new Insets(0,0,0,0));
		jcContinuous = new JCheckBox("Continue",false);
		jcContinuous.setBackground(new Color(252,189,253));
		jcContinuous.setMargin(new Insets(0,0,0,0));		
		jcNRRA = new JCheckBox("NRRA",false);		
		jcNRRA.setBackground(new Color(252,189,253));
		jcNRRA.setMargin(new Insets(0,0,0,0));
		jcNCA = new JCheckBox("NCA",false);
		jcNCA.setBackground(new Color(252,189,253));
		jcNCA.setMargin(new Insets(0,0,0,0));	
		
/*		jcVia = new JCheckBox("Via",false);
		jcVia.setBackground(new Color(252,189,253));
		jcVia.setMargin(new Insets(0,0,0,0));
*/		
		GridBagLayout gbTop = new GridBagLayout();
	    GridBagConstraints c = new GridBagConstraints();
		panel1 = new JPanel();
		panel1.setBackground(new Color(0,128,128));
		panel1.setLayout(gbTop);

		c.fill = GridBagConstraints.NONE;
		c.gridwidth = GridBagConstraints.REMAINDER;
		GridBagLayout gbRBG = new GridBagLayout();
	    GridBagConstraints cRBG = new GridBagConstraints();
		JPanel panelRBG = new JPanel();
		panelRBG.setBackground(new Color(252,189,253));
		panelRBG.setLayout(gbRBG);
		panelRBG.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		jrbDriver = new JRadioButton("OnlyDriver",false);
		jrbDriver.setBackground(new Color(252,189,253));
		jrbDriver.setForeground(Color.blue);
		jrbDriver.setActionCommand("DRIVER");
//		jrbDriver.setFont(f1);
		jrbAssistant = new JRadioButton("OnlyAssistant");
		jrbAssistant.setBackground(new Color(252,189,253));
		jrbAssistant.setForeground(Color.blue);
		jrbAssistant.setActionCommand("ASSISTANT");
//		jrbAssistant.setFont(f1);
		jrbGuard = new JRadioButton("OnlyGuard");
		jrbGuard.setBackground(new Color(252,189,253));
		jrbGuard.setForeground(Color.blue);
		jrbGuard.setActionCommand("GUARD");
//		jrbGuard.setFont(f1);
		jrbWithoutGuard = new JRadioButton("WithoutGuard");
		jrbWithoutGuard.setBackground(new Color(252,189,253));
		jrbWithoutGuard.setForeground(Color.blue);
		jrbWithoutGuard.setActionCommand("WITHOUTGUARD");
//		jrbWithoutGuard.setFont(f1);
		jrbWithGuard = new JRadioButton("WithGuard",true);
		jrbWithGuard.setBackground(new Color(252,189,253));
		jrbWithGuard.setForeground(Color.blue);
		jrbWithGuard.setActionCommand("WITHGUARD");
//		jrbWithGuard.setFont(f1);
		group = new ButtonGroup();
		group.add(jrbDriver);
		group.add(jrbAssistant);
		group.add(jrbGuard);
		group.add(jrbWithoutGuard);
		group.add(jrbWithGuard);

		JPanel jpRadio = new JPanel();
		jpRadio.setBackground(new Color(252,189,253));
		jpRadio.add(jrbDriver);
		jpRadio.add(jrbAssistant);
		jpRadio.add(jrbGuard);
		jpRadio.add(jrbWithoutGuard);
		jpRadio.add(jrbWithGuard);
		gbRBG.setConstraints(jpRadio,cRBG);
		panelRBG.add(jpRadio);
		jbShow = new JButton("Show Crew");
//		jbShow.setFont(f2);
		jbShow.setBackground(new Color(255,255,83));
		jbShow.setForeground(new Color(0,0,255));
		jbShow.setPreferredSize(dim8);
		jbShow.setMnemonic('C');
		cRBG.gridwidth = GridBagConstraints.REMAINDER;
		gbRBG.setConstraints(jbShow,cRBG);
		panelRBG.add(jbShow);

		c.gridwidth = 1;
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gbTop.setConstraints(panelRBG,c);
		panel1.add(panelRBG);
//		gbTop.setConstraints(jpRadio,c);
//		panel1.add(jpRadio);
//		c.gridwidth = GridBagConstraints.REMAINDER;
//		c.fill = GridBagConstraints.NONE;
//		gbTop.setConstraints(jbShow,c);
//		panel1.add(jbShow);

		panelDriver = new JPanel();
		panelDriver.setBackground(new Color(252,189,253));
		panelDriver.setLayout(new BorderLayout());

		panelDriver.add(jbTitleD, BorderLayout.WEST);
//		panelDriverName = new JPanel();
		panelDriver.setBackground(new Color(252,189,253));
		panelDriver.add(jcbDriverName);
//		panelDriver.add(panelDriverName, BorderLayout.EAST);

		panelAssistant = new JPanel();
		panelAssistant.setBackground(new Color(252,189,253));
		panelAssistant.setLayout(new BorderLayout());

		panelAssistant.add(jbTitleAD, BorderLayout.WEST);
//		panelAssistantName = new JPanel();
		panelAssistant.setBackground(new Color(252,189,253));
		panelAssistant.add(jcbAssistantName);
//		panelAssistant.add(panelAssistantName, BorderLayout.EAST);

		panelGuard = new JPanel();
		panelGuard.setBackground(new Color(252,189,253));
		panelGuard.setLayout(new BorderLayout());

		panelGuard.add(jbTitleG, BorderLayout.WEST);
//		panelGuardName = new JPanel();
		panelGuard.setBackground(new Color(252,189,253));
		panelGuard.add(jcbGuardName);
//		panelGuard.add(panelGuardName, BorderLayout.EAST);

		panelCrew = new JPanel();
		panelCrew.setBackground(new Color(252,189,253));
		GridBagLayout gbCrew = new GridBagLayout();
		GridBagConstraints gbcCrew = new GridBagConstraints();
		panelCrew.setLayout(gbCrew);
		gbcCrew.gridwidth = 1;
		gbcCrew.fill= GridBagConstraints.NONE;
		gbCrew.setConstraints(panelDriver,gbcCrew);
		panelCrew.add(panelDriver);
		gbCrew.setConstraints(panelAssistant,gbcCrew);
		panelCrew.add(panelAssistant);
		gbcCrew.gridwidth = GridBagConstraints.REMAINDER;
		gbCrew.setConstraints(panelGuard,gbcCrew);
		panelCrew.add(panelGuard);

		gbTop.setConstraints(panelCrew,c);
		panel1.add(panelCrew);
		GridBagLayout gbStats = new GridBagLayout();
		GridBagConstraints cStats = new GridBagConstraints();
		panel4 = new JPanel();
		panel4.setBackground(new Color(252,189,253));
		panel4.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panel4.setLayout(gbStats);

		cStats.fill = GridBagConstraints.VERTICAL;
		cStats.gridwidth = 1;
		gbStats.setConstraints(jbCtrNo,cStats);
		panel4.add(jbCtrNo);
		gbStats.setConstraints(jtfCtrNo,cStats);
		panel4.add(jtfCtrNo);
/*		gbStats.setConstraints(jbVHF,cStats);
		panel4.add(jbVHF);
		gbStats.setConstraints(jtfVHF,cStats);
		panel4.add(jtfVHF);
		gbStats.setConstraints(jbPTPhone,cStats);
		panel4.add(jbPTPhone);
		gbStats.setConstraints(jtfPTPhone,cStats);
		panel4.add(jtfPTPhone);
*/		gbStats.setConstraints(jbService1,cStats);
		panel4.add(jbService1);
    gbStats.setConstraints(jcbService,cStats);
		panel4.add(jcbService);
		gbStats.setConstraints(jbShunting,cStats);
		panel4.add(jbShunting);
		gbStats.setConstraints(jtfShunting,cStats);
		panel4.add(jtfShunting);
		gbStats.setConstraints(jcHandicap,cStats);
		panel4.add(jcHandicap);
//		cStats.gridwidth = GridBagConstraints.REMAINDER;
		gbStats.setConstraints(jcContinuous,cStats);
		panel4.add(jcContinuous);
//		cStats.gridwidth = GridBagConstraints.REMAINDER;
		gbStats.setConstraints(jcNRRA,cStats);
		panel4.add(jcNRRA);
		gbStats.setConstraints(jcNCA,cStats);
		panel4.add(jcNCA);
		gbStats.setConstraints(jbSDA,cStats);
		panel4.add(jbSDA);
		cStats.gridwidth = GridBagConstraints.REMAINDER;
		gbStats.setConstraints(jtfSDA,cStats);
		panel4.add(jtfSDA);
/*		cStats.gridwidth = GridBagConstraints.REMAINDER;
		gbStats.setConstraints(jcVia,cStats);
		panel4.add(jcVia);
*/
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gbTop.setConstraints(panel4,c);
		panel1.add(panel4);

		GridBagLayout gbSignOn = new GridBagLayout();
		GridBagConstraints cSignOn = new GridBagConstraints();
		panel5 = new JPanel();
		panel5.setBackground(new Color(252,189,253));
		panel5.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panel5.setLayout(gbSignOn);
//		panel5.setMargin(new Insets(0,0,0,0));

		jpSignD = new JPanel();
//		jpSignD.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		jpSignD.setBackground(new Color(252,189,253));
//		jpSignD.setMargin(new Insets(0,0,0,0));
		jpSignD.add(jbTitleD1);
		jpSignD.add(dateDriver);
		jpSignD.add(hourDriver);
		jpSignD.add(minuteDriver);

		jpSignG = new JPanel();
//		jpSignG.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		jpSignG.setBackground(new Color(252,189,253));
//		jpSignG.setMargin(new Insets(0,0,0,0));
		jpSignG.add(jbTitleG1);
		jpSignG.add(dateGuard);
		jpSignG.add(hourGuard);
		jpSignG.add(minuteGuard);

		jpSignAD = new JPanel();
//		jpSignAD.setBorder(new EtchedBorder(EtchedBorder.RAISED));
//		jpSignAD.setMargin(new Insets(0,0,0,0));
		jpSignAD.setBackground(new Color(252,189,253));
		jpSignAD.add(jbTitleAD1);
		jpSignAD.add(dateAssistant);
		jpSignAD.add(hourAssistant);
		jpSignAD.add(minuteAssistant);

		jpSignArrl = new JPanel();
//		jpSignAD.setBorder(new EtchedBorder(EtchedBorder.RAISED));
//		jpSignAD.setMargin(new Insets(0,0,0,0));
		jpSignArrl.setBackground(new Color(252,189,253));
		jpSignArrl.add(jbTitleArrl);
		jpSignArrl.add(dateArrival);
		jpSignArrl.add(hourArrival);
		jpSignArrl.add(minuteArrival);

		cSignOn.gridwidth = 1;
		gbSignOn.setConstraints(jpSignD,cSignOn);
		panel5.add(jpSignD);
		cSignOn.gridwidth = GridBagConstraints.REMAINDER;
		gbSignOn.setConstraints(jpSignAD,cSignOn);
		panel5.add(jpSignAD);
		cSignOn.gridwidth = 1;
		gbSignOn.setConstraints(jpSignG,cSignOn);
		panel5.add(jpSignG);
		cSignOn.gridwidth = GridBagConstraints.REMAINDER;
		gbSignOn.setConstraints(jpSignArrl,cSignOn);
		panel5.add(jpSignArrl);
		panel5.setVisible(true);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gbTop.setConstraints(panel5,c);
		panel1.add(panel5);
/*		
		GridBagLayout gbService = new GridBagLayout();
		GridBagConstraints cService = new GridBagConstraints();
		JPanel jpService = new JPanel();
		jpService.setBackground(new Color(252,189,253));
		jpService.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		jpService.setLayout(gbService);
		cService.gridwidth = 1;
    gbService.setConstraints(jbService1,cService);
		jpService.add(jbService1);
		cService.gridwidth = GridBagConstraints.REMAINDER;
    gbService.setConstraints(jcbService,cService);
		jpService.add(jcbService);

		c.fill = GridBagConstraints.NONE;
		c.gridwidth = GridBagConstraints.REMAINDER;
		gbTop.setConstraints(jpService,c);
		panel1.add(jpService);
*/
		GridBagLayout gbtrain  = new GridBagLayout();
		GridBagConstraints ctrain = new GridBagConstraints();
		jpTrain = new JPanel();
		jpTrain.setBackground(new Color(252,189,253));
		jpTrain.setLayout(gbtrain);
		jpTrain.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jbEngineno,ctrain);
		jpTrain.add(jbEngineno); 
		gbtrain.setConstraints(jbTrainno,ctrain);
		jpTrain.add(jbTrainno);
		gbtrain.setConstraints(jbService,ctrain);
		jpTrain.add(jbService);
		gbtrain.setConstraints(jbSection,ctrain);
		jpTrain.add(jbSection);
		gbtrain.setConstraints(jbFrom,ctrain);
		jpTrain.add(jbFrom);
		gbtrain.setConstraints(jbTo,ctrain);
		jpTrain.add(jbTo);
		gbtrain.setConstraints(jbSiding,ctrain);
		jpTrain.add(jbSiding);
		gbtrain.setConstraints(jbLoad,ctrain);
		jpTrain.add(jbLoad);
		gbtrain.setConstraints(jbTrainHrs,ctrain);
		jpTrain.add(jbTrainHrs);
		gbtrain.setConstraints(jbEngineHrs,ctrain);
		jpTrain.add(jbEngineHrs);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(jbShuntingHrs,ctrain);
		jpTrain.add(jbShuntingHrs);

		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco1,ctrain);
		jpTrain.add(jftfLoco1); 
		gbtrain.setConstraints(jcbTrainno1,ctrain);
		jpTrain.add(jcbTrainno1);
		gbtrain.setConstraints(jcbService1,ctrain);
		jpTrain.add(jcbService1);
		gbtrain.setConstraints(jcbSection1,ctrain);
		jpTrain.add(jcbSection1);
		gbtrain.setConstraints(jcbFrom1,ctrain);
		jpTrain.add(jcbFrom1);
		gbtrain.setConstraints(jcbTo1,ctrain);
		jpTrain.add(jcbTo1);
		gbtrain.setConstraints(jcbSiding1,ctrain);
		jpTrain.add(jcbSiding1);
		gbtrain.setConstraints(jftfLoad1,ctrain);
		jpTrain.add(jftfLoad1);
		gbtrain.setConstraints(jcbDep1,ctrain);
		jpTrain.add(jcbDep1);
		gbtrain.setConstraints(jcbArr1,ctrain);
		jpTrain.add(jcbArr1);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label1,ctrain);
		jpTrain.add(label1);
		
		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco2,ctrain);
		jpTrain.add(jftfLoco2); 
		gbtrain.setConstraints(jcbTrainno2,ctrain);
		jpTrain.add(jcbTrainno2);
		gbtrain.setConstraints(jcbService2,ctrain);
		jpTrain.add(jcbService2);
		gbtrain.setConstraints(jcbSection2,ctrain);
		jpTrain.add(jcbSection2);
		gbtrain.setConstraints(jcbFrom2,ctrain);
		jpTrain.add(jcbFrom2);
		gbtrain.setConstraints(jcbTo2,ctrain);
		jpTrain.add(jcbTo2);
		gbtrain.setConstraints(jcbSiding2,ctrain);
		jpTrain.add(jcbSiding2);
		gbtrain.setConstraints(jftfLoad2,ctrain);
		jpTrain.add(jftfLoad2);
		gbtrain.setConstraints(jcbDep2,ctrain);
		jpTrain.add(jcbDep2);
		gbtrain.setConstraints(jcbArr2,ctrain);
		jpTrain.add(jcbArr2);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label2,ctrain);
		jpTrain.add(label2);

		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco3,ctrain);
		jpTrain.add(jftfLoco3); 
		gbtrain.setConstraints(jcbTrainno3,ctrain);
		jpTrain.add(jcbTrainno3);
		gbtrain.setConstraints(jcbService3,ctrain);
		jpTrain.add(jcbService3);
		gbtrain.setConstraints(jcbSection3,ctrain);
		jpTrain.add(jcbSection3);
		gbtrain.setConstraints(jcbFrom3,ctrain);
		jpTrain.add(jcbFrom3);
		gbtrain.setConstraints(jcbTo3,ctrain);
		jpTrain.add(jcbTo3);
		gbtrain.setConstraints(jcbSiding3,ctrain);
		jpTrain.add(jcbSiding3);
		gbtrain.setConstraints(jftfLoad3,ctrain);
		jpTrain.add(jftfLoad3);
		gbtrain.setConstraints(jcbDep3,ctrain);
		jpTrain.add(jcbDep3);
		gbtrain.setConstraints(jcbArr3,ctrain);
		jpTrain.add(jcbArr3);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label3,ctrain);
		jpTrain.add(label3);
		
		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco4,ctrain);
		jpTrain.add(jftfLoco4); 
		gbtrain.setConstraints(jcbTrainno4,ctrain);
		jpTrain.add(jcbTrainno4);
		gbtrain.setConstraints(jcbService4,ctrain);
		jpTrain.add(jcbService4);
		gbtrain.setConstraints(jcbSection4,ctrain);
		jpTrain.add(jcbSection4);
		gbtrain.setConstraints(jcbFrom4,ctrain);
		jpTrain.add(jcbFrom4);
		gbtrain.setConstraints(jcbTo4,ctrain);
		jpTrain.add(jcbTo4);
		gbtrain.setConstraints(jcbSiding4,ctrain);
		jpTrain.add(jcbSiding4);
		gbtrain.setConstraints(jftfLoad4,ctrain);
		jpTrain.add(jftfLoad4);
		gbtrain.setConstraints(jcbDep4,ctrain);
		jpTrain.add(jcbDep4);
		gbtrain.setConstraints(jcbArr4,ctrain);
		jpTrain.add(jcbArr4);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label4,ctrain);
		jpTrain.add(label4);
		
		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco5,ctrain);
		jpTrain.add(jftfLoco5); 
		gbtrain.setConstraints(jcbTrainno5,ctrain);
		jpTrain.add(jcbTrainno5);
		gbtrain.setConstraints(jcbService5,ctrain);
		jpTrain.add(jcbService5);
		gbtrain.setConstraints(jcbSection5,ctrain);
		jpTrain.add(jcbSection5);
		gbtrain.setConstraints(jcbFrom5,ctrain);
		jpTrain.add(jcbFrom5);
		gbtrain.setConstraints(jcbTo5,ctrain);
		jpTrain.add(jcbTo5);
		gbtrain.setConstraints(jcbSiding5,ctrain);
		jpTrain.add(jcbSiding5);
		gbtrain.setConstraints(jftfLoad5,ctrain);
		jpTrain.add(jftfLoad5);
		gbtrain.setConstraints(jcbDep5,ctrain);
		jpTrain.add(jcbDep5);
		gbtrain.setConstraints(jcbArr5,ctrain);
		jpTrain.add(jcbArr5);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label5,ctrain);
		jpTrain.add(label5);
		
		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco6,ctrain);
		jpTrain.add(jftfLoco6); 
		gbtrain.setConstraints(jcbTrainno6,ctrain);
		jpTrain.add(jcbTrainno6);
		gbtrain.setConstraints(jcbService6,ctrain);
		jpTrain.add(jcbService6);
		gbtrain.setConstraints(jcbSection6,ctrain);
		jpTrain.add(jcbSection6);
		gbtrain.setConstraints(jcbFrom6,ctrain);
		jpTrain.add(jcbFrom6);
		gbtrain.setConstraints(jcbTo6,ctrain);
		jpTrain.add(jcbTo6);
		gbtrain.setConstraints(jcbSiding6,ctrain);
		jpTrain.add(jcbSiding6);
		gbtrain.setConstraints(jftfLoad6,ctrain);
		jpTrain.add(jftfLoad6);
		gbtrain.setConstraints(jcbDep6,ctrain);
		jpTrain.add(jcbDep6);
		gbtrain.setConstraints(jcbArr6,ctrain);
		jpTrain.add(jcbArr6);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label6,ctrain);
		jpTrain.add(label6);

		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco7,ctrain);
		jpTrain.add(jftfLoco7); 
		gbtrain.setConstraints(jcbTrainno7,ctrain);
		jpTrain.add(jcbTrainno7);
		gbtrain.setConstraints(jcbService7,ctrain);
		jpTrain.add(jcbService7);
		gbtrain.setConstraints(jcbSection7,ctrain);
		jpTrain.add(jcbSection7);
		gbtrain.setConstraints(jcbFrom7,ctrain);
		jpTrain.add(jcbFrom7);
		gbtrain.setConstraints(jcbTo7,ctrain);
		jpTrain.add(jcbTo7);
		gbtrain.setConstraints(jcbSiding7,ctrain);
		jpTrain.add(jcbSiding7);
		gbtrain.setConstraints(jftfLoad7,ctrain);
		jpTrain.add(jftfLoad7);
		gbtrain.setConstraints(jcbDep7,ctrain);
		jpTrain.add(jcbDep7);
		gbtrain.setConstraints(jcbArr7,ctrain);
		jpTrain.add(jcbArr7);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label7,ctrain);
		jpTrain.add(label7);

		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco8,ctrain);
		jpTrain.add(jftfLoco8); 
		gbtrain.setConstraints(jcbTrainno8,ctrain);
		jpTrain.add(jcbTrainno8);
		gbtrain.setConstraints(jcbService8,ctrain);
		jpTrain.add(jcbService8);
		gbtrain.setConstraints(jcbSection8,ctrain);
		jpTrain.add(jcbSection8);
		gbtrain.setConstraints(jcbFrom8,ctrain);
		jpTrain.add(jcbFrom8);
		gbtrain.setConstraints(jcbTo8,ctrain);
		jpTrain.add(jcbTo8);
		gbtrain.setConstraints(jcbSiding8,ctrain);
		jpTrain.add(jcbSiding8);
		gbtrain.setConstraints(jftfLoad8,ctrain);
		jpTrain.add(jftfLoad8);
		gbtrain.setConstraints(jcbDep8,ctrain);
		jpTrain.add(jcbDep8);
		gbtrain.setConstraints(jcbArr8,ctrain);
		jpTrain.add(jcbArr8);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label8,ctrain);
		jpTrain.add(label8);

		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco9,ctrain);
		jpTrain.add(jftfLoco9); 
		gbtrain.setConstraints(jcbTrainno9,ctrain);
		jpTrain.add(jcbTrainno9);
		gbtrain.setConstraints(jcbService9,ctrain);
		jpTrain.add(jcbService9);
		gbtrain.setConstraints(jcbSection9,ctrain);
		jpTrain.add(jcbSection9);
		gbtrain.setConstraints(jcbFrom9,ctrain);
		jpTrain.add(jcbFrom9);
		gbtrain.setConstraints(jcbTo9,ctrain);
		jpTrain.add(jcbTo9);
		gbtrain.setConstraints(jcbSiding9,ctrain);
		jpTrain.add(jcbSiding9);
		gbtrain.setConstraints(jftfLoad9,ctrain);
		jpTrain.add(jftfLoad9);
		gbtrain.setConstraints(jcbDep9,ctrain);
		jpTrain.add(jcbDep9);
		gbtrain.setConstraints(jcbArr9,ctrain);
		jpTrain.add(jcbArr9);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label9,ctrain);
		jpTrain.add(label9);

		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco10,ctrain);
		jpTrain.add(jftfLoco10); 
		gbtrain.setConstraints(jcbTrainno10,ctrain);
		jpTrain.add(jcbTrainno10);
		gbtrain.setConstraints(jcbService10,ctrain);
		jpTrain.add(jcbService10);
		gbtrain.setConstraints(jcbSection10,ctrain);
		jpTrain.add(jcbSection10);
		gbtrain.setConstraints(jcbFrom10,ctrain);
		jpTrain.add(jcbFrom10);
		gbtrain.setConstraints(jcbTo10,ctrain);
		jpTrain.add(jcbTo10);
		gbtrain.setConstraints(jcbSiding10,ctrain);
		jpTrain.add(jcbSiding10);
		gbtrain.setConstraints(jftfLoad10,ctrain);
		jpTrain.add(jftfLoad10);
		gbtrain.setConstraints(jcbDep10,ctrain);
		jpTrain.add(jcbDep10);
		gbtrain.setConstraints(jcbArr10,ctrain);
		jpTrain.add(jcbArr10);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label10,ctrain);
		jpTrain.add(label10);

		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco11,ctrain);
		jpTrain.add(jftfLoco11); 
		gbtrain.setConstraints(jcbTrainno11,ctrain);
		jpTrain.add(jcbTrainno11);
		gbtrain.setConstraints(jcbService11,ctrain);
		jpTrain.add(jcbService11);
		gbtrain.setConstraints(jcbSection11,ctrain);
		jpTrain.add(jcbSection11);
		gbtrain.setConstraints(jcbFrom11,ctrain);
		jpTrain.add(jcbFrom11);
		gbtrain.setConstraints(jcbTo11,ctrain);
		jpTrain.add(jcbTo11);
		gbtrain.setConstraints(jcbSiding11,ctrain);
		jpTrain.add(jcbSiding11);
		gbtrain.setConstraints(jftfLoad11,ctrain);
		jpTrain.add(jftfLoad11);
		gbtrain.setConstraints(jcbDep11,ctrain);
		jpTrain.add(jcbDep11);
		gbtrain.setConstraints(jcbArr11,ctrain);
		jpTrain.add(jcbArr11);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label11,ctrain);
		jpTrain.add(label11);

		ctrain.gridwidth = 1;
		ctrain.fill = GridBagConstraints.NONE;
		gbtrain.setConstraints(jftfLoco12,ctrain);
		jpTrain.add(jftfLoco12); 
		gbtrain.setConstraints(jcbTrainno12,ctrain);
		jpTrain.add(jcbTrainno12);
		gbtrain.setConstraints(jcbService12,ctrain);
		jpTrain.add(jcbService12);
		gbtrain.setConstraints(jcbSection12,ctrain);
		jpTrain.add(jcbSection12);
		gbtrain.setConstraints(jcbFrom12,ctrain);
		jpTrain.add(jcbFrom12);
		gbtrain.setConstraints(jcbTo12,ctrain);
		jpTrain.add(jcbTo12);
		gbtrain.setConstraints(jcbSiding12,ctrain);
		jpTrain.add(jcbSiding12);
		gbtrain.setConstraints(jftfLoad12,ctrain);
		jpTrain.add(jftfLoad12);
		gbtrain.setConstraints(jcbDep12,ctrain);
		jpTrain.add(jcbDep12);
		gbtrain.setConstraints(jcbArr12,ctrain);
		jpTrain.add(jcbArr12);
		ctrain.gridwidth = GridBagConstraints.REMAINDER;
		gbtrain.setConstraints(label12,ctrain);
		jpTrain.add(label12);
		
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.NONE;
		gbTop.setConstraints(jpTrain,c);
		panel1.add(jpTrain);

		JPanel jpSignof = new JPanel();
		jpSignof.setBackground(new Color(252,189,253));
		jpSignof.add(jbTitleSof);
		jpSignof.add(dateSignOf);
		jpSignof.add(hourSignOf);
		jpSignof.add(minuteSignOf);
		
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.NONE;
		gbTop.setConstraints(jpSignof,c);
		panel1.add(jpSignof);
/*
		c.gridwidth = 1;
		c.fill = GridBagConstraints.CENTER;
		gbTop.setConstraints(jbTitleSof,c);
		panel1.add(jbTitleSof);
		gbTop.setConstraints(dateSignOf,c);
		panel1.add(dateSignOf);
		gbTop.setConstraints(hourSignOf,c);
		panel1.add(hourSignOf);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.NONE;
		gbTop.setConstraints(minuteSignOf,c);
		panel1.add(minuteSignOf);
*/
		GridBagLayout gbSubmit  = new GridBagLayout();
		GridBagConstraints cSubmit = new GridBagConstraints();
		panel7 = new JPanel();
		panel7.setBackground(new Color(252,189,253));
		panel7.setLayout(gbSubmit);
		panel7.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		gbSubmit.setConstraints(jbDetention,cSubmit);
		panel7.add(jbDetention);
		gbSubmit.setConstraints(jtfDetention,cSubmit);
		panel7.add(jtfDetention);
		gbSubmit.setConstraints(jbKms,cSubmit);
		panel7.add(jbKms);
		gbSubmit.setConstraints(jbVerify,cSubmit);
		panel7.add(jbVerify);
		cSubmit.gridwidth = GridBagConstraints.REMAINDER;
		gbSubmit.setConstraints(jbSubmit,cSubmit);
		panel7.add(jbSubmit);
		
		c.gridwidth = GridBagConstraints.REMAINDER;
		gbTop.setConstraints(panel7,c);
		panel1.add(panel7);

		jbSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)   
			{
				try
				{
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.1:1521:oracle","javacrew","javacrew");
//					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.1:1521:oracle","javacrew","javacrew");
//con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.1:1521:oracle","javacrew","javacrew");
//					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//					con = DriverManager.getConnection("jdbc:odbc:javacrew","kzj","kzj");
					con.setAutoCommit(false);
					stmt = con.createStatement();
				} 
				catch(Exception e1)	
				{
					e1.printStackTrace();
				}

				try
				{
					radioname = group.getSelection().getActionCommand();
					if(radioname.equals(new String("WITHGUARD")))	
					{
						blnDriver = true;
						blnAssistant = true;
						blnGuard = true;
					}
					if(radioname.equals(new String("WITHOUTGUARD")))	
					{
						blnDriver = true;
						blnAssistant = true;
						blnGuard = false;
					}
					if(radioname.equals(new String("DRIVER")))	
					{
						blnDriver = true;
						blnAssistant = false;
						blnGuard = false;
					}
					if(radioname.equals(new String("ASSISTANT")))	
					{
						blnDriver = false;
						blnAssistant = true;
						blnGuard = false;
					}
					if(radioname.equals(new String("GUARD")))	
					{
						blnDriver = false;
						blnAssistant = false;
						blnGuard = true;				
					}
					if(blnDriver)
						driverNamePfNo = ncbDriver.getName().trim();
					if(blnAssistant)
						assistantNamePfNo = ncbAssistant.getName().trim();
					if(blnGuard)
						guardNamePfNo = ncbGuard.getName().trim();
					
					if(blnDriver)
					{
						int i = driverNamePfNo.length();
						driverName =	driverNamePfNo.substring(0,i-9).trim();
						driverPfNo = driverNamePfNo.substring(i-8);
					}
					if(blnAssistant)	
					{
						int i = assistantNamePfNo.length();
						assistantName =	assistantNamePfNo.substring(0,i-9).trim();
						assistantPfNo = assistantNamePfNo.substring(i-8);
					}
					if(blnGuard)	
					{
						int i = guardNamePfNo.length();
						guardName = guardNamePfNo.substring(0,i-9).trim();
						guardPfNo = guardNamePfNo.substring(i-8);
					}
					strCtrNo = jtfCtrNo.getText().trim().toUpperCase();
					if(blnDriver)
					{
						query = "Select Ctrno from signoffdriver where upper(ctrno) = '"+strCtrNo+"'";
						vectorCoaching.removeAllElements();
						vectorCoaching.trimToSize();
						vectorCoaching= snv.getStationNameList("",query );
						if(vectorCoaching.size()>0 )
						{
							JOptionPane.showMessageDialog(null,"Driver CTR no already exists","Click OK to Continue",
																							JOptionPane.ERROR_MESSAGE);
									return;
						}
					}
					if(blnGuard)
					{
						query = "Select Ctrno from signoffguard where upper(ctrno) = '"+strCtrNo+"'";
						vectorCoaching.removeAllElements();
						vectorCoaching.trimToSize();
						vectorCoaching= snv.getStationNameList("",query );
						if(vectorCoaching.size()>0 )
						{
							JOptionPane.showMessageDialog(null,"Guard CTR No already exists","Click OK to Continue",
																							JOptionPane.ERROR_MESSAGE);
									return;
						}
					}
					if(blnAssistant)
					{
						query = "Select Ctrno from signoffassistant where upper(ctrno) = '"+strCtrNo+"'";
						vectorCoaching.removeAllElements();
						vectorCoaching.trimToSize();
						vectorCoaching = snv.getStationNameList("",query );
						if( vectorCoaching.size()>0 )
						{
									JOptionPane.showMessageDialog(null,"Assistant CTR No already exists","Click OK to Continue",
																							JOptionPane.ERROR_MESSAGE);
									return;
						}
					}
					
					blnContinuous = jcContinuous.isSelected();
					sda = 0;					
					if(blnContinuous)
						blnBaseStation = false;
					else
						blnBaseStation = blnBase;

					System.out.println("blnBaseStation : " + blnBaseStation);				
					blnHandicap = jcHandicap.isSelected();
					iHandicap = 0;
					iVia = 0;
					if(blnHandicap)
					{
						iHandicap = 1;
					}
					else
					{
						iHandicap = 0;
					}
/*					blnVia = jcVia.isSelected();
					iVia = 0;
					if(blnVia)
					{
						iVia = 1;
					}
					else
					{
						iVia = 0;
					}
*/
					blnNRRA = jcNRRA.isSelected();
					iNRRA = 0;
					if(blnNRRA)
					{
						iNRRA = 1;
					}
					else
					{
						iNRRA = 0;
					}
					blnNCA = jcNCA.isSelected();
					iNCA = 0;
					if(blnNCA)
					{
						iNCA = 1;
					}
					else
					{
						iNCA = 0;
					}
					detention = new Integer(jtfDetention.getText().trim()).intValue();

					strType = "P";
					service = (String) jcbService.getSelectedItem();

					try
					{
						if(!to1.equals(null))
							coa = to1;
					}
					catch(Exception exe3)
					{
					}
					try
					{
						if(!to2.equals(null))
							coa = to2;
					}
					catch(Exception exe3)
					{
					}
					try
					{
						if(!to3.equals(null))
							coa = to3;
					}
					catch(Exception exe2)
					{
					}
					try
					{
						if(!to4.equals(null))
							coa = to4;
					}
					catch(Exception exe1)
					{
					}
					try
					{
						if(!to5.equals(null))
							coa = to5;
					}
					catch(Exception exe1)
					{
					}
					try
					{
						if(!to6.equals(null))
							coa = to6;
					}
					catch(Exception exe1)
					{
					}
					try
					{
						if(!to7.equals(null))
							coa = to7;
					}
					catch(Exception exe7)
					{
					}
					try
					{
						if(!to8.equals(null))
							coa = to8;
					}
					catch(Exception exe8)
					{
					}
					try
					{
						if(!to9.equals(null))
							coa = to9;
					}
					catch(Exception exe9)
					{
					}
					try
					{
						if(!to10.equals(null))
							coa = to10;
					}
					catch(Exception exe10)
					{
					}
					try
					{
						if(!to11.equals(null))
							coa = to11;
					}
					catch(Exception exe11)
					{
					}
					try
					{
						if(!to12.equals(null))
							coa = to12;
					}
					catch(Exception exe12)
					{
					}

					if(service.equals("HigherGrade1") || service.equals("HigherGrade2"))
//						||service.equals("Shunting")||service.equals("LR"))
					{
						if(blnDriver)
						{
							vector.removeAllElements();
							vector.trimToSize();		
							query  = "select ctrno from signoffdriver where pfnodriver ='"+driverPfNo+
									"' and CasualtyOver=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
							System.out.println(query );
							vector = snv.getStationNameList("",query );
							if(vector.size()>0)
							{
								if(coa.equals(depot))
								{
									String ctr = (String) vector.elementAt(0);
									query = " delete from signoffdriver where ctrno = '"+ ctr +"'";
									System.out.println(query);
									stmt.addBatch(query);

									query = "update casualtyd set CasualtyOver =1,"+
										"CasualtyTo =to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi') "+
										" where pfnodriver ='"+	driverPfNo+"' and casualtyover=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
									stmt.addBatch(query );
								}
							}
							else
							{
								if(service.equals("HigherGrade1") || service.equals("HigherGrade2"))
								{
									JOptionPane.showMessageDialog(null,"Service Mentioned for DRIVER is not correct","Click OK to Continue",
																							JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
						}
						if(blnGuard)
						{
							vector.removeAllElements();
							vector.trimToSize();		
							query = "select ctrno from signoffguard where pfnoguard ='"+guardPfNo+
									"' and CasualtyOver=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
							System.out.println(query );
							vector = snv.getStationNameList("",query );
							if(vector.size()>0)
							{
								if(coa.equals(depot))
								{
									String ctr = (String) vector.elementAt(0);
									query = " delete from signoffguard where ctrno = '"+ ctr +"'";
									System.out.println(query );
									stmt.addBatch(query );

									query = "update casualtyg set CasualtyOver =1,"+
										"CasualtyTo =to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi') "+
										" where pfnoguard ='"+	guardPfNo+"' and casualtyover=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
									stmt.addBatch(query );
								}
							}
							else
							{
								if(service.equals("HigherGrade1") || service.equals("HigherGrade2"))
								{
									JOptionPane.showMessageDialog(null,"Service Mentioned for GUARD is not correct","Click OK to Continue",
																						JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
						}
						if(blnAssistant)
						{
							vector.removeAllElements();
							vector.trimToSize();
							query = "select ctrno from signoffassistant where pfnoassistant ='"+
										assistantPfNo+"' and CasualtyOver=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
							vector = snv.getStationNameList("",query );
							if(vector.size()>0)
							{
								if(coa.equals(depot))
								{
									ctr = (String) vector.elementAt(0);
									query = " delete from signoffassistant where ctrno = '"+ ctr +"'";
									System.out.println(query );
									stmt.addBatch(query );
									query = "update casualtyad set CasualtyOver =1,"+
											"CasualtyTo =to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi') "+
											" where pfnoassistant ='"+	assistantPfNo+"' and casualtyover=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
									System.out.println(query );
									stmt.addBatch(query );
								}
							}
							else
							{
								if(service.equals("HigherGrade1") || service.equals("HigherGrade2"))
								{
									JOptionPane.showMessageDialog(null,"Service Mentioned for ASSISTANT is not correct","Click OK to Continue",
													JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
						}
					}
					else
					{
						if(service.equals("Shunting")||service.equals("LR")||service.equals("Pilot"))
						{
						}
						else
						{
							if(blnDriver)
							{
								vector.removeAllElements();
								vector.trimToSize();		
								query  = "select ctrno from signoffdriver where pfnodriver ='"+driverPfNo+
										"' and CasualtyOver=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
								System.out.println(query );
								vector = snv.getStationNameList("",query );
								if(vector.size()>0)
								{
									JOptionPane.showMessageDialog(null,"Service Mentioned for DRIVER is not correct",
										"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
							if(blnGuard)
							{
								vector.removeAllElements();
								vector.trimToSize();		
								query = "select ctrno from signoffguard where pfnoguard ='"+guardPfNo+
										"' and CasualtyOver=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
								System.out.println(query );
								vector = snv.getStationNameList("",query );
								if(vector.size()>0)
								{
									JOptionPane.showMessageDialog(null,"Service Mentioned for GUARD is not correct","Click OK to Continue",
																							JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
							if(blnAssistant)
							{
								vector.removeAllElements();
								vector.trimToSize();
								query = "select ctrno from signoffassistant where pfnoassistant ='"+
											assistantPfNo+"' and CasualtyOver=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
								vector = snv.getStationNameList("",query );
								if(vector.size()>0)
								{
									JOptionPane.showMessageDialog(null,"Service Mentioned for ASSISTANT is not correct","Click OK to Continue",
														JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
						}
					}

					if(shuntingHours == 0)
					{
						shuntingHours = new Double(jtfShunting.getText().trim()).doubleValue();
					}
					System.out.println("######################## MILEAGE CALCULATION ##################################");
					try
					{
						if(!service1.equals(null))
						{
							if((service1.equals(new String("LE/LA"))) ||(service1.equals(new String("CraneSpecial"))) || 
								(service1.equals(new String("EnggSpl")))  ||  (service1.equals(new String("Ballast"))) 
								||(service1.equals(new String("CoalPilots"))) ||(service1.equals(new String("MaterialTrain")))) 
							{
								if (from1.equals(to1))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service2.equals(null))
						{
							if(service2.equals(new String("LE/LA"))||service2.equals(new String("CraneSpecial"))|| 
								service2.equals(new String("EnggSpl"))||service2.equals(new String("Ballast")) 
								||service2.equals(new String("CoalPilots"))||service2.equals(new String("MaterialTrain"))) 
							{
								if (from2.equals(to2))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service3.equals(null))
						{
							if(service3.equals(new String("LE/LA"))||service3.equals(new String("CraneSpecial"))|| 
								service3.equals(new String("EnggSpl"))||service3.equals(new String("Ballast")) 
								||service3.equals(new String("CoalPilots"))||service3.equals(new String("MaterialTrain"))) 
							{
								if (from3.equals(to3))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service4.equals(null))
						{
							if(service4.equals(new String("LE/LA"))||service4.equals(new String("CraneSpecial"))|| 
								service4.equals(new String("EnggSpl"))||service4.equals(new String("Ballast")) 
								||service4.equals(new String("CoalPilots"))||service4.equals(new String("MaterialTrain"))) 
							{
								if (from4.equals(to4))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service5.equals(null))
						{
							if(service5.equals(new String("LE/LA"))||service5.equals(new String("CraneSpecial"))|| 
								service5.equals(new String("EnggSpl"))||service5.equals(new String("Ballast")) 
								||service5.equals(new String("CoalPilots"))||service5.equals(new String("MaterialTrain"))) 
							{
								if (from5.equals(to5))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service6.equals(null))
						{
							if(service6.equals(new String("LE/LA"))||service6.equals(new String("CraneSpecial"))|| 
								service6.equals(new String("EnggSpl"))||service6.equals(new String("Ballast")) 
								||service6.equals(new String("CoalPilots"))||service6.equals(new String("MaterialTrain"))) 
							{
								if (from6.equals(to6))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service7.equals(null))
						{
							if(service7.equals(new String("LE/LA"))||service7.equals(new String("CraneSpecial"))|| 
								service7.equals(new String("EnggSpl"))||service7.equals(new String("Ballast")) 
								||service7.equals(new String("CoalPilots"))||service7.equals(new String("MaterialTrain"))) 
							{
								if (from7.equals(to7))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service8.equals(null))
						{
							if(service8.equals(new String("LE/LA"))||service8.equals(new String("CraneSpecial"))|| 
								service8.equals(new String("EnggSpl"))||service8.equals(new String("Ballast")) 
								||service8.equals(new String("CoalPilots"))||service8.equals(new String("MaterialTrain"))) 
							{
								if (from8.equals(to8))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service9.equals(null))
						{
							if(service9.equals(new String("LE/LA"))||service9.equals(new String("CraneSpecial"))|| 
								service9.equals(new String("EnggSpl"))||service9.equals(new String("Ballast")) 
								||service9.equals(new String("CoalPilots"))||service9.equals(new String("MaterialTrain"))) 
							{
								if (from9.equals(to9))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service10.equals(null))
						{
							if(service10.equals(new String("LE/LA"))||service10.equals(new String("CraneSpecial"))|| 
								service10.equals(new String("EnggSpl"))||service10.equals(new String("Ballast")) 
								||service10.equals(new String("CoalPilots"))||service10.equals(new String("MaterialTrain"))) 
							{
								if (from10.equals(to10))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service11.equals(null))
						{
							if(service11.equals(new String("LE/LA"))||service11.equals(new String("CraneSpecial"))|| 
								service11.equals(new String("EnggSpl"))||service11.equals(new String("Ballast")) 
								||service11.equals(new String("CoalPilots"))||service11.equals(new String("MaterialTrain"))) 
							{
								if (from11.equals(to11))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service12.equals(null))
						{
							if(service12.equals(new String("LE/LA"))||service12.equals(new String("CraneSpecial"))|| 
								service12.equals(new String("EnggSpl"))||service12.equals(new String("Ballast")) 
								||service12.equals(new String("CoalPilots"))||service12.equals(new String("MaterialTrain"))) 
							{
								if (from12.equals(to12))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
					}
					catch(Exception ee)
					{
					}
					try
					{
						if(!service1.equals(null))
						{
							if((service1.equals(new String("LE/LA"))) ||(service1.equals(new String("CraneSpecial"))) || 
								(service1.equals(new String("EnggSpl")))  ||  (service1.equals(new String("Ballast"))) 
								||(service1.equals(new String("CoalPilots"))) ||(service1.equals(new String("MaterialTrain")))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service2.equals(null))
						{
							if(service2.equals(new String("LE/LA"))||service2.equals(new String("CraneSpecial"))|| 
								service2.equals(new String("EnggSpl"))||service2.equals(new String("Ballast")) 
								||service2.equals(new String("CoalPilots"))||service2.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service3.equals(null))
						{
							if(service3.equals(new String("LE/LA"))||service3.equals(new String("CraneSpecial"))|| 
								service3.equals(new String("EnggSpl"))||service3.equals(new String("Ballast")) 
								||service3.equals(new String("CoalPilots"))||service3.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service4.equals(null))
						{
							if(service4.equals(new String("LE/LA"))||service4.equals(new String("CraneSpecial"))|| 
								service4.equals(new String("EnggSpl"))||service4.equals(new String("Ballast")) 
								||service4.equals(new String("CoalPilots"))||service4.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service5.equals(null))
						{
							if(service5.equals(new String("LE/LA"))||service5.equals(new String("CraneSpecial"))|| 
								service5.equals(new String("EnggSpl"))||service5.equals(new String("Ballast")) 
								||service5.equals(new String("CoalPilots"))||service5.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service6.equals(null))
						{
							if(service6.equals(new String("LE/LA"))||service6.equals(new String("CraneSpecial"))|| 
								service6.equals(new String("EnggSpl"))||service6.equals(new String("Ballast")) 
								||service6.equals(new String("CoalPilots"))||service6.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service7.equals(null))
						{
							if(service7.equals(new String("LE/LA"))||service7.equals(new String("CraneSpecial"))|| 
								service7.equals(new String("EnggSpl"))||service7.equals(new String("Ballast")) 
								||service7.equals(new String("CoalPilots"))||service7.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service8.equals(null))
						{
							if(service8.equals(new String("LE/LA"))||service8.equals(new String("CraneSpecial"))|| 
								service8.equals(new String("EnggSpl"))||service8.equals(new String("Ballast")) 
								||service8.equals(new String("CoalPilots"))||service8.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service9.equals(null))
						{
							if(service9.equals(new String("LE/LA"))||service9.equals(new String("CraneSpecial"))|| 
								service9.equals(new String("EnggSpl"))||service9.equals(new String("Ballast")) 
								||service9.equals(new String("CoalPilots"))||service9.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service10.equals(null))
						{
							if(service10.equals(new String("LE/LA"))||service10.equals(new String("CraneSpecial"))|| 
								service10.equals(new String("EnggSpl"))||service10.equals(new String("Ballast")) 
								||service10.equals(new String("CoalPilots"))||service10.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service11.equals(null))
						{
							if(service11.equals(new String("LE/LA"))||service11.equals(new String("CraneSpecial"))|| 
								service11.equals(new String("EnggSpl"))||service11.equals(new String("Ballast")) 
								||service11.equals(new String("CoalPilots"))||service11.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service12.equals(null))
						{
							if(service12.equals(new String("LE/LA"))||service12.equals(new String("CraneSpecial"))|| 
								service12.equals(new String("EnggSpl"))||service12.equals(new String("Ballast")) 
								||service12.equals(new String("CoalPilots"))||service12.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
					}
					catch(NullPointerException  npex)
					{
//						System.out.println("Null pointer in calculating Mileage ");
//						npex.printStackTrace();
					}
					throughgoodskm=0; lekm=0; ballastkm=0; cranesplkm=0;breakdownkm=0; medicalreliefkm=0; shuntingkm=0;
					coalpilotskm=0; lelakm=0; enggkm = 0; materialtrainkm=0; pilotkm=0; enggsplkm=0;shuttlingkm=0;
					hg1km=0; hg2km=0;  sidingkm=0;yardreliefkm=0; pilotsectionkm=0; lrkm=0; 
					srtrainkm=0;
					mileage = 0; amileage = 0; dmileage = 0; gmileage = 0; mileagex = 0;
					throughgoodshrs=0; lehrs=0; ballasthrs=0; cranesplhrs=0;breakdownhrs=0; medicalreliefhrs=0; shuntinghrs=0;
					coalpilotshrs=0; lelahrs=0; materialtrainhrs=0; pilothrs=0; enggsplhrs=0;shuttlinghrs = 0;
					hg1hrs=0; hg2hrs=0;  sidinghrs=0;yardreliefhrs=0; pilotsectionhrs=0; lrhrs=0; 
					srtrainhrs=0;
					try
					{
						if(!service1.equals(null))
						{
							returnMileage(service1, dist1, hour1);
						}
						if(!service2.equals(null))
						{
							returnMileage(service2, dist2, hour2);
						}
						if(!service3.equals(null))
						{
							returnMileage(service3, dist3, hour3);
						}
						if(!service4.equals(null))
						{
							returnMileage(service4, dist4, hour4);
						}
						if(!service5.equals(null))
						{
							returnMileage(service5, dist5, hour5);
						}
						if(!service6.equals(null))
						{
							returnMileage(service6, dist6, hour6);
						}
						if(!service7.equals(null))
						{
							returnMileage(service7, dist7, hour7);
						}
						if(!service8.equals(null))
						{
							returnMileage(service8, dist8, hour8);
						}
						if(!service9.equals(null))
						{
							returnMileage(service9, dist9, hour9);
						}
						if(!service10.equals(null))
						{
							returnMileage(service10, dist10, hour10);
						}
						if(!service11.equals(null))
						{
							returnMileage(service11, dist11, hour11);
						}
						if(!service12.equals(null))
						{
							returnMileage(service12, dist12, hour12);
						}
					}
					catch(NullPointerException  npex)
					{
//						System.out.println("Null pointer in calculating Mileage ");
//						npex.printStackTrace();
					}
					sidingkm = sidingkm ;//-distPilot;
					throughgoodskm = throughgoodskm + lekm;//-distPilot;
					lelakm = lelakm+cranesplkm+enggsplkm+ballastkm+coalpilotskm+materialtrainkm;//-distPilot;
					breakdownkm = breakdownkm+medicalreliefkm;//-distPilot;
					shuntingkm = shuntingkm + yardreliefkm;
					System.out.println("TG : " + throughgoodskm + " &  lela : " + lelakm + " & break : " + breakdownkm + 
					" & Siding : " + sidingkm + " & HG : " + hg1km + " & hg2 : " + hg2km + " & pilot : " + pilotkm);
					throughgoodshrs = throughgoodshrs + lehrs;
					lelahrs = lelahrs+cranesplhrs+enggsplhrs+ballasthrs+coalpilotshrs+materialtrainhrs;
					breakdownhrs = breakdownhrs+medicalreliefhrs;
					sidinghrs = sidinghrs ;
					shuntinghrs = shuntinghrs + yardreliefhrs;
					shuntingHours = new Double(jtfShunting.getText().trim()).doubleValue();
					if(blnHandicap)
					{
						amileage  = 120;
						gmileage  = 120;
						dmileage  = 120;
					}
					else
					{
						if(throughgoodskm >0)
						{
							mileagex = me.getMileage("ThroughGoods",throughgoodskm+sidingkm,
							blnHandicap,0, throughgoodshrs);
							System.out.println("ThroughGoods KM : " + throughgoodskm+ " & " + mileagex + " : " + mileage);
							mileage = mileage + mileagex;							
						}
						if(lrkm >0)
						{
							mileagex = me.getMileage("LR",lrkm,	blnHandicap,0, lrhrs);
							mileage = mileage + mileagex;
							System.out.println("LR KM : " + lrkm+ " & " + mileagex + " : " + mileage);
						}
						if(pilotsectionkm >0)
						{
							mileagex = me.getMileage("PilotSection",pilotsectionkm,
							blnHandicap,shuntingHours, pilotsectionhrs);
							mileage = mileage + mileagex;
							System.out.println("PilotSection KM : " + pilotsectionkm+ " & " + mileagex + " : " +mileage);
						}
						
						if(srtrainkm >0)
						{
							mileagex =me.getMileage("SRTrain",srtrainkm+sidingkm,
							blnHandicap,0, srtrainhrs);
							mileage = mileage + mileagex;
							System.out.println("SRTrain KM : " + srtrainkm+ " & " + mileagex + " : " + mileage);
						}
						if(shuntinghrs >0)
						{
							mileagex = me.getMileage("Shunting",shuntingkm,
							blnHandicap,0, shuntinghrs);
							mileage = mileage + mileagex;
							System.out.println("Shunting KM : " + shuntingkm+ " & " + mileagex + " : " + mileage);
						}
						if(shuttlingkm >0)
						{
							mileagex = me.getMileage("Shuttling",shuttlingkm,
							blnHandicap,0, shuttlinghrs);
							mileage = mileage + mileagex;
							System.out.println("Shunting KM : " + shuttlingkm+ " & " + mileagex + " : " + mileage);
						}
						if(srtrainkm <= 0)
						{
							if(sidingkm >0)
							{
								mileagex = me.getMileage("Siding",0,
								blnHandicap,0,shuntingHours);
								mileage = mileage + mileagex;
								System.out.println("Ssiding KM : " + sidingkm+ " & " + mileagex + " : " + mileage);
							}
						}
						if(pilotkm >0 || distPilot >0 )
						{
							mileagex = me.getMileage("Pilot",pilotkm,
							blnHandicap,0, pilothrs);
							mileage = mileage + mileagex;
							System.out.println("Pilot KM : " + pilotkm+ " & " + mileagex + " : " + mileage);
						}
						if(breakdownkm >0)
						{
							mileagex = me.getMileage("BreakDown",breakdownkm,
								blnHandicap,0, breakdownhrs+sidinghrs);
							mileage = mileage + mileagex;
							System.out.println("Breakdown KM : " +  breakdownkm+ " & " + mileagex + " : " + mileage);
						}
						
						amileage = mileage;
						dmileage = mileage;
						gmileage = mileage;
						if(lelakm >0 || enggkm >0)
						{
							if(blnSpecial==true) 
							{
								double signoff = ct.getHourBetween(arrivalDate, signOfDate);
								lelahrs = lelahrs + signoff;
							}
							if(blnDriver)
							{
								mileagex = me.getMileage("LE/LA",lelakm, blnHandicap,0, lelahrs, driverDate, signOfDate);
								dmileage = dmileage + mileagex;
								System.out.println("Dr lela KM : " + lelakm+ " & " + mileagex + " : " + dmileage);
							}
							if(blnAssistant)
							{
								mileagex = me.getMileage("LE/LA",lelakm,blnHandicap,0, lelahrs, assistantDate, signOfDate);
								amileage = amileage + mileagex;
								System.out.println("ADr lela KM : " + lelakm+ " & " + mileagex + " : " + amileage);
							}
							if(blnGuard)
							{
								mileagex = me.getMileage("LE/LA",lelakm,blnHandicap,0, lelahrs, guardDate, signOfDate);
								gmileage = gmileage + mileagex;
								System.out.println("Guard lela KM : " + lelakm+ " & " + mileagex + " : " + gmileage);
							}							
						}
						if(hg1km >0)
						{
							if(blnDriver)
							{
								mileagex = me.getMileage("HigherGrade1",hg1km,
								blnHandicap,0, hg1hrs, "DRIVER");
								dmileage = dmileage + mileagex;
								System.out.println("HigherGrade1 KM : " + hg1km+ " & " + mileagex + " : " + dmileage);
							}
							if(blnAssistant)
							{
								mileagex = me.getMileage("HigherGrade1",hg1km,
								blnHandicap,0, hg1hrs, "ASSISTANT");
								amileage = amileage + mileagex;
								System.out.println("HigherGrade1 KM : " + hg1km+ " & " + mileagex + " : " + amileage);
							}
							if(blnGuard)
							{
								mileagex = me.getMileage("HigherGrade1",hg1km,
								blnHandicap,0, hg1hrs, "GUARD");
								gmileage = gmileage + mileagex;
								System.out.println("HigherGrade1 KM : " + hg1km+ " & " + mileagex + " : " + gmileage);
							}
						}
						if(hg2km >0)
						{
							if(blnDriver)
							{
								mileagex = me.getMileage("HigherGrade2",hg2km,
								blnHandicap,0, hg2hrs, "DRIVER");
								dmileage = dmileage + mileagex;
								System.out.println("HigherGrade2 KM : " + hg2km+ " & " + mileagex + " : " + dmileage);
							}
							if(blnAssistant)
							{
								mileagex = me.getMileage("HigherGrade2",hg2km,
								blnHandicap,0, hg2hrs, "ASSISTANT");
								amileage = amileage + mileagex;
								System.out.println("HigherGrade2 KM : " + hg2km+ " & " + mileagex + " : " + amileage);
							}
							if(blnGuard)
							{
								mileagex = me.getMileage("HigherGrade2",hg2km,
								blnHandicap,0, hg2hrs, "GUARD");
								gmileage = gmileage + mileagex;
								System.out.println("HigherGrade2 KM : " + hg2km+ " & " + mileagex + " : " + gmileage);
							}
						}
					}
					System.out.println("######################## MILEAGE CALCULATION ENDS ##################################");
									
					sda = new Double(jtfSDA.getText().trim()).doubleValue();
					out = new Vector();
					try
					{
						if(blnDriver)		
						{
							ndad = returnNDA(driverDate,signOfDate);
							if(from1.equals(depot))
							{
								hrestd = retHSRest("Driver",driverPfNo,blnContinuous);
								out.add(0,"0");
								out.add(1,"0");
							}
							if(!from1.equals(depot))
							{
								out.removeAllElements();
								out.trimToSize();
								out = retOSRest("Driver",driverPfNo);
								hrestd = 0;
							}
							System.out.println("HAHAHA");
							driverHours = ct.getHourBetween(driverDate,signOfDate);
							query ="insert into signoffdriver (CTRNo,TrainNo,StationFrom,StationTo,NameDriver,"+
								"PfNoDriver,date2,Departure,Arrival,date1,TotalKms,Shunting,"+
								"PilotDistance,Engine,Service,Load,Handicap,"+
								"StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,stationto7,stationto8,"+
								"stationto9,stationto10, stationto11,stationto12,"+
								"Siding,Siding2,Siding3,Siding4,Siding5,Siding6,Siding7,Siding8,Siding9,Siding10,"+
								"Siding11,Siding12,PilotFrom,PilotTo,PilotFrom1,"+
								"PilotTo1, pilotfrom2, pilotto2,Casualty,CasualtyOver,PilotHours, NDAHours, homestationrest, "+
									" outstationrest , oda, HOURS, mileage, intrainarrival, nrra, nca, sda, detention,"+
									"relief, relief1, relief2) "+
								" values (upper('"+strCtrNo+"'),'"+train1+"','"+from1+"','"+to1+"','"+driverName+
								"','"+driverPfNo+"',to_date('"+driverDate+"','mm/dd/yyyy hh24:mi'),"+
								"to_date('"+departureDate+"','mm/dd/yyyy hh24:mi'),"+
								"to_date('"+arrivalDate+"','mm/dd/yyyy hh24:mi'),to_date('"+signOfDate+	"','mm/dd/yyyy hh24:mi'),"+
								dist+","+shuntingHours+","+distPilot+",'"+
								engine1+"','"+service+"',"+ load1.substring(load1.lastIndexOf('/')+1)+","+iHandicap+",'"+
								to2+"','"+to3+"','"+to4+"','"+to5+"','"+to6+"','"+to7+"','"+to8+"','"+to9+
								"','"+to10+"','"+to11+"','"+to12+"','"+siding1+"','"+siding2+"','"+
								siding3+"','"+siding4+"','"+siding5+"','"+siding6+"','"+siding7+"','"+siding8+"','"+
								siding9+"','"+siding10+"','"+siding11+"','"+siding12+"','"+
								pilotFrom+"','"+pilotTo+"','"+pilotFrom1+"','"+
								pilotTo1+"','"+pilotFrom2+"','"+pilotTo2+"','WKG',1,"+	pilotHours+","+ndad+","+
								hrestd+","+out.elementAt(0)+","+out.elementAt(1)+","+driverHours+","+dmileage+", "+
								" to_date('"+inArrivalDate+	"','mm/dd/yyyy hh24:mi'),"+iNRRA+
								","+iNCA+","+sda+","+detention+",to_date('"+relief+"','mm/dd/yyyy hh24:mi'),"+
								"to_date('"+relief1+"','mm/dd/yyyy hh24:mi'),to_date('"+relief2+"','mm/dd/yyyy hh24:mi'))";
							
							System.out.println(query );
							stmt.addBatch(query );
							query = "insert into signoffcheckup(ctrno, name, pfno, designation , userentered) " + 
								" values('"+strCtrNo+"','"+driverName+"','"+driverPfNo+"','DRIVER','"+pword.username+"-'||to_char(sysdate,'mm/dd/yyyy hh24:mi'))";
							stmt.addBatch(query);
							if(blnContinuous)
							{
								query = " update signondriver set continuous=1,continuedate=to_date('"+
									driverDate +"','mm/dd/yyyy hh24:mi')  where pfnodriver='"+
									driverPfNo+"' and date1=(select max(date1) from signondriver where pfnodriver='"+
									driverPfNo+"')";
								System.out.println("son : " + query );
								stmt.addBatch(query );
							}
//							periodhoursd = upwhd.getUpdateWorkingHrsD(strCtrNo,driverDate,signOfDate, driverPfNo,driverName,blnBaseStation);
//							query = "Update periodhrsD set HoursWorked = "+periodhoursd+" where PfNoDriver='" +driverPfNo+"'";
//							System.out.println(query);
//							stmt.addBatch(query );
							cjdbc.executeProcedure("utilisationhours('"+signOfDate+"','"+driverPfNo+"','DRIVER')");
							query = "Update mileageD set mileage = mileage+"+dmileage+" where PfNoDriver='" +driverPfNo+"'";
							System.out.println(query);
							stmt.addBatch(query );
							
							mr.updateMuster(driverDate,signOfDate,driverPfNo,"P","Driver");
							if(!service.equals("HigherGrade1") || !service.equals("HigherGrade2"))
//								||!service.equals("Shunting")||!service.equals("LR"))
							{
								if(!blnOSD)
								{
									query = " update ctrlist set signon=to_date('"+driverDate+"','mm/dd/yyyy hh24:mi'),"+
																"signof=to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi') where namedriver='"+
																driverName+"' and ctrno ='"+ctr+"'";
									System.out.println(query );
								}
								else
								{
									query  = "insert into ctrlist(ctrno,namedriver,nameassistant, issued,signon,"+
																	"signof) values('"+ctrno+"','"+driverName+"','NIL',"+
																	"to_date('"+driverDate+"','mm/dd/yyyy hh24:mi'),"+
																	" to_date('"+driverDate+"','mm/dd/yyyy hh24:mi'),"+
																	" to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi'))";
									System.out.println(query );
								}
								stmt.addBatch(query );
								
								if(blnBaseStation)		
								{
									vhfno = jtfVHF.getText().trim();
									query = " update vhf set signon=to_date('"+driverDate+"','mm/dd/yyyy hh24:mi'),"+
																	"signof=to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi') where namedriver='"+
																	driverName+"' and vhfno ='"+vhfno+"'";
									System.out.println(query );

									stmt.addBatch(query );
									ptphoneno = jtfPTPhone.getText().trim();
									query = " update ptphone set signon=to_date('"+driverDate+"','mm/dd/yyyy hh24:mi'),"+
																	"signof=to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi') where namedriver='"+
																	driverName+"' and ptphoneno ='"+ptphoneno+"'";
									System.out.println(query );
									stmt.addBatch(query );
								}
							}							
						}
						
						if(blnGuard)			
						{
							ndag = returnNDA(guardDate,signOfDate);
							if(from1.equals(depot))
							{
								hrestg = retHSRest("Guard",guardPfNo,blnContinuous);
								out.add(0,"0");
								out.add(1,"0");
							}
							if(!from1.equals(depot))
							{
								out.removeAllElements();
								out.trimToSize();
								out = retOSRest("Guard",guardPfNo);
								hresta =0;
							}
							guardHours = ct.getHourBetween(guardDate,signOfDate);
							query ="insert into signoffguard (CTRNo,TrainNo,StationFrom,StationTo,NameGuard,"+
							"PfNoGuard,date2,Departure,Arrival,date1,TotalKms,Shunting,"+
							"PilotDistance,Engine,Service,Load,Handicap,"+
							"StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,stationto7,stationto8,"+
							"stationto9,stationto10, stationto11,stationto12,"+
							"Siding,Siding2,Siding3,Siding4,Siding5,Siding6,Siding7,Siding8,Siding9,Siding10,"+
							"Siding11,Siding12,PilotFrom,PilotTo,PilotFrom1,"+
							"PilotTo1, pilotfrom2, pilotto2,Casualty,CasualtyOver,PilotHours, NDAHours, homestationrest, "+
								" outstationrest , oda, hourS, mileage, intrainarrival, nrra, nca, sda, detention,"+
									"relief, relief1, relief2) "+
							" values (upper('"+strCtrNo+"'),'"+train1+"','"+from1+"','"+to1+"','"+guardName+
							"','"+guardPfNo+"',to_date('"+guardDate+"','mm/dd/yyyy hh24:mi'),"+
							"to_date('"+departureDate+"','mm/dd/yyyy hh24:mi'),"+
							"to_date('"+arrivalDate+"','mm/dd/yyyy hh24:mi'),to_date('"+signOfDate+	"','mm/dd/yyyy hh24:mi'),"+
							dist+","+shuntingHours+","+distPilot+",'"+
							engine1+"','"+service+"',"+ load1.substring(load1.lastIndexOf('/')+1)+","+iHandicap+",'"+
							to2+"','"+to3+"','"+to4+"','"+to5+"','"+to6+"','"+to7+"','"+to8+"','"+to9+
							"','"+to10+"','"+to11+"','"+to12+"','"+siding1+"','"+siding2+"','"+
							siding3+"','"+siding4+"','"+siding5+"','"+siding6+"','"+siding7+"','"+siding8+"','"+
							siding9+"','"+siding10+"','"+siding11+"','"+siding12+"','"+
							pilotFrom+"','"+pilotTo+"','"+pilotFrom1+"','"+
							pilotTo1+"','"+pilotFrom2+"','"+pilotTo2+"','WKG',1,"+	pilotHours+","+ndag+","+
							hrestg+","+out.elementAt(0)+","+out.elementAt(1)+","+guardHours+","+gmileage+", "+
								" to_date('"+inArrivalDate+	"','mm/dd/yyyy hh24:mi'),"+iNRRA+
								","+iNCA+","+sda+","+detention+",to_date('"+relief+"','mm/dd/yyyy hh24:mi'),"+
								"to_date('"+relief1+"','mm/dd/yyyy hh24:mi'),to_date('"+relief2+"','mm/dd/yyyy hh24:mi'))";
							System.out.println("gUARD: " + query );
							stmt.addBatch(query );
									query = "insert into signoffcheckup(ctrno, name, pfno, designation , userentered) " + " values('"+strCtrNo+"','"+guardName+"','"+guardPfNo+"','GUARD','"+pword.username+" -'||to_char(sysdate,'mm/dd/yyyy hh24:mi'))";
							stmt.addBatch(query);
							if(blnContinuous)
							{
								query = " update signonguard set continuous=1,continuedate=to_date('"+
									guardDate +"','mm/dd/yyyy hh24:mi') where pfnoguard='"+
									guardPfNo+"' and date1=(select max(date1) from signonguard where pfnoguard='"+
									guardPfNo+"')";
								stmt.addBatch(query );
							}
//							periodhoursg = upwhg.getUpdateWorkingHrsG(strCtrNo,guardDate,signOfDate, guardPfNo,guardName,blnBaseStation);
//							query = "Update periodhrsG set HoursWorked = "+periodhoursg+" where PfNoGuard='" +guardPfNo+"'";
//							System.out.println(query);
//							stmt.addBatch(query );
							cjdbc.executeProcedure("utilisationhours('"+signOfDate+"','"+guardPfNo+"','GUARD')");
							query = "Update MileageG set mileage = mileage+"+gmileage+" where PfNoGuard='" +guardPfNo+"'";
							System.out.println(query);
							stmt.addBatch(query );
								
							mr.updateMuster(guardDate,signOfDate,guardPfNo,"P","Guard");
						}
						
						if(blnAssistant)		
						{
							ndaa = returnNDA(assistantDate,signOfDate);
							if(from1.equals(depot))
							{
								hresta = retHSRest("Assistant",assistantPfNo,blnContinuous);
								out.add(0,"0");
								out.add(1,"0");
							}
							if(!from1.equals(depot))
							{
								out.add(0,"0");
								out.add(1,"0");
								out.removeAllElements();
								out.trimToSize();
								out = retOSRest("Assistant",assistantPfNo);
								hresta = 0;
							}
							assistantHours = ct.getHourBetween(assistantDate,signOfDate);
							query ="insert into signoffassistant (CTRNo,TrainNo,StationFrom,StationTo,Nameassistant,"+
							"PfNoassistant,date2,Departure,Arrival,date1,TotalKms,Shunting,"+
							"PilotDistance,Engine,Service,Load,Handicap,"+
							"StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,stationto7,stationto8,"+
							"stationto9,stationto10, stationto11,stationto12,"+
							"Siding,Siding2,Siding3,Siding4,Siding5,Siding6,Siding7,Siding8,Siding9,Siding10,"+
							"Siding11,Siding12,PilotFrom,PilotTo,PilotFrom1,"+
							"PilotTo1, pilotfrom2, pilotto2,Casualty,CasualtyOver,PilotHours, NDAHours, homestationrest, "+
							" outstationrest , oda, hours, mileage, intrainarrival, nrra, nca, sda, detention,"+
									"relief, relief1, relief2) "+
							" values (upper('"+strCtrNo+"'),'"+train1+"','"+from1+"','"+to1+"','"+assistantName+
							"','"+assistantPfNo+"',to_date('"+assistantDate+"','mm/dd/yyyy hh24:mi'),"+
							"to_date('"+departureDate+"','mm/dd/yyyy hh24:mi'),"+
							"to_date('"+arrivalDate+"','mm/dd/yyyy hh24:mi'),to_date('"+signOfDate+	"','mm/dd/yyyy hh24:mi'),"+
							dist+","+shuntingHours+","+distPilot+",'"+
							engine1+"','"+service+"',"+ load1.substring(load1.lastIndexOf('/')+1)+","+iHandicap+",'"+
							to2+"','"+to3+"','"+to4+"','"+to5+"','"+to6+"','"+to7+"','"+to8+"','"+to9+
							"','"+to10+"','"+to11+"','"+to12+"','"+siding1+"','"+siding2+"','"+
							siding3+"','"+siding4+"','"+siding5+"','"+siding6+"','"+siding7+"','"+siding8+"','"+
							siding9+"','"+siding10+"','"+siding11+"','"+siding12+"','"+
							pilotFrom+"','"+pilotTo+"','"+pilotFrom1+"','"+
							pilotTo1+"','"+pilotFrom2+"','"+pilotTo2+"','WKG',1,"+	pilotHours+","+ndaa+","+
							hresta+","+out.elementAt(0)+","+out.elementAt(1)+","+assistantHours+","+amileage+", "+
								" to_date('"+inArrivalDate+	"','mm/dd/yyyy hh24:mi'),"+iNRRA+
								","+iNCA+","+sda+","+detention+",to_date('"+relief+"','mm/dd/yyyy hh24:mi'),"+
								"to_date('"+relief1+"','mm/dd/yyyy hh24:mi'),to_date('"+relief2+"','mm/dd/yyyy hh24:mi'))";
								System.out.println(query );
								stmt.addBatch(query );
								query = "insert into signoffcheckup(ctrno, name, pfno, designation , userentered) " + " values('"+strCtrNo+"','"+assistantName+"','"+assistantPfNo+"','ASSISTANT','"+pword.username+" -'||to_char(sysdate,'mm/dd/yyyy hh24:mi'))";
							stmt.addBatch(query);
							if(blnContinuous)
							{
								query = " update signonassistant set continuous=1,continuedate=to_date('"+
									assistantDate +"','mm/dd/yyyy hh24:mi')  where pfnoassistant='"+
									assistantPfNo+"' and date1=(select max(date1) from signonassistant where pfnoassistant='"+
									assistantPfNo+"')";
								System.out.println("son : " + query );
								stmt.addBatch(query );
							}
							cjdbc.executeProcedure("utilisationhours('"+signOfDate+"','"+assistantPfNo+"','ASSISTANT')");
//							periodhoursa = upwha.getUpdateWorkingHrsA(strCtrNo,assistantDate,signOfDate, assistantPfNo,assistantName,blnBaseStation);
//							query = "Update periodhrsA set HoursWorked = "+periodhoursa+" where PfNoassistant='" +assistantPfNo+"'";
//							System.out.println(query);
//							stmt.addBatch(query );
							query = "Update MileageA set mileage = mileage+"+amileage+" where PfNoassistant='" +assistantPfNo+"'";
							System.out.println(query);
							stmt.addBatch(query );

								
							mr.updateMuster(assistantDate,signOfDate,assistantPfNo,"P","Assistant");
							if(!blnDriver)
							{
								if(!service.equals("HigherGrade1") || !service.equals("HigherGrade2"))
//									||!service.equals("Shunting")||service.equals("LR"))
								{
									if(!blnOSA)
									{
										query = " update ctrlist set signon=to_date('"+assistantDate+"','mm/dd/yyyy hh24:mi'),"+
																"signof=to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi') where nameassistant='"+
																assistantName+"' and ctrno ='"+ctr+"'";
									}
									else
									{
										query  = "insert into ctrlist(ctrno,namedriver,nameassistant,issued,signon,signof) values('"+
																		ctrno+"','NIL','"+assistantName+"',to_date('"+assistantDate+"','mm/dd/yyyy hh24:mi'),"+
																		" to_date('"+assistantDate+"','mm/dd/yyyy hh24:mi'),"+
																		" to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi'))";
									}
									System.out.println(query );
									stmt.addBatch(query );
									if(blnBaseStation)		
									{
										vhfno = jtfVHF.getText().trim();
										query = " update vhf set signon=to_date('"+assistantDate+"','mm/dd/yyyy hh24:mi'),"+
																		"signof=to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi') where nameassistant='"+
																		assistantName+"' and vhfno ='"+vhfno+"'";
										System.out.println(query );
										stmt.addBatch(query );
										String ptphoneno = jtfPTPhone.getText().trim();
										query = " update ptphone set signon=to_date('"+assistantDate+"','mm/dd/yyyy hh24:mi'),"+
																		"signof=to_date('"+signOfDate+"','mm/dd/yyyy hh24:mi') where nameassistant='"+
																		assistantName+"' and ptphoneno ='"+ptphoneno+"'";
									System.out.println(query );
										stmt.addBatch(query );
									}
								}
							}							
						}
						String LRValidTo = at.getHourAdd(signOfDate,2160);
						try
						{
							if(service1.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service2.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service3.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service4.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service5.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service6.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service7.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service8.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service9.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service10.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service11.equals("Pilot"))
							{	
								blnLRS = true;
							}
							else if(service12.equals("Pilot"))
							{	
								blnLRS = true;
							}							
						}
						catch(Exception lre11)
						{
						}
						System.out.println("Bln LRS : " + blnLRS);
						if(blnLRS)
						{
							try
							{
								if(!section1.equals(null))
								{	
									lrsection = section1;								
								}
								if(!section2.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section2.substring(section2.indexOf('_')+1);
								}
								if(!section3.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section3.substring(section3.indexOf('_')+1);
								}
								if(!section4.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section4.substring(section4.indexOf('_')+1);
								}
								if(!section5.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section5.substring(section5.indexOf('_')+1);
								}
								if(!section6.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section6.substring(section6.indexOf('_')+1);
								}
								if(!section7.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section7.substring(section7.indexOf('_')+1);
								}
								if(!section8.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section8.substring(section8.indexOf('_')+1);
								}
								if(!section9.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section9.substring(section9.indexOf('_')+1);
								}
								if(!section10.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section10.substring(section10.indexOf('_')+1);
								}
								if(!section11.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section11.substring(section11.indexOf('_')+1);
								}
								if(!section12.equals(null))
								{	
									lrsection = lrsection.substring(0,lrsection.indexOf('_')) + "_"+
																	section12.substring(section12.indexOf('_')+1);
								}
							}
							catch(Exception lre1)
							{
							}
						}
						else
						{
							lrsection = "";
						}
						if(!lrsection.equals(""))
						{
							try
							{
								query = " select stationname from lrstation where stationname = '"+lrsection+"'";
								vector = snv.getStationNameList("",query);
								vector.trimToSize();

								if(!lrstation.equals((String)vector.elementAt(0)))
								{
									lrsection = "";
								}
							if((lrsection.substring(0,lrsection.indexOf('_'))).equals(lrsection.substring(lrsection.indexOf('_')+1)))
								{
									lrsection = "";
								}							
							}
							catch(Exception ex)
							{
								lrsection = "";
							}
						}
						System.out.println("&&&&&&&&&&&&& LR : " + lrsection);
						blnLRPilot = false;
						if(blnDriver)
						{
							LRValidTo = at.getHourAdd(signOfDate,2160);
//							if(sLRCode!="")
							{
								try
								{
									if(!section1.equals(null))
									{	
										if(!service1.equals("Pilot"))
										{
											updateLR(section1, LRValidTo, driverPfNo, "DRIVER");					
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section2.equals(null))
									{	
										if(!service2.equals("Pilot"))
										{
											updateLR(section2, LRValidTo, driverPfNo, "DRIVER");						
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section3.equals(null))
									{	
										if(!service3.equals("Pilot"))
										{
											updateLR(section3, LRValidTo, driverPfNo, "DRIVER");							
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section4.equals(null))
									{	
										if(!service4.equals("Pilot"))
										{
											updateLR(section4, LRValidTo, driverPfNo, "DRIVER");						
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section5.equals(null))
									{	
										if(!service5.equals("Pilot"))
										{
											updateLR(section5, LRValidTo, driverPfNo, "DRIVER");			
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section6.equals(null))
									{	
										if(!service6.equals("Pilot"))
										{
											updateLR(section6, LRValidTo, driverPfNo, "DRIVER");								
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section7.equals(null))
									{	
										if(!service7.equals("Pilot"))
										{
											updateLR(section7, LRValidTo, driverPfNo, "DRIVER");							
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section8.equals(null))
									{	
										if(!service8.equals("Pilot"))
										{
											updateLR(section8, LRValidTo, driverPfNo, "DRIVER");						
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section9.equals(null))
									{	
										if(!service9.equals("Pilot"))
										{
											updateLR(section9, LRValidTo, driverPfNo, "DRIVER");								
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section10.equals(null))
									{	
										if(!service10.equals("Pilot"))
										{
											updateLR(section10, LRValidTo, driverPfNo, "DRIVER");							
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section11.equals(null))
									{	
										if(!service11.equals("Pilot"))
										{
											updateLR(section11, LRValidTo, driverPfNo, "DRIVER");								
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section12.equals(null))
									{	
										if(!service12.equals("Pilot"))
										{
											updateLR(section12, LRValidTo, driverPfNo, "DRIVER");							
										}
										else
										{
											blnLRPilot = true;
										}
									}
								}
								catch(Exception lre)
								{
									blnLRPilot = false;
								}
								try
								{
									if(!siding1.equals(null))
									{	
										if(!service1.equals("Pilot"))
										{
											updateLR(siding1, LRValidTo, driverPfNo, "DRIVER");					
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding2.equals(null))
									{	
										if(!service2.equals("Pilot"))
										{
											updateLR(siding2, LRValidTo, driverPfNo, "DRIVER");						
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding3.equals(null))
									{
										if(!service3.equals("Pilot"))
										{
											updateLR(siding3, LRValidTo, driverPfNo, "DRIVER");							
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding4.equals(null))
									{	
										if(!service4.equals("Pilot"))
										{
											updateLR(siding4, LRValidTo, driverPfNo, "DRIVER");						
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding5.equals(null))
									{	
										if(!service5.equals("Pilot"))
										{
											updateLR(siding5, LRValidTo, driverPfNo, "DRIVER");			
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding6.equals(null))
									{	
										if(!service6.equals("Pilot"))
										{
											updateLR(siding6, LRValidTo, driverPfNo, "DRIVER");								
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding7.equals(null))
									{	
										if(!service7.equals("Pilot"))
										{
											updateLR(siding7, LRValidTo, driverPfNo, "DRIVER");							
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding8.equals(null))
									{	
										if(!service9.equals("Pilot"))
										{
											updateLR(siding8, LRValidTo, driverPfNo, "DRIVER");						
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding9.equals(null))
									{	
										if(!service10.equals("Pilot"))
										{
											updateLR(siding9, LRValidTo, driverPfNo, "DRIVER");								
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding10.equals(null))
									{	
										if(!service10.equals("Pilot"))
										{
											updateLR(siding10, LRValidTo, driverPfNo, "DRIVER");							
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding11.equals(null))
									{	
										if(!service11.equals("Pilot"))
										{
											updateLR(siding11, LRValidTo, driverPfNo, "DRIVER");								
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!siding12.equals(null))
									{	
										if(!service12.equals("Pilot"))
										{
											updateLR(siding12, LRValidTo, driverPfNo, "DRIVER");							
										}
										else
										{
											blnLRPilot = true;
										}
									}
								}
								catch(Exception lre1)
								{
									blnLRPilot = false;
								}
							}
						}
						if(blnGuard)
						{
							LRValidTo = at.getHourAdd(signOfDate,2160);
//							if(sLRCode!="")
							{
								try
								{
									if(!section1.equals(null))
									{
										if(!service1.equals("Pilot"))
										{
											updateLR(section1, LRValidTo, guardPfNo, "GUARD");					
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section2.equals(null))
									{	
										if(!service2.equals("Pilot"))
										{
											updateLR(section2, LRValidTo, guardPfNo, "GUARD");						
										}
										else
										{
											blnLRPilot = true;
										}
									}
									if(!section3.equals(null))
									{	
										if(!service3.equals("Pilot"))
										{
											updateLR(section3, LRValidTo, guardPfNo, "GUARD");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section4.equals(null))
									{	
										if(!service4.equals("Pilot"))
										{
											updateLR(section4, LRValidTo, guardPfNo, "GUARD");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section5.equals(null))
									{	
										if(!service5.equals("Pilot"))
										{
											updateLR(section5, LRValidTo, guardPfNo, "GUARD");			
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section6.equals(null))
									{
										if(!service6.equals("Pilot"))
										{
										updateLR(section6, LRValidTo, guardPfNo, "GUARD");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section7.equals(null))
									{	
										if(!service7.equals("Pilot"))
										{
										updateLR(section7, LRValidTo, guardPfNo, "GUARD");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section8.equals(null))
									{	
										if(!service8.equals("Pilot"))
										{
										updateLR(section8, LRValidTo, guardPfNo, "GUARD");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section9.equals(null))
									{	
										if(!service9.equals("Pilot"))
										{
										updateLR(section9, LRValidTo, guardPfNo, "GUARD");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section10.equals(null))
									{	
										if(!service10.equals("Pilot"))
										{
										updateLR(section10, LRValidTo, guardPfNo, "GUARD");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section11.equals(null))
									{	
										if(!service11.equals("Pilot"))
										{
										updateLR(section11, LRValidTo, guardPfNo, "GUARD");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section12.equals(null))
									{	
										if(!service12.equals("Pilot"))
										{
										updateLR(section12, LRValidTo, guardPfNo, "GUARD");							
										}else
										{
											blnLRPilot = true;
										}
									}
								}
								catch(Exception e1)
								{
								}
								try
								{
									if(!siding1.equals(null))
									{	
										if(!service1.equals("Pilot"))
										{
										updateLR(siding1, LRValidTo, guardPfNo, "GUARD");					
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding2.equals(null))
									{	
										if(!service2.equals("Pilot"))
										{
										updateLR(siding2, LRValidTo, guardPfNo, "GUARD");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding3.equals(null))
									{	
										if(!service3.equals("Pilot"))
										{
										updateLR(siding3, LRValidTo, guardPfNo, "GUARD");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding4.equals(null))
									{	
										if(!service4.equals("Pilot"))
										{
										updateLR(siding4, LRValidTo, guardPfNo, "GUARD");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding5.equals(null))
									{	
										if(!service5.equals("Pilot"))
										{
										updateLR(siding5, LRValidTo, guardPfNo, "GUARD");			
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding6.equals(null))
									{	
										if(!service6.equals("Pilot"))
										{
										updateLR(siding6, LRValidTo, guardPfNo, "GUARD");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding7.equals(null))
									{	
										if(!service7.equals("Pilot"))
										{
										updateLR(siding7, LRValidTo, guardPfNo, "GUARD");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding8.equals(null))
									{	
										if(!service8.equals("Pilot"))
										{
										updateLR(siding8, LRValidTo, guardPfNo, "GUARD");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding9.equals(null))
									{	
										if(!service9.equals("Pilot"))
										{
										updateLR(siding9, LRValidTo, guardPfNo, "GUARD");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding10.equals(null))
									{	
										if(!service10.equals("Pilot"))
										{
										updateLR(siding10, LRValidTo, guardPfNo, "GUARD");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding11.equals(null))
									{	
										if(!service11.equals("Pilot"))
										{
										updateLR(siding11, LRValidTo, guardPfNo, "GUARD");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding12.equals(null))
									{	
										if(!service12.equals("Pilot"))
										{
										updateLR(siding12, LRValidTo, guardPfNo, "GUARD");							
										}else
										{
											blnLRPilot = true;
										}
									}
								}
								catch(Exception e2)
								{
								}
							}
						}
						if(blnAssistant)
						{
							LRValidTo = at.getHourAdd(signOfDate,2160);
//							if(sLRCode!="")
							{
								try
								{
									if(!section1.equals(null))
									{	
										if(!service1.equals("Pilot"))
										{
										updateLR(section1, LRValidTo, assistantPfNo, "ASSISTANT");					
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section2.equals(null))
									{	
										if(!service2.equals("Pilot"))
										{
										updateLR(section2, LRValidTo, assistantPfNo, "ASSISTANT");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section3.equals(null))
									{	
										if(!service3.equals("Pilot"))
										{
										updateLR(section3, LRValidTo, assistantPfNo, "ASSISTANT");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section4.equals(null))
									{	
										if(!service4.equals("Pilot"))
										{
										updateLR(section4, LRValidTo, assistantPfNo, "ASSISTANT");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section5.equals(null))
									{	
										if(!service5.equals("Pilot"))
										{
										updateLR(section5, LRValidTo, assistantPfNo, "ASSISTANT");			
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section6.equals(null))
									{	
										if(!service6.equals("Pilot"))
										{
										updateLR(section6, LRValidTo, assistantPfNo, "ASSISTANT");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section7.equals(null))
									{	
										if(!service7.equals("Pilot"))
										{
										updateLR(section7, LRValidTo, assistantPfNo, "ASSISTANT");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section8.equals(null))
									{	
										if(!service8.equals("Pilot"))
										{
										updateLR(section8, LRValidTo, assistantPfNo, "ASSISTANT");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section9.equals(null))
									{	
										if(!service9.equals("Pilot"))
										{
										updateLR(section9, LRValidTo, assistantPfNo, "ASSISTANT");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section10.equals(null))
									{	
										if(!service10.equals("Pilot"))
										{
										updateLR(section10, LRValidTo, assistantPfNo, "ASSISTANT");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section11.equals(null))
									{	
										if(!service11.equals("Pilot"))
										{
										updateLR(section11, LRValidTo, assistantPfNo, "ASSISTANT");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!section12.equals(null))
									{	
										if(!service12.equals("Pilot"))
										{
										updateLR(section12, LRValidTo, assistantPfNo, "ASSISTANT");							
										}else
										{
											blnLRPilot = true;
										}
									}
								}
								catch(Exception e2)
								{
								}
								try
								{
									if(!siding1.equals(null))
									{	
										if(!service1.equals("Pilot"))
										{
										updateLR(siding1, LRValidTo, assistantPfNo, "ASSISTANT");					
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding2.equals(null))
									{	
										if(!service2.equals("Pilot"))
										{
										updateLR(siding2, LRValidTo, assistantPfNo, "ASSISTANT");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding3.equals(null))
									{	
										if(!service3.equals("Pilot"))
										{
										updateLR(siding3, LRValidTo, assistantPfNo, "ASSISTANT");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding4.equals(null))
									{	
										if(!service4.equals("Pilot"))
										{
										updateLR(siding4, LRValidTo, assistantPfNo, "ASSISTANT");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding5.equals(null))
									{	
										if(!service5.equals("Pilot"))
										{
										updateLR(siding5, LRValidTo, assistantPfNo, "ASSISTANT");			
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding6.equals(null))
									{	
										if(!service6.equals("Pilot"))
										{
										updateLR(siding6, LRValidTo, assistantPfNo, "ASSISTANT");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding7.equals(null))
									{	
										if(!service7.equals("Pilot"))
										{
										updateLR(siding7, LRValidTo, assistantPfNo, "ASSISTANT");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding8.equals(null))
									{	
										if(!service8.equals("Pilot"))
										{
										updateLR(siding8, LRValidTo, assistantPfNo, "ASSISTANT");						
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding9.equals(null))
									{	
										if(!service9.equals("Pilot"))
										{
										updateLR(siding9, LRValidTo, assistantPfNo, "ASSISTANT");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding10.equals(null))
									{	
										if(!service10.equals("Pilot"))
										{
										updateLR(siding10, LRValidTo, assistantPfNo, "ASSISTANT");							
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding11.equals(null))
									{	
										if(!service11.equals("Pilot"))
										{
										updateLR(siding11, LRValidTo, assistantPfNo, "ASSISTANT");								
										}else
										{
											blnLRPilot = true;
										}
									}
									if(!siding12.equals(null))
									{	
										if(!service12.equals("Pilot"))
										{
										updateLR(siding12, LRValidTo, assistantPfNo, "ASSISTANT");							
										}else
										{
											blnLRPilot = true;
										}
									}
								}
								catch(Exception ex)
								{
								}
							}							
						}
/*						int B[] = stmt.executeBatch();
							con.commit();
							stmt.clearBatch();
*/
						System.out.println("Contnuous  : " + ddate1+ " : " +adate1+ " : " + gdate1);
						if(blnDriver)
						{
							if(ddate1.equals("") || ddate1 == "")
							{
								dutyHourDriver =	ct.getHourBetween(signOfDate,driverDate);
							}
							else
							{
								dutyHourDriver =	ct.getHourBetween(signOfDate,ddate1);
								ddate1 = "";
							}
						}
						if(blnAssistant)
						{
							if(adate1.equals("") || adate1 == "" )
							{
								dutyHourAssistant = ct.getHourBetween(signOfDate,assistantDate);
							}
							else
							{
								dutyHourAssistant = ct.getHourBetween(signOfDate,adate1);
								adate1 = "";
							}
						}
						if(blnGuard)
						{
							if(gdate1.equals("") || gdate1 == "" )
							{
								dutyHourGuard = ct.getHourBetween(signOfDate,guardDate);
							}
							else
							{
								dutyHourGuard = ct.getHourBetween(signOfDate,gdate1);
								gdate1 = "";
							}
						}
						System.out.println(" Rest HOurs : "+dutyHourDriver+" $$$$$ "+dutyHourAssistant + 
							" : " + dutyHourGuard);
//						String RestTo = "";//,RestToAssistant, RestToGuard;
						System.out.println("HAHAHA1");
						try
						{
							if(blnDriver)	
							{
								System.out.println("HAHAHA2");
								if(dutyHourDriver >= 8)
								{
									RestTo = at.getHourAdd(signOfDate,16);
								}
								else
								{
									RestTo = at.getHourAdd(signOfDate,12);	
								}
								System.out.println("HAHAHA3");
								if(blnBaseStation)	
								{
	//Addition for auto PR

							query = "select ctrno,to_char(date1,'mm/dd/yyyy hh24:mi') signon from curronlined "+
								" where namedriver='"+driverName+"' ";
							vecCtrD = qtm.setQuery("",query );
							System.out.println(" Out of HQ:"+vecCtrD.size()+": "+query);
							if(vecCtrD.size()>0)
							{
								ctrnos = ((String[])vecCtrD.elementAt(0))[0]; //(String) vecCtrD.elementAt(0);
								outofhqD = ((String[])vecCtrD.elementAt(0))[1];
							System.out.println(" Signon at HQ :"+outofhqD);
							}
	//
									query =	"delete from CurrOnlineD where (PfNoDriver ='"+	driverPfNo+"')";
									System.out.println(query );
									stmt.addBatch(query );
							
									query  =	"insert into Currrestd(NameDriver,PfNoDriver,RestFrom,RestTo,  mileage)"+
											" values ('"+driverName+"','"+driverPfNo+"',to_date('"+
											signOfDate+"','mm/dd/yyyy hh24:mi'),to_date('"+RestTo+"','mm/dd/yyyy hh24:mi'),"+
										mileage+")";
									System.out.println(query );
									stmt.addBatch(query );
									query = " update currrestd set hoursworked = (select hoursworked from "+
										" periodhrsd where pfnodriver = '"+driverPfNo+"'), mileage = (select mileage from "+
										" mileaged where pfnodriver = '"+driverPfNo+"') " + 
										" where pfnodriver = '"+driverPfNo+"'";
									System.out.println(query );
									stmt.addBatch(query );
									System.out.println("Out of HQ Driver : " + signOfDate+ " : " +outofhqD);
									xhours=0;
									xhours = ct.getHourBetween(outofhqD, signOfDate);
									if(xhours >60.0)
									{
										JOptionPane.showMessageDialog(null,"Driver is out of HQ for morethan " + xhours +
										" He is being granted automatic PR ",
										"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
										query = " insert into PRd(NameDriver,PfNoDriver,PRFrom,PRTo,NoOfPR,PRHours, "+
											" userentered)  values('"+driverName+"','"+driverPfNo+"',to_date('"+signOfDate+
												"','mm/dd/yyyy hh24:mi'),to_date('"+signOfDate + 
											"','mm/dd/yyyy hh24:mi')+(30/24),1,30,'System(OOHQ) -'||to_char(sysdate,'mm/dd/yyyy hh24:mi'))";
										System.out.println(query );
										stmt.addBatch(query);

										query = " update currrestd set restto = restfrom+30/24 , prissued=1 where pfnodriver = '"+driverPfNo+"' ";
										System.out.println(query );
										stmt.addBatch(query );
									}									
								}
							}
							
							if(blnGuard)	
							{
								if(dutyHourGuard >= 8)
									RestTo = at.getHourAdd(signOfDate,16);
								else
									RestTo = at.getHourAdd(signOfDate,12);				
								if(blnBaseStation)	
								{
									query =	"delete from CurrOnlineG where (PfNoGuard ='"+ guardPfNo+"')";
									System.out.println(query );
									stmt.addBatch(query );

									query  =	"insert into CurrrestG (NameGuard,PfNoGuard,RestFrom,RestTo, mileage)"+
										" values ('"+guardName+"','"+guardPfNo+"',to_date('"+	signOfDate+
										"','mm/dd/yyyy hh24:mi'),to_date('"+RestTo+"','mm/dd/yyyy hh24:mi'),"+
										mileage+")";
									System.out.println(query );
									stmt.addBatch(query );
									query = " update currrestg set hoursworked = (select hoursworked from "+
										" periodhrsg where pfnoguard = '"+guardPfNo+"'), mileage =  (select mileage from "+
										" mileageg where pfnoguard = '"+guardPfNo+"') "+
										" where pfnoguard = '"+guardPfNo+"'";
									System.out.println(query );
									stmt.addBatch(query );

									System.out.println("Out of HQ Guard : " + signOfDate+ " : " +outofhqG);
									xhours=0;
									xhours = ct.getHourBetween(outofhqG, signOfDate);
									if(xhours >60.0)
									{
										JOptionPane.showMessageDialog(null,"Guard is out of HQ for morethan " + xhours +
										" He is being granted automatic PR ",
																"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
										query = " insert into PRG(Nameguard,PfNoguard,PRFrom,PRTo,NoOfPR,PRHours, "+
											" userentered)  values('"+guardName+"','"+guardPfNo+"',to_date('"+signOfDate+
												"','mm/dd/yyyy hh24:mi'),to_date('"+signOfDate + 
											"','mm/dd/yyyy hh24:mi')+(30/24),1,30,'System(OOHQ) -'||to_char(sysdate,'mm/dd/yyyy hh24:mi'))";
										System.out.println(query );
										stmt.addBatch(query);

										query = " update currrestg set restto = restfrom+30/24 , prissued=1 where pfnoguard = '"+guardPfNo+"' ";
										System.out.println(query );
										stmt.addBatch(query );
									}
								}
							}
							
							if(blnAssistant)	
							{
								System.out.println("HAHAHA4");
								if(dutyHourAssistant >= 8)
								{
									RestTo = at.getHourAdd(signOfDate,16);
								}
								else
								{
									RestTo = at.getHourAdd(signOfDate,12);				
								}
								System.out.println("HAHAHA5");
								if(blnBaseStation)	
								{
									query ="delete from CurrOnlineAD where (PfNoAssistant ='"+assistantPfNo+"')";
									System.out.println(query );
									stmt.addBatch(query );
									query  ="insert into Currrestad (NameAssistant,PfNoAssistant,RestFrom,RestTo, mileage)"+
										" values ('"+assistantName+"','"+assistantPfNo+"',to_date('"+	signOfDate+
										"','mm/dd/yyyy hh24:mi'),to_date('"+RestTo+"','mm/dd/yyyy hh24:mi'),"+
										mileage+")";
									System.out.println(query );
									stmt.addBatch(query );
									query = " update currrestad set hoursworked = (select hoursworked from "+
										" periodhrsa where pfnoassistant = '"+assistantPfNo+"'), mileage = (select mileage from "+
										" mileagea where pfnoassistant = '"+assistantPfNo+"') "+
										" where pfnoassistant = '"+assistantPfNo+"'";
									System.out.println(query );
									stmt.addBatch(query );
	//								new insertSQL("",query );
									System.out.println("Out of HQ assistant Driver : " + signOfDate+ " : " +outofhqAD);
									xhours=0;
									xhours = ct.getHourBetween(outofhqAD, signOfDate);
									if(xhours >60.0)
									{
										JOptionPane.showMessageDialog(null,"AssistantDriver is out of HQ for morethan " + xhours +
										" He is being granted automatic PR ",
																"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
										query = " insert into PRad(Nameassistant,PfNoassistant,PRFrom,PRTo,NoOfPR,PRHours, "+
											" userentered)  values('"+assistantName+"','"+assistantPfNo+"',to_date('"+signOfDate+
												"','mm/dd/yyyy hh24:mi'),to_date('"+signOfDate + 
											"','mm/dd/yyyy hh24:mi')+(30/24),1,30,'System(OOHQ) -'||to_char(sysdate,'mm/dd/yyyy hh24:mi'))";
										System.out.println(query );
										stmt.addBatch(query);

										query = " update currrestad set restto = restfrom+30/24 , prissued=1 where pfnoassistant = '"+assistantPfNo+"' ";
										System.out.println(query );
										stmt.addBatch(query );
									}
								}
							}
						}
						catch(Exception exx)
						{
							System.out.println("in rest calculation");
							exx.printStackTrace();
						}
							int a[] = stmt.executeBatch();
							con.commit();
							stmt.clearBatch();
						}
						catch(Exception ex1)
						{
							con.rollback();
							ex1.printStackTrace();
							JOptionPane.showMessageDialog(panel1,	ex1.getMessage(),
																"Click OK to Continue",JOptionPane.ERROR_MESSAGE);
										return;						
						}
						if(blnBaseStation)
						{
							if(blnAssistant)
							{
								cjdbc.executeProcedure("utilisationhours('"+signOfDate+"','"+assistantPfNo+"','ASSISTANT')");
							}
							if(blnDriver)
							{
								cjdbc.executeProcedure("utilisationhours('"+signOfDate+"','"+driverPfNo+"','DRIVER')");
							}
							if(blnGuard)
							{
								cjdbc.executeProcedure("utilisationhours('"+signOfDate+"','"+guardPfNo+"','GUARD')");
							}
						}
						
						try
						{
							if(!service1.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
									 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
									 "','mm/dd/yyyy hh24:mi'),'"+train1+"','"+engine1+"','"+service1+"','"+
									 from1+"','"+to1+"','"+siding1+"','"+load1+"',"+dist1+
									 ",to_date('"+ddep1+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr1+
									 "','mm/dd/yyyy hh24:mi'),'"+section1+"')";
									System.out.println(" 1 : " + query );
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
									 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
									 "','mm/dd/yyyy hh24:mi'),'"+train1+"','"+engine1+"','"+service1+"','"+
									 from1+"','"+to1+"','"+siding1+"','"+load1+"',"+dist1+
									 ",to_date('"+ddep1+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr1+
									 "','mm/dd/yyyy hh24:mi'),'"+section1+"')";
									System.out.println(" 1 : " + query );
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
									 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
									 "','mm/dd/yyyy hh24:mi'),'"+train1+"','"+engine1+"','"+service1+"','"+
									 from1+"','"+to1+"','"+siding1+"','"+load1+"',"+dist1+
									 ",to_date('"+ddep1+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr1+
									 "','mm/dd/yyyy hh24:mi'),'"+section1+"')";
									System.out.println(" 1 : " + query );
									stmt.addBatch(query );
								}
							}
							if(!service2.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train2+"','"+engine2+"','"+service2+"','"+
													 from2+"','"+to2+"','"+siding2+"','"+load2+"',"+dist2+
													 ",to_date('"+ddep2+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr2+
													 "','mm/dd/yyyy hh24:mi'),'"+section2+"')";
									System.out.println(" 2 : " + query );
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train2+"','"+engine2+"','"+service2+"','"+
													 from2+"','"+to2+"','"+siding2+"','"+load2+"',"+dist2+
													 ",to_date('"+ddep2+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr2+
													 "','mm/dd/yyyy hh24:mi'),'"+section2+"')";
									System.out.println(" 2 : " + query );
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train2+"','"+engine2+"','"+service2+"','"+
													 from2+"','"+to2+"','"+siding2+"','"+load2+"',"+dist2+
													 ",to_date('"+ddep2+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr2+
													 "','mm/dd/yyyy hh24:mi'),'"+section2+"')";
									System.out.println(" 2 : " + query );
									stmt.addBatch(query );
								}								
							}
							if(!service3.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+
													 strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train3+"','"+engine3+"','"+service3+"','"+
													 from3+"','"+to3+"','"+siding3+"','"+load3+"',"+dist3+
													 ",to_date('"+ddep3+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr3+
													 "','mm/dd/yyyy hh24:mi'),'"+section3+"')";
									System.out.println(" 3 : " + query );
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+
													 strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train3+"','"+engine3+"','"+service3+"','"+
													 from3+"','"+to3+"','"+siding3+"','"+load3+"',"+dist3+
													 ",to_date('"+ddep3+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr3+
													 "','mm/dd/yyyy hh24:mi'),'"+section3+"')";
									System.out.println(" 3 : " + query );
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+
													 strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train3+"','"+engine3+"','"+service3+"','"+
													 from3+"','"+to3+"','"+siding3+"','"+load3+"',"+dist3+
													 ",to_date('"+ddep3+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr3+
													 "','mm/dd/yyyy hh24:mi'),'"+section3+"')";
									System.out.println(" 3 : " + query );
									stmt.addBatch(query );
								}
							}
							if(!service4.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train4+"','"+engine4+"','"+service4+"','"+
													 from4+"','"+to4+"','"+siding4+"','"+load4+"',"+dist4+
													 ",to_date('"+ddep4+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr4+
													 "','mm/dd/yyyy hh24:mi'),'"+section4+"')";
	//								System.out.println(" 4 : " + query );
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train4+"','"+engine4+"','"+service4+"','"+
													 from4+"','"+to4+"','"+siding4+"','"+load4+"',"+dist4+
													 ",to_date('"+ddep4+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr4+
													 "','mm/dd/yyyy hh24:mi'),'"+section4+"')";
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train4+"','"+engine4+"','"+service4+"','"+
													 from4+"','"+to4+"','"+siding4+"','"+load4+"',"+dist4+
													 ",to_date('"+ddep4+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr4+
													 "','mm/dd/yyyy hh24:mi'),'"+section4+"')";
									stmt.addBatch(query );
								}
							}
							if(!service5.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train5+"','"+engine5+"','"+service5+"','"+
													 from5+"','"+to5+"','"+siding5+"','"+load5+"',"+dist5+
													 ",to_date('"+ddep5+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr5+
													 "','mm/dd/yyyy hh24:mi'),'"+section5+"')";
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train5+"','"+engine5+"','"+service5+"','"+
													 from5+"','"+to5+"','"+siding5+"','"+load5+"',"+dist5+
													 ",to_date('"+ddep5+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr5+
													 "','mm/dd/yyyy hh24:mi'),'"+section5+"')";
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train5+"','"+engine5+"','"+service5+"','"+
													 from5+"','"+to5+"','"+siding5+"','"+load5+"',"+dist5+
													 ",to_date('"+ddep5+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr5+
													 "','mm/dd/yyyy hh24:mi'),'"+section5+"')";
									stmt.addBatch(query );
								}
							}
							if(!service6.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train6+"','"+engine6+"','"+service6+"','"+
													 from6+"','"+to6+"','"+siding6+"','"+load6+"',"+dist6+
													 ",to_date('"+ddep6+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr6+
													 "','mm/dd/yyyy hh24:mi'),'"+section6+"')";
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train6+"','"+engine6+"','"+service6+"','"+
													 from6+"','"+to6+"','"+siding6+"','"+load6+"',"+dist6+
													 ",to_date('"+ddep6+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr6+
													 "','mm/dd/yyyy hh24:mi'),'"+section6+"')";
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train6+"','"+engine6+"','"+service6+"','"+
													 from6+"','"+to6+"','"+siding6+"','"+load6+"',"+dist6+
													 ",to_date('"+ddep6+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr6+
													 "','mm/dd/yyyy hh24:mi'),'"+section6+"')";
									stmt.addBatch(query );
								}
							}
							if(!service7.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train7+"','"+engine7+"','"+service7+"','"+
													 from7+"','"+to7+"','"+siding7+"','"+load7+"',"+dist7+
													 ",to_date('"+ddep7+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr7+
													 "','mm/dd/yyyy hh24:mi'),'"+section7+"')";
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train7+"','"+engine7+"','"+service7+"','"+
													 from7+"','"+to7+"','"+siding7+"','"+load7+"',"+dist7+
													 ",to_date('"+ddep7+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr7+
													 "','mm/dd/yyyy hh24:mi'),'"+section7+"')";
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train7+"','"+engine7+"','"+service7+"','"+
													 from7+"','"+to7+"','"+siding7+"','"+load7+"',"+dist7+
													 ",to_date('"+ddep7+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr7+
													 "','mm/dd/yyyy hh24:mi'),'"+section7+"')";
									stmt.addBatch(query );
								}
							}
							if(!service8.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train8+"','"+engine8+"','"+service8+"','"+
													 from8+"','"+to8+"','"+siding8+"','"+load8+"',"+dist8+
													 ",to_date('"+ddep8+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr8+
													 "','mm/dd/yyyy hh24:mi'),'"+section8+"')";
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train8+"','"+engine8+"','"+service8+"','"+
													 from8+"','"+to8+"','"+siding8+"','"+load8+"',"+dist8+
													 ",to_date('"+ddep8+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr8+
													 "','mm/dd/yyyy hh24:mi'),'"+section8+"')";
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train8+"','"+engine8+"','"+service8+"','"+
													 from8+"','"+to8+"','"+siding8+"','"+load8+"',"+dist8+
													 ",to_date('"+ddep8+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr8+
													 "','mm/dd/yyyy hh24:mi'),'"+section8+"')";
									stmt.addBatch(query );
								}
							}
							if(!service9.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train9+"','"+engine9+"','"+service9+"','"+
													 from9+"','"+to9+"','"+siding9+"','"+load9+"',"+dist9+
													 ",to_date('"+ddep9+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr9+
													 "','mm/dd/yyyy hh24:mi'),'"+section9+"')";
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train9+"','"+engine9+"','"+service9+"','"+
													 from9+"','"+to9+"','"+siding9+"','"+load9+"',"+dist9+
													 ",to_date('"+ddep9+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr9+
													 "','mm/dd/yyyy hh24:mi'),'"+section9+"')";
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train9+"','"+engine9+"','"+service9+"','"+
													 from9+"','"+to9+"','"+siding9+"','"+load9+"',"+dist9+
													 ",to_date('"+ddep9+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr9+
													 "','mm/dd/yyyy hh24:mi'),'"+section9+"')";
									stmt.addBatch(query );
								}
							}
							if(!service10.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train10+"','"+engine10+"','"+service10+"','"+
													 from10+"','"+to10+"','"+siding10+"','"+load10+"',"+dist10+
													 ",to_date('"+ddep10+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr10+
													 "','mm/dd/yyyy hh24:mi'),'"+section10+"')";
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train10+"','"+engine10+"','"+service10+"','"+
													 from10+"','"+to10+"','"+siding10+"','"+load10+"',"+dist10+
													 ",to_date('"+ddep10+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr10+
													 "','mm/dd/yyyy hh24:mi'),'"+section10+"')";
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train10+"','"+engine10+"','"+service10+"','"+
													 from10+"','"+to10+"','"+siding10+"','"+load10+"',"+dist10+
													 ",to_date('"+ddep10+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr10+
													 "','mm/dd/yyyy hh24:mi'),'"+section10+"')";
									stmt.addBatch(query );
								}
							}
							if(!service11.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train11+"','"+engine11+"','"+service11+"','"+
													 from11+"','"+to11+"','"+siding11+"','"+load11+"',"+dist11+
													 ",to_date('"+ddep11+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr11+
													 "','mm/dd/yyyy hh24:mi'),'"+section11+"')";
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train11+"','"+engine11+"','"+service11+"','"+
													 from11+"','"+to11+"','"+siding11+"','"+load11+"',"+dist11+
													 ",to_date('"+ddep11+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr11+
													 "','mm/dd/yyyy hh24:mi'),'"+section11+"')";
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train11+"','"+engine11+"','"+service11+"','"+
													 from11+"','"+to11+"','"+siding11+"','"+load11+"',"+dist11+
													 ",to_date('"+ddep11+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr11+
													 "','mm/dd/yyyy hh24:mi'),'"+section11+"')";
									stmt.addBatch(query );
								}
							}
							if(!service12.equals(null))
							{
								if(blnDriver)
								{
									query  = "insert into statistics(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train12+"','"+engine12+"','"+service12+"','"+
													 from12+"','"+to12+"','"+siding12+"','"+load12+"',"+dist12+
													 ",to_date('"+ddep12+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr12+
													 "','mm/dd/yyyy hh24:mi'),'"+section12+"')";
									stmt.addBatch(query );
								}
								if(blnAssistant)
								{
									query  = "insert into statisticsad(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train12+"','"+engine12+"','"+service12+"','"+
													 from12+"','"+to12+"','"+siding12+"','"+load12+"',"+dist12+
													 ",to_date('"+ddep12+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr12+
													 "','mm/dd/yyyy hh24:mi'),'"+section12+"')";
									stmt.addBatch(query );
								}
								if(blnGuard)
								{
									query  = "insert into statisticsg(ctrno, ctrdate, trainno, locono, service, stationfrom,"+
													 "stationto, siding, load, distance, departure, arrival, section) values ('"+strCtrNo+"',to_date('"+signOfDate+
													 "','mm/dd/yyyy hh24:mi'),'"+train12+"','"+engine12+"','"+service12+"','"+
													 from12+"','"+to12+"','"+siding12+"','"+load12+"',"+dist12+
													 ",to_date('"+ddep12+"','mm/dd/yyyy hh24:mi'),to_date('"+aarr12+
													 "','mm/dd/yyyy hh24:mi'),'"+section12+"')";
									stmt.addBatch(query );
								}
							}							
						}
						catch(Exception bat)
						{	
						}
				
						try
						{
							int b[] = stmt.executeBatch();
							con.commit();
							stmt.clearBatch();
							con.close();
						} 
						catch(SQLException sqle)	
						{
							try
							{
								con.rollback();
								sqle.printStackTrace();
								JOptionPane.showMessageDialog(null,	"Statistics Data is not posted due to :   " + sqle.getMessage(),
															"Click OK to Continue",JOptionPane.ERROR_MESSAGE);
								return;
							}
							catch(Exception ex)
							{
							}
						}		
						
						blnBaseStation= false;
						blnBase = false;
						blnContinuous = false;
						clearEntries();
						refreshComboBox();
						panel1.repaint();
				}
				catch (Exception npe)	
				{
					System.out.println("NPE in Sign Off");
					npe.printStackTrace();
					JOptionPane.showMessageDialog(panel1,	npe.getMessage(),
										"Click OK to Continue",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		jbVerify.addActionListener(new ActionListener()  
		{
			public void actionPerformed(ActionEvent e)      
			{
				service = (String) jcbService.getSelectedItem();
				radioname = group.getSelection().getActionCommand();
				if(radioname.equals(new String("WITHGUARD")))	
				{
					blnDriver = true;
					blnAssistant = true;
					blnGuard = true;
				}
				if(radioname.equals(new String("WITHOUTGUARD")))	
				{
					blnDriver = true;
					blnAssistant = true;
					blnGuard = false;
				}
				if(radioname.equals(new String("DRIVER")))	
				{
					blnDriver = true;
					blnAssistant = false;
					blnGuard = false;
				}
				if(radioname.equals(new String("ASSISTANT")))	
				{
					blnDriver = false;
					blnAssistant = true;
					blnGuard = false;
				}
				if(radioname.equals(new String("GUARD")))	
				{
					blnDriver = false;
					blnAssistant = false;
					blnGuard = true;				
				}
				try
				{
					try
					{
						if(blnDriver)
							driverNamePfNo = ncbDriver.getName().trim();
						if(blnAssistant)
							assistantNamePfNo = ncbAssistant.getName().trim();
						if(blnGuard)
							guardNamePfNo = ncbGuard.getName().trim();
					}
					catch(Exception ex2)
					{
						JOptionPane.showMessageDialog(null,"Select Proper Crew Names"
									,"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								return;
					}
					if(blnDriver)
					{
						int i = driverNamePfNo.length();
						driverName =	driverNamePfNo.substring(0,i-9).trim();
						driverPfNo = driverNamePfNo.substring(i-8);
					}
					if(blnAssistant)	
					{
						int i = assistantNamePfNo.length();
						assistantName =	assistantNamePfNo.substring(0,i-9).trim();
						assistantPfNo = assistantNamePfNo.substring(i-8);
					}
					if(blnGuard)	
					{
						int i = guardNamePfNo.length();
						guardName = guardNamePfNo.substring(0,i-9).trim();
						guardPfNo = guardNamePfNo.substring(i-8);
					}
					
					strCtrNo = jtfCtrNo.getText().trim();
					strCtrNo = strCtrNo.toUpperCase();
					System.out.println("CTR : " + strCtrNo);
					
					try
					{
						ctrno = strCtrNo.substring(4).trim();
					}
					catch(Exception exe)
					{
					}
//					service = (String) jcbService.getSelectedItem();
					if (blnDriver)
					{
						if(service.equals("HigherGrade1") || service.equals("HigherGrade2"))
//						||		service.equals("Shunting") || service.equals("LR")|| service.equals("Pilot") )
						{
						}
						else
						{
/*
//				Deleted this to add Automatic PR for Crew morethan 75 hours out of HQ
							query = "select ctrno from curronlined where namedriver='"+driverName+"' ";
							System.out.println(query);
							vecCtrD = snv.getStationNameList("",query );
*/
							query = "select ctrno,to_char(date1,'mm/dd/yyyy hh24:mi') signon from curronlined "+
								" where namedriver='"+driverName+"' ";
							vecCtrD =	qtm.setQuery("",query );
							if(vecCtrD.size()>0)
							{
								ctrnos = ((String[])vecCtrD.elementAt(0))[0]; //(String) vecCtrD.elementAt(0);
								outofhqD = ((String[])vecCtrD.elementAt(0))[1];
								int a = ctrnos.lastIndexOf(',');
								if (a != -1)
								{
									xctr = ctrnos;
									try
									{
										ctrx = xctr.substring(0,xctr.indexOf(','));
										
										System.out.println(ctrx + " : " + ctrno);
										if (ctrx.equals(ctrno.substring(0,ctrx.length())))
										{
											len = ctrx.length();
											if(ctrx.length() != ctrno.length())
											{
												ctr = ctrno.substring(len, len+2);
												System.out.println("CTR : " + ctr);
												if(ctr.equals("OS"))
												{
													blnOSD = true;
													blnCtrD = true;
												}
											}		
											else
											{
												blnCtrD = true;
											}
										}
										xctr = xctr.substring(xctr.indexOf(',')+1);
										try
										{
											ctry = xctr.substring(0,xctr.indexOf(','));
										}
										catch(StringIndexOutOfBoundsException sioobe)
										{
											ctry = xctr;
										}

										System.out.println(ctry + " : " + ctrno);
										if (ctry.equals(ctrno.substring(0,ctrx.length())))
										{
											len = ctry.length();
											if(ctry.length() != ctrno.length())
											{
												ctr = ctrno.substring(len, len+2);
												System.out.println("CTR : " + ctr);
												if(ctr.equals("OS"))
												{
													blnOSD = true;
													blnCtrD = true;
												}
											}		
											else
											{
												blnCtrD = true;
											}
										}
										else
										{
										}
										try
										{
											xctr = xctr.substring(xctr.indexOf(',')+1);
											ctrz = xctr.substring(0,xctr.indexOf(','));
										}
										catch(StringIndexOutOfBoundsException sioobe)
										{
											ctrz = xctr;
										}
										System.out.println(ctrz + " : " + ctrno);
										if (ctrz.equals(ctrno.substring(0,ctrx.length())))
										{
											len = ctrz.length();
											if(ctrz.length() != ctrno.length())
											{
												ctr = ctrno.substring(len, len+2);
												System.out.println("CTR : " + ctr);
												if(ctr.equals("OS"))
												{
													blnOSD = true;
													blnCtrD = true;
												}
											}		
											else
											{
												blnCtrD = true;
											}
										}
									}
									catch(Exception ex)
									{
										ex.printStackTrace();
									}								
								}
								else
								{
									if (ctrnos.equals(ctrno.substring(0,ctrnos.length())))
									{
										len = ctrno.length();
										if(ctrnos.length() != ctrno.length())
										{
											ctr = ctrno.substring(len, len+2);
											System.out.println("CTR : " + ctr);
											if(ctr.equals("OS"))
											{
												blnOSD = true;
												blnCtrD = true;
											}
										}		
										else
										{
											blnCtrD = true;
										}
									}
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Enter correct CTR nos '"+ctrnos+"'",
											"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								return;
							}
															
							if(!blnCtrD)
							{
								JOptionPane.showMessageDialog(null,"The CTRs issued to driver are '"+ctrnos+"'"+
											" Please correct it ","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
						query = "select vhfno from vhf where issued=(select max(issued) from vhf "+
											" where namedriver='"+driverName+"' and signon is null) "+
											" and namedriver='"+driverName+"' and signon is null ";
						vecCtrD = snv.getStationNameList("",query );
						if(vecCtrD.size() >0)
						{
							jtfVHF.setText((String) vecCtrD.elementAt(0));
						}
						else
						{
							jtfVHF.setText("0");
						}
						query = "select ptphoneno from ptphone where issued=(select max(issued) from ptphone "+
											" where namedriver='"+driverName+"' and signon is null) "+
											" and namedriver='"+driverName+"' and signon is null ";
						vecCtrD = snv.getStationNameList("",query );
//						System.out.println("VHF : " + vecCtrD.size());
						if(vecCtrD.size() > 0)
						{
							jtfPTPhone.setText((String) vecCtrD.elementAt(0));
						}
						else
						{
							jtfPTPhone.setText("0");
						}
					}				
					else if (blnAssistant)
					{
						if(service.equals("HigherGrade1")||service.equals("HigherGrade2"))//z ||
//								service1.equals("Shunting") || service1.equals("LR")|| service1.equals("Pilot"))
						{
						}
						else
						{
/*							query = "select ctrno from curronlinead where nameassistant='"+assistantName+"' ";
							System.out.println(query);
							vecCtrD = snv.getStationNameList("",query );
							System.out.println(vecCtrD.size() + " : " + query );
*/
							query = "select ctrno,to_char(date1,'mm/dd/yyyy hh24:mi') signon from curronlinead "+
								" where nameassistant='"+assistantName+"' ";
							vecCtrD =		qtm.setQuery("",query );
							
							if(vecCtrD.size()>0)
							{
								ctrnos = ((String[])vecCtrD.elementAt(0))[0]; //(String) vecCtrD.elementAt(0);
								outofhqAD = ((String[])vecCtrD.elementAt(0))[1];
								int a = ctrnos.lastIndexOf(',');
								if (a != -1)
								{
									xctr = ctrnos;
									try
									{
										ctrx = xctr.substring(0,xctr.indexOf(','));
										
										System.out.println(ctrx + " : " + ctrno);
										if (ctrx.equals(ctrno.substring(0,ctrx.length())))
										{
											len = ctrx.length();
											if(ctrx.length() != ctrno.length())
											{
												ctr = ctrno.substring(len, len+2);
												System.out.println("CTR : " + ctr);
												if(ctr.equals("OS"))
												{
													blnOSA = true;
													blnCtrA = true;
												}
											}		
											else
											{
												blnCtrA = true;
											}
										}
										xctr = xctr.substring(xctr.indexOf(',')+1);
										try
										{
											ctry = xctr.substring(0,xctr.indexOf(','));
										}
										catch(StringIndexOutOfBoundsException sioobe)
										{
											ctry = xctr;
										}

										System.out.println(ctry + " : " + ctrno);
										if (ctry.equals(ctrno.substring(0,ctrx.length())))
										{
											len = ctry.length();
											if(ctry.length() != ctrno.length())
											{
												ctr = ctrno.substring(len, len+2);
												System.out.println("CTR : " + ctr);
												if(ctr.equals("OS"))
												{
													blnOSA = true;
													blnCtrA = true;
												}
											}		
											else
											{
												blnCtrA = true;
											}
										}
										else
										{
										}
										try
										{
											xctr = xctr.substring(xctr.indexOf(',')+1);
											ctrz = xctr.substring(0,xctr.indexOf(','));
										}
										catch(StringIndexOutOfBoundsException sioobe)
										{
											ctrz = xctr;
										}
										System.out.println(ctrz + " : " + ctrno);
										if (ctrz.equals(ctrno.substring(0,ctrx.length())))
										{
											len = ctrz.length();
											if(ctrz.length() != ctrno.length())
											{
												ctr = ctrno.substring(len, len+2);
												System.out.println("CTR : " + ctr);
												if(ctr.equals("OS"))
												{
													blnOSA = true;
													blnCtrA = true;
												}
											}		
											else
											{
												blnCtrA = true;
											}
										}
									}
									catch(Exception ex)
									{
										ex.printStackTrace();
									}
								}
								else
								{
									if (ctrnos.equals(ctrno.substring(0,ctrnos.length())))
									{
										len = ctrno.length();
										if(ctrnos.length() != ctrno.length())
										{
											ctr = ctrno.substring(len, len+2);
											System.out.println("CTR : " + ctr);
											if(ctr.equals("OS"))
											{
												blnOSA = true;
												blnCtrA = true;
											}
										}		
										else
										{
											blnCtrA = true;
										}
									}
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Enter correct CTR nos "+ctrnos+"'",
											"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								return;
							}
							if(!blnCtrA)
							{
								JOptionPane.showMessageDialog(null,"The CTRs issued to asst. driver are '"+ctrnos+"'"+
											" Please correct it ","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
						ctrs = "select vhfno from vhf where issued=(select max(issued) from vhf "+
											" where nameassistant='"+assistantName+"' and signon is null) "+
											" and nameassistant='"+assistantName+"' and signon is null ";
						vecCtrD = snv.getStationNameList("",ctrs);
//						System.out.println("VHF : " + vecCtrD.size());
						if(vecCtrD.size() > 0)
						{
							jtfVHF.setText((String) vecCtrD.elementAt(0));
						}
						else
						{
							jtfVHF.setText("0");
						}
						query = "select ptphoneno from ptphone where issued=(select max(issued) from ptphone "+
											" where nameassistant='"+assistantName+"' and signon is null) "+
											" and nameassistant='"+assistantName+"' and signon is null ";
						vecCtrD = snv.getStationNameList("",query );
//						System.out.println("VHF : " + vecCtrD.size());
						if(vecCtrD.size() > 0)
						{
							jtfPTPhone.setText((String) vecCtrD.elementAt(0));
						}
						else
						{
							jtfPTPhone.setText("0");
						}
					}
					else if (blnAssistant)
					{
						if(service.equals("HigherGrade1")||service.equals("HigherGrade2"))//z ||
//								service1.equals("Shunting") || service1.equals("LR")|| service1.equals("Pilot"))
						{
						}
						else
						{
/*							query = "select ctrno from curronlinead where nameassistant='"+assistantName+"' ";
							System.out.println(query);
							vecCtrD = snv.getStationNameList("",query );
							System.out.println(vecCtrD.size() + " : " + query );
*/
							query = "select ctrno,to_char(date1,'mm/dd/yyyy hh24:mi') signon from curronlineg "+
								" where nameguard='"+guardName+"' ";
							vecCtrD =		qtm.setQuery("",query );
							
							if(vecCtrD.size()>0)
							{
								ctrnos = ((String[])vecCtrD.elementAt(0))[0]; //(String) vecCtrD.elementAt(0);
								outofhqG = ((String[])vecCtrD.elementAt(0))[1];
							}							
						}					
					}
					ctrnos="";					
				}
				catch(Exception ex1)
				{
					ex1.printStackTrace();
				}


				inArrivalDate=dpArrl.getUpdateDate();
				inArrivalHour=hpArrl.getUpdateHour();
				inArrivalMinute=mpArrl.getUpdateMinute();
				inArrivalDate = cdmf.getChangedFormat(inArrivalDate,inArrivalHour, inArrivalMinute);
				
				int a = inArrivalDate.compareTo(departureDate);
				if(a > 0 ) 
				{
					JOptionPane.showMessageDialog(null,"Incoming Train Arrival is Morethan Train Departure. "+
							"\n Please Correct it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
					return;
				}				

				signOfDate=dpSof.getUpdateDate();
				signOfHour=hpSof.getUpdateHour();
				signOfMinute=mpSof.getUpdateMinute();
				signOfDate = cdmf.getChangedFormat(signOfDate,signOfHour, signOfMinute);
				System.out.println("Signoff checking : " + signOfDate+ " : " +arrivalDate);
				xhours = ct.getHourBetween(signOfDate, arrivalDate);
				if(xhours >2.0)
				{
					JOptionPane.showMessageDialog(null,"SignOfTime is 2 or more hours greaterthan Arrival Time",
											"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
				}
				if(blnDriver)
				{
					if(cmpt.getGreaterSof(signOfDate,arrivalDate))
					{
						JOptionPane.showMessageDialog(null,"SignOn Time cannot be lessthan Arrival Time",
												"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if(blnAssistant)
				{
					if(cmpt.getGreaterSof(signOfDate,arrivalDate))
					{
						JOptionPane.showMessageDialog(null,"Assistant SignOn Time cannot be lessthan Arrival Time",
												"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if(blnGuard)
				{
					if(cmpt.getGreaterSof(signOfDate,arrivalDate))
					{
						JOptionPane.showMessageDialog(null,"Guard SignOn Time cannot be lessthan Arrival Time",
												"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if(shuntingHours == 0)
					{
						shuntingHours = new Double(jtfShunting.getText().trim()).doubleValue();
					}
/*					System.out.println("######################## MILEAGE CALCULATION ##################################");
					try
					{
						if(!service1.equals(null))
						{
							if((service1.equals(new String("LE/LA"))) ||(service1.equals(new String("CraneSpecial"))) || 
								(service1.equals(new String("EnggSpl")))  ||  (service1.equals(new String("Ballast"))) 
								||(service1.equals(new String("CoalPilots"))) ||(service1.equals(new String("MaterialTrain")))) 
							{
								if (from1.equals(to1))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service2.equals(null))
						{
							if(service2.equals(new String("LE/LA"))||service2.equals(new String("CraneSpecial"))|| 
								service2.equals(new String("EnggSpl"))||service2.equals(new String("Ballast")) 
								||service2.equals(new String("CoalPilots"))||service2.equals(new String("MaterialTrain"))) 
							{
								if (from2.equals(to2))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service3.equals(null))
						{
							if(service3.equals(new String("LE/LA"))||service3.equals(new String("CraneSpecial"))|| 
								service3.equals(new String("EnggSpl"))||service3.equals(new String("Ballast")) 
								||service3.equals(new String("CoalPilots"))||service3.equals(new String("MaterialTrain"))) 
							{
								if (from3.equals(to3))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service4.equals(null))
						{
							if(service4.equals(new String("LE/LA"))||service4.equals(new String("CraneSpecial"))|| 
								service4.equals(new String("EnggSpl"))||service4.equals(new String("Ballast")) 
								||service4.equals(new String("CoalPilots"))||service4.equals(new String("MaterialTrain"))) 
							{
								if (from4.equals(to4))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service5.equals(null))
						{
							if(service5.equals(new String("LE/LA"))||service5.equals(new String("CraneSpecial"))|| 
								service5.equals(new String("EnggSpl"))||service5.equals(new String("Ballast")) 
								||service5.equals(new String("CoalPilots"))||service5.equals(new String("MaterialTrain"))) 
							{
								if (from5.equals(to5))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service6.equals(null))
						{
							if(service6.equals(new String("LE/LA"))||service6.equals(new String("CraneSpecial"))|| 
								service6.equals(new String("EnggSpl"))||service6.equals(new String("Ballast")) 
								||service6.equals(new String("CoalPilots"))||service6.equals(new String("MaterialTrain"))) 
							{
								if (from6.equals(to6))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service7.equals(null))
						{
							if(service7.equals(new String("LE/LA"))||service7.equals(new String("CraneSpecial"))|| 
								service7.equals(new String("EnggSpl"))||service7.equals(new String("Ballast")) 
								||service7.equals(new String("CoalPilots"))||service7.equals(new String("MaterialTrain"))) 
							{
								if (from7.equals(to7))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service8.equals(null))
						{
							if(service8.equals(new String("LE/LA"))||service8.equals(new String("CraneSpecial"))|| 
								service8.equals(new String("EnggSpl"))||service8.equals(new String("Ballast")) 
								||service8.equals(new String("CoalPilots"))||service8.equals(new String("MaterialTrain"))) 
							{
								if (from8.equals(to8))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service9.equals(null))
						{
							if(service9.equals(new String("LE/LA"))||service9.equals(new String("CraneSpecial"))|| 
								service9.equals(new String("EnggSpl"))||service9.equals(new String("Ballast")) 
								||service9.equals(new String("CoalPilots"))||service9.equals(new String("MaterialTrain"))) 
							{
								if (from9.equals(to9))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service10.equals(null))
						{
							if(service10.equals(new String("LE/LA"))||service10.equals(new String("CraneSpecial"))|| 
								service10.equals(new String("EnggSpl"))||service10.equals(new String("Ballast")) 
								||service10.equals(new String("CoalPilots"))||service10.equals(new String("MaterialTrain"))) 
							{
								if (from10.equals(to10))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service11.equals(null))
						{
							if(service11.equals(new String("LE/LA"))||service11.equals(new String("CraneSpecial"))|| 
								service11.equals(new String("EnggSpl"))||service11.equals(new String("Ballast")) 
								||service11.equals(new String("CoalPilots"))||service11.equals(new String("MaterialTrain"))) 
							{
								if (from11.equals(to11))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
						if(!service12.equals(null))
						{
							if(service12.equals(new String("LE/LA"))||service12.equals(new String("CraneSpecial"))|| 
								service12.equals(new String("EnggSpl"))||service12.equals(new String("Ballast")) 
								||service12.equals(new String("CoalPilots"))||service12.equals(new String("MaterialTrain"))) 
							{
								if (from12.equals(to12))
								{
									enggkm = 1;
								}
								else
								{
									enggkm = 0;
								}
							}
						}
					}
					catch(Exception ee)
					{
					}
					try
					{
						if(!service1.equals(null))
						{
							if((service1.equals(new String("LE/LA"))) ||(service1.equals(new String("CraneSpecial"))) || 
								(service1.equals(new String("EnggSpl")))  ||  (service1.equals(new String("Ballast"))) 
								||(service1.equals(new String("CoalPilots"))) ||(service1.equals(new String("MaterialTrain")))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service2.equals(null))
						{
							if(service2.equals(new String("LE/LA"))||service2.equals(new String("CraneSpecial"))|| 
								service2.equals(new String("EnggSpl"))||service2.equals(new String("Ballast")) 
								||service2.equals(new String("CoalPilots"))||service2.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service3.equals(null))
						{
							if(service3.equals(new String("LE/LA"))||service3.equals(new String("CraneSpecial"))|| 
								service3.equals(new String("EnggSpl"))||service3.equals(new String("Ballast")) 
								||service3.equals(new String("CoalPilots"))||service3.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service4.equals(null))
						{
							if(service4.equals(new String("LE/LA"))||service4.equals(new String("CraneSpecial"))|| 
								service4.equals(new String("EnggSpl"))||service4.equals(new String("Ballast")) 
								||service4.equals(new String("CoalPilots"))||service4.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service5.equals(null))
						{
							if(service5.equals(new String("LE/LA"))||service5.equals(new String("CraneSpecial"))|| 
								service5.equals(new String("EnggSpl"))||service5.equals(new String("Ballast")) 
								||service5.equals(new String("CoalPilots"))||service5.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service6.equals(null))
						{
							if(service6.equals(new String("LE/LA"))||service6.equals(new String("CraneSpecial"))|| 
								service6.equals(new String("EnggSpl"))||service6.equals(new String("Ballast")) 
								||service6.equals(new String("CoalPilots"))||service6.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service7.equals(null))
						{
							if(service7.equals(new String("LE/LA"))||service7.equals(new String("CraneSpecial"))|| 
								service7.equals(new String("EnggSpl"))||service7.equals(new String("Ballast")) 
								||service7.equals(new String("CoalPilots"))||service7.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service8.equals(null))
						{
							if(service8.equals(new String("LE/LA"))||service8.equals(new String("CraneSpecial"))|| 
								service8.equals(new String("EnggSpl"))||service8.equals(new String("Ballast")) 
								||service8.equals(new String("CoalPilots"))||service8.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service9.equals(null))
						{
							if(service9.equals(new String("LE/LA"))||service9.equals(new String("CraneSpecial"))|| 
								service9.equals(new String("EnggSpl"))||service9.equals(new String("Ballast")) 
								||service9.equals(new String("CoalPilots"))||service9.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service10.equals(null))
						{
							if(service10.equals(new String("LE/LA"))||service10.equals(new String("CraneSpecial"))|| 
								service10.equals(new String("EnggSpl"))||service10.equals(new String("Ballast")) 
								||service10.equals(new String("CoalPilots"))||service10.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service11.equals(null))
						{
							if(service11.equals(new String("LE/LA"))||service11.equals(new String("CraneSpecial"))|| 
								service11.equals(new String("EnggSpl"))||service11.equals(new String("Ballast")) 
								||service11.equals(new String("CoalPilots"))||service11.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
						if(!service12.equals(null))
						{
							if(service12.equals(new String("LE/LA"))||service12.equals(new String("CraneSpecial"))|| 
								service12.equals(new String("EnggSpl"))||service12.equals(new String("Ballast")) 
								||service12.equals(new String("CoalPilots"))||service12.equals(new String("MaterialTrain"))) 
							{
								blnSpecial = true;
							}
							else
							{
								blnSpecial = false;
							}
						}
					}
					catch(NullPointerException  npex)
					{
//						System.out.println("Null pointer in calculating Mileage ");
//						npex.printStackTrace();
					}
					
					try
					{
						if(!service1.equals(null))
						{
							returnMileage(service1, dist1, hour1);
						}
						if(!service2.equals(null))
						{
							returnMileage(service2, dist2, hour2);
						}
						if(!service3.equals(null))
						{
							returnMileage(service3, dist3, hour3);
						}
						if(!service4.equals(null))
						{
							returnMileage(service4, dist4, hour4);
						}
						if(!service5.equals(null))
						{
							returnMileage(service5, dist5, hour5);
						}
						if(!service6.equals(null))
						{
							returnMileage(service6, dist6, hour6);
						}
						if(!service7.equals(null))
						{
							returnMileage(service7, dist7, hour7);
						}
						if(!service8.equals(null))
						{
							returnMileage(service8, dist8, hour8);
						}
						if(!service9.equals(null))
						{
							returnMileage(service9, dist9, hour9);
						}
						if(!service10.equals(null))
						{
							returnMileage(service10, dist10, hour10);
						}
						if(!service11.equals(null))
						{
							returnMileage(service11, dist11, hour11);
						}
						if(!service12.equals(null))
						{
							returnMileage(service12, dist12, hour12);
						}
					}
					catch(NullPointerException  npex)
					{
//						System.out.println("Null pointer in calculating Mileage ");
//						npex.printStackTrace();
					}
					throughgoodskm = throughgoodskm + lekm;//-distPilot;
					lelakm = lelakm+cranesplkm+enggsplkm+ballastkm+coalpilotskm+materialtrainkm;//-distPilot;
					breakdownkm = breakdownkm+medicalreliefkm;//-distPilot;
					sidingkm = sidingkm ;//-distPilot;
					shuntingkm = shuntingkm + yardreliefkm;
					System.out.println("TG : " + throughgoodskm + " &  lela : " + lelakm + " & break : " + breakdownkm + 
					" & Siding : " + sidingkm + " & HG : " + hg1km + " & hg2 : " + hg2km + " & pilot : " + pilotkm);
					throughgoodshrs = throughgoodshrs + lehrs;
					lelahrs = lelahrs+cranesplhrs+enggsplhrs+ballasthrs+coalpilotshrs+materialtrainhrs;
					breakdownhrs = breakdownhrs+medicalreliefhrs;
					sidinghrs = sidinghrs ;
					shuntinghrs = shuntinghrs + yardreliefhrs;
					shuntingHours = new Double(jtfShunting.getText().trim()).doubleValue();
					if(blnHandicap)
					{
						mileage  = 120;
					}
					else
					{
						if(throughgoodskm >0)
						{
							mileagex = me.getMileage("ThroughGoods",throughgoodskm,
							blnHandicap,0, throughgoodshrs);
							System.out.println("ThroughGoods KM : " + throughgoodskm+ " & " + mileagex + " : " + mileage);
							mileage = mileage + mileagex;							
						}
						if(lrkm >0)
						{
							mileagex = me.getMileage("LR",lrkm,
							blnHandicap,0, lrhrs);
							mileage = mileage + mileagex;
							System.out.println("LR KM : " + lrkm+ " & " + mileagex + " : " + mileage);
						}
						if(pilotsectionkm >0)
						{
							mileagex = me.getMileage("PilotSection",pilotsectionkm,
							blnHandicap,shuntingHours, pilotsectionhrs);
							mileage = mileage + mileagex;
							System.out.println("PilotSection KM : " + pilotsectionkm+ " & " + mileagex + " : " +mileage);
						}
						
						if(srtrainkm >0)
						{
							mileagex =me.getMileage("SRTrain",srtrainkm,
							blnHandicap,0, srtrainhrs);
							mileage = mileage + mileagex;
							System.out.println("SRTrain KM : " + srtrainkm+ " & " + mileagex + " : " + mileage);
						}
						if(shuntinghrs >0)
						{
							mileagex = me.getMileage("Shunting",shuntingkm,
							blnHandicap,0, shuntinghrs);
							mileage = mileage + mileagex;
							System.out.println("Shunting KM : " + shuntingkm+ " & " + mileagex + " : " + mileage);
						}
						if(sidingkm >0)
						{
							mileagex = me.getMileage("Siding",sidingkm,
							blnHandicap,0,shuntingHours);
							mileage = mileage + mileagex;
							System.out.println("Ssiding KM : " + sidingkm+ " & " + mileagex + " : " + mileage);
						}
						if(pilotkm >0 || distPilot >0 )
						{
							mileagex = me.getMileage("Pilot",pilotkm,
							blnHandicap,0, pilothrs);
							mileage = mileage + mileagex;
							System.out.println("Pilot KM : " + pilotkm+ " & " + mileagex + " : " + mileage);
						}
						if(breakdownkm >0)
						{
							mileagex = me.getMileage("BreakDown",breakdownkm,
								blnHandicap,0, breakdownhrs);
							mileage = mileage + mileagex;
							System.out.println("Breakdown KM : " +  breakdownkm+ " & " + mileagex + " : " + mileage);
						}
						
						amileage = mileage;
						dmileage = mileage;
						gmileage = mileage;
						if(lelakm >0 || enggkm >0)
						{
							if(blnSpecial==true) 
							{
								double signoff = ct.getHourBetween(arrivalDate, signOfDate);
								lelahrs = lelahrs + signoff;
							}
							if(blnDriver)
							{
								mileagex = me.getMileage("LE/LA",lelakm, blnHandicap,0, lelahrs, driverDate, signOfDate);
								dmileage = dmileage + mileagex;
								System.out.println("Dr lela KM : " + lelakm+ " & " + mileagex + " : " + dmileage);
							}
							if(blnAssistant)
							{
								mileagex = me.getMileage("LE/LA",lelakm,blnHandicap,0, lelahrs, assistantDate, signOfDate);
								amileage = amileage + mileagex;
								System.out.println("ADr lela KM : " + lelakm+ " & " + mileagex + " : " + amileage);
							}
							if(blnGuard)
							{
								mileagex = me.getMileage("LE/LA",lelakm,blnHandicap,0, lelahrs, guardDate, signOfDate);
								gmileage = gmileage + mileagex;
								System.out.println("Guard lela KM : " + lelakm+ " & " + mileagex + " : " + gmileage);
							}							
						}
						if(hg1km >0)
						{
							if(blnDriver)
							{
								mileagex = me.getMileage("HigherGrade1",hg1km,
								blnHandicap,0, hg1hrs, "DRIVER");
								dmileage = dmileage + mileagex;
								System.out.println("HigherGrade1 KM : " + hg1km+ " & " + mileagex + " : " + dmileage);
							}
							if(blnAssistant)
							{
								mileagex = me.getMileage("HigherGrade1",hg1km,
								blnHandicap,0, hg1hrs, "ASSISTANT");
								amileage = amileage + mileagex;
								System.out.println("HigherGrade1 KM : " + hg1km+ " & " + mileagex + " : " + amileage);
							}
							if(blnGuard)
							{
								mileagex = me.getMileage("HigherGrade1",hg1km,
								blnHandicap,0, hg1hrs, "GUARD");
								gmileage = gmileage + mileagex;
								System.out.println("HigherGrade1 KM : " + hg1km+ " & " + mileagex + " : " + gmileage);
							}
						}
						if(hg2km >0)
						{
							if(blnDriver)
							{
								mileagex = me.getMileage("HigherGrade2",hg2km,
								blnHandicap,0, hg2hrs, "DRIVER");
								dmileage = dmileage + mileagex;
								System.out.println("HigherGrade2 KM : " + hg2km+ " & " + mileagex + " : " + dmileage);
							}
							if(blnAssistant)
							{
								mileagex = me.getMileage("HigherGrade2",hg2km,
								blnHandicap,0, hg2hrs, "ASSISTANT");
								amileage = amileage + mileagex;
								System.out.println("HigherGrade2 KM : " + hg2km+ " & " + mileagex + " : " + amileage);
							}
							if(blnGuard)
							{
								mileagex = me.getMileage("HigherGrade2",hg2km,
								blnHandicap,0, hg2hrs, "Guard");
								gmileage = gmileage + mileagex;
								System.out.println("HigherGrade2 KM : " + hg2km+ " & " + mileagex + " : " + gmileage);
							}
						}
					}
					System.out.println("######################## MILEAGE CALCULATION ENDS ##################################");
*/					
				jbSubmit.setEnabled(true);
				blnCtrD = false;
				blnCtrA = false;
			}
		});

/*		jcbService.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
//				service = (String) jcbService.getSelectedItem();
				radioname = group.getSelection().getActionCommand();
				if(radioname.equals(new String("WITHGUARD")))	
				{
					blnDriver = true;
					blnAssistant = true;
					blnGuard = true;
				}
				if(radioname.equals(new String("WITHOUTGUARD")))	
				{
					blnDriver = true;
					blnAssistant = true;
					blnGuard = false;
				}
				if(radioname.equals(new String("DRIVER")))	
				{
					blnDriver = true;
					blnAssistant = false;
					blnGuard = false;
				}
				if(radioname.equals(new String("ASSISTANT")))	
				{
					blnDriver = false;
					blnAssistant = true;
					blnGuard = false;
				}
				if(radioname.equals(new String("GUARD")))	
				{
					blnDriver = false;
					blnAssistant = false;
					blnGuard = true;				
				}
			}
		});
*/	
		jcbService1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				service = (String) jcbService.getSelectedItem();
				radioname = group.getSelection().getActionCommand();
				if(radioname.equals(new String("WITHGUARD")))	
				{
					blnDriver = true;
					blnAssistant = true;
					blnGuard = true;
				}
				if(radioname.equals(new String("WITHOUTGUARD")))	
				{
					blnDriver = true;
					blnAssistant = true;
					blnGuard = false;
				}
				if(radioname.equals(new String("DRIVER")))	
				{
					blnDriver = true;
					blnAssistant = false;
					blnGuard = false;
				}
				if(radioname.equals(new String("ASSISTANT")))	
				{
					blnDriver = false;
					blnAssistant = true;
					blnGuard = false;
				}
				if(radioname.equals(new String("GUARD")))	
				{
					blnDriver = false;
					blnAssistant = false;
					blnGuard = true;				
				}
				service1 = (String)jcbService1.getSelectedItem();
				if(!service1.equals("Siding"))
				{
					jcbSiding1.setFocusable(false);
				}
			}
		});
		jcbService2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service2 = (String)jcbService2.getSelectedItem();
				if(service2.trim().equals("Siding"))
				{
					jcbSiding2.setFocusable(true);
					jcbFrom2.setSelectedItem(to1);
					jcbTo2.setSelectedItem(to1);
				}
				else
				{
					jcbSiding2.setFocusable(false);
					jcbFrom2.setSelectedItem(to1);
				}
			}
		});
		jcbService3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service3 = (String)jcbService3.getSelectedItem();
				if(service3.trim().equals("Siding"))
				{
					jcbSiding3.setFocusable(true);
					jcbFrom3.setSelectedItem(to2);
					jcbTo3.setSelectedItem(to2);
				}
				else
				{
					jcbSiding3.setFocusable(false);
					jcbFrom3.setSelectedItem(to2);
				}
			}
		});
		jcbService4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service4 = (String)jcbService4.getSelectedItem();
				if(service4.trim().equals("Siding"))
				{
					jcbSiding4.setFocusable(true);
					jcbFrom4.setSelectedItem(to3);
					jcbTo4.setSelectedItem(to3);
				}
				else
				{
					jcbSiding4.setFocusable(false);
					jcbFrom4.setSelectedItem(to3);
				}
			}
		});
		jcbService5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service5 = (String)jcbService5.getSelectedItem();
				if(service5.trim().equals("Siding"))
				{
					jcbSiding5.setFocusable(true);
					jcbFrom5.setSelectedItem(to4);
					jcbTo5.setSelectedItem(to4);
				}
				else
				{
					jcbSiding5.setFocusable(false);
					jcbFrom5.setSelectedItem(to4);
				}
			}
		});
		jcbService6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service6 = (String)jcbService6.getSelectedItem();
				if(service6.trim().equals("Siding"))
				{
					jcbSiding6.setFocusable(true);
					jcbFrom6.setSelectedItem(to5);
					jcbTo6.setSelectedItem(to5);
				}
				else
				{
					jcbSiding6.setFocusable(false);
					jcbFrom6.setSelectedItem(to5);
				}
			}
		});
		jcbService7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service7 = (String)jcbService7.getSelectedItem();
				if(service7.trim().equals("Siding"))
				{
					jcbSiding7.setFocusable(true);
					jcbFrom7.setSelectedItem(to6);
					jcbTo7.setSelectedItem(to6);
				}
				else
				{
					jcbSiding7.setFocusable(false);
					jcbFrom7.setSelectedItem(to6);
				}
			}
		});
		jcbService8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service8 = (String)jcbService8.getSelectedItem();
				if(service8.trim().equals("Siding"))
				{
					jcbSiding8.setFocusable(true);
					jcbFrom8.setSelectedItem(to7);
					jcbTo8.setSelectedItem(to7);
				}
				else
				{
					jcbSiding8.setFocusable(false);
					jcbFrom8.setSelectedItem(to7);
				}
			}
		});
		jcbService9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service9 = (String)jcbService9.getSelectedItem();
				if(service9.trim().equals("Siding"))
				{
					jcbSiding9.setFocusable(true);
					jcbFrom9.setSelectedItem(to8);
					jcbTo9.setSelectedItem(to8);
				}
				else
				{
					jcbSiding9.setFocusable(false);
					jcbFrom9.setSelectedItem(to8);
				}
			}
		});
		jcbService10.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service10 = (String)jcbService10.getSelectedItem();
				if(service10.trim().equals("Siding"))
				{
					jcbSiding10.setFocusable(true);
					jcbFrom10.setSelectedItem(to9);
					jcbTo10.setSelectedItem(to9);
				}
				else
				{
					jcbSiding10.setFocusable(false);
					jcbFrom10.setSelectedItem(to9);
				}
			}
		});
		jcbService11.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service11 = (String)jcbService11.getSelectedItem();
				if(service11.trim().equals("Siding"))
				{
					jcbSiding11.setFocusable(true);
					jcbFrom11.setSelectedItem(to10);
					jcbTo11.setSelectedItem(to10);
				}
				else
				{
					jcbSiding11.setFocusable(false);
					jcbFrom11.setSelectedItem(to10);
				}
			}
		});
		jcbService12.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				service12 = (String)jcbService12.getSelectedItem();
				if(service12.trim().equals("Siding"))
				{
					jcbSiding12.setFocusable(true);
					jcbFrom12.setSelectedItem(to11);
					jcbTo12.setSelectedItem(to11);
				}
				else
				{
					jcbSiding12.setFocusable(false);
					jcbFrom11.setSelectedItem(to11);
				}
			}
		});
		jcbDep1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP1 ********************************");		
				if(blnClear)
				{
					pilotFrom = "null";
					pilotTo = "null";
					pilotFrom1 = "null";
					pilotTo1 = "null";
					pilotFrom2 = "null";
					pilotTo2 = "null";
					relief = "01/01/1999 00:00";
					relief1 = "01/01/1999 00:00";
					relief2 = "01/01/1999 00:00";
					service1 = (String) jcbService1.getSelectedItem();
					if(!service1.equals(null))// || !service1.equals(" "))
					{
						if(blnDriver)
						{
							driverDate1=dpD.getUpdateDate();
							driverHour=hpD.getUpdateHour();
							driverMinute=mpD.getUpdateMinute();
							driverDate = cdmf.getChangedFormat(driverDate1,driverHour, driverMinute);
						}
						if(blnGuard)
						{
							guardDate1=dpG.getUpdateDate();
							guardHour=hpG.getUpdateHour();
							guardMinute=mpG.getUpdateMinute();
							guardDate = cdmf.getChangedFormat(guardDate1,guardHour, guardMinute);
						}
						if(blnAssistant)
						{
							assistantDate1=dpA.getUpdateDate();
							assistantHour=hpA.getUpdateHour();
							assistantMinute=mpA.getUpdateMinute();
							assistantDate = cdmf.getChangedFormat(assistantDate1, assistantHour, assistantMinute);
						}
						dep1 = (String) jcbDep1.getSelectedItem();
						System.out.println("Dep1 :" + dep1+"XXXX");
						if(!dep1.equals(""))
						{
							if(blnDriver)
							{
								ddep1 = cdmf.getChangedFormat(driverDate1,dep1.substring(0,2), dep1.substring(3));
								System.out.println("Dep1 : " + dep1 + " ddep1 : " + ddep1);
								int a = driverDate.compareTo(ddep1);
								if(a > 0 ) 
								{
									JOptionPane.showMessageDialog(null,"Departure is lessthan to Driver Sign On. "+
											"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
									ddep1 = at.getHourAdd(ddep1,24);
								}
								departureDate = ddep1;
								System.out.println("driverdate : " + driverDate + " ddep1 : " + ddep1);
							}
						
							if(blnAssistant)
							{
								ddep1 = cdmf.getChangedFormat(assistantDate1,dep1.substring(0,2), dep1.substring(3));
								System.out.println("Dep1 : " + dep1 + " ddep1 : " + ddep1);
								int a = assistantDate.compareTo(ddep1);
								if(a > 0 ) 
								{
									JOptionPane.showMessageDialog(null,"Departure is lessthan to Assistant Sign On. "+
											"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
									ddep1 = at.getHourAdd(ddep1,24);
								}
								if(!blnDriver)
								{
									departureDate = ddep1;
								}
								System.out.println("Assistant date : " + assistantDate + " ddep1 : " + ddep1);
							}
							if(blnGuard)
							{
								ddep1 = cdmf.getChangedFormat(guardDate1,dep1.substring(0,2), dep1.substring(3));
								System.out.println("Dep1 : " + dep1 + " ddep1 : " + ddep1);
								int a = guardDate.compareTo(ddep1);
								if(a > 0 ) 
								{
									JOptionPane.showMessageDialog(null,"Departure is lessthan to Guard Sign On. "+
											"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
									ddep1 = at.getHourAdd(ddep1,24);
								}
								if(!blnDriver && !blnAssistant)
								{
									departureDate = ddep1;
								}
								System.out.println("guarddate : " + guardDate + " ddep1 : " + ddep1);
							}
						}
					}
				}
				System.out.println("************************** END DEP1 ********************************");
			}
		});
		jcbArr1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR1 ********************************");
				if(blnClear)
				{
					if(!service1.equals(null))// || !service1.equals(" "))
					{
						System.out.println("blnFirst1 : " + blnFirst1);
						try
						{
							if(blnDriver)
							{
								if(!signoflast.equals("null"))
								{
									System.out.println("Last : " + driverDate + " &&&& " + signoflast);
									if(cmpt.getGreaterDate(driverDate, signoflast))
									{
										JOptionPane.showMessageDialog(null,"Driver Last signed OFF at : " + signoflast+
											". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
										jcbFrom1.requestFocus();
										return;
									}
								}
							}
							if(blnGuard)
							{
								if(!signoflast.equals("null"))
								{
									System.out.println("HAHA : " + guardDate + " &&&& " + signoflast);
									if(cmpt.getGreaterDate(guardDate, signoflast))
									{
										JOptionPane.showMessageDialog(null,"Guard Last signed OFF at : " + signoflast+
											". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
										jcbFrom1.requestFocus();
										return;
									}
								}
							}
							if(blnAssistant)
							{
								if(!signoflast.equals("null"))
								{
									System.out.println("HAHA : " + assistantDate + " &&&& " + signoflast);
									if(cmpt.getGreaterDate(assistantDate, signoflast))
									{
										JOptionPane.showMessageDialog(null,"Assistant Driver Last signed OFF at : " + signoflast+
											". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
										jcbFrom1.requestFocus();
										return;
									}
								}
							}
							loconotfound = "";
							engine1 = (String) jftfLoco1.getValue();
							train1 = (String) jcbTrainno1.getSelectedItem();
							service1 = (String) jcbService1.getSelectedItem();
							section1 = (String) jcbSection1.getSelectedItem();
							from1 = (String) jcbFrom1.getSelectedItem();
							to1 = (String) jcbTo1.getSelectedItem();
							siding1 = (String) jcbSiding1.getSelectedItem();
							load1 = (String) jftfLoad1.getValue();
							dep1 = (String) jcbDep1.getSelectedItem();
							arr1 = (String) jcbArr1.getSelectedItem();
							if(siding1.equals(" "))
								siding1 = null;

							lrstation = to1;
							System.out.println("1 : "+ engine1 +  " : " +train1+" : " + service1 + " :  " + from1 +
																	" : " + to1 + " : " +siding1 + " : " + load1 + " : " + dep1 + " : " + arr1 );
							try
							{
								if(engine1 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine1);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco1.requestFocus();
										return;
									}
								}
							}
							catch(Exception ex1)
							{
							}
							
							aarr1 = cdmf.getChangedFormat1( ddep1.substring(0,10), arr1.substring(0,2), arr1.substring(3));
							if(ddep1.compareTo(aarr1) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr1 = at.getHourAdd(aarr1,24);
								
							}
							System.out.println("Dep1 : " + ddep1 + " arr1 : " + aarr1);
//							if(from1 != to1)// && !service1.equals("Siding")) 
							if(!service1.trim().equals("Siding")) 
							{
								if(blnFirst1)
								{
									System.out.println("First ");
									dist1 = cd.getDistance(from1,to1,section1);
									if ((dist1 == 0)||(dist1 < 0))
									{
										System.out.println("Distance Zero, Check Stations");
									}
									dist +=  dist1;
									
									if(service1.trim().equals("Pilot"))
									{
										distPilot += dist1;
//										pilotkm += dist1;
										pilotFrom = from1;
										pilotTo = to1;
										if(from1.equals(depot))
										{
											relief  = aarr1;
										}
										else
										{
											relief  = ddep1;		
										}
									}
									System.out.println("First1  dist : "+dist + " and dist1 : " + dist1);	
									System.out.println("Relief ********** : "+relief );	
								}
								else
								{
									System.out.println("Next ");
									System.out.println("Next DIST1 : "+dist1+" and dist :"+dist);
									dist  = dist - dist1;
									System.out.println("Next DIST1 : "+dist1+" and dist :"+dist);
									if(service1.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist1;
									}
									dist1 = 0;
									dist1 = cd.getDistance(from1,to1,section1);
									dist +=  dist1;
									System.out.println("Next DIST1 : "+dist1+" and dist :"+dist);
									if(service1.trim().equals("Pilot"))
									{
										distPilot += dist1;
										pilotFrom = from1;
										pilotTo = to1;
										if(from1.equals(depot))
										{
											relief  = aarr1;
										}
										else
										{
											relief  = ddep1;		
										}
									}
									System.out.println("Next1  AND diST : "+dist + " and dist1 : " + dist1 + " relief " +
															ddep1);	
								}
								if(to1.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
								
								System.out.println("Depot : " + depot + " &&&& To station : " + to1);
								
							}
							else if((service1.trim().equals("Siding")))	
							{
								querySiding = "Select kms from sidings where name ='" + siding1.trim()+"'";
	//							System.out.println("Siding : " + querySiding);
								if(blnFirst1)
								{
									dist1 = sk.getSidingKm("",querySiding);
									dist += dist1;
								}
								else
								{
									dist  = dist - dist1;
									dist1 = 0;
									dist1 = sk.getSidingKm("",querySiding);
									dist +=  dist1;
								}
							}
							if(blnFirst1)
							{
								if(blnDriver)
								{
									hour1 = ct.getHourBetween(driverDate,aarr1);
								}
								else if(blnAssistant)
								{
									hour1 = ct.getHourBetween(assistantDate,aarr1);
								}
								else
								{
									hour1 = ct.getHourBetween(guardDate,aarr1);
								}
								if(service1.trim().equals("Siding"))
								{
									hourSdg1 = ct.getHourBetween(ddep1,aarr1);
									sidingHours += hourSdg1;
								}
								if(service1.trim().equals("Shunting"))
								{
									hourShtg1 = ct.getHourBetween(ddep1,aarr1);
									sidingHours += hourShtg1;
								}
								if(service1.trim().equals("Pilot"))
								{
									hourPilot1 = ct.getHourBetween(ddep1,aarr1);
									pilotHours += hourPilot1;
								}
								workingHours = workingHours + hour1;
							}
							else 
							{
								workingHours = workingHours - hour1;
								if(service1.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot1;
									hourPilot1 = 0;
									hourPilot1 = ct.getHourBetween(ddep1,aarr1);
									pilotHours += hourPilot1;
								}
								if(service1.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg1;
									hourSdg1 = 0;
								}
								if(service1.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg1;
									hourShtg1 = 0;
								}
								if(blnDriver)
								{
									hour1 = ct.getHourBetween(driverDate,aarr1);
								}
								else if(blnAssistant)
								{
									hour1 = ct.getHourBetween(assistantDate,aarr1);
								}
								else
								{
									hour1 = ct.getHourBetween(guardDate,aarr1);
								}
								if(service1.trim().equals("Siding"))
								{
									hourSdg1 = ct.getHourBetween(ddep1,aarr1);
									sidingHours += hourSdg1;
								}
								if(service1.trim().equals("Pilot"))
								{
									hourPilot1 = ct.getHourBetween(ddep1,aarr1);
									pilotHours += hourPilot1;
								}
								if(service1.trim().equals("Shunting"))
								{
									hourShtg1 = ct.getHourBetween(ddep1,aarr1);
									shuntingHours += hourShtg1;
								}
								System.out.println(driverDate + " : " + assistantDate  + 
								" hours : " + hour1 + " dist1 : " + dist1);
								workingHours = workingHours + hour1;
							}
							arrivalDate = aarr1;
//							signOfDate = retSignof(service,aarr1);
							//         System.out.println("signOfDate : " + signOfDate + " ### base station: " + blnBaseStation);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label1.setText(new Integer(dist1).toString()+"/"+hour1);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst1 = false;
//							returnMileage(service1, dist1, hour1);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR1 ********************************");
			}
		});
		jcbDep2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP2 ********************************");
				if(blnClear)
				{
					if(!service2.equals(null) || !service2.equals(" "))
					{
						dep2 = (String) jcbDep2.getSelectedItem();
						ddep2 = cdmf.getChangedFormat1(aarr1.substring(0,10), dep2.substring(0,2), dep2.substring(3));
						System.out.println("Dep2 : " + dep2 + " ddep2 : " + ddep2);
						if(aarr1.compareTo(ddep2) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep2 = at.getHourAdd(ddep2,24);
						}
						System.out.println("aarr1 : " + aarr1 + " & ddep2 : " + ddep2);
					}
				}
				System.out.println("************************** END DEP2 ********************************");
			}
		});
		jcbArr2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR2 ********************************");
				if(blnClear)
				{
					if(!service2.equals(null) || !service2.equals(" "))
					{
						System.out.println("blnFirst2 : " + blnFirst2);
						try
						{
							engine2 = (String) jftfLoco2.getValue();
							train2 = (String) jcbTrainno2.getSelectedItem();
							service2 = (String) jcbService2.getSelectedItem();
							section2 = (String) jcbSection2.getSelectedItem();
							from2 = (String) jcbFrom2.getSelectedItem();
							to2 = (String) jcbTo2.getSelectedItem();
							siding2 = (String) jcbSiding2.getSelectedItem();
							if(siding2.equals(" "))
								siding2 = null;
							load2 = (String) jftfLoad2.getValue();
							dep2 = (String) jcbDep2.getSelectedItem();
							arr2 = (String) jcbArr2.getSelectedItem();
								
							lrstation = to2;
							System.out.println("2 : "+ engine2 +  " : " +train2+" : " + service2 + " :" + from2 +
																	":" + to2 + ": " + siding2 + " : " + load2 + " : " + dep2 + " : " + arr2 );
							try
							{
								loconotfound = "";
								if(engine2 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine2);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco2.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex2)
							{
							}
							aarr2 = cdmf.getChangedFormat1( ddep2.substring(0,10), arr2.substring(0,2), arr2.substring(3));
							if(ddep2.compareTo(aarr2) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr2 = at.getHourAdd(aarr2,24);
							}
//							if(from2 != to2)
							if(!service2.trim().equals("Siding")) 
							{
								System.out.println("XXX");
								if(blnFirst2)
								{
									System.out.println("fIRST 2 ");
									dist2 = cd.getDistance(from2,to2,section2);
									dist +=  dist2;
									
									if(service2.trim().equals("Pilot"))
									{
										distPilot += dist2;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from2;
											pilotTo = to2;
											if(from2.equals(depot))
											{
												relief  = aarr2;
											}
											else
											{
												relief  = ddep2;		
											}
										}
										else if(pilotFrom1.equals("null"))
										{
											pilotFrom1 = from2;
											pilotTo1 = to2;
											relief1  = ddep2;
										}
									}
									System.out.println("Frist2  AND diST : "+dist + " and dist2 : " + dist2);	
								}
								else
								{
									System.out.println("Next2 ");								
									dist  = dist - dist2;
									if(service2.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist2;
									}
									dist2 = cd.getDistance(from2,to2,section2);
									dist +=  dist2;
									if(service2.trim().equals("Pilot"))
									{
										distPilot += dist2;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from2;
											pilotTo = to2;
											if(from2.equals(depot))
											{
												relief  = aarr2;
											}
											else
											{
												relief  = ddep2;		
											}
										}
										else if(pilotFrom1.equals("null"))
										{
											pilotFrom1 = from2;
											pilotTo1 = to2;
											relief1  = ddep2;
										}
									}
									System.out.println("Next  AND diST : "+dist + " and dist2 : " + dist2);									
								}
								if(to2.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else if((service2.trim().equals("Siding")))	
							{
								System.out.println("YYY");
								querySiding = "Select kms from sidings where name ='" + siding2.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst2)
								{
									dist2 = sk.getSidingKm("",querySiding);
									dist += dist2;
								}
								else
								{
									dist  = dist - dist2;
									dist2 = sk.getSidingKm("",querySiding);
									dist +=  dist2;
								}
								System.out.println("dist : " + dist2);
							}
							if(blnFirst2)
							{
								hour2 = ct.getHourBetween(aarr1,aarr2);
								if(service2.trim().equals("Pilot"))
								{
									hourPilot2 = ct.getHourBetween(ddep2,aarr2);
									pilotHours += hourPilot2;
								}
								if(service2.trim().equals("Siding"))
								{
									hourSdg2 = ct.getHourBetween(ddep2,aarr2);
									sidingHours += hourSdg2;
								}
								if(service2.trim().equals("Shunting"))
								{
									hourShtg2 = ct.getHourBetween(ddep2,aarr2);
									shuntingHours += hourShtg2;
								}
								System.out.println(" aarr1 : " + aarr1 + " ** aarr2 : " + aarr2  + 
								" hours : " + hour2 + " dist2 : " + dist2);
								workingHours = workingHours + hour2;
							}
							else
							{
								workingHours = workingHours - hour2;
								if(service2.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot2;
									hourPilot2 = 0;
								}
								if(service2.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg2;
									hourSdg2 = 0;
								}
								if(service2.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg2;
									hourShtg2 = 0;
								}
								hour2 = ct.getHourBetween(aarr1,aarr2);
								if(service2.trim().equals("Pilot"))
								{
									hourPilot2 = ct.getHourBetween(ddep2,aarr2);
									pilotHours += hourPilot2;
								}
								if(service2.trim().equals("Siding"))
								{
									hourSdg2 = ct.getHourBetween(ddep2,aarr2);
									sidingHours += hourSdg2;
								}
								if(service2.trim().equals("Shunting"))
								{
									hourShtg2 = ct.getHourBetween(ddep2,aarr2);
									shuntingHours += hourShtg2;
								}
								System.out.println(" aarr1 : " + aarr1 + " ** aarr2 : " + aarr2  + 
								" hours2 : " + hour2 + " dist2 : " + dist2);
								workingHours = workingHours + hour2;
							}
							arrivalDate = aarr2;
							//          signOfDate = retSignof(service,aarr2);
							//         System.out.println("signOfDate : " + signOfDate+ " : " + blnBaseStation);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label2.setText(new Integer(dist2).toString()+"/"+hour2);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst2 = false;
//							returnMileage(service2, dist2, hour2);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR2 ********************************");
			}
		});
		jcbDep3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP3 ********************************");
				if(blnClear)
				{
					if(!service3.equals(null) || !service3.equals(" "))
					{
						dep3 = (String) jcbDep3.getSelectedItem();
						ddep3 = cdmf.getChangedFormat1(aarr2.substring(0,10), dep3.substring(0,2), dep3.substring(3));
						System.out.println("Dep3 : " + dep3 + " ddep3 : " + ddep3);
						if(aarr2.compareTo(ddep3) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep3 = at.getHourAdd(ddep3,24);
						}
						System.out.println("aarr2 : " + aarr2 + " & ddep3 : " + ddep3);
					}
				}
				System.out.println("************************** END DEP3 ********************************");
			}
		});
		jcbArr3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR3 ********************************");
				if(blnClear)
				{
					if(!service3.equals(null) || !service3.equals(" "))
					{
						try
						{
						System.out.println("blnFirst3 : " + blnFirst3);
							engine3 = (String) jftfLoco3.getValue();
							train3 = (String) jcbTrainno3.getSelectedItem();
							service3 = (String) jcbService3.getSelectedItem();
							section3 = (String) jcbSection3.getSelectedItem();
							try
							{
								from3 = (String) jcbFrom3.getSelectedItem();
							}
							catch(Exception e1)
							{
								from3 = null;
							}
							try
							{
								to3 = (String) jcbTo3.getSelectedItem();
							}
							catch(Exception e2)
							{
								to3 = null;
							}
							try
							{
								siding3 = (String) jcbSiding3.getSelectedItem();
								if(siding3.equals(" "))
									siding3 = null;

							}
							catch(Exception e2)
							{
								siding3 = null;
							}
							load3 = (String) jftfLoad3.getValue();
							dep3 = (String) jcbDep3.getSelectedItem();
							arr3 = (String) jcbArr3.getSelectedItem();
								
							lrstation = to3;
							System.out.println("3 : "+ engine3 +  " : " +train3+" : " + service3 + " :  " + from3 +
																	" : " + to3 + " : " + load3 + " : " + dep3 + " : " + arr3 );
							try
							{
								loconotfound = "";
								if(engine3 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine3);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco3.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex3)
							{
							}
							aarr3 = cdmf.getChangedFormat1( ddep3.substring(0,10), arr3.substring(0,2), arr3.substring(3));
							if(ddep3.compareTo(aarr3) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr3 = at.getHourAdd(aarr3,24);
							}
							System.out.println("dDep3 : " + ddep3 + " &&  aarr3 : " + aarr3);
	//						if(!(to3.equals(null)))	
	//						if((siding3.equals(null)))	
//							if(from3 != to3)
							if(!service3.trim().equals("Siding")) 
							{
								if(blnFirst3)
								{
									dist3 = cd.getDistance(from3,to3,section3);
									dist = dist + dist3;
									
									if(service3.trim().equals("Pilot"))
									{
										distPilot = distPilot + dist3;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from3;
											pilotTo = to3;
											if(from3.equals(depot))
											{
												relief  = aarr3;
											}
											else
											{
												relief  = ddep3;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from3;
											pilotTo1 = to3;
											relief1  = ddep3;
										}
										else
										{
											pilotFrom2 = from3;
											pilotTo2 = to3;
											relief2  = ddep3;
										}
									}
								}
								else 
								{
									dist  = dist - dist3;
									if(service3.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist3;
									}
									dist3 = cd.getDistance(from3,to3,section3);
									dist +=  dist3;
									if(service3.trim().equals("Pilot"))
									{
										distPilot += dist3;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from3;
											pilotTo = to3;
											if(from3.equals(depot))
											{
												relief  = aarr3;
											}
											else
											{
												relief  = ddep3;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from3;
											pilotTo1 = to3;
											relief1  = ddep3;
										}
										else
										{
											pilotFrom2 = from3;
											pilotTo2 = to3;
											relief2  = ddep3;
										}
									}
								}
								if(to3.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else if((service3.trim().equals("Siding")))	
							{
								querySiding = "Select kms from sidings where name ='" + siding3.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst3)
								{
									dist3 = sk.getSidingKm("",querySiding);
									dist += dist3;
								}
								else
								{
									dist  = dist - dist3;
									dist3 = sk.getSidingKm("",querySiding);
									dist +=  dist3;
								}
							}
							if(blnFirst3)
							{
								hour3 = ct.getHourBetween(aarr2,aarr3);
								if(service3.trim().equals("Pilot"))
								{
									hourPilot3 = ct.getHourBetween(ddep3,aarr3);
									pilotHours += hourPilot3;
								}
								if(service3.trim().equals("Siding"))
								{
									hourSdg3 = ct.getHourBetween(ddep3,aarr3);
									sidingHours += hourSdg3;
								}
								if(service3.trim().equals("Shunting"))
								{
									hourShtg3 = ct.getHourBetween(ddep3,aarr3);
									shuntingHours += hourShtg3;
								}
								System.out.println(" aarr2 : " + aarr2 + " ** aarr3 : " + aarr3  + 
								" hours3: " + hour3 + " dist3 : " + dist3);
								workingHours = workingHours + hour3;
							}
							else
							{
								workingHours = workingHours - hour3;
								if(service3.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot3;
									hourPilot3 = 0;
								}
								if(service3.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg3;
									hourSdg3 = 0;
								}
								if(service3.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg3;
									hourShtg3 = 0;
								}
								hour3 = ct.getHourBetween(aarr2,aarr3);
								if(service3.trim().equals("Pilot"))
								{
									hourPilot3 = ct.getHourBetween(ddep3,aarr3);
									pilotHours += hourPilot3;
								}
								if(service3.trim().equals("Siding"))
								{
									hourSdg3 = ct.getHourBetween(ddep3,aarr3);
									sidingHours += hourSdg3;
								}
								if(service3.trim().equals("Shunting"))
								{
									hourShtg3 = ct.getHourBetween(ddep3,aarr3);
									shuntingHours += hourShtg3;
								}							
								System.out.println(" aarr2 : " + aarr2 + " ** aarr3 : " + aarr3  + 
								" hours3 : " + hour3 + " dist3 : " + dist3);
								workingHours = workingHours + hour3;
							}
							arrivalDate = aarr3;
							//          signOfDate = retSignof(service,aarr3);
							//         System.out.println("signOfDate : " + signOfDate+ " : " + blnBaseStation);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label3.setText(new Integer(dist3).toString()+"/"+hour3);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst3 = false;
//							returnMileage(service3, dist3, hour3);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR3  ********************************");
			}
		});
		jcbDep4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP4 ********************************");
				if(blnClear)
				{
					if(!service4.equals(null) || !service4.equals(" "))
					{
						dep4 = (String) jcbDep4.getSelectedItem();
						ddep4 = cdmf.getChangedFormat1(aarr3.substring(0,10), dep4.substring(0,2), dep4.substring(3));
						System.out.println("Dep4 : " + dep4 + " ddep4 : " + ddep4);
						if(aarr3.compareTo(ddep4) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep4 = at.getHourAdd(ddep4,24);
						}
						System.out.println("aarr3 : " + aarr3 + " & ddep4 : " + ddep4);
					}
				}
				System.out.println("************************** END DEP4 ********************************");
			}
		});
		jcbArr4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR4 ********************************");
				if(blnClear)
				{
					if(!service4.equals(null) || !service4.equals(" "))
					{
						try
						{
							engine4 = (String) jftfLoco4.getValue();
							train4 = (String) jcbTrainno4.getSelectedItem();
							service4 = (String) jcbService4.getSelectedItem();
							section4 = (String) jcbSection4.getSelectedItem();
							try
							{
								from4 = (String) jcbFrom4.getSelectedItem();
							}
							catch(Exception e1)
							{
								from4 = null;
							}
							try
							{
								to4 = (String) jcbTo4.getSelectedItem();
							}
							catch(Exception e2)
							{
								to4 = null;
							}
							try
							{
								siding4 = (String) jcbSiding4.getSelectedItem();
								if(siding4.equals(" "))
									siding4 = null;

							}
							catch(Exception e2)
							{
								siding3 = null;
							}
							load4 = (String) jftfLoad4.getValue();
							dep4 = (String) jcbDep4.getSelectedItem();
							arr4 = (String) jcbArr4.getSelectedItem();
								
							lrstation = to4;
							System.out.println("4 : "+ engine4 +  " : " +train4+" : " + service4 + " :  " + from4 +
																	" : " + to4 + " : " + load4 + " : " + dep4 + " : " + arr4 );
							try
							{
								loconotfound = "";
								if(engine4 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine4);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco4.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex4)
							{
							}
							aarr4 = cdmf.getChangedFormat1( ddep4.substring(0,10), arr4.substring(0,2), arr4.substring(3));
							if(ddep4.compareTo(aarr4) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr4 = at.getHourAdd(aarr4,24);
							}
							System.out.println("dDep4 : " + ddep4 + " &&  aarr4 : " + aarr4);
	//						if(!(to4.equals(null)))	
	//						if((siding4.equals(null)))	
//							if(from4 != to4)
							if(!service4.trim().equals("Siding")) 
							{
								if(blnFirst4)
								{
									dist4 = cd.getDistance(from4,to4,section4);
									dist = dist + dist4;
									
									if(service4.trim().equals("Pilot"))
									{
										distPilot = distPilot + dist4;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from4;
											pilotTo = to4;
											if(from4.equals(depot))
											{
												relief  = aarr4;
											}
											else
											{
												relief  = ddep4;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from4;
											pilotTo1 = to4;
											relief1  = ddep4;
										}
										else
										{
											pilotFrom2 = from4;
											pilotTo2 = to4;
											relief2  = ddep4;
										}
									}
								}
								else
								{
									dist  = dist - dist4;
									if(service4.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist4;
									}
									dist4 = cd.getDistance(from4,to4,section4);
									dist +=  dist4;
									if(service4.trim().equals("Pilot"))
									{
										distPilot += dist4;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from4;
											pilotTo = to4;
											if(from4.equals(depot))
											{
												relief  = aarr4;
											}
											else
											{
												relief  = ddep4;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from4;
											pilotTo1 = to4;
											relief1  = ddep4;
										}
										else
										{
											pilotFrom2 = from4;
											pilotTo2 = to4;
											relief2  = ddep4;
										}
									}
								}
								if(to4.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else //if(!(siding4.trim().equals(null)))	
							{
								querySiding = "Select kms from sidings where name ='" + siding4.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst4)
								{
									dist4 = sk.getSidingKm("",querySiding);
									dist += dist4;
								}
								else
								{
									dist  = dist - dist4;
									dist4 = sk.getSidingKm("",querySiding);
									dist +=  dist4;
								}
							}
							if(blnFirst4)
							{
								hour4 = ct.getHourBetween(aarr3,aarr4);
								if(service4.trim().equals("Pilot"))
								{
									hourPilot4 = ct.getHourBetween(ddep4,aarr4);
									pilotHours += hourPilot4;
								}
								if(service4.trim().equals("Siding"))
								{
									hourSdg4 = ct.getHourBetween(ddep4,aarr4);
									sidingHours += hourSdg4;
								}
								if(service4.trim().equals("Shunting"))
								{
									hourShtg4 = ct.getHourBetween(ddep4,aarr4);
									shuntingHours += hourShtg4;
								}
								System.out.println(" aarr3 : " + aarr3 + " ** aarr4 : " + aarr4  + " hours4 : " + hour4);
								workingHours = workingHours + hour4;
							}
							else
							{
								workingHours = workingHours - hour4;
								if(service4.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot4;
									hourPilot4 = 0;
								}
								if(service4.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg4;
									hourSdg4 = 0;
								}
								if(service4.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg4;
									hourShtg4 = 0;
								}
								hour4 = ct.getHourBetween(aarr3,aarr4);
								if(service4.trim().equals("Pilot"))
								{
									hourPilot4 = ct.getHourBetween(ddep4,aarr4);
									pilotHours += hourPilot4;
								}
								if(service4.trim().equals("Siding"))
								{
									hourSdg4 = ct.getHourBetween(ddep4,aarr4);
									sidingHours += hourSdg4;
								}
								if(service4.trim().equals("Shunting"))
								{
									hourShtg4 = ct.getHourBetween(ddep4,aarr4);
									shuntingHours += hourShtg4;
								}
								System.out.println(" aarr3 : " + aarr3 + " ** aarr4 : " + aarr4  + " hours4 : " + hour4);
								workingHours = workingHours + hour4;
							}
							arrivalDate = aarr4;
							//          signOfDate = retSignof(service,aarr4);
							//         System.out.println("signOfDate : " + signOfDate);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label4.setText(new Integer(dist4).toString()+"/"+hour4);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst4 = false;
//							returnMileage(service4, dist4, hour4);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR4  ********************************");
			}
		});
		
		jcbDep5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP5 ********************************");
				if(blnClear)
				{
					if(!service5.equals(null) || !service5.equals(" "))
					{
						dep5 = (String) jcbDep5.getSelectedItem();
						ddep5 = cdmf.getChangedFormat1(aarr4.substring(0,10), dep5.substring(0,2), dep5.substring(3));
						System.out.println("Dep5 : " + dep5 + " ddep5 : " + ddep5);
						if(aarr4.compareTo(ddep5) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep5 = at.getHourAdd(ddep5,24);
						}
						System.out.println("aarr4 : " + aarr4 + " & ddep5 : " + ddep5);
					}
				}
				System.out.println("************************** END DEP5 ********************************");
			}
		});
		jcbArr5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR5 ********************************");
				if(blnClear)
				{
					if(!service5.equals(null) || !service5.equals(" "))
					{
						try
						{
							engine5 = (String) jftfLoco5.getValue();
							train5 = (String) jcbTrainno5.getSelectedItem();
							service5 = (String) jcbService5.getSelectedItem();
							section5 = (String) jcbSection5.getSelectedItem();
							try
							{
								from5 = (String) jcbFrom5.getSelectedItem();
							}
							catch(Exception e1)
							{
								from5 = null;
							}
							try
							{
								to5 = (String) jcbTo5.getSelectedItem();
							}
							catch(Exception e2)
							{
								to5 = null;
							}
							try
							{
								siding5 = (String) jcbSiding5.getSelectedItem();
								if(siding5.equals(" "))
								siding5 = null;
							}
							catch(Exception e2)
							{
								siding5 = null;
							}
							load5 = (String) jftfLoad5.getValue();
							dep5 = (String) jcbDep5.getSelectedItem();
							arr5 = (String) jcbArr5.getSelectedItem();
								
							lrstation = to5;
							System.out.println("5 : "+ engine5 +  " : " +train5+" : " + service5 + " :  " + from5 +
																	" : " + to5 + " : " + load5 + " : " + dep5 + " : " + arr5 );
							try
							{
								loconotfound = "";
								if(engine5 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine5);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco5.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex5)
							{
							}
							aarr5 = cdmf.getChangedFormat1( ddep5.substring(0,10), arr5.substring(0,2), arr5.substring(3));
							if(ddep5.compareTo(aarr5) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr5 = at.getHourAdd(aarr5,24);
							}
							System.out.println("dDep5 : " + ddep5 + " &&  aarr5 : " + aarr5);
	//						if(!(to5.equals(null)))	
	//						if((siding5.equals(null)))	
//							if(from5 != to5)
							if(!service5.trim().equals("Siding")) 
							{
								if(blnFirst5)
								{
									dist5 = cd.getDistance(from5,to5,section5);
									dist = dist + dist5;
									
									if(service5.trim().equals("Pilot"))
									{
										distPilot = distPilot + dist5;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from5;
											pilotTo = to5;
											if(from5.equals(depot))
											{
												relief  = aarr5;
											}
											else
											{
												relief  = ddep5;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from5;
											pilotTo1 = to5;
											relief1  = ddep5;
										}
										else
										{
											pilotFrom2 = from5;
											pilotTo2 = to5;
											relief2  = ddep5;
										}
									}
								}
								else
								{
									dist  = dist - dist5;
									if(service5.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist5;
									}
									dist5 = cd.getDistance(from5,to5,section5);
									dist +=  dist5;
									if(service5.trim().equals("Pilot"))
									{
										distPilot += dist5;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from5;
											pilotTo = to5;
											if(from5.equals(depot))
											{
												relief  = aarr5;
											}
											else
											{
												relief  = ddep5;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from5;
											pilotTo1 = to5;
											relief1  = ddep5;
										}
										else
										{
											pilotFrom2 = from5;
											pilotTo2 = to5;
											relief2  = ddep5;
										}
									}
								}
								if(to5.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else //if(!(siding5.trim().equals(null)))	
							{
								querySiding = "Select kms from sidings where name ='" + siding5.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst5)
								{
									dist5 = sk.getSidingKm("",querySiding);
									dist += dist5;
								}
								else
								{
									dist  = dist - dist5;
									dist5 = sk.getSidingKm("",querySiding);
									dist +=  dist5;
								}
							}
							if(blnFirst5)
							{
								hour5 = ct.getHourBetween(aarr4,aarr5);
								if(service5.trim().equals("Pilot"))
								{
									hourPilot5 = ct.getHourBetween(ddep5,aarr5);
									pilotHours += hourPilot5;
								}
								if(service5.trim().equals("Siding"))
								{
									hourSdg5 = ct.getHourBetween(ddep5,aarr5);
									sidingHours += hourSdg5;
								}
								if(service5.trim().equals("Shunting"))
								{
									hourShtg5 = ct.getHourBetween(ddep5,aarr5);
									shuntingHours += hourShtg5;
								}
								System.out.println(" aarr4 : " + aarr4 + " ** aarr5 : " + aarr5  + " hours5 : " + hour5);
								workingHours = workingHours + hour5;
							}
							else
							{
								workingHours = workingHours - hour5;
								if(service5.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot5;
									hourPilot5 = 0;
								}
								if(service5.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg5;
									hourSdg5 = 0;
								}
								if(service5.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg5;
									hourShtg5 = 0;
								}
								hour5 = ct.getHourBetween(aarr4,aarr5);
								if(service5.trim().equals("Pilot"))
								{
									hourPilot5 = ct.getHourBetween(ddep5,aarr5);
									pilotHours += hourPilot5;
								}
								if(service5.trim().equals("Siding"))
								{
									hourSdg5 = ct.getHourBetween(ddep5,aarr5);
									sidingHours += hourSdg5;
								}
								if(service5.trim().equals("Shunting"))
								{
									hourShtg5 = ct.getHourBetween(ddep5,aarr5);
									shuntingHours += hourShtg5;
								}
								System.out.println(" aarr4 : " + aarr4 + " ** aarr5 : " + aarr5  + " hours5 : " + hour5);
								workingHours = workingHours + hour5;
							}
							arrivalDate = aarr5;
							//          signOfDate = retSignof(service,aarr5);
							//         System.out.println("signOfDate : " + signOfDate);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label5.setText(new Integer(dist5).toString()+"/"+hour5);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst5 = false;
//							returnMileage(service5, dist5, hour5);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR5  ********************************");
			}
		});
		jcbDep6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP6 ********************************");
				if(blnClear)
				{
					if(!service6.equals(null) || !service6.equals(" "))
					{
						dep6 = (String) jcbDep6.getSelectedItem();
						ddep6 = cdmf.getChangedFormat1(aarr5.substring(0,10), dep6.substring(0,2), dep6.substring(3));
						System.out.println("Dep6 : " + dep6 + " ddep6 : " + ddep6);
						if(aarr5.compareTo(ddep6) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep6 = at.getHourAdd(ddep6,24);
						}
						System.out.println("aarr5 : " + aarr5 + " & ddep6 : " + ddep6);
					}
				}
				System.out.println("************************** END DEP6 ********************************");
			}
		});
		jcbArr6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR6 ********************************");
				if(blnClear)
				{
					if(!service6.equals(null) || !service6.equals(" "))
					{
						try
						{
							engine6 = (String) jftfLoco6.getValue();
							train6 = (String) jcbTrainno6.getSelectedItem();
							service6 = (String) jcbService6.getSelectedItem();
							section6 = (String) jcbSection6.getSelectedItem();
							try
							{
								from6 = (String) jcbFrom6.getSelectedItem();
							}
							catch(Exception e1)
							{
								from6 = null;
							}
							try
							{
								to6 = (String) jcbTo6.getSelectedItem();
							}
							catch(Exception e2)
							{
								to6 = null;
							}
							try
							{
								siding6 = (String) jcbSiding6.getSelectedItem();
								if(siding6.equals(" "))
								siding6 = null;
							}
							catch(Exception e2)
							{
								siding6 = null;
							}						
							load6 = (String) jftfLoad6.getValue();
							dep6 = (String) jcbDep6.getSelectedItem();
							arr6 = (String) jcbArr6.getSelectedItem();
								
							lrstation = to6;
							System.out.println("6 : "+ engine6 +  " : " +train6+" : " + service6 + " :  " + from6 +
																	" : " + to6 + " : " + load6 + " : " + dep6 + " : " + arr6 );
							try
							{
								loconotfound = "";
								if(engine6 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine6);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco6.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex6)
							{
							}
							aarr6 = cdmf.getChangedFormat1( ddep6.substring(0,10), arr6.substring(0,2), arr6.substring(3));
							if(ddep6.compareTo(aarr6) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr6 = at.getHourAdd(aarr6,24);
							}
							System.out.println("dDep6 : " + ddep6 + " &&  aarr6 : " + aarr6);
	//						if(!(to6.equals(null)))	
	//						if((siding6.equals(null)))	
//							if(from6 != to6)
							if(!service6.trim().equals("Siding")) 
							{
								if(blnFirst6)
								{
									dist6 = cd.getDistance(from6,to6,section6);
									dist = dist + dist6;
									
									if(service6.trim().equals("Pilot"))
									{
										distPilot = distPilot + dist6;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from6;
											pilotTo = to6;
											if(from6.equals(depot))
											{
												relief  = aarr6;
											}
											else
											{
												relief  = ddep6;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from6;
											pilotTo1 = to6;
											relief1  =ddep6;
										}
										else
										{
											pilotFrom2 = from6;
											pilotTo2 = to6;
											relief2  = ddep6;
										}
									}
								}
								else
								{
									dist  = dist - dist6;
									if(service6.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist6;
									}
									dist6 = cd.getDistance(from6,to6,section6);
									dist +=  dist6;
									if(service6.trim().equals("Pilot"))
									{
										distPilot += dist6;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from6;
											pilotTo = to6;
											if(from6.equals(depot))
											{
												relief  = aarr6;
											}
											else
											{
												relief  = ddep6;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from6;
											pilotTo1 = to6;
											relief1  = ddep6;
										}
										else
										{
											pilotFrom2 = from6;
											pilotTo2 = to6;
											relief2  = ddep6;
										}
									}
								}
								if(to6.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else //if(!(siding6.trim().equals(null)))	
							{
								querySiding = "Select kms from sidings where name ='" + siding6.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst6)
								{
									dist6 = sk.getSidingKm("",querySiding);
									dist += dist6;
								}
								else
								{
									dist  = dist - dist6;
									dist6 = sk.getSidingKm("",querySiding);
									dist +=  dist6;
								}
							}
							if(blnFirst6)
							{
								hour6 = ct.getHourBetween(aarr5,aarr6);
								if(service6.trim().equals("Pilot"))
								{
									hourPilot6 = ct.getHourBetween(ddep6,aarr6);
									pilotHours += hourPilot6;
								}
								if(service6.trim().equals("Siding"))
								{
									hourSdg6 = ct.getHourBetween(ddep6,aarr6);
									sidingHours += hourSdg6;
								}
								if(service6.trim().equals("Shunting"))
								{
									hourShtg6 = ct.getHourBetween(ddep6,aarr6);
									shuntingHours += hourShtg6;
								}
								System.out.println(" aarr5 : " + aarr5 + " ** aarr6 : " + aarr6  + " hours6 : " + hour6);
								workingHours = workingHours + hour6;
							}
							else
							{
								workingHours = workingHours - hour6;
								if(service6.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot6;
									hourPilot6 = 0;
								}
								if(service6.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg6;
									hourSdg6 = 0;
								}
								if(service6.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg6;
									hourShtg6 = 0;
								}
								
								hour6 = ct.getHourBetween(aarr5,aarr6);
								if(service6.trim().equals("Pilot"))
								{
									hourPilot6 = ct.getHourBetween(ddep6,aarr6);
									pilotHours += hourPilot6;
								}
								if(service6.trim().equals("Siding"))
								{
									hourSdg6 = ct.getHourBetween(ddep6,aarr6);
									sidingHours += hourSdg6;
								}
								if(service6.trim().equals("Shunting"))
								{
									hourShtg6 = ct.getHourBetween(ddep6,aarr6);
									shuntingHours += hourShtg6;
								}
								System.out.println(" aarr5 : " + aarr5 + " ** aarr6 : " + aarr6  + " hours6 : " + hour6);
								workingHours = workingHours + hour6;
							}
							arrivalDate = aarr6;
							//          signOfDate = retSignof(service,aarr6);
							//         System.out.println("signOfDate : " + signOfDate);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label6.setText(new Integer(dist6).toString()+"/"+hour6);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst6 = false;
//							returnMileage(service6, dist6, hour6);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR6  ********************************");
			}
		});
		jcbDep7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP7 ********************************");
				if(blnClear)
				{
					if(!service7.equals(null) || !service7.equals(" "))
					{
						dep7 = (String) jcbDep7.getSelectedItem();
						ddep7 = cdmf.getChangedFormat1(aarr6.substring(0,10), dep7.substring(0,2), dep7.substring(3));
						System.out.println("Dep7 : " + dep7 + " ddep7 : " + ddep7);
						if(aarr6.compareTo(ddep7) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep7 = at.getHourAdd(ddep7,24);
						}
						System.out.println("aarr6 : " + aarr6 + " & ddep7 : " + ddep7);
					}
				}
				System.out.println("************************** END DEP7 ********************************");
			}
		});
		jcbArr7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR7 ********************************");
				if(blnClear)
				{
					if(!service7.equals(null) || !service7.equals(" "))
					{
						try
						{
							engine7 = (String) jftfLoco7.getValue();
							train7 = (String) jcbTrainno7.getSelectedItem();
							service7 = (String) jcbService7.getSelectedItem();
							section7 = (String) jcbSection7.getSelectedItem();
							try
							{
								from7 = (String) jcbFrom7.getSelectedItem();
							}
							catch(Exception e1)
							{
								from7 = null;
							}
							try
							{
								to7 = (String) jcbTo7.getSelectedItem();
							}
							catch(Exception e2)
							{
								to7 = null;
							}
							try
							{
								siding7 = (String) jcbSiding7.getSelectedItem();
								if(siding7.equals(" "))
								siding7 = null;
							}
							catch(Exception e2)
							{
								siding7 = null;
							}
							load7 = (String) jftfLoad7.getValue();
							dep7 = (String) jcbDep7.getSelectedItem();
							arr7 = (String) jcbArr7.getSelectedItem();

							lrstation = to7;
							System.out.println("7 : "+ engine7 +  " : " +train7+" : " + service7 + " :  " + from7 +
																	" : " + to7 + " : " + load7 + " : " + dep7 + " : " + arr7 );
							try
							{
								loconotfound = "";
								if(engine7 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine7);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco7.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex7)
							{
							}
							aarr7 = cdmf.getChangedFormat1( ddep7.substring(0,10), arr7.substring(0,2), arr7.substring(3));
							if(ddep7.compareTo(aarr7) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr7 = at.getHourAdd(aarr7,24);
							}
							System.out.println("dDep7 : " + ddep7 + " &&  aarr7 : " + aarr7);
	//						if(!(to7.equals(null)))	
	//						if((siding7.equals(null)))	
							//if(from7 != to7)
							if(!service7.trim().equals("Siding")) 
							{
								if(blnFirst7)
								{
									dist7 = cd.getDistance(from7,to7,section7);
									dist = dist + dist7;
									
									if(service7.trim().equals("Pilot"))
									{
										distPilot = distPilot + dist7;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from7;
											pilotTo = to7;
											if(from7.equals(depot))
											{
												relief  = aarr7;
											}
											else
											{
												relief  = ddep7;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from7;
											pilotTo1 = to7;
											relief1  = ddep7;
										}
										else
										{
											pilotFrom2 = from7;
											pilotTo2 = to7;
											relief2  = ddep7;
										}
									}
								}
								else
								{
									dist  = dist - dist7;
									if(service7.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist7;
									}
									dist7 = cd.getDistance(from7,to7,section7);
									dist +=  dist7;
									if(service7.trim().equals("Pilot"))
									{
										distPilot += dist7;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from7;
											pilotTo = to7;
											if(from7.equals(depot))
											{
												relief  = aarr7;
											}
											else
											{
												relief  = ddep7;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from7;
											pilotTo1 = to7;
											relief1  = ddep7;
										}
										else
										{
											pilotFrom2 = from7;
											pilotTo2 = to7;
											relief2  = ddep7;
										}
									}
								}
								if(to7.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else //if(!(siding7.trim().equals(null)))	
							{
								querySiding = "Select kms from sidings where name ='" + siding7.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst7)
								{
									dist7 = sk.getSidingKm("",querySiding);
									dist += dist7;
								}
								else
								{
									dist  = dist - dist7;
									dist7 = sk.getSidingKm("",querySiding);
									dist +=  dist7;
								}
							}
							if(blnFirst7)
							{
								hour7 = ct.getHourBetween(aarr6,aarr7);
								if(service7.trim().equals("Pilot"))
								{
									hourPilot7 = ct.getHourBetween(ddep7,aarr7);
									pilotHours += hourPilot7;
								}
								if(service7.trim().equals("Siding"))
								{
									hourSdg7 = ct.getHourBetween(ddep7,aarr7);
									sidingHours += hourSdg7;
								}
								if(service7.trim().equals("Shunting"))
								{
									hourShtg7 = ct.getHourBetween(ddep7,aarr7);
									shuntingHours += hourShtg7;
								}
								System.out.println(" aarr6 : " + aarr6 + " ** aarr7 : " + aarr7  + " hours7 : " + hour7);
								workingHours = workingHours + hour7;
							}
							else
							{
								workingHours = workingHours - hour7;
								if(service7.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot7;
									hourPilot7 = 0;
								}
								if(service7.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg7;
									hourSdg7 = 0;
								}
								if(service7.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg7;
									hourShtg7 = 0;
								}
								
								hour7 = ct.getHourBetween(aarr6,aarr7);
								if(service7.trim().equals("Pilot"))
								{
									hourPilot7 = ct.getHourBetween(ddep7,aarr7);
									pilotHours += hourPilot7;
								}
								if(service7.trim().equals("Siding"))
								{
									hourSdg7 = ct.getHourBetween(ddep7,aarr7);
									sidingHours += hourSdg7;
								}
								if(service7.trim().equals("Shunting"))
								{
									hourShtg7 = ct.getHourBetween(ddep7,aarr7);
									shuntingHours += hourShtg7;
								}
								System.out.println(" aarr6 : " + aarr6 + " ** aarr7 : " + aarr7  + " hours7 : " + hour7);
								workingHours = workingHours + hour7;
							}
							arrivalDate = aarr7;
							//          signOfDate = retSignof(service,aarr7);
							//         System.out.println("signOfDate : " + signOfDate);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label7.setText(new Integer(dist7).toString()+"/"+hour7);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst7 = false;
//							returnMileage(service7, dist7, hour7);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR7  ********************************");
			}
		});

		jcbDep8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP8 ********************************");
				if(blnClear)
				{
					if(!service8.equals(null) || !service8.equals(" "))
					{
						dep8 = (String) jcbDep8.getSelectedItem();
						ddep8 = cdmf.getChangedFormat1(aarr7.substring(0,10), dep8.substring(0,2), dep8.substring(3));
						System.out.println("Dep8 : " + dep8 + " ddep8 : " + ddep8);
						if(aarr7.compareTo(ddep8) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep8 = at.getHourAdd(ddep8,24);
						}
						System.out.println("aarr7 : " + aarr7 + " & ddep7 : " + ddep7);
					}
				}
				System.out.println("************************** END DEP8 ********************************");
			}
		});

		jcbArr8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR8 ********************************");
				if(blnClear)
				{
					if(!service8.equals(null) || !service8.equals(" "))
					{
						try
						{
							engine8 = (String) jftfLoco8.getValue();
							train8 = (String) jcbTrainno8.getSelectedItem();
							service8 = (String) jcbService8.getSelectedItem();
							section8 = (String) jcbSection8.getSelectedItem();
							try
							{
								from8 = (String) jcbFrom8.getSelectedItem();
							}
							catch(Exception e1)
							{
								from8 = null;
							}
							try
							{
								to8 = (String) jcbTo8.getSelectedItem();
							}
							catch(Exception e2)
							{
								to8 = null;
							}
							try
							{
								siding8 = (String) jcbSiding8.getSelectedItem();
								if(siding8.equals(" "))
								siding8 = null;
							}
							catch(Exception e2)
							{
								siding8 = null;
							}
							load8 = (String) jftfLoad8.getValue();
							dep8 = (String) jcbDep8.getSelectedItem();
							arr8 = (String) jcbArr8.getSelectedItem();

							lrstation = to8;
							System.out.println("8 : "+ engine8 +  " : " +train8+" : " + service8 + " :  " + from8 +
																	" : " + to8 + " : " + load8 + " : " + dep8 + " : " + arr8 );
							try
							{
								loconotfound = "";
								if(engine8 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine8);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco8.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex8)
							{
							}
							aarr8 = cdmf.getChangedFormat1( ddep8.substring(0,10), arr8.substring(0,2), arr8.substring(3));
							if(ddep8.compareTo(aarr8) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr8 = at.getHourAdd(aarr8,24);
							}
							System.out.println("dDep8 : " + ddep8 + " &&  aarr8 : " + aarr8);
	//						if(!(to8.equals(null)))	
	//						if((siding8.equals(null)))	
							//if(from8 != to8)
							if(!service8.trim().equals("Siding")) 
							{
								if(blnFirst8)
								{
									dist8 = cd.getDistance(from8,to8,section8);
									dist = dist + dist8;
									
									if(service8.trim().equals("Pilot"))
									{
										distPilot = distPilot + dist8;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from8;
											pilotTo = to8;
											if(from8.equals(depot))
											{
												relief  = aarr8;
											}
											else
											{
												relief  = ddep8;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from8;
											pilotTo1 = to8;
											relief1  = ddep8;
										}
										else
										{
											pilotFrom2 = from8;
											pilotTo2 = to8;
											relief2  = ddep8;
										}
									}
								}
								else
								{
									dist  = dist - dist8;
									if(service8.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist8;
									}
									dist8 = cd.getDistance(from8,to8,section8);
									dist +=  dist8;
									if(service8.trim().equals("Pilot"))
									{
										distPilot += dist8;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from8;
											pilotTo = to8;
											if(from8.equals(depot))
											{
												relief  = aarr8;
											}
											else
											{
												relief  = ddep8;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from8;
											pilotTo1 = to8;
											relief1  = ddep8;
										}
										else
										{
											pilotFrom2 = from8;
											pilotTo2 = to8;
											relief2  = ddep8;
										}
									}
								}
								if(to8.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else //if(!(siding8.trim().equals(null)))	
							{
								querySiding = "Select kms from sidings where name ='" + siding8.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst8)
								{
									dist8 = sk.getSidingKm("",querySiding);
									dist += dist8;
								}
								else
								{
									dist  = dist - dist8;
									dist8 = sk.getSidingKm("",querySiding);
									dist +=  dist8;
								}
							}
							if(blnFirst8)
							{
								hour8 = ct.getHourBetween(aarr7,aarr8);
								if(service8.trim().equals("Pilot"))
								{
									hourPilot8 = ct.getHourBetween(ddep8,aarr8);
									pilotHours += hourPilot8;
								}
								if(service8.trim().equals("Siding"))
								{
									hourSdg8 = ct.getHourBetween(ddep8,aarr8);
									sidingHours += hourSdg8;
								}
								if(service8.trim().equals("Shunting"))
								{
									hourShtg8 = ct.getHourBetween(ddep8,aarr8);
									shuntingHours += hourShtg8;
								}
								System.out.println(" aarr7 : " + aarr7 + " ** aarr8 : " + aarr8  + " hours8 : " + hour8);
								workingHours = workingHours + hour8;
							}
							else
							{
								workingHours = workingHours - hour8;
								if(service8.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot8;
									hourPilot8 = 0;
								}
								if(service8.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg8;
									hourSdg8 = 0;
								}
								if(service8.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg8;
									hourShtg8 = 0;
								}
								
								hour8 = ct.getHourBetween(aarr7,aarr8);
								if(service8.trim().equals("Pilot"))
								{
									hourPilot8 = ct.getHourBetween(ddep8,aarr8);
									pilotHours += hourPilot8;
								}
								if(service8.trim().equals("Siding"))
								{
									hourSdg8 = ct.getHourBetween(ddep8,aarr8);
									sidingHours += hourSdg8;
								}
								if(service8.trim().equals("Shunting"))
								{
									hourShtg8 = ct.getHourBetween(ddep8,aarr8);
									shuntingHours += hourShtg8;
								}
								System.out.println(" aarr7 : " + aarr7 + " ** aarr8 : " + aarr8  + " hours8 : " + hour8);
								workingHours = workingHours + hour8;
							}
							arrivalDate = aarr8;
							//          signOfDate = retSignof(service,aarr8);
							//         System.out.println("signOfDate : " + signOfDate);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label8.setText(new Integer(dist8).toString()+"/"+hour8);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst8 = false;
//							returnMileage(service8, dist8, hour8);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR8  ********************************");
			}
		});
		
		jcbDep9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP9 ********************************");
				if(blnClear)
				{
					if(!service9.equals(null) || !service9.equals(" "))
					{
						dep9 = (String) jcbDep9.getSelectedItem();
						ddep9 = cdmf.getChangedFormat1(aarr8.substring(0,10), dep9.substring(0,2), dep9.substring(3));
						System.out.println("Dep9 : " + dep9 + " ddep9 : " + ddep9);
						if(aarr8.compareTo(ddep9) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep9 = at.getHourAdd(ddep9,24);
						}
						System.out.println("aarr8 : " + aarr8 + " & ddep9 : " + ddep9);
					}
				}
				System.out.println("************************** END DEP9 ********************************");
			}
		});

		jcbArr9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR9 ********************************");
				if(blnClear)
				{
					if(!service9.equals(null) || !service9.equals(" "))
					{
						try
						{
							engine9 = (String) jftfLoco9.getValue();
							train9 = (String) jcbTrainno9.getSelectedItem();
							service9 = (String) jcbService9.getSelectedItem();
							section9 = (String) jcbSection9.getSelectedItem();
							try
							{
								from9 = (String) jcbFrom9.getSelectedItem();
							}
							catch(Exception e1)
							{
								from9 = null;
							}
							try
							{
								to9 = (String) jcbTo9.getSelectedItem();
							}
							catch(Exception e2)
							{
								to9 = null;
							}
							try
							{
								siding9 = (String) jcbSiding9.getSelectedItem();
								if(siding9.equals(" "))
								siding9 = null;
							}
							catch(Exception e2)
							{
								siding9 = null;
							}
							load9 = (String) jftfLoad9.getValue();
							dep9 = (String) jcbDep9.getSelectedItem();
							arr9 = (String) jcbArr9.getSelectedItem();

							lrstation = to9;
							System.out.println("9 : "+ engine9 +  " : " +train9+" : " + service9 + " :  " + from9 +
																	" : " + to9 + " : " + load9 + " : " + dep9 + " : " + arr9 );
							try
							{
								loconotfound = "";
								if(engine9 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine9);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco9.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex9)
							{
							}
							aarr9 = cdmf.getChangedFormat1( ddep9.substring(0,10), arr9.substring(0,2), arr9.substring(3));
							if(ddep9.compareTo(aarr9) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr9 = at.getHourAdd(aarr9,24);
							}
							System.out.println("dDep9 : " + ddep9 + " &&  aarr9 : " + aarr9);
	//						if(!(to9.equals(null)))	
	//						if((siding9.equals(null)))	
							//if(from9 != to9)
							if(!service9.trim().equals("Siding")) 
							{
								if(blnFirst9)
								{
									dist9 = cd.getDistance(from9,to9,section9);
									dist = dist + dist9;
									
									if(service9.trim().equals("Pilot"))
									{
										distPilot = distPilot + dist9;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from9;
											pilotTo = to9;
											if(from9.equals(depot))
											{
												relief  = aarr9;
											}
											else
											{
												relief  = ddep9;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from9;
											pilotTo1 = to9;
											relief1  = ddep9;
										}
										else
										{
											pilotFrom2 = from9;
											pilotTo2 = to9;
											relief2  = ddep9;
										}
									}
								}
								else
								{
									dist  = dist - dist9;
									if(service9.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist9;
									}
									dist9 = cd.getDistance(from9,to9,section9);
									dist +=  dist9;
									if(service9.trim().equals("Pilot"))
									{
										distPilot += dist9;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from9;
											pilotTo = to9;
											if(from9.equals(depot))
											{
												relief  = aarr9;
											}
											else
											{
												relief  = ddep9;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from9;
											pilotTo1 = to9;
											relief1  = ddep9;
										}
										else
										{
											pilotFrom2 = from9;
											pilotTo2 = to9;
											relief2  = ddep9;
										}
									}
								}
								if(to9.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else //if(!(siding9.trim().equals(null)))	
							{
								querySiding = "Select kms from sidings where name ='" + siding9.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst9)
								{
									dist9 = sk.getSidingKm("",querySiding);
									dist += dist9;
								}
								else
								{
									dist  = dist - dist9;
									dist9 = sk.getSidingKm("",querySiding);
									dist +=  dist9;
								}
							}
							if(blnFirst9)
							{
								hour9 = ct.getHourBetween(aarr8,aarr9);
								if(service9.trim().equals("Pilot"))
								{
									hourPilot9 = ct.getHourBetween(ddep9,aarr9);
									pilotHours += hourPilot9;
								}
								if(service9.trim().equals("Siding"))
								{
									hourSdg9 = ct.getHourBetween(ddep9,aarr9);
									sidingHours += hourSdg9;
								}
								if(service9.trim().equals("Shunting"))
								{
									hourShtg9 = ct.getHourBetween(ddep9,aarr9);
									shuntingHours += hourShtg9;
								}
								System.out.println(" aarr8 : " + aarr8 + " ** aarr9 : " + aarr9  + " hours9 : " + hour9);
								workingHours = workingHours + hour9;
							}
							else
							{
								workingHours = workingHours - hour9;
								if(service9.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot9;
									hourPilot9 = 0;
								}
								if(service9.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg9;
									hourSdg9 = 0;
								}
								if(service9.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg9;
									hourShtg9 = 0;
								}
								
								hour9 = ct.getHourBetween(aarr8,aarr9);
								if(service9.trim().equals("Pilot"))
								{
									hourPilot9 = ct.getHourBetween(ddep9,aarr9);
									pilotHours += hourPilot9;
								}
								if(service9.trim().equals("Siding"))
								{
									hourSdg9 = ct.getHourBetween(ddep9,aarr9);
									sidingHours += hourSdg9;
								}
								if(service9.trim().equals("Shunting"))
								{
									hourShtg9 = ct.getHourBetween(ddep9,aarr9);
									shuntingHours += hourShtg9;
								}
								System.out.println(" aarr8 : " + aarr8 + " ** aarr9 : " + aarr9  + " hours9 : " + hour9);
								workingHours = workingHours + hour9;
							}
							arrivalDate = aarr9;
							//          signOfDate = retSignof(service,aarr9);
							//         System.out.println("signOfDate : " + signOfDate);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label9.setText(new Integer(dist9).toString()+"/"+hour9);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst9 = false;
//							returnMileage(service9, dist9, hour9);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR9  ********************************");
			}
		});
		
		jcbDep10.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP10 ********************************");
				if(blnClear)
				{
					if(!service10.equals(null) || !service10.equals(" "))
					{
						dep10 = (String) jcbDep10.getSelectedItem();
						ddep10 = cdmf.getChangedFormat1(aarr9.substring(0,10), dep10.substring(0,2), dep10.substring(3));
						System.out.println("Dep10 : " + dep10 + " ddep10 : " + ddep10);
						if(aarr9.compareTo(ddep10) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep10 = at.getHourAdd(ddep10,24);
						}
						System.out.println("aarr9 : " + aarr9 + " & ddep10 : " + ddep10);
					}
				}
				System.out.println("************************** END DEP10 ********************************");
			}
		});

		jcbArr10.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR10 ********************************");
				if(blnClear)
				{
					if(!service10.equals(null) || !service10.equals(" "))
					{
						try
						{
							engine10 = (String) jftfLoco10.getValue();
							train10 = (String) jcbTrainno10.getSelectedItem();
							service10 = (String) jcbService10.getSelectedItem();
							section10 = (String) jcbSection10.getSelectedItem();
							try
							{
								from10 = (String) jcbFrom10.getSelectedItem();
							}
							catch(Exception e1)
							{
								from10 = null;
							}
							try
							{
								to10 = (String) jcbTo10.getSelectedItem();
							}
							catch(Exception e2)
							{
								to10 = null;
							}
							try
							{
								siding10 = (String) jcbSiding10.getSelectedItem();
								if(siding10.equals(" "))
								siding10 = null;
							}
							catch(Exception e2)
							{
								siding10 = null;
							}
							load10 = (String) jftfLoad10.getValue();
							dep10 = (String) jcbDep10.getSelectedItem();
							arr10 = (String) jcbArr10.getSelectedItem();

							lrstation = to10;
							System.out.println("10 : "+ engine10 +  " : " +train10+" : " + service10 + " :  " + from10 +
																	" : " + to10 + " : " + load10 + " : " + dep10 + " : " + arr10 );
							try
							{
								loconotfound = "";
								if(engine10 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine10);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco10.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex10)
							{
							}
							aarr10 = cdmf.getChangedFormat1( ddep10.substring(0,10), arr10.substring(0,2), arr10.substring(3));
							if(ddep10.compareTo(aarr10) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr10 = at.getHourAdd(aarr10,24);
							}
							System.out.println("dDep10 : " + ddep10 + " &&  aarr10 : " + aarr10);
	//						if(!(to10.equals(null)))	
//							if((siding10.equals(null)))	
							//if(from10 != to10)
							if(!service10.trim().equals("Siding")) 
							{
								if(blnFirst10)
								{
									dist10 = cd.getDistance(from10,to10,section10);
									dist = dist + dist10;
									
									if(service10.trim().equals("Pilot"))
									{
										distPilot = distPilot + dist10;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from10;
											pilotTo = to10;
											if(from10.equals(depot))
											{
												relief  = aarr10;
											}
											else
											{
												relief  = ddep10;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from10;
											pilotTo1 = to10;
											relief1  = ddep10;
										}
										else
										{
											pilotFrom2 = from10;
											pilotTo2 = to10;
											relief2  =ddep10;
										}
									}
								}
								else
								{
									dist  = dist - dist10;
									if(service10.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist10;
									}
									dist10 = cd.getDistance(from10,to10,section10);
									dist +=  dist10;
									if(service10.trim().equals("Pilot"))
									{
										distPilot += dist10;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from10;
											pilotTo = to10;
											if(from10.equals(depot))
											{
												relief  = aarr10;
											}
											else
											{
												relief  = ddep10;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from10;
											pilotTo1 = to10;
											relief1  = ddep10;
										}
										else
										{
											pilotFrom2 = from10;
											pilotTo2 = to10;
											relief2  = ddep10;
										}
									}
								}
								if(to10.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else //if(!(siding10.trim().equals(null)))	
							{
								querySiding = "Select kms from sidings where name ='" + siding10.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst10)
								{
									dist10 = sk.getSidingKm("",querySiding);
									dist += dist10;
								}
								else
								{
									dist  = dist - dist10;
									dist10 = sk.getSidingKm("",querySiding);
									dist +=  dist10;
								}
							}
							if(blnFirst10)
							{
								hour10 = ct.getHourBetween(aarr9,aarr10);
								if(service10.trim().equals("Pilot"))
								{
									hourPilot10 = ct.getHourBetween(ddep10,aarr10);
									pilotHours += hourPilot10;
								}
								if(service10.trim().equals("Siding"))
								{
									hourSdg10 = ct.getHourBetween(ddep10,aarr10);
									sidingHours += hourSdg10;
								}
								if(service10.trim().equals("Shunting"))
								{
									hourShtg10 = ct.getHourBetween(ddep10,aarr10);
									shuntingHours += hourShtg10;
								}
								System.out.println(" aarr9 : " + aarr9 + " ** aarr10 : " + aarr10  + " hours10 : " + hour10);
								workingHours = workingHours + hour10;
							}
							else
							{
								workingHours = workingHours - hour10;
								if(service10.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot10;
									hourPilot10 = 0;
								}
								if(service10.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg10;
									hourSdg10 = 0;
								}
								if(service10.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg10;
									hourShtg10 = 0;
								}
								
								hour10 = ct.getHourBetween(aarr9,aarr10);
								if(service10.trim().equals("Pilot"))
								{
									hourPilot10 = ct.getHourBetween(ddep10,aarr10);
									pilotHours += hourPilot10;
								}
								if(service10.trim().equals("Siding"))
								{
									hourSdg10 = ct.getHourBetween(ddep10,aarr10);
									sidingHours += hourSdg10;
								}
								if(service10.trim().equals("Shunting"))
								{
									hourShtg10 = ct.getHourBetween(ddep10,aarr10);
									shuntingHours += hourShtg10;
								}
								System.out.println(" aarr9 : " + aarr9 + " ** aarr10 : " + aarr10  + " hours10 : " + hour10);
								workingHours = workingHours + hour10;
							}
							arrivalDate = aarr10;
							//          signOfDate = retSignof(service,aarr10);
							//         System.out.println("signOfDate : " + signOfDate);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label10.setText(new Integer(dist10).toString()+"/"+hour9);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst10 = false;
//							returnMileage(service10, dist10, hour10);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR10  ********************************");
			}
		});

		jcbDep11.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP11 ********************************");
				if(blnClear)
				{
					if(!service11.equals(null) || !service11.equals(" "))
					{
						dep11 = (String) jcbDep11.getSelectedItem();
						ddep11 = cdmf.getChangedFormat1(aarr10.substring(0,10), dep11.substring(0,2), dep11.substring(3));
						System.out.println("Dep11 : " + dep11 + " ddep11 : " + ddep11);
						if(aarr8.compareTo(ddep11) > 0 ) 
						{
							JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
									"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							ddep11 = at.getHourAdd(ddep11,24);
						}
						System.out.println("aarr10 : " + aarr10 + " & ddep11 : " + ddep11);
					}
				}
				System.out.println("************************** END DEP11 ********************************");
			}
		});

		jcbArr11.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR11 ********************************");
				if(blnClear)
				{
					if(!service11.equals(null) || !service11.equals(" "))
					{
						try
						{
							engine11 = (String) jftfLoco11.getValue();
							train11 = (String) jcbTrainno11.getSelectedItem();
							service11 = (String) jcbService11.getSelectedItem();
							section11 = (String) jcbSection11.getSelectedItem();
							try
							{
								from11 = (String) jcbFrom11.getSelectedItem();
							}
							catch(Exception e1)
							{
								from11 = null;
							}
							try
							{
								to11 = (String) jcbTo11.getSelectedItem();
							}
							catch(Exception e2)
							{
								to11 = null;
							}
							try
							{
								siding11 = (String) jcbSiding11.getSelectedItem();
								if(siding11.equals(" "))
								siding11 = null;
							}
							catch(Exception e2)
							{
								siding11 = null;
							}
							load11 = (String) jftfLoad11.getValue();
							dep11 = (String) jcbDep11.getSelectedItem();
							arr11 = (String) jcbArr11.getSelectedItem();

							lrstation = to11;
							System.out.println("11 : "+ engine11 +  " : " +train11+" : " + service11 + " :  " + from11 +
																	" : " + to11 + " : " + load11 + " : " + dep11 + " : " + arr11 );
							try
							{
								loconotfound = "";
								if(engine11 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine11);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco11.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex11)
							{
							}
							aarr11 = cdmf.getChangedFormat1( ddep11.substring(0,10), arr11.substring(0,2), arr11.substring(3));
							if(ddep11.compareTo(aarr11) > 0)
							{
								JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								aarr11 = at.getHourAdd(aarr11,24);
							}
							System.out.println("dDep11 : " + ddep11 + " &&  aarr11 : " + aarr11);
	//						if(!(to11.equals(null)))	
//							if((siding11.equals(null)))	
							//if(from11 != to11)
							if(!service11.trim().equals("Siding")) 
							{
								if(blnFirst11)
								{
									dist11 = cd.getDistance(from11,to11,section11);
									dist = dist + dist11;
									
									if(service11.trim().equals("Pilot"))
									{
										distPilot = distPilot + dist11;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from11;
											pilotTo = to11;
											if(from11.equals(depot))
											{
												relief  = aarr11;
											}
											else
											{
												relief  = ddep11;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from11;
											pilotTo1 = to11;
											relief1  = ddep11;
										}
										else
										{
											pilotFrom2 = from11;
											pilotTo2 = to11;
											relief2  = ddep11;
										}
									}
								}
								else
								{
									dist  = dist - dist11;
									if(service11.trim().equals("Pilot"))
									{
										distPilot = distPilot -  dist11;
									}
									dist11 = cd.getDistance(from11,to11,section11);
									dist +=  dist11;
									if(service11.trim().equals("Pilot"))
									{
										distPilot += dist11;
										if(pilotFrom.equals("null"))
										{
											pilotFrom = from11;
											pilotTo = to11;
											if(from11.equals(depot))
											{
												relief  = aarr11;
											}
											else
											{
												relief  = ddep11;		
											}
										}
										else if (pilotFrom1.equals("null"))
										{
											pilotFrom1 = from11;
											pilotTo1 = to11;
											relief1  = ddep11;
										}
										else
										{
											pilotFrom2 = from11;
											pilotTo2 = to11;
											relief2  = ddep11;
										}
									}
								}
								if(to11.equals(depot))
									blnBaseStation = true;
								else
									blnBaseStation = false;
							}
							else //if(!(siding11.trim().equals(null)))	
							{
								querySiding = "Select kms from sidings where name ='" + siding11.trim()+"'";
								System.out.println("Siding : " + querySiding);
								if(blnFirst11)
								{
									dist11 = sk.getSidingKm("",querySiding);
									dist += dist11;
								}
								else
								{
									dist  = dist - dist11;
									dist11 = sk.getSidingKm("",querySiding);
									dist +=  dist11;
								}
							}
							if(blnFirst11)
							{
								hour11 = ct.getHourBetween(aarr10,aarr11);
								if(service11.trim().equals("Pilot"))
								{
									hourPilot11 = ct.getHourBetween(ddep11,aarr11);
									pilotHours += hourPilot11;
								}
								if(service11.trim().equals("Siding"))
								{
									hourSdg11 = ct.getHourBetween(ddep11,aarr11);
									sidingHours += hourSdg11;
								}
								if(service11.trim().equals("Shunting"))
								{
									hourShtg11 = ct.getHourBetween(ddep11,aarr11);
									shuntingHours += hourShtg11;
								}
								System.out.println(" aarr10 : " + aarr10 + " ** aarr11 : " + aarr11  + " hours11 : " + hour11);
								workingHours = workingHours + hour11;
							}
							else
							{
								workingHours = workingHours - hour11;
								if(service11.trim().equals("Pilot"))
								{
									pilotHours = pilotHours - hourPilot11;
									hourPilot11 = 0;
								}
								if(service11.trim().equals("Siding"))
								{
									sidingHours = sidingHours - hourSdg11;
									hourSdg11 = 0;
								}
								if(service11.trim().equals("Shunting"))
								{
									shuntingHours = shuntingHours - hourShtg11;
									hourShtg11 = 0;
								}
								
								hour11 = ct.getHourBetween(aarr10,aarr11);
								if(service11.trim().equals("Pilot"))
								{
									hourPilot11 = ct.getHourBetween(ddep11,aarr11);
									pilotHours += hourPilot11;
								}
								if(service11.trim().equals("Siding"))
								{
									hourSdg11 = ct.getHourBetween(ddep11,aarr11);
									sidingHours += hourSdg11;
								}
								if(service11.trim().equals("Shunting"))
								{
									hourShtg11 = ct.getHourBetween(ddep11,aarr11);
									shuntingHours += hourShtg11;
								}
								System.out.println(" aarr10 : " + aarr10 + " ** aarr11 : " + aarr11  + " hours11 : " + hour11);
								workingHours = workingHours + hour11;
							}
							arrivalDate = aarr11;
							//          signOfDate = retSignof(service,aarr11);
							//         System.out.println("signOfDate : " + signOfDate);
							System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							label11.setText(new Integer(dist11).toString()+"/"+hour11);
							jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
							blnBase = blnBaseStation;
							blnFirst11 = false;
//							returnMileage(service11, dist11, hour11);
						}
						catch(Exception e)
						{
		//					e.printStackTrace();
						}
					}
				}
				System.out.println("************************** END ARR11  ********************************");
			}
		});
		jcbDep12.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("************************** DEP12 ********************************");
				if(blnClear)
				{
					try
					{
						if(!service12.equals(null) || !service12.equals(" "))
						{
							dep12 = (String) jcbDep12.getSelectedItem();
							ddep12 = cdmf.getChangedFormat1(aarr11.substring(0,10), dep12.substring(0,2), dep12.substring(3));
							System.out.println("Dep12 : " + dep12 + " ddep12 : " + ddep12);
							if(aarr11.compareTo(ddep12) > 0 ) 
							{
								JOptionPane.showMessageDialog(null,"Departure is lessthan Previous Arrival. "+
										"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								ddep12 = at.getHourAdd(ddep12,24);
							}
							System.out.println("aarr8 : " + aarr8 + " & ddep12 : " + ddep12);
						}
					}
					catch(Exception ex)
					{
					}
				}
				System.out.println("************************** END DEP12 ********************************");
			}
		});

		jcbArr12.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent me)
			{
				System.out.println("************************** ARR12 ********************************");
				if(blnClear)
				{
					try
					{
						if(!service12.equals(null) || !service12.equals(" "))
						{
							try
							{
								engine12 = (String) jftfLoco12.getValue();
								train12 = (String) jcbTrainno12.getSelectedItem();
								service12 = (String) jcbService12.getSelectedItem();
								section12 = (String) jcbSection12.getSelectedItem();
								try
								{
									from12 = (String) jcbFrom12.getSelectedItem();
								}
								catch(Exception e1)
								{
									from12 = null;
								}
								try
								{
									to12 = (String) jcbTo12.getSelectedItem();
								}
								catch(Exception e2)
								{
									to12 = null;
								}
								try
								{
									siding12 = (String) jcbSiding12.getSelectedItem();
									if(siding12.equals(" "))
									siding12 = null;
								}
								catch(Exception e2)
								{
									siding12 = null;
								}
								load12 = (String) jftfLoad12.getValue();
								dep12 = (String) jcbDep12.getSelectedItem();
								arr12 = (String) jcbArr12.getSelectedItem();

								lrstation = to12;
								System.out.println("12 : "+ engine12 +  " : " +train12+" : " + service12 + " :  " + from12 +
																		" : " + to12 + " : " + load12 + " : " + dep12 + " : " + arr12 );
								try
							{
								loconotfound = "";
								if(engine12 != "00000+00000+00000+00000+00000")
								{
									loconotfound = verifyLoco(engine12);
									if (loconotfound.length() > 2)
									{
										JOptionPane.showMessageDialog(null,"Locos  "+loconotfound+" donot exist in the database.\n"+
													" Please enter the new locos carefully and \n ***** ENTER TIME AGAIN ***** ","Click OK to Continue",
																											JOptionPane.ERROR_MESSAGE);
										jftfLoco12.requestFocus();
										return;
									}
									
								}
							}
							catch(Exception ex12)
							{
							}
								aarr12 = cdmf.getChangedFormat1( ddep12.substring(0,10), arr12.substring(0,2), arr12.substring(3));
								if(ddep12.compareTo(aarr12) > 0)
								{
									JOptionPane.showMessageDialog(null,"Arrival is lessthan to Departure. "+
											"\n Please Ensure it.","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
									aarr12 = at.getHourAdd(aarr12,24);
								}
								System.out.println("dDep12 : " + ddep12 + " &&  aarr12 : " + aarr12);
		//						if(!(to12.equals(null)))	
		//						if((siding12.equals(null)))	
								//if(from12 != to12)
								if(!service12.trim().equals("Siding")) 
								{
									if(blnFirst12)
									{
										dist12 = cd.getDistance(from12,to12,section12);
										dist = dist + dist12;
										
										if(service12.trim().equals("Pilot"))
										{
											distPilot = distPilot + dist12;
											if(pilotFrom.equals("null"))
											{
												pilotFrom = from12;
												pilotTo = to12;
												if(from12.equals(depot))
											{
												relief  = aarr12;
											}
											else
											{
												relief  = ddep12;		
											}
											}
											else if (pilotFrom1.equals("null"))
											{
												pilotFrom1 = from12;
												pilotTo1 = to12;
												relief1  = ddep12;
											}
											else
											{
												pilotFrom2 = from12;
												pilotTo2 = to12;
												relief2  = ddep12;
											}
										}
									}
									else
									{
										dist  = dist - dist12;
										if(service12.trim().equals("Pilot"))
										{
											distPilot = distPilot -  dist12;
										}
										dist12 = cd.getDistance(from12,to12,section12);
										dist +=  dist12;
										if(service12.trim().equals("Pilot"))
										{
											distPilot += dist12;
											if(pilotFrom.equals("null"))
											{
												pilotFrom = from12;
												pilotTo = to12;
												if(from12.equals(depot))
											{
												relief  = aarr12;
											}
											else
											{
												relief  = ddep12;		
											}

											}
											else if (pilotFrom1.equals("null"))
											{
												pilotFrom1 = from12;
												pilotTo1 = to12;
												relief1  = ddep12;
											}
											else
											{
												pilotFrom2 = from12;
												pilotTo2 = to12;
												relief2  = ddep12;
											}
										}
									}
									if(to12.equals(depot))
										blnBaseStation = true;
									else
										blnBaseStation = false;
								}
								else //if(!(siding12.trim().equals(null)))	
								{
									querySiding = "Select kms from sidings where name ='" + siding12.trim()+"'";
									System.out.println("Siding : " + querySiding);
									if(blnFirst12)
									{
										dist12 = sk.getSidingKm("",querySiding);
										dist += dist12;
									}
									else
									{
										dist  = dist - dist12;
										dist12 = sk.getSidingKm("",querySiding);
										dist +=  dist12;
									}
								}
								if(blnFirst12)
								{
									hour12 = ct.getHourBetween(aarr11,aarr12);
									if(service12.trim().equals("Pilot"))
									{
										hourPilot12 = ct.getHourBetween(ddep12,aarr12);
										pilotHours += hourPilot12;
									}
									if(service12.trim().equals("Siding"))
									{
										hourSdg12 = ct.getHourBetween(ddep12,aarr12);
										sidingHours += hourSdg12;
									}
									if(service12.trim().equals("Shunting"))
									{
										hourShtg12 = ct.getHourBetween(ddep12,aarr12);
										shuntingHours += hourShtg12;
									}
									System.out.println(" aarr11 : " + aarr11 + " ** aarr12 : " + aarr12  + " hours12 : " + hour12);
									workingHours = workingHours + hour12;
								}
								else
								{
									workingHours = workingHours - hour12;
									if(service12.trim().equals("Pilot"))
									{
										pilotHours = pilotHours - hourPilot12;
										hourPilot12 = 0;
									}
									if(service12.trim().equals("Siding"))
									{
										sidingHours = sidingHours - hourSdg12;
										hourSdg12 = 0;
									}
									if(service12.trim().equals("Shunting"))
									{
										shuntingHours = shuntingHours - hourShtg12;
										hourShtg12 = 0;
									}
									
									hour12 = ct.getHourBetween(aarr11,aarr12);
									if(service12.trim().equals("Pilot"))
									{
										hourPilot12 = ct.getHourBetween(ddep12,aarr12);
										pilotHours += hourPilot12;
									}
									if(service12.trim().equals("Siding"))
									{
										hourSdg12 = ct.getHourBetween(ddep12,aarr12);
										sidingHours += hourSdg12;
									}
									if(service12.trim().equals("Shunting"))
									{
										hourShtg12 = ct.getHourBetween(ddep12,aarr12);
										shuntingHours += hourShtg12;
									}
									System.out.println(" aarr11 : " + aarr11 + " ** aarr12 : " + aarr12  + " hours12 : " + hour12);
									workingHours = workingHours + hour12;
								}
								arrivalDate = aarr12;
								//          signOfDate = retSignof(service,aarr12);
//								//         System.out.println("signOfDate : " + signOfDate + " : " + blnBaseStation);
								System.out.println("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
								label12.setText(new Integer(dist12).toString()+"/"+hour12);
								jbKms.setText("Total Kms : " + dist + " & Pilot Kms : " + distPilot+ " Hours Worked : " + workingHours);
								blnBase = blnBaseStation;
								blnFirst12 = false;
//								returnMileage(service12, dist12, hour12);
							}
							catch(Exception e)
							{
			//					e.printStackTrace();
							}
						}
					}
					catch(Exception exx)
					{
					}
				}
				System.out.println("************************** END ARR12  ********************************");
			}			
		});
/*		jcbFrom1.addFocusListener(new FocusAdapter()	
		{
			public void focusLost(FocusEvent ae)
			{
				if (blnGuard)
				{
					if(!signoflast.equals("null"))
					{
						if(!cmpt.getGreater(guardDate, signoflast))
						{
							JOptionPane.showMessageDialog(null,"Guard Last signed OFF at : " + signoflast+
								". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							jcbFrom1.requestFocus();
							return;
						}
					}
				}
				if (blnDriver)
				{
					if(!signoflast.equals("null"))
					{
						if(!cmpt.getGreater(driverDate, signoflast))
						{
							JOptionPane.showMessageDialog(null,"Driver Last signed OFF at : " + signoflast+
								". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							jcbFrom1.requestFocus();
							return;
						}
					}
				}
				if (blnAssistant)
				{
					if(!signoflast.equals("null"))
					{						
						if(!cmpt.getGreater(assistantDate, signoflast))
						{
							JOptionPane.showMessageDialog(null,"Assistant Last signed OFF at : " + signoflast+
								". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
							jcbFrom1.requestFocus();
							return;
						}
					}
				}
			}
		});
*/
		jcbFrom1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if (blnClear)
				{
					try
					{
						if(blnDriver)
							driverNamePfNo = ncbDriver.getName().trim();
						if(blnAssistant)
							assistantNamePfNo = ncbAssistant.getName().trim();
						if(blnGuard)
							guardNamePfNo = ncbGuard.getName().trim();
					}
					catch(Exception ex2)
					{
						ex2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Select Proper Crew Names"
									,"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
								return;
					}
					if(blnDriver)
					{
						int i = driverNamePfNo.length();
						driverName =	driverNamePfNo.substring(0,i-9).trim();
						driverPfNo = driverNamePfNo.substring(i-8);
					}
					if(blnAssistant)	
					{
						int i = assistantNamePfNo.length();
						assistantName =	assistantNamePfNo.substring(0,i-9).trim();
						assistantPfNo = assistantNamePfNo.substring(i-8);
					}
					if(blnGuard)	
					{
						int i = guardNamePfNo.length();
						guardName = guardNamePfNo.substring(0,i-9).trim();
						guardPfNo = guardNamePfNo.substring(i-8);
					}
					if(blnDriver)
					{
						driverDate1=dpD.getUpdateDate();
						driverHour=hpD.getUpdateHour();
						driverMinute=mpD.getUpdateMinute();
						driverDate = cdmf.getChangedFormat(driverDate1,driverHour, driverMinute);
					}
					if(blnGuard)
					{
						guardDate1=dpG.getUpdateDate();
						guardHour=hpG.getUpdateHour();
						guardMinute=mpG.getUpdateMinute();
						guardDate = cdmf.getChangedFormat(guardDate1,guardHour, guardMinute);
					}
					if(blnAssistant)
					{
						assistantDate1=dpA.getUpdateDate();
						assistantHour=hpA.getUpdateHour();
						assistantMinute=mpA.getUpdateMinute();
						assistantDate = cdmf.getChangedFormat(assistantDate1, assistantHour, assistantMinute);
					}
					inArrivalDate=dpArrl.getUpdateDate();
					inArrivalHour=hpArrl.getUpdateHour();
					inArrivalMinute=mpArrl.getUpdateMinute();
					inArrivalDate = cdmf.getChangedFormat(inArrivalDate,inArrivalHour, inArrivalMinute);
					service = (String) jcbService.getSelectedItem();
					service = service.trim();
					from1 = (String) jcbFrom1.getSelectedItem();
					blnContinuous = jcContinuous.isSelected();
					System.out.println("CONTI : " + blnContinuous );
					if(service.equals("HigherGrade1")||service.equals("HigherGrade2"))
					{
						System.out.println("CONTI : " + blnContinuous + " &&& Service : " + service1);
					}
					else
					{
						if(service1.equals("Shunting") || service1.equals("LR")||service1.equals("Pilot"))
						{
						}
						else
						{
							if(blnDriver)
							{
								vector.removeAllElements();
								vector.trimToSize();		
								query  = "select ctrno from signoffdriver where pfnodriver ='"+driverPfNo+
										"' and CasualtyOver=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
								System.out.println(query );
								vector = snv.getStationNameList("",query );
								if(vector.size()>0)
								{
									JOptionPane.showMessageDialog(null,"Service Mentioned for DRIVER is not correct",
										"Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
							if(blnGuard)
							{
								vector.removeAllElements();
								vector.trimToSize();		
								query = "select ctrno from signoffguard where pfnoguard ='"+guardPfNo+
										"' and CasualtyOver=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
								System.out.println(query );
								vector = snv.getStationNameList("",query );
								if(vector.size()>0)
								{
									JOptionPane.showMessageDialog(null,"Service Mentioned for GUARD is not correct","Click OK to Continue",
																							JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
							if(blnAssistant)
							{
								vector.removeAllElements();
								vector.trimToSize();
								query = "select ctrno from signoffassistant where pfnoassistant ='"+
											assistantPfNo+"' and CasualtyOver=0 and  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1))='COACHING'";
								vector = snv.getStationNameList("",query );
								if(vector.size()>0)
								{
									JOptionPane.showMessageDialog(null,"Service Mentioned for ASSISTANT is not correct","Click OK to Continue",
														JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
						}
					}
					try
					{
						if(service.equals("HigherGrade1") || service.equals("HigherGrade2"))
//					||	service1.equals("Shunting") || service1.equals("LR"))
						{
						}
						else
						{
							System.out.println(service);					
							iContinuous = 0;
							if(from1.substring(from1.length()-1).equals("."))//str.substring(str.length()-1)
							{
								from1 = from1.substring(0,from1.length()-1);//str.substring(0,str.length()-1)
							}
							if(blnDriver)
							{
								lastSignOf = returnLastSignOf("Driver", driverPfNo);
								if(!lastSignOf.equals(from1) && !lastSignOf.equals("null"))
								{
									JOptionPane.showMessageDialog(null,"Driver Last signed OFF at : " + lastSignOf+
										". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
									jcbFrom1.requestFocus();

								}
								
								select = "select (TO_char(date1,'dd/mm/yyyy hh24:mi')),continuous,"+
											" nvl(TO_char(continuedate,'mm/dd/yyyy hh24:mi'),'') from signondriver "+
										" where PfNodriver= '"+driverPfNo+"' and date1= "+
										"(select max(date1) from signondriver where PfNodriver= '"+driverPfNo+"' )";
								System.out.println("D : " + select);
								vector.removeAllElements();
								vector.trimToSize();
								vector =		qtm.setQuery("",select);
								ddate =((String[])vector.elementAt(0))[0];
								iContinuous = new Integer(((String[])vector.elementAt(0))[1]).intValue();
								continuedate =((String[])vector.elementAt(0))[2];
								if(iContinuous == 0)
								{
	//										if(depot.equals(ncbStationFrom.getName().trim()))
									if(depot.equals((String) jcbFrom1.getSelectedItem()))
									{
										System.out.println(depot + " : " + (String) jcbFrom1.getSelectedItem());
										dpD.setDate(ddate.substring(0,10));
										hpD.setHour(new Integer(ddate.substring(11,13)).intValue());
										mpD.setMinute(new Integer(ddate.substring(14)).intValue());
									}
									else
									{
										System.out.println("last signof : " + signoflast + " : "+ driverDate);
										if(!signoflast.equals("null"))
										{
											if(cmpt.getGreaterDate(driverDate, signoflast))
											{
												JOptionPane.showMessageDialog(null,"Driver Last signed OFF at : " + signoflast+
													". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
												jcbDep1.requestFocus();
												return;
											}
										}
									}
								}
								else
								{
									ddate1 = 	continuedate;
									System.out.println("HAHAHA : " + ddate1);
									continuedate="";
								}
							}			
							if(blnAssistant)
							{
								lastSignOf = returnLastSignOf("Assistant", assistantPfNo);
								if(!lastSignOf.equals(from1) && !lastSignOf.equals("null"))
								{
									JOptionPane.showMessageDialog(null,"Assistant Driver Last signed OFF at : " + lastSignOf+
										". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
									jcbFrom1.requestFocus();
									return;
								}
								
								select = "select (TO_char(date1,'dd/mm/yyyy hh24:mi')), continuous,"+
									" nvl(TO_char(continuedate,'mm/dd/yyyy hh24:mi'),'') from signonassistant "+
										" where PfNoAssistant= '"+assistantPfNo+"' and date1= "+
										"(select max(date1) from signonassistant where PfNoAssistant= '"+assistantPfNo+"' )";
								System.out.println("A : " + select);
								vector.removeAllElements();
								vector.trimToSize();
								vector = qtm.setQuery("",select);
								adate =((String[])vector.elementAt(0))[0];
								iContinuous = new Integer(((String[])vector.elementAt(0))[1]).intValue();
								continuedate =((String[])vector.elementAt(0))[2];
								if(iContinuous == 0)
								{
									if(depot.equals((String) jcbFrom1.getSelectedItem()))
									{
										dpA.setDate(adate.substring(0,10));
										hpA.setHour(new Integer(adate.substring(11,13)).intValue());
										mpA.setMinute(new Integer(adate.substring(14)).intValue());
									}
									else
									{
										System.out.println("last signof Asst : " + signoflast);
										if(!signoflast.equals("null"))
										{
											if(cmpt.getGreaterDate(assistantDate, signoflast))
											{
												JOptionPane.showMessageDialog(null,"Assistant Driver Last signed OFF at : " + signoflast+
													". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
												jcbDep1.requestFocus();
												return;
											}
										}
									}
								}
								else
								{
									adate1 = continuedate;
									System.out.println("HAHAHA : " + adate1);
									continuedate="";
								}
							}

							if(blnGuard)
							{
								lastSignOf = returnLastSignOf("Guard", guardPfNo);
								if(!lastSignOf.equals(from1) && !lastSignOf.equals("null"))
								{
									JOptionPane.showMessageDialog(null,"Guard Last signed OFF at : " + lastSignOf+
										". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
									jcbFrom1.requestFocus();
									return;
								}
								select = "select TO_char(date1,'dd/mm/yyyy hh24:mi'),continuous,"+
												" nvl(TO_char(continuedate,'mm/dd/yyyy hh24:mi'),'') from signonguard "+
										" where pfnoguard='"+guardPfNo+"' and date1= "+
										"(select max(date1) from signonguard where pfnoguard='"+guardPfNo+"' )";
								
								vector.removeAllElements();
								vector.trimToSize();
								vector =		qtm.setQuery("",select);
								gdate =((String[])vector.elementAt(0))[0];
								iContinuous = new Integer(((String[])vector.elementAt(0))[1]).intValue();
								continuedate =((String[])vector.elementAt(0))[2];
								if(iContinuous == 0)
								{
									if(depot.equals((String) jcbFrom1.getSelectedItem()))
									{
										dpG.setDate(gdate.substring(0,10));
										hpG.setHour(new Integer(gdate.substring(11,13)).intValue());
										mpG.setMinute(new Integer(gdate.substring(14)).intValue());
									}
									else
									{
										if(!signoflast.equals("null"))
										{
											guardDate1=dpG.getUpdateDate();
											guardHour=hpG.getUpdateHour();
											guardMinute=mpG.getUpdateMinute();
											guardDate = cdmf.getChangedFormat(guardDate1,guardHour, guardMinute);
											System.out.println("HAHA : " + guardDate + " &&&& " + signoflast);
											if(cmpt.getGreaterDate(guardDate, signoflast))
											{
												JOptionPane.showMessageDialog(null,"Guard Last signed OFF at : " + signoflast+
													". Please verify it","Click OK to Continue",	JOptionPane.ERROR_MESSAGE);
												jcbDep1.requestFocus();
												return;
											}
										}
									}
								}
								else
								{
									gdate1 = 	continuedate;
									continuedate="";
								}
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		jbShow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)    
			{		
				clearEntries();
				refreshComboBox();
				radioname = group.getSelection().getActionCommand();
				dpA.clearDate();
				hpA.clearHour();
				mpA.clearMinute();
				dpD.clearDate();
				hpD.clearHour();
				mpD.clearMinute();
				dpG.clearDate();
				hpG.clearHour();
				mpG.clearMinute();
				if(radioname.equals(new String("WITHGUARD")))	
				{
					blnDriver = true;
					blnAssistant = true;
					blnGuard = true;
					panelAssistant.setVisible(true);
					panelGuard.setVisible(true);
					panelDriver.setVisible(true);
					jpSignAD.setVisible(true);
					jpSignD.setVisible(true);
					jpSignG.setVisible(true);
					panel5.repaint();
					panelCrew.repaint();
				}
				if(radioname.equals(new String("WITHOUTGUARD")))	
				{
					blnDriver = true;
					blnAssistant = true;
					blnGuard = false;
					panelAssistant.setVisible(true);
					panelGuard.setVisible(false);
					panelDriver.setVisible(true);
					jpSignAD.setVisible(true);
					jpSignD.setVisible(true);
					jpSignG.setVisible(false);
					panel5.repaint();
					panelCrew.repaint();
				}
				if(radioname.equals(new String("DRIVER")))	
				{
					blnDriver = true;
					blnAssistant = false;
					blnGuard = false;
					panelAssistant.setVisible(false);
					panelGuard.setVisible(false);
					panelDriver.setVisible(true);
					jpSignAD.setVisible(false);
					jpSignD.setVisible(true);
					jpSignG.setVisible(false);
					panel5.repaint();
					panelCrew.repaint();
				}
				if(radioname.equals(new String("ASSISTANT")))	
				{
					blnDriver = false;
					blnAssistant = true;
					blnGuard = false;
					panelAssistant.setVisible(true);
					panelGuard.setVisible(false);
					panelDriver.setVisible(false);
					jpSignAD.setVisible(true);
					jpSignD.setVisible(false);
					jpSignG.setVisible(false);
					panel5.repaint();
					panelCrew.repaint();
				}
				if(radioname.equals(new String("GUARD")))	
				{
					blnDriver = false;
					blnAssistant = false;
					blnGuard = true;
					panelAssistant.setVisible(false);
					panelGuard.setVisible(true);
					panelDriver.setVisible(false);
					jpSignAD.setVisible(false);
					jpSignD.setVisible(false);
					jpSignG.setVisible(true);
					panel5.repaint();
					panelCrew.repaint();
				}
				blnFirst1 = true;
				blnFirst2 = true;
				blnFirst3 = true;
				blnFirst4 = true;
				blnFirst5 = true;
				blnFirst6 = true;
				blnFirst7 = true;
				blnFirst8 = true;
				blnFirst9 = true;
				blnFirst10 = true;
				blnFirst11 = true;
				blnFirst12 = true;
				blnClear = true;

				pilotFrom = "null";
				pilotTo = "null";
				pilotFrom1 = "null";
				pilotTo1 = "null";
				signoflast = "null"; lastSignOf = "";
				driverDate = ""; driverDate1 = ""; assistantDate = ""; assistantDate1 = "";
				guardDate = ""; guardDate1 = "";
				dist = 0; distPilot = 0; 
				workingHours =0; hour1=0; hour2=0; hour3=0; hour4=0; hour5=0; hour6=0; hour7=0; hour8=0;
				hour9=0; hour10=0;	hour11=0; hour12=0;	hourSdg1=0; hourSdg2=0; hourSdg3=0; hourSdg4=0;
				hourSdg5=0; hourSdg6=0; hourSdg7=0; hourSdg8=0; hourSdg9=0;	hourSdg10=0; hourSdg11=0; 
				hourSdg12=0; sidingHours=0;	hourShtg1=0; hourShtg2=0; hourShtg3=0; hourShtg4=0; hourShtg5=0;
				hourShtg6=0; hourShtg7=0; hourShtg8=0; hourShtg9=0; hourShtg10=0; hourShtg11=0; hourShtg12=0;
				shuntingHours=0; hourPilot1=0; hourPilot2=0; hourPilot3=0; hourPilot4=0; hourPilot5=0; 
				hourPilot6=0; hourPilot7=0;	hourPilot8=0; hourPilot9=0; hourPilot10=0; hourPilot11=0;
				hourPilot12=0; pilotHours=0; 

				ddep1 =""; aarr1=""; ddep2 =""; aarr2=""; ddep3 =""; aarr3=""; ddep4 =""; aarr4=""; ddep5 =""; 
				aarr5=""; ddep6 =""; aarr6="";	ddep7 =""; aarr7=""; ddep8 =""; aarr8=""; ddep9 =""; aarr9=""; 
				ddep10 =""; aarr10=""; ddep11 =""; aarr11=""; ddep12 =""; aarr12="";

				ctrno="";trainno="";service="";engineno="";
				engine1=null;engine2=null;engine3=null;engine4=null;engine5=null;engine6=null;engine7=null;engine8=null; engine9=null;engine10=null;engine11=null;engine12=null;
				train1=null;train2=null;train3=null;train4=null;train5=null;train6=null;train7=null;train8=null; train9=null;train10=null;train11=null;train12=null;
				service1=null;service2=null;service3=null;service4=null;service5=null;service6=null;service7=null;service8=null; service9=null;service10=null;service11=null;service12=null;
				from1=null;from2=null;from3=null;from4=null;from5=null;from6=null;from7=null;from8=null;from9=null;from10=null;from11=null;from12=null;
				to1=null;to2=null;to3=null;to4=null;to5=null;to6=null; to7=null; to8=null;to9=null;to10=null;to11=null; to12=null;
				siding1=null;siding2=null;siding3=null;siding5=null;siding4=null;siding6=null;siding7=null;siding8=null;siding9=null;siding10=null;siding11=null;siding12=null; 
				strInsert="";querySiding="";strWeight=""; ctrs=""; ctr=""; lock="";
				dep1="";dep2="";dep3="";dep4="";dep5="";dep6="";dep7="";dep8="";dep9="";dep10=""; dep11=""; dep12="";
				arr1="";arr2="";arr3="";arr4="";arr5="";arr6="";arr7="";arr8="";arr9="";arr10="";arr11="";arr12="";
				jbVerify.setEnabled(true);
				throughgoodskm=0; lekm=0; ballastkm=0; cranesplkm=0;breakdownkm=0; medicalreliefkm=0; shuntingkm=0;
				coalpilotskm=0; lelakm=0; enggkm = 0; materialtrainkm=0; pilotkm=0; enggsplkm=0; shuttlingkm = 0;
				hg1km=0; hg2km=0;  sidingkm=0;yardreliefkm=0; pilotsectionkm=0; lrkm=0; 
				srtrainkm=0;
				mileage = 0; amileage = 0; dmileage = 0; gmileage = 0;
				throughgoodshrs=0; lehrs=0; ballasthrs=0; cranesplhrs=0;breakdownhrs=0; medicalreliefhrs=0; shuntinghrs=0;
				coalpilotshrs=0; lelahrs=0; materialtrainhrs=0; pilothrs=0; enggsplhrs=0; shuttlinghrs = 0;
				hg1hrs=0; hg2hrs=0;  sidinghrs=0;yardreliefhrs=0; pilotsectionhrs=0; lrhrs=0; 
				srtrainhrs=0;

				relief = "01/01/1999 00:00";
				relief1 = "01/01/1999 00:00";
				relief2 = "01/01/1999 00:00";

				select = "Select depot from depot";
				
				vector =	snv.getStationNameList("",select);
				depot = (String)(vector.elementAt(0));
			}
		});

		int v= ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

		JScrollPane scrollpane = new JScrollPane(panel1,v,h);
		scrollpane = new JScrollPane(panel1,v,h);
		scrollpane.setPreferredSize(new Dimension(775,510));
		JPanel sop = new JPanel();
		sop.setBackground(new Color(0,128,128));
		CompoundBorder sopBorder=new CompoundBorder(new EtchedBorder(),new BevelBorder(BevelBorder.RAISED));
		sop.setBorder(sopBorder);
		sop.add(scrollpane);
		return sop;
	}
	
	public void clearEntries()
	{
		try
		{
			pilotFrom = "null";
			pilotTo = "null";
			pilotFrom1 = "null";
			pilotTo1 = "null";
			pilotFrom2 = "null";
			pilotTo2 = "null";
			blnClear = false; blnOSD = false; blnOSA = false; blnOSG = false; blnLRS = false; lrsection="";
			blnCtrD = false; blnCtrA = false; blnCtrG = false; blnSpecial = false; blnLRPilot = false;
			dist = 0; distPilot = 0;
			workingHours =0; hour1=0; hour2=0; hour3=0; hour4=0; hour5=0; hour6=0; hour7=0; hour8=0;
			hour9=0; hour10=0;	hour11=0; hour12=0;	hourSdg1=0; hourSdg2=0; hourSdg3=0; hourSdg4=0;
			hourSdg5=0; hourSdg6=0; hourSdg7=0; hourSdg8=0; hourSdg9=0;	hourSdg10=0; hourSdg11=0; 
			hourSdg12=0; sidingHours=0;	hourShtg1=0; hourShtg2=0; hourShtg3=0; hourShtg4=0; hourShtg5=0;
			hourShtg6=0; hourShtg7=0; hourShtg8=0; hourShtg9=0; hourShtg10=0; hourShtg11=0; hourShtg12=0;
			shuntingHours=0; hourPilot1=0; hourPilot2=0; hourPilot3=0; hourPilot4=0; hourPilot5=0; 
			hourPilot6=0; hourPilot7=0;	hourPilot8=0; hourPilot9=0; hourPilot10=0; hourPilot11=0;
			hourPilot12=0; pilotHours=0; 
			hrestd = 0; hresta = 0;
			ddep1 =""; aarr1=""; ddep2 =""; aarr2=""; ddep3 =""; aarr3=""; ddep4 =""; aarr4=""; ddep5 =""; 
			aarr5=""; ddep6 =""; aarr6="";	ddep7 =""; aarr7=""; ddep8 =""; aarr8=""; ddep9 =""; aarr9=""; 
			ddep10 =""; aarr10=""; ddep11 =""; aarr11=""; ddep12 =""; aarr12="";

			ctrno="";trainno="";service="";engineno="";
			engine1=null;engine2=null;engine3=null;engine4=null;engine5=null;engine6=null;engine7=null;engine8=null; engine9=null;engine10=null;engine11=null;engine12=null;
			train1=null;train2=null;train3=null;train4=null;train5=null;train6=null;train7=null;train8=null; train9=null;train10=null;train11=null;train12=null;
			service1=null;service2=null;service3=null;service4=null;service5=null;service6=null;service7=null;service8=null; service9=null;service10=null;service11=null;service12=null;
			from1=null;from2=null;from3=null;from4=null;from5=null;from6=null;from7=null;from8=null;from9=null;from10=null;from11=null;from12=null;
			to1=null;to2=null;to3=null;to4=null;to5=null;to6=null; to7=null; to8=null;to9=null;to10=null;to11=null; to12=null;
			siding1=null;siding2=null;siding3=null;siding5=null;siding4=null;siding6=null;siding7=null;siding8=null;siding9=null;siding10=null;siding11=null;siding12=null; 
			strInsert="";querySiding="";strWeight=""; ctrs=""; ctr=""; lock="";
			dep1="";dep2="";dep3="";dep4="";dep5="";dep6="";dep7="";dep8="";dep9="";dep10=""; dep11=""; dep12="";
			arr1="";arr2="";arr3="";arr4="";arr5="";arr6="";arr7="";arr8="";arr9="";arr10="";arr11="";arr12="";

			relief = "01/01/1999 00:00";
			relief1 = "01/01/1999 00:00";
			relief2 = "01/01/1999 00:00";

			ncbDep1.clearAll();			ncbArr1.clearAll();
			ncbDep2.clearAll();			ncbArr2.clearAll();					
			ncbDep3.clearAll();		ncbArr3.clearAll();
			ncbDep4.clearAll();			ncbArr4.clearAll();
			ncbDep5.clearAll();			ncbArr5.clearAll();					
			ncbDep6.clearAll();		ncbArr6.clearAll();
			ncbDep7.clearAll();			ncbArr7.clearAll();
			ncbDep8.clearAll();			ncbArr8.clearAll();					
			ncbDep9.clearAll();		ncbArr9.clearAll();
			ncbDep10.clearAll();			ncbArr10.clearAll();
			ncbDep11.clearAll();		ncbArr11.clearAll();			ncbDep12.clearAll();			ncbArr12.clearAll();
			ncbSiding.clearAll();
			jcbDriverName.setSelectedIndex(0);			jcbAssistantName.setSelectedIndex(0);
			jcbGuardName.setSelectedIndex(0);
			ncbDriver.clearAll();										ncbAssistant.clearAll();
			ncbGuard.clearAll();
			throughgoodskm=0; lekm=0; ballastkm=0; cranesplkm=0;breakdownkm=0; medicalreliefkm=0; shuntingkm=0;
			coalpilotskm=0; lelakm=0; enggkm = 0; materialtrainkm=0; pilotkm=0; enggsplkm=0;shuttlingkm=0;
			hg1km=0; hg2km=0;  sidingkm=0;yardreliefkm=0; pilotsectionkm=0; lrkm=0; 
			srtrainkm=0;
			mileage = 0; amileage = 0; dmileage = 0; gmileage = 0;
			throughgoodshrs=0; lehrs=0; ballasthrs=0; cranesplhrs=0;breakdownhrs=0; medicalreliefhrs=0; shuntinghrs=0;
			coalpilotshrs=0; lelahrs=0; materialtrainhrs=0; pilothrs=0; enggsplhrs=0;shuttlinghrs = 0;
			hg1hrs=0; hg2hrs=0;  sidinghrs=0;yardreliefhrs=0; pilotsectionhrs=0; lrhrs=0; 
			srtrainhrs=0;
		try
		{
			jcbTrainno1.setSelectedIndex(0);
			jcbService1.setSelectedIndex(0);
			jcbSection1.setSelectedIndex(0);
			jcbFrom1.setSelectedIndex(0);
			jcbTo1.setSelectedIndex(0);
			jftfLoad1.setValue("00+0/000/0000");
			jftfLoco1.setValue("00000+00000+00000+00000+00000");
			label1.setText("0");
			jcbSiding1.setSelectedIndex(0);
			
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno2.setSelectedIndex(0);
			jcbService2.setSelectedIndex(0);
			jcbSection2.setSelectedIndex(0);
			jcbFrom2.setSelectedIndex(0);
			jcbTo2.setSelectedIndex(0);
			jftfLoad2.setValue("00+0/000/0000");
			jftfLoco2.setValue("00000+00000+00000+00000+00000");
			label2.setText("0");
			jcbSiding2.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno3.setSelectedIndex(0);
			jcbService3.setSelectedIndex(0);
			jcbSection3.setSelectedIndex(0);
			jcbFrom3.setSelectedIndex(0);
			jcbTo3.setSelectedIndex(0);
			jftfLoad3.setValue("00+0/000/0000");
			jftfLoco3.setValue("00000+00000+00000+00000+00000");
			label3.setText("0");
			jcbSiding3.setSelectedIndex(0);
			
		}
		catch(Exception e)
		{
//			System.out.println("33333333333333333");
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno4.setSelectedIndex(0);
			jcbService4.setSelectedIndex(0);
			jcbSection4.setSelectedIndex(0);
			jcbFrom4.setSelectedIndex(0);
			jcbTo4.setSelectedIndex(0);
			jftfLoad4.setValue("00+0/000/0000");
			jftfLoco4.setValue("00000+00000+00000+00000+00000");
			label4.setText("0");
			
			jcbSiding4.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno5.setSelectedIndex(0);
			jcbService5.setSelectedIndex(0);
			jcbSection5.setSelectedIndex(0);
			jcbFrom5.setSelectedIndex(0);
			jcbTo5.setSelectedIndex(0);
			jftfLoad5.setValue("00+0/000/0000");
			jftfLoco5.setValue("00000+00000+00000+00000+00000");
			label5.setText("0");
			jcbSiding5.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno6.setSelectedIndex(0);
			jcbService6.setSelectedIndex(0);
			jcbSection6.setSelectedIndex(0);
			jcbFrom6.setSelectedIndex(0);
			jcbTo6.setSelectedIndex(0);
			jftfLoad6.setValue("00+0/000/0000");
			jftfLoco6.setValue("00000+00000+00000+00000+00000");
			label6.setText("0");
			jcbSiding6.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}

		try
		{
			jcbTrainno7.setSelectedIndex(0);
			jcbService7.setSelectedIndex(0);
			jcbSection7.setSelectedIndex(0);
			jcbFrom7.setSelectedIndex(0);
			jcbTo7.setSelectedIndex(0);
			jftfLoad7.setValue("00+0/000/0000");
			jftfLoco7.setValue("00000+00000+00000+00000+00000");
			label7.setText("0");
			jcbSiding7.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno8.setSelectedIndex(0);
			jcbService8.setSelectedIndex(0);
			jcbSection8.setSelectedIndex(0);
			jcbFrom8.setSelectedIndex(0);
			jcbTo8.setSelectedIndex(0);
			jftfLoad8.setValue("00+0/000/0000");
			jftfLoco8.setValue("00000+00000+00000+00000+00000");
			label8.setText("0");
			jcbSiding8.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno9.setSelectedIndex(0);
			jcbService9.setSelectedIndex(0);
			jcbSection9.setSelectedIndex(0);
			jcbFrom9.setSelectedIndex(0);
			jcbTo9.setSelectedIndex(0);
			jftfLoad9.setValue("00+0/000/0000");
			jftfLoco9.setValue("00000+00000+00000+00000+00000");
			label9.setText("0");
			jcbSiding9.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno10.setSelectedIndex(0);
			jcbService10.setSelectedIndex(0);
			jcbSection10.setSelectedIndex(0);
			jcbFrom10.setSelectedIndex(0);
			jcbTo10.setSelectedIndex(0);
			jftfLoad10.setValue("00+0/000/0000");
			jftfLoco10.setValue("00000+00000+00000+00000+00000");
			label10.setText("0");
			jcbSiding10.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno11.setSelectedIndex(0);
			jcbService11.setSelectedIndex(0);
			jcbSection11.setSelectedIndex(0);
			jcbFrom11.setSelectedIndex(0);
			jcbTo11.setSelectedIndex(0);
			jftfLoad11.setValue("00+0/000/0000");
			jftfLoco11.setValue("00000+00000+00000+00000+00000");
			label11.setText("0");
			jcbSiding11.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		try
		{
			jcbTrainno12.setSelectedIndex(0);
			jcbService12.setSelectedIndex(0);
			jcbSection12.setSelectedIndex(0);
			jcbFrom12.setSelectedIndex(0);
			jcbTo12.setSelectedIndex(0);
			jftfLoad12.setValue("00+0/000/0000");
			jftfLoco12.setValue("00000+00000+00000+00000+00000");
			label12.setText("0");
			jcbSiding12.setSelectedIndex(0);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
		}
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}try	
		{
			jbKms.setText("Total Kms : 0  & Pilot Kms : 0 & Hours Worked : 0");
			jbSubmit.setEnabled(false);
			String currentDate = pt.getTodayTime();
			String mon= currentDate.substring(0,2);
			String day=currentDate.substring(3,5);
			String currentDate1 = mon+day;
			jtfCtrNo.setText(currentDate1);//.substring(0,4)
			jcHandicap.setSelected(false);
			jtfShunting.setText("0");
			jtfSDA.setText("0");
			dpD.clearDate();
			dpA.clearDate();
			hpD.clearHour();
			hpA.clearHour();
			mpD.clearMinute();
			mpA.clearMinute();
			dpG.clearDate();
			hpG.clearHour();
			mpG.clearMinute();
			dpArrl.clearDate();
			hpArrl.clearHour();
			mpArrl.clearMinute();
			jbVerify.setText("Verify Data");
			jcContinuous.setSelected(false);
			jcNRRA.setSelected(false);
			jcNCA.setSelected(false);
//			jcVia.setSelected(false);
			jtfPTPhone.setText("");
			jtfVHF.setText("");
			noloco="";
			dpSof.clearDate();
			hpSof.clearHour();
			mpSof.clearMinute();
			jtfPTPhone.setText("");
			jtfVHF.setText("");
			jtfDetention.setText("0");
			xhours=0;
			jcbService.setSelectedIndex(0);					
		}
		catch (Exception clearException)
		{
			System.out.println("clear exception in Sign Off");
			clearException.printStackTrace();
		}
	}
	public static void main(String a[])
	{
		SignOfPanel sp = new SignOfPanel();
		JFrame frame = new JFrame("Crew Booking");
	// add everything  to final frame
		frame.getContentPane().setLayout(new BorderLayout());

		frame.addWindowListener(new BasicWindowMonitor());
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(sp.getSignOfPanel(),BorderLayout.CENTER);
		frame.setSize(810,580);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	void refreshComboBox()	
	{
		panelDriver.setVisible(false);
		panelDriver.remove(jcbDriverName);
		query = "Select NameDriver, PfNoDriver from Curronlined order by nameDriver";
		vectorDriver.removeAllElements();
		vectorDriver =cnv.getCrewNameList(url,query);
		jcbDriverName = ncbDriver.namePanel(vectorDriver);
		query = "Select NameDriver,PfNoDriver from Casualtyd where  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1)) ='COACHING' and casualtyover=0";
		vectorDriverCoaching =cnv.getCrewNameList(url,query );
		vectorDriver.addAll(vectorDriverCoaching);
		jcbDriverName = ncbDriver.namePanel(vectorDriver);
		jcbDriverName.setPreferredSize(dim7);
		jcbDriverName.setFont(f1);
		jcbDriverName.setSelectedIndex(0);
		
		panelGuard.setVisible(false);
		panelGuard.remove(jcbGuardName);
		query = "Select NameGuard, PfNoGuard from CurronlineG order by nameGuard";		
		vectorGuard.removeAllElements();
		vectorGuard =cnv.getCrewNameList(url,query);
		jcbGuardName = ncbGuard.namePanel(vectorGuard);
		query = "Select NameGuard,PfNoGuard from CasualtyG where  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1)) ='COACHING' and casualtyover=0";
		vectorGuardCoaching =cnv.getCrewNameList(url,query );
		vectorGuard.addAll(vectorGuardCoaching);
		jcbGuardName = ncbGuard.namePanel(vectorGuard);
		jcbGuardName.setPreferredSize(dim7);
		jcbGuardName.setFont(f1);
		jcbGuardName.setSelectedIndex(0);

		panelAssistant.setVisible(false);
		panelAssistant.remove(jcbAssistantName);
		query = "Select NameAssistant, PfNoAssistant from Curronlinead order by nameAssistant";		
		vectorAssistant =	cnv.getCrewNameList(url,query);
		jcbAssistantName = ncbAssistant.namePanel(vectorAssistant);
		jcbAssistantName.setPreferredSize(dim6);
		query = "Select NameAssistant,PfNoAssistant from Casualtyad "+
		" where  substr(casualty,0,DECODE(instr(casualty,'/',3),0,LENGTH(CASUALTY),instr(casualty,'/',3)-1)) ='COACHING' and casualtyover=0";
		vectorAssistantCoaching =	cnv.getCrewNameList(url,query );
		vectorAssistant.addAll(vectorAssistantCoaching);
		jcbAssistantName = ncbAssistant.namePanel(vectorAssistant);
		jcbAssistantName.setPreferredSize(dim7);
		jcbAssistantName.setFont(f1);
		jcbAssistantName.setSelectedIndex(0);

		panelDriver.add(jcbDriverName);
		panelDriver.setVisible(true);
		panelGuard.add(jcbGuardName);
		panelGuard.setVisible(true);
		panelAssistant.add(jcbAssistantName);
		panelAssistant.setVisible(true);
		panel1.repaint();
	}
	public String retSignof(String service, String xdate)
	{
		System.out.println("XXXXXXXXXXXXXXXX : " + service + " YYYYYYYYYYYYYYYY : " + xdate);
		sdate = "";
		shour = "";
		sminute = "";
		month = "";
		day = "";
		smin = 0;
		sh = 0;
		xday = 0;
		sdate = xdate.substring(0,10);
		shour = xdate.substring(11,13);
		sminute = xdate.substring(14);
		month = sdate.substring(0,2);
		day = sdate.substring(3,5);
		if(service.trim().equals("Pilot"))
		{
			smin = new Integer(sminute).intValue();
		}
		else if(service.trim().equals("YardRelief"))
		{
			smin = new Integer(sminute).intValue();
		}
		else if(service.trim().equals("Shunting"))
		{
			smin = new Integer(sminute).intValue();
		}
		else
		{
			smin = new Integer(sminute).intValue()+15;
		}
		sh = new Integer(shour).intValue();
		xday = 0;
		if(smin >= 60)
		{
			smin = smin - 60;
			sh++;
			if(sh >= 24)
			{
				sh = sh-24;
				xday = new Integer(day).intValue() + 1;
				sdate = cdmf.getChangedFormat1(sdate,""+sh,""+smin);
				sdate= at.getHourAdd(sdate,24);
			}
			else
			{
				sdate = cdmf.getChangedFormat1(sdate,""+sh,""+smin);
			}
		}
		else
		{
			sdate = cdmf.getChangedFormat1(sdate,""+sh,""+smin);
		}
		return sdate;
	}
	public String returnLastSignOf(String who,String pfNo)
	{
		if(who.equals("Driver"))
		{
			query  = "select StationTo,StationTo2,StationTo3,StationTo4,StationTo5,StationTo6, StationTo7,  "+
								" stationto8, stationto9, stationto10, stationto11, stationto12, ctrno,  "+	
								" nvl(to_char(date1,'mm/dd/yyyy hh24:mi'),'null') "+
								"  from signoffdriver where date1 = (select max(date1) from signoffdriver "+
								" where pfnodriver = '"+pfNo+	"' and casualty='WKG') and date2="+
									" (select max(date2) from signoffdriver where pfnodriver = '"+pfNo+
									"' and Casualty='WKG')  and pfnodriver = '"+pfNo+"' and Casualty='WKG'";
		}
		if(who.equals("Assistant"))
		{
			query  = "select StationTo,StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,StationTo7, "+
								" stationto8, stationto9, stationto10, stationto11, stationto12, ctrno,   "+	
								" nvl(to_char(date1,'mm/dd/yyyy hh24:mi'),'null') "+
								" from signoffAssistant where date1 = (select max(date1) from signoffAssistant "+
								" where pfnoAssistant = '"+pfNo+"' and Casualty='WKG') and date2="+
									" (select max(date2) from signoffassistant where pfnoassistant = '"+pfNo+
									"' and Casualty='WKG') and pfnoassistant = '"+pfNo+"' and Casualty='WKG'";
		}
		if(who.equals("Guard"))
		{
			query  = "select StationTo,StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,StationTo7, "+
								" stationto8, stationto9, stationto10, stationto11, stationto12, ctrno,   "+	
								" nvl(to_char(date1,'mm/dd/yyyy hh24:mi'),'null') "+								
								" from signoffguard where date1 = (select max(date1) from signoffguard "+
								" where pfnoguard = '"+pfNo+"' and Casualty='WKG')  and date2="+
									"(select max(date2) from signoffguard where pfnoguard = '"+pfNo+
									"' and Casualty='WKG')  and pfnoguard = '"+pfNo+"' and Casualty='WKG'";
		}

		System.out.println(query );
		vector.removeAllElements();
		vector.trimToSize();
		vector =		qtm.setQuery("",query );
		int columnCount = qtm.getColumnCount();
		int totalRecords = vector.size();
		if(vector.size() > 0)
		{
			try
			{
				strstn1 =((String[])vector.elementAt(0))[0];
				strstn2 =((String[])vector.elementAt(0))[1];
				strstn3 =((String[])vector.elementAt(0))[2];
				strstn4 =((String[])vector.elementAt(0))[3];
				strstn5 =((String[])vector.elementAt(0))[4];
				strstn6 =((String[])vector.elementAt(0))[5];
				strstn7 =((String[])vector.elementAt(0))[6];
				strstn8 =((String[])vector.elementAt(0))[7];
				strstn9 =((String[])vector.elementAt(0))[8];
				strstn10 =((String[])vector.elementAt(0))[9];
				strstn11 =((String[])vector.elementAt(0))[10];
				strstn12 =((String[])vector.elementAt(0))[11];
				String ctrno =((String[])vector.elementAt(0))[12];
				signoflast =((String[])vector.elementAt(0))[13];
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
				if (strstn2.equals("null"))	
				{
					strstn=strstn1;
				}
				else if (strstn3.equals("null"))	
				{
					strstn=strstn2;
				}
				else if (strstn4.equals("null"))	
				{
					strstn=strstn3;
				}
				else if (strstn5.equals("null"))
				{
					strstn=strstn4;
				}
				else if (strstn6.equals("null"))
				{
					strstn=strstn5;
				}
				else if (strstn7.equals("null"))	
				{
					strstn=strstn6;
				}
				else if (strstn8.equals("null"))	
				{
					strstn=strstn7;
				}
				else if (strstn9.equals("null"))	
				{
					strstn=strstn8;
				}
				else if (strstn10.equals("null"))	
				{
					strstn=strstn9;
				}
				else if (strstn11.equals("null"))	
				{
					strstn=strstn10;
				}
				else if (strstn12.equals("null"))	
				{
					strstn=strstn11;
				}
				else
					strstn=strstn12;

				if (strstn.equals(null))
				{
					strstn = "null";
				}
				if(strstn.substring(strstn.length()-1).equals("."))
				{
					strstn = strstn.substring(0,strstn.length()-1);
				}
				return strstn;
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		else
		{
			strstn = "null";
			signoflast = "null";
		}
		return strstn;		
	}
	public double returnNDA(String xdate,String ydate)
	{
		String date1 = xdate.substring(0,10);
		String hour1 = xdate.substring(11,13); 
		String min1 = xdate.substring(14);
		String date2 = ydate.substring(0,10);
		String hour2 = ydate.substring(11,13); 
		String min2 = ydate.substring(14);
		double x=0,y=0, z=0,on=0,of=0,nda = 0;
		double signon = new Double(hour1).doubleValue() + new Double(min1).doubleValue()/60;
		double signof = new Double(hour2).doubleValue() + new Double(min2).doubleValue()/60;

		if(date1.equals(date2))
		{
			if(signon < 6.0 && signof > 6.0)
			{
				 x= 6.0 - signon;
				if(signof==0.0)
					of = 24.0;
				else
					of = signof;
				if(of >22.0)
					y = of -22;
				nda = x + y ;
			}
			if(signon >= 0.0 && signof <= 6.0)
				nda = signof - signon  ;
			if(signon > 6.0 && signof <24.0)
			{
				if(signof >22.0 && signof < 24.0)
					nda = signof  - 22.0;
				else
					nda = 0;
			}
		}
/*		if(!date1.equals(date2))
		{
			if (signon > 6.0 && signon <24.0 )
			{
				x = 24.0 - signon;
				if(x > 2)
					x= 2;
			}
			else if(signon < 6.0 )
				x = 6 - signon + 2;

			if(signof < 6.0)
				y = signof;
			else 
			if(signof >=6 && signof <= 24.0)
					y = 6 ;
			else
				y = 0;
			if(signof >22.0)
			  z = signof - 22.0;
			else
				z = 0;
			nda = x + y + z ;
*/
		if(!date1.equals(date2))
		{
			try
			{
				query = "select to_date('"+date2+"','mm/dd/yyyy hh24:Mi')-"+
				" to_date('"+date1+"','mm/dd/yyyy hh24:Mi') from dual";
				System.out.println(query);
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.1:1521:oracle","javacrew","javacrew");
				conn.setAutoCommit(false);
				stmt2 = con.createStatement(); 
				rs2 = stmt2.executeQuery(query);
				while(rs2.next())
				{
					days =  rs2.getInt(1);
				}
				System.out.println(date1 + " && " + date2 + " && " + days);
				conn.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			if (signon > 6.0 && signon <24.0 )
			{
				x = 24.0 - signon;
				if(x > 2)
					x= 2;
			}
			else if(signon < 6.0 )
				x = 6 - signon + 2;

			if(signof < 6.0)
				y = signof;
			else 
			if(signof >=6 && signof <= 24.0)
					y = 6 ;
			else
				y = 0;
			if(signof >22.0)
				z = signof - 22.0;
			else
				z = 0;
			
			if(days ==1)
			{
				nda = x + y + z ;
				System.out.println(nda + " : " + x + " : " + y + " : " + z);
			}
			else if (days ==2)
			{
				nda = x + y + z  +  8;
				System.out.println(nda + " :  " + x + " : " + y + " : " + z);
			}
			else if (days ==3)
			{
				nda = x + y + z  +  16;
				System.out.println(nda + " :  " + x + " : " + y + " : " + z);
			}
			else if (days ==4)
			{
				nda = x + y + z  +  24;
				System.out.println(nda + " :  " + x + " : " + y + " : " + z);
			}
		}
		return nda;
	}
	public double retHSRest(String who, String pfNo, boolean bool)
	{
		if(who.equals("Driver"))
		{
			select = "select StationTo,StationTo2,StationTo3,StationTo4,StationTo5,StationTo6, StationTo7, "+
								" stationto8, stationto9, stationto10, stationto11, stationto12, "+								
								"to_char(date1,'mm/dd/yyyy hh24:mi')   from signoffdriver where date1 = (select max(date1) from signoffdriver "+
								" where pfnodriver = '"+pfNo+	"' and casualtyover=1) and date2="+
									" (select max(date2) from signoffdriver where pfnodriver = '"+pfNo+
									"' and casualtyover=1)  and pfnodriver = '"+pfNo+"'  and casualtyover=1";
		}
		if(who.equals("Assistant"))
		{
			select = "select StationTo,StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,StationTo7, "+
								" stationto8, stationto9, stationto10, stationto11, stationto12, "+								
								"to_char(date1,'mm/dd/yyyy hh24:mi')  from signoffAssistant where date1 = "+
								" (select max(date1) from signoffAssistant "+
								" where pfnoAssistant = '"+pfNo+"' and casualtyover=1) and date2="+
									" (select max(date2) from signoffassistant where pfnoassistant = '"+pfNo+
									"' and casualtyover=1) and pfnoassistant = '"+pfNo+"' and casualtyover=1";
			
		}
		if(who.equals("Guard"))
		{
			select = "select StationTo,StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,StationTo7, "+
								" stationto8, stationto9, stationto10, stationto11, stationto12, "+								
								"to_char(date1,'mm/dd/yyyy hh24:mi')  from signoffguard where date1 = "+
								"(select max(date1) from signoffguard "+
								" where pfnoguard = '"+pfNo+"' and casualtyover=1)  and date2="+
									"(select max(date2) from signoffguard where pfnoguard = '"+pfNo+
									"' and casualtyover=1)  and pfnoguard = '"+pfNo+"' and casualtyover=1";
		}

		System.out.println(" HR : " + select );
		vector.removeAllElements();
		vector.trimToSize();
		vector =		qtm.setQuery("",select);
		int columnCount = qtm.getColumnCount();
		int totalRecords = vector.size();
		System.out.println(vector.size());
		if(vector.size() > 0)
		{
			try
			{
				strstn1 =((String[])vector.elementAt(0))[0];
				strstn2 =((String[])vector.elementAt(0))[1];
				strstn3 =((String[])vector.elementAt(0))[2];
				strstn4 =((String[])vector.elementAt(0))[3];
				strstn5 =((String[])vector.elementAt(0))[4];
				strstn6 =((String[])vector.elementAt(0))[5];
				strstn7 =((String[])vector.elementAt(0))[6];
				strstn8 =((String[])vector.elementAt(0))[7];
				strstn9 =((String[])vector.elementAt(0))[8];
				strstn10 =((String[])vector.elementAt(0))[9];
				strstn11 =((String[])vector.elementAt(0))[10];
				strstn12 =((String[])vector.elementAt(0))[11];
				lastSignOfDate =((String[])vector.elementAt(0))[12];
//				System.out.println(strstn1+" : " + strstn2+" : " +strstn3+" : " +strstn4+" : " +
//				strstn5+" : " +strstn6+" : " +strstn7 + " : " + lastSignOfDate);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
				if (strstn2.equals("null"))	
				{
					strstn=strstn1;
				}
				else if (strstn3.equals("null"))	
				{
					strstn=strstn2;
				}
				else if (strstn4.equals("null"))	
				{
					strstn=strstn3;
				}
				else if (strstn5.equals("null"))
				{
					strstn=strstn4;
				}
				else if (strstn6.equals("null"))
				{
					strstn=strstn5;
				}
				else if (strstn7.equals("null"))	
				{
					strstn=strstn6;
				}
				else if (strstn8.equals("null"))	
				{
					strstn=strstn7;
				}
				else if (strstn9.equals("null"))	
				{
					strstn=strstn8;
				}
				else if (strstn10.equals("null"))	
				{
					strstn=strstn9;
				}
				else if (strstn11.equals("null"))	
				{
					strstn=strstn10;
				}
				else if (strstn12.equals("null"))	
				{
					strstn=strstn11;
				}
				else
					strstn=strstn12;
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		if(!bool)
		{
			if(who.equals("Driver"))
			{
				try
				{
					if(strstn.equals(depot))
					{
						hrest = ct.getHourBetween(lastSignOfDate,driverDate);
					}
					else if(strstn.equals("NA"))
					{
						hrest = ct.getHourBetween(lastSignOfDate,driverDate);
					}
				}
				catch(NullPointerException npe1)
				{
						hrest = 0;
				}
			}
			if(who.equals("Assistant"))
			{
				try
				{
					if(strstn.equals(depot))
					{
						hrest = ct.getHourBetween(lastSignOfDate,assistantDate);
					}
					else if(strstn.equals("NA"))
					{
						hrest = ct.getHourBetween(lastSignOfDate,assistantDate);
					}
				}
				catch(NullPointerException npe1)
				{
						hrest = 0;
				}
			}
			if(who.equals("Guard"))
			{
				try
				{
					if(strstn.equals(depot))
					{
						hrest = ct.getHourBetween(lastSignOfDate,guardDate);
					}
					else if(strstn.equals("NA"))
					{
						hrest = ct.getHourBetween(lastSignOfDate,guardDate);
					}
				}
				catch(NullPointerException npe1)
				{
						hrest = 0;
				}
			}	
			System.out.println(" HR : " + hrest);
			return hrest;
		}
		else
		{
			System.out.println("Rest 0");
			return 0;
		}
		
	}
	public Vector retOSRest(String who, String pfNo)
	{
		String strStn=""; 
		double time=0.0;
		orest = 0;
		odaKm = 0;
		if(who.equals("Driver"))
		{
			query = "select StationTo,StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,stationto7,"+
								" stationto8, stationto9, stationto10, stationto11, stationto12, "+								
								"to_char(date1,'mm/dd/yyyy hh24:mi') from signoffdriver "+
								" where date1 = (select max(date1) from signoffdriver where pfnodriver = '"+pfNo+
								"' and stationTo <> 'NA') and date2="+
								" (select max(date2) from signoffdriver where pfnodriver = '"+pfNo+
								"' and stationTo <> 'NA') and stationTo <>'NA' and pfnodriver = '"+pfNo+"'";
		}
		if(who.equals("Assistant"))
		{
			query = "select StationTo,StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,StationTo7, "+
								" stationto8, stationto9, stationto10, stationto11, stationto12, "+
								"to_char(date1,'mm/dd/yyyy hh24:mi')  from signoffAssistant where date1 = "+
								" (select max(date1) from signoffAssistant "+
								" where pfnoAssistant = '"+pfNo+"'  and stationTo <> 'NA') and date2="+
									" (select max(date2) from signoffassistant where pfnoassistant = '"+pfNo+
									"'  and stationTo <> 'NA') and pfnoassistant = '"+pfNo+"'  and stationTo <> 'NA'";
		}
		if(who.equals("Guard"))
		{
			query = "select StationTo,StationTo2,StationTo3,StationTo4,StationTo5,StationTo6,StationTo7, "+
								" stationto8, stationto9, stationto10, stationto11, stationto12, "+
								"to_char(date1,'mm/dd/yyyy hh24:mi')  from signoffguard where date1 = "+
								"(select max(date1) from signoffguard "+
								" where pfnoguard = '"+pfNo+"'  and stationTo <> 'NA')  and date2="+
									"(select max(date2) from signoffguard where pfnoguard = '"+pfNo+
									"'  and stationTo <> 'NA')  and pfnoguard = '"+pfNo+"'  and stationTo <> 'NA'";
		}

		System.out.println("OSRest : "+query);
		vector.removeAllElements();
		vector.trimToSize();
		vector =		qtm.setQuery("",query);
		int columnCount = qtm.getColumnCount();
		int totalRecords = vector.size();
		if(vector.size() > 0)
		{
			try
			{
				strstn1 =((String[])vector.elementAt(0))[0];
				strstn2 =((String[])vector.elementAt(0))[1];
				strstn3 =((String[])vector.elementAt(0))[2];
				strstn4 =((String[])vector.elementAt(0))[3];
				strstn5 =((String[])vector.elementAt(0))[4];
				strstn6 =((String[])vector.elementAt(0))[5];
				strstn7 =((String[])vector.elementAt(0))[6];
				strstn8 =((String[])vector.elementAt(0))[7];
				strstn9 =((String[])vector.elementAt(0))[8];
				strstn10 =((String[])vector.elementAt(0))[9];
				strstn11 =((String[])vector.elementAt(0))[10];
				strstn12 =((String[])vector.elementAt(0))[11];
				lastSignOfDate =((String[])vector.elementAt(0))[12];
				System.out.println("OSRest : " + strstn1+" : " + strstn2+" : " +strstn3+" : " +strstn4+" : " +
				strstn5+" : " +strstn6+" : " +strstn7 + " : " + lastSignOfDate);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
				if (strstn2.equals("null"))	
				{
					strstn=strstn1;
				}
				else if (strstn3.equals("null"))	
				{
					strstn=strstn2;
				}
				else if (strstn4.equals("null"))	
				{
					strstn=strstn3;
				}
				else if (strstn5.equals("null"))
				{
					strstn=strstn4;
				}
				else if (strstn6.equals("null"))
				{
					strstn=strstn5;
				}
				else if (strstn7.equals("null"))	
				{
					strstn=strstn6;
				}
				else if (strstn8.equals("null"))	
				{
					strstn=strstn7;
				}
				else if (strstn9.equals("null"))	
				{
					strstn=strstn8;
				}
				else if (strstn10.equals("null"))	
				{
					strstn=strstn9;
				}
				else if (strstn11.equals("null"))	
				{
					strstn=strstn10;
				}
				else if (strstn12.equals("null"))	
				{
					strstn=strstn11;
				}
				else
					strstn=strstn12;

				System.out.println("OSRest : " + strstn);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			try
			{
				if(!strstn.equals(depot))
				{
					query = " select base from base where base = upper('"+strstn+"')";
					vector.removeAllElements();
					vector.trimToSize();
					vector  = snv.getStationNameList("",query);
					System.out.println("In outstation rest : " + driverDate + " : " + assistantDate + " :  " + 
						guardDate);
					if(vector.size() > 0)
					{
						if(who.equals("Driver"))
						{
							System.out.println("D OSRest : "+lastSignOfDate+" : " + driverDate);
							time = ct.getHourBetween(lastSignOfDate,driverDate);
							orest = ct.getHourBetween(lastSignOfDate,driverDate);
						}
						if(who.equals("Assistant"))
						{
							System.out.println("AD OSRest : "+lastSignOfDate+" : " + assistantDate);
							time = ct.getHourBetween(lastSignOfDate,assistantDate);
							orest = ct.getHourBetween(lastSignOfDate,assistantDate);				
						}
						if(who.equals("Guard"))
						{
							time =  ct.getHourBetween(lastSignOfDate,guardDate);
							orest = ct.getHourBetween(lastSignOfDate,guardDate);				
						}
						if(time > 16 )
						{
							System.out.println("OD Time"+time);
							time = (time -16)/24;
							odaKm = 70 + (int)time * 70 ;
						}
						System.out.println("OD Time"+time+"Kms:"+odaKm);
					}
					else 
						odaKm = 0;
				}
				else
					odaKm = 0;
			}
			catch(NullPointerException npe)
			{
				time = 0;
				odaKm = 0;
			}
			vecOut.removeAllElements();
			vecOut.trimToSize();
			vecOut.add(new Double(orest));
			vecOut.add(new Integer(odaKm));
			return vecOut;
		}
		else
		{
			return new Vector();
		}
	}
	public String verifyLoco(String locos)
	{
		nooflocos = 0;
		noloco = "";
		if (!locos.equals("00000+00000+00000+00000+00000"))
		{
			index = locos.trim().length();
			if (index == 35)
			{
				nooflocos = 6; 
			}
			else if (index == 29)
			{
				nooflocos = 5 ; 
			}
			else if (index == 23)
			{
				nooflocos = 4; 
			}
			else if (index == 17)
			{
				nooflocos = 3; 
			}
			else if (index == 11)
			{
				nooflocos = 2; 
			}
			else if (index == 5)
			{
				nooflocos = 1; 
			}
			else if (index < 5 ) 
			{
				nooflocos = 0;
			}
			System.out.println("vERIFY : "  + nooflocos + " : " + locos);
			for (int i=0 ; i < nooflocos; i++ )
			{
				try
				{
					loco = locos.trim().substring(0,5);
				}
				catch(Exception e)
				{
				}
				if (!loco.equals("00000"))
				{
//					noloco = "";
					query = "select locono from locomaster where locono='"+loco+"'";
					System.out.println(query);
					vecLoco = snv.getStationNameList("",query);
					vecLoco.trimToSize();
					if(vecLoco.size() <= 0)
					{
						noloco = noloco + ","+loco;
					}			
					vecLoco.removeAllElements();
					vecLoco.trimToSize();
					if(i != nooflocos - 1)
					{
						locos = locos.trim().substring(6);
					}
				}
				else
				{
					noloco = noloco + "";
				}
			}
			locos = "";
			System.out.println("NO MATCHES1 : " + noloco);			
		}
		return noloco;
	}
	public void returnMileage(String service, int distance, double time)
	{
		System.out.println("In Return Mileage : "+ service + " : " + distance + " : " + time);
		if(service.trim().equals("ThroughGoods"))
		{
			throughgoodskm += distance;
			throughgoodshrs += time;
			System.out.println("TG : " + throughgoodskm);
		}
		else if(service.trim().equals("Pilot"))
		{
			pilotkm += distance;	
			pilothrs += time;
			System.out.println("Pilot : " + pilotkm);
		}
		else if(service.trim().equals("SRTrain"))
		{
			srtrainkm += distance;	
			srtrainhrs += time;
			System.out.println("SRTrain : " + srtrainkm);
		}
		else if(service.trim().equals("Ballast"))
		{
			ballastkm += distance;										
			ballasthrs += time;
			System.out.println("Ballast : " + ballastkm);
		}
		else if(service.trim().equals("CraneSpecial"))
		{
			cranesplkm += distance;										
			cranesplhrs += time;
			System.out.println("Crane Spl : " + cranesplkm);
		}
		else if(service.trim().equals("BreakDown"))
		{
			breakdownkm += distance;										
			breakdownhrs += time;
			System.out.println("BD : " + breakdownkm);
		}
		else if(service.trim().equals("MedicalRelief"))
		{
			medicalreliefkm += distance;										
			medicalreliefhrs += time;
			System.out.println("Medical Relief : " + medicalreliefkm);
		}
		else if(service.trim().equals("Shuttling"))
		{
			shuttlingkm += distance;	
			shuttlinghrs += time;
			System.out.println("Shunting : " + shuttlingkm);
		}
		else if(service.trim().equals("Shunting"))
		{
			shuntingkm += distance;	
			shuntinghrs += time;
			System.out.println("Shunting : " + shuntingkm);
		}
		else if(service.trim().equals("CoalPilots"))
		{
			coalpilotskm += distance;										
			coalpilotshrs += time;
			System.out.println("Coal Pilots : " + coalpilotskm);
		}
		else if(service.trim().equals("LE/LA"))
		{
			lelakm += distance;		
			lelahrs += time;
			System.out.println("LELA : " + lelakm);
		}
		else if(service.trim().equals("MaterialTrain"))
		{
			materialtrainkm += distance;										
			materialtrainhrs += time;
			System.out.println("Material Train : " + materialtrainkm);
		}
		else if(service.trim().equals("EnggSpl"))
		{
			enggsplkm += distance;	
			enggsplhrs += time;
			System.out.println("Engg Spl : " + enggsplkm);
		}
		else if(service.trim().equals("HigherGrade1"))
		{
			hg1km += distance;
			hg1hrs += time;
			System.out.println("HG1 : " + hg1km);
		}
		else if(service.trim().equals("HigherGrade2"))
		{
			hg2km += distance;										
			hg2hrs += time;
			System.out.println("HG2 : " + hg2km);
		}
		else if(service.trim().equals("Passenger"))
		{
			hg1km += distance;										
			hg1hrs += time;
			System.out.println("PSNG : " + hg2km);
		}
		else if(service.trim().equals("LE"))
		{
			lekm += distance;										
			lehrs += time;
			System.out.println("LE : " + lekm);
		}
		else if(service.trim().equals("Siding"))
		{
			sidingkm += distance;										
			sidinghrs += time;
			System.out.println("Siding : " + sidingkm);
		}
		else if(service.trim().equals("YardRelief"))
		{
			yardreliefkm += distance;										
			yardreliefhrs += time;
			System.out.println("Yard Relief : " + yardreliefkm);
		}
		else if(service.trim().equals("PilotSection"))
		{
			pilotsectionkm += distance;										
			pilotsectionhrs += time;
			System.out.println("PilotSection : " + pilotsectionkm);
		}
		else if(service.trim().equals("LR"))
		{
			lrkm += distance;	
			lrhrs += time;
			System.out.println("LR : " + lrkm);
		}
	}
	public void updateLR(String section, String lrdate, String pfno, String who)
	{
		try
		{
//			query = "select stationname from lrstation where parentsection = '"+section+"'";
			query = "select distinct parent from sections where parent  = '"+section+"'";
			System.out.println(query);
			vector.removeAllElements();
			vector.trimToSize();
			vector = snv.getStationNameList("",query);
			vector.trimToSize();
			if (vector.size() > 0 )
			{
				if(who.equals("DRIVER"))
				{
					update = "update LRd set "+section+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi') where "+
										 "	pfnodriver = '"+pfno+"'";
					System.out.println(update);
					stmt.addBatch(update);
				}
				else if(who.equals("GUARD"))
				{
					update = "update LRG set "+section+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi') where "+
										 "	pfnoguard = '"+pfno+"'";
					System.out.println(update);
					stmt.addBatch(update);
				}
				else if(who.equals("ASSISTANT"))
				{
					update = "update LRAd set "+section+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi') where "+
									 "	PfNoAssistant = '"+	pfno+"'";
					System.out.println(update);
					stmt.addBatch(update);								
				}

				query = "select subsection from sections where parent = '"+section+"'";
				System.out.println(query);
				vector.removeAllElements();
				vector.trimToSize();
				vector = snv.getStationNameList("",query);
				vector.trimToSize();					
				
				for(int i = 0; i < vector.size(); i++)
				{			
					String sec = (String) vector.elementAt(i);
					System.out.println("Sec : " + sec);	
					if(who.equals("DRIVER"))
					{
						while (true)
						{
							try
							{
								System.out.println("indx : " + indx + " &&& : " + sec.substring(0,sec.indexOf(',')));
								query = "Update LRd set "+sec.substring(0,sec.indexOf(','))+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi')"+
								" Where (PfNoDriver = '"+	pfno+"')";
								System.out.println(query);
								stmt.addBatch(query);
								sec =  sec.substring(sec.indexOf(',')+1);
								System.out.println(sec);
							}
							catch(StringIndexOutOfBoundsException sioobe)
							{
								query = "Update LRd set "+sec+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi')"+
							" Where (PfNoDriver = '"+	pfno+"')";
								System.out.println(query);								
								stmt.addBatch(query);
								break;
							}
						}
					}
					sec = (String) vector.elementAt(i);
					System.out.println("Sec : " + sec);	
					if(who.equals("ASSISTANT"))
					{
						while (true)
						{
							try
							{
//								System.out.println(sec.substring(0,sec.indexOf(',')));
								query = "Update LRad set "+sec.substring(0,sec.indexOf(','))+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi')"+
								" Where (PfNoAssistant = '"+	pfno+"')";
								System.out.println(query);
								stmt.addBatch(query);
								sec =  sec.substring(sec.indexOf(',')+1);
								System.out.println(sec);
							}
							catch(StringIndexOutOfBoundsException sioobe)
							{
								query = "Update LRad set "+sec+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi')"+
							" Where (PfNoAssistant = '"+	pfno+"')";
								System.out.println(query);								
								stmt.addBatch(query);
								break;
							}
						}
					}
					sec = (String) vector.elementAt(i);
					System.out.println("Sec : " + sec);	
					if(who.equals("GUARD"))
					{
						while (true)
						{
							try
							{
								System.out.println("indx : " + indx + " &&& : " + sec.substring(0,sec.indexOf(',')));
								query = "Update LRG set "+sec.substring(0,sec.indexOf(','))+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi')"+
								" Where (PfNoGuard = '"+	pfno+"')";
								System.out.println(query);
								stmt.addBatch(query);
								sec =  sec.substring(sec.indexOf(',')+1);
								System.out.println(sec);
							}
							catch(StringIndexOutOfBoundsException sioobe)
							{
								query = "Update LRG set "+sec+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi')"+
							" Where (PfNoGuard = '"+	pfno+"')";
								System.out.println(query);								
								stmt.addBatch(query);
								break;
							}
						}
					}
				}
			}
			else
			{
				if(who.equals("DRIVER"))
				{
					update = "update LRd set "+section+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi') where "+
										 "	pfnodriver = '"+pfno+"'";
					System.out.println(update);
					stmt.addBatch(update);	
					if(!blnLRPilot)
					{
						if(!lrsection.equals(""))
						{
							update = "update LRd set "+lrsection+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi') where "+
													 "	pfnodriver = '"+pfno+"'";
								System.out.println("XXX : " + update);	
							stmt.addBatch(update);				
						}
					}
				}
				else if(who.equals("ASSISTANT"))
				{
					update = "update LRad set "+section+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi') where "+
										 "	pfnoassistant = '"+pfno+"'";
					System.out.println("XXX : " + update);
					stmt.addBatch(update);								
					if(!blnLRPilot)
					{
						if(!lrsection.equals(""))
						{
							update = "update LRad set "+lrsection+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi') where "+
												 "	pfnoassistant = '"+pfno+"'";
									System.out.println(update);		
							stmt.addBatch(update);
						}
					}
				}
				else if(who.equals("GUARD"))
				{
					update = "update LRG set "+section+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi') where "+
										 "	pfnoguard = '"+pfno+"'";
					System.out.println(update);
					stmt.addBatch(update);	
					if(!blnLRPilot)
					{
						if(!lrsection.equals(""))
						{
							update = "update LRG set "+lrsection+" = to_date('"+lrdate+"','mm/dd/yyyy hh24:mi') where "+
													 "	pfnoguard = '"+pfno+"'";
								System.out.println("XXX : " + update);	
							stmt.addBatch(update);				
						}
					}
				}				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}