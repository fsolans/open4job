Cliente para acceder remotamente a un EJB.

Cliente no autenticado
----------------------

Cliente autentificado
---------------------

En este caso, eliminamos los comentarios 

root@fsolans-ThinkPad-L430:~# cd /usr/java/wildfly-8.1.0.Final/bin/
root@fsolans-ThinkPad-L430:/usr/java/wildfly-8.1.0.Final/bin# ./add-user.sh 

What type of user do you wish to add? 
 a) Management User (mgmt-users.properties) 
 b) Application User (application-users.properties)
(a): b

Enter the details of the new user to add.
Using realm 'ApplicationRealm' as discovered from the existing property files.
Username : open4job
Password recommendations are listed below. To modify these restrictions edit the add-user.properties configuration file.
 - The password should not be one of the following restricted values {root, admin, administrator}
 - The password should contain at least 8 characters, 1 alphabetic character(s), 1 digit(s), 1 non-alphanumeric symbol(s)
 - The password should be different from the username
Password : 
JBAS015267: Password must have at least 1 non-alphanumeric symbol.
Are you sure you want to use the password entered yes/no? yes
Re-enter Password : 
What groups do you want this user to belong to? (Please enter a comma separated list, or leave blank for none)[  ]: 
About to add user 'open4job' for realm 'ApplicationRealm'
Is this correct yes/no? yes
Added user 'open4job' to file '/usr/java/wildfly-8.1.0.Final/standalone/configuration/application-users.properties'
Added user 'open4job' to file '/usr/java/wildfly-8.1.0.Final/domain/configuration/application-users.properties'
Added user 'open4job' with groups  to file '/usr/java/wildfly-8.1.0.Final/standalone/configuration/application-roles.properties'
Added user 'open4job' with groups  to file '/usr/java/wildfly-8.1.0.Final/domain/configuration/application-roles.properties'
Is this new user going to be used for one AS process to connect to another AS process? 
e.g. for a slave host controller connecting to the master or for a Remoting connection for server to server EJB calls.
yes/no? yes
To represent the user add the following to the server-identities definition <secret value="b3BlbjRqb2I=" />
root@fsolans-ThinkPad-L430:/usr/java/wildfly-8.1.0.Final/bin#