-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: foodislife
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping routines for database 'foodislife'
--
/*!50003 DROP PROCEDURE IF EXISTS `addLeftovers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addLeftovers`(
	IN ItemNo int,
    IN qty int,
    IN BB date,
    IN adminEmail varchar(70)
)
BEGIN
	declare bid int;
    declare rid int;
	
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		
        -- get the restaurant and branch id 
		select branch.restaurant_id, branch.id into rid, bid from branch_admin join branch on branch_admin.id = branch.admin_id where branch_admin.email = adminEmail;
        
        -- insert the leftover by updating the quantity of item
        update leftovers
        set quantity = qty, best_before = BB
        where item_id = ItemNo and restaurant_id = rid and branch_id = bid;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addOrderItems` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addOrderItems`(
	IN itemid int,
    IN resName varchar(50),
    IN bid int
)
BEGIN
	declare oid int;
    declare rid int;
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		select restaurant.id into rid from restaurant where name = resName;
		select orders.id into oid from orders order by orders.id desc limit 1;
		insert into order_items values(oid, itemid, rid, bid);
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addRiderDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addRiderDetails`(
	IN rider_cnic varchar(12),
    IN rider_name varchar(70),
    IN rider_phone varchar(12),
    IN rider_email varchar(70),
    IN adminEmail varchar(70)
)
BEGIN
	declare nid int;
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
    
		select ngo.id into nid from ngo join ngo_admin on ngo.admin_id = ngo_admin.id where ngo_admin.email = adminEmail;
        insert into rider(cnic, name, phone, email, ngo_id) values(rider_cnic, rider_name, rider_phone, rider_email, nid);
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addStoreFoodItems` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addStoreFoodItems`(
	IN itemNO int,
	IN itemName varchar(70),
    IN itemDesc varchar(500),
    IN adminEmail varchar(70)
)
BEGIN
	declare bid int;
    declare rid int;
	
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
    
		select branch.restaurant_id, branch.id into rid, bid from branch_admin join branch on branch_admin.id = branch.admin_id where branch_admin.email = adminEmail;
        insert into food_items values(itemNo, ItemName, ItemDesc, rid, bid);
        insert into leftovers(item_id, restaurant_id, branch_id) values(itemNo, rid, bid);
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `bookOrder` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bookOrder`(
	IN otime date,
    IN oStatus varchar(70),
    IN ptime date,
    IN resName varchar(50),
    IN bid int,
    IN rider_cnic varchar(12)
)
BEGIN
	declare rid int;
    declare oid int;
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		select restaurant.id into rid from restaurant where name = resName;
		insert into orders(order_time, order_status, pickup_time, restaurant_id, branch_id) values(otime, oStatus, ptime, rid, bid);
		
        select orders.id into oid from orders order by orders.id desc limit 1;
        update rider
        set rider.order_id = oid
        where rider.cnic = rider_cnic;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CreateTables` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateTables`()
    DETERMINISTIC
    COMMENT 'Creating all necessary tables'
BEGIN
 
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;

	create table if not exists restaurant(
		id int primary key auto_increment,
		name varchar(50) not null unique
	);
	create table if not exists branch_admin(
		id int primary key auto_increment,
		username varchar(70) not null,
		admin_password varchar(100) not null,
		phone varchar(12) not null,
		email varchar(70) not null unique
	);
	create table if not exists branch(
		id int,
		address varchar(300) not null,
		city varchar(50) not null,
		state varchar(100) not null,
		phone varchar(12) not null,
		email varchar(70) not null,
        openingHours varchar(100) not null,
		restaurant_id int, 
		admin_id int,
		primary key(id, restaurant_id),
		foreign key(restaurant_id) references restaurant(id),
		foreign key(admin_id) references branch_admin(id)
	);
	create table if not exists food_items(
		id int,
		item_name varchar(70) not null,
		item_description varchar(500) not null,
		restaurant_id int,
        branch_id int,
        primary key(id, restaurant_id, branch_id),
        foreign key(branch_id, restaurant_id) references branch(id, restaurant_id)
	);
	create table if not exists NGO_admin(
		id int primary key auto_increment,
		username varchar(70) not null,
		admin_password varchar(100) not null,
		phone varchar(12) not null,
		email varchar(70) not null unique
	);
    create table if not exists NGO(
		id int primary key auto_increment,
        NgoName varchar(50) not null unique,
		address varchar(300) not null,
		city varchar(50) not null,
		state varchar(100) not null,
		phone varchar(12) not null,
		email varchar(70) not null,
        openingHours varchar(100) not null,
		admin_id int,
		foreign key(admin_id) references NGO_admin(id)
	);
    create table if not exists leftovers(
		quantity int not null default 0,
        best_before date,
        item_id int,
        restaurant_id int,
        branch_id int,
        foreign key(item_id, restaurant_id, branch_id) references food_items(id, restaurant_id, branch_id),
        primary key(item_id, restaurant_id, branch_id)
    );
    create table if not exists orders(
		id int primary key auto_increment,
        order_time date not null,
        order_status varchar(70) not null default 'Pending',
        pickup_time date,
        restaurant_id int,
        branch_id int,
        foreign key(branch_id, restaurant_id) references branch(id, restaurant_id)
    );
    
    create table if not exists order_items(
		id int,
        item_id int,
        restaurant_id int,
        branch_id int,
        foreign key(id) references orders(id),
        foreign key(item_id, restaurant_id, branch_id) references food_items(id, restaurant_id, branch_id),
        primary key(id, item_id)
    );
    create table if not exists rider(
		cnic varchar(12) primary key,
        name varchar(70),
        phone varchar(12),
        email varchar(70),
        ngo_id int,
        order_id int,
        foreign key(ngo_id) references ngo(id),
        foreign key(order_id) references orders(id)
    );
 COMMIT;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `displayFoodItems` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `displayFoodItems`(
    IN adminEmail varchar(70),
    IN itemStatus BOOLEAN
)
BEGIN
    DECLARE exit handler for sqlexception
    BEGIN
        -- ERROR
        ROLLBACK;
    END;
    
    DECLARE exit handler for sqlwarning
    BEGIN
        -- WARNING
        ROLLBACK;
    END;

    START TRANSACTION;

    SELECT 
        fi.id,
        fi.item_name,
        fi.item_description,
        r.name
    FROM 
        food_items fi
    JOIN 
        branch b ON fi.branch_id = b.id
    JOIN 
        branch_admin ba ON b.admin_id = ba.id
    JOIN 
        restaurant r ON b.restaurant_id = r.id
    WHERE 
        ba.email = adminEmail;

    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `displayRiderDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `displayRiderDetails`(
	IN adminEmail varchar(70)
)
BEGIN
	declare nid int;
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
    
		select ngo.id into nid from ngo join ngo_admin on ngo.admin_id = ngo_admin.id where ngo_admin.email = adminEmail;
        select cnic, name, phone, email from rider where ngo_id = nid;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `fetchLeftoversDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetchLeftoversDetails`()
BEGIN
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		select 
			restaurant.name, branch.id as "bid", branch.address, branch.city, branch.state, branch.phone, branch.email,
			branch.openingHours, food_items.item_name, food_items.item_description, leftovers.quantity, leftovers.best_before,
			leftovers.item_id
		from 
			leftovers join food_items on leftovers.item_id = food_items.id 
			and leftovers.restaurant_id = food_items.restaurant_id and leftovers.branch_id = food_items.branch_id
			join branch on leftovers.branch_id = branch.id and 
            leftovers.restaurant_id = branch.restaurant_id
			join restaurant on leftovers.restaurant_id = restaurant.id;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `fetchNGOLogin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetchNGOLogin`(
IN usrname varchar(70),
IN passw varchar(100),
OUT result int
)
BEGIN
 
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		select count(*) into result from ngo_admin where ngo_admin.email = usrname and admin_password = passw;
COMMIT;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `fetchStoreLogin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetchStoreLogin`(
IN usrname varchar(70),
IN passw varchar(100),
OUT result int
)
BEGIN
 
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		select count(*) into result from branch_admin where branch_admin.email = usrname and admin_password = passw;
COMMIT;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAddFoodItemNextIndex` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAddFoodItemNextIndex`(
	IN adminEmail varchar(70),
    OUT count int
)
BEGIN
	declare rid int;
    declare bid int;
    
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		set count = 0;
    
		select branch.restaurant_id, branch.id into rid, bid from branch_admin join branch on branch_admin.id = branch.admin_id where branch_admin.email = adminEmail;
		select count(*) into count from food_items group by restaurant_id, branch_id having food_items.restaurant_id = rid and food_items.branch_id = bid;
        
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `RegisterNGO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `RegisterNGO`(
	IN NGOName varchar(50),
    IN address varchar(300),
    IN city varchar(50),
    IN state varchar(100),
    IN phone varchar(12),
    IN emailID varchar(70),
    IN openingHours varchar(100),
    IN adminUsername varchar(70),
    IN NGOPassword varchar(100),
    IN adminPhone varchar(12),
    IN adminEmail varchar(70),
    OUT result boolean
)
    DETERMINISTIC
    COMMENT 'Register the records of the NGO'
BEGIN
	declare flag int default 0;
    
	DECLARE exit handler for sqlexception
		BEGIN
		 -- ERROR
			set result = true;
			ROLLBACK;
		END;
	   
	 DECLARE exit handler for sqlwarning
		BEGIN
		 -- WARNING
         set result = true;
			ROLLBACK;
		END;

	START TRANSACTION;
    
    insert into NGO_admin(username, admin_password, phone, email) values(adminUsername, NGOPassword, adminPhone, adminEmail);
    insert into NGO(NgoName, address, city, state, phone, email, openingHours, admin_id) values(NGOName, address, city, state, phone, emailID, openingHours, (select id from NGO_admin where NGO_admin.email = adminEmail));
 COMMIT;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `RegisterRestaurantStore` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `RegisterRestaurantStore`(
	IN RestaurantName varchar(50),
    IN bid int,
    IN address varchar(300),
    IN city varchar(50),
    IN state varchar(100),
    IN phone varchar(12),
    IN emailID varchar(70),
    IN openingHours varchar(100),
    IN adminUsername varchar(70),
    IN RestaurantPassword varchar(100),
    IN adminPhone varchar(12),
    IN adminEmail varchar(70),
    OUT result boolean,
    OUT admin_exist boolean
)
BEGIN
	declare flag int;
    declare flag2 int;
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;
	START TRANSACTION;
		set result = false;
        set admin_exist = false;
        
        select count(*) into flag from restaurant where name = RestaurantName;
        select count(*) into flag2 from branch_admin where branch_admin.email = adminEmail;
        
		-- admin email check
        if flag2 != 0 then
			set admin_exist = true;
		end if;
        
        if flag = 0 then 
			insert into restaurant(name) values(RestaurantName);
			insert into branch_admin(username, admin_password, phone, email) values(adminUsername, RestaurantPassword, adminPhone, adminEmail);
			insert into branch values(bid, address, city, state, phone, emailID, openingHours, (select id from restaurant where name = RestaurantName), (select id from branch_admin where branch_admin.email = adminEmail));
        else
			if (select count(*) from branch  where branch.restaurant_id = (select id from restaurant where name = RestaurantName) and branch.id = bid) = 1 then
				set result = true;
			else
				insert into branch_admin(username, admin_password, phone, email) values(adminUsername, RestaurantPassword, adminPhone, adminEmail);
				insert into branch values(bid, address, city, state, phone, emailID, openingHours, (select id from restaurant where name = RestaurantName), (select id from branch_admin where branch_admin.email = adminEmail));
			end if;
		end if;
        
 COMMIT;
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removeRider` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `removeRider`(
	IN rider_cnic varchar(12)
)
BEGIN
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		delete from rider
        where cnic = rider_cnic;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `showStoreOrders` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `showStoreOrders`(
	IN adminEmail varchar(70)
)
BEGIN
	declare bid int;
    declare rid int;
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		select branch.restaurant_id, branch.id into rid, bid from branch_admin join branch on branch_admin.id = branch.admin_id where branch_admin.email = adminEmail;
        
         select 
			o.id as "order_id", o.order_time, o.order_status, o.pickup_time, r.cnic,
            r.name as "rider_name", r.phone, ng.NgoName  
		 from 
			orders o join rider r on o.id = r.order_id join ngo ng on r.ngo_id = ng.id
        where o.restaurant_id = rid and o.branch_id = bid and o.order_status = 'Pending';
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateRiderByEmail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRiderByEmail`(
	IN rider_cnic varchar(12),
    IN newEmail varchar(70)
)
BEGIN
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		update rider
        set email = newEmail
        where cnic = rider_cnic;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateRiderByPhone` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRiderByPhone`(
	IN rider_cnic varchar(12),
    IN newPhone varchar(12)
)
BEGIN
	 DECLARE exit handler for sqlexception
	   BEGIN
		 -- ERROR
	   ROLLBACK;
	 END;
	   
	 DECLARE exit handler for sqlwarning
	  BEGIN
		 -- WARNING
	  ROLLBACK;
	 END;

	START TRANSACTION;
		update rider
        set phone = newPhone
        where cnic = rider_cnic;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-12 19:09:17
