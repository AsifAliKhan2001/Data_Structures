CleverSIDC - Adaptive Student Tracking System
This project was completed as part of my COMP 352 (Data Structures & Algorithms) assignment in Winter 2024. The goal was to design an adaptive student tracking system that efficiently manages student records using dynamic data structures based on dataset size.

Overview
CleverSIDC intelligently selects the appropriate data structure:

Sorted Array for small datasets (≤1000 entries) to optimize memory usage.
Custom Hash Table for large datasets (≥1000 entries) to ensure fast lookups.
It supports essential CRUD operations (Create, Read, Update, Delete) with efficient time complexity:

Create (add(key, value)) – Inserts student records while maintaining sorted order in arrays or using quadratic probing in the hash table.
Read (getValue(key), allKeys()) – Retrieves values in O(1) using the hash table or via binary search in sorted arrays. allKeys() returns all student IDs in sorted order.
Update – Can be handled by removing and re-adding a record with a new value.
Delete (remove(key)) – Shifts elements left in an array or marks keys as defunct in the hash table for efficient lazy deletion.

Key Features
Dynamically switches between sorted arrays & hash tables based on dataset size.
Custom HashMap implementation with quadratic probing for collision handling.
Optimized retrieval using binary search (arrays) and constant-time lookup (hash table).
Scalability & efficiency tested with real-world student datasets.

This project was an exciting deep dive into data structures and algorithm optimization, balancing memory efficiency, runtime performance, and adaptive design. 
