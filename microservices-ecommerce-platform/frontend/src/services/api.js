import axios from 'axios';

// Set the base URL for the API, which can be configured based on the environment
const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080';

// Inventory Service API calls
export const fetchInventory = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/inventory`);
        return response.data;
    } catch (error) {
        console.error('Error fetching inventory:', error);
        throw error;
    }
};

// User Service API calls
export const loginUser = async (username, password) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/login`, { username, password });
        return response.data;
    } catch (error) {
        console.error('Error logging in:', error);
        throw error;
    }
};

// Order Service API calls
export const placeOrder = async (orderData) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/orders`, orderData);
        return response.data;
    } catch (error) {
        console.error('Error placing order:', error);
        throw error;
    }
};

// Payment Service API calls
export const processPayment = async (paymentData) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/payments`, paymentData);
        return response.data;
    } catch (error) {
        console.error('Error processing payment:', error);
        throw error;
    }
};
