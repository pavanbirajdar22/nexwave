procedure protenhoursdiesel(month1 varchar2) is
	cursor totaltrips(month varchar2) is 
	select 
	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') section,
	count(hours) trips
	from signoffdriver 
	where (casualty ='WKG')  and to_char(date2,'mm/YYYY') like month AND 
	engine like '1%' and service not like 'Pilot'and service not like 'Shunting'
	group by replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','');
	cursor section is
	select distinct section sec from tenhours where section not like 'NA-NA-NA-NA-NA' 
	and traction like 'DIESEL';
	cursor belowten(month varchar2) is 
	select 
	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') sect,
	count(hours) trips
	from signoffdriver 
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and hours < 10
	  and 	engine like '1%' and service not like 'Pilot'and service not like 'Shunting'
	group by replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') ;
	cursor withintendep(month varchar2) is 
	select 
	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') sect,count(hours) trips
	from signoffdriver 
	where casualty='WKG' and to_char(date2,'mm/YYYY') like month and 
	((date1-departure)*24) <10  and 	engine like '1%' and service not like 'Pilot'and service not like 'Shunting'
	group by 		replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') ;
	cursor tentotwelve(month varchar2) is 
	select 
	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') sect,
	count(hours) trips
	from signoffdriver 
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and 
	(hours between 10 and 12)  and 	engine like '1%' and service not like 'Pilot'and service not like 'Shunting'
	group by replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') ;
	cursor twotothree(month varchar2) is 
	select 
	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') sect,
	count(hours) trips
	from signoffdriver 
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and 
	(hours between 12.01 and 13)  and 	engine like '1%' and service not like 'Pilot'and service not like 'Shunting'
	group by replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') ;
	cursor abovethree(month varchar2) is 
	select 
	replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') sect,
	count(hours) trips
	from signoffdriver 
	where casualty='WKG'  and to_char(date2,'mm/YYYY') like month and 
	(hours >13)  and 	engine like '1%' and service not like 'Pilot'and service not like 'Shunting'
	group by replace((stationfrom||'-'||stationto||'-'||Stationto2||'-'||stationto3||'-'||	
	stationto4),'null','') ;
begin
	for rec1 in totaltrips(month1) loop
		insert into tenhours(section,traction,totaltrips) values(rec1.section ,'DIESEL',rec1.trips);
	commit;
	end loop;
	for sec1 in section loop
		for hours1 in belowten(month1) loop
			if(hours1.sect = sec1.sec)  then 
			update tenhours set withinten=hours1.trips where section = sec1.sec and traction='DIESEL';		
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in withintendep(month1) loop
			if(hours1.sect = sec1.sec)  then 
			update tenhours set withintendep=hours1.trips where section = sec1.sec and traction='DIESEL';		
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in tentotwelve(month1) loop
			if(hours1.sect = sec1.sec)  then 
			update tenhours set tentotwelve=hours1.trips where section = sec1.sec and traction='DIESEL';		
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in twotothree(month1) loop
			if(hours1.sect = sec1.sec)  then 
			update tenhours set twotothree=hours1.trips where section = sec1.sec and traction='DIESEL';		
			end if;
		end loop;
		commit;
	end loop;
	for sec1 in section loop
		for hours1 in abovethree(month1) loop
			if(hours1.sect = sec1.sec)  then 
			update tenhours set abovethree=hours1.trips where section = sec1.sec and traction='DIESEL';		
			end if;
		end loop;
		commit;
	end loop;
	end;
/
