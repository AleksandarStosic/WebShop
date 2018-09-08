-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: eisbooks
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `barcode` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `id_category` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  KEY `FK_f0xxa3qf34dd841p1r0b780us` (`id_category`),
  CONSTRAINT `FK_f0xxa3qf34dd841p1r0b780us` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,' Daniel Arenson',1,'Requiem. A forbidden word. The name of a lost kingdom, the homeland of dragons. Yet there are some who remember Requiem, who will fight to see it rise again . . . ','F1.jpg','       Requiem for Dragons',2,18,5),(3,'by TMS, Inc',2,'Eligible for FREE SHIPPING','G1.jpg','Pen is Mightier Than the Sword Resin Pen Cup',4,9,7),(4,'Oxford University ',3,'Featuring an exceptionally clear writing style and a wealth of real-world examples and exercises, Logic, Third Edition, shows how logic relates to everyday life','T1.jpg','Logic / Edition 3',20,32,1),(5,'Meredith Costain, Polona Lovsin (Illustrator)',4,'Daddies are awesome! They\'re warm and delicious. They tickle and hug you and shower you with kisses. Loving and thoughtful, playful and daring, cuddly and caring--daddies are awesome. ','K1.jpg','Daddies Are Awesome',6,60,2),(6,'by eeBoo',5,'Warning: Choking Hazard-Small parts. Not for Children under 3 years of age','TO1.jpg','Alphabet & Numbers Puzzle Pairs',16,20,6),(7,'Kevin Phillips',6,'In 1775, iconoclastic historian and bestselling author Kevin Phillips punctures the myth that 1776 was the watershed year of the American Revolution.','H1.jpg','1775: A Good Year for Revolution',10,36,4),(8,'Leigh Bardugo',7,'The highly anticipated, entirely new coming-of-age story for the world\'s greatest super hero: WONDER WOMAN by the # 1 New York Times bestselling author LEIGH BARDUGO.','TE1.jpg','Wonder Woman: Warbringer (Signed Book)',20,63,3),(9,'Sarah J. Maas',8,'Celaena Sardothien, heroine of the New York Times bestselling series, rises from the ashes to burn even brighter than before.  Celaena has survived deadly contests and shattering heartbreak-but at an unspeakable cost.','TE2.jpg','Heir of Fire (Throne of Glass Series #3)',15,72,3),(10,' David Rock, Linda J. Page',9,'Foundations for Practice  David Rock and Linda J. Page, PhD  Discover the science behind brain-based coaching','T2.jpg','Coaching with the Brain in Mind',48,11,1),(11,'David Rock',10,'Improving the performance of your employees involves one of the hardest challenges in the known universe: changing the way they think. In constant demand as a coach, speaker','T3.jpg','Quiet Leadership',18,27,1),(12,'Stephen Lucas',11,'The Art of Public Speaking personalizes learning for every student no matter who they are or where they are, ensuring that they come to your public speaking class confident,','T4.jpg','The Art of Public Speaking',27,27,1),(13,' Jon Gordon, Jeremy Schaap',12,'Great teammates dont just impact you today; they impact you for the rest of your life.','T5.jpg','The Hard Hat',17,32,1),(14,'Kobi Yamada',13,'\"What do you do with a problem? Especially one that follows you around and doesn\'t seem to be going away? Do you worry about it? Ignore it? Do you run and hide from it?','K2.jpg','What Do You Do With a Problem?',10,41,2),(15,'Elena Favilli, Francesca Cavallo',14,'ood Night Stories For Rebel Girls reinvents fairy tales with a collection of 100 bedtime stories about the life of 100 extraordinary women, from Elizabeth I to Serena Williams. ','K3.jpg','Good Night Stories for Rebel Girls',35,45,2),(16,'Rebecca Langston-George, Janna Bock (Illustrator)',15,'She grew up in a world where women were supposed to be quiet. But Malala Yousafzai refused to be silent. She defied the Taliban\'s rules, spoke out for education for every girl, and was almost killed for her beliefs.','K4.jpg','For the Right to Learn',12,11,2),(17,'Jacqueline Woodson',16,'A New York Times Bestseller and National Book Award Winner  Jacqueline Woodson, the acclaimed author of Another Brooklyn, tells the moving story of her childhood in mesmerizing verse. ','K5.jpg','Brown Girl Dreaming',14,22,2),(18,'Sarah J. Maas',18,'Chaol Westfall has always defined himself by his unwavering loyalty, his strength, and his position as the Captain of the Guard. But all of that has changed since the glass castle shattered, since his men were See more details below','TE3.jpg','Tower of Dawn (B&N Exclusive Edition)',15,52,3),(19,'Morgan Rhodes',17,'       Immortal Reign (Falling Kingdoms Series #6) by Morgan Rhodes    See All Formats & Editions As two lethal elemental gods set out to destroy Mytica, sworn enemies must become allies in the final fight to save the kingdoms. ','TE4.jpg','Immortal Reign',18,67,3),(20,'Kendare Blake',19,'This exclusive signed Barnes & Noble edition features extra material from Kendare Blake that Three Dark Crowns fans will devour: a bonus scene with Katharine and Pietyr.','TE5.jpg','       One Dark Throne',13,100,3),(21,'Tzu Sun, Ralph D. Sawyer',20,'The Art of War is almost certainly the most famous study of strategy ever written and has had an extraordinary influence on the history of warfare','H2.jpg','The Art of War',10,70,4),(22,'Isaac Asimov',21,'With these three, simple directives, Isaac Asimov changed our perception of robots forever ','F2.jpg','I, Robot',15,200,5),(23,'Dan Simmons',22,'On the world called Hyperion, beyond the law of the Hegemony of Man, there waits the creature called the Shrike. There are those who worship it. ','F3.jpg','       Hyperion',25,100,5),(24,'H. G. Wells, Alfred Mac Adam (Introduction)',23,'The War of the Worlds, by H. G. Wells, is part of the Barnes & Noble Classics series, which offers quality editions at affordable prices to the student and the general reader, including new scholarship,','F4.jpg','War of the Worlds',10,68,5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-14 13:28:48
