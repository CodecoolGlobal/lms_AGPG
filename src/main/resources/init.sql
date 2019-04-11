DROP TABLE IF EXISTS assignments CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS answers CASCADE;
DROP TABLE IF EXISTS textpage CASCADE;
DROP TABLE IF EXISTS attendance CASCADE;

CREATE TABLE assignments (
    assignment_id SERIAL PRIMARY KEY,
    published boolean NOT NULL,
    assignment_date date ,
	question varchar NOT NULL,
	max_point INTEGER NOT NULL,
    mentor_id INTEGER NOT NULL
);

CREATE TABLE attendance (
    user_id INTEGER,
    date_att date
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_name TEXT NOT NULL,
    email varchar NOT null,
    user_password varchar NOT null,
	ismentor boolean NOT NULL
);

CREATE TABLE answers (
    assignment_id INTEGER NOT NULL,
    student_id INTEGER NOT null,
    answer TEXT NOT NULL,
    grade INTEGER NOT NULL
);

CREATE TABLE textpage (
    textpage_id SERIAL NOT NULL,
    textpage_title varchar,
    textpage_value text,
    ispublished boolean NOT NULL
);



INSERT INTO users (user_name, email, user_password, isMentor) VALUES
	('Balogh Joli','user1@user1', 'user1', true), -- 1
	('Kovács Pilu','user2@user2', 'user2', false), -- 2
	('Kalács Ede', 'user3@user3', 'user3', false),
    ('Zombori Gizi', 'user4@user4', 'user4', false),
    ('Puma Ottó', 'user5@user5', 'user5', true),
    ('Ali Baba', 'user6@user6', 'user6', false),
    ('Kanalas Etelka', 'user7@user7', 'user7', false); -- 3

INSERT INTO assignments (published, assignment_date, question, max_point, mentor_id) VALUES
	(true, null, 'What is Inheritance?', 5, 1),
    (true, null, 'WHat is Polymorphism?', 5, 5),
    (false, null, 'What is Abstraction?', 5, 1),
    (true, null, 'What is Encapsulation?', 5, 1);

INSERT INTO answers (assignment_id, student_id, answer, grade) VALUES
	(1, 4, 'Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another. With the use of inheritance the information is made manageable in a hierarchical order. The class which inherits the properties of other is known as subclass (derived class, child class) and the class whose properties are inherited is known as superclass (base class, parent class).', 2),
	(2, 2, 'Polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.', 1),
    (1, 7, 'As per dictionary, abstraction is the quality of dealing with ideas rather than events. For example, when you consider the case of e-mail, complex details such as what happens as soon as you send an e-mail, the protocol your e-mail server uses are hidden from the user. Therefore, to send an e-mail you just need to type the content, mention the address of the receiver, and click send. Likewise in Object-oriented programming, abstraction is a process of hiding the implementation details from the user, only the functionality will be provided to the user. In other words, the user will have the information on what the object does instead of how it does it. In Java, abstraction is achieved using Abstract classes and interfaces.', 2),
	(3, 6, 'In Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit. In encapsulation, the variables of a class will be hidden from other classes, and can be accessed only through the methods of their current class. Therefore, it is also known as data hiding. ', 1);

