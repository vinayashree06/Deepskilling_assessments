CREATE TABLE SavingsAccounts (
  AccountID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  Balance NUMBER
);
INSERT INTO SavingsAccounts VALUES (201, 1, 1000);
INSERT INTO SavingsAccounts VALUES (202, 2, 2000);
INSERT INTO SavingsAccounts VALUES (203, 3, 3000);
COMMIT;
CREATE TABLE Employees (
  EmployeeID NUMBER PRIMARY KEY,
  Name VARCHAR2(50),
  Department VARCHAR2(50),
  Salary NUMBER
);
INSERT INTO Employees VALUES (301, 'Vinaya', 'HR', 50000);
INSERT INTO Employees VALUES (302, 'Kushal', 'HR', 52000);
INSERT INTO Employees VALUES (303, 'Vidya', 'IT', 60000);
INSERT INTO Employees VALUES (304, 'Shra', 'IT', 65000);
COMMIT;
CREATE TABLE Accounts (
  AccountID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  Balance NUMBER
);
INSERT INTO Accounts VALUES (401, 1, 5000);
INSERT INTO Accounts VALUES (402, 2, 3000);
INSERT INTO Accounts VALUES (403, 3, 7000);
COMMIT;

--Scenario:1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  UPDATE SavingsAccounts
  SET Balance = Balance + (Balance * 0.01);

  DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');

  COMMIT;
END;
/
EXEC ProcessMonthlyInterest;
SELECT * FROM SavingsAccounts;

--Scenario:2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_department IN VARCHAR2,
  p_bonus_pct IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_pct / 100)
  WHERE Department = p_department;

  DBMS_OUTPUT.PUT_LINE('Bonus applied to department: ' || p_department);

  COMMIT;
END;
/
EXEC UpdateEmployeeBonus('HR', 10);
SELECT * FROM Employees;

--Scenario:3
CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) AS
  v_balance NUMBER;
BEGIN

  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;
  IF v_balance >= p_amount THEN
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
    DBMS_OUTPUT.PUT_LINE('Transfer of ' || p_amount || ' done from Account ' ||p_from_account || ' to Account ' || p_to_account);
    COMMIT;
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient balance in Account ' || p_from_account);
  END IF;
END;
/
EXEC TransferFunds(401, 402, 1000);
SELECT * FROM Accounts;







