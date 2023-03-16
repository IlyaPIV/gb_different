SELECT films1.date,
	films1.name,
	films1.time,
    films1.duration,
	films1.endtime,
    films2.name,
    films2.time
FROM (SELECT  sch.id,
		f.name,
		sch.date, 
        sch.time,
        addtime(sch.time,SEC_TO_TIME(f.duration*60)) as 'endtime',
        f.duration
FROM cinema.schedule as sch
	join cinema.film as f on sch.film_id=f.id
order by sch.date, sch.time) as films1
	JOIN (SELECT  sch.id,
			f.name,
			sch.date, 
			sch.time
	FROM cinema.schedule as sch
		join cinema.film as f on sch.film_id=f.id
	order by sch.date, sch.time) as films2 ON films1.date=films2.date
    WHERE films1.endtime>films2.time AND films1.time<films2.time;