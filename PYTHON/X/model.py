import streamlit as st
import pandas as pd
import random
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.ensemble import RandomForestClassifier
from sklearn.pipeline import Pipeline
from sklearn.compose import ColumnTransformer
from sklearn.metrics import accuracy_score

# Synonyms for data augmentation
synonyms = {
    'sort': ['arrange', 'order', 'organize'],
    'find': ['locate', 'search for', 'retrieve'],
    'search': ['look for', 'seek', 'find'],
}

def augment_data(data):
    """Augments the dataset with additional rows."""
    augmented_data = []
    for index, row in data.iterrows():
        augmented_data.append(row)
        if 'sort' in row['Use Case'].lower():
            new_row = row.copy()
            synonym = random.choice(synonyms['sort'])
            new_row['Use Case'] = new_row['Use Case'].replace('sort', synonym)
            augmented_data.append(new_row)

        new_row = row.copy()
        new_row['Scenario'] = f"Can you {row['Algorithm'].lower()} the following: {row['Scenario']}?"
        augmented_data.append(new_row)

        new_row = row.copy()
        new_row['Scenario'] = f"Please {row['Scenario']}."
        augmented_data.append(new_row)

        if row['Data Structure'] == 'Array':
            new_row = row.copy()
            new_row['Data Structure'] = random.choice(['Linked List', 'Stack', 'Queue'])
            augmented_data.append(new_row)

    return pd.DataFrame(augmented_data)

def train_model(dataset):
    """Trains the ML model."""
    features = dataset[['Problem Type', 'Data Structure', 'Use Case', 'Time Complexity']]
    target = dataset['Algorithm']
    X_train, X_test, y_train, y_test = train_test_split(features, target, test_size=0.2, random_state=42)

    text_preprocessor = TfidfVectorizer()
    preprocessor = ColumnTransformer(transformers=[
        ('problem_type', text_preprocessor, 'Problem Type'),
        ('data_structure', text_preprocessor, 'Data Structure'),
        ('use_case', text_preprocessor, 'Use Case'),
        ('time_complexity', text_preprocessor, 'Time Complexity'),
    ])

    model = Pipeline(steps=[
        ('preprocessor', preprocessor),
        ('classifier', RandomForestClassifier(random_state=42))
    ])

    model.fit(X_train, y_train)
    y_pred = model.predict(X_test)
    st.write(f"Model Accuracy: {accuracy_score(y_test, y_pred):.2f}")
    return model

# Streamlit app
st.title("ML-Based DSA Recommendation System")

# Step 1: Dataset processing
if st.button("Process Dataset"):
    dataset_path = st.file_uploader("Upload Dataset CSV", type="csv")
    if dataset_path:
        data = pd.read_csv(dataset_path, encoding='ISO-8859-1')
        augmented_data = augment_data(data)
        augmented_data.to_csv("Augmented_Dataset.csv", index=False)
        st.write("Dataset processed and saved as `Augmented_Dataset.csv`.")
    else:
        st.error("Please upload a dataset to process.")

# Step 2: Train model and predict
if st.button("Train and Predict"):
    try:
        dataset = pd.read_csv("Augmented_Dataset.csv", encoding='latin1')
        dataset.dropna(subset=['Problem Type', 'Data Structure', 'Use Case', 'Time Complexity', 'Algorithm'], inplace=True)
        model = train_model(dataset)

        # Get user input for prediction
        st.subheader("Enter Details for Prediction")
        problem_type = st.text_input("Problem Type (e.g., Sorting, Searching)")
        data_structure = st.text_input("Data Structure (e.g., Array, Linked List)")
        use_case = st.text_input("Use Case (e.g., Simple dataset sorting)")
        time_complexity = st.text_input("Time Complexity (e.g., O(n), O(n log n))")

        if st.button("Predict Algorithm"):
            if all([problem_type, data_structure, use_case, time_complexity]):
                user_data = pd.DataFrame({
                    'Problem Type': [problem_type],
                    'Data Structure': [data_structure],
                    'Use Case': [use_case],
                    'Time Complexity': [time_complexity]
                })
                prediction = model.predict(user_data)[0]
                st.write(f"### Predicted Algorithm: **{prediction}**")
            else:
                st.error("Please fill in all fields before predicting.")
    except FileNotFoundError:
        st.error("Augmented dataset not found. Please process the dataset first.")

