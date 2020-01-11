/*Movie table details*/
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_boxoffice`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2017-03-23', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_boxoffice`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2018-12-23', 'Superhero', '0');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_boxoffice`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2021-08-21', 'Romance', '0');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_boxoffice`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2019-07-02', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movie` (`mo_id`, `mo_title`, `mo_boxoffice`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers:End Game', '2750760348', '1', '2022-11-02', 'Superhero', '1');

select mo_id,mo_title, mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from moviecruiser.movie;

/* User table details*/
insert into user(us_id,us_name)values(1,'Sangram');
insert into user(us_id,us_name)values(2,'Sanket');

select us_id,us_name from moviecruiser.user;

/*Favorite table details*/
insert into moviecruiser.favorites(fav_us_id,fav_mo_id)values(1,1);
insert into moviecruiser.favorites(fav_us_id,fav_mo_id)values(1,3);
insert into moviecruiser.favorites(fav_us_id,fav_mo_id)values(1,4);

select fav_id,fav_us_id,fav_mo_id from moviecruiser.favorites;
/*view movie list admin*/
select mo_id,mo_title, mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from moviecruiser.movies;


/*View Movie List Customer*/
select mo_id,mo_title, mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from `moviecruiser`.`movie` where mo_active='1' and mo_date_of_launch > (select CURDATE()); 


/*Edit movie*/
select mo_id,mo_title, mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from `moviecruiser`.`movie` where mo_id='1';

update moviecruiser.movie 
set mo_title='Geostorm',mo_boxoffice='5321456387',mo_active='1',mo_date_of_launch='2022-05-09',mo_genre='Science fiction',mo_has_teaser='0'
where mo_id='3';

select mo_id,mo_title, mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from moviecruiser.movie;

/*Add to Favorites */
insert into moviecruiser.favorites(fav_us_id,fav_mo_id)values(1,1);
insert into moviecruiser.favorites(fav_us_id,fav_mo_id)values(1,3);
insert into moviecruiser.favorites(fav_us_id,fav_mo_id)values(1,4);

/*View favorites */
select mo_title,mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser 
from moviecruiser.movie
inner join moviecruiser.favorites as Favorite
on fav_mo_id=mo_id 
where fav_us_id=1;

select count(moviecruiser.favorites.fav_id) as No_Of_Favorites from moviecruiser.favorites;

 
/*Remove movie from  */
delete from moviecruiser.favorites where fav_us_id='1' and fav_mo_id='1' limit 1;
