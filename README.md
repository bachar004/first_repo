Le projet consiste à créer une application permettant de simuler le fonctionnement d'une agence de location de voitures.fenêtres de L'application:
Fenêtre 1:
L'utilisateur clique sur un bouton: Administrateur ou Client
Fenêtre 2:
L'utilisateur doit saisir un login et un mot de passe pour se connecter ou clique sur un bouton "Sign In" pour créer un compte 
Fenêtre 3:
L'utilisateur s'inscrit en fournissant: un login, un mot de passe, une adresse (ville) et une adresse e-mail.
Fenêtre 4:
Si un administrateur: il clique sur un bouton lui permettant d'ouvrir une fenêtre pour:
- Ajouter une nouvelle voiture (Marque, modèle, Age, prix)
- Consulter la liste des voitures (Toutes ou selon un critère)
- Consulter la liste des utilisateurs
Fenêtre 4:
Si un User, il clique sur un bouton lui permettant d'ouvrir une fenêtre pour:
- Voir la liste des voitures ayant pour état: "A louer" et clique sur le bouton "Louer" pour valider son choix
- Voir ses paramètres d'accès et les modifier si nécesaire

- // voir ici le script de base de données vu qu'elle est local:
- create database app;
  
create table admin(
login varchar(50) primary key,
mdp varchar(50));

create table user(
login varchar(50) primary key,
mdp varchar(50),
ville varchar(50),
mail varchar(100));

create table voiture(
immatricule int,
marque varchar(50),
modele varchar(50),
age int,
prix double,
login_user varchar(50),
constraint pk3 primary key (immatricule),
constraint fk foreign key(login_user) references user(login),
constraint ch1 check(age>0),
constraint ch2 check(prix>0));

insert into admin values ('admin25', 'admin123');

insert into user values('ahmed07', 'ahmed07', 'sfax', 'ahmed2005@gmail.com');
insert into user values('amen007', 'amen007', 'nabeul', 'amen36@gmail.com');
insert into user values('amir22', 'amir22', 'manouba', 'amir@gmail.com');
insert into user values('aymen', 'aymen1234', 'nabeul', 'aymen04@gmail.com');
insert into user values('bach', 'bachar123', 'seliana', 'bachar04@gmail.com');
insert into user values('eya22', 'eya8956', 'bizerte', 'eya@gmail.com');
insert into user values('houayda77', 'houayda77', 'kef', 'houayda55@gmail.com');
insert into user values('lina10', 'lina10', 'sanheja', 'lina@gmail.com');

insert into voiture values('1', 'audi', 'a5', '10', '220', NULL);
insert into voiture values('2', 'renault', 'clio_bombé', '2', '200', NULL);
insert into voiture values('3', 'renault', 'symbole', '15', '100', 'aymen');
insert into voiture values('4', 'audi', 'a2', '2', '88', 'ahmed07');
insert into voiture values('5', 'renault', 'symbole', '2', '105', NULL);
insert into voiture values('6', 'renault', 'symbole', '15', '120', NULL);
insert into voiture values('7', 'citroen', 'berlingo', '8', '110', NULL);
insert into voiture values('8', 'citroen', 'berlingo', '8', '160', NULL);
insert into voiture values('9', 'renault', 'classique', '17', '80', NULL);
insert into voiture values('10', 'peugeuot', '208', '6', '280', NULL);
insert into voiture values('11', 'toyota', 'dmax', '1', '170', 'bach');
insert into voiture values('12', 'bmw', 'e36', '3', '170', NULL);
insert into voiture values('13', 'volkswagen', 'golf 4', '12', '130', NULL);
insert into voiture values('14', 'citreon', 'c5', '10', '180', NULL);

#j'éspère que tout est claire 
