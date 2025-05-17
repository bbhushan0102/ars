# ars

Gradle task to create properties.language file from JSON

task convertJsonToProperties(type: Exec) {
    commandLine 'python', 'src/main/resources/scripts/json_to_properties.py'
}

