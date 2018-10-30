Create database oceanstudy default character set utf8;
drop user if exists oceanstudy@localhost;
CREATE USER oceanstudy@'localhost' IDENTIFIED BY 'OceanStudy@123';
GRANT ALL PRIVILEGES ON oceanstudy.* TO oceanstudy@localhost WITH GRANT OPTION;