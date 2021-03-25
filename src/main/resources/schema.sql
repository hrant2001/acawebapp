CREATE TABLE applicants (
                        applicant_id int AUTO_INCREMENT  PRIMARY KEY,
                        applicant_name varchar(40) NOT NULL,
                        email varchar(20) NOT NULL,
                        phone_number varchar(13) NOT NULL,
                        address varchar(30) NOT NULL,
                        status varchar(15) NOT NULL
);

CREATE TABLE courses (
                            course_id int AUTO_INCREMENT  PRIMARY KEY,
                            course_name varchar(40) NOT NULL,
                            start_date varchar(10) NOT NULL,
                            end_date varchar(10) NOT NULL,
                            teacher_name varchar(35) NOT NULL,
                            description varchar(50) NOT NULL
);