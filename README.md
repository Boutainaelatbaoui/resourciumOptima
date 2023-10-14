# Resourcium Optima JEE

## Description
Resourcium Optima is a powerful enterprise-level tool dedicated to optimizing talent and equipment management within companies. It empowers HR managers and supervisors with an intuitive interface to efficiently orchestrate tasks related to employees and equipment.

## Installation

Follow these steps to install and run Resourcium Optima JEE:

### Prerequisites

- **Java Development Kit (JDK)**: Make sure you have the JDK installed. You can download it [here](https://www.oracle.com/java/technologies/javase-downloads.html).

- **Java EE Application Server**: You'll need a Java EE application server. You can choose one of the following options:

    - **WildFly**: A powerful and lightweight Java EE server. Download and install it [here](https://www.wildfly.org/).

    - **Payara**: An open-source Java EE application server. Download and install it [here](https://www.payara.fish/).

    - **GlassFish**: The reference implementation for Java EE. Download and install it [here](https://javaee.github.io/glassfish/).

    - **Apache Tomcat**: A popular servlet container that can also support Java EE. Download and install it [here](http://tomcat.apache.org/).

- **Git**: Install Git on your machine if it's not already installed. You can download it [here](https://git-scm.com/).

### Clone the Project

1. Open your terminal or command prompt.

2. Navigate to the directory where you want to clone the project.

3. Run the following command to clone the project repository:
   ```shell
   git clone https://github.com/yourusername/resourcium-optima-jee.git

### Configure persistence.xml
Locate the persistence.xml file: It is typically found in the src/main/resources/META-INF directory.

Open persistence.xml in a text editor.

Update the database connection properties to match your database configuration:
```XML
  <property name="javax.persistence.jdbc.url" value="jdbc:mysql://your-database-host:your-database-port/your-database-name"/>
  <property name="javax.persistence.jdbc.user" value="your-database-username"/>
  <property name="javax.persistence.jdbc.password" value="your-database-password"/>
Replace the placeholders with your actual database details.

Save the persistence.xml file.

### Build and Deploy
Use your chosen Java EE application server (WildFly, Payara, GlassFish, or Apache Tomcat) to build and deploy the project. The exact steps will depend on the server you're using.

Access the application via the provided URL from your application server.

### Technologies
Resourcium Optima JEE leverages a stack of modern technologies:

Java EE (Enterprise Edition): A set of specifications extending Java SE for enterprise applications.

Java Persistence API (JPA): A Java specification for managing data between Java objects and relational databases.

Maven: A build automation tool for managing project dependencies.

Servlets: Java classes to extend the capabilities of servers hosting applications.

JavaServer Pages (JSP): A technology for creating web pages based on dynamic content.

Apache Tomcat: A popular servlet container with Java EE support.

Git: A distributed version control system used for tracking changes in source code during development.

MySQL (or your preferred database system): A relational database management system.

Resourcium Optima JEE is designed to provide seamless talent and equipment management capabilities for enterprises, with robust and scalable technologies at its core.
