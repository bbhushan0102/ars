import json

# Load JSON file
json_file = "src/main/resources/static/data/localise-questions.json"

with open(json_file, "r", encoding="utf-8") as f:
    data = json.load(f)

# Create properties files for English & Welsh
with open("src/main/resources/messages_en.properties", "w", encoding="utf-8") as en_file, \
     open("src/main/resources/messages_cy.properties", "w", encoding="utf-8") as cy_file:

    for item in data:
        question_id = item["id"]

        for key, value in item.items():
            if isinstance(value, dict):  # Process only fields with language translations
                en_file.write(f"{question_id}.{key}={value.get('en', '')}\n")
                cy_file.write(f"{question_id}.{key}={value.get('cy', '')}\n")
