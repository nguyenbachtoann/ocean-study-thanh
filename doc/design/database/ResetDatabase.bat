@ECHO OFF
ECHO Step 1: Input the password of root to drop the database if it exited.
mysql -u root -p  < OceanStudy_Drop_Database.sql

ECHO Step 2: Input the password of root to create the database.
mysql -u root -p  < OceanStudy_Script_CreateDB_MySQL.sql

ECHO Step 3: Create tables for the database dailyreport...
mysql -u oceanstudy -pOceanStudy@123 oceanstudy < OceanStudy_Script_Table_MYSQL.sql