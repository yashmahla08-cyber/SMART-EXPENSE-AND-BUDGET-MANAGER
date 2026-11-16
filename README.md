# Smart Expense and Budget Manager 💰📊

A modern, desktop-first personal finance management application built with **Java 17**, **Java Swing (FlatLaf Dark Navy & Purple Theme)**, **MySQL 8.0**, **JDBC PreparedStatement**, and **JFreeChart**. Architected using a strict **MVC (Model-View-Controller)** pattern with enterprise-grade security and automated unit/integration testing.

---

## 🌟 Modules & Core Capabilities

### 1. 🔐 Module 1: User Authentication & Security
- **Modern Login & Registration UI**: Sleek dual-tab authentication frame with real-time field validation.
- **BCrypt Password Hashing**: Utilizes `jBCrypt` with high salt work factor, zero plaintext password persistence.
- **Form Sanitization**: Regex validation for username, email format, and password complexity.
- **Session Management**: Thread-safe active user state and secure sign-out.

### 2. 📊 Module 2: Financial Dashboard
- **Real-Time KPI Cards**: Total Balance, Total Income, Total Expenses, and Net Savings with custom status colors.
- **Live Header**: Personalized greeting and live calendar date display.
- **Recent Transactions Ledger**: Displays the 5 latest transactions across income and expenses.
- **Instant Cross-Panel Sync**: Automatically refreshes figures whenever transactions or budgets change.

### 3. 💵 Module 3: Income Management
- **Inflow Tracking**: Record income transactions across predefined categories (`Salary`, `Freelance`, `Business`, `Investment`, `Gift`, `Rental`, `Others`).
- **Interactive Modals**: Modern dialogs for adding, editing, and deleting income entries.
- **Date & Amount Validation**: Strict positive value checks and `LocalDate` calendar validation.
- **Data Grid**: Alternating dark rows, formatted dates, and emerald-highlighted currency.

### 4. 💳 Module 4: Expense Management
- **Outflow Categorization**: Comprehensive tracking across (`Food`, `Shopping`, `Travel`, `Education`, `Bills`, `Entertainment`, `Others`).
- **Full CRUD Support**: Add, modify, or remove expense records with instant database persistence.
- **Real-Time Balance Recalculation**: Deducts expenses from total balance immediately across all views.

### 5. 🎯 Module 5: Budget Planning & Warning Alerts
- **Monthly Spending Caps**: Define customizable monthly limits for each expense category.
- **Automated Expense Tracking**: Aggregates month-to-date spending directly from transactions using subqueries.
- **Visual Progress Indicators**: Modern two-tone progress bars reflecting budget utilization percentage.
- **Smart Warning States**:
  - 🟢 **On Track** (`< 80%` spent): Emerald status badge.
  - 🟡 **Warning** (`80% - 100%` spent): Amber warning alert.
  - 🔴 **Exceeded** (`> 100%` spent): Crimson danger badge indicating overspending.
- **Budget KPI Cards**: Total Budgeted, Total Spent, Remaining Buffer, and Active Alert count.

### 6. 📈 Module 6: Analytics & Graphical Reports (JFreeChart)
- **Category-Wise Expense Pie Chart**:
  - Interactive JFreeChart rendered with customized dark navy & purple palette.
  - Percentage and currency labels for each spending category.
- **12-Month Income vs. Expense Bar Chart**:
  - Side-by-side comparison of inflows (Emerald) and outflows (Rose) for all 12 months.
  - StandardBarPainter flat styling with formatted currency axes.
- **Period Filter Engine**: Switch between specific months or view the full calendar year.
- **Automated Financial Health Insights**: AI-like contextual feedback evaluating savings rate and identifying largest spending drivers.

### 7. 📜 Module 7: Transaction History, Multi-Filter & CSV Export
- **Unified Master Ledger**: View all historical income and expense transactions in a single responsive table.
- **Multi-Dimensional Filters**:
  - **Search Keyword**: Substring search across transaction notes and category names.
  - **Type Filter**: All Types, Income Only, Expense Only.
  - **Category Dropdown**: Filter by any specific category.
  - **Date Range**: Filter between custom start (`YYYY-MM-DD`) and end (`YYYY-MM-DD`) dates.
  - **Sorting**: Newest date, oldest date, highest amount, lowest amount.
- **Live Summary Strip**: Instant calculation of filtered record count, total inflow, total outflow, and net cashflow.
- **CSV Ledger Export**: Export filtered transactions into standard RFC-4180 compliant CSV files with full escaping using `JFileChooser`.

---

## 🛠️ Technology Stack

| Component | Technology | Version |
| :--- | :--- | :--- |
| **Runtime / SDK** | OpenJDK 17 LTS | `17.0.10` |
| **Desktop GUI** | Java Swing + FlatLaf Dark Theme | `3.4.1` |
| **Database** | MySQL Server | `8.0+` |
| **Persistence** | JDBC (PreparedStatements) | `8.3.0` |
| **Data Visualization** | JFreeChart | `1.5.4` |
| **Password Security** | jBCrypt | `0.4` |
| **Build System** | Apache Maven | `3.9.6` |
| **Unit Testing** | JUnit 5 Jupiter | `5.10.2` |

---

## 📁 Project Architecture & Package Structure