INSERT INTO textpage (textpage_title, textpage_value, ispublished) VALUES
	('Interpreted vs. compiled', 'Python: Youve learned Python, which is an interpreted language. This means that when you run python3 main.py the Python interpreter on-the-fly "interprets" (read line-by-line and analyzed) your Python source code and translate thats to machine code (CPU specific sequences of 0s and 1s - CPU specific meaning, it can be specific to 32bit or 64bit architectures, it can be x86, ARM, etc.). This happens on-the-fly, Python doesnt read your whole script at once only what it needs to execute the first few executable lines in your code (stuff like print() for example). Java: Java is compiled language. This means that contrary to Pythons way of doing things with Java you dont just run your code. You compile, then run. The Java compiler reads your whole Java source file (or files) and analyzes whats in that to check if syntactically correct: every variable is used as it should be, etc. we ll take a look at this later.', true),
	('Getters and Setters', 'Now after this little example, heres what the best practices concerning getters and setters. Always create private instance fields. Dont ever create getters and setters. Easy to follow, eh? Now theres more to this of course. Because sometimes it makes sense to not create private fields or to create setters. Heres an extended version ... but first, see if the first one works for you, if it does, cool! Always create private instance fields. Or protected (only super-classes) if you want child-classes access to have access to these fields. Dont ever create getters and setters. If you happen to notice that you need access to a particular field from outside the class create a getter and only that. If you happen to notice that you need to change a particular fieldss value from outside the class create a setter too ... but this is rarely needed. For example in the above example I might have created a field for size and a getter for it, if I want to have access to this information from the outside.', true),
	('Encapsulation (data hiding)', 'Encapsulation is the technique of making the fields in a class private and providing access to the fields via public methods. If a field is declared private, it cannot be accessed by anyone outside the class, thereby hiding the fields within the class. A Java access modifier specifies which classes can access a given class and its fields, constructors and methods. Access modifiers can be specified separately for a class, its constructors, fields and methods. Classes, fields, constructors and methods can have one of four different. Java access modifiers: private, default (package private), protected, public', true),
	('Polymorphism', 'Polymorphism means "one name, many forms". Polymorphism manifests itself by having multiple methods all with the same name, but slightly different functionality. Polymorphism in Java has two types: Compile time polymorphism (static binding) Runtime polymorphism (dynamic binding or late binding). Method overloading is an example of static polymorphism, while method overriding is an example of dynamic polymorphism. Method overloading Method overloading means there are several methods present in a class having the same name but different types/order/number of parameters. At compile time, Java knows which method to invoke by checking the method signatures. So, this is called compile time polymorphism or static binding. Method overriding Suppose a sub-class overrides a particular method of the super-class. Let’s say, in the program we create an object of the sub-class and assign it to the super-class reference. Now, if we call the overridden method on the super-class reference then the sub-class version of the method will be called. As the method to call is determined at runtime, this is called dynamic binding or late binding.', true),
	('Abstraction', 'Abstraction is a process of hiding the implementation details. We will have the information on what the object does instead of how it does it. Abstraction in Java is achieved by using interfaces and abstract classes. An interface or abstract class is something which is not concrete, something which is not implemented. Abstract classes and methods A Java abstract class is a class which cannot be instantiated, meaning you cannot create new instances of an abstract class. The purpose of an abstract class is to function as a base for sub-classes. Interfaces  A Java interface is a bit like a class, except a Java interface can only contain method signatures and fields. A Java interface cannot contain an implementation of the methods, only the signature (name, parameters and exceptions) of the method.', true),
	('HTML / CSS / JS: HTML, the wire-frame of the web', 'Probably you already met with these 3 fellows, HTML, CSS and JavaScript. HTML describes the structure of the websites, CSS gives a nice styling to them (like fonts, paragraphs, colors,..) and JavaScript can perform client-side logic to do stuff (for example animated menus, video players, clickable maps,..). Now, we will only take a look on HTML in this SI week. Note: Please dont use any visual site creator. As the tutorial also warns about it, they usually add non-standard, hard to understand stuff into your code. Also you do not learn the most important part - how it works doing so. Professionals dont use Dreamweaver! ;)', true),
	('Web? Tomcat?', 'Tomcat is an application server from the Apache Software Foundation that executes Java servlets and renders Web pages that include Java Server Page coding. Described as a "reference implementation" of the Java Servlet and the Java Server Page specifications. If you are developing a web application something like Codecool.hu . This app should be accessible to the out side world through the Internet or Intranet. So you develop application in your system. To access your application to the outside world you need a server. That server can be your Apache Tomcat. To access the application from the outside world, it needs HTTP protocol so all this HTTP protocol are implemented inside Tomcat Server. So it automatically take care of handling "Request" and "Response".', true);


INSERT INTO attendance (user_id, date_att) VALUES
    (1,'2019-04-09'),
    (2,'2019-04-09'),
    (3,'2019-04-09');

ALTER TABLE assignments
    ADD CONSTRAINT mentor_id FOREIGN KEY (mentor_id) REFERENCES users;
ALTER TABLE answers
    ADD CONSTRAINT assignment_id FOREIGN KEY (assignment_id) REFERENCES assignments;
ALTER TABLE answers
    ADD CONSTRAINT student_id FOREIGN KEY (student_id) REFERENCES users;
ALTER TABLE attendance
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES users;
