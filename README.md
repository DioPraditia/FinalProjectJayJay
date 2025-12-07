# FinalProjectJayJay
Automation Test Framework — Web UI & API (Cucumber + Java + Gradle + Rest Assured + Selenium + GitHub Actions + Git and GitHub)

## 📌 Overview
Repository ini dibuat sebagai final project untuk membangun automation test framework yang mencakup:
- Testing Web UI
- Testing API
- Menggunakan Gherkin (Cucumber)
- Menghasilkan report otomatis (HTML & JSON)
- Berjalan otomatis melalui GitHub Actions setiap push & pull request

Struktur project mengikuti clean architecture:
- Folder dan package terpisah untuk Web & API
- Step definitions terpisah
- Feature files terpisah
- Test runner terpisah (API & Web)

---

## 📁 Project Structure
src
└── test
├── java
│ ├── com.dio
| | └── BaseTest
│ │── stepdef
| |└── api
| | └── ApiCrudSteps
| | └── HooksAPI
│ ├└── web
│ │ └── HomeStepDef
| | └── LoginStepDef
| | └── HooksWeb
| |
│ └── testRunners
│ ├── CucumberApiTest.java
│ └── CucumberWebTest.java
│
| |── JUnitTest
| | └── LoginTest
| |── pages
| |└── UserApiPage
| | └── web 
| | └── HomePage
| | └── LoginPage
└── resources
├── features
│ ├── api
│ └── apiCRUD.feature
| ├── web
| └── web.feature
├── build.gradle
└── README.md

