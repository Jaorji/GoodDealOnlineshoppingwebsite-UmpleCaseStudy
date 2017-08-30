# GoodDealOnlinshoppingwebsite-UmpleCaseStudy
This is a demo project using Umple which is a model build and code generation tool.


# What's UMPLE?
Umple is a modeling tool and programming language family to enable what we call Model-Oriented Programming. It adds abstractions such as Associations, Attributes and State Machines derived from UML to object-oriented programming languages such as Java, C++, PHP and Ruby. Umple can also be used to create UML class and state diagrams textually.
Umple is an open source project, so details will evolve. However, it is ready to be used for real systems. In fact the Umple compiler itself is written in Umple. Any Java, C++ or PHP project could use Umple. We have found the resulting code to be more readable and have many fewer lines. This is because Umple means you can avoid having to code a lot of 'boilerplate' code that would be needed to implement associations and attributes, a system based on Umple should also be less bug-prone.
Umple has also been found to help students learn UML faster in the classroom.

# What's the project's requirement?
Using Umple to design and develop an online shopping website. This website is divided into two parts: Member Part and Manager Part.
| ID | requirment |
|----| -----------|
| 3 .| 123456 .   |


Visitors can look through the goods’ basic information, but they cannot see the detail.
 RQ002:Registration
 Visitors need register to be a member of this website in order to buy goods. When a visitor register, he needs input his member user name, password, confirm password, birthday, profession, email address, a question in case he loses the password and the answer related to the question.
 RQ003: Log in
Members need log in to have access to this website. When he logs in, he needs input his user name and password. 
RQ004: Log out
If members want to leave the website, they can click the log out button and there will be a pop out window confirmation.
RQ005: Recovering Password
If a member forgets his password, he can visit recovering password page. In this page the member needs input his user name and get his questions which he set when he registered. If he forget his answer, he need send email to the manager of this website.
RQ006: Adding goods to the shopping cart
If a member is interested in some goods and wants to buy them, he can add them to his cart. They can also specify the quantity as well.
RQ007：Modifying shopping cart
The member can check his cart and make some changes. He can change the quantity of goods he wants to buy, he can clear the cart, he can choose to continue shopping, or he can make a payment.
RQ008: Making a payment
When the cart is ready, a member can choose to make a payment. There will be an order code shown automatically. At the meantime, a member should provide the mail address, email address, and contact number. Then he needs to choose the payment method. There will be three payment method: Visa, Master card, and debit. There will be three post method: UPS, Canada post, EMS. Members can leave a message for each order.
RQ009: Checking shipping status of an order
A member can check if his order is shipped or not. 
RQ010 : Checking details of an order
A member can see the order he did. And he can choose to see the detail of the order. 
RQ011:Check member’s profile
A member can check his profile, all information is what he provided when he registered. 
RQ012：Modifying profile
A member can do some changes to his profile and then save it.
Manager Part:
The website has a manager side. There should be one admin manager at least. Other managers can be added to the system. Every manager should use their own user name and password to log in.
Requirement
Title 
Description
RQ013
Managing admin users
A manager must be able to modify other admin users
RQ014
Managing members
A Manager must be able to modify members
RQ015
Managing goods
A manager must be able to modify goods
RQ016
Managing types
A manager must be able to modify types
RQ017
Managing brands
A manager must be able to modify brands
RQ018
Managing orders
A manager must be able to modify orders

RQ013: Managing admin users 
The manager can add manager and delete manager. When he adds a new manager, he should set his name, user name, and password.
RQ014：Managing members
The manager can check the detail information of members and can delete them.
RQ015: Managing goods
The manager can see the detail information of goods and can delete or add goods, at the meantime can decide if it is on sale price or not. When add goods information, the manager need choose the type and brand, add the name of the goods and manufacturers, upload the pictures, set the price and add description.
The sale price should be defaulted to 0 for all the new products, but if the manager want to set sale price, the manager need check the detail of the goods and set it as on sale and then give it a sale price.
RQ016: Managing types
The manager can check the type and can delete or add the type.
•	RQ017: Managing brands
The manager can check the brand and can delete or add the brand.
RQ018: Managing orders
The manager can check all the orders’ information and can check every order’s detail. The manager can decide if the order is shipped or not and can delete the order.
UML design:


 


