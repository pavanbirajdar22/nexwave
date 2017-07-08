create or replace procedure protenhoursKZ(month1 varchar2) is
	cursor totaltrips(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||stationTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') section,
	count(hours) trips	from signoffdriver
	where (casualty ='WKG')  and to_char(date2,'mm/YYYY') like month AND
	engine like '2%' and service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') ;
	cursor section is
	select distinct section sec from tenhourskzj where section not like 'NA-NA-NA-NA-NA-NA-NA-NA-NA-NA-NA-NA-NA'
	and traction like 'ELECTRIC';
 	cursor below9DEP(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') sect,
	count(hours) trips	from signoffdriver
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and ((date1-departure)*24)-detention <=9.0
	  and 	engine like '2%' and service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 		replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null','')	;
	cursor belowten(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') sect,
	count(hours) trips	from signoffdriver
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and
	hours-PILOTHOURS-detention <= 10	  and 	engine like '2%' and 
	service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 		replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null','')	;
	cursor withintendep(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') sect,
	count(hours) trips	from signoffdriver
	where casualty='WKG' and to_char(date2,'mm/YYYY') like month and
	((date1-departure)*24)-pilothours-detention <=10  and 	engine like '2%'
	and service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null','');
	cursor tentoTENFIVE(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') sect,
	count(hours) trips	from signoffdriver
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and
	(hours-PILOTHOURS-detention  between 10.01 and 10.49)  and 	engine like '2%'
	and service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null','');
	cursor tenfivetoeleven(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') sect,
	count(hours) trips	from signoffdriver
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and
	(hours-PILOTHOURS-detention  between 10.50 and 11)  and 	engine like '2%'
	and service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null','');
 	cursor eleventotwelve(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') sect,
	count(hours) trips	from signoffdriver
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and
	(hours-PILOTHOURS-detention  between 11.01 and 12)  and 	engine like '2%'
	and service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null','');
	cursor tentotwelve(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') sect,
	count(hours) trips	from signoffdriver
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and
	(hours-PILOTHOURS-detention  between 10.01 and 12 )  and 	engine like '2%'
	and service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null','');
	cursor twotothree(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') sect,
	count(hours) trips	from signoffdriver
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and
	(hours-PILOTHOURS-detention  between 12.01 and 13)  and 	engine like '2%'
	and service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null','');
	cursor abovethree(month varchar2) is
	select
	replace(replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null',''),'--','') sect,
	count(hours) trips	from signoffdriver
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and
	(hours-PILOTHOURS-detention  >=13.01)  and 	engine like '2%'
	and service not in ('Pilot','LR','Shunting','HigherGrade1','HigherGrade2')
	group by 	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||
	stationto4||'-'||STATIONTO5||'-'||stationto6||'-'||Stationto7||'-'||stationto8||'-'||
	stationto9||STATIONTO10||'-'||stationto11||'-'||Stationto12),'null','');
begin
	DELETE FROM tenhourskzj where traction='ELECTRIC';
	for rec1 in totaltrips(month1) loop
		insert into tenhourskzj(section,traction,totaltrips) values(rec1.section ,'ELECTRIC',rec1.trips);
	commit;
	end loop;
	for sec1 in section loop
		for hours1 in below9dep(month1) loop
			if(hours1.sect = sec1.sec)  then
			update tenhourskzj set below9dep=hours1.trips where section = sec1.sec and traction='ELECTRIC';
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in belowten(month1) loop
			if(hours1.sect = sec1.sec)  then
			update tenhourskzj set withinten=hours1.trips where section = sec1.sec and traction='ELECTRIC';
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in withintendep(month1) loop
			if(hours1.sect = sec1.sec)  then
			update tenhourskzj set withintendep=hours1.trips where section = sec1.sec and traction='ELECTRIC';
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in tentotenfive(month1) loop
			if(hours1.sect = sec1.sec)  then
			update tenhourskzj set tentotenfive=hours1.trips where section = sec1.sec and traction='ELECTRIC';
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in tenfivetoeleven(month1) loop
			if(hours1.sect = sec1.sec)  then
			update tenhourskzj set tenfivetoeleven=hours1.trips where section = sec1.sec and traction='ELECTRIC';
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in eleventotwelve(month1) loop
			if(hours1.sect = sec1.sec)  then
			update tenhourskzj set eleventotwelve=hours1.trips where section = sec1.sec and traction='ELECTRIC';
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in tentotwelve(month1) loop
			if(hours1.sect = sec1.sec)  then
			update tenhourskzj set tentotwelve=hours1.trips where section = sec1.sec and traction='ELECTRIC';
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in twotothree(month1) loop
			if(hours1.sect = sec1.sec)  then
			update tenhourskzj set twotothree=hours1.trips where section = sec1.sec and traction='ELECTRIC';
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in abovethree(month1) loop
			if(hours1.sect = sec1.sec)  then
			update tenhourskzj set abovethree=hours1.trips where section = sec1.sec and traction='ELECTRIC';
			end if;
		end loop;
		commit;
	end loop;
	end;
/
