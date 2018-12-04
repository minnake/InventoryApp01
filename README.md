# Inventory App, Stage 1 

Project Overview 

This project is the first part of a 2 stage project where you'll create a single amazing app that will pull together many of the components you've learned in this Nanodegree program! 

In this project, you'll design and create the structure of a Inventory App that will allow a store to keep track of its inventory of products. The app will need to store information about the product and allow the user to track sales and shipments and make it easy for the user to order more from the listed supplier. 

We will split the development of this app in two stages. Let's talk about Stage 1. 

In this stage you’ll focus on what happens behind the scenes, practicing how to design and implement a simple database. Note: This stage of the project will not have any UI components 

Why this project? 

In the most recent portion of the Nanodegree program, you learned about data storage in Android, using both SQLite tables and file storage on the device. These skills let you build apps which are critical to small businesses worldwide. By practicing these skills and building this app, you will have the foundation to build similar apps for any kind of business. 

What will I Iearn? 

This project is about combining various ideas and skills we’ve been practicing throughout the course. They include: 

* Creating a SQLite table in your app 
* Populating that table with new entries 
* Modifying the entries 
* Displaying the contents of the table to users. 

Note: As the focus of this program is Java, only projects completed with Java as the source code will be accepted. Projects using Kotlin as the source code will not be accepted. 

Build Your Project 

For this project, you’ll be setting up and using the database schema for an Book Store App. This project will not have any UI components; instead, you will focus on what happens behind the scenes, practicing how to design and implement a simple database. Remember to include a subclass of SQLiteOpenHelper and a Contract. 

First, define and setup up the database schema (i.e. table and columns) that can be used to keep track of product inventory. The app will need to store information about the product name, price, quantity, supplier name, and supplier phone number. It is up to you to decide what datatype (e.g. INTEGER, STRING) each of these values should be; however, it is required that there are at least 2 different datatypes (e.g. INTEGER, STRING). 

The fields in the table below are required, but you may choose to add additional information if you would like: 

Table that stores information about the product name, price, quantity, supplier name, and supplier phone number.  

Define and setup up the database schema store information about the product name, price, quantity, supplier name, and supplier phone number. 

Then, create 2 methods that insert and read data to/from your database. These 2 methods can all be contained in a single Java file. 

The single insert method that adds at least two values of two different datatypes (e.g. INTEGER, STRING) into the database using a ContentValues object and the insert() method. 

Note: Even though UI is not required for this Stage, we highly recommend that you test your insert/read methods with log calls or displaying the data in a TextView. Often, students do not realize their code has SQL syntax errors until the app is run and the methods are called. 
