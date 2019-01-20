CREATE DATABASE PfadfinderDB;

CREATE TABLE Resource (
	id varchar(32),
	name varchar(128) not null,
	info text,
	primary key(id)
	);
	
CREATE TABLE Event (
	id varchar(32),
	startdate date not null check(startdate >= CURRENT_DATE),
	enddate date not null check(enddate >= startdate),
	name varchar(128) not null,
	info text,
	primary key(id)
	);
	
CREATE TABLE Leader (
	id varchar(32),
	name varchar(128) not null,
	primary key(id)
	);
	
CREATE TABLE Groups (
	id varchar(32),
	membercount int check (membercount >= 1),
	primary key(id)
	);
	
CREATE TABLE Task ( 
	id varchar(32),
	name varchar(128) not null,
	duedate date check(duedate >= CURRENT_DATE),
	info text,
	primary key(id)
	);

CREATE TYPE accept AS ENUM('false', 'unknown', 'true');
	
CREATE TABLE Invitation (
	id varchar(32),
	accepted accept not null,
	eventId varchar(32),
	leaderId varchar(32),
	foreign key(eventId) references Event(id) on delete cascade,
	foreign key(leaderId) references Leader(id) on delete cascade,
	primary key(id)
	);
	
CREATE TABLE uses (
	resourceId varchar(32),
	eventId varchar(32),
	foreign key(resourceId) references Resource(id) on delete cascade,
	foreign key(eventId) references Event(id) on delete cascade,
	primary key(resourceId, eventId)
	);
	
CREATE TABLE isPartOf (
	leaderId varchar(32),
	groupId varchar(32),
	foreign key(leaderId) references Leader(id) on delete cascade,
	foreign key(groupId) references Groups(id) on delete cascade,
	primary key(leaderId, groupId)
	);
	
CREATE TABLE assigned (
	leaderId varchar(32),
	taskId varchar(32),
	foreign key(leaderId) references Leader(id) on delete cascade,
	foreign key(taskId) references Task(id) on delete cascade,
	primary key(leaderId, taskId)
	);
	

	

	
	