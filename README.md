Adyapana Institute Management System
Overview
The Adyapana Institute Management System is designed to streamline and automate various processes at the Adyapana Institute, which currently serves over 2500 students who have completed their Advanced Levels in the Science stream. This system aims to enhance the management of student registration, subject registration, teacher enrollment, payment processing, class registration, attendance tracking, and reporting.

Features
Entity Relationship Diagram (ERD): Visual representation of the data model based on the requirements.
Business Process Diagram: Overview of the key processes involved in the system.
Use Case Diagram: Identification of the interactions between users and the system.
Wireframes: Visual design of the user interface for various functionalities.
Reports: Generation of necessary reports for management and administrative purposes.
Functional Requirements
The system will include the following functionalities:

Student Management:
Add, update, delete, and search for student records.
Teacher Management:
Add, update, delete, and search for teacher records.
Subject Management:
Add, update, delete, and search for subjects.
Class Registration:
Manage class registrations and student enrollments.
Attendance Tracking:
Record and view student attendance for each class.
Payment Processing:
Add, update, and search for payment records.
Generate invoices for payments.
Reporting:
Search due lists by class and student.
Generate various reports for management.
Database Schema
The following tables will be implemented in the database:

Student:

Sno (Student Number)
Name (Student Name)
Address (Student Address)
dob (Date of Birth)
Teacher:

Tno (Teacher Number)
Name (Teacher Name)
Address (Teacher Address)
subjects (Subjects taught by the teacher)
Subject:

Subno (Subject Number)
Description (Subject Description)
Price (Subject Price)
Class:

ClassNo (Class Number)
subNo (Subject Number)
Tno (Teacher Number)
timeslot (Class Time Slot)
Invoice:

Sno (Student Number)
Tno (Teacher Number)
Subno (Subject Number)
month (Invoice Month)
Value (Invoice Amount)
