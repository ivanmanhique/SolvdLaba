-- ALTER TABLE:


ALTER TABLE `vb_Football`.`Players`
ADD Team_id int,
ADD INDEX `fk_Players_Team1_idx` (`Team_id` ASC),
ADD  CONSTRAINT `fk_Players_Team1`
    FOREIGN KEY (`Team_id`)
    REFERENCES `vb_Football`.`Team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
;

ALTER TABLE vb_Football.PlayerStats
ADD date_ date not null;

ALTER TABLE vb_Football.Nationality
ADD city varchar(20);

ALTER TABLE vb_Football.Nationality
DROP COLUMN city;

ALTER TABLE vb_Football.Match
CHANGE COLUMN date_  match_date DATE;


-- UPDATE:


UPDATE vb_Football.Referree set name = 'Pablo C' WHERE id= 2;
UPDATE vb_Football.Referree set name = 'Paulo C' WHERE id = 4;
UPDATE vb_Football.Stadium set name = 'Zimpeto' WHERE id = 6 ;
UPDATE vb_Football.PlayerStats set goal = 2 where id = 2;
UPDATE vb_Football.PlayerStats set goal = 1 where id = 5;
UPDATE vb_Football.PlayerStats set yellowcard = 1 where id = 1;
UPDATE vb_Football.PlayerStats set redCard = 1 where id = 4;
UPDATE vb_Football.Players set firstname  = 'Kyllian' where id = 6;
UPDATE vb_Football.PlayerStats set goal = 0 where id = 5;
UPDATE vb_Football.PlayerStats set goal = 3 where id = 3;
UPDATE vb_Football.Players set Team_id=1 where id >0 and id <4;
UPDATE vb_Football.Players set Team_id=2 where id >3 and id <7



-- DELETIONS:


INSERT INTO vb_Football.Position values (10, 'GK');
INSERT INTO vb_Football.Position values (12, 'LB');
INSERT INTO vb_Football.Position values (13, 'CB');
INSERT INTO vb_Football.Position values (14, 'RB');
INSERT INTO vb_Football.Position values (15, 'CM');
INSERT INTO vb_Football.Position values (16, 'CAM');
INSERT INTO vb_Football.Position values (17, 'RW');
INSERT INTO vb_Football.Position values (18, 'LW');
INSERT INTO vb_Football.Position values (19, 'ST');

DELETE FROM vb_Football.Position WHERE id = 10;
DELETE FROM vb_Football.Position WHERE id = 11;
DELETE FROM vb_Football.Position WHERE id = 12;
DELETE FROM vb_Football.Position WHERE id = 13;
DELETE FROM vb_Football.Position WHERE id = 14;
DELETE FROM vb_Football.Position WHERE id = 15;
DELETE FROM vb_Football.Position WHERE id = 16;
DELETE FROM vb_Football.Position WHERE id = 17;
DELETE FROM vb_Football.Position WHERE id = 18;
DELETE FROM vb_Football.Position WHERE id = 19;

-- INSERTIONS:
-- Positions :
INSERT INTO vb_Football.Position values (1, 'GK');
INSERT INTO vb_Football.Position values (2, 'LB');
INSERT INTO vb_Football.Position values (3, 'CB');
INSERT INTO vb_Football.Position values (4, 'RB');
INSERT INTO vb_Football.Position values (5, 'CM');
INSERT INTO vb_Football.Position values (6, 'CAM');
INSERT INTO vb_Football.Position values (7, 'RW');
INSERT INTO vb_Football.Position values (8, 'LW');
INSERT INTO vb_Football.Position values (9, 'ST');

-- Referres :
INSERT INTO vb_Football.Referree values (1, 'Pierluigi Collina');
INSERT INTO vb_Football.Referree values (2, 'Joao Tembe');
INSERT INTO vb_Football.Referree values (4, 'Joao Tembe');
INSERT INTO vb_Football.Referree values (6, 'Ricardo Carvalho');
INSERT INTO vb_Football.Referree values (8, 'Richard Enderson');

--Season :
INSERT INTO vb_Football.Season values (1, '2013/14');
INSERT INTO vb_Football.Season values (2, '2014/15');
INSERT INTO vb_Football.Season values (3, '2015/16');
INSERT INTO vb_Football.Season values (4, '2016/17');
INSERT INTO vb_Football.Season values (5, '2018/19');

--Stadiums:
INSERT INTO vb_Football.Stadium values (1, 'Santiago Bernabeu');
INSERT INTO vb_Football.Stadium values (2, 'Camp Nou');
INSERT INTO vb_Football.Stadium values (3, 'Old Trafford');
INSERT INTO vb_Football.Stadium values (4, 'Parc de Princes');
INSERT INTO vb_Football.Stadium values (5, 'Allianz Arena');
INSERT INTO vb_Football.Stadium values (6, 'Ethiad Stadium');

--Nationality :
INSERT INTO vb_Football.Nationality values (1, 'Mozambique');
INSERT INTO vb_Football.Nationality values (2, 'Spain');
INSERT INTO vb_Football.Nationality values (3, 'Brazil');
INSERT INTO vb_Football.Nationality values (4, 'Argentina');

--PlayerStats :

INSERT INTO vb_Football.PlayerStats values (1,0,0,3,2,'2017-08-16'); /*vini*/
INSERT INTO vb_Football.PlayerStats values (2,1,0,3,1,'2017-08-16'); /* pepe*/
INSERT INTO vb_Football.PlayerStats values (3,0,1,1,5,'2017-08-16'); /*Ronaldo*/
INSERT INTO vb_Football.PlayerStats values (4,0,0,0,2,'2017-08-16'); /*Meessi*/
INSERT INTO vb_Football.PlayerStats values (5,0,2,0,0,'2017-08-16'); /*Ramos*/
INSERT INTO vb_Football.PlayerStats values (6,0,0,0,1,'2017-08-16');/*Mbappe*/

--League :

INSERT INTO vb_Football.League(name,country) values ('World Club Tournament',1);
INSERT INTO vb_Football.League(name,country) values ('European + SA Tournament',2);

--League_Season :
INSERT INTO vb_Football.League_Season(Season_id, League_id) values (4,1);
INSERT INTO vb_Football.League_Season(Season_id, League_id) values (4,2);
INSERT INTO vb_Football.League_Season(Season_id, League_id) values (5,1);
INSERT INTO vb_Football.League_Season(Season_id, League_id) values (5,2);


--Players and Teams :

INSERT INTO vb_Football.Players(firstname, lastname,PlayerStats_id,Position_id,Nationality_id,Team_id) values ('Vini','Jr', 1,8,3,null);
INSERT INTO vb_Football.Players(firstname, lastname,PlayerStats_id,Position_id,Nationality_id,Team_id) values ('Pepe','Mau', 2,3,3,null); /*update name*/
INSERT INTO vb_Football.Players(firstname, lastname,PlayerStats_id,Position_id,Nationality_id,Team_id) values ('Cristiano','Ronaldo', 3,9,3,null);
INSERT INTO vb_Football.Team (name,League_id, Players_id) values('Madrid',2,1 );

INSERT INTO vb_Football.Players(firstname, lastname,PlayerStats_id,Position_id,Nationality_id,Team_id) values ('Leo','Messi', 4,8,3,null);
INSERT INTO vb_Football.Players(firstname, lastname,PlayerStats_id,Position_id,Nationality_id,Team_id) values ('Sergio','Ramos', 5,7,3,null);
INSERT INTO vb_Football.Players(firstname, lastname,PlayerStats_id,Position_id,Nationality_id,Team_id) values ('K.','Mbappe', 6,9,3,null);
INSERT INTO vb_Football.Team (name,League_id, Players_id) values('PSG',2,4 );

--Team_League :

INSERT INTO vb_Football.Team_League(League_id,Team_id) values (1,1);
INSERT INTO vb_Football.Team_League(League_id,Team_id) values (1,2);

--MATCH :--
INSERT INTO vb_Football.Match(date_,Team1, Team2) values ('2017-08-16', 1,2);

--Match_Referrees :
INSERT INTO vb_Football.Match_Referrees( Referree_id,Match_id) values (1,1);

INSERT INTO vb_Football.Match_League( League_id,Match_id) values (2,1);
INSERT INTO vb_Football.Match_Stadium( Stadium_id,Match_id) values (2,1);


-- ONE BIG STATEMENT:
 SELECT *
 FROM vb_Football.Players p
 JOIN vb_Football.Nationality n ON p.Nationality_id = n.id
 JOIN vb_Football.Position pos ON  p.Position_id = pos.id
 JOIN vb_Football.PlayerStats ps ON p.PlayerStats_id = ps.id
 JOIN vb_Football.Team	t ON p.Team_id = t.id
 JOIN vb_Football.League l ON t.League_id = l.id
 JOIN vb_Football.League_Season ls ON l.id = ls.League_id
 JOIN vb_Football.Season s ON ls.Season_id = s.id
 JOIN vb_Football.Team_League tl ON t.id = tl.Team_id
 JOIN vb_Football.Match m ON t.id = m.Team1
 JOIN vb_Football.Match_Stadium ms ON m.id = ms.Match_id
 JOIN vb_Football.Stadium st ON ms.Stadium_id = st.id
 JOIN vb_Football.Match_Referrees mr ON m.id= mr.Match_id
 JOIN vb_Football.Referree r ON mr.Referree_id = r.id;


-- 5 Joins:

-- inner join
 SELECT p.firstname, p.lastname, pos.name as 'position'
 FROM vb_Football.Players p
 INNER JOIN vb_Football.Position pos ON p.Position_id = pos.id;

 -- right join
 SELECT p.firstname, p.lastname, pos.name as 'position'
 FROM vb_Football.Players p
 RIGHT JOIN vb_Football.Position pos ON p.Position_id = pos.id;

 -- left join
 SELECT n.name, l.name as club
 FROM vb_Football.Nationality n
 LEFT JOIN vb_Football.League l ON  n.id = l.Country;

  -- outer join
   SELECT p.firstname, p.lastname, pos.name as 'position'
   FROM vb_Football.Players p
   JOIN vb_Football.Position pos ON p.Position_id = pos.id;

-- left join
SELECT l.name as clubName, ls.Season_id
FROM vb_Football.League l
LEFT JOIN vb_Football.League_Season ls ON l.id = ls.League_id;


-- 7 Group by:

-- 1
SELECT COUNT(*), Team_id
FROM vb_Football.Players p
group by p.Team_id;

-- 2
SELECT COUNT(*), goal
FROM vb_Football.PlayerStats
group by goal;

-- 3
SELECT COUNT(*), League_id
FROM vb_Football.Team
group by League_id;

-- 4
SELECT COUNT(*), Country
FROM vb_Football.League
group by Country;

-- 5
SELECT COUNT(*), Country
FROM vb_Football.League
group by Country;

-- 6
SELECT COUNT(*), redCard
FROM vb_Football.PlayerStats
group by redCard;

-- 7
SELECT COUNT(*), yellowCard
FROM vb_Football.PlayerStats
group by yellowCard;


-- Group by with Having:

SELECT COUNT(*), Country
FROM vb_Football.League
group by Country
having count(*) >=1;

SELECT COUNT(*), redCard
FROM vb_Football.PlayerStats
where redCard >=1
group by redCard
having count(*) >=1;


SELECT COUNT(*), goal
FROM vb_Football.PlayerStats
group by goal
having count(*) =3;