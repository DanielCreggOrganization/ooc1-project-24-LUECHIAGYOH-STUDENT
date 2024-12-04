# Headphone Manager

Headphone Manager is a simple Java application for managing a collection of headphones. It allows you to add, delete, search, sort, and manage the data. It also features loading and saving data from a file and configuration using YAML.

## Features
- Add, delete, and list headphones.
- Sort headphones by price.
- Set a maximum size for the headphone list.
- Save and load headphone data from a file.
- Uses a YAML configuration file to manage app settings.

## How to Run

1. Clone the repository: `git clone https://github.com/DanielCreggOrganization/ooc1-project-24-LUECHIAGYOH-STUDENT.git`
2. Navigate to the project folder: `cd headphone-manager`
3. Compile and run the Java application.
4. Edit `config.yaml` to set your preferred configuration (e.g., maximum number of headphones).

## Configuration

The configuration is stored in `config.yaml`:

```yaml
appName: HeadphoneManager
version: 1.2
maxHeadphones: 50
admin:
  name: Luechia
  email: G00416981@atu.ie