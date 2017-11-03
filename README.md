"# IpTable"

This application is created to store data in database about all IP addresses and 
assosiated with them devices in the organization. Organization can have several 
departments, subnets and different types of devices like computers, routers,
printers etc. Also, departments can have subdepartments.
This application allows to filter data by departments, subnets and types of devices.
You can find any IP address using search by IP address or computer name or username.
This application is multiusers system and integrated with Microsoft Active Directory. 
All changes that users make log into the database and everybody can see history of made 
changes of all users. 

History of changes:

- Add separation on subdepartments in Office department.
- Add validation on uniqueness of computer name.
- Add pagination to history view.
- Add search by username when username has both firstname and lastname in the field. 
- Add search by IP address to history view.
- Add departments: Cherkassy, Orlik.
- Add method that returns list of IP addresses as a result of searching.
- Add validation on changing fields like Department, Subnet, DeviceType in Add/Edit view.
 

 
 