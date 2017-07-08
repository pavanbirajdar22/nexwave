SELECT namedriver from signoffdriver where
date2 between '12-dec-04' and '28-dec-04'
and casualty IN ('PR','LEAVE')
GROUP BY NAMEDRIVER
/