```text
smart-expense-manager/
├── database/
│   └── schema.sql                        # Database schema definition
├── src/
│   ├── main/
│   │   ├── java/com/smartexpense/
│   │   │   ├── Main.java                 # Main entry point
│   │   │   ├── controller/               # Event handlers and navigation
│   │   │   │   └── AuthController.java
│   │   │   ├── dao/                      # Data Access Objects (JDBC PreparedStatement)
│   │   │   │   ├── DatabaseInitializer.java
│   │   │   │   ├── UserDAO.java
│   │   │   │   ├── TransactionDAO.java
│   │   │   │   ├── BudgetDAO.java
│   │   │   │   └── AnalyticsDAO.java
│   │   │   ├── model/                    # Domain models & entities
│   │   │   │   ├── User.java
│   │   │   │   ├── Transaction.java
│   │   │   │   ├── TransactionType.java
│   │   │   │   ├── Category.java
│   │   │   │   ├── Budget.java
│   │   │   │   ├── BudgetStatus.java
│   │   │   │   ├── DashboardSummary.java
│   │   │   │   ├── CategoryExpense.java
│   │   │   │   ├── MonthlyComparison.java
│   │   │   │   ├── AnalyticsData.java
│   │   │   │   └── TransactionFilterCriteria.java
│   │   │   ├── service/                  # Business logic and validation
│   │   │   │   ├── ServiceResult.java
│   │   │   │   ├── UserService.java
│   │   │   │   ├── TransactionService.java
│   │   │   │   ├── BudgetService.java
│   │   │   │   └── AnalyticsService.java
│   │   │   ├── util/                     # Security, DB, date and export utilities
│   │   │   │   ├── DatabaseConnection.java
│   │   │   │   ├── PasswordUtil.java
│   │   │   │   ├── CurrencyUtil.java
│   │   │   │   ├── DateUtil.java
│   │   │   │   └── CsvExportUtil.java
│   │   │   └── view/                     # Swing UI views, panels, and custom components
│   │   │       ├── MainFrame.java
│   │   │       ├── auth/AuthFrame.java
│   │   │       ├── dashboard/DashboardPanel.java
│   │   │       ├── income/IncomePanel.java
│   │   │       ├── expense/ExpensePanel.java
│   │   │       ├── budget/BudgetPanel.java
│   │   │       ├── analytics/AnalyticsPanel.java
│   │   │       ├── history/TransactionHistoryPanel.java
│   │   │       ├── dialogs/
│   │   │       │   ├── IncomeDialog.java
│   │   │       │   ├── ExpenseDialog.java
│   │   │       │   └── BudgetDialog.java
│   │   │       ├── components/
│   │   │       │   ├── ModernButton.java
│   │   │       │   ├── ModernTextField.java
│   │   │       │   ├── ModernPasswordField.java
│   │   │       │   ├── ModernProgressBar.java
│   │   │       │   ├── ModernTable.java
│   │   │       │   ├── RoundedPanel.java
│   │   │       │   └── StatCard.java
│   │   │       └── theme/UITheme.java
│   │   └── resources/
│   │       └── db.properties             # Database credentials
│   └── test/java/com/smartexpense/       # 39 Automated Unit & Integration Tests
│       ├── AppTest.java
│       ├── AuthFrameGuiTest.java
│       ├── PasswordUtilTest.java
│       ├── UserServiceValidationTest.java
│       ├── CurrencyAndDateUtilTest.java
│       ├── DatabaseConnectivityIntegrationTest.java
│       ├── IncomeAndDashboardIntegrationTest.java
│       ├── ExpenseIntegrationTest.java
│       ├── BudgetIntegrationTest.java
│       ├── AnalyticsIntegrationTest.java
│       ├── TransactionHistoryAndExportIntegrationTest.java
│       └── TransactionServiceTest.java
├── pom.xml                               # Maven project configuration
└── README.md                             # Project manual
```

---

## 🚀 Running the Application

### 1. Build and Run via Maven
```bash
# Compile and run test suite (39 automated tests)
mvn test

# Package standalone executable JAR
mvn clean package -DskipTests=true

# Launch the desktop application
java -jar target/smart-expense-manager-1.0.0-jar-with-dependencies.jar
```

### 2. Database Auto-Provisioning
On startup, `DatabaseInitializer` automatically validates and initializes the schema, creating the `users`, `transactions`, and `budgets` tables if they do not exist.
Default connection properties in `src/main/resources/db.properties`:
```properties
db.url=jdbc:mysql://localhost:3306/smart_expense_manager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8
db.username=expense_app
db.password=Change_This_To_Your_Strong_Password
```

---

## 🧪 Testing & Verification

The project includes **39 automated tests** covering unit validations, database transactions, calculations, and GUI construction:
- **Authentication**: Password hashing, salt randomness, regex checks, login validation.
- **Income & Expense Operations**: Full CRUD lifecycle, balance recalculation.
- **Budgeting Engine**: Category spending aggregation, threshold warning states (`80%` and `>100%`).
- **Analytics Aggregations**: Monthly totals, savings rate computations, 12-month trend arrays.
- **Ledger & Export**: Multi-criteria filtering (keyword, type, category, date range, sorting) and CSV RFC-4180 export integrity.
