@ECHO OFF

ECHO Adding: Create data for the database oceanstudy...
mysql -u oceanstudy -pOceanStudy@123 oceanstudy < OceanStudy_Script_StaticData.sql