# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

## SUPPLEMENTAL RESOURCES  
1.	How to clone a project to IntelliJ using Git?

> Ensure that you have Git installed on your system and that IntelliJ is installed using [Toolbox](https://www.jetbrains.com/toolbox-app/). Make sure that you are using version 2022.3.2. Once this has been confirmed, click the clone button and use the 'IntelliJ IDEA (HTTPS)' button. This will open IntelliJ with a prompt to clone the proejct. Save it in a safe location for the directory and press clone. IntelliJ will prompt you for your credentials. Enter in your WGU Credentials and the project will be cloned onto your local machine.  

2. How to create a branch and start Development?

- GitLab method
> Press the '+' button located near your branch name. In the dropdown list, press the 'New branch' button. This will allow you to create a name for your branch. Once the branch has been named, you can select 'Create Branch' to push the branch to your repository.

- IntelliJ method
> In IntelliJ, Go to the 'Git' button on the top toolbar. Select the new branch option and create a name for the branch. Make sure checkout branch is selected and press create. You can now add a commit message and push the new branch to the local repo.

## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!





## SEE PROJECT INSTRUCTIONS/REQUIREMENTS BELOW FOR THE "D287 PERFORMANCE ASSESSMENT: JAVA FRAMEWORKS (ALN2)"



COMPETENCIES

4084.1.1 : Implements User Interfaces The learner implements user interfaces.

4084.1.2 : Implements Frameworks The learner implements object-oriented programming frameworks.

INTRODUCTION

Throughout your career in software design and development, you will be asked to create, customize, and maintain applications with various features and functionality based on business requirements. For this assessment, you will customize a Spring Framework application with an HTML front-end and a Java backend using the solution statements provided in the requirements section of this assessment.

The skills you showcase in your completed application will be useful in responding to technical interview questions for future employment. This application may also be added to your portfolio to show to future employers.

For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how to do this. You will also use the GitLab link in the web links section to obtain the template code for this project, please review the “GitLab How-To” web link prior to starting your work. Next, you will clone your GitLab repository and open it in IntelliJ IDEA (Ultimate Edition).

SCENARIO

You are working for a company that licenses and customizes a software application to keep track of inventory in stores. Your job as a software developer is to customize this application to meet a specific customer’s needs. You will choose any type of customer you would like, but it must sell a product composed of parts. An example of products versus parts would be a customer that’s a bicycle shop: a bicycle is a product, and a set of two matching wheels is a part (do not use the bicycle shop example in your project).

You have been provided with a Spring application with a Java backend, a generic HTML user interface to use in the design and development of the system, and a UML class diagram to assist you in your work (see the attached “UML Class Diagram”). You can find a user guide to help assist with the inventory management application in the attachments (see “Shop Inventory Management User Guide”).

REQUIREMENTS

Your submission must be your own original work. You may not use or reference other students’ submissions for this task. For more information please review our Academic Authenticity policies and the Professionalism and Conduct Expectations for College of Information Technology Students.

You must use the rubric to direct the creation of your submission because it provides detailed criteria that will be used to evaluate your work. Each requirement below may be evaluated by more than one rubric aspect. The rubric aspect titles may contain hyperlinks to relevant portions of the course.

Tasks may not be submitted as cloud links, such as links to Google Docs, Google Slides, OneDrive, etc., unless specified in the task requirements. All other submissions must be file types that are uploaded and submitted as attachments (e.g., .docx, .pdf, .ppt).

Note: External plugins and libraries other than those specified in this task are not allowed.

Note: You cannot use a bicycle shop as a customer for your submission.

A.  Create your subgroup and project by logging into GitLab using the web link provided and using the “GitLab How-To” web link, and do the following: •  Clone the project to the IDE. •  Commit with a message and push when you complete each of the tasks listed below (e.g., parts C to J).  Note: You may commit and push whenever you want to back up your changes, even if a task is not complete.  •  Submit a copy of the Git repository URL and a copy of the repository branch history retrieved from your repository, which must include the commit messages and dates.  Note: Wait until you have completed all the following prompts before you create your copy of the repository branch history. 

B.  Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change. 

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.  Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required. 

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen. 

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database. 

Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part. 

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters: •  The “Buy Now” button must be next to the buttons that update and delete products. •  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts. •  Display a message that indicates the success or failure of a purchase. 

G.  Modify the parts to track maximum and minimum inventory by doing the following: •  Add additional fields to the part entity for maximum and minimum inventory. •  Modify the sample inventory to include the maximum and minimum fields. •  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values. •  Rename the file the persistent storage is saved to. •  Modify the code to enforce that the inventory is between or at the minimum and maximum value. 

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following: •  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts. •  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum. •  Display error messages when adding and updating parts if the inventory is greater than the maximum. 

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package. 

J.  Remove the class files for any unused validators in order to clean your code. 

K.  Demonstrate professional communication in the content and presentation of your submission.
