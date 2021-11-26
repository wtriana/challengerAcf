create database test_acf;
\c test_acf

create table customers(
	 id SERIAL PRIMARY KEY,
	 "customerId" varchar(20) unique,
	 "firstName" varchar(50) NOT NULL,
	 "surName" varchar(50) NOT NULL,
	 "custAge" integer NOT NULL,
	 "creationDate" timestamp WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);