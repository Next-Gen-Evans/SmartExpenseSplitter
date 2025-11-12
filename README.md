# 💸 Smart Expense Splitter

A **Java Swing desktop application** to easily **split expenses among friends** and keep accurate track of who owes what.  
The app also generates **QR codes** for quick and convenient payments.

---

## ✨ Features

- 🧑‍🤝‍🧑 **Add Friends** – Add friends to the shared expense list.  
- 💰 **Add Expenses** – Enter an amount, choose the payer, and automatically split costs evenly among all friends.  
- 📊 **Live Balances Table** – Instantly view each friend’s balance with clear color coding:  
  - 🟩 **Green** – Positive balance (money owed to them)  
  - 🟥 **Red** – Negative balance (they owe money)  
- 📱 **QR Code Payments** – Generate QR codes for easy settlements between friends.  
- 🧾 **Automatic Calculations** – Updates balances instantly after each transaction.  
- 🧠 **Data Validation** – Ensures valid inputs and prevents empty or duplicate entries.

---

## 🗂️ Project Structure

```yaml
SmartExpenseSplitter/
├─ src/
│  ├─ App.java       # Main class that launches the GUI
│  ├─ GUI.java       # Handles interface design, logic, and event actions
│  └─ Friend.java    # Data model for storing friend names and balances
└─ core-3.5.1.jar    # ZXing library for QR code generation
```

## ⚙️ Setup & Run

### 1️⃣ Download Dependency
Get the **ZXing Core JAR** file and place it in the project folder:  
👉 [core-3.5.1.jar](https://repo1.maven.org/maven2/com/google/zxing/core/3.5.1/core-3.5.1.jar)

---

### 2️⃣ Compile the Project
Open a terminal in the project directory and run:
```bash
javac -cp "src;core-3.5.1.jar" src\*.java

## 3️⃣ Run the Application
```bash
java -cp "src;core-3.5.1.jar" App
```
## 🏗️ Example Commands
# Compile
javac -cp "src;core-3.5.1.jar" src\*.java

# Run
java -cp "src;core-3.5.1.jar" App

## 🧪 Example Output
Friend Added: John  
Expense Added: Ksh 300 - Paid by Jane  
Balances Updated:  
  John: -150.00  
  Jane: +150.00  

## 🧱 Version
v1.0.0 – Initial stable release with friend management, expense splitting, and QR code generation.

## 🚀 Usage Guide
- Launch the app.
- Use the top panel to add friends.
- Use the middle panel to add expenses and select the payer.
- View automatically updated balances in the bottom table.
- Click the QR button next to a friend’s name to generate their payment QR code.

💡 Tip: Keep the app open during group activities or trips for instant updates and accountability.

## 🧭 Future Enhancements
💵 Add custom currency and number formatting options.
🕒 Maintain a history of expenses and settlements.
📤 Export data to CSV or PDF reports.
✏️ Allow editing/deleting friends and expenses.
☁️ Add database or file saving support to persist data between sessions.
🌐 Integrate mobile payment APIs (like M-Pesa or PayPal) for real transfers.
🎨 Introduce a dark/light theme toggle for modern UI aesthetics.
🔔 Add notification pop-ups when balances are updated or settled.
🧮 Include custom split ratios (not always 50/50).
📱 Future plan: Convert into a mobile app version using Kotlin or Flutter.

## 🧰 Technologies Used
🪟 Java Swing – For building the desktop graphical interface  
🔳 ZXing (Zebra Crossing) – For QR code generation  
🎨 Java AWT – For layout, event handling, and GUI rendering  
☕ JVM 17+ – Compatible with the latest Java versions  

## 🧑‍💻 Author
👤 Name: Evans Mutharimi Buongo  
🏫 University: Meru University of Science and Technology  
📧 Contact: [evansbuongo@gmail.com]  

## 🪄 License
This project is released under the MIT License.  
You’re free to use, modify, and distribute it with proper credit.  