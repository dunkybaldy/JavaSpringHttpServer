## AWS Relational Database Setup and Management

### Setup
[Medium article](https://medium.com/@ryanzhou7/connecting-a-mysql-workbench-to-amazon-web-services-relational-database-service-36ae1f23d424)
by Ryan Zhou

Describes Inbound connections through the default Virtual Private Cloud environment problems because it
initially allows connection from a very specific address.

To fix and check available accessible from IP addresses:

Beware that every new location you want to access this database from will be required to add or change this value in the security group

>EC2 > Security Groups > Edit Inbound Rules > Source