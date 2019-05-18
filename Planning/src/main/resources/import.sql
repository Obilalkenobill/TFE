insert into Heure (nom_heure) values ('08h'),('12h'),('16h'),('18h')
insert into Jour (nom_jour) values ('lundi'),('mardi'),('mercredi'),('jeudi'),('vendredi'),('samedi'),('dimanche')
insert into Adresse (code_postale, localite, numero_et_boite, pays, rue) values (121123,'Bien-Jardin','8','Belgique','rue des trois brouettes'),(123123,'Bienbon','18','Belgique','rue des trois casquettes'),(123123,'Chass-Ville','88','Belgique','rue des trois proies'),(122123,'Bien-Manger','28','Belgique','rue des trois haches'),(123123,'Bien-Moins','76','Belgique','rue des trois deux'),(123553,'Bien-Bien-Bien','88','Belgique','rue des trois biens'),(123663,'Bien-Oui','55','Belgique','rue des trois jambes'),(12111,'Bien-Matheux','45','Belgique','rue des trois quatres'),(123333,'Bien-Danger','12','Belgique','rue des trois corps'),(122145,'Bien-Bon','67','Belgique','rue des trois barbes'),(1223,'Bien-Bill','32','Belgique','rue des trois froids'),(12444,'Bien-Bon','44','Belgique','rue des trois casques'),(12223,'Bien-Us','78','Belgique','rue des trois alouettes'),(1113,'Bien-Bien','23','Belgique','rue des trois cigales'),(1200,'Bien-Hiroshi','88','Belgique','rue des trois bras'),(12003,'Bien-Gentil','54','Belgique','rue des trois bois'),(121113,'Bien-Bon','12','Belgique','rue des trois reference'),(12355,'Bien','1','Belgique','rue des trois couettes'),(12333,'Bien-Bien','188','Belgique','rue des trois chaussures'),(12222,'Bien-Moche','18','Belgique','rue des trois oiseau'),(12111,'Bien-Beau','456','Belgique','rue des trois bar'),(1245,'Bien-Lo','456','Belgique','rue des trois gouttes'),(12111,'Bien-Alheure','456','Belgique','rue des trois quart'),(12161,'Bien-redondan','456','Belgique','rue des trois trois')
insert into Infirmier (adresse_id,date_naiss,nom,prenom,tel) values (1,'01/12/1987','Leclair','Jean','0475-846-231'),(2,'11/12/1990','Lebon','Bill','0475-123-231'),(3,'13/02/1987','Lele','Maxime','0475-846-231'),(4,'01/02/1987','Lenou','Jerome','0475-456-231')
update Adresse set infirmier_id=1 where id=1
update Adresse set infirmier_id=2 where id=2
update Adresse set infirmier_id=3 where id=3
update Adresse set infirmier_id=4 where id=4
insert into Patient (adresse_id, date_naiss,infirmier_id,nom,prenom,tel) values (5,'11/02/1999',1,'Ben Baba','Omar','0481-123-456'),(6,'11/03/1999',3,'Kueki','Opris','0482-123-456'),(7,'11/02/1971',4,'Bilies','Olies','0485-523-456'),(8,'15/06/1983',1,'Milois','Peri','0488-253-456'),(9,'23/05/1999',2,'Nilus','Olesir','0482-453-456'),(10,'23/56/1965',1,'Kiloki','Ilostor','0485-873-456'),(11,'29/03/1992',3,'Olkaste','Birbillon','0471-485-456'),(12,'11/06/1985',4,'Gostor','Ben','0495-453-456'),(13,'25/12/1997',1,'Birou','Sirou','0497-133-456'),(14,'14/03/2000',2,'Dumeureille','Sybeline','0491-953-456'),(15,'23/07/1996',1,'Duchausseur','Myrtille','0475-123-456'),(16,'25/01/1984',3,'Likesis','Demili','0473-123-456'),(17,'06/08/1981',3,'Sildui','Pepeline','0474-123-456'),(18,'12/06/1986',2,'Sana','Vapa','0498-123-456'),(19,'02/02/1983',4,'Bijou','Rose','0497-123-456'),(20,'16/05/1985',1,'Bobi','Kodi','0471-123-456'),(21,'16/06/1981',2,'Joujou','Coucou','0471-456-456'),(22,'12/01/1985',3,'Douze','Duhin','0471-123-132'),(23,'11/03/1999',4,'Baba','Lala','0485-123-456'),(24,'12/12/1992',4,'Jaja','Coucou','0481-000-456')
insert into ADRESSE_PATIENTS  (adresse_id,patients_id) values (5,1),(6,2),(7,3),(8,4),(9,5),(10,6),(11,7),(12,8),(13,9),(14,10),(15,11),(16,12),(17,13),(18,14),(19,15),(20,16),(21,17),(22,18),(23,19),(24,20)
insert into INFIRMIER_PATIENTS (infirmier_id,patients_id) values (1,1),(1,4),(1,6),(1,9),(1,11),(1,16),(2,5),(2,10),(2,14),(2,17),(3,2),(3,7),(3,12),(3,13),(3,18),(4,3),(4,8),(4,15),(4,19),(4,20)
insert into i_tache (type,description) values ('Plonge','Laver la vaisselle des patients après le repas'),('Table','Dresser une belle table puis apporter la nourriture de la cuisine et la servir'),('Ordure ménagère','Une fois pleines, sortez les poubelles afin de les jeter dans la bène'),('Sol','Nettoyer le sol des salles de tables'),('Frigo & Four','Bien nettoyer le frigo et le four')
insert into tache (jour_id,heure_id,infirmier_id,itache_id) values (1,1,1,2),(2,1,1,2),(3,1,1,2),(4,1,1,2),(5,1,1,2),(6,1,1,2),(7,1,1,2),(1,2,1,2),(2,2,1,2),(3,2,1,2),(4,2,1,2),(5,2,1,2),(6,2,1,2),(7,2,1,2),(1,4,1,2),(2,4,1,2),(3,4,1,2),(4,4,1,2),(5,4,1,2),(6,4,1,2),(7,4,1,2)
insert into patient_taches (patient_id,taches_id) values (1,21),(2,20),(3,19),(4,18),(5,17),(6,16),(7,15),(8,14),(9,13),(10,12),(11,11),(12,10),(13,9),(14,8),(15,7),(16,6),(17,5),(18,4),(19,3),(20,2),(1,1)
insert into tache_patients (tache_id,patients_id) values (21,1),(20,2)