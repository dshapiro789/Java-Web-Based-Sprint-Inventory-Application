C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

Updates "mainscreen.html" as follows:

[Line 14]
BEFORE:
My Bicycle Shop

AFTER:
Dave's Discount Computer Parts

[Line 19]
BEFORE:
Shop

AFTER:
Dave's Discount Computer Parts

[Line 21]
BEFORE:
Parts

AFTER:
Shop Parts

______________________________________________


D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

- About.html: Creates new "About.html" page + [Line 25] adds brief company description
- mainscreen.html [Lines 20-22]: Adds navigation to About.html page.
- MainScreenControllerr.java [Lines 56-59]: Adds new method to handle requests to the "/about" endpoint
- About.html [Line 18-24]: Adds navigation link back to mainscreen.html

______________________________________________


E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

- BootStrapData.java [Lines 42-109]: Added 5 Parts, 5 Products (+ Price/Inventory)
- BootStrapData.java [Lines 42-80 + 88-99]: Amended code to troubleshoot

______________________________________________

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

- mainscreen.html [Lines 88-91] - Adds 'Buy Now' button form
- purchaseSuccessful.html - Created new HTML page
- purchaseError.html - Created new HTML page
- ProductService.java [Line 21] - adds method signature for decrementing inventory
- ProductServiceImpl.java [Lines 70-84] - adds new decrementInventory method
- MainScreenControllerr.java [Lines 32-36 + 58-68] - Amends existing controller method + Adds PostMapping for Buy Now button functionality

______________________________________________

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

- Part.java [Line 7] - adds the import for (Max) validation constraints
- Part.java [Lines 33-38] - creates new min and max inventory fields
- Part.java [Lines 46-47] - initializes new min/maxInv fields
- Part.java [Lines 63-78] - creates getters and setters for minInv and maxInv
- Part.java [Lines 34 + 37] - amended new min/max inventory fields
- BootStrapData.java [Lines 107-117] - sets minimum and maximum inventory levels
- BootStrapData.java [Lines 107] - removed new min/max inventory fields and moved to respective run method [Lines 50-51, 59-60, 68-69, 77-78, 86-87]
- InhousePartForm.html [Lines 24-26] - adds new minimum and maximum inventory inputs
- OutsourcedPartForm.html [Lines 25-27] - adds new minimum and maximum inventory inputs
- spring-boot-h2-db102.mv.db - Renamed file to "spring-boot-newdb.mv.db"
- application.properties [Line 6] - Renamed file path to "spring-boot-newdb.mv.db"
- Part.java [Line 37] - amended max inventory field (changed 10000 to 10001)
- Part.java [Lines 120-123] - adds new isInventoryValid method
- AddInhousePartController.java [Lines 45-49] - adds validation for the inventory level
- AddOutsourcedPartController.java [Lines 47-51] - adds validation for the inventory level
- OutsourcedPart.java [Line 18 + 21-25] - Calls constructors of Part 
- InhousePart.java [Line 18 + 21-25] - Calls constructors of Part + Initializes all fields, including inherited ones
- Part.java [Lines 46-47, 50, 54-55, 58, 63-64] - amended min/maxInv fields + added min/maxInv parameters
- mainscreen.html [Lines 41-42] - adds new column for min/max inventory
- mainscreen.html [Lines 51-52] - displays min/max inventory
- productForm.html [Lines 40-41] - creates headers for min/max inventory
- productForm.html [Lines 50-51] - creates new columns for min/max inventory
- productForm.html [Lines 78] - uncommented out the footer link back to mainscreen.html

______________________________________________

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

- AddInhousePartController.java [Lines 46-56] - checks if inventory is less than or exceeds min/max constraints
- AddOutsourcedPartController.java [Lines 47-57] - checks if inventory is less than or exceeds min/max constraints
- EnufPartsValidator.java [Lines 36-44] - Determines the potential new inventory level for the part + Adds constraint violation
- AddProductController.java [Lines 57-66] - modified Product2 assignment + try/catch statements
- AddProductController.java [Lines 84-100] - adds logic for inventory "too low" management

______________________________________________

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.





______________________________________________

J.  Remove the class files for any unused validators in order to clean your code.