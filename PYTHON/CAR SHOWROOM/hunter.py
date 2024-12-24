import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from PIL import Image, ImageTk
from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
import collada

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
        
        # Set up OpenGL rendering window
        glutInit()
        glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_DEPTH)
        glutInitWindowSize(800, 600)
        self.opengl_window = glutCreateWindow(b"3D Car Model Viewer")
        glutDisplayFunc(self.render_scene)
        self.init_gl()

        # Load the .dae model
        self.model = collada.Collada('model.dae')  # Replace with the actual .dae file path
        
        # Prepare the vertex and face data for rendering
        self.prepare_model()

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
        
        # Button to trigger OpenGL render window for 3D model display
        tk.Button(self.details_frame, text="Show 3D Model", command=self.show_3d_model).pack(pady=10)
        
        # Vehicle options
        tk.Label(self.details_frame, text="Select Fuel Type:").pack()
        fuel_var = tk.StringVar()
        fuel_dropdown = ttk.Combobox(self.details_frame, textvariable=fuel_var, values=["Petrol", "Diesel", "Hybrid", "Electric"])
        fuel_dropdown.pack(pady=5)
        
        tk.Label(self.details_frame, text="Select Color:").pack()
        color_var = tk.StringVar(value="Black")
        color_dropdown = ttk.Combobox(self.details_frame, textvariable=color_var, values=["Red", "Blue", "Black", "White"])
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
    
    def prepare_model(self):
        self.vertex_data = []
        self.face_data = []

        # Extract geometry from the loaded .dae model
        for geometry in self.model.geometries:
            for primitive in geometry.primitives:
                if isinstance(primitive, collada.triangleset.TriangleSet):
                    self.vertex_data.extend(primitive.vertex)
                    self.face_data.extend(primitive.vertex_index)

    def show_3d_model(self):
        glutMainLoop()  # Enter the OpenGL rendering loop

    def init_gl(self):
        glEnable(GL_DEPTH_TEST)
        glClearColor(0.0, 0.0, 0.0, 1.0)
        
    def draw_model(self):
        # Enable vertex arrays for rendering
        glEnableClientState(GL_VERTEX_ARRAY)
        
        # Pass the vertex data to OpenGL
        glVertexPointer(3, GL_FLOAT, 0, self.vertex_data)
        
        # Draw the triangles using the face indices
        glDrawElements(GL_TRIANGLES, len(self.face_data), GL_UNSIGNED_INT, self.face_data)
        
        # Disable the vertex array
        glDisableClientState(GL_VERTEX_ARRAY)

    def render_scene(self):
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

        # Set up transformations
        glPushMatrix()
        glTranslatef(0, 0, -5)  # Move the model
        glScalef(0.01, 0.01, 0.01)  # Scale down the model if necessary
        
        # Draw the 3D model
        self.draw_model()
        
        glPopMatrix()

        glutSwapBuffers()  # Swap buffers to display the rendered frame
    
    def show_price(self, model, fuel, color, engine, variant):
        # Sample price calculation
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
