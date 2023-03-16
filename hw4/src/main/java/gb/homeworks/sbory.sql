SELECT  sales.name,
		SUM(sales.sold),
        SUM(sales.earned),
        AVG(sales.sold),
        AVG(sales.earned)
FROM (SELECT 	ts.schedule_id,
				f.name,
				count(ts.place) AS sold,
				count(ts.place)*pr.price AS earned
		FROM cinema.tickets_sales AS ts
			JOIN cinema.schedule AS sch ON ts.schedule_id=sch.id
			JOIN cinema.pricelist AS pr ON ts.schedule_id=pr.schedule_id
			JOIN cinema.film AS f ON sch.film_id=f.id
		GROUP BY ts.schedule_id) AS sales
GROUP BY sales.name
ORDER BY SUM(sales.earned) DESC;	


SELECT  sales.timezone,
		SUM(sales.sold),
        SUM(sales.earned)
FROM (SELECT 	ts.schedule_id,
				sch.time,
				CASE 
					WHEN sch.time>=time('09:00') AND sch.time<time('15:00')
						THEN 'c 9 до 15'
					WHEN sch.time>=time('15:00') AND sch.time<time('18:00')
						THEN 'с 15 до 18'
					WHEN sch.time>=time('18:00') AND sch.time<time('21:00')
						THEN 'с 18 до 21'
					ELSE 'с 21 до 00'
				END AS timezone,
				count(ts.place) AS sold,
				count(ts.place)*pr.price AS earned
		FROM cinema.tickets_sales AS ts
			JOIN cinema.schedule AS sch ON ts.schedule_id=sch.id
			JOIN cinema.pricelist AS pr ON ts.schedule_id=pr.schedule_id
		GROUP BY ts.schedule_id) AS sales
GROUP BY sales.timezone;