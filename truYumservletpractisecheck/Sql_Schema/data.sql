/*MenuItem table details*/
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwitch', '99', '1', '2019-04-23', 'Main Course', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129', '1', '2019-12-23', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149', '1', '2020-01-10', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57', '0', '2021-03-12', 'Starters', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32', '1', '2022-11-04', 'Dessert', '1');

/* User table details*/
insert into  `truyum`.user(us_id,us_name) values(1,'Pooja');
insert into `truyum`.user(us_id,us_name) values(2,'Shraddha');

/*Cart table details*/
insert into `truyum`.cart(ct_us_id,ct_me_id)values(1,1);
insert into `truyum`.cart(ct_us_id,ct_me_id)values(1,3);
insert into `truyum`.cart(ct_us_id,ct_me_id)values(1,5);


/*view menu item list admin*/
select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from truyum.menu_item;

/*View Menu Item List Customer*/
select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from truyum.menu_item where me_active='1' and me_date_of_launch > (select CURDATE()); 

/*Edit Menu Item */
select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from truyum.menu_item where me_id='1';

update truyum.menu_item 
set me_name='Ice cream',me_price='180',me_active='1',me_date_of_launch='2021-11-06',me_category='Dessert',me_free_delivery='1'
where me_id='3';

select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from truyum.menu_item;

/*Add to Cart */
insert into `truyum`.cart(ct_us_id,ct_me_id)values(1,1);
insert into `truyum`.cart(ct_us_id,ct_me_id)values(1,3);
insert into `truyum`.cart(ct_us_id,ct_me_id)values(1,5);

/*View Cart */
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery 
from truyum.menu_item 
inner join cart as Cart
on ct_me_id=me_id
where ct_us_id='1'; 

select sum(me_price) as Total_price from menu_item inner join cart as Total on ct_me_id=ct_us_id where cart.ct_us_id='2';

/*Remove Item from Cart */
delete from truyum.cart where ct_us_id='1' and ct_me_id='1' limit 1;





