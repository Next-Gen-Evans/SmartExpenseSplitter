# Smart Expense Splitter

A Java Swing application to **easily split expenses among friends** and keep track of balances. Each friend can see who owes what, and QR codes can be generated for quick payments.

---

## Features

- **Add Friend**: Quickly add friends to your expense list.  
- **Add Expense**: Enter an amount and select the payer; the app automatically splits the expense among all friends.  
- **Balances Table**: View each friend's balance with color coding:  
  - **Green** → positive balance (money owed to them)  
  - **Red** → negative balance (they owe money)  
- **QR Code Generation**: Generate a QR code for each friend to simplify payments.

---

## Project Structure
SmartExpenseSplitter/
├─ src/
│  ├─ App.java      # Main class launching the GUI
│  ├─ GUI.java      # Contains all GUI code, event handling, and QR generation
│  └─ Friend.java   # Friend class storing name and balance
└─ core-3.5.1.jar   # ZXing library for QR code generation

---

## Setup & Run

1. **Download ZXing Core Jar**:  
   [core-3.5.1.jar](https://repo1.maven.org/maven2/com/google/zxing/core/3.5.1/core-3.5.1.jar) and place it in the project folder.

2. **Compile the project**:

```bash
javac -cp "src;core-3.5.1.jar" src\*.java
```
## Run the application

```bash
java -cp "src;core-3.5.1.jar" App
```

## Usage

1. Open the application.
2. Add friends using the top panel.
3. Add expenses using the middle panel (enter amount and select payer).
4. View updated balances in the bottom table.
5. Click **QR** next to any friend to generate a payment QR code.

## Future Enhancements

- Allow custom currency and formatting.
- Add history of expenses.
- Export balances to CSV or PDF.
- Enable editing/deleting friends and expenses.

💡 Built with **Java Swing** for GUI and **ZXing** for QR code generation.


