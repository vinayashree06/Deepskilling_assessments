CREATE TABLE Customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(50),
  Age NUMBER,
  Balance NUMBER,
  IsVIP VARCHAR2(5)
);
INSERT INTO Customers VALUES (1, 'Vinaya', 65, 12000, 'FALSE');
INSERT INTO Customers VALUES (2, 'Vidya', 55, 8000, 'FALSE');
INSERT INTO Customers VALUES (3, 'Supriya', 70, 15000, 'FALSE');
INSERT INTO Customers VALUES (4, 'Sindhu', 40, 5000, 'FALSE');
INSERT INTO Customers VALUES (5, 'Varshu', 25, 6000, 'FALSE');
COMMIT;

CREATE TABLE Loans (
  LoanID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  InterestRate NUMBER,
  DueDate DATE
);

INSERT INTO Loans VALUES (101, 1, 10, SYSDATE + 10);  
INSERT INTO Loans VALUES (102, 2, 12, SYSDATE + 40);  
INSERT INTO Loans VALUES (103, 3, 9, SYSDATE + 20);   
INSERT INTO Loans VALUES (104, 4, 11, SYSDATE + 5);  
INSERT INTO Loans VALUES (105, 5, 13, SYSDATE + 10);
COMMIT;
--Scenario:1
DECLARE
  CURSOR cur_customers IS
    SELECT L.LoanID, L.InterestRate, C.Age
    FROM Loans L
    JOIN Customers C ON L.CustomerID = C.CustomerID
    WHERE C.Age > 60;

BEGIN
  FOR rec IN cur_customers LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE LoanID = rec.LoanID;
    DBMS_OUTPUT.PUT_LINE('Discount applied for Loan ID: ' || rec.LoanID);
  END LOOP;
  COMMIT;
END;
/
SELECT * FROM Loans;

--Scenario:2
DECLARE
  CURSOR cur_customers IS
    SELECT CustomerID, Balance FROM Customers;
BEGIN
  FOR rec IN cur_customers LOOP
    IF rec.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = rec.CustomerID;
      DBMS_OUTPUT.PUT_LINE('Promoted to VIP: Customer ID ' || rec.CustomerID);
    END IF;
  END LOOP;
  COMMIT;
END;
/
SELECT * FROM Customers;

--Scenario:3
DECLARE
  CURSOR cur_due_loans IS
    SELECT L.LoanID, L.DueDate, C.Name
    FROM Loans L
    JOIN Customers C ON L.CustomerID = C.CustomerID
    WHERE L.DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
  FOR rec IN cur_due_loans LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || ' for Customer ' || rec.Name ||
                         ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/
SELECT * FROM Loans;
