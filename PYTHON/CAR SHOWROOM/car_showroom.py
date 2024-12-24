import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from PIL import Image, ImageTk  # Import for handling images (Pillow library)

class CarShowroomApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Car Showroom Management System")
        self.root.geometry("800x600")  # Updated size for image display
        
        # Categories Frame
        self.category_frame = tk.Frame(self.root)
        self.category_frame.pack(pady=20)
        
        tk.Label(self.category_frame, text="Select Category", font=("Arial", 14)).pack()
        
        # Buttons for categories
        tk.Button(self.category_frame, text="Luxury Vehicles (Lexus)", command=self.show_luxury_vehicles).pack(pady=5)
        tk.Button(self.category_frame, text="Normal Vehicles (Toyota)", command=self.show_normal_vehicles).pack(pady=5)
        
        # Vehicle details frame (will update dynamically)
        self.details_frame = tk.Frame(self.root)
        self.details_frame.pack(pady=20)
        
        # For displaying the vehicle image
        self.image_label = tk.Label(self.root)
        self.image_label.pack(pady=10)
        
    def show_luxury_vehicles(self):
        self.clear_frame(self.details_frame)
        self.show_vehicles("Luxury Vehicles", ["Lexus ES", "Lexus RX", "Lexus NX"])
    
    def show_normal_vehicles(self):
        self.clear_frame(self.details_frame)
        self.show_vehicles("Normal Vehicles", ["Toyota Camry", "Toyota Corolla", "Toyota Yaris"])
        
    def show_vehicles(self, category, models):
        tk.Label(self.details_frame, text=f"{category} Models", font=("Arial", 12)).pack(pady=10)
        
        for model in models:
            tk.Button(self.details_frame, text=model, command=lambda m=model: self.show_model_details(m)).pack(pady=5)
    
    def show_model_details(self, model):
        self.clear_frame(self.details_frame)
        
        # Displaying Model Title
        tk.Label(self.details_frame, text=f"{model} Details", font=("Arial", 14)).pack(pady=10)
        
        # Load and display the image of the vehicle
        self.display_vehicle_image(model, "Black")  # Default color
        
        # Vehicle options
        tk.Label(self.details_frame, text="Select Fuel Type:").pack()
        fuel_var = tk.StringVar()
        fuel_dropdown = ttk.Combobox(self.details_frame, textvariable=fuel_var, values=["Petrol", "Diesel", "Hybrid", "Electric"])
        fuel_dropdown.pack(pady=5)
        
        tk.Label(self.details_frame, text="Select Color:").pack()
        color_var = tk.StringVar(value="Black")
        color_dropdown = ttk.Combobox(self.details_frame, textvariable=color_var, values=["Red", "Blue", "Black", "White"])
        color_dropdown.bind("<<ComboboxSelected>>", lambda event: self.display_vehicle_image(model, color_var.get()))
        color_dropdown.pack(pady=5)
        
        tk.Label(self.details_frame, text="Select Engine:").pack()
        engine_var = tk.StringVar()
        engine_dropdown = ttk.Combobox(self.details_frame, textvariable=engine_var, values=["1.5L", "2.0L", "3.0L"])
        engine_dropdown.pack(pady=5)
        
        tk.Label(self.details_frame, text="Select Variant:").pack()
        variant_var = tk.StringVar()
        variant_dropdown = ttk.Combobox(self.details_frame, textvariable=variant_var, values=["Base", "Mid", "Top"])
        variant_dropdown.pack(pady=5)
        
        # Calculate Price button
        tk.Button(self.details_frame, text="Calculate Price", 
                  command=lambda: self.show_price(model, fuel_var.get(), color_var.get(), engine_var.get(), variant_var.get())).pack(pady=10)
    
    def display_vehicle_image(self, model, color):
        # Map models and colors to their corresponding image filenames
        model_images = {
            "Lexus ES": {
                "Red": "CAR SHOWROOM\LEXUS_ES\lexus_es_red.png",
                "Blue": "CAR showroom\LEXUS_ES\lexus_es_blue.png",
                "Black": "CAR showroom\LEXUS_ES\lexus_es_black.png",
                "White": "CAR showroom\LEXUS_ES\lexus_es_white.png"
            },
            "Lexus RX": {
                "Red": "CAR SHOWROOM\LEXUS_RX\lexus_rx_red.png",
                "Blue": "CAR SHOWROOM\LEXUS_RX\lexus_rx_blue.png",
                "Black": "CAR SHOWROOM\LEXUS_RX\lexus_rx_black.png",
                "White": "CAR SHOWROOM\LEXUS_RX\lexus_rx_white.png"
            },
            "Lexus NX": {
                "Red": "CAR SHOWROOM\LEXUS_NX\lexus_nx_red.png",
                "Blue": "CAR SHOWROOM\LEXUS_NX\lexus_nx_blue.png",
                "Black": "CAR SHOWROOM\LEXUS_NX\lexus_nx_black.png",
                "White": "CAR SHOWROOM\LEXUS_NX\lexus_nx_white.png"
            },
            "Toyota Camry": {
                "Red": "CAR SHOWROOM/toyota_camry_red.png",
                "Blue": "CAR SHOWROOM/toyota_camry_blue.png",
                "Black": "CAR SHOWROOM/toyota_camry_black.png",
                "White": "CAR SHOWROOM/toyota_camry_white.png"
            },
            "Toyota Corolla": {
                "Red": "CAR SHOWROOM/toyota_corolla_red.png",
                "Blue": "CAR SHOWROOM/toyota_corolla_blue.png",
                "Black": "CAR SHOWROOM/toyota_corolla_black.png",
                "White": "CAR SHOWROOM/toyota_corolla_white.png"
            },
            "Toyota Yaris": {
                "Red": "CAR SHOWROOM/toyota_yaris_red.png",
                "Blue": "CAR SHOWROOM/toyota_yaris_blue.png",
                "Black": "CAR SHOWROOM/toyota_yaris_black.png",
                "White": "CAR SHOWROOM/toyota_yaris_white.png"
            }
        }
        
        # Check if the image exists for the selected model and color
        image_path = model_images.get(model, {}).get(color)
        
        if image_path:
            try:
                # Open and resize image
                img = Image.open(image_path)
                img = img.resize((300, 200))  # Resize image to fit in GUI
                photo = ImageTk.PhotoImage(img)
                
                # Update image in the label
                self.image_label.config(image=photo)
                self.image_label.image = photo  # Keep a reference to avoid garbage collection
                
            except Exception as e:
                messagebox.showerror("Image Error", f"Could not load image for {model} in {color} color: {e}")
    
    def show_price(self, model, fuel, color, engine, variant):
        # Sample price calculation (you can make it more dynamic)
        base_price = 50000 if "Lexus" in model else 30000
        final_price = base_price + (5000 if fuel == "Diesel" else 0) + (3000 if engine == "3.0L" else 0)
        
        # Availability date
        availability_date = "Available in 2 weeks" if "Lexus" in model else "Available in 1 week"
        
        # Display price and availability
        messagebox.showinfo("Price and Availability", f"Model: {model}\nPrice: {final_price} USD\nAvailability: {availability_date}")
    
    def clear_frame(self, frame):
        for widget in frame.winfo_children():
            widget.destroy()

# Initialize the application
root = tk.Tk()
app = CarShowroomApp(root)
root.mainloop()
