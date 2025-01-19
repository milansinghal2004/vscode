const express = require('express');
const multer = require('multer');
const path = require('path');

const app = express();
const port = process.env.PORT || 3000;

// Set storage engine for multer
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, 'uploads/'); // Specify folder to save files
  },
  filename: (req, file, cb) => {
    const uniqueName = Date.now() + path.extname(file.originalname);
    cb(null, uniqueName); // Create unique filename
  },
});

// File filter to allow only PDF files
const fileFilter = (req, file, cb) => {
  const fileTypes = /pdf/;
  const extname = fileTypes.test(path.extname(file.originalname).toLowerCase());
  const mimetype = fileTypes.test(file.mimetype);

  if (extname && mimetype) {
    cb(null, true);
  } else {
    cb(new Error('Only PDFs are allowed!'));
  }
};

// Initialize multer with storage and file filter
const upload = multer({
  storage: storage,
  fileFilter: fileFilter,
});

// Serve static files from "public" and "uploads" directories
app.use(express.static('public'));
app.use('/uploads', express.static('uploads'));

// Route to handle file upload
app.post('/upload', upload.single('file'), (req, res) => {
  if (!req.file) {
    return res.status(400).send({ message: 'No file uploaded or wrong file type.' });
  }
  res.send({
    message: 'File uploaded successfully!',
    filePath: `/uploads/${req.file.filename}` // Send file path to frontend
  });
});

// Start server
app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});
